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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fast XSLT Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FastXSLTMediatorImpl#getFastXsltSchemaKeyType <em>Fast Xslt Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FastXSLTMediatorImpl#getFastXsltStaticSchemaKey <em>Fast Xslt Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FastXSLTMediatorImpl#getFastXsltDynamicSchemaKey <em>Fast Xslt Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FastXSLTMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FastXSLTMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FastXSLTMediatorImpl extends MediatorImpl implements FastXSLTMediator {
	/**
	 * The default value of the '{@link #getFastXsltSchemaKeyType() <em>Fast Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFastXsltSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType FAST_XSLT_SCHEMA_KEY_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getFastXsltSchemaKeyType() <em>Fast Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFastXsltSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected KeyType fastXsltSchemaKeyType = FAST_XSLT_SCHEMA_KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFastXsltStaticSchemaKey() <em>Fast Xslt Static Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFastXsltStaticSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty fastXsltStaticSchemaKey;

	/**
	 * The cached value of the '{@link #getFastXsltDynamicSchemaKey() <em>Fast Xslt Dynamic Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFastXsltDynamicSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty fastXsltDynamicSchemaKey;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected FastXSLTMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected FastXSLTMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
    protected FastXSLTMediatorImpl() {
		super();
		// Fast XSLT Static Schema Key
		fastXsltStaticSchemaKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		// Set filter properties to filter in only fast xslt media type
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) fastXsltStaticSchemaKey.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				PlatformMediaTypeConstants.MEDIA_TYPE_XSLT);

		fastXsltStaticSchemaKey.setPrettyName("XSLT Static Key");
		fastXsltStaticSchemaKey.setKeyName("key");
		fastXsltStaticSchemaKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setFastXsltStaticSchemaKey(fastXsltStaticSchemaKey);

		// Fast XSLT Dynamic Schema Key
		fastXsltDynamicSchemaKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		fastXsltDynamicSchemaKey.setPrettyName("XSLT Dynamic Key");
		fastXsltDynamicSchemaKey.setPropertyName("key");
		fastXsltDynamicSchemaKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setFastXsltDynamicSchemaKey(fastXsltDynamicSchemaKey);					
				
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.FAST_XSLT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getFastXsltSchemaKeyType() {
		return fastXsltSchemaKeyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFastXsltSchemaKeyType(KeyType newFastXsltSchemaKeyType) {
		KeyType oldFastXsltSchemaKeyType = fastXsltSchemaKeyType;
		fastXsltSchemaKeyType = newFastXsltSchemaKeyType == null ? FAST_XSLT_SCHEMA_KEY_TYPE_EDEFAULT : newFastXsltSchemaKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE, oldFastXsltSchemaKeyType, fastXsltSchemaKeyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getFastXsltStaticSchemaKey() {
		return fastXsltStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFastXsltStaticSchemaKey(RegistryKeyProperty newFastXsltStaticSchemaKey, NotificationChain msgs) {
		RegistryKeyProperty oldFastXsltStaticSchemaKey = fastXsltStaticSchemaKey;
		fastXsltStaticSchemaKey = newFastXsltStaticSchemaKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY, oldFastXsltStaticSchemaKey, newFastXsltStaticSchemaKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFastXsltStaticSchemaKey(RegistryKeyProperty newFastXsltStaticSchemaKey) {
		if (newFastXsltStaticSchemaKey != fastXsltStaticSchemaKey) {
			NotificationChain msgs = null;
			if (fastXsltStaticSchemaKey != null)
				msgs = ((InternalEObject)fastXsltStaticSchemaKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY, null, msgs);
			if (newFastXsltStaticSchemaKey != null)
				msgs = ((InternalEObject)newFastXsltStaticSchemaKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY, null, msgs);
			msgs = basicSetFastXsltStaticSchemaKey(newFastXsltStaticSchemaKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY, newFastXsltStaticSchemaKey, newFastXsltStaticSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFastXsltDynamicSchemaKey() {
		return fastXsltDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFastXsltDynamicSchemaKey(NamespacedProperty newFastXsltDynamicSchemaKey, NotificationChain msgs) {
		NamespacedProperty oldFastXsltDynamicSchemaKey = fastXsltDynamicSchemaKey;
		fastXsltDynamicSchemaKey = newFastXsltDynamicSchemaKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY, oldFastXsltDynamicSchemaKey, newFastXsltDynamicSchemaKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFastXsltDynamicSchemaKey(NamespacedProperty newFastXsltDynamicSchemaKey) {
		if (newFastXsltDynamicSchemaKey != fastXsltDynamicSchemaKey) {
			NotificationChain msgs = null;
			if (fastXsltDynamicSchemaKey != null)
				msgs = ((InternalEObject)fastXsltDynamicSchemaKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY, null, msgs);
			if (newFastXsltDynamicSchemaKey != null)
				msgs = ((InternalEObject)newFastXsltDynamicSchemaKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY, null, msgs);
			msgs = basicSetFastXsltDynamicSchemaKey(newFastXsltDynamicSchemaKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY, newFastXsltDynamicSchemaKey, newFastXsltDynamicSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastXSLTMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(FastXSLTMediatorInputConnector newInputConnector, NotificationChain msgs) {
		FastXSLTMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(FastXSLTMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastXSLTMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(FastXSLTMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		FastXSLTMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(FastXSLTMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY:
				return basicSetFastXsltStaticSchemaKey(null, msgs);
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY:
				return basicSetFastXsltDynamicSchemaKey(null, msgs);
			case EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE:
				return getFastXsltSchemaKeyType();
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY:
				return getFastXsltStaticSchemaKey();
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY:
				return getFastXsltDynamicSchemaKey();
			case EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE:
				setFastXsltSchemaKeyType((KeyType)newValue);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY:
				setFastXsltStaticSchemaKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY:
				setFastXsltDynamicSchemaKey((NamespacedProperty)newValue);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((FastXSLTMediatorInputConnector)newValue);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((FastXSLTMediatorOutputConnector)newValue);
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
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE:
				setFastXsltSchemaKeyType(FAST_XSLT_SCHEMA_KEY_TYPE_EDEFAULT);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY:
				setFastXsltStaticSchemaKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY:
				setFastXsltDynamicSchemaKey((NamespacedProperty)null);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((FastXSLTMediatorInputConnector)null);
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((FastXSLTMediatorOutputConnector)null);
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
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE:
				return fastXsltSchemaKeyType != FAST_XSLT_SCHEMA_KEY_TYPE_EDEFAULT;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY:
				return fastXsltStaticSchemaKey != null;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY:
				return fastXsltDynamicSchemaKey != null;
			case EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR:
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
		result.append(" (fastXsltSchemaKeyType: ");
		result.append(fastXsltSchemaKeyType);
		result.append(')');
		return result.toString();
	}

} //FastXSLTMediatorImpl
