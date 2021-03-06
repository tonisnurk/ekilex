package eki.ekilex.runner;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.postgresql.jdbc.PgArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eki.common.constant.Complexity;
import eki.common.constant.DbConstant;
import eki.common.data.Count;
import eki.ekilex.data.transform.Freeform;
import eki.ekilex.data.util.FreeformRowMapper;

@Component
public class WordMergerRunner extends AbstractLoaderRunner implements DbConstant {

	private static Logger logger = LoggerFactory.getLogger(WordMergerRunner.class);

	private static final int DEFAULT_LEXEME_LEVEL = 1;

	private static final int DEFAULT_HOMONYM_NUMBER = 1;

	private static final String SQL_SELECT_WORD_JOIN_CANDIDATES_VALUE_AND_WORD_IDS = "sql/select_word_join_candidates_value_and_word_ids.sql";

	private static final String SQL_SELECT_WORD_HOMONYMS_WORD_IDS = "sql/select_word_homonyms_word_ids.sql";

	private static final String SQL_SELECT_WORD_FREEFORMS = "sql/select_word_freeforms.sql";

	private static final String SQL_UPDATE_WORD_FREEFORMS_WHERE_FREEFORM_ID_IN_LIST = "sql/update_word_freeforms_where_freeform_id_in_list.sql";

	private String sqlSelectWordJoinCandidatesValueAndWordIds;

	private String sqlSelectWordHomonymsWordIds;

	private String sqlSelectWordFreeforms;

	private String sqlUpdateWordFreeformsWhereFreeformIdInList;

	private String sqlSelectWordLexemesMaxFirstLevel = "select max(lex.level1) from " + LEXEME + " lex where lex.word_id = :wordId";

	private String sqlDeleteLexemeFreeforms =
			"delete from " + FREEFORM + " ff where ff.id in(select lff.freeform_id from " + LEXEME_FREEFORM + " lff where lff.lexeme_id = :lexemeId)";

	private String sqlDeleteWordFreeforms =
			"delete from " + FREEFORM + " ff where ff.id in(select wff.freeform_id from " + WORD_FREEFORM + " wff where wff.word_id = :wordId)";

	private List<String> excludedWordTypeCodes;

	@Override
	public String getDataset() {
		return "wordmerge";
	}

	@Override
	public Complexity getLexemeComplexity() {
		return null;
	}

	@Override
	public Complexity getDefinitionComplexity() {
		return null;
	}

	@Override
	public Complexity getFreeformComplexity() {
		return null;
	}

	@Override
	public void deleteDatasetData() {
	}

	@Override
	public void initialise() throws Exception {

		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceFileInputStream;

		resourceFileInputStream = classLoader.getResourceAsStream(SQL_SELECT_WORD_JOIN_CANDIDATES_VALUE_AND_WORD_IDS);
		sqlSelectWordJoinCandidatesValueAndWordIds = getContent(resourceFileInputStream);

		resourceFileInputStream = classLoader.getResourceAsStream(SQL_SELECT_WORD_HOMONYMS_WORD_IDS);
		sqlSelectWordHomonymsWordIds = getContent(resourceFileInputStream);

		resourceFileInputStream = classLoader.getResourceAsStream(SQL_SELECT_WORD_FREEFORMS);
		sqlSelectWordFreeforms = getContent(resourceFileInputStream);

		resourceFileInputStream = classLoader.getResourceAsStream(SQL_UPDATE_WORD_FREEFORMS_WHERE_FREEFORM_ID_IN_LIST);
		sqlUpdateWordFreeformsWhereFreeformIdInList = getContent(resourceFileInputStream);

		excludedWordTypeCodes = new ArrayList<>();
		excludedWordTypeCodes.add(WORD_TYPE_CODE_PREFIXOID);
		excludedWordTypeCodes.add(WORD_TYPE_CODE_SUFFIXOID);
		excludedWordTypeCodes.add(WORD_TYPE_CODE_ABBREVIATION);
	}

