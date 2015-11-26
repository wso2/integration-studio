/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.GSpreadQuery;
import org.wso2.developerstudio.eclipse.ds.HasHeader;
import org.wso2.developerstudio.eclipse.ds.MaxRowCount;
import org.wso2.developerstudio.eclipse.ds.StartingRow;
import org.wso2.developerstudio.eclipse.ds.WorkSheetNumber;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GSpread Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl#getWorksheetnumber <em>Worksheetnumber</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl#getStartingrow <em>Startingrow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl#getMaxrowcount <em>Maxrowcount</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl#getHasheader <em>Hasheader</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GSpreadQueryImpl extends EObjectImpl implements GSpreadQuery {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GSpreadQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EClass eStaticClass() {
		return DsPackage.Literals.GSPREAD_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DsPackage.GSPREAD_QUERY__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkSheetNumber getWorksheetnumber() {
		return (WorkSheetNumber)getMixed().get(DsPackage.Literals.GSPREAD_QUERY__WORKSHEETNUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorksheetnumber(WorkSheetNumber newWorksheetnumber,
	                                                 NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.GSPREAD_QUERY__WORKSHEETNUMBER, newWorksheetnumber, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorksheetnumber(WorkSheetNumber newWorksheetnumber) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.GSPREAD_QUERY__WORKSHEETNUMBER, newWorksheetnumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartingRow getStartingrow() {
		return (StartingRow)getMixed().get(DsPackage.Literals.GSPREAD_QUERY__STARTINGROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartingrow(StartingRow newStartingrow, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.GSPREAD_QUERY__STARTINGROW, newStartingrow, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingrow(StartingRow newStartingrow) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.GSPREAD_QUERY__STARTINGROW, newStartingrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxRowCount getMaxrowcount() {
		return (MaxRowCount)getMixed().get(DsPackage.Literals.GSPREAD_QUERY__MAXROWCOUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxrowcount(MaxRowCount newMaxrowcount, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.GSPREAD_QUERY__MAXROWCOUNT, newMaxrowcount, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxrowcount(MaxRowCount newMaxrowcount) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.GSPREAD_QUERY__MAXROWCOUNT, newMaxrowcount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasHeader getHasheader() {
		return (HasHeader)getMixed().get(DsPackage.Literals.GSPREAD_QUERY__HASHEADER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasheader(HasHeader newHasheader, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.GSPREAD_QUERY__HASHEADER, newHasheader, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasheader(HasHeader newHasheader) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.GSPREAD_QUERY__HASHEADER, newHasheader);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
	                                        NotificationChain msgs) {
		switch (featureID) {
			case DsPackage.GSPREAD_QUERY__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case DsPackage.GSPREAD_QUERY__WORKSHEETNUMBER:
				return basicSetWorksheetnumber(null, msgs);
			case DsPackage.GSPREAD_QUERY__STARTINGROW:
				return basicSetStartingrow(null, msgs);
			case DsPackage.GSPREAD_QUERY__MAXROWCOUNT:
				return basicSetMaxrowcount(null, msgs);
			case DsPackage.GSPREAD_QUERY__HASHEADER:
				return basicSetHasheader(null, msgs);
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
			case DsPackage.GSPREAD_QUERY__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DsPackage.GSPREAD_QUERY__WORKSHEETNUMBER:
				return getWorksheetnumber();
			case DsPackage.GSPREAD_QUERY__STARTINGROW:
				return getStartingrow();
			case DsPackage.GSPREAD_QUERY__MAXROWCOUNT:
				return getMaxrowcount();
			case DsPackage.GSPREAD_QUERY__HASHEADER:
				return getHasheader();
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
			case DsPackage.GSPREAD_QUERY__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DsPackage.GSPREAD_QUERY__WORKSHEETNUMBER:
				setWorksheetnumber((WorkSheetNumber)newValue);
				return;
			case DsPackage.GSPREAD_QUERY__STARTINGROW:
				setStartingrow((StartingRow)newValue);
				return;
			case DsPackage.GSPREAD_QUERY__MAXROWCOUNT:
				setMaxrowcount((MaxRowCount)newValue);
				return;
			case DsPackage.GSPREAD_QUERY__HASHEADER:
				setHasheader((HasHeader)newValue);
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
			case DsPackage.GSPREAD_QUERY__MIXED:
				getMixed().clear();
				return;
			case DsPackage.GSPREAD_QUERY__WORKSHEETNUMBER:
				setWorksheetnumber((WorkSheetNumber)null);
				return;
			case DsPackage.GSPREAD_QUERY__STARTINGROW:
				setStartingrow((StartingRow)null);
				return;
			case DsPackage.GSPREAD_QUERY__MAXROWCOUNT:
				setMaxrowcount((MaxRowCount)null);
				return;
			case DsPackage.GSPREAD_QUERY__HASHEADER:
				setHasheader((HasHeader)null);
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
			case DsPackage.GSPREAD_QUERY__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DsPackage.GSPREAD_QUERY__WORKSHEETNUMBER:
				return getWorksheetnumber() != null;
			case DsPackage.GSPREAD_QUERY__STARTINGROW:
				return getStartingrow() != null;
			case DsPackage.GSPREAD_QUERY__MAXROWCOUNT:
				return getMaxrowcount() != null;
			case DsPackage.GSPREAD_QUERY__HASHEADER:
				return getHasheader() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} // GSpreadQueryImpl
