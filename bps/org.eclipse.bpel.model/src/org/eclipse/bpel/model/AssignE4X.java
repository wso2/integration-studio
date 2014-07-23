/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign E4X</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.AssignE4X#getValidate <em>Validate</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.AssignE4X#getExtensionAssignOperation <em>Extension Assign Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getAssignE4X()
 * @model
 * @generated
 */
public interface AssignE4X extends Activity {
	/**
	 * Returns the value of the '<em><b>Validate</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate</em>' attribute.
	 * @see #setValidate(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getAssignE4X_Validate()
	 * @model default="" required="true"
	 * @generated
	 */
	Boolean getValidate();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.AssignE4X#getValidate <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate</em>' attribute.
	 * @see #getValidate()
	 * @generated
	 */
	void setValidate(Boolean value);

	/**
	 * Returns the value of the '<em><b>Extension Assign Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.ExtensionAssignOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Assign Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Assign Operation</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getAssignE4X_ExtensionAssignOperation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExtensionAssignOperation> getExtensionAssignOperation();

} // AssignE4X
