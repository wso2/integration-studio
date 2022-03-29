/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__HTTP_METHOD;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__URI_TEMPLATE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_GRANT_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__AUTH_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__BASIC_AUTH_USERNAME;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_CLIENT_ID;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_USERNAME;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_PASSWORD;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_TOKEN_URL;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_PARAMETERS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.axis2.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.BasicAuthConfiguredHTTPEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.OAuthConfiguredHTTPEndpoint;
import org.apache.synapse.endpoints.auth.basicauth.BasicAuthHandler;
import org.apache.synapse.endpoints.auth.oauth.AuthorizationCodeHandler;
import org.apache.synapse.endpoints.auth.oauth.ClientCredentialsHandler;
import org.apache.synapse.endpoints.auth.oauth.PasswordCredentialsHandler;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.rest.RESTConstants;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEList.UnmodifiableEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.gmf.esb.AbstractEndPoint;
import org.wso2.integrationstudio.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.gmf.esb.EndPointPropertyScope;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpointAuthType;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpointOAuthAuthenticationMode;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpointOAuthGrantType;
import org.wso2.integrationstudio.gmf.esb.HttpMethodType;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.HttpEndpointFormPage;

public class HTTPEndpointDeserializer extends AbstractEndpointDeserializer {

    @Deprecated
    public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
        Assert.isTrue(object instanceof org.apache.synapse.endpoints.HTTPEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.HTTPEndpoint httpEndpoint = (org.apache.synapse.endpoints.HTTPEndpoint) object;
        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.HTTPEndpoint_3712
                        : EsbElementTypes.HTTPEndpoint_3709;
        AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(endPoint);
        deserializeEndpoint(httpEndpoint, endPoint);

        if (httpEndpoint.getUriTemplate() != null) {
            executeSetValueCommand(HTTP_ENDPOINT__URI_TEMPLATE, httpEndpoint.getUriTemplate().getTemplate());
        }
        String httpMethod = httpEndpoint.getHttpMethod();
        if (httpMethod != null) {
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.POST);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.GET);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.PUT);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.DELETE);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.HEAD);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.PATCH);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.OPTIONS);
            }
        } else {
            executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.LEAVE_AS_IS);
        }

        executeSetValueCommand(HTTP_ENDPOINT__AUTH_TYPE, HTTPEndpointAuthType.NONE);

        if (object instanceof OAuthConfiguredHTTPEndpoint) {
            OAuthConfiguredHTTPEndpoint oauthEP = (OAuthConfiguredHTTPEndpoint) object;
            
            executeSetValueCommand(HTTP_ENDPOINT__AUTH_TYPE,HTTPEndpointAuthType.OAUTH);
            if (oauthEP.getOauthHandler() instanceof AuthorizationCodeHandler) {
                AuthorizationCodeHandler handler = (AuthorizationCodeHandler) oauthEP.getOauthHandler();
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_GRANT_TYPE,
                        HTTPEndpointOAuthGrantType.AUTHORIZATION_CODE_GRANT);
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE, handler.getAuthMode());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_CLIENT_ID, handler.getClientId());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_CLIENT_SECRET, handler.getClientSecret());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN, handler.getRefreshToken());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_TOKEN_URL, handler.getTokenUrl());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE, getOAuthMode(handler.getAuthMode()));
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_PARAMETERS, getOAuthParametersList(handler.getRequestParametersMap()));
            } else if (oauthEP.getOauthHandler() instanceof ClientCredentialsHandler) {
                ClientCredentialsHandler handler = (ClientCredentialsHandler) oauthEP.getOauthHandler();
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_GRANT_TYPE,
                        HTTPEndpointOAuthGrantType.CLIENT_CREDENTIALS_GRANT);
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE, handler.getAuthMode());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_CLIENT_ID, handler.getClientId());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_CLIENT_SECRET, handler.getClientSecret());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_TOKEN_URL, handler.getTokenUrl());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE, getOAuthMode(handler.getAuthMode()));
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_PARAMETERS, getOAuthParametersList(handler.getRequestParametersMap()));
            } else if (oauthEP.getOauthHandler() instanceof PasswordCredentialsHandler) {
                PasswordCredentialsHandler handler = (PasswordCredentialsHandler) oauthEP.getOauthHandler();
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_GRANT_TYPE,
                        HTTPEndpointOAuthGrantType.PASSWORD_CREDENTIALS_GRANT);
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE, handler.getAuthMode());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_CLIENT_ID, handler.getClientId());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_CLIENT_SECRET, handler.getClientSecret());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_USERNAME, handler.getUsername());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_PASSWORD, handler.getPassword());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_TOKEN_URL, handler.getTokenUrl());
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE, getOAuthMode(handler.getAuthMode()));
                executeSetValueCommand(HTTP_ENDPOINT__OAUTH_PARAMETERS, getOAuthParametersList(handler.getRequestParametersMap()));
            }
        } else if (object instanceof BasicAuthConfiguredHTTPEndpoint) {
            BasicAuthConfiguredHTTPEndpoint basicAuthEP = (BasicAuthConfiguredHTTPEndpoint) object;
            if (basicAuthEP.getBasicAuthHandler() instanceof BasicAuthHandler) {
                BasicAuthHandler handler = (BasicAuthHandler) basicAuthEP.getBasicAuthHandler();
                executeSetValueCommand(HTTP_ENDPOINT__AUTH_TYPE,HTTPEndpointAuthType.BASIC_AUTH);
                executeSetValueCommand(HTTP_ENDPOINT__BASIC_AUTH_USERNAME, handler.getUsername());
                executeSetValueCommand(HTTP_ENDPOINT__BASIC_AUTH_PASSWORD, handler.getPassword());
            }
        }

        return endPoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {
        ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        HTTPEndpoint endpoint = (HTTPEndpoint) endpointObject;

        HttpEndpointFormPage httpEndpointPage = (HttpEndpointFormPage) endpointPage;
        deserializeEndpoint(formEditor, endpointObject);
        // setTextValue(httpEndpointPage.httpEP_Properties, endpoint.getDefinition().get);
        setTextValue(httpEndpointPage.getEP_Description(), endpoint.getDescription());
        httpEndpointPage.setEndpointCommentList(endpoint.getCommentsList());
        if (endpoint.getUriTemplate() != null) {
            setTextValue(httpEndpointPage.httpEP_UriTemplate, endpoint.getUriTemplate().getTemplate());
        } else {
            setTextValue(httpEndpointPage.httpEP_UriTemplate, "");
        }
        String httpMethod = endpoint.getHttpMethod();
        if (httpMethod != null) {// {"LEAVE_AS_IS", "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH"};
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
                httpEndpointPage.httpEP_Method.select(2);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
                httpEndpointPage.httpEP_Method.select(1);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
                httpEndpointPage.httpEP_Method.select(3);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
                httpEndpointPage.httpEP_Method.select(4);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
                httpEndpointPage.httpEP_Method.select(5);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
                httpEndpointPage.httpEP_Method.select(7);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
                httpEndpointPage.httpEP_Method.select(6);
            }
        } else {
            httpEndpointPage.httpEP_Method.select(0);
        }

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = httpEndpointPage.endpointPropertyList;
            httpEndpointPage.endpointPropertyList = getProperties(endpoint, existingProperties);

        } else {
            httpEndpointPage.endpointPropertyList = null;
        }

        httpEndpointPage.httpEP_AuthType.select(0);
        httpEndpointPage.httpEP_OAuthType.select(0);
        httpEndpointPage.httpEP_OAuthAuthenticationMode.select(0);

        if (endpointObject instanceof OAuthConfiguredHTTPEndpoint) {
            OAuthConfiguredHTTPEndpoint oauthEP = (OAuthConfiguredHTTPEndpoint) endpointObject;
            if (oauthEP.getOauthHandler() instanceof AuthorizationCodeHandler) {
                AuthorizationCodeHandler handler = (AuthorizationCodeHandler) oauthEP.getOauthHandler();
                httpEndpointPage.httpEP_AuthType.select(2);
                httpEndpointPage.httpEP_OAuthType.select(0);
                httpEndpointPage.httpEP_OAuthAuthenticationMode.select(HTTPEndpointOAuthAuthenticationMode.getByName(handler.getAuthMode()).getValue());
                
                httpEndpointPage.setOAuthClientId(handler.getClientId());
                httpEndpointPage.setOAuthClientSecret(handler.getClientSecret());
                httpEndpointPage.setOAuthRefreshToken(handler.getRefreshToken());
                httpEndpointPage.setOAuthTokenUrl(handler.getTokenUrl());
                httpEndpointPage.setOAuthParameters(handler.getRequestParametersMap());
            } else if (oauthEP.getOauthHandler() instanceof ClientCredentialsHandler) {
                ClientCredentialsHandler handler = (ClientCredentialsHandler) oauthEP.getOauthHandler();
                httpEndpointPage.httpEP_AuthType.select(2);
                httpEndpointPage.httpEP_OAuthType.select(1);
                httpEndpointPage.httpEP_OAuthAuthenticationMode.select(HTTPEndpointOAuthAuthenticationMode.getByName(handler.getAuthMode()).getValue());
                
                httpEndpointPage.setOAuthClientId(handler.getClientId());
                httpEndpointPage.setOAuthClientSecret(handler.getClientSecret());
                httpEndpointPage.setOAuthTokenUrl(handler.getTokenUrl());
                httpEndpointPage.setOAuthParameters(handler.getRequestParametersMap());
            } else if (oauthEP.getOauthHandler() instanceof PasswordCredentialsHandler) {
                PasswordCredentialsHandler handler = (PasswordCredentialsHandler) oauthEP.getOauthHandler();
                httpEndpointPage.httpEP_AuthType.select(2);
                httpEndpointPage.httpEP_OAuthType.select(2);
                httpEndpointPage.httpEP_OAuthAuthenticationMode.select(HTTPEndpointOAuthAuthenticationMode.getByName(handler.getAuthMode()).getValue());
                
                httpEndpointPage.setOAuthClientId(handler.getClientId());
                httpEndpointPage.setOAuthClientSecret(handler.getClientSecret());
                httpEndpointPage.getOAuthUsername(handler.getUsername());
                httpEndpointPage.getOAuthPassword(handler.getPassword());
                httpEndpointPage.setOAuthTokenUrl(handler.getTokenUrl());
                httpEndpointPage.setOAuthParameters(handler.getRequestParametersMap());
            }
            
        } else if (endpointObject instanceof BasicAuthConfiguredHTTPEndpoint) {
            BasicAuthConfiguredHTTPEndpoint basicAuthEP = (BasicAuthConfiguredHTTPEndpoint) endpointObject;
            if (basicAuthEP.getBasicAuthHandler() instanceof BasicAuthHandler) {
                BasicAuthHandler handler = (BasicAuthHandler) basicAuthEP.getBasicAuthHandler();
                httpEndpointPage.httpEP_AuthType.select(1);
                httpEndpointPage.setBasicAuthUsername(handler.getUsername());
                httpEndpointPage.setBasicAuthPassword(handler.getPassword());
            }
        }

        httpEndpointPage.setAuthenticationFields();
        super.createNode(formEditor, endpointObject);
    }
    
    private HTTPEndpointOAuthAuthenticationMode getOAuthMode(String value) {
        if (value.equals("header")) {
            return HTTPEndpointOAuthAuthenticationMode.HEADER_OAUTH_AUTHENTICATION_MODE;
        } else {
            return HTTPEndpointOAuthAuthenticationMode.PAYLOAD_OAUTH_AUTHENTICATION_MODE;
        }
        
    }
    
    protected EList<EndPointProperty> getOAuthParametersList(Map<String, String> map) {
        
        EList<EndPointProperty> list = new BasicEList<EndPointProperty>();
        
        for(Entry<String, String> entry: map.entrySet()) {
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(entry.getKey());
            
            if (isExpression(entry.getValue())) {
                property.setValueType(PropertyValueType.EXPRESSION);
                NamespacedProperty namespacedProperty = EsbFactory.eINSTANCE.createNamespacedProperty();
                namespacedProperty.setPropertyValue(getValueFromExpression(entry.getValue()));
                property.setValueExpression(namespacedProperty);
            } else {
                property.setValueType(PropertyValueType.LITERAL);
                property.setValue(entry.getValue());
            }
            
            list.add(property);
            
        }
        
        return list;
    }
    
    /**
     * Validate the given attribute to identify whether it is static or dynamic key
     * If the name is in the {} format then it is dynamic key(XPath)
     * Otherwise just a static name
     *
     * @param attributeValue string to validate as the attribute
     * @return isDynamicAttribute representing the attribute type
     */
    private boolean isExpression(String value) {
        if (value.length() < 2) {
            return false;
        }

        final char startExpression = '{';
        final char endExpression = '}';

        char firstChar = value.charAt(0);
        char lastChar = value.charAt(value.length() - 1);

        return (startExpression == firstChar && endExpression == lastChar);
    }
    
    private String getValueFromExpression(String expression) {
        return expression.substring(1, expression.length() - 1);
    }

    /**
     * Get properties
     * 
     * @param endpoint endpoint
     * @param existingProperties existing properties
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EndPointProperty> getProperties(HTTPEndpoint endpoint, List<EndPointProperty> existingProperties) {

        List<EndPointProperty> newlyAddedProperties = new ArrayList<EndPointProperty>();
        List<EndPointProperty> removedProperties = new ArrayList<EndPointProperty>();
        List<EndPointProperty> newProperties = new ArrayList<EndPointProperty>();

        for (Iterator<MediatorProperty> i = endpoint.getProperties().iterator(); i.hasNext();) {
            MediatorProperty next = i.next();
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(next.getName());

            if (next.getExpression() != null) {
                property.setValueType(PropertyValueType.EXPRESSION);
                NamespacedProperty valueXPath = EsbFactory.eINSTANCE.createNamespacedProperty();
                valueXPath.setPropertyValue(next.getExpression().toString());
                Map<String, String> namespaces = (Map<String, String>) next.getExpression().getNamespaces();
                valueXPath.setNamespaces(namespaces);
                property.setValueExpression(valueXPath);
            } else if (next.getValue() != null) {
                property.setValueType(PropertyValueType.LITERAL);
                property.setValue(next.getValue());
            }

            if (next.getScope() != null) {
                property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
            } else {
                property.setScope(EndPointPropertyScope.SYNAPSE);
            }

            if (existingProperties != null) {
                for (EndPointProperty propertyItem : existingProperties) {
                    // When updating the existing properties from source view, then remove the property
                    // from old list and add to new list
                    if (propertyItem.getName().equals(next.getName())) {
                        existingProperties.remove(propertyItem);
                        newlyAddedProperties.add(property);
                        break;
                    }
                }
            }
            // When adding a new property from source then add it to the new list
            if (!newlyAddedProperties.contains(property)) {
                newlyAddedProperties.add(property);
            }
        }
        // If old properties contain any property values, then remove the value and add the property to the
        // new
        // list, DEVTOOLESB-505
        if (existingProperties != null) {
            for (EndPointProperty prop : existingProperties) {
                String value = prop.getName();
                if (StringUtils.isNotEmpty(value)) {
                    // Add the property to removed list
                    removedProperties.add(prop);
                }
            }
        }
        // First remove the removed properties from existing properties
        if (removedProperties.size() > 0) {
            existingProperties.removeAll(removedProperties);
        }
        // Adds the new properties
        if (newProperties.size() > 0) {
            newlyAddedProperties.addAll(newProperties);
        }
        // Adds the existing old properties (which didn't get updated)
        // to the new list
        if (existingProperties != null) {
            newlyAddedProperties.addAll(existingProperties);
        }
        return newlyAddedProperties;

    }

}
