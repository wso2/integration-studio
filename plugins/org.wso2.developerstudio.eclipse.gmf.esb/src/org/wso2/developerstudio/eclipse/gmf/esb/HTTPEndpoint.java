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
 * A representation of the model object '<em><b>HTTP Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getURITemplate <em>URI Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getHttpMethod <em>Http Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHTTPEndpoint()
 * @model
 * @generated
 */
public interface HTTPEndpoint extends AbstractEndPoint {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(HTTPEndPointInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHTTPEndpoint_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	HTTPEndPointInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(HTTPEndPointInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(HTTPEndPointOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHTTPEndpoint_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	HTTPEndPointOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(HTTPEndPointOutputConnector value);

	/**
	 * Returns the value of the '<em><b>URI Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URI Template</em>' attribute.
	 * @see #setURITemplate(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHTTPEndpoint_URITemplate()
	 * @model
	 * @generated
	 */
	String getURITemplate();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getURITemplate <em>URI Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI Template</em>' attribute.
	 * @see #getURITemplate()
	 * @generated
	 */
	void setURITemplate(String value);

	/**
	 * Returns the value of the '<em><b>Http Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.HttpMethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.HttpMethodType
	 * @see #setHttpMethod(HttpMethodType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHTTPEndpoint_HttpMethod()
	 * @model
	 * @generated
	 */
	HttpMethodType getHttpMethod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint#getHttpMethod <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.HttpMethodType
	 * @see #getHttpMethod()
	 * @generated
	 */
	void setHttpMethod(HttpMethodType value);

} // HTTPEndpoint
