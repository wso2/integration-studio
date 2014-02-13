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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XQuery Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl#getVariableType <em>Variable Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XQueryVariableImpl extends ModelObjectImpl implements XQueryVariable {
	/**
	 * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_NAME_EDEFAULT = "variable_name";

	/**
	 * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected String variableName = VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariableType() <em>Variable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableType()
	 * @generated
	 * @ordered
	 */
	protected static final XQueryVariableType VARIABLE_TYPE_EDEFAULT = XQueryVariableType.STRING;

	/**
	 * The cached value of the '{@link #getVariableType() <em>Variable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableType()
	 * @generated
	 * @ordered
	 */
	protected XQueryVariableType variableType = VARIABLE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final XQueryVariableValueType VALUE_TYPE_EDEFAULT = XQueryVariableValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected XQueryVariableValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_LITERAL_EDEFAULT = "literal_value";

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
	protected XQueryVariableImpl() {
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
		setValueKey(valueKey);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Variable name.
		if (self.hasAttribute("name")) {
			setVariableName(self.getAttribute("name"));
		} else {
			throw new Exception("An xquery variable must have a name.");
		}
		
		// Variable type.
		XQueryVariableType variableType = null;
		if (self.hasAttribute("type")) {
			variableType = XQueryVariableType.get(self.getAttribute("type"));
		}
		
		if (null != variableType) {
			setVariableType(variableType);
		} else {
			throw new Exception("Missing or un-known variable type.");
		}
		
		// Variable value.
		if (self.hasAttribute("value")) {
			setValueType(XQueryVariableValueType.LITERAL);
			setValueLiteral(self.getAttribute("value"));
		} else {
			setValueType(XQueryVariableValueType.EXPRESSION);
			if (self.hasAttribute("expression")) {
				getValueExpression().load(self);
			}
			
			if (self.hasAttribute("key")) {
				getValueKey().load(self);
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "variable");
		
		// Variable name.
		self.setAttribute("name", getVariableName());
		
		// Variable type.
		self.setAttribute("type", getVariableType().getLiteral());
		
		// Variable value.
		if (getValueType().equals(XQueryVariableValueType.LITERAL)) {
			self.setAttribute("value", getValueLiteral());
		} else {
			if (!StringUtils.isBlank(getValueExpression().getPropertyValue())) {
				getValueExpression().save(self);
			}
			
			if (!StringUtils.isBlank(getValueKey().getKeyValue())) {
				getValueKey().save(self);
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
		return MediatorsPackage.Literals.XQUERY_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableName() {
		return variableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableName(String newVariableName) {
		String oldVariableName = variableName;
		variableName = newVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VARIABLE_NAME, oldVariableName, variableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryVariableType getVariableType() {
		return variableType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableType(XQueryVariableType newVariableType) {
		XQueryVariableType oldVariableType = variableType;
		variableType = newVariableType == null ? VARIABLE_TYPE_EDEFAULT : newVariableType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VARIABLE_TYPE, oldVariableType, variableType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryVariableValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(XQueryVariableValueType newValueType) {
		XQueryVariableValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION, newValueExpression, newValueExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY, oldValueKey, newValueKey);
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
				msgs = ((InternalEObject)valueKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY, null, msgs);
			if (newValueKey != null)
				msgs = ((InternalEObject)newValueKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY, null, msgs);
			msgs = basicSetValueKey(newValueKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY, newValueKey, newValueKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY:
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
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_NAME:
				return getVariableName();
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_TYPE:
				return getVariableType();
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_TYPE:
				return getValueType();
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_LITERAL:
				return getValueLiteral();
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION:
				return getValueExpression();
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY:
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
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_NAME:
				setVariableName((String)newValue);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_TYPE:
				setVariableType((XQueryVariableType)newValue);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_TYPE:
				setValueType((XQueryVariableValueType)newValue);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY:
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
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_NAME:
				setVariableName(VARIABLE_NAME_EDEFAULT);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_TYPE:
				setVariableType(VARIABLE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY:
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
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_NAME:
				return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
			case MediatorsPackage.XQUERY_VARIABLE__VARIABLE_TYPE:
				return variableType != VARIABLE_TYPE_EDEFAULT;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_EXPRESSION:
				return valueExpression != null;
			case MediatorsPackage.XQUERY_VARIABLE__VALUE_KEY:
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
		result.append(" (variableName: ");
		result.append(variableName);
		result.append(", variableType: ");
		result.append(variableType);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getVariableName() || getVariableName().trim().isEmpty()) {
			validateMap.put("VariableName","Variable Name is empty");
		}
		
		if (getValueType().equals(XQueryVariableValueType.LITERAL)) {
			if (null == getValueLiteral() || getValueLiteral().trim().isEmpty()) {
				validateMap.put("VariableValue","Variable Value is empty");
			}
		} 
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("XQuery Mediator - Variable", objectValidator);
	    return mediatorValidateMap;
    }

} //XQueryVariableImpl
