/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Assign Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.ExtensionAssignOperation#getSnippet <em>Snippet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getExtensionAssignOperation()
 * @model
 * @generated
 */
public interface ExtensionAssignOperation extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Snippet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snippet</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snippet</em>' containment reference.
	 * @see #setSnippet(Snippet)
	 * @see org.eclipse.bpel.model.BPELPackage#getExtensionAssignOperation_Snippet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Snippet getSnippet();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.ExtensionAssignOperation#getSnippet <em>Snippet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snippet</em>' containment reference.
	 * @see #getSnippet()
	 * @generated
	 */
	void setSnippet(Snippet value);

} // ExtensionAssignOperation
