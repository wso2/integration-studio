/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iterator.java,v 1.1 2006/01/31 14:56:08 james Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Iterator#getFinalCounterValue <em>Final Counter Value</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Iterator#getStartCounterValue <em>Start Counter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getIterator()
 * @model
 * @generated
 */
public interface Iterator extends EObject {
	/**
	 * Returns the value of the '<em><b>Final Counter Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final Counter Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Counter Value</em>' containment reference.
	 * @see #setFinalCounterValue(Expression)
	 * @see org.eclipse.bpel.model.BPELPackage#getIterator_FinalCounterValue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getFinalCounterValue();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Iterator#getFinalCounterValue <em>Final Counter Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Counter Value</em>' containment reference.
	 * @see #getFinalCounterValue()
	 * @generated
	 */
	void setFinalCounterValue(Expression value);

	/**
	 * Returns the value of the '<em><b>Start Counter Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Counter Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Counter Value</em>' containment reference.
	 * @see #setStartCounterValue(Expression)
	 * @see org.eclipse.bpel.model.BPELPackage#getIterator_StartCounterValue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getStartCounterValue();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Iterator#getStartCounterValue <em>Start Counter Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Counter Value</em>' containment reference.
	 * @see #getStartCounterValue()
	 * @generated
	 */
	void setStartCounterValue(Expression value);

} // Iterator
