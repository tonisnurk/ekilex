package eki.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import eki.common.constant.TextDecoration;
import eki.common.data.CodeValue;
import eki.common.data.TextDecorationDescriptor;

@Component
public class TextDecorationService implements InitializingBean, TextDecoration {

	//TODO remove later when new kind of cleanup has been tested
	//private static final String EKI_MARKUP_GENERIC_PATTERN = "[&]\\w+[;]";

	private static final String EKI_MARKUP_PATTERN_FOREIGN = "(&ema;(.+?)&eml;)";

	private static final String EKI_MARKUP_PATTERN_HIGHLIGHT = "(&ba;(.+?)&bl;)";

	private static final String EKI_MARKUP_PATTERN_SUB = "(&suba;(.+?)&subl;)";

	private static final String EKI_MARKUP_PATTERN_SUP = "(&supa;(.+?)&supl;)";

	private static final String EKI_MARKUP_PATTERN_META_V = "(&(v);)";

	private static final String EKI_MARKUP_PATTERN_META_ETC = "(&(ehk|Hrl|hrl|ja|jne|jt|ka|nt|puudub|vm|vms|vrd|vt|напр.|и др.|и т. п.|г.);)";

	private static final String EKI_MARKUP_PATTERN_RUSSIAN_STRESS_1 = "[\\\"\\x{201e}][\\x{0400}-\\x{04ff}]";

	private static final String EKI_MARKUP_PATTERN_RUSSIAN_STRESS_2 = "[\\x{0401}\\x{0451}]";

	private static final int REPLACE_MARKUP = 1;

	private static final int SURROUND_CHAR_BY_MARKUP = 2;

	private List<TextDecorationDescriptor> allEkiMarkupDescriptors;

	private List<TextDecorationDescriptor> uniLangEkiMarkupDescriptors;

