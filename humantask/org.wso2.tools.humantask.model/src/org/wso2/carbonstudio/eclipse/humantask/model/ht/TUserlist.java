/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TUserlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTUserlist()
 * @model extendedMetaData="name='tUserlist' kind='elementOnly'"
 * @generated
 */
public interface TUserlist extends EObject {
	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTUserlist_User()
	 * @model unique="false" dataType="org.wso2.developerstudio.eclipse.humantask.model.ht.TUser"
	 *        extendedMetaData="kind='element' name='user' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getUser();

} // TUserlist
