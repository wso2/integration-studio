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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluator Expression Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.EvaluatorExpressionPropertyImpl#getPrettyName <em>Pretty Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.EvaluatorExpressionPropertyImpl#getEvaluatorName <em>Evaluator Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.EvaluatorExpressionPropertyImpl#getEvaluatorValue <em>Evaluator Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvaluatorExpressionPropertyImpl extends ModelObjectImpl implements EvaluatorExpressionProperty {
	/**
	 * The default value of the '{@link #getPrettyName() <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrettyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRETTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrettyName() <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrettyName()
	 * @generated
	 * @ordered
	 */
	protected String prettyName = PRETTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvaluatorName() <em>Evaluator Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluatorName()
	 * @generated
	 * @ordered
	 */
	protected static final String EVALUATOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvaluatorName() <em>Evaluator Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluatorName()
	 * @generated
	 * @ordered
	 */
	protected String evaluatorName = EVALUATOR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvaluatorValue() <em>Evaluator Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluatorValue()
	 * @generated
	 * @ordered
	 */
	protected static final String EVALUATOR_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvaluatorValue() <em>Evaluator Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluatorValue()
	 * @generated
	 * @ordered
	 */
	protected String evaluatorValue = EVALUATOR_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluatorExpressionPropertyImpl() {
		super();
	}

	
	protected void doLoad(Element self) throws Exception {
		super.doLoad(self);
	}

	
	protected Element doSave(Element parent) throws Exception {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.EVALUATOR_EXPRESSION_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrettyName() {
		return prettyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrettyName(String newPrettyName) {
		String oldPrettyName = prettyName;
		prettyName = newPrettyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME, oldPrettyName, prettyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvaluatorName() {
		return evaluatorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluatorName(String newEvaluatorName) {
		String oldEvaluatorName = evaluatorName;
		evaluatorName = newEvaluatorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME, oldEvaluatorName, evaluatorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvaluatorValue() {
		return evaluatorValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluatorValue(String newEvaluatorValue) {
		String oldEvaluatorValue = evaluatorValue;
		evaluatorValue = newEvaluatorValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE, oldEvaluatorValue, evaluatorValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME:
				return getPrettyName();
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME:
				return getEvaluatorName();
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE:
				return getEvaluatorValue();
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
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME:
				setPrettyName((String)newValue);
				return;
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME:
				setEvaluatorName((String)newValue);
				return;
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE:
				setEvaluatorValue((String)newValue);
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
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME:
				setPrettyName(PRETTY_NAME_EDEFAULT);
				return;
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME:
				setEvaluatorName(EVALUATOR_NAME_EDEFAULT);
				return;
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE:
				setEvaluatorValue(EVALUATOR_VALUE_EDEFAULT);
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
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME:
				return PRETTY_NAME_EDEFAULT == null ? prettyName != null : !PRETTY_NAME_EDEFAULT.equals(prettyName);
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME:
				return EVALUATOR_NAME_EDEFAULT == null ? evaluatorName != null : !EVALUATOR_NAME_EDEFAULT.equals(evaluatorName);
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE:
				return EVALUATOR_VALUE_EDEFAULT == null ? evaluatorValue != null : !EVALUATOR_VALUE_EDEFAULT.equals(evaluatorValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	
	public String toString() {
		if (eIsProxy()) return super.toString();
		StringBuffer result = new StringBuffer();
		result.append(getEvaluatorValue());
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }
	

	
} //EvaluatorExpressionPropertyImpl
