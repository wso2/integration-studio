package org.wso2.datamapper.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigDataModel {
	
	private Map<String, String> dataTypemap;
	private List<OutputDataModel> outDataModels;
	private String inputDatatype;
	private String outputdataType;
	private OutputDataModel outDataModel;
	
	public ConfigDataModel(){
		dataTypemap = new HashMap<String, String>();
		outDataModels = new ArrayList<OutputDataModel>();
	}
	
	public void addDataType(String inputtype, String outputType) {
		this.dataTypemap.put(inputtype, outputType);
	}

	public Map<String, String> getDataTypemap() {
		return dataTypemap;
	}
	
	public void addOutDataModel(OutputDataModel outModel) {
		this.outDataModels.add(outModel);
	}

	public List<OutputDataModel> getOutDataModels() {
		return outDataModels;
	}

	public String getInputDatatype() {
		return inputDatatype;
	}

	public void setInputDatatype(String inputDatatype) {
		this.inputDatatype = inputDatatype;
	}

	public String getOutputdataType() {
		return outputdataType;
	}

	public void setOutputdataType(String outputdataType) {
		this.outputdataType = outputdataType;
	}

	public void setOutDataModels(List<OutputDataModel> outDataModels) {
		this.outDataModels = outDataModels;
	}

	public OutputDataModel getOutDataModel() {
		return outDataModel;
	}

	public void setOutDataModel(OutputDataModel outDataModel) {
		this.outDataModel = outDataModel;
	}
	
	
	
}
