/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getSoapVersion <em>Soap Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#isSerializeResponse <em>Serialize Response</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#isMarkAsResponse <em>Mark As Response</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeSoap11 <em>Fault Code Soap11</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeType <em>Fault Code Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeExpression <em>Fault Code Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultStringType <em>Fault String Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultStringValue <em>Fault String Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultStringExpression <em>Fault String Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultActor <em>Fault Actor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeSoap12 <em>Fault Code Soap12</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultReasonType <em>Fault Reason Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultReasonValue <em>Fault Reason Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultReasonExpression <em>Fault Reason Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultDetailType <em>Fault Detail Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultDetailValue <em>Fault Detail Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultDetailExpression <em>Fault Detail Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator()
 * @model
 * @generated
 */
public interface FaultMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Soap Version</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion
	 * @see #setSoapVersion(FaultSoapVersion)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_SoapVersion()
	 * @model
	 * @generated
	 */
	FaultSoapVersion getSoapVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getSoapVersion <em>Soap Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion
	 * @see #getSoapVersion()
	 * @generated
	 */
	void setSoapVersion(FaultSoapVersion value);

	/**
	 * Returns the value of the '<em><b>Serialize Response</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serialize Response</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serialize Response</em>' attribute.
	 * @see #setSerializeResponse(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_SerializeResponse()
	 * @model
	 * @generated
	 */
	boolean isSerializeResponse();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#isSerializeResponse <em>Serialize Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serialize Response</em>' attribute.
	 * @see #isSerializeResponse()
	 * @generated
	 */
	void setSerializeResponse(boolean value);

	/**
	 * Returns the value of the '<em><b>Mark As Response</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mark As Response</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mark As Response</em>' attribute.
	 * @see #setMarkAsResponse(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_MarkAsResponse()
	 * @model
	 * @generated
	 */
	boolean isMarkAsResponse();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#isMarkAsResponse <em>Mark As Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mark As Response</em>' attribute.
	 * @see #isMarkAsResponse()
	 * @generated
	 */
	void setMarkAsResponse(boolean value);

	/**
	 * Returns the value of the '<em><b>Fault Code Soap11</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap11}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Code Soap11</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Code Soap11</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap11
	 * @see #setFaultCodeSoap11(FaultCodeSoap11)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultCodeSoap11()
	 * @model
	 * @generated
	 */
	FaultCodeSoap11 getFaultCodeSoap11();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeSoap11 <em>Fault Code Soap11</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Code Soap11</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap11
	 * @see #getFaultCodeSoap11()
	 * @generated
	 */
	void setFaultCodeSoap11(FaultCodeSoap11 value);

	/**
	 * Returns the value of the '<em><b>Fault Code Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Code Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Code Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType
	 * @see #setFaultCodeType(FaultCodeType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultCodeType()
	 * @model
	 * @generated
	 */
	FaultCodeType getFaultCodeType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeType <em>Fault Code Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Code Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType
	 * @see #getFaultCodeType()
	 * @generated
	 */
	void setFaultCodeType(FaultCodeType value);

	/**
	 * Returns the value of the '<em><b>Fault Code Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Code Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Code Expression</em>' containment reference.
	 * @see #setFaultCodeExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultCodeExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultCodeExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeExpression <em>Fault Code Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Code Expression</em>' containment reference.
	 * @see #getFaultCodeExpression()
	 * @generated
	 */
	void setFaultCodeExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Fault String Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault String Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault String Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType
	 * @see #setFaultStringType(FaultStringType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultStringType()
	 * @model
	 * @generated
	 */
	FaultStringType getFaultStringType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultStringType <em>Fault String Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault String Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType
	 * @see #getFaultStringType()
	 * @generated
	 */
	void setFaultStringType(FaultStringType value);

	/**
	 * Returns the value of the '<em><b>Fault String Value</b></em>' attribute.
	 * The default value is <code>"fault_string"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault String Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault String Value</em>' attribute.
	 * @see #setFaultStringValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultStringValue()
	 * @model default="fault_string"
	 * @generated
	 */
	String getFaultStringValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultStringValue <em>Fault String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault String Value</em>' attribute.
	 * @see #getFaultStringValue()
	 * @generated
	 */
	void setFaultStringValue(String value);

	/**
	 * Returns the value of the '<em><b>Fault String Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault String Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault String Expression</em>' containment reference.
	 * @see #setFaultStringExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultStringExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultStringExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultStringExpression <em>Fault String Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault String Expression</em>' containment reference.
	 * @see #getFaultStringExpression()
	 * @generated
	 */
	void setFaultStringExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Fault Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Actor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Actor</em>' attribute.
	 * @see #setFaultActor(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultActor()
	 * @model
	 * @generated
	 */
	String getFaultActor();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultActor <em>Fault Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Actor</em>' attribute.
	 * @see #getFaultActor()
	 * @generated
	 */
	void setFaultActor(String value);

	/**
	 * Returns the value of the '<em><b>Fault Code Soap12</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap12}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Code Soap12</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Code Soap12</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap12
	 * @see #setFaultCodeSoap12(FaultCodeSoap12)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultCodeSoap12()
	 * @model
	 * @generated
	 */
	FaultCodeSoap12 getFaultCodeSoap12();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultCodeSoap12 <em>Fault Code Soap12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Code Soap12</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap12
	 * @see #getFaultCodeSoap12()
	 * @generated
	 */
	void setFaultCodeSoap12(FaultCodeSoap12 value);

	/**
	 * Returns the value of the '<em><b>Fault Reason Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Reason Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Reason Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType
	 * @see #setFaultReasonType(FaultReasonType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultReasonType()
	 * @model
	 * @generated
	 */
	FaultReasonType getFaultReasonType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultReasonType <em>Fault Reason Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Reason Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType
	 * @see #getFaultReasonType()
	 * @generated
	 */
	void setFaultReasonType(FaultReasonType value);

	/**
	 * Returns the value of the '<em><b>Fault Reason Value</b></em>' attribute.
	 * The default value is <code>"fault_reason"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Reason Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Reason Value</em>' attribute.
	 * @see #setFaultReasonValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultReasonValue()
	 * @model default="fault_reason"
	 * @generated
	 */
	String getFaultReasonValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultReasonValue <em>Fault Reason Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Reason Value</em>' attribute.
	 * @see #getFaultReasonValue()
	 * @generated
	 */
	void setFaultReasonValue(String value);

	/**
	 * Returns the value of the '<em><b>Fault Reason Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Reason Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Reason Expression</em>' containment reference.
	 * @see #setFaultReasonExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultReasonExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultReasonExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultReasonExpression <em>Fault Reason Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Reason Expression</em>' containment reference.
	 * @see #getFaultReasonExpression()
	 * @generated
	 */
	void setFaultReasonExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Name</em>' attribute.
	 * @see #setRoleName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_RoleName()
	 * @model
	 * @generated
	 */
	String getRoleName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getRoleName <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Name</em>' attribute.
	 * @see #getRoleName()
	 * @generated
	 */
	void setRoleName(String value);

	/**
	 * Returns the value of the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Name</em>' attribute.
	 * @see #setNodeName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_NodeName()
	 * @model
	 * @generated
	 */
	String getNodeName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getNodeName <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Name</em>' attribute.
	 * @see #getNodeName()
	 * @generated
	 */
	void setNodeName(String value);

	/**
	 * Returns the value of the '<em><b>Fault Detail Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Detail Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Detail Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType
	 * @see #setFaultDetailType(FaultDetailType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultDetailType()
	 * @model
	 * @generated
	 */
	FaultDetailType getFaultDetailType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultDetailType <em>Fault Detail Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Detail Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType
	 * @see #getFaultDetailType()
	 * @generated
	 */
	void setFaultDetailType(FaultDetailType value);

	/**
	 * Returns the value of the '<em><b>Fault Detail Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Detail Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Detail Value</em>' attribute.
	 * @see #setFaultDetailValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultDetailValue()
	 * @model
	 * @generated
	 */
	String getFaultDetailValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultDetailValue <em>Fault Detail Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Detail Value</em>' attribute.
	 * @see #getFaultDetailValue()
	 * @generated
	 */
	void setFaultDetailValue(String value);

	/**
	 * Returns the value of the '<em><b>Fault Detail Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Detail Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Detail Expression</em>' containment reference.
	 * @see #setFaultDetailExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_FaultDetailExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultDetailExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getFaultDetailExpression <em>Fault Detail Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Detail Expression</em>' containment reference.
	 * @see #getFaultDetailExpression()
	 * @generated
	 */
	void setFaultDetailExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(FaultMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FaultMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(FaultMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(FaultMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FaultMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(FaultMediatorOutputConnector value);

} // FaultMediator
