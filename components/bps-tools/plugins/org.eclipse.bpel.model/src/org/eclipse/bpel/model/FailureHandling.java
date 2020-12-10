/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Handling</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.FailureHandling#getFaultOnFailure <em>Fault On Failure</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.FailureHandling#getRetryFor <em>Retry For</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.FailureHandling#getRetryDelay <em>Retry Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getFailureHandling()
 * @model
 * @generated
 */
public interface FailureHandling extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Fault On Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault On Failure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault On Failure</em>' containment reference.
	 * @see #setFaultOnFailure(FaultOnFailure)
	 * @see org.eclipse.bpel.model.BPELPackage#getFailureHandling_FaultOnFailure()
	 * @model containment="true"
	 * @generated
	 */
	FaultOnFailure getFaultOnFailure();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.FailureHandling#getFaultOnFailure <em>Fault On Failure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault On Failure</em>' containment reference.
	 * @see #getFaultOnFailure()
	 * @generated
	 */
	void setFaultOnFailure(FaultOnFailure value);

	/**
	 * Returns the value of the '<em><b>Retry For</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry For</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry For</em>' containment reference.
	 * @see #setRetryFor(RetryFor)
	 * @see org.eclipse.bpel.model.BPELPackage#getFailureHandling_RetryFor()
	 * @model containment="true"
	 * @generated
	 */
	RetryFor getRetryFor();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.FailureHandling#getRetryFor <em>Retry For</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry For</em>' containment reference.
	 * @see #getRetryFor()
	 * @generated
	 */
	void setRetryFor(RetryFor value);

	/**
	 * Returns the value of the '<em><b>Retry Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry Delay</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Delay</em>' containment reference.
	 * @see #setRetryDelay(RetryDelay)
	 * @see org.eclipse.bpel.model.BPELPackage#getFailureHandling_RetryDelay()
	 * @model containment="true"
	 * @generated
	 */
	RetryDelay getRetryDelay();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.FailureHandling#getRetryDelay <em>Retry Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Delay</em>' containment reference.
	 * @see #getRetryDelay()
	 * @generated
	 */
	void setRetryDelay(RetryDelay value);

} // FailureHandling
