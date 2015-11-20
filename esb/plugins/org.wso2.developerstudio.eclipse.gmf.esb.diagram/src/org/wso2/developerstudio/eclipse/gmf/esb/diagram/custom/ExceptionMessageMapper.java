package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

public class ExceptionMessageMapper {

	public static String getNonTechnicalMessage(String message) {
		
		String simpleMessage = message;
		if (message != null ){
			if (message.contains("Only one resource can be designated as default")) {
				simpleMessage = "You have defined more than one resources where no uri-mapping(or uri-template) is provided or with empty uri-maping(or uri-template)s, " +
						"which leads to treat all these resources as default resources, But Only one resource can be designated as default. "; 
			} /*else if (place your other mappings here)
			{
				
			}
			*/
		}
		return simpleMessage;
	}

}
