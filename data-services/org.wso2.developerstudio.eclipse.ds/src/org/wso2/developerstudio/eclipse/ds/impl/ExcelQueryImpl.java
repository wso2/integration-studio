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
import org.wso2.developerstudio.eclipse.ds.ExcelQuery;
import org.wso2.developerstudio.eclipse.ds.HasHeader;
import org.wso2.developerstudio.eclipse.ds.MaxRowCount;
import org.wso2.developerstudio.eclipse.ds.StartingRow;
import org.wso2.developerstudio.eclipse.ds.WorkBookName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Excel Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl#getWorkbookname <em>Workbookname</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl#getHasheader <em>Hasheader</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl#getStartingrow <em>Startingrow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl#getMaxrowcount <em>Maxrowcount</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExcelQueryImpl extends EObjectImpl implements ExcelQuery {
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
	protected ExcelQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EClass eStaticClass() {
		return DsPackage.Literals.EXCEL_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DsPackage.EXCEL_QUERY__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkBookName getWorkbookname() {
		return (WorkBookName)getMixed().get(DsPackage.Literals.EXCEL_QUERY__WORKBOOKNAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkbookname(WorkBookName newWorkbookname,
	                                              NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EXCEL_QUERY__WORKBOOKNAME, newWorkbookname, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkbookname(WorkBookName newWorkbookname) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EXCEL_QUERY__WORKBOOKNAME, newWorkbookname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasHeader getHasheader() {
		return (HasHeader)getMixed().get(DsPackage.Literals.EXCEL_QUERY__HASHEADER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasheader(HasHeader newHasheader, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EXCEL_QUERY__HASHEADER, newHasheader, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasheader(HasHeader newHasheader) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EXCEL_QUERY__HASHEADER, newHasheader);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartingRow getStartingrow() {
		return (StartingRow)getMixed().get(DsPackage.Literals.EXCEL_QUERY__STARTINGROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartingrow(StartingRow newStartingrow, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EXCEL_QUERY__STARTINGROW, newStartingrow, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingrow(StartingRow newStartingrow) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EXCEL_QUERY__STARTINGROW, newStartingrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxRowCount getMaxrowcount() {
		return (MaxRowCount)getMixed().get(DsPackage.Literals.EXCEL_QUERY__MAXROWCOUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxrowcount(MaxRowCount newMaxrowcount, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EXCEL_QUERY__MAXROWCOUNT, newMaxrowcount, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxrowcount(MaxRowCount newMaxrowcount) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EXCEL_QUERY__MAXROWCOUNT, newMaxrowcount);
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
			case DsPackage.EXCEL_QUERY__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case DsPackage.EXCEL_QUERY__WORKBOOKNAME:
				return basicSetWorkbookname(null, msgs);
			case DsPackage.EXCEL_QUERY__HASHEADER:
				return basicSetHasheader(null, msgs);
			case DsPackage.EXCEL_QUERY__STARTINGROW:
				return basicSetStartingrow(null, msgs);
			case DsPackage.EXCEL_QUERY__MAXROWCOUNT:
				return basicSetMaxrowcount(null, msgs);
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
			case DsPackage.EXCEL_QUERY__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DsPackage.EXCEL_QUERY__WORKBOOKNAME:
				return getWorkbookname();
			case DsPackage.EXCEL_QUERY__HASHEADER:
				return getHasheader();
			case DsPackage.EXCEL_QUERY__STARTINGROW:
				return getStartingrow();
			case DsPackage.EXCEL_QUERY__MAXROWCOUNT:
				return getMaxrowcount();
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
			case DsPackage.EXCEL_QUERY__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DsPackage.EXCEL_QUERY__WORKBOOKNAME:
				setWorkbookname((WorkBookName)newValue);
				return;
			case DsPackage.EXCEL_QUERY__HASHEADER:
				setHasheader((HasHeader)newValue);
				return;
			case DsPackage.EXCEL_QUERY__STARTINGROW:
				setStartingrow((StartingRow)newValue);
				return;
			case DsPackage.EXCEL_QUERY__MAXROWCOUNT:
				setMaxrowcount((MaxRowCount)newValue);
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
			case DsPackage.EXCEL_QUERY__MIXED:
				getMixed().clear();
				return;
			case DsPackage.EXCEL_QUERY__WORKBOOKNAME:
				setWorkbookname((WorkBookName)null);
				return;
			case DsPackage.EXCEL_QUERY__HASHEADER:
				setHasheader((HasHeader)null);
				return;
			case DsPackage.EXCEL_QUERY__STARTINGROW:
				setStartingrow((StartingRow)null);
				return;
			case DsPackage.EXCEL_QUERY__MAXROWCOUNT:
				setMaxrowcount((MaxRowCount)null);
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
			case DsPackage.EXCEL_QUERY__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DsPackage.EXCEL_QUERY__WORKBOOKNAME:
				return getWorkbookname() != null;
			case DsPackage.EXCEL_QUERY__HASHEADER:
				return getHasheader() != null;
			case DsPackage.EXCEL_QUERY__STARTINGROW:
				return getStartingrow() != null;
			case DsPackage.EXCEL_QUERY__MAXROWCOUNT:
				return getMaxrowcount() != null;
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

} // ExcelQueryImpl
