package eki.ekilex.data;

import eki.common.data.AbstractDataObject;

public class LexemeData extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String datasetCode;

	private String processStateCode;

	private String layerProcessStateCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatasetCode() {
		return datasetCode;
	}

	public void setDatasetCode(String datasetCode) {
		this.datasetCode = datasetCode;
	}

	public String getProcessStateCode() {
		return processStateCode;
	}

	public void setProcessStateCode(String processStateCode) {
		this.processStateCode = processStateCode;
	}

	public String getLayerProcessStateCode() {
		return layerProcessStateCode;
	}

	public void setLayerProcessStateCode(String layerProcessStateCode) {
		this.layerProcessStateCode = layerProcessStateCode;
	}

}
