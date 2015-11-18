/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.jaxrs.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.wso2.developerstudio.eclipse.artifact.jaxrs.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class JaxUtil {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static String getCXFWebConfig(){
		StringBuffer config = new StringBuffer();
		config.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		config.append("<web-app version=\"2.5\" xmlns=\"http://java.sun.com/xml/ns/javaee\"\n");
		config.append("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
		config.append("\txsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee \n");
		config.append("\thttp://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\">\n");
		config.append("<display-name>cxf</display-name>\n\n");
		config.append("<servlet>\n");
		config.append("\t<servlet-name>cxf</servlet-name>\n");
		config.append("\t<display-name>cxf</display-name>\n");
		config.append("\t<description>Apache CXF Endpoint</description>\n");
		config.append("\t<servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>\n");
		config.append("\t<load-on-startup>1</load-on-startup>\n");
		config.append("</servlet>\n\n");
		config.append("<servlet-mapping>\n");
		config.append("\t<servlet-name>cxf</servlet-name>\n");
		config.append("\t<url-pattern>/services/*</url-pattern>\n");
		config.append("</servlet-mapping>\n\n");
		config.append("<session-config>\n");
		config.append("\t<session-timeout>60</session-timeout>\n");
		config.append("</session-config>\n\n");
		config.append("</web-app>\n");
		return config.toString();
	}
	
	public static String getServiceClassSource(String PackageName, String  className, boolean stubs ){
		
		StringBuffer buffer = new StringBuffer();
		if(!PackageName.equalsIgnoreCase("")){
		buffer.append("package " + PackageName + ";\n");
		buffer.append("\n");
		}
		
		if(stubs){
			buffer.append("import javax.ws.rs.*;\n");
			buffer.append("import javax.ws.rs.core.*;\n");
		} else{
			buffer.append("import javax.ws.rs.Path;\n");
		}
		buffer.append("\n");
		buffer.append("@Path(\"");
		buffer.append("/");
		buffer.append("\")\n");
		buffer.append("public interface ");
		buffer.append(className);
		buffer.append("{\n\n");
		if(stubs){
			buffer.append("\t/** This is sample methods */\n");
			buffer.append("\t@GET\n");
			buffer.append("\t@Path(\"/add/{a}/{b}\")\n");
			buffer.append("\t@Produces(MediaType.TEXT_PLAIN)\n");
			buffer.append("\tpublic Double add(");
			buffer.append("@PathParam(\"a\") double a,");
			buffer.append("@PathParam(\"b\") double b);\n\n");
			
			buffer.append("\t@GET\n");
			buffer.append("\t@Path(\"/sub/{a}/{b}\")\n");
			buffer.append("\t@Produces(MediaType.TEXT_PLAIN)\n");
			buffer.append("\tpublic Double sub(");
			buffer.append("@PathParam(\"a\") double a,");
			buffer.append("@PathParam(\"b\") double b);\n\n");
		}
		buffer.append("\n}");
		return buffer.toString();
	}
	
	public static String getJsr311LibraryName(){
		return "jsr311-api-1.1.1.jar";
	} 
	
	
	public static class CxfServlet extends AbstractXMLDoc{
		private static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";
		private static final String JAXRS_NS = "http://cxf.apache.org/jaxrs";
		private static final String JAXRS_XSD = "http://cxf.apache.org/schemas/jaxrs.xsd";
		private static final String SOAP_NS = "http://cxf.apache.org/bindings/soap";
		private static final String SOAP_XSD = "http://cxf.apache.org/schemas/configuration/soap.xsd";
		private static final String DEFAULT_NS = "http://www.springframework.org/schema/beans";
		private static final String BEANS_XSD = "http://www.springframework.org/schema/beans/spring-beans-2.0.xsd";
		
		private static final String SCHEMA_LOCATION = String.format("%s %s %s %s %s %s",
				DEFAULT_NS, BEANS_XSD, SOAP_NS, SOAP_XSD, JAXRS_NS, JAXRS_XSD);
		
		
		OMElement documentElement=null;
		OMNamespace xsi = null;
		OMNamespace jaxrs = null;
		
		private Map<String,JaxwsServer> servers= new HashMap<String,JaxwsServer>(); 
		
		public Map<String, JaxwsServer> getServers() {
			return servers;
		}
		
		public void addServer(String id, String serviceClass, String address, String beanClass){
			JaxwsServer server = new JaxwsServer();
			server.setId(id);
			server.setServiceClass(serviceClass);
			server.setAddress(address);
			server.setBeanClass(beanClass);
			getServers().put(id, server);
		}
		
		public void removeServer(String id){
			getServers().remove(id);
		}


		public CxfServlet(){
			
		}

		@Override
		public void deserialize(OMElement documentElement) throws Exception {
			this.documentElement = documentElement;
			xsi = documentElement.findNamespace(XSI_NS, "xsi");
			jaxrs = documentElement.findNamespace(JAXRS_NS, "jaxrs");
			/*
			List<OMElement> servers = getChildElements(documentElement,"server");
			if (servers.size() > 1) {
				for (OMElement serverElement : servers) {
					JaxwsServer server = new JaxwsServer();
					String id = getAttribute(serverElement, "id");
					String serviceClass =getAttribute(serverElement, "serviceClass");
					String address =getAttribute(serverElement, "address");
					String beanClass = null;
					List<OMElement> serviceBeanElements = getChildElements(serverElement,"serviceBean");
					if (serviceBeanElements.size() ==1){
						List<OMElement> beanElements = getChildElements(serviceBeanElements.get(0),"bean");
						if (beanElements.size() ==1){
							beanClass = getAttribute(beanElements.get(0), "class");
						}
					}
					server.setId(id);
					server.setServiceClass(serviceClass);
					server.setAddress(address);
					server.setBeanClass(beanClass);
					getServers().put(id, server);
				}
			}
			*/
		}

		@Override
		public String serialize() {
			String result = null;
			OMDocument document = factory.createOMDocument();
			OMElement documentElement = getDocumentElement();
			document.addChild(documentElement);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				prettify(documentElement, outputStream);
			} catch (XMLStreamException e) {
				log.error(e);
				return null;
			} catch (Exception e) {
				log.error(e);
				return null;
			}
			result = outputStream.toString();
			return result;
		}
		
		public OMElement getDocumentElement() {
			OMFactory factory = OMAbstractFactory.getOMFactory();
			if(documentElement==null){
				documentElement = getElement("beans", "");
				documentElement.declareDefaultNamespace(DEFAULT_NS);
				xsi = documentElement.declareNamespace(XSI_NS, "xsi");
				jaxrs = documentElement.declareNamespace(JAXRS_NS, "jaxrs");
				documentElement.addAttribute("schemaLocation",SCHEMA_LOCATION, xsi);
			}
			
			for(JaxwsServer s: getServers().values()){
				OMElement serverElement = factory.createOMElement("server",jaxrs);
				serverElement.addAttribute("id",s.getId(),null);
				serverElement.addAttribute("address",s.getAddress(),null);
				if(s.getBeanClass()!=null){
					OMElement serviceBeanElement = factory.createOMElement("serviceBeans",jaxrs);
					OMElement beanRef = factory.createOMElement(new QName("ref"));
					beanRef.addAttribute("bean",s.getId().concat("Bean"),null);
					serviceBeanElement.addChild(beanRef);
					serverElement.addChild(serviceBeanElement);
					OMElement beanElement = factory.createOMElement(new QName("bean"));
					beanElement.addAttribute("id",s.getId().concat("Bean"),null);
					beanElement.addAttribute("class",s.getBeanClass(),null);
					documentElement.addChild(beanElement);
				}
				documentElement.addChild(serverElement);
			}
			return documentElement;
		}

		@Override
		protected String getDefaultName() {
			return null;
		}
		
		class JaxwsServer{
			private String id;
			private String serviceClass;
			private String address;
			private String beanClass;
			
			public void setId(String id) {
				this.id = id;
			}
			public String getId() {
				return id;
			}
			public void setServiceClass(String serviceClass) {
				this.serviceClass = serviceClass;
			}
			public String getServiceClass() {
				return serviceClass;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getAddress() {
				return address;
			}
			public void setBeanClass(String beanClass) {
				this.beanClass = beanClass;
			}
			public String getBeanClass() {
				return beanClass;
			}
			
		}
		
	}
	
}
