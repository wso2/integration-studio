/**
 * <copyright>
 * </copyright>
 *
 * $Id: Validate.java,v 1.2 2007/08/01 21:02:30 mchmielewski Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Validate#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getValidate()
 * @model
 * @generated
 */
public interface Validate extends Activity {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getValidate_Variables()
	 * @model
	 * @generated
	 */
	EList<Variable> getVariables();

} // Validate
