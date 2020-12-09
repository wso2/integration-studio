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
 * $Id: PartnerLink.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The services with which a business process interacts are modeled as partners in the process. Partners both consume and provide services to a business Process. These services are characterized by a ServiceLinkType.
 * 
 * Partners define the different parties that interact with the business process. A partner represents both a consumer of a service provided by the business process and a provider of a service to the business process.
 * 
 * The role of the partner is always seen from the perspective of the process that contains it. For invoke activities, the partner plays a role to provide the invoked service. For receive activities, the partner plays a role to invoke the service, and the process plays the role of providing it.
 * 
 * Each partner is characterized by a service link type and a role name that identifies the functionality that must be provided by the business process and by the partner for the relationship to succeed. That is, the portTypes that the process and partners need to implement.
 * 
 * myRole represents the responsibilities or services produced and consumed by this process. For services provided by this process, myRole must specify a role of the serviceLinkType which which has a portType and operation that appears in a receive activity within this process. That is, for some receive activity in this process, its partner attribute must name a partner defined in the process having myRole specify a role of the partner's serviceLinkType whose portType matches the receive portType, that portType must contain the operation specified in the receive activity, and the container of that activity must refer to a container of the process whose messageType is the same as the input message of the operation.
 * 
 * For consumed services, similar rules apply to the invoke activity. The partner attribute must name a partner defined in the process having partnerRole specify a role of the partner's serviceLinkType whose portType matches the invoke portType, that portType must contain the operation specified in the invoke activity, and the inputContainer of that activity  must refer to a container of the process whose messageType is same as the input message of the operation, and whose outputContainer refers to a container of the process whose messageType is the same as the output message of the operation.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.PartnerLink#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerLink#getMyRole <em>My Role</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerLink#getPartnerRole <em>Partner Role</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerLink#getPartnerLinkType <em>Partner Link Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerLink#getInitializePartnerRole <em>Initialize Partner Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getPartnerLink()
 * @model
 * @generated
 */
public interface PartnerLink extends BPELExtensibleElement {
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
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerLink_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerLink#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>My Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Role</em>' reference.
	 * @see #setMyRole(Role)
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerLink_MyRole()
	 * @model
	 * @generated
	 */
	Role getMyRole();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerLink#getMyRole <em>My Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My Role</em>' reference.
	 * @see #getMyRole()
	 */
	void setMyRole(Role value);

	/**
	 * Returns the value of the '<em><b>Partner Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Role</em>' reference.
	 * @see #setPartnerRole(Role)
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerLink_PartnerRole()
	 * @model
	 * @generated
	 */
	Role getPartnerRole();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerLink#getPartnerRole <em>Partner Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Role</em>' reference.
	 * @see #getPartnerRole()
	 */
	void setPartnerRole(Role value);

	/**
	 * Returns the value of the '<em><b>Partner Link Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link Type</em>' reference.
	 * @see #setPartnerLinkType(PartnerLinkType)
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerLink_PartnerLinkType()
	 * @model
	 * @generated
	 */
	PartnerLinkType getPartnerLinkType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerLink#getPartnerLinkType <em>Partner Link Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link Type</em>' reference.
	 * @see #getPartnerLinkType()
	 */
	void setPartnerLinkType(PartnerLinkType value);

	/**
	 * Returns the value of the '<em><b>Initialize Partner Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialize Partner Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialize Partner Role</em>' attribute.
	 * @see #isSetInitializePartnerRole()
	 * @see #unsetInitializePartnerRole()
	 * @see #setInitializePartnerRole(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerLink_InitializePartnerRole()
	 * @model unsettable="true"
	 * @generated
	 */
	Boolean getInitializePartnerRole();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerLink#getInitializePartnerRole <em>Initialize Partner Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialize Partner Role</em>' attribute.
	 * @see #isSetInitializePartnerRole()
	 * @see #unsetInitializePartnerRole()
	 * @see #getInitializePartnerRole()
	 */
	void setInitializePartnerRole(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.PartnerLink#getInitializePartnerRole <em>Initialize Partner Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitializePartnerRole()
	 * @see #getInitializePartnerRole()
	 * @see #setInitializePartnerRole(Boolean)
	 */
	void unsetInitializePartnerRole();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.PartnerLink#getInitializePartnerRole <em>Initialize Partner Role</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initialize Partner Role</em>' attribute is set.
	 * @see #unsetInitializePartnerRole()
	 * @see #getInitializePartnerRole()
	 * @see #setInitializePartnerRole(Boolean)
	 * @generated
	 */
	boolean isSetInitializePartnerRole();

} // PartnerLink
