/**
 */
package org.wso2.integrationstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.Constant#getConstantValue <em>Constant Value</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.Constant#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getConstant()
 * @model
 * @generated
 */
public interface Constant extends Operator {

	/**
	 * Returns the value of the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Value</em>' attribute.
	 * @see #setConstantValue(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getConstant_ConstantValue()
	 * @model
	 * @generated
	 */
	String getConstantValue();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.Constant#getConstantValue <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Value</em>' attribute.
	 * @see #getConstantValue()
	 * @generated
	 */
	void setConstantValue(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"STRING"</code>.
	 * The literals are from the enumeration {@link org.wso2.integrationstudio.datamapper.SchemaDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.wso2.integrationstudio.datamapper.SchemaDataType
	 * @see #setType(SchemaDataType)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getConstant_Type()
	 * @model default="STRING"
	 * @generated
	 */
	SchemaDataType getType();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.Constant#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.wso2.integrationstudio.datamapper.SchemaDataType
	 * @see #getType()
	 * @generated
	 */
	void setType(SchemaDataType value);
} // Constant
