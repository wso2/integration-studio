package org.wso2.maven.stratos.utils;

import java.net.URL;

import org.wso2.maven.stratos.ssl.utils.SSLUtils;
import org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub;
import org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.CloudService;
import org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.RetrieveCloudServiceInfo;
import org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.RetrieveCloudServiceInfoResponse;

public class StratosUtils {
	
	public static CloudService[] getCloudServices(URL stratosURL, String sessionCookie) throws Exception{
		return getCloudServices(stratosURL, sessionCookie, false);
	}
	
	public static CloudService[] getCloudServices(URL stratosURL, String sessionCookie, boolean allowInvalidCertificates) throws Exception{
		CloudManagerServiceStub stub = new CloudManagerServiceStub(stratosURL.toString()+"/services/CloudManagerService");
		if (allowInvalidCertificates){
			SSLUtils.setSSLProtocolHandler(stub);
		}
		Axis2Utils.setCookie(sessionCookie, stub);
		RetrieveCloudServiceInfo a = new RetrieveCloudServiceInfo();
		RetrieveCloudServiceInfoResponse retrieveCloudServiceInfo = stub.retrieveCloudServiceInfo(a);
		CloudService[] cloudService = retrieveCloudServiceInfo.get_return();
		return cloudService;
	}
}
