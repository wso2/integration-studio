/**
 */
package org.wso2.integrationstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compare</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.Compare#getComparisonOperator <em>Comparison Operator</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCompare()
 * @model
 * @generated
 */
public interface Compare extends Operator {

	/**
	 * Returns the value of the '<em><b>Comparison Operator</b></em>' attribute.
	 * The default value is <code>"=="</code>.
	 * The literals are from the enumeration {@link org.wso2.integrationstudio.datamapper.ComparisonOperatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparison Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparison Operator</em>' attribute.
	 * @see org.wso2.integrationstudio.datamapper.ComparisonOperatorType
	 * @see #setComparisonOperator(ComparisonOperatorType)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCompare_ComparisonOperator()
	 * @model default="=="
	 * @generated
	 */
	ComparisonOperatorType getComparisonOperator();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.Compare#getComparisonOperator <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparison Operator</em>' attribute.
	 * @see org.wso2.integrationstudio.datamapper.ComparisonOperatorType
	 * @see #getComparisonOperator()
	 * @generated
	 */
	void setComparisonOperator(ComparisonOperatorType value);
} // Compare
