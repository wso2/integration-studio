/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URL Rewrite Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleImpl#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteRuleImpl#getRewriteRuleAction <em>Rewrite Rule Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLRewriteRuleImpl extends EsbNodeImpl implements URLRewriteRule {
	/**
	 * The cached value of the '{@link #getUrlRewriteRuleCondition() <em>Url Rewrite Rule Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlRewriteRuleCondition()
	 * @generated
	 * @ordered
	 */
	protected EvaluatorExpressionProperty urlRewriteRuleCondition;

	/**
	 * The cached value of the '{@link #getRewriteRuleAction() <em>Rewrite Rule Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRewriteRuleAction()
	 * @generated
	 * @ordered
	 */
	protected EList<URLRewriteRuleAction> rewriteRuleAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URLRewriteRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.URL_REWRITE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty getUrlRewriteRuleCondition() {
		return urlRewriteRuleCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUrlRewriteRuleCondition(EvaluatorExpressionProperty newUrlRewriteRuleCondition, NotificationChain msgs) {
		EvaluatorExpressionProperty oldUrlRewriteRuleCondition = urlRewriteRuleCondition;
		urlRewriteRuleCondition = newUrlRewriteRuleCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION, oldUrlRewriteRuleCondition, newUrlRewriteRuleCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlRewriteRuleCondition(EvaluatorExpressionProperty newUrlRewriteRuleCondition) {
		if (newUrlRewriteRuleCondition != urlRewriteRuleCondition) {
			NotificationChain msgs = null;
			if (urlRewriteRuleCondition != null)
				msgs = ((InternalEObject)urlRewriteRuleCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION, null, msgs);
			if (newUrlRewriteRuleCondition != null)
				msgs = ((InternalEObject)newUrlRewriteRuleCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION, null, msgs);
			msgs = basicSetUrlRewriteRuleCondition(newUrlRewriteRuleCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION, newUrlRewriteRuleCondition, newUrlRewriteRuleCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URLRewriteRuleAction> getRewriteRuleAction() {
		if (rewriteRuleAction == null) {
			rewriteRuleAction = new EObjectContainmentEList<URLRewriteRuleAction>(URLRewriteRuleAction.class, this, EsbPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION);
		}
		return rewriteRuleAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				return basicSetUrlRewriteRuleCondition(null, msgs);
			case EsbPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				return ((InternalEList<?>)getRewriteRuleAction()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				return getUrlRewriteRuleCondition();
			case EsbPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				return getRewriteRuleAction();
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
			case EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				setUrlRewriteRuleCondition((EvaluatorExpressionProperty)newValue);
				return;
			case EsbPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				getRewriteRuleAction().clear();
				getRewriteRuleAction().addAll((Collection<? extends URLRewriteRuleAction>)newValue);
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
			case EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				setUrlRewriteRuleCondition((EvaluatorExpressionProperty)null);
				return;
			case EsbPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				getRewriteRuleAction().clear();
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
			case EsbPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				return urlRewriteRuleCondition != null;
			case EsbPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				return rewriteRuleAction != null && !rewriteRuleAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //URLRewriteRuleImpl
