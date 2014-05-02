/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign E4X</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.AssignE4XImpl#getValidate <em>Validate</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.AssignE4XImpl#getExtensionAssignOperation <em>Extension Assign Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignE4XImpl extends ActivityImpl implements AssignE4X {
	/**
	 * The default value of the '{@link #getValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidate()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean VALIDATE_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidate()
	 * @generated
	 * @ordered
	 */
	protected Boolean validate = VALIDATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtensionAssignOperation() <em>Extension Assign Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionAssignOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionAssignOperation> extensionAssignOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignE4XImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.ASSIGN_E4X;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getValidate() {
		return validate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setValidate(Boolean newValidate) {
		Boolean oldValidate = validate;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_VALIDATE,
					BPELUtils.boolean2XML(newValidate));
		}
		validate = newValidate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ASSIGN_E4X__VALIDATE, oldValidate, validate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionAssignOperation> getExtensionAssignOperation() {
		if (extensionAssignOperation == null) {
			extensionAssignOperation = new EObjectContainmentEList<ExtensionAssignOperation>(
					ExtensionAssignOperation.class, this,
					BPELPackage.ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION);
		}
		return extensionAssignOperation;
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
		case BPELPackage.ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION:
			return ((InternalEList<?>) getExtensionAssignOperation())
					.basicRemove(otherEnd, msgs);
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
		case BPELPackage.ASSIGN_E4X__VALIDATE:
			return getValidate();
		case BPELPackage.ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION:
			return getExtensionAssignOperation();
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
		case BPELPackage.ASSIGN_E4X__VALIDATE:
			setValidate((Boolean) newValue);
			return;
		case BPELPackage.ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION:
			getExtensionAssignOperation().clear();
			getExtensionAssignOperation().addAll(
					(Collection<? extends ExtensionAssignOperation>) newValue);
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
		case BPELPackage.ASSIGN_E4X__VALIDATE:
			setValidate(VALIDATE_EDEFAULT);
			return;
		case BPELPackage.ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION:
			getExtensionAssignOperation().clear();
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
		case BPELPackage.ASSIGN_E4X__VALIDATE:
			return VALIDATE_EDEFAULT == null ? validate != null
					: !VALIDATE_EDEFAULT.equals(validate);
		case BPELPackage.ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION:
			return extensionAssignOperation != null
					&& !extensionAssignOperation.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Validate: "); //$NON-NLS-1$
		result.append(validate);
		result.append(')');
		return result.toString();
	}

	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof ExtensionAssignOperation) {
			ReconciliationHelper.adoptChild(this, extensionAssignOperation,
					(ExtensionAssignOperation) object,
					BPELConstants.ND_EXTENSION_ASSIGN_OPERATION);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof ExtensionAssignOperation) {
			ReconciliationHelper.orphanChild(this,
					(ExtensionAssignOperation) obj);
		}
		super.orphanContent(reference, obj);
	}

} //AssignE4XImpl