	@Override
	public void afterPropertiesSet() throws Exception {

		allEkiMarkupDescriptors = new ArrayList<>();
		uniLangEkiMarkupDescriptors = new ArrayList<>();

		Pattern entityMatchPattern;
		String preDecoration, postDecoration;
		TextDecorationDescriptor textDecorationDescriptor;

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_FOREIGN);
		preDecoration = asXmlElemStart(FOREIGN);
		postDecoration = asXmlElemEnd(FOREIGN);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, REPLACE_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
		uniLangEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_HIGHLIGHT);
		preDecoration = asXmlElemStart(HIGHLIGHT);
		postDecoration = asXmlElemEnd(HIGHLIGHT);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, REPLACE_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
		uniLangEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_SUB);
		preDecoration = asXmlElemStart(SUB);
		postDecoration = asXmlElemEnd(SUB);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, REPLACE_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
		uniLangEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_SUP);
		preDecoration = asXmlElemStart(SUP);
		postDecoration = asXmlElemEnd(SUP);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, REPLACE_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
		uniLangEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_META_V);
		preDecoration = asXmlElemStart(META) + "~" + asXmlElemEnd(META);
		postDecoration = null;
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, REPLACE_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
		uniLangEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_META_ETC);
		preDecoration = asXmlElemStart(META);
		postDecoration = asXmlElemEnd(META);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, REPLACE_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
		uniLangEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_RUSSIAN_STRESS_1);
		preDecoration = asXmlElemStart(STRESS);
		postDecoration = asXmlElemEnd(STRESS);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, SURROUND_CHAR_BY_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);

		entityMatchPattern = Pattern.compile(EKI_MARKUP_PATTERN_RUSSIAN_STRESS_2);
		preDecoration = asXmlElemStart(STRESS);
		postDecoration = asXmlElemEnd(STRESS);
		textDecorationDescriptor = new TextDecorationDescriptor(entityMatchPattern, preDecoration, postDecoration, SURROUND_CHAR_BY_MARKUP);
		allEkiMarkupDescriptors.add(textDecorationDescriptor);
	}

	public String cleanEkiElementMarkup(String originalText) {
		if (StringUtils.isBlank(originalText)) {
			return originalText;
		}
		String cleanText = RegExUtils.removePattern(originalText, "<[/]?eki-[^>]*>");
		return cleanText;
	}

	public String cleanHtmlAndSkipEkiElementMarkup(String originalText) {
		if (StringUtils.isBlank(originalText)) {
			return originalText;
		}
		String cleanText = RegExUtils.removePattern(originalText, "(?!<[/]?eki-[^>]*>)<[^>]*>");
		return cleanText;
	}

	public String cleanEkiEntityMarkup(String originalText) {
		return cleanEkiEntityMarkup(originalText, false);
	}

	public String cleanEkiEntityMarkupSkipStress(String originalText) {
		return cleanEkiEntityMarkup(originalText, true);
	}

	private String cleanEkiEntityMarkup(String originalText, boolean skipStress) {
		if (StringUtils.isBlank(originalText)) {
			return originalText;
		}
		String convertedText = new String(originalText);
		List<TextDecorationDescriptor> ekiMarkupDescriptors;
		if (skipStress) {
			ekiMarkupDescriptors = new ArrayList<>(uniLangEkiMarkupDescriptors);
		} else {
			ekiMarkupDescriptors = new ArrayList<>(allEkiMarkupDescriptors);
		}
		Pattern pattern;
		int applyMethod;
		for (TextDecorationDescriptor textDecorationDescriptor : ekiMarkupDescriptors) {
			pattern = textDecorationDescriptor.getEntityMatchPattern();
			applyMethod = textDecorationDescriptor.getApplyMethod();
			if (REPLACE_MARKUP == applyMethod) {
				convertedText = cleanByReplacingPattern(pattern, convertedText);
			} else if (SURROUND_CHAR_BY_MARKUP == applyMethod) {
				convertedText = cleanBySurroundingCharPattern(pattern, convertedText);
			}
		}
		return convertedText;
	}

	public String convertEkiEntityMarkup(String originalText) {

		if (StringUtils.isEmpty(originalText)) {
			return originalText;
		}

		String convertedText = new String(originalText);
		Pattern pattern;
		String preDecoration;
		String postDecoration;
		int applyMethod;

		for (TextDecorationDescriptor textDecorationDescriptor : allEkiMarkupDescriptors) {
			pattern = textDecorationDescriptor.getEntityMatchPattern();
			preDecoration = textDecorationDescriptor.getPreDecoration();
			postDecoration = textDecorationDescriptor.getPostDecoration();
			applyMethod = textDecorationDescriptor.getApplyMethod();
			if (REPLACE_MARKUP == applyMethod) {
				convertedText = replaceByPattern(pattern, convertedText, preDecoration, postDecoration);
			} else if (SURROUND_CHAR_BY_MARKUP == applyMethod) {
				convertedText = surroundCharByPattern(pattern, convertedText, preDecoration, postDecoration);
			}
		}
		return convertedText;
	}

	public String composeLinkMarkup(String linkType, String linkId, String linkValue) {
		StringBuffer markupBuf = new StringBuffer();
		markupBuf.append("<");
		markupBuf.append(LINK.getCode());
		markupBuf.append(" link-type='");
		markupBuf.append(linkType);
		markupBuf.append("'");
		markupBuf.append(" link-id='");
		markupBuf.append(linkId);
		markupBuf.append("'");
		markupBuf.append(">");
		markupBuf.append(linkValue);
		markupBuf.append(asXmlElemEnd(LINK));
		return markupBuf.toString();
	}

	public String applyPattern(Pattern pattern, String text, CodeValue codeValue) {
		String preDecoration = asXmlElemStart(codeValue);
		String postDecoration = asXmlElemEnd(codeValue);
		return replaceByPattern(pattern, text, preDecoration, postDecoration);
	}

	private String replaceByPattern(Pattern pattern, String text, String preDecoration, String postDecoration) {
		return replaceByPattern(pattern, text, preDecoration, postDecoration, null);
	}

	private String replaceByPattern(Pattern pattern, String text, String preDecoration, String postDecoration, String fixedMatchReplacement) {

		StringBuffer decorBuf = new StringBuffer();
		Matcher matcher = pattern.matcher(text);
		int textLength = text.length();
		int textStart = 0;
		int matchStart;
		int matchEnd;
		String cleanFragment;
		String matchFragment;
		while (matcher.find()) {
			matchStart = matcher.start();
			matchEnd = matcher.end();
			cleanFragment = StringUtils.substring(text, textStart, matchStart);
			decorBuf.append(cleanFragment);
			if (fixedMatchReplacement == null) {
				if (matcher.groupCount() > 1) {
					matchFragment = matcher.group(matcher.groupCount());
				} else {
					matchFragment = null;
				}
			} else {
				matchFragment = fixedMatchReplacement;
			}
			if ((preDecoration == null) && (postDecoration == null)) {
				decorBuf.append(matchFragment);
			} else if ((preDecoration != null) && (postDecoration == null)) {
				decorBuf.append(preDecoration);
			} else {
				decorBuf.append(preDecoration);
				decorBuf.append(matchFragment);
				decorBuf.append(postDecoration);
			}
			textStart = matchEnd;
		}
		if (textStart < textLength) {
			cleanFragment = StringUtils.substring(text, textStart, textLength);
			decorBuf.append(cleanFragment);
		}
		text = decorBuf.toString();
		return text;
	}

	private String cleanByReplacingPattern(Pattern pattern, String text) {

		StringBuffer decorBuf = new StringBuffer();
		Matcher matcher = pattern.matcher(text);
		int textLength = text.length();
		int textStart = 0;
		int matchStart;
		int matchEnd;
		String cleanFragment;
		String matchFragment;
		while (matcher.find()) {
			matchStart = matcher.start();
			matchEnd = matcher.end();
			cleanFragment = StringUtils.substring(text, textStart, matchStart);
			matchFragment = matcher.group(matcher.groupCount());
			decorBuf.append(cleanFragment);
			decorBuf.append(matchFragment);
			textStart = matchEnd;
		}
		if (textStart < textLength) {
			cleanFragment = StringUtils.substring(text, textStart, textLength);
			decorBuf.append(cleanFragment);
		}
		text = decorBuf.toString();
		return text;
	}

	private String surroundCharByPattern(Pattern pattern, String text, String preDecoration, String postDecoration) {

		StringBuffer decorBuf = new StringBuffer();
		Matcher matcher = pattern.matcher(text);
		int textLength = text.length();
		int textStart = 0;
		int matchStart;
		int matchEnd;
		String cleanFragment;
		String matchFragment;
		char[] matchFragmentChars;
		while (matcher.find()) {
			matchStart = matcher.start();
			matchEnd = matcher.end();
			cleanFragment = StringUtils.substring(text, textStart, matchStart);
			matchFragment = matcher.group(0);
			matchFragmentChars = matchFragment.toCharArray();
			char matchFragmentChar = matchFragmentChars[matchFragmentChars.length - 1];
			decorBuf.append(cleanFragment);
			decorBuf.append(preDecoration);
			decorBuf.append(matchFragmentChar);
			decorBuf.append(postDecoration);
			textStart = matchEnd;
		}
		if (textStart < textLength) {
			cleanFragment = StringUtils.substring(text, textStart, textLength);
			decorBuf.append(cleanFragment);
		}
		text = decorBuf.toString();
		return text;
	}

	private String cleanBySurroundingCharPattern(Pattern pattern, String text) {

		StringBuffer decorBuf = new StringBuffer();
		Matcher matcher = pattern.matcher(text);
		int textLength = text.length();
		int textStart = 0;
		int matchStart;
		int matchEnd;
		String cleanFragment;
		String matchFragment;
		char[] matchFragmentChars;
		while (matcher.find()) {
			matchStart = matcher.start();
			matchEnd = matcher.end();
			cleanFragment = StringUtils.substring(text, textStart, matchStart);
			matchFragment = matcher.group(0);
			matchFragmentChars = matchFragment.toCharArray();
			char matchFragmentChar = matchFragmentChars[matchFragmentChars.length - 1];
			decorBuf.append(cleanFragment);
			decorBuf.append(matchFragmentChar);
			textStart = matchEnd;
		}
		if (textStart < textLength) {
			cleanFragment = StringUtils.substring(text, textStart, textLength);
			decorBuf.append(cleanFragment);
		}
		text = decorBuf.toString();
		return text;
	}

	private String asXmlElemStart(CodeValue codeValue) {
		return "<" + codeValue.getCode() + ">";
	}

	private String asXmlElemEnd(CodeValue codeValue) {
		return "</" + codeValue.getCode() + ">";
	}
}
