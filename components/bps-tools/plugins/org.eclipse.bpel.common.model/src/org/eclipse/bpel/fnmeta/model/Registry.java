/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.fnmeta.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Registry#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Registry#getAssistants <em>Assistants</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Registry#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getRegistry()
 * @model
 * @generated
 */
public interface Registry extends FacadeElement {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.fnmeta.model.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getRegistry_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Assistants</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpel.fnmeta.model.Assistant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assistants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assistants</em>' reference list.
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getRegistry_Assistants()
	 * @model
	 * @generated
	 */
	EList<Assistant> getAssistants();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpel.fnmeta.model.Argument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getRegistry_Arguments()
	 * @model
	 * @generated
	 */
	EList<Argument> getArguments();

} // Registry
