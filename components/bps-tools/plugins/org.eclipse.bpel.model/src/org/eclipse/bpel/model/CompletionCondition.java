/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompletionCondition.java,v 1.7 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.CompletionCondition#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getCompletionCondition()
 * @model
 * @generated
 */
public interface CompletionCondition extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Branches</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' containment reference.
	 * @see #setBranches(Branches)
	 * @see org.eclipse.bpel.model.BPELPackage#getCompletionCondition_Branches()
	 * @model containment="true"
	 * @generated
	 */
	Branches getBranches();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.CompletionCondition#getBranches <em>Branches</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branches</em>' containment reference.
	 * @see #getBranches()
	 * @generated
	 */
	void setBranches(Branches value);

} // CompletionCondition
