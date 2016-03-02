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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceOutput;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbSequenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbSequenceImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbSequenceImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbSequenceImpl#getChildMediators <em>Child Mediators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EsbSequenceImpl extends EsbNodeImpl implements EsbSequence {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = ",";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EsbSequenceInputConnector input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected EsbSequenceOutputConnector output;

	/**
	 * The cached value of the '{@link #getChildMediators() <em>Child Mediators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildMediators()
	 * @generated
	 * @ordered
	 */
	protected EList<Mediator> childMediators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EsbSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ESB_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SEQUENCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceInputConnector getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(EsbSequenceInputConnector newInput, NotificationChain msgs) {
		EsbSequenceInputConnector oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SEQUENCE__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(EsbSequenceInputConnector newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ESB_SEQUENCE__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ESB_SEQUENCE__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SEQUENCE__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceOutputConnector getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(EsbSequenceOutputConnector newOutput, NotificationChain msgs) {
		EsbSequenceOutputConnector oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SEQUENCE__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(EsbSequenceOutputConnector newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ESB_SEQUENCE__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ESB_SEQUENCE__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SEQUENCE__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mediator> getChildMediators() {
		if (childMediators == null) {
			childMediators = new EObjectContainmentEList<Mediator>(Mediator.class, this, EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS);
		}
		return childMediators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ESB_SEQUENCE__INPUT:
				return basicSetInput(null, msgs);
			case EsbPackage.ESB_SEQUENCE__OUTPUT:
				return basicSetOutput(null, msgs);
			case EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS:
				return ((InternalEList<?>)getChildMediators()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.ESB_SEQUENCE__NAME:
				return getName();
			case EsbPackage.ESB_SEQUENCE__INPUT:
				return getInput();
			case EsbPackage.ESB_SEQUENCE__OUTPUT:
				return getOutput();
			case EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS:
				return getChildMediators();
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
			case EsbPackage.ESB_SEQUENCE__NAME:
				setName((String)newValue);
				return;
			case EsbPackage.ESB_SEQUENCE__INPUT:
				setInput((EsbSequenceInputConnector)newValue);
				return;
			case EsbPackage.ESB_SEQUENCE__OUTPUT:
				setOutput((EsbSequenceOutputConnector)newValue);
				return;
			case EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS:
				getChildMediators().clear();
				getChildMediators().addAll((Collection<? extends Mediator>)newValue);
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
			case EsbPackage.ESB_SEQUENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsbPackage.ESB_SEQUENCE__INPUT:
				setInput((EsbSequenceInputConnector)null);
				return;
			case EsbPackage.ESB_SEQUENCE__OUTPUT:
				setOutput((EsbSequenceOutputConnector)null);
				return;
			case EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS:
				getChildMediators().clear();
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
			case EsbPackage.ESB_SEQUENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsbPackage.ESB_SEQUENCE__INPUT:
				return input != null;
			case EsbPackage.ESB_SEQUENCE__OUTPUT:
				return output != null;
			case EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS:
				return childMediators != null && !childMediators.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EsbSequenceImpl
