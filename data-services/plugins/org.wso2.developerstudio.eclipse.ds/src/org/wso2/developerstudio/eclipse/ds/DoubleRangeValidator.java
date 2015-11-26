/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Range Validator</b></em>
 * '.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMinimum <em>Minimum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDoubleRangeValidator()
 * @model extendedMetaData="name='validateDoubleRange_._type' kind='empty'"
 * @generated
 */
public interface DoubleRangeValidator extends EObject {
	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(double)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDoubleRangeValidator_Maximum()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='maximum' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(double)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDoubleRangeValidator_Minimum()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='minimum' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMinimum();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(double value);

} // DoubleRangeValidator
