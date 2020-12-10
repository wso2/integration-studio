package org.wso2.integrationstudio.datamapper.diagram.custom.generator.lang;

public class FunctionCallLine extends LanguageLine {
	String name;
	String inputArg;
	String outputArg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getInputArg() {
		return inputArg;
	}
	public void setInputArg(String inputArg) {
		this.inputArg = inputArg;
	}

	public String getOutputArg() {
		return outputArg;
	}
	public void setOutputArg(String outputArg) {
		this.outputArg = outputArg;
	}

	
	public FunctionCallLine(String name, String inputArg, String outputArg) {
		this.name = name;
		this.inputArg = inputArg;
		this.outputArg = outputArg;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s);", name, inputArg, outputArg);
	}
}