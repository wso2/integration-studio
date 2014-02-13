/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions;
import org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TImport;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>THuman Interactions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getLogicalPeopleGroups <em>Logical People Groups</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl#getTargetNamespace <em>Target Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class THumanInteractionsImpl extends TExtensibleElementsImpl implements THumanInteractions {
	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected TExtensions extensions;

	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected EList<TImport> import_;

	/**
	 * The cached value of the '{@link #getLogicalPeopleGroups() <em>Logical People Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalPeopleGroups()
	 * @generated
	 * @ordered
	 */
	protected TLogicalPeopleGroups logicalPeopleGroups;

	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected TTasks tasks;

	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected TNotifications notifications;

	/**
	 * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected String queryLanguage = QUERY_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNamespace()
	 * @generated
	 * @ordered
	 */
	protected String targetNamespace = TARGET_NAMESPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected THumanInteractionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.THUMAN_INTERACTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExtensions getExtensions() {
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensions(TExtensions newExtensions, NotificationChain msgs) {
		TExtensions oldExtensions = extensions;
		extensions = newExtensions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__EXTENSIONS, oldExtensions, newExtensions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensions(TExtensions newExtensions) {
		if (newExtensions != extensions) {
			NotificationChain msgs = null;
			if (extensions != null)
				msgs = ((InternalEObject)extensions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__EXTENSIONS, null, msgs);
			if (newExtensions != null)
				msgs = ((InternalEObject)newExtensions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__EXTENSIONS, null, msgs);
			msgs = basicSetExtensions(newExtensions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__EXTENSIONS, newExtensions, newExtensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TImport> getImport() {
		if (import_ == null) {
			import_ = new EObjectContainmentEList<TImport>(TImport.class, this, HTPackage.THUMAN_INTERACTIONS__IMPORT);
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLogicalPeopleGroups getLogicalPeopleGroups() {
		return logicalPeopleGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogicalPeopleGroups(TLogicalPeopleGroups newLogicalPeopleGroups, NotificationChain msgs) {
		TLogicalPeopleGroups oldLogicalPeopleGroups = logicalPeopleGroups;
		logicalPeopleGroups = newLogicalPeopleGroups;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS, oldLogicalPeopleGroups, newLogicalPeopleGroups);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalPeopleGroups(TLogicalPeopleGroups newLogicalPeopleGroups) {
		if (newLogicalPeopleGroups != logicalPeopleGroups) {
			NotificationChain msgs = null;
			if (logicalPeopleGroups != null)
				msgs = ((InternalEObject)logicalPeopleGroups).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS, null, msgs);
			if (newLogicalPeopleGroups != null)
				msgs = ((InternalEObject)newLogicalPeopleGroups).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS, null, msgs);
			msgs = basicSetLogicalPeopleGroups(newLogicalPeopleGroups, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS, newLogicalPeopleGroups, newLogicalPeopleGroups));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTasks getTasks() {
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTasks(TTasks newTasks, NotificationChain msgs) {
		TTasks oldTasks = tasks;
		tasks = newTasks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__TASKS, oldTasks, newTasks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTasks(TTasks newTasks) {
		if (newTasks != tasks) {
			NotificationChain msgs = null;
			if (tasks != null)
				msgs = ((InternalEObject)tasks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__TASKS, null, msgs);
			if (newTasks != null)
				msgs = ((InternalEObject)newTasks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__TASKS, null, msgs);
			msgs = basicSetTasks(newTasks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__TASKS, newTasks, newTasks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotifications getNotifications() {
		return notifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotifications(TNotifications newNotifications, NotificationChain msgs) {
		TNotifications oldNotifications = notifications;
		notifications = newNotifications;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS, oldNotifications, newNotifications);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotifications(TNotifications newNotifications) {
		if (newNotifications != notifications) {
			NotificationChain msgs = null;
			if (notifications != null)
				msgs = ((InternalEObject)notifications).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS, null, msgs);
			if (newNotifications != null)
				msgs = ((InternalEObject)newNotifications).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS, null, msgs);
			msgs = basicSetNotifications(newNotifications, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS, newNotifications, newNotifications));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionLanguage(String newExpressionLanguage) {
		String oldExpressionLanguage = expressionLanguage;
		expressionLanguage = newExpressionLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE, oldExpressionLanguage, expressionLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryLanguage() {
		return queryLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryLanguage(String newQueryLanguage) {
		String oldQueryLanguage = queryLanguage;
		queryLanguage = newQueryLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__QUERY_LANGUAGE, oldQueryLanguage, queryLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetNamespace() {
		return targetNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNamespace(String newTargetNamespace) {
		String oldTargetNamespace = targetNamespace;
		targetNamespace = newTargetNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.THUMAN_INTERACTIONS__TARGET_NAMESPACE, oldTargetNamespace, targetNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.THUMAN_INTERACTIONS__EXTENSIONS:
				return basicSetExtensions(null, msgs);
			case HTPackage.THUMAN_INTERACTIONS__IMPORT:
				return ((InternalEList<?>)getImport()).basicRemove(otherEnd, msgs);
			case HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS:
				return basicSetLogicalPeopleGroups(null, msgs);
			case HTPackage.THUMAN_INTERACTIONS__TASKS:
				return basicSetTasks(null, msgs);
			case HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS:
				return basicSetNotifications(null, msgs);
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
			case HTPackage.THUMAN_INTERACTIONS__EXTENSIONS:
				return getExtensions();
			case HTPackage.THUMAN_INTERACTIONS__IMPORT:
				return getImport();
			case HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS:
				return getLogicalPeopleGroups();
			case HTPackage.THUMAN_INTERACTIONS__TASKS:
				return getTasks();
			case HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS:
				return getNotifications();
			case HTPackage.THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE:
				return getExpressionLanguage();
			case HTPackage.THUMAN_INTERACTIONS__QUERY_LANGUAGE:
				return getQueryLanguage();
			case HTPackage.THUMAN_INTERACTIONS__TARGET_NAMESPACE:
				return getTargetNamespace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HTPackage.THUMAN_INTERACTIONS__EXTENSIONS:
				setExtensions((TExtensions)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__IMPORT:
				getImport().clear();
				getImport().addAll((Collection<? extends TImport>)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS:
				setLogicalPeopleGroups((TLogicalPeopleGroups)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__TASKS:
				setTasks((TTasks)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS:
				setNotifications((TNotifications)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE:
				setExpressionLanguage((String)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__QUERY_LANGUAGE:
				setQueryLanguage((String)newValue);
				return;
			case HTPackage.THUMAN_INTERACTIONS__TARGET_NAMESPACE:
				setTargetNamespace((String)newValue);
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
			case HTPackage.THUMAN_INTERACTIONS__EXTENSIONS:
				setExtensions((TExtensions)null);
				return;
			case HTPackage.THUMAN_INTERACTIONS__IMPORT:
				getImport().clear();
				return;
			case HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS:
				setLogicalPeopleGroups((TLogicalPeopleGroups)null);
				return;
			case HTPackage.THUMAN_INTERACTIONS__TASKS:
				setTasks((TTasks)null);
				return;
			case HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS:
				setNotifications((TNotifications)null);
				return;
			case HTPackage.THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE:
				setExpressionLanguage(EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case HTPackage.THUMAN_INTERACTIONS__QUERY_LANGUAGE:
				setQueryLanguage(QUERY_LANGUAGE_EDEFAULT);
				return;
			case HTPackage.THUMAN_INTERACTIONS__TARGET_NAMESPACE:
				setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
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
			case HTPackage.THUMAN_INTERACTIONS__EXTENSIONS:
				return extensions != null;
			case HTPackage.THUMAN_INTERACTIONS__IMPORT:
				return import_ != null && !import_.isEmpty();
			case HTPackage.THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS:
				return logicalPeopleGroups != null;
			case HTPackage.THUMAN_INTERACTIONS__TASKS:
				return tasks != null;
			case HTPackage.THUMAN_INTERACTIONS__NOTIFICATIONS:
				return notifications != null;
			case HTPackage.THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE:
				return EXPRESSION_LANGUAGE_EDEFAULT == null ? expressionLanguage != null : !EXPRESSION_LANGUAGE_EDEFAULT.equals(expressionLanguage);
			case HTPackage.THUMAN_INTERACTIONS__QUERY_LANGUAGE:
				return QUERY_LANGUAGE_EDEFAULT == null ? queryLanguage != null : !QUERY_LANGUAGE_EDEFAULT.equals(queryLanguage);
			case HTPackage.THUMAN_INTERACTIONS__TARGET_NAMESPACE:
				return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null : !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
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
		result.append(" (expressionLanguage: ");
		result.append(expressionLanguage);
		result.append(", queryLanguage: ");
		result.append(queryLanguage);
		result.append(", targetNamespace: ");
		result.append(targetNamespace);
		result.append(')');
		return result.toString();
	}

} //THumanInteractionsImpl
