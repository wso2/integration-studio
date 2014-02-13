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


import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Template Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateMediatorImpl#getTargetTemplate <em>Target Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateMediatorImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallTemplateMediatorImpl extends MediatorImpl implements CallTemplateMediator {
	/**
	 * The default value of the '{@link #getTargetTemplate() <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetTemplate() <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTemplate()
	 * @generated
	 * @ordered
	 */
	protected String targetTemplate = TARGET_TEMPLATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<CallTemplateParameter> templateParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallTemplateMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("target")) {
			String targetTemplate = self.getAttribute("target");
			if (null != targetTemplate) {
				setTargetTemplate(targetTemplate);
			} else {
				setTargetTemplate("");
			}
		} else {
			setTargetTemplate("");
		}

		// Parameters.
		loadObjects(self, "with-param", CallTemplateParameter.class,
				new ObjectHandler<CallTemplateParameter>() {
					public void handle(CallTemplateParameter object) {
						getTemplateParameters().add(object);
					}
				});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {		
		Element self = createChildElement(parent, "call-template");
		if (null != getTargetTemplate() && !getTargetTemplate().equals("")) {
			self.setAttribute("target", getTargetTemplate());
		}

		// Parameters.
		for (CallTemplateParameter variable : getTemplateParameters()) {
			variable.save(self);
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
		return MediatorsPackage.Literals.CALL_TEMPLATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetTemplate() {
		return targetTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTemplate(String newTargetTemplate) {
		String oldTargetTemplate = targetTemplate;
		targetTemplate = newTargetTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE, oldTargetTemplate, targetTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CallTemplateParameter> getTemplateParameters() {
		if (templateParameters == null) {
			templateParameters = new EObjectContainmentEList<CallTemplateParameter>(CallTemplateParameter.class, this, MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS);
		}
		return templateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				return getTargetTemplate();
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				return getTemplateParameters();
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
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				setTargetTemplate((String)newValue);
				return;
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				getTemplateParameters().addAll((Collection<? extends CallTemplateParameter>)newValue);
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
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				setTargetTemplate(TARGET_TEMPLATE_EDEFAULT);
				return;
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
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
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				return TARGET_TEMPLATE_EDEFAULT == null ? targetTemplate != null : !TARGET_TEMPLATE_EDEFAULT.equals(targetTemplate);
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				return templateParameters != null && !templateParameters.isEmpty();
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
		result.append(" (targetTemplate: ");
		result.append(targetTemplate);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
 		
 		if (null == getTargetTemplate() || getTargetTemplate().trim().isEmpty()) {
			validateMap.put("Target Template","Target Template is empty");
		}
		
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Call Template Mediator", objectValidator);
 		
 		return mediatorValidateMap;
    }

} //CallTemplateMediatorImpl
