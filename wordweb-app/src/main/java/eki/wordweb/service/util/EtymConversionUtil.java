package eki.wordweb.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.common.data.Classifier;
import eki.wordweb.data.TypeWordEtymRelation;
import eki.wordweb.data.Word;
import eki.wordweb.data.WordEtymTuple;
import eki.wordweb.data.WordEtymology;

@Component
public class EtymConversionUtil {

	@Autowired
	private ClassifierUtil classifierUtil;

	public void composeWordEtymology(Word word, List<WordEtymTuple> wordEtymTuples, String displayLang) {

		if (CollectionUtils.isEmpty(wordEtymTuples)) {
			return;
		}
		wordEtymTuples.forEach(tuple -> {
			classifierUtil.applyClassifiers(tuple, displayLang);
		});

		Long headwordId = word.getWordId();

		Map<Long, List<WordEtymTuple>> etymAltsMap = wordEtymTuples.stream().collect(Collectors.groupingBy(WordEtymTuple::getWordEtymWordId));

		WordEtymTuple headwordEtymTuple = etymAltsMap.get(headwordId).get(0);
		WordEtymology wordEtymology = composeHeadwordEtym(headwordEtymTuple);
		word.setWordEtymology(wordEtymology);

		List<String> etymLevelsWrapup = new ArrayList<>();
		wordEtymology.setEtymLevelsWrapup(etymLevelsWrapup);
		composeEtymLevelsWrapup(etymLevelsWrapup, headwordId, headwordId, etymAltsMap);
	}

	private WordEtymology composeHeadwordEtym(WordEtymTuple headwordEtymTuple) {

		WordEtymology wordEtymology = new WordEtymology();
		StringBuilder headwordEtymBuf = new StringBuilder();
		if (headwordEtymTuple.isWordEtymIsQuestionable()) {
			headwordEtymBuf.append(" ? ");
		}
		if (headwordEtymTuple.getEtymologyType() != null) {
			headwordEtymBuf.append("<font style='font-variant: small-caps'>");
			headwordEtymBuf.append(headwordEtymTuple.getEtymologyType().getValue());
			headwordEtymBuf.append("</font>");
		}
		List<String> wordEtymSources = headwordEtymTuple.getWordEtymSources();
		if (CollectionUtils.isNotEmpty(wordEtymSources)) {
			if (headwordEtymBuf.length() > 0) {
				headwordEtymBuf.append(", ");
			}
			headwordEtymBuf.append(StringUtils.join(wordEtymSources, ", "));
		}
		String etymologyYear = headwordEtymTuple.getEtymologyYear();
		if (StringUtils.isNotEmpty(etymologyYear)) {
			if (headwordEtymBuf.length() > 0) {
				headwordEtymBuf.append(", ");
			}
			headwordEtymBuf.append(etymologyYear);
		}
		if (headwordEtymBuf.length() > 0) {
			String headwordEtymWrapup = headwordEtymBuf.toString().trim();
			wordEtymology.setEtymWrapup(headwordEtymWrapup);
		}
		wordEtymology.setComment(headwordEtymTuple.getWordEtymComment());
		return wordEtymology;
	}

	private void composeEtymLevelsWrapup(List<String> etymLevelsWrapup, Long headwordId, Long wordId, Map<Long, List<WordEtymTuple>> etymAltsMap) {

		if (wordId == null) {
			return;
		}
		List<WordEtymTuple> wordEtymAlts = etymAltsMap.get(wordId);
		List<String> wordEtymAltsContent = new ArrayList<>();
		List<Long> etymLevelWordIds = new ArrayList<>();
		for (WordEtymTuple wordEtymAlt : wordEtymAlts) {
			List<TypeWordEtymRelation> wordEtymRelations = wordEtymAlt.getWordEtymRelations();
			String etymLevelWrapup = composeEtymLevelWrapup(wordEtymRelations, etymAltsMap);
			if (StringUtils.isNotBlank(etymLevelWrapup)) {
				if (!headwordId.equals(wordId) && wordEtymAlt.isWordEtymIsQuestionable()) {
					etymLevelWrapup = " ? " + etymLevelWrapup;
				}
				wordEtymAltsContent.add(etymLevelWrapup);
			}
			List<Long> relatedWordIds = wordEtymRelations.stream()
					.filter(rel -> rel.getRelatedWordId() != null)
					.map(TypeWordEtymRelation::getRelatedWordId).collect(Collectors.toList());
			etymLevelWordIds.addAll(relatedWordIds);
		}
		String etymLevelWrapupJoin = StringUtils.join(wordEtymAltsContent, " v ");
		if (StringUtils.isNotBlank(etymLevelWrapupJoin) && !etymLevelsWrapup.contains(etymLevelWrapupJoin)) {
			etymLevelsWrapup.add(etymLevelWrapupJoin);
		}
		for (Long etymLevelWordId : etymLevelWordIds) {
			composeEtymLevelsWrapup(etymLevelsWrapup, headwordId, etymLevelWordId, etymAltsMap);
		}
	}

