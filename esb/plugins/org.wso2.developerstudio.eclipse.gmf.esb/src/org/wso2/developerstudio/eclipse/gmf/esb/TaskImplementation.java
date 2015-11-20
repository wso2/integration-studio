/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TaskImplementation#getTaskImplementation <em>Task Implementation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.TaskImplementation#getTaskProperties <em>Task Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTaskImplementation()
 * @model
 * @generated
 */
public interface TaskImplementation extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Task Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Implementation</em>' attribute.
	 * @see #setTaskImplementation(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTaskImplementation_TaskImplementation()
	 * @model
	 * @generated
	 */
	String getTaskImplementation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.TaskImplementation#getTaskImplementation <em>Task Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Implementation</em>' attribute.
	 * @see #getTaskImplementation()
	 * @generated
	 */
	void setTaskImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Task Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTaskImplementation_TaskProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskProperty> getTaskProperties();

} // TaskImplementation
