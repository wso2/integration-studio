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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSpecVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RM Sequence Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RMSequenceMediatorImpl#getRmSpecVersion <em>Rm Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RMSequenceMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RMSequenceMediatorImpl#getCorrelationXpath <em>Correlation Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RMSequenceMediatorImpl#getLastMessageXpath <em>Last Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RMSequenceMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RMSequenceMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
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
	 * The cached value of the '{@link #getCorrelationXpath() <em>Correlation Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty correlationXpath;

	/**
	 * The cached value of the '{@link #getLastMessageXpath() <em>Last Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMessageXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty lastMessageXpath;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected RMSequenceMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected RMSequenceMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RMSequenceMediatorImpl() {
		super();
		
		// Correlation xpath.
		NamespacedProperty correlationXpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		correlationXpath.setPrettyName("Sequence XPath");
		correlationXpath.setPropertyName("correlation");
		correlationXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setCorrelationXpath(correlationXpath);
		
		// Last message xpath.
		NamespacedProperty lastMessageXpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		lastMessageXpath.setPrettyName("Last message XPath");
		lastMessageXpath.setPropertyName("last-message");
		lastMessageXpath.setPropertyValue("");
		setLastMessageXpath(lastMessageXpath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.RM_SEQUENCE_MEDIATOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION, oldRmSpecVersion, rmSpecVersion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getCorrelationXpath() {
		return correlationXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorrelationXpath(NamespacedProperty newCorrelationXpath, NotificationChain msgs) {
		NamespacedProperty oldCorrelationXpath = correlationXpath;
		correlationXpath = newCorrelationXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH, oldCorrelationXpath, newCorrelationXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelationXpath(NamespacedProperty newCorrelationXpath) {
		if (newCorrelationXpath != correlationXpath) {
			NotificationChain msgs = null;
			if (correlationXpath != null)
				msgs = ((InternalEObject)correlationXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH, null, msgs);
			if (newCorrelationXpath != null)
				msgs = ((InternalEObject)newCorrelationXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH, null, msgs);
			msgs = basicSetCorrelationXpath(newCorrelationXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH, newCorrelationXpath, newCorrelationXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getLastMessageXpath() {
		return lastMessageXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLastMessageXpath(NamespacedProperty newLastMessageXpath, NotificationChain msgs) {
		NamespacedProperty oldLastMessageXpath = lastMessageXpath;
		lastMessageXpath = newLastMessageXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH, oldLastMessageXpath, newLastMessageXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastMessageXpath(NamespacedProperty newLastMessageXpath) {
		if (newLastMessageXpath != lastMessageXpath) {
			NotificationChain msgs = null;
			if (lastMessageXpath != null)
				msgs = ((InternalEObject)lastMessageXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH, null, msgs);
			if (newLastMessageXpath != null)
				msgs = ((InternalEObject)newLastMessageXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH, null, msgs);
			msgs = basicSetLastMessageXpath(newLastMessageXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH, newLastMessageXpath, newLastMessageXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(RMSequenceMediatorInputConnector newInputConnector, NotificationChain msgs) {
		RMSequenceMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(RMSequenceMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(RMSequenceMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		RMSequenceMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(RMSequenceMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				return basicSetCorrelationXpath(null, msgs);
			case EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				return basicSetLastMessageXpath(null, msgs);
			case EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				return getRmSpecVersion();
			case EsbPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				return getCorrelationXpath();
			case EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				return getLastMessageXpath();
			case EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				setRmSpecVersion((RMSpecVersion)newValue);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType((RMSequenceType)newValue);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				setCorrelationXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				setLastMessageXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((RMSequenceMediatorInputConnector)newValue);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((RMSequenceMediatorOutputConnector)newValue);
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
			case EsbPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				setRmSpecVersion(RM_SPEC_VERSION_EDEFAULT);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				setCorrelationXpath((NamespacedProperty)null);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				setLastMessageXpath((NamespacedProperty)null);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((RMSequenceMediatorInputConnector)null);
				return;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((RMSequenceMediatorOutputConnector)null);
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
			case EsbPackage.RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION:
				return rmSpecVersion != RM_SPEC_VERSION_EDEFAULT;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH:
				return correlationXpath != null;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH:
				return lastMessageXpath != null;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR:
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
		result.append(" (rmSpecVersion: ");
		result.append(rmSpecVersion);
		result.append(", sequenceType: ");
		result.append(sequenceType);
		result.append(')');
		return result.toString();
	}

} //RMSequenceMediatorImpl
