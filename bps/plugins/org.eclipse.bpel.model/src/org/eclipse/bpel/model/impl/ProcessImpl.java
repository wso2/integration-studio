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
 */
package org.eclipse.bpel.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getTargetNamespace <em>Target Namespace</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getVariableAccessSerializable <em>Variable Access Serializable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getPartnerLinks <em>Partner Links</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getFaultHandlers <em>Fault Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getEventHandlers <em>Event Handlers</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getExitOnStandardFault <em>Exit On Standard Fault</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getMessageExchanges <em>Message Exchanges</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ProcessImpl#getAbstractProcessProfile <em>Abstract Process Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessImpl extends BPELExtensibleElementImpl implements
		org.eclipse.bpel.model.Process {
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
	 * The default value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_LANGUAGE_EDEFAULT = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0";

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
	 * This is true if the Query Language attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean queryLanguageESet;

	/**
	 * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_LANGUAGE_EDEFAULT = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0";

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
	 * This is true if the Expression Language attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean expressionLanguageESet;

	/**
	 * The default value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SUPPRESS_JOIN_FAILURE_EDEFAULT = Boolean.FALSE;

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
	 * The default value of the '{@link #getVariableAccessSerializable() <em>Variable Access Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAccessSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getVariableAccessSerializable() <em>Variable Access Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAccessSerializable()
	 * @generated
	 * @ordered
	 */
	protected Boolean variableAccessSerializable = VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT;

	/**
	 * This is true if the Variable Access Serializable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean variableAccessSerializableESet;

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
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected Variables variables;

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
	 * The cached value of the '{@link #getFaultHandlers() <em>Fault Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultHandlers()
	 * @generated
	 * @ordered
	 */
	protected FaultHandler faultHandlers;

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
	 * The cached value of the '{@link #getCorrelationSets() <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationSets()
	 * @generated
	 * @ordered
	 */
	protected CorrelationSets correlationSets;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected Extensions extensions;

	/**
	 * The default value of the '{@link #getExitOnStandardFault() <em>Exit On Standard Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitOnStandardFault()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean EXIT_ON_STANDARD_FAULT_EDEFAULT = Boolean.TRUE;

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
	 * The cached value of the '{@link #getMessageExchanges() <em>Message Exchanges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageExchanges()
	 * @generated
	 * @ordered
	 */
	protected MessageExchanges messageExchanges;

	/**
	 * The default value of the '{@link #getAbstractProcessProfile() <em>Abstract Process Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractProcessProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String ABSTRACT_PROCESS_PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbstractProcessProfile() <em>Abstract Process Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractProcessProfile()
	 * @generated
	 * @ordered
	 */
	protected String abstractProcessProfile = ABSTRACT_PROCESS_PROFILE_EDEFAULT;

	/**
	 * This is true if the Abstract Process Profile attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean abstractProcessProfileESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.PROCESS;
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
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, BPELConstants.AT_NAME,
					newName);
		}
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__NAME, oldName, name));
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
	 */
	public void setTargetNamespace(String newTargetNamespace) {
		String oldTargetNamespace = targetNamespace;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_TARGET_NAMESPACE, newTargetNamespace);
		}
		targetNamespace = newTargetNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__TARGET_NAMESPACE, oldTargetNamespace,
					targetNamespace));
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
	 */
	public void setQueryLanguage(String newQueryLanguage) {
		String oldQueryLanguage = queryLanguage;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_QUERYLANGUAGE, newQueryLanguage);
		}
		queryLanguage = newQueryLanguage;
		boolean oldQueryLanguageESet = queryLanguageESet;
		queryLanguageESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__QUERY_LANGUAGE, oldQueryLanguage,
					queryLanguage, !oldQueryLanguageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetQueryLanguage() {
		String oldQueryLanguage = queryLanguage;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_QUERYLANGUAGE, (String) null);
		}
		boolean oldQueryLanguageESet = queryLanguageESet;
		queryLanguage = QUERY_LANGUAGE_EDEFAULT;
		queryLanguageESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.PROCESS__QUERY_LANGUAGE, oldQueryLanguage,
					QUERY_LANGUAGE_EDEFAULT, oldQueryLanguageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQueryLanguage() {
		return queryLanguageESet;
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
	 */
	public void setExpressionLanguage(String newExpressionLanguage) {
		String oldExpressionLanguage = expressionLanguage;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_EXPRESSIONLANGUAGE, newExpressionLanguage);
		}
		expressionLanguage = newExpressionLanguage;
		boolean oldExpressionLanguageESet = expressionLanguageESet;
		expressionLanguageESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__EXPRESSION_LANGUAGE,
					oldExpressionLanguage, expressionLanguage,
					!oldExpressionLanguageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetExpressionLanguage() {
		String oldExpressionLanguage = expressionLanguage;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_EXPRESSIONLANGUAGE, (String) null);
		}
		boolean oldExpressionLanguageESet = expressionLanguageESet;
		expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;
		expressionLanguageESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.PROCESS__EXPRESSION_LANGUAGE,
					oldExpressionLanguage, EXPRESSION_LANGUAGE_EDEFAULT,
					oldExpressionLanguageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpressionLanguage() {
		return expressionLanguageESet;
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
		suppressJoinFailure = newSuppressJoinFailure;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUPPRESS_JOIN_FAILURE,
					BPELUtils.boolean2XML(newSuppressJoinFailure));
		}
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__SUPPRESS_JOIN_FAILURE,
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
					BPELPackage.PROCESS__SUPPRESS_JOIN_FAILURE,
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
	public Boolean getVariableAccessSerializable() {
		return variableAccessSerializable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setVariableAccessSerializable(
			Boolean newVariableAccessSerializable) {
		Boolean oldVariableAccessSerializable = variableAccessSerializable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_VARIABLE_ACCESS_SERIALIZABLE,
					BPELUtils.boolean2XML(newVariableAccessSerializable));
		}
		variableAccessSerializable = newVariableAccessSerializable;
		boolean oldVariableAccessSerializableESet = variableAccessSerializableESet;
		variableAccessSerializableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__VARIABLE_ACCESS_SERIALIZABLE,
					oldVariableAccessSerializable, variableAccessSerializable,
					!oldVariableAccessSerializableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetVariableAccessSerializable() {
		Boolean oldVariableAccessSerializable = variableAccessSerializable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_VARIABLE_ACCESS_SERIALIZABLE,
					(String) null);
		}
		boolean oldVariableAccessSerializableESet = variableAccessSerializableESet;
		variableAccessSerializable = VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT;
		variableAccessSerializableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.PROCESS__VARIABLE_ACCESS_SERIALIZABLE,
					oldVariableAccessSerializable,
					VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT,
					oldVariableAccessSerializableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVariableAccessSerializable() {
		return variableAccessSerializableESet;
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
					Notification.SET, BPELPackage.PROCESS__PARTNER_LINKS,
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
								- BPELPackage.PROCESS__PARTNER_LINKS, null,
						msgs);
			if (newPartnerLinks != null)
				msgs = ((InternalEObject) newPartnerLinks).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__PARTNER_LINKS, null,
						msgs);
			msgs = basicSetPartnerLinks(newPartnerLinks, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__PARTNER_LINKS, newPartnerLinks,
					newPartnerLinks));
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
					Notification.SET, BPELPackage.PROCESS__VARIABLES,
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
				msgs = ((InternalEObject) variables)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__VARIABLES, null, msgs);
			if (newVariables != null)
				msgs = ((InternalEObject) newVariables)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__VARIABLES, null, msgs);
			msgs = basicSetVariables(newVariables, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__VARIABLES, newVariables, newVariables));
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
					Notification.SET, BPELPackage.PROCESS__ACTIVITY,
					oldActivity, newActivity);
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
						EOPPOSITE_FEATURE_BASE - BPELPackage.PROCESS__ACTIVITY,
						null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.PROCESS__ACTIVITY,
						null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__ACTIVITY, newActivity, newActivity));
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
					Notification.SET, BPELPackage.PROCESS__FAULT_HANDLERS,
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
				msgs = ((InternalEObject) faultHandlers).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__FAULT_HANDLERS, null,
						msgs);
			if (newFaultHandlers != null)
				msgs = ((InternalEObject) newFaultHandlers).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__FAULT_HANDLERS, null,
						msgs);
			msgs = basicSetFaultHandlers(newFaultHandlers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__FAULT_HANDLERS, newFaultHandlers,
					newFaultHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extensions getExtensions() {
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetExtensions(Extensions newExtensions,
			NotificationChain msgs) {
		Extensions oldExtensions = extensions;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldExtensions,
					newExtensions);
		}
		extensions = newExtensions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.PROCESS__EXTENSIONS,
					oldExtensions, newExtensions);
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
	public void setExtensions(Extensions newExtensions) {
		if (newExtensions != extensions) {
			NotificationChain msgs = null;
			if (extensions != null)
				msgs = ((InternalEObject) extensions).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__EXTENSIONS, null, msgs);
			if (newExtensions != null)
				msgs = ((InternalEObject) newExtensions).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__EXTENSIONS, null, msgs);
			msgs = basicSetExtensions(newExtensions, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__EXTENSIONS, newExtensions,
					newExtensions));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__EXIT_ON_STANDARD_FAULT,
					oldExitOnStandardFault, exitOnStandardFault));
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
					Notification.SET, BPELPackage.PROCESS__MESSAGE_EXCHANGES,
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
	 */
	public void setMessageExchanges(MessageExchanges newMessageExchanges) {
		if (newMessageExchanges != messageExchanges) {
			NotificationChain msgs = null;
			if (messageExchanges != null)
				msgs = ((InternalEObject) messageExchanges).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__MESSAGE_EXCHANGES, null,
						msgs);
			if (newMessageExchanges != null)
				msgs = ((InternalEObject) newMessageExchanges).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__MESSAGE_EXCHANGES, null,
						msgs);
			msgs = basicSetMessageExchanges(newMessageExchanges, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__MESSAGE_EXCHANGES,
					newMessageExchanges, newMessageExchanges));
		//		MessageExchanges oldMessageExchanges = messageExchanges;
		//		if (!isReconciling) {
		//			ReconciliationHelper.replaceChild(this, oldMessageExchanges, newMessageExchanges);
		//		}
		//		messageExchanges = newMessageExchanges;
		//		if (eNotificationRequired())
		//			eNotify(new ENotificationImpl(this, Notification.SET,
		//					BPELPackage.PROCESS__MESSAGE_EXCHANGES,
		//					oldMessageExchanges, messageExchanges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbstractProcessProfile() {
		return abstractProcessProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setAbstractProcessProfile(String newAbstractProcessProfile) {
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_ABSTRACT_PROFILES,
					newAbstractProcessProfile);
		}
		String oldAbstractProcessProfile = abstractProcessProfile;
		abstractProcessProfile = newAbstractProcessProfile;
		boolean oldAbstractProcessProfileESet = abstractProcessProfileESet;
		abstractProcessProfileESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__ABSTRACT_PROCESS_PROFILE,
					oldAbstractProcessProfile, abstractProcessProfile,
					!oldAbstractProcessProfileESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetAbstractProcessProfile() {
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_ABSTRACT_PROFILES, (String) null);
		}
		String oldAbstractProcessProfile = abstractProcessProfile;
		boolean oldAbstractProcessProfileESet = abstractProcessProfileESet;
		abstractProcessProfile = ABSTRACT_PROCESS_PROFILE_EDEFAULT;
		abstractProcessProfileESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.PROCESS__ABSTRACT_PROCESS_PROFILE,
					oldAbstractProcessProfile,
					ABSTRACT_PROCESS_PROFILE_EDEFAULT,
					oldAbstractProcessProfileESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAbstractProcessProfile() {
		return abstractProcessProfileESet;
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
		case BPELPackage.PROCESS__PARTNER_LINKS:
			return basicSetPartnerLinks(null, msgs);
		case BPELPackage.PROCESS__VARIABLES:
			return basicSetVariables(null, msgs);
		case BPELPackage.PROCESS__ACTIVITY:
			return basicSetActivity(null, msgs);
		case BPELPackage.PROCESS__FAULT_HANDLERS:
			return basicSetFaultHandlers(null, msgs);
		case BPELPackage.PROCESS__EVENT_HANDLERS:
			return basicSetEventHandlers(null, msgs);
		case BPELPackage.PROCESS__CORRELATION_SETS:
			return basicSetCorrelationSets(null, msgs);
		case BPELPackage.PROCESS__IMPORTS:
			return ((InternalEList<?>) getImports())
					.basicRemove(otherEnd, msgs);
		case BPELPackage.PROCESS__EXTENSIONS:
			return basicSetExtensions(null, msgs);
		case BPELPackage.PROCESS__MESSAGE_EXCHANGES:
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
		case BPELPackage.PROCESS__NAME:
			return getName();
		case BPELPackage.PROCESS__TARGET_NAMESPACE:
			return getTargetNamespace();
		case BPELPackage.PROCESS__QUERY_LANGUAGE:
			return getQueryLanguage();
		case BPELPackage.PROCESS__EXPRESSION_LANGUAGE:
			return getExpressionLanguage();
		case BPELPackage.PROCESS__SUPPRESS_JOIN_FAILURE:
			return getSuppressJoinFailure();
		case BPELPackage.PROCESS__VARIABLE_ACCESS_SERIALIZABLE:
			return getVariableAccessSerializable();
		case BPELPackage.PROCESS__PARTNER_LINKS:
			return getPartnerLinks();
		case BPELPackage.PROCESS__VARIABLES:
			return getVariables();
		case BPELPackage.PROCESS__ACTIVITY:
			return getActivity();
		case BPELPackage.PROCESS__FAULT_HANDLERS:
			return getFaultHandlers();
		case BPELPackage.PROCESS__EVENT_HANDLERS:
			return getEventHandlers();
		case BPELPackage.PROCESS__CORRELATION_SETS:
			return getCorrelationSets();
		case BPELPackage.PROCESS__IMPORTS:
			return getImports();
		case BPELPackage.PROCESS__EXTENSIONS:
			return getExtensions();
		case BPELPackage.PROCESS__EXIT_ON_STANDARD_FAULT:
			return getExitOnStandardFault();
		case BPELPackage.PROCESS__MESSAGE_EXCHANGES:
			return getMessageExchanges();
		case BPELPackage.PROCESS__ABSTRACT_PROCESS_PROFILE:
			return getAbstractProcessProfile();
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
		case BPELPackage.PROCESS__NAME:
			setName((String) newValue);
			return;
		case BPELPackage.PROCESS__TARGET_NAMESPACE:
			setTargetNamespace((String) newValue);
			return;
		case BPELPackage.PROCESS__QUERY_LANGUAGE:
			setQueryLanguage((String) newValue);
			return;
		case BPELPackage.PROCESS__EXPRESSION_LANGUAGE:
			setExpressionLanguage((String) newValue);
			return;
		case BPELPackage.PROCESS__SUPPRESS_JOIN_FAILURE:
			setSuppressJoinFailure((Boolean) newValue);
			return;
		case BPELPackage.PROCESS__VARIABLE_ACCESS_SERIALIZABLE:
			setVariableAccessSerializable((Boolean) newValue);
			return;
		case BPELPackage.PROCESS__PARTNER_LINKS:
			setPartnerLinks((PartnerLinks) newValue);
			return;
		case BPELPackage.PROCESS__VARIABLES:
			setVariables((Variables) newValue);
			return;
		case BPELPackage.PROCESS__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.PROCESS__FAULT_HANDLERS:
			setFaultHandlers((FaultHandler) newValue);
			return;
		case BPELPackage.PROCESS__EVENT_HANDLERS:
			setEventHandlers((EventHandler) newValue);
			return;
		case BPELPackage.PROCESS__CORRELATION_SETS:
			setCorrelationSets((CorrelationSets) newValue);
			return;
		case BPELPackage.PROCESS__IMPORTS:
			getImports().clear();
			getImports().addAll((Collection<? extends Import>) newValue);
			return;
		case BPELPackage.PROCESS__EXTENSIONS:
			setExtensions((Extensions) newValue);
			return;
		case BPELPackage.PROCESS__EXIT_ON_STANDARD_FAULT:
			setExitOnStandardFault((Boolean) newValue);
			return;
		case BPELPackage.PROCESS__MESSAGE_EXCHANGES:
			setMessageExchanges((MessageExchanges) newValue);
			return;
		case BPELPackage.PROCESS__ABSTRACT_PROCESS_PROFILE:
			setAbstractProcessProfile((String) newValue);
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
		case BPELPackage.PROCESS__NAME:
			setName(NAME_EDEFAULT);
			return;
		case BPELPackage.PROCESS__TARGET_NAMESPACE:
			setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
			return;
		case BPELPackage.PROCESS__QUERY_LANGUAGE:
			unsetQueryLanguage();
			return;
		case BPELPackage.PROCESS__EXPRESSION_LANGUAGE:
			unsetExpressionLanguage();
			return;
		case BPELPackage.PROCESS__SUPPRESS_JOIN_FAILURE:
			unsetSuppressJoinFailure();
			return;
		case BPELPackage.PROCESS__VARIABLE_ACCESS_SERIALIZABLE:
			unsetVariableAccessSerializable();
			return;
		case BPELPackage.PROCESS__PARTNER_LINKS:
			setPartnerLinks((PartnerLinks) null);
			return;
		case BPELPackage.PROCESS__VARIABLES:
			setVariables((Variables) null);
			return;
		case BPELPackage.PROCESS__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.PROCESS__FAULT_HANDLERS:
			setFaultHandlers((FaultHandler) null);
			return;
		case BPELPackage.PROCESS__EVENT_HANDLERS:
			setEventHandlers((EventHandler) null);
			return;
		case BPELPackage.PROCESS__CORRELATION_SETS:
			setCorrelationSets((CorrelationSets) null);
			return;
		case BPELPackage.PROCESS__IMPORTS:
			getImports().clear();
			return;
		case BPELPackage.PROCESS__EXTENSIONS:
			setExtensions((Extensions) null);
			return;
		case BPELPackage.PROCESS__EXIT_ON_STANDARD_FAULT:
			setExitOnStandardFault(EXIT_ON_STANDARD_FAULT_EDEFAULT);
			return;
		case BPELPackage.PROCESS__MESSAGE_EXCHANGES:
			setMessageExchanges((MessageExchanges) null);
			return;
		case BPELPackage.PROCESS__ABSTRACT_PROCESS_PROFILE:
			unsetAbstractProcessProfile();
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
		case BPELPackage.PROCESS__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case BPELPackage.PROCESS__TARGET_NAMESPACE:
			return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null
					: !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
		case BPELPackage.PROCESS__QUERY_LANGUAGE:
			return isSetQueryLanguage();
		case BPELPackage.PROCESS__EXPRESSION_LANGUAGE:
			return isSetExpressionLanguage();
		case BPELPackage.PROCESS__SUPPRESS_JOIN_FAILURE:
			return isSetSuppressJoinFailure();
		case BPELPackage.PROCESS__VARIABLE_ACCESS_SERIALIZABLE:
			return isSetVariableAccessSerializable();
		case BPELPackage.PROCESS__PARTNER_LINKS:
			return partnerLinks != null;
		case BPELPackage.PROCESS__VARIABLES:
			return variables != null;
		case BPELPackage.PROCESS__ACTIVITY:
			return activity != null;
		case BPELPackage.PROCESS__FAULT_HANDLERS:
			return faultHandlers != null;
		case BPELPackage.PROCESS__EVENT_HANDLERS:
			return eventHandlers != null;
		case BPELPackage.PROCESS__CORRELATION_SETS:
			return correlationSets != null;
		case BPELPackage.PROCESS__IMPORTS:
			return imports != null && !imports.isEmpty();
		case BPELPackage.PROCESS__EXTENSIONS:
			return extensions != null;
		case BPELPackage.PROCESS__EXIT_ON_STANDARD_FAULT:
			return EXIT_ON_STANDARD_FAULT_EDEFAULT == null ? exitOnStandardFault != null
					: !EXIT_ON_STANDARD_FAULT_EDEFAULT
							.equals(exitOnStandardFault);
		case BPELPackage.PROCESS__MESSAGE_EXCHANGES:
			return messageExchanges != null;
		case BPELPackage.PROCESS__ABSTRACT_PROCESS_PROFILE:
			return isSetAbstractProcessProfile();
		}
		return super.eIsSet(featureID);
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
		eventHandlers = newEventHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.PROCESS__EVENT_HANDLERS,
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
				msgs = ((InternalEObject) eventHandlers).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__EVENT_HANDLERS, null,
						msgs);
			if (newEventHandlers != null)
				msgs = ((InternalEObject) newEventHandlers).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__EVENT_HANDLERS, null,
						msgs);
			msgs = basicSetEventHandlers(newEventHandlers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__EVENT_HANDLERS, newEventHandlers,
					newEventHandlers));
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
					Notification.SET, BPELPackage.PROCESS__CORRELATION_SETS,
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
								- BPELPackage.PROCESS__CORRELATION_SETS, null,
						msgs);
			if (newCorrelationSets != null)
				msgs = ((InternalEObject) newCorrelationSets).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PROCESS__CORRELATION_SETS, null,
						msgs);
			msgs = basicSetCorrelationSets(newCorrelationSets, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PROCESS__CORRELATION_SETS, newCorrelationSets,
					newCorrelationSets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this,
					BPELPackage.PROCESS__IMPORTS);
		}
		return imports;
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
		result.append(", targetNamespace: "); //$NON-NLS-1$
		result.append(targetNamespace);
		result.append(", queryLanguage: "); //$NON-NLS-1$
		if (queryLanguageESet)
			result.append(queryLanguage);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", expressionLanguage: "); //$NON-NLS-1$
		if (expressionLanguageESet)
			result.append(expressionLanguage);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", suppressJoinFailure: "); //$NON-NLS-1$
		if (suppressJoinFailureESet)
			result.append(suppressJoinFailure);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", variableAccessSerializable: "); //$NON-NLS-1$
		if (variableAccessSerializableESet)
			result.append(variableAccessSerializable);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", exitOnStandardFault: "); //$NON-NLS-1$
		result.append(exitOnStandardFault);
		result.append(", abstractProcessProfile: "); //$NON-NLS-1$
		if (abstractProcessProfileESet)
			result.append(abstractProcessProfile);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof Import) {
			ReconciliationHelper.adoptChild(this, imports, (Import) object,
					BPELConstants.ND_IMPORT);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof Import) {
			ReconciliationHelper.orphanChild(this, (Import) obj);
		}
		super.orphanContent(reference, obj);
	}

	/**
	 * @customized
	 */
	private List fieldPostLoadRunnables;

	/**
	 * @see org.eclipse.bpel.model.Process#getPostLoadRunnables()
	 * @customized
	 */
	public List getPostLoadRunnables() {
		if (fieldPostLoadRunnables == null)
			fieldPostLoadRunnables = new ArrayList();
		return fieldPostLoadRunnables;
	}

	//	public void reconcileAttributes(Element changedElement) {
	//		if (changedElement.hasAttribute(BPELConstants.AT_NAME)) {
	//			String name = changedElement.getAttribute(BPELConstants.AT_NAME);
	//			if (name != null) {
	//				setName(name);
	//			}
	//		} 
	//		if (changedElement.hasAttribute(BPELConstants.AT_SUPPRESS_JOIN_FAILURE)) {
	//			setSuppressJoinFailure(BPELUtils.xml2boolean(changedElement.getAttribute(BPELConstants.AT_SUPPRESS_JOIN_FAILURE)));
	//		} 
	//		if (changedElement.hasAttribute(BPELConstants.AT_TARGET_NAMESPACE)) {
	//			String nameSpace = changedElement.getAttribute(BPELConstants.AT_TARGET_NAMESPACE);
	//			if (nameSpace != null) {
	//				setTargetNamespace(nameSpace);
	//			}
	//		}
	//		if (changedElement.hasAttribute(BPELConstants.AT_QUERYLANGUAGE)) {
	//			String queryLanguage = changedElement.getAttribute(BPELConstants.AT_QUERYLANGUAGE);
	//			if (queryLanguage != null) {
	//				setQueryLanguage(queryLanguage);
	//			}
	//		}
	//		if (changedElement.hasAttribute(BPELConstants.AT_EXPRESSIONLANGUAGE)) {
	//			String expressionLanguage = changedElement.getAttribute(BPELConstants.AT_EXPRESSIONLANGUAGE);
	//			if (expressionLanguage != null) {
	//				setQueryLanguage(expressionLanguage);
	//			}
	//		}
	//		if (changedElement.hasAttribute(BPELConstants.AT_EXIT_ON_STANDARD_FAULT)) {
	//			setExitOnStandardFault(BPELUtils.xml2boolean(changedElement.getAttribute(BPELConstants.AT_EXIT_ON_STANDARD_FAULT)));
	//		}
	//		super.reconcileAttributes(changedElement);
	//	}
	//	
	//	protected void handleReconciliation(Collection remainingModelObjects) {
	//		for (Object o : remainingModelObjects) {
	//			if (o == activity) {
	//				setActivity(null);
	//			} else if (o == correlationSets) {
	//				setCorrelationSets(null);
	//			}
	//		}
	//	}	
	//
	//	public void handleUnreconciledElement(Element child, Collection remainingModelObjects) {
	//		Activity activity = ReconciliationHelper.createActivity(child);
	//		if (activity != null) {
	//			ReconciliationHelper.addActivity(this, activity);
	//		} else {
	//			super.handleUnreconciledElement(child, remainingModelObjects);
	//		}
	//	}

} //ProcessImpl
