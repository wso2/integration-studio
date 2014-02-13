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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.w3c.dom.Element;


import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>URL Rewrite Rule Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl#getRuleAction <em>Rule Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl#getRuleFragment <em>Rule Fragment</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl#getRuleOption <em>Rule Option</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl#getActionExpression <em>Action Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl#getActionValue <em>Action Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl#getActionRegex <em>Action Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLRewriteRuleActionImpl extends ModelObjectImpl implements
		URLRewriteRuleAction {
	/**
	 * The default value of the '{@link #getRuleAction() <em>Rule Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRuleAction()
	 * @generated
	 * @ordered
	 */
	protected static final RuleActionType RULE_ACTION_EDEFAULT = RuleActionType.REPLACE;

	/**
	 * The cached value of the '{@link #getRuleAction() <em>Rule Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRuleAction()
	 * @generated
	 * @ordered
	 */
	protected RuleActionType ruleAction = RULE_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuleFragment() <em>Rule Fragment</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRuleFragment()
	 * @generated
	 * @ordered
	 */
	protected static final RuleFragmentType RULE_FRAGMENT_EDEFAULT = RuleFragmentType.PROTOCOL;

	/**
	 * The cached value of the '{@link #getRuleFragment() <em>Rule Fragment</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRuleFragment()
	 * @generated
	 * @ordered
	 */
	protected RuleFragmentType ruleFragment = RULE_FRAGMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuleOption() <em>Rule Option</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRuleOption()
	 * @generated
	 * @ordered
	 */
	protected static final RuleOptionType RULE_OPTION_EDEFAULT = RuleOptionType.VALUE;

	/**
	 * The cached value of the '{@link #getRuleOption() <em>Rule Option</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRuleOption()
	 * @generated
	 * @ordered
	 */
	protected RuleOptionType ruleOption = RULE_OPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActionExpression() <em>Action Expression</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getActionExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty actionExpression;

	/**
	 * The default value of the '{@link #getActionValue() <em>Action Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionValue()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getActionValue() <em>Action Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionValue()
	 * @generated
	 * @ordered
	 */
	protected String actionValue = ACTION_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionRegex() <em>Action Regex</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_REGEX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getActionRegex() <em>Action Regex</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionRegex()
	 * @generated
	 * @ordered
	 */
	protected String actionRegex = ACTION_REGEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	protected URLRewriteRuleActionImpl() {
		super();
		// Rule Action Expression
		actionExpression = getEsbFactory().createNamespacedProperty();
		actionExpression.setPropertyName("xpath");
		actionExpression.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		actionExpression.setPrettyName("Xpath");
		setActionExpression(actionExpression);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("type")) {
			String attributeValue = self.getAttribute("type");
			if (attributeValue == null) {
				attributeValue = "";
			}
			attributeValue = attributeValue.trim();
			if (attributeValue.equalsIgnoreCase("replace")) {
				setRuleAction(RuleActionType.REPLACE);
			} else if (attributeValue.equalsIgnoreCase("remove")) {
				setRuleAction(RuleActionType.REMOVE);
			} else if (attributeValue.equalsIgnoreCase("append")) {
				setRuleAction(RuleActionType.APPEND);
			} else if (attributeValue.equalsIgnoreCase("prepend")) {
				setRuleAction(RuleActionType.PREPEND);
			} else if (attributeValue.equalsIgnoreCase("set")) {
				setRuleAction(RuleActionType.SET);
			} else {
				setRuleAction(RuleActionType.REPLACE);
			}
		} else {
			setRuleAction(RuleActionType.REPLACE);
		}

		if (self.hasAttribute("fragment")) {
			String fragmentAttributeValue = self.getAttribute("fragment");
			if (fragmentAttributeValue == null) {
				fragmentAttributeValue = "";
			}
			fragmentAttributeValue = fragmentAttributeValue.trim();
			if (fragmentAttributeValue.equalsIgnoreCase("protocol")) {
				setRuleFragment(RuleFragmentType.PROTOCOL);
			} else if (fragmentAttributeValue.equalsIgnoreCase("host")) {
				setRuleFragment(RuleFragmentType.HOST);
			} else if (fragmentAttributeValue.equalsIgnoreCase("port")) {
				setRuleFragment(RuleFragmentType.PORT);
			} else if (fragmentAttributeValue.equalsIgnoreCase("path")) {
				setRuleFragment(RuleFragmentType.PATH);
			} else if (fragmentAttributeValue.equalsIgnoreCase("query")) {
				setRuleFragment(RuleFragmentType.QUERY);
			} else if (fragmentAttributeValue.equalsIgnoreCase("ref")) {
				setRuleFragment(RuleFragmentType.REF);
			} else if (fragmentAttributeValue.equalsIgnoreCase("user")) {
				setRuleFragment(RuleFragmentType.USER);
			} else if (fragmentAttributeValue.equalsIgnoreCase("full")) {
				setRuleFragment(RuleFragmentType.FULL);
			} else {
				setRuleFragment(RuleFragmentType.PROTOCOL);
			}
		} else {
			setRuleFragment(RuleFragmentType.PROTOCOL);
		}

		if (self.hasAttribute("value")) {
			String valueAttributeValue = self.getAttribute("value");
			if (valueAttributeValue == null) {
				valueAttributeValue = "";
			}
			valueAttributeValue = valueAttributeValue.trim();
			setRuleOption(RuleOptionType.VALUE);
			setActionValue(valueAttributeValue);
		}

		if (self.hasAttribute("xpath")) {
			String xpathAttributeValue = self.getAttribute("xpath");
			if (xpathAttributeValue == null) {
				xpathAttributeValue = "";
			}
			xpathAttributeValue = xpathAttributeValue.trim();
			setRuleOption(RuleOptionType.EXPRESSION);
			getActionExpression().setPropertyValue(xpathAttributeValue);
		}
		if (self.hasAttribute("regex")) {
			String regexAttributeValue = self.getAttribute("regex");
			if (regexAttributeValue == null) {
				regexAttributeValue = "";
			}
			regexAttributeValue = regexAttributeValue.trim();

			setActionRegex(regexAttributeValue);
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "action");

		self.setAttribute("type", getRuleAction().getName().toLowerCase());

		switch (getRuleOption()) {
		case VALUE:
			if (null != getActionValue()) {
				self.setAttribute("value", getActionValue());
			}
			break;
		case EXPRESSION:
			if (null != getActionExpression().getPropertyValue()) {
				getActionExpression().save(self);
			}
			break;
		}

		self.setAttribute("fragment", getRuleFragment().getName().toLowerCase());
		if (null != getActionRegex()) {
			self.setAttribute("regex", getActionRegex());
		}

		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.URL_REWRITE_RULE_ACTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RuleActionType getRuleAction() {
		return ruleAction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleAction(RuleActionType newRuleAction) {
		RuleActionType oldRuleAction = ruleAction;
		ruleAction = newRuleAction == null ? RULE_ACTION_EDEFAULT : newRuleAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION, oldRuleAction, ruleAction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFragmentType getRuleFragment() {
		return ruleFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleFragment(RuleFragmentType newRuleFragment) {
		RuleFragmentType oldRuleFragment = ruleFragment;
		ruleFragment = newRuleFragment == null ? RULE_FRAGMENT_EDEFAULT : newRuleFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT, oldRuleFragment, ruleFragment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RuleOptionType getRuleOption() {
		return ruleOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleOption(RuleOptionType newRuleOption) {
		RuleOptionType oldRuleOption = ruleOption;
		ruleOption = newRuleOption == null ? RULE_OPTION_EDEFAULT : newRuleOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION, oldRuleOption, ruleOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getActionExpression() {
		if (actionExpression != null && actionExpression.eIsProxy()) {
			InternalEObject oldActionExpression = (InternalEObject)actionExpression;
			actionExpression = (NamespacedProperty)eResolveProxy(oldActionExpression);
			if (actionExpression != oldActionExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION, oldActionExpression, actionExpression));
			}
		}
		return actionExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetActionExpression() {
		return actionExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionExpression(NamespacedProperty newActionExpression) {
		NamespacedProperty oldActionExpression = actionExpression;
		actionExpression = newActionExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION, oldActionExpression, actionExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionValue() {
		return actionValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionValue(String newActionValue) {
		String oldActionValue = actionValue;
		actionValue = newActionValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE, oldActionValue, actionValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionRegex() {
		return actionRegex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionRegex(String newActionRegex) {
		String oldActionRegex = actionRegex;
		actionRegex = newActionRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX, oldActionRegex, actionRegex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				return getRuleAction();
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				return getRuleFragment();
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				return getRuleOption();
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				if (resolve) return getActionExpression();
				return basicGetActionExpression();
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				return getActionValue();
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				return getActionRegex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				setRuleAction((RuleActionType)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				setRuleFragment((RuleFragmentType)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				setRuleOption((RuleOptionType)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				setActionExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				setActionValue((String)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				setActionRegex((String)newValue);
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
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				setRuleAction(RULE_ACTION_EDEFAULT);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				setRuleFragment(RULE_FRAGMENT_EDEFAULT);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				setRuleOption(RULE_OPTION_EDEFAULT);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				setActionExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				setActionValue(ACTION_VALUE_EDEFAULT);
				return;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				setActionRegex(ACTION_REGEX_EDEFAULT);
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
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				return ruleAction != RULE_ACTION_EDEFAULT;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				return ruleFragment != RULE_FRAGMENT_EDEFAULT;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				return ruleOption != RULE_OPTION_EDEFAULT;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				return actionExpression != null;
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				return ACTION_VALUE_EDEFAULT == null ? actionValue != null : !ACTION_VALUE_EDEFAULT.equals(actionValue);
			case MediatorsPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				return ACTION_REGEX_EDEFAULT == null ? actionRegex != null : !ACTION_REGEX_EDEFAULT.equals(actionRegex);
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
		result.append(" (ruleAction: ");
		result.append(ruleAction);
		result.append(", ruleFragment: ");
		result.append(ruleFragment);
		result.append(", ruleOption: ");
		result.append(ruleOption);
		result.append(", actionValue: ");
		result.append(actionValue);
		result.append(", actionRegex: ");
		result.append(actionRegex);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

	

} // URLRewriteRuleActionImpl
