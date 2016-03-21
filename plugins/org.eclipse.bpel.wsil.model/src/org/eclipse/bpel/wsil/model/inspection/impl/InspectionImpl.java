/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection.impl;

import java.util.Collection;

import org.eclipse.bpel.wsil.model.inspection.Inspection;
import org.eclipse.bpel.wsil.model.inspection.InspectionPackage;

import org.eclipse.bpel.wsil.model.inspection.Link;
import org.eclipse.bpel.wsil.model.inspection.Service;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inspection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InspectionImpl extends ItemWithAbstractsImpl implements Inspection {
	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap groups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InspectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InspectionPackage.Literals.INSPECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroups() {
		if (groups == null) {
			groups = new BasicFeatureMap(this, InspectionPackage.INSPECTION__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		return getGroups().list(InspectionPackage.Literals.INSPECTION__SERVICES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		return getGroups().list(InspectionPackage.Literals.INSPECTION__LINKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InspectionPackage.INSPECTION__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
			case InspectionPackage.INSPECTION__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
			case InspectionPackage.INSPECTION__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case InspectionPackage.INSPECTION__GROUPS:
				if (coreType) return getGroups();
				return ((FeatureMap.Internal)getGroups()).getWrapper();
			case InspectionPackage.INSPECTION__SERVICES:
				return getServices();
			case InspectionPackage.INSPECTION__LINKS:
				return getLinks();
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
			case InspectionPackage.INSPECTION__GROUPS:
				((FeatureMap.Internal)getGroups()).set(newValue);
				return;
			case InspectionPackage.INSPECTION__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case InspectionPackage.INSPECTION__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
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
			case InspectionPackage.INSPECTION__GROUPS:
				getGroups().clear();
				return;
			case InspectionPackage.INSPECTION__SERVICES:
				getServices().clear();
				return;
			case InspectionPackage.INSPECTION__LINKS:
				getLinks().clear();
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
			case InspectionPackage.INSPECTION__GROUPS:
				return groups != null && !groups.isEmpty();
			case InspectionPackage.INSPECTION__SERVICES:
				return !getServices().isEmpty();
			case InspectionPackage.INSPECTION__LINKS:
				return !getLinks().isEmpty();
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
		result.append(" (groups: ");
		result.append(groups);
		result.append(')');
		return result.toString();
	}

} //InspectionImpl