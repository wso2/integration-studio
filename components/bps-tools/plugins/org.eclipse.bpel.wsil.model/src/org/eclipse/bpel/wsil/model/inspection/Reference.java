/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.Reference#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.Reference#getReferencedNamespace <em>Referenced Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.wsil.model.inspection.InspectionPackage#getReference()
 * @model extendedMetaData="name='referenceType' kind='elementOnly'"
 * @generated
 */
public interface Reference extends ItemWithAbstracts {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.eclipse.bpel.wsil.model.inspection.InspectionPackage#getReference_Location()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.wsil.model.inspection.Reference#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Referenced Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Namespace</em>' attribute.
	 * @see #setReferencedNamespace(String)
	 * @see org.eclipse.bpel.wsil.model.inspection.InspectionPackage#getReference_ReferencedNamespace()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        extendedMetaData="kind='attribute' name='referencedNamespace'"
	 * @generated
	 */
	String getReferencedNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.wsil.model.inspection.Reference#getReferencedNamespace <em>Referenced Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Namespace</em>' attribute.
	 * @see #getReferencedNamespace()
	 * @generated
	 */
	void setReferencedNamespace(String value);

} // Reference