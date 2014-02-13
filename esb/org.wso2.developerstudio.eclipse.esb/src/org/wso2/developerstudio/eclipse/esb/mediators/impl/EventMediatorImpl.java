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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.EventMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Event Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl#getTopicType <em>Topic Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl#getStaticTopic <em>Static Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl#getDynamicTopic <em>Dynamic Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl#getEventExpression <em>Event Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl#getEventSource <em>Event Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventMediatorImpl extends MediatorImpl implements EventMediator {
	/**
	 * The default value of the '{@link #getTopicType() <em>Topic Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTopicType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType TOPIC_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getTopicType() <em>Topic Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTopicType()
	 * @generated
	 * @ordered
	 */
	protected KeyType topicType = TOPIC_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStaticTopic() <em>Static Topic</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStaticTopic()
	 * 
	 * @ordered
	 */
	protected static final String STATIC_TOPIC_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getStaticTopic() <em>Static Topic</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStaticTopic()
	 * @generated
	 * @ordered
	 */
	protected String staticTopic = STATIC_TOPIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDynamicTopic() <em>Dynamic Topic</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDynamicTopic()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicTopic;

	/**
	 * The cached value of the '{@link #getEventExpression() <em>Event Expression</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEventExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty eventExpression;

	/**
	 * The default value of the '{@link #getEventSource() <em>Event Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSource()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventSource() <em>Event Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSource()
	 * @generated
	 * @ordered
	 */
	protected String eventSource = EVENT_SOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * 
	 */
	protected EventMediatorImpl() {
		super();
		// Dynamic topic
		dynamicTopic = getEsbFactory().createNamespacedProperty();
		dynamicTopic.setPropertyName("topic");
		dynamicTopic.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		dynamicTopic.setPrettyName("Dynamic Topic");
		setDynamicTopic(dynamicTopic);

		// Event Expression
		eventExpression = getEsbFactory().createNamespacedProperty();
		eventExpression.setPropertyName("expression");
		eventExpression.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		eventExpression.setPrettyName("Event Expression");
		setEventExpression(eventExpression);

	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("topic")) {
			String topicTypeValue = self.getAttribute("topic");
			if (topicTypeValue == null) {
				topicTypeValue = "";
			}
			topicTypeValue = topicTypeValue.trim();
			if (topicTypeValue.startsWith("{") && topicTypeValue.endsWith("}")) {
				setTopicType(getTopicType().DYNAMIC);
				topicTypeValue = topicTypeValue.substring(1,
						topicTypeValue.length() - 2);
				getDynamicTopic().setPropertyValue(topicTypeValue);
			} else {
				setTopicType(getTopicType().STATIC);
				setStaticTopic(topicTypeValue);
			}
		} else {
			setTopicType(getTopicType().STATIC);
			setStaticTopic("");

		}

		if (self.hasAttribute("expression")) {
			String expressionValue = self.getAttribute("expression");
			if (expressionValue == null) {
				expressionValue = "";
			}
			expressionValue = expressionValue.trim();
			getEventExpression().setPropertyValue(expressionValue);
		}
		
		if (self.hasAttribute("eventSourceName")) {
			String eventSourceValue = self.getAttribute("eventSourceName");
			if (eventSourceValue == null) {
				eventSourceValue = "";
			}
			eventSourceValue = eventSourceValue.trim();
			setEventSource(eventSourceValue);
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = null;
		switch (getCurrentEsbVersion()) {
		case ESB301:
			self = createChildElement(parent, "eventPublisher");
			self.setAttribute("eventSourceName", getEventSource());
			break;

		case ESB400:
			self = createChildElement(parent, "event");
			switch (getTopicType()) {
			case STATIC:
				if (getStaticTopic() != null && !getStaticTopic().equals("")) {
					self.setAttribute("topic", getStaticTopic());
				}
				break;
			case DYNAMIC:
				self.setAttribute(getDynamicTopic().getPropertyName(), "{"
						+ getDynamicTopic().getPropertyValue() + "}");
				break;
			}
			if (!getEventExpression().getPropertyValue().equals("")) {
				getEventExpression().save(self);
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
		return MediatorsPackage.Literals.EVENT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getTopicType() {
		return topicType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopicType(KeyType newTopicType) {
		KeyType oldTopicType = topicType;
		topicType = newTopicType == null ? TOPIC_TYPE_EDEFAULT : newTopicType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.EVENT_MEDIATOR__TOPIC_TYPE, oldTopicType, topicType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getStaticTopic() {
		return staticTopic;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticTopic(String newStaticTopic) {
		String oldStaticTopic = staticTopic;
		staticTopic = newStaticTopic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.EVENT_MEDIATOR__STATIC_TOPIC, oldStaticTopic, staticTopic));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicTopic() {
		if (dynamicTopic != null && dynamicTopic.eIsProxy()) {
			InternalEObject oldDynamicTopic = (InternalEObject)dynamicTopic;
			dynamicTopic = (NamespacedProperty)eResolveProxy(oldDynamicTopic);
			if (dynamicTopic != oldDynamicTopic) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC, oldDynamicTopic, dynamicTopic));
			}
		}
		return dynamicTopic;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetDynamicTopic() {
		return dynamicTopic;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicTopic(NamespacedProperty newDynamicTopic) {
		NamespacedProperty oldDynamicTopic = dynamicTopic;
		dynamicTopic = newDynamicTopic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC, oldDynamicTopic, dynamicTopic));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getEventExpression() {
		if (eventExpression != null && eventExpression.eIsProxy()) {
			InternalEObject oldEventExpression = (InternalEObject)eventExpression;
			eventExpression = (NamespacedProperty)eResolveProxy(oldEventExpression);
			if (eventExpression != oldEventExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.EVENT_MEDIATOR__EVENT_EXPRESSION, oldEventExpression, eventExpression));
			}
		}
		return eventExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetEventExpression() {
		return eventExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventExpression(NamespacedProperty newEventExpression) {
		NamespacedProperty oldEventExpression = eventExpression;
		eventExpression = newEventExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.EVENT_MEDIATOR__EVENT_EXPRESSION, oldEventExpression, eventExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventSource() {
		return eventSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventSource(String newEventSource) {
		String oldEventSource = eventSource;
		eventSource = newEventSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.EVENT_MEDIATOR__EVENT_SOURCE, oldEventSource, eventSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				return getTopicType();
			case MediatorsPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				return getStaticTopic();
			case MediatorsPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				if (resolve) return getDynamicTopic();
				return basicGetDynamicTopic();
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				if (resolve) return getEventExpression();
				return basicGetEventExpression();
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_SOURCE:
				return getEventSource();
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
			case MediatorsPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				setTopicType((KeyType)newValue);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				setStaticTopic((String)newValue);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				setDynamicTopic((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				setEventExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_SOURCE:
				setEventSource((String)newValue);
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
			case MediatorsPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				setTopicType(TOPIC_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				setStaticTopic(STATIC_TOPIC_EDEFAULT);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				setDynamicTopic((NamespacedProperty)null);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				setEventExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_SOURCE:
				setEventSource(EVENT_SOURCE_EDEFAULT);
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
			case MediatorsPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				return topicType != TOPIC_TYPE_EDEFAULT;
			case MediatorsPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				return STATIC_TOPIC_EDEFAULT == null ? staticTopic != null : !STATIC_TOPIC_EDEFAULT.equals(staticTopic);
			case MediatorsPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				return dynamicTopic != null;
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				return eventExpression != null;
			case MediatorsPackage.EVENT_MEDIATOR__EVENT_SOURCE:
				return EVENT_SOURCE_EDEFAULT == null ? eventSource != null : !EVENT_SOURCE_EDEFAULT.equals(eventSource);
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
		result.append(" (topicType: ");
		result.append(topicType);
		result.append(", staticTopic: ");
		result.append(staticTopic);
		result.append(", eventSource: ");
		result.append(eventSource);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} // EventMediatorImpl
