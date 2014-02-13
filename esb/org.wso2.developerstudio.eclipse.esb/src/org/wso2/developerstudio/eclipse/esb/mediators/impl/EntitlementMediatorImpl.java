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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entitlement Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getServerURL <em>Server URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getOnAccept <em>On Accept</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getOnReject <em>On Reject</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getObligations <em>Obligations</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getAdvice <em>Advice</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl#getCallbackClass <em>Callback Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntitlementMediatorImpl extends MediatorImpl implements EntitlementMediator {
	/**
	 * The default value of the '{@link #getServerURL() <em>Server URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerURL()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_URL_EDEFAULT = "server_url";

	/**
	 * The cached value of the '{@link #getServerURL() <em>Server URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerURL()
	 * @generated
	 * @ordered
	 */
	protected String serverURL = SERVER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = "username";

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = "password";

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOnAccept() <em>On Accept</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAccept()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorOnAcceptBranch onAccept;

	/**
	 * The cached value of the '{@link #getOnReject() <em>On Reject</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnReject()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorOnRejectBranch onReject;

	/**
	 * The cached value of the '{@link #getObligations() <em>Obligations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObligations()
	 * @generated
	 * @ordered
	 */
	protected EntitlementObligationsBranch obligations;

	/**
	 * The cached value of the '{@link #getAdvice() <em>Advice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvice()
	 * @generated
	 * @ordered
	 */
	protected EntitlementAdviceBranch advice;

	/**
	 * The default value of the '{@link #getCallbackClass() <em>Callback Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallbackClass()
	 * @generated
	 * @ordered
	 */
	protected static final String CALLBACK_CLASS_EDEFAULT = "callbackClass";

	/**
	 * The cached value of the '{@link #getCallbackClass() <em>Callback Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallbackClass()
	 * @generated
	 * @ordered
	 */
	protected String callbackClass = CALLBACK_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *  
	 */
	protected EntitlementMediatorImpl() {
		super();
		setOnAccept(getMediatorFactory().createEntitlementMediatorOnAcceptBranch());
		setOnReject(getMediatorFactory().createEntitlementMediatorOnRejectBranch());
		setObligations(getMediatorFactory().createEntitlementObligationsBranch());
		setAdvice(getMediatorFactory().createEntitlementAdviceBranch());
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		setServerURL(self.getAttribute("remoteServiceUrl"));
		setUsername(self.getAttribute("remoteServiceUserName"));
		setPassword(self.getAttribute("remoteServicePassword"));
		String callbackClass = self.getAttribute("callbackClass");
		if(callbackClass!=null && !"".equals(callbackClass) && !"callbackClass".equals(callbackClass)){
			 setCallbackClass(callbackClass);
		} 
		getOnAccept().load(self);
		getOnReject().load(self);
		getAdvice().load(self);
		getObligations().load(self);
		
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self =  createChildElement(parent, "entitlementService");		
		self.setAttribute("remoteServiceUrl", getServerURL());		
		self.setAttribute("remoteServiceUserName", getUsername());		
		self.setAttribute("remoteServicePassword", getPassword());	
		String callbackClass = getCallbackClass();
		if(callbackClass!=null && !"".equals(callbackClass)&&!"callbackClass".equals(callbackClass)){
			self.setAttribute("callbackClass", callbackClass);	
		}
		getOnAccept().save(self);
		getOnReject().save(self);
		getObligations().save(self);
		getAdvice().save(self);
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
		return MediatorsPackage.Literals.ENTITLEMENT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerURL() {
		return serverURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerURL(String newServerURL) {
		String oldServerURL = serverURL;
		serverURL = newServerURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__SERVER_URL, oldServerURL, serverURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnAcceptBranch getOnAccept() {
		return onAccept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnAccept(EntitlementMediatorOnAcceptBranch newOnAccept, NotificationChain msgs) {
		EntitlementMediatorOnAcceptBranch oldOnAccept = onAccept;
		onAccept = newOnAccept;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT, oldOnAccept, newOnAccept);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAccept(EntitlementMediatorOnAcceptBranch newOnAccept) {
		if (newOnAccept != onAccept) {
			NotificationChain msgs = null;
			if (onAccept != null)
				msgs = ((InternalEObject)onAccept).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT, null, msgs);
			if (newOnAccept != null)
				msgs = ((InternalEObject)newOnAccept).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT, null, msgs);
			msgs = basicSetOnAccept(newOnAccept, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT, newOnAccept, newOnAccept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnRejectBranch getOnReject() {
		return onReject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnReject(EntitlementMediatorOnRejectBranch newOnReject, NotificationChain msgs) {
		EntitlementMediatorOnRejectBranch oldOnReject = onReject;
		onReject = newOnReject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT, oldOnReject, newOnReject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnReject(EntitlementMediatorOnRejectBranch newOnReject) {
		if (newOnReject != onReject) {
			NotificationChain msgs = null;
			if (onReject != null)
				msgs = ((InternalEObject)onReject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT, null, msgs);
			if (newOnReject != null)
				msgs = ((InternalEObject)newOnReject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT, null, msgs);
			msgs = basicSetOnReject(newOnReject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT, newOnReject, newOnReject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementObligationsBranch getObligations() {
		return obligations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObligations(EntitlementObligationsBranch newObligations, NotificationChain msgs) {
		EntitlementObligationsBranch oldObligations = obligations;
		obligations = newObligations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS, oldObligations, newObligations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObligations(EntitlementObligationsBranch newObligations) {
		if (newObligations != obligations) {
			NotificationChain msgs = null;
			if (obligations != null)
				msgs = ((InternalEObject)obligations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS, null, msgs);
			if (newObligations != null)
				msgs = ((InternalEObject)newObligations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS, null, msgs);
			msgs = basicSetObligations(newObligations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS, newObligations, newObligations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementAdviceBranch getAdvice() {
		return advice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdvice(EntitlementAdviceBranch newAdvice, NotificationChain msgs) {
		EntitlementAdviceBranch oldAdvice = advice;
		advice = newAdvice;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE, oldAdvice, newAdvice);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvice(EntitlementAdviceBranch newAdvice) {
		if (newAdvice != advice) {
			NotificationChain msgs = null;
			if (advice != null)
				msgs = ((InternalEObject)advice).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE, null, msgs);
			if (newAdvice != null)
				msgs = ((InternalEObject)newAdvice).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE, null, msgs);
			msgs = basicSetAdvice(newAdvice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE, newAdvice, newAdvice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCallbackClass() {
		return callbackClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallbackClass(String newCallbackClass) {
		String oldCallbackClass = callbackClass;
		callbackClass = newCallbackClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS, oldCallbackClass, callbackClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT:
				return basicSetOnAccept(null, msgs);
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT:
				return basicSetOnReject(null, msgs);
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS:
				return basicSetObligations(null, msgs);
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE:
				return basicSetAdvice(null, msgs);
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
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__SERVER_URL:
				return getServerURL();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				return getUsername();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				return getPassword();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT:
				return getOnAccept();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT:
				return getOnReject();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS:
				return getObligations();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE:
				return getAdvice();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS:
				return getCallbackClass();
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
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__SERVER_URL:
				setServerURL((String)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				setUsername((String)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				setPassword((String)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT:
				setOnAccept((EntitlementMediatorOnAcceptBranch)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT:
				setOnReject((EntitlementMediatorOnRejectBranch)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS:
				setObligations((EntitlementObligationsBranch)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE:
				setAdvice((EntitlementAdviceBranch)newValue);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS:
				setCallbackClass((String)newValue);
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
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__SERVER_URL:
				setServerURL(SERVER_URL_EDEFAULT);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT:
				setOnAccept((EntitlementMediatorOnAcceptBranch)null);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT:
				setOnReject((EntitlementMediatorOnRejectBranch)null);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS:
				setObligations((EntitlementObligationsBranch)null);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE:
				setAdvice((EntitlementAdviceBranch)null);
				return;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS:
				setCallbackClass(CALLBACK_CLASS_EDEFAULT);
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
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__SERVER_URL:
				return SERVER_URL_EDEFAULT == null ? serverURL != null : !SERVER_URL_EDEFAULT.equals(serverURL);
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT:
				return onAccept != null;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ON_REJECT:
				return onReject != null;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS:
				return obligations != null;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__ADVICE:
				return advice != null;
			case MediatorsPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS:
				return CALLBACK_CLASS_EDEFAULT == null ? callbackClass != null : !CALLBACK_CLASS_EDEFAULT.equals(callbackClass);
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
		result.append(" (serverURL: ");
		result.append(serverURL);
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(", callbackClass: ");
		result.append(callbackClass);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (null == getServerURL() || getServerURL().trim().isEmpty()) {
			validateMap.put("RemoteService URL","RemoteService URL Context is empty");
		}
		if (null == getUsername() || getUsername().trim().isEmpty()) {
			validateMap.put("remoteService username","RemoteService username is empty");
		}
		if (null == getPassword() || getPassword().trim().isEmpty()) {
			validateMap.put("remoteService password","RemoteService password is empty");
		}	
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Entitlement Mediator", objectValidator);
 	    return mediatorValidateMap;
    }
 
	
} //EntitlementMediatorImpl
