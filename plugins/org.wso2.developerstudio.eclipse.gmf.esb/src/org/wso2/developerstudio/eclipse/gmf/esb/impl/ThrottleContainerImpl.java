/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnAcceptContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throttle Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleContainerImpl#getOnAcceptContainer <em>On Accept Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleContainerImpl#getOnRejectContainer <em>On Reject Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrottleContainerImpl extends EsbNodeImpl implements ThrottleContainer {
    /**
	 * The cached value of the '{@link #getOnAcceptContainer() <em>On Accept Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnAcceptContainer()
	 * @generated
	 * @ordered
	 */
    protected ThrottleOnAcceptContainer onAcceptContainer;

    /**
	 * The cached value of the '{@link #getOnRejectContainer() <em>On Reject Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnRejectContainer()
	 * @generated
	 * @ordered
	 */
    protected ThrottleOnRejectContainer onRejectContainer;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ThrottleContainerImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return EsbPackage.Literals.THROTTLE_CONTAINER;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleOnAcceptContainer getOnAcceptContainer() {
		return onAcceptContainer;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOnAcceptContainer(ThrottleOnAcceptContainer newOnAcceptContainer, NotificationChain msgs) {
		ThrottleOnAcceptContainer oldOnAcceptContainer = onAcceptContainer;
		onAcceptContainer = newOnAcceptContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER, oldOnAcceptContainer, newOnAcceptContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnAcceptContainer(ThrottleOnAcceptContainer newOnAcceptContainer) {
		if (newOnAcceptContainer != onAcceptContainer) {
			NotificationChain msgs = null;
			if (onAcceptContainer != null)
				msgs = ((InternalEObject)onAcceptContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER, null, msgs);
			if (newOnAcceptContainer != null)
				msgs = ((InternalEObject)newOnAcceptContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER, null, msgs);
			msgs = basicSetOnAcceptContainer(newOnAcceptContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER, newOnAcceptContainer, newOnAcceptContainer));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleOnRejectContainer getOnRejectContainer() {
		return onRejectContainer;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOnRejectContainer(ThrottleOnRejectContainer newOnRejectContainer, NotificationChain msgs) {
		ThrottleOnRejectContainer oldOnRejectContainer = onRejectContainer;
		onRejectContainer = newOnRejectContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER, oldOnRejectContainer, newOnRejectContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnRejectContainer(ThrottleOnRejectContainer newOnRejectContainer) {
		if (newOnRejectContainer != onRejectContainer) {
			NotificationChain msgs = null;
			if (onRejectContainer != null)
				msgs = ((InternalEObject)onRejectContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER, null, msgs);
			if (newOnRejectContainer != null)
				msgs = ((InternalEObject)newOnRejectContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER, null, msgs);
			msgs = basicSetOnRejectContainer(newOnRejectContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER, newOnRejectContainer, newOnRejectContainer));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER:
				return basicSetOnAcceptContainer(null, msgs);
			case EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER:
				return basicSetOnRejectContainer(null, msgs);
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
			case EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER:
				return getOnAcceptContainer();
			case EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER:
				return getOnRejectContainer();
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
			case EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER:
				setOnAcceptContainer((ThrottleOnAcceptContainer)newValue);
				return;
			case EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER:
				setOnRejectContainer((ThrottleOnRejectContainer)newValue);
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
			case EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER:
				setOnAcceptContainer((ThrottleOnAcceptContainer)null);
				return;
			case EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER:
				setOnRejectContainer((ThrottleOnRejectContainer)null);
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
			case EsbPackage.THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER:
				return onAcceptContainer != null;
			case EsbPackage.THROTTLE_CONTAINER__ON_REJECT_CONTAINER:
				return onRejectContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //ThrottleContainerImpl
