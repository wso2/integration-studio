/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.project.ui.view;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.servlets.FunctionServerConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import net.consensys.cava.toml.Toml;
import net.consensys.cava.toml.TomlParseResult;

public class DeployedServicesView extends ViewPart {
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String URL_PREFIX = "https://localhost:";
    private static final String MI_LOGIN_API_URL = "/management/login";
    private static final String MI_API_API_URL = "/management/apis";
    private static final String MI_PROXY_API_URL = "/management/proxy-services";
    private static final String MI_DATASERVICES_API_URL = "/management/data-services";
    private static final String API_DETAILS_GET_PARAM = "apidetails";
    private static final String PROXY_DETAILS_GET_PARAM = "proxydetails";
    private static final String DATASERVICE_DETAILS_GET_PARAM = "dataservicedetails";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin";
    private static final String DEP_SERVICES_PROPERTIES_PATH = ResourcesPlugin.getWorkspace().getRoot().getLocation()
            .toOSString() + File.separator + ".metadata" + File.separator + "deployed_services.properties";
    private static final String NO_CACHE = "&nocache=1";

    private Browser browser;
    private String accessToken;
    private int offSet = 10;

    @Override
    public void createPartControl(Composite arg0) {
        browser = new Browser(arg0, SWT.NONE);
        String apiList = null;
        String proxyList = null;
        String dataServiceList = null;
        try {
            setOffset();
            generateAccessToken();
            apiList = getDeployedServices(URL_PREFIX + getManagamentAPIPort() + MI_API_API_URL);
        } catch (Exception e) {
            log.error("Failed to fetch API information from the management API", e);
        }
        try {
            proxyList = getDeployedServices(URL_PREFIX + getManagamentAPIPort() + MI_PROXY_API_URL);
        } catch (Exception e) {
            log.error("Failed to fetch proxy information from the management API", e);
        }
        try {
            dataServiceList = getDeployedServices(URL_PREFIX + getManagamentAPIPort() + MI_DATASERVICES_API_URL);
        } catch (Exception e) {
            log.error("Failed to fetch data service information from the management API", e);
        }
        try {
            updateDeployedServicesMetadata(apiList, proxyList, dataServiceList);
            browser.setUrl(getDefaultPage(apiList, proxyList, dataServiceList));
        } catch (Exception ex) {
            log.error("Failed to start deployed services page", ex);
        }

    }

    private String getDefaultPage(String apiList, String proxyList, String dataServiceList)
            throws URISyntaxException, IOException {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        String port = rootNode.get("portDetails", String.valueOf(FunctionServerConstants.EMBEDDED_SERVER_PORT));
        return "http://127.0.0.1:" + port + "/project/endpoints?" + API_DETAILS_GET_PARAM + "=" + apiList + "&"
                + PROXY_DETAILS_GET_PARAM + "=" + proxyList + "&" + DATASERVICE_DETAILS_GET_PARAM + "="
                + dataServiceList + "&port=" + port + NO_CACHE;
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }

    public void setURL(URL url) {
        browser.setUrl(url.toString() + NO_CACHE);
    }
    
    private String generateAccessToken() throws IOException {
        URL url = new URL (URL_PREFIX + getManagamentAPIPort() + MI_LOGIN_API_URL);
        String encoding = Base64.getEncoder().encodeToString((DEFAULT_USERNAME + ":" + DEFAULT_PASSWORD).getBytes());
        ignoreCertValidation();
        
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Basic " + encoding);
        InputStream content = (InputStream)connection.getInputStream();
        BufferedReader in   = 
            new BufferedReader (new InputStreamReader (content));
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
        setAccessToken(accessToken);
        return accessToken;
    }

    private void ignoreCertValidation() {
        //Add Null trust managers to avoid ssl checking
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};
         
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            log.error("Could not add SSL trust manager", e);
        }
    }  

    private String getDeployedServices(String URLString) throws IOException {
        URL urlrestapi = new URL (URLString);
        HttpsURLConnection connection = (HttpsURLConnection) urlrestapi.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer " + getAccessToken());
        InputStream content = (InputStream)connection.getInputStream();
        BufferedReader in  = 
            new BufferedReader (new InputStreamReader (content));
        String line;
        StringBuffer responseJson = new StringBuffer();
        while ((line = in.readLine()) != null) {
            responseJson.append(line);
        }
        
        return responseJson.toString();
    }
    
    private void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String getAccessToken() {
        return accessToken;
    }
    
    private int getOffSet() {
        return this.offSet;
    }

    private void setOffset() {
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
                        this.offSet = Integer.valueOf((String) offsetObject);
                    } else if (offsetObject instanceof Long) {
                        this.offSet = ((Long) offsetObject).intValue();
                    }
                }
            }
        } catch (IOException e) {
            log.error("An error occured while backup default server configurations", e);
        }
    }

    private String getManagamentAPIPort() {
        return String.valueOf(9154 + getOffSet());
    }

    private void updateDeployedServicesMetadata(String apiList, String proxyList, String dataServiceList) {
        Properties properties = new Properties();
        if (apiList != null) {
            properties.setProperty("deployed.md5sum.api", DigestUtils.md5Hex(apiList));
        }
        if (proxyList != null) {
            properties.setProperty("deployed.md5sum.proxy", DigestUtils.md5Hex(proxyList));
        }
        if (dataServiceList != null) {
            properties.setProperty("deployed.md5sum.dataservice", DigestUtils.md5Hex(dataServiceList));
        }
        try (OutputStream outputStream = new FileOutputStream(DEP_SERVICES_PROPERTIES_PATH)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            log.error("Error while writing to the conf.properties file.", e);
        }
    }
}