	@Transactional
	public void execute(String mergedLexDatasetCode, boolean doReports) throws Exception {

		this.doReports = doReports;
		start();

		Map<String, List<Long>> joinCandidates = getJoinCandidates(mergedLexDatasetCode);

		int wordCount = joinCandidates.values().stream()
				.mapToInt(List::size)
				.sum();
		int valueCount = joinCandidates.size();
		logger.debug("Merging {} candidate words with {} different word values", wordCount, valueCount);

		Count candidateMergedWithSuperHomonymCount = new Count();
		Count candidateMergedWithAnotherCandidateCount = new Count();
		Count candidateNotMergedCount = new Count();

		long wordValueCounter = 0;
		long progressIndicator = valueCount / Math.min(valueCount, 100);

		for (Map.Entry<String, List<Long>> joinCandidate : joinCandidates.entrySet()) {
			String wordValue = joinCandidate.getKey();
			List<Long> candidateWordIds = joinCandidate.getValue();

			List<Long> joinableHomonyms = getJoinableHomonyms(mergedLexDatasetCode, wordValue);
			if (joinableHomonyms.isEmpty()) {
				int candidateCount = candidateWordIds.size();
				boolean multipleCandidates = candidateCount > 1;
				if (multipleCandidates) {
					Long targetWordId = candidateWordIds.get(0);
					for (Long sourceWordId : candidateWordIds.subList(1, candidateCount)) {
						joinWords(targetWordId, sourceWordId);
						candidateMergedWithAnotherCandidateCount.increment();
					}
					candidateMergedWithAnotherCandidateCount.increment();
				} else {
					candidateNotMergedCount.increment();
				}
			} else if (joinableHomonyms.size() == 1) {
				Long targetWordId = joinableHomonyms.get(0);
				for (Long sourceWordId : candidateWordIds) {
					joinWords(targetWordId, sourceWordId);
					candidateMergedWithSuperHomonymCount.increment();
				}
			} else {
				candidateNotMergedCount.increment();
			}

			wordValueCounter++;
			if (wordValueCounter % progressIndicator == 0) {
				long progressPercent = wordValueCounter / progressIndicator;
				logger.debug("{}% - {} word values iterated", progressPercent, wordValueCounter);
			}
		}

		logger.debug("{} candidate words merged with {} dataset", candidateMergedWithSuperHomonymCount.getValue(), mergedLexDatasetCode);
		logger.debug("{} candidate words merged with another candidate", candidateMergedWithAnotherCandidateCount.getValue());
		logger.debug("{} candidate words not merged", candidateNotMergedCount.getValue());

		end();
	}

	private Map<String, List<Long>> getJoinCandidates(String mergedLexDatasetCode) throws SQLException {

		Map<String, List<Long>> joinCandidates = new HashMap<>();
		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("lang", LANGUAGE_CODE_EST);
		tableRowParamMap.put("datasetType", DATASET_TYPE_TERM);
		tableRowParamMap.put("includedDatasetCode", ETYMOLOGY_OWNER_DATASET_CODE);
		tableRowParamMap.put("excludedDatasetCode", mergedLexDatasetCode);
		tableRowParamMap.put("excludedWordTypeCodes", excludedWordTypeCodes);
		List<Map<String, Object>> valueAndWordIds = basicDbService.queryList(sqlSelectWordJoinCandidatesValueAndWordIds, tableRowParamMap);

		for (Map<String, Object> row : valueAndWordIds) {
			String value = (String) row.get("value");
			PgArray wordIdsArr = (PgArray) row.get("word_ids");
			Long[] wordIdsArray = (Long[]) wordIdsArr.getArray();
			List<Long> wordIdsList = Arrays.asList(wordIdsArray);
			joinCandidates.put(value, wordIdsList);
		}
		return joinCandidates;
	}

