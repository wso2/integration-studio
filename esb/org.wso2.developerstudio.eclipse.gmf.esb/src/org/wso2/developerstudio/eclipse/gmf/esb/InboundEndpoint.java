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
 * A representation of the model object '<em><b>Inbound Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceInputConnector <em>Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceOutputConnector <em>Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequence <em>On Error Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint()
 * @model
 * @generated
 */
public interface InboundEndpoint extends EsbElement {
	/**
	 * Returns the value of the '<em><b>Sequence Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Input Connector</em>' containment reference.
	 * @see #setSequenceInputConnector(InboundEndpointSequenceInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SequenceInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointSequenceInputConnector getSequenceInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceInputConnector <em>Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Input Connector</em>' containment reference.
	 * @see #getSequenceInputConnector()
	 * @generated
	 */
	void setSequenceInputConnector(InboundEndpointSequenceInputConnector value);

	/**
	 * Returns the value of the '<em><b>Sequence Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Output Connector</em>' containment reference.
	 * @see #setSequenceOutputConnector(InboundEndpointSequenceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SequenceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointSequenceOutputConnector getSequenceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceOutputConnector <em>Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Output Connector</em>' containment reference.
	 * @see #getSequenceOutputConnector()
	 * @generated
	 */
	void setSequenceOutputConnector(InboundEndpointSequenceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>On Error Sequence Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error Sequence Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error Sequence Input Connector</em>' containment reference.
	 * @see #setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequenceInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointOnErrorSequenceInputConnector getOnErrorSequenceInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error Sequence Input Connector</em>' containment reference.
	 * @see #getOnErrorSequenceInputConnector()
	 * @generated
	 */
	void setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector value);

	/**
	 * Returns the value of the '<em><b>On Error Sequence Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error Sequence Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error Sequence Output Connector</em>' containment reference.
	 * @see #setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequenceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointOnErrorSequenceOutputConnector getOnErrorSequenceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error Sequence Output Connector</em>' containment reference.
	 * @see #getOnErrorSequenceOutputConnector()
	 * @generated
	 */
	void setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(InboundEndpointContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Container()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointContainer getContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(InboundEndpointContainer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' attribute.
	 * @see #setSequence(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Sequence()
	 * @model
	 * @generated
	 */
	String getSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequence <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence</em>' attribute.
	 * @see #getSequence()
	 * @generated
	 */
	void setSequence(String value);

	/**
	 * Returns the value of the '<em><b>On Error Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error Sequence</em>' attribute.
	 * @see #setOnErrorSequence(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequence()
	 * @model
	 * @generated
	 */
	String getOnErrorSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequence <em>On Error Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error Sequence</em>' attribute.
	 * @see #getOnErrorSequence()
	 * @generated
	 */
	void setOnErrorSequence(String value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' attribute.
	 * @see #setProtocol(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Protocol()
	 * @model
	 * @generated
	 */
	String getProtocol();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getProtocol <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' attribute.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(String value);

} // InboundEndpoint
