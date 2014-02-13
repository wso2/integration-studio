package org.wso2.datamapper.model;

import java.util.ArrayList;
import java.util.List;

public class OutputDataModel {
	
	private String outputElement;
	private String function;
	private List<String> argList;
	private String outElementValue;
	
	public OutputDataModel() {
		argList = new ArrayList<String>();
	}
	
	public String getOutputElement() {
		return outputElement;
	}
	public void setOutputElement(String outputElement) {
		this.outputElement = outputElement;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public List<String> getArgList() {
		return argList;
	}
	public void addArg(String arg) {
		this.argList.add(arg);
	}

	public String getOutElementValue() {
		return outElementValue;
	}

	public void setOutElementValue(String outElementValue) {
		this.outElementValue = outElementValue;
	}

}
