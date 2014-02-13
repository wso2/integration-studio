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
	
import java.io.IOException;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.wso2.developerstudio.appfactory.core.Activator;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

	/**
	 * Simple class to launch a jenkins build on run@Cloud platform, should also work on every jenkins instance (not tested)
	 */
	public class HttpsJenkinsClient {
		private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	    public static HttpResponse getBulildinfo(String applicationId,String version,String builderBaseUrl,int lastBuildNo){
 
	        DefaultHttpClient client = new DefaultHttpClient();
	        client = (DefaultHttpClient) HttpsJaggeryClient.wrapClient(client,builderBaseUrl);
	        client.getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
	                new UsernamePasswordCredentials(Authenticator.getInstance().getCredentials().getUser()
	                		, Authenticator.getInstance().getCredentials().getPassword()));

	        // Generate BASIC scheme object and stick it to the execution context
	        BasicScheme basicAuth = new BasicScheme();
	        BasicHttpContext context = new BasicHttpContext();
	        context.setAttribute("preemptive-auth", basicAuth);

	        // Add as the first (because of the zero) request interceptor
	        // It will first intercept the request and preemptively initialize the authentication scheme if there is not
	        client.addRequestInterceptor(new PreemptiveAuth(), 0);
	        String getUrl =   builderBaseUrl + "/job/" + applicationId + "-" + version + "-default/" + lastBuildNo + "/consoleText";
	        HttpGet get = new HttpGet(getUrl);

	        try {
	            // Execute your request with the given context
	            HttpResponse response = client.execute(get, context);
	            return response;
	        } catch (Exception e) {
	        log.error("Jenkins Client err", e);
	        } 
			return null;
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
