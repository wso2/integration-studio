/**
 */
package org.wso2.integrationstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced Custom Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.AdvancedCustomFunction#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.AdvancedCustomFunction#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.AdvancedCustomFunction#isIsEndFunction <em>Is End Function</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getAdvancedCustomFunction()
 * @model
 * @generated
 */
public interface AdvancedCustomFunction extends Operator {
	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * The default value is <code>"endFunction"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getAdvancedCustomFunction_FunctionName()
	 * @model default="endFunction"
	 * @generated
	 */
	String getFunctionName();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.AdvancedCustomFunction#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 * @generated
	 */
	void setFunctionName(String value);

	/**
	 * Returns the value of the '<em><b>Function Definition</b></em>' attribute.
	 * The default value is <code>"function(input,output){};"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Definition</em>' attribute.
	 * @see #setFunctionDefinition(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getAdvancedCustomFunction_FunctionDefinition()
	 * @model default="function(input,output){};"
	 * @generated
	 */
	String getFunctionDefinition();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.AdvancedCustomFunction#getFunctionDefinition <em>Function Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Definition</em>' attribute.
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	void setFunctionDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Is End Function</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is End Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is End Function</em>' attribute.
	 * @see #setIsEndFunction(boolean)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getAdvancedCustomFunction_IsEndFunction()
	 * @model default="true"
	 * @generated
	 */
	boolean isIsEndFunction();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.AdvancedCustomFunction#isIsEndFunction <em>Is End Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is End Function</em>' attribute.
	 * @see #isIsEndFunction()
	 * @generated
	 */
	void setIsEndFunction(boolean value);

} // AdvancedCustomFunction
