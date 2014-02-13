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

package org.wso2.developerstudio.appfactory.core.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.http.HttpResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.appfactory.core.Activator;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.core.client.HttpsJaggeryClient;
import org.wso2.developerstudio.appfactory.core.client.RssClient;
import org.wso2.developerstudio.appfactory.core.jag.api.JagApiProperties;
import org.wso2.developerstudio.appfactory.core.model.AppVersionInfo;
import org.wso2.developerstudio.appfactory.core.model.ApplicationInfo;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 

public class AppListModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
		public List<ApplicationInfo> getCategories(List<ApplicationInfo> apps) {
			// TODO  can do changes to default model
		for (ApplicationInfo applicationInfo : apps) {
			/*Currently API doesn't provide the app owner information*/
			applicationInfo.setApplicationOwner(Authenticator.getInstance().getCredentials().getUser());
		}
	    return apps;
	  }

	public boolean setversionInfo(ApplicationInfo applicationInfo) {
		String respond = "";
		/* Getting version information */
		Map<String, String> params = new HashMap<String, String>();
		params.put("action", JagApiProperties.App_NIFO_ACTION);
		params.put("stageName", "Development");
		params.put("userName", Authenticator.getInstance().getCredentials()
				.getUser());
		params.put("applicationKey", applicationInfo.getKey());
		respond = HttpsJaggeryClient.httpPost(JagApiProperties.getAppInfoUrl(),
				params);
		if ("false".equals(respond)) {
			return false;
		} else {
			JsonElement jelement = new JsonParser().parse(respond);
			JsonElement jsonElement = jelement.getAsJsonArray().get(0)
					.getAsJsonObject().get("versions");
			JsonArray infoArray = jsonElement.getAsJsonArray();
			ArrayList<AppVersionInfo> appVersionList = new ArrayList<AppVersionInfo>();
			for (JsonElement jsonElement2 : infoArray) {
				JsonObject asJsonObject = jsonElement2.getAsJsonObject();
				Gson gson = new Gson();
				AppVersionInfo version = gson.fromJson(asJsonObject,
						AppVersionInfo.class);
				version.setAppName(applicationInfo.getKey());
				version.setLocalRepo(applicationInfo.getLocalrepoLocation());
				appVersionList.add(version);
			}
			applicationInfo.setAppVersionList(appVersionList);
			return true;
		}
	}

	public boolean setRoleInfomation(ApplicationInfo applicationInfo) {
		String respond;
		Map<String, String> params;
		JsonElement jelement;
		params = new HashMap<String, String>();
		params.put("action", JagApiProperties.App_USERS_ROLES_ACTION);
		params.put("applicationKey", applicationInfo.getKey());
		respond = HttpsJaggeryClient.httpPost(
				JagApiProperties.getAppUserRolesUrlS(), params);
		if ("false".equals(respond)) {
			return false;
		} else {
			jelement = new JsonParser().parse(respond);
			JsonArray infoArray2 = jelement.getAsJsonArray();
			ArrayList<AppUserInfo> appUserList = new ArrayList<AppUserInfo>();
			for (JsonElement jsonElement3 : infoArray2) {
				JsonObject asJsonObject = jsonElement3.getAsJsonObject();
				Gson gson = new Gson();
				AppUserInfo user = gson.fromJson(asJsonObject, AppUserInfo.class);
				appUserList.add(user);
			}
			applicationInfo.setApplicationDevelopers(appUserList);
			return true;
		}
	}
	
 
	public boolean setDSInfomation(ApplicationInfo applicationInfo) {
		String respond;
		Map<String, String> params;
		params = new HashMap<String, String>();
		params.put("action", JagApiProperties.App_DS_INFO_ACTION);
		params.put("stage", "Development");
		respond = HttpsJaggeryClient.httpPost(
				JagApiProperties.getAppDsInfoUrl(), params);
		if ("false".equals(respond)) {
			return false;
		} else {
			RssClient.getDBinfo("reloadAllDataSources", respond);
			String dsinfo = RssClient.getDBinfo("getAllDataSources", respond);
			if (dsinfo == null) {
				return false;
			}
			try {
				List<DataSource> dsModels = new ArrayList<DataSource>();
				InputStream is = new ByteArrayInputStream(dsinfo.getBytes());
				SOAPMessage msg = MessageFactory.newInstance().createMessage(null, is);
				SOAPBody soapBody = msg.getSOAPBody();

				SOAPElement allDataSources = (SOAPElement) soapBody.getFirstChild();
				@SuppressWarnings("unchecked")
				Iterator<SOAPElement> dsList = allDataSources.getChildElements();
				while (dsList.hasNext()) {
					SOAPElement element = dsList.next();
					SOAPElement isactive = (SOAPElement) element.getLastChild().getLastChild();
					if ("ACTIVE".equalsIgnoreCase(isactive.getValue())) {
						try {
							DataSource dsModel = new DataSource();
							//SOAPElement reInfo = (SOAPElement) element;
							SOAPElement dsMetaInfo = (SOAPElement)element.getFirstChild();
							SOAPElement dsName = (SOAPElement) dsMetaInfo
									.getElementsByTagNameNS( "http://services.core.ndatasource.carbon.wso2.org/xsd",
											"name").item(0);
							dsModel.setName(dsName.getValue());
							SOAPElement dsDefinition = (SOAPElement) dsMetaInfo.getFirstChild();
							SOAPElement dsType = (SOAPElement) dsDefinition
									.getElementsByTagNameNS(
											"http://services.core.ndatasource.carbon.wso2.org/xsd",
											"type").item(0);
							dsModel.setType(dsType.getValue());
							SOAPElement dsXMLConfiguration = (SOAPElement) dsDefinition
									.getFirstChild();
							Map<String, String> dbconfig = new HashMap<String, String>();
							String xmlSource = dsXMLConfiguration.getValue();

							DocumentBuilderFactory factory = DocumentBuilderFactory
									.newInstance();
							DocumentBuilder builder = factory
									.newDocumentBuilder();
							Document doc = builder.parse(new InputSource(
									new StringReader(xmlSource)));
							Node firstChild = doc.getFirstChild();
							NodeList childNodes = firstChild.getChildNodes();
							for (int temp = 0; temp < childNodes.getLength(); temp++) {
								Node nNode = childNodes.item(temp);
								Element eElement = (Element) nNode;
								dbconfig.put(eElement.getNodeName(),
										eElement.getTextContent());
							}
							dsModel.setConfig(dbconfig);
							dsModels.add(dsModel);
						} catch (Exception e) {
							log.error("DataSource Response msg processing error",e);
						}

					}
				}

				applicationInfo.setDatasources(dsModels);
			} catch (IOException e) {
				return false;

			} catch (SOAPException e) {
				return false;
			}
		}
		return true;
	}
	
	public boolean setDBInfomation(ApplicationInfo applicationInfo) {
		String respond;
		Map<String, String> params;
		JsonElement jelement;
		params = new HashMap<String, String>();
		params.put("action", JagApiProperties.App_DB_INFO_ACTION);
		params.put("applicationKey", applicationInfo.getKey());
		respond = HttpsJaggeryClient.httpPost(
				JagApiProperties.getAppUserDbInfoUrl(), params);
		if ("false".equals(respond)) {
			return false;
		} else {
			jelement = new JsonParser().parse(respond);
			JsonArray infoArray2 = jelement.getAsJsonArray();
			ArrayList<AppDBinfo> appDbList = new ArrayList<AppDBinfo>();
			for (JsonElement jsonElement3 : infoArray2) {
				JsonObject asJsonObject = jsonElement3.getAsJsonObject();
				String stage = asJsonObject.get("stage").getAsString();
				if("Development".equals(stage)){
					AppDBinfo appDBinfo = new AppDBinfo();
					JsonArray dbArray = asJsonObject.get("dbs").getAsJsonArray();
					List<Map<String,String>> dbs = new ArrayList<Map<String,String>>();
					for (JsonElement jsonElement : dbArray) {
						 HashMap<String, String> dbInfo = new HashMap<String, String>();
						 dbInfo.put("dbName",jsonElement.getAsJsonObject().get("dbName").getAsString());
						 dbInfo.put("url",jsonElement.getAsJsonObject().get("url").getAsString());
						 dbs.add(dbInfo);
					}
					appDBinfo.setDbs(dbs);
					JsonArray dbusers = asJsonObject.get("users").getAsJsonArray();
					List<String> usr = new ArrayList<String>();
					for (JsonElement jsonElement : dbusers) {
						usr.add(jsonElement.getAsJsonObject().get("name").getAsString());
					}
					appDBinfo.setUsr(usr);
					JsonArray dbtemplates = asJsonObject.get("templates").getAsJsonArray();
					List<String> temple = new ArrayList<String>();
					for (JsonElement jsonElement : dbtemplates) {
						temple.add(jsonElement.getAsJsonObject().get("name").getAsString());
					}
					appDBinfo.setUsr(temple);
					appDbList.add(appDBinfo);
				}
			}
			applicationInfo.setDatabases(appDbList);
			return true;
		}
	}
	
}
