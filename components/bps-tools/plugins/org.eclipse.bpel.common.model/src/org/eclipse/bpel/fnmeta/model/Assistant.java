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
 * A representation of the model object '<em><b>Assistant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Assistant#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Assistant#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Assistant#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getAssistant()
 * @model
 * @generated
 */
public interface Assistant extends FacadeElement {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpel.fnmeta.model.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' reference list.
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getAssistant_Options()
	 * @model
	 * @generated
	 */
	EList<Option> getOptions();

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
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getAssistant_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Assistant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getAssistant_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Assistant#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // Assistant
