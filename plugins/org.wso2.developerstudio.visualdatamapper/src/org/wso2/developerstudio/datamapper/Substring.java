/**
 */
package org.wso2.developerstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.Substring#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Substring#getEndIndex <em>End Index</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Substring#isGetPatternFromInput <em>Get Pattern From Input</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSubstring()
 * @model
 * @generated
 */
public interface Substring extends Operator {

	/**
	 * Returns the value of the '<em><b>Start Index</b></em>' attribute.
	 * The default value is <code>"{$StartIndex}"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Index</em>' attribute.
	 * @see #setStartIndex(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSubstring_StartIndex()
	 * @model default="{$StartIndex}"
	 * @generated
	 */
	String getStartIndex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Substring#getStartIndex <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Index</em>' attribute.
	 * @see #getStartIndex()
	 * @generated
	 */
	void setStartIndex(String value);

	/**
	 * Returns the value of the '<em><b>End Index</b></em>' attribute.
	 * The default value is <code>"{$Length}"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Index</em>' attribute.
	 * @see #setEndIndex(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSubstring_EndIndex()
	 * @model default="{$Length}"
	 * @generated
	 */
	String getEndIndex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Substring#getEndIndex <em>End Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Index</em>' attribute.
	 * @see #getEndIndex()
	 * @generated
	 */
	void setEndIndex(String value);

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
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSubstring_GetPatternFromInput()
	 * @model default="true"
	 * @generated
	 */
	boolean isGetPatternFromInput();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Substring#isGetPatternFromInput <em>Get Pattern From Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Pattern From Input</em>' attribute.
	 * @see #isGetPatternFromInput()
	 * @generated
	 */
	void setGetPatternFromInput(boolean value);
} // Substring
