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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;

import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorBranchImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Conditional Route Branch</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl#isBreakAfterRoute
 * <em>Break After Route</em>}</li>
 * <li>
 * {@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl#getEvaluatorExpression
 * <em>Evaluator Expression</em>}</li>
 * <li>
 * {@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl#getTargetSequence
 * <em>Target Sequence</em>}</li>
 * </ul>
 * </p>
 * 
 * 
 */
public class ConditionalRouteBranchImpl extends MediatorBranchImpl implements
		ConditionalRouteBranch {
	/**
	 * The default value of the '{@link #isBreakAfterRoute()
	 * <em>Break After Route</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isBreakAfterRoute() @ * @ordered
	 */
	protected static final boolean BREAK_AFTER_ROUTE_EDEFAULT = false;
	private static final String EVALUATOR_EXPRESSION_EDEFAULT = "<condition></condition>";
	/**
	 * The cached value of the '{@link #isBreakAfterRoute() <em>Break After Route</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isBreakAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected boolean breakAfterRoute = BREAK_AFTER_ROUTE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEvaluatorExpression() <em>Evaluator Expression</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEvaluatorExpression()
	 * @generated
	 * @ordered
	 */
	protected EvaluatorExpressionProperty evaluatorExpression;
	protected RegistryKeyProperty targetSequence;
	/*
	 * @generated
	 */
	protected boolean asynchronous = false;

	public boolean isAsynchronous() {
		return asynchronous;
	}

	public void setAsynchronous(boolean asynchronous) {
		this.asynchronous = asynchronous;
	}

	protected ConditionalRouteBranchImpl() {
		super();
		// Target Sequence
		targetSequence = getEsbFactory().createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) targetSequence.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		targetSequence.setPrettyName("Target");
		targetSequence.setKeyName("sequence");
		targetSequence.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setTargetSequence(targetSequence);
		
		//Evaluator Expression
		evaluatorExpression =getEsbFactory().createEvaluatorExpressionProperty();
		evaluatorExpression.setPrettyName("Evaluator Expression");
		evaluatorExpression.setEvaluatorName("condition");
		evaluatorExpression.setEvaluatorValue(DEFAULT_EVALUATOR_EXPRESSION_VALUE);
		setEvaluatorExpression(evaluatorExpression);

	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		// asynchronous
		if (self.hasAttribute("asynchronous")) {
			if (self.getAttribute("asynchronous").equals("true")) {
				setAsynchronous(true);
			}
		} else {
			setAsynchronous(false);
		}
		// Break After Route
		if (self.hasAttribute("breakRoute")) {
			if (self.getAttribute("breakRoute").equals("true")) {
				setBreakAfterRoute(true);
			}
		}

		List<Element> children = getChildElements(self);
		if (!children.isEmpty()) {
			// Question: Do we have to consider all the child elements?
			getEvaluatorExpression().setEvaluatorValue(EsbUtils
					.renderElement(children.get(0), true,true));

		}

		Element targetElem = getChildElement(self, "target");
		if (null != targetElem) {
			if (targetElem.hasAttribute("sequence")) {
				String attributeValue = self.getAttribute("sequence");
				if (attributeValue == null) {
					attributeValue = "";
				}
				attributeValue = attributeValue.trim();
				getTargetSequence().setKeyValue(attributeValue);
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "conditionalRoute");

		// asynchronous
		if (isAsynchronous()) {
			self.setAttribute("asynchronous", "true");
		} else {
			self.setAttribute("asynchronous", "false");
		}
		// Break After Route
		if (isBreakAfterRoute()) {
			self.setAttribute("breakRoute", "true");
		} 
		
		if (!(getEvaluatorExpression().getEvaluatorValue().equals("<condition/>")
				|| getEvaluatorExpression().getEvaluatorValue().equals("<condition></condition>")
				|| null == getEvaluatorExpression().getEvaluatorValue() || getEvaluatorExpression().getEvaluatorValue()
				.equals(""))) {
			Element evaluatorExpressionElem = null;
			try {
				evaluatorExpressionElem = EsbUtils
						.parseElement(getEvaluatorExpression().getEvaluatorValue(),false);
				evaluatorExpressionElem = (Element) self.getOwnerDocument()
						.importNode(evaluatorExpressionElem, true);
				self.appendChild(evaluatorExpressionElem);
			} catch (Exception ex) {
				// TODO: Log the error.

				// This is a workaround.
				evaluatorExpressionElem = createChildElement(self, "condition");
				getEvaluatorExpression().setEvaluatorValue(EVALUATOR_EXPRESSION_EDEFAULT);
			}

			if (!(getTargetSequence().equals("") || null == getTargetSequence())) {
				Element targetElem = null;
				targetElem = createChildElement(self, "target");
				getTargetSequence().save(targetElem);
			}
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
		return MediatorsPackage.Literals.CONDITIONAL_ROUTE_BRANCH;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBreakAfterRoute() {
		return breakAfterRoute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakAfterRoute(boolean newBreakAfterRoute) {
		boolean oldBreakAfterRoute = breakAfterRoute;
		breakAfterRoute = newBreakAfterRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE, oldBreakAfterRoute, breakAfterRoute));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty getEvaluatorExpression() {
		if (evaluatorExpression != null && evaluatorExpression.eIsProxy()) {
			InternalEObject oldEvaluatorExpression = (InternalEObject)evaluatorExpression;
			evaluatorExpression = (EvaluatorExpressionProperty)eResolveProxy(oldEvaluatorExpression);
			if (evaluatorExpression != oldEvaluatorExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION, oldEvaluatorExpression, evaluatorExpression));
			}
		}
		return evaluatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty basicGetEvaluatorExpression() {
		return evaluatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluatorExpression(EvaluatorExpressionProperty newEvaluatorExpression) {
		EvaluatorExpressionProperty oldEvaluatorExpression = evaluatorExpression;
		evaluatorExpression = newEvaluatorExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION, oldEvaluatorExpression, evaluatorExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getTargetSequence() {
		if (targetSequence != null && targetSequence.eIsProxy()) {
			InternalEObject oldTargetSequence = (InternalEObject)targetSequence;
			targetSequence = (RegistryKeyProperty)eResolveProxy(oldTargetSequence);
			if (targetSequence != oldTargetSequence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE, oldTargetSequence, targetSequence));
			}
		}
		return targetSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetTargetSequence() {
		return targetSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSequence(RegistryKeyProperty newTargetSequence) {
		RegistryKeyProperty oldTargetSequence = targetSequence;
		targetSequence = newTargetSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE, oldTargetSequence, targetSequence));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				return isBreakAfterRoute();
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				if (resolve) return getEvaluatorExpression();
				return basicGetEvaluatorExpression();
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				if (resolve) return getTargetSequence();
				return basicGetTargetSequence();
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
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				setBreakAfterRoute((Boolean)newValue);
				return;
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				setEvaluatorExpression((EvaluatorExpressionProperty)newValue);
				return;
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				setTargetSequence((RegistryKeyProperty)newValue);
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
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				setBreakAfterRoute(BREAK_AFTER_ROUTE_EDEFAULT);
				return;
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				setEvaluatorExpression((EvaluatorExpressionProperty)null);
				return;
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				setTargetSequence((RegistryKeyProperty)null);
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
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				return breakAfterRoute != BREAK_AFTER_ROUTE_EDEFAULT;
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				return evaluatorExpression != null;
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				return targetSequence != null;
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
		result.append(" (breakAfterRoute: ");
		result.append(breakAfterRoute);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getTargetSequence().getKeyValue() || getTargetSequence().getKeyValue().trim().isEmpty()) {
			validateMap.put("Target Sequence","Target Sequence is empty");
		}
		
		try {
            Element formatElem = EsbUtils.parseElement(getEvaluatorExpression().getEvaluatorValue());
        } catch (Exception e) {
        	validateMap.put("Evaluator Expression", "Evaluator expression format, must be valid xml");
        }
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Conditional Router Mediator - Conditional Route", objectValidator);
	    return mediatorValidateMap;
    }

} // ConditionalRouteBranchImpl
