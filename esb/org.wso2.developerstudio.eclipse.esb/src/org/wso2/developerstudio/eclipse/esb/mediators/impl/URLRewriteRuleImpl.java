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


import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>URL Rewrite Rule</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleImpl#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleImpl#getRewriteRuleAction <em>Rewrite Rule Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLRewriteRuleImpl extends ModelObjectImpl implements
		URLRewriteRule {
	/**
	 * The cached value of the '{@link #getUrlRewriteRuleCondition() <em>Url Rewrite Rule Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlRewriteRuleCondition()
	 * @generated
	 * @ordered
	 */
	protected EvaluatorExpressionProperty urlRewriteRuleCondition;
	protected static final String URL_REWRITE_RULE_CONDITION = "<condition/>";
	/**
	 * The cached value of the '{@link #getRewriteRuleAction()
	 * <em>Rewrite Rule Action</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRewriteRuleAction()
	 * @generated
	 * @ordered
	 */
	protected EList<URLRewriteRuleAction> rewriteRuleAction;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	protected URLRewriteRuleImpl() {
		super();
		urlRewriteRuleCondition = getEsbFactory()
				.createEvaluatorExpressionProperty();
		urlRewriteRuleCondition.setPrettyName("Condition");
		urlRewriteRuleCondition.setEvaluatorName("condition");
		urlRewriteRuleCondition
				.setEvaluatorValue(DEFAULT_EVALUATOR_EXPRESSION_VALUE);
		setUrlRewriteRuleCondition(urlRewriteRuleCondition);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		Element conditionElem = getChildElement(self, "condition");
		if (null != conditionElem) {
			List<Element> children = getChildElements(conditionElem);
			if (!children.isEmpty()) {
				// Question: Do we have to consider all the child elements?
				getUrlRewriteRuleCondition().setEvaluatorValue(
						"<condition>"
								+ EsbUtils.renderElement(children.get(0), true,true)
								+ "</condition>");
			} else {
				getUrlRewriteRuleCondition().setEvaluatorValue(
						"<condition><condition>");
			}
		} else {
			getUrlRewriteRuleCondition().setEvaluatorValue(
					"<condition></condition>");
		}

		loadObjects(self, "action", URLRewriteRuleAction.class,
				new ObjectHandler<URLRewriteRuleAction>() {
					public void handle(URLRewriteRuleAction object) {
						getRewriteRuleAction().add(object);

					}
				});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {

		Element self = createChildElement(parent, "rewriterule");

		if (!(getUrlRewriteRuleCondition().getEvaluatorValue().equals(
				"<condition/>")
				|| getUrlRewriteRuleCondition().getEvaluatorValue().equals(
						"<condition></condition>")
				|| null == getUrlRewriteRuleCondition().getEvaluatorValue() || getUrlRewriteRuleCondition()
				.getEvaluatorValue().equals(""))) {
			Element evaluatorExpressionElem = null;
			try {
				evaluatorExpressionElem = EsbUtils
						.parseElement(getUrlRewriteRuleCondition()
								.getEvaluatorValue(),false);
				evaluatorExpressionElem = (Element) self.getOwnerDocument()
						.importNode(evaluatorExpressionElem, true);
				self.appendChild(evaluatorExpressionElem);
			} catch (Exception ex) {
				// TODO: Log the error.

				// This is a workaround.
				evaluatorExpressionElem = createChildElement(self, "condition");
				getUrlRewriteRuleCondition().setEvaluatorValue(
						URL_REWRITE_RULE_CONDITION);
			}

		}
		for (URLRewriteRuleAction urlRewiteRuleAction : getRewriteRuleAction()) {
			urlRewiteRuleAction.save(self);
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
		return MediatorsPackage.Literals.URL_REWRITE_RULE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty getUrlRewriteRuleCondition() {
		if (urlRewriteRuleCondition != null && urlRewriteRuleCondition.eIsProxy()) {
			InternalEObject oldUrlRewriteRuleCondition = (InternalEObject)urlRewriteRuleCondition;
			urlRewriteRuleCondition = (EvaluatorExpressionProperty)eResolveProxy(oldUrlRewriteRuleCondition);
			if (urlRewriteRuleCondition != oldUrlRewriteRuleCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION, oldUrlRewriteRuleCondition, urlRewriteRuleCondition));
			}
		}
		return urlRewriteRuleCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty basicGetUrlRewriteRuleCondition() {
		return urlRewriteRuleCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlRewriteRuleCondition(
			EvaluatorExpressionProperty newUrlRewriteRuleCondition) {
		EvaluatorExpressionProperty oldUrlRewriteRuleCondition = urlRewriteRuleCondition;
		urlRewriteRuleCondition = newUrlRewriteRuleCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION, oldUrlRewriteRuleCondition, urlRewriteRuleCondition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URLRewriteRuleAction> getRewriteRuleAction() {
		if (rewriteRuleAction == null) {
			rewriteRuleAction = new EObjectContainmentEList<URLRewriteRuleAction>(URLRewriteRuleAction.class, this, MediatorsPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION);
		}
		return rewriteRuleAction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				return ((InternalEList<?>)getRewriteRuleAction()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				if (resolve) return getUrlRewriteRuleCondition();
				return basicGetUrlRewriteRuleCondition();
			case MediatorsPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				return getRewriteRuleAction();
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
			case MediatorsPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				setUrlRewriteRuleCondition((EvaluatorExpressionProperty)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				getRewriteRuleAction().clear();
				getRewriteRuleAction().addAll((Collection<? extends URLRewriteRuleAction>)newValue);
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
			case MediatorsPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				setUrlRewriteRuleCondition((EvaluatorExpressionProperty)null);
				return;
			case MediatorsPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				getRewriteRuleAction().clear();
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
			case MediatorsPackage.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION:
				return urlRewriteRuleCondition != null;
			case MediatorsPackage.URL_REWRITE_RULE__REWRITE_RULE_ACTION:
				return rewriteRuleAction != null && !rewriteRuleAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();	
		
		try {
            Element formatElem = EsbUtils.parseElement(getUrlRewriteRuleCondition().getEvaluatorValue());
        } catch (Exception e) {
        	validateMap.put("Condition", "Invalid condition, must be valid xml");
        }
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("URLRewrite Mediator - RewriteRule", objectValidator);
 	    return mediatorValidateMap;
    }

} // URLRewriteRuleImpl
