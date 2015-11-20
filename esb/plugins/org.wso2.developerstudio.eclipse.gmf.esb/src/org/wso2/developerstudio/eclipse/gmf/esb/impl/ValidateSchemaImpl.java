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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validate Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateSchemaImpl#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateSchemaImpl#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateSchemaImpl#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateSchemaImpl#getSchemaKey <em>Schema Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidateSchemaImpl extends EsbNodeImpl implements ValidateSchema {
	/**
	 * The cached value of the '{@link #getValidateStaticSchemaKey() <em>Validate Static Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateStaticSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty validateStaticSchemaKey;

	/**
	 * The cached value of the '{@link #getValidateDynamicSchemaKey() <em>Validate Dynamic Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateDynamicSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty validateDynamicSchemaKey;

	/**
	 * The default value of the '{@link #getValidateSchemaKeyType() <em>Validate Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getValidateSchemaKeyType() <em>Validate Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected KeyType validateSchemaKeyType = VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSchemaKey() <em>Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty schemaKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ValidateSchemaImpl() {
		super();
		setValidateSchemaKeyType(KeyType.STATIC);
		
		NamespacedProperty valueExpression = EsbFactory.eINSTANCE.createNamespacedProperty();
		valueExpression.setPropertyName("expression");
		valueExpression.setPrettyName("expression");
		valueExpression.setPropertyValue("/default/expression");
		setValidateDynamicSchemaKey(valueExpression);
		
		RegistryKeyProperty registryPropertyKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		registryPropertyKey.setKeyName("keyName");
		registryPropertyKey.setPrettyName("prettyName");
		registryPropertyKey.setKeyValue("default/key");	
		setValidateStaticSchemaKey(registryPropertyKey);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.VALIDATE_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getValidateStaticSchemaKey() {
		return validateStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidateStaticSchemaKey(RegistryKeyProperty newValidateStaticSchemaKey, NotificationChain msgs) {
		RegistryKeyProperty oldValidateStaticSchemaKey = validateStaticSchemaKey;
		validateStaticSchemaKey = newValidateStaticSchemaKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY, oldValidateStaticSchemaKey, newValidateStaticSchemaKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateStaticSchemaKey(RegistryKeyProperty newValidateStaticSchemaKey) {
		if (newValidateStaticSchemaKey != validateStaticSchemaKey) {
			NotificationChain msgs = null;
			if (validateStaticSchemaKey != null)
				msgs = ((InternalEObject)validateStaticSchemaKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY, null, msgs);
			if (newValidateStaticSchemaKey != null)
				msgs = ((InternalEObject)newValidateStaticSchemaKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY, null, msgs);
			msgs = basicSetValidateStaticSchemaKey(newValidateStaticSchemaKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY, newValidateStaticSchemaKey, newValidateStaticSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getValidateDynamicSchemaKey() {
		return validateDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidateDynamicSchemaKey(NamespacedProperty newValidateDynamicSchemaKey, NotificationChain msgs) {
		NamespacedProperty oldValidateDynamicSchemaKey = validateDynamicSchemaKey;
		validateDynamicSchemaKey = newValidateDynamicSchemaKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY, oldValidateDynamicSchemaKey, newValidateDynamicSchemaKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateDynamicSchemaKey(NamespacedProperty newValidateDynamicSchemaKey) {
		if (newValidateDynamicSchemaKey != validateDynamicSchemaKey) {
			NotificationChain msgs = null;
			if (validateDynamicSchemaKey != null)
				msgs = ((InternalEObject)validateDynamicSchemaKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY, null, msgs);
			if (newValidateDynamicSchemaKey != null)
				msgs = ((InternalEObject)newValidateDynamicSchemaKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY, null, msgs);
			msgs = basicSetValidateDynamicSchemaKey(newValidateDynamicSchemaKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY, newValidateDynamicSchemaKey, newValidateDynamicSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getValidateSchemaKeyType() {
		return validateSchemaKeyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateSchemaKeyType(KeyType newValidateSchemaKeyType) {
		KeyType oldValidateSchemaKeyType = validateSchemaKeyType;
		validateSchemaKeyType = newValidateSchemaKeyType == null ? VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT : newValidateSchemaKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE, oldValidateSchemaKeyType, validateSchemaKeyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSchemaKey() {
		if (schemaKey != null && schemaKey.eIsProxy()) {
			InternalEObject oldSchemaKey = (InternalEObject)schemaKey;
			schemaKey = (RegistryKeyProperty)eResolveProxy(oldSchemaKey);
			if (schemaKey != oldSchemaKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.VALIDATE_SCHEMA__SCHEMA_KEY, oldSchemaKey, schemaKey));
			}
		}
		return schemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetSchemaKey() {
		return schemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemaKey(RegistryKeyProperty newSchemaKey) {
		RegistryKeyProperty oldSchemaKey = schemaKey;
		schemaKey = newSchemaKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_SCHEMA__SCHEMA_KEY, oldSchemaKey, schemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				return basicSetValidateStaticSchemaKey(null, msgs);
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				return basicSetValidateDynamicSchemaKey(null, msgs);
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
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				return getValidateStaticSchemaKey();
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				return getValidateDynamicSchemaKey();
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				return getValidateSchemaKeyType();
			case EsbPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
				if (resolve) return getSchemaKey();
				return basicGetSchemaKey();
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
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				setValidateStaticSchemaKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				setValidateDynamicSchemaKey((NamespacedProperty)newValue);
				return;
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				setValidateSchemaKeyType((KeyType)newValue);
				return;
			case EsbPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
				setSchemaKey((RegistryKeyProperty)newValue);
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
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				setValidateStaticSchemaKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				setValidateDynamicSchemaKey((NamespacedProperty)null);
				return;
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				setValidateSchemaKeyType(VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT);
				return;
			case EsbPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
				setSchemaKey((RegistryKeyProperty)null);
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
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				return validateStaticSchemaKey != null;
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				return validateDynamicSchemaKey != null;
			case EsbPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				return validateSchemaKeyType != VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT;
			case EsbPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
				return schemaKey != null;
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
		result.append(" (validateSchemaKeyType: ");
		result.append(validateSchemaKeyType);
		result.append(')');
		return result.toString();
	}

} //ValidateSchemaImpl
