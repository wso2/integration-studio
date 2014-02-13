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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RM Sequence Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl#getRmSpecVersion <em>Rm Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl#getCorrelationXpath <em>Correlation Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl#getLastMessageXpath <em>Last Message Xpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RMSequenceMediatorImpl extends MediatorImpl implements RMSequenceMediator {
	/**
	 * The default value of the '{@link #getRmSpecVersion() <em>Rm Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRmSpecVersion()
	 * @generated
	 * @ordered
	 */
	protected static final RMSpecVersion RM_SPEC_VERSION_EDEFAULT = RMSpecVersion.VERSION_10;

	/**
	 * The cached value of the '{@link #getRmSpecVersion() <em>Rm Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRmSpecVersion()
	 * @generated
	 * @ordered
	 */
	protected RMSpecVersion rmSpecVersion = RM_SPEC_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final RMSequenceType SEQUENCE_TYPE_EDEFAULT = RMSequenceType.SINGLE_MESSAGE;

	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected RMSequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCorrelationXpath() <em>Correlation Xpath</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty correlationXpath;

	/**
	 * The cached value of the '{@link #getLastMessageXpath() <em>Last Message Xpath</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMessageXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty lastMessageXpath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected RMSequenceMediatorImpl() {
		super();
		
		// Correlation xpath.
		NamespacedProperty correlationXpath = getEsbFactory().createNamespacedProperty();
		correlationXpath.setPrettyName("Sequence XPath");
		correlationXpath.setPropertyName("correlation");
		correlationXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setCorrelationXpath(correlationXpath);
		
		// Last message xpath.
		NamespacedProperty lastMessageXpath = getEsbFactory().createNamespacedProperty();
		lastMessageXpath.setPrettyName("Last message XPath");
		lastMessageXpath.setPropertyName("last-message");
		setLastMessageXpath(lastMessageXpath);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// WSRM spec version.
		RMSpecVersion version = RMSpecVersion.get(self.getAttribute("version"));
		if (null != version) {
			setRmSpecVersion(version);
		} else {
			throw new Exception("Unknown WSRM spec version.");
		}
		
		// RM sequence.
		if (self.getAttribute("single").equalsIgnoreCase("true")) {
			setSequenceType(RMSequenceType.SINGLE_MESSAGE);
		} else {
			setSequenceType(RMSequenceType.CORRELATED_SEQUENCE);
			getLastMessageXpath().load(self);
			getCorrelationXpath().load(self);
		}
		super.doLoad(self);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "RMSequence");
		
		// RM spec version.
		self.setAttribute("version", getRmSpecVersion().getLiteral());
		
		// RM sequence.
		if (getSequenceType().equals(RMSequenceType.SINGLE_MESSAGE)) {
			self.setAttribute("single",	"true");
		} else {
			getLastMessageXpath().save(self);
			getCorrelationXpath().save(self);
		}
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
		return MediatorsPackage.Literals.RM_SEQUENCE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSpecVersion getRmSpecVersion() {
		return rmSpecVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRmSpecVersion(RMSpecVersion newRmSpecVersion) {
		RMSpecVersion oldRmSpecVersion = rmSpecVersion;
		rmSpecVersion = newRmSpecVersion == null ? RM_SPEC_VERSION_EDEFAULT : newRmSpecVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION, oldRmSpecVersion, rmSpecVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(RMSequenceType newSequenceType) {
		RMSequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getCorrelationXpath() {
		if (correlationXpath != null && correlationXpath.eIsProxy()) {
			InternalEObject oldCorrelationXpath = (InternalEObject)correlationXpath;
			correlationXpath = (NamespacedProperty)eResolveProxy(oldCorrelationXpath);
			if (correlationXpath != oldCorrelationXpath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH, oldCorrelationXpath, correlationXpath));
			}
		}
		return correlationXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetCorrelationXpath() {
		return correlationXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelationXpath(NamespacedProperty newCorrelationXpath) {
		NamespacedProperty oldCorrelationXpath = correlationXpath;
		correlationXpath = newCorrelationXpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH, oldCorrelationXpath, correlationXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getLastMessageXpath() {
		if (lastMessageXpath != null && lastMessageXpath.eIsProxy()) {
			InternalEObject oldLastMessageXpath = (InternalEObject)lastMessageXpath;
			lastMessageXpath = (NamespacedProperty)eResolveProxy(oldLastMessageXpath);
			if (lastMessageXpath != oldLastMessageXpath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH, oldLastMessageXpath, lastMessageXpath));
			}
		}
		return lastMessageXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetLastMessageXpath() {
		return lastMessageXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastMessageXpath(NamespacedProperty newLastMessageXpath) {
		NamespacedProperty oldLastMessageXpath = lastMessageXpath;
		lastMessageXpath = newLastMessageXpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH, oldLastMessageXpath, lastMessageXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				return getRmSpecVersion();
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				return getSequenceType();
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				if (resolve) return getCorrelationXpath();
				return basicGetCorrelationXpath();
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				if (resolve) return getLastMessageXpath();
				return basicGetLastMessageXpath();
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
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				setRmSpecVersion((RMSpecVersion)newValue);
				return;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType((RMSequenceType)newValue);
				return;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				setCorrelationXpath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				setLastMessageXpath((NamespacedProperty)newValue);
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
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				setRmSpecVersion(RM_SPEC_VERSION_EDEFAULT);
				return;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				setCorrelationXpath((NamespacedProperty)null);
				return;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				setLastMessageXpath((NamespacedProperty)null);
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
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				return rmSpecVersion != RM_SPEC_VERSION_EDEFAULT;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				return correlationXpath != null;
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				return lastMessageXpath != null;
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
		result.append(" (rmSpecVersion: ");
		result.append(rmSpecVersion);
		result.append(", sequenceType: ");
		result.append(sequenceType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
 		if (getSequenceType().equals(RMSequenceType.CORRELATED_SEQUENCE)) {
			if (null == getCorrelationXpath().getPropertyValue()|| getCorrelationXpath().getPropertyValue().trim().isEmpty()) {
	 			validateMap.put("Correlation Xpath", "Correlation Xpath is empty");
	 		}
		} 
 					
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("RMSequence Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} //RMSequenceMediatorImpl
