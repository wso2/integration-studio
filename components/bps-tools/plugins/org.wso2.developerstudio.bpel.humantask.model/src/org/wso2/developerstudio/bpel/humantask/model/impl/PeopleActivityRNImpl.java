/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 *
 */
package org.wso2.developerstudio.bpel.humantask.model.impl;

import org.eclipse.bpel.model.Variable;

import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.smila.processing.designer.model.processor.util.DOMUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.model.util.HTConstants;
import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>People Activity RN</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRNImpl#getInputVariable
 * <em>Input Variable</em>}</li>
 * <li>
 * {@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRNImpl#getRemoteNotification
 * <em>Remote Notification</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PeopleActivityRNImpl extends ExtensionActivityImpl implements
		PeopleActivityRN {
	/**
	 * The cached value of the '{@link #getInputVariable()
	 * <em>Input Variable</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getInputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable inputVariable;

	/**
	 * The cached value of the '{@link #getRemoteNotification()
	 * <em>Remote Notification</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getRemoteNotification()
	 * @generated
	 * @ordered
	 */
	protected RemoteNotification remoteNotification;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PeopleActivityRNImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PEOPLE_ACTIVITY_RN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Variable getInputVariable() {
		if (inputVariable != null && inputVariable.eIsProxy()) {
			InternalEObject oldInputVariable = (InternalEObject) inputVariable;
			inputVariable = (Variable) eResolveProxy(oldInputVariable);
			if (inputVariable != oldInputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelPackage.PEOPLE_ACTIVITY_RN__INPUT_VARIABLE,
							oldInputVariable, inputVariable));
			}
		}
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Variable basicGetInputVariable() {
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setInputVariable(Variable newInputVariable) {
		Variable oldInputVariable = inputVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					HTConstants.AT_INPUT_VARIABLE,
					newInputVariable == null ? null : newInputVariable
							.getName());
		}
		inputVariable = newInputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PEOPLE_ACTIVITY_RN__INPUT_VARIABLE,
					oldInputVariable, inputVariable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RemoteNotification getRemoteNotification() {
		return remoteNotification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public NotificationChain basicSetRemoteNotification(
			RemoteNotification newRemoteNotification, NotificationChain msgs) {
		RemoteNotification oldRemoteNotification = remoteNotification;

		replaceChild(oldRemoteNotification, newRemoteNotification);	
		
		remoteNotification = newRemoteNotification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION,
					oldRemoteNotification, newRemoteNotification);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRemoteNotification(RemoteNotification newRemoteNotification) {
		if (newRemoteNotification != remoteNotification) {
			NotificationChain msgs = null;
			if (remoteNotification != null)
				msgs = ((InternalEObject) remoteNotification)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION,
								null, msgs);
			if (newRemoteNotification != null)
				msgs = ((InternalEObject) newRemoteNotification)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION,
								null, msgs);
			msgs = basicSetRemoteNotification(newRemoteNotification, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION,
					newRemoteNotification, newRemoteNotification));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Element fixElement(Document document) {
		if (getElement() == null && !isUpdatingDOM()) {
		      try {
		        setUpdatingDOM(true);
		        Element element =
		          document.createElementNS(ModelPackage.eNS_URI, HTConstants.ND_PEOPLE_ACTIVITY_RN);
		        element.setPrefix(ModelPackage.eNS_PREFIX);
		        setElement(element);
		        if (getRemoteNotification() != null) {
		          DOMUtils.appendIndented(element, getRemoteNotification().fixElement(document));
		        }
		      } finally {
		        setUpdatingDOM(false);
		      }
		    }
		    return getElement();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION:
			return basicSetRemoteNotification(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.PEOPLE_ACTIVITY_RN__INPUT_VARIABLE:
			if (resolve)
				return getInputVariable();
			return basicGetInputVariable();
		case ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION:
			return getRemoteNotification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.PEOPLE_ACTIVITY_RN__INPUT_VARIABLE:
			setInputVariable((Variable) newValue);
			return;
		case ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION:
			setRemoteNotification((RemoteNotification) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.PEOPLE_ACTIVITY_RN__INPUT_VARIABLE:
			setInputVariable((Variable) null);
			return;
		case ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION:
			setRemoteNotification((RemoteNotification) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.PEOPLE_ACTIVITY_RN__INPUT_VARIABLE:
			return inputVariable != null;
		case ModelPackage.PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION:
			return remoteNotification != null;
		}
		return super.eIsSet(featureID);
	}

	protected <E extends ExtensionElement> void replaceChild(E oldElement, E newElement) {
	    if (!isReconciling() && !isUpdatingDOM() && getElement() != null && !ReconciliationHelper.isLoading(this)) {
	      if (newElement.fixElement(getElement().getOwnerDocument()) != null) {
	        ReconciliationHelper.replaceChild(this, oldElement, newElement);
	      }
	    }
	  }
} // PeopleActivityRNImpl
