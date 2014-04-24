/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: Invoke.java,v 1.5 2007/12/06 20:01:24 smoser Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows the business process to invoke a one-way asynchronous, or request-response synchronous operation on a portType offered by a partner playing a role in the business process as specified in a ServiceLinkType. Asyncrhosous invocations specify only an input container while synchronous invocations specify both an input and output container. Correlation sets are used to correlate the business process with a stateful service provided by the partner.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getInputVariable <em>Input Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getCompensationHandler <em>Compensation Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getFaultHandler <em>Fault Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getToParts <em>To Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Invoke#getFailureHandling <em>Failure Handling</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getInvoke()
 * @model
 * @generated
 */
public interface Invoke extends PartnerActivity {
	/**
	 * Returns the value of the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable</em>' reference.
	 * @see #setOutputVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_OutputVariable()
	 * @model
	 * @generated
	 */
	Variable getOutputVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getOutputVariable <em>Output Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Variable</em>' reference.
	 * @see #getOutputVariable()
	 */
	void setOutputVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable</em>' reference.
	 * @see #setInputVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_InputVariable()
	 * @model
	 * @generated
	 */
	Variable getInputVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getInputVariable <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Variable</em>' reference.
	 * @see #getInputVariable()
	 */
	void setInputVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Compensation Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compensation Handler</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compensation Handler</em>' containment reference.
	 * @see #setCompensationHandler(CompensationHandler)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_CompensationHandler()
	 * @model containment="true"
	 * @generated
	 */
	CompensationHandler getCompensationHandler();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getCompensationHandler <em>Compensation Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compensation Handler</em>' containment reference.
	 * @see #getCompensationHandler()
	 * @generated
	 */
	void setCompensationHandler(CompensationHandler value);

	/**
	 * Returns the value of the '<em><b>Fault Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Handler</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Handler</em>' containment reference.
	 * @see #setFaultHandler(FaultHandler)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_FaultHandler()
	 * @model containment="true"
	 * @generated
	 */
	FaultHandler getFaultHandler();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getFaultHandler <em>Fault Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Handler</em>' containment reference.
	 * @see #getFaultHandler()
	 * @generated
	 */
	void setFaultHandler(FaultHandler value);

	/**
	 * Returns the value of the '<em><b>From Parts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Parts</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Parts</em>' containment reference.
	 * @see #setFromParts(FromParts)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_FromParts()
	 * @model containment="true"
	 * @generated
	 */
	FromParts getFromParts();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getFromParts <em>From Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Parts</em>' containment reference.
	 * @see #getFromParts()
	 * @generated
	 */
	void setFromParts(FromParts value);

	/**
	 * Returns the value of the '<em><b>To Parts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Parts</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Parts</em>' containment reference.
	 * @see #setToParts(ToParts)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_ToParts()
	 * @model containment="true"
	 * @generated
	 */
	ToParts getToParts();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getToParts <em>To Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Parts</em>' containment reference.
	 * @see #getToParts()
	 * @generated
	 */
	void setToParts(ToParts value);

	/**
	 * Returns the value of the '<em><b>Failure Handling</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Handling</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Handling</em>' containment reference.
	 * @see #setFailureHandling(FailureHandling)
	 * @see org.eclipse.bpel.model.BPELPackage#getInvoke_FailureHandling()
	 * @model containment="true"
	 * @generated
	 */
	FailureHandling getFailureHandling();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Invoke#getFailureHandling <em>Failure Handling</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Handling</em>' containment reference.
	 * @see #getFailureHandling()
	 * @generated
	 */
	void setFailureHandling(FailureHandling value);

} // Invoke
