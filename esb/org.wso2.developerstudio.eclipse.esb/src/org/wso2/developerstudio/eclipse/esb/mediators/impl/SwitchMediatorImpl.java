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
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.SwitchDefaultBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SwitchMediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl#getCaseBranches <em>Case Branches</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl#getDefaultBranch <em>Default Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchMediatorImpl extends MediatorImpl implements SwitchMediator {
	/**
	 * The cached value of the '{@link #getSourceXpath() <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty sourceXpath;

	/**
	 * The default value of the '{@link #getSourceXPath() <em>Source XPath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXPath()
	 * @ordered
	 */
	protected static final String SOURCE_XPATH_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getCaseBranches() <em>Case Branches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<SwitchCaseBranch> caseBranches;

	/**
	 * The cached value of the '{@link #getDefaultBranch() <em>Default Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultBranch()
	 * @generated
	 * @ordered
	 */
	protected SwitchDefaultBranch defaultBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SwitchMediatorImpl() {
		super();
		
		// Source xpath.
		NamespacedProperty sourceXpath = getEsbFactory().createNamespacedProperty();
		sourceXpath.setPrettyName("Source XPath");
		sourceXpath.setPropertyName("source");
		sourceXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setSourceXpath(sourceXpath);
	}	
	
	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		// Load the source xpath namespaced property.
		getSourceXpath().load(self);
		
		// Load all case branches.
		loadObjects(self, "case", SwitchCaseBranch.class, new ObjectHandler<SwitchCaseBranch>() {
			public void handle(SwitchCaseBranch object) {
				getCaseBranches().add(object);				
			}			
		});
		
		// Load the default branch.
		loadObject(self, "default", SwitchDefaultBranch.class, false, new ObjectHandler<SwitchDefaultBranch>() {
			public void handle(SwitchDefaultBranch object) {
				setDefaultBranch(object);
			}			
		});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "switch");		
		getSourceXpath().save(self);
		for (SwitchCaseBranch caseBranch : getCaseBranches()) {
			caseBranch.save(self);
		}
		if (null != getDefaultBranch()) {
			getDefaultBranch().save(self);
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
		return MediatorsPackage.Literals.SWITCH_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSourceXpath() {
		return sourceXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceXpath(NamespacedProperty newSourceXpath, NotificationChain msgs) {
		NamespacedProperty oldSourceXpath = sourceXpath;
		sourceXpath = newSourceXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH, oldSourceXpath, newSourceXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceXpath(NamespacedProperty newSourceXpath) {
		if (newSourceXpath != sourceXpath) {
			NotificationChain msgs = null;
			if (sourceXpath != null)
				msgs = ((InternalEObject)sourceXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH, null, msgs);
			if (newSourceXpath != null)
				msgs = ((InternalEObject)newSourceXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH, null, msgs);
			msgs = basicSetSourceXpath(newSourceXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH, newSourceXpath, newSourceXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SwitchCaseBranch> getCaseBranches() {
		if (caseBranches == null) {
			caseBranches = new EObjectContainmentEList<SwitchCaseBranch>(SwitchCaseBranch.class, this, MediatorsPackage.SWITCH_MEDIATOR__CASE_BRANCHES);
		}
		return caseBranches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchDefaultBranch getDefaultBranch() {
		return defaultBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultBranch(SwitchDefaultBranch newDefaultBranch, NotificationChain msgs) {
		SwitchDefaultBranch oldDefaultBranch = defaultBranch;
		defaultBranch = newDefaultBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH, oldDefaultBranch, newDefaultBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultBranch(SwitchDefaultBranch newDefaultBranch) {
		if (newDefaultBranch != defaultBranch) {
			NotificationChain msgs = null;
			if (defaultBranch != null)
				msgs = ((InternalEObject)defaultBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH, null, msgs);
			if (newDefaultBranch != null)
				msgs = ((InternalEObject)newDefaultBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH, null, msgs);
			msgs = basicSetDefaultBranch(newDefaultBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH, newDefaultBranch, newDefaultBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH:
				return basicSetSourceXpath(null, msgs);
			case MediatorsPackage.SWITCH_MEDIATOR__CASE_BRANCHES:
				return ((InternalEList<?>)getCaseBranches()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH:
				return basicSetDefaultBranch(null, msgs);
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
			case MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH:
				return getSourceXpath();
			case MediatorsPackage.SWITCH_MEDIATOR__CASE_BRANCHES:
				return getCaseBranches();
			case MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH:
				return getDefaultBranch();
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
			case MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.SWITCH_MEDIATOR__CASE_BRANCHES:
				getCaseBranches().clear();
				getCaseBranches().addAll((Collection<? extends SwitchCaseBranch>)newValue);
				return;
			case MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH:
				setDefaultBranch((SwitchDefaultBranch)newValue);
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
			case MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)null);
				return;
			case MediatorsPackage.SWITCH_MEDIATOR__CASE_BRANCHES:
				getCaseBranches().clear();
				return;
			case MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH:
				setDefaultBranch((SwitchDefaultBranch)null);
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
			case MediatorsPackage.SWITCH_MEDIATOR__SOURCE_XPATH:
				return sourceXpath != null;
			case MediatorsPackage.SWITCH_MEDIATOR__CASE_BRANCHES:
				return caseBranches != null && !caseBranches.isEmpty();
			case MediatorsPackage.SWITCH_MEDIATOR__DEFAULT_BRANCH:
				return defaultBranch != null;
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getSourceXpath().getPropertyValue() || getSourceXpath().getPropertyValue().trim().isEmpty()) {
			validateMap.put("Source Xpath","Source Xpath is empty");
		}
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Switch Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} //SwitchMediatorImpl
