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
 * $Id: ScopeImpl.java,v 1.15 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getIsolated <em>Isolated</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getFaultHandlers <em>Fault Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getCompensationHandler <em>Compensation Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getEventHandlers <em>Event Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getPartnerLinks <em>Partner Links</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getTerminationHandler <em>Termination Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getMessageExchanges <em>Message Exchanges</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ScopeImpl#getExitOnStandardFault <em>Exit On Standard Fault</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScopeImpl extends ActivityImpl implements Scope {
	/**
	 * The default value of the '{@link #getIsolated() <em>Isolated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsolated()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean ISOLATED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getIsolated() <em>Isolated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsolated()
	 * @generated
	 * @ordered
	 */
	protected Boolean isolated = ISOLATED_EDEFAULT;

	/**
	 * This is true if the Isolated attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isolatedESet;

	/**
	 * The cached value of the '{@link #getFaultHandlers() <em>Fault Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultHandlers()
	 * @generated
	 * @ordered
	 */
	protected FaultHandler faultHandlers;

	/**
	 * The cached value of the '{@link #getCompensationHandler() <em>Compensation Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompensationHandler()
	 * @generated
	 * @ordered
	 */
	protected CompensationHandler compensationHandler;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected Variables variables;

	/**
	 * The cached value of the '{@link #getCorrelationSets() <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationSets()
	 * @generated
	 * @ordered
	 */
	protected CorrelationSets correlationSets;

	/**
	 * The cached value of the '{@link #getEventHandlers() <em>Event Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventHandlers()
	 * @generated
	 * @ordered
	 */
	protected EventHandler eventHandlers;

	/**
	 * The cached value of the '{@link #getPartnerLinks() <em>Partner Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLinks()
	 * @generated
	 * @ordered
	 */
	protected PartnerLinks partnerLinks;

	/**
	 * The cached value of the '{@link #getTerminationHandler() <em>Termination Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminationHandler()
	 * @generated
	 * @ordered
	 */
	protected TerminationHandler terminationHandler;

	/**
	 * The cached value of the '{@link #getMessageExchanges() <em>Message Exchanges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageExchanges()
	 * @generated
	 * @ordered
	 */
	protected MessageExchanges messageExchanges;

	/**
	 * The default value of the '{@link #getExitOnStandardFault() <em>Exit On Standard Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitOnStandardFault()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean EXIT_ON_STANDARD_FAULT_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getExitOnStandardFault() <em>Exit On Standard Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitOnStandardFault()
	 * @generated
	 * @ordered
	 */
	protected Boolean exitOnStandardFault = EXIT_ON_STANDARD_FAULT_EDEFAULT;

	/**
	 * This is true if the Exit On Standard Fault attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean exitOnStandardFaultESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsolated() {
		return isolated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIsolated(Boolean newIsolated) {
		Boolean oldIsolated = isolated;
		isolated = newIsolated;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_ISOLATED,
					BPELUtils.boolean2XML(newIsolated));
		}
		boolean oldIsolatedESet = isolatedESet;
		isolatedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__ISOLATED, oldIsolated, isolated,
					!oldIsolatedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetIsolated() {
		Boolean oldIsolated = isolated;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_ISOLATED, (String) null);
		}
		boolean oldIsolatedESet = isolatedESet;
		isolated = ISOLATED_EDEFAULT;
		isolatedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.SCOPE__ISOLATED, oldIsolated,
					ISOLATED_EDEFAULT, oldIsolatedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsolated() {
		return isolatedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultHandler getFaultHandlers() {
		return faultHandlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFaultHandlers(
			FaultHandler newFaultHandlers, NotificationChain msgs) {
		FaultHandler oldFaultHandlers = faultHandlers;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFaultHandlers,
					newFaultHandlers);
		}
		faultHandlers = newFaultHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__FAULT_HANDLERS,
					oldFaultHandlers, newFaultHandlers);
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
	public void setFaultHandlers(FaultHandler newFaultHandlers) {
		if (newFaultHandlers != faultHandlers) {
			NotificationChain msgs = null;
			if (faultHandlers != null)
				msgs = ((InternalEObject) faultHandlers)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__FAULT_HANDLERS, null, msgs);
			if (newFaultHandlers != null)
				msgs = ((InternalEObject) newFaultHandlers)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__FAULT_HANDLERS, null, msgs);
			msgs = basicSetFaultHandlers(newFaultHandlers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__FAULT_HANDLERS, newFaultHandlers,
					newFaultHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompensationHandler getCompensationHandler() {
		return compensationHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCompensationHandler(
			CompensationHandler newCompensationHandler, NotificationChain msgs) {
		CompensationHandler oldCompensationHandler = compensationHandler;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCompensationHandler,
					newCompensationHandler);
		}
		compensationHandler = newCompensationHandler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__COMPENSATION_HANDLER,
					oldCompensationHandler, newCompensationHandler);
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
	public void setCompensationHandler(
			CompensationHandler newCompensationHandler) {
		if (newCompensationHandler != compensationHandler) {
			NotificationChain msgs = null;
			if (compensationHandler != null)
				msgs = ((InternalEObject) compensationHandler).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__COMPENSATION_HANDLER,
						null, msgs);
			if (newCompensationHandler != null)
				msgs = ((InternalEObject) newCompensationHandler).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__COMPENSATION_HANDLER,
						null, msgs);
			msgs = basicSetCompensationHandler(newCompensationHandler, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__COMPENSATION_HANDLER,
					newCompensationHandler, newCompensationHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetActivity(Activity newActivity,
			NotificationChain msgs) {
		Activity oldActivity = activity;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldActivity, newActivity);
		}
		activity = newActivity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__ACTIVITY, oldActivity,
					newActivity);
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
	public void setActivity(Activity newActivity) {
		if (newActivity != activity) {
			NotificationChain msgs = null;
			if (activity != null)
				msgs = ((InternalEObject) activity).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.SCOPE__ACTIVITY,
						null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.SCOPE__ACTIVITY,
						null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__ACTIVITY, newActivity, newActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variables getVariables() {
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetVariables(Variables newVariables,
			NotificationChain msgs) {
		Variables oldVariables = variables;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldVariables, newVariables);
		}
		variables = newVariables;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__VARIABLES,
					oldVariables, newVariables);
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
	public void setVariables(Variables newVariables) {
		if (newVariables != variables) {
			NotificationChain msgs = null;
			if (variables != null)
				msgs = ((InternalEObject) variables).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.SCOPE__VARIABLES,
						null, msgs);
			if (newVariables != null)
				msgs = ((InternalEObject) newVariables).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.SCOPE__VARIABLES,
						null, msgs);
			msgs = basicSetVariables(newVariables, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__VARIABLES, newVariables, newVariables));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationSets getCorrelationSets() {
		return correlationSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCorrelationSets(
			CorrelationSets newCorrelationSets, NotificationChain msgs) {
		CorrelationSets oldCorrelationSets = correlationSets;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCorrelationSets,
					newCorrelationSets);
		}
		correlationSets = newCorrelationSets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__CORRELATION_SETS,
					oldCorrelationSets, newCorrelationSets);
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
	public void setCorrelationSets(CorrelationSets newCorrelationSets) {
		if (newCorrelationSets != correlationSets) {
			NotificationChain msgs = null;
			if (correlationSets != null)
				msgs = ((InternalEObject) correlationSets).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__CORRELATION_SETS, null,
						msgs);
			if (newCorrelationSets != null)
				msgs = ((InternalEObject) newCorrelationSets).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__CORRELATION_SETS, null,
						msgs);
			msgs = basicSetCorrelationSets(newCorrelationSets, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__CORRELATION_SETS, newCorrelationSets,
					newCorrelationSets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventHandler getEventHandlers() {
		return eventHandlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetEventHandlers(
			EventHandler newEventHandlers, NotificationChain msgs) {
		EventHandler oldEventHandlers = eventHandlers;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldEventHandlers,
					newEventHandlers);
		}
		eventHandlers = newEventHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__EVENT_HANDLERS,
					oldEventHandlers, newEventHandlers);
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
	public void setEventHandlers(EventHandler newEventHandlers) {
		if (newEventHandlers != eventHandlers) {
			NotificationChain msgs = null;
			if (eventHandlers != null)
				msgs = ((InternalEObject) eventHandlers)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__EVENT_HANDLERS, null, msgs);
			if (newEventHandlers != null)
				msgs = ((InternalEObject) newEventHandlers)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__EVENT_HANDLERS, null, msgs);
			msgs = basicSetEventHandlers(newEventHandlers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__EVENT_HANDLERS, newEventHandlers,
					newEventHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLinks getPartnerLinks() {
		return partnerLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetPartnerLinks(PartnerLinks newPartnerLinks,
			NotificationChain msgs) {
		PartnerLinks oldPartnerLinks = partnerLinks;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldPartnerLinks,
					newPartnerLinks);
		}
		partnerLinks = newPartnerLinks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__PARTNER_LINKS,
					oldPartnerLinks, newPartnerLinks);
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
	public void setPartnerLinks(PartnerLinks newPartnerLinks) {
		if (newPartnerLinks != partnerLinks) {
			NotificationChain msgs = null;
			if (partnerLinks != null)
				msgs = ((InternalEObject) partnerLinks).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__PARTNER_LINKS, null, msgs);
			if (newPartnerLinks != null)
				msgs = ((InternalEObject) newPartnerLinks).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__PARTNER_LINKS, null, msgs);
			msgs = basicSetPartnerLinks(newPartnerLinks, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__PARTNER_LINKS, newPartnerLinks,
					newPartnerLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminationHandler getTerminationHandler() {
		return terminationHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetTerminationHandler(
			TerminationHandler newTerminationHandler, NotificationChain msgs) {
		TerminationHandler oldTerminationHandler = terminationHandler;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldTerminationHandler,
					newTerminationHandler);
		}
		terminationHandler = newTerminationHandler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__TERMINATION_HANDLER,
					oldTerminationHandler, newTerminationHandler);
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
	public void setTerminationHandler(TerminationHandler newTerminationHandler) {
		if (newTerminationHandler != terminationHandler) {
			NotificationChain msgs = null;
			if (terminationHandler != null)
				msgs = ((InternalEObject) terminationHandler).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__TERMINATION_HANDLER, null,
						msgs);
			if (newTerminationHandler != null)
				msgs = ((InternalEObject) newTerminationHandler).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__TERMINATION_HANDLER, null,
						msgs);
			msgs = basicSetTerminationHandler(newTerminationHandler, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__TERMINATION_HANDLER,
					newTerminationHandler, newTerminationHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchanges getMessageExchanges() {
		return messageExchanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setMessageExchanges(MessageExchanges newMessageExchanges) {
		if (newMessageExchanges != messageExchanges) {
			NotificationChain msgs = null;
			if (messageExchanges != null)
				msgs = ((InternalEObject) messageExchanges).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__MESSAGE_EXCHANGES, null,
						msgs);
			if (newMessageExchanges != null)
				msgs = ((InternalEObject) newMessageExchanges).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.SCOPE__MESSAGE_EXCHANGES, null,
						msgs);
			msgs = basicSetMessageExchanges(newMessageExchanges, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__MESSAGE_EXCHANGES, newMessageExchanges,
					newMessageExchanges));
	}

	private NotificationChain basicSetMessageExchanges(
			MessageExchanges newMessageExchanges, NotificationChain msgs) {
		MessageExchanges oldMessageExchanges = messageExchanges;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldMessageExchanges,
					newMessageExchanges);
		}
		messageExchanges = newMessageExchanges;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__MESSAGE_EXCHANGES,
					oldMessageExchanges, newMessageExchanges);
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
	public Boolean getExitOnStandardFault() {
		return exitOnStandardFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setExitOnStandardFault(Boolean newExitOnStandardFault) {
		Boolean oldExitOnStandardFault = exitOnStandardFault;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_EXIT_ON_STANDARD_FAULT,
					BPELUtils.boolean2XML(newExitOnStandardFault));
		}
		exitOnStandardFault = newExitOnStandardFault;
		boolean oldExitOnStandardFaultESet = exitOnStandardFaultESet;
		exitOnStandardFaultESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT,
					oldExitOnStandardFault, exitOnStandardFault,
					!oldExitOnStandardFaultESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetExitOnStandardFault() {
		Boolean oldExitOnStandardFault = exitOnStandardFault;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_EXIT_ON_STANDARD_FAULT, (String) null);
		}
		boolean oldExitOnStandardFaultESet = exitOnStandardFaultESet;
		exitOnStandardFault = EXIT_ON_STANDARD_FAULT_EDEFAULT;
		exitOnStandardFaultESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT,
					oldExitOnStandardFault, EXIT_ON_STANDARD_FAULT_EDEFAULT,
					oldExitOnStandardFaultESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExitOnStandardFault() {
		return exitOnStandardFaultESet;
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
		case BPELPackage.SCOPE__FAULT_HANDLERS:
			return basicSetFaultHandlers(null, msgs);
		case BPELPackage.SCOPE__COMPENSATION_HANDLER:
			return basicSetCompensationHandler(null, msgs);
		case BPELPackage.SCOPE__ACTIVITY:
			return basicSetActivity(null, msgs);
		case BPELPackage.SCOPE__VARIABLES:
			return basicSetVariables(null, msgs);
		case BPELPackage.SCOPE__CORRELATION_SETS:
			return basicSetCorrelationSets(null, msgs);
		case BPELPackage.SCOPE__EVENT_HANDLERS:
			return basicSetEventHandlers(null, msgs);
		case BPELPackage.SCOPE__PARTNER_LINKS:
			return basicSetPartnerLinks(null, msgs);
		case BPELPackage.SCOPE__TERMINATION_HANDLER:
			return basicSetTerminationHandler(null, msgs);
		case BPELPackage.SCOPE__MESSAGE_EXCHANGES:
			return basicSetMessageExchanges(null, msgs);
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
		case BPELPackage.SCOPE__ISOLATED:
			return getIsolated();
		case BPELPackage.SCOPE__FAULT_HANDLERS:
			return getFaultHandlers();
		case BPELPackage.SCOPE__COMPENSATION_HANDLER:
			return getCompensationHandler();
		case BPELPackage.SCOPE__ACTIVITY:
			return getActivity();
		case BPELPackage.SCOPE__VARIABLES:
			return getVariables();
		case BPELPackage.SCOPE__CORRELATION_SETS:
			return getCorrelationSets();
		case BPELPackage.SCOPE__EVENT_HANDLERS:
			return getEventHandlers();
		case BPELPackage.SCOPE__PARTNER_LINKS:
			return getPartnerLinks();
		case BPELPackage.SCOPE__TERMINATION_HANDLER:
			return getTerminationHandler();
		case BPELPackage.SCOPE__MESSAGE_EXCHANGES:
			return getMessageExchanges();
		case BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT:
			return getExitOnStandardFault();
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
		case BPELPackage.SCOPE__ISOLATED:
			setIsolated((Boolean) newValue);
			return;
		case BPELPackage.SCOPE__FAULT_HANDLERS:
			setFaultHandlers((FaultHandler) newValue);
			return;
		case BPELPackage.SCOPE__COMPENSATION_HANDLER:
			setCompensationHandler((CompensationHandler) newValue);
			return;
		case BPELPackage.SCOPE__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.SCOPE__VARIABLES:
			setVariables((Variables) newValue);
			return;
		case BPELPackage.SCOPE__CORRELATION_SETS:
			setCorrelationSets((CorrelationSets) newValue);
			return;
		case BPELPackage.SCOPE__EVENT_HANDLERS:
			setEventHandlers((EventHandler) newValue);
			return;
		case BPELPackage.SCOPE__PARTNER_LINKS:
			setPartnerLinks((PartnerLinks) newValue);
			return;
		case BPELPackage.SCOPE__TERMINATION_HANDLER:
			setTerminationHandler((TerminationHandler) newValue);
			return;
		case BPELPackage.SCOPE__MESSAGE_EXCHANGES:
			setMessageExchanges((MessageExchanges) newValue);
			return;
		case BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT:
			setExitOnStandardFault((Boolean) newValue);
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
		case BPELPackage.SCOPE__ISOLATED:
			unsetIsolated();
			return;
		case BPELPackage.SCOPE__FAULT_HANDLERS:
			setFaultHandlers((FaultHandler) null);
			return;
		case BPELPackage.SCOPE__COMPENSATION_HANDLER:
			setCompensationHandler((CompensationHandler) null);
			return;
		case BPELPackage.SCOPE__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.SCOPE__VARIABLES:
			setVariables((Variables) null);
			return;
		case BPELPackage.SCOPE__CORRELATION_SETS:
			setCorrelationSets((CorrelationSets) null);
			return;
		case BPELPackage.SCOPE__EVENT_HANDLERS:
			setEventHandlers((EventHandler) null);
			return;
		case BPELPackage.SCOPE__PARTNER_LINKS:
			setPartnerLinks((PartnerLinks) null);
			return;
		case BPELPackage.SCOPE__TERMINATION_HANDLER:
			setTerminationHandler((TerminationHandler) null);
			return;
		case BPELPackage.SCOPE__MESSAGE_EXCHANGES:
			setMessageExchanges((MessageExchanges) null);
			return;
		case BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT:
			unsetExitOnStandardFault();
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
		case BPELPackage.SCOPE__ISOLATED:
			return isSetIsolated();
		case BPELPackage.SCOPE__FAULT_HANDLERS:
			return faultHandlers != null;
		case BPELPackage.SCOPE__COMPENSATION_HANDLER:
			return compensationHandler != null;
		case BPELPackage.SCOPE__ACTIVITY:
			return activity != null;
		case BPELPackage.SCOPE__VARIABLES:
			return variables != null;
		case BPELPackage.SCOPE__CORRELATION_SETS:
			return correlationSets != null;
		case BPELPackage.SCOPE__EVENT_HANDLERS:
			return eventHandlers != null;
		case BPELPackage.SCOPE__PARTNER_LINKS:
			return partnerLinks != null;
		case BPELPackage.SCOPE__TERMINATION_HANDLER:
			return terminationHandler != null;
		case BPELPackage.SCOPE__MESSAGE_EXCHANGES:
			return messageExchanges != null;
		case BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT:
			return isSetExitOnStandardFault();
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
		result.append(" (isolated: "); //$NON-NLS-1$
		if (isolatedESet)
			result.append(isolated);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", exitOnStandardFault: "); //$NON-NLS-1$
		if (exitOnStandardFaultESet)
			result.append(exitOnStandardFault);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ScopeImpl
