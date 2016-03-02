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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorOutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Publish Event Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getOutputconnector <em>Outputconnector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getStreamName <em>Stream Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getStreamVersion <em>Stream Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getEventSink <em>Event Sink</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getMetaAttributes <em>Meta Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getCorrelationAttributes <em>Correlation Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getPayloadAttributes <em>Payload Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorImpl#getArbitraryAttributes <em>Arbitrary Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PublishEventMediatorImpl extends MediatorImpl implements PublishEventMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected PublishEventMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputconnector() <em>Outputconnector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputconnector()
	 * @generated
	 * @ordered
	 */
	protected PublishEventMediatorOutputConnector outputconnector;

	/**
	 * The default value of the '{@link #getStreamName() <em>Stream Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamName()
	 * @generated
	 * @ordered
	 */
	protected static final String STREAM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreamName() <em>Stream Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamName()
	 * @generated
	 * @ordered
	 */
	protected String streamName = STREAM_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreamVersion() <em>Stream Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String STREAM_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreamVersion() <em>Stream Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamVersion()
	 * @generated
	 * @ordered
	 */
	protected String streamVersion = STREAM_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventSink() <em>Event Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSink()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_SINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventSink() <em>Event Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSink()
	 * @generated
	 * @ordered
	 */
	protected String eventSink = EVENT_SINK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetaAttributes() <em>Meta Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<PublishEventMediatorAttribute> metaAttributes;

	/**
	 * The cached value of the '{@link #getCorrelationAttributes() <em>Correlation Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<PublishEventMediatorAttribute> correlationAttributes;

	/**
	 * The cached value of the '{@link #getPayloadAttributes() <em>Payload Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<PublishEventMediatorAttribute> payloadAttributes;

	/**
	 * The cached value of the '{@link #getArbitraryAttributes() <em>Arbitrary Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArbitraryAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<PublishEventMediatorAttribute> arbitraryAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PublishEventMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(PublishEventMediatorInputConnector newInputConnector, NotificationChain msgs) {
		PublishEventMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(PublishEventMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMediatorOutputConnector getOutputconnector() {
		return outputconnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputconnector(PublishEventMediatorOutputConnector newOutputconnector, NotificationChain msgs) {
		PublishEventMediatorOutputConnector oldOutputconnector = outputconnector;
		outputconnector = newOutputconnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR, oldOutputconnector, newOutputconnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputconnector(PublishEventMediatorOutputConnector newOutputconnector) {
		if (newOutputconnector != outputconnector) {
			NotificationChain msgs = null;
			if (outputconnector != null)
				msgs = ((InternalEObject)outputconnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR, null, msgs);
			if (newOutputconnector != null)
				msgs = ((InternalEObject)newOutputconnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR, null, msgs);
			msgs = basicSetOutputconnector(newOutputconnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR, newOutputconnector, newOutputconnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreamName() {
		return streamName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreamName(String newStreamName) {
		String oldStreamName = streamName;
		streamName = newStreamName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_NAME, oldStreamName, streamName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreamVersion() {
		return streamVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreamVersion(String newStreamVersion) {
		String oldStreamVersion = streamVersion;
		streamVersion = newStreamVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION, oldStreamVersion, streamVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventSink() {
		return eventSink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventSink(String newEventSink) {
		String oldEventSink = eventSink;
		eventSink = newEventSink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PUBLISH_EVENT_MEDIATOR__EVENT_SINK, oldEventSink, eventSink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PublishEventMediatorAttribute> getMetaAttributes() {
		if (metaAttributes == null) {
			metaAttributes = new EObjectContainmentEList<PublishEventMediatorAttribute>(PublishEventMediatorAttribute.class, this, EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES);
		}
		return metaAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PublishEventMediatorAttribute> getCorrelationAttributes() {
		if (correlationAttributes == null) {
			correlationAttributes = new EObjectContainmentEList<PublishEventMediatorAttribute>(PublishEventMediatorAttribute.class, this, EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES);
		}
		return correlationAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PublishEventMediatorAttribute> getPayloadAttributes() {
		if (payloadAttributes == null) {
			payloadAttributes = new EObjectContainmentEList<PublishEventMediatorAttribute>(PublishEventMediatorAttribute.class, this, EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES);
		}
		return payloadAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PublishEventMediatorAttribute> getArbitraryAttributes() {
		if (arbitraryAttributes == null) {
			arbitraryAttributes = new EObjectContainmentEList<PublishEventMediatorAttribute>(PublishEventMediatorAttribute.class, this, EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES);
		}
		return arbitraryAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR:
				return basicSetOutputconnector(null, msgs);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES:
				return ((InternalEList<?>)getMetaAttributes()).basicRemove(otherEnd, msgs);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES:
				return ((InternalEList<?>)getCorrelationAttributes()).basicRemove(otherEnd, msgs);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES:
				return ((InternalEList<?>)getPayloadAttributes()).basicRemove(otherEnd, msgs);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES:
				return ((InternalEList<?>)getArbitraryAttributes()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR:
				return getOutputconnector();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_NAME:
				return getStreamName();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION:
				return getStreamVersion();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__EVENT_SINK:
				return getEventSink();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES:
				return getMetaAttributes();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES:
				return getCorrelationAttributes();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES:
				return getPayloadAttributes();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES:
				return getArbitraryAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((PublishEventMediatorInputConnector)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR:
				setOutputconnector((PublishEventMediatorOutputConnector)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_NAME:
				setStreamName((String)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION:
				setStreamVersion((String)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__EVENT_SINK:
				setEventSink((String)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES:
				getMetaAttributes().clear();
				getMetaAttributes().addAll((Collection<? extends PublishEventMediatorAttribute>)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES:
				getCorrelationAttributes().clear();
				getCorrelationAttributes().addAll((Collection<? extends PublishEventMediatorAttribute>)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES:
				getPayloadAttributes().clear();
				getPayloadAttributes().addAll((Collection<? extends PublishEventMediatorAttribute>)newValue);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES:
				getArbitraryAttributes().clear();
				getArbitraryAttributes().addAll((Collection<? extends PublishEventMediatorAttribute>)newValue);
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
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((PublishEventMediatorInputConnector)null);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR:
				setOutputconnector((PublishEventMediatorOutputConnector)null);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_NAME:
				setStreamName(STREAM_NAME_EDEFAULT);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION:
				setStreamVersion(STREAM_VERSION_EDEFAULT);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__EVENT_SINK:
				setEventSink(EVENT_SINK_EDEFAULT);
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES:
				getMetaAttributes().clear();
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES:
				getCorrelationAttributes().clear();
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES:
				getPayloadAttributes().clear();
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES:
				getArbitraryAttributes().clear();
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
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR:
				return outputconnector != null;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_NAME:
				return STREAM_NAME_EDEFAULT == null ? streamName != null : !STREAM_NAME_EDEFAULT.equals(streamName);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION:
				return STREAM_VERSION_EDEFAULT == null ? streamVersion != null : !STREAM_VERSION_EDEFAULT.equals(streamVersion);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__EVENT_SINK:
				return EVENT_SINK_EDEFAULT == null ? eventSink != null : !EVENT_SINK_EDEFAULT.equals(eventSink);
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES:
				return metaAttributes != null && !metaAttributes.isEmpty();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES:
				return correlationAttributes != null && !correlationAttributes.isEmpty();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES:
				return payloadAttributes != null && !payloadAttributes.isEmpty();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES:
				return arbitraryAttributes != null && !arbitraryAttributes.isEmpty();
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
		result.append(" (streamName: ");
		result.append(streamName);
		result.append(", streamVersion: ");
		result.append(streamVersion);
		result.append(", eventSink: ");
		result.append(eventSink);
		result.append(')');
		return result.toString();
	}

} //PublishEventMediatorImpl
