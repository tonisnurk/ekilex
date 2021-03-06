package eki.ekilex.data.imp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import eki.common.constant.FormMode;
import eki.common.data.AbstractDataObject;

@JsonIgnoreProperties({"id", "paradigm_id"})
public class Form extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonProperty("paradigm_id")
	private Long paradigmId;

	@JsonProperty("mode")
	private FormMode mode;

	@JsonProperty("morph_group1")
	private String morphGroup1;

	@JsonProperty("morph_group2")
	private String morphGroup2;

	@JsonProperty("morph_group3")
	private String morphGroup3;

	@JsonProperty("display_level")
	private Integer displayLevel;

	@JsonProperty("morph_code")
	private String morphCode;

	@JsonProperty("morph_exists")
	private Boolean morphExists;

	@JsonProperty("value")
	private String value;

	@JsonProperty("value_prese")
	private String valuePrese;

	@JsonProperty("components")
	private String[] components;

	@JsonProperty("display_form")
	private String displayForm;

	@JsonProperty("vocal_form")
	private String vocalForm;

	@JsonProperty("audio_file")
	private String audioFile;

	@JsonProperty("order_by")
	private Long orderBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParadigmId() {
		return paradigmId;
	}

	public void setParadigmId(Long paradigmId) {
		this.paradigmId = paradigmId;
	}

	public FormMode getMode() {
		return mode;
	}

	public void setMode(FormMode mode) {
		this.mode = mode;
	}

	public String getMorphGroup1() {
		return morphGroup1;
	}

	public void setMorphGroup1(String morphGroup1) {
		this.morphGroup1 = morphGroup1;
	}

	public String getMorphGroup2() {
		return morphGroup2;
	}

	public void setMorphGroup2(String morphGroup2) {
		this.morphGroup2 = morphGroup2;
	}

	public String getMorphGroup3() {
		return morphGroup3;
	}

	public void setMorphGroup3(String morphGroup3) {
		this.morphGroup3 = morphGroup3;
	}

	public Integer getDisplayLevel() {
		return displayLevel;
	}

	public void setDisplayLevel(Integer displayLevel) {
		this.displayLevel = displayLevel;
	}

	public String getMorphCode() {
		return morphCode;
	}

	public void setMorphCode(String morphCode) {
		this.morphCode = morphCode;
	}

	public Boolean getMorphExists() {
		return morphExists;
	}

	public void setMorphExists(Boolean morphExists) {
		this.morphExists = morphExists;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValuePrese() {
		return valuePrese;
	}

	public void setValuePrese(String valuePrese) {
		this.valuePrese = valuePrese;
	}

	public String[] getComponents() {
		return components;
	}

	public void setComponents(String[] components) {
		this.components = components;
	}

	public String getDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(String displayForm) {
		this.displayForm = displayForm;
	}

	public String getVocalForm() {
		return vocalForm;
	}

	public void setVocalForm(String vocalForm) {
		this.vocalForm = vocalForm;
	}

	public String getAudioFile() {
		return audioFile;
	}

	public void setAudioFile(String audioFile) {
		this.audioFile = audioFile;
	}

	public Long getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

}
