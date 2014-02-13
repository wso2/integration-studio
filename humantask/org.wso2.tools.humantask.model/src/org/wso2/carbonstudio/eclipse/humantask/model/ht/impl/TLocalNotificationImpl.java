/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TLocal Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl#getPeopleAssignments <em>People Assignments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TLocalNotificationImpl extends TExtensibleElementsImpl implements TLocalNotification {
	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected TPriority priority;

	/**
	 * The cached value of the '{@link #getPeopleAssignments() <em>People Assignments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeopleAssignments()
	 * @generated
	 * @ordered
	 */
	protected TPeopleAssignments peopleAssignments;

	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final QName REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected QName reference = REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TLocalNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TLOCAL_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPriority getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPriority(TPriority newPriority, NotificationChain msgs) {
		TPriority oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TLOCAL_NOTIFICATION__PRIORITY, oldPriority, newPriority);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(TPriority newPriority) {
		if (newPriority != priority) {
			NotificationChain msgs = null;
			if (priority != null)
				msgs = ((InternalEObject)priority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TLOCAL_NOTIFICATION__PRIORITY, null, msgs);
			if (newPriority != null)
				msgs = ((InternalEObject)newPriority).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TLOCAL_NOTIFICATION__PRIORITY, null, msgs);
			msgs = basicSetPriority(newPriority, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TLOCAL_NOTIFICATION__PRIORITY, newPriority, newPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPeopleAssignments getPeopleAssignments() {
		return peopleAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeopleAssignments(TPeopleAssignments newPeopleAssignments, NotificationChain msgs) {
		TPeopleAssignments oldPeopleAssignments = peopleAssignments;
		peopleAssignments = newPeopleAssignments;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS, oldPeopleAssignments, newPeopleAssignments);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeopleAssignments(TPeopleAssignments newPeopleAssignments) {
		if (newPeopleAssignments != peopleAssignments) {
			NotificationChain msgs = null;
			if (peopleAssignments != null)
				msgs = ((InternalEObject)peopleAssignments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS, null, msgs);
			if (newPeopleAssignments != null)
				msgs = ((InternalEObject)newPeopleAssignments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS, null, msgs);
			msgs = basicSetPeopleAssignments(newPeopleAssignments, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS, newPeopleAssignments, newPeopleAssignments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(QName newReference) {
		QName oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TLOCAL_NOTIFICATION__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TLOCAL_NOTIFICATION__PRIORITY:
				return basicSetPriority(null, msgs);
			case HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS:
				return basicSetPeopleAssignments(null, msgs);
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
			case HTPackage.TLOCAL_NOTIFICATION__PRIORITY:
				return getPriority();
			case HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS:
				return getPeopleAssignments();
			case HTPackage.TLOCAL_NOTIFICATION__REFERENCE:
				return getReference();
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
			case HTPackage.TLOCAL_NOTIFICATION__PRIORITY:
				setPriority((TPriority)newValue);
				return;
			case HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS:
				setPeopleAssignments((TPeopleAssignments)newValue);
				return;
			case HTPackage.TLOCAL_NOTIFICATION__REFERENCE:
				setReference((QName)newValue);
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
			case HTPackage.TLOCAL_NOTIFICATION__PRIORITY:
				setPriority((TPriority)null);
				return;
			case HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS:
				setPeopleAssignments((TPeopleAssignments)null);
				return;
			case HTPackage.TLOCAL_NOTIFICATION__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
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
			case HTPackage.TLOCAL_NOTIFICATION__PRIORITY:
				return priority != null;
			case HTPackage.TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS:
				return peopleAssignments != null;
			case HTPackage.TLOCAL_NOTIFICATION__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
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
		result.append(" (reference: ");
		result.append(reference);
		result.append(')');
		return result.toString();
	}

} //TLocalNotificationImpl
