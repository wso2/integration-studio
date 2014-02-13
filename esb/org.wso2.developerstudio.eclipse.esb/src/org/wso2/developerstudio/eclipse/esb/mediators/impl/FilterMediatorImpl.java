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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterElseBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterThenBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FilterMediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl#getConditionType <em>Condition Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl#getFilterXpath <em>Filter Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl#getFilterSource <em>Filter Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl#getFilterRegex <em>Filter Regex</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl#getThenBranch <em>Then Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl#getElseBranch <em>Else Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilterMediatorImpl extends MediatorImpl implements FilterMediator {
	/**
	 * The default value of the '{@link #getConditionType() <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionType()
	 * @generated
	 * @ordered
	 */
	protected static final FilterConditionType CONDITION_TYPE_EDEFAULT = FilterConditionType.XPATH;

	/**
	 * The cached value of the '{@link #getConditionType() <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionType()
	 * @generated
	 * @ordered
	 */
	protected FilterConditionType conditionType = CONDITION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilterXpath() <em>Filter Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty filterXpath;

				/**
	 * The cached value of the '{@link #getFilterSource() <em>Filter Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterSource()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty filterSource;

				/**
	 * The default value of the '{@link #getFilterRegex() <em>Filter Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_REGEX_EDEFAULT = "http://localhost:9000.*";

				/**
	 * The cached value of the '{@link #getFilterRegex() <em>Filter Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterRegex()
	 * @generated
	 * @ordered
	 */
	protected String filterRegex = FILTER_REGEX_EDEFAULT;

				/**
	 * The default value of the '{@link #getXPath() <em>XPath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXPath()
	 * @ordered
	 */
	protected static final String XPATH_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getRegularExpression() <em>Regular Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegularExpression()
	 * @ordered
	 */
	protected static final String REGULAR_EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getThenBranch() <em>Then Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenBranch()
	 * @generated
	 * @ordered
	 */
	protected FilterThenBranch thenBranch;

	/**
	 * The cached value of the '{@link #getElseBranch() <em>Else Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseBranch()
	 * @generated
	 * @ordered
	 */
	protected FilterElseBranch elseBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected FilterMediatorImpl() {
		super();
		
		// Filter xpath.
		NamespacedProperty xpath = getEsbFactory().createNamespacedProperty();
		xpath.setPrettyName("XPath");
		xpath.setPropertyName("xpath");
		xpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setFilterXpath(xpath);

		// Source.
		NamespacedProperty source = getEsbFactory().createNamespacedProperty();
		source.setPrettyName("Source");
		source.setPropertyName("source");
		source.setPropertyValue("get-property('To')");
		setFilterSource(source);
		
		setThenBranch(getMediatorFactory().createFilterThenBranch());
		setElseBranch(getMediatorFactory().createFilterElseBranch());
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		if (self.hasAttribute("xpath")) {
			setConditionType(FilterConditionType.XPATH);
			getFilterXpath().load(self);
		} else if (self.hasAttribute("source")) {
			setConditionType(FilterConditionType.SOURCE_AND_REGULAR_EXPRESSION);
			getFilterSource().load(self);
			setFilterRegex(self.getAttribute("regex"));
		} else {
			throw new Exception("Expected either xpath or source attribute.");
		}
		
		Element thenElem = getChildElement(self, "then");
		if (null != thenElem) {			
			loadObject(thenElem, FilterThenBranch.class, true, new ObjectHandler<FilterThenBranch>() {
				public void handle(FilterThenBranch object) {
					setThenBranch(object);
				}				
			});			
			
			loadObject(self, "else", FilterElseBranch.class, false, new ObjectHandler<FilterElseBranch>() {
				public void handle(FilterElseBranch object) {
					setElseBranch(object);
				}				
			});			
		} else {
			FilterThenBranch thenBranch = getMediatorFactory().createFilterThenBranch();

			// Here we have to pass the self element because there is no <then/> child element.
			thenBranch.load(self);
			
			setThenBranch(thenBranch);
		}	
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "filter");
		if (getConditionType().equals(FilterConditionType.XPATH)) {
			getFilterXpath().save(self);
		} else {
			getFilterSource().save(self);
			self.setAttribute("regex", getFilterRegex());
		}			
		getThenBranch().save(self);
		getElseBranch().save(self);	
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
		return MediatorsPackage.Literals.FILTER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterConditionType getConditionType() {
		return conditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionType(FilterConditionType newConditionType) {
		FilterConditionType oldConditionType = conditionType;
		conditionType = newConditionType == null ? CONDITION_TYPE_EDEFAULT : newConditionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__CONDITION_TYPE, oldConditionType, conditionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFilterXpath() {
		return filterXpath;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFilterXpath(NamespacedProperty newFilterXpath, NotificationChain msgs) {
		NamespacedProperty oldFilterXpath = filterXpath;
		filterXpath = newFilterXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH, oldFilterXpath, newFilterXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterXpath(NamespacedProperty newFilterXpath) {
		if (newFilterXpath != filterXpath) {
			NotificationChain msgs = null;
			if (filterXpath != null)
				msgs = ((InternalEObject)filterXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH, null, msgs);
			if (newFilterXpath != null)
				msgs = ((InternalEObject)newFilterXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH, null, msgs);
			msgs = basicSetFilterXpath(newFilterXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH, newFilterXpath, newFilterXpath));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFilterSource() {
		return filterSource;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFilterSource(NamespacedProperty newFilterSource, NotificationChain msgs) {
		NamespacedProperty oldFilterSource = filterSource;
		filterSource = newFilterSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE, oldFilterSource, newFilterSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterSource(NamespacedProperty newFilterSource) {
		if (newFilterSource != filterSource) {
			NotificationChain msgs = null;
			if (filterSource != null)
				msgs = ((InternalEObject)filterSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE, null, msgs);
			if (newFilterSource != null)
				msgs = ((InternalEObject)newFilterSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE, null, msgs);
			msgs = basicSetFilterSource(newFilterSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE, newFilterSource, newFilterSource));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilterRegex() {
		return filterRegex;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterRegex(String newFilterRegex) {
		String oldFilterRegex = filterRegex;
		filterRegex = newFilterRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__FILTER_REGEX, oldFilterRegex, filterRegex));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterThenBranch getThenBranch() {
		return thenBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenBranch(FilterThenBranch newThenBranch, NotificationChain msgs) {
		FilterThenBranch oldThenBranch = thenBranch;
		thenBranch = newThenBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH, oldThenBranch, newThenBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenBranch(FilterThenBranch newThenBranch) {
		if (newThenBranch != thenBranch) {
			NotificationChain msgs = null;
			if (thenBranch != null)
				msgs = ((InternalEObject)thenBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH, null, msgs);
			if (newThenBranch != null)
				msgs = ((InternalEObject)newThenBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH, null, msgs);
			msgs = basicSetThenBranch(newThenBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH, newThenBranch, newThenBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterElseBranch getElseBranch() {
		return elseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseBranch(FilterElseBranch newElseBranch, NotificationChain msgs) {
		FilterElseBranch oldElseBranch = elseBranch;
		elseBranch = newElseBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH, oldElseBranch, newElseBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseBranch(FilterElseBranch newElseBranch) {
		if (newElseBranch != elseBranch) {
			NotificationChain msgs = null;
			if (elseBranch != null)
				msgs = ((InternalEObject)elseBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH, null, msgs);
			if (newElseBranch != null)
				msgs = ((InternalEObject)newElseBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH, null, msgs);
			msgs = basicSetElseBranch(newElseBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH, newElseBranch, newElseBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH:
				return basicSetFilterXpath(null, msgs);
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE:
				return basicSetFilterSource(null, msgs);
			case MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH:
				return basicSetThenBranch(null, msgs);
			case MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH:
				return basicSetElseBranch(null, msgs);
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
			case MediatorsPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				return getConditionType();
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH:
				return getFilterXpath();
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE:
				return getFilterSource();
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_REGEX:
				return getFilterRegex();
			case MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH:
				return getThenBranch();
			case MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH:
				return getElseBranch();
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
			case MediatorsPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				setConditionType((FilterConditionType)newValue);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH:
				setFilterXpath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE:
				setFilterSource((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_REGEX:
				setFilterRegex((String)newValue);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH:
				setThenBranch((FilterThenBranch)newValue);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH:
				setElseBranch((FilterElseBranch)newValue);
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
			case MediatorsPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				setConditionType(CONDITION_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH:
				setFilterXpath((NamespacedProperty)null);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE:
				setFilterSource((NamespacedProperty)null);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_REGEX:
				setFilterRegex(FILTER_REGEX_EDEFAULT);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH:
				setThenBranch((FilterThenBranch)null);
				return;
			case MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH:
				setElseBranch((FilterElseBranch)null);
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
			case MediatorsPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				return conditionType != CONDITION_TYPE_EDEFAULT;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_XPATH:
				return filterXpath != null;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_SOURCE:
				return filterSource != null;
			case MediatorsPackage.FILTER_MEDIATOR__FILTER_REGEX:
				return FILTER_REGEX_EDEFAULT == null ? filterRegex != null : !FILTER_REGEX_EDEFAULT.equals(filterRegex);
			case MediatorsPackage.FILTER_MEDIATOR__THEN_BRANCH:
				return thenBranch != null;
			case MediatorsPackage.FILTER_MEDIATOR__ELSE_BRANCH:
				return elseBranch != null;
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
		result.append(" (conditionType: ");
		result.append(conditionType);
		result.append(", filterRegex: ");
		result.append(filterRegex);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (getConditionType().equals(FilterConditionType.XPATH)) {
			if (null == getFilterXpath().getPropertyValue() || getFilterXpath().getPropertyValue().trim().isEmpty()) {
				validateMap.put("XPath","XPath is empty");
			}
		} else {
			if (null == getFilterSource().getPropertyValue() || getFilterSource().getPropertyValue().trim().isEmpty()) {
				validateMap.put("Source","Source is empty");
			}
			if (null == getFilterRegex() || getFilterRegex().trim().isEmpty()) {
				validateMap.put("Regular expression","Regular expression is empty");
			}
		}	
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Filter Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} //FilterMediatorImpl
