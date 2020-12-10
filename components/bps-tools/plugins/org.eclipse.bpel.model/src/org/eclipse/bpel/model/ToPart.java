/**
 * <copyright>
 * </copyright>
 *
 * $Id: ToPart.java,v 1.6 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.wst.wsdl.Part;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.ToPart#getFromVariable <em>From Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.ToPart#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getToPart()
 * @model
 * @generated
 */
public interface ToPart extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>From Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Variable</em>' reference.
	 * @see #setFromVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getToPart_FromVariable()
	 * @model
	 * @generated
	 */
	Variable getFromVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.ToPart#getFromVariable <em>From Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Variable</em>' reference.
	 * @see #getFromVariable()
	 */
	void setFromVariable(Variable value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getToPart_Part()
	 * @model
	 */
	Part getPart();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.ToPart#getPart <em>Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' reference.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(Part value);

} // ToPart
