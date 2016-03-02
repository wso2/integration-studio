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
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Fact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getFactType <em>Fact Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getFactCustomType <em>Fact Custom Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getFactName <em>Fact Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactImpl#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleFactImpl extends EObjectImpl implements RuleFact {
	/**
	 * The default value of the '{@link #getFactType() <em>Fact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactType()
	 * @generated
	 * @ordered
	 */
	protected static final RuleFactType FACT_TYPE_EDEFAULT = RuleFactType.CUSTOM;

	/**
	 * The cached value of the '{@link #getFactType() <em>Fact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactType()
	 * @generated
	 * @ordered
	 */
	protected RuleFactType factType = FACT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFactCustomType() <em>Fact Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactCustomType()
	 * @generated
	 * @ordered
	 */
	protected static final String FACT_CUSTOM_TYPE_EDEFAULT = "custom_type";

	/**
	 * The cached value of the '{@link #getFactCustomType() <em>Fact Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactCustomType()
	 * @generated
	 * @ordered
	 */
	protected String factCustomType = FACT_CUSTOM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFactName() <em>Fact Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactName()
	 * @generated
	 * @ordered
	 */
	protected static final String FACT_NAME_EDEFAULT = "fact_name";

	/**
	 * The cached value of the '{@link #getFactName() <em>Fact Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactName()
	 * @generated
	 * @ordered
	 */
	protected String factName = FACT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final RuleFactValueType VALUE_TYPE_EDEFAULT = RuleFactValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected RuleFactValueType valueType = VALUE_TYPE_EDEFAULT;

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
	protected RuleFactImpl() {
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
		return EsbPackage.Literals.RULE_FACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFactType getFactType() {
		return factType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactType(RuleFactType newFactType) {
		RuleFactType oldFactType = factType;
		factType = newFactType == null ? FACT_TYPE_EDEFAULT : newFactType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__FACT_TYPE, oldFactType, factType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactCustomType() {
		return factCustomType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactCustomType(String newFactCustomType) {
		String oldFactCustomType = factCustomType;
		factCustomType = newFactCustomType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__FACT_CUSTOM_TYPE, oldFactCustomType, factCustomType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactName() {
		return factName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactName(String newFactName) {
		String oldFactName = factName;
		factName = newFactName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__FACT_NAME, oldFactName, factName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFactValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(RuleFactValueType newValueType) {
		RuleFactValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_FACT__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_FACT__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__VALUE_EXPRESSION, newValueExpression, newValueExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__VALUE_KEY, oldValueKey, newValueKey);
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
				msgs = ((InternalEObject)valueKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_FACT__VALUE_KEY, null, msgs);
			if (newValueKey != null)
				msgs = ((InternalEObject)newValueKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RULE_FACT__VALUE_KEY, null, msgs);
			msgs = basicSetValueKey(newValueKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RULE_FACT__VALUE_KEY, newValueKey, newValueKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.RULE_FACT__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
			case EsbPackage.RULE_FACT__VALUE_KEY:
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
			case EsbPackage.RULE_FACT__FACT_TYPE:
				return getFactType();
			case EsbPackage.RULE_FACT__FACT_CUSTOM_TYPE:
				return getFactCustomType();
			case EsbPackage.RULE_FACT__FACT_NAME:
				return getFactName();
			case EsbPackage.RULE_FACT__VALUE_TYPE:
				return getValueType();
			case EsbPackage.RULE_FACT__VALUE_LITERAL:
				return getValueLiteral();
			case EsbPackage.RULE_FACT__VALUE_EXPRESSION:
				return getValueExpression();
			case EsbPackage.RULE_FACT__VALUE_KEY:
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
			case EsbPackage.RULE_FACT__FACT_TYPE:
				setFactType((RuleFactType)newValue);
				return;
			case EsbPackage.RULE_FACT__FACT_CUSTOM_TYPE:
				setFactCustomType((String)newValue);
				return;
			case EsbPackage.RULE_FACT__FACT_NAME:
				setFactName((String)newValue);
				return;
			case EsbPackage.RULE_FACT__VALUE_TYPE:
				setValueType((RuleFactValueType)newValue);
				return;
			case EsbPackage.RULE_FACT__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case EsbPackage.RULE_FACT__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.RULE_FACT__VALUE_KEY:
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
			case EsbPackage.RULE_FACT__FACT_TYPE:
				setFactType(FACT_TYPE_EDEFAULT);
				return;
			case EsbPackage.RULE_FACT__FACT_CUSTOM_TYPE:
				setFactCustomType(FACT_CUSTOM_TYPE_EDEFAULT);
				return;
			case EsbPackage.RULE_FACT__FACT_NAME:
				setFactName(FACT_NAME_EDEFAULT);
				return;
			case EsbPackage.RULE_FACT__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.RULE_FACT__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case EsbPackage.RULE_FACT__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case EsbPackage.RULE_FACT__VALUE_KEY:
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
			case EsbPackage.RULE_FACT__FACT_TYPE:
				return factType != FACT_TYPE_EDEFAULT;
			case EsbPackage.RULE_FACT__FACT_CUSTOM_TYPE:
				return FACT_CUSTOM_TYPE_EDEFAULT == null ? factCustomType != null : !FACT_CUSTOM_TYPE_EDEFAULT.equals(factCustomType);
			case EsbPackage.RULE_FACT__FACT_NAME:
				return FACT_NAME_EDEFAULT == null ? factName != null : !FACT_NAME_EDEFAULT.equals(factName);
			case EsbPackage.RULE_FACT__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case EsbPackage.RULE_FACT__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case EsbPackage.RULE_FACT__VALUE_EXPRESSION:
				return valueExpression != null;
			case EsbPackage.RULE_FACT__VALUE_KEY:
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
		result.append(" (factType: ");
		result.append(factType);
		result.append(", factCustomType: ");
		result.append(factCustomType);
		result.append(", factName: ");
		result.append(factName);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(')');
		return result.toString();
	}

} //RuleFactImpl
