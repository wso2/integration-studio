/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.Snippet;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Assign Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ExtensionAssignOperationImpl#getSnippet <em>Snippet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionAssignOperationImpl extends BPELExtensibleElementImpl
		implements ExtensionAssignOperation {
	/**
	 * The cached value of the '{@link #getSnippet() <em>Snippet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnippet()
	 * @generated
	 * @ordered
	 */
	protected Snippet snippet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionAssignOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.EXTENSION_ASSIGN_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snippet getSnippet() {
		return snippet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetSnippet(Snippet newSnippet,
			NotificationChain msgs) {
		Snippet oldSnippet = snippet;
		if (!isReconciling) {
			ReconciliationHelper.replaceSnippet(this, newSnippet);
		}
		snippet = newSnippet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET,
					oldSnippet, newSnippet);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnippet(Snippet newSnippet) {
		if (newSnippet != snippet) {
			NotificationChain msgs = null;
			if (snippet != null)
				msgs = ((InternalEObject) snippet)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET,
								null, msgs);
			if (newSnippet != null)
				msgs = ((InternalEObject) newSnippet)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET,
								null, msgs);
			msgs = basicSetSnippet(newSnippet, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET,
					newSnippet, newSnippet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET:
			return basicSetSnippet(null, msgs);
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
		case BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET:
			return getSnippet();
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
		case BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET:
			setSnippet((Snippet) newValue);
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
		case BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET:
			setSnippet((Snippet) null);
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
		case BPELPackage.EXTENSION_ASSIGN_OPERATION__SNIPPET:
			return snippet != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtensionAssignOperationImpl
