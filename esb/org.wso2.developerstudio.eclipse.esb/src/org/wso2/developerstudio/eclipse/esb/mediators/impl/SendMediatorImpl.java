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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EndPointReference;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.SendMediator;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>SendMediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl#getAnonymousEndPoint <em>Anonymous End Point</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl#getEndPointReference <em>End Point Reference</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl#getReceivingSequenceType <em>Receiving Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl#getStaticReceivingSequence <em>Static Receiving Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl#getDynamicReceivingSequence <em>Dynamic Receiving Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SendMediatorImpl extends MediatorImpl implements SendMediator {
	/**
	 * The cached value of the '{@link #getAnonymousEndPoint() <em>Anonymous End Point</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getAnonymousEndPoint()
	 * @generated
	 * @ordered
	 */
	protected EndPoint anonymousEndPoint;
	/**
	 * The cached value of the '{@link #getEndPointReference() <em>End Point Reference</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getEndPointReference()
	 * @generated
	 * @ordered
	 */
	protected EndPointReference endPointReference;
	/**
	 * The default value of the '{@link #getReceivingSequenceType() <em>Receiving Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceivingSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final ReceivingSequenceType RECEIVING_SEQUENCE_TYPE_EDEFAULT = ReceivingSequenceType.DEFAULT;
	/**
	 * The cached value of the '{@link #getReceivingSequenceType() <em>Receiving Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceivingSequenceType()
	 * @generated
	 * @ordered
	 */
	protected ReceivingSequenceType receivingSequenceType = RECEIVING_SEQUENCE_TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getStaticReceivingSequence()
	 * <em>Static Receiving Sequence</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStaticReceivingSequence()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty staticReceivingSequence;
	/**
	 * The cached value of the '{@link #getDynamicReceivingSequence()
	 * <em>Dynamic Receiving Sequence</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDynamicReceivingSequence()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicReceivingSequence;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @!generated
	 */
	protected SendMediatorImpl() {
		super();
		// Static Receiving Sequence
		staticReceivingSequence = getEsbFactory().createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) staticReceivingSequence
						.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		staticReceivingSequence.setPrettyName("Static");
		staticReceivingSequence.setKeyName("receive");
		staticReceivingSequence
				.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setStaticReceivingSequence(staticReceivingSequence);

		// Dynamic Receiving Sequence
		dynamicReceivingSequence = getEsbFactory().createNamespacedProperty();
		dynamicReceivingSequence.setPropertyName("receive");
		dynamicReceivingSequence.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		dynamicReceivingSequence.setPrettyName("Dynamic");
		setDynamicReceivingSequence(dynamicReceivingSequence);

	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		if (self.hasAttribute("receive")) {
			String attributeValue = self.getAttribute("receive");
			if (attributeValue == null) {
				attributeValue = "";
			}
			attributeValue = attributeValue.trim();
			if (attributeValue.startsWith("{") && attributeValue.endsWith("}")) {
				setReceivingSequenceType(ReceivingSequenceType.DYNAMIC);
				attributeValue = attributeValue.substring(1,
						attributeValue.length() - 2);
				getDynamicReceivingSequence().setPropertyValue(attributeValue);
			} else {
				setReceivingSequenceType(ReceivingSequenceType.STATIC);
				getStaticReceivingSequence().setKeyValue(attributeValue);
			}
		} else {
			setReceivingSequenceType(ReceivingSequenceType.DEFAULT);
		}

		Element endpointElem = getChildElement(self, "endpoint");
		if (null != endpointElem) {
			if (endpointElem.hasAttribute("key-expression")
					|| endpointElem.hasAttribute("key")) {
				loadObject(endpointElem, EndPointReference.class, false,
						new ObjectHandler<EndPointReference>() {
							public void handle(EndPointReference object) {
								setEndPointReference(object);
							}
						});
			} else {
				loadObject(endpointElem, EndPoint.class, false,
						new ObjectHandler<EndPoint>() {
							public void handle(EndPoint object) {
								setAnonymousEndPoint(object);
							}
						});
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "send");
		switch (getCurrentEsbVersion()) {
		case ESB301:

			if (null != getEndPointReference()) {
				getEndPointReference().save(self);
			} else if (null != getAnonymousEndPoint()) {
				getAnonymousEndPoint().save(self);
			}
			break;

		case ESB400:
			switch (getReceivingSequenceType()) {
			case STATIC:
				getStaticReceivingSequence().save(self);
				break;
			case DYNAMIC:
				self.setAttribute(getDynamicReceivingSequence()
						.getPropertyName(), "{"
						+ getDynamicReceivingSequence().getPropertyValue()
						+ "}");
				break;
			}

			if (null != getEndPointReference()) {
				getEndPointReference().save(self);
			} else if (null != getAnonymousEndPoint()) {
				getAnonymousEndPoint().save(self);
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
		return MediatorsPackage.Literals.SEND_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint getAnonymousEndPoint() {
		return anonymousEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnonymousEndPoint(
			EndPoint newAnonymousEndPoint, NotificationChain msgs) {
		EndPoint oldAnonymousEndPoint = anonymousEndPoint;
		anonymousEndPoint = newAnonymousEndPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT, oldAnonymousEndPoint, newAnonymousEndPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnonymousEndPoint(EndPoint newAnonymousEndPoint) {
		if (newAnonymousEndPoint != anonymousEndPoint) {
			NotificationChain msgs = null;
			if (anonymousEndPoint != null)
				msgs = ((InternalEObject)anonymousEndPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT, null, msgs);
			if (newAnonymousEndPoint != null)
				msgs = ((InternalEObject)newAnonymousEndPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT, null, msgs);
			msgs = basicSetAnonymousEndPoint(newAnonymousEndPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT, newAnonymousEndPoint, newAnonymousEndPoint));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointReference getEndPointReference() {
		return endPointReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndPointReference(
			EndPointReference newEndPointReference, NotificationChain msgs) {
		EndPointReference oldEndPointReference = endPointReference;
		endPointReference = newEndPointReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE, oldEndPointReference, newEndPointReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPointReference(EndPointReference newEndPointReference) {
		if (newEndPointReference != endPointReference) {
			NotificationChain msgs = null;
			if (endPointReference != null)
				msgs = ((InternalEObject)endPointReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE, null, msgs);
			if (newEndPointReference != null)
				msgs = ((InternalEObject)newEndPointReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE, null, msgs);
			msgs = basicSetEndPointReference(newEndPointReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE, newEndPointReference, newEndPointReference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReceivingSequenceType getReceivingSequenceType() {
		return receivingSequenceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceivingSequenceType(
			ReceivingSequenceType newReceivingSequenceType) {
		ReceivingSequenceType oldReceivingSequenceType = receivingSequenceType;
		receivingSequenceType = newReceivingSequenceType == null ? RECEIVING_SEQUENCE_TYPE_EDEFAULT : newReceivingSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE, oldReceivingSequenceType, receivingSequenceType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getStaticReceivingSequence() {
		return staticReceivingSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStaticReceivingSequence(
			RegistryKeyProperty newStaticReceivingSequence,
			NotificationChain msgs) {
		RegistryKeyProperty oldStaticReceivingSequence = staticReceivingSequence;
		staticReceivingSequence = newStaticReceivingSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE, oldStaticReceivingSequence, newStaticReceivingSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticReceivingSequence(
			RegistryKeyProperty newStaticReceivingSequence) {
		if (newStaticReceivingSequence != staticReceivingSequence) {
			NotificationChain msgs = null;
			if (staticReceivingSequence != null)
				msgs = ((InternalEObject)staticReceivingSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE, null, msgs);
			if (newStaticReceivingSequence != null)
				msgs = ((InternalEObject)newStaticReceivingSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE, null, msgs);
			msgs = basicSetStaticReceivingSequence(newStaticReceivingSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE, newStaticReceivingSequence, newStaticReceivingSequence));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicReceivingSequence() {
		return dynamicReceivingSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicReceivingSequence(
			NamespacedProperty newDynamicReceivingSequence,
			NotificationChain msgs) {
		NamespacedProperty oldDynamicReceivingSequence = dynamicReceivingSequence;
		dynamicReceivingSequence = newDynamicReceivingSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE, oldDynamicReceivingSequence, newDynamicReceivingSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicReceivingSequence(
			NamespacedProperty newDynamicReceivingSequence) {
		if (newDynamicReceivingSequence != dynamicReceivingSequence) {
			NotificationChain msgs = null;
			if (dynamicReceivingSequence != null)
				msgs = ((InternalEObject)dynamicReceivingSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE, null, msgs);
			if (newDynamicReceivingSequence != null)
				msgs = ((InternalEObject)newDynamicReceivingSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE, null, msgs);
			msgs = basicSetDynamicReceivingSequence(newDynamicReceivingSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE, newDynamicReceivingSequence, newDynamicReceivingSequence));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT:
				return basicSetAnonymousEndPoint(null, msgs);
			case MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE:
				return basicSetEndPointReference(null, msgs);
			case MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
				return basicSetStaticReceivingSequence(null, msgs);
			case MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
				return basicSetDynamicReceivingSequence(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT:
				return getAnonymousEndPoint();
			case MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE:
				return getEndPointReference();
			case MediatorsPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE:
				return getReceivingSequenceType();
			case MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
				return getStaticReceivingSequence();
			case MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
				return getDynamicReceivingSequence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT:
				setAnonymousEndPoint((EndPoint)newValue);
				return;
			case MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE:
				setEndPointReference((EndPointReference)newValue);
				return;
			case MediatorsPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE:
				setReceivingSequenceType((ReceivingSequenceType)newValue);
				return;
			case MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
				setStaticReceivingSequence((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
				setDynamicReceivingSequence((NamespacedProperty)newValue);
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
			case MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT:
				setAnonymousEndPoint((EndPoint)null);
				return;
			case MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE:
				setEndPointReference((EndPointReference)null);
				return;
			case MediatorsPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE:
				setReceivingSequenceType(RECEIVING_SEQUENCE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
				setStaticReceivingSequence((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
				setDynamicReceivingSequence((NamespacedProperty)null);
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
			case MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT:
				return anonymousEndPoint != null;
			case MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE:
				return endPointReference != null;
			case MediatorsPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE:
				return receivingSequenceType != RECEIVING_SEQUENCE_TYPE_EDEFAULT;
			case MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
				return staticReceivingSequence != null;
			case MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
				return dynamicReceivingSequence != null;
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
		result.append(" (receivingSequenceType: ");
		result.append(receivingSequenceType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} // SendMediatorImpl
