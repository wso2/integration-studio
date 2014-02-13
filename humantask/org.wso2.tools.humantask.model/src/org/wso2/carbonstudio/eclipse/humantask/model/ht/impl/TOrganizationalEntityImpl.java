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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TOrganizational Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TOrganizationalEntityImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TOrganizationalEntityImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TOrganizationalEntityImpl extends EObjectImpl implements TOrganizationalEntity {
	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected TUserlist users;

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected TGrouplist groups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TOrganizationalEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TORGANIZATIONAL_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TUserlist getUsers() {
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsers(TUserlist newUsers, NotificationChain msgs) {
		TUserlist oldUsers = users;
		users = newUsers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TORGANIZATIONAL_ENTITY__USERS, oldUsers, newUsers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsers(TUserlist newUsers) {
		if (newUsers != users) {
			NotificationChain msgs = null;
			if (users != null)
				msgs = ((InternalEObject)users).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TORGANIZATIONAL_ENTITY__USERS, null, msgs);
			if (newUsers != null)
				msgs = ((InternalEObject)newUsers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TORGANIZATIONAL_ENTITY__USERS, null, msgs);
			msgs = basicSetUsers(newUsers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TORGANIZATIONAL_ENTITY__USERS, newUsers, newUsers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGrouplist getGroups() {
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroups(TGrouplist newGroups, NotificationChain msgs) {
		TGrouplist oldGroups = groups;
		groups = newGroups;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TORGANIZATIONAL_ENTITY__GROUPS, oldGroups, newGroups);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroups(TGrouplist newGroups) {
		if (newGroups != groups) {
			NotificationChain msgs = null;
			if (groups != null)
				msgs = ((InternalEObject)groups).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TORGANIZATIONAL_ENTITY__GROUPS, null, msgs);
			if (newGroups != null)
				msgs = ((InternalEObject)newGroups).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TORGANIZATIONAL_ENTITY__GROUPS, null, msgs);
			msgs = basicSetGroups(newGroups, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TORGANIZATIONAL_ENTITY__GROUPS, newGroups, newGroups));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TORGANIZATIONAL_ENTITY__USERS:
				return basicSetUsers(null, msgs);
			case HTPackage.TORGANIZATIONAL_ENTITY__GROUPS:
				return basicSetGroups(null, msgs);
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
			case HTPackage.TORGANIZATIONAL_ENTITY__USERS:
				return getUsers();
			case HTPackage.TORGANIZATIONAL_ENTITY__GROUPS:
				return getGroups();
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
			case HTPackage.TORGANIZATIONAL_ENTITY__USERS:
				setUsers((TUserlist)newValue);
				return;
			case HTPackage.TORGANIZATIONAL_ENTITY__GROUPS:
				setGroups((TGrouplist)newValue);
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
			case HTPackage.TORGANIZATIONAL_ENTITY__USERS:
				setUsers((TUserlist)null);
				return;
			case HTPackage.TORGANIZATIONAL_ENTITY__GROUPS:
				setGroups((TGrouplist)null);
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
			case HTPackage.TORGANIZATIONAL_ENTITY__USERS:
				return users != null;
			case HTPackage.TORGANIZATIONAL_ENTITY__GROUPS:
				return groups != null;
		}
		return super.eIsSet(featureID);
	}

} //TOrganizationalEntityImpl
