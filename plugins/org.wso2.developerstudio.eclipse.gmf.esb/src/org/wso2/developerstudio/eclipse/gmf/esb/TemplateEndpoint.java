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
 * A representation of the model object '<em><b>Template Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getAddress <em>Address</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getTargetTemplate <em>Target Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getAvailableTemplates <em>Available Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint()
 * @model
 * @generated
 */
public interface TemplateEndpoint extends AbstractEndPoint {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(TemplateEndpointInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	TemplateEndpointInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(TemplateEndpointInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(TemplateEndpointOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	TemplateEndpointOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(TemplateEndpointOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint_Address()
	 * @model
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Target Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Template</em>' attribute.
	 * @see #setTargetTemplate(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint_TargetTemplate()
	 * @model
	 * @generated
	 */
	String getTargetTemplate();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getTargetTemplate <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Template</em>' attribute.
	 * @see #getTargetTemplate()
	 * @generated
	 */
	void setTargetTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateEndpointParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Available Templates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Templates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Templates</em>' attribute.
	 * @see #setAvailableTemplates(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTemplateEndpoint_AvailableTemplates()
	 * @model
	 * @generated
	 */
	String getAvailableTemplates();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint#getAvailableTemplates <em>Available Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Templates</em>' attribute.
	 * @see #getAvailableTemplates()
	 * @generated
	 */
	void setAvailableTemplates(String value);

} // TemplateEndpoint
