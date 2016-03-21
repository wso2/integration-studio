/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.fnmeta.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Argument#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Argument#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Argument#getOptionality <em>Optionality</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Argument#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Argument#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Argument#getAssistant <em>Assistant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends FacadeElement {
	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument_DefaultValue()
	 * @model default="" ordered="false"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

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
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Optionality</b></em>' attribute.
	 * The default value is <code>"Required"</code>.
	 * The literals are from the enumeration {@link org.eclipse.bpel.fnmeta.model.Optionality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optionality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optionality</em>' attribute.
	 * @see org.eclipse.bpel.fnmeta.model.Optionality
	 * @see #isSetOptionality()
	 * @see #unsetOptionality()
	 * @see #setOptionality(Optionality)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument_Optionality()
	 * @model default="Required" unsettable="true" ordered="false"
	 * @generated
	 */
	Optionality getOptionality();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getOptionality <em>Optionality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optionality</em>' attribute.
	 * @see org.eclipse.bpel.fnmeta.model.Optionality
	 * @see #isSetOptionality()
	 * @see #unsetOptionality()
	 * @see #getOptionality()
	 * @generated
	 */
	void setOptionality(Optionality value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getOptionality <em>Optionality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOptionality()
	 * @see #getOptionality()
	 * @see #setOptionality(Optionality)
	 * @generated
	 */
	void unsetOptionality();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getOptionality <em>Optionality</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Optionality</em>' attribute is set.
	 * @see #unsetOptionality()
	 * @see #getOptionality()
	 * @see #setOptionality(Optionality)
	 * @generated
	 */
	boolean isSetOptionality();

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
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument_Type()
	 * @model ordered="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Assistant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assistant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assistant</em>' reference.
	 * @see #setAssistant(Assistant)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getArgument_Assistant()
	 * @model
	 * @generated
	 */
	Assistant getAssistant();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Argument#getAssistant <em>Assistant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assistant</em>' reference.
	 * @see #getAssistant()
	 * @generated
	 */
	void setAssistant(Assistant value);

} // Argument
