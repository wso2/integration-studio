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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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

public class DeployedServicesView extends ViewPart {
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String MI_LOGIN_API_URL= "https://localhost:9164/management/login";
    private static final String MI_API_API_URL= "https://localhost:9164/management/apis";
    private static final String MI_PROXY_API_URL= "https://localhost:9164/management/proxy-services";
    private static final String MI_DATASERVICES_API_URL= "https://localhost:9164/management/data-services";
    private static final String API_DETAILS_GET_PARAM= "apidetails";
    private static final String PROXY_DETAILS_GET_PARAM= "proxydetails";
    private static final String DATASERVICE_DETAILS_GET_PARAM= "dataservicedetails";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin";
    
    private Browser browser;
    private String accessToken;

    @Override
    public void createPartControl(Composite arg0) {
        browser = new Browser(arg0, SWT.NONE);

        try {
            generateAccessToken();
            String apiList = getDeployedServices(MI_API_API_URL);
            String proxyList = getDeployedServices(MI_PROXY_API_URL);
            String dataServiceList = getDeployedServices(MI_DATASERVICES_API_URL);
            browser.setUrl(getDefaultPage(apiList, proxyList, dataServiceList));
        } catch (Exception ex) {
            log.error("Failed to start deployed services page", ex);
        }

    }

    private String getDefaultPage(String apiList, String proxyList, String dataServiceList)
            throws URISyntaxException, IOException {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        String port = rootNode.get("portDetails", String.valueOf(FunctionServerConstants.EMBEDDED_SERVER_PORT));
        return "http://localhost:" + port + "/project/endpoints?" + API_DETAILS_GET_PARAM + "=" + apiList + "&"
                + PROXY_DETAILS_GET_PARAM + "=" + proxyList + "&" + DATASERVICE_DETAILS_GET_PARAM + "="
                + dataServiceList;
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }

    public void setURL(URL url) {
        browser.setUrl(url.toString());
    }
    
    private String generateAccessToken() throws IOException {
        URL url = new URL (MI_LOGIN_API_URL);
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
            System.out.println(obj.toString());
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
    

}
