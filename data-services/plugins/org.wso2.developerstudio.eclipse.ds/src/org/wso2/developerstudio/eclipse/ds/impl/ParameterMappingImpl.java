/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.ParameterMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl#getQueryParam <em>Query Param</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterMappingImpl extends EObjectImpl implements ParameterMapping {
	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected String column = COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueryParam() <em>Query Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryParam()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_PARAM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryParam() <em>Query Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryParam()
	 * @generated
	 * @ordered
	 */
	protected String queryParam = QUERY_PARAM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EClass eStaticClass() {
		return DsPackage.Literals.PARAMETER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(String newColumn) {
		String oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.PARAMETER_MAPPING__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.PARAMETER_MAPPING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryParam() {
		return queryParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryParam(String newQueryParam) {
		String oldQueryParam = queryParam;
		queryParam = newQueryParam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.PARAMETER_MAPPING__QUERY_PARAM, oldQueryParam, queryParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DsPackage.PARAMETER_MAPPING__COLUMN:
				return getColumn();
			case DsPackage.PARAMETER_MAPPING__NAME:
				return getName();
			case DsPackage.PARAMETER_MAPPING__QUERY_PARAM:
				return getQueryParam();
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
			case DsPackage.PARAMETER_MAPPING__COLUMN:
				setColumn((String)newValue);
				return;
			case DsPackage.PARAMETER_MAPPING__NAME:
				setName((String)newValue);
				return;
			case DsPackage.PARAMETER_MAPPING__QUERY_PARAM:
				setQueryParam((String)newValue);
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
			case DsPackage.PARAMETER_MAPPING__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case DsPackage.PARAMETER_MAPPING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DsPackage.PARAMETER_MAPPING__QUERY_PARAM:
				setQueryParam(QUERY_PARAM_EDEFAULT);
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
			case DsPackage.PARAMETER_MAPPING__COLUMN:
				return COLUMN_EDEFAULT == null ? column != null : !COLUMN_EDEFAULT.equals(column);
			case DsPackage.PARAMETER_MAPPING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DsPackage.PARAMETER_MAPPING__QUERY_PARAM:
				return QUERY_PARAM_EDEFAULT == null ? queryParam != null : !QUERY_PARAM_EDEFAULT.equals(queryParam);
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
		result.append(" (column: ");
		result.append(column);
		result.append(", name: ");
		result.append(name);
		result.append(", queryParam: ");
		result.append(queryParam);
		result.append(')');
		return result.toString();
	}

} // ParameterMappingImpl
