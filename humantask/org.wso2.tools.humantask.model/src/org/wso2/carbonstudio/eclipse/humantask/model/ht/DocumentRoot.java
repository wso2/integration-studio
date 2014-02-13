/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getBusinessAdministrators <em>Business Administrators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getExcludedOwners <em>Excluded Owners</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroup <em>Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getHumanInteractions <em>Human Interactions</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getImport <em>Import</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getLogicalPeopleGroups <em>Logical People Groups</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotification <em>Notification</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getOrganizationalEntity <em>Organizational Entity</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPeopleAssignments <em>People Assignments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPotentialOwners <em>Potential Owners</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getRecipients <em>Recipients</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTask <em>Task</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskInitiator <em>Task Initiator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskStakeholders <em>Task Stakeholders</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUser <em>User</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Business Administrators</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Administrators</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Administrators</em>' containment reference.
	 * @see #setBusinessAdministrators(TGenericHumanRole)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_BusinessAdministrators()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='businessAdministrators' namespace='##targetNamespace'"
	 * @generated
	 */
	TGenericHumanRole getBusinessAdministrators();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getBusinessAdministrators <em>Business Administrators</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Business Administrators</em>' containment reference.
	 * @see #getBusinessAdministrators()
	 * @generated
	 */
	void setBusinessAdministrators(TGenericHumanRole value);

	/**
	 * Returns the value of the '<em><b>Excluded Owners</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Owners</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Owners</em>' containment reference.
	 * @see #setExcludedOwners(TGenericHumanRole)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_ExcludedOwners()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='excludedOwners' namespace='##targetNamespace'"
	 * @generated
	 */
	TGenericHumanRole getExcludedOwners();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getExcludedOwners <em>Excluded Owners</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Excluded Owners</em>' containment reference.
	 * @see #getExcludedOwners()
	 * @generated
	 */
	void setExcludedOwners(TGenericHumanRole value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Group()
	 * @model unique="false" dataType="org.wso2.developerstudio.eclipse.humantask.model.ht.TGroup" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='group' namespace='##targetNamespace'"
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference.
	 * @see #setGroups(TGrouplist)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Groups()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='groups' namespace='##targetNamespace'"
	 * @generated
	 */
	TGrouplist getGroups();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroups <em>Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Groups</em>' containment reference.
	 * @see #getGroups()
	 * @generated
	 */
	void setGroups(TGrouplist value);

	/**
	 * Returns the value of the '<em><b>Human Interactions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Human Interactions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Human Interactions</em>' containment reference.
	 * @see #setHumanInteractions(THumanInteractions)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_HumanInteractions()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='humanInteractions' namespace='##targetNamespace'"
	 * @generated
	 */
	THumanInteractions getHumanInteractions();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getHumanInteractions <em>Human Interactions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Human Interactions</em>' containment reference.
	 * @see #getHumanInteractions()
	 * @generated
	 */
	void setHumanInteractions(THumanInteractions value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' containment reference.
	 * @see #setImport(TImport)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Import()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
	 * @generated
	 */
	TImport getImport();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getImport <em>Import</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' containment reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(TImport value);

	/**
	 * Returns the value of the '<em><b>Logical People Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical People Groups</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical People Groups</em>' containment reference.
	 * @see #setLogicalPeopleGroups(TLogicalPeopleGroups)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_LogicalPeopleGroups()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='logicalPeopleGroups' namespace='##targetNamespace'"
	 * @generated
	 */
	TLogicalPeopleGroups getLogicalPeopleGroups();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getLogicalPeopleGroups <em>Logical People Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logical People Groups</em>' containment reference.
	 * @see #getLogicalPeopleGroups()
	 * @generated
	 */
	void setLogicalPeopleGroups(TLogicalPeopleGroups value);

	/**
	 * Returns the value of the '<em><b>Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification</em>' containment reference.
	 * @see #setNotification(TNotification)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Notification()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='notification' namespace='##targetNamespace'"
	 * @generated
	 */
	TNotification getNotification();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotification <em>Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification</em>' containment reference.
	 * @see #getNotification()
	 * @generated
	 */
	void setNotification(TNotification value);

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference.
	 * @see #setNotifications(TNotifications)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Notifications()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='notifications' namespace='##targetNamespace'"
	 * @generated
	 */
	TNotifications getNotifications();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotifications <em>Notifications</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notifications</em>' containment reference.
	 * @see #getNotifications()
	 * @generated
	 */
	void setNotifications(TNotifications value);

	/**
	 * Returns the value of the '<em><b>Organizational Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organizational Entity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organizational Entity</em>' containment reference.
	 * @see #setOrganizationalEntity(TOrganizationalEntity)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_OrganizationalEntity()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='organizationalEntity' namespace='##targetNamespace'"
	 * @generated
	 */
	TOrganizationalEntity getOrganizationalEntity();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getOrganizationalEntity <em>Organizational Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organizational Entity</em>' containment reference.
	 * @see #getOrganizationalEntity()
	 * @generated
	 */
	void setOrganizationalEntity(TOrganizationalEntity value);

	/**
	 * Returns the value of the '<em><b>People Assignments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People Assignments</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People Assignments</em>' containment reference.
	 * @see #setPeopleAssignments(TPeopleAssignments)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_PeopleAssignments()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='peopleAssignments' namespace='##targetNamespace'"
	 * @generated
	 */
	TPeopleAssignments getPeopleAssignments();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPeopleAssignments <em>People Assignments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>People Assignments</em>' containment reference.
	 * @see #getPeopleAssignments()
	 * @generated
	 */
	void setPeopleAssignments(TPeopleAssignments value);

	/**
	 * Returns the value of the '<em><b>Potential Owners</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Potential Owners</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Potential Owners</em>' containment reference.
	 * @see #setPotentialOwners(TGenericHumanRole)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_PotentialOwners()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='potentialOwners' namespace='##targetNamespace'"
	 * @generated
	 */
	TGenericHumanRole getPotentialOwners();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPotentialOwners <em>Potential Owners</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Potential Owners</em>' containment reference.
	 * @see #getPotentialOwners()
	 * @generated
	 */
	void setPotentialOwners(TGenericHumanRole value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' containment reference.
	 * @see #setPriority(TPriority)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Priority()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='priority' namespace='##targetNamespace'"
	 * @generated
	 */
	TPriority getPriority();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPriority <em>Priority</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' containment reference.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(TPriority value);

	/**
	 * Returns the value of the '<em><b>Recipients</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipients</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipients</em>' containment reference.
	 * @see #setRecipients(TGenericHumanRole)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Recipients()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='recipients' namespace='##targetNamespace'"
	 * @generated
	 */
	TGenericHumanRole getRecipients();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getRecipients <em>Recipients</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recipients</em>' containment reference.
	 * @see #getRecipients()
	 * @generated
	 */
	void setRecipients(TGenericHumanRole value);

	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' containment reference.
	 * @see #setTask(TTask)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Task()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='task' namespace='##targetNamespace'"
	 * @generated
	 */
	TTask getTask();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTask <em>Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' containment reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(TTask value);

	/**
	 * Returns the value of the '<em><b>Task Initiator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Initiator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Initiator</em>' containment reference.
	 * @see #setTaskInitiator(TGenericHumanRole)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_TaskInitiator()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='taskInitiator' namespace='##targetNamespace'"
	 * @generated
	 */
	TGenericHumanRole getTaskInitiator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskInitiator <em>Task Initiator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Initiator</em>' containment reference.
	 * @see #getTaskInitiator()
	 * @generated
	 */
	void setTaskInitiator(TGenericHumanRole value);

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference.
	 * @see #setTasks(TTasks)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Tasks()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tasks' namespace='##targetNamespace'"
	 * @generated
	 */
	TTasks getTasks();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTasks <em>Tasks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tasks</em>' containment reference.
	 * @see #getTasks()
	 * @generated
	 */
	void setTasks(TTasks value);

	/**
	 * Returns the value of the '<em><b>Task Stakeholders</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Stakeholders</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Stakeholders</em>' containment reference.
	 * @see #setTaskStakeholders(TGenericHumanRole)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_TaskStakeholders()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='taskStakeholders' namespace='##targetNamespace'"
	 * @generated
	 */
	TGenericHumanRole getTaskStakeholders();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskStakeholders <em>Task Stakeholders</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Stakeholders</em>' containment reference.
	 * @see #getTaskStakeholders()
	 * @generated
	 */
	void setTaskStakeholders(TGenericHumanRole value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_User()
	 * @model unique="false" dataType="org.wso2.developerstudio.eclipse.humantask.model.ht.TUser" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='user' namespace='##targetNamespace'"
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(String value);

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference.
	 * @see #setUsers(TUserlist)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getDocumentRoot_Users()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='users' namespace='##targetNamespace'"
	 * @generated
	 */
	TUserlist getUsers();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUsers <em>Users</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Users</em>' containment reference.
	 * @see #getUsers()
	 * @generated
	 */
	void setUsers(TUserlist value);

} // DocumentRoot