	private List<Long> getJoinableHomonyms(String mergedLexDatasetCode, String wordValue) {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("wordValue", wordValue);
		tableRowParamMap.put("lang", LANGUAGE_CODE_EST);
		tableRowParamMap.put("datasetCode", mergedLexDatasetCode);
		tableRowParamMap.put("excludedWordTypeCodes", excludedWordTypeCodes);
		List<Long> wordIds = basicDbService.queryList(sqlSelectWordHomonymsWordIds, tableRowParamMap, Long.class);
		return wordIds;
	}

	private void joinWords(Long targetWordId, Long sourceWordId) throws Exception {

		joinWordData(targetWordId, sourceWordId);
		joinLexemeData(targetWordId, sourceWordId);
		basicDbService.delete(WORD, sourceWordId);
	}

	private void joinWordData(Long targetWordId, Long sourceWordId) throws Exception {

		joinWordFreeforms(targetWordId, sourceWordId);

		Map<String, Object> criteriaParamMap;
		Map<String, Object> valueParamMap;
		List<String> notExistsFields;

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word1_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word1_id", targetWordId);
		notExistsFields = new ArrayList<>();
		notExistsFields.add("word_rel_type_code");
		basicDbService.updateIfNotExists(WORD_RELATION, criteriaParamMap, valueParamMap, notExistsFields);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word2_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word2_id", targetWordId);
		notExistsFields = new ArrayList<>();
		notExistsFields.add("word_rel_type_code");
		basicDbService.updateIfNotExists(WORD_RELATION, criteriaParamMap, valueParamMap, notExistsFields);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word_id", targetWordId);
		notExistsFields = new ArrayList<>();
		notExistsFields.add("word_type_code");
		basicDbService.updateIfNotExists(WORD_WORD_TYPE, criteriaParamMap, valueParamMap, notExistsFields);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word_id", targetWordId);
		notExistsFields = new ArrayList<>();
		notExistsFields.add("word_group_id");
		basicDbService.updateIfNotExists(WORD_GROUP_MEMBER, criteriaParamMap, valueParamMap, notExistsFields);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word_id", targetWordId);
		basicDbService.update(WORD_ETYMOLOGY, criteriaParamMap, valueParamMap);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("related_word_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("related_word_id", targetWordId);
		notExistsFields = new ArrayList<>();
		notExistsFields.add("word_etym_id");
		basicDbService.updateIfNotExists(WORD_ETYMOLOGY_RELATION, criteriaParamMap, valueParamMap, notExistsFields);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word_id", targetWordId);
		basicDbService.update(WORD_PROCESS_LOG, criteriaParamMap, valueParamMap);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("word_id", sourceWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("word_id", targetWordId);
		basicDbService.update(WORD_LIFECYCLE_LOG, criteriaParamMap, valueParamMap);

		criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("id", targetWordId);
		valueParamMap = new HashMap<>();
		valueParamMap.put("homonym_nr", DEFAULT_HOMONYM_NUMBER);
		basicDbService.update(WORD, criteriaParamMap, valueParamMap);
	}

	private void joinWordFreeforms(Long targetWordId, Long sourceWordId) throws Exception {

		FreeformRowMapper freeformRowMapper = new FreeformRowMapper();
		Map<String, Object> paramMap;

		paramMap = new HashMap<>();
		paramMap.put("wordId", targetWordId);
		List<Freeform> wordFreeforms = basicDbService.getResults(sqlSelectWordFreeforms, paramMap, freeformRowMapper);

		paramMap = new HashMap<>();
		paramMap.put("wordId", sourceWordId);
		List<Freeform> sourceWordFreeforms = basicDbService.getResults(sqlSelectWordFreeforms, paramMap, freeformRowMapper);

		List<Long> nonDublicateFreeformIds = getNonDuplicateFreeformIds(wordFreeforms, sourceWordFreeforms);

		if (!nonDublicateFreeformIds.isEmpty()) {
			paramMap = new HashMap<>();
			paramMap.put("wordId", targetWordId);
			paramMap.put("sourceWordId", sourceWordId);
			paramMap.put("nonDublicateFreeformIds", nonDublicateFreeformIds);
			basicDbService.executeScript(sqlUpdateWordFreeformsWhereFreeformIdInList, paramMap);
		}

		paramMap = new HashMap<>();
		paramMap.put("wordId", sourceWordId);
		basicDbService.executeScript(sqlDeleteWordFreeforms, paramMap);
	}

	private List<Long> getNonDuplicateFreeformIds(List<Freeform> targetFreeforms, List<Freeform> sourceFreeforms) {

		return sourceFreeforms.stream()
				.filter(sf -> targetFreeforms.stream()
						.noneMatch(
								tf -> tf.getType().equals(sf.getType()) &&
								((Objects.nonNull(tf.getValueText()) && tf.getValueText().equals(sf.getValueText())) ||
								(Objects.nonNull(tf.getValueNumber()) && tf.getValueNumber().equals(sf.getValueNumber())) ||
								(Objects.nonNull(tf.getClassifCode()) && tf.getClassifCode().equals(sf.getClassifCode())) ||
								(Objects.nonNull(tf.getValueDate()) && tf.getValueDate().equals(sf.getValueDate())))))
				.map(Freeform::getFreeformId)
				.collect(Collectors.toList());
	}

	private void joinLexemeData(Long targetWordId, Long sourceWordId) throws Exception {

		Map<String, Object> paramMap;

		paramMap = new HashMap<>();
		paramMap.put("word_id", sourceWordId);
		List<Map<String, Object>> sourceWordLexemes = basicDbService.selectAll(LEXEME, paramMap);
		for (Map<String, Object> sourceWordLexeme : sourceWordLexemes) {
			Long sourceWordLexemeId = (Long) sourceWordLexeme.get("id");
			Long sourceWordLexemeMeaningId = (Long) sourceWordLexeme.get("meaning_id");
			String sourceWordLexemeDatasetCode = (String) sourceWordLexeme.get("dataset_code");

			paramMap = new HashMap<>();
			paramMap.put("word_id", targetWordId);
			paramMap.put("meaning_id", sourceWordLexemeMeaningId);
			paramMap.put("dataset_code", sourceWordLexemeDatasetCode);
			Map<String, Object> targetWordLexeme = basicDbService.select(LEXEME, paramMap);
			boolean lexemeExists = targetWordLexeme != null;

			if (lexemeExists) {
				deleteLexeme(sourceWordLexemeId);
			} else {
				paramMap = new HashMap<>();
				paramMap.put("wordId", targetWordId);
				Map<String, Object> maxLevelMap = basicDbService.queryForMap(sqlSelectWordLexemesMaxFirstLevel, paramMap);
				Integer currentMaxLevel = (Integer) maxLevelMap.get("max");
				int level1 = currentMaxLevel + 1;
				updateLexemeWordIdAndLevels(sourceWordLexemeId, targetWordId, level1, DEFAULT_LEXEME_LEVEL);
			}
		}
	}

	private void updateLexemeWordIdAndLevels(Long lexemeId, Long wordId, int level1, int level2) throws Exception {

		Map<String, Object> criteriaParamMap = new HashMap<>();
		criteriaParamMap.put("id", lexemeId);

		Map<String, Object> valueParamMap = new HashMap<>();
		valueParamMap.put("word_id", wordId);
		valueParamMap.put("level1", level1);
		valueParamMap.put("level2", level2);

		basicDbService.update(LEXEME, criteriaParamMap, valueParamMap);
	}

	private void deleteLexeme(Long lexemeId) {

		deleteLexemeFreeforms(lexemeId);
		basicDbService.delete(LEXEME, lexemeId);
	}

	private void deleteLexemeFreeforms(Long lexemeId) {

		Map<String, Object> params = new HashMap<>();
		params.put("lexemeId", lexemeId);
		basicDbService.executeScript(sqlDeleteLexemeFreeforms, params);
	}

}
