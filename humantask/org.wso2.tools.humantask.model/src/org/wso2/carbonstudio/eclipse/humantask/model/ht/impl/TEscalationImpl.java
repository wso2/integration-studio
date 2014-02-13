/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TBooleanExpr;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TEscalation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl#getToParts <em>To Parts</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl#getNotification <em>Notification</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl#getLocalNotification <em>Local Notification</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl#getReassignment <em>Reassignment</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TEscalationImpl extends TExtensibleElementsImpl implements TEscalation {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected TBooleanExpr condition;

	/**
	 * The cached value of the '{@link #getToParts() <em>To Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToParts()
	 * @generated
	 * @ordered
	 */
	protected EList<TToParts> toParts;

	/**
	 * The cached value of the '{@link #getNotification() <em>Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotification()
	 * @generated
	 * @ordered
	 */
	protected TNotification notification;

	/**
	 * The cached value of the '{@link #getLocalNotification() <em>Local Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalNotification()
	 * @generated
	 * @ordered
	 */
	protected TLocalNotification localNotification;

	/**
	 * The cached value of the '{@link #getReassignment() <em>Reassignment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReassignment()
	 * @generated
	 * @ordered
	 */
	protected TReassignment reassignment;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TEscalationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TESCALATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBooleanExpr getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(TBooleanExpr newCondition, NotificationChain msgs) {
		TBooleanExpr oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(TBooleanExpr newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TToParts> getToParts() {
		if (toParts == null) {
			toParts = new EObjectContainmentEList<TToParts>(TToParts.class, this, HTPackage.TESCALATION__TO_PARTS);
		}
		return toParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotification getNotification() {
		return notification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotification(TNotification newNotification, NotificationChain msgs) {
		TNotification oldNotification = notification;
		notification = newNotification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__NOTIFICATION, oldNotification, newNotification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotification(TNotification newNotification) {
		if (newNotification != notification) {
			NotificationChain msgs = null;
			if (notification != null)
				msgs = ((InternalEObject)notification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__NOTIFICATION, null, msgs);
			if (newNotification != null)
				msgs = ((InternalEObject)newNotification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__NOTIFICATION, null, msgs);
			msgs = basicSetNotification(newNotification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__NOTIFICATION, newNotification, newNotification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLocalNotification getLocalNotification() {
		return localNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalNotification(TLocalNotification newLocalNotification, NotificationChain msgs) {
		TLocalNotification oldLocalNotification = localNotification;
		localNotification = newLocalNotification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__LOCAL_NOTIFICATION, oldLocalNotification, newLocalNotification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalNotification(TLocalNotification newLocalNotification) {
		if (newLocalNotification != localNotification) {
			NotificationChain msgs = null;
			if (localNotification != null)
				msgs = ((InternalEObject)localNotification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__LOCAL_NOTIFICATION, null, msgs);
			if (newLocalNotification != null)
				msgs = ((InternalEObject)newLocalNotification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__LOCAL_NOTIFICATION, null, msgs);
			msgs = basicSetLocalNotification(newLocalNotification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__LOCAL_NOTIFICATION, newLocalNotification, newLocalNotification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TReassignment getReassignment() {
		return reassignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReassignment(TReassignment newReassignment, NotificationChain msgs) {
		TReassignment oldReassignment = reassignment;
		reassignment = newReassignment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__REASSIGNMENT, oldReassignment, newReassignment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReassignment(TReassignment newReassignment) {
		if (newReassignment != reassignment) {
			NotificationChain msgs = null;
			if (reassignment != null)
				msgs = ((InternalEObject)reassignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__REASSIGNMENT, null, msgs);
			if (newReassignment != null)
				msgs = ((InternalEObject)newReassignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TESCALATION__REASSIGNMENT, null, msgs);
			msgs = basicSetReassignment(newReassignment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__REASSIGNMENT, newReassignment, newReassignment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TESCALATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TESCALATION__CONDITION:
				return basicSetCondition(null, msgs);
			case HTPackage.TESCALATION__TO_PARTS:
				return ((InternalEList<?>)getToParts()).basicRemove(otherEnd, msgs);
			case HTPackage.TESCALATION__NOTIFICATION:
				return basicSetNotification(null, msgs);
			case HTPackage.TESCALATION__LOCAL_NOTIFICATION:
				return basicSetLocalNotification(null, msgs);
			case HTPackage.TESCALATION__REASSIGNMENT:
				return basicSetReassignment(null, msgs);
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
			case HTPackage.TESCALATION__CONDITION:
				return getCondition();
			case HTPackage.TESCALATION__TO_PARTS:
				return getToParts();
			case HTPackage.TESCALATION__NOTIFICATION:
				return getNotification();
			case HTPackage.TESCALATION__LOCAL_NOTIFICATION:
				return getLocalNotification();
			case HTPackage.TESCALATION__REASSIGNMENT:
				return getReassignment();
			case HTPackage.TESCALATION__NAME:
				return getName();
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
			case HTPackage.TESCALATION__CONDITION:
				setCondition((TBooleanExpr)newValue);
				return;
			case HTPackage.TESCALATION__TO_PARTS:
				getToParts().clear();
				getToParts().addAll((Collection<? extends TToParts>)newValue);
				return;
			case HTPackage.TESCALATION__NOTIFICATION:
				setNotification((TNotification)newValue);
				return;
			case HTPackage.TESCALATION__LOCAL_NOTIFICATION:
				setLocalNotification((TLocalNotification)newValue);
				return;
			case HTPackage.TESCALATION__REASSIGNMENT:
				setReassignment((TReassignment)newValue);
				return;
			case HTPackage.TESCALATION__NAME:
				setName((String)newValue);
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
			case HTPackage.TESCALATION__CONDITION:
				setCondition((TBooleanExpr)null);
				return;
			case HTPackage.TESCALATION__TO_PARTS:
				getToParts().clear();
				return;
			case HTPackage.TESCALATION__NOTIFICATION:
				setNotification((TNotification)null);
				return;
			case HTPackage.TESCALATION__LOCAL_NOTIFICATION:
				setLocalNotification((TLocalNotification)null);
				return;
			case HTPackage.TESCALATION__REASSIGNMENT:
				setReassignment((TReassignment)null);
				return;
			case HTPackage.TESCALATION__NAME:
				setName(NAME_EDEFAULT);
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
			case HTPackage.TESCALATION__CONDITION:
				return condition != null;
			case HTPackage.TESCALATION__TO_PARTS:
				return toParts != null && !toParts.isEmpty();
			case HTPackage.TESCALATION__NOTIFICATION:
				return notification != null;
			case HTPackage.TESCALATION__LOCAL_NOTIFICATION:
				return localNotification != null;
			case HTPackage.TESCALATION__REASSIGNMENT:
				return reassignment != null;
			case HTPackage.TESCALATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

} //TEscalationImpl
