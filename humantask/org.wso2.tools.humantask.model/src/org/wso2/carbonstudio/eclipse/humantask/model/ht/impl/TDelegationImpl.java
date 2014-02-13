/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TDelegation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDelegationImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDelegationImpl#getPotentialDelegatees <em>Potential Delegatees</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TDelegationImpl extends TExtensibleElementsImpl implements TDelegation {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected TFrom from;

	/**
	 * The default value of the '{@link #getPotentialDelegatees() <em>Potential Delegatees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotentialDelegatees()
	 * @generated
	 * @ordered
	 */
	protected static final TPotentialDelegatees POTENTIAL_DELEGATEES_EDEFAULT = TPotentialDelegatees.ANYBODY;

	/**
	 * The cached value of the '{@link #getPotentialDelegatees() <em>Potential Delegatees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotentialDelegatees()
	 * @generated
	 * @ordered
	 */
	protected TPotentialDelegatees potentialDelegatees = POTENTIAL_DELEGATEES_EDEFAULT;

	/**
	 * This is true if the Potential Delegatees attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean potentialDelegateesESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TDelegationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TDELEGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFrom getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom(TFrom newFrom, NotificationChain msgs) {
		TFrom oldFrom = from;
		from = newFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TDELEGATION__FROM, oldFrom, newFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(TFrom newFrom) {
		if (newFrom != from) {
			NotificationChain msgs = null;
			if (from != null)
				msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TDELEGATION__FROM, null, msgs);
			if (newFrom != null)
				msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TDELEGATION__FROM, null, msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TDELEGATION__FROM, newFrom, newFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPotentialDelegatees getPotentialDelegatees() {
		return potentialDelegatees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotentialDelegatees(TPotentialDelegatees newPotentialDelegatees) {
		TPotentialDelegatees oldPotentialDelegatees = potentialDelegatees;
		potentialDelegatees = newPotentialDelegatees == null ? POTENTIAL_DELEGATEES_EDEFAULT : newPotentialDelegatees;
		boolean oldPotentialDelegateesESet = potentialDelegateesESet;
		potentialDelegateesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TDELEGATION__POTENTIAL_DELEGATEES, oldPotentialDelegatees, potentialDelegatees, !oldPotentialDelegateesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPotentialDelegatees() {
		TPotentialDelegatees oldPotentialDelegatees = potentialDelegatees;
		boolean oldPotentialDelegateesESet = potentialDelegateesESet;
		potentialDelegatees = POTENTIAL_DELEGATEES_EDEFAULT;
		potentialDelegateesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HTPackage.TDELEGATION__POTENTIAL_DELEGATEES, oldPotentialDelegatees, POTENTIAL_DELEGATEES_EDEFAULT, oldPotentialDelegateesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPotentialDelegatees() {
		return potentialDelegateesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TDELEGATION__FROM:
				return basicSetFrom(null, msgs);
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
			case HTPackage.TDELEGATION__FROM:
				return getFrom();
			case HTPackage.TDELEGATION__POTENTIAL_DELEGATEES:
				return getPotentialDelegatees();
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
			case HTPackage.TDELEGATION__FROM:
				setFrom((TFrom)newValue);
				return;
			case HTPackage.TDELEGATION__POTENTIAL_DELEGATEES:
				setPotentialDelegatees((TPotentialDelegatees)newValue);
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
			case HTPackage.TDELEGATION__FROM:
				setFrom((TFrom)null);
				return;
			case HTPackage.TDELEGATION__POTENTIAL_DELEGATEES:
				unsetPotentialDelegatees();
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
			case HTPackage.TDELEGATION__FROM:
				return from != null;
			case HTPackage.TDELEGATION__POTENTIAL_DELEGATEES:
				return isSetPotentialDelegatees();
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
		result.append(" (potentialDelegatees: ");
		if (potentialDelegateesESet) result.append(potentialDelegatees); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TDelegationImpl
