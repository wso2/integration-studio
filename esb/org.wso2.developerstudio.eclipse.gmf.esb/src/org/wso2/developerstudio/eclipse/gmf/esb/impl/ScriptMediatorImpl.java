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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptLanguage;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptType;
import org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getMediateFunction <em>Mediate Function</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getScriptDynamicKey <em>Script Dynamic Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getScriptBody <em>Script Body</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getKeyType <em>Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getScriptStaticKey <em>Script Static Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ScriptMediatorImpl#getScriptKeys <em>Script Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptMediatorImpl extends MediatorImpl implements ScriptMediator {
	/**
	 * The default value of the '{@link #getScriptType() <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected static final ScriptType SCRIPT_TYPE_EDEFAULT = ScriptType.REGISTRY_REFERENCE;

	/**
	 * The cached value of the '{@link #getScriptType() <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected ScriptType scriptType = SCRIPT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScriptLanguage() <em>Script Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final ScriptLanguage SCRIPT_LANGUAGE_EDEFAULT = ScriptLanguage.JAVASCRIPT;

	/**
	 * The cached value of the '{@link #getScriptLanguage() <em>Script Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptLanguage()
	 * @generated
	 * @ordered
	 */
	protected ScriptLanguage scriptLanguage = SCRIPT_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMediateFunction() <em>Mediate Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediateFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String MEDIATE_FUNCTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getMediateFunction() <em>Mediate Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediateFunction()
	 * @generated
	 * @ordered
	 */
	protected String mediateFunction = MEDIATE_FUNCTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScriptDynamicKey() <em>Script Dynamic Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptDynamicKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty scriptDynamicKey;

	/**
	 * The default value of the '{@link #getScriptBody() <em>Script Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptBody()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_BODY_EDEFAULT = "script_code";

	/**
	 * The cached value of the '{@link #getScriptBody() <em>Script Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptBody()
	 * @generated
	 * @ordered
	 */
	protected String scriptBody = SCRIPT_BODY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ScriptMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ScriptMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getKeyType() <em>Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final scriptKeyTypeEnum KEY_TYPE_EDEFAULT = scriptKeyTypeEnum.STATIC_KEY;

	/**
	 * The cached value of the '{@link #getKeyType() <em>Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyType()
	 * @generated
	 * @ordered
	 */
	protected scriptKeyTypeEnum keyType = KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScriptStaticKey() <em>Script Static Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptStaticKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty scriptStaticKey;

	/**
	 * The cached value of the '{@link #getScriptKeys() <em>Script Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistryKeyProperty> scriptKeys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ScriptMediatorImpl() {
		super();
		
		// Script key.
		RegistryKeyProperty key = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		key.setPrettyName("Script Key");
		key.setKeyName("key");
		key.setKeyValue(DEFAULT_REGISTRY_KEY);
		setScriptStaticKey(key);
		NamespacedProperty namespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		namespacedProperty.setPrettyName("");
		namespacedProperty.setPropertyName("dynamic key");
		namespacedProperty.setPropertyValue("/xpath/expression");
		setScriptDynamicKey(namespacedProperty);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SCRIPT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType getScriptType() {
		return scriptType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptType(ScriptType newScriptType) {
		ScriptType oldScriptType = scriptType;
		scriptType = newScriptType == null ? SCRIPT_TYPE_EDEFAULT : newScriptType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE, oldScriptType, scriptType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptLanguage getScriptLanguage() {
		return scriptLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptLanguage(ScriptLanguage newScriptLanguage) {
		ScriptLanguage oldScriptLanguage = scriptLanguage;
		scriptLanguage = newScriptLanguage == null ? SCRIPT_LANGUAGE_EDEFAULT : newScriptLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE, oldScriptLanguage, scriptLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMediateFunction() {
		return mediateFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediateFunction(String newMediateFunction) {
		String oldMediateFunction = mediateFunction;
		mediateFunction = newMediateFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION, oldMediateFunction, mediateFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getScriptDynamicKey() {
		return scriptDynamicKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScriptDynamicKey(NamespacedProperty newScriptDynamicKey, NotificationChain msgs) {
		NamespacedProperty oldScriptDynamicKey = scriptDynamicKey;
		scriptDynamicKey = newScriptDynamicKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY, oldScriptDynamicKey, newScriptDynamicKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptDynamicKey(NamespacedProperty newScriptDynamicKey) {
		if (newScriptDynamicKey != scriptDynamicKey) {
			NotificationChain msgs = null;
			if (scriptDynamicKey != null)
				msgs = ((InternalEObject)scriptDynamicKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY, null, msgs);
			if (newScriptDynamicKey != null)
				msgs = ((InternalEObject)newScriptDynamicKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY, null, msgs);
			msgs = basicSetScriptDynamicKey(newScriptDynamicKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY, newScriptDynamicKey, newScriptDynamicKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScriptBody() {
		return scriptBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptBody(String newScriptBody) {
		String oldScriptBody = scriptBody;
		scriptBody = newScriptBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_BODY, oldScriptBody, scriptBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(ScriptMediatorInputConnector newInputConnector, NotificationChain msgs) {
		ScriptMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(ScriptMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(ScriptMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		ScriptMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(ScriptMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scriptKeyTypeEnum getKeyType() {
		return keyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyType(scriptKeyTypeEnum newKeyType) {
		scriptKeyTypeEnum oldKeyType = keyType;
		keyType = newKeyType == null ? KEY_TYPE_EDEFAULT : newKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__KEY_TYPE, oldKeyType, keyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getScriptStaticKey() {
		return scriptStaticKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScriptStaticKey(RegistryKeyProperty newScriptStaticKey, NotificationChain msgs) {
		RegistryKeyProperty oldScriptStaticKey = scriptStaticKey;
		scriptStaticKey = newScriptStaticKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY, oldScriptStaticKey, newScriptStaticKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptStaticKey(RegistryKeyProperty newScriptStaticKey) {
		if (newScriptStaticKey != scriptStaticKey) {
			NotificationChain msgs = null;
			if (scriptStaticKey != null)
				msgs = ((InternalEObject)scriptStaticKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY, null, msgs);
			if (newScriptStaticKey != null)
				msgs = ((InternalEObject)newScriptStaticKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY, null, msgs);
			msgs = basicSetScriptStaticKey(newScriptStaticKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY, newScriptStaticKey, newScriptStaticKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistryKeyProperty> getScriptKeys() {
		if (scriptKeys == null) {
			scriptKeys = new EObjectContainmentEList<RegistryKeyProperty>(RegistryKeyProperty.class, this, EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS);
		}
		return scriptKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY:
				return basicSetScriptDynamicKey(null, msgs);
			case EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY:
				return basicSetScriptStaticKey(null, msgs);
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS:
				return ((InternalEList<?>)getScriptKeys()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				return getScriptType();
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				return getScriptLanguage();
			case EsbPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				return getMediateFunction();
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY:
				return getScriptDynamicKey();
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				return getScriptBody();
			case EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.SCRIPT_MEDIATOR__KEY_TYPE:
				return getKeyType();
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY:
				return getScriptStaticKey();
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS:
				return getScriptKeys();
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
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				setScriptType((ScriptType)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				setScriptLanguage((ScriptLanguage)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				setMediateFunction((String)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY:
				setScriptDynamicKey((NamespacedProperty)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				setScriptBody((String)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ScriptMediatorInputConnector)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ScriptMediatorOutputConnector)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__KEY_TYPE:
				setKeyType((scriptKeyTypeEnum)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY:
				setScriptStaticKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS:
				getScriptKeys().clear();
				getScriptKeys().addAll((Collection<? extends RegistryKeyProperty>)newValue);
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
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				setScriptType(SCRIPT_TYPE_EDEFAULT);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				setScriptLanguage(SCRIPT_LANGUAGE_EDEFAULT);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				setMediateFunction(MEDIATE_FUNCTION_EDEFAULT);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY:
				setScriptDynamicKey((NamespacedProperty)null);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				setScriptBody(SCRIPT_BODY_EDEFAULT);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ScriptMediatorInputConnector)null);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ScriptMediatorOutputConnector)null);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__KEY_TYPE:
				setKeyType(KEY_TYPE_EDEFAULT);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY:
				setScriptStaticKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS:
				getScriptKeys().clear();
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
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				return scriptType != SCRIPT_TYPE_EDEFAULT;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				return scriptLanguage != SCRIPT_LANGUAGE_EDEFAULT;
			case EsbPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				return MEDIATE_FUNCTION_EDEFAULT == null ? mediateFunction != null : !MEDIATE_FUNCTION_EDEFAULT.equals(mediateFunction);
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY:
				return scriptDynamicKey != null;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				return SCRIPT_BODY_EDEFAULT == null ? scriptBody != null : !SCRIPT_BODY_EDEFAULT.equals(scriptBody);
			case EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.SCRIPT_MEDIATOR__KEY_TYPE:
				return keyType != KEY_TYPE_EDEFAULT;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY:
				return scriptStaticKey != null;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS:
				return scriptKeys != null && !scriptKeys.isEmpty();
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
		result.append(" (scriptType: ");
		result.append(scriptType);
		result.append(", scriptLanguage: ");
		result.append(scriptLanguage);
		result.append(", mediateFunction: ");
		result.append(mediateFunction);
		result.append(", scriptBody: ");
		result.append(scriptBody);
		result.append(", keyType: ");
		result.append(keyType);
		result.append(')');
		return result.toString();
	}

} //ScriptMediatorImpl
