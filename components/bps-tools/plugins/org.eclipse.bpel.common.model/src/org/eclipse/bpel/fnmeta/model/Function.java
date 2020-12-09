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
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getHelp <em>Help</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getIsDeprecated <em>Is Deprecated</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getDeprecateComment <em>Deprecate Comment</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Function#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends FacadeElement {
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
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * The default value is <code>"urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_Namespace()
	 * @model default="urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' attribute.
	 * @see #setReturnType(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_ReturnType()
	 * @model
	 * @generated
	 */
	String getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getReturnType <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' attribute.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(String value);

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
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_Arguments()
	 * @model
	 * @generated
	 */
	EList<Argument> getArguments();

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
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Help</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Help</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Help</em>' attribute.
	 * @see #setHelp(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_Help()
	 * @model
	 * @generated
	 */
	String getHelp();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getHelp <em>Help</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help</em>' attribute.
	 * @see #getHelp()
	 * @generated
	 */
	void setHelp(String value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Is Deprecated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Deprecated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Deprecated</em>' attribute.
	 * @see #setIsDeprecated(Boolean)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_IsDeprecated()
	 * @model default="false"
	 * @generated
	 */
	Boolean getIsDeprecated();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getIsDeprecated <em>Is Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Deprecated</em>' attribute.
	 * @see #getIsDeprecated()
	 * @generated
	 */
	void setIsDeprecated(Boolean value);

	/**
	 * Returns the value of the '<em><b>Deprecate Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deprecate Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deprecate Comment</em>' attribute.
	 * @see #setDeprecateComment(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_DeprecateComment()
	 * @model
	 * @generated
	 */
	String getDeprecateComment();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getDeprecateComment <em>Deprecate Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecate Comment</em>' attribute.
	 * @see #getDeprecateComment()
	 * @generated
	 */
	void setDeprecateComment(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getFunction_ClassName()
	 * @model default=""
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Function#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

} // Function
