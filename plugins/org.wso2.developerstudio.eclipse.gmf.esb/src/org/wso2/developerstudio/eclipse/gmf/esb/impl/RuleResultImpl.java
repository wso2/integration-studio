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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getResultCustomType <em>Result Custom Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getResultName <em>Result Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleResultImpl#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleResultImpl extends EObjectImpl implements RuleResult {
	/**
	 * The default value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected static final RuleResultType RESULT_TYPE_EDEFAULT = RuleResultType.CUSTOM;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected RuleResultType resultType = RESULT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultCustomType() <em>Result Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultCustomType()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_CUSTOM_TYPE_EDEFAULT = "custom_type";

	/**
	 * The cached value of the '{@link #getResultCustomType() <em>Result Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultCustomType()
	 * @generated
	 * @ordered
	 */
	protected String resultCustomType = RESULT_CUSTOM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultName() <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_NAME_EDEFAULT = "result_name";

	/**
	 * The cached value of the '{@link #getResultName() <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultName()
	 * @generated
	 * @ordered
	 */
	protected String resultName = RESULT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final RuleResultValueType VALUE_TYPE_EDEFAULT = RuleResultValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected RuleResultValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_LITERAL_EDEFAULT = "value";

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
	 * The cached value of the '{@link #getValueKey() <em>Value Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty valueKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RuleResultImpl() {
		super();
		NamespacedProperty valueExpression = EsbFactory.eINSTANCE.createNamespacedProperty();
		valueExpression.setPropertyName("expression");
		valueExpression.setPrettyName("expression");
		valueExpression.setPropertyValue("/default/expression");
		setValueExpression(valueExpression);
		
		RegistryKeyProperty valueKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		valueKey.setKeyName("valueKey");
		valueKey.setPrettyName("valueKey");
		valueKey.setKeyValue("/default/key");
		setValueKey(valueKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.RULE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResultType getResultType() {
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(RuleResultType newResultType) {
		RuleResultType oldResultType = resultType;
		resultType = newResultType == null ? RESULT_TYPE_EDEFAULT : newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__RESULT_TYPE, oldResultType, resultType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultCustomType() {
		return resultCustomType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultCustomType(String newResultCustomType) {
		String oldResultCustomType = resultCustomType;
		resultCustomType = newResultCustomType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__RESULT_CUSTOM_TYPE, oldResultCustomType, resultCustomType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultName() {
		return resultName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultName(String newResultName) {
		String oldResultName = resultName;
		resultName = newResultName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__RESULT_NAME, oldResultName, resultName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResultValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(RuleResultValueType newValueType) {
		RuleResultValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_RESULT__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_RESULT__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getValueKey() {
		return valueKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueKey(RegistryKeyProperty newValueKey, NotificationChain msgs) {
		RegistryKeyProperty oldValueKey = valueKey;
		valueKey = newValueKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__VALUE_KEY, oldValueKey, newValueKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueKey(RegistryKeyProperty newValueKey) {
		if (newValueKey != valueKey) {
			NotificationChain msgs = null;
			if (valueKey != null)
				msgs = ((InternalEObject)valueKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_RESULT__VALUE_KEY, null, msgs);
			if (newValueKey != null)
				msgs = ((InternalEObject)newValueKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_RESULT__VALUE_KEY, null, msgs);
			msgs = basicSetValueKey(newValueKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_RESULT__VALUE_KEY, newValueKey, newValueKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.RULE_RESULT__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
			case EsbPackage.RULE_RESULT__VALUE_KEY:
				return basicSetValueKey(null, msgs);
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
			case EsbPackage.RULE_RESULT__RESULT_TYPE:
				return getResultType();
			case EsbPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				return getResultCustomType();
			case EsbPackage.RULE_RESULT__RESULT_NAME:
				return getResultName();
			case EsbPackage.RULE_RESULT__VALUE_TYPE:
				return getValueType();
			case EsbPackage.RULE_RESULT__VALUE_LITERAL:
				return getValueLiteral();
			case EsbPackage.RULE_RESULT__VALUE_EXPRESSION:
				return getValueExpression();
			case EsbPackage.RULE_RESULT__VALUE_KEY:
				return getValueKey();
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
			case EsbPackage.RULE_RESULT__RESULT_TYPE:
				setResultType((RuleResultType)newValue);
				return;
			case EsbPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				setResultCustomType((String)newValue);
				return;
			case EsbPackage.RULE_RESULT__RESULT_NAME:
				setResultName((String)newValue);
				return;
			case EsbPackage.RULE_RESULT__VALUE_TYPE:
				setValueType((RuleResultValueType)newValue);
				return;
			case EsbPackage.RULE_RESULT__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case EsbPackage.RULE_RESULT__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.RULE_RESULT__VALUE_KEY:
				setValueKey((RegistryKeyProperty)newValue);
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
			case EsbPackage.RULE_RESULT__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
				return;
			case EsbPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				setResultCustomType(RESULT_CUSTOM_TYPE_EDEFAULT);
				return;
			case EsbPackage.RULE_RESULT__RESULT_NAME:
				setResultName(RESULT_NAME_EDEFAULT);
				return;
			case EsbPackage.RULE_RESULT__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.RULE_RESULT__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case EsbPackage.RULE_RESULT__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case EsbPackage.RULE_RESULT__VALUE_KEY:
				setValueKey((RegistryKeyProperty)null);
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
			case EsbPackage.RULE_RESULT__RESULT_TYPE:
				return resultType != RESULT_TYPE_EDEFAULT;
			case EsbPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				return RESULT_CUSTOM_TYPE_EDEFAULT == null ? resultCustomType != null : !RESULT_CUSTOM_TYPE_EDEFAULT.equals(resultCustomType);
			case EsbPackage.RULE_RESULT__RESULT_NAME:
				return RESULT_NAME_EDEFAULT == null ? resultName != null : !RESULT_NAME_EDEFAULT.equals(resultName);
			case EsbPackage.RULE_RESULT__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case EsbPackage.RULE_RESULT__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case EsbPackage.RULE_RESULT__VALUE_EXPRESSION:
				return valueExpression != null;
			case EsbPackage.RULE_RESULT__VALUE_KEY:
				return valueKey != null;
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
		result.append(" (resultType: ");
		result.append(resultType);
		result.append(", resultCustomType: ");
		result.append(resultCustomType);
		result.append(", resultName: ");
		result.append(resultName);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(')');
		return result.toString();
	}

} //RuleResultImpl
