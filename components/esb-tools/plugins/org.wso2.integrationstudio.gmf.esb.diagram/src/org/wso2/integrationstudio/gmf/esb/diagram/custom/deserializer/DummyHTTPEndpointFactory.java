/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import com.damnhandy.uri.template.UriTemplate;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.DefinitionFactory;
import org.apache.synapse.config.xml.endpoints.EndpointDefinitionFactory;
import org.apache.synapse.endpoints.BasicAuthConfiguredHTTPEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.OAuthConfiguredHTTPEndpoint;
import org.apache.synapse.endpoints.auth.AuthConstants;
import org.apache.synapse.endpoints.auth.AuthHandler;
import org.apache.synapse.endpoints.auth.basicauth.BasicAuthHandler;
import org.apache.synapse.endpoints.auth.oauth.AuthorizationCodeHandler;
import org.apache.synapse.endpoints.auth.oauth.ClientCredentialsHandler;
import org.apache.synapse.endpoints.auth.oauth.OAuthHandler;
import org.apache.synapse.endpoints.auth.oauth.PasswordCredentialsHandler;
import org.apache.synapse.api.RESTConstants;
import org.apache.synapse.commons.resolvers.ResolverFactory;
import javax.xml.namespace.QName;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Iterator;

public class DummyHTTPEndpointFactory extends DummyEndpointFactory {

    private static DummyHTTPEndpointFactory instance = new DummyHTTPEndpointFactory();

    public static DummyHTTPEndpointFactory getInstance() {
        return instance;
    }

    public EndpointDefinition createEndpointDefinition(OMElement elem) {
        DefinitionFactory fac = getEndpointDefinitionFactory();
        EndpointDefinition endpointDefinition;
        if (fac == null) {
            fac = new EndpointDefinitionFactory();
            endpointDefinition = fac.createDefinition(elem);
        } else {
            endpointDefinition = fac.createDefinition(elem);
        }
        extractSpecificEndpointProperties(endpointDefinition, elem);
        return endpointDefinition;
    }

