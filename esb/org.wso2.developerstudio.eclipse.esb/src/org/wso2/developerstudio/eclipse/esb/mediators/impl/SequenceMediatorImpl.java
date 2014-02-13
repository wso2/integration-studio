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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sequence Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl#getReferringSequenceType <em>Referring Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl#getDynamicReferenceKey <em>Dynamic Reference Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl#getStaticReferenceKey <em>Static Reference Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl#getSequenceKey <em>Sequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceMediatorImpl extends MediatorImpl implements
		SequenceMediator {
	/**
	 * The default value of the '{@link #getReferringSequenceType() <em>Referring Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferringSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType REFERRING_SEQUENCE_TYPE_EDEFAULT = KeyType.STATIC;
	/**
	 * The cached value of the '{@link #getReferringSequenceType() <em>Referring Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferringSequenceType()
	 * @generated
	 * @ordered
	 */
	protected KeyType referringSequenceType = REFERRING_SEQUENCE_TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDynamicReferenceKey() <em>Dynamic Reference Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDynamicReferenceKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicReferenceKey;
	/**
	 * The cached value of the '{@link #getStaticReferenceKey() <em>Static Reference Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getStaticReferenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty staticReferenceKey;

	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected SequenceMediatorImpl() {
		super();
		// Static Reference Key
		staticReferenceKey = getEsbFactory().createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) staticReferenceKey.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		staticReferenceKey.setPrettyName("Static Reference Key");
		staticReferenceKey.setKeyName("key");
		staticReferenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setStaticReferenceKey(staticReferenceKey);

		// Dynamic Reference Key
		dynamicReferenceKey = getEsbFactory().createNamespacedProperty();
		dynamicReferenceKey.setPropertyName("key");
		dynamicReferenceKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		dynamicReferenceKey.setPrettyName("Dynamic Reference Key");
		setDynamicReferenceKey(dynamicReferenceKey);
		
		// Sequence key.
		sequenceKey = getEsbFactory().createRegistryKeyProperty();
		//Set filter properties to filter in only sequences media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)sequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);

		sequenceKey.setPrettyName("Sequence Key");
		sequenceKey.setKeyName("key");
		sequenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setSequenceKey(sequenceKey);

	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		switch (getCurrentEsbVersion()) {
		case ESB301:
			if (self.hasAttribute("key")) {
				getSequenceKey().load(self);
			} else {
				throw new Exception("Expected sequence key.");
			}
		 break;

		case ESB400:
			if (self.hasAttribute("key")) {
				getSequenceKey().load(self);
				String referenceKeyValue = self.getAttribute("key");
				if (referenceKeyValue == null) {
					referenceKeyValue = "";
				}
				referenceKeyValue = referenceKeyValue.trim();
				if (referenceKeyValue.startsWith("{")
						&& referenceKeyValue.endsWith("}")) {
					setReferringSequenceType(getReferringSequenceType().DYNAMIC);
					referenceKeyValue = referenceKeyValue.substring(1,
							referenceKeyValue.length() - 1);
					getDynamicReferenceKey()
							.setPropertyValue(referenceKeyValue);
				} else {
					setReferringSequenceType(getReferringSequenceType().STATIC);
					getStaticReferenceKey().setKeyValue(referenceKeyValue);
				}
			} else {
				setReferringSequenceType(getReferringSequenceType().STATIC);
				// throw new Exception("Expected sequence key.");
			}
			break;
		}
		super.doLoad(self);
		
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "sequence");
		switch (getCurrentEsbVersion()) {

		case ESB301:
			getSequenceKey().save(self);
			break;

		case ESB400:
			switch (getReferringSequenceType()) {
			case STATIC:
				getStaticReferenceKey().save(self);
				break;
			case DYNAMIC:
				self.setAttribute(getDynamicReferenceKey().getPropertyName(),
						"{" + getDynamicReferenceKey().getPropertyValue() + "}");
				break;
			}
			break;
		}
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.SEQUENCE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getReferringSequenceType() {
		return referringSequenceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferringSequenceType(KeyType newReferringSequenceType) {
		KeyType oldReferringSequenceType = referringSequenceType;
		referringSequenceType = newReferringSequenceType == null ? REFERRING_SEQUENCE_TYPE_EDEFAULT : newReferringSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE, oldReferringSequenceType, referringSequenceType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicReferenceKey() {
		if (dynamicReferenceKey != null && dynamicReferenceKey.eIsProxy()) {
			InternalEObject oldDynamicReferenceKey = (InternalEObject)dynamicReferenceKey;
			dynamicReferenceKey = (NamespacedProperty)eResolveProxy(oldDynamicReferenceKey);
			if (dynamicReferenceKey != oldDynamicReferenceKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY, oldDynamicReferenceKey, dynamicReferenceKey));
			}
		}
		return dynamicReferenceKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetDynamicReferenceKey() {
		return dynamicReferenceKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicReferenceKey(NamespacedProperty newDynamicReferenceKey) {
		NamespacedProperty oldDynamicReferenceKey = dynamicReferenceKey;
		dynamicReferenceKey = newDynamicReferenceKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY, oldDynamicReferenceKey, dynamicReferenceKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getStaticReferenceKey() {
		if (staticReferenceKey != null && staticReferenceKey.eIsProxy()) {
			InternalEObject oldStaticReferenceKey = (InternalEObject)staticReferenceKey;
			staticReferenceKey = (RegistryKeyProperty)eResolveProxy(oldStaticReferenceKey);
			if (staticReferenceKey != oldStaticReferenceKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY, oldStaticReferenceKey, staticReferenceKey));
			}
		}
		return staticReferenceKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetStaticReferenceKey() {
		return staticReferenceKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticReferenceKey(RegistryKeyProperty newStaticReferenceKey) {
		RegistryKeyProperty oldStaticReferenceKey = staticReferenceKey;
		staticReferenceKey = newStaticReferenceKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY, oldStaticReferenceKey, staticReferenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		if (sequenceKey != null && sequenceKey.eIsProxy()) {
			InternalEObject oldSequenceKey = (InternalEObject)sequenceKey;
			sequenceKey = (RegistryKeyProperty)eResolveProxy(oldSequenceKey);
			if (sequenceKey != oldSequenceKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.SEQUENCE_MEDIATOR__SEQUENCE_KEY, oldSequenceKey, sequenceKey));
			}
		}
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEQUENCE_MEDIATOR__SEQUENCE_KEY, oldSequenceKey, sequenceKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE:
				return getReferringSequenceType();
			case MediatorsPackage.SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY:
				if (resolve) return getDynamicReferenceKey();
				return basicGetDynamicReferenceKey();
			case MediatorsPackage.SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY:
				if (resolve) return getStaticReferenceKey();
				return basicGetStaticReferenceKey();
			case MediatorsPackage.SEQUENCE_MEDIATOR__SEQUENCE_KEY:
				if (resolve) return getSequenceKey();
				return basicGetSequenceKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE:
				setReferringSequenceType((KeyType)newValue);
				return;
			case MediatorsPackage.SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY:
				setDynamicReferenceKey((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY:
				setStaticReferenceKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.SEQUENCE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE:
				setReferringSequenceType(REFERRING_SEQUENCE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY:
				setDynamicReferenceKey((NamespacedProperty)null);
				return;
			case MediatorsPackage.SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY:
				setStaticReferenceKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.SEQUENCE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE:
				return referringSequenceType != REFERRING_SEQUENCE_TYPE_EDEFAULT;
			case MediatorsPackage.SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY:
				return dynamicReferenceKey != null;
			case MediatorsPackage.SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY:
				return staticReferenceKey != null;
			case MediatorsPackage.SEQUENCE_MEDIATOR__SEQUENCE_KEY:
				return sequenceKey != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (referringSequenceType: ");
		result.append(referringSequenceType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} // SequenceMediatorImpl
