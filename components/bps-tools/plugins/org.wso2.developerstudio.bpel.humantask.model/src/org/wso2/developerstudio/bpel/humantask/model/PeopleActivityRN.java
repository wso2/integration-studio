/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.bpel.humantask.model;

import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Variable;

import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>People Activity RN</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getInputVariable <em>Input Variable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getRemoteNotification <em>Remote Notification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRN()
 * @model
 * @generated
 */
public interface PeopleActivityRN extends ExtensionActivity, ExtensionElement {
	/**
	 * Returns the value of the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable</em>' reference.
	 * @see #setInputVariable(Variable)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRN_InputVariable()
	 * @model
	 * @generated
	 */
	Variable getInputVariable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getInputVariable <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Variable</em>' reference.
	 * @see #getInputVariable()
	 * @generated
	 */
	void setInputVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Remote Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Notification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Notification</em>' containment reference.
	 * @see #setRemoteNotification(RemoteNotification)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRN_RemoteNotification()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RemoteNotification getRemoteNotification();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getRemoteNotification <em>Remote Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Notification</em>' containment reference.
	 * @see #getRemoteNotification()
	 * @generated
	 */
	void setRemoteNotification(RemoteNotification value);

} // PeopleActivityRN
