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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventArbitraryAttributes;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventCorrelationAttributes;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMetaAttributes;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventPayloadAttributes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Publish Event Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventAttributesImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventAttributesImpl#getCorrelation <em>Correlation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventAttributesImpl#getPayload <em>Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventAttributesImpl#getArbitrary <em>Arbitrary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PublishEventAttributesImpl extends EObjectImpl implements PublishEventAttributes {
	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected PublishEventMetaAttributes meta;

	/**
	 * The cached value of the '{@link #getCorrelation() <em>Correlation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelation()
	 * @generated
	 * @ordered
	 */
	protected PublishEventCorrelationAttributes correlation;

	/**
	 * The cached value of the '{@link #getPayload() <em>Payload</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayload()
	 * @generated
	 * @ordered
	 */
	protected PublishEventPayloadAttributes payload;

	/**
	 * The cached value of the '{@link #getArbitrary() <em>Arbitrary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArbitrary()
	 * @generated
	 * @ordered
	 */
	protected PublishEventArbitraryAttributes arbitrary;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PublishEventAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PUBLISH_EVENT_ATTRIBUTES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMetaAttributes getMeta() {
		if (meta != null && meta.eIsProxy()) {
			InternalEObject oldMeta = (InternalEObject)meta;
			meta = (PublishEventMetaAttributes)eResolveProxy(oldMeta);
			if (meta != oldMeta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__META, oldMeta, meta));
			}
		}
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMetaAttributes basicGetMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(PublishEventMetaAttributes newMeta) {
		PublishEventMetaAttributes oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__META, oldMeta, meta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventCorrelationAttributes getCorrelation() {
		if (correlation != null && correlation.eIsProxy()) {
			InternalEObject oldCorrelation = (InternalEObject)correlation;
			correlation = (PublishEventCorrelationAttributes)eResolveProxy(oldCorrelation);
			if (correlation != oldCorrelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__CORRELATION, oldCorrelation, correlation));
			}
		}
		return correlation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventCorrelationAttributes basicGetCorrelation() {
		return correlation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelation(PublishEventCorrelationAttributes newCorrelation) {
		PublishEventCorrelationAttributes oldCorrelation = correlation;
		correlation = newCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__CORRELATION, oldCorrelation, correlation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventPayloadAttributes getPayload() {
		if (payload != null && payload.eIsProxy()) {
			InternalEObject oldPayload = (InternalEObject)payload;
			payload = (PublishEventPayloadAttributes)eResolveProxy(oldPayload);
			if (payload != oldPayload) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__PAYLOAD, oldPayload, payload));
			}
		}
		return payload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventPayloadAttributes basicGetPayload() {
		return payload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayload(PublishEventPayloadAttributes newPayload) {
		PublishEventPayloadAttributes oldPayload = payload;
		payload = newPayload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__PAYLOAD, oldPayload, payload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventArbitraryAttributes getArbitrary() {
		if (arbitrary != null && arbitrary.eIsProxy()) {
			InternalEObject oldArbitrary = (InternalEObject)arbitrary;
			arbitrary = (PublishEventArbitraryAttributes)eResolveProxy(oldArbitrary);
			if (arbitrary != oldArbitrary) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__ARBITRARY, oldArbitrary, arbitrary));
			}
		}
		return arbitrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventArbitraryAttributes basicGetArbitrary() {
		return arbitrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArbitrary(PublishEventArbitraryAttributes newArbitrary) {
		PublishEventArbitraryAttributes oldArbitrary = arbitrary;
		arbitrary = newArbitrary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_ATTRIBUTES__ARBITRARY, oldArbitrary, arbitrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__META:
				if (resolve) return getMeta();
				return basicGetMeta();
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__CORRELATION:
				if (resolve) return getCorrelation();
				return basicGetCorrelation();
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__PAYLOAD:
				if (resolve) return getPayload();
				return basicGetPayload();
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__ARBITRARY:
				if (resolve) return getArbitrary();
				return basicGetArbitrary();
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
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__META:
				setMeta((PublishEventMetaAttributes)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__CORRELATION:
				setCorrelation((PublishEventCorrelationAttributes)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__PAYLOAD:
				setPayload((PublishEventPayloadAttributes)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__ARBITRARY:
				setArbitrary((PublishEventArbitraryAttributes)newValue);
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
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__META:
				setMeta((PublishEventMetaAttributes)null);
				return;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__CORRELATION:
				setCorrelation((PublishEventCorrelationAttributes)null);
				return;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__PAYLOAD:
				setPayload((PublishEventPayloadAttributes)null);
				return;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__ARBITRARY:
				setArbitrary((PublishEventArbitraryAttributes)null);
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
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__META:
				return meta != null;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__CORRELATION:
				return correlation != null;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__PAYLOAD:
				return payload != null;
			case EsbPackage.PUBLISH_EVENT_ATTRIBUTES__ARBITRARY:
				return arbitrary != null;
		}
		return super.eIsSet(featureID);
	}

} //PublishEventAttributesImpl
