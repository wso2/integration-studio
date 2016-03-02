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
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ScopeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Header Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getHeaderName <em>Header Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getHeaderAction <em>Header Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.HeaderMediatorImpl#getValueInline <em>Value Inline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HeaderMediatorImpl extends MediatorImpl implements HeaderMediator {
	/**
	 * The cached value of the '{@link #getHeaderName() <em>Header Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderName()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty headerName;

	/**
	 * The default value of the '{@link #getHeaderAction() <em>Header Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderAction()
	 * @generated
	 * @ordered
	 */
	protected static final HeaderAction HEADER_ACTION_EDEFAULT = HeaderAction.SET;

	/**
	 * The cached value of the '{@link #getHeaderAction() <em>Header Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderAction()
	 * @generated
	 * @ordered
	 */
	protected HeaderAction headerAction = HEADER_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final HeaderValueType VALUE_TYPE_EDEFAULT = HeaderValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected HeaderValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeType SCOPE_EDEFAULT = ScopeType.DEFAULT;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeType scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_LITERAL_EDEFAULT = "header_value";

	/**
	 * The cached value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected String valueLiteral = VALUE_LITERAL_EDEFAULT;

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
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected HeaderMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected HeaderMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getValueInline() <em>Value Inline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueInline()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_INLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueInline() <em>Value Inline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueInline()
	 * @generated
	 * @ordered
	 */
	protected String valueInline = VALUE_INLINE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected HeaderMediatorImpl() {
		super();
		
		// Header name.
		NamespacedProperty headerName = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		headerName.setPrettyName("Header Name");
		headerName.setPropertyName("name");
		//Fixing TOOLS-2320
		//headerName.setPropertyValue("header_name");
		headerName.setPropertyValue("To");
		setHeaderName(headerName);

		// Value expression.
		NamespacedProperty valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		valueExpression.setPrettyName("Expression");
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
		return EsbPackage.Literals.HEADER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getHeaderName() {
		return headerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaderName(NamespacedProperty newHeaderName, NotificationChain msgs) {
		NamespacedProperty oldHeaderName = headerName;
		headerName = newHeaderName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__HEADER_NAME, oldHeaderName, newHeaderName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderName(NamespacedProperty newHeaderName) {
		if (newHeaderName != headerName) {
			NotificationChain msgs = null;
			if (headerName != null)
				msgs = ((InternalEObject)headerName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__HEADER_NAME, null, msgs);
			if (newHeaderName != null)
				msgs = ((InternalEObject)newHeaderName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__HEADER_NAME, null, msgs);
			msgs = basicSetHeaderName(newHeaderName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__HEADER_NAME, newHeaderName, newHeaderName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderAction getHeaderAction() {
		return headerAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderAction(HeaderAction newHeaderAction) {
		HeaderAction oldHeaderAction = headerAction;
		headerAction = newHeaderAction == null ? HEADER_ACTION_EDEFAULT : newHeaderAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__HEADER_ACTION, oldHeaderAction, headerAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(HeaderValueType newValueType) {
		HeaderValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(ScopeType newScope) {
		ScopeType oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueLiteral() {
		return valueLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueLiteral(String newValueLiteral) {
		String oldValueLiteral = valueLiteral;
		valueLiteral = newValueLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(HeaderMediatorInputConnector newInputConnector, NotificationChain msgs) {
		HeaderMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(HeaderMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(HeaderMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		HeaderMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(HeaderMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueInline() {
		return valueInline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueInline(String newValueInline) {
		String oldValueInline = valueInline;
		valueInline = newValueInline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.HEADER_MEDIATOR__VALUE_INLINE, oldValueInline, valueInline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.HEADER_MEDIATOR__HEADER_NAME:
				return basicSetHeaderName(null, msgs);
			case EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
			case EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
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
			case EsbPackage.HEADER_MEDIATOR__HEADER_NAME:
				return getHeaderName();
			case EsbPackage.HEADER_MEDIATOR__HEADER_ACTION:
				return getHeaderAction();
			case EsbPackage.HEADER_MEDIATOR__VALUE_TYPE:
				return getValueType();
			case EsbPackage.HEADER_MEDIATOR__SCOPE:
				return getScope();
			case EsbPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				return getValueLiteral();
			case EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				return getValueExpression();
			case EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.HEADER_MEDIATOR__VALUE_INLINE:
				return getValueInline();
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
			case EsbPackage.HEADER_MEDIATOR__HEADER_NAME:
				setHeaderName((NamespacedProperty)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__HEADER_ACTION:
				setHeaderAction((HeaderAction)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_TYPE:
				setValueType((HeaderValueType)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__SCOPE:
				setScope((ScopeType)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((HeaderMediatorInputConnector)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((HeaderMediatorOutputConnector)newValue);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_INLINE:
				setValueInline((String)newValue);
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
			case EsbPackage.HEADER_MEDIATOR__HEADER_NAME:
				setHeaderName((NamespacedProperty)null);
				return;
			case EsbPackage.HEADER_MEDIATOR__HEADER_ACTION:
				setHeaderAction(HEADER_ACTION_EDEFAULT);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.HEADER_MEDIATOR__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((HeaderMediatorInputConnector)null);
				return;
			case EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((HeaderMediatorOutputConnector)null);
				return;
			case EsbPackage.HEADER_MEDIATOR__VALUE_INLINE:
				setValueInline(VALUE_INLINE_EDEFAULT);
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
			case EsbPackage.HEADER_MEDIATOR__HEADER_NAME:
				return headerName != null;
			case EsbPackage.HEADER_MEDIATOR__HEADER_ACTION:
				return headerAction != HEADER_ACTION_EDEFAULT;
			case EsbPackage.HEADER_MEDIATOR__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case EsbPackage.HEADER_MEDIATOR__SCOPE:
				return scope != SCOPE_EDEFAULT;
			case EsbPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				return valueExpression != null;
			case EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.HEADER_MEDIATOR__VALUE_INLINE:
				return VALUE_INLINE_EDEFAULT == null ? valueInline != null : !VALUE_INLINE_EDEFAULT.equals(valueInline);
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
		result.append(" (headerAction: ");
		result.append(headerAction);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", scope: ");
		result.append(scope);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(", valueInline: ");
		result.append(valueInline);
		result.append(')');
		return result.toString();
	}

} //HeaderMediatorImpl
