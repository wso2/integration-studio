/**
 */
package org.wso2.developerstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Precision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.SetPrecision#getNumberOfDigits <em>Number Of Digits</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSetPrecision()
 * @model
 * @generated
 */
public interface SetPrecision extends Operator {

	/**
	 * Returns the value of the '<em><b>Number Of Digits</b></em>' attribute.
	 * The default value is <code>"{$NoOfDigits}"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Digits</em>' attribute.
	 * @see #setNumberOfDigits(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSetPrecision_NumberOfDigits()
	 * @model default="{$NoOfDigits}"
	 * @generated
	 */
	String getNumberOfDigits();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.SetPrecision#getNumberOfDigits <em>Number Of Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Digits</em>' attribute.
	 * @see #getNumberOfDigits()
	 * @generated
	 */
	void setNumberOfDigits(String value);
} // SetPrecision
