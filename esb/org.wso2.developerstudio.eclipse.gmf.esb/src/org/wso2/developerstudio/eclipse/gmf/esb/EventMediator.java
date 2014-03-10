/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getTopicType <em>Topic Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getStaticTopic <em>Static Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getDynamicTopic <em>Dynamic Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getEventExpression <em>Event Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator()
 * @model
 * @generated
 */
public interface EventMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Topic Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topic Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType
	 * @see #setTopicType(EventTopicType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator_TopicType()
	 * @model
	 * @generated
	 */
	EventTopicType getTopicType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getTopicType <em>Topic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType
	 * @see #getTopicType()
	 * @generated
	 */
	void setTopicType(EventTopicType value);

	/**
	 * Returns the value of the '<em><b>Static Topic</b></em>' attribute.
	 * The default value is <code>"source_property"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Topic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Topic</em>' attribute.
	 * @see #setStaticTopic(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator_StaticTopic()
	 * @model default="source_property"
	 * @generated
	 */
	String getStaticTopic();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getStaticTopic <em>Static Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Topic</em>' attribute.
	 * @see #getStaticTopic()
	 * @generated
	 */
	void setStaticTopic(String value);

	/**
	 * Returns the value of the '<em><b>Dynamic Topic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Topic</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Topic</em>' containment reference.
	 * @see #setDynamicTopic(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator_DynamicTopic()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getDynamicTopic();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getDynamicTopic <em>Dynamic Topic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Topic</em>' containment reference.
	 * @see #getDynamicTopic()
	 * @generated
	 */
	void setDynamicTopic(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Event Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Expression</em>' containment reference.
	 * @see #setEventExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator_EventExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getEventExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getEventExpression <em>Event Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Expression</em>' containment reference.
	 * @see #getEventExpression()
	 * @generated
	 */
	void setEventExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(EventMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EventMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(EventMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(EventMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEventMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EventMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EventMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(EventMediatorOutputConnector value);

} // EventMediator
