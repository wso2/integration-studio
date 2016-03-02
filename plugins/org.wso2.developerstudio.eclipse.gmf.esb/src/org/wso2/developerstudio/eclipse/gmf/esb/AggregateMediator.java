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
 * A representation of the model object '<em><b>Aggregate Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getAggregateID <em>Aggregate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCorrelationExpression <em>Correlation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionTimeout <em>Completion Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMinMessagesType <em>Completion Min Messages Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMaxMessagesType <em>Completion Max Messages Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMinMessagesValue <em>Completion Min Messages Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMinMessagesExpression <em>Completion Min Messages Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMaxMessagesValue <em>Completion Max Messages Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMaxMessagesExpression <em>Completion Max Messages Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getOnCompleteOutputConnector <em>On Complete Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getAggregationExpression <em>Aggregation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getEnclosingElementProperty <em>Enclosing Element Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator()
 * @model
 * @generated
 */
public interface AggregateMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Aggregate ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregate ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregate ID</em>' attribute.
	 * @see #setAggregateID(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_AggregateID()
	 * @model
	 * @generated
	 */
	String getAggregateID();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getAggregateID <em>Aggregate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregate ID</em>' attribute.
	 * @see #getAggregateID()
	 * @generated
	 */
	void setAggregateID(String value);

	/**
	 * Returns the value of the '<em><b>Correlation Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Expression</em>' containment reference.
	 * @see #setCorrelationExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CorrelationExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getCorrelationExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCorrelationExpression <em>Correlation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Expression</em>' containment reference.
	 * @see #getCorrelationExpression()
	 * @generated
	 */
	void setCorrelationExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Completion Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Timeout</em>' attribute.
	 * @see #setCompletionTimeout(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionTimeout()
	 * @model
	 * @generated
	 */
	long getCompletionTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionTimeout <em>Completion Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Timeout</em>' attribute.
	 * @see #getCompletionTimeout()
	 * @generated
	 */
	void setCompletionTimeout(long value);

	/**
	 * Returns the value of the '<em><b>Completion Min Messages Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Min Messages Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Min Messages Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType
	 * @see #setCompletionMinMessagesType(CompletionMessagesType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionMinMessagesType()
	 * @model
	 * @generated
	 */
	CompletionMessagesType getCompletionMinMessagesType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMinMessagesType <em>Completion Min Messages Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Min Messages Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType
	 * @see #getCompletionMinMessagesType()
	 * @generated
	 */
	void setCompletionMinMessagesType(CompletionMessagesType value);

	/**
	 * Returns the value of the '<em><b>Completion Max Messages Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Max Messages Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Max Messages Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType
	 * @see #setCompletionMaxMessagesType(CompletionMessagesType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionMaxMessagesType()
	 * @model
	 * @generated
	 */
	CompletionMessagesType getCompletionMaxMessagesType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMaxMessagesType <em>Completion Max Messages Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Max Messages Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType
	 * @see #getCompletionMaxMessagesType()
	 * @generated
	 */
	void setCompletionMaxMessagesType(CompletionMessagesType value);

	/**
	 * Returns the value of the '<em><b>Completion Min Messages Value</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Min Messages Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Min Messages Value</em>' attribute.
	 * @see #setCompletionMinMessagesValue(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionMinMessagesValue()
	 * @model default="-1"
	 * @generated
	 */
	int getCompletionMinMessagesValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMinMessagesValue <em>Completion Min Messages Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Min Messages Value</em>' attribute.
	 * @see #getCompletionMinMessagesValue()
	 * @generated
	 */
	void setCompletionMinMessagesValue(int value);

	/**
	 * Returns the value of the '<em><b>Completion Min Messages Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Min Messages Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Min Messages Expression</em>' containment reference.
	 * @see #setCompletionMinMessagesExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionMinMessagesExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getCompletionMinMessagesExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMinMessagesExpression <em>Completion Min Messages Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Min Messages Expression</em>' containment reference.
	 * @see #getCompletionMinMessagesExpression()
	 * @generated
	 */
	void setCompletionMinMessagesExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Completion Max Messages Value</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Max Messages Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Max Messages Value</em>' attribute.
	 * @see #setCompletionMaxMessagesValue(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionMaxMessagesValue()
	 * @model default="-1"
	 * @generated
	 */
	int getCompletionMaxMessagesValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMaxMessagesValue <em>Completion Max Messages Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Max Messages Value</em>' attribute.
	 * @see #getCompletionMaxMessagesValue()
	 * @generated
	 */
	void setCompletionMaxMessagesValue(int value);

	/**
	 * Returns the value of the '<em><b>Completion Max Messages Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Max Messages Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Max Messages Expression</em>' containment reference.
	 * @see #setCompletionMaxMessagesExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_CompletionMaxMessagesExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getCompletionMaxMessagesExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getCompletionMaxMessagesExpression <em>Completion Max Messages Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Max Messages Expression</em>' containment reference.
	 * @see #getCompletionMaxMessagesExpression()
	 * @generated
	 */
	void setCompletionMaxMessagesExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(AggregateMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	AggregateMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(AggregateMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(AggregateMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	AggregateMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(AggregateMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>On Complete Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Complete Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Complete Output Connector</em>' containment reference.
	 * @see #setOnCompleteOutputConnector(AggregateMediatorOnCompleteOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_OnCompleteOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	AggregateMediatorOnCompleteOutputConnector getOnCompleteOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getOnCompleteOutputConnector <em>On Complete Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Complete Output Connector</em>' containment reference.
	 * @see #getOnCompleteOutputConnector()
	 * @generated
	 */
	void setOnCompleteOutputConnector(AggregateMediatorOnCompleteOutputConnector value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

	/**
	 * Returns the value of the '<em><b>Aggregation Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Expression</em>' containment reference.
	 * @see #setAggregationExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_AggregationExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getAggregationExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getAggregationExpression <em>Aggregation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Expression</em>' containment reference.
	 * @see #getAggregationExpression()
	 * @generated
	 */
	void setAggregationExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType
	 * @see #setSequenceType(AggregateSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_SequenceType()
	 * @model
	 * @generated
	 */
	AggregateSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(AggregateSequenceType value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' containment reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_SequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getSequenceKey <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' containment reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Enclosing Element Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing Element Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosing Element Property</em>' attribute.
	 * @see #setEnclosingElementProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAggregateMediator_EnclosingElementProperty()
	 * @model
	 * @generated
	 */
	String getEnclosingElementProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator#getEnclosingElementProperty <em>Enclosing Element Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enclosing Element Property</em>' attribute.
	 * @see #getEnclosingElementProperty()
	 * @generated
	 */
	void setEnclosingElementProperty(String value);

} // AggregateMediator
