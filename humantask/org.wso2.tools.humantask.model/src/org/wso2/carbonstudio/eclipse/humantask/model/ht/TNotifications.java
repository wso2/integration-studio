/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNotifications</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications#getNotification <em>Notification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotifications()
 * @model extendedMetaData="name='tNotifications' kind='elementOnly'"
 * @generated
 */
public interface TNotifications extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Notification</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotifications_Notification()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='notification' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TNotification> getNotification();

} // TNotifications
