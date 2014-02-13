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
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction;
import org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Header Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl#getHeaderName <em>Header Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl#getHeaderAction <em>Header Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl#getValueExpression <em>Value Expression</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected HeaderMediatorImpl() {
		super();

		// Header name.
		NamespacedProperty headerName = getEsbFactory().createNamespacedProperty();
		headerName.setPrettyName("Header Name");
		headerName.setPropertyName("name");
		headerName.setPropertyValue("header_name");
		setHeaderName(headerName);

		// Value expression.
		NamespacedProperty valueExpression = getEsbFactory().createNamespacedProperty();
		valueExpression.setPrettyName("Expression");
		valueExpression.setPropertyName("expression");
		valueExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setValueExpression(valueExpression);
	}

	/**
	 * {@inheritDoc}
	 */
	
	protected void doLoad(Element self) throws Exception {
		String headerNamePrefix = null;
		if (self.hasAttribute("name")) {
			getHeaderName().load(self);

			// Extract header name and the corresponding namespace.
			String headerNameWithPrefix = getHeaderName().getPropertyValue();
			String headerName = null;
			String headerNameNamespaceURI = null;
			int colon = headerNameWithPrefix.indexOf(':');
			if (colon > 0) {
				headerNamePrefix = headerNameWithPrefix.substring(0, colon);
				headerName = headerNameWithPrefix.substring(colon + 1);
				headerNameNamespaceURI = getHeaderName().getNamespaces().get(
						headerNamePrefix);
				if (headerNameNamespaceURI == null) {
					Map<String, String> nsMap = new HashMap<String, String>();
					NamedNodeMap nsList = self.getOwnerDocument()
							.getChildNodes().item(0).getAttributes();
					if (nsList.getLength() > 0) {
						for (int i = 0; i < nsList.getLength(); i++) {
							Node item = nsList.item(i);
							if (null != item.getPrefix()
									&& "xmlns".equals(item.getPrefix())) {
								nsMap.put(item.getLocalName(),
										item.getNodeValue());
							}
						}
					}
					headerNameNamespaceURI = (String) nsMap
							.get(headerNamePrefix);
				}
			}

			// Clear all other namespaces.
			getHeaderName().getNamespaces().clear();

			// Set the extracted header name.
			if (!StringUtils.isBlank(headerName)) {
				getHeaderName().setPropertyValue(headerName);
			}

			// Add the namespace corresponding to header name.
			if (!StringUtils.isBlank(headerNamePrefix)
					&& (!StringUtils.isBlank(headerNameNamespaceURI))) {
				getHeaderName().getNamespaces().put(headerNamePrefix,
						headerNameNamespaceURI);
			}
		} else {
			throw new Exception("Expected header name.");
		}

		// Header action.
		HeaderAction action = HeaderAction.get(self.getAttribute("action"));
		if (null != action) {
			setHeaderAction(action);
		}
		// removed exception throwing due to optionality of action

		// Header value.
		if (getHeaderAction().equals(HeaderAction.SET)) {
			if (self.hasAttribute("value")) {
				setValueType(HeaderValueType.LITERAL);
				setValueLiteral(self.getAttribute("value"));
			} else if (self.hasAttribute("expression")) {
				setValueType(HeaderValueType.EXPRESSION);
				getValueExpression().load(self);

				// Remove the namespace corresponding to header name.
				if (!StringUtils.isBlank(headerNamePrefix)) {
					getValueExpression().getNamespaces().remove(
							headerNamePrefix);
				}
			} else {
				throw new Exception(
						"Expected either a header value or an expression.");
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */

	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "header");

		// Header name.
		if (!getHeaderName().getNamespaces().isEmpty()) {
			Entry<String, String> headerNamespace = getHeaderName()
					.getNamespaces().entrySet().iterator().next();
			String newHeaderName = String.format("%s:%s", headerNamespace
					.getKey(), getHeaderName().getPropertyValue());
			self.setAttribute("name", newHeaderName);
			int size = ((ModelObject)EcoreUtil.getRootContainer(this))
					.getAdditionalNamespaces().size();
			boolean contains = false;
			for (int i = 0; i < size; ++i) {
				if (((ModelObject) EcoreUtil.getRootContainer(this))
						.getAdditionalNamespaces().get(i).getPrefix()
						.equals(headerNamespace.getKey())) {
					contains = true;
				}
			}
			if (!contains) {
				self.setAttribute(
						String.format("xmlns:%s", headerNamespace.getKey()),
						headerNamespace.getValue());
			}

		} else {
			self.setAttribute("name", getHeaderName().getPropertyValue());
		}

		// Header action.
		self.setAttribute("action", getHeaderAction().getLiteral());

		// Header value.
		if (getHeaderAction().equals(HeaderAction.SET)) {
			if (getValueType().equals(HeaderValueType.LITERAL)) {
				self.setAttribute("value", getValueLiteral());
			} else {
				getValueExpression().save(self);
			}
		}
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
		return MediatorsPackage.Literals.HEADER_MEDIATOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME, oldHeaderName, newHeaderName);
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
				msgs = ((InternalEObject)headerName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME, null, msgs);
			if (newHeaderName != null)
				msgs = ((InternalEObject)newHeaderName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME, null, msgs);
			msgs = basicSetHeaderName(newHeaderName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME, newHeaderName, newHeaderName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__HEADER_ACTION, oldHeaderAction, headerAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__VALUE_LITERAL, oldValueLiteral, valueLiteral));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME:
				return basicSetHeaderName(null, msgs);
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
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
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME:
				return getHeaderName();
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_ACTION:
				return getHeaderAction();
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_TYPE:
				return getValueType();
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				return getValueLiteral();
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				return getValueExpression();
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
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME:
				setHeaderName((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_ACTION:
				setHeaderAction((HeaderAction)newValue);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_TYPE:
				setValueType((HeaderValueType)newValue);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)newValue);
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
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME:
				setHeaderName((NamespacedProperty)null);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_ACTION:
				setHeaderAction(HEADER_ACTION_EDEFAULT);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				setValueExpression((NamespacedProperty)null);
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
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_NAME:
				return headerName != null;
			case MediatorsPackage.HEADER_MEDIATOR__HEADER_ACTION:
				return headerAction != HEADER_ACTION_EDEFAULT;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case MediatorsPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
				return valueExpression != null;
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
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
		ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> headerMediatorValidateMap = new HashMap<String, ObjectValidator>();
	    if(getHeaderName().getPropertyValue().equals("") || getHeaderName().getPropertyValue().equals(null)){
	    	validateMap.put("Header Name", "Header Name is empty");
	    	
	    }
	    if(getHeaderAction().equals(HeaderAction.SET)){
	    	if(getValueType().equals(HeaderValueType.LITERAL)){
	    		if(getValueLiteral().equals("") || getValueLiteral().equals(null)){
	    			validateMap.put("Value Literal", "Value Literal is empty");
	    		}
	    	}else{
	    		if(getValueExpression().equals("") || getValueExpression().equals(null)){
	    			validateMap.put("Value Expression", "Value Expression is empty");
	    		}
	    	}
	    }
	    
	    objectValidator.setMediatorErrorMap(validateMap);
	    headerMediatorValidateMap.put("Header", objectValidator);
	    return headerMediatorValidateMap;
    }

} //HeaderMediatorImpl
