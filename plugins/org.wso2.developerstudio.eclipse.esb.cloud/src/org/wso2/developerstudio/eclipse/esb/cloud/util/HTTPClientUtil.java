/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.cloud.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.ResponseMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Handles HTTP calls
 *
 */
public class HTTPClientUtil {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Send HTTP GET request
     * 
     * @param url
     * @return
     * @throws NetworkUnavailableException
     * @throws HttpClientException
     */
    public String sendGet(String url) throws NetworkUnavailableException, HttpClientException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        StringBuffer result = new StringBuffer();

        HttpResponse response = null;
        try {
            response = client.execute(request);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (UnknownHostException | SocketException e) {
            log.error("No internet connection available!", e);
            throw new NetworkUnavailableException();
        } catch (IOException e) {
            throw new HttpClientException("An error occured while trying to send request!");
        }
        return result.toString();
    }

    /**
     * Send HTTP POST request with form data
     * 
     * @param url
     * @param headers
     * @param params
     * @param cookieStore
     * @return
     * @throws InvalidTokenException
     * @throws CloudDeploymentException
     * @throws NetworkUnavailableException
     * @throws HttpClientException
     */
    public static String sendPostWithFormData(String url, Map<String, String> headers, Map<String, String> params,
            CookieStore cookieStore)
            throws InvalidTokenException, CloudDeploymentException, NetworkUnavailableException, HttpClientException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringBuffer result = new StringBuffer();

        for (Map.Entry<String, String> header : headers.entrySet()) {
            post.setHeader(header.getKey(), header.getValue());
        }

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            urlParameters.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        post.setConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build());
        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpClientContext context = new HttpClientContext();

            context.setCookieStore(cookieStore);

            HttpResponse response = client.execute(post, context);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            cookieStore = context.getCookieStore();

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            handleResponseStatus(response.getStatusLine().getStatusCode(), result.toString());

        } catch (UnknownHostException | SocketException e) {
            log.error("No internet connection available!", e);
            throw new NetworkUnavailableException();
        } catch (IOException e) {
            throw new HttpClientException("An error occured while trying to send request!", e);
        }

        return result.toString();
    }

    /**
     * Send HTTP POST data with multipart form data
     * 
     * @param url
     * @param params
     * @param files
     * @param cookieStore
     * @return
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * @throws NetworkUnavailableException
     * @throws HttpClientException
     */
    public static String sendPostWithMulipartFormData(String url, Map<String, String> params, Map<String, String> files,
            CookieStore cookieStore)
            throws CloudDeploymentException, InvalidTokenException, NetworkUnavailableException, HttpClientException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        StringBuffer result = new StringBuffer();
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        try {

            for (Map.Entry<String, String> param : params.entrySet()) {
                builder.addTextBody(param.getKey(), param.getValue());
            }

            for (Map.Entry<String, String> file : files.entrySet()) {
                builder.addPart(file.getKey(), new FileBody(new File(file.getValue())));
            }

            HttpEntity entity = builder.build();
            post.setEntity(entity);

            HttpClientContext context = new HttpClientContext();
            context.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

            HttpResponse response = client.execute(post, context);

            BufferedReader rd1 = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line1 = "";
            while ((line1 = rd1.readLine()) != null) {
                result.append(line1);
            }

            handleResponseStatus(response.getStatusLine().getStatusCode(), result.toString());

        } catch (UnknownHostException | SocketException e) {
            log.error("No internet connection available!", e);
            throw new NetworkUnavailableException();
        } catch (IOException e) {
            throw new HttpClientException("An error occured while trying to send request!");
        }

        return result.toString();
    }

    /**
     * Handles error statuses
     * 
     * @param status
     * @param response
     * @throws InvalidTokenException
     * @throws CloudDeploymentException
     */
    private static void handleResponseStatus(int status, String response)
            throws InvalidTokenException, CloudDeploymentException {
        if (status == 401) {
            throw new InvalidTokenException(ResponseMessageConstants.ErrorMessages.AUTHENTICATION_FAILURE);
        } else if (status != 200) {
            throw new CloudDeploymentException(mapResponse(response));
        }
    }

    /**
     * Maps responses with status code 200 but indicates errors, to exception messages
     * 
     * @param response
     * @return response if there are no errors
     * @throws CloudDeploymentException
     */
    private static String mapResponse(String response) throws CloudDeploymentException {
        JsonParser parser = new JsonParser();
        JsonElement jsonResponse = parser.parse(response);
        return jsonResponse.getAsJsonObject().get("message").getAsString();
    }

}
