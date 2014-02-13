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
package org.wso2.developerstudio.eclipse.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.esb.ProxySequenceType;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Proxy Sequence Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractProxySequenceConfigurationImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractProxySequenceConfigurationImpl#getInlineSequence <em>Inline Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractProxySequenceConfigurationImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractProxySequenceConfigurationImpl#getSequenceName <em>Sequence Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractProxySequenceConfigurationImpl extends ModelObjectImpl implements AbstractProxySequenceConfiguration {
	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final ProxySequenceType SEQUENCE_TYPE_EDEFAULT = ProxySequenceType.ANONYMOUS;
	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected ProxySequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInlineSequence() <em>Inline Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlineSequence()
	 * @generated
	 * @ordered
	 */
	protected MediatorSequence inlineSequence;
	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;
	/**
	 * The default value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_NAME_EDEFAULT = "sequence_name";
	/**
	 * The cached value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String sequenceName = SEQUENCE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractProxySequenceConfigurationImpl() {
		super();
	}

	/**
	 * Utility method for loading a generic proxy sequence configuration.
	 * 
	 * @param contentElem
	 *            {@link Element} which hosts the sequence configuration.
	 * @param localName
	 *            local name of the child {@link Element} or the attribute
	 *            within the content element which holds the sequence
	 *            configuration.
	 * @throws Exception
	 *             if an error occurs while loading the sequence configuration.
	 */
	protected void loadContent(Element contentElem, String localName) throws Exception {
		Element sequenceElem = getChildElement(contentElem, localName);
		if (null != sequenceElem) {
			super.doLoad(sequenceElem);
			setSequenceType(ProxySequenceType.ANONYMOUS);
			MediatorSequence sequence = getEsbFactory().createMediatorSequence();
			sequence.load(sequenceElem);
			
			// Force the sequence to be anonymous.
			sequence.setAnonymous(true);
			
			setInlineSequence(sequence);
		} else if (contentElem.hasAttribute(localName)) {
			String sequenceReference = contentElem.getAttribute(localName);
			
			// TODO: This is not optimal, we could mis-interpret a registry
			// reference as a named reference and vice versa.
			if (isRegistryKey(sequenceReference)) {
				setSequenceType(ProxySequenceType.REGISTRY_REFERENCE);
				getSequenceKey().load(contentElem);
			} else {
				setSequenceType(ProxySequenceType.NAMED_REFERENCE);
				setSequenceName(sequenceReference);
			}
		}
	}

	/**
	 * Utility method for loading a generic proxy sequence configuration.
	 * 
	 * @param contentElem
	 *            {@link Element} which should host the sequence configuration.
	 * @param localName
	 *            local name of the child {@link Element} or the attribute
	 *            within the content element which should hold the sequence
	 *            configuration.
	 * @return child {@link Element} if one was created, null otherwise.
	 * @throws Exception
	 *             if an error occurs while saving the sequence configuration.
	 */
	protected Element saveContent(Element contentElem, String localName) throws Exception {
		switch (getSequenceType()) {
			case ANONYMOUS: {
				if (null != getInlineSequence()) {
					// Force the sequence to be anonymous.
					getInlineSequence().setAnonymous(true);
					
					Element sequenceElem = createChildElement(contentElem, localName);
					
					if (isOnErrorValuePresent()){
						sequenceElem.setAttribute("onError", getInlineSequence().getOnError().getKeyValue());
					} 
					
					for (Mediator mediator: getInlineSequence().getMediators()) {
						mediator.save(sequenceElem);
					}			
					return sequenceElem;
				}
				break;
			}
		
			case REGISTRY_REFERENCE: {
				getSequenceKey().save(contentElem);
				break;
			}
		
			case NAMED_REFERENCE: {
				contentElem.setAttribute(localName, getSequenceName());
				break;
			}

			default : {
				// Do nothing.
			}
		}
		
		return null;
	}

	private boolean isOnErrorValuePresent() {
		String onErrorValue = getInlineSequence().getOnError().getKeyValue();
		return onErrorValue!=null && !onErrorValue.equals("");
	}	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxySequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(ProxySequenceType newSequenceType) {
		ProxySequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorSequence getInlineSequence() {
		return inlineSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInlineSequence(MediatorSequence newInlineSequence, NotificationChain msgs) {
		MediatorSequence oldInlineSequence = inlineSequence;
		inlineSequence = newInlineSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE, oldInlineSequence, newInlineSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlineSequence(MediatorSequence newInlineSequence) {
		if (newInlineSequence != inlineSequence) {
			NotificationChain msgs = null;
			if (inlineSequence != null)
				msgs = ((InternalEObject)inlineSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE, null, msgs);
			if (newInlineSequence != null)
				msgs = ((InternalEObject)newInlineSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE, null, msgs);
			msgs = basicSetInlineSequence(newInlineSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE, newInlineSequence, newInlineSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceKey(RegistryKeyProperty newSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		if (newSequenceKey != sequenceKey) {
			NotificationChain msgs = null;
			if (sequenceKey != null)
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSequenceName() {
		return sequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceName(String newSequenceName) {
		String oldSequenceName = sequenceName;
		sequenceName = newSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_NAME, oldSequenceName, sequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE:
				return basicSetInlineSequence(null, msgs);
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY:
				return basicSetSequenceKey(null, msgs);
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
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE:
				return getInlineSequence();
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY:
				return getSequenceKey();
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_NAME:
				return getSequenceName();
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
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_TYPE:
				setSequenceType((ProxySequenceType)newValue);
				return;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE:
				setInlineSequence((MediatorSequence)newValue);
				return;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_NAME:
				setSequenceName((String)newValue);
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
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE:
				setInlineSequence((MediatorSequence)null);
				return;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_NAME:
				setSequenceName(SEQUENCE_NAME_EDEFAULT);
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
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE:
				return inlineSequence != null;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY:
				return sequenceKey != null;
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_NAME:
				return SEQUENCE_NAME_EDEFAULT == null ? sequenceName != null : !SEQUENCE_NAME_EDEFAULT.equals(sequenceName);
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
		result.append(" (sequenceType: ");
		result.append(sequenceType);
		result.append(", sequenceName: ");
		result.append(sequenceName);
		result.append(')');
		return result.toString();
	}

} //AbstractProxySequenceConfigurationImpl
