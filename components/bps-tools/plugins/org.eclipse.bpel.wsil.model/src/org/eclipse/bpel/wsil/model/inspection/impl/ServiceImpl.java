/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection.impl;

import java.util.Collection;

import org.eclipse.bpel.wsil.model.inspection.Description;
import org.eclipse.bpel.wsil.model.inspection.InspectionPackage;
import org.eclipse.bpel.wsil.model.inspection.Name;
import org.eclipse.bpel.wsil.model.inspection.Service;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.ServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.ServiceImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends ItemWithAbstractsImpl implements Service {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EList<Name> name;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<Description> description;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InspectionPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Name> getName() {
		if (name == null) {
			name = new EObjectContainmentEList<Name>(Name.class, this, InspectionPackage.SERVICE__NAME);
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Description> getDescription() {
		if (description == null) {
			description = new EObjectContainmentEList<Description>(Description.class, this, InspectionPackage.SERVICE__DESCRIPTION);
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InspectionPackage.SERVICE__NAME:
				return ((InternalEList<?>)getName()).basicRemove(otherEnd, msgs);
			case InspectionPackage.SERVICE__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
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
			case InspectionPackage.SERVICE__NAME:
				return getName();
			case InspectionPackage.SERVICE__DESCRIPTION:
				return getDescription();
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
			case InspectionPackage.SERVICE__NAME:
				getName().clear();
				getName().addAll((Collection<? extends Name>)newValue);
				return;
			case InspectionPackage.SERVICE__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends Description>)newValue);
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
			case InspectionPackage.SERVICE__NAME:
				getName().clear();
				return;
			case InspectionPackage.SERVICE__DESCRIPTION:
				getDescription().clear();
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
			case InspectionPackage.SERVICE__NAME:
				return name != null && !name.isEmpty();
			case InspectionPackage.SERVICE__DESCRIPTION:
				return description != null && !description.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceImpl