/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validate Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getSchemaKey <em>Schema Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getValidateSchema()
 * @model
 * @generated
 */
public interface ValidateSchema extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Validate Static Schema Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Static Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Static Schema Key</em>' containment reference.
	 * @see #setValidateStaticSchemaKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getValidateSchema_ValidateStaticSchemaKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getValidateStaticSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Static Schema Key</em>' containment reference.
	 * @see #getValidateStaticSchemaKey()
	 * @generated
	 */
	void setValidateStaticSchemaKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Validate Dynamic Schema Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Dynamic Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Dynamic Schema Key</em>' containment reference.
	 * @see #setValidateDynamicSchemaKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getValidateSchema_ValidateDynamicSchemaKey()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValidateDynamicSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Dynamic Schema Key</em>' containment reference.
	 * @see #getValidateDynamicSchemaKey()
	 * @generated
	 */
	void setValidateDynamicSchemaKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Validate Schema Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Schema Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #setValidateSchemaKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getValidateSchema_ValidateSchemaKeyType()
	 * @model
	 * @generated
	 */
	KeyType getValidateSchemaKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getValidateSchema_SchemaKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema#getSchemaKey <em>Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Key</em>' reference.
	 * @see #getSchemaKey()
	 * @generated
	 */
	void setSchemaKey(RegistryKeyProperty value);

} // ValidateSchema
