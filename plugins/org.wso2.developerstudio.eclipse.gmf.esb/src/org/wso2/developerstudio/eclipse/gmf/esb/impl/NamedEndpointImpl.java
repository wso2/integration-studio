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
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl#getReferringEndpointType <em>Referring Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl#getDynamicReferenceKey <em>Dynamic Reference Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl#getStaticReferenceKey <em>Static Reference Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedEndpointImpl extends AbstractEndPointImpl implements NamedEndpoint {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected NamedEndpointInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected NamedEndpointOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferringEndpointType() <em>Referring Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferringEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType REFERRING_ENDPOINT_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getReferringEndpointType() <em>Referring Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferringEndpointType()
	 * @generated
	 * @ordered
	 */
	protected KeyType referringEndpointType = REFERRING_ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDynamicReferenceKey() <em>Dynamic Reference Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicReferenceKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicReferenceKey;

	/**
	 * The cached value of the '{@link #getStaticReferenceKey() <em>Static Reference Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticReferenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty staticReferenceKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected NamedEndpointImpl() {
		super();
		NamespacedProperty dynamicKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		dynamicKey.setPrettyName("Endpoint Expression");
		dynamicKey.setPropertyName("expression");
		dynamicKey.setPropertyValue("/default/expression");
		setDynamicReferenceKey(dynamicKey);
		
		RegistryKeyProperty staticKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		staticKey.setKeyName("Endpoint Key");
		staticKey.setPrettyName("Endpoint Key");
		staticKey.setKeyValue("");
		setStaticReferenceKey(staticKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.NAMED_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedEndpointInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(NamedEndpointInputConnector newInputConnector, NotificationChain msgs) {
		NamedEndpointInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(NamedEndpointInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedEndpointOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(NamedEndpointOutputConnector newOutputConnector, NotificationChain msgs) {
		NamedEndpointOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(NamedEndpointOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getReferringEndpointType() {
		return referringEndpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferringEndpointType(KeyType newReferringEndpointType) {
		KeyType oldReferringEndpointType = referringEndpointType;
		referringEndpointType = newReferringEndpointType == null ? REFERRING_ENDPOINT_TYPE_EDEFAULT : newReferringEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE, oldReferringEndpointType, referringEndpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicReferenceKey() {
		return dynamicReferenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicReferenceKey(NamespacedProperty newDynamicReferenceKey, NotificationChain msgs) {
		NamespacedProperty oldDynamicReferenceKey = dynamicReferenceKey;
		dynamicReferenceKey = newDynamicReferenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY, oldDynamicReferenceKey, newDynamicReferenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicReferenceKey(NamespacedProperty newDynamicReferenceKey) {
		if (newDynamicReferenceKey != dynamicReferenceKey) {
			NotificationChain msgs = null;
			if (dynamicReferenceKey != null)
				msgs = ((InternalEObject)dynamicReferenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY, null, msgs);
			if (newDynamicReferenceKey != null)
				msgs = ((InternalEObject)newDynamicReferenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY, null, msgs);
			msgs = basicSetDynamicReferenceKey(newDynamicReferenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY, newDynamicReferenceKey, newDynamicReferenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getStaticReferenceKey() {
		return staticReferenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStaticReferenceKey(RegistryKeyProperty newStaticReferenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldStaticReferenceKey = staticReferenceKey;
		staticReferenceKey = newStaticReferenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY, oldStaticReferenceKey, newStaticReferenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticReferenceKey(RegistryKeyProperty newStaticReferenceKey) {
		if (newStaticReferenceKey != staticReferenceKey) {
			NotificationChain msgs = null;
			if (staticReferenceKey != null)
				msgs = ((InternalEObject)staticReferenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY, null, msgs);
			if (newStaticReferenceKey != null)
				msgs = ((InternalEObject)newStaticReferenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY, null, msgs);
			msgs = basicSetStaticReferenceKey(newStaticReferenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY, newStaticReferenceKey, newStaticReferenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY:
				return basicSetDynamicReferenceKey(null, msgs);
			case EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY:
				return basicSetStaticReferenceKey(null, msgs);
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
			case EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.NAMED_ENDPOINT__NAME:
				return getName();
			case EsbPackage.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE:
				return getReferringEndpointType();
			case EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY:
				return getDynamicReferenceKey();
			case EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY:
				return getStaticReferenceKey();
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
			case EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR:
				setInputConnector((NamedEndpointInputConnector)newValue);
				return;
			case EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR:
				setOutputConnector((NamedEndpointOutputConnector)newValue);
				return;
			case EsbPackage.NAMED_ENDPOINT__NAME:
				setName((String)newValue);
				return;
			case EsbPackage.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE:
				setReferringEndpointType((KeyType)newValue);
				return;
			case EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY:
				setDynamicReferenceKey((NamespacedProperty)newValue);
				return;
			case EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY:
				setStaticReferenceKey((RegistryKeyProperty)newValue);
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
			case EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR:
				setInputConnector((NamedEndpointInputConnector)null);
				return;
			case EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR:
				setOutputConnector((NamedEndpointOutputConnector)null);
				return;
			case EsbPackage.NAMED_ENDPOINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsbPackage.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE:
				setReferringEndpointType(REFERRING_ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY:
				setDynamicReferenceKey((NamespacedProperty)null);
				return;
			case EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY:
				setStaticReferenceKey((RegistryKeyProperty)null);
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
			case EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.NAMED_ENDPOINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsbPackage.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE:
				return referringEndpointType != REFERRING_ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY:
				return dynamicReferenceKey != null;
			case EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY:
				return staticReferenceKey != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", referringEndpointType: ");
		result.append(referringEndpointType);
		result.append(')');
		return result.toString();
	}

} //NamedEndpointImpl
