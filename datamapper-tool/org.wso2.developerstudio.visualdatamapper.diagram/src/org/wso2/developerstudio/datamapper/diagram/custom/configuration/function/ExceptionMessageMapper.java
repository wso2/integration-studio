package org.wso2.developerstudio.datamapper.diagram.custom.configuration.function;

public class ExceptionMessageMapper {

	public static String getNonTechnicalMessage(String message) {
		
		String simpleMessage = message;
		if (message != null ){
			if (message.contains("Function generation exeception occured")) {
				simpleMessage = "Related config can not generate  "; 
			} 
		}
		return simpleMessage;
	}
}
