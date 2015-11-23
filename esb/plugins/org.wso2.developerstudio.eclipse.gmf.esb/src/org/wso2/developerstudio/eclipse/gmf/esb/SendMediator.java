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
 * A representation of the model object '<em><b>Send Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getReceivingSequenceType <em>Receiving Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getStaticReceivingSequence <em>Static Receiving Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getDynamicReceivingSequence <em>Dynamic Receiving Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getEndpointOutputConnector <em>Endpoint Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#isSkipSerialization <em>Skip Serialization</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#isBuildMessageBeforeSending <em>Build Message Before Sending</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator()
 * @model
 * @generated
 */
public interface SendMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>End Point</b></em>' reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.EndPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Point</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Point</em>' reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_EndPoint()
	 * @model
	 * @generated
	 */
	EList<EndPoint> getEndPoint();

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(SendMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SendMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(SendMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(SendMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SendMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(SendMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Receiving Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ReceivingSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiving Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiving Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ReceivingSequenceType
	 * @see #setReceivingSequenceType(ReceivingSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_ReceivingSequenceType()
	 * @model
	 * @generated
	 */
	ReceivingSequenceType getReceivingSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getReceivingSequenceType <em>Receiving Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiving Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ReceivingSequenceType
	 * @see #getReceivingSequenceType()
	 * @generated
	 */
	void setReceivingSequenceType(ReceivingSequenceType value);

	/**
	 * Returns the value of the '<em><b>Static Receiving Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Receiving Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Receiving Sequence</em>' containment reference.
	 * @see #setStaticReceivingSequence(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_StaticReceivingSequence()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getStaticReceivingSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getStaticReceivingSequence <em>Static Receiving Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Receiving Sequence</em>' containment reference.
	 * @see #getStaticReceivingSequence()
	 * @generated
	 */
	void setStaticReceivingSequence(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Dynamic Receiving Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Receiving Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Receiving Sequence</em>' containment reference.
	 * @see #setDynamicReceivingSequence(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_DynamicReceivingSequence()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getDynamicReceivingSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getDynamicReceivingSequence <em>Dynamic Receiving Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Receiving Sequence</em>' containment reference.
	 * @see #getDynamicReceivingSequence()
	 * @generated
	 */
	void setDynamicReceivingSequence(NamespacedProperty value);

    /**
	 * Returns the value of the '<em><b>Endpoint Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Output Connector</em>' containment reference.
	 * @see #setEndpointOutputConnector(SendMediatorEndpointOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_EndpointOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
    SendMediatorEndpointOutputConnector getEndpointOutputConnector();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getEndpointOutputConnector <em>Endpoint Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Output Connector</em>' containment reference.
	 * @see #getEndpointOutputConnector()
	 * @generated
	 */
    void setEndpointOutputConnector(SendMediatorEndpointOutputConnector value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

				/**
	 * Returns the value of the '<em><b>Skip Serialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skip Serialization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip Serialization</em>' attribute.
	 * @see #setSkipSerialization(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_SkipSerialization()
	 * @model
	 * @generated
	 */
	boolean isSkipSerialization();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#isSkipSerialization <em>Skip Serialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip Serialization</em>' attribute.
	 * @see #isSkipSerialization()
	 * @generated
	 */
	void setSkipSerialization(boolean value);

				/**
	 * Returns the value of the '<em><b>Build Message Before Sending</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Message Before Sending</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Message Before Sending</em>' attribute.
	 * @see #setBuildMessageBeforeSending(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSendMediator_BuildMessageBeforeSending()
	 * @model
	 * @generated
	 */
	boolean isBuildMessageBeforeSending();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator#isBuildMessageBeforeSending <em>Build Message Before Sending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Message Before Sending</em>' attribute.
	 * @see #isBuildMessageBeforeSending()
	 * @generated
	 */
	void setBuildMessageBeforeSending(boolean value);

				/**
     * Sets the value of the next node
     * @param node
     */
    void setNextNode(EndPoint node);
    
    /**
     * Returns the value of the next node
     * @return
     */
    EndPoint getNextNode();
    

} // SendMediator