	private String composeEtymLevelWrapup(List<TypeWordEtymRelation> wordEtymRelations, Map<Long, List<WordEtymTuple>> etymAltsMap) {

		StringBuilder etymLevelBuf = new StringBuilder();
		int etymLevelMemberIndex = 0;
		int etymLevelSize = wordEtymRelations.size();
		String recentEtymWordLang = null;
		for (TypeWordEtymRelation wordEtymRel : wordEtymRelations) {
			if (wordEtymRel.getRelatedWordId() == null) {
				break;
			}
			Long relatedWordId = wordEtymRel.getRelatedWordId();
			String comment = wordEtymRel.getComment();
			boolean isQuestionable = wordEtymRel.isQuestionable();
			boolean isCompound = wordEtymRel.isCompound();
			if (isCompound) {
				etymLevelBuf.append(" + ");
			} else if (etymLevelMemberIndex > 0) {
				etymLevelBuf.append(", ");
			}
			if (isQuestionable) {
				etymLevelBuf.append(" ? ");
			}
			List<WordEtymTuple> relatedWordTuples = etymAltsMap.get(relatedWordId);
			WordEtymTuple etymLevelMember = relatedWordTuples.get(0);

			String etymWord = etymLevelMember.getWordEtymWord();
			String etymWordLang = etymLevelMember.getWordEtymWordLang();
			Classifier etymWordLanguage = etymLevelMember.getWordEtymWordLanguage();
			List<String> etymWordMeaningWords = etymLevelMember.getWordEtymWordMeaningWords();
			List<String> etymWordSources = etymLevelMember.getWordEtymSources();
			if (etymWordLanguage != null) {
				if (etymLevelMemberIndex == 0) {
					etymLevelBuf.append(etymWordLanguage.getValue());
					etymLevelBuf.append(" ");
				} else if (!StringUtils.equals(recentEtymWordLang, etymWordLang)) {
					etymLevelBuf.append(etymWordLanguage.getValue());
					etymLevelBuf.append(" ");
				}
			}
			etymLevelBuf.append("<i>");
			etymLevelBuf.append(etymWord);
			etymLevelBuf.append("</i>");
			if (CollectionUtils.isNotEmpty(etymWordMeaningWords)) {
				etymLevelBuf.append(' ');
				etymLevelBuf.append('\'');
				etymLevelBuf.append(StringUtils.join(etymWordMeaningWords, ", "));
				etymLevelBuf.append('\'');
			}
			if (CollectionUtils.isNotEmpty(etymWordSources)) {
				etymLevelBuf.append(' ');
				etymLevelBuf.append('(');
				etymLevelBuf.append(StringUtils.join(etymWordSources, ", "));
				if (StringUtils.isNotBlank(etymLevelMember.getEtymologyYear())) {
					etymLevelBuf.append(' ');
					etymLevelBuf.append(etymLevelMember.getEtymologyYear());
				}
				etymLevelBuf.append(')');
			}
			if (StringUtils.isNotEmpty(comment)) {
				if (etymLevelMemberIndex == etymLevelSize - 1) {
					etymLevelBuf.append(". ");
					etymLevelBuf.append(comment);
				}
			}
			recentEtymWordLang = etymWordLang;
			etymLevelMemberIndex++;
		}
		return etymLevelBuf.toString();
	}
}
