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
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Payload Factory Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryArgumentImpl#getArgumentType <em>Argument Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryArgumentImpl#getArgumentValue <em>Argument Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryArgumentImpl#getArgumentExpression <em>Argument Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryArgumentImpl#getEvaluator <em>Evaluator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PayloadFactoryArgumentImpl extends EsbNodeImpl implements PayloadFactoryArgument {
	/**
	 * The default value of the '{@link #getArgumentType() <em>Argument Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentType()
	 * @generated
	 * @ordered
	 */
	protected static final PayloadFactoryArgumentType ARGUMENT_TYPE_EDEFAULT = PayloadFactoryArgumentType.VALUE;

	/**
	 * The cached value of the '{@link #getArgumentType() <em>Argument Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentType()
	 * @generated
	 * @ordered
	 */
	protected PayloadFactoryArgumentType argumentType = ARGUMENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getArgumentValue() <em>Argument Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String ARGUMENT_VALUE_EDEFAULT = "default";

	/**
	 * The cached value of the '{@link #getArgumentValue() <em>Argument Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentValue()
	 * @generated
	 * @ordered
	 */
	protected String argumentValue = ARGUMENT_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgumentExpression() <em>Argument Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty argumentExpression;

	/**
	 * The default value of the '{@link #getEvaluator() <em>Evaluator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluator()
	 * @generated
	 * @ordered
	 */
	protected static final MediaType EVALUATOR_EDEFAULT = MediaType.XML;

	/**
	 * The cached value of the '{@link #getEvaluator() <em>Evaluator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluator()
	 * @generated
	 * @ordered
	 */
	protected MediaType evaluator = EVALUATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PayloadFactoryArgumentImpl() {
		super();
		NamespacedProperty argumentExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		argumentExpression.setPrettyName("Argument Expression");
		argumentExpression.setPropertyName("Argument Expression");
		argumentExpression.setPropertyValue("/default/expression");
		setArgumentExpression(argumentExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryArgumentType getArgumentType() {
		return argumentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentType(PayloadFactoryArgumentType newArgumentType) {
		PayloadFactoryArgumentType oldArgumentType = argumentType;
		argumentType = newArgumentType == null ? ARGUMENT_TYPE_EDEFAULT : newArgumentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE, oldArgumentType, argumentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArgumentValue() {
		return argumentValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentValue(String newArgumentValue) {
		String oldArgumentValue = argumentValue;
		argumentValue = newArgumentValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE, oldArgumentValue, argumentValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getArgumentExpression() {
		return argumentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgumentExpression(NamespacedProperty newArgumentExpression, NotificationChain msgs) {
		NamespacedProperty oldArgumentExpression = argumentExpression;
		argumentExpression = newArgumentExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, oldArgumentExpression, newArgumentExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentExpression(NamespacedProperty newArgumentExpression) {
		if (newArgumentExpression != argumentExpression) {
			NotificationChain msgs = null;
			if (argumentExpression != null)
				msgs = ((InternalEObject)argumentExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, null, msgs);
			if (newArgumentExpression != null)
				msgs = ((InternalEObject)newArgumentExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, null, msgs);
			msgs = basicSetArgumentExpression(newArgumentExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, newArgumentExpression, newArgumentExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaType getEvaluator() {
		return evaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluator(MediaType newEvaluator) {
		MediaType oldEvaluator = evaluator;
		evaluator = newEvaluator == null ? EVALUATOR_EDEFAULT : newEvaluator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR, oldEvaluator, evaluator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				return basicSetArgumentExpression(null, msgs);
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
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				return getArgumentType();
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				return getArgumentValue();
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				return getArgumentExpression();
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR:
				return getEvaluator();
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
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				setArgumentType((PayloadFactoryArgumentType)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				setArgumentValue((String)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				setArgumentExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR:
				setEvaluator((MediaType)newValue);
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
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				setArgumentType(ARGUMENT_TYPE_EDEFAULT);
				return;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				setArgumentValue(ARGUMENT_VALUE_EDEFAULT);
				return;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				setArgumentExpression((NamespacedProperty)null);
				return;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR:
				setEvaluator(EVALUATOR_EDEFAULT);
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
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
				return argumentType != ARGUMENT_TYPE_EDEFAULT;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
				return ARGUMENT_VALUE_EDEFAULT == null ? argumentValue != null : !ARGUMENT_VALUE_EDEFAULT.equals(argumentValue);
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
				return argumentExpression != null;
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR:
				return evaluator != EVALUATOR_EDEFAULT;
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
		result.append(" (argumentType: ");
		result.append(argumentType);
		result.append(", argumentValue: ");
		result.append(argumentValue);
		result.append(", evaluator: ");
		result.append(evaluator);
		result.append(')');
		return result.toString();
	}

} //PayloadFactoryArgumentImpl
