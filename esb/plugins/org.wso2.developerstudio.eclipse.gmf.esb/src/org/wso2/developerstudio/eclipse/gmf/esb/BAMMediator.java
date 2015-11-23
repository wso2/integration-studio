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
 * A representation of the model object '<em><b>BAM Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getServerProfile <em>Server Profile</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getStreamName <em>Stream Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getStreamVersion <em>Stream Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getBAMMediator()
 * @model
 * @generated
 */
public interface BAMMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(BAMMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getBAMMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	BAMMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(BAMMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(BAMMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getBAMMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	BAMMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(BAMMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Server Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Profile</em>' attribute.
	 * @see #setServerProfile(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getBAMMediator_ServerProfile()
	 * @model
	 * @generated
	 */
	String getServerProfile();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getServerProfile <em>Server Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Profile</em>' attribute.
	 * @see #getServerProfile()
	 * @generated
	 */
	void setServerProfile(String value);

	/**
	 * Returns the value of the '<em><b>Stream Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stream Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stream Name</em>' attribute.
	 * @see #setStreamName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getBAMMediator_StreamName()
	 * @model
	 * @generated
	 */
	String getStreamName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getStreamName <em>Stream Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stream Name</em>' attribute.
	 * @see #getStreamName()
	 * @generated
	 */
	void setStreamName(String value);

	/**
	 * Returns the value of the '<em><b>Stream Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stream Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stream Version</em>' attribute.
	 * @see #setStreamVersion(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getBAMMediator_StreamVersion()
	 * @model
	 * @generated
	 */
	String getStreamVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator#getStreamVersion <em>Stream Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stream Version</em>' attribute.
	 * @see #getStreamVersion()
	 * @generated
	 */
	void setStreamVersion(String value);

} // BAMMediator
