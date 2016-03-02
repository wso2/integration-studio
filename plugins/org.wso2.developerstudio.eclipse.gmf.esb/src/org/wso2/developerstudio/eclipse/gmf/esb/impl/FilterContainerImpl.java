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
import org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterFailContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterPassContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filter Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterContainerImpl#getPassContainer <em>Pass Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterContainerImpl#getFailContainer <em>Fail Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilterContainerImpl extends EsbNodeImpl implements FilterContainer {
    /**
	 * The cached value of the '{@link #getPassContainer() <em>Pass Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPassContainer()
	 * @generated
	 * @ordered
	 */
    protected FilterPassContainer passContainer;

    /**
	 * The cached value of the '{@link #getFailContainer() <em>Fail Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFailContainer()
	 * @generated
	 * @ordered
	 */
    protected FilterFailContainer failContainer;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected FilterContainerImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return EsbPackage.Literals.FILTER_CONTAINER;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FilterPassContainer getPassContainer() {
		return passContainer;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetPassContainer(FilterPassContainer newPassContainer, NotificationChain msgs) {
		FilterPassContainer oldPassContainer = passContainer;
		passContainer = newPassContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_CONTAINER__PASS_CONTAINER, oldPassContainer, newPassContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setPassContainer(FilterPassContainer newPassContainer) {
		if (newPassContainer != passContainer) {
			NotificationChain msgs = null;
			if (passContainer != null)
				msgs = ((InternalEObject)passContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_CONTAINER__PASS_CONTAINER, null, msgs);
			if (newPassContainer != null)
				msgs = ((InternalEObject)newPassContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_CONTAINER__PASS_CONTAINER, null, msgs);
			msgs = basicSetPassContainer(newPassContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_CONTAINER__PASS_CONTAINER, newPassContainer, newPassContainer));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FilterFailContainer getFailContainer() {
		return failContainer;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetFailContainer(FilterFailContainer newFailContainer, NotificationChain msgs) {
		FilterFailContainer oldFailContainer = failContainer;
		failContainer = newFailContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER, oldFailContainer, newFailContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFailContainer(FilterFailContainer newFailContainer) {
		if (newFailContainer != failContainer) {
			NotificationChain msgs = null;
			if (failContainer != null)
				msgs = ((InternalEObject)failContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER, null, msgs);
			if (newFailContainer != null)
				msgs = ((InternalEObject)newFailContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER, null, msgs);
			msgs = basicSetFailContainer(newFailContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER, newFailContainer, newFailContainer));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.FILTER_CONTAINER__PASS_CONTAINER:
				return basicSetPassContainer(null, msgs);
			case EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER:
				return basicSetFailContainer(null, msgs);
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
			case EsbPackage.FILTER_CONTAINER__PASS_CONTAINER:
				return getPassContainer();
			case EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER:
				return getFailContainer();
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
			case EsbPackage.FILTER_CONTAINER__PASS_CONTAINER:
				setPassContainer((FilterPassContainer)newValue);
				return;
			case EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER:
				setFailContainer((FilterFailContainer)newValue);
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
			case EsbPackage.FILTER_CONTAINER__PASS_CONTAINER:
				setPassContainer((FilterPassContainer)null);
				return;
			case EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER:
				setFailContainer((FilterFailContainer)null);
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
			case EsbPackage.FILTER_CONTAINER__PASS_CONTAINER:
				return passContainer != null;
			case EsbPackage.FILTER_CONTAINER__FAIL_CONTAINER:
				return failContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //FilterContainerImpl
