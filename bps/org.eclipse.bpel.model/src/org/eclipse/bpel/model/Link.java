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
 * $Id: Link.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies the synchronization dependencies between activities in a flow. Each activity can be the source and/or target of any number of links. Links establish a predecessor/successor relationship between activities. Activities that are the source of a link are predecessors of activities that are targets of the same link. Parallel execution of activities in a flow is synchronized by requiring that all the source activities of an activity must complete before corresponding target activities of the same link can run. When an activity completes, all activities that are targets of links for which this activity is a source are now candidates for execution (assuming all their predecessor activities have completed).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Link#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Link#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Link#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends BPELExtensibleElement {
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
	 * @see org.eclipse.bpel.model.BPELPackage#getLink_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Link#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Source}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpel.model.Source#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getLink_Sources()
	 * @see org.eclipse.bpel.model.Source#getLink
	 * @model opposite="Link"
	 * @generated
	 */
	EList<Source> getSources();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Target}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpel.model.Target#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getLink_Targets()
	 * @see org.eclipse.bpel.model.Target#getLink
	 * @model opposite="Link"
	 * @generated
	 */
	EList<Target> getTargets();

} // Link
