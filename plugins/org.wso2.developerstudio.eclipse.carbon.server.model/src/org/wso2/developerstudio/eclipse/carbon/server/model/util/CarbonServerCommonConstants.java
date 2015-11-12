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

package org.wso2.developerstudio.eclipse.carbon.server.model.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.carbonfeatures.Activator;

public class CarbonServerCommonConstants {

	private static String ESB_TRANSPORT_HTTP = "esb.transport.http";
	private static String ESB_TRANSPORT_HTTPS = "esb.transport.https";
	private static String ESB_CONSOLE_HTTPS = "esb.https";

	// If the following 3 final variables are changed, please update the
	private static String ESB_TRANSPORT_HTTP_DESC = "ESB transport http";
	private static String ESB_TRANSPORT_HTTPS_DESC = "ESB transport https";
	private static String ESB_CONSOLE_HTTPS_DESC = "ESB console port";

	private static String ESB_ORIGINAL_TRANSPORT_HTTP = "esb.original.transport.http";
	private static String ESB_ORIGINAL_TRANSPORT_HTTPS = "esb.original.transport.https";

	private static String ESB_USERNAME = "esb.username";
	private static String ESB_PASSWORD = "esb.password";

	public static String[] getStringArrayFromProprties(String bundleID, String libPrefixes) {
		List<String> arrayList = getListFromPropertiesFile(bundleID, libPrefixes);
		String[] strArrayProperty = (String[]) arrayList.toArray();
		return strArrayProperty;
	}

	public static List<String> getPortcaptions(String bundleID) {
		return getListFromPropertiesFile(bundleID, "portCaptions");
	}

	public static List<String> getPortids(String bundleID) {
		return getListFromPropertiesFile(bundleID, "portIds");
	}

	private static List<String> getListFromPropertiesFile(String bundleID, String propKey) {
		Properties prop;
		List<String> propList = new ArrayList<String>();
		if (bundleID != null) {
			try {
				prop = readFromPropertiesFile(bundleID);
				String[] portCaptionsArray = prop.getProperty(propKey).split(",");
				propList = Arrays.asList(portCaptionsArray);
			} catch (IOException e) {
				// log error
			}
		}
		return propList;
	}

	public static String getEsbTransportHttp() {
		return ESB_TRANSPORT_HTTP;
	}

	public static String getEsbTransportHttps() {
		return ESB_TRANSPORT_HTTPS;
	}

	public static String getEsbConsoleHttps() {
		return ESB_CONSOLE_HTTPS;
	}

	public static String getEsbTransportHttpDesc() {
		return ESB_TRANSPORT_HTTP_DESC;
	}

	public static String getEsbTransportHttpsDesc() {
		return ESB_TRANSPORT_HTTPS_DESC;
	}

	public static String getEsbConsoleHttpsDesc() {
		return ESB_CONSOLE_HTTPS_DESC;
	}

	public static String getEsbOriginalTransportHttp() {
		return ESB_ORIGINAL_TRANSPORT_HTTP;
	}

	public static String getEsbOriginalTransportHttps() {
		return ESB_ORIGINAL_TRANSPORT_HTTPS;
	}

	public static String getEsbUsername() {
		return ESB_USERNAME;
	}

	public static String getEsbPassword() {
		return ESB_PASSWORD;
	}

	public static String getCarbonVersion(String bundleID) {
		return getPropertyFromFile(bundleID, "CARBON_VERSION");
	}

	public static String getCatalinaXpathExpressionForSslEnabledPort(String bundleID) {
		return getPropertyFromFile(bundleID, "CATALINA_XPATH_EXPRESSION_FOR_SSL_ENABLED_PORT");
	}

	public static String getAnyFileUploaderUrl(String bundleID) {
		return getPropertyFromFile(bundleID, "ANY_FILE_UPLOADER_URL");
	}

	public static String getToolsFileUploaderUrl(String bundleID) {
		return getPropertyFromFile(bundleID, "TOOLS_FILE_UPLOADER_URL");
	}

	public static String getValidatorFileUploaderUrl(String bundleID) {
		return getPropertyFromFile(bundleID, "VALIDATOR_FILE_UPLOADER_URL");
	}

	public static String getToolsAnyFileUploadUrl(String bundleID) {
		return getPropertyFromFile(bundleID, "TOOLS_ANY_FILE_UPLOAD_URL");
	}

	private static String getPropertyFromFile(String bundleID, String propKey) {
		Properties prop;
		String propVal = null;
		if (bundleID != null) {
			try {
				prop = readFromPropertiesFile(bundleID);
				propVal = prop.getProperty(propKey);
			} catch (IOException e) {
				// log error
			}
		}
		return propVal;
	}

	public static Properties readFromPropertiesFile(String bundleID) throws IOException {
		Properties prop = new Properties();
		if (bundleID == null) {
			bundleID = Activator.PLUGIN_ID;
		}
		Bundle bundle = Platform.getBundle(bundleID);
		URL fileURL = bundle.getEntry("resources/server.properties");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = fileURL.openConnection().getInputStream();
		prop.load(stream);

		return prop;
	}

}
