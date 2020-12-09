/**
 * <copyright>
 * </copyright>
 *
 * $Id: BranchesImpl.java,v 1.10 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branches</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.BranchesImpl#getCountCompletedBranchesOnly <em>Count Completed Branches Only</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchesImpl extends ExpressionImpl implements Branches {
	/**
	 * The default value of the '{@link #getCountCompletedBranchesOnly() <em>Count Completed Branches Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountCompletedBranchesOnly()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean COUNT_COMPLETED_BRANCHES_ONLY_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getCountCompletedBranchesOnly() <em>Count Completed Branches Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountCompletedBranchesOnly()
	 * @generated
	 * @ordered
	 */
	protected Boolean countCompletedBranchesOnly = COUNT_COMPLETED_BRANCHES_ONLY_EDEFAULT;

	/**
	 * This is true if the Count Completed Branches Only attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean countCompletedBranchesOnlyESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.BRANCHES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCountCompletedBranchesOnly() {
		return countCompletedBranchesOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setCountCompletedBranchesOnly(
			Boolean newCountCompletedBranchesOnly) {
		Boolean oldCountCompletedBranchesOnly = countCompletedBranchesOnly;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUCCESSFUL_BRANCHES_ONLY,
					BPELUtils.boolean2XML(newCountCompletedBranchesOnly));
		}
		countCompletedBranchesOnly = newCountCompletedBranchesOnly;
		boolean oldCountCompletedBranchesOnlyESet = countCompletedBranchesOnlyESet;
		countCompletedBranchesOnlyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY,
					oldCountCompletedBranchesOnly, countCompletedBranchesOnly,
					!oldCountCompletedBranchesOnlyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetCountCompletedBranchesOnly() {
		Boolean oldCountCompletedBranchesOnly = countCompletedBranchesOnly;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUCCESSFUL_BRANCHES_ONLY, (String) null);
		}
		boolean oldCountCompletedBranchesOnlyESet = countCompletedBranchesOnlyESet;
		countCompletedBranchesOnly = COUNT_COMPLETED_BRANCHES_ONLY_EDEFAULT;
		countCompletedBranchesOnlyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY,
					oldCountCompletedBranchesOnly,
					COUNT_COMPLETED_BRANCHES_ONLY_EDEFAULT,
					oldCountCompletedBranchesOnlyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCountCompletedBranchesOnly() {
		return countCompletedBranchesOnlyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY:
			return getCountCompletedBranchesOnly();
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
		case BPELPackage.BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY:
			setCountCompletedBranchesOnly((Boolean) newValue);
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
		case BPELPackage.BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY:
			unsetCountCompletedBranchesOnly();
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
		case BPELPackage.BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY:
			return isSetCountCompletedBranchesOnly();
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
		result.append(" (countCompletedBranchesOnly: "); //$NON-NLS-1$
		if (countCompletedBranchesOnlyESet)
			result.append(countCompletedBranchesOnly);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //BranchesImpl
