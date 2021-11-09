/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.HTTPEndPointInputConnector;
import org.wso2.integrationstudio.gmf.esb.HTTPEndPointOutputConnector;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpoint;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpointAuthType;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpointOAuthGrantType;
import org.wso2.integrationstudio.gmf.esb.HttpMethodType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HTTP Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getURITemplate <em>URI Template</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getHttpMethod <em>Http Method</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getOAuthGrantType <em>OAuth Grant Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getOAuthClientId <em>OAuth Client Id</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getOAuthClientSecret <em>OAuth Client Secret</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getOAuthTokenUrl <em>OAuth Token Url</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getOAuthRefreshToken <em>OAuth Refresh Token</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getAuthType <em>Auth Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getBasicAuthUsername <em>Basic Auth Username</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.HTTPEndpointImpl#getBasicAuthPassword <em>Basic Auth Password</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HTTPEndpointImpl extends AbstractEndPointImpl implements HTTPEndpoint {
    /**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
    protected HTTPEndPointInputConnector inputConnector;

    /**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
    protected HTTPEndPointOutputConnector outputConnector;

    /**
     * The default value of the '{@link #getURITemplate() <em>URI Template</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getURITemplate()
     * @generated
     * @ordered
     */
    protected static final String URI_TEMPLATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getURITemplate() <em>URI Template</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getURITemplate()
     * @generated
     * @ordered
     */
    protected String uriTemplate = URI_TEMPLATE_EDEFAULT;

    /**
     * The default value of the '{@link #getHttpMethod() <em>Http Method</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHttpMethod()
     * @generated
     * @ordered
     */
    protected static final HttpMethodType HTTP_METHOD_EDEFAULT = HttpMethodType.GET;

    /**
     * The cached value of the '{@link #getHttpMethod() <em>Http Method</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHttpMethod()
     * @generated
     * @ordered
     */
    protected HttpMethodType httpMethod = HTTP_METHOD_EDEFAULT;

    /**
     * The default value of the '{@link #getOAuthGrantType() <em>OAuth Grant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthGrantType()
     * @generated
     * @ordered
     */
    protected static final HTTPEndpointOAuthGrantType OAUTH_GRANT_TYPE_EDEFAULT = HTTPEndpointOAuthGrantType.AUTHORIZATION_CODE_GRANT;

    /**
     * The cached value of the '{@link #getOAuthGrantType() <em>OAuth Grant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthGrantType()
     * @generated
     * @ordered
     */
    protected HTTPEndpointOAuthGrantType oAuthGrantType = OAUTH_GRANT_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getOAuthClientId() <em>OAuth Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthClientId()
     * @generated
     * @ordered
     */
    protected static final String OAUTH_CLIENT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOAuthClientId() <em>OAuth Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthClientId()
     * @generated
     * @ordered
     */
    protected String oAuthClientId = OAUTH_CLIENT_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getOAuthClientSecret() <em>OAuth Client Secret</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthClientSecret()
     * @generated
     * @ordered
     */
    protected static final String OAUTH_CLIENT_SECRET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOAuthClientSecret() <em>OAuth Client Secret</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthClientSecret()
     * @generated
     * @ordered
     */
    protected String oAuthClientSecret = OAUTH_CLIENT_SECRET_EDEFAULT;

    /**
     * The default value of the '{@link #getOAuthTokenUrl() <em>OAuth Token Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthTokenUrl()
     * @generated
     * @ordered
     */
    protected static final String OAUTH_TOKEN_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOAuthTokenUrl() <em>OAuth Token Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthTokenUrl()
     * @generated
     * @ordered
     */
    protected String oAuthTokenUrl = OAUTH_TOKEN_URL_EDEFAULT;

    /**
     * The default value of the '{@link #getOAuthRefreshToken() <em>OAuth Refresh Token</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthRefreshToken()
     * @generated
     * @ordered
     */
    protected static final String OAUTH_REFRESH_TOKEN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOAuthRefreshToken() <em>OAuth Refresh Token</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOAuthRefreshToken()
     * @generated
     * @ordered
     */
    protected String oAuthRefreshToken = OAUTH_REFRESH_TOKEN_EDEFAULT;

    /**
     * The default value of the '{@link #getAuthType() <em>Auth Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthType()
     * @generated
     * @ordered
     */
    protected static final HTTPEndpointAuthType AUTH_TYPE_EDEFAULT = HTTPEndpointAuthType.NONE;

    /**
     * The cached value of the '{@link #getAuthType() <em>Auth Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthType()
     * @generated
     * @ordered
     */
    protected HTTPEndpointAuthType authType = AUTH_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getBasicAuthUsername() <em>Basic Auth Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBasicAuthUsername()
     * @generated
     * @ordered
     */
    protected static final String BASIC_AUTH_USERNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBasicAuthUsername() <em>Basic Auth Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBasicAuthUsername()
     * @generated
     * @ordered
     */
    protected String basicAuthUsername = BASIC_AUTH_USERNAME_EDEFAULT;

    /**
     * The default value of the '{@link #getBasicAuthPassword() <em>Basic Auth Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBasicAuthPassword()
     * @generated
     * @ordered
     */
    protected static final String BASIC_AUTH_PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBasicAuthPassword() <em>Basic Auth Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBasicAuthPassword()
     * @generated
     * @ordered
     */
    protected String basicAuthPassword = BASIC_AUTH_PASSWORD_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HTTPEndpointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.HTTP_ENDPOINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HTTPEndPointInputConnector getInputConnector() {
        return inputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInputConnector(HTTPEndPointInputConnector newInputConnector,
            NotificationChain msgs) {
        HTTPEndPointInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputConnector(HTTPEndPointInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HTTPEndPointOutputConnector getOutputConnector() {
        return outputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutputConnector(HTTPEndPointOutputConnector newOutputConnector,
            NotificationChain msgs) {
        HTTPEndPointOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputConnector(HTTPEndPointOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getURITemplate() {
        return uriTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setURITemplate(String newURITemplate) {
        String oldURITemplate = uriTemplate;
        uriTemplate = newURITemplate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__URI_TEMPLATE, oldURITemplate, uriTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HttpMethodType getHttpMethod() {
        return httpMethod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHttpMethod(HttpMethodType newHttpMethod) {
        HttpMethodType oldHttpMethod = httpMethod;
        httpMethod = newHttpMethod == null ? HTTP_METHOD_EDEFAULT : newHttpMethod;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__HTTP_METHOD, oldHttpMethod, httpMethod));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HTTPEndpointOAuthGrantType getOAuthGrantType() {
        return oAuthGrantType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOAuthGrantType(HTTPEndpointOAuthGrantType newOAuthGrantType) {
        HTTPEndpointOAuthGrantType oldOAuthGrantType = oAuthGrantType;
        oAuthGrantType = newOAuthGrantType == null ? OAUTH_GRANT_TYPE_EDEFAULT : newOAuthGrantType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OAUTH_GRANT_TYPE, oldOAuthGrantType, oAuthGrantType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOAuthClientId() {
        return oAuthClientId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOAuthClientId(String newOAuthClientId) {
        String oldOAuthClientId = oAuthClientId;
        oAuthClientId = newOAuthClientId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_ID, oldOAuthClientId, oAuthClientId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOAuthClientSecret() {
        return oAuthClientSecret;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOAuthClientSecret(String newOAuthClientSecret) {
        String oldOAuthClientSecret = oAuthClientSecret;
        oAuthClientSecret = newOAuthClientSecret;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET, oldOAuthClientSecret, oAuthClientSecret));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOAuthTokenUrl() {
        return oAuthTokenUrl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOAuthTokenUrl(String newOAuthTokenUrl) {
        String oldOAuthTokenUrl = oAuthTokenUrl;
        oAuthTokenUrl = newOAuthTokenUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OAUTH_TOKEN_URL, oldOAuthTokenUrl, oAuthTokenUrl));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOAuthRefreshToken() {
        return oAuthRefreshToken;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOAuthRefreshToken(String newOAuthRefreshToken) {
        String oldOAuthRefreshToken = oAuthRefreshToken;
        oAuthRefreshToken = newOAuthRefreshToken;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN, oldOAuthRefreshToken, oAuthRefreshToken));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HTTPEndpointAuthType getAuthType() {
        return authType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthType(HTTPEndpointAuthType newAuthType) {
        HTTPEndpointAuthType oldAuthType = authType;
        authType = newAuthType == null ? AUTH_TYPE_EDEFAULT : newAuthType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__AUTH_TYPE, oldAuthType, authType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBasicAuthUsername() {
        return basicAuthUsername;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBasicAuthUsername(String newBasicAuthUsername) {
        String oldBasicAuthUsername = basicAuthUsername;
        basicAuthUsername = newBasicAuthUsername;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_USERNAME, oldBasicAuthUsername, basicAuthUsername));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBasicAuthPassword() {
        return basicAuthPassword;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBasicAuthPassword(String newBasicAuthPassword) {
        String oldBasicAuthPassword = basicAuthPassword;
        basicAuthPassword = newBasicAuthPassword;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD, oldBasicAuthPassword, basicAuthPassword));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR:
                return getOutputConnector();
            case EsbPackage.HTTP_ENDPOINT__URI_TEMPLATE:
                return getURITemplate();
            case EsbPackage.HTTP_ENDPOINT__HTTP_METHOD:
                return getHttpMethod();
            case EsbPackage.HTTP_ENDPOINT__OAUTH_GRANT_TYPE:
                return getOAuthGrantType();
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_ID:
                return getOAuthClientId();
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET:
                return getOAuthClientSecret();
            case EsbPackage.HTTP_ENDPOINT__OAUTH_TOKEN_URL:
                return getOAuthTokenUrl();
            case EsbPackage.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN:
                return getOAuthRefreshToken();
            case EsbPackage.HTTP_ENDPOINT__AUTH_TYPE:
                return getAuthType();
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_USERNAME:
                return getBasicAuthUsername();
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD:
                return getBasicAuthPassword();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR:
                setInputConnector((HTTPEndPointInputConnector)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR:
                setOutputConnector((HTTPEndPointOutputConnector)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__URI_TEMPLATE:
                setURITemplate((String)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__HTTP_METHOD:
                setHttpMethod((HttpMethodType)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_GRANT_TYPE:
                setOAuthGrantType((HTTPEndpointOAuthGrantType)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_ID:
                setOAuthClientId((String)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET:
                setOAuthClientSecret((String)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_TOKEN_URL:
                setOAuthTokenUrl((String)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN:
                setOAuthRefreshToken((String)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__AUTH_TYPE:
                setAuthType((HTTPEndpointAuthType)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_USERNAME:
                setBasicAuthUsername((String)newValue);
                return;
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD:
                setBasicAuthPassword((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR:
                setInputConnector((HTTPEndPointInputConnector)null);
                return;
            case EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR:
                setOutputConnector((HTTPEndPointOutputConnector)null);
                return;
            case EsbPackage.HTTP_ENDPOINT__URI_TEMPLATE:
                setURITemplate(URI_TEMPLATE_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__HTTP_METHOD:
                setHttpMethod(HTTP_METHOD_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_GRANT_TYPE:
                setOAuthGrantType(OAUTH_GRANT_TYPE_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_ID:
                setOAuthClientId(OAUTH_CLIENT_ID_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET:
                setOAuthClientSecret(OAUTH_CLIENT_SECRET_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_TOKEN_URL:
                setOAuthTokenUrl(OAUTH_TOKEN_URL_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN:
                setOAuthRefreshToken(OAUTH_REFRESH_TOKEN_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__AUTH_TYPE:
                setAuthType(AUTH_TYPE_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_USERNAME:
                setBasicAuthUsername(BASIC_AUTH_USERNAME_EDEFAULT);
                return;
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD:
                setBasicAuthPassword(BASIC_AUTH_PASSWORD_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR:
                return outputConnector != null;
            case EsbPackage.HTTP_ENDPOINT__URI_TEMPLATE:
                return URI_TEMPLATE_EDEFAULT == null ? uriTemplate != null : !URI_TEMPLATE_EDEFAULT.equals(uriTemplate);
            case EsbPackage.HTTP_ENDPOINT__HTTP_METHOD:
                return httpMethod != HTTP_METHOD_EDEFAULT;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_GRANT_TYPE:
                return oAuthGrantType != OAUTH_GRANT_TYPE_EDEFAULT;
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_ID:
                return OAUTH_CLIENT_ID_EDEFAULT == null ? oAuthClientId != null : !OAUTH_CLIENT_ID_EDEFAULT.equals(oAuthClientId);
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET:
                return OAUTH_CLIENT_SECRET_EDEFAULT == null ? oAuthClientSecret != null : !OAUTH_CLIENT_SECRET_EDEFAULT.equals(oAuthClientSecret);
            case EsbPackage.HTTP_ENDPOINT__OAUTH_TOKEN_URL:
                return OAUTH_TOKEN_URL_EDEFAULT == null ? oAuthTokenUrl != null : !OAUTH_TOKEN_URL_EDEFAULT.equals(oAuthTokenUrl);
            case EsbPackage.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN:
                return OAUTH_REFRESH_TOKEN_EDEFAULT == null ? oAuthRefreshToken != null : !OAUTH_REFRESH_TOKEN_EDEFAULT.equals(oAuthRefreshToken);
            case EsbPackage.HTTP_ENDPOINT__AUTH_TYPE:
                return authType != AUTH_TYPE_EDEFAULT;
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_USERNAME:
                return BASIC_AUTH_USERNAME_EDEFAULT == null ? basicAuthUsername != null : !BASIC_AUTH_USERNAME_EDEFAULT.equals(basicAuthUsername);
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD:
                return BASIC_AUTH_PASSWORD_EDEFAULT == null ? basicAuthPassword != null : !BASIC_AUTH_PASSWORD_EDEFAULT.equals(basicAuthPassword);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (URITemplate: ");
        result.append(uriTemplate);
        result.append(", HttpMethod: ");
        result.append(httpMethod);
        result.append(", OAuthGrantType: ");
        result.append(oAuthGrantType);
        result.append(", OAuthClientId: ");
        result.append(oAuthClientId);
        result.append(", OAuthClientSecret: ");
        result.append(oAuthClientSecret);
        result.append(", OAuthTokenUrl: ");
        result.append(oAuthTokenUrl);
        result.append(", OAuthRefreshToken: ");
        result.append(oAuthRefreshToken);
        result.append(", AuthType: ");
        result.append(authType);
        result.append(", BasicAuthUsername: ");
        result.append(basicAuthUsername);
        result.append(", BasicAuthPassword: ");
        result.append(basicAuthPassword);
        result.append(')');
        return result.toString();
    }

} // HTTPEndpointImpl
