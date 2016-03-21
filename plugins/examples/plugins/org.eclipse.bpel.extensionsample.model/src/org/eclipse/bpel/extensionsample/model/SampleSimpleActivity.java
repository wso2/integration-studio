/**
 * <copyright>
 * </copyright>
 *
 * $Id: SampleSimpleActivity.java,v 1.1 2008/09/15 15:44:28 smoser Exp $
 */
package org.eclipse.bpel.extensionsample.model;

import org.eclipse.bpel.model.ExtensionActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sample Simple Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.extensionsample.model.SampleSimpleActivity#getSampleExtensionAttribute <em>Sample Extension Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.extensionsample.model.ModelPackage#getSampleSimpleActivity()
 * @model
 * @generated
 */
public interface SampleSimpleActivity extends ExtensionActivity {

	/**
	 * Returns the value of the '<em><b>Sample Extension Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Extension Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Extension Attribute</em>' attribute.
	 * @see #setSampleExtensionAttribute(String)
	 * @see org.eclipse.bpel.extensionsample.model.ModelPackage#getSampleSimpleActivity_SampleExtensionAttribute()
	 * @model
	 * @generated
	 */
	String getSampleExtensionAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.extensionsample.model.SampleSimpleActivity#getSampleExtensionAttribute <em>Sample Extension Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Extension Attribute</em>' attribute.
	 * @see #getSampleExtensionAttribute()
	 * @generated
	 */
	void setSampleExtensionAttribute(String value);
} // SampleSimpleActivity
