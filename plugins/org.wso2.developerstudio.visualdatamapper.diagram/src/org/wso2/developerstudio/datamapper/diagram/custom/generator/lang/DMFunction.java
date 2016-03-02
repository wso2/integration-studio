package org.wso2.developerstudio.datamapper.diagram.custom.generator.lang;

import java.util.ArrayList;
import java.util.List;

public class DMFunction {
	String name;
	String inputArg;
	String outputArg;
	List<LanguageLine> lines;
	
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

	public List<LanguageLine> getLines() {
		return lines;
	}
	
	public DMFunction(String name, String inputArg, String outputArg) {
		lines = new ArrayList<LanguageLine>();
		this.name = name;
		this.inputArg = inputArg;
		this.outputArg = outputArg;
	}
	
	@Override
	public String toString() {
		 String startTemplate = "function %s(%s, %s) {";
		 String endTemplate = "\n\treturn %s; \n}";
         String start = String.format(startTemplate, name, inputArg, outputArg);
         String end = String.format(endTemplate, outputArg);
         String body = "";
         for (LanguageLine line : lines) {
        	 body += "\n\t" + line.toString();
         }
         return start + body + end;
	}

}
