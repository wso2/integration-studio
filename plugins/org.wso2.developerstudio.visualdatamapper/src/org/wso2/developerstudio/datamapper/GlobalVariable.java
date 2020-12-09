/**
 */
package org.wso2.developerstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.GlobalVariable#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.GlobalVariable#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getGlobalVariable()
 * @model
 * @generated
 */
public interface GlobalVariable extends Operator {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"defaultName"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getGlobalVariable_Name()
	 * @model default="defaultName"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.GlobalVariable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * The default value is <code>"\"defaultValue\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getGlobalVariable_DefaultValue()
	 * @model default="\"defaultValue\""
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.GlobalVariable#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);
} // GlobalVariable
