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
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getPropertyDataType <em>Property Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getPropertyAction <em>Property Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getPropertyScope <em>Property Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getValueOM <em>Value OM</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getValueStringPattern <em>Value String Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl#getValueStringCapturingGroup <em>Value String Capturing Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyMediatorImpl extends MediatorImpl implements PropertyMediator {
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
	 * The default value of the '{@link #getValueOM() <em>Value OM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOM()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_OM_EDEFAULT = "<value/>";
	/**
	 * The cached value of the '{@link #getValueOM() <em>Value OM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOM()
	 * @generated
	 * @ordered
	 */
	protected String valueOM = VALUE_OM_EDEFAULT;
	/**
	 * The default value of the '{@link #getValueStringPattern() <em>Value String Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueStringPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_STRING_PATTERN_EDEFAULT = "";
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected PropertyMediatorImpl() {
		super();
		
		// Value expression.
		NamespacedProperty valueExpression = getEsbFactory().createNamespacedProperty();
		valueExpression.setPrettyName("Property Expression");
		valueExpression.setPropertyName("expression");
		valueExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);		
		setValueExpression(valueExpression);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Property name.
		if (self.hasAttribute("name")) {
			setPropertyName(self.getAttribute("name"));
		} else {
			throw new Exception("Expected property name.");
		}
		
		// Property action.
		PropertyAction action = PropertyAction.get(self.getAttribute("action"));
		if (null == action) {
			action = PropertyAction.SET;
		}
		setPropertyAction(action);
		
		if (getPropertyAction().equals(PropertyAction.SET)) {
			// Property data type.
			PropertyDataType dataType = PropertyDataType.get(self.getAttribute("type"));
			if (null != dataType) {
				setPropertyDataType(dataType);
			}
			
			// Property value.
			if (self.hasAttribute("expression")) {
				setValueType(PropertyValueType.EXPRESSION);
				getValueExpression().load(self);
			} else {
				setValueType(PropertyValueType.LITERAL);

				if (self.hasAttribute("value")) {
					setValueLiteral(self.getAttribute("value"));
				} else if (getPropertyDataType().equals(PropertyDataType.OM)) {
					List<Element> childElems = getChildElements(self);
					if (!childElems.isEmpty()) {
						// Question: Is it possible there will be multiple child
						// elements?
						setValueOM(EsbUtils.renderElement(childElems.get(0), true));
					}
				} else {
					throw new Exception("Unknown property value definition.");
				}
			}
			
			// String properties have additional pattern and group parameters.
			if (getPropertyDataType().equals(PropertyDataType.STRING)) {
				// Pattern.
				if (self.hasAttribute("pattern")) {
					setValueStringPattern(self.getAttribute("pattern"));
				}
				
				// Capturing group.
				if (self.hasAttribute("group")) {
					setValueStringCapturingGroup(Integer.parseInt(self.getAttribute("group")));
				}
			}
		}				

		// Property scope.
		PropertyScope scope = PropertyScope.get(self.getAttribute("scope"));
		if (null != scope) {
			setPropertyScope(scope);
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "property");
		
		// Name.
		self.setAttribute("name", getPropertyName());
		
		// Action.
		self.setAttribute("action", getPropertyAction().getLiteral());				
								
		if (getPropertyAction().equals(PropertyAction.SET)) {			
			// Data type.
			self.setAttribute("type", getPropertyDataType().getLiteral());
					
			// Value.
			if (getValueType().equals(PropertyValueType.EXPRESSION)) {
				getValueExpression().save(self);
			} else if (getPropertyDataType().equals(PropertyDataType.OM)) {
				Element omElem = null;
				try {
					omElem = EsbUtils.parseElement(getValueOM());
					omElem = (Element) self.getOwnerDocument().importNode(omElem, true);
					self.appendChild(omElem);
				} catch (Exception ex) {
					// TODO: Report error.
					omElem = createChildElement(self, "value");
					setValueOM(VALUE_OM_EDEFAULT);
				}
			} else {
				self.setAttribute("value", getValueLiteral());
			}
		
			// String properties might have an associated pattern and a capturing group.
			if (getPropertyDataType().equals(PropertyDataType.STRING)) {				
				if (!StringUtils.isBlank(getValueStringPattern())) {
					self.setAttribute("pattern", getValueStringPattern());
				}
				
				if (getValueStringCapturingGroup() > 0) {
					self.setAttribute("group", Integer.toString(getValueStringCapturingGroup()));
				}
			}
		}						
		
		// Scope.
		self.setAttribute("scope", getPropertyScope().getLiteral());
		if(description!=null)
			description.save(self);
		
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
		return MediatorsPackage.Literals.PROPERTY_MEDIATOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_NAME, oldPropertyName, propertyName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, oldPropertyDataType, propertyDataType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION, oldPropertyAction, propertyAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueOM() {
		return valueOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueOM(String newValueOM) {
		String oldValueOM = valueOM;
		valueOM = newValueOM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_OM, oldValueOM, valueOM));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN, oldValueStringPattern, valueStringPattern));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP, oldValueStringCapturingGroup, valueStringCapturingGroup));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE, oldPropertyScope, propertyScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
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
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				return getPropertyName();
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				return getPropertyDataType();
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				return getPropertyAction();
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				return getPropertyScope();
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				return getValueType();
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_LITERAL:
				return getValueLiteral();
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				return getValueExpression();
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_OM:
				return getValueOM();
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				return getValueStringPattern();
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				return getValueStringCapturingGroup();
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
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				setPropertyDataType((PropertyDataType)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				setPropertyAction((PropertyAction)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				setPropertyScope((PropertyScope)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				setValueType((PropertyValueType)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_OM:
				setValueOM((String)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				setValueStringPattern((String)newValue);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				setValueStringCapturingGroup((Integer)newValue);
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
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				setPropertyDataType(PROPERTY_DATA_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				setPropertyAction(PROPERTY_ACTION_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				setPropertyScope(PROPERTY_SCOPE_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_OM:
				setValueOM(VALUE_OM_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				setValueStringPattern(VALUE_STRING_PATTERN_EDEFAULT);
				return;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				setValueStringCapturingGroup(VALUE_STRING_CAPTURING_GROUP_EDEFAULT);
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
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
				return propertyDataType != PROPERTY_DATA_TYPE_EDEFAULT;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
				return propertyAction != PROPERTY_ACTION_EDEFAULT;
			case MediatorsPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
				return propertyScope != PROPERTY_SCOPE_EDEFAULT;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
				return valueExpression != null;
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_OM:
				return VALUE_OM_EDEFAULT == null ? valueOM != null : !VALUE_OM_EDEFAULT.equals(valueOM);
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
				return VALUE_STRING_PATTERN_EDEFAULT == null ? valueStringPattern != null : !VALUE_STRING_PATTERN_EDEFAULT.equals(valueStringPattern);
			case MediatorsPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
				return valueStringCapturingGroup != VALUE_STRING_CAPTURING_GROUP_EDEFAULT;
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
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(", valueOM: ");
		result.append(valueOM);
		result.append(", valueStringPattern: ");
		result.append(valueStringPattern);
		result.append(", valueStringCapturingGroup: ");
		result.append(valueStringCapturingGroup);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
		ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
    	if(null==getPropertyName() || getPropertyName().trim().isEmpty()){
    		validateMap.put("Property Name", "Property Name is empty");
    	}
    	if (getValueType().equals(PropertyValueType.EXPRESSION)) {
    		if(null==getValueExpression().getPropertyValue() || getValueExpression().getPropertyValue().trim().isEmpty()){
	    		validateMap.put("Property Expression", "Expression is empty");
	    	}
		} else if (getPropertyDataType().equals(PropertyDataType.OM)) {
			try {
				Element omElem = EsbUtils.parseElement(getValueOM());
			} catch (Exception ex) {
				validateMap.put("ValueXML", "Invalid ValueXML");			
			}
		} else {
			if(null==getValueLiteral() || getValueLiteral().trim().isEmpty()){
	    		validateMap.put("Property value", "Property value is empty");
	    	}
		}
	
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Property Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} //PropertyMediatorImpl
