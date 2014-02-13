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
 * A representation of the model object '<em><b>TDeadlines</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines#getStartDeadline <em>Start Deadline</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines#getCompletionDeadline <em>Completion Deadline</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTDeadlines()
 * @model extendedMetaData="name='tDeadlines' kind='elementOnly'"
 * @generated
 */
public interface TDeadlines extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Start Deadline</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Deadline</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Deadline</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTDeadlines_StartDeadline()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='startDeadline' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TDeadline> getStartDeadline();

	/**
	 * Returns the value of the '<em><b>Completion Deadline</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Deadline</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Deadline</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTDeadlines_CompletionDeadline()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='completionDeadline' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TDeadline> getCompletionDeadline();

} // TDeadlines
