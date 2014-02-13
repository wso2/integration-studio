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
import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl#getMediateFunction <em>Mediate Function</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl#getScriptKey <em>Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl#getScriptBody <em>Script Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptMediatorImpl extends MediatorImpl implements ScriptMediator {
	/**
	 * The default value of the '{@link #getScriptType() <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected static final ScriptType SCRIPT_TYPE_EDEFAULT = ScriptType.REGISTRY_REFERENCE;

	/**
	 * The cached value of the '{@link #getScriptType() <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected ScriptType scriptType = SCRIPT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScriptLanguage() <em>Script Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final ScriptLanguage SCRIPT_LANGUAGE_EDEFAULT = ScriptLanguage.JAVASCRIPT;

	/**
	 * The cached value of the '{@link #getScriptLanguage() <em>Script Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptLanguage()
	 * @generated
	 * @ordered
	 */
	protected ScriptLanguage scriptLanguage = SCRIPT_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMediateFunction() <em>Mediate Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediateFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String MEDIATE_FUNCTION_EDEFAULT = "mediate";

	/**
	 * The cached value of the '{@link #getMediateFunction() <em>Mediate Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediateFunction()
	 * @generated
	 * @ordered
	 */
	protected String mediateFunction = MEDIATE_FUNCTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScriptKey() <em>Script Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty scriptKey;

	/**
	 * The default value of the '{@link #getScriptBody() <em>Script Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptBody()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_BODY_EDEFAULT = "script_code";

	/**
	 * The cached value of the '{@link #getScriptBody() <em>Script Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptBody()
	 * @generated
	 * @ordered
	 */
	protected String scriptBody = SCRIPT_BODY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ScriptMediatorImpl() {
		super();
		
		// Script key.
		RegistryKeyProperty key = getEsbFactory().createRegistryKeyProperty();
		key.setPrettyName("Script Key");
		key.setKeyName("key");
		key.setKeyValue(DEFAULT_REGISTRY_KEY);
		setScriptKey(key);	
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Script language.
		ScriptLanguage language = ScriptLanguage.get(self.getAttribute("language"));
		if (null != language) {
			setScriptLanguage(language);
		}				
		
		// Script type.
		if (self.hasAttribute("key")) {
			setScriptType(ScriptType.REGISTRY_REFERENCE);
			getScriptKey().load(self);
			
			// Script function.
			if (self.hasAttribute("function")) {
				setMediateFunction(self.getAttribute("function"));
			}
		} else {
			setScriptType(ScriptType.INLINE);
			CDATASection cdata = getChildCDATASection(self);			
			if (null != cdata) {
				setScriptBody(cdata.getTextContent());
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "script");
		
		// Script language.
		self.setAttribute("language", getScriptLanguage().getLiteral());				
		
		// Script code.
		if (getScriptType().equals(ScriptType.REGISTRY_REFERENCE)){						
			getScriptKey().save(self);
			
			// Mediate function.
			if (!StringUtils.isBlank(getMediateFunction())) {
				self.setAttribute("function", getMediateFunction());
			}
		} else {
			CDATASection cdata = parent.getOwnerDocument().createCDATASection(getScriptBody());
			self.appendChild(cdata);
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
		return MediatorsPackage.Literals.SCRIPT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType getScriptType() {
		return scriptType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptType(ScriptType newScriptType) {
		ScriptType oldScriptType = scriptType;
		scriptType = newScriptType == null ? SCRIPT_TYPE_EDEFAULT : newScriptType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE, oldScriptType, scriptType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptLanguage getScriptLanguage() {
		return scriptLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptLanguage(ScriptLanguage newScriptLanguage) {
		ScriptLanguage oldScriptLanguage = scriptLanguage;
		scriptLanguage = newScriptLanguage == null ? SCRIPT_LANGUAGE_EDEFAULT : newScriptLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE, oldScriptLanguage, scriptLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMediateFunction() {
		return mediateFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediateFunction(String newMediateFunction) {
		String oldMediateFunction = mediateFunction;
		mediateFunction = newMediateFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION, oldMediateFunction, mediateFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getScriptKey() {
		return scriptKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScriptKey(RegistryKeyProperty newScriptKey, NotificationChain msgs) {
		RegistryKeyProperty oldScriptKey = scriptKey;
		scriptKey = newScriptKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY, oldScriptKey, newScriptKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptKey(RegistryKeyProperty newScriptKey) {
		if (newScriptKey != scriptKey) {
			NotificationChain msgs = null;
			if (scriptKey != null)
				msgs = ((InternalEObject)scriptKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY, null, msgs);
			if (newScriptKey != null)
				msgs = ((InternalEObject)newScriptKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY, null, msgs);
			msgs = basicSetScriptKey(newScriptKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY, newScriptKey, newScriptKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScriptBody() {
		return scriptBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptBody(String newScriptBody) {
		String oldScriptBody = scriptBody;
		scriptBody = newScriptBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_BODY, oldScriptBody, scriptBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY:
				return basicSetScriptKey(null, msgs);
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
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				return getScriptType();
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				return getScriptLanguage();
			case MediatorsPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				return getMediateFunction();
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY:
				return getScriptKey();
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				return getScriptBody();
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
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				setScriptType((ScriptType)newValue);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				setScriptLanguage((ScriptLanguage)newValue);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				setMediateFunction((String)newValue);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY:
				setScriptKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				setScriptBody((String)newValue);
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
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				setScriptType(SCRIPT_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				setScriptLanguage(SCRIPT_LANGUAGE_EDEFAULT);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				setMediateFunction(MEDIATE_FUNCTION_EDEFAULT);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY:
				setScriptKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				setScriptBody(SCRIPT_BODY_EDEFAULT);
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
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
				return scriptType != SCRIPT_TYPE_EDEFAULT;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
				return scriptLanguage != SCRIPT_LANGUAGE_EDEFAULT;
			case MediatorsPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
				return MEDIATE_FUNCTION_EDEFAULT == null ? mediateFunction != null : !MEDIATE_FUNCTION_EDEFAULT.equals(mediateFunction);
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_KEY:
				return scriptKey != null;
			case MediatorsPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
				return SCRIPT_BODY_EDEFAULT == null ? scriptBody != null : !SCRIPT_BODY_EDEFAULT.equals(scriptBody);
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
		result.append(" (scriptType: ");
		result.append(scriptType);
		result.append(", scriptLanguage: ");
		result.append(scriptLanguage);
		result.append(", mediateFunction: ");
		result.append(mediateFunction);
		result.append(", scriptBody: ");
		result.append(scriptBody);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (getScriptType().equals(ScriptType.REGISTRY_REFERENCE)){						
			if (null == getScriptKey().getKeyValue() || getScriptKey().getKeyValue().trim().isEmpty()) {
				validateMap.put("Script key","Script key is empty");
			}
			
		} else {		
			if (null == getScriptBody() || getScriptBody().trim().isEmpty()) {
				validateMap.put("Script Body","Script Body is empty");
			}
		}		
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Script Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} //ScriptMediatorImpl
