/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeType;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Name Value Expression Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueExpressionAttributeImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueExpressionAttributeImpl#getAttributeValueType <em>Attribute Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueExpressionAttributeImpl#getAttributeValue <em>Attribute Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueExpressionAttributeImpl#getAttributeType <em>Attribute Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueExpressionAttributeImpl#getAttributeExpression <em>Attribute Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractNameValueExpressionAttributeImpl extends EsbNodeImpl implements AbstractNameValueExpressionAttribute {
	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = "attribute_name";
	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getAttributeValueType() <em>Attribute Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeValueType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeValueType ATTRIBUTE_VALUE_TYPE_EDEFAULT = AttributeValueType.VALUE;
	/**
	 * The cached value of the '{@link #getAttributeValueType() <em>Attribute Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeValueType()
	 * @generated
	 * @ordered
	 */
	protected AttributeValueType attributeValueType = ATTRIBUTE_VALUE_TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getAttributeValue() <em>Attribute Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeValue()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_VALUE_EDEFAULT = "attribute_value";
	/**
	 * The cached value of the '{@link #getAttributeValue() <em>Attribute Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeValue()
	 * @generated
	 * @ordered
	 */
	protected String attributeValue = ATTRIBUTE_VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getAttributeType() <em>Attribute Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeType ATTRIBUTE_TYPE_EDEFAULT = AttributeType.STRING;
	/**
	 * The cached value of the '{@link #getAttributeType() <em>Attribute Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeType()
	 * @generated
	 * @ordered
	 */
	protected AttributeType attributeType = ATTRIBUTE_TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getAttributeExpression() <em>Attribute Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty attributeExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractNameValueExpressionAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueType getAttributeValueType() {
		return attributeValueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeValueType(AttributeValueType newAttributeValueType) {
		AttributeValueType oldAttributeValueType = attributeValueType;
		attributeValueType = newAttributeValueType == null ? ATTRIBUTE_VALUE_TYPE_EDEFAULT : newAttributeValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE, oldAttributeValueType, attributeValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeValue() {
		return attributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeValue(String newAttributeValue) {
		String oldAttributeValue = attributeValue;
		attributeValue = newAttributeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE, oldAttributeValue, attributeValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType getAttributeType() {
		return attributeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeType(AttributeType newAttributeType) {
		AttributeType oldAttributeType = attributeType;
		attributeType = newAttributeType == null ? ATTRIBUTE_TYPE_EDEFAULT : newAttributeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE, oldAttributeType, attributeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getAttributeExpression() {
		return attributeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeExpression(NamespacedProperty newAttributeExpression, NotificationChain msgs) {
		NamespacedProperty oldAttributeExpression = attributeExpression;
		attributeExpression = newAttributeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION, oldAttributeExpression, newAttributeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeExpression(NamespacedProperty newAttributeExpression) {
		if (newAttributeExpression != attributeExpression) {
			NotificationChain msgs = null;
			if (attributeExpression != null)
				msgs = ((InternalEObject)attributeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION, null, msgs);
			if (newAttributeExpression != null)
				msgs = ((InternalEObject)newAttributeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION, null, msgs);
			msgs = basicSetAttributeExpression(newAttributeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION, newAttributeExpression, newAttributeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION:
				return basicSetAttributeExpression(null, msgs);
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME:
				return getAttributeName();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE:
				return getAttributeValueType();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE:
				return getAttributeValue();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE:
				return getAttributeType();
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION:
				return getAttributeExpression();
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE:
				setAttributeValueType((AttributeValueType)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE:
				setAttributeValue((String)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE:
				setAttributeType((AttributeType)newValue);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION:
				setAttributeExpression((NamespacedProperty)newValue);
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE:
				setAttributeValueType(ATTRIBUTE_VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE:
				setAttributeValue(ATTRIBUTE_VALUE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE:
				setAttributeType(ATTRIBUTE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION:
				setAttributeExpression((NamespacedProperty)null);
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
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE:
				return attributeValueType != ATTRIBUTE_VALUE_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE:
				return ATTRIBUTE_VALUE_EDEFAULT == null ? attributeValue != null : !ATTRIBUTE_VALUE_EDEFAULT.equals(attributeValue);
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE:
				return attributeType != ATTRIBUTE_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION:
				return attributeExpression != null;
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
		result.append(" (attributeName: ");
		result.append(attributeName);
		result.append(", attributeValueType: ");
		result.append(attributeValueType);
		result.append(", attributeValue: ");
		result.append(attributeValue);
		result.append(", attributeType: ");
		result.append(attributeType);
		result.append(')');
		return result.toString();
	}

} //AbstractNameValueExpressionAttributeImpl
