/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.developerstudio.eclipse.apim.endpoint.central.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.contrib.ssl.EasySSLProtocolSocketFactory;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.Activator;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.EndpointRegistryConnectException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointRegistryServiceConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Handles HTTP calls.
 */
public class HTTPClientUtil {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Send a simple get request.
     * 
     * @param url target url
     * @param headers request headers
     * @return response message
     * @throws InvalidTokenException auth failures
     * @throws HttpClientException request failures
     * @throws EndpointRegistryConnectException connection failures
     */
    public static String sendGet(String url, Map<String, String> headers)
            throws InvalidTokenException, HttpClientException, EndpointRegistryConnectException {
        try {
            // Discard SSL certificate
            Protocol easyhttps = new Protocol(EndpointRegistryServiceConstants.Common.HTTPS,
                    (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol(EndpointRegistryServiceConstants.Common.HTTPS, easyhttps);

            // Initialize client and method
            HttpClient client = new HttpClient();
            GetMethod getMethod = new GetMethod(url);
            String response;

            // set headers
            for (Map.Entry<String, String> header : headers.entrySet()) {
                getMethod.addRequestHeader(header.getKey(), header.getValue());
            }
            int statusCode = client.executeMethod(getMethod);

            // build response
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet()));
            String line = EndpointRegistryServiceConstants.Common.EMPTY_STRING;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            response = result.toString();
            handleResponseStatus(statusCode, response);
            return response;
        } catch (UnknownHostException | SocketException e) {
            log.error(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
            throw new EndpointRegistryConnectException(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
        } catch (IOException | GeneralSecurityException e) {
            throw new HttpClientException(EndpointRegistryServiceConstants.Errors.HTTP_ERROR_SENDING_REQUEST, e);
        }
    }

    /**
     * Send a Get request with url encoded parameters.
     * 
     * @param url target url
     * @param headers request headers
     * @param data parameters to set
     * @return response message
     * @throws InvalidTokenException auth failures
     * @throws HttpClientException request failures
     * @throws EndpointRegistryConnectException connection failures
     */
    public static String sendGetWithParams(String url, Map<String, String> headers, Map<String, String> data)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        try {
            // Discard SSL certificate
            Protocol easyhttps = new Protocol(EndpointRegistryServiceConstants.Common.HTTPS,
                    (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol(EndpointRegistryServiceConstants.Common.HTTPS, easyhttps);

            // Initialize client and method
            HttpClient client = new HttpClient();
            GetMethod getMethod = new GetMethod(url);
            String response;

            // set headers
            for (Map.Entry<String, String> header : headers.entrySet()) {
                getMethod.addRequestHeader(header.getKey(), header.getValue());
            }
            getMethod.addRequestHeader(EndpointRegistryServiceConstants.HEADERS.CONTENT_TYPE,
                    EndpointRegistryServiceConstants.HEADERS.APPLICATION_FORM_URL_ENCODED);

            // set parameters
            NameValuePair[] parameters = new NameValuePair[data.size()];
            int index = 0;
            for (Map.Entry<String, String> param : data.entrySet()) {
                parameters[index] = new NameValuePair(param.getKey(), param.getValue());
                index++;
            }
            getMethod.setQueryString(parameters);

            // Send request
            int statusCode = client.executeMethod(getMethod);

            // build response
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet()));
            String line = EndpointRegistryServiceConstants.Common.EMPTY_STRING;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            response = result.toString();
            handleResponseStatus(statusCode, response);
            return response;
        } catch (UnknownHostException | SocketException e) {
            log.error(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
            throw new EndpointRegistryConnectException(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
        } catch (IOException | GeneralSecurityException e) {
            throw new HttpClientException(EndpointRegistryServiceConstants.Errors.HTTP_ERROR_SENDING_REQUEST, e);
        }
    }

    /**
     * Send a POST request with JSON payload.
     * 
     * @param url target url
     * @param headers request headers
     * @param json payload
     * @return response message
     * @throws InvalidTokenException auth failures
     * @throws HttpClientException request failures
     * @throws EndpointRegistryConnectException connection failures
     */
    public static String sendPostWithJsonPayload(String url, Map<String, String> headers, String json)
            throws InvalidTokenException, EndpointRegistryConnectException, HttpClientException {
        try {
            // Discard SSL certificate
            Protocol easyhttps = new Protocol(EndpointRegistryServiceConstants.Common.HTTPS,
                    (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol(EndpointRegistryServiceConstants.Common.HTTPS, easyhttps);

            // Initialize client and method
            HttpClient client = new HttpClient();
            PostMethod postMethod = new PostMethod(url);
            String response;

            // set headers
            for (Map.Entry<String, String> header : headers.entrySet()) {
                postMethod.addRequestHeader(header.getKey(), header.getValue());
            }
            StringRequestEntity requestEntity = new StringRequestEntity(json,
                    EndpointRegistryServiceConstants.HEADERS.APPLICATION_JSON,
                    EndpointRegistryServiceConstants.HEADERS.UTF_8);
            postMethod.setRequestEntity(requestEntity);
            int statusCode = client.executeMethod(postMethod);

            // build response
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(postMethod.getResponseBodyAsStream(), postMethod.getResponseCharSet()));
            String line = EndpointRegistryServiceConstants.Common.EMPTY_STRING;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            response = result.toString();
            handleResponseStatus(statusCode, response);
            return response;
        } catch (UnknownHostException | SocketException e) {
            log.error(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
            throw new EndpointRegistryConnectException(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
        } catch (IOException | GeneralSecurityException e) {
            throw new HttpClientException(EndpointRegistryServiceConstants.Errors.HTTP_ERROR_SENDING_REQUEST, e);
        }
    }

    /**
     * Send a POST request with url encoded data.
     * 
     * @param url target url
     * @param headers request headers
     * @param data data to encode
     * @return response message
     * @throws InvalidTokenException auth failures
     * @throws HttpClientException request failures
     * @throws URISyntaxException
     * @throws EndpointRegistryConnectException connection failures
     */
    public static String sendPostWithFormData(String url, Map<String, String> headers, Map<String, String> data)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        try {
            // Discard SSL certificate
            Protocol easyhttps = new Protocol(EndpointRegistryServiceConstants.Common.HTTPS,
                    (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol(EndpointRegistryServiceConstants.Common.HTTPS, easyhttps);

            // Initialize client and method
            HttpClient client = new HttpClient();
            PostMethod postMethod = new PostMethod(url);
            String response;

            // set headers
            for (Map.Entry<String, String> header : headers.entrySet()) {
                postMethod.addRequestHeader(header.getKey(), header.getValue());
            }
            postMethod.addRequestHeader(EndpointRegistryServiceConstants.HEADERS.CONTENT_TYPE,
                    EndpointRegistryServiceConstants.HEADERS.APPLICATION_FORM_URL_ENCODED);

            // set parameters
            NameValuePair[] parameters = new NameValuePair[data.size()];
            int index = 0;
            for (Map.Entry<String, String> param : data.entrySet()) {
                parameters[index] = new NameValuePair(param.getKey(), param.getValue());
                index++;
            }
            postMethod.setQueryString(parameters);
            int statusCode = client.executeMethod(postMethod);

            // build response
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(postMethod.getResponseBodyAsStream(), postMethod.getResponseCharSet()));
            String line = EndpointRegistryServiceConstants.Common.EMPTY_STRING;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            response = result.toString();
            handleResponseStatus(statusCode, response);
            return response;
        } catch (UnknownHostException | SocketException e) {
            log.error(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
            throw new EndpointRegistryConnectException(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
        } catch (IOException | GeneralSecurityException e) {
            throw new HttpClientException(EndpointRegistryServiceConstants.Errors.HTTP_ERROR_SENDING_REQUEST, e);
        }
    }

    /**
     * Send a POST request with multi-part form data.
     * 
     * @param url target url
     * @param headers request headers
     * @param params JSONs to send
     * @param files files to send
     * @return response message
     * @throws InvalidTokenException auth failures
     * @throws HttpClientException request failures
     * @throws EndpointRegistryConnectException connection failures
     */
    public static String sendPostWithMulipartFormData(String url, Map<String, String> headers,
            Map<String, String> params, Map<String, String> files)
            throws InvalidTokenException, HttpClientException, EndpointRegistryConnectException {
        try {
            // Discard SSL certificate
            Protocol easyhttps = new Protocol(EndpointRegistryServiceConstants.Common.HTTPS,
                    (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol(EndpointRegistryServiceConstants.Common.HTTPS, easyhttps);

            // Initialize client and method
            HttpClient client = new HttpClient();
            MultipartPostMethod postMethod = new MultipartPostMethod(url);
            String response;

            // set headers
            for (Map.Entry<String, String> header : headers.entrySet()) {
                postMethod.addRequestHeader(header.getKey(), header.getValue());
            }
            postMethod.addRequestHeader(EndpointRegistryServiceConstants.HEADERS.ACCEPT,
                    EndpointRegistryServiceConstants.HEADERS.APPLICATION_JSON);
            postMethod.addRequestHeader(EndpointRegistryServiceConstants.HEADERS.CONTENT_TYPE, 
                    EndpointRegistryServiceConstants.HEADERS.MULTI_PART_FORM_DATA);

            // set JSON data
            for (Map.Entry<String, String> param : params.entrySet()) {
                StringPart stringPart = new StringPart(param.getKey(), param.getValue(),
                        EndpointRegistryServiceConstants.HEADERS.UTF_8);
                stringPart.setContentType(EndpointRegistryServiceConstants.HEADERS.APPLICATION_JSON);
                postMethod.addPart(stringPart);
            }

            // set file data
            for (Map.Entry<String, String> file : files.entrySet()) {
                StringPart stringPart = new StringPart(file.getKey(), file.getValue(),
                        EndpointRegistryServiceConstants.HEADERS.UTF_8);
                stringPart.setContentType(EndpointRegistryServiceConstants.HEADERS.TEXT_JSON);
                postMethod.addPart(stringPart);
            }
            int statusCode = client.executeMethod(postMethod);

            // build response
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(postMethod.getResponseBodyAsStream(), postMethod.getResponseCharSet()));
            String line = EndpointRegistryServiceConstants.Common.EMPTY_STRING;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            response = result.toString();
            handleResponseStatus(statusCode, response);
            return response;
        } catch (UnknownHostException | SocketException e) {
            log.error(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
            throw new EndpointRegistryConnectException(EndpointRegistryServiceConstants.Errors.CONNECTION_FAILS, e);
        } catch (IOException | GeneralSecurityException e) {
            throw new HttpClientException(EndpointRegistryServiceConstants.Errors.HTTP_ERROR_SENDING_REQUEST, e);
        }
    }

    /**
     * Handles error statuses.
     * 
     * @param status response status
     * @param response response message
     * @throws InvalidTokenException auth failures
     * @throws EndpointRegistryConnectException unidentified failures
     */
    private static void handleResponseStatus(int status, String response)
            throws InvalidTokenException, EndpointRegistryConnectException {
        if (status == 401) {
            throw new InvalidTokenException(EndpointRegistryServiceConstants.Errors.AUTH_FAILED);
        } else if (status == 500 && response.contains("Unauthenticated request")) {
            throw new InvalidTokenException(EndpointRegistryServiceConstants.Errors.INVALID_CREDENTIAL);
        } else if (status != 200) {
            throw new EndpointRegistryConnectException(getErrorMessage(response));
        }
    }

    /**
     * Get error message from unsuccessful requests.
     * 
     * @param response message
     * @return extracted error message
     */
    private static String getErrorMessage(String response) {
        JsonParser parser = new JsonParser();
        JsonElement jsonResponse = parser.parse(response);
        return jsonResponse.getAsJsonObject().get("description").getAsString();
    }
}
