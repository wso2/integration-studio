/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResult;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getResultCustomType <em>Result Custom Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getResultName <em>Result Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleResultImpl extends ModelObjectImpl implements RuleResult {
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
	 */
	protected RuleResultImpl() {
		super();
		
		// Value expression.
		NamespacedProperty valueExpression = getEsbFactory().createNamespacedProperty();
		valueExpression.setPrettyName("Value Expression");
		valueExpression.setPropertyName("expression");
		valueExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setValueExpression(valueExpression);
		
		// Value key.
		RegistryKeyProperty valueKey = getEsbFactory().createRegistryKeyProperty();
		valueKey.setPrettyName("Value Key");
		valueKey.setKeyName("key");
		valueKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setValueKey(valueKey);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("name")) {
			setResultName(self.getAttribute("name"));
		} else {
			throw new Exception("Expected name attribute.");
		}
		
		RuleResultType resultType = RuleResultType.get(self.getAttribute("type"));
		if (null != resultType) {
			setResultType(resultType);
		} else {
			setResultType(RuleResultType.CUSTOM);
			setResultCustomType(self.getAttribute("type"));
		}
		
		if (self.hasAttribute("value")) {
			setValueType(RuleResultValueType.LITERAL);
			setValueLiteral(self.getAttribute("value"));
		} else if (self.hasAttribute("expression")) {
			setValueType(RuleResultValueType.EXPRESSION);
			getValueExpression().load(self);
		} else if (self.hasAttribute("key")) {
			setValueType(RuleResultValueType.REGISTRY_REFERENCE);
			getValueKey().load(self);
		} else {
			throw new Exception("Unknown rule result definition.");
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "result");
		
		self.setAttribute("name", getResultName());
		
		if (!getResultType().equals(RuleResultType.CUSTOM)) {
			self.setAttribute("type", getResultType().toString());
		} else {
			self.setAttribute("type", getResultCustomType());
		}
		
		switch (getValueType()) {
			case LITERAL: {
				self.setAttribute("value", getValueLiteral());
				break;
			}
			
			case EXPRESSION: {
				getValueExpression().save(self);
				break;
			}
			
			case REGISTRY_REFERENCE: {
				getValueKey().save(self);
				break;
			}
		}
		
		addComments(self);
		return self;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.RULE_RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__RESULT_TYPE, oldResultType, resultType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__RESULT_CUSTOM_TYPE, oldResultCustomType, resultCustomType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__RESULT_NAME, oldResultName, resultName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION, newValueExpression, newValueExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__VALUE_KEY, oldValueKey, newValueKey);
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
				msgs = ((InternalEObject)valueKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_RESULT__VALUE_KEY, null, msgs);
			if (newValueKey != null)
				msgs = ((InternalEObject)newValueKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_RESULT__VALUE_KEY, null, msgs);
			msgs = basicSetValueKey(newValueKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_RESULT__VALUE_KEY, newValueKey, newValueKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
			case MediatorsPackage.RULE_RESULT__VALUE_KEY:
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
			case MediatorsPackage.RULE_RESULT__RESULT_TYPE:
				return getResultType();
			case MediatorsPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				return getResultCustomType();
			case MediatorsPackage.RULE_RESULT__RESULT_NAME:
				return getResultName();
			case MediatorsPackage.RULE_RESULT__VALUE_TYPE:
				return getValueType();
			case MediatorsPackage.RULE_RESULT__VALUE_LITERAL:
				return getValueLiteral();
			case MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION:
				return getValueExpression();
			case MediatorsPackage.RULE_RESULT__VALUE_KEY:
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
			case MediatorsPackage.RULE_RESULT__RESULT_TYPE:
				setResultType((RuleResultType)newValue);
				return;
			case MediatorsPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				setResultCustomType((String)newValue);
				return;
			case MediatorsPackage.RULE_RESULT__RESULT_NAME:
				setResultName((String)newValue);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_TYPE:
				setValueType((RuleResultValueType)newValue);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_KEY:
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
			case MediatorsPackage.RULE_RESULT__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				setResultCustomType(RESULT_CUSTOM_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.RULE_RESULT__RESULT_NAME:
				setResultName(RESULT_NAME_EDEFAULT);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.RULE_RESULT__VALUE_KEY:
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
			case MediatorsPackage.RULE_RESULT__RESULT_TYPE:
				return resultType != RESULT_TYPE_EDEFAULT;
			case MediatorsPackage.RULE_RESULT__RESULT_CUSTOM_TYPE:
				return RESULT_CUSTOM_TYPE_EDEFAULT == null ? resultCustomType != null : !RESULT_CUSTOM_TYPE_EDEFAULT.equals(resultCustomType);
			case MediatorsPackage.RULE_RESULT__RESULT_NAME:
				return RESULT_NAME_EDEFAULT == null ? resultName != null : !RESULT_NAME_EDEFAULT.equals(resultName);
			case MediatorsPackage.RULE_RESULT__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case MediatorsPackage.RULE_RESULT__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case MediatorsPackage.RULE_RESULT__VALUE_EXPRESSION:
				return valueExpression != null;
			case MediatorsPackage.RULE_RESULT__VALUE_KEY:
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

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //RuleResultImpl
