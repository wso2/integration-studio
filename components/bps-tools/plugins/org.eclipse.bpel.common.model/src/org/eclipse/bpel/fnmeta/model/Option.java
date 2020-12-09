/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.fnmeta.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Option#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.bpel.fnmeta.model.Option#getDisplayValue <em>Display Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getOption()
 * @model
 * @generated
 */
public interface Option extends FacadeElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getOption_Value()
	 * @model ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Option#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Value</em>' attribute.
	 * @see #setDisplayValue(String)
	 * @see org.eclipse.bpel.fnmeta.model.FMPackage#getOption_DisplayValue()
	 * @model ordered="false"
	 * @generated
	 */
	String getDisplayValue();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.fnmeta.model.Option#getDisplayValue <em>Display Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Value</em>' attribute.
	 * @see #getDisplayValue()
	 * @generated
	 */
	void setDisplayValue(String value);

} // Option
