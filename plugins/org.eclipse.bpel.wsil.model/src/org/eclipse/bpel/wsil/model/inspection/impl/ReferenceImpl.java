/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection.impl;

import org.eclipse.bpel.wsil.model.inspection.InspectionPackage;
import org.eclipse.bpel.wsil.model.inspection.Reference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.ReferenceImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.impl.ReferenceImpl#getReferencedNamespace <em>Referenced Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends ItemWithAbstractsImpl implements Reference {
	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferencedNamespace() <em>Referenced Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCED_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferencedNamespace() <em>Referenced Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedNamespace()
	 * @generated
	 * @ordered
	 */
	protected String referencedNamespace = REFERENCED_NAMESPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InspectionPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InspectionPackage.REFERENCE__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferencedNamespace() {
		return referencedNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedNamespace(String newReferencedNamespace) {
		String oldReferencedNamespace = referencedNamespace;
		referencedNamespace = newReferencedNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InspectionPackage.REFERENCE__REFERENCED_NAMESPACE, oldReferencedNamespace, referencedNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InspectionPackage.REFERENCE__LOCATION:
				return getLocation();
			case InspectionPackage.REFERENCE__REFERENCED_NAMESPACE:
				return getReferencedNamespace();
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
			case InspectionPackage.REFERENCE__LOCATION:
				setLocation((String)newValue);
				return;
			case InspectionPackage.REFERENCE__REFERENCED_NAMESPACE:
				setReferencedNamespace((String)newValue);
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
			case InspectionPackage.REFERENCE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case InspectionPackage.REFERENCE__REFERENCED_NAMESPACE:
				setReferencedNamespace(REFERENCED_NAMESPACE_EDEFAULT);
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
			case InspectionPackage.REFERENCE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case InspectionPackage.REFERENCE__REFERENCED_NAMESPACE:
				return REFERENCED_NAMESPACE_EDEFAULT == null ? referencedNamespace != null : !REFERENCED_NAMESPACE_EDEFAULT.equals(referencedNamespace);
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
		result.append(" (location: ");
		result.append(location);
		result.append(", referencedNamespace: ");
		result.append(referencedNamespace);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl