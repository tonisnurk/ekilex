package eki.ekilex.data;

import javax.persistence.Column;

import eki.common.data.AbstractDataObject;

public class Word extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	@Column(name = "word_id")
	private Long wordId;

	@Column(name = "word")
	private String value;

	@Column(name = "homonym_nr")
	private Integer homonymNumber;

	@Column(name = "lang")
	private String language;

	@Column(name = "word_class")
	private String wordClass;

	@Column(name = "gender_code")
	private String genderCode;

	@Column(name = "aspect_code")
	private String aspectCode;

	@Column(name = "dataset_codes")
	private String[] datasetCodes;

	public Word() {
	}

	public Long getWordId() {
		return wordId;
	}

	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getHomonymNumber() {
		return homonymNumber;
	}

	public void setHomonymNumber(Integer homonymNumber) {
		this.homonymNumber = homonymNumber;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getWordClass() {
		return wordClass;
	}

	public void setWordClass(String wordClass) {
		this.wordClass = wordClass;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getAspectCode() {
		return aspectCode;
	}

	public void setAspectCode(String aspectCode) {
		this.aspectCode = aspectCode;
	}

	public String[] getDatasetCodes() {
		return datasetCodes;
	}

	public void setDatasetCodes(String[] datasetCodes) {
		this.datasetCodes = datasetCodes;
	}

}