    @Override
    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {
    	OMAttribute nameAttr = epConfig.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "name"));

        String name = null;

        if (nameAttr != null) {
            name = nameAttr.getAttributeValue();
        }

        OMElement httpElement = epConfig.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "http"));

        HTTPEndpoint httpEndpoint = null;

        AuthHandler authHandler = createAuthHandler(httpElement);
        if (authHandler != null) {
            switch (authHandler.getAuthType()) {
                case AuthConstants.BASIC_AUTH:
                    httpEndpoint = new BasicAuthConfiguredHTTPEndpoint(authHandler);
                    break;
                case AuthConstants.OAUTH:
                    httpEndpoint = new OAuthConfiguredHTTPEndpoint(authHandler);
                    break;
                default:
                    httpEndpoint = new HTTPEndpoint();
            }
        } else {
            httpEndpoint = new HTTPEndpoint();
        }

        if (name != null) {
            httpEndpoint.setName(name);
        }

        if (httpElement != null) {
            EndpointDefinition definition = createEndpointDefinition(httpElement);

            OMAttribute uriTemplateAttr = httpElement.getAttribute(new QName("uri-template"));
            if (uriTemplateAttr != null) {

                    httpEndpoint.setUriTemplate(UriTemplate.fromTemplate(uriTemplateAttr.getAttributeValue()));
                    definition.setAddress(uriTemplateAttr.getAttributeValue());
                    httpEndpoint.setLegacySupport(true);

            }

            httpEndpoint.setDefinition(definition);
            processAuditStatus(definition, httpEndpoint.getName(), httpElement);

            OMAttribute methodAttr = httpElement.getAttribute(new QName("method"));
            if (methodAttr != null) {
                setHttpMethod(httpEndpoint, methodAttr.getAttributeValue());
            }
        }

        processProperties(httpEndpoint, epConfig);

        return httpEndpoint;
    }

    private void setHttpMethod(HTTPEndpoint httpEndpoint, String httpMethod) {
        if (httpMethod != null) {
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_POST);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_GET);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_PUT);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_DELETE);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_HEAD);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_PATCH);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
                httpEndpoint.setHttpMethod(RESTConstants.METHOD_OPTIONS);
            }
        }
    }

    /**
     * This method will return an AuthHandler instance depending on the auth configs
     *
     * @param httpElement Element containing http configs
     * @return AuthHandler instance if valid auth configuration is found
     */
    private AuthHandler createAuthHandler(OMElement httpElement) {
        if (httpElement != null) {
            OMElement authElement = httpElement.getFirstChildWithName(
                    new QName(SynapseConstants.SYNAPSE_NAMESPACE, AuthConstants.AUTHENTICATION));

            if (authElement != null) {
                OMElement oauthElement = authElement
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, AuthConstants.OAUTH));
                OMElement basicAuthElement = authElement.getFirstChildWithName(
                        new QName(SynapseConstants.SYNAPSE_NAMESPACE, AuthConstants.BASIC_AUTH));

                AuthHandler authHandler = null;
                if (oauthElement != null) {
                    authHandler = getSpecificOAuthHandler(oauthElement);
                } else if (basicAuthElement != null) {
                    authHandler = getBasicAuthHandler(basicAuthElement);
                }
                
                // invalid auth configuration
                if (authHandler != null) {
                    return authHandler;
                }
            }
        }
        return null;
    }
    
    private static AuthHandler getBasicAuthHandler(OMElement basicAuthElement) {

        String username = getChildValue(basicAuthElement, AuthConstants.BASIC_AUTH_USERNAME);
        String password = getChildValue(basicAuthElement, AuthConstants.BASIC_AUTH_PASSWORD);
        return new BasicAuthHandler(username, password);
    }

    /**
     * This method will return an OAuthHandler instance depending on the oauth configs
     *
     * @param oauthElement Element containing OAuth configs
     * @return OAuthHandler object
     */
    private static OAuthHandler getSpecificOAuthHandler(OMElement oauthElement) {

        OAuthHandler oAuthHandler = null;

        OMElement authCodeElement = oauthElement.getFirstChildWithName(
                new QName(SynapseConstants.SYNAPSE_NAMESPACE, AuthConstants.AUTHORIZATION_CODE));

        OMElement clientCredentialsElement = oauthElement.getFirstChildWithName(
                new QName(SynapseConstants.SYNAPSE_NAMESPACE, AuthConstants.CLIENT_CREDENTIALS));
        
        OMElement passwordCredentialsElement = oauthElement.getFirstChildWithName(new QName(
                SynapseConstants.SYNAPSE_NAMESPACE, AuthConstants.PASSWORD_CREDENTIALS));

        if (authCodeElement != null) {
            oAuthHandler = getAuthorizationCodeHandler(authCodeElement);
        }

        if (clientCredentialsElement != null) {
            oAuthHandler = getClientCredentialsHandler(clientCredentialsElement);
        }
        
        if (passwordCredentialsElement != null) {
            oAuthHandler = getPasswordCredentialsHandler(passwordCredentialsElement);
        }
        return oAuthHandler;
    }

    /**
     * Method to get a AuthorizationCodeHandler
     *
     * @param authCodeElement Element containing authorization code configs
     * @return AuthorizationCodeHandler object
     */
    private static AuthorizationCodeHandler getAuthorizationCodeHandler(OMElement authCodeElement) {
        
        String clientId = getChildValue(authCodeElement, AuthConstants.OAUTH_CLIENT_ID);
        String clientSecret = getChildValue(authCodeElement, AuthConstants.OAUTH_CLIENT_SECRET);
        String refreshToken = getChildValue(authCodeElement, AuthConstants.OAUTH_REFRESH_TOKEN);
        String tokenApiUrl = getChildValue(authCodeElement, AuthConstants.TOKEN_API_URL);
        String authMode = getChildValue(authCodeElement, AuthConstants.OAUTH_AUTHENTICATION_MODE);

        if (clientId == null || clientSecret == null || refreshToken == null || tokenApiUrl == null) {
            return null;
        }
        AuthorizationCodeHandler handler = new AuthorizationCodeHandler(tokenApiUrl, clientId, clientSecret,
                refreshToken, authMode);
        if (hasRequestParameters(authCodeElement)) {
            Map<String, String> requestParameters = getRequestParameters(authCodeElement);
            if (requestParameters == null) {
                return null;
            }
            handler.setRequestParameters(requestParameters);
        }
        return handler;

    }

    /**
     * Method to get a ClientCredentialsHandler
     *
     * @param clientCredentialsElement Element containing client credentials configs
     * @return ClientCredentialsHandler object
     */
    private static ClientCredentialsHandler getClientCredentialsHandler(OMElement clientCredentialsElement) {

        String clientId = getChildValue(clientCredentialsElement, AuthConstants.OAUTH_CLIENT_ID);
        String clientSecret = getChildValue(clientCredentialsElement, AuthConstants.OAUTH_CLIENT_SECRET);
        String tokenApiUrl = getChildValue(clientCredentialsElement, AuthConstants.TOKEN_API_URL);
        String authMode = getChildValue(clientCredentialsElement, AuthConstants.OAUTH_AUTHENTICATION_MODE);

        if (clientId == null || clientSecret == null || tokenApiUrl == null) {
            return null;
        }
        ClientCredentialsHandler handler = new ClientCredentialsHandler(tokenApiUrl, clientId, clientSecret, authMode);
        if (hasRequestParameters(clientCredentialsElement)) {
            Map<String, String> requestParameters = getRequestParameters(clientCredentialsElement);
            if (requestParameters == null) {
                return null;
            }
            handler.setRequestParameters(requestParameters);
        }
        return handler;

    }
    
    /**
     * Method to get a PasswordCredentialsHandler
     *
     * @param clientCredentialsElement Element containing client credentials configs
     * @return ClientCredentialsHandler object
     */
    private static PasswordCredentialsHandler getPasswordCredentialsHandler(OMElement passwordCredentialsElement) {

        String clientId = getChildValue(passwordCredentialsElement, AuthConstants.OAUTH_CLIENT_ID);
        String clientSecret = getChildValue(passwordCredentialsElement, AuthConstants.OAUTH_CLIENT_SECRET);
        String username = getChildValue(passwordCredentialsElement, AuthConstants.OAUTH_USERNAME);
        String password = getChildValue(passwordCredentialsElement, AuthConstants.OAUTH_PASSWORD);
        String tokenApiUrl = getChildValue(passwordCredentialsElement, AuthConstants.TOKEN_API_URL);
        String authMode = getChildValue(passwordCredentialsElement, AuthConstants.OAUTH_AUTHENTICATION_MODE);

        if (username == null || password == null || tokenApiUrl == null || clientId == null || clientSecret == null) {
            return null;
        }
        PasswordCredentialsHandler handler = new PasswordCredentialsHandler(tokenApiUrl, clientId, clientSecret,
                username, password, authMode);
        if (hasRequestParameters(passwordCredentialsElement)) {
            Map<String, String> requestParameters = getRequestParameters(passwordCredentialsElement);
            if (requestParameters == null) {
                return null;
            }
            handler.setRequestParameters(requestParameters);
        }
        return handler;

    }

    /**
     * Method to get the value inside a child element
     *
     * @param parentElement Parent OMElement
     * @param childName name of the child
     * @return String containing the value of the child
     */
    private static String getChildValue(OMElement parentElement, String childName) {

        OMElement childElement = parentElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, childName));

        if (childElement != null) {
            return childElement.getText().trim();
        }
        return "";
    }
    
    /**
     * Method to return the request parameters as a Map.
     *
     * @param oauthElement OAuth config OMElement
     * @return Map<String, String> containing request parameters
     */
    private static Map<String, String> getRequestParameters(OMElement oauthElement) {

        HashMap<String, String> parameterMap = new HashMap<>();

        OMElement requestParametersElement = oauthElement.getFirstChildWithName(
                new QName(XMLConfigConstants.SYNAPSE_NAMESPACE,
                        AuthConstants.REQUEST_PARAMETERS));

        Iterator parameters =
                requestParametersElement.getChildrenWithName(
                        new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, AuthConstants.REQUEST_PARAMETER));

        while (parameters.hasNext()) {
            OMElement parameter = (OMElement) parameters.next();
            String paramName = parameter.getAttributeValue(new QName(AuthConstants.NAME));
            String paramValue = parameter.getText().trim();
            if (StringUtils.isBlank(paramName) || StringUtils.isBlank(paramValue)) {
                return null;
            }
            paramValue = ResolverFactory.getInstance().getResolver(paramValue).resolve();
            parameterMap.put(paramName, paramValue);
        }
        return parameterMap;
    }
    
    /**
     * Method to check whether there are request parameters are defined in the OAuth config.
     *
     * @param oauthElement OAuth config OMElement
     * @return true if there are request parameters in the oauth element
     */
    private static boolean hasRequestParameters(OMElement oauthElement) {

        OMElement requestParametersElement = oauthElement.getFirstChildWithName(
                new QName(XMLConfigConstants.SYNAPSE_NAMESPACE,
                        AuthConstants.REQUEST_PARAMETERS));
        return (requestParametersElement != null && requestParametersElement.getChildrenWithName(
                new QName(XMLConfigConstants.SYNAPSE_NAMESPACE,
                        AuthConstants.REQUEST_PARAMETER)).hasNext());
    }
}
