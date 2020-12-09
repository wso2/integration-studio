/**
 */
package org.wso2.developerstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.IfElse#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.IfElse#isGetPatternFromInput <em>Get Pattern From Input</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getIfElse()
 * @model
 * @generated
 */
public interface IfElse extends Operator {

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getIfElse_Condition()
	 * @model default="true"
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.IfElse#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Returns the value of the '<em><b>Get Pattern From Input</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Pattern From Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Pattern From Input</em>' attribute.
	 * @see #setGetPatternFromInput(boolean)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getIfElse_GetPatternFromInput()
	 * @model default="true"
	 * @generated
	 */
	boolean isGetPatternFromInput();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.IfElse#isGetPatternFromInput <em>Get Pattern From Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Pattern From Input</em>' attribute.
	 * @see #isGetPatternFromInput()
	 * @generated
	 */
	void setGetPatternFromInput(boolean value);
} // IfElse
