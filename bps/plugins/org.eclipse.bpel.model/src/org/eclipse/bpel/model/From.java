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
 * $Id: From.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.bpel.model.messageproperties.Property;

import org.eclipse.wst.wsdl.Part;

import org.eclipse.xsd.XSDTypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.From#getOpaque <em>Opaque</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.From#getEndpointReference <em>Endpoint Reference</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.From#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.From#getUnsafeLiteral <em>Unsafe Literal</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.From#getServiceRef <em>Service Ref</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.From#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getFrom()
 * @model
 * @generated
 */
public interface From extends BPELExtensibleElement, AbstractAssignBound {
	/**
	 * Returns the value of the '<em><b>Opaque</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Signifies that an opaque value is to be assigned to a container property based on a non-deterministic choice. Must be used in abstract processes only. The XSD type of the To container property must be derived from xsd:string restricted by enumeration or any restricted XSD integral numeric type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Opaque</em>' attribute.
	 * @see #isSetOpaque()
	 * @see #unsetOpaque()
	 * @see #setOpaque(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getFrom_Opaque()
	 * @model unsettable="true"
	 * @generated
	 */
	Boolean getOpaque();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getOpaque <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opaque</em>' attribute.
	 * @see #isSetOpaque()
	 * @see #unsetOpaque()
	 * @see #getOpaque()
	 */
	void setOpaque(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.From#getOpaque <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOpaque()
	 * @see #getOpaque()
	 * @see #setOpaque(Boolean)
	 */
	void unsetOpaque();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.From#getOpaque <em>Opaque</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Opaque</em>' attribute is set.
	 * @see #unsetOpaque()
	 * @see #getOpaque()
	 * @see #setOpaque(Boolean)
	 * @generated
	 */
	boolean isSetOpaque();

	/**
	 * Returns the value of the '<em><b>Endpoint Reference</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.bpel.model.EndpointReferenceRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Reference</em>' attribute.
	 * @see org.eclipse.bpel.model.EndpointReferenceRole
	 * @see #isSetEndpointReference()
	 * @see #unsetEndpointReference()
	 * @see #setEndpointReference(EndpointReferenceRole)
	 * @see org.eclipse.bpel.model.BPELPackage#getFrom_EndpointReference()
	 * @model unsettable="true"
	 * @generated
	 */
	EndpointReferenceRole getEndpointReference();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getEndpointReference <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Reference</em>' attribute.
	 * @see org.eclipse.bpel.model.EndpointReferenceRole
	 * @see #isSetEndpointReference()
	 * @see #unsetEndpointReference()
	 * @see #getEndpointReference()
	 */
	void setEndpointReference(EndpointReferenceRole value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.From#getEndpointReference <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndpointReference()
	 * @see #getEndpointReference()
	 * @see #setEndpointReference(EndpointReferenceRole)
	 */
	void unsetEndpointReference();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.From#getEndpointReference <em>Endpoint Reference</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Endpoint Reference</em>' attribute is set.
	 * @see #unsetEndpointReference()
	 * @see #getEndpointReference()
	 * @see #setEndpointReference(EndpointReferenceRole)
	 * @generated
	 */
	boolean isSetEndpointReference();

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #isSetLiteral()
	 * @see #unsetLiteral()
	 * @see #setLiteral(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getFrom_Literal()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #isSetLiteral()
	 * @see #unsetLiteral()
	 * @see #getLiteral()
	 */
	void setLiteral(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.From#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiteral()
	 * @see #getLiteral()
	 * @see #setLiteral(String)
	 */
	void unsetLiteral();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.From#getLiteral <em>Literal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Literal</em>' attribute is set.
	 * @see #unsetLiteral()
	 * @see #getLiteral()
	 * @see #setLiteral(String)
	 * @generated
	 */
	boolean isSetLiteral();

	/**
	 * Returns the value of the '<em><b>Unsafe Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsafe Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsafe Literal</em>' attribute.
	 * @see #setUnsafeLiteral(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getFrom_UnsafeLiteral()
	 * @model
	 * @generated
	 */
	Boolean getUnsafeLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getUnsafeLiteral <em>Unsafe Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsafe Literal</em>' attribute.
	 * @see #getUnsafeLiteral()
	 * @generated
	 */
	void setUnsafeLiteral(Boolean value);

	/**
	 * Returns the value of the '<em><b>Service Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Ref</em>' containment reference.
	 * @see #setServiceRef(ServiceRef)
	 * @see org.eclipse.bpel.model.BPELPackage#getFrom_ServiceRef()
	 * @model containment="true"
	 * @generated
	 */
	ServiceRef getServiceRef();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getServiceRef <em>Service Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Ref</em>' containment reference.
	 * @see #getServiceRef()
	 * @generated
	 */
	void setServiceRef(ServiceRef value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(XSDTypeDefinition)
	 * @see org.eclipse.bpel.model.BPELPackage#getFrom_Type()
	 * @model
	 * @generated
	 */
	XSDTypeDefinition getType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 */
	void setType(XSDTypeDefinition value);

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 */
	void setVariable(Variable value);

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getPart <em>Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' reference.
	 * @see #getPart()
	 */
	void setPart(Part value);

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getPartnerLink <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link</em>' reference.
	 * @see #getPartnerLink()
	 */
	void setPartnerLink(PartnerLink value);

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.From#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 */
	void setProperty(Property value);

} // From
