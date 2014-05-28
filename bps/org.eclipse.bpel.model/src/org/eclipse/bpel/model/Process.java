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
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Describes behavior based on interactions between the activities performed by partners through Web Service interfaces. Defines how individual or composite activities are coordinated to achieve a business goal, as well as the state and logic necessary for this coordination. Represents stateful, long-running interactions in which each interaction has a beginning, defined behavior during its lifetime, and an end.
 * 
 * Abstract processes approach data handling in a way that reflects the level of abstraction required to describe the public aspects of the business protocol. Abstract processes handle only protocol-relevant data as defined by message properties.
 * 
 * Processes and Partners are modeled as WSDL services.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Process#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getTargetNamespace <em>Target Namespace</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getVariableAccessSerializable <em>Variable Access Serializable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getPartnerLinks <em>Partner Links</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getFaultHandlers <em>Fault Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getEventHandlers <em>Event Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getExitOnStandardFault <em>Exit On Standard Fault</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getMessageExchanges <em>Message Exchanges</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Process#getAbstractProcessProfile <em>Abstract Process Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Namespace</em>' attribute.
	 * @see #setTargetNamespace(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_TargetNamespace()
	 * @model
	 * @generated
	 */
	String getTargetNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getTargetNamespace <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Namespace</em>' attribute.
	 * @see #getTargetNamespace()
	 * @generated
	 */
	void setTargetNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Query Language</b></em>' attribute.
	 * The default value is <code>"urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Language</em>' attribute.
	 * @see #isSetQueryLanguage()
	 * @see #unsetQueryLanguage()
	 * @see #setQueryLanguage(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_QueryLanguage()
	 * @model default="urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0" unsettable="true"
	 * @generated
	 */
	String getQueryLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getQueryLanguage <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Language</em>' attribute.
	 * @see #isSetQueryLanguage()
	 * @see #unsetQueryLanguage()
	 * @see #getQueryLanguage()
	 * @generated
	 */
	void setQueryLanguage(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Process#getQueryLanguage <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQueryLanguage()
	 * @see #getQueryLanguage()
	 * @see #setQueryLanguage(String)
	 * @generated
	 */
	void unsetQueryLanguage();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Process#getQueryLanguage <em>Query Language</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Query Language</em>' attribute is set.
	 * @see #unsetQueryLanguage()
	 * @see #getQueryLanguage()
	 * @see #setQueryLanguage(String)
	 * @generated
	 */
	boolean isSetQueryLanguage();

	/**
	 * Returns the value of the '<em><b>Expression Language</b></em>' attribute.
	 * The default value is <code>"urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Language</em>' attribute.
	 * @see #isSetExpressionLanguage()
	 * @see #unsetExpressionLanguage()
	 * @see #setExpressionLanguage(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_ExpressionLanguage()
	 * @model default="urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0" unsettable="true"
	 * @generated
	 */
	String getExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getExpressionLanguage <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Language</em>' attribute.
	 * @see #isSetExpressionLanguage()
	 * @see #unsetExpressionLanguage()
	 * @see #getExpressionLanguage()
	 * @generated
	 */
	void setExpressionLanguage(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Process#getExpressionLanguage <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpressionLanguage()
	 * @see #getExpressionLanguage()
	 * @see #setExpressionLanguage(String)
	 * @generated
	 */
	void unsetExpressionLanguage();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Process#getExpressionLanguage <em>Expression Language</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression Language</em>' attribute is set.
	 * @see #unsetExpressionLanguage()
	 * @see #getExpressionLanguage()
	 * @see #setExpressionLanguage(String)
	 * @generated
	 */
	boolean isSetExpressionLanguage();

	/**
	 * Returns the value of the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether the joinFailure fault will be suppressed for all activities in the process. Default is false.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see #isSetSuppressJoinFailure()
	 * @see #unsetSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_SuppressJoinFailure()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getSuppressJoinFailure();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see #isSetSuppressJoinFailure()
	 * @see #unsetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @generated
	 */
	void setSuppressJoinFailure(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Process#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(Boolean)
	 * @generated
	 */
	void unsetSuppressJoinFailure();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Process#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Suppress Join Failure</em>' attribute is set.
	 * @see #unsetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(Boolean)
	 * @generated
	 */
	boolean isSetSuppressJoinFailure();

	/**
	 * Returns the value of the '<em><b>Variable Access Serializable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the XML query language used for selection of nodes in assignment, property definitions, and other uses. The default is XPath 1.0.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Access Serializable</em>' attribute.
	 * @see #isSetVariableAccessSerializable()
	 * @see #unsetVariableAccessSerializable()
	 * @see #setVariableAccessSerializable(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_VariableAccessSerializable()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getVariableAccessSerializable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getVariableAccessSerializable <em>Variable Access Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Access Serializable</em>' attribute.
	 * @see #isSetVariableAccessSerializable()
	 * @see #unsetVariableAccessSerializable()
	 * @see #getVariableAccessSerializable()
	 * @generated
	 */
	void setVariableAccessSerializable(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Process#getVariableAccessSerializable <em>Variable Access Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVariableAccessSerializable()
	 * @see #getVariableAccessSerializable()
	 * @see #setVariableAccessSerializable(Boolean)
	 * @generated
	 */
	void unsetVariableAccessSerializable();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Process#getVariableAccessSerializable <em>Variable Access Serializable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Variable Access Serializable</em>' attribute is set.
	 * @see #unsetVariableAccessSerializable()
	 * @see #getVariableAccessSerializable()
	 * @see #setVariableAccessSerializable(Boolean)
	 * @generated
	 */
	boolean isSetVariableAccessSerializable();

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_PartnerLinks()
	 * @model containment="true"
	 * @generated
	 */
	PartnerLinks getPartnerLinks();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getPartnerLinks <em>Partner Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Links</em>' containment reference.
	 * @see #getPartnerLinks()
	 * @generated
	 */
	void setPartnerLinks(PartnerLinks value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_Variables()
	 * @model containment="true"
	 * @generated
	 */
	Variables getVariables();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getVariables <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variables</em>' containment reference.
	 * @see #getVariables()
	 * @generated
	 */
	void setVariables(Variables value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_Activity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_FaultHandlers()
	 * @model containment="true"
	 * @generated
	 */
	FaultHandler getFaultHandlers();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getFaultHandlers <em>Fault Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Handlers</em>' containment reference.
	 * @see #getFaultHandlers()
	 * @generated
	 */
	void setFaultHandlers(FaultHandler value);

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference.
	 * @see #setExtensions(Extensions)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	Extensions getExtensions();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getExtensions <em>Extensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extensions</em>' containment reference.
	 * @see #getExtensions()
	 * @generated
	 */
	void setExtensions(Extensions value);

	/**
	 * Returns the value of the '<em><b>Exit On Standard Fault</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit On Standard Fault</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit On Standard Fault</em>' attribute.
	 * @see #setExitOnStandardFault(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_ExitOnStandardFault()
	 * @model default="true"
	 * @generated
	 */
	Boolean getExitOnStandardFault();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getExitOnStandardFault <em>Exit On Standard Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit On Standard Fault</em>' attribute.
	 * @see #getExitOnStandardFault()
	 * @generated
	 */
	void setExitOnStandardFault(Boolean value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_MessageExchanges()
	 * @model containment="true"
	 * @generated
	 */
	MessageExchanges getMessageExchanges();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getMessageExchanges <em>Message Exchanges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exchanges</em>' containment reference.
	 * @see #getMessageExchanges()
	 * @generated
	 */
	void setMessageExchanges(MessageExchanges value);

	/**
	 * Returns the value of the '<em><b>Abstract Process Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Process Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Process Profile</em>' attribute.
	 * @see #isSetAbstractProcessProfile()
	 * @see #unsetAbstractProcessProfile()
	 * @see #setAbstractProcessProfile(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_AbstractProcessProfile()
	 * @model unsettable="true"
	 * @generated
	 */
	String getAbstractProcessProfile();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getAbstractProcessProfile <em>Abstract Process Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Process Profile</em>' attribute.
	 * @see #isSetAbstractProcessProfile()
	 * @see #unsetAbstractProcessProfile()
	 * @see #getAbstractProcessProfile()
	 * @generated
	 */
	void setAbstractProcessProfile(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Process#getAbstractProcessProfile <em>Abstract Process Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAbstractProcessProfile()
	 * @see #getAbstractProcessProfile()
	 * @see #setAbstractProcessProfile(String)
	 * @generated
	 */
	void unsetAbstractProcessProfile();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Process#getAbstractProcessProfile <em>Abstract Process Profile</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Abstract Process Profile</em>' attribute is set.
	 * @see #unsetAbstractProcessProfile()
	 * @see #getAbstractProcessProfile()
	 * @see #setAbstractProcessProfile(String)
	 * @generated
	 */
	boolean isSetAbstractProcessProfile();

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_EventHandlers()
	 * @model containment="true"
	 * @generated
	 */
	EventHandler getEventHandlers();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getEventHandlers <em>Event Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Handlers</em>' containment reference.
	 * @see #getEventHandlers()
	 * @generated
	 */
	void setEventHandlers(EventHandler value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_CorrelationSets()
	 * @model containment="true"
	 * @generated
	 */
	CorrelationSets getCorrelationSets();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Process#getCorrelationSets <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Sets</em>' containment reference.
	 * @see #getCorrelationSets()
	 * @generated
	 */
	void setCorrelationSets(CorrelationSets value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getProcess_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns a list of objects that implement Runnable
	 * The objects in this list will be run after loading the process.
	 * @return a list of tasks to do in pass 2
	 * @customized
	 */
	java.util.List<Runnable> getPostLoadRunnables();

} // Process
