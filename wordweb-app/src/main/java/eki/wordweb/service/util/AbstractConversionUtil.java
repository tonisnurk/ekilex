package eki.wordweb.service.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import eki.common.constant.Complexity;
import eki.wordweb.constant.SystemConstant;
import eki.wordweb.constant.WebConstant;
import eki.wordweb.data.ComplexityType;
import eki.wordweb.data.LangType;
import eki.wordweb.data.TypeMeaningWord;
import eki.wordweb.data.Word;
import eki.wordweb.data.WordTypeData;

public abstract class AbstractConversionUtil implements WebConstant, SystemConstant {

	@Autowired
	protected ClassifierUtil classifierUtil;

	public void setWordTypeFlags(WordTypeData wordTypeData) {

		boolean isPrefixoid = false;
		boolean isSuffixoid = false;
		boolean isAbbreviationWord = false;
		boolean isForeignWord = false;
		List<String> wordTypeCodes = wordTypeData.getWordTypeCodes();
		if (CollectionUtils.isNotEmpty(wordTypeCodes)) {
			isPrefixoid = wordTypeCodes.contains(PREFIXOID_WORD_TYPE_CODE);
			isSuffixoid = wordTypeCodes.contains(SUFFIXOID_WORD_TYPE_CODE);
			isAbbreviationWord = CollectionUtils.containsAny(wordTypeCodes, Arrays.asList(ABBREVIATION_WORD_TYPE_CODES));
			isForeignWord = wordTypeCodes.contains(FOREIGN_WORD_TYPE_CODE);
		}
		wordTypeData.setPrefixoid(isPrefixoid);
		wordTypeData.setSuffixoid(isSuffixoid);
		wordTypeData.setAbbreviationWord(isAbbreviationWord);
		wordTypeData.setForeignWord(isForeignWord);

		if (wordTypeData instanceof Word) {
			Word word = (Word) wordTypeData;
			List<TypeMeaningWord> meaningWords = word.getMeaningWords();
			if (CollectionUtils.isNotEmpty(meaningWords)) {
				for (TypeMeaningWord meaningWord : meaningWords) {
					setWordTypeFlags(meaningWord);
				}
			}
		}
	}

	protected <T extends ComplexityType> List<T> filter(List<T> list, Complexity lexComplexity) {
		if (CollectionUtils.isEmpty(list)) {
			return list;
		}
		if (lexComplexity == null) {
			return list;
		}
		if (complexityExists(list, lexComplexity)) {
			return list.stream().filter(elem -> isComplexityMatch(elem.getComplexity(), lexComplexity)).collect(Collectors.toList());
		}
		return list;
	}

	protected boolean complexityExists(List<? extends ComplexityType> list, Complexity lexComplexity) {
		if (CollectionUtils.isEmpty(list)) {
			return false;
		}
		return list.stream().anyMatch(elem -> isComplexityMatch(elem.getComplexity(), lexComplexity));
	}

	protected boolean isComplexityMatch(Complexity dataComplexity, Complexity lexComplexity) {
		if (dataComplexity == null) {
			return true;
		}
		if (Complexity.DEFAULT.equals(dataComplexity)) {
			return true;
		}
		return StringUtils.startsWith(dataComplexity.name(), lexComplexity.name());
	}

	protected <T extends LangType> List<T> filter(List<T> list, String wordLang, List<String> destinLangs) {
		if (CollectionUtils.isEmpty(list)) {
			return list;
		}
		if (CollectionUtils.isEmpty(destinLangs)) {
			return list;
		}
		return list.stream().filter(elem -> isLangFilterMatch(wordLang, elem.getLang(), destinLangs)).collect(Collectors.toList());
	}

	protected boolean isLangFilterMatch(String wordLang, String dataLang, List<String> destinLangs) {
		if (CollectionUtils.isEmpty(destinLangs)) {
			return true;
		}
		if (destinLangs.contains(DESTIN_LANG_ALL)) {
			return true;
		}
		if (StringUtils.equals(wordLang, dataLang)) {
			return true;
		}
		boolean isDataLangSupportedFilterLang = ArrayUtils.contains(SUPPORTED_DESTIN_LANGS, dataLang);
		if (isDataLangSupportedFilterLang && destinLangs.contains(dataLang)) {
			return true;
		} else if (!isDataLangSupportedFilterLang && destinLangs.contains(DESTIN_LANG_OTHER)) {
			return true;
		}
		return false;
	}
}
