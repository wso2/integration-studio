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
 * $Id: Copy.java,v 1.7 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Copy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Copy#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Copy#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Copy#getKeepSrcElementName <em>Keep Src Element Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Copy#getIgnoreMissingFromData <em>Ignore Missing From Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getCopy()
 * @model
 * @generated
 */
public interface Copy extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' containment reference.
	 * @see #setTo(To)
	 * @see org.eclipse.bpel.model.BPELPackage#getCopy_To()
	 * @model containment="true" required="true"
	 * @generated
	 */
	To getTo();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Copy#getTo <em>To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' containment reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(To value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' containment reference.
	 * @see #setFrom(From)
	 * @see org.eclipse.bpel.model.BPELPackage#getCopy_From()
	 * @model containment="true" required="true"
	 * @generated
	 */
	From getFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Copy#getFrom <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' containment reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(From value);

	/**
	 * Returns the value of the '<em><b>Keep Src Element Name</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keep Src Element Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keep Src Element Name</em>' attribute.
	 * @see #isSetKeepSrcElementName()
	 * @see #unsetKeepSrcElementName()
	 * @see #setKeepSrcElementName(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getCopy_KeepSrcElementName()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getKeepSrcElementName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Copy#getKeepSrcElementName <em>Keep Src Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keep Src Element Name</em>' attribute.
	 * @see #isSetKeepSrcElementName()
	 * @see #unsetKeepSrcElementName()
	 * @see #getKeepSrcElementName()
	 */
	void setKeepSrcElementName(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Copy#getKeepSrcElementName <em>Keep Src Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKeepSrcElementName()
	 * @see #getKeepSrcElementName()
	 * @see #setKeepSrcElementName(Boolean)
	 */
	void unsetKeepSrcElementName();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Copy#getKeepSrcElementName <em>Keep Src Element Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Keep Src Element Name</em>' attribute is set.
	 * @see #unsetKeepSrcElementName()
	 * @see #getKeepSrcElementName()
	 * @see #setKeepSrcElementName(Boolean)
	 * @generated
	 */
	boolean isSetKeepSrcElementName();

	/**
	 * Returns the value of the '<em><b>Ignore Missing From Data</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore Missing From Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore Missing From Data</em>' attribute.
	 * @see #isSetIgnoreMissingFromData()
	 * @see #unsetIgnoreMissingFromData()
	 * @see #setIgnoreMissingFromData(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getCopy_IgnoreMissingFromData()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getIgnoreMissingFromData();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Copy#getIgnoreMissingFromData <em>Ignore Missing From Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore Missing From Data</em>' attribute.
	 * @see #isSetIgnoreMissingFromData()
	 * @see #unsetIgnoreMissingFromData()
	 * @see #getIgnoreMissingFromData()
	 */
	void setIgnoreMissingFromData(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Copy#getIgnoreMissingFromData <em>Ignore Missing From Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIgnoreMissingFromData()
	 * @see #getIgnoreMissingFromData()
	 * @see #setIgnoreMissingFromData(Boolean)
	 */
	void unsetIgnoreMissingFromData();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Copy#getIgnoreMissingFromData <em>Ignore Missing From Data</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ignore Missing From Data</em>' attribute is set.
	 * @see #unsetIgnoreMissingFromData()
	 * @see #getIgnoreMissingFromData()
	 * @see #setIgnoreMissingFromData(Boolean)
	 * @generated
	 */
	boolean isSetIgnoreMissingFromData();

} // Copy
