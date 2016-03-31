/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.Constants;
import org.apache.axis2.transport.http.HTTPConstants;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub;
import org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub.DeleteWebapp;
import org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub.UploadWebapp;
import org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub.WebappUploadData;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.ClientTrustStorePreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.utils.SSLUtils;

public class WebAppDeployer {

	private static IPreferencesService preferenceStore;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	static {
		preferenceStore = Platform.getPreferencesService();

		String clientTrustStoreLocation =
		                                  preferenceStore.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                            ClientTrustStorePreferencePage.TRUST_STORE_LOCATION,
		                                                            null, null);
		String clientTrustStoreType =
		                              preferenceStore.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                        ClientTrustStorePreferencePage.TRUST_STORE_TYPE, null,
		                                                        null);
		String clientTrustStorePassword =
		                                  preferenceStore.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                            ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD,
		                                                            null, null);

		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		if (clientTrustStoreLocation != null && clientTrustStorePassword != null &&
		    clientTrustStoreLocation.endsWith(".jks") && !clientTrustStorePassword.equals("")) {
			System.setProperty("javax.net.ssl.trustStore", clientTrustStoreLocation);
			System.setProperty("javax.net.ssl.trustStorePassword", clientTrustStorePassword);
		} else {
			System.setProperty("javax.net.ssl.trustStore", getJKSPath());
			System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
		}
	}

	private static String getJKSPath() {
		extractFilesToLocation("resources/security", new File(getMetaDataPath()));
		String path = getMetaDataPath() + File.separator + "security" + File.separator + "wso2carbon.jks";
		return path;
	}

	public static void extractFilesToLocation(String resourcePath, File destination) {
		URL resource = Activator.getDefault().getBundle().getResource(resourcePath);
		if (isResourceFolder(resource)) {
			Enumeration confFolder = Activator.getDefault().getBundle().getEntryPaths(resourcePath);
			String[] filePath = resource.getFile().split(File.separator);
			File newDestinationPath = new File(destination, filePath[filePath.length - 1]);
			newDestinationPath.mkdirs();
			while (confFolder != null && confFolder.hasMoreElements()) {
				String newResourcefile = confFolder.nextElement().toString();
				extractFilesToLocation(newResourcefile, newDestinationPath);
			}

		} else {
			copyResourceToDestination(resource, destination);
		}
	}

	private static boolean isResourceFolder(URL url) {
		boolean result = true;
		try {
			InputStream openStream = url.openStream();
			if (openStream.available() > 0)
				result = false;
			openStream.close();
		} catch (IOException e) {
			// error
		}
		return result;
	}

	private static void copyResourceToDestination(URL url, File destination) {
		String[] filePath = url.getFile().split(File.separator);
		File destinationFile = new File(destination, filePath[filePath.length - 1]);

		InputStream confOpenStream;
		try {
			confOpenStream = url.openStream();
			BufferedInputStream confBufferedInStream = null;
			confBufferedInStream = new BufferedInputStream(confOpenStream);
			FileOutputStream out = new FileOutputStream(destinationFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = confBufferedInStream.read(buf)) > 0) {
				out.write(buf, 0, len);//
			}

			confOpenStream.close();
			out.close();
		} catch (IOException e) {
			 log.error(e);
		}
	}

	public static String getMetaDataPath() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath location = root.getLocation();
		String metadataPath = location.toOSString() + File.separator + ".metadata";
		return metadataPath;
	}

	public void deployWebApp(String username, String pwd, String url, File warFile) throws AxisFault,
	                                                                               MalformedURLException, Exception {

		WebappAdminStub webappAdminStub = getWebappAdminStub(username, pwd, url);
		Options options = webappAdminStub._getServiceClient().getOptions();
		options.setProperty(Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);

		UploadWebapp uploadWebapp = new UploadWebapp();
		List<WebappUploadData> webappUploadDataList = new ArrayList<WebappUploadData>();
		DataHandler datahandler = new DataHandler(warFile.toURI().toURL());
		WebappUploadData tempData = new WebappUploadData();
		tempData.setFileName(warFile.getName());
		tempData.setDataHandler(datahandler);
		webappUploadDataList.add(tempData);
		uploadWebapp.setWebappUploadDataList(webappUploadDataList.toArray(new WebappUploadData[webappUploadDataList.size()]));
		webappAdminStub.uploadWebapp(uploadWebapp);
	}

	public void undeployWebApp(String username, String pwd, String url, String webappName) throws AxisFault,
	                                                                                      MalformedURLException,
	                                                                                      Exception {

		WebappAdminStub webappAdminStub = getWebappAdminStub(username, pwd, url);
		Options options = webappAdminStub._getServiceClient().getOptions();
		options.setProperty(Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);

		DeleteWebapp deleteWebApp = new DeleteWebapp();
		deleteWebApp.setWebappFileName(webappName);
		webappAdminStub.deleteWebapp(deleteWebApp);
	}

	private WebappAdminStub getWebappAdminStub(String username, String pwd, String url) throws Exception, AxisFault,
	                                                                                   MalformedURLException {

		String sessionCookie = CarbonServerUtils.createSessionCookie(url, username, pwd);
		WebappAdminStub webaapAdminStub =
		                                  new WebappAdminStub(CarbonServerUtils.getURL(url) + File.separator +
		                                                      CarbonServerUtils.getServicePath() + File.separator +
		                                                      "WebappAdmin");
		SSLUtils.setSSLProtocolHandler(webaapAdminStub);
		webaapAdminStub._getServiceClient().getOptions().setManageSession(true);
		webaapAdminStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return webaapAdminStub;
	}

}
