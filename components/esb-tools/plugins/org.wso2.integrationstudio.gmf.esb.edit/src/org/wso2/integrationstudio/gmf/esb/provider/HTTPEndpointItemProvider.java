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
package org.wso2.integrationstudio.gmf.esb.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.HTTPEndpoint;
import org.wso2.integrationstudio.gmf.esb.Template;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HTTPEndpointItemProvider extends AbstractEndPointItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HTTPEndpointItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

        super.getPropertyDescriptors(object);

        if (itemPropertyDescriptors != null) {
            itemPropertyDescriptors.clear();
        }
        addStatisticsEnabledPropertyDescriptor(object);
        addTraceEnabledPropertyDescriptor(object);
        addURITemplatePropertyDescriptor(object);
        addHttpMethodPropertyDescriptor(object);
        addDescriptionPropertyDescriptor(object);
        addPropertiesPropertyDescriptor(object);

        // Auth Configuration
        addAuthTypePropertyDescriptor(object);
        addBasicAuthUsernamePropertyDescriptor(object);
        addBasicAuthPasswordPropertyDescriptor(object);
        addOAuthGrantTypePropertyDescriptor(object);
        addOAuthClientIdPropertyDescriptor(object);
        addOAuthClientSecretPropertyDescriptor(object);
        addOAuthRefreshTokenPropertyDescriptor(object);
        addOAuthTokenUrlPropertyDescriptor(object);

        // Suspend.
        addSuspendErrorCodesPropertyDescriptor(object);
        addSuspendInitialDurationPropertyDescriptor(object);
        addSuspendMaximumDurationPropertyDescriptor(object);
        addSuspendProgressionFactorPropertyDescriptor(object);

        // Retry.
        addRetryErrorCodesPropertyDescriptor(object);
        addRetryCountPropertyDescriptor(object);
        addRetryDelayPropertyDescriptor(object);

        // Timeout.
        addTimeOutDurationPropertyDescriptor(object);
        addTimeOutActionPropertyDescriptor(object);

        if (((HTTPEndpoint) object).eContainer() != null) {
            if (((HTTPEndpoint) object).eContainer().eContainer() instanceof Template) {
                addTemplateParametersPropertyDescriptor(object);
            }
        }

        /*
         * if (itemPropertyDescriptors == null) {
         * super.getPropertyDescriptors(object);
         * 
         * addURITemplatePropertyDescriptor(object);
         * addHttpMethodPropertyDescriptor(object);
         * }
         */
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the URI Template feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addURITemplatePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HTTPEndpoint_URITemplate_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_URITemplate_feature",
                                "_UI_HTTPEndpoint_type"),
                        EsbPackage.Literals.HTTP_ENDPOINT__URI_TEMPLATE, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Basic", null));
    }

    /**
     * This adds a property descriptor for the Http Method feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addHttpMethodPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HTTPEndpoint_HttpMethod_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_HttpMethod_feature",
                                "_UI_HTTPEndpoint_type"),
                        EsbPackage.Literals.HTTP_ENDPOINT__HTTP_METHOD, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Basic", null));
    }

    /**
     * This adds a property descriptor for the OAuth Grant Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthGrantTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthGrantType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthGrantType_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_GRANT_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Authentication Mode feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthAuthenticationModePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthAuthenticationMode_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthAuthenticationMode_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Client Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthClientIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthClientId_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthClientId_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_CLIENT_ID,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Client Secret feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthClientSecretPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthClientSecret_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthClientSecret_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Token Url feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthTokenUrlPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthTokenUrl_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthTokenUrl_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_TOKEN_URL,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Refresh Token feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthRefreshTokenPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthRefreshToken_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthRefreshToken_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Auth Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAuthTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_AuthType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_AuthType_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__AUTH_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Basic Auth Username feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBasicAuthUsernamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_BasicAuthUsername_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_BasicAuthUsername_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__BASIC_AUTH_USERNAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Basic Auth Password feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBasicAuthPasswordPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_BasicAuthPassword_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_BasicAuthPassword_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Username feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthUsernamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthUsername_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthUsername_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_USERNAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Password feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthPasswordPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthPassword_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthPassword_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_PASSWORD,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Client Id Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthClientIdExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthClientIdExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthClientIdExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_CLIENT_ID_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Client Secret Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthClientSecretExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthClientSecretExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthClientSecretExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Token Url Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthTokenUrlExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthTokenUrlExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthTokenUrlExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_TOKEN_URL_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Refresh Token Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthRefreshTokenExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthRefreshTokenExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthRefreshTokenExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Basic Auth Username Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBasicAuthUsernameExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_BasicAuthUsernameExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_BasicAuthUsernameExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__BASIC_AUTH_USERNAME_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Basic Auth Password Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBasicAuthPasswordExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_BasicAuthPasswordExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_BasicAuthPasswordExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Username Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthUsernameExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthUsernameExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthUsernameExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_USERNAME_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the OAuth Password Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOAuthPasswordExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HTTPEndpoint_OAuthPasswordExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HTTPEndpoint_OAuthPasswordExpression_feature", "_UI_HTTPEndpoint_type"),
                 EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_PASSWORD_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Properties feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addPropertiesPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_EndPoint_properties_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_EndPoint_properties_feature",
                                "_UI_EndPoint_type"),
                        EsbPackage.Literals.END_POINT__PROPERTIES, true, false, true, null, "Endpoint Properties",
                        null));
    }

    /**
     * This adds a property descriptor for the Description feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_EsbElement_description_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_EsbElement_description_feature",
                                "_UI_EsbElement_type"),
                        EsbPackage.Literals.ESB_ELEMENT__DESCRIPTION, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Endpoint Description", null));
    }

    /**
     * This adds a property descriptor for the Time Out Duration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addTimeOutDurationPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_AbstractEndPoint_timeOutDuration_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_timeOutDuration_feature",
                                "_UI_AbstractEndPoint_type"),
                        EsbPackage.Literals.ABSTRACT_END_POINT__TIME_OUT_DURATION, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, "Timeout", null));
    }

    /**
     * This adds a property descriptor for the Time Out Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addTimeOutActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_AbstractEndPoint_timeOutAction_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_timeOutAction_feature",
                                "_UI_AbstractEndPoint_type"),
                        EsbPackage.Literals.ABSTRACT_END_POINT__TIME_OUT_ACTION, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Timeout", null));
    }

    /**
     * This adds a property descriptor for the Retry Error Codes feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addRetryErrorCodesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractEndPoint_retryErrorCodes_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_retryErrorCodes_feature",
                        "_UI_AbstractEndPoint_type"),
                EsbPackage.Literals.ABSTRACT_END_POINT__RETRY_ERROR_CODES, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Endpoint Timeout State", null));
    }

    /**
     * This adds a property descriptor for the Retry Count feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addRetryCountPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_AbstractEndPoint_retryCount_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_retryCount_feature",
                                "_UI_AbstractEndPoint_type"),
                        EsbPackage.Literals.ABSTRACT_END_POINT__RETRY_COUNT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, "Endpoint Timeout State", null));
    }

    /**
     * This adds a property descriptor for the Retry Delay feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addRetryDelayPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_AbstractEndPoint_retryDelay_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_retryDelay_feature",
                                "_UI_AbstractEndPoint_type"),
                        EsbPackage.Literals.ABSTRACT_END_POINT__RETRY_DELAY, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, "Endpoint Timeout State", null));
    }

    /**
     * This adds a property descriptor for the Suspend Error Codes feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addSuspendErrorCodesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractEndPoint_suspendErrorCodes_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendErrorCodes_feature",
                        "_UI_AbstractEndPoint_type"),
                EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Endpoint Suspend State", null));
    }

    /**
     * This adds a property descriptor for the Suspend Initial Duration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addSuspendInitialDurationPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractEndPoint_suspendInitialDuration_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendInitialDuration_feature",
                        "_UI_AbstractEndPoint_type"),
                EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, "Endpoint Suspend State", null));
    }

    /**
     * This adds a property descriptor for the Suspend Maximum Duration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addSuspendMaximumDurationPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractEndPoint_suspendMaximumDuration_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendMaximumDuration_feature",
                        "_UI_AbstractEndPoint_type"),
                EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, "Endpoint Suspend State", null));
    }

    /**
     * This adds a property descriptor for the Suspend Progression Factor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addSuspendProgressionFactorPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_AbstractEndPoint_suspendProgressionFactor_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_AbstractEndPoint_suspendProgressionFactor_feature", "_UI_AbstractEndPoint_type"),
                        EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR, true, false, false,
                        ItemPropertyDescriptor.REAL_VALUE_IMAGE, "Endpoint Suspend State", null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(EsbPackage.Literals.HTTP_ENDPOINT__INPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.HTTP_ENDPOINT__OUTPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_PARAMETERS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns HTTPEndpoint.png.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/HTTPEndpoint.png"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((HTTPEndpoint)object).getEndPointName();
        return label == null || label.length() == 0 ?
            getString("_UI_HTTPEndpoint_type") :
            getString("_UI_HTTPEndpoint_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(HTTPEndpoint.class)) {
            case EsbPackage.HTTP_ENDPOINT__URI_TEMPLATE:
            case EsbPackage.HTTP_ENDPOINT__HTTP_METHOD:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_GRANT_TYPE:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_AUTHENTICATION_MODE:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_ID:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_CLIENT_SECRET:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_TOKEN_URL:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_REFRESH_TOKEN:
            case EsbPackage.HTTP_ENDPOINT__AUTH_TYPE:
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_USERNAME:
            case EsbPackage.HTTP_ENDPOINT__BASIC_AUTH_PASSWORD:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_USERNAME:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_PASSWORD:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EsbPackage.HTTP_ENDPOINT__INPUT_CONNECTOR:
            case EsbPackage.HTTP_ENDPOINT__OUTPUT_CONNECTOR:
            case EsbPackage.HTTP_ENDPOINT__OAUTH_PARAMETERS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.HTTP_ENDPOINT__INPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createHTTPEndPointInputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.HTTP_ENDPOINT__OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createHTTPEndPointOutputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.HTTP_ENDPOINT__OAUTH_PARAMETERS,
                 EsbFactory.eINSTANCE.createHTTPEndpointOAuthParameter()));
    }

    /**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify =
            childFeature == EsbPackage.Literals.ABSTRACT_END_POINT__INBOUND_POLICY ||
            childFeature == EsbPackage.Literals.ABSTRACT_END_POINT__OUTBOUND_POLICY;

        if (qualify) {
            return getString
                ("_UI_CreateChild_text2",
                 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

}
