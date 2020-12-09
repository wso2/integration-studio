/**
 * <copyright>
 * </copyright>
 *
 * $Id: SampleStructuredActivity.java,v 1.1 2008/09/15 15:44:28 smoser Exp $
 */
package org.eclipse.bpel.extensionsample.model;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.ExtensionActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sample Structured Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.extensionsample.model.SampleStructuredActivity#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.extensionsample.model.ModelPackage#getSampleStructuredActivity()
 * @model
 * @generated
 */
public interface SampleStructuredActivity extends ExtensionActivity {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference.
	 * @see #setActivity(Activity)
	 * @see org.eclipse.bpel.extensionsample.model.ModelPackage#getSampleStructuredActivity_Activity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.extensionsample.model.SampleStructuredActivity#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

} // SampleStructuredActivity
