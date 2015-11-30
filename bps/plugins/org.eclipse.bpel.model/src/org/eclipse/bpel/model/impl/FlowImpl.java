/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: FlowImpl.java,v 1.9 2009/04/14 10:50:37 smoser Exp $
 */
package org.eclipse.bpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.FlowImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FlowImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FlowImpl#getCompletionCondition <em>Completion Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowImpl extends ActivityImpl implements Flow {
	/**
	 * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivities()
	 * @generated
	 * @ordered
	 */
	protected EList<Activity> activities;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected Links links;

	/**
	 * The cached value of the '{@link #getCompletionCondition() <em>Completion Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionCondition()
	 * @generated
	 * @ordered
	 */
	protected CompletionCondition completionCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Activity> getActivities() {
		if (activities == null) {
			activities = new EObjectContainmentEList<Activity>(Activity.class,
					this, BPELPackage.FLOW__ACTIVITIES);
		}
		return activities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Links getLinks() {
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetLinks(Links newLinks,
			NotificationChain msgs) {
		Links oldLinks = links;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldLinks, newLinks);
		}
		links = newLinks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.FLOW__LINKS, oldLinks,
					newLinks);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinks(Links newLinks) {
		if (newLinks != links) {
			NotificationChain msgs = null;
			if (links != null)
				msgs = ((InternalEObject) links).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.FLOW__LINKS, null,
						msgs);
			if (newLinks != null)
				msgs = ((InternalEObject) newLinks).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.FLOW__LINKS, null,
						msgs);
			msgs = basicSetLinks(newLinks, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FLOW__LINKS, newLinks, newLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionCondition getCompletionCondition() {
		return completionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCompletionCondition(
			CompletionCondition newCompletionCondition, NotificationChain msgs) {
		CompletionCondition oldCompletionCondition = completionCondition;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCompletionCondition,
					newCompletionCondition);
		}
		completionCondition = newCompletionCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.FLOW__COMPLETION_CONDITION,
					oldCompletionCondition, newCompletionCondition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionCondition(
			CompletionCondition newCompletionCondition) {
		if (newCompletionCondition != completionCondition) {
			NotificationChain msgs = null;
			if (completionCondition != null)
				msgs = ((InternalEObject) completionCondition).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FLOW__COMPLETION_CONDITION, null,
						msgs);
			if (newCompletionCondition != null)
				msgs = ((InternalEObject) newCompletionCondition).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FLOW__COMPLETION_CONDITION, null,
						msgs);
			msgs = basicSetCompletionCondition(newCompletionCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FLOW__COMPLETION_CONDITION,
					newCompletionCondition, newCompletionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BPELPackage.FLOW__ACTIVITIES:
			return ((InternalEList<?>) getActivities()).basicRemove(otherEnd,
					msgs);
		case BPELPackage.FLOW__LINKS:
			return basicSetLinks(null, msgs);
		case BPELPackage.FLOW__COMPLETION_CONDITION:
			return basicSetCompletionCondition(null, msgs);
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
		case BPELPackage.FLOW__ACTIVITIES:
			return getActivities();
		case BPELPackage.FLOW__LINKS:
			return getLinks();
		case BPELPackage.FLOW__COMPLETION_CONDITION:
			return getCompletionCondition();
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
		case BPELPackage.FLOW__ACTIVITIES:
			getActivities().clear();
			getActivities().addAll((Collection<? extends Activity>) newValue);
			return;
		case BPELPackage.FLOW__LINKS:
			setLinks((Links) newValue);
			return;
		case BPELPackage.FLOW__COMPLETION_CONDITION:
			setCompletionCondition((CompletionCondition) newValue);
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
		case BPELPackage.FLOW__ACTIVITIES:
			getActivities().clear();
			return;
		case BPELPackage.FLOW__LINKS:
			setLinks((Links) null);
			return;
		case BPELPackage.FLOW__COMPLETION_CONDITION:
			setCompletionCondition((CompletionCondition) null);
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
		case BPELPackage.FLOW__ACTIVITIES:
			return activities != null && !activities.isEmpty();
		case BPELPackage.FLOW__LINKS:
			return links != null;
		case BPELPackage.FLOW__COMPLETION_CONDITION:
			return completionCondition != null;
		}
		return super.eIsSet(featureID);
	}

} //FlowImpl
