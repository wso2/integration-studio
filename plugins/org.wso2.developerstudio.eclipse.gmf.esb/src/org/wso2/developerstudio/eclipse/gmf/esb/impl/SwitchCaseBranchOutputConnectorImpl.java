/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Case Branch Output Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchCaseBranchOutputConnectorImpl#getCaseRegex <em>Case Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchCaseBranchOutputConnectorImpl extends OutputConnectorImpl implements SwitchCaseBranchOutputConnector {
	/**
	 * The default value of the '{@link #getCaseRegex() <em>Case Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String CASE_REGEX_EDEFAULT = ".*+";

	/**
	 * The cached value of the '{@link #getCaseRegex() <em>Case Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseRegex()
	 * @generated
	 * @ordered
	 */
	protected String caseRegex = CASE_REGEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchCaseBranchOutputConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCaseRegex() {
		return caseRegex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseRegex(String newCaseRegex) {
		String oldCaseRegex = caseRegex;
		caseRegex = newCaseRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX, oldCaseRegex, caseRegex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX:
				return getCaseRegex();
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
			case EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX:
				setCaseRegex((String)newValue);
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
			case EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX:
				setCaseRegex(CASE_REGEX_EDEFAULT);
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
			case EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX:
				return CASE_REGEX_EDEFAULT == null ? caseRegex != null : !CASE_REGEX_EDEFAULT.equals(caseRegex);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (caseRegex: ");
		result.append(caseRegex);
		result.append(')');
		return result.toString();
	}

} //SwitchCaseBranchOutputConnectorImpl
