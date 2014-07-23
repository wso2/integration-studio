/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Mapper Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputType <em>Input Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputSchema <em>Input Schema</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputSchema <em>Output Schema</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getConfigurationLocalPath <em>Configuration Local Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputSchemaLocalPath <em>Input Schema Local Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputSchemaLocalPath <em>Output Schema Local Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputType <em>Output Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator()
 * @model
 * @generated
 */
public interface DataMapperMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(DataMapperMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	DataMapperMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(DataMapperMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Input Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes
	 * @see #setInputType(DataMapperMediatorDataTypes)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_InputType()
	 * @model
	 * @generated
	 */
	DataMapperMediatorDataTypes getInputType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputType <em>Input Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes
	 * @see #getInputType()
	 * @generated
	 */
	void setInputType(DataMapperMediatorDataTypes value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(DataMapperMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	DataMapperMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(DataMapperMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Input Schema</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Schema</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Schema</em>' containment reference.
	 * @see #setInputSchema(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_InputSchema()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInputSchema();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputSchema <em>Input Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Schema</em>' containment reference.
	 * @see #getInputSchema()
	 * @generated
	 */
	void setInputSchema(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Output Schema</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Schema</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Schema</em>' containment reference.
	 * @see #setOutputSchema(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_OutputSchema()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOutputSchema();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputSchema <em>Output Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Schema</em>' containment reference.
	 * @see #getOutputSchema()
	 * @generated
	 */
	void setOutputSchema(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Configuration Local Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Local Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Local Path</em>' attribute.
	 * @see #setConfigurationLocalPath(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_ConfigurationLocalPath()
	 * @model
	 * @generated
	 */
	String getConfigurationLocalPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getConfigurationLocalPath <em>Configuration Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Local Path</em>' attribute.
	 * @see #getConfigurationLocalPath()
	 * @generated
	 */
	void setConfigurationLocalPath(String value);

	/**
	 * Returns the value of the '<em><b>Input Schema Local Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Schema Local Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Schema Local Path</em>' attribute.
	 * @see #setInputSchemaLocalPath(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_InputSchemaLocalPath()
	 * @model
	 * @generated
	 */
	String getInputSchemaLocalPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getInputSchemaLocalPath <em>Input Schema Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Schema Local Path</em>' attribute.
	 * @see #getInputSchemaLocalPath()
	 * @generated
	 */
	void setInputSchemaLocalPath(String value);

	/**
	 * Returns the value of the '<em><b>Output Schema Local Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Schema Local Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Schema Local Path</em>' attribute.
	 * @see #setOutputSchemaLocalPath(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_OutputSchemaLocalPath()
	 * @model
	 * @generated
	 */
	String getOutputSchemaLocalPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputSchemaLocalPath <em>Output Schema Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Schema Local Path</em>' attribute.
	 * @see #getOutputSchemaLocalPath()
	 * @generated
	 */
	void setOutputSchemaLocalPath(String value);

	/**
	 * Returns the value of the '<em><b>Output Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes
	 * @see #setOutputType(DataMapperMediatorDataTypes)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataMapperMediator_OutputType()
	 * @model
	 * @generated
	 */
	DataMapperMediatorDataTypes getOutputType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator#getOutputType <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes
	 * @see #getOutputType()
	 * @generated
	 */
	void setOutputType(DataMapperMediatorDataTypes value);

} // DataMapperMediator
