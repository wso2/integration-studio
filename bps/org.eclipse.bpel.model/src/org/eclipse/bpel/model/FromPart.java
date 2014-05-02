/**
 * <copyright>
 * </copyright>
 *
 * $Id: FromPart.java,v 1.6 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.wst.wsdl.Part;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.FromPart#getToVariable <em>To Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.FromPart#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getFromPart()
 * @model
 * @generated
 */
public interface FromPart extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>To Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Variable</em>' reference.
	 * @see #setToVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getFromPart_ToVariable()
	 * @model
	 * @generated
	 */
	Variable getToVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.FromPart#getToVariable <em>To Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Variable</em>' reference.
	 * @see #getToVariable()
	 */
	void setToVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' reference.
	 * @see #setPart(Part)
	 * @see org.eclipse.bpel.model.BPELPackage#getFromPart_Part()
	 * @model
	 * @generated
	 */
	Part getPart();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.FromPart#getPart <em>Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' reference.
	 * @see #getPart()
	 */
	void setPart(Part value);

} // FromPart
