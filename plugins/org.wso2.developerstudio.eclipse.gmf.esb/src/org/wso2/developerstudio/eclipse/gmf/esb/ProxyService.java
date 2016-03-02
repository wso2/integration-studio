/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultInputConnector <em>Fault Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceOutputConnector <em>Out Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceInputConnectors <em>In Sequence Input Connectors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getPinnedServers <em>Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getServiceGroup <em>Service Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isStartOnLoad <em>Start On Load</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getTransports <em>Transports</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getServicePolicies <em>Service Policies</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceType <em>In Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceKey <em>In Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceName <em>In Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceOnError <em>In Sequence On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceType <em>Out Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceKey <em>Out Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceName <em>Out Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceOnError <em>Out Sequence On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceType <em>Fault Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceKey <em>Fault Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceName <em>Fault Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceOnError <em>Fault Sequence On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getEndpointKey <em>Endpoint Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getEndpointName <em>Endpoint Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isMainSequence <em>Main Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlType <em>Wsdl Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlXML <em>Wsdl XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlURL <em>Wsdl URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlKey <em>Wsdl Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlEndpoint <em>Wsdl Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlResources <em>Wsdl Resources</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOnError <em>On Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService()
 * @model
 * @generated
 */
public interface ProxyService extends EsbElement {
	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(ProxyOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ProxyOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(ProxyOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(ProxyInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ProxyInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(ProxyInputConnector value);

	/**
	 * Returns the value of the '<em><b>Fault Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Input Connector</em>' containment reference.
	 * @see #setFaultInputConnector(ProxyFaultInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_FaultInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ProxyFaultInputConnector getFaultInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultInputConnector <em>Fault Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Input Connector</em>' containment reference.
	 * @see #getFaultInputConnector()
	 * @generated
	 */
	void setFaultInputConnector(ProxyFaultInputConnector value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Output Connector</em>' containment reference.
	 * @see #setOutSequenceOutputConnector(ProxyOutSequenceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OutSequenceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ProxyOutSequenceOutputConnector getOutSequenceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceOutputConnector <em>Out Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Output Connector</em>' containment reference.
	 * @see #getOutSequenceOutputConnector()
	 * @generated
	 */
	void setOutSequenceOutputConnector(ProxyOutSequenceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>In Sequence Input Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Input Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Input Connectors</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_InSequenceInputConnectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyInSequenceInputConnector> getInSequenceInputConnectors();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"proxy1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_Name()
	 * @model default="proxy1"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pinned Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pinned Servers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pinned Servers</em>' attribute.
	 * @see #setPinnedServers(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_PinnedServers()
	 * @model
	 * @generated
	 */
	String getPinnedServers();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getPinnedServers <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pinned Servers</em>' attribute.
	 * @see #getPinnedServers()
	 * @generated
	 */
	void setPinnedServers(String value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_ServiceGroup()
	 * @model
	 * @generated
	 */
	String getServiceGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getServiceGroup <em>Service Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Group</em>' attribute.
	 * @see #getServiceGroup()
	 * @generated
	 */
	void setServiceGroup(String value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_TraceEnabled()
	 * @model
	 * @generated
	 */
	boolean isTraceEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isTraceEnabled <em>Trace Enabled</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_StatisticsEnabled()
	 * @model
	 * @generated
	 */
	boolean isStatisticsEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isStatisticsEnabled <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #isStatisticsEnabled()
	 * @generated
	 */
	void setStatisticsEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Start On Load</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start On Load</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start On Load</em>' attribute.
	 * @see #setStartOnLoad(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_StartOnLoad()
	 * @model
	 * @generated
	 */
	boolean isStartOnLoad();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isStartOnLoad <em>Start On Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start On Load</em>' attribute.
	 * @see #isStartOnLoad()
	 * @generated
	 */
	void setStartOnLoad(boolean value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_Transports()
	 * @model default="https,http"
	 * @generated
	 */
	String getTransports();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getTransports <em>Transports</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_ReliableMessagingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isReliableMessagingEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_SecurityEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isSecurityEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isSecurityEnabled <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Enabled</em>' attribute.
	 * @see #isSecurityEnabled()
	 * @generated
	 */
	void setSecurityEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Service Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_ServiceParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyServiceParameter> getServiceParameters();

	/**
	 * Returns the value of the '<em><b>Service Policies</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServicePolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Policies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Policies</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_ServicePolicies()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyServicePolicy> getServicePolicies();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(ProxyServiceContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_Container()
	 * @model containment="true"
	 * @generated
	 */
	ProxyServiceContainer getContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ProxyServiceContainer value);

	/**
	 * Returns the value of the '<em><b>In Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setInSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_InSequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getInSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceType <em>In Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getInSequenceType()
	 * @generated
	 */
	void setInSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>In Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Key</em>' containment reference.
	 * @see #setInSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_InSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceKey <em>In Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Key</em>' containment reference.
	 * @see #getInSequenceKey()
	 * @generated
	 */
	void setInSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>In Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Name</em>' attribute.
	 * @see #setInSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_InSequenceName()
	 * @model
	 * @generated
	 */
	String getInSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceName <em>In Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Name</em>' attribute.
	 * @see #getInSequenceName()
	 * @generated
	 */
	void setInSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>In Sequence On Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence On Error</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence On Error</em>' containment reference.
	 * @see #setInSequenceOnError(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_InSequenceOnError()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInSequenceOnError();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getInSequenceOnError <em>In Sequence On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence On Error</em>' containment reference.
	 * @see #getInSequenceOnError()
	 * @generated
	 */
	void setInSequenceOnError(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setOutSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OutSequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getOutSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceType <em>Out Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getOutSequenceType()
	 * @generated
	 */
	void setOutSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Key</em>' containment reference.
	 * @see #setOutSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OutSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOutSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceKey <em>Out Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Key</em>' containment reference.
	 * @see #getOutSequenceKey()
	 * @generated
	 */
	void setOutSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Name</em>' attribute.
	 * @see #setOutSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OutSequenceName()
	 * @model
	 * @generated
	 */
	String getOutSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceName <em>Out Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Name</em>' attribute.
	 * @see #getOutSequenceName()
	 * @generated
	 */
	void setOutSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Out Sequence On Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence On Error</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence On Error</em>' containment reference.
	 * @see #setOutSequenceOnError(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OutSequenceOnError()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOutSequenceOnError();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOutSequenceOnError <em>Out Sequence On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence On Error</em>' containment reference.
	 * @see #getOutSequenceOnError()
	 * @generated
	 */
	void setOutSequenceOnError(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setFaultSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_FaultSequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getFaultSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceType <em>Fault Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getFaultSequenceType()
	 * @generated
	 */
	void setFaultSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Key</em>' containment reference.
	 * @see #setFaultSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_FaultSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getFaultSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceKey <em>Fault Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Key</em>' containment reference.
	 * @see #getFaultSequenceKey()
	 * @generated
	 */
	void setFaultSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Name</em>' attribute.
	 * @see #setFaultSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_FaultSequenceName()
	 * @model
	 * @generated
	 */
	String getFaultSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceName <em>Fault Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Name</em>' attribute.
	 * @see #getFaultSequenceName()
	 * @generated
	 */
	void setFaultSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence On Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence On Error</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence On Error</em>' containment reference.
	 * @see #setFaultSequenceOnError(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_FaultSequenceOnError()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getFaultSequenceOnError();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getFaultSequenceOnError <em>Fault Sequence On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence On Error</em>' containment reference.
	 * @see #getFaultSequenceOnError()
	 * @generated
	 */
	void setFaultSequenceOnError(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Endpoint Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setEndpointType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_EndpointType()
	 * @model
	 * @generated
	 */
	SequenceType getEndpointType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getEndpointType <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getEndpointType()
	 * @generated
	 */
	void setEndpointType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>Endpoint Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Key</em>' containment reference.
	 * @see #setEndpointKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_EndpointKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getEndpointKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getEndpointKey <em>Endpoint Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Key</em>' containment reference.
	 * @see #getEndpointKey()
	 * @generated
	 */
	void setEndpointKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Endpoint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Name</em>' attribute.
	 * @see #setEndpointName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_EndpointName()
	 * @model
	 * @generated
	 */
	String getEndpointName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getEndpointName <em>Endpoint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Name</em>' attribute.
	 * @see #getEndpointName()
	 * @generated
	 */
	void setEndpointName(String value);

	/**
	 * Returns the value of the '<em><b>Main Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Sequence</em>' attribute.
	 * @see #setMainSequence(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_MainSequence()
	 * @model
	 * @generated
	 */
	boolean isMainSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#isMainSequence <em>Main Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Sequence</em>' attribute.
	 * @see #isMainSequence()
	 * @generated
	 */
	void setMainSequence(boolean value);

	/**
	 * Returns the value of the '<em><b>Wsdl Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType
	 * @see #setWsdlType(ProxyWsdlType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_WsdlType()
	 * @model default="NONE"
	 * @generated
	 */
	ProxyWsdlType getWsdlType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlType <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType
	 * @see #getWsdlType()
	 * @generated
	 */
	void setWsdlType(ProxyWsdlType value);

	/**
	 * Returns the value of the '<em><b>Wsdl XML</b></em>' attribute.
	 * The default value is <code>"<definitions/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl XML</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl XML</em>' attribute.
	 * @see #setWsdlXML(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_WsdlXML()
	 * @model default="<definitions/>"
	 * @generated
	 */
	String getWsdlXML();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlXML <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl XML</em>' attribute.
	 * @see #getWsdlXML()
	 * @generated
	 */
	void setWsdlXML(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl URL</b></em>' attribute.
	 * The default value is <code>"http://default/wsdl/url"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl URL</em>' attribute.
	 * @see #setWsdlURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_WsdlURL()
	 * @model default="http://default/wsdl/url"
	 * @generated
	 */
	String getWsdlURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlURL <em>Wsdl URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl URL</em>' attribute.
	 * @see #getWsdlURL()
	 * @generated
	 */
	void setWsdlURL(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Key</em>' containment reference.
	 * @see #setWsdlKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_WsdlKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getWsdlKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlKey <em>Wsdl Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Key</em>' containment reference.
	 * @see #getWsdlKey()
	 * @generated
	 */
	void setWsdlKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Wsdl Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Endpoint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Endpoint</em>' containment reference.
	 * @see #setWsdlEndpoint(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_WsdlEndpoint()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getWsdlEndpoint();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getWsdlEndpoint <em>Wsdl Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Endpoint</em>' containment reference.
	 * @see #getWsdlEndpoint()
	 * @generated
	 */
	void setWsdlEndpoint(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Wsdl Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Resources</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_WsdlResources()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyWSDLResource> getWsdlResources();

	/**
	 * Returns the value of the '<em><b>On Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error</em>' containment reference.
	 * @see #setOnError(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyService_OnError()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOnError();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService#getOnError <em>On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error</em>' containment reference.
	 * @see #getOnError()
	 * @generated
	 */
	void setOnError(RegistryKeyProperty value);

} // ProxyService
