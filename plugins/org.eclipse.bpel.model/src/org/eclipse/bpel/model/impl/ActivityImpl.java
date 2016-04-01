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
 * $Id: ActivityImpl.java,v 1.11 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ActivityImpl#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ActivityImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ActivityImpl#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends BPELExtensibleElementImpl implements Activity {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SUPPRESS_JOIN_FAILURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected Boolean suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;

	/**
	 * This is true if the Suppress Join Failure attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean suppressJoinFailureESet;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected Targets targets;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected Sources sources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, BPELConstants.AT_NAME,
					newName);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ACTIVITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getSuppressJoinFailure() {
		return suppressJoinFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSuppressJoinFailure(Boolean newSuppressJoinFailure) {
		Boolean oldSuppressJoinFailure = suppressJoinFailure;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUPPRESS_JOIN_FAILURE,
					BPELUtils.boolean2XML(newSuppressJoinFailure));
		}
		suppressJoinFailure = newSuppressJoinFailure;
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE,
					oldSuppressJoinFailure, suppressJoinFailure,
					!oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetSuppressJoinFailure() {
		Boolean oldSuppressJoinFailure = suppressJoinFailure;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUPPRESS_JOIN_FAILURE, (String) null);
		}
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;
		suppressJoinFailureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE,
					oldSuppressJoinFailure, SUPPRESS_JOIN_FAILURE_EDEFAULT,
					oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuppressJoinFailure() {
		return suppressJoinFailureESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Targets getTargets() {
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetTargets(Targets newTargets,
			NotificationChain msgs) {
		Targets oldTargets = targets;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldTargets, newTargets);
		}
		targets = newTargets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ACTIVITY__TARGETS,
					oldTargets, newTargets);
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
	public void setTargets(Targets newTargets) {
		if (newTargets != targets) {
			NotificationChain msgs = null;
			if (targets != null)
				msgs = ((InternalEObject) targets).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.ACTIVITY__TARGETS,
						null, msgs);
			if (newTargets != null)
				msgs = ((InternalEObject) newTargets).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.ACTIVITY__TARGETS,
						null, msgs);
			msgs = basicSetTargets(newTargets, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ACTIVITY__TARGETS, newTargets, newTargets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sources getSources() {
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetSources(Sources newSources,
			NotificationChain msgs) {
		Sources oldSources = sources;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldSources, newSources);
		}
		sources = newSources;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ACTIVITY__SOURCES,
					oldSources, newSources);
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
	public void setSources(Sources newSources) {
		if (newSources != sources) {
			NotificationChain msgs = null;
			if (sources != null)
				msgs = ((InternalEObject) sources).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.ACTIVITY__SOURCES,
						null, msgs);
			if (newSources != null)
				msgs = ((InternalEObject) newSources).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.ACTIVITY__SOURCES,
						null, msgs);
			msgs = basicSetSources(newSources, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ACTIVITY__SOURCES, newSources, newSources));
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
		case BPELPackage.ACTIVITY__TARGETS:
			return basicSetTargets(null, msgs);
		case BPELPackage.ACTIVITY__SOURCES:
			return basicSetSources(null, msgs);
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
		case BPELPackage.ACTIVITY__NAME:
			return getName();
		case BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE:
			return getSuppressJoinFailure();
		case BPELPackage.ACTIVITY__TARGETS:
			return getTargets();
		case BPELPackage.ACTIVITY__SOURCES:
			return getSources();
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
		case BPELPackage.ACTIVITY__NAME:
			setName((String) newValue);
			return;
		case BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE:
			setSuppressJoinFailure((Boolean) newValue);
			return;
		case BPELPackage.ACTIVITY__TARGETS:
			setTargets((Targets) newValue);
			return;
		case BPELPackage.ACTIVITY__SOURCES:
			setSources((Sources) newValue);
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
		case BPELPackage.ACTIVITY__NAME:
			setName(NAME_EDEFAULT);
			return;
		case BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE:
			unsetSuppressJoinFailure();
			return;
		case BPELPackage.ACTIVITY__TARGETS:
			setTargets((Targets) null);
			return;
		case BPELPackage.ACTIVITY__SOURCES:
			setSources((Sources) null);
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
		case BPELPackage.ACTIVITY__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE:
			return isSetSuppressJoinFailure();
		case BPELPackage.ACTIVITY__TARGETS:
			return targets != null;
		case BPELPackage.ACTIVITY__SOURCES:
			return sources != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", suppressJoinFailure: "); //$NON-NLS-1$
		if (suppressJoinFailureESet)
			result.append(suppressJoinFailure);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	public int getActivityNodeIndex(Node activityNode) {
		Node parent = activityNode.getParentNode();
		if (parent == null) {
			return -1; //error
		}

		int index = 0;
		for (Node child = parent.getFirstChild(); child != null; child = child
				.getNextSibling()) {
			if (child == activityNode) {
				return index;
			}
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				index++;
			}
		}

		return -1; // error
	}
	/*protected void handleReconciliation(Collection remainingModelObjects) {
	    for (Iterator i = remainingModelObjects.iterator(); i.hasNext();){
	    	remove(this, i.next());
	    }
	}*/

} //ActivityImpl
