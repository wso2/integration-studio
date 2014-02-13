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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validate Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl#getSchemaKey <em>Schema Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidateSchemaImpl extends ModelObjectImpl implements ValidateSchema {
	/**
	 * The cached value of the '{@link #getValidateStaticSchemaKey() <em>Validate Static Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateStaticSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty validateStaticSchemaKey;
	/**
	 * The cached value of the '{@link #getValidateDynamicSchemaKey() <em>Validate Dynamic Schema Key</em>}' reference.
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
	 */
	protected ValidateSchemaImpl() {
		super();
		
		// Static Key
		validateStaticSchemaKey = getEsbFactory().createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) validateStaticSchemaKey
						.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE,
						PlatformMediaTypeConstants.MEDIA_TYPE_XSD);
		validateStaticSchemaKey.setPrettyName("Static Schema Key");
		validateStaticSchemaKey.setKeyName("key");
		validateStaticSchemaKey
				.setKeyValue(DEFAULT_REGISTRY_KEY);
		setValidateStaticSchemaKey(validateStaticSchemaKey);

		// Dynamic Key
		validateDynamicSchemaKey = getEsbFactory().createNamespacedProperty();
		validateDynamicSchemaKey.setPropertyName("key");
		validateDynamicSchemaKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		validateDynamicSchemaKey.setPrettyName("Dynamic Schema Key");
		setValidateDynamicSchemaKey(validateDynamicSchemaKey);
		// Schema key.
		RegistryKeyProperty schemaKey = getEsbFactory().createRegistryKeyProperty();
		//Set filter properties to filter in only sequences media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)schemaKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_XSD);

		schemaKey.setPrettyName("Validate Schema");
		schemaKey.setKeyName("key");
		schemaKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setSchemaKey(schemaKey);
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		switch (getCurrentEsbVersion()) {
		case ESB301:
			getSchemaKey().load(self);
			break;

		case ESB400:
			if (self.hasAttribute("key")) {
				String attributeValue = self.getAttribute("key");
				if (attributeValue == null) {
					attributeValue = "";
				}
				attributeValue = attributeValue.trim();
				if (attributeValue.startsWith("{")
						&& attributeValue.endsWith("}")) {
					setValidateSchemaKeyType(getValidateSchemaKeyType().DYNAMIC);
					attributeValue = attributeValue.substring(1,
							attributeValue.length() - 2);
					getValidateDynamicSchemaKey().setPropertyValue(
							attributeValue);
				} else {
					setValidateSchemaKeyType(getValidateSchemaKeyType().STATIC);
					getValidateStaticSchemaKey().setKeyValue(attributeValue);
				}
			} else {
				setValidateSchemaKeyType(getValidateSchemaKeyType().STATIC);
			}
			break;
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "schema");
		switch (getCurrentEsbVersion()) {
		case ESB301:
			getSchemaKey().save(self);
			break;
		case ESB400:
			switch (getValidateSchemaKeyType()) {
			case STATIC:
				getValidateStaticSchemaKey().save(self);
				break;
			case DYNAMIC:
				self.setAttribute(getValidateDynamicSchemaKey()
						.getPropertyName(), "{"
						+ getValidateDynamicSchemaKey().getPropertyValue()
						+ "}");
				break;
			}
			break;
		}
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.VALIDATE_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getValidateStaticSchemaKey() {
		if (validateStaticSchemaKey != null && validateStaticSchemaKey.eIsProxy()) {
			InternalEObject oldValidateStaticSchemaKey = (InternalEObject)validateStaticSchemaKey;
			validateStaticSchemaKey = (RegistryKeyProperty)eResolveProxy(oldValidateStaticSchemaKey);
			if (validateStaticSchemaKey != oldValidateStaticSchemaKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY, oldValidateStaticSchemaKey, validateStaticSchemaKey));
			}
		}
		return validateStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetValidateStaticSchemaKey() {
		return validateStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateStaticSchemaKey(RegistryKeyProperty newValidateStaticSchemaKey) {
		RegistryKeyProperty oldValidateStaticSchemaKey = validateStaticSchemaKey;
		validateStaticSchemaKey = newValidateStaticSchemaKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY, oldValidateStaticSchemaKey, validateStaticSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getValidateDynamicSchemaKey() {
		if (validateDynamicSchemaKey != null && validateDynamicSchemaKey.eIsProxy()) {
			InternalEObject oldValidateDynamicSchemaKey = (InternalEObject)validateDynamicSchemaKey;
			validateDynamicSchemaKey = (NamespacedProperty)eResolveProxy(oldValidateDynamicSchemaKey);
			if (validateDynamicSchemaKey != oldValidateDynamicSchemaKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY, oldValidateDynamicSchemaKey, validateDynamicSchemaKey));
			}
		}
		return validateDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetValidateDynamicSchemaKey() {
		return validateDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateDynamicSchemaKey(NamespacedProperty newValidateDynamicSchemaKey) {
		NamespacedProperty oldValidateDynamicSchemaKey = validateDynamicSchemaKey;
		validateDynamicSchemaKey = newValidateDynamicSchemaKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY, oldValidateDynamicSchemaKey, validateDynamicSchemaKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE, oldValidateSchemaKeyType, validateSchemaKeyType));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.VALIDATE_SCHEMA__SCHEMA_KEY, oldSchemaKey, schemaKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_SCHEMA__SCHEMA_KEY, oldSchemaKey, schemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				if (resolve) return getValidateStaticSchemaKey();
				return basicGetValidateStaticSchemaKey();
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				if (resolve) return getValidateDynamicSchemaKey();
				return basicGetValidateDynamicSchemaKey();
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				return getValidateSchemaKeyType();
			case MediatorsPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
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
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				setValidateStaticSchemaKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				setValidateDynamicSchemaKey((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				setValidateSchemaKeyType((KeyType)newValue);
				return;
			case MediatorsPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
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
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				setValidateStaticSchemaKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				setValidateDynamicSchemaKey((NamespacedProperty)null);
				return;
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				setValidateSchemaKeyType(VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
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
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY:
				return validateStaticSchemaKey != null;
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY:
				return validateDynamicSchemaKey != null;
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				return validateSchemaKeyType != VALIDATE_SCHEMA_KEY_TYPE_EDEFAULT;
			case MediatorsPackage.VALIDATE_SCHEMA__SCHEMA_KEY:
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

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} // ValidateSchemaImpl
