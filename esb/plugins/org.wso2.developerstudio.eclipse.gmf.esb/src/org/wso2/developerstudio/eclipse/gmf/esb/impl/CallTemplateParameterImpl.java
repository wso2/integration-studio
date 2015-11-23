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

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateParameterImpl#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateParameterImpl#getTemplateParameterType <em>Template Parameter Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateParameterImpl#getParameterValue <em>Parameter Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateParameterImpl#getParameterExpression <em>Parameter Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallTemplateParameterImpl extends EsbNodeImpl implements CallTemplateParameter {
	/**
	 * The default value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterName()
	 * @generated
	 * @ordered
	 */
	protected String parameterName = PARAMETER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTemplateParameterType() <em>Template Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameterType()
	 * @generated
	 * @ordered
	 */
	protected static final RuleOptionType TEMPLATE_PARAMETER_TYPE_EDEFAULT = RuleOptionType.VALUE;

	/**
	 * The cached value of the '{@link #getTemplateParameterType() <em>Template Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameterType()
	 * @generated
	 * @ordered
	 */
	protected RuleOptionType templateParameterType = TEMPLATE_PARAMETER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValue()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValue()
	 * @generated
	 * @ordered
	 */
	protected String parameterValue = PARAMETER_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameterExpression() <em>Parameter Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty parameterExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallTemplateParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CALL_TEMPLATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterName(String newParameterName) {
		String oldParameterName = parameterName;
		parameterName = newParameterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME, oldParameterName, parameterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleOptionType getTemplateParameterType() {
		return templateParameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateParameterType(RuleOptionType newTemplateParameterType) {
		RuleOptionType oldTemplateParameterType = templateParameterType;
		templateParameterType = newTemplateParameterType == null ? TEMPLATE_PARAMETER_TYPE_EDEFAULT : newTemplateParameterType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE, oldTemplateParameterType, templateParameterType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterValue() {
		return parameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterValue(String newParameterValue) {
		String oldParameterValue = parameterValue;
		parameterValue = newParameterValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE, oldParameterValue, parameterValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getParameterExpression() {
		return parameterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterExpression(NamespacedProperty newParameterExpression, NotificationChain msgs) {
		NamespacedProperty oldParameterExpression = parameterExpression;
		parameterExpression = newParameterExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, oldParameterExpression, newParameterExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterExpression(NamespacedProperty newParameterExpression) {
		if (newParameterExpression != parameterExpression) {
			NotificationChain msgs = null;
			if (parameterExpression != null)
				msgs = ((InternalEObject)parameterExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, null, msgs);
			if (newParameterExpression != null)
				msgs = ((InternalEObject)newParameterExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, null, msgs);
			msgs = basicSetParameterExpression(newParameterExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, newParameterExpression, newParameterExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				return basicSetParameterExpression(null, msgs);
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
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				return getParameterName();
			case EsbPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				return getTemplateParameterType();
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				return getParameterValue();
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				return getParameterExpression();
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
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				setParameterName((String)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				setTemplateParameterType((RuleOptionType)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				setParameterValue((String)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				setParameterExpression((NamespacedProperty)newValue);
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
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				setParameterName(PARAMETER_NAME_EDEFAULT);
				return;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				setTemplateParameterType(TEMPLATE_PARAMETER_TYPE_EDEFAULT);
				return;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				setParameterValue(PARAMETER_VALUE_EDEFAULT);
				return;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				setParameterExpression((NamespacedProperty)null);
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
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME:
				return PARAMETER_NAME_EDEFAULT == null ? parameterName != null : !PARAMETER_NAME_EDEFAULT.equals(parameterName);
			case EsbPackage.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE:
				return templateParameterType != TEMPLATE_PARAMETER_TYPE_EDEFAULT;
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE:
				return PARAMETER_VALUE_EDEFAULT == null ? parameterValue != null : !PARAMETER_VALUE_EDEFAULT.equals(parameterValue);
			case EsbPackage.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION:
				return parameterExpression != null;
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
		result.append(" (parameterName: ");
		result.append(parameterName);
		result.append(", templateParameterType: ");
		result.append(templateParameterType);
		result.append(", parameterValue: ");
		result.append(parameterValue);
		result.append(')');
		return result.toString();
	}

} //CallTemplateParameterImpl
