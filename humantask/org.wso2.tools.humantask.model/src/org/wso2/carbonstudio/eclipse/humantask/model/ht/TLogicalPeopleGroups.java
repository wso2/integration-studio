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
 * A representation of the model object '<em><b>TLogical People Groups</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups#getLogicalPeopleGroup <em>Logical People Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTLogicalPeopleGroups()
 * @model extendedMetaData="name='tLogicalPeopleGroups' kind='elementOnly'"
 * @generated
 */
public interface TLogicalPeopleGroups extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Logical People Group</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical People Group</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical People Group</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTLogicalPeopleGroups_LogicalPeopleGroup()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='logicalPeopleGroup' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TLogicalPeopleGroup> getLogicalPeopleGroup();

} // TLogicalPeopleGroups
