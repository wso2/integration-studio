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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>XQuery Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl#getTargetXPath <em>Target XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl#getScriptKeyType <em>Script Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl#getStaticScriptKey <em>Static Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl#getDynamicScriptKey <em>Dynamic Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl#getQueryKey <em>Query Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XQueryMediatorImpl extends MediatorImpl implements XQueryMediator {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<XQueryVariable> variables;

	/**
	 * The cached value of the '{@link #getTargetXPath() <em>Target XPath</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetXPath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty targetXPath;

	/**
	 * The default value of the '{@link #getScriptKeyType() <em>Script Key Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getScriptKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType SCRIPT_KEY_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getScriptKeyType() <em>Script Key Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getScriptKeyType()
	 * @generated
	 * @ordered
	 */
	protected KeyType scriptKeyType = SCRIPT_KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStaticScriptKey() <em>Static Script Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getStaticScriptKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty staticScriptKey;

	/**
	 * The cached value of the '{@link #getDynamicScriptKey() <em>Dynamic Script Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDynamicScriptKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty dynamicScriptKey;

	/**
	 * The cached value of the '{@link #getQueryKey() <em>Query Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty queryKey;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected XQueryMediatorImpl() {
		super();
		// Query key.
		RegistryKeyProperty queryKey = getEsbFactory().createRegistryKeyProperty();
		queryKey.setPrettyName("XQuery Key");
		queryKey.setKeyName("key");
		queryKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setQueryKey(queryKey);

		// Static script key.
		staticScriptKey = getEsbFactory().createRegistryKeyProperty();
		staticScriptKey.setPrettyName("Static Script Key");
		staticScriptKey.setKeyName("key");
		staticScriptKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setStaticScriptKey(staticScriptKey);

		// Dynamic script key
		dynamicScriptKey = getEsbFactory().createNamespacedProperty();
		dynamicScriptKey.setPrettyName("Dynamic Script Key");
		dynamicScriptKey.setPropertyName("key");
		dynamicScriptKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setDynamicScriptKey(dynamicScriptKey);

		// Target XPath.
		NamespacedProperty targetXPath = getEsbFactory()
				.createNamespacedProperty();
		targetXPath.setPrettyName("Target XPath");
		targetXPath.setPropertyName("target");
		setTargetXPath(targetXPath);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		
		switch (getCurrentEsbVersion()){
		case ESB301:
			// Query key.
			if (self.hasAttribute("key")) {
				getQueryKey().load(self);
			} else {
				throw new Exception("An xquery mediator must have a query key property.");
			}
			
			// Target XPath.
			if (self.hasAttribute("target")) {
				getTargetXPath().load(self);
			}
			
			// Variables.
			loadObjects(self, "variable", XQueryVariable.class, new ObjectHandler<XQueryVariable>() {
				public void handle(XQueryVariable object) {
					getVariables().add(object);				
				}			
			});
			break;
		
		case ESB400:
			// XQuery script key.
			if (self.hasAttribute("key")) {
				String scriptKeyValue = self.getAttribute("key");
				if (scriptKeyValue == null) {
					scriptKeyValue = "";
				}
				scriptKeyValue = scriptKeyValue.trim();
				if (scriptKeyValue.startsWith("{") && scriptKeyValue.endsWith("}")) {
					setScriptKeyType(getScriptKeyType().DYNAMIC);
					scriptKeyValue = scriptKeyValue.substring(1,
							scriptKeyValue.length() - 2);
					getDynamicScriptKey().setPropertyValue(scriptKeyValue);
				} else {
					setScriptKeyType(getScriptKeyType().STATIC);
					getStaticScriptKey().setKeyValue(scriptKeyValue);
				}
			} else {
				setScriptKeyType(getScriptKeyType().STATIC);
				//throw new Exception(
				//		"An xquery mediator must have a query key property.");
			}

			// Target XPath.
			if (self.hasAttribute("target")) {
				getTargetXPath().load(self);
			}

			// Variables.
			loadObjects(self, "variable", XQueryVariable.class,
					new ObjectHandler<XQueryVariable>() {
						public void handle(XQueryVariable object) {
							getVariables().add(object);
						}
					});
			break;
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "xquery");
		switch (getCurrentEsbVersion()){
		
		case ESB301:
			// Query key.
			getQueryKey().save(self);
			
			// Target XPath.
			if (!StringUtils.isBlank(getTargetXPath().getPropertyValue())) {
				getTargetXPath().save(self);
			}
			
			// Variables.
			for (XQueryVariable variable : getVariables()) {
				variable.save(self);
			}
			break;
			
		case ESB400:
			// XQuery script key.
			switch (getScriptKeyType()) {
			case STATIC:
				getStaticScriptKey().save(self);
				break;
			case DYNAMIC:
				self.setAttribute(getDynamicScriptKey().getPropertyName(),
						"{" + getDynamicScriptKey().getPropertyValue()
								+ "}");
				break;
			}

			// Target XPath.
			if (!StringUtils.isBlank(getTargetXPath().getPropertyValue())) {
				getTargetXPath().save(self);
			}

			// Variables.
			for (XQueryVariable variable : getVariables()) {
				variable.save(self);
			}
			break;
		}
		
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.XQUERY_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getTargetXPath() {
		if (targetXPath != null && targetXPath.eIsProxy()) {
			InternalEObject oldTargetXPath = (InternalEObject)targetXPath;
			targetXPath = (NamespacedProperty)eResolveProxy(oldTargetXPath);
			if (targetXPath != oldTargetXPath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XQUERY_MEDIATOR__TARGET_XPATH, oldTargetXPath, targetXPath));
			}
		}
		return targetXPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetTargetXPath() {
		return targetXPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetXPath(NamespacedProperty newTargetXPath) {
		NamespacedProperty oldTargetXPath = targetXPath;
		targetXPath = newTargetXPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_MEDIATOR__TARGET_XPATH, oldTargetXPath, targetXPath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getScriptKeyType() {
		return scriptKeyType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptKeyType(KeyType newScriptKeyType) {
		KeyType oldScriptKeyType = scriptKeyType;
		scriptKeyType = newScriptKeyType == null ? SCRIPT_KEY_TYPE_EDEFAULT : newScriptKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE, oldScriptKeyType, scriptKeyType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getStaticScriptKey() {
		if (staticScriptKey != null && staticScriptKey.eIsProxy()) {
			InternalEObject oldStaticScriptKey = (InternalEObject)staticScriptKey;
			staticScriptKey = (RegistryKeyProperty)eResolveProxy(oldStaticScriptKey);
			if (staticScriptKey != oldStaticScriptKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, oldStaticScriptKey, staticScriptKey));
			}
		}
		return staticScriptKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetStaticScriptKey() {
		return staticScriptKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticScriptKey(RegistryKeyProperty newStaticScriptKey) {
		RegistryKeyProperty oldStaticScriptKey = staticScriptKey;
		staticScriptKey = newStaticScriptKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, oldStaticScriptKey, staticScriptKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getDynamicScriptKey() {
		if (dynamicScriptKey != null && dynamicScriptKey.eIsProxy()) {
			InternalEObject oldDynamicScriptKey = (InternalEObject)dynamicScriptKey;
			dynamicScriptKey = (NamespacedProperty)eResolveProxy(oldDynamicScriptKey);
			if (dynamicScriptKey != oldDynamicScriptKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, oldDynamicScriptKey, dynamicScriptKey));
			}
		}
		return dynamicScriptKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetDynamicScriptKey() {
		return dynamicScriptKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicScriptKey(NamespacedProperty newDynamicScriptKey) {
		NamespacedProperty oldDynamicScriptKey = dynamicScriptKey;
		dynamicScriptKey = newDynamicScriptKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, oldDynamicScriptKey, dynamicScriptKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getQueryKey() {
		if (queryKey != null && queryKey.eIsProxy()) {
			InternalEObject oldQueryKey = (InternalEObject)queryKey;
			queryKey = (RegistryKeyProperty)eResolveProxy(oldQueryKey);
			if (queryKey != oldQueryKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XQUERY_MEDIATOR__QUERY_KEY, oldQueryKey, queryKey));
			}
		}
		return queryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetQueryKey() {
		return queryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryKey(RegistryKeyProperty newQueryKey) {
		RegistryKeyProperty oldQueryKey = queryKey;
		queryKey = newQueryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XQUERY_MEDIATOR__QUERY_KEY, oldQueryKey, queryKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XQueryVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<XQueryVariable>(XQueryVariable.class, this, MediatorsPackage.XQUERY_MEDIATOR__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.XQUERY_MEDIATOR__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.XQUERY_MEDIATOR__VARIABLES:
				return getVariables();
			case MediatorsPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				if (resolve) return getTargetXPath();
				return basicGetTargetXPath();
			case MediatorsPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				return getScriptKeyType();
			case MediatorsPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				if (resolve) return getStaticScriptKey();
				return basicGetStaticScriptKey();
			case MediatorsPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				if (resolve) return getDynamicScriptKey();
				return basicGetDynamicScriptKey();
			case MediatorsPackage.XQUERY_MEDIATOR__QUERY_KEY:
				if (resolve) return getQueryKey();
				return basicGetQueryKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.XQUERY_MEDIATOR__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends XQueryVariable>)newValue);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				setTargetXPath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				setScriptKeyType((KeyType)newValue);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				setStaticScriptKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				setDynamicScriptKey((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__QUERY_KEY:
				setQueryKey((RegistryKeyProperty)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.XQUERY_MEDIATOR__VARIABLES:
				getVariables().clear();
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				setTargetXPath((NamespacedProperty)null);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				setScriptKeyType(SCRIPT_KEY_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				setStaticScriptKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				setDynamicScriptKey((NamespacedProperty)null);
				return;
			case MediatorsPackage.XQUERY_MEDIATOR__QUERY_KEY:
				setQueryKey((RegistryKeyProperty)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.XQUERY_MEDIATOR__VARIABLES:
				return variables != null && !variables.isEmpty();
			case MediatorsPackage.XQUERY_MEDIATOR__TARGET_XPATH:
				return targetXPath != null;
			case MediatorsPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				return scriptKeyType != SCRIPT_KEY_TYPE_EDEFAULT;
			case MediatorsPackage.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY:
				return staticScriptKey != null;
			case MediatorsPackage.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY:
				return dynamicScriptKey != null;
			case MediatorsPackage.XQUERY_MEDIATOR__QUERY_KEY:
				return queryKey != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (scriptKeyType: ");
		result.append(scriptKeyType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		switch (getCurrentEsbVersion()) {
		case ESB301:	
			if (null == getQueryKey().getKeyValue() || getQueryKey().getKeyValue().trim().isEmpty()) {
				validateMap.put("Script Key","Script Key is empty");
			}
			break;
		case ESB400:
			switch (getScriptKeyType()) {
			case STATIC:
				if (null == getStaticScriptKey().getKeyValue() || getStaticScriptKey().getKeyValue().trim().isEmpty()) {
					validateMap.put("Script Key","Script Key is empty");
				}
				break;
			case DYNAMIC:
				if (null == getDynamicScriptKey().getPropertyValue() || getDynamicScriptKey().getPropertyValue().trim().isEmpty()) {
					validateMap.put("Script Key","Script Key is empty");
				}
				break;
			}
		}
		
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("XQuery Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} // XQueryMediatorImpl
