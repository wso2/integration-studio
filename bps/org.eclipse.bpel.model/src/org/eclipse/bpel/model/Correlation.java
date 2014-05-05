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
 * $Id: Correlation.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Correlation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Correlation#getInitiate <em>Initiate</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Correlation#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Correlation#getSet <em>Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getCorrelation()
 * @model
 * @generated
 */
public interface Correlation extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Initiate</b></em>' attribute.
	 * The default value is <code>"no"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiate</em>' attribute.
	 * @see #isSetInitiate()
	 * @see #unsetInitiate()
	 * @see #setInitiate(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getCorrelation_Initiate()
	 * @model default="no" unsettable="true"
	 * @generated
	 */
	String getInitiate();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Correlation#getInitiate <em>Initiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiate</em>' attribute.
	 * @see #isSetInitiate()
	 * @see #unsetInitiate()
	 * @see #getInitiate()
	 */
	void setInitiate(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Correlation#getInitiate <em>Initiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitiate()
	 * @see #getInitiate()
	 * @see #setInitiate(String)
	 * @generated
	 */
	void unsetInitiate();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Correlation#getInitiate <em>Initiate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initiate</em>' attribute is set.
	 * @see #unsetInitiate()
	 * @see #getInitiate()
	 * @see #setInitiate(String)
	 * @generated
	 */
	boolean isSetInitiate();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.bpel.model.CorrelationPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see org.eclipse.bpel.model.CorrelationPattern
	 * @see #isSetPattern()
	 * @see #unsetPattern()
	 * @see #setPattern(CorrelationPattern)
	 * @see org.eclipse.bpel.model.BPELPackage#getCorrelation_Pattern()
	 * @model unsettable="true"
	 * @generated
	 */
	CorrelationPattern getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Correlation#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see org.eclipse.bpel.model.CorrelationPattern
	 * @see #isSetPattern()
	 * @see #unsetPattern()
	 * @see #getPattern()
	 */
	void setPattern(CorrelationPattern value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Correlation#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPattern()
	 * @see #getPattern()
	 * @see #setPattern(CorrelationPattern)
	 */
	void unsetPattern();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Correlation#getPattern <em>Pattern</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pattern</em>' attribute is set.
	 * @see #unsetPattern()
	 * @see #getPattern()
	 * @see #setPattern(CorrelationPattern)
	 * @generated
	 */
	boolean isSetPattern();

	/**
	 * Returns the value of the '<em><b>Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set</em>' reference.
	 * @see #setSet(CorrelationSet)
	 * @see org.eclipse.bpel.model.BPELPackage#getCorrelation_Set()
	 * @model required="true"
	 */
	CorrelationSet getSet();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Correlation#getSet <em>Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set</em>' reference.
	 * @see #getSet()
	 */
	void setSet(CorrelationSet value);

} // Correlation
