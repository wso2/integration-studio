/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Callout Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getServiceURL <em>Service URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPayloadType <em>Payload Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#isPassHeaders <em>Pass Headers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getAddressEndpoint <em>Address Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPayloadProperty <em>Payload Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getSecurityType <em>Security Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getOutboundPolicyKey <em>Outbound Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getInboundPolicyKey <em>Inbound Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPolicies <em>Policies</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#isInitAxis2ClientOptions <em>Init Axis2 Client Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator()
 * @model
 * @generated
 */
public interface CalloutMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Service URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service URL</em>' attribute.
	 * @see #setServiceURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_ServiceURL()
	 * @model
	 * @generated
	 */
	String getServiceURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getServiceURL <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service URL</em>' attribute.
	 * @see #getServiceURL()
	 * @generated
	 */
	void setServiceURL(String value);

	/**
	 * Returns the value of the '<em><b>Soap Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Action</em>' attribute.
	 * @see #setSoapAction(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_SoapAction()
	 * @model
	 * @generated
	 */
	String getSoapAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getSoapAction <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Action</em>' attribute.
	 * @see #getSoapAction()
	 * @generated
	 */
	void setSoapAction(String value);

	/**
	 * Returns the value of the '<em><b>Path To Axis2xml</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Axis2xml</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Axis2xml</em>' attribute.
	 * @see #setPathToAxis2xml(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PathToAxis2xml()
	 * @model
	 * @generated
	 */
	String getPathToAxis2xml();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Axis2xml</em>' attribute.
	 * @see #getPathToAxis2xml()
	 * @generated
	 */
	void setPathToAxis2xml(String value);

	/**
	 * Returns the value of the '<em><b>Path To Axis2 Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Axis2 Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Axis2 Repository</em>' attribute.
	 * @see #setPathToAxis2Repository(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PathToAxis2Repository()
	 * @model
	 * @generated
	 */
	String getPathToAxis2Repository();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Axis2 Repository</em>' attribute.
	 * @see #getPathToAxis2Repository()
	 * @generated
	 */
	void setPathToAxis2Repository(String value);

	/**
	 * Returns the value of the '<em><b>Payload Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType
	 * @see #setPayloadType(CalloutPayloadType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PayloadType()
	 * @model
	 * @generated
	 */
	CalloutPayloadType getPayloadType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPayloadType <em>Payload Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType
	 * @see #getPayloadType()
	 * @generated
	 */
	void setPayloadType(CalloutPayloadType value);

	/**
	 * Returns the value of the '<em><b>Payload Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Message Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Message Xpath</em>' containment reference.
	 * @see #setPayloadMessageXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PayloadMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getPayloadMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Message Xpath</em>' containment reference.
	 * @see #getPayloadMessageXpath()
	 * @generated
	 */
	void setPayloadMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType
	 * @see #setResultType(CalloutResultType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_ResultType()
	 * @model
	 * @generated
	 */
	CalloutResultType getResultType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(CalloutResultType value);

	/**
	 * Returns the value of the '<em><b>Result Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Message Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Message Xpath</em>' containment reference.
	 * @see #setResultMessageXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_ResultMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getResultMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Message Xpath</em>' containment reference.
	 * @see #getResultMessageXpath()
	 * @generated
	 */
	void setResultMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Result Context Property</b></em>' attribute.
	 * The default value is <code>"context_property_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Context Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Context Property</em>' attribute.
	 * @see #setResultContextProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_ResultContextProperty()
	 * @model default="context_property_name"
	 * @generated
	 */
	String getResultContextProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Context Property</em>' attribute.
	 * @see #getResultContextProperty()
	 * @generated
	 */
	void setResultContextProperty(String value);

	/**
	 * Returns the value of the '<em><b>Pass Headers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pass Headers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass Headers</em>' attribute.
	 * @see #setPassHeaders(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PassHeaders()
	 * @model
	 * @generated
	 */
	boolean isPassHeaders();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#isPassHeaders <em>Pass Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass Headers</em>' attribute.
	 * @see #isPassHeaders()
	 * @generated
	 */
	void setPassHeaders(boolean value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(CalloutMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CalloutMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(CalloutMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(CalloutMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CalloutMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(CalloutMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Address Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address Endpoint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address Endpoint</em>' containment reference.
	 * @see #setAddressEndpoint(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_AddressEndpoint()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getAddressEndpoint();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getAddressEndpoint <em>Address Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Endpoint</em>' containment reference.
	 * @see #getAddressEndpoint()
	 * @generated
	 */
	void setAddressEndpoint(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Endpoint Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType
	 * @see #setEndpointType(CalloutEndpointType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_EndpointType()
	 * @model
	 * @generated
	 */
	CalloutEndpointType getEndpointType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getEndpointType <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType
	 * @see #getEndpointType()
	 * @generated
	 */
	void setEndpointType(CalloutEndpointType value);

	/**
	 * Returns the value of the '<em><b>Payload Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Property</em>' attribute.
	 * @see #setPayloadProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PayloadProperty()
	 * @model
	 * @generated
	 */
	String getPayloadProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPayloadProperty <em>Payload Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Property</em>' attribute.
	 * @see #getPayloadProperty()
	 * @generated
	 */
	void setPayloadProperty(String value);

	/**
	 * Returns the value of the '<em><b>Security Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType
	 * @see #setSecurityType(CalloutSecurityType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_SecurityType()
	 * @model
	 * @generated
	 */
	CalloutSecurityType getSecurityType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getSecurityType <em>Security Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType
	 * @see #getSecurityType()
	 * @generated
	 */
	void setSecurityType(CalloutSecurityType value);

	/**
	 * Returns the value of the '<em><b>Outbound Policy Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outbound Policy Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outbound Policy Key</em>' containment reference.
	 * @see #setOutboundPolicyKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_OutboundPolicyKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOutboundPolicyKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getOutboundPolicyKey <em>Outbound Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outbound Policy Key</em>' containment reference.
	 * @see #getOutboundPolicyKey()
	 * @generated
	 */
	void setOutboundPolicyKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Inbound Policy Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Policy Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Policy Key</em>' containment reference.
	 * @see #setInboundPolicyKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_InboundPolicyKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInboundPolicyKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getInboundPolicyKey <em>Inbound Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Policy Key</em>' containment reference.
	 * @see #getInboundPolicyKey()
	 * @generated
	 */
	void setInboundPolicyKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Policies</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policies</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies
	 * @see #setPolicies(CalloutSecurityPolicies)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_Policies()
	 * @model
	 * @generated
	 */
	CalloutSecurityPolicies getPolicies();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPolicies <em>Policies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policies</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies
	 * @see #getPolicies()
	 * @generated
	 */
	void setPolicies(CalloutSecurityPolicies value);

	/**
	 * Returns the value of the '<em><b>Policy Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Key</em>' containment reference.
	 * @see #setPolicyKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_PolicyKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPolicyKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#getPolicyKey <em>Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Key</em>' containment reference.
	 * @see #getPolicyKey()
	 * @generated
	 */
	void setPolicyKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Init Axis2 Client Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Axis2 Client Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Axis2 Client Options</em>' attribute.
	 * @see #setInitAxis2ClientOptions(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCalloutMediator_InitAxis2ClientOptions()
	 * @model
	 * @generated
	 */
	boolean isInitAxis2ClientOptions();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator#isInitAxis2ClientOptions <em>Init Axis2 Client Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Axis2 Client Options</em>' attribute.
	 * @see #isInitAxis2ClientOptions()
	 * @generated
	 */
	void setInitAxis2ClientOptions(boolean value);

} // CalloutMediator
