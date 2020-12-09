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
 * $Id: InvokeImpl.java,v 1.13 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getInputVariable <em>Input Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getCompensationHandler <em>Compensation Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getFaultHandler <em>Fault Handler</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getToParts <em>To Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.InvokeImpl#getFailureHandling <em>Failure Handling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class InvokeImpl extends PartnerActivityImpl implements Invoke {
	/**
	 * The cached value of the '{@link #getOutputVariable() <em>Output Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable outputVariable;

	/**
	 * The cached value of the '{@link #getInputVariable() <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable inputVariable;

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
	 * The cached value of the '{@link #getFaultHandler() <em>Fault Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultHandler()
	 * @generated
	 * @ordered
	 */
	protected FaultHandler faultHandler;

	/**
	 * The cached value of the '{@link #getFromParts() <em>From Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromParts()
	 * @generated
	 * @ordered
	 */
	protected FromParts fromParts;

	/**
	 * The cached value of the '{@link #getToParts() <em>To Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToParts()
	 * @generated
	 * @ordered
	 */
	protected ToParts toParts;

	/**
	 * The cached value of the '{@link #getFailureHandling() <em>Failure Handling</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureHandling()
	 * @generated
	 * @ordered
	 */
	protected FailureHandling failureHandling;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getOutputVariable() {
		if (outputVariable != null && outputVariable.eIsProxy()) {
			InternalEObject oldOutputVariable = (InternalEObject) outputVariable;
			outputVariable = (Variable) eResolveProxy(oldOutputVariable);
			if (outputVariable != oldOutputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.INVOKE__OUTPUT_VARIABLE,
							oldOutputVariable, outputVariable));
			}
		}
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetOutputVariable() {
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setOutputVariable(Variable newOutputVariable) {
		Variable oldOutputVariable = outputVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_OUTPUT_VARIABLE,
					newOutputVariable == null ? null : newOutputVariable
							.getName());
		}
		outputVariable = newOutputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__OUTPUT_VARIABLE, oldOutputVariable,
					outputVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getInputVariable() {
		if (inputVariable != null && inputVariable.eIsProxy()) {
			InternalEObject oldInputVariable = (InternalEObject) inputVariable;
			inputVariable = (Variable) eResolveProxy(oldInputVariable);
			if (inputVariable != oldInputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.INVOKE__INPUT_VARIABLE,
							oldInputVariable, inputVariable));
			}
		}
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetInputVariable() {
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setInputVariable(Variable newInputVariable) {
		Variable oldInputVariable = inputVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_INPUT_VARIABLE,
					newInputVariable == null ? null : newInputVariable
							.getName());
		}
		inputVariable = newInputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__INPUT_VARIABLE, oldInputVariable,
					inputVariable));
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
	 * @generated
	 */
	public NotificationChain basicSetCompensationHandler(
			CompensationHandler newCompensationHandler, NotificationChain msgs) {
		CompensationHandler oldCompensationHandler = compensationHandler;
		compensationHandler = newCompensationHandler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.INVOKE__COMPENSATION_HANDLER,
					oldCompensationHandler, newCompensationHandler);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/*
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
								- BPELPackage.INVOKE__COMPENSATION_HANDLER,
						null, msgs);
			if (newCompensationHandler != null)
				msgs = ((InternalEObject) newCompensationHandler).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__COMPENSATION_HANDLER,
						null, msgs);
			msgs = basicSetCompensationHandler(newCompensationHandler, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__COMPENSATION_HANDLER,
					newCompensationHandler, newCompensationHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultHandler getFaultHandler() {
		return faultHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFaultHandler(FaultHandler newFaultHandler,
			NotificationChain msgs) {
		FaultHandler oldFaultHandler = faultHandler;
		if (!isReconciling) {
			ReconciliationHelper.replaceFaultHandler(this, newFaultHandler);
		}
		faultHandler = newFaultHandler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.INVOKE__FAULT_HANDLER,
					oldFaultHandler, newFaultHandler);
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
	public void setFaultHandler(FaultHandler newFaultHandler) {
		if (newFaultHandler != faultHandler) {
			NotificationChain msgs = null;
			if (faultHandler != null)
				msgs = ((InternalEObject) faultHandler)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__FAULT_HANDLER, null, msgs);
			if (newFaultHandler != null)
				msgs = ((InternalEObject) newFaultHandler)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__FAULT_HANDLER, null, msgs);
			msgs = basicSetFaultHandler(newFaultHandler, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__FAULT_HANDLER, newFaultHandler,
					newFaultHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromParts getFromParts() {
		return fromParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFromParts(FromParts newFromParts,
			NotificationChain msgs) {
		FromParts oldFromParts = fromParts;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFromParts, newFromParts);
		}
		fromParts = newFromParts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.INVOKE__FROM_PARTS,
					oldFromParts, newFromParts);
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
	public void setFromParts(FromParts newFromParts) {
		if (newFromParts != fromParts) {
			NotificationChain msgs = null;
			if (fromParts != null)
				msgs = ((InternalEObject) fromParts)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__FROM_PARTS, null, msgs);
			if (newFromParts != null)
				msgs = ((InternalEObject) newFromParts)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__FROM_PARTS, null, msgs);
			msgs = basicSetFromParts(newFromParts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__FROM_PARTS, newFromParts, newFromParts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToParts getToParts() {
		return toParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetToParts(ToParts newToParts,
			NotificationChain msgs) {
		ToParts oldToParts = toParts;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldToParts, newToParts);
		}
		toParts = newToParts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.INVOKE__TO_PARTS, oldToParts,
					newToParts);
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
	public void setToParts(ToParts newToParts) {
		if (newToParts != toParts) {
			NotificationChain msgs = null;
			if (toParts != null)
				msgs = ((InternalEObject) toParts).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.INVOKE__TO_PARTS,
						null, msgs);
			if (newToParts != null)
				msgs = ((InternalEObject) newToParts).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.INVOKE__TO_PARTS,
						null, msgs);
			msgs = basicSetToParts(newToParts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__TO_PARTS, newToParts, newToParts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureHandling getFailureHandling() {
		return failureHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	// JIRA Tools-785
	public NotificationChain basicSetFailureHandling(
			FailureHandling newFailureHandling, NotificationChain msgs) {
		FailureHandling oldFailureHandling = failureHandling;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFailureHandling,
					newFailureHandling);
		}
		failureHandling = newFailureHandling;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.INVOKE__FAILURE_HANDLING,
					oldFailureHandling, newFailureHandling);
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
	public void setFailureHandling(FailureHandling newFailureHandling) {
		if (newFailureHandling != failureHandling) {
			NotificationChain msgs = null;
			if (failureHandling != null)
				msgs = ((InternalEObject) failureHandling).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__FAILURE_HANDLING, null,
						msgs);
			if (newFailureHandling != null)
				msgs = ((InternalEObject) newFailureHandling).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.INVOKE__FAILURE_HANDLING, null,
						msgs);
			msgs = basicSetFailureHandling(newFailureHandling, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.INVOKE__FAILURE_HANDLING, newFailureHandling,
					newFailureHandling));
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
		case BPELPackage.INVOKE__COMPENSATION_HANDLER:
			return basicSetCompensationHandler(null, msgs);
		case BPELPackage.INVOKE__FAULT_HANDLER:
			return basicSetFaultHandler(null, msgs);
		case BPELPackage.INVOKE__FROM_PARTS:
			return basicSetFromParts(null, msgs);
		case BPELPackage.INVOKE__TO_PARTS:
			return basicSetToParts(null, msgs);
		case BPELPackage.INVOKE__FAILURE_HANDLING:
			return basicSetFailureHandling(null, msgs);
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
		case BPELPackage.INVOKE__OUTPUT_VARIABLE:
			if (resolve)
				return getOutputVariable();
			return basicGetOutputVariable();
		case BPELPackage.INVOKE__INPUT_VARIABLE:
			if (resolve)
				return getInputVariable();
			return basicGetInputVariable();
		case BPELPackage.INVOKE__COMPENSATION_HANDLER:
			return getCompensationHandler();
		case BPELPackage.INVOKE__FAULT_HANDLER:
			return getFaultHandler();
		case BPELPackage.INVOKE__FROM_PARTS:
			return getFromParts();
		case BPELPackage.INVOKE__TO_PARTS:
			return getToParts();
		case BPELPackage.INVOKE__FAILURE_HANDLING:
			return getFailureHandling();
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
		case BPELPackage.INVOKE__OUTPUT_VARIABLE:
			setOutputVariable((Variable) newValue);
			return;
		case BPELPackage.INVOKE__INPUT_VARIABLE:
			setInputVariable((Variable) newValue);
			return;
		case BPELPackage.INVOKE__COMPENSATION_HANDLER:
			setCompensationHandler((CompensationHandler) newValue);
			return;
		case BPELPackage.INVOKE__FAULT_HANDLER:
			setFaultHandler((FaultHandler) newValue);
			return;
		case BPELPackage.INVOKE__FROM_PARTS:
			setFromParts((FromParts) newValue);
			return;
		case BPELPackage.INVOKE__TO_PARTS:
			setToParts((ToParts) newValue);
			return;
		case BPELPackage.INVOKE__FAILURE_HANDLING:
			setFailureHandling((FailureHandling) newValue);
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
		case BPELPackage.INVOKE__OUTPUT_VARIABLE:
			setOutputVariable((Variable) null);
			return;
		case BPELPackage.INVOKE__INPUT_VARIABLE:
			setInputVariable((Variable) null);
			return;
		case BPELPackage.INVOKE__COMPENSATION_HANDLER:
			setCompensationHandler((CompensationHandler) null);
			return;
		case BPELPackage.INVOKE__FAULT_HANDLER:
			setFaultHandler((FaultHandler) null);
			return;
		case BPELPackage.INVOKE__FROM_PARTS:
			setFromParts((FromParts) null);
			return;
		case BPELPackage.INVOKE__TO_PARTS:
			setToParts((ToParts) null);
			return;
		case BPELPackage.INVOKE__FAILURE_HANDLING:
			setFailureHandling((FailureHandling) null);
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
		case BPELPackage.INVOKE__OUTPUT_VARIABLE:
			return outputVariable != null;
		case BPELPackage.INVOKE__INPUT_VARIABLE:
			return inputVariable != null;
		case BPELPackage.INVOKE__COMPENSATION_HANDLER:
			return compensationHandler != null;
		case BPELPackage.INVOKE__FAULT_HANDLER:
			return faultHandler != null;
		case BPELPackage.INVOKE__FROM_PARTS:
			return fromParts != null;
		case BPELPackage.INVOKE__TO_PARTS:
			return toParts != null;
		case BPELPackage.INVOKE__FAILURE_HANDLING:
			return failureHandling != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EList getWSDLContents() {
		// TODO: (DU) It's a hack to make children of FaultHandler to be found
		// by
		// WSDLNodeAssociationProvider.getModelObjectHelper() when
		// looking up EMF object from DOM element
		if (faultHandler == null) {
			return super.getWSDLContents();
		} else {
			EList result = new BasicEList();
			result.addAll(super.getWSDLContents());
			result.addAll(((FaultHandlerImpl) faultHandler).getWSDLContents());
			return result;
		}
	}

} // InvokeImpl
