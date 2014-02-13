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
 */
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl#getTemplateParameterType <em>Template Parameter Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl#getParameterValue <em>Parameter Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl#getParameterExpression <em>Parameter Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallTemplateParameterImpl extends ModelObjectImpl implements CallTemplateParameter {
	/**
     * The default value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterName()
     * @generated NOT
     * @ordered
     */
	protected static final String PARAMETER_NAME_EDEFAULT = "Parameter";
	/**
	 * The cached value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterName()
	 * @generated
	 * @ordered
	 */
	protected String parameterName = PARAMETER_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getTemplateParameterType() <em>Template Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameterType()
	 * @generated
	 * @ordered
	 */
	protected static final RuleOptionType TEMPLATE_PARAMETER_TYPE_EDEFAULT = RuleOptionType.VALUE;
	/**
	 * The cached value of the '{@link #getTemplateParameterType() <em>Template Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameterType()
	 * @generated
	 * @ordered
	 */
	protected RuleOptionType templateParameterType = TEMPLATE_PARAMETER_TYPE_EDEFAULT;
	/**
     * The default value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterValue()
     * @generated NOT
     * @ordered
     */
	protected static final String PARAMETER_VALUE_EDEFAULT  = "Value";
	/**
	 * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValue()
	 * @generated
	 * @ordered
	 */
	protected String parameterValue = PARAMETER_VALUE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getParameterExpression() <em>Parameter Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty parameterExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CallTemplateParameterImpl() {
		super();
		/* Initialize parameter expression. */
		parameterExpression = getEsbFactory()
				.createNamespacedProperty();
		parameterExpression.setPrettyName("expression");
		parameterExpression.setPropertyName("Expression");
		parameterExpression.setPropertyValue("/default/expression");
		setParameterExpression(parameterExpression);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		Map<String,String> nsMap = new HashMap<String, String>();
		if (self.hasAttribute("value")) {
			String attributeValue = self.getAttribute("value");
			if (attributeValue == null) {
				attributeValue = "";
			}
			attributeValue = attributeValue.trim();
			if (attributeValue.startsWith("{") && attributeValue.endsWith("}")) {
				setTemplateParameterType(RuleOptionType.EXPRESSION);
				attributeValue = attributeValue.replaceAll("^\\{","").replaceAll("\\}$", "");
				getParameterExpression().setPropertyValue(attributeValue);
				NamedNodeMap nsList = self.getAttributes();
				if (nsList.getLength() > 0) {
					for (int i = 0; i < nsList.getLength(); i++) {
						Node item = nsList.item(i);
						if (null != item.getPrefix() && "xmlns".equals(item.getPrefix())) {
							nsMap.put(item.getLocalName(), item.getNodeValue());
						}
					}
					getParameterExpression().setNamespaces(nsMap);
				}
			} else {
				setTemplateParameterType(RuleOptionType.VALUE);
				setParameterValue(attributeValue);
			}
		}

		if (self.hasAttribute("name")) {
			String attributeValue = self.getAttribute("name");
			if (attributeValue == null) {
				attributeValue = "";
			}
			setParameterName(attributeValue);
		} else {

			setParameterName("");
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "with-param");
		
		self.setAttribute("name", getParameterName());
		
		switch (getTemplateParameterType()) {
		case VALUE:
			if (null != getParameterValue()) {
				self.setAttribute("value", getParameterValue());
			}
			break;
		case EXPRESSION:
			if (null != getParameterExpression().getPropertyValue()) {
				self.setAttribute("value", "{"
						+ getParameterExpression().getPropertyValue()
						+ "}");
				Map<String, String> namespaces = getParameterExpression().getNamespaces();
				for (String ns : namespaces.keySet()) {
		            self.setAttribute("xmlns:"+ns,namespaces.get(ns));
	            }
			}
			break;
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
		return MediatorsPackage.Literals.CALL_TEMPLATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterName(String newParameterName) {
		String oldParameterName = parameterName;
		parameterName = newParameterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME, oldParameterName, parameterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleOptionType getTemplateParameterType() {
		return templateParameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateParameterType(RuleOptionType newTemplateParameterType) {
		RuleOptionType oldTemplateParameterType = templateParameterType;
		templateParameterType = newTemplateParameterType == null ? TEMPLATE_PARAMETER_TYPE_EDEFAULT : newTemplateParameterType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE, oldTemplateParameterType, templateParameterType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterValue() {
		return parameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterValue(String newParameterValue) {
		String oldParameterValue = parameterValue;
		parameterValue = newParameterValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE, oldParameterValue, parameterValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getParameterExpression() {
		if (parameterExpression != null && parameterExpression.eIsProxy()) {
			InternalEObject oldParameterExpression = (InternalEObject)parameterExpression;
			parameterExpression = (NamespacedProperty)eResolveProxy(oldParameterExpression);
			if (parameterExpression != oldParameterExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, oldParameterExpression, parameterExpression));
			}
		}
		return parameterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetParameterExpression() {
		return parameterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterExpression(NamespacedProperty newParameterExpression) {
		NamespacedProperty oldParameterExpression = parameterExpression;
		parameterExpression = newParameterExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, oldParameterExpression, parameterExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				return getParameterName();
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				return getTemplateParameterType();
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				return getParameterValue();
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				if (resolve) return getParameterExpression();
				return basicGetParameterExpression();
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
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				setParameterName((String)newValue);
				return;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				setTemplateParameterType((RuleOptionType)newValue);
				return;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				setParameterValue((String)newValue);
				return;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				setParameterExpression((NamespacedProperty)newValue);
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
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				setParameterName(PARAMETER_NAME_EDEFAULT);
				return;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				setTemplateParameterType(TEMPLATE_PARAMETER_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				setParameterValue(PARAMETER_VALUE_EDEFAULT);
				return;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				setParameterExpression((NamespacedProperty)null);
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
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				return PARAMETER_NAME_EDEFAULT == null ? parameterName != null : !PARAMETER_NAME_EDEFAULT.equals(parameterName);
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				return templateParameterType != TEMPLATE_PARAMETER_TYPE_EDEFAULT;
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				return PARAMETER_VALUE_EDEFAULT == null ? parameterValue != null : !PARAMETER_VALUE_EDEFAULT.equals(parameterValue);
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				return parameterExpression != null;
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
		result.append(" (parameterName: ");
		result.append(parameterName);
		result.append(", templateParameterType: ");
		result.append(templateParameterType);
		result.append(", parameterValue: ");
		result.append(parameterValue);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
    	if(null==getParameterName() || getParameterName().trim().isEmpty()){
    		validateMap.put("Parameter Name", "Parameter Name is empty");
    	}
		switch (getTemplateParameterType()) {
			case VALUE:
				if (null == getParameterValue() || getParameterValue().trim().isEmpty()) {
					validateMap.put("Parameter Value", "Parameter Value is empty");
				}
				break;
			case EXPRESSION:
				if (null == getParameterExpression().getPropertyValue() ||
				    getParameterExpression().getPropertyValue().trim().isEmpty()) {
					validateMap.put("Parameter Expression", "Parameter Expression is empty");
				}
				break;
		}
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("CallTemplate Parameter", objectValidator);
	    return mediatorValidateMap;
    }

	
} //CallTemplateParameterImpl
