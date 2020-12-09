/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageExchange.java,v 1.6 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exchange</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.MessageExchange#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getMessageExchange()
 * @model
 * @generated
 */
public interface MessageExchange extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getMessageExchange_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.MessageExchange#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 */
	void setName(String value);

} // MessageExchange
