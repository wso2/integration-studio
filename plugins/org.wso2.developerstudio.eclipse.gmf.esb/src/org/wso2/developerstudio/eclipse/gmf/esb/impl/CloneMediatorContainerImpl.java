/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clone Mediator Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorContainerImpl#getCloneTargetContainer <em>Clone Target Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloneMediatorContainerImpl extends EsbNodeImpl implements CloneMediatorContainer {
	/**
	 * The cached value of the '{@link #getCloneTargetContainer() <em>Clone Target Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloneTargetContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<CloneTargetContainer> cloneTargetContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloneMediatorContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CLONE_MEDIATOR_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CloneTargetContainer> getCloneTargetContainer() {
		if (cloneTargetContainer == null) {
			cloneTargetContainer = new EObjectContainmentEList<CloneTargetContainer>(CloneTargetContainer.class, this, EsbPackage.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER);
		}
		return cloneTargetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER:
				return ((InternalEList<?>)getCloneTargetContainer()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER:
				return getCloneTargetContainer();
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
			case EsbPackage.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER:
				getCloneTargetContainer().clear();
				getCloneTargetContainer().addAll((Collection<? extends CloneTargetContainer>)newValue);
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
			case EsbPackage.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER:
				getCloneTargetContainer().clear();
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
			case EsbPackage.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER:
				return cloneTargetContainer != null && !cloneTargetContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CloneMediatorContainerImpl
