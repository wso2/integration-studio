/*
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
 * A representation of the model object '<em><b>Proxy Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getPinnedServers <em>Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getServiceGroup <em>Service Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getTransports <em>Transports</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getWsdlConfiguration <em>Wsdl Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getInSequenceConfiguration <em>In Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getEndpointConfiguration <em>Endpoint Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getOutSequenceConfiguration <em>Out Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getFaultSequenceConfiguration <em>Fault Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getServicePolicies <em>Service Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService()
 * @model
 * @generated
 */
public interface ProxyService extends ConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"service_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_Name()
	 * @model default="service_name"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Service Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Group</em>' attribute.
	 * @see #setServiceGroup(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_ServiceGroup()
	 * @model
	 * @generated
	 */
	String getServiceGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getServiceGroup <em>Service Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Group</em>' attribute.
	 * @see #getServiceGroup()
	 * @generated
	 */
	void setServiceGroup(String value);

	/**
	 * Returns the value of the '<em><b>Pinned Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pinned Servers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pinned Servers</em>' attribute.
	 * @see #setPinnedServers(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_PinnedServers()
	 * @model
	 * @generated
	 */
	String getPinnedServers();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getPinnedServers <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pinned Servers</em>' attribute.
	 * @see #getPinnedServers()
	 * @generated
	 */
	void setPinnedServers(String value);

	/**
	 * Returns the value of the '<em><b>Trace Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Enabled</em>' attribute.
	 * @see #setTraceEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_TraceEnabled()
	 * @model
	 * @generated
	 */
	boolean isTraceEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isTraceEnabled <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Enabled</em>' attribute.
	 * @see #isTraceEnabled()
	 * @generated
	 */
	void setTraceEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Statistics Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistics Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #setStatisticsEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_StatisticsEnabled()
	 * @model
	 * @generated
	 */
	boolean isStatisticsEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isStatisticsEnabled <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #isStatisticsEnabled()
	 * @generated
	 */
	void setStatisticsEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Transports</b></em>' attribute.
	 * The default value is <code>"https,http"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transports</em>' attribute.
	 * @see #setTransports(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_Transports()
	 * @model default="https,http"
	 * @generated
	 */
	String getTransports();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getTransports <em>Transports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transports</em>' attribute.
	 * @see #getTransports()
	 * @generated
	 */
	void setTransports(String value);

	/**
	 * Returns the value of the '<em><b>Reliable Messaging Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reliable Messaging Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reliable Messaging Enabled</em>' attribute.
	 * @see #setReliableMessagingEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_ReliableMessagingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isReliableMessagingEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reliable Messaging Enabled</em>' attribute.
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 */
	void setReliableMessagingEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Security Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Enabled</em>' attribute.
	 * @see #setSecurityEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_SecurityEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isSecurityEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#isSecurityEnabled <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Enabled</em>' attribute.
	 * @see #isSecurityEnabled()
	 * @generated
	 */
	void setSecurityEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Wsdl Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Configuration</em>' containment reference.
	 * @see #setWsdlConfiguration(ProxyWsdlConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_WsdlConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ProxyWsdlConfiguration getWsdlConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getWsdlConfiguration <em>Wsdl Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Configuration</em>' containment reference.
	 * @see #getWsdlConfiguration()
	 * @generated
	 */
	void setWsdlConfiguration(ProxyWsdlConfiguration value);

	/**
	 * Returns the value of the '<em><b>In Sequence Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Configuration</em>' containment reference.
	 * @see #setInSequenceConfiguration(ProxyInSequenceConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_InSequenceConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ProxyInSequenceConfiguration getInSequenceConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getInSequenceConfiguration <em>In Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Configuration</em>' containment reference.
	 * @see #getInSequenceConfiguration()
	 * @generated
	 */
	void setInSequenceConfiguration(ProxyInSequenceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Endpoint Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Configuration</em>' containment reference.
	 * @see #setEndpointConfiguration(ProxyEndpointConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_EndpointConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ProxyEndpointConfiguration getEndpointConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getEndpointConfiguration <em>Endpoint Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Configuration</em>' containment reference.
	 * @see #getEndpointConfiguration()
	 * @generated
	 */
	void setEndpointConfiguration(ProxyEndpointConfiguration value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Configuration</em>' containment reference.
	 * @see #setOutSequenceConfiguration(ProxyOutSequenceConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_OutSequenceConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ProxyOutSequenceConfiguration getOutSequenceConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getOutSequenceConfiguration <em>Out Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Configuration</em>' containment reference.
	 * @see #getOutSequenceConfiguration()
	 * @generated
	 */
	void setOutSequenceConfiguration(ProxyOutSequenceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Configuration</em>' containment reference.
	 * @see #setFaultSequenceConfiguration(ProxyFaultSequenceConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_FaultSequenceConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ProxyFaultSequenceConfiguration getFaultSequenceConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyService#getFaultSequenceConfiguration <em>Fault Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Configuration</em>' containment reference.
	 * @see #getFaultSequenceConfiguration()
	 * @generated
	 */
	void setFaultSequenceConfiguration(ProxyFaultSequenceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Service Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.ProxyServiceParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_ServiceParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyServiceParameter> getServiceParameters();

	/**
	 * Returns the value of the '<em><b>Service Policies</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.ProxyServicePolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Policies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Policies</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyService_ServicePolicies()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyServicePolicy> getServicePolicies();

} // ProxyService
