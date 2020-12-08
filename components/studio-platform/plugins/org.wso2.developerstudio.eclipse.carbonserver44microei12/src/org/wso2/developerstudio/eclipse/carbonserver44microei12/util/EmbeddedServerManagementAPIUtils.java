/*
*  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.developerstudio.eclipse.carbonserver44microei12.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import net.consensys.cava.toml.Toml;
import net.consensys.cava.toml.TomlParseResult;

public class EmbeddedServerManagementAPIUtils {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String URL_PREFIX = "https://localhost:";
    private static final String MI_LOGIN_API_URL = "/management/login";

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin";

    public static String getDeployedServices(String port, String urlPostFix, String accessToken) throws IOException {
        URL urlrestapi = new URL(URL_PREFIX + port + urlPostFix);
        HttpsURLConnection connection = (HttpsURLConnection) urlrestapi.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);
        InputStream content = (InputStream) connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(content));
        String line;
        StringBuffer responseJson = new StringBuffer();
        while ((line = in.readLine()) != null) {
            responseJson.append(line);
        }
        return responseJson.toString();
    }

    private static void ignoreCertValidation() {
        // Add Null trust managers to avoid ssl checking
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            log.error("Could not add SSL trust manager", e);
        }
    }

    public static String generateAccessToken(String port) throws IOException {
        URL url = new URL(URL_PREFIX + port + MI_LOGIN_API_URL);
        String encoding = Base64.getEncoder().encodeToString((DEFAULT_USERNAME + ":" + DEFAULT_PASSWORD).getBytes());
        ignoreCertValidation();

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Basic " + encoding);
        InputStream content = (InputStream) connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(content));
        String line;
        StringBuffer responseJson = new StringBuffer();
        while ((line = in.readLine()) != null) {
            responseJson.append(line);
        }
        String accessToken = "";
        try {
            JSONObject obj = new JSONObject(responseJson.toString().trim());
            accessToken = obj.getString("AccessToken");
        } catch (JSONException e) {
            log.error("Could not parse recieved login json", e);
        }
        return accessToken;
    }

    public static int getOffset(int defaultValue) {
        String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
        try {
            String serverConfigDirectoryPath = workspace + File.separator + ".metadata" + File.separator
                    + "ServerConfigs";
            File serverConfigurationDirectory = new File(serverConfigDirectoryPath);
            String tomlFilePath = serverConfigDirectoryPath + File.separator + "deployment.toml";
            File customizedTomlFile = new File(tomlFilePath);
            if (serverConfigurationDirectory.exists() && customizedTomlFile.exists()) {
                TomlParseResult tomlResults = Toml.parse(Paths.get(tomlFilePath));
                Object offsetObject = tomlResults.get("server.offset");
                if (offsetObject != null) {
                    if (offsetObject instanceof String) {
                        return Integer.valueOf((String) offsetObject);
                    } else if (offsetObject instanceof Long) {
                        return ((Long) offsetObject).intValue();
                    }
                }
            }
        } catch (IOException e) {
            log.error("An error occured while backup default server configurations", e);
        }
        return defaultValue;
    }
}
