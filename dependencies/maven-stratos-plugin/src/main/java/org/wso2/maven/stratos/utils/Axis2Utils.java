package org.wso2.maven.stratos.utils;

import org.apache.axis2.client.Stub;
import org.apache.axis2.transport.http.HTTPConstants;

public class Axis2Utils {
	public static void setCookie(String sessionCookie,Stub stub) {
		stub._getServiceClient().getOptions().setManageSession(true);
		stub._getServiceClient().getOptions().setProperty(
				HTTPConstants.COOKIE_STRING, sessionCookie);
	}
}
