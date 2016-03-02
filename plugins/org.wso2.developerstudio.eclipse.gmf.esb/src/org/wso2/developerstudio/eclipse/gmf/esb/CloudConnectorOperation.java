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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cloud Connector Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getConnectorParameters <em>Connector Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getConfigRef <em>Config Ref</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getConnectorName <em>Connector Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getCloudConnectorName <em>Cloud Connector Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getNewConfig <em>New Config</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getAvailableConfigs <em>Available Configs</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getParameterEditorType <em>Parameter Editor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation()
 * @model
 * @generated
 */
public interface CloudConnectorOperation extends Mediator {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(CloudConnectorOperationInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CloudConnectorOperationInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(CloudConnectorOperationInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(CloudConnectorOperationOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CloudConnectorOperationOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(CloudConnectorOperationOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Connector Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_ConnectorParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<CallTemplateParameter> getConnectorParameters();

	/**
	 * Returns the value of the '<em><b>Config Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Ref</em>' attribute.
	 * @see #setConfigRef(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_ConfigRef()
	 * @model
	 * @generated
	 */
	String getConfigRef();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getConfigRef <em>Config Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config Ref</em>' attribute.
	 * @see #getConfigRef()
	 * @generated
	 */
	void setConfigRef(String value);

	/**
	 * Returns the value of the '<em><b>Connector Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Name</em>' attribute.
	 * @see #setConnectorName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_ConnectorName()
	 * @model
	 * @generated
	 */
	String getConnectorName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getConnectorName <em>Connector Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Name</em>' attribute.
	 * @see #getConnectorName()
	 * @generated
	 */
	void setConnectorName(String value);

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_OperationName()
	 * @model
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

	/**
	 * Returns the value of the '<em><b>Cloud Connector Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cloud Connector Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cloud Connector Name</em>' attribute.
	 * @see #setCloudConnectorName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_CloudConnectorName()
	 * @model
	 * @generated
	 */
	String getCloudConnectorName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getCloudConnectorName <em>Cloud Connector Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cloud Connector Name</em>' attribute.
	 * @see #getCloudConnectorName()
	 * @generated
	 */
	void setCloudConnectorName(String value);

	/**
	 * Returns the value of the '<em><b>New Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Config</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Config</em>' containment reference.
	 * @see #setNewConfig(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_NewConfig()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getNewConfig();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getNewConfig <em>New Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Config</em>' containment reference.
	 * @see #getNewConfig()
	 * @generated
	 */
	void setNewConfig(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Available Configs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Configs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Configs</em>' attribute.
	 * @see #setAvailableConfigs(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_AvailableConfigs()
	 * @model
	 * @generated
	 */
	String getAvailableConfigs();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getAvailableConfigs <em>Available Configs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Configs</em>' attribute.
	 * @see #getAvailableConfigs()
	 * @generated
	 */
	void setAvailableConfigs(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Editor Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Editor Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Editor Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType
	 * @see #setParameterEditorType(CloudConnectorOperationParamEditorType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloudConnectorOperation_ParameterEditorType()
	 * @model
	 * @generated
	 */
	CloudConnectorOperationParamEditorType getParameterEditorType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation#getParameterEditorType <em>Parameter Editor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Editor Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType
	 * @see #getParameterEditorType()
	 * @generated
	 */
	void setParameterEditorType(CloudConnectorOperationParamEditorType value);

} // CloudConnectorOperation
