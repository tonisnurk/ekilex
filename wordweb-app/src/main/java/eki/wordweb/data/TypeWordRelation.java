package eki.wordweb.data;

import eki.common.constant.Complexity;
import eki.common.data.Classifier;

public class TypeWordRelation extends WordTypeData {

	private static final long serialVersionUID = 1L;

	private Long wordId;

	private String word;

	private String wordLang;

	private Integer homonymNr;

	private Complexity[] lexComplexities;

	private String wordRelTypeCode;

	private Classifier wordRelType;

	public Long getWordId() {
		return wordId;
	}

	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordLang() {
		return wordLang;
	}

	public void setWordLang(String wordLang) {
		this.wordLang = wordLang;
	}

	public Integer getHomonymNr() {
		return homonymNr;
	}

	public void setHomonymNr(Integer homonymNr) {
		this.homonymNr = homonymNr;
	}

	public Complexity[] getLexComplexities() {
		return lexComplexities;
	}

	public void setLexComplexities(Complexity[] lexComplexities) {
		this.lexComplexities = lexComplexities;
	}

	public String getWordRelTypeCode() {
		return wordRelTypeCode;
	}

	public void setWordRelTypeCode(String wordRelTypeCode) {
		this.wordRelTypeCode = wordRelTypeCode;
	}

	public Classifier getWordRelType() {
		return wordRelType;
	}

	public void setWordRelType(Classifier wordRelType) {
		this.wordRelType = wordRelType;
	}

}
