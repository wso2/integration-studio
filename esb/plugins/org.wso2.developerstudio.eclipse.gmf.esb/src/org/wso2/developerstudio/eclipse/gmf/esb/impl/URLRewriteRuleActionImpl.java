/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URL Rewrite Rule Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleActionImpl#getRuleAction <em>Rule Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleActionImpl#getRuleFragment <em>Rule Fragment</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleActionImpl#getRuleOption <em>Rule Option</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleActionImpl#getActionExpression <em>Action Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleActionImpl#getActionValue <em>Action Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleActionImpl#getActionRegex <em>Action Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLRewriteRuleActionImpl extends EsbNodeImpl implements URLRewriteRuleAction {
	/**
	 * The default value of the '{@link #getRuleAction() <em>Rule Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleAction()
	 * @generated
	 * @ordered
	 */
	protected static final RuleActionType RULE_ACTION_EDEFAULT = RuleActionType.REPLACE;

	/**
	 * The cached value of the '{@link #getRuleAction() <em>Rule Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleAction()
	 * @generated
	 * @ordered
	 */
	protected RuleActionType ruleAction = RULE_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuleFragment() <em>Rule Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleFragment()
	 * @generated
	 * @ordered
	 */
	protected static final RuleFragmentType RULE_FRAGMENT_EDEFAULT = RuleFragmentType.PROTOCOL;

	/**
	 * The cached value of the '{@link #getRuleFragment() <em>Rule Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleFragment()
	 * @generated
	 * @ordered
	 */
	protected RuleFragmentType ruleFragment = RULE_FRAGMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuleOption() <em>Rule Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleOption()
	 * @generated
	 * @ordered
	 */
	protected static final RuleOptionType RULE_OPTION_EDEFAULT = RuleOptionType.VALUE;

	/**
	 * The cached value of the '{@link #getRuleOption() <em>Rule Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleOption()
	 * @generated
	 * @ordered
	 */
	protected RuleOptionType ruleOption = RULE_OPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActionExpression() <em>Action Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty actionExpression;

	/**
	 * The default value of the '{@link #getActionValue() <em>Action Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionValue()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionValue() <em>Action Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionValue()
	 * @generated
	 * @ordered
	 */
	protected String actionValue = ACTION_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionRegex() <em>Action Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionRegex() <em>Action Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionRegex()
	 * @generated
	 * @ordered
	 */
	protected String actionRegex = ACTION_REGEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URLRewriteRuleActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.URL_REWRITE_RULE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleActionType getRuleAction() {
		return ruleAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleAction(RuleActionType newRuleAction) {
		RuleActionType oldRuleAction = ruleAction;
		ruleAction = newRuleAction == null ? RULE_ACTION_EDEFAULT : newRuleAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION, oldRuleAction, ruleAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFragmentType getRuleFragment() {
		return ruleFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleFragment(RuleFragmentType newRuleFragment) {
		RuleFragmentType oldRuleFragment = ruleFragment;
		ruleFragment = newRuleFragment == null ? RULE_FRAGMENT_EDEFAULT : newRuleFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT, oldRuleFragment, ruleFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleOptionType getRuleOption() {
		return ruleOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleOption(RuleOptionType newRuleOption) {
		RuleOptionType oldRuleOption = ruleOption;
		ruleOption = newRuleOption == null ? RULE_OPTION_EDEFAULT : newRuleOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION, oldRuleOption, ruleOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getActionExpression() {
		return actionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionExpression(NamespacedProperty newActionExpression, NotificationChain msgs) {
		NamespacedProperty oldActionExpression = actionExpression;
		actionExpression = newActionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION, oldActionExpression, newActionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionExpression(NamespacedProperty newActionExpression) {
		if (newActionExpression != actionExpression) {
			NotificationChain msgs = null;
			if (actionExpression != null)
				msgs = ((InternalEObject)actionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION, null, msgs);
			if (newActionExpression != null)
				msgs = ((InternalEObject)newActionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION, null, msgs);
			msgs = basicSetActionExpression(newActionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION, newActionExpression, newActionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionValue() {
		return actionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionValue(String newActionValue) {
		String oldActionValue = actionValue;
		actionValue = newActionValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE, oldActionValue, actionValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionRegex() {
		return actionRegex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionRegex(String newActionRegex) {
		String oldActionRegex = actionRegex;
		actionRegex = newActionRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX, oldActionRegex, actionRegex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				return basicSetActionExpression(null, msgs);
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
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				return getRuleAction();
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				return getRuleFragment();
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				return getRuleOption();
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				return getActionExpression();
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				return getActionValue();
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				return getActionRegex();
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
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				setRuleAction((RuleActionType)newValue);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				setRuleFragment((RuleFragmentType)newValue);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				setRuleOption((RuleOptionType)newValue);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				setActionExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				setActionValue((String)newValue);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				setActionRegex((String)newValue);
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
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				setRuleAction(RULE_ACTION_EDEFAULT);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				setRuleFragment(RULE_FRAGMENT_EDEFAULT);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				setRuleOption(RULE_OPTION_EDEFAULT);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				setActionExpression((NamespacedProperty)null);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				setActionValue(ACTION_VALUE_EDEFAULT);
				return;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				setActionRegex(ACTION_REGEX_EDEFAULT);
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
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_ACTION:
				return ruleAction != RULE_ACTION_EDEFAULT;
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT:
				return ruleFragment != RULE_FRAGMENT_EDEFAULT;
			case EsbPackage.URL_REWRITE_RULE_ACTION__RULE_OPTION:
				return ruleOption != RULE_OPTION_EDEFAULT;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION:
				return actionExpression != null;
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_VALUE:
				return ACTION_VALUE_EDEFAULT == null ? actionValue != null : !ACTION_VALUE_EDEFAULT.equals(actionValue);
			case EsbPackage.URL_REWRITE_RULE_ACTION__ACTION_REGEX:
				return ACTION_REGEX_EDEFAULT == null ? actionRegex != null : !ACTION_REGEX_EDEFAULT.equals(actionRegex);
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

} //URLRewriteRuleActionImpl
