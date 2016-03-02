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
 * A representation of the model object '<em><b>Recipient List End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getWestOutputConnector <em>West Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getEndpointsValue <em>Endpoints Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getEndpointsExpression <em>Endpoints Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getMaxCache <em>Max Cache</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint()
 * @model
 * @generated
 */
public interface RecipientListEndPoint extends ParentEndPoint {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(RecipientListEndPointInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RecipientListEndPointInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(RecipientListEndPointInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointOutputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EList<RecipientListEndPointOutputConnector> getOutputConnector();

	/**
	 * Returns the value of the '<em><b>West Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>West Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>West Output Connector</em>' containment reference.
	 * @see #setWestOutputConnector(RecipientListEndPointWestOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_WestOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RecipientListEndPointWestOutputConnector getWestOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getWestOutputConnector <em>West Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>West Output Connector</em>' containment reference.
	 * @see #getWestOutputConnector()
	 * @generated
	 */
	void setWestOutputConnector(RecipientListEndPointWestOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Endpoint Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType
	 * @see #setEndpointType(RecipientListEndpointType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_EndpointType()
	 * @model
	 * @generated
	 */
	RecipientListEndpointType getEndpointType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getEndpointType <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType
	 * @see #getEndpointType()
	 * @generated
	 */
	void setEndpointType(RecipientListEndpointType value);

	/**
	 * Returns the value of the '<em><b>Endpoints Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoints Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints Value</em>' attribute.
	 * @see #setEndpointsValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_EndpointsValue()
	 * @model
	 * @generated
	 */
	String getEndpointsValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getEndpointsValue <em>Endpoints Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoints Value</em>' attribute.
	 * @see #getEndpointsValue()
	 * @generated
	 */
	void setEndpointsValue(String value);

	/**
	 * Returns the value of the '<em><b>Endpoints Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoints Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints Expression</em>' containment reference.
	 * @see #setEndpointsExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_EndpointsExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getEndpointsExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getEndpointsExpression <em>Endpoints Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoints Expression</em>' containment reference.
	 * @see #getEndpointsExpression()
	 * @generated
	 */
	void setEndpointsExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Max Cache</b></em>' attribute.
	 * The default value is <code>"20"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Cache</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Cache</em>' attribute.
	 * @see #setMaxCache(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_MaxCache()
	 * @model default="20"
	 * @generated
	 */
	int getMaxCache();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getMaxCache <em>Max Cache</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Cache</em>' attribute.
	 * @see #getMaxCache()
	 * @generated
	 */
	void setMaxCache(int value);

	/**
	 * Returns the value of the '<em><b>Mediator Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediator Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #setMediatorFlow(MediatorFlow)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRecipientListEndPoint_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

} // RecipientListEndPoint
