/* Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.appfactory.core.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.wso2.developerstudio.appfactory.core.Activator;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.core.model.ErrorType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class HttpsJaggeryClient {

    public static final String TIMEOUT_RESPONSE = "timeout";
    public static final String FALSE_RESPONSE = "false";
    public static  int soTimeout = 30000;
    private static int reTryDelay = 30000;
    
    private static final String COOKIE_HEADER = "Cookie";
    private static final String SET_COOKIE_HEADER = "Set-Cookie";
    private static final int STATUS_OK = 200;
    
    private static HttpClient httpClient;
    private static String sessionCookie;


    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    
    public static int getRetryDelay() {
		return reTryDelay;
	}

	public static void setRetryDelay(int retryDelay) {
		 if(retryDelay>0){
			 HttpsJaggeryClient.reTryDelay = retryDelay;
		 }
	}

	public static int getSotimeout(){     
    	return soTimeout;
    }
    
    public static void setSotimeout(int val){
        if(val>0){
        	soTimeout = val;
        }
   }

    public static String httpPostLogin(String postURL, Map<String, String> requestParams) {

        httpClient = new DefaultHttpClient();
        httpClient = HttpsJaggeryClient.wrapClient(httpClient, postURL);
        HttpPost postRequest = new HttpPost(postURL);
        String jsonResponse = "";
        HttpResponse postResponse = null;

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            Set<String> paramKeys = requestParams.keySet();

            for (String paramKey : paramKeys) {
                nameValuePairs.add(new BasicNameValuePair(paramKey, requestParams.get(paramKey)));
            }
            postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            postResponse = httpClient.execute(postRequest);

            if (STATUS_OK == postResponse.getStatusLine().getStatusCode()) {
                sessionCookie = postResponse.getFirstHeader(SET_COOKIE_HEADER).getValue().split(";")[0];
                HttpEntity entity = postResponse.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                StringBuilder responseBuilder = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                jsonResponse = responseBuilder.toString();
                if (FALSE_RESPONSE.equals(jsonResponse)) {
                    Authenticator.getInstance().setErrorcode(ErrorType.INVALID);
                }
                EntityUtils.consume(entity);
                if (entity != null) {
                    entity.getContent().close();
                }
            } else {
                Authenticator.getInstance().setErrorcode(ErrorType.FAILD);
                Authenticator.getInstance().setErrormsg(postResponse.getStatusLine().getReasonPhrase());
                log.error("(" + postResponse.getStatusLine().getStatusCode() + ")" + ":"
                        + postResponse.getStatusLine().getReasonPhrase());
                return FALSE_RESPONSE;
            }
        } catch (Exception e) {
            Authenticator.getInstance().setErrorcode(ErrorType.ERROR);
            log.error("Connection failure", e);
            return FALSE_RESPONSE;
        } finally {
            httpClient.getConnectionManager().closeExpiredConnections();
        }
        return jsonResponse;
    }

    public static String httpPost(String postURL, Map<String, String> requestParams) {
        if (httpClient == null) {
            httpPostLogin(postURL, requestParams);
        }
        HttpPost postRequest = new HttpPost(postURL);
        String jsonResponse = "";
        HttpResponse postResponse = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            Set<String> paramKeys = requestParams.keySet();
            for (String paramKey : paramKeys) {
                nameValuePairs.add(new BasicNameValuePair(paramKey, requestParams.get(paramKey)));
            }
            postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            if (sessionCookie != null) {
                postRequest.setHeader(COOKIE_HEADER, sessionCookie);
            }
            postResponse = httpClient.execute(postRequest);
            if (STATUS_OK == postResponse.getStatusLine().getStatusCode()) {
                HttpEntity entity = postResponse.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                StringBuilder responseBuilder = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                jsonResponse = responseBuilder.toString();
                if (FALSE_RESPONSE.equals(jsonResponse)) {
                    Authenticator.getInstance().setErrorcode(ErrorType.INVALID);
                }
                EntityUtils.consume(entity);
                if (entity != null) {
                    entity.getContent().close();
                }
            } else {
                Authenticator.getInstance().setErrorcode(ErrorType.FAILD);
                Authenticator.getInstance().setErrormsg(postResponse.getStatusLine().getReasonPhrase());
                log.error("(" + postResponse.getStatusLine().getStatusCode() + ")" + ":"
                        + postResponse.getStatusLine().getReasonPhrase());
                return FALSE_RESPONSE;
            }
        } catch (Exception e) {
            Authenticator.getInstance().setErrorcode(ErrorType.ERROR);
            log.error("Connection failure", e);
            return FALSE_RESPONSE;
        } finally {
            httpClient.getConnectionManager().closeExpiredConnections();
        }
        return jsonResponse;
    }
    
    public static String httpPostWithSoTimeout(String postURL, Map<String, String> requestParams, int socketTimeout){
        if (httpClient == null) {
            httpPostLogin(postURL, requestParams);
        }
        httpClient.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, socketTimeout);
        HttpPost postRequest = new HttpPost(postURL);
        String jsonResponse = "";
        HttpResponse postResponse = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            Set<String> paramKeys = requestParams.keySet();
            for (String paramKey : paramKeys) {
                nameValuePairs.add(new BasicNameValuePair(paramKey, requestParams.get(paramKey)));
            }
            postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            if (sessionCookie != null) {
                postRequest.setHeader(COOKIE_HEADER, sessionCookie);
            }
            postResponse = httpClient.execute(postRequest);
            if (STATUS_OK == postResponse.getStatusLine().getStatusCode()) {
                HttpEntity entity = postResponse.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                StringBuilder responseBuilder = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                jsonResponse = responseBuilder.toString();
                if (FALSE_RESPONSE.equals(jsonResponse)) {
                    Authenticator.getInstance().setErrorcode(ErrorType.INVALID);
                }
                EntityUtils.consume(entity);
                if (entity != null) {
                    entity.getContent().close();
                }
            } else {
                Authenticator.getInstance().setErrorcode(ErrorType.FAILD);
                Authenticator.getInstance().setErrormsg(postResponse.getStatusLine().getReasonPhrase());
                log.error("(" + postResponse.getStatusLine().getStatusCode() + ")" + ":"
                        + postResponse.getStatusLine().getReasonPhrase());
                return FALSE_RESPONSE;
            }
        } catch (SocketTimeoutException e) {
            log.error("Connection failure due to socket timeout.", e);
            return TIMEOUT_RESPONSE;   
        } catch (Exception e) {
            Authenticator.getInstance().setErrorcode(ErrorType.ERROR);
            log.error("Connection failure", e);
            return FALSE_RESPONSE;
        } finally {
            httpClient.getConnectionManager().closeExpiredConnections();
        }
        return jsonResponse;
    }

    public static BufferedReader getPostResponseBuffer(String postURL, Map<String, String> requestParams) {
        if (httpClient == null) {
            httpPostLogin(postURL, requestParams);
        }
        HttpPost postRequest = new HttpPost(postURL);
        HttpResponse jsonResponse = null;
        BufferedReader reader = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            Set<String> paramKeys = requestParams.keySet();
            for (String paramKey : paramKeys) {
                nameValuePairs.add(new BasicNameValuePair(paramKey, requestParams.get(paramKey)));
            }
            postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            if (sessionCookie != null) {
                postRequest.setHeader(COOKIE_HEADER, sessionCookie);
            }
            jsonResponse = httpClient.execute(postRequest);
            if (STATUS_OK == jsonResponse.getStatusLine().getStatusCode()) {
                HttpEntity entity = jsonResponse.getEntity();
                reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            }
        } catch (Exception e) {
            Authenticator.getInstance().setErrorcode(ErrorType.ERROR);
            log.error("Connection failure", e);
            return null;
        } finally {
            httpClient.getConnectionManager().closeExpiredConnections();
        }
        return reader;
    }

    @SuppressWarnings("deprecation")
    public static HttpClient wrapClient(HttpClient base, String urlStr) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            ClientConnectionManager ccm = new ThreadSafeClientConnManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            URL url = new URL(urlStr);
            int port = url.getPort();
            if (port == -1) {
                port = 443;
            }
            String protocol = url.getProtocol();
            if ("https".equals(protocol)) {
                if (port == -1) {
                    port = 443;
                }
            } else if ("http".equals(protocol)) {
                if (port == -1) {
                    port = 80;
                }
            }
            sr.register(new Scheme(protocol, ssf, port));

            return new DefaultHttpClient(ccm, base.getParams());
        } catch (Throwable ex) {
            ex.printStackTrace();
            log.error("Trust Manager Error", ex);
            return null;
        }
    }
}
