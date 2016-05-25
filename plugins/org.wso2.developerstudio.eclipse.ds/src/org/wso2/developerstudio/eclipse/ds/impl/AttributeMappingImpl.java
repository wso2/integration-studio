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

import org.wso2.developerstudio.eclipse.ds.AttributeMapping;
import org.wso2.developerstudio.eclipse.ds.DsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl#getRequiredRoles <em>Required Roles</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl#getXsdType <em>Xsd Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeMappingImpl extends EObjectImpl implements AttributeMapping {
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
	 * The default value of the '{@link #getRequiredRoles() <em>Required Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRoles()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_ROLES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequiredRoles() <em>Required Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRoles()
	 * @generated
	 * @ordered
	 */
	protected String requiredRoles = REQUIRED_ROLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getXsdType() <em>Xsd Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsdType()
	 * @generated
	 * @ordered
	 */
	protected static final String XSD_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXsdType() <em>Xsd Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsdType()
	 * @generated
	 * @ordered
	 */
	protected String xsdType = XSD_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EClass eStaticClass() {
		return DsPackage.Literals.ATTRIBUTE_MAPPING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.ATTRIBUTE_MAPPING__COLUMN, oldColumn, column));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.ATTRIBUTE_MAPPING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequiredRoles() {
		return requiredRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRoles(String newRequiredRoles) {
		String oldRequiredRoles = requiredRoles;
		requiredRoles = newRequiredRoles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.ATTRIBUTE_MAPPING__REQUIRED_ROLES, oldRequiredRoles, requiredRoles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXsdType() {
		return xsdType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsdType(String newXsdType) {
		String oldXsdType = xsdType;
		xsdType = newXsdType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.ATTRIBUTE_MAPPING__XSD_TYPE, oldXsdType, xsdType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.ATTRIBUTE_MAPPING__OPTIONAL, oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DsPackage.ATTRIBUTE_MAPPING__COLUMN:
				return getColumn();
			case DsPackage.ATTRIBUTE_MAPPING__NAME:
				return getName();
			case DsPackage.ATTRIBUTE_MAPPING__REQUIRED_ROLES:
				return getRequiredRoles();
			case DsPackage.ATTRIBUTE_MAPPING__XSD_TYPE:
				return getXsdType();
			case DsPackage.ATTRIBUTE_MAPPING__OPTIONAL:
				return isOptional();
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
			case DsPackage.ATTRIBUTE_MAPPING__COLUMN:
				setColumn((String)newValue);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__NAME:
				setName((String)newValue);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__REQUIRED_ROLES:
				setRequiredRoles((String)newValue);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__XSD_TYPE:
				setXsdType((String)newValue);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__OPTIONAL:
				setOptional((Boolean)newValue);
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
			case DsPackage.ATTRIBUTE_MAPPING__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__REQUIRED_ROLES:
				setRequiredRoles(REQUIRED_ROLES_EDEFAULT);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__XSD_TYPE:
				setXsdType(XSD_TYPE_EDEFAULT);
				return;
			case DsPackage.ATTRIBUTE_MAPPING__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
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
			case DsPackage.ATTRIBUTE_MAPPING__COLUMN:
				return COLUMN_EDEFAULT == null ? column != null : !COLUMN_EDEFAULT.equals(column);
			case DsPackage.ATTRIBUTE_MAPPING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DsPackage.ATTRIBUTE_MAPPING__REQUIRED_ROLES:
				return REQUIRED_ROLES_EDEFAULT == null ? requiredRoles != null : !REQUIRED_ROLES_EDEFAULT.equals(requiredRoles);
			case DsPackage.ATTRIBUTE_MAPPING__XSD_TYPE:
				return XSD_TYPE_EDEFAULT == null ? xsdType != null : !XSD_TYPE_EDEFAULT.equals(xsdType);
			case DsPackage.ATTRIBUTE_MAPPING__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
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
		result.append(", requiredRoles: ");
		result.append(requiredRoles);
		result.append(", xsdType: ");
		result.append(xsdType);
		result.append(", optional: ");
		result.append(optional);
		result.append(')');
		return result.toString();
	}

} // AttributeMappingImpl
