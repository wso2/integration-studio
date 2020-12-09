package org.wso2.developerstudio.datamapper.diagram.custom.generator.lang;

import java.util.ArrayList;
import java.util.List;

public class DMConfig {
	
	List<DMFunction> functionsList;
	
	public List<DMFunction> getFunctionsList() {
		return functionsList;
	}

	public DMConfig() {
		functionsList = new ArrayList<DMFunction>();
	}
	
	@Override
	public String toString() {
		String config = "";
		for (DMFunction function :functionsList) {
			config += "\n" + function.toString();
		}
		return config;
	}
}
