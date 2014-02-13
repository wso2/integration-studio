/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TLogical People Groups</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupsImpl#getLogicalPeopleGroup <em>Logical People Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TLogicalPeopleGroupsImpl extends TExtensibleElementsImpl implements TLogicalPeopleGroups {
	/**
	 * The cached value of the '{@link #getLogicalPeopleGroup() <em>Logical People Group</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalPeopleGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<TLogicalPeopleGroup> logicalPeopleGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TLogicalPeopleGroupsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TLOGICAL_PEOPLE_GROUPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TLogicalPeopleGroup> getLogicalPeopleGroup() {
		if (logicalPeopleGroup == null) {
			logicalPeopleGroup = new EObjectContainmentEList<TLogicalPeopleGroup>(TLogicalPeopleGroup.class, this, HTPackage.TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP);
		}
		return logicalPeopleGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP:
				return ((InternalEList<?>)getLogicalPeopleGroup()).basicRemove(otherEnd, msgs);
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
			case HTPackage.TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP:
				return getLogicalPeopleGroup();
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
			case HTPackage.TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP:
				getLogicalPeopleGroup().clear();
				getLogicalPeopleGroup().addAll((Collection<? extends TLogicalPeopleGroup>)newValue);
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
			case HTPackage.TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP:
				getLogicalPeopleGroup().clear();
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
			case HTPackage.TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP:
				return logicalPeopleGroup != null && !logicalPeopleGroup.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TLogicalPeopleGroupsImpl
