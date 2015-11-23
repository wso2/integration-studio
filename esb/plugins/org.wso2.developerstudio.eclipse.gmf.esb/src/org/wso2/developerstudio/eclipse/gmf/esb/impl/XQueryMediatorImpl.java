/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XQuery Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getTargetXPath <em>Target XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getScriptKeyType <em>Script Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getStaticScriptKey <em>Static Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getDynamicScriptKey <em>Dynamic Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getQueryKey <em>Query Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XQueryMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XQueryMediatorImpl extends MediatorImpl implements XQueryMediator {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<XQueryVariable> variables;

	/**
	 * The cached value of the '{@link #getTargetXPath() <em>Target XPath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetXPath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty targetXPath;

	/**
	 * The default value of the '{@link #getScriptKeyType() <em>Script Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType SCRIPT_KEY_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getScriptKeyType() <em>Script Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptKeyType()
	 * @generated
	 * @ordered
	 */
	protected KeyType scriptKeyType = SCRIPT_KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStaticScriptKey() <em>Static Script Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticScriptKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty staticScriptKey;

	/**
	 * The cached value of the '{@link #getDynamicScriptKey() <em>Dynamic Script Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicScriptKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicScriptKey;

	/**
	 * The cached value of the '{@link #getQueryKey() <em>Query Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty queryKey;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected XQueryMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected XQueryMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected XQueryMediatorImpl() {
		super();
		// Query key.
		RegistryKeyProperty queryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		queryKey.setPrettyName("XQuery Key");
		queryKey.setKeyName("key");
		queryKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setQueryKey(queryKey);

		// Static script key.
		staticScriptKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		staticScriptKey.setPrettyName("Static Script Key");
		staticScriptKey.setKeyName("key");
		staticScriptKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setStaticScriptKey(staticScriptKey);

		// Dynamic script key
		dynamicScriptKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		dynamicScriptKey.setPrettyName("Dynamic Script Key");
		dynamicScriptKey.setPropertyName("key");
		dynamicScriptKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setDynamicScriptKey(dynamicScriptKey);

		// Target XPath.
		NamespacedProperty targetXPath = EsbFactoryImpl.eINSTANCE
				.createNamespacedProperty();
		targetXPath.setPrettyName("Target XPath");
		targetXPath.setPropertyName("target");
		setTargetXPath(targetXPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.XQUERY_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XQueryVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<XQueryVariable>(XQueryVariable.class, this, EsbPackage.XQUERY_MEDIATOR__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getTargetXPath() {
		return targetXPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetXPath(NamespacedProperty newTargetXPath, NotificationChain msgs) {
		NamespacedProperty oldTargetXPath = targetXPath;
		targetXPath = newTargetXPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH, oldTargetXPath, newTargetXPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetXPath(NamespacedProperty newTargetXPath) {
		if (newTargetXPath != targetXPath) {
			NotificationChain msgs = null;
			if (targetXPath != null)
				msgs = ((InternalEObject)targetXPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH, null, msgs);
			if (newTargetXPath != null)
				msgs = ((InternalEObject)newTargetXPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH, null, msgs);
			msgs = basicSetTargetXPath(newTargetXPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH, newTargetXPath, newTargetXPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getScriptKeyType() {
		return scriptKeyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptKeyType(KeyType newScriptKeyType) {
		KeyType oldScriptKeyType = scriptKeyType;
		scriptKeyType = newScriptKeyType == null ? SCRIPT_KEY_TYPE_EDEFAULT : newScriptKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE, oldScriptKeyType, scriptKeyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getStaticScriptKey() {
		return staticScriptKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStaticScriptKey(RegistryKeyProperty newStaticScriptKey, NotificationChain msgs) {
		RegistryKeyProperty oldStaticScriptKey = staticScriptKey;
		staticScriptKey = newStaticScriptKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, oldStaticScriptKey, newStaticScriptKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticScriptKey(RegistryKeyProperty newStaticScriptKey) {
		if (newStaticScriptKey != staticScriptKey) {
			NotificationChain msgs = null;
			if (staticScriptKey != null)
				msgs = ((InternalEObject)staticScriptKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, null, msgs);
			if (newStaticScriptKey != null)
				msgs = ((InternalEObject)newStaticScriptKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, null, msgs);
			msgs = basicSetStaticScriptKey(newStaticScriptKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, newStaticScriptKey, newStaticScriptKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicScriptKey() {
		return dynamicScriptKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicScriptKey(NamespacedProperty newDynamicScriptKey, NotificationChain msgs) {
		NamespacedProperty oldDynamicScriptKey = dynamicScriptKey;
		dynamicScriptKey = newDynamicScriptKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, oldDynamicScriptKey, newDynamicScriptKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicScriptKey(NamespacedProperty newDynamicScriptKey) {
		if (newDynamicScriptKey != dynamicScriptKey) {
			NotificationChain msgs = null;
			if (dynamicScriptKey != null)
				msgs = ((InternalEObject)dynamicScriptKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, null, msgs);
			if (newDynamicScriptKey != null)
				msgs = ((InternalEObject)newDynamicScriptKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, null, msgs);
			msgs = basicSetDynamicScriptKey(newDynamicScriptKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, newDynamicScriptKey, newDynamicScriptKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getQueryKey() {
		return queryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQueryKey(RegistryKeyProperty newQueryKey, NotificationChain msgs) {
		RegistryKeyProperty oldQueryKey = queryKey;
		queryKey = newQueryKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__QUERY_KEY, oldQueryKey, newQueryKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryKey(RegistryKeyProperty newQueryKey) {
		if (newQueryKey != queryKey) {
			NotificationChain msgs = null;
			if (queryKey != null)
				msgs = ((InternalEObject)queryKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__QUERY_KEY, null, msgs);
			if (newQueryKey != null)
				msgs = ((InternalEObject)newQueryKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__QUERY_KEY, null, msgs);
			msgs = basicSetQueryKey(newQueryKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__QUERY_KEY, newQueryKey, newQueryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(XQueryMediatorInputConnector newInputConnector, NotificationChain msgs) {
		XQueryMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(XQueryMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(XQueryMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		XQueryMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(XQueryMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.XQUERY_MEDIATOR__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				return basicSetTargetXPath(null, msgs);
			case EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				return basicSetStaticScriptKey(null, msgs);
			case EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				return basicSetDynamicScriptKey(null, msgs);
			case EsbPackage.XQUERY_MEDIATOR__QUERY_KEY:
				return basicSetQueryKey(null, msgs);
			case EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.XQUERY_MEDIATOR__VARIABLES:
				return getVariables();
			case EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				return getTargetXPath();
			case EsbPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				return getScriptKeyType();
			case EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				return getStaticScriptKey();
			case EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				return getDynamicScriptKey();
			case EsbPackage.XQUERY_MEDIATOR__QUERY_KEY:
				return getQueryKey();
			case EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
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
			case EsbPackage.XQUERY_MEDIATOR__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends XQueryVariable>)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				setTargetXPath((NamespacedProperty)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				setScriptKeyType((KeyType)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				setStaticScriptKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				setDynamicScriptKey((NamespacedProperty)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__QUERY_KEY:
				setQueryKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((XQueryMediatorInputConnector)newValue);
				return;
			case EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((XQueryMediatorOutputConnector)newValue);
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
			case EsbPackage.XQUERY_MEDIATOR__VARIABLES:
				getVariables().clear();
				return;
			case EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				setTargetXPath((NamespacedProperty)null);
				return;
			case EsbPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				setScriptKeyType(SCRIPT_KEY_TYPE_EDEFAULT);
				return;
			case EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				setStaticScriptKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				setDynamicScriptKey((NamespacedProperty)null);
				return;
			case EsbPackage.XQUERY_MEDIATOR__QUERY_KEY:
				setQueryKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((XQueryMediatorInputConnector)null);
				return;
			case EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((XQueryMediatorOutputConnector)null);
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
			case EsbPackage.XQUERY_MEDIATOR__VARIABLES:
				return variables != null && !variables.isEmpty();
			case EsbPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				return targetXPath != null;
			case EsbPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				return scriptKeyType != SCRIPT_KEY_TYPE_EDEFAULT;
			case EsbPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				return staticScriptKey != null;
			case EsbPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				return dynamicScriptKey != null;
			case EsbPackage.XQUERY_MEDIATOR__QUERY_KEY:
				return queryKey != null;
			case EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR:
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
		result.append(" (scriptKeyType: ");
		result.append(scriptKeyType);
		result.append(')');
		return result.toString();
	}

} //XQueryMediatorImpl
