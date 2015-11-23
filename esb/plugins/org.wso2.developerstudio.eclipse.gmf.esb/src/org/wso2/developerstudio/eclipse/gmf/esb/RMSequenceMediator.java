/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RM Sequence Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getRmSpecVersion <em>Rm Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getCorrelationXpath <em>Correlation Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getLastMessageXpath <em>Last Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator()
 * @model
 * @generated
 */
public interface RMSequenceMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Rm Spec Version</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RMSpecVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rm Spec Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rm Spec Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RMSpecVersion
	 * @see #setRmSpecVersion(RMSpecVersion)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator_RmSpecVersion()
	 * @model
	 * @generated
	 */
	RMSpecVersion getRmSpecVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getRmSpecVersion <em>Rm Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rm Spec Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RMSpecVersion
	 * @see #getRmSpecVersion()
	 * @generated
	 */
	void setRmSpecVersion(RMSpecVersion value);

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The default value is <code>"SINGLE_MESSAGE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceType
	 * @see #setSequenceType(RMSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator_SequenceType()
	 * @model default="SINGLE_MESSAGE"
	 * @generated
	 */
	RMSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(RMSequenceType value);

	/**
	 * Returns the value of the '<em><b>Correlation Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Xpath</em>' containment reference.
	 * @see #setCorrelationXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator_CorrelationXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getCorrelationXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getCorrelationXpath <em>Correlation Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Xpath</em>' containment reference.
	 * @see #getCorrelationXpath()
	 * @generated
	 */
	void setCorrelationXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Last Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Message Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Message Xpath</em>' containment reference.
	 * @see #setLastMessageXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator_LastMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getLastMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getLastMessageXpath <em>Last Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Message Xpath</em>' containment reference.
	 * @see #getLastMessageXpath()
	 * @generated
	 */
	void setLastMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(RMSequenceMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RMSequenceMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(RMSequenceMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(RMSequenceMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRMSequenceMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RMSequenceMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(RMSequenceMediatorOutputConnector value);

} // RMSequenceMediator
