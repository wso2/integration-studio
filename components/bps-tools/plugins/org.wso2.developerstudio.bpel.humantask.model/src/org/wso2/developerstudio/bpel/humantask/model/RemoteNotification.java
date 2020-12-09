/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.bpel.humantask.model;

import org.eclipse.bpel.model.PartnerLink;

import org.eclipse.wst.wsdl.Operation;

import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteNotification()
 * @model
 * @generated
 */
public interface RemoteNotification extends ExtensionElement {
	/**
	 * Returns the value of the '<em><b>Partner Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link</em>' reference.
	 * @see #setPartnerLink(PartnerLink)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteNotification_PartnerLink()
	 * @model
	 * @generated
	 */
	PartnerLink getPartnerLink();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getPartnerLink <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link</em>' reference.
	 * @see #getPartnerLink()
	 * @generated
	 */
	void setPartnerLink(PartnerLink value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteNotification_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // RemoteNotification
