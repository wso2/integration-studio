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

import javax.wsdl.extensions.ExtensibilityElement;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.wst.wsdl.Operation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.model.util.HTConstants;
import org.wso2.developerstudio.bpel.humantask.record.impl.ExtensionElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remote Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.RemoteNotificationImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.RemoteNotificationImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RemoteNotificationImpl extends ExtensionElementImpl implements RemoteNotification {
	/**
	 * The cached value of the '{@link #getPartnerLink() <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected PartnerLink partnerLink;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoteNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	protected EClass eStaticClass() {
		return ModelPackage.Literals.REMOTE_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink getPartnerLink() {
		if (partnerLink != null && partnerLink.eIsProxy()) {
			InternalEObject oldPartnerLink = (InternalEObject)partnerLink;
			partnerLink = (PartnerLink)eResolveProxy(oldPartnerLink);
			if (partnerLink != oldPartnerLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REMOTE_NOTIFICATION__PARTNER_LINK, oldPartnerLink, partnerLink));
			}
		}
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink basicGetPartnerLink() {
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPartnerLink(PartnerLink newPartnerLink) {
		PartnerLink oldPartnerLink = partnerLink;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					HTConstants.AT_PARTNER_LINK,
					newPartnerLink == null ? null : newPartnerLink.getName());
		}
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REMOTE_NOTIFICATION__PARTNER_LINK, oldPartnerLink, partnerLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperation() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (Operation)eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REMOTE_NOTIFICATION__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOperation(Operation newOperation) {
		Operation oldOperation = operation;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					HTConstants.AT_OPERATION, newOperation == null ? null
							: newOperation.getName());
		}
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REMOTE_NOTIFICATION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.REMOTE_NOTIFICATION__PARTNER_LINK:
				if (resolve) return getPartnerLink();
				return basicGetPartnerLink();
			case ModelPackage.REMOTE_NOTIFICATION__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.REMOTE_NOTIFICATION__PARTNER_LINK:
				setPartnerLink((PartnerLink)newValue);
				return;
			case ModelPackage.REMOTE_NOTIFICATION__OPERATION:
				setOperation((Operation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.REMOTE_NOTIFICATION__PARTNER_LINK:
				setPartnerLink((PartnerLink)null);
				return;
			case ModelPackage.REMOTE_NOTIFICATION__OPERATION:
				setOperation((Operation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.REMOTE_NOTIFICATION__PARTNER_LINK:
				return partnerLink != null;
			case ModelPackage.REMOTE_NOTIFICATION__OPERATION:
				return operation != null;
		}
		return super.eIsSet(featureID);
	}

	

	
	protected Element createFixedElement(Document document) {
		 Element element = document.createElementNS(ModelPackage.eNS_URI, HTConstants.ND_REMOTE_NOTIFICATION);
		    element.setPrefix(ModelPackage.eNS_PREFIX);
		    if (partnerLink != null) {
		      element.setAttribute(HTConstants.AT_PARTNER_LINK, partnerLink.getName());
		    }
		    if (operation != null) {
		      element.setAttribute(HTConstants.AT_OPERATION, operation.getName());
		    }
		    return element;
	}

} //RemoteNotificationImpl
