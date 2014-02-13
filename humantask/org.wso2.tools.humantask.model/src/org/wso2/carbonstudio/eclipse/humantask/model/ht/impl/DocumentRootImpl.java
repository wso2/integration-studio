/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot;
import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist;
import org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TImport;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTask;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getBusinessAdministrators <em>Business Administrators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getExcludedOwners <em>Excluded Owners</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getHumanInteractions <em>Human Interactions</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getLogicalPeopleGroups <em>Logical People Groups</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getNotification <em>Notification</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getOrganizationalEntity <em>Organizational Entity</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getPeopleAssignments <em>People Assignments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getPotentialOwners <em>Potential Owners</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getRecipients <em>Recipients</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getTask <em>Task</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getTaskInitiator <em>Task Initiator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getTaskStakeholders <em>Task Stakeholders</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, HTPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, HTPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, HTPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getBusinessAdministrators() {
		return (TGenericHumanRole)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBusinessAdministrators(TGenericHumanRole newBusinessAdministrators, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS, newBusinessAdministrators, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusinessAdministrators(TGenericHumanRole newBusinessAdministrators) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS, newBusinessAdministrators);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getExcludedOwners() {
		return (TGenericHumanRole)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__EXCLUDED_OWNERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExcludedOwners(TGenericHumanRole newExcludedOwners, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__EXCLUDED_OWNERS, newExcludedOwners, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExcludedOwners(TGenericHumanRole newExcludedOwners) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__EXCLUDED_OWNERS, newExcludedOwners);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroup() {
		return (String)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(String newGroup) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__GROUP, newGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGrouplist getGroups() {
		return (TGrouplist)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroups(TGrouplist newGroups, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__GROUPS, newGroups, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroups(TGrouplist newGroups) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__GROUPS, newGroups);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public THumanInteractions getHumanInteractions() {
		return (THumanInteractions)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__HUMAN_INTERACTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHumanInteractions(THumanInteractions newHumanInteractions, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__HUMAN_INTERACTIONS, newHumanInteractions, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHumanInteractions(THumanInteractions newHumanInteractions) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__HUMAN_INTERACTIONS, newHumanInteractions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TImport getImport() {
		return (TImport)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__IMPORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImport(TImport newImport, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__IMPORT, newImport, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImport(TImport newImport) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__IMPORT, newImport);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLogicalPeopleGroups getLogicalPeopleGroups() {
		return (TLogicalPeopleGroups)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogicalPeopleGroups(TLogicalPeopleGroups newLogicalPeopleGroups, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS, newLogicalPeopleGroups, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalPeopleGroups(TLogicalPeopleGroups newLogicalPeopleGroups) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS, newLogicalPeopleGroups);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotification getNotification() {
		return (TNotification)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__NOTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotification(TNotification newNotification, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__NOTIFICATION, newNotification, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotification(TNotification newNotification) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__NOTIFICATION, newNotification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotifications getNotifications() {
		return (TNotifications)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__NOTIFICATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotifications(TNotifications newNotifications, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__NOTIFICATIONS, newNotifications, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotifications(TNotifications newNotifications) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__NOTIFICATIONS, newNotifications);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOrganizationalEntity getOrganizationalEntity() {
		return (TOrganizationalEntity)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrganizationalEntity(TOrganizationalEntity newOrganizationalEntity, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY, newOrganizationalEntity, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganizationalEntity(TOrganizationalEntity newOrganizationalEntity) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY, newOrganizationalEntity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPeopleAssignments getPeopleAssignments() {
		return (TPeopleAssignments)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeopleAssignments(TPeopleAssignments newPeopleAssignments, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS, newPeopleAssignments, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeopleAssignments(TPeopleAssignments newPeopleAssignments) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS, newPeopleAssignments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getPotentialOwners() {
		return (TGenericHumanRole)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__POTENTIAL_OWNERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPotentialOwners(TGenericHumanRole newPotentialOwners, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__POTENTIAL_OWNERS, newPotentialOwners, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotentialOwners(TGenericHumanRole newPotentialOwners) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__POTENTIAL_OWNERS, newPotentialOwners);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPriority getPriority() {
		return (TPriority)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__PRIORITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPriority(TPriority newPriority, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__PRIORITY, newPriority, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(TPriority newPriority) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__PRIORITY, newPriority);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getRecipients() {
		return (TGenericHumanRole)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__RECIPIENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecipients(TGenericHumanRole newRecipients, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__RECIPIENTS, newRecipients, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecipients(TGenericHumanRole newRecipients) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__RECIPIENTS, newRecipients);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTask getTask() {
		return (TTask)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__TASK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTask(TTask newTask, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__TASK, newTask, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTask(TTask newTask) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__TASK, newTask);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getTaskInitiator() {
		return (TGenericHumanRole)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__TASK_INITIATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskInitiator(TGenericHumanRole newTaskInitiator, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__TASK_INITIATOR, newTaskInitiator, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskInitiator(TGenericHumanRole newTaskInitiator) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__TASK_INITIATOR, newTaskInitiator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTasks getTasks() {
		return (TTasks)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__TASKS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTasks(TTasks newTasks, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__TASKS, newTasks, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTasks(TTasks newTasks) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__TASKS, newTasks);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole getTaskStakeholders() {
		return (TGenericHumanRole)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__TASK_STAKEHOLDERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskStakeholders(TGenericHumanRole newTaskStakeholders, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__TASK_STAKEHOLDERS, newTaskStakeholders, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskStakeholders(TGenericHumanRole newTaskStakeholders) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__TASK_STAKEHOLDERS, newTaskStakeholders);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return (String)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TUserlist getUsers() {
		return (TUserlist)getMixed().get(HTPackage.Literals.DOCUMENT_ROOT__USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsers(TUserlist newUsers, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.DOCUMENT_ROOT__USERS, newUsers, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsers(TUserlist newUsers) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.DOCUMENT_ROOT__USERS, newUsers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case HTPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case HTPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case HTPackage.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS:
				return basicSetBusinessAdministrators(null, msgs);
			case HTPackage.DOCUMENT_ROOT__EXCLUDED_OWNERS:
				return basicSetExcludedOwners(null, msgs);
			case HTPackage.DOCUMENT_ROOT__GROUPS:
				return basicSetGroups(null, msgs);
			case HTPackage.DOCUMENT_ROOT__HUMAN_INTERACTIONS:
				return basicSetHumanInteractions(null, msgs);
			case HTPackage.DOCUMENT_ROOT__IMPORT:
				return basicSetImport(null, msgs);
			case HTPackage.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS:
				return basicSetLogicalPeopleGroups(null, msgs);
			case HTPackage.DOCUMENT_ROOT__NOTIFICATION:
				return basicSetNotification(null, msgs);
			case HTPackage.DOCUMENT_ROOT__NOTIFICATIONS:
				return basicSetNotifications(null, msgs);
			case HTPackage.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY:
				return basicSetOrganizationalEntity(null, msgs);
			case HTPackage.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS:
				return basicSetPeopleAssignments(null, msgs);
			case HTPackage.DOCUMENT_ROOT__POTENTIAL_OWNERS:
				return basicSetPotentialOwners(null, msgs);
			case HTPackage.DOCUMENT_ROOT__PRIORITY:
				return basicSetPriority(null, msgs);
			case HTPackage.DOCUMENT_ROOT__RECIPIENTS:
				return basicSetRecipients(null, msgs);
			case HTPackage.DOCUMENT_ROOT__TASK:
				return basicSetTask(null, msgs);
			case HTPackage.DOCUMENT_ROOT__TASK_INITIATOR:
				return basicSetTaskInitiator(null, msgs);
			case HTPackage.DOCUMENT_ROOT__TASKS:
				return basicSetTasks(null, msgs);
			case HTPackage.DOCUMENT_ROOT__TASK_STAKEHOLDERS:
				return basicSetTaskStakeholders(null, msgs);
			case HTPackage.DOCUMENT_ROOT__USERS:
				return basicSetUsers(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HTPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case HTPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case HTPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case HTPackage.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS:
				return getBusinessAdministrators();
			case HTPackage.DOCUMENT_ROOT__EXCLUDED_OWNERS:
				return getExcludedOwners();
			case HTPackage.DOCUMENT_ROOT__GROUP:
				return getGroup();
			case HTPackage.DOCUMENT_ROOT__GROUPS:
				return getGroups();
			case HTPackage.DOCUMENT_ROOT__HUMAN_INTERACTIONS:
				return getHumanInteractions();
			case HTPackage.DOCUMENT_ROOT__IMPORT:
				return getImport();
			case HTPackage.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS:
				return getLogicalPeopleGroups();
			case HTPackage.DOCUMENT_ROOT__NOTIFICATION:
				return getNotification();
			case HTPackage.DOCUMENT_ROOT__NOTIFICATIONS:
				return getNotifications();
			case HTPackage.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY:
				return getOrganizationalEntity();
			case HTPackage.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS:
				return getPeopleAssignments();
			case HTPackage.DOCUMENT_ROOT__POTENTIAL_OWNERS:
				return getPotentialOwners();
			case HTPackage.DOCUMENT_ROOT__PRIORITY:
				return getPriority();
			case HTPackage.DOCUMENT_ROOT__RECIPIENTS:
				return getRecipients();
			case HTPackage.DOCUMENT_ROOT__TASK:
				return getTask();
			case HTPackage.DOCUMENT_ROOT__TASK_INITIATOR:
				return getTaskInitiator();
			case HTPackage.DOCUMENT_ROOT__TASKS:
				return getTasks();
			case HTPackage.DOCUMENT_ROOT__TASK_STAKEHOLDERS:
				return getTaskStakeholders();
			case HTPackage.DOCUMENT_ROOT__USER:
				return getUser();
			case HTPackage.DOCUMENT_ROOT__USERS:
				return getUsers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HTPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS:
				setBusinessAdministrators((TGenericHumanRole)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__EXCLUDED_OWNERS:
				setExcludedOwners((TGenericHumanRole)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__GROUP:
				setGroup((String)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__GROUPS:
				setGroups((TGrouplist)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__HUMAN_INTERACTIONS:
				setHumanInteractions((THumanInteractions)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__IMPORT:
				setImport((TImport)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS:
				setLogicalPeopleGroups((TLogicalPeopleGroups)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__NOTIFICATION:
				setNotification((TNotification)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__NOTIFICATIONS:
				setNotifications((TNotifications)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY:
				setOrganizationalEntity((TOrganizationalEntity)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS:
				setPeopleAssignments((TPeopleAssignments)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__POTENTIAL_OWNERS:
				setPotentialOwners((TGenericHumanRole)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__PRIORITY:
				setPriority((TPriority)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__RECIPIENTS:
				setRecipients((TGenericHumanRole)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__TASK:
				setTask((TTask)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__TASK_INITIATOR:
				setTaskInitiator((TGenericHumanRole)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__TASKS:
				setTasks((TTasks)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__TASK_STAKEHOLDERS:
				setTaskStakeholders((TGenericHumanRole)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__USER:
				setUser((String)newValue);
				return;
			case HTPackage.DOCUMENT_ROOT__USERS:
				setUsers((TUserlist)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case HTPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case HTPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case HTPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case HTPackage.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS:
				setBusinessAdministrators((TGenericHumanRole)null);
				return;
			case HTPackage.DOCUMENT_ROOT__EXCLUDED_OWNERS:
				setExcludedOwners((TGenericHumanRole)null);
				return;
			case HTPackage.DOCUMENT_ROOT__GROUP:
				setGroup(GROUP_EDEFAULT);
				return;
			case HTPackage.DOCUMENT_ROOT__GROUPS:
				setGroups((TGrouplist)null);
				return;
			case HTPackage.DOCUMENT_ROOT__HUMAN_INTERACTIONS:
				setHumanInteractions((THumanInteractions)null);
				return;
			case HTPackage.DOCUMENT_ROOT__IMPORT:
				setImport((TImport)null);
				return;
			case HTPackage.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS:
				setLogicalPeopleGroups((TLogicalPeopleGroups)null);
				return;
			case HTPackage.DOCUMENT_ROOT__NOTIFICATION:
				setNotification((TNotification)null);
				return;
			case HTPackage.DOCUMENT_ROOT__NOTIFICATIONS:
				setNotifications((TNotifications)null);
				return;
			case HTPackage.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY:
				setOrganizationalEntity((TOrganizationalEntity)null);
				return;
			case HTPackage.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS:
				setPeopleAssignments((TPeopleAssignments)null);
				return;
			case HTPackage.DOCUMENT_ROOT__POTENTIAL_OWNERS:
				setPotentialOwners((TGenericHumanRole)null);
				return;
			case HTPackage.DOCUMENT_ROOT__PRIORITY:
				setPriority((TPriority)null);
				return;
			case HTPackage.DOCUMENT_ROOT__RECIPIENTS:
				setRecipients((TGenericHumanRole)null);
				return;
			case HTPackage.DOCUMENT_ROOT__TASK:
				setTask((TTask)null);
				return;
			case HTPackage.DOCUMENT_ROOT__TASK_INITIATOR:
				setTaskInitiator((TGenericHumanRole)null);
				return;
			case HTPackage.DOCUMENT_ROOT__TASKS:
				setTasks((TTasks)null);
				return;
			case HTPackage.DOCUMENT_ROOT__TASK_STAKEHOLDERS:
				setTaskStakeholders((TGenericHumanRole)null);
				return;
			case HTPackage.DOCUMENT_ROOT__USER:
				setUser(USER_EDEFAULT);
				return;
			case HTPackage.DOCUMENT_ROOT__USERS:
				setUsers((TUserlist)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case HTPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case HTPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case HTPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case HTPackage.DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS:
				return getBusinessAdministrators() != null;
			case HTPackage.DOCUMENT_ROOT__EXCLUDED_OWNERS:
				return getExcludedOwners() != null;
			case HTPackage.DOCUMENT_ROOT__GROUP:
				return GROUP_EDEFAULT == null ? getGroup() != null : !GROUP_EDEFAULT.equals(getGroup());
			case HTPackage.DOCUMENT_ROOT__GROUPS:
				return getGroups() != null;
			case HTPackage.DOCUMENT_ROOT__HUMAN_INTERACTIONS:
				return getHumanInteractions() != null;
			case HTPackage.DOCUMENT_ROOT__IMPORT:
				return getImport() != null;
			case HTPackage.DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS:
				return getLogicalPeopleGroups() != null;
			case HTPackage.DOCUMENT_ROOT__NOTIFICATION:
				return getNotification() != null;
			case HTPackage.DOCUMENT_ROOT__NOTIFICATIONS:
				return getNotifications() != null;
			case HTPackage.DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY:
				return getOrganizationalEntity() != null;
			case HTPackage.DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS:
				return getPeopleAssignments() != null;
			case HTPackage.DOCUMENT_ROOT__POTENTIAL_OWNERS:
				return getPotentialOwners() != null;
			case HTPackage.DOCUMENT_ROOT__PRIORITY:
				return getPriority() != null;
			case HTPackage.DOCUMENT_ROOT__RECIPIENTS:
				return getRecipients() != null;
			case HTPackage.DOCUMENT_ROOT__TASK:
				return getTask() != null;
			case HTPackage.DOCUMENT_ROOT__TASK_INITIATOR:
				return getTaskInitiator() != null;
			case HTPackage.DOCUMENT_ROOT__TASKS:
				return getTasks() != null;
			case HTPackage.DOCUMENT_ROOT__TASK_STAKEHOLDERS:
				return getTaskStakeholders() != null;
			case HTPackage.DOCUMENT_ROOT__USER:
				return USER_EDEFAULT == null ? getUser() != null : !USER_EDEFAULT.equals(getUser());
			case HTPackage.DOCUMENT_ROOT__USERS:
				return getUsers() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
