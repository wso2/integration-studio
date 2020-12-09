/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item With Abstracts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.wsil.model.inspection.ItemWithAbstracts#getAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.wsil.model.inspection.InspectionPackage#getItemWithAbstracts()
 * @model abstract="true"
 *        extendedMetaData="name='itemWithAbstracts' kind='elementOnly'"
 * @generated
 */
public interface ItemWithAbstracts extends EObject {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' containment reference list.
	 * @see org.eclipse.bpel.wsil.model.inspection.InspectionPackage#getItemWithAbstracts_Abstract()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='abstract' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TypeOfAbstract> getAbstract();

} // ItemWithAbstracts