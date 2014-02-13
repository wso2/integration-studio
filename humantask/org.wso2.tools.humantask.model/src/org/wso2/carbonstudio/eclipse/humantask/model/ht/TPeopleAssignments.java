/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPeople Assignments</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getGenericHumanRole <em>Generic Human Role</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getPotentialOwners <em>Potential Owners</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getExcludedOwners <em>Excluded Owners</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getTaskInitiator <em>Task Initiator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getTaskStakeholders <em>Task Stakeholders</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getBusinessAdministrators <em>Business Administrators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getRecipients <em>Recipients</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments()
 * @model extendedMetaData="name='tPeopleAssignments' kind='elementOnly'"
 * @generated
 */
public interface TPeopleAssignments extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Generic Human Role</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generic Human Role</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generic Human Role</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_GenericHumanRole()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='GenericHumanRole:3'"
	 * @generated
	 */
	FeatureMap getGenericHumanRole();

	/**
	 * Returns the value of the '<em><b>Potential Owners</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Potential Owners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Potential Owners</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_PotentialOwners()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='potentialOwners' namespace='##targetNamespace' group='#GenericHumanRole:3'"
	 * @generated
	 */
	EList<TGenericHumanRole> getPotentialOwners();

	/**
	 * Returns the value of the '<em><b>Excluded Owners</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Owners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Owners</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_ExcludedOwners()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='excludedOwners' namespace='##targetNamespace' group='#GenericHumanRole:3'"
	 * @generated
	 */
	EList<TGenericHumanRole> getExcludedOwners();

	/**
	 * Returns the value of the '<em><b>Task Initiator</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Initiator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Initiator</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_TaskInitiator()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='taskInitiator' namespace='##targetNamespace' group='#GenericHumanRole:3'"
	 * @generated
	 */
	EList<TGenericHumanRole> getTaskInitiator();

	/**
	 * Returns the value of the '<em><b>Task Stakeholders</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Stakeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Stakeholders</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_TaskStakeholders()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='taskStakeholders' namespace='##targetNamespace' group='#GenericHumanRole:3'"
	 * @generated
	 */
	EList<TGenericHumanRole> getTaskStakeholders();

	/**
	 * Returns the value of the '<em><b>Business Administrators</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Administrators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Administrators</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_BusinessAdministrators()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='businessAdministrators' namespace='##targetNamespace' group='#GenericHumanRole:3'"
	 * @generated
	 */
	EList<TGenericHumanRole> getBusinessAdministrators();

	/**
	 * Returns the value of the '<em><b>Recipients</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipients</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipients</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTPeopleAssignments_Recipients()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='recipients' namespace='##targetNamespace' group='#GenericHumanRole:3'"
	 * @generated
	 */
	EList<TGenericHumanRole> getRecipients();

} // TPeopleAssignments
