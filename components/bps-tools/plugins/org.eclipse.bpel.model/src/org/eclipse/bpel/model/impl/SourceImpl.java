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
 * $Id: SourceImpl.java,v 1.10 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Condition;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ElementFactory;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.SourceImpl#getLink <em>Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.SourceImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.SourceImpl#getTransitionCondition <em>Transition Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceImpl extends BPELExtensibleElementImpl implements Source {
	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected Link link;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

	/**
	 * The cached value of the '{@link #getTransitionCondition() <em>Transition Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition transitionCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getLink() {
		if (link != null && link.eIsProxy()) {
			InternalEObject oldLink = (InternalEObject) link;
			link = (Link) eResolveProxy(oldLink);
			if (link != oldLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.SOURCE__LINK, oldLink, link));
			}
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link basicGetLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetLink(Link newLink, NotificationChain msgs) {
		Link oldLink = link;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_LINK_NAME, newLink == null ? null
							: newLink.getName());
		}
		link = newLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SOURCE__LINK, oldLink,
					newLink);
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
	public void setLink(Link newLink) {
		if (newLink != link) {
			NotificationChain msgs = null;
			if (link != null)
				msgs = ((InternalEObject) link).eInverseRemove(this,
						BPELPackage.LINK__SOURCES, Link.class, msgs);
			if (newLink != null)
				msgs = ((InternalEObject) newLink).eInverseAdd(this,
						BPELPackage.LINK__SOURCES, Link.class, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SOURCE__LINK, newLink, newLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public Activity getActivity() {
		EObject container = eContainer();
		if (!(container instanceof Sources))
			return null;
		container = container.eContainer();
		if (!(container instanceof Activity))
			return null;
		return (Activity) container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setActivity(Activity newActivity) {
		Sources sources = newActivity.getSources();
		if (sources == null) {
			sources = BPELFactory.eINSTANCE.createSources();
			newActivity.setSources(sources);
		}
		sources.getChildren().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getTransitionCondition() {
		return transitionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetTransitionCondition(
			Condition newTransitionCondition, NotificationChain msgs) {
		Condition oldTransitionCondition = transitionCondition;
		if (!isReconciling) {
			if (newTransitionCondition != null
					&& newTransitionCondition.getElement() == null
					&& !ReconciliationHelper.isLoading(this)) {
				newTransitionCondition.setElement(ElementFactory.getInstance()
						.createExpressionElement(newTransitionCondition, this,
								BPELConstants.ND_TRANSITION_CONDITION));
			}
			ReconciliationHelper.replaceChild(this, oldTransitionCondition,
					newTransitionCondition);
		}
		transitionCondition = newTransitionCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SOURCE__TRANSITION_CONDITION,
					oldTransitionCondition, newTransitionCondition);
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
	public void setTransitionCondition(Condition newTransitionCondition) {
		if (newTransitionCondition != transitionCondition) {
			NotificationChain msgs = null;
			if (transitionCondition != null)
				msgs = ((InternalEObject) transitionCondition).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SOURCE__TRANSITION_CONDITION,
						null, msgs);
			if (newTransitionCondition != null)
				msgs = ((InternalEObject) newTransitionCondition).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SOURCE__TRANSITION_CONDITION,
						null, msgs);
			msgs = basicSetTransitionCondition(newTransitionCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SOURCE__TRANSITION_CONDITION,
					newTransitionCondition, newTransitionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BPELPackage.SOURCE__LINK:
			if (link != null)
				msgs = ((InternalEObject) link).eInverseRemove(this,
						BPELPackage.LINK__SOURCES, Link.class, msgs);
			return basicSetLink((Link) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case BPELPackage.SOURCE__LINK:
			return basicSetLink(null, msgs);
		case BPELPackage.SOURCE__TRANSITION_CONDITION:
			return basicSetTransitionCondition(null, msgs);
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
		case BPELPackage.SOURCE__LINK:
			if (resolve)
				return getLink();
			return basicGetLink();
		case BPELPackage.SOURCE__ACTIVITY:
			if (resolve)
				return getActivity();
			return basicGetActivity();
		case BPELPackage.SOURCE__TRANSITION_CONDITION:
			return getTransitionCondition();
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
		case BPELPackage.SOURCE__LINK:
			setLink((Link) newValue);
			return;
		case BPELPackage.SOURCE__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.SOURCE__TRANSITION_CONDITION:
			setTransitionCondition((Condition) newValue);
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
		case BPELPackage.SOURCE__LINK:
			setLink((Link) null);
			return;
		case BPELPackage.SOURCE__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.SOURCE__TRANSITION_CONDITION:
			setTransitionCondition((Condition) null);
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
		case BPELPackage.SOURCE__LINK:
			return link != null;
		case BPELPackage.SOURCE__ACTIVITY:
			return activity != null;
		case BPELPackage.SOURCE__TRANSITION_CONDITION:
			return transitionCondition != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceImpl
