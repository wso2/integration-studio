/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.appcloud.utils.client;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;

import org.w3c.dom.NodeList;
import org.wso2.developerstudio.appcloud.utils.authentication.UserPasswordCredentials;

public class CloudAdminServiceClient {

	private final static String AUTH_ADMIN_SERVICE = "https://identity.cloud.wso2.com/services/AuthenticationAdmin";
	private final static String USER_MGR_SERVICE = "https://identity.cloud.wso2.com/services/CloudUserManager";

	private final static String USER_MGT_SERVICE_NS = "http://manager.user.cloud.carbon.wso2.org";
	private final static String ADMIN_AUTH_SERVICE_NS = "http://authentication.services.core.carbon.wso2.org";

	public static Map<String, String> getTenantDomains(UserPasswordCredentials credentials) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			
			QName serviceName = null;
			QName portName = null;
			Service service = null;
			Dispatch<SOAPMessage> dispatch = null;
			BindingProvider provider = null;
			SOAPElement operation = null;
			Map<String, Object> headers = null;
			Map<String, List<String>> reqHeaders = null;
			List<String> cookieList = null;
			SOAPMessage response = null;
			SOAPMessage request = null;
			SOAPPart part = null;
			SOAPEnvelope env = null;
			SOAPBody body = null;
			SOAPElement user = null;

			serviceName = new QName(USER_MGT_SERVICE_NS, "CloudUserManager");
			portName = new QName(USER_MGT_SERVICE_NS,
					"CloudUserManagerHttpsSoap11Endpoint");

			service = Service.create(serviceName);
			service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, USER_MGR_SERVICE);

			  // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        // Create empty HostnameVerifier
	        HostnameVerifier hv = new HostnameVerifier() {
	            public boolean verify(String arg0, SSLSession arg1) {
	                return true;
	            }
	        };
	        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws CertificateException {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws CertificateException {
					// TODO Auto-generated method stub
					
				}

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					// TODO Auto-generated method stub
					return null;
				}
	        } 
	        };
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	        HttpsURLConnection.setDefaultHostnameVerifier(hv);
	        
			dispatch = service.createDispatch(portName, SOAPMessage.class,
					Service.Mode.MESSAGE);
			provider = (BindingProvider) dispatch;

			MessageFactory mf = MessageFactory
					.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

			request = mf.createMessage();
			part = request.getSOAPPart();
			env = part.getEnvelope();
			body = env.getBody();

			operation = body.addChildElement("getTenantDisplayNames", "ns",
					USER_MGT_SERVICE_NS);

			user = operation.addChildElement("user");
			user.addTextNode(credentials.getCloudUserName());

			request.saveChanges();

			headers = provider.getRequestContext();
			reqHeaders = (Map) headers.get(MessageContext.HTTP_REQUEST_HEADERS);

			if (reqHeaders == null) {
				reqHeaders = new HashMap<String, List<String>>();
			}

			cookieList = new ArrayList<String>();

			cookieList.add(getCookie(credentials.getCloudUserName(),
					credentials.getPassword()));
			
			reqHeaders.put("Cookie", cookieList);

			headers.put(MessageContext.HTTP_REQUEST_HEADERS, reqHeaders);
			response = dispatch.invoke(request);
			
			NodeList elements = response.getSOAPBody().getFirstChild().getChildNodes();
			
			for(int i=0;i<elements.getLength();i++){
				
				String displayName = elements.item(i).getFirstChild().getTextContent();	
				String domainName = elements.item(i).getLastChild().getTextContent();	
				map.put(displayName, domainName);
				
			}	

		} catch (Exception e) {
			throw e;
		}

		return map;
	}

	public static String getCookie(String userName,
			String password) throws Exception {

		QName serviceName = null;
		QName portName = null;
		Service service = null;
		Dispatch<SOAPMessage> dispatch = null;
		BindingProvider provider = null;
		SOAPElement operation = null;
		SOAPMessage response = null;
		SOAPMessage request = null;
		SOAPPart part = null;
		SOAPEnvelope env = null;
		SOAPBody body = null;
		SOAPElement user = null;
		SOAPElement pwd = null;

		SOAPElement remoteAddr = null;

		serviceName = new QName(ADMIN_AUTH_SERVICE_NS, "AuthenticationAdmin");
		portName = new QName(ADMIN_AUTH_SERVICE_NS,
				"AuthenticationAdminHttpsSoap11Endpoint");

		service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, AUTH_ADMIN_SERVICE);
		dispatch = service.createDispatch(portName, SOAPMessage.class,
				Service.Mode.MESSAGE);
		

		provider = (BindingProvider) dispatch;

		MessageFactory mf = MessageFactory
				.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

		request = mf.createMessage();
		part = request.getSOAPPart();

		env = part.getEnvelope();
		body = env.getBody();

		operation = body.addChildElement("login", "ns", ADMIN_AUTH_SERVICE_NS);

		user = operation.addChildElement("username");
		user.addTextNode(userName);

		pwd = operation.addChildElement("password");
		pwd.addTextNode(password);

		remoteAddr = operation.addChildElement("remoteAddress");
		remoteAddr.addTextNode("wso2.org");

		request.saveChanges();

		response = dispatch.invoke(request);

		if ("true".equals(response.getSOAPBody().getFirstChild()
				.getTextContent())) {
			List cookieList = null;
			Map respHeaders = null;
			Map<String, Object> headers = null;

			headers = provider.getResponseContext();
			respHeaders = (Map) headers
					.get(MessageContext.HTTP_RESPONSE_HEADERS);
			// This is the JSESSIONID cookie.
			cookieList = (List) respHeaders.get("Set-cookie");
			return (String) cookieList.get(0);
		} else {
			return null;
		}

	}

}
