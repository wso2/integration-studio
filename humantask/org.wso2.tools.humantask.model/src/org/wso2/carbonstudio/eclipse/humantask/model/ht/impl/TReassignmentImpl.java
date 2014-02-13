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
import org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TReassignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TReassignmentImpl#getPotentialOwners <em>Potential Owners</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TReassignmentImpl extends TExtensibleElementsImpl implements TReassignment {
	/**
	 * The cached value of the '{@link #getPotentialOwners() <em>Potential Owners</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotentialOwners()
	 * @generated
	 * @ordered
	 */
	protected TGenericHumanRole potentialOwners;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TReassignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TREASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getPotentialOwners() {
		return potentialOwners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPotentialOwners(TGenericHumanRole newPotentialOwners, NotificationChain msgs) {
		TGenericHumanRole oldPotentialOwners = potentialOwners;
		potentialOwners = newPotentialOwners;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS, oldPotentialOwners, newPotentialOwners);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotentialOwners(TGenericHumanRole newPotentialOwners) {
		if (newPotentialOwners != potentialOwners) {
			NotificationChain msgs = null;
			if (potentialOwners != null)
				msgs = ((InternalEObject)potentialOwners).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS, null, msgs);
			if (newPotentialOwners != null)
				msgs = ((InternalEObject)newPotentialOwners).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS, null, msgs);
			msgs = basicSetPotentialOwners(newPotentialOwners, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS, newPotentialOwners, newPotentialOwners));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS:
				return basicSetPotentialOwners(null, msgs);
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
			case HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS:
				return getPotentialOwners();
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
			case HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS:
				setPotentialOwners((TGenericHumanRole)newValue);
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
			case HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS:
				setPotentialOwners((TGenericHumanRole)null);
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
			case HTPackage.TREASSIGNMENT__POTENTIAL_OWNERS:
				return potentialOwners != null;
		}
		return super.eIsSet(featureID);
	}

} //TReassignmentImpl
