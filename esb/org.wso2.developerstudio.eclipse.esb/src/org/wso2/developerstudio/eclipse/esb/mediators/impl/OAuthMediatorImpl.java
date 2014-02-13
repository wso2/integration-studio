/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OAuth Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.OAuthMediatorImpl#getRemoteServiceUrl <em>Remote Service Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OAuthMediatorImpl extends MediatorImpl implements OAuthMediator {
	/**
	 * The default value of the '{@link #getRemoteServiceUrl() <em>Remote Service Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteServiceUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_SERVICE_URL_EDEFAULT = "service_url";

	/**
	 * The cached value of the '{@link #getRemoteServiceUrl() <em>Remote Service Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteServiceUrl()
	 * @generated
	 * @ordered
	 */
	protected String remoteServiceUrl = REMOTE_SERVICE_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OAuthMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("remoteServiceUrl")) {
			setRemoteServiceUrl(self.getAttribute("remoteServiceUrl"));
		}
		super.doLoad(self);
	}


	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent,"oauthService");
		self.setAttribute("remoteServiceUrl", getRemoteServiceUrl());
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.OAUTH_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteServiceUrl() {
		return remoteServiceUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteServiceUrl(String newRemoteServiceUrl) {
		String oldRemoteServiceUrl = remoteServiceUrl;
		remoteServiceUrl = newRemoteServiceUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.OAUTH_MEDIATOR__REMOTE_SERVICE_URL, oldRemoteServiceUrl, remoteServiceUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.OAUTH_MEDIATOR__REMOTE_SERVICE_URL:
				return getRemoteServiceUrl();
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
			case MediatorsPackage.OAUTH_MEDIATOR__REMOTE_SERVICE_URL:
				setRemoteServiceUrl((String)newValue);
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
			case MediatorsPackage.OAUTH_MEDIATOR__REMOTE_SERVICE_URL:
				setRemoteServiceUrl(REMOTE_SERVICE_URL_EDEFAULT);
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
			case MediatorsPackage.OAUTH_MEDIATOR__REMOTE_SERVICE_URL:
				return REMOTE_SERVICE_URL_EDEFAULT == null ? remoteServiceUrl != null : !REMOTE_SERVICE_URL_EDEFAULT.equals(remoteServiceUrl);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (remoteServiceUrl: ");
		result.append(remoteServiceUrl);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (null == getRemoteServiceUrl() || getRemoteServiceUrl().trim().isEmpty()) {
			validateMap.put("RemoteService URL","RemoteService URL Context is empty");
		}
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Entitlement Mediator", objectValidator);
 	    return mediatorValidateMap;
    }
	
} //OAuthMediatorImpl
