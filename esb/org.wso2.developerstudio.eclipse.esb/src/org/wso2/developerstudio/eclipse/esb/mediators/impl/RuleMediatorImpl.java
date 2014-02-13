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
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleChildMediatorsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl#getRuleSetConfiguration <em>Rule Set Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl#getRuleSessionConfiguration <em>Rule Session Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl#getFactsConfiguration <em>Facts Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl#getResultsConfiguration <em>Results Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl#getChildMediatorsConfiguration <em>Child Mediators Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleMediatorImpl extends MediatorImpl implements RuleMediator {
	/**
	 * The cached value of the '{@link #getRuleSetConfiguration() <em>Rule Set Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleSetConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RuleSetConfiguration ruleSetConfiguration;

	/**
	 * The cached value of the '{@link #getRuleSessionConfiguration() <em>Rule Session Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleSessionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RuleSessionConfiguration ruleSessionConfiguration;

	/**
	 * The cached value of the '{@link #getFactsConfiguration() <em>Facts Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactsConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RuleFactsConfiguration factsConfiguration;

	/**
	 * The cached value of the '{@link #getResultsConfiguration() <em>Results Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultsConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RuleResultsConfiguration resultsConfiguration;

	/**
	 * The cached value of the '{@link #getChildMediatorsConfiguration() <em>Child Mediators Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildMediatorsConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RuleChildMediatorsConfiguration childMediatorsConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected RuleMediatorImpl() {
		super();
		
		// Configuration elements.
		setRuleSetConfiguration(getMediatorFactory().createRuleSetConfiguration());
		setRuleSessionConfiguration(getMediatorFactory().createRuleSessionConfiguration());
		setFactsConfiguration(getMediatorFactory().createRuleFactsConfiguration());
		setResultsConfiguration(getMediatorFactory().createRuleResultsConfiguration());
		setChildMediatorsConfiguration(getMediatorFactory().createRuleChildMediatorsConfiguration());
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		loadObject(self, "ruleset", RuleSetConfiguration.class, true, 
				new ObjectHandler<RuleSetConfiguration>() {
					public void handle(RuleSetConfiguration object) {
						setRuleSetConfiguration(object);
					}
				});
		
		if (self.getOwnerDocument().getElementById("session") != null) {
		loadObject(self, "session", RuleSessionConfiguration.class, true,
				new ObjectHandler<RuleSessionConfiguration>() {
					public void handle(RuleSessionConfiguration object) {
						setRuleSessionConfiguration(object);
					}
				});
		}
		
		loadObject(self, "facts", RuleFactsConfiguration.class, true, 
				new ObjectHandler<RuleFactsConfiguration>() {
					public void handle(RuleFactsConfiguration object) {
						setFactsConfiguration(object);
					}
				});
		
		if (self.getOwnerDocument().getElementById("results") != null) {
		loadObject(self, "results", RuleResultsConfiguration.class, true,
				new ObjectHandler<RuleResultsConfiguration>() {
					public void handle(RuleResultsConfiguration object) {
						setResultsConfiguration(object);
					}
				});
		}
		
		loadObject(self, "childMediators", RuleChildMediatorsConfiguration.class, false,
				new ObjectHandler<RuleChildMediatorsConfiguration>() {
					public void handle(RuleChildMediatorsConfiguration object) {
						setChildMediatorsConfiguration(object);
					}
				});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "rule");
		getRuleSetConfiguration().save(self);
		getRuleSessionConfiguration().save(self);
		getFactsConfiguration().save(self);
		getResultsConfiguration().save(self);
		getChildMediatorsConfiguration().save(self);
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
		return MediatorsPackage.Literals.RULE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSetConfiguration getRuleSetConfiguration() {
		return ruleSetConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRuleSetConfiguration(RuleSetConfiguration newRuleSetConfiguration, NotificationChain msgs) {
		RuleSetConfiguration oldRuleSetConfiguration = ruleSetConfiguration;
		ruleSetConfiguration = newRuleSetConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION, oldRuleSetConfiguration, newRuleSetConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleSetConfiguration(RuleSetConfiguration newRuleSetConfiguration) {
		if (newRuleSetConfiguration != ruleSetConfiguration) {
			NotificationChain msgs = null;
			if (ruleSetConfiguration != null)
				msgs = ((InternalEObject)ruleSetConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION, null, msgs);
			if (newRuleSetConfiguration != null)
				msgs = ((InternalEObject)newRuleSetConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION, null, msgs);
			msgs = basicSetRuleSetConfiguration(newRuleSetConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION, newRuleSetConfiguration, newRuleSetConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSessionConfiguration getRuleSessionConfiguration() {
		return ruleSessionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRuleSessionConfiguration(RuleSessionConfiguration newRuleSessionConfiguration, NotificationChain msgs) {
		RuleSessionConfiguration oldRuleSessionConfiguration = ruleSessionConfiguration;
		ruleSessionConfiguration = newRuleSessionConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION, oldRuleSessionConfiguration, newRuleSessionConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleSessionConfiguration(RuleSessionConfiguration newRuleSessionConfiguration) {
		if (newRuleSessionConfiguration != ruleSessionConfiguration) {
			NotificationChain msgs = null;
			if (ruleSessionConfiguration != null)
				msgs = ((InternalEObject)ruleSessionConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION, null, msgs);
			if (newRuleSessionConfiguration != null)
				msgs = ((InternalEObject)newRuleSessionConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION, null, msgs);
			msgs = basicSetRuleSessionConfiguration(newRuleSessionConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION, newRuleSessionConfiguration, newRuleSessionConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFactsConfiguration getFactsConfiguration() {
		return factsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFactsConfiguration(RuleFactsConfiguration newFactsConfiguration, NotificationChain msgs) {
		RuleFactsConfiguration oldFactsConfiguration = factsConfiguration;
		factsConfiguration = newFactsConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION, oldFactsConfiguration, newFactsConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactsConfiguration(RuleFactsConfiguration newFactsConfiguration) {
		if (newFactsConfiguration != factsConfiguration) {
			NotificationChain msgs = null;
			if (factsConfiguration != null)
				msgs = ((InternalEObject)factsConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION, null, msgs);
			if (newFactsConfiguration != null)
				msgs = ((InternalEObject)newFactsConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION, null, msgs);
			msgs = basicSetFactsConfiguration(newFactsConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION, newFactsConfiguration, newFactsConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResultsConfiguration getResultsConfiguration() {
		return resultsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultsConfiguration(RuleResultsConfiguration newResultsConfiguration, NotificationChain msgs) {
		RuleResultsConfiguration oldResultsConfiguration = resultsConfiguration;
		resultsConfiguration = newResultsConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION, oldResultsConfiguration, newResultsConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultsConfiguration(RuleResultsConfiguration newResultsConfiguration) {
		if (newResultsConfiguration != resultsConfiguration) {
			NotificationChain msgs = null;
			if (resultsConfiguration != null)
				msgs = ((InternalEObject)resultsConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION, null, msgs);
			if (newResultsConfiguration != null)
				msgs = ((InternalEObject)newResultsConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION, null, msgs);
			msgs = basicSetResultsConfiguration(newResultsConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION, newResultsConfiguration, newResultsConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleChildMediatorsConfiguration getChildMediatorsConfiguration() {
		return childMediatorsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChildMediatorsConfiguration(RuleChildMediatorsConfiguration newChildMediatorsConfiguration, NotificationChain msgs) {
		RuleChildMediatorsConfiguration oldChildMediatorsConfiguration = childMediatorsConfiguration;
		childMediatorsConfiguration = newChildMediatorsConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION, oldChildMediatorsConfiguration, newChildMediatorsConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildMediatorsConfiguration(RuleChildMediatorsConfiguration newChildMediatorsConfiguration) {
		if (newChildMediatorsConfiguration != childMediatorsConfiguration) {
			NotificationChain msgs = null;
			if (childMediatorsConfiguration != null)
				msgs = ((InternalEObject)childMediatorsConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION, null, msgs);
			if (newChildMediatorsConfiguration != null)
				msgs = ((InternalEObject)newChildMediatorsConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION, null, msgs);
			msgs = basicSetChildMediatorsConfiguration(newChildMediatorsConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION, newChildMediatorsConfiguration, newChildMediatorsConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION:
				return basicSetRuleSetConfiguration(null, msgs);
			case MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION:
				return basicSetRuleSessionConfiguration(null, msgs);
			case MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION:
				return basicSetFactsConfiguration(null, msgs);
			case MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION:
				return basicSetResultsConfiguration(null, msgs);
			case MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION:
				return basicSetChildMediatorsConfiguration(null, msgs);
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
			case MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION:
				return getRuleSetConfiguration();
			case MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION:
				return getRuleSessionConfiguration();
			case MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION:
				return getFactsConfiguration();
			case MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION:
				return getResultsConfiguration();
			case MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION:
				return getChildMediatorsConfiguration();
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
			case MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION:
				setRuleSetConfiguration((RuleSetConfiguration)newValue);
				return;
			case MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION:
				setRuleSessionConfiguration((RuleSessionConfiguration)newValue);
				return;
			case MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION:
				setFactsConfiguration((RuleFactsConfiguration)newValue);
				return;
			case MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION:
				setResultsConfiguration((RuleResultsConfiguration)newValue);
				return;
			case MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION:
				setChildMediatorsConfiguration((RuleChildMediatorsConfiguration)newValue);
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
			case MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION:
				setRuleSetConfiguration((RuleSetConfiguration)null);
				return;
			case MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION:
				setRuleSessionConfiguration((RuleSessionConfiguration)null);
				return;
			case MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION:
				setFactsConfiguration((RuleFactsConfiguration)null);
				return;
			case MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION:
				setResultsConfiguration((RuleResultsConfiguration)null);
				return;
			case MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION:
				setChildMediatorsConfiguration((RuleChildMediatorsConfiguration)null);
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
			case MediatorsPackage.RULE_MEDIATOR__RULE_SET_CONFIGURATION:
				return ruleSetConfiguration != null;
			case MediatorsPackage.RULE_MEDIATOR__RULE_SESSION_CONFIGURATION:
				return ruleSessionConfiguration != null;
			case MediatorsPackage.RULE_MEDIATOR__FACTS_CONFIGURATION:
				return factsConfiguration != null;
			case MediatorsPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION:
				return resultsConfiguration != null;
			case MediatorsPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION:
				return childMediatorsConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
    	return new HashMap<String, ObjectValidator>();
    }

} //RuleMediatorImpl
