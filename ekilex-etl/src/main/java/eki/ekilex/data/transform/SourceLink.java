package eki.ekilex.data.transform;

import eki.common.constant.ReferenceType;
import eki.common.data.AbstractDataObject;

public abstract class SourceLink extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private Long sourceId;

	private ReferenceType type;

	private String name;

	private String value;

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public ReferenceType getType() {
		return type;
	}

	public void setType(ReferenceType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
