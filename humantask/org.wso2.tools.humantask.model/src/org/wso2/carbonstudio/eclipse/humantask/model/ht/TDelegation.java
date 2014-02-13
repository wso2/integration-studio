/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TDelegation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getFrom <em>From</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getPotentialDelegatees <em>Potential Delegatees</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTDelegation()
 * @model extendedMetaData="name='tDelegation' kind='elementOnly'"
 * @generated
 */
public interface TDelegation extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' containment reference.
	 * @see #setFrom(TFrom)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTDelegation_From()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='from' namespace='##targetNamespace'"
	 * @generated
	 */
	TFrom getFrom();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getFrom <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' containment reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(TFrom value);

	/**
	 * Returns the value of the '<em><b>Potential Delegatees</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Potential Delegatees</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Potential Delegatees</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
	 * @see #isSetPotentialDelegatees()
	 * @see #unsetPotentialDelegatees()
	 * @see #setPotentialDelegatees(TPotentialDelegatees)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTDelegation_PotentialDelegatees()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='potentialDelegatees'"
	 * @generated
	 */
	TPotentialDelegatees getPotentialDelegatees();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getPotentialDelegatees <em>Potential Delegatees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Potential Delegatees</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
	 * @see #isSetPotentialDelegatees()
	 * @see #unsetPotentialDelegatees()
	 * @see #getPotentialDelegatees()
	 * @generated
	 */
	void setPotentialDelegatees(TPotentialDelegatees value);

	/**
	 * Unsets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getPotentialDelegatees <em>Potential Delegatees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPotentialDelegatees()
	 * @see #getPotentialDelegatees()
	 * @see #setPotentialDelegatees(TPotentialDelegatees)
	 * @generated
	 */
	void unsetPotentialDelegatees();

	/**
	 * Returns whether the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getPotentialDelegatees <em>Potential Delegatees</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Potential Delegatees</em>' attribute is set.
	 * @see #unsetPotentialDelegatees()
	 * @see #getPotentialDelegatees()
	 * @see #setPotentialDelegatees(TPotentialDelegatees)
	 * @generated
	 */
	boolean isSetPotentialDelegatees();

} // TDelegation
