/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getPropertyDataType <em>Property Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getPropertyAction <em>Property Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getPropertyScope <em>Property Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getNamespacePrefix <em>Namespace Prefix</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#isBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getOM <em>OM</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getValueStringPattern <em>Value String Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getValueStringCapturingGroup <em>Value String Capturing Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl#getNewPropertyName <em>New Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyMediatorImpl extends MediatorImpl implements PropertyMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected PropertyMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected PropertyMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyName PROPERTY_NAME_EDEFAULT = PropertyName.NEW_PROPERTY_NAME;

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected PropertyName propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyDataType() <em>Property Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDataType()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyDataType PROPERTY_DATA_TYPE_EDEFAULT = PropertyDataType.STRING;

	/**
	 * The cached value of the '{@link #getPropertyDataType() <em>Property Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDataType()
	 * @generated
	 * @ordered
	 */
	protected PropertyDataType propertyDataType = PROPERTY_DATA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyAction() <em>Property Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyAction()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyAction PROPERTY_ACTION_EDEFAULT = PropertyAction.SET;

	/**
	 * The cached value of the '{@link #getPropertyAction() <em>Property Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyAction()
	 * @generated
	 * @ordered
	 */
	protected PropertyAction propertyAction = PROPERTY_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyScope() <em>Property Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyScope()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyScope PROPERTY_SCOPE_EDEFAULT = PropertyScope.SYNAPSE;

	/**
	 * The cached value of the '{@link #getPropertyScope() <em>Property Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyScope()
	 * @generated
	 * @ordered
	 */
	protected PropertyScope propertyScope = PROPERTY_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyValueType VALUE_TYPE_EDEFAULT = PropertyValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected PropertyValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = "value";

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespacePrefix() <em>Namespace Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespacePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespacePrefix() <em>Namespace Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespacePrefix()
	 * @generated
	 * @ordered
	 */
	protected String namespacePrefix = NAMESPACE_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty valueExpression;

	/**
	 * The default value of the '{@link #isBoolean() <em>Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBoolean() <em>Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoolean()
	 * @generated
	 * @ordered
	 */
	protected boolean boolean_ = BOOLEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getOM() <em>OM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOM()
	 * @generated
	 * @ordered
	 */
	protected static final String OM_EDEFAULT = "<value/>";

	/**
	 * The cached value of the '{@link #getOM() <em>OM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOM()
	 * @generated
	 * @ordered
	 */
	protected String om = OM_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueStringPattern() <em>Value String Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueStringPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_STRING_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueStringPattern() <em>Value String Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueStringPattern()
	 * @generated
	 * @ordered
	 */
	protected String valueStringPattern = VALUE_STRING_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueStringCapturingGroup() <em>Value String Capturing Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueStringCapturingGroup()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_STRING_CAPTURING_GROUP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValueStringCapturingGroup() <em>Value String Capturing Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueStringCapturingGroup()
	 * @generated
	 * @ordered
	 */
	protected int valueStringCapturingGroup = VALUE_STRING_CAPTURING_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewPropertyName() <em>New Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_PROPERTY_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewPropertyName() <em>New Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String newPropertyName = NEW_PROPERTY_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PropertyMediatorImpl() {
		super();
		// Value expression.
		NamespacedProperty valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		valueExpression.setPrettyName("Property Expression");
		valueExpression.setPropertyName("expression");
		valueExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);		
		setValueExpression(valueExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROPERTY_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyName getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(PropertyName newPropertyName) {
		PropertyName oldPropertyName = propertyName;
		propertyName = newPropertyName == null ? PROPERTY_NAME_EDEFAULT : newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyDataType getPropertyDataType() {
		return propertyDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyDataType(PropertyDataType newPropertyDataType) {
		PropertyDataType oldPropertyDataType = propertyDataType;
		propertyDataType = newPropertyDataType == null ? PROPERTY_DATA_TYPE_EDEFAULT : newPropertyDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, oldPropertyDataType, propertyDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAction getPropertyAction() {
		return propertyAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyAction(PropertyAction newPropertyAction) {
		PropertyAction oldPropertyAction = propertyAction;
		propertyAction = newPropertyAction == null ? PROPERTY_ACTION_EDEFAULT : newPropertyAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION, oldPropertyAction, propertyAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyScope getPropertyScope() {
		return propertyScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyScope(PropertyScope newPropertyScope) {
		PropertyScope oldPropertyScope = propertyScope;
		propertyScope = newPropertyScope == null ? PROPERTY_SCOPE_EDEFAULT : newPropertyScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE, oldPropertyScope, propertyScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(PropertyValueType newValueType) {
		PropertyValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespacePrefix(String newNamespacePrefix) {
		String oldNamespacePrefix = namespacePrefix;
		namespacePrefix = newNamespacePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__NAMESPACE_PREFIX, oldNamespacePrefix, namespacePrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getValueExpression() {
		return valueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExpression(NamespacedProperty newValueExpression, NotificationChain msgs) {
		NamespacedProperty oldValueExpression = valueExpression;
		valueExpression = newValueExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueExpression(NamespacedProperty newValueExpression) {
		if (newValueExpression != valueExpression) {
			NotificationChain msgs = null;
			if (valueExpression != null)
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBoolean() {
		return boolean_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoolean(boolean newBoolean) {
		boolean oldBoolean = boolean_;
		boolean_ = newBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__BOOLEAN, oldBoolean, boolean_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOM() {
		return om;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOM(String newOM) {
		String oldOM = om;
		om = newOM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__OM, oldOM, om));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueStringPattern() {
		return valueStringPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueStringPattern(String newValueStringPattern) {
		String oldValueStringPattern = valueStringPattern;
		valueStringPattern = newValueStringPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN, oldValueStringPattern, valueStringPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValueStringCapturingGroup() {
		return valueStringCapturingGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueStringCapturingGroup(int newValueStringCapturingGroup) {
		int oldValueStringCapturingGroup = valueStringCapturingGroup;
		valueStringCapturingGroup = newValueStringCapturingGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP, oldValueStringCapturingGroup, valueStringCapturingGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewPropertyName() {
		return newPropertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewPropertyName(String newNewPropertyName) {
		String oldNewPropertyName = newPropertyName;
		newPropertyName = newNewPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME, oldNewPropertyName, newPropertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(PropertyMediatorInputConnector newInputConnector, NotificationChain msgs) {
		PropertyMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(PropertyMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(PropertyMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		PropertyMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(PropertyMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
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
			case EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				return getPropertyName();
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				return getPropertyDataType();
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				return getPropertyAction();
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				return getPropertyScope();
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				return getValueType();
			case EsbPackage.PROPERTY_MEDIATOR__VALUE:
				return getValue();
			case EsbPackage.PROPERTY_MEDIATOR__EXPRESSION:
				return getExpression();
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE_PREFIX:
				return getNamespacePrefix();
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE:
				return getNamespace();
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				return getValueExpression();
			case EsbPackage.PROPERTY_MEDIATOR__BOOLEAN:
				return isBoolean();
			case EsbPackage.PROPERTY_MEDIATOR__OM:
				return getOM();
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				return getValueStringPattern();
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				return getValueStringCapturingGroup();
			case EsbPackage.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME:
				return getNewPropertyName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((PropertyMediatorInputConnector)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((PropertyMediatorOutputConnector)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				setPropertyName((PropertyName)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				setPropertyDataType((PropertyDataType)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				setPropertyAction((PropertyAction)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				setPropertyScope((PropertyScope)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				setValueType((PropertyValueType)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE:
				setValue((String)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__EXPRESSION:
				setExpression((String)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE_PREFIX:
				setNamespacePrefix((String)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__BOOLEAN:
				setBoolean((Boolean)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__OM:
				setOM((String)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				setValueStringPattern((String)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				setValueStringCapturingGroup((Integer)newValue);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME:
				setNewPropertyName((String)newValue);
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
			case EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((PropertyMediatorInputConnector)null);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((PropertyMediatorOutputConnector)null);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				setPropertyDataType(PROPERTY_DATA_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				setPropertyAction(PROPERTY_ACTION_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				setPropertyScope(PROPERTY_SCOPE_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE_PREFIX:
				setNamespacePrefix(NAMESPACE_PREFIX_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__BOOLEAN:
				setBoolean(BOOLEAN_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__OM:
				setOM(OM_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				setValueStringPattern(VALUE_STRING_PATTERN_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				setValueStringCapturingGroup(VALUE_STRING_CAPTURING_GROUP_EDEFAULT);
				return;
			case EsbPackage.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME:
				setNewPropertyName(NEW_PROPERTY_NAME_EDEFAULT);
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
			case EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				return propertyName != PROPERTY_NAME_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				return propertyDataType != PROPERTY_DATA_TYPE_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				return propertyAction != PROPERTY_ACTION_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				return propertyScope != PROPERTY_SCOPE_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case EsbPackage.PROPERTY_MEDIATOR__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE_PREFIX:
				return NAMESPACE_PREFIX_EDEFAULT == null ? namespacePrefix != null : !NAMESPACE_PREFIX_EDEFAULT.equals(namespacePrefix);
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				return valueExpression != null;
			case EsbPackage.PROPERTY_MEDIATOR__BOOLEAN:
				return boolean_ != BOOLEAN_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__OM:
				return OM_EDEFAULT == null ? om != null : !OM_EDEFAULT.equals(om);
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				return VALUE_STRING_PATTERN_EDEFAULT == null ? valueStringPattern != null : !VALUE_STRING_PATTERN_EDEFAULT.equals(valueStringPattern);
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				return valueStringCapturingGroup != VALUE_STRING_CAPTURING_GROUP_EDEFAULT;
			case EsbPackage.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME:
				return NEW_PROPERTY_NAME_EDEFAULT == null ? newPropertyName != null : !NEW_PROPERTY_NAME_EDEFAULT.equals(newPropertyName);
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
		result.append(" (propertyName: ");
		result.append(propertyName);
		result.append(", propertyDataType: ");
		result.append(propertyDataType);
		result.append(", propertyAction: ");
		result.append(propertyAction);
		result.append(", propertyScope: ");
		result.append(propertyScope);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", value: ");
		result.append(value);
		result.append(", expression: ");
		result.append(expression);
		result.append(", namespacePrefix: ");
		result.append(namespacePrefix);
		result.append(", namespace: ");
		result.append(namespace);
		result.append(", boolean: ");
		result.append(boolean_);
		result.append(", OM: ");
		result.append(om);
		result.append(", valueStringPattern: ");
		result.append(valueStringPattern);
		result.append(", valueStringCapturingGroup: ");
		result.append(valueStringCapturingGroup);
		result.append(", newPropertyName: ");
		result.append(newPropertyName);
		result.append(')');
		return result.toString();
	}

} //PropertyMediatorImpl
