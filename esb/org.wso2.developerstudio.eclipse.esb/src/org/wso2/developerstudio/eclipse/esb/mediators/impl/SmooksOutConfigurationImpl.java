/**
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
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smooks Out Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl#getOutputMethod <em>Output Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmooksOutConfigurationImpl extends ModelObjectImpl implements SmooksOutConfiguration {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SmooksIODataType TYPE_EDEFAULT = SmooksIODataType.XML;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SmooksIODataType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty expression;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @!generated
	 * @ordered
	 */
	protected static final String PROPERTY_EDEFAULT = "smooksOutputProperty";

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected String property = PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final ExpressionAction ACTION_EDEFAULT = ExpressionAction.ADD;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected ExpressionAction action = ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputMethod() <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMethod()
	 * @generated
	 * @ordered
	 */
	protected static final OutputMethod OUTPUT_METHOD_EDEFAULT = OutputMethod.DEFAULT;

	/**
	 * The cached value of the '{@link #getOutputMethod() <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMethod()
	 * @generated
	 * @ordered
	 */
	protected OutputMethod outputMethod = OUTPUT_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @!generated
	 */
	protected SmooksOutConfigurationImpl() {
		super();
		// Property expression.
		NamespacedProperty expression = getEsbFactory().createNamespacedProperty();
		expression.setPrettyName("Expression");
		expression.setPropertyName("expression");
		expression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setExpression(expression);
		
		//Property value
		setProperty(PROPERTY_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.SMOOKS_OUT_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksIODataType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SmooksIODataType newType) {
		SmooksIODataType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_OUT_CONFIGURATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getExpression() {
		if (expression != null && expression.eIsProxy()) {
			InternalEObject oldExpression = (InternalEObject)expression;
			expression = (NamespacedProperty)eResolveProxy(oldExpression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.SMOOKS_OUT_CONFIGURATION__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(NamespacedProperty newExpression) {
		NamespacedProperty oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_OUT_CONFIGURATION__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(String newProperty) {
		String oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_OUT_CONFIGURATION__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAction getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(ExpressionAction newAction) {
		ExpressionAction oldAction = action;
		action = newAction == null ? ACTION_EDEFAULT : newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_OUT_CONFIGURATION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputMethod getOutputMethod() {
		return outputMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputMethod(OutputMethod newOutputMethod) {
		OutputMethod oldOutputMethod = outputMethod;
		outputMethod = newOutputMethod == null ? OUTPUT_METHOD_EDEFAULT : newOutputMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD, oldOutputMethod, outputMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__TYPE:
				return getType();
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__PROPERTY:
				return getProperty();
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__ACTION:
				return getAction();
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD:
				return getOutputMethod();
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
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__TYPE:
				setType((SmooksIODataType)newValue);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__EXPRESSION:
				setExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__PROPERTY:
				setProperty((String)newValue);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__ACTION:
				setAction((ExpressionAction)newValue);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD:
				setOutputMethod((OutputMethod)newValue);
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
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__EXPRESSION:
				setExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD:
				setOutputMethod(OUTPUT_METHOD_EDEFAULT);
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
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__TYPE:
				return type != TYPE_EDEFAULT;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__EXPRESSION:
				return expression != null;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__PROPERTY:
				return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__ACTION:
				return action != ACTION_EDEFAULT;
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD:
				return outputMethod != OUTPUT_METHOD_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", property: ");
		result.append(property);
		result.append(", action: ");
		result.append(action);
		result.append(", outputMethod: ");
		result.append(outputMethod);
		result.append(')');
		return result.toString();
	}

	
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("type")) {
			String typeAttribute = self.getAttribute("type");
			setType(typeAttribute.equalsIgnoreCase("text") ? SmooksIODataType.TEXT
					: SmooksIODataType.XML);
		}
		if (self.hasAttribute("expression")) {
			String expressionAttribute = self.getAttribute("expression");
			getExpression().setPropertyValue(expressionAttribute);
			if (self.hasAttribute("action")) {
				String actionAttribute = self.getAttribute("action");
				setAction(ExpressionAction.getByName(actionAttribute));
			}
			setOutputMethod(OutputMethod.EXPRESSION);
		}else if (self.hasAttribute("property")){
			String propertyAttribute = self.getAttribute("property");
			setProperty(propertyAttribute);
			setOutputMethod(OutputMethod.PROPERTY);
		}
		super.doLoad(self);
	}

	
	protected Element doSave(Element parent) throws Exception {
		Element self =  createChildElement(parent, "output");
		self.setAttribute("type", getType().toString().toLowerCase());
		switch(getOutputMethod()){
			case EXPRESSION:
				self.setAttribute("expression", getExpression().getPropertyValue());
				self.setAttribute("action", getAction().toString().toLowerCase());
				break;
			case PROPERTY:
				self.setAttribute("property", getProperty());
		}
		addComments(self);
		return self;
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //SmooksOutConfigurationImpl
