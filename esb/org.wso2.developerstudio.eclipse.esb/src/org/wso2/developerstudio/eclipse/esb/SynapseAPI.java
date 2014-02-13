/**
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synapse API</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getApiName <em>Api Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getContext <em>Context</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getHostname <em>Hostname</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getPort <em>Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getSynapseAPI()
 * @model
 * @generated
 */
public interface SynapseAPI extends ConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Api Name</b></em>' attribute.
	 * The default value is <code>"api_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api Name</em>' attribute.
	 * @see #setApiName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getSynapseAPI_ApiName()
	 * @model default="api_name" id="true" required="true"
	 * @generated
	 */
	String getApiName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getApiName <em>Api Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Name</em>' attribute.
	 * @see #getApiName()
	 * @generated
	 */
	void setApiName(String value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * The default value is <code>"/context"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getSynapseAPI_Context()
	 * @model default="/context" required="true"
	 * @generated
	 */
	String getContext();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(String value);

	/**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hostname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getSynapseAPI_Hostname()
	 * @model
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(int)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getSynapseAPI_Port()
	 * @model
	 * @generated
	 */
	int getPort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(int value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.ApiResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getSynapseAPI_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApiResource> getResources();

} // SynapseAPI
