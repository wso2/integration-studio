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
package org.wso2.developerstudio.appfactory.core.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.eclipse.jgit.api.CreateBranchCommand;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;

public class RssClient {
	//private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
    public static String getDBinfo(String operation,String dsBaseUrl){
         String url = dsBaseUrl+"NDataSourceAdmin";
        DefaultHttpClient client = new DefaultHttpClient();
        client = (DefaultHttpClient) HttpsJaggeryClient.wrapClient(client,url);
        client.getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                new UsernamePasswordCredentials(Authenticator.getInstance().getCredentials().getUser()
                		, Authenticator.getInstance().getCredentials().getPassword()));

        // Generate BASIC scheme object and stick it to the execution context
        BasicScheme basicAuth = new BasicScheme();
        BasicHttpContext context = new BasicHttpContext();
        context.setAttribute("preemptive-auth", basicAuth);
        client.addRequestInterceptor(new PreemptiveAuth(), 0);

         HttpPost post = new HttpPost(url);
         String sopactionValue = "urn:"+operation;
         post.addHeader("SOAPAction", sopactionValue);
         String body = createPayLoad(operation);
         try {
         StringEntity entity = new StringEntity(body.toString(), "text/xml", HTTP.DEFAULT_CONTENT_CHARSET);
         post.setEntity(entity);
         HttpResponse response = client.execute(post);
         if(200==response.getStatusLine().getStatusCode()){
		      HttpEntity entityGetAppsOfUser = response.getEntity();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(entityGetAppsOfUser.getContent()));
		      StringBuilder sb = new StringBuilder();
		      String line ="";
		      while ((line = rd.readLine()) != null) {
		                  sb.append(line);
		            }
		    String  respond = sb.toString();
		    EntityUtils.consume(entityGetAppsOfUser);
		    return respond;
         }
        } catch (Exception e) {
       // log.error("Jenkins Client err", e);
        } 
		return null;
    }
    
    
    private static String createPayLoad(String param){
    	StringBuilder body = new StringBuilder();
    	  body.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"" +
           		" xmlns:xsd=\"http://org.apache.axis2/xsd\">");
           body.append("<soapenv:Header/>");
           body.append("<soapenv:Body>");
           body.append(" <xsd:"+param+"/>");
           body.append("</soapenv:Body>");
           body.append("</soapenv:Envelope>");
    	return body.toString();
    }
    
    

    /**
     * Preemptive authentication intercepter
     */
    static class PreemptiveAuth implements HttpRequestInterceptor {

        /*
           * (non-Javadoc)
           *
           * @see org.apache.http.HttpRequestInterceptor#process(org.apache.http.HttpRequest,
           * org.apache.http.protocol.HttpContext)
           */
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            // Get the AuthState
            AuthState authState = (AuthState) context.getAttribute(ClientContext.TARGET_AUTH_STATE);

            // If no auth scheme available yet, try to initialize it preemptively
            if (authState.getAuthScheme() == null) {
                AuthScheme authScheme = (AuthScheme) context.getAttribute("preemptive-auth");
                CredentialsProvider credsProvider = (CredentialsProvider) context
                        .getAttribute(ClientContext.CREDS_PROVIDER);
                HttpHost targetHost = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                if (authScheme != null) {
                    Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(), targetHost
                            .getPort()));
                    if (creds == null) {
                        throw new HttpException("No credentials for preemptive authentication");
                    }
                    authState.setAuthScheme(authScheme);
                    authState.setCredentials(creds);
                }
            }

        }

    }

}
