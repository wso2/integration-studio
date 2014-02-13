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
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Payload Factory Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl#getArgumentType <em>Argument Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl#getArgumentValue <em>Argument Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl#getArgumentExpression <em>Argument Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PayloadFactoryArgumentImpl extends ModelObjectImpl implements PayloadFactoryArgument {
    /**
	 * The default value of the '{@link #getArgumentType() <em>Argument Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArgumentType()
	 * @generated
	 * @ordered
	 */
    protected static final PayloadFactoryArgumentType ARGUMENT_TYPE_EDEFAULT = PayloadFactoryArgumentType.VALUE;

    /**
	 * The cached value of the '{@link #getArgumentType() <em>Argument Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArgumentType()
	 * @generated
	 * @ordered
	 */
    protected PayloadFactoryArgumentType argumentType = ARGUMENT_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getArgumentValue() <em>Argument Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArgumentValue()
     * @generated NOT
     * @ordered
     */
    protected static final String ARGUMENT_VALUE_EDEFAULT  = "Value";

    /**
	 * The cached value of the '{@link #getArgumentValue() <em>Argument Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArgumentValue()
	 * @generated
	 * @ordered
	 */
    protected String argumentValue = ARGUMENT_VALUE_EDEFAULT;

    /**
	 * The cached value of the '{@link #getArgumentExpression() <em>Argument Expression</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArgumentExpression()
	 * @generated
	 * @ordered
	 */
    protected NamespacedProperty argumentExpression;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected PayloadFactoryArgumentImpl() {
        super();
		// argument expression.
        argumentExpression = getEsbFactory()
				.createNamespacedProperty();
        argumentExpression.setPrettyName("expression");
        argumentExpression.setPropertyName("Expression");
        argumentExpression.setPropertyValue("/default/expression");
		setArgumentExpression(argumentExpression);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				protected EClass eStaticClass() {
		return MediatorsPackage.Literals.PAYLOAD_FACTORY_ARGUMENT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PayloadFactoryArgumentType getArgumentType() {
		return argumentType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setArgumentType(PayloadFactoryArgumentType newArgumentType) {
		PayloadFactoryArgumentType oldArgumentType = argumentType;
		argumentType = newArgumentType == null ? ARGUMENT_TYPE_EDEFAULT : newArgumentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE, oldArgumentType, argumentType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getArgumentValue() {
		return argumentValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setArgumentValue(String newArgumentValue) {
		String oldArgumentValue = argumentValue;
		argumentValue = newArgumentValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE, oldArgumentValue, argumentValue));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NamespacedProperty getArgumentExpression() {
		if (argumentExpression != null && argumentExpression.eIsProxy()) {
			InternalEObject oldArgumentExpression = (InternalEObject)argumentExpression;
			argumentExpression = (NamespacedProperty)eResolveProxy(oldArgumentExpression);
			if (argumentExpression != oldArgumentExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, oldArgumentExpression, argumentExpression));
			}
		}
		return argumentExpression;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NamespacedProperty basicGetArgumentExpression() {
		return argumentExpression;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setArgumentExpression(NamespacedProperty newArgumentExpression) {
		NamespacedProperty oldArgumentExpression = argumentExpression;
		argumentExpression = newArgumentExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, oldArgumentExpression, argumentExpression));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				return getArgumentType();
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				return getArgumentValue();
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				if (resolve) return getArgumentExpression();
				return basicGetArgumentExpression();
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
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				setArgumentType((PayloadFactoryArgumentType)newValue);
				return;
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				setArgumentValue((String)newValue);
				return;
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				setArgumentExpression((NamespacedProperty)newValue);
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
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				setArgumentType(ARGUMENT_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				setArgumentValue(ARGUMENT_VALUE_EDEFAULT);
				return;
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				setArgumentExpression((NamespacedProperty)null);
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
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				return argumentType != ARGUMENT_TYPE_EDEFAULT;
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				return ARGUMENT_VALUE_EDEFAULT == null ? argumentValue != null : !ARGUMENT_VALUE_EDEFAULT.equals(argumentValue);
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				return argumentExpression != null;
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
		result.append(" (argumentType: ");
		result.append(argumentType);
		result.append(", argumentValue: ");
		result.append(argumentValue);
		result.append(')');
		return result.toString();
	}

	
    protected void doLoad(Element self) throws Exception {
		Map<String,String> nsMap = new HashMap<String, String>();
		if (self.hasAttribute("expression")) {
			String attributeValue = self.getAttribute("expression");
			if (attributeValue == null) {
				attributeValue = "";
			}
			attributeValue = attributeValue.trim();
			setArgumentType(PayloadFactoryArgumentType.EXPRESSION);
			getArgumentExpression().setPropertyValue(attributeValue);
			NamedNodeMap nsList = self.getAttributes();
			if (nsList.getLength() > 0) {
				for (int i = 0; i < nsList.getLength(); i++) {
					Node item = nsList.item(i);
					if (null != item.getPrefix() && "xmlns".equals(item.getPrefix())) {
						nsMap.put(item.getLocalName(), item.getNodeValue());
					}
				}
				getArgumentExpression().setNamespaces(nsMap);
			}

		} else if (self.hasAttribute("value")) {
			String attributeValue = self.getAttribute("value");
			if (attributeValue == null) {
				attributeValue = "";
			}
			attributeValue = attributeValue.trim();
			setArgumentType(PayloadFactoryArgumentType.VALUE);
			setArgumentValue(attributeValue);
		} 
	    super.doLoad(self);
    }

	
    protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "arg");
		if(getArgumentType()==PayloadFactoryArgumentType.VALUE){
			self.setAttribute("value",getArgumentValue());
		} else{
			self.setAttribute("expression",getArgumentExpression().getPropertyValue());
			Map<String, String> namespaces = getArgumentExpression().getNamespaces();
			for (String ns : namespaces.keySet()) {
	            self.setAttribute("xmlns:"+ns,namespaces.get(ns));
            }
		}
		
		addComments(self);
		return self;
    }

	
    public Map<String, ObjectValidator> validate() {
		ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if(getArgumentType()==PayloadFactoryArgumentType.VALUE){
			if(null==getArgumentValue() || getArgumentValue().trim().isEmpty()){
	    		validateMap.put("Argument Value", "Argument Value is empty");
	    	}
		} else{
			if(null==getArgumentExpression().getPropertyValue() || getArgumentExpression().getPropertyValue().trim().isEmpty()){
	    		validateMap.put("Argument Expression", "Argument Expression is empty");
	    	}
		}
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("PayloadFactory Argument", objectValidator);
	    return mediatorValidateMap;
    }

} //PayloadFactoryArgumentImpl
