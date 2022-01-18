package org.wso2.integrationstudio.artifact.synapse.api.util;

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
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.wso2.integrationstudio.artifact.synapse.api.Activator;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.APIMConnectException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.HttpClientException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.InvalidTokenException;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Handles HTTP calls.
 */
public class HttpClientUtil {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    

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
            throws  APIMConnectException, HttpClientException, InvalidTokenException {
        try {
            // Discard SSL certificate
            Protocol easyhttps = new Protocol(ArtifactConstants.Common.HTTPS,
                    (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol(ArtifactConstants.Common.HTTPS, easyhttps);

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
            String line = ArtifactConstants.Common.EMPTY_STRING;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            response = result.toString();
            handleResponseStatus(statusCode, response);
            return response;
        } catch (UnknownHostException | SocketException e) {
            log.error(ArtifactConstants.Errors.CONNECTION_FAILS, e);
            throw new APIMConnectException(ArtifactConstants.Errors.CONNECTION_FAILS, e);
        } catch (IOException | GeneralSecurityException e) {
            throw new HttpClientException(ArtifactConstants.Errors.HTTP_ERROR_SENDING_REQUEST, e);
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
    /*public static String sendGetWithParams(String url, Map<String, String> headers, Map<String, String> data)
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
    } */

  

    /**
     * Handles error statuses.
     * 
     * @param status response status
     * @param response response message
     * @throws InvalidTokenException auth failures
     * @throws EndpointRegistryConnectException unidentified failures
     */
    private static void handleResponseStatus(int status, String response)
            throws InvalidTokenException, APIMConnectException {
        if (status == 401) {
            throw new InvalidTokenException(ArtifactConstants.Errors.AUTH_FAILED);
        } else if (status == 500 && response.contains("Unauthenticated request")) {
            throw new InvalidTokenException(ArtifactConstants.Errors.INVALID_CREDENTIAL);
        } else if (status != 200) {
            throw new APIMConnectException(getErrorMessage(response));
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
