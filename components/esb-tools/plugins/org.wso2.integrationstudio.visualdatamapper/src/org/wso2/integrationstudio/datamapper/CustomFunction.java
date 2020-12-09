/**
 */
package org.wso2.integrationstudio.datamapper;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.CustomFunction#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.CustomFunction#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.CustomFunction#getOutputConnectorTag <em>Output Connector Tag</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.CustomFunction#getInputConnectorTag <em>Input Connector Tag</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCustomFunction()
 * @model
 * @generated
 */
public interface CustomFunction extends Operator {

	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * The default value is <code>"customFunction"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCustomFunction_FunctionName()
	 * @model default="customFunction"
	 * @generated
	 */
	String getFunctionName();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.CustomFunction#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 * @generated
	 */
	void setFunctionName(String value);

	/**
	 * Returns the value of the '<em><b>Function Definition</b></em>' attribute.
	 * The default value is <code>"function(in1,in2){ return (in1 + in2);};"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Definition</em>' attribute.
	 * @see #setFunctionDefinition(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCustomFunction_FunctionDefinition()
	 * @model default="function(in1,in2){ return (in1 + in2);};"
	 * @generated
	 */
	String getFunctionDefinition();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.CustomFunction#getFunctionDefinition <em>Function Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Definition</em>' attribute.
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	void setFunctionDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Output Connector Tag</b></em>' attribute.
	 * The default value is <code>"Result"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector Tag</em>' attribute.
	 * @see #setOutputConnectorTag(String)
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCustomFunction_OutputConnectorTag()
	 * @model default="Result"
	 * @generated
	 */
	String getOutputConnectorTag();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.datamapper.CustomFunction#getOutputConnectorTag <em>Output Connector Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector Tag</em>' attribute.
	 * @see #getOutputConnectorTag()
	 * @generated
	 */
	void setOutputConnectorTag(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector Tag</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector Tag</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector Tag</em>' attribute list.
	 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage#getCustomFunction_InputConnectorTag()
	 * @model default="In"
	 * @generated
	 */
	EList<String> getInputConnectorTag();
} // CustomFunction
