/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorOnCompleteOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getAggregateID <em>Aggregate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCorrelationExpression <em>Correlation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionTimeout <em>Completion Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionMinMessagesType <em>Completion Min Messages Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionMaxMessagesType <em>Completion Max Messages Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionMinMessagesValue <em>Completion Min Messages Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionMinMessagesExpression <em>Completion Min Messages Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionMaxMessagesValue <em>Completion Max Messages Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getCompletionMaxMessagesExpression <em>Completion Max Messages Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getOnCompleteOutputConnector <em>On Complete Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getAggregationExpression <em>Aggregation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl#getEnclosingElementProperty <em>Enclosing Element Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregateMediatorImpl extends MediatorImpl implements AggregateMediator {
	/**
	 * The default value of the '{@link #getAggregateID() <em>Aggregate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregateID()
	 * @generated
	 * @ordered
	 */
	protected static final String AGGREGATE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAggregateID() <em>Aggregate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregateID()
	 * @generated
	 * @ordered
	 */
	protected String aggregateID = AGGREGATE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCorrelationExpression() <em>Correlation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty correlationExpression;

	/**
	 * The default value of the '{@link #getCompletionTimeout() <em>Completion Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final long COMPLETION_TIMEOUT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCompletionTimeout() <em>Completion Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionTimeout()
	 * @generated
	 * @ordered
	 */
	protected long completionTimeout = COMPLETION_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompletionMinMessagesType() <em>Completion Min Messages Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMinMessagesType()
	 * @generated
	 * @ordered
	 */
	protected static final CompletionMessagesType COMPLETION_MIN_MESSAGES_TYPE_EDEFAULT = CompletionMessagesType.VALUE;

	/**
	 * The cached value of the '{@link #getCompletionMinMessagesType() <em>Completion Min Messages Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMinMessagesType()
	 * @generated
	 * @ordered
	 */
	protected CompletionMessagesType completionMinMessagesType = COMPLETION_MIN_MESSAGES_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompletionMaxMessagesType() <em>Completion Max Messages Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMaxMessagesType()
	 * @generated
	 * @ordered
	 */
	protected static final CompletionMessagesType COMPLETION_MAX_MESSAGES_TYPE_EDEFAULT = CompletionMessagesType.VALUE;

	/**
	 * The cached value of the '{@link #getCompletionMaxMessagesType() <em>Completion Max Messages Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMaxMessagesType()
	 * @generated
	 * @ordered
	 */
	protected CompletionMessagesType completionMaxMessagesType = COMPLETION_MAX_MESSAGES_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompletionMinMessagesValue() <em>Completion Min Messages Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMinMessagesValue()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPLETION_MIN_MESSAGES_VALUE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCompletionMinMessagesValue() <em>Completion Min Messages Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMinMessagesValue()
	 * @generated
	 * @ordered
	 */
	protected int completionMinMessagesValue = COMPLETION_MIN_MESSAGES_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompletionMinMessagesExpression() <em>Completion Min Messages Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMinMessagesExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty completionMinMessagesExpression;

	/**
	 * The default value of the '{@link #getCompletionMaxMessagesValue() <em>Completion Max Messages Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMaxMessagesValue()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPLETION_MAX_MESSAGES_VALUE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCompletionMaxMessagesValue() <em>Completion Max Messages Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMaxMessagesValue()
	 * @generated
	 * @ordered
	 */
	protected int completionMaxMessagesValue = COMPLETION_MAX_MESSAGES_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompletionMaxMessagesExpression() <em>Completion Max Messages Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionMaxMessagesExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty completionMaxMessagesExpression;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected AggregateMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected AggregateMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getOnCompleteOutputConnector() <em>On Complete Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnCompleteOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected AggregateMediatorOnCompleteOutputConnector onCompleteOutputConnector;

	/**
	 * The cached value of the '{@link #getMediatorFlow() <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediatorFlow()
	 * @generated
	 * @ordered
	 */
	protected MediatorFlow mediatorFlow;

	/**
	 * The cached value of the '{@link #getAggregationExpression() <em>Aggregation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty aggregationExpression;

	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final AggregateSequenceType SEQUENCE_TYPE_EDEFAULT = AggregateSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected AggregateSequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;

	/**
	 * The default value of the '{@link #getEnclosingElementProperty() <em>Enclosing Element Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingElementProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCLOSING_ELEMENT_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnclosingElementProperty() <em>Enclosing Element Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingElementProperty()
	 * @generated
	 * @ordered
	 */
	protected String enclosingElementProperty = ENCLOSING_ELEMENT_PROPERTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AggregateMediatorImpl() {
		super();	
		// Correlation expression.
		NamespacedProperty correlateOnExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		correlateOnExpression.setPrettyName("Correlation Expression");
		correlateOnExpression.setPropertyName("expression");
		correlateOnExpression.setPropertyValue("");
		setCorrelationExpression(correlateOnExpression);	
		
		// Aggregation Expression
		NamespacedProperty aggregationExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		aggregationExpression.setPrettyName("Aggregation Expression");
		aggregationExpression.setPropertyName("expression");
		aggregationExpression.setPropertyValue("/default/expression");
		setAggregationExpression(aggregationExpression);
		
		NamespacedProperty completionMaxMessagesExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		completionMaxMessagesExpression.setPrettyName("completionMaxMessagesExpression");
		completionMaxMessagesExpression.setPropertyName("expression");
		completionMaxMessagesExpression.setPropertyValue("/default/expression");
		setCompletionMaxMessagesExpression(completionMaxMessagesExpression);
		
		NamespacedProperty completionMinMessagesExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		completionMinMessagesExpression.setPrettyName("completionMinMessagesExpression");
		completionMinMessagesExpression.setPropertyName("expression");
		completionMinMessagesExpression.setPropertyValue("/default/expression");
		setCompletionMinMessagesExpression(completionMinMessagesExpression);
		
		RegistryKeyProperty sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		sequenceKey.setKeyName("Sequence Key");
		sequenceKey.setPrettyName("Sequence Key");
		sequenceKey.setKeyValue("/default/key");
		setSequenceKey(sequenceKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.AGGREGATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAggregateID() {
		return aggregateID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregateID(String newAggregateID) {
		String oldAggregateID = aggregateID;
		aggregateID = newAggregateID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__AGGREGATE_ID, oldAggregateID, aggregateID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getCorrelationExpression() {
		return correlationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorrelationExpression(NamespacedProperty newCorrelationExpression, NotificationChain msgs) {
		NamespacedProperty oldCorrelationExpression = correlationExpression;
		correlationExpression = newCorrelationExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION, oldCorrelationExpression, newCorrelationExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelationExpression(NamespacedProperty newCorrelationExpression) {
		if (newCorrelationExpression != correlationExpression) {
			NotificationChain msgs = null;
			if (correlationExpression != null)
				msgs = ((InternalEObject)correlationExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION, null, msgs);
			if (newCorrelationExpression != null)
				msgs = ((InternalEObject)newCorrelationExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION, null, msgs);
			msgs = basicSetCorrelationExpression(newCorrelationExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION, newCorrelationExpression, newCorrelationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCompletionTimeout() {
		return completionTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionTimeout(long newCompletionTimeout) {
		long oldCompletionTimeout = completionTimeout;
		completionTimeout = newCompletionTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT, oldCompletionTimeout, completionTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionMessagesType getCompletionMinMessagesType() {
		return completionMinMessagesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionMinMessagesType(CompletionMessagesType newCompletionMinMessagesType) {
		CompletionMessagesType oldCompletionMinMessagesType = completionMinMessagesType;
		completionMinMessagesType = newCompletionMinMessagesType == null ? COMPLETION_MIN_MESSAGES_TYPE_EDEFAULT : newCompletionMinMessagesType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE, oldCompletionMinMessagesType, completionMinMessagesType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionMessagesType getCompletionMaxMessagesType() {
		return completionMaxMessagesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionMaxMessagesType(CompletionMessagesType newCompletionMaxMessagesType) {
		CompletionMessagesType oldCompletionMaxMessagesType = completionMaxMessagesType;
		completionMaxMessagesType = newCompletionMaxMessagesType == null ? COMPLETION_MAX_MESSAGES_TYPE_EDEFAULT : newCompletionMaxMessagesType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE, oldCompletionMaxMessagesType, completionMaxMessagesType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCompletionMinMessagesValue() {
		return completionMinMessagesValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionMinMessagesValue(int newCompletionMinMessagesValue) {
		int oldCompletionMinMessagesValue = completionMinMessagesValue;
		completionMinMessagesValue = newCompletionMinMessagesValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE, oldCompletionMinMessagesValue, completionMinMessagesValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getCompletionMinMessagesExpression() {
		return completionMinMessagesExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompletionMinMessagesExpression(NamespacedProperty newCompletionMinMessagesExpression, NotificationChain msgs) {
		NamespacedProperty oldCompletionMinMessagesExpression = completionMinMessagesExpression;
		completionMinMessagesExpression = newCompletionMinMessagesExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION, oldCompletionMinMessagesExpression, newCompletionMinMessagesExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionMinMessagesExpression(NamespacedProperty newCompletionMinMessagesExpression) {
		if (newCompletionMinMessagesExpression != completionMinMessagesExpression) {
			NotificationChain msgs = null;
			if (completionMinMessagesExpression != null)
				msgs = ((InternalEObject)completionMinMessagesExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION, null, msgs);
			if (newCompletionMinMessagesExpression != null)
				msgs = ((InternalEObject)newCompletionMinMessagesExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION, null, msgs);
			msgs = basicSetCompletionMinMessagesExpression(newCompletionMinMessagesExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION, newCompletionMinMessagesExpression, newCompletionMinMessagesExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCompletionMaxMessagesValue() {
		return completionMaxMessagesValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionMaxMessagesValue(int newCompletionMaxMessagesValue) {
		int oldCompletionMaxMessagesValue = completionMaxMessagesValue;
		completionMaxMessagesValue = newCompletionMaxMessagesValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE, oldCompletionMaxMessagesValue, completionMaxMessagesValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getCompletionMaxMessagesExpression() {
		return completionMaxMessagesExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompletionMaxMessagesExpression(NamespacedProperty newCompletionMaxMessagesExpression, NotificationChain msgs) {
		NamespacedProperty oldCompletionMaxMessagesExpression = completionMaxMessagesExpression;
		completionMaxMessagesExpression = newCompletionMaxMessagesExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION, oldCompletionMaxMessagesExpression, newCompletionMaxMessagesExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionMaxMessagesExpression(NamespacedProperty newCompletionMaxMessagesExpression) {
		if (newCompletionMaxMessagesExpression != completionMaxMessagesExpression) {
			NotificationChain msgs = null;
			if (completionMaxMessagesExpression != null)
				msgs = ((InternalEObject)completionMaxMessagesExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION, null, msgs);
			if (newCompletionMaxMessagesExpression != null)
				msgs = ((InternalEObject)newCompletionMaxMessagesExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION, null, msgs);
			msgs = basicSetCompletionMaxMessagesExpression(newCompletionMaxMessagesExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION, newCompletionMaxMessagesExpression, newCompletionMaxMessagesExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(AggregateMediatorInputConnector newInputConnector, NotificationChain msgs) {
		AggregateMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(AggregateMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(AggregateMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		AggregateMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(AggregateMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediatorOnCompleteOutputConnector getOnCompleteOutputConnector() {
		return onCompleteOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnCompleteOutputConnector(AggregateMediatorOnCompleteOutputConnector newOnCompleteOutputConnector, NotificationChain msgs) {
		AggregateMediatorOnCompleteOutputConnector oldOnCompleteOutputConnector = onCompleteOutputConnector;
		onCompleteOutputConnector = newOnCompleteOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR, oldOnCompleteOutputConnector, newOnCompleteOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnCompleteOutputConnector(AggregateMediatorOnCompleteOutputConnector newOnCompleteOutputConnector) {
		if (newOnCompleteOutputConnector != onCompleteOutputConnector) {
			NotificationChain msgs = null;
			if (onCompleteOutputConnector != null)
				msgs = ((InternalEObject)onCompleteOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR, null, msgs);
			if (newOnCompleteOutputConnector != null)
				msgs = ((InternalEObject)newOnCompleteOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnCompleteOutputConnector(newOnCompleteOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR, newOnCompleteOutputConnector, newOnCompleteOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow getMediatorFlow() {
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediatorFlow(MediatorFlow newMediatorFlow, NotificationChain msgs) {
		MediatorFlow oldMediatorFlow = mediatorFlow;
		mediatorFlow = newMediatorFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediatorFlow(MediatorFlow newMediatorFlow) {
		if (newMediatorFlow != mediatorFlow) {
			NotificationChain msgs = null;
			if (mediatorFlow != null)
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getAggregationExpression() {
		return aggregationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregationExpression(NamespacedProperty newAggregationExpression, NotificationChain msgs) {
		NamespacedProperty oldAggregationExpression = aggregationExpression;
		aggregationExpression = newAggregationExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION, oldAggregationExpression, newAggregationExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationExpression(NamespacedProperty newAggregationExpression) {
		if (newAggregationExpression != aggregationExpression) {
			NotificationChain msgs = null;
			if (aggregationExpression != null)
				msgs = ((InternalEObject)aggregationExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION, null, msgs);
			if (newAggregationExpression != null)
				msgs = ((InternalEObject)newAggregationExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION, null, msgs);
			msgs = basicSetAggregationExpression(newAggregationExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION, newAggregationExpression, newAggregationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateSequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(AggregateSequenceType newSequenceType) {
		AggregateSequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceKey(RegistryKeyProperty newSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		if (newSequenceKey != sequenceKey) {
			NotificationChain msgs = null;
			if (sequenceKey != null)
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnclosingElementProperty() {
		return enclosingElementProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingElementProperty(String newEnclosingElementProperty) {
		String oldEnclosingElementProperty = enclosingElementProperty;
		enclosingElementProperty = newEnclosingElementProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY, oldEnclosingElementProperty, enclosingElementProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION:
				return basicSetCorrelationExpression(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION:
				return basicSetCompletionMinMessagesExpression(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION:
				return basicSetCompletionMaxMessagesExpression(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR:
				return basicSetOnCompleteOutputConnector(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION:
				return basicSetAggregationExpression(null, msgs);
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY:
				return basicSetSequenceKey(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATE_ID:
				return getAggregateID();
			case EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION:
				return getCorrelationExpression();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT:
				return getCompletionTimeout();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE:
				return getCompletionMinMessagesType();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE:
				return getCompletionMaxMessagesType();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE:
				return getCompletionMinMessagesValue();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION:
				return getCompletionMinMessagesExpression();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE:
				return getCompletionMaxMessagesValue();
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION:
				return getCompletionMaxMessagesExpression();
			case EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR:
				return getOnCompleteOutputConnector();
			case EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION:
				return getAggregationExpression();
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY:
				return getSequenceKey();
			case EsbPackage.AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY:
				return getEnclosingElementProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATE_ID:
				setAggregateID((String)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION:
				setCorrelationExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT:
				setCompletionTimeout((Long)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE:
				setCompletionMinMessagesType((CompletionMessagesType)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE:
				setCompletionMaxMessagesType((CompletionMessagesType)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE:
				setCompletionMinMessagesValue((Integer)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION:
				setCompletionMinMessagesExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE:
				setCompletionMaxMessagesValue((Integer)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION:
				setCompletionMaxMessagesExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((AggregateMediatorInputConnector)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((AggregateMediatorOutputConnector)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR:
				setOnCompleteOutputConnector((AggregateMediatorOnCompleteOutputConnector)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION:
				setAggregationExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType((AggregateSequenceType)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY:
				setEnclosingElementProperty((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATE_ID:
				setAggregateID(AGGREGATE_ID_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION:
				setCorrelationExpression((NamespacedProperty)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT:
				setCompletionTimeout(COMPLETION_TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE:
				setCompletionMinMessagesType(COMPLETION_MIN_MESSAGES_TYPE_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE:
				setCompletionMaxMessagesType(COMPLETION_MAX_MESSAGES_TYPE_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE:
				setCompletionMinMessagesValue(COMPLETION_MIN_MESSAGES_VALUE_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION:
				setCompletionMinMessagesExpression((NamespacedProperty)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE:
				setCompletionMaxMessagesValue(COMPLETION_MAX_MESSAGES_VALUE_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION:
				setCompletionMaxMessagesExpression((NamespacedProperty)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((AggregateMediatorInputConnector)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((AggregateMediatorOutputConnector)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR:
				setOnCompleteOutputConnector((AggregateMediatorOnCompleteOutputConnector)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION:
				setAggregationExpression((NamespacedProperty)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY:
				setEnclosingElementProperty(ENCLOSING_ELEMENT_PROPERTY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATE_ID:
				return AGGREGATE_ID_EDEFAULT == null ? aggregateID != null : !AGGREGATE_ID_EDEFAULT.equals(aggregateID);
			case EsbPackage.AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION:
				return correlationExpression != null;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT:
				return completionTimeout != COMPLETION_TIMEOUT_EDEFAULT;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE:
				return completionMinMessagesType != COMPLETION_MIN_MESSAGES_TYPE_EDEFAULT;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE:
				return completionMaxMessagesType != COMPLETION_MAX_MESSAGES_TYPE_EDEFAULT;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE:
				return completionMinMessagesValue != COMPLETION_MIN_MESSAGES_VALUE_EDEFAULT;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION:
				return completionMinMessagesExpression != null;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE:
				return completionMaxMessagesValue != COMPLETION_MAX_MESSAGES_VALUE_EDEFAULT;
			case EsbPackage.AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION:
				return completionMaxMessagesExpression != null;
			case EsbPackage.AGGREGATE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR:
				return onCompleteOutputConnector != null;
			case EsbPackage.AGGREGATE_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION:
				return aggregationExpression != null;
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.AGGREGATE_MEDIATOR__SEQUENCE_KEY:
				return sequenceKey != null;
			case EsbPackage.AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY:
				return ENCLOSING_ELEMENT_PROPERTY_EDEFAULT == null ? enclosingElementProperty != null : !ENCLOSING_ELEMENT_PROPERTY_EDEFAULT.equals(enclosingElementProperty);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (aggregateID: ");
		result.append(aggregateID);
		result.append(", completionTimeout: ");
		result.append(completionTimeout);
		result.append(", completionMinMessagesType: ");
		result.append(completionMinMessagesType);
		result.append(", completionMaxMessagesType: ");
		result.append(completionMaxMessagesType);
		result.append(", completionMinMessagesValue: ");
		result.append(completionMinMessagesValue);
		result.append(", completionMaxMessagesValue: ");
		result.append(completionMaxMessagesValue);
		result.append(", sequenceType: ");
		result.append(sequenceType);
		result.append(", enclosingElementProperty: ");
		result.append(enclosingElementProperty);
		result.append(')');
		return result.toString();
	}

} //AggregateMediatorImpl
