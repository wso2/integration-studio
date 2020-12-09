/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageExchanges.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exchanges</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.MessageExchanges#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getMessageExchanges()
 * @model
 * @generated
 */
public interface MessageExchanges extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.MessageExchange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getMessageExchanges_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<MessageExchange> getChildren();

} // MessageExchanges
