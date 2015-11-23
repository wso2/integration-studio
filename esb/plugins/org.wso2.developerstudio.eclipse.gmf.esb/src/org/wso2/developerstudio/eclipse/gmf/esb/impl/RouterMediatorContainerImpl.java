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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Router Mediator Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterMediatorContainerImpl#getRouterTargetContainer <em>Router Target Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouterMediatorContainerImpl extends EsbNodeImpl implements RouterMediatorContainer {
	/**
	 * The cached value of the '{@link #getRouterTargetContainer() <em>Router Target Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouterTargetContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<RouterTargetContainer> routerTargetContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouterMediatorContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ROUTER_MEDIATOR_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RouterTargetContainer> getRouterTargetContainer() {
		if (routerTargetContainer == null) {
			routerTargetContainer = new EObjectContainmentEList<RouterTargetContainer>(RouterTargetContainer.class, this, EsbPackage.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER);
		}
		return routerTargetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER:
				return ((InternalEList<?>)getRouterTargetContainer()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER:
				return getRouterTargetContainer();
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
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER:
				getRouterTargetContainer().clear();
				getRouterTargetContainer().addAll((Collection<? extends RouterTargetContainer>)newValue);
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
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER:
				getRouterTargetContainer().clear();
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
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER:
				return routerTargetContainer != null && !routerTargetContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RouterMediatorContainerImpl
