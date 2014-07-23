/**
 * <copyright>
 * </copyright>
 *
 * $Id: Branches.java,v 1.3 2007/12/06 20:01:24 smoser Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branches</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Branches#getCountCompletedBranchesOnly <em>Count Completed Branches Only</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getBranches()
 * @model
 * @generated
 */
public interface Branches extends Expression {
	/**
	 * Returns the value of the '<em><b>Count Completed Branches Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Completed Branches Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Completed Branches Only</em>' attribute.
	 * @see #isSetCountCompletedBranchesOnly()
	 * @see #unsetCountCompletedBranchesOnly()
	 * @see #setCountCompletedBranchesOnly(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getBranches_CountCompletedBranchesOnly()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getCountCompletedBranchesOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Branches#getCountCompletedBranchesOnly <em>Count Completed Branches Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Completed Branches Only</em>' attribute.
	 * @see #isSetCountCompletedBranchesOnly()
	 * @see #unsetCountCompletedBranchesOnly()
	 * @see #getCountCompletedBranchesOnly()
	 */
	void setCountCompletedBranchesOnly(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Branches#getCountCompletedBranchesOnly <em>Count Completed Branches Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCountCompletedBranchesOnly()
	 * @see #getCountCompletedBranchesOnly()
	 * @see #setCountCompletedBranchesOnly(Boolean)
	 */
	void unsetCountCompletedBranchesOnly();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Branches#getCountCompletedBranchesOnly <em>Count Completed Branches Only</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Count Completed Branches Only</em>' attribute is set.
	 * @see #unsetCountCompletedBranchesOnly()
	 * @see #getCountCompletedBranchesOnly()
	 * @see #setCountCompletedBranchesOnly(Boolean)
	 * @generated
	 */
	boolean isSetCountCompletedBranchesOnly();

} // Branches
