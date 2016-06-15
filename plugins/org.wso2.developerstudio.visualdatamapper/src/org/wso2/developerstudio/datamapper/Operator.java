/**
 */
package org.wso2.developerstudio.datamapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#getBasicContainer <em>Basic Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#isSerialized <em>Serialized</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#getDefaultInputConnectors <em>Default Input Connectors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#getDefaultOutputConnectors <em>Default Output Connectors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#isInputSizeFixed <em>Input Size Fixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#isOutputSizeFixed <em>Output Size Fixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends DataMapperNode {
	/**
	 * Returns the value of the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Container</em>' containment reference.
	 * @see #setBasicContainer(OperatorBasicContainer)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_BasicContainer()
	 * @model containment="true"
	 * @generated
	 */
	OperatorBasicContainer getBasicContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#getBasicContainer <em>Basic Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Container</em>' containment reference.
	 * @see #getBasicContainer()
	 * @generated
	 */
	void setBasicContainer(OperatorBasicContainer value);

	/**
	 * Returns the value of the '<em><b>Serialized</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serialized</em>' attribute.
	 * @see #setSerialized(boolean)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_Serialized()
	 * @model default="false"
	 * @generated
	 */
	boolean isSerialized();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#isSerialized <em>Serialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serialized</em>' attribute.
	 * @see #isSerialized()
	 * @generated
	 */
	void setSerialized(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Input Connectors</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Input Connectors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Input Connectors</em>' attribute.
	 * @see #setDefaultInputConnectors(int)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_DefaultInputConnectors()
	 * @model default="0"
	 * @generated
	 */
	int getDefaultInputConnectors();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#getDefaultInputConnectors <em>Default Input Connectors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Input Connectors</em>' attribute.
	 * @see #getDefaultInputConnectors()
	 * @generated
	 */
	void setDefaultInputConnectors(int value);

	/**
	 * Returns the value of the '<em><b>Default Output Connectors</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Output Connectors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Output Connectors</em>' attribute.
	 * @see #setDefaultOutputConnectors(int)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_DefaultOutputConnectors()
	 * @model default="0"
	 * @generated
	 */
	int getDefaultOutputConnectors();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#getDefaultOutputConnectors <em>Default Output Connectors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Output Connectors</em>' attribute.
	 * @see #getDefaultOutputConnectors()
	 * @generated
	 */
	void setDefaultOutputConnectors(int value);

	/**
	 * Returns the value of the '<em><b>Input Variable Type</b></em>' attribute list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.SchemaDataType}.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.datamapper.SchemaDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable Type</em>' attribute list.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_InputVariableType()
	 * @model default="STRING"
	 * @generated NOT
	 */
	Map<Integer, List<SchemaDataType>> getInputVariableTypes();

	/**
	 * Returns the value of the '<em><b>Output Variable Type</b></em>' attribute list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.SchemaDataType}.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.datamapper.SchemaDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable Type</em>' attribute list.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_OutputVariableType()
	 * @model default="STRING"
	 * @generated NOT
	 */
	Map<Integer, List<SchemaDataType>> getOutputVariableTypes();

	/**
	 * Returns the value of the '<em><b>Input Size Fixed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Size Fixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Size Fixed</em>' attribute.
	 * @see #setInputSizeFixed(boolean)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_InputSizeFixed()
	 * @model default="true"
	 * @generated
	 */
	boolean isInputSizeFixed();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#isInputSizeFixed <em>Input Size Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Size Fixed</em>' attribute.
	 * @see #isInputSizeFixed()
	 * @generated
	 */
	void setInputSizeFixed(boolean value);

	/**
	 * Returns the value of the '<em><b>Output Size Fixed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Size Fixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Size Fixed</em>' attribute.
	 * @see #setOutputSizeFixed(boolean)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_OutputSizeFixed()
	 * @model default="true"
	 * @generated
	 */
	boolean isOutputSizeFixed();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#isOutputSizeFixed <em>Output Size Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Size Fixed</em>' attribute.
	 * @see #isOutputSizeFixed()
	 * @generated
	 */
	void setOutputSizeFixed(boolean value);

	/**
	 * Returns the value of the '<em><b>Operator Type</b></em>' attribute.
	 * The default value is <code>"OPERATOR"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.datamapper.DataMapperOperatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Type</em>' attribute.
	 * @see org.wso2.developerstudio.datamapper.DataMapperOperatorType
	 * @see #setOperatorType(DataMapperOperatorType)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_OperatorType()
	 * @model default="OPERATOR"
	 * @generated
	 */
	DataMapperOperatorType getOperatorType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#getOperatorType <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Type</em>' attribute.
	 * @see org.wso2.developerstudio.datamapper.DataMapperOperatorType
	 * @see #getOperatorType()
	 * @generated
	 */
	void setOperatorType(DataMapperOperatorType value);

} // Operator
