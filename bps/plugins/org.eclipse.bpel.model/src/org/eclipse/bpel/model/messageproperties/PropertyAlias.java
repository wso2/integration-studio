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
 * $Id: PropertyAlias.java,v 1.3 2007/08/01 21:02:32 mchmielewski Exp $
 */
package org.eclipse.bpel.model.messageproperties;

import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.Part;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Alias</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getMessageType <em>Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getWsdlPart <em>Wsdl Part</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getXSDElement <em>XSD Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias()
 * @model
 * @generated
 */
public interface PropertyAlias extends ExtensibilityElement {
	/**
	 * Returns the value of the '<em><b>Message Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Type</em>' attribute.
	 * @see #setMessageType(Object)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_MessageType()
	 * @model
	 * @generated
	 */
	Object getMessageType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getMessageType <em>Message Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Type</em>' attribute.
	 * @see #getMessageType()
	 * @generated
	 */
	void setMessageType(Object value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' attribute.
	 * @see #setPart(String)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_Part()
	 * @model
	 * @generated
	 */
	String getPart();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getPart <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' attribute.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(String value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(Object)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_PropertyName()
	 * @model
	 * @generated
	 */
	Object getPropertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(Object value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_ID()
	 * @model id="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getID();

	/**
	 * Returns the value of the '<em><b>Wsdl Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Part</em>' reference.
	 * @see #setWsdlPart(Part)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_WsdlPart()
	 * @model required="true" transient="true"
	 * @generated
	 */
	Part getWsdlPart();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getWsdlPart <em>Wsdl Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Part</em>' reference.
	 * @see #getWsdlPart()
	 * @generated
	 */
	void setWsdlPart(Part value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' containment reference.
	 * @see #setQuery(Query)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_Query()
	 * @model containment="true"
	 * @generated
	 */
	Query getQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getQuery <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' containment reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(Query value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_Type()
	 * @model
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

	/**
	 * Returns the value of the '<em><b>XSD Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSD Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSD Element</em>' attribute.
	 * @see #setXSDElement(Object)
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#getPropertyAlias_XSDElement()
	 * @model
	 * @generated
	 */
	Object getXSDElement();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.messageproperties.PropertyAlias#getXSDElement <em>XSD Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSD Element</em>' attribute.
	 * @see #getXSDElement()
	 * @generated
	 */
	void setXSDElement(Object value);

} // PropertyAlias
