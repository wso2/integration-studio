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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Name Value Expression Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractNameValueExpressionPropertyImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractNameValueExpressionPropertyImpl#getPropertyValueType <em>Property Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractNameValueExpressionPropertyImpl#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractNameValueExpressionPropertyImpl#getPropertyExpression <em>Property Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractNameValueExpressionPropertyImpl extends ModelObjectImpl implements AbstractNameValueExpressionProperty {
	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = "property_name";

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyValueType() <em>Property Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValueType()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyValueType PROPERTY_VALUE_TYPE_EDEFAULT = PropertyValueType.VALUE;

	/**
	 * The cached value of the '{@link #getPropertyValueType() <em>Property Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValueType()
	 * @generated
	 * @ordered
	 */
	protected PropertyValueType propertyValueType = PROPERTY_VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyValue() <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_VALUE_EDEFAULT = "property_value";

	/**
	 * The cached value of the '{@link #getPropertyValue() <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected String propertyValue = PROPERTY_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyExpression() <em>Property Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty propertyExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractNameValueExpressionPropertyImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		// Extract name.
		if (self.hasAttribute("name")) {
			setPropertyName(self.getAttribute("name"));
		} else {
			throw new Exception("Expected property name.");
		}		
		
		// Extract value.
		if (self.hasAttribute("value")) {
			setPropertyValueType(PropertyValueType.VALUE);
	    	setPropertyValue(self.getAttribute("value"));
	    } else if (self.hasAttribute("expression")) {
	    	setPropertyValueType(PropertyValueType.EXPRESSION);
	    	getPropertyExpression().load(self);	    	
	    } else {
	    	throw new Exception("Expected value or expression attribute.");
	    }
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "property");
		self.setAttribute("name", getPropertyName());
		if (getPropertyValueType().equals(PropertyValueType.VALUE)) {
			self.setAttribute("value", getPropertyValue());	
		} else {
			getPropertyExpression().save(self);
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
		return EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueType getPropertyValueType() {
		return propertyValueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyValueType(PropertyValueType newPropertyValueType) {
		PropertyValueType oldPropertyValueType = propertyValueType;
		propertyValueType = newPropertyValueType == null ? PROPERTY_VALUE_TYPE_EDEFAULT : newPropertyValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE, oldPropertyValueType, propertyValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyValue(String newPropertyValue) {
		String oldPropertyValue = propertyValue;
		propertyValue = newPropertyValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE, oldPropertyValue, propertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getPropertyExpression() {
		return propertyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyExpression(NamespacedProperty newPropertyExpression, NotificationChain msgs) {
		NamespacedProperty oldPropertyExpression = propertyExpression;
		propertyExpression = newPropertyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION, oldPropertyExpression, newPropertyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyExpression(NamespacedProperty newPropertyExpression) {
		if (newPropertyExpression != propertyExpression) {
			NotificationChain msgs = null;
			if (propertyExpression != null)
				msgs = ((InternalEObject)propertyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION, null, msgs);
			if (newPropertyExpression != null)
				msgs = ((InternalEObject)newPropertyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION, null, msgs);
			msgs = basicSetPropertyExpression(newPropertyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION, newPropertyExpression, newPropertyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION:
				return basicSetPropertyExpression(null, msgs);
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME:
				return getPropertyName();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE:
				return getPropertyValueType();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE:
				return getPropertyValue();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION:
				return getPropertyExpression();
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE:
				setPropertyValueType((PropertyValueType)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE:
				setPropertyValue((String)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION:
				setPropertyExpression((NamespacedProperty)newValue);
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE:
				setPropertyValueType(PROPERTY_VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE:
				setPropertyValue(PROPERTY_VALUE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION:
				setPropertyExpression((NamespacedProperty)null);
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE:
				return propertyValueType != PROPERTY_VALUE_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE:
				return PROPERTY_VALUE_EDEFAULT == null ? propertyValue != null : !PROPERTY_VALUE_EDEFAULT.equals(propertyValue);
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION:
				return propertyExpression != null;
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
		result.append(", propertyValueType: ");
		result.append(propertyValueType);
		result.append(", propertyValue: ");
		result.append(propertyValue);
		result.append(')');
		return result.toString();
	}
	
	@Override
    public Map<String, ObjectValidator> validate() {
		ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
    	if(null==getPropertyName() || getPropertyName().trim().isEmpty()){
    		validateMap.put("Property Name", "Property Name is empty");
    	}
		if (getPropertyValueType().equals(PropertyValueType.VALUE)) {	
			if(null==getPropertyValue() || getPropertyValue().trim().isEmpty()){
	    		validateMap.put("Property Value", "Property Value is empty");
	    	}
		} else {
			if(null==getPropertyExpression().getPropertyValue() || getPropertyExpression().getPropertyValue().trim().isEmpty()){
	    		validateMap.put("Property Expression", "Expression is empty");
	    	}
		}
	    
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Name Value Expression", objectValidator);
	    return mediatorValidateMap;
    }

} //AbstractNameValueExpressionPropertyImpl
