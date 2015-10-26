package org.wso2.developerstudio.embedded.tomcat.exception;

public class AppNotFoundException extends EmbeddedTomcatException {

	private static final long serialVersionUID = 878234784147263928L;

	public AppNotFoundException(String appID) {
		super("App: " + appID + " is not found in embedded tomcat server.");
	}
}
