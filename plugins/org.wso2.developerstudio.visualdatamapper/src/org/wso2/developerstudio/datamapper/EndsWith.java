/**
 */
package org.wso2.developerstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ends With</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.EndsWith#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.EndsWith#isGetPatternFromInput <em>Get Pattern From Input</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getEndsWith()
 * @model
 * @generated
 */
public interface EndsWith extends Operator {

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * The default value is <code>"{$Pattern}"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getEndsWith_Pattern()
	 * @model default="{$Pattern}"
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.EndsWith#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

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
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getEndsWith_GetPatternFromInput()
	 * @model default="true"
	 * @generated
	 */
	boolean isGetPatternFromInput();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.EndsWith#isGetPatternFromInput <em>Get Pattern From Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Pattern From Input</em>' attribute.
	 * @see #isGetPatternFromInput()
	 * @generated
	 */
	void setGetPatternFromInput(boolean value);
} // EndsWith
