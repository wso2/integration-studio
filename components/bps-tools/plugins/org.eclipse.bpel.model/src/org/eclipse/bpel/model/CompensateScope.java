/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compensate Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Used to invoke compensation of an inner scope that has already completed its execution normally. This construct can  be invoked only from within a fault handler or the compensation handler of the scope that immediately encloses the scope for which compensation is to be performed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.CompensateScope#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getCompensateScope()
 * @model
 * @generated
 */
public interface CompensateScope extends Activity {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the scope whose compensation handler is to be invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Activity)
	 * @see org.eclipse.bpel.model.BPELPackage#getCompensateScope_Target()
	 * @model
	 * @generated
	 */
	Activity getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.CompensateScope#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 */
	void setTarget(Activity value);

	/**
	 * Sets the scope for which compensation is to be performed.
	 * 
	 * The specified <code>scopeName</code> must correspond with the name of a
	 * scope enclosed by the same scope that encloses this compensate activity.
	 * 
	 * @param scopeName
	 *            the scope name
	 * @see #setScope(Scope)
	 * @see #getScope()
	 * @customized
	 */

	void setTarget(String scopeName);

} // CompensateScope
