/**
 */
package org.wso2.integrationstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.Replace#getTarget <em>Target</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.Replace#getReplaceString <em>Replace String</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getReplace()
 * @model
 * @generated
 */
public interface Replace extends Operator {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * The default value is <code>"{$Target}"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getReplace_Target()
	 * @model default="{$Target}"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.Replace#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

	/**
	 * Returns the value of the '<em><b>Replace String</b></em>' attribute.
	 * The default value is <code>"{$ReplaceWith}"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replace String</em>' attribute.
	 * @see #setReplaceString(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getReplace_ReplaceString()
	 * @model default="{$ReplaceWith}"
	 * @generated
	 */
	String getReplaceString();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.Replace#getReplaceString <em>Replace String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replace String</em>' attribute.
	 * @see #getReplaceString()
	 * @generated
	 */
	void setReplaceString(String value);
} // Replace
