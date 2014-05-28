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
 * $Id: Expression.java,v 1.4 2007/12/06 20:01:24 smoser Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.wst.wsdl.ExtensibilityElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Expression#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Expression#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Expression#getOpaque <em>Opaque</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends ExtensibilityElement {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(Object)
	 * @see org.eclipse.bpel.model.BPELPackage#getExpression_Body()
	 * @model
	 * @generated
	 */
	Object getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Expression#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 */
	void setBody(Object value);

	/**
	 * Returns the value of the '<em><b>Expression Language</b></em>' attribute.
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
	 * @see org.eclipse.bpel.model.BPELPackage#getExpression_ExpressionLanguage()
	 * @model unsettable="true"
	 * @generated
	 */
	String getExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Expression#getExpressionLanguage <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Language</em>' attribute.
	 * @see #isSetExpressionLanguage()
	 * @see #unsetExpressionLanguage()
	 * @see #getExpressionLanguage()
	 */
	void setExpressionLanguage(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Expression#getExpressionLanguage <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpressionLanguage()
	 * @see #getExpressionLanguage()
	 * @see #setExpressionLanguage(String)
	 * @generated
	 */
	void unsetExpressionLanguage();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Expression#getExpressionLanguage <em>Expression Language</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Opaque</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opaque</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opaque</em>' attribute.
	 * @see #isSetOpaque()
	 * @see #unsetOpaque()
	 * @see #setOpaque(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getExpression_Opaque()
	 * @model unsettable="true"
	 * @generated
	 */
	Boolean getOpaque();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Expression#getOpaque <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opaque</em>' attribute.
	 * @see #isSetOpaque()
	 * @see #unsetOpaque()
	 * @see #getOpaque()
	 */
	void setOpaque(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Expression#getOpaque <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOpaque()
	 * @see #getOpaque()
	 * @see #setOpaque(Boolean)
	 */
	void unsetOpaque();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Expression#getOpaque <em>Opaque</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Opaque</em>' attribute is set.
	 * @see #unsetOpaque()
	 * @see #getOpaque()
	 * @see #setOpaque(Boolean)
	 * @generated
	 */
	boolean isSetOpaque();

} // Expression
