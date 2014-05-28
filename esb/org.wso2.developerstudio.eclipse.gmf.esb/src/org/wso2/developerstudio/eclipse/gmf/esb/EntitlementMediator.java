/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entitlement Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getEntitlementServerURL <em>Entitlement Server URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getUsername <em>Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getCallbackClassName <em>Callback Class Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getThriftHost <em>Thrift Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getThriftPort <em>Thrift Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getEntitlementClientType <em>Entitlement Client Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnRejectSequenceType <em>On Reject Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnAcceptSequenceType <em>On Accept Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getAdviceSequenceType <em>Advice Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getObligationsSequenceType <em>Obligations Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnRejectSequenceKey <em>On Reject Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnAcceptSequenceKey <em>On Accept Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getAdviceSequenceKey <em>Advice Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getObligationsSequenceKey <em>Obligations Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getEntitlementContainer <em>Entitlement Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnRejectOutputConnector <em>On Reject Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnAcceptOutputConnector <em>On Accept Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getAdviceOutputConnector <em>Advice Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getObligationsOutputConnector <em>Obligations Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getCallbackHandler <em>Callback Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator()
 * @model
 * @generated
 */
public interface EntitlementMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Entitlement Server URL</b></em>' attribute.
	 * The default value is <code>"server_url"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entitlement Server URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entitlement Server URL</em>' attribute.
	 * @see #setEntitlementServerURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_EntitlementServerURL()
	 * @model default="server_url"
	 * @generated
	 */
	String getEntitlementServerURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getEntitlementServerURL <em>Entitlement Server URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entitlement Server URL</em>' attribute.
	 * @see #getEntitlementServerURL()
	 * @generated
	 */
	void setEntitlementServerURL(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * The default value is <code>"username"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_Username()
	 * @model default="username"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * The default value is <code>"password"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_Password()
	 * @model default="password"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Callback Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Callback Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Callback Class Name</em>' attribute.
	 * @see #setCallbackClassName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_CallbackClassName()
	 * @model
	 * @generated
	 */
	String getCallbackClassName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getCallbackClassName <em>Callback Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callback Class Name</em>' attribute.
	 * @see #getCallbackClassName()
	 * @generated
	 */
	void setCallbackClassName(String value);

	/**
	 * Returns the value of the '<em><b>Thrift Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thrift Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thrift Host</em>' attribute.
	 * @see #setThriftHost(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_ThriftHost()
	 * @model
	 * @generated
	 */
	String getThriftHost();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getThriftHost <em>Thrift Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thrift Host</em>' attribute.
	 * @see #getThriftHost()
	 * @generated
	 */
	void setThriftHost(String value);

	/**
	 * Returns the value of the '<em><b>Thrift Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thrift Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thrift Port</em>' attribute.
	 * @see #setThriftPort(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_ThriftPort()
	 * @model
	 * @generated
	 */
	String getThriftPort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getThriftPort <em>Thrift Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thrift Port</em>' attribute.
	 * @see #getThriftPort()
	 * @generated
	 */
	void setThriftPort(String value);

	/**
	 * Returns the value of the '<em><b>Entitlement Client Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entitlement Client Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entitlement Client Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType
	 * @see #setEntitlementClientType(EntitlementClientType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_EntitlementClientType()
	 * @model
	 * @generated
	 */
	EntitlementClientType getEntitlementClientType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getEntitlementClientType <em>Entitlement Client Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entitlement Client Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType
	 * @see #getEntitlementClientType()
	 * @generated
	 */
	void setEntitlementClientType(EntitlementClientType value);

	/**
	 * Returns the value of the '<em><b>On Reject Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #setOnRejectSequenceType(EntitlementSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OnRejectSequenceType()
	 * @model
	 * @generated
	 */
	EntitlementSequenceType getOnRejectSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnRejectSequenceType <em>On Reject Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #getOnRejectSequenceType()
	 * @generated
	 */
	void setOnRejectSequenceType(EntitlementSequenceType value);

	/**
	 * Returns the value of the '<em><b>On Accept Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #setOnAcceptSequenceType(EntitlementSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OnAcceptSequenceType()
	 * @model
	 * @generated
	 */
	EntitlementSequenceType getOnAcceptSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnAcceptSequenceType <em>On Accept Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #getOnAcceptSequenceType()
	 * @generated
	 */
	void setOnAcceptSequenceType(EntitlementSequenceType value);

	/**
	 * Returns the value of the '<em><b>Advice Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #setAdviceSequenceType(EntitlementSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_AdviceSequenceType()
	 * @model
	 * @generated
	 */
	EntitlementSequenceType getAdviceSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getAdviceSequenceType <em>Advice Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #getAdviceSequenceType()
	 * @generated
	 */
	void setAdviceSequenceType(EntitlementSequenceType value);

	/**
	 * Returns the value of the '<em><b>Obligations Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obligations Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obligations Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #setObligationsSequenceType(EntitlementSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_ObligationsSequenceType()
	 * @model
	 * @generated
	 */
	EntitlementSequenceType getObligationsSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getObligationsSequenceType <em>Obligations Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obligations Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType
	 * @see #getObligationsSequenceType()
	 * @generated
	 */
	void setObligationsSequenceType(EntitlementSequenceType value);

	/**
	 * Returns the value of the '<em><b>On Reject Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Sequence Key</em>' containment reference.
	 * @see #setOnRejectSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OnRejectSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOnRejectSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnRejectSequenceKey <em>On Reject Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Sequence Key</em>' containment reference.
	 * @see #getOnRejectSequenceKey()
	 * @generated
	 */
	void setOnRejectSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>On Accept Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Sequence Key</em>' containment reference.
	 * @see #setOnAcceptSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OnAcceptSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOnAcceptSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnAcceptSequenceKey <em>On Accept Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Sequence Key</em>' containment reference.
	 * @see #getOnAcceptSequenceKey()
	 * @generated
	 */
	void setOnAcceptSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Advice Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Sequence Key</em>' containment reference.
	 * @see #setAdviceSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_AdviceSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getAdviceSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getAdviceSequenceKey <em>Advice Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice Sequence Key</em>' containment reference.
	 * @see #getAdviceSequenceKey()
	 * @generated
	 */
	void setAdviceSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Obligations Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obligations Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obligations Sequence Key</em>' containment reference.
	 * @see #setObligationsSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_ObligationsSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getObligationsSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getObligationsSequenceKey <em>Obligations Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obligations Sequence Key</em>' containment reference.
	 * @see #getObligationsSequenceKey()
	 * @generated
	 */
	void setObligationsSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Entitlement Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entitlement Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entitlement Container</em>' containment reference.
	 * @see #setEntitlementContainer(EntitlementContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_EntitlementContainer()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementContainer getEntitlementContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getEntitlementContainer <em>Entitlement Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entitlement Container</em>' containment reference.
	 * @see #getEntitlementContainer()
	 * @generated
	 */
	void setEntitlementContainer(EntitlementContainer value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(EntitlementMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(EntitlementMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(EntitlementMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(EntitlementMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>On Reject Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Output Connector</em>' containment reference.
	 * @see #setOnRejectOutputConnector(EntitlementMediatorOnRejectOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OnRejectOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementMediatorOnRejectOutputConnector getOnRejectOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnRejectOutputConnector <em>On Reject Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Output Connector</em>' containment reference.
	 * @see #getOnRejectOutputConnector()
	 * @generated
	 */
	void setOnRejectOutputConnector(EntitlementMediatorOnRejectOutputConnector value);

	/**
	 * Returns the value of the '<em><b>On Accept Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Output Connector</em>' containment reference.
	 * @see #setOnAcceptOutputConnector(EntitlementMediatorOnAcceptOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_OnAcceptOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementMediatorOnAcceptOutputConnector getOnAcceptOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getOnAcceptOutputConnector <em>On Accept Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Output Connector</em>' containment reference.
	 * @see #getOnAcceptOutputConnector()
	 * @generated
	 */
	void setOnAcceptOutputConnector(EntitlementMediatorOnAcceptOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Advice Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Output Connector</em>' containment reference.
	 * @see #setAdviceOutputConnector(EntitlementMediatorAdviceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_AdviceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementMediatorAdviceOutputConnector getAdviceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getAdviceOutputConnector <em>Advice Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice Output Connector</em>' containment reference.
	 * @see #getAdviceOutputConnector()
	 * @generated
	 */
	void setAdviceOutputConnector(EntitlementMediatorAdviceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Obligations Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obligations Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obligations Output Connector</em>' containment reference.
	 * @see #setObligationsOutputConnector(EntitlementMediatorObligationsOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_ObligationsOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementMediatorObligationsOutputConnector getObligationsOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getObligationsOutputConnector <em>Obligations Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obligations Output Connector</em>' containment reference.
	 * @see #getObligationsOutputConnector()
	 * @generated
	 */
	void setObligationsOutputConnector(EntitlementMediatorObligationsOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Callback Handler</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Callback Handler</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Callback Handler</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler
	 * @see #setCallbackHandler(EntitlementCallbackHandler)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementMediator_CallbackHandler()
	 * @model
	 * @generated
	 */
	EntitlementCallbackHandler getCallbackHandler();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator#getCallbackHandler <em>Callback Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callback Handler</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler
	 * @see #getCallbackHandler()
	 * @generated
	 */
	void setCallbackHandler(EntitlementCallbackHandler value);

} // EntitlementMediator
