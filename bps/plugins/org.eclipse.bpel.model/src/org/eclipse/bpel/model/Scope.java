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
 * $Id: Scope.java,v 1.7 2008/02/28 17:33:21 smoser Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines a nested activity with its own associated fault and compensation handlers.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Scope#getIsolated <em>Isolated</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getFaultHandlers <em>Fault Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getCompensationHandler <em>Compensation Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getEventHandlers <em>Event Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getPartnerLinks <em>Partner Links</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getTerminationHandler <em>Termination Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getMessageExchanges <em>Message Exchanges</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Scope#getExitOnStandardFault <em>Exit On Standard Fault</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getScope()
 * @model
 * @generated
 */
public interface Scope extends Activity {
	/**
	 * Returns the value of the '<em><b>Isolated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Isolated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Isolated</em>' attribute.
	 * @see #isSetIsolated()
	 * @see #unsetIsolated()
	 * @see #setIsolated(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_Isolated()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getIsolated();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getIsolated <em>Isolated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isolated</em>' attribute.
	 * @see #isSetIsolated()
	 * @see #unsetIsolated()
	 * @see #getIsolated()
	 */
	void setIsolated(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Scope#getIsolated <em>Isolated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsolated()
	 * @see #getIsolated()
	 * @see #setIsolated(Boolean)
	 */
	void unsetIsolated();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Scope#getIsolated <em>Isolated</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Isolated</em>' attribute is set.
	 * @see #unsetIsolated()
	 * @see #getIsolated()
	 * @see #setIsolated(Boolean)
	 * @generated
	 */
	boolean isSetIsolated();

	/**
	 * Returns the value of the '<em><b>Fault Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Handlers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Handlers</em>' containment reference.
	 * @see #setFaultHandlers(FaultHandler)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_FaultHandlers()
	 * @model containment="true"
	 * @generated
	 */
	FaultHandler getFaultHandlers();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getFaultHandlers <em>Fault Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Handlers</em>' containment reference.
	 * @see #getFaultHandlers()
	 * @generated
	 */
	void setFaultHandlers(FaultHandler value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_CompensationHandler()
	 * @model containment="true"
	 * @generated
	 */
	CompensationHandler getCompensationHandler();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getCompensationHandler <em>Compensation Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compensation Handler</em>' containment reference.
	 * @see #getCompensationHandler()
	 * @generated
	 */
	void setCompensationHandler(CompensationHandler value);

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference.
	 * @see #setActivity(Activity)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_Activity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference.
	 * @see #setVariables(Variables)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_Variables()
	 * @model containment="true"
	 * @generated
	 */
	Variables getVariables();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getVariables <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variables</em>' containment reference.
	 * @see #getVariables()
	 * @generated
	 */
	void setVariables(Variables value);

	/**
	 * Returns the value of the '<em><b>Correlation Sets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Sets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Sets</em>' containment reference.
	 * @see #setCorrelationSets(CorrelationSets)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_CorrelationSets()
	 * @model containment="true"
	 * @generated
	 */
	CorrelationSets getCorrelationSets();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getCorrelationSets <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Sets</em>' containment reference.
	 * @see #getCorrelationSets()
	 * @generated
	 */
	void setCorrelationSets(CorrelationSets value);

	/**
	 * Returns the value of the '<em><b>Event Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Handlers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Handlers</em>' containment reference.
	 * @see #setEventHandlers(EventHandler)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_EventHandlers()
	 * @model containment="true"
	 * @generated
	 */
	EventHandler getEventHandlers();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getEventHandlers <em>Event Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Handlers</em>' containment reference.
	 * @see #getEventHandlers()
	 * @generated
	 */
	void setEventHandlers(EventHandler value);

	/**
	 * Returns the value of the '<em><b>Partner Links</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Links</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Links</em>' containment reference.
	 * @see #setPartnerLinks(PartnerLinks)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_PartnerLinks()
	 * @model containment="true"
	 * @generated
	 */
	PartnerLinks getPartnerLinks();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getPartnerLinks <em>Partner Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Links</em>' containment reference.
	 * @see #getPartnerLinks()
	 * @generated
	 */
	void setPartnerLinks(PartnerLinks value);

	/**
	 * Returns the value of the '<em><b>Termination Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Termination Handler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Termination Handler</em>' containment reference.
	 * @see #setTerminationHandler(TerminationHandler)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_TerminationHandler()
	 * @model containment="true"
	 * @generated
	 */
	TerminationHandler getTerminationHandler();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getTerminationHandler <em>Termination Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Termination Handler</em>' containment reference.
	 * @see #getTerminationHandler()
	 * @generated
	 */
	void setTerminationHandler(TerminationHandler value);

	/**
	 * Returns the value of the '<em><b>Message Exchanges</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Exchanges</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Exchanges</em>' containment reference.
	 * @see #setMessageExchanges(MessageExchanges)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_MessageExchanges()
	 * @model containment="true"
	 * @generated
	 */
	MessageExchanges getMessageExchanges();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getMessageExchanges <em>Message Exchanges</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exchanges</em>' reference.
	 * @see #getMessageExchanges()
	 */
	void setMessageExchanges(MessageExchanges value);

	/**
	 * Returns the value of the '<em><b>Exit On Standard Fault</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit On Standard Fault</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit On Standard Fault</em>' attribute.
	 * @see #isSetExitOnStandardFault()
	 * @see #unsetExitOnStandardFault()
	 * @see #setExitOnStandardFault(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getScope_ExitOnStandardFault()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getExitOnStandardFault();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Scope#getExitOnStandardFault <em>Exit On Standard Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit On Standard Fault</em>' attribute.
	 * @see #isSetExitOnStandardFault()
	 * @see #unsetExitOnStandardFault()
	 * @see #getExitOnStandardFault()
	 */
	void setExitOnStandardFault(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Scope#getExitOnStandardFault <em>Exit On Standard Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExitOnStandardFault()
	 * @see #getExitOnStandardFault()
	 * @see #setExitOnStandardFault(Boolean)
	 */
	void unsetExitOnStandardFault();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Scope#getExitOnStandardFault <em>Exit On Standard Fault</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exit On Standard Fault</em>' attribute is set.
	 * @see #unsetExitOnStandardFault()
	 * @see #getExitOnStandardFault()
	 * @see #setExitOnStandardFault(Boolean)
	 * @generated
	 */
	boolean isSetExitOnStandardFault();

} // Scope
