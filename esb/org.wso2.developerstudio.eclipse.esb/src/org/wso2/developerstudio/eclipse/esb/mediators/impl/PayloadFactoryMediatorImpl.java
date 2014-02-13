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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Payload Factory Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryMediatorImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryMediatorImpl#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PayloadFactoryMediatorImpl extends MediatorImpl implements PayloadFactoryMediator {
    /**
     * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated NOT
     * @ordered
     */
    protected static final String FORMAT_EDEFAULT = "<inline/>";

    /**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
    protected String format = FORMAT_EDEFAULT;

    /**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
    protected EList<PayloadFactoryArgument> args;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PayloadFactoryMediatorImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				protected EClass eStaticClass() {
		return MediatorsPackage.Literals.PAYLOAD_FACTORY_MEDIATOR;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getFormat() {
		return format;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT, oldFormat, format));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<PayloadFactoryArgument> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<PayloadFactoryArgument>(PayloadFactoryArgument.class, this, MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS);
		}
		return args;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				return getFormat();
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				return getArgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				@Override
    
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				setFormat((String)newValue);
				return;
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends PayloadFactoryArgument>)newValue);
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
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				getArgs().clear();
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
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				return args != null && !args.isEmpty();
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
		result.append(" (format: ");
		result.append(format);
		result.append(')');
		return result.toString();
	}

	
    protected void doLoad(Element self) throws Exception {
		

		
		NodeList formatNode = self.getElementsByTagName("format");
		if (formatNode.getLength()==1){
			Element format = (Element) formatNode.item(0);
			List<Element> children = getChildElements(format);
			if (!children.isEmpty()) {
				setFormat(EsbUtils.renderElement(children.get(0), true,true));
			}
		}
		NodeList argsNode = self.getElementsByTagName("args");
		if (argsNode.getLength()==1){
			Element args = (Element) argsNode.item(0);
			loadObjects(args, "arg",PayloadFactoryArgument.class ,
						new ObjectHandler<PayloadFactoryArgument>() {
							public void handle(PayloadFactoryArgument object) {
								getArgs().add(object);
							}
						});
		}
		super.doLoad(self);
    }

	
    protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "payloadFactory");
		if (null != getFormat()) {
			try {
	            Element format = createChildElement(self, "format");
	            Element formatElem = EsbUtils.parseElement(getFormat(),false);
	            formatElem = (Element) self.getOwnerDocument().importNode(formatElem, true);
	            format.appendChild(formatElem);
            } catch (Exception e) {
	            setFormat("");
            }
		}
		
		Element args = createChildElement(self, "args");
		for(PayloadFactoryArgument variable : getArgs()){
			variable.save(args);
		}
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
    }

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		try {
            Element formatElem = EsbUtils.parseElement(getFormat());
        } catch (Exception e) {
        	validateMap.put("Format", "Invalid payload format, must be valid xml");
        }
		if(getArgs().size()<=0){
	    		validateMap.put("Arguments", "Must have at least one argument");
		} 
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("PayloadFactory Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} //PayloadFactoryMediatorImpl
