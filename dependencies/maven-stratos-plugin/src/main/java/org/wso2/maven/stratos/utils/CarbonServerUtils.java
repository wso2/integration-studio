package org.wso2.maven.stratos.utils;

import java.net.URL;

import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.wso2.carbon.authenticator.stub.AuthenticationAdminStub;
import org.wso2.carbon.roles.mgt.stub.ServerRolesManagerStub;
import org.wso2.maven.stratos.ssl.utils.SSLUtils;

public class CarbonServerUtils {
	public static String getAutheticatedSessionCookie(URL url, String username, String password) throws Exception{
		return getAutheticatedSessionCookie(url, username, password, false);
	}
	public static String getAutheticatedSessionCookie(URL url, String username, String password, boolean allowInvalidCertificates) throws Exception{
		AuthenticationAdminStub stub = new AuthenticationAdminStub(url.toString()+"/services/AuthenticationAdmin");
		if (allowInvalidCertificates){
			SSLUtils.setSSLProtocolHandler(stub);
		}
		String sessionCookie=null;
		if (stub.login(username, password,url.getHost())){
			ServiceContext serviceContext = stub._getServiceClient().getLastOperationContext().getServiceContext();
			sessionCookie = (String) serviceContext.getProperty(HTTPConstants.COOKIE_STRING);
		}
		return sessionCookie;
	}

	public static String[] getServerRoles(URL serverURL, String sessionCookie) throws Exception{
		return getServerRoles(serverURL, sessionCookie, false);
	}
	
	public static String[] getServerRoles(URL serverURL, String sessionCookie, boolean allowInvalidCertificates) throws Exception{
		ServerRolesManagerStub stub = new ServerRolesManagerStub(serverURL.toString()+"/services/ServerRolesManager");
		if (allowInvalidCertificates){
			SSLUtils.setSSLProtocolHandler(stub);
		}
		Axis2Utils.setCookie(sessionCookie, stub);
		String[] readServerRoles = stub.readServerRoles("Default");
		return readServerRoles;
	}
}
