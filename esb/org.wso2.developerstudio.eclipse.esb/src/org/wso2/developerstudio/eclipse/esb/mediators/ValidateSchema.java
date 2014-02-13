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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validate Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getSchemaKey <em>Schema Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateSchema()
 * @model
 * @generated
 */
public interface ValidateSchema extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Validate Static Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Static Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Static Schema Key</em>' reference.
	 * @see #setValidateStaticSchemaKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateSchema_ValidateStaticSchemaKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getValidateStaticSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Static Schema Key</em>' reference.
	 * @see #getValidateStaticSchemaKey()
	 * @generated
	 */
	void setValidateStaticSchemaKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Validate Dynamic Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Dynamic Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Dynamic Schema Key</em>' reference.
	 * @see #setValidateDynamicSchemaKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateSchema_ValidateDynamicSchemaKey()
	 * @model
	 * @generated
	 */
	NamespacedProperty getValidateDynamicSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Dynamic Schema Key</em>' reference.
	 * @see #getValidateDynamicSchemaKey()
	 * @generated
	 */
	void setValidateDynamicSchemaKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Validate Schema Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Schema Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #setValidateSchemaKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateSchema_ValidateSchemaKeyType()
	 * @model
	 * @generated
	 */
	KeyType getValidateSchemaKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #getValidateSchemaKeyType()
	 * @generated
	 */
	void setValidateSchemaKeyType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Key</em>' reference.
	 * @see #setSchemaKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateSchema_SchemaKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getSchemaKey <em>Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Key</em>' reference.
	 * @see #getSchemaKey()
	 * @generated
	 */
	void setSchemaKey(RegistryKeyProperty value);

} // ValidateSchema
