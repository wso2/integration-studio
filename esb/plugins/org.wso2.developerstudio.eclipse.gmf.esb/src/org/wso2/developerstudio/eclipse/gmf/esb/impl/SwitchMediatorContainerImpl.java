/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseParentContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultParentContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Mediator Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchMediatorContainerImpl#getSwitchCaseParentContainer <em>Switch Case Parent Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchMediatorContainerImpl#getSwitchDefaultParentContainer <em>Switch Default Parent Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchMediatorContainerImpl extends EsbNodeImpl implements SwitchMediatorContainer {
	/**
	 * The cached value of the '{@link #getSwitchCaseParentContainer() <em>Switch Case Parent Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchCaseParentContainer()
	 * @generated
	 * @ordered
	 */
	protected SwitchCaseParentContainer switchCaseParentContainer;

	/**
	 * The cached value of the '{@link #getSwitchDefaultParentContainer() <em>Switch Default Parent Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchDefaultParentContainer()
	 * @generated
	 * @ordered
	 */
	protected SwitchDefaultParentContainer switchDefaultParentContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchMediatorContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SWITCH_MEDIATOR_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCaseParentContainer getSwitchCaseParentContainer() {
		return switchCaseParentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitchCaseParentContainer(SwitchCaseParentContainer newSwitchCaseParentContainer, NotificationChain msgs) {
		SwitchCaseParentContainer oldSwitchCaseParentContainer = switchCaseParentContainer;
		switchCaseParentContainer = newSwitchCaseParentContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER, oldSwitchCaseParentContainer, newSwitchCaseParentContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchCaseParentContainer(SwitchCaseParentContainer newSwitchCaseParentContainer) {
		if (newSwitchCaseParentContainer != switchCaseParentContainer) {
			NotificationChain msgs = null;
			if (switchCaseParentContainer != null)
				msgs = ((InternalEObject)switchCaseParentContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER, null, msgs);
			if (newSwitchCaseParentContainer != null)
				msgs = ((InternalEObject)newSwitchCaseParentContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER, null, msgs);
			msgs = basicSetSwitchCaseParentContainer(newSwitchCaseParentContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER, newSwitchCaseParentContainer, newSwitchCaseParentContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchDefaultParentContainer getSwitchDefaultParentContainer() {
		return switchDefaultParentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitchDefaultParentContainer(SwitchDefaultParentContainer newSwitchDefaultParentContainer, NotificationChain msgs) {
		SwitchDefaultParentContainer oldSwitchDefaultParentContainer = switchDefaultParentContainer;
		switchDefaultParentContainer = newSwitchDefaultParentContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER, oldSwitchDefaultParentContainer, newSwitchDefaultParentContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchDefaultParentContainer(SwitchDefaultParentContainer newSwitchDefaultParentContainer) {
		if (newSwitchDefaultParentContainer != switchDefaultParentContainer) {
			NotificationChain msgs = null;
			if (switchDefaultParentContainer != null)
				msgs = ((InternalEObject)switchDefaultParentContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER, null, msgs);
			if (newSwitchDefaultParentContainer != null)
				msgs = ((InternalEObject)newSwitchDefaultParentContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER, null, msgs);
			msgs = basicSetSwitchDefaultParentContainer(newSwitchDefaultParentContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER, newSwitchDefaultParentContainer, newSwitchDefaultParentContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER:
				return basicSetSwitchCaseParentContainer(null, msgs);
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER:
				return basicSetSwitchDefaultParentContainer(null, msgs);
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
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER:
				return getSwitchCaseParentContainer();
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER:
				return getSwitchDefaultParentContainer();
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
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER:
				setSwitchCaseParentContainer((SwitchCaseParentContainer)newValue);
				return;
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER:
				setSwitchDefaultParentContainer((SwitchDefaultParentContainer)newValue);
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
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER:
				setSwitchCaseParentContainer((SwitchCaseParentContainer)null);
				return;
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER:
				setSwitchDefaultParentContainer((SwitchDefaultParentContainer)null);
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
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER:
				return switchCaseParentContainer != null;
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER:
				return switchDefaultParentContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchMediatorContainerImpl
