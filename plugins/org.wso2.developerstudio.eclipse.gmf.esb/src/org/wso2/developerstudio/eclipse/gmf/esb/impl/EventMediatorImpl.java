/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EventMediatorImpl#getTopicType <em>Topic Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EventMediatorImpl#getStaticTopic <em>Static Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EventMediatorImpl#getDynamicTopic <em>Dynamic Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EventMediatorImpl#getEventExpression <em>Event Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EventMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EventMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventMediatorImpl extends MediatorImpl implements EventMediator {
	/**
	 * The default value of the '{@link #getTopicType() <em>Topic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopicType()
	 * @generated
	 * @ordered
	 */
	protected static final EventTopicType TOPIC_TYPE_EDEFAULT = EventTopicType.STATIC;

	/**
	 * The cached value of the '{@link #getTopicType() <em>Topic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopicType()
	 * @generated
	 * @ordered
	 */
	protected EventTopicType topicType = TOPIC_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStaticTopic() <em>Static Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticTopic()
	 * @generated
	 * @ordered
	 */
	protected static final String STATIC_TOPIC_EDEFAULT = "source_property";

	/**
	 * The cached value of the '{@link #getStaticTopic() <em>Static Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticTopic()
	 * @generated
	 * @ordered
	 */
	protected String staticTopic = STATIC_TOPIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDynamicTopic() <em>Dynamic Topic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicTopic()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicTopic;

	/**
	 * The cached value of the '{@link #getEventExpression() <em>Event Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty eventExpression;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected EventMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EventMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EventMediatorImpl() {
		super();
		// Dynamic topic
		dynamicTopic = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		dynamicTopic.setPropertyName("topic");
		dynamicTopic.setPropertyValue("");
		dynamicTopic.setPrettyName("Dynamic Topic");
		setDynamicTopic(dynamicTopic);

		// Event Expression
		eventExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		eventExpression.setPropertyName("expression");
		eventExpression.setPropertyValue("");
		eventExpression.setPrettyName("Event Expression");
		setEventExpression(eventExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.EVENT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventTopicType getTopicType() {
		return topicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopicType(EventTopicType newTopicType) {
		EventTopicType oldTopicType = topicType;
		topicType = newTopicType == null ? TOPIC_TYPE_EDEFAULT : newTopicType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__TOPIC_TYPE, oldTopicType, topicType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStaticTopic() {
		return staticTopic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticTopic(String newStaticTopic) {
		String oldStaticTopic = staticTopic;
		staticTopic = newStaticTopic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__STATIC_TOPIC, oldStaticTopic, staticTopic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicTopic() {
		return dynamicTopic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicTopic(NamespacedProperty newDynamicTopic, NotificationChain msgs) {
		NamespacedProperty oldDynamicTopic = dynamicTopic;
		dynamicTopic = newDynamicTopic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC, oldDynamicTopic, newDynamicTopic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicTopic(NamespacedProperty newDynamicTopic) {
		if (newDynamicTopic != dynamicTopic) {
			NotificationChain msgs = null;
			if (dynamicTopic != null)
				msgs = ((InternalEObject)dynamicTopic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC, null, msgs);
			if (newDynamicTopic != null)
				msgs = ((InternalEObject)newDynamicTopic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC, null, msgs);
			msgs = basicSetDynamicTopic(newDynamicTopic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC, newDynamicTopic, newDynamicTopic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getEventExpression() {
		return eventExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventExpression(NamespacedProperty newEventExpression, NotificationChain msgs) {
		NamespacedProperty oldEventExpression = eventExpression;
		eventExpression = newEventExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION, oldEventExpression, newEventExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventExpression(NamespacedProperty newEventExpression) {
		if (newEventExpression != eventExpression) {
			NotificationChain msgs = null;
			if (eventExpression != null)
				msgs = ((InternalEObject)eventExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION, null, msgs);
			if (newEventExpression != null)
				msgs = ((InternalEObject)newEventExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION, null, msgs);
			msgs = basicSetEventExpression(newEventExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION, newEventExpression, newEventExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(EventMediatorInputConnector newInputConnector, NotificationChain msgs) {
		EventMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(EventMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(EventMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		EventMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(EventMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				return basicSetDynamicTopic(null, msgs);
			case EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				return basicSetEventExpression(null, msgs);
			case EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
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
			case EsbPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				return getTopicType();
			case EsbPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				return getStaticTopic();
			case EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				return getDynamicTopic();
			case EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				return getEventExpression();
			case EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
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
			case EsbPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				setTopicType((EventTopicType)newValue);
				return;
			case EsbPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				setStaticTopic((String)newValue);
				return;
			case EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				setDynamicTopic((NamespacedProperty)newValue);
				return;
			case EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				setEventExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EventMediatorInputConnector)newValue);
				return;
			case EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EventMediatorOutputConnector)newValue);
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
			case EsbPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				setTopicType(TOPIC_TYPE_EDEFAULT);
				return;
			case EsbPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				setStaticTopic(STATIC_TOPIC_EDEFAULT);
				return;
			case EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				setDynamicTopic((NamespacedProperty)null);
				return;
			case EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				setEventExpression((NamespacedProperty)null);
				return;
			case EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EventMediatorInputConnector)null);
				return;
			case EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EventMediatorOutputConnector)null);
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
			case EsbPackage.EVENT_MEDIATOR__TOPIC_TYPE:
				return topicType != TOPIC_TYPE_EDEFAULT;
			case EsbPackage.EVENT_MEDIATOR__STATIC_TOPIC:
				return STATIC_TOPIC_EDEFAULT == null ? staticTopic != null : !STATIC_TOPIC_EDEFAULT.equals(staticTopic);
			case EsbPackage.EVENT_MEDIATOR__DYNAMIC_TOPIC:
				return dynamicTopic != null;
			case EsbPackage.EVENT_MEDIATOR__EVENT_EXPRESSION:
				return eventExpression != null;
			case EsbPackage.EVENT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.EVENT_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
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
		result.append(" (topicType: ");
		result.append(topicType);
		result.append(", staticTopic: ");
		result.append(staticTopic);
		result.append(')');
		return result.toString();
	}

} //EventMediatorImpl
