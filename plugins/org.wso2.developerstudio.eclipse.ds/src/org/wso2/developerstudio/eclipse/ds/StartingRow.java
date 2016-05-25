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
 * A representation of the model object '<em><b>Starting Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.StartingRow#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getStartingRow()
 * @model extendedMetaData="name='startingrow_._type' kind='simple'"
 * @generated
 */
public interface StartingRow extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(long)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getStartingRow_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	long getValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.StartingRow#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(long value);

} // StartingRow
