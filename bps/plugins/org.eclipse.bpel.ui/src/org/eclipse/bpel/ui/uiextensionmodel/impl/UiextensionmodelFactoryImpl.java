/**
 * <copyright>
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: UiextensionmodelFactoryImpl.java,v 1.2 2007/08/09 02:02:13 mchmielewski Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.impl;

import org.eclipse.bpel.ui.uiextensionmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiextensionmodelFactoryImpl extends EFactoryImpl implements UiextensionmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UiextensionmodelFactory init() {
		try {
			UiextensionmodelFactory theUiextensionmodelFactory = (UiextensionmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/bpel/ui/uiextensionmodel.ecore"); 
			if (theUiextensionmodelFactory != null) {
				return theUiextensionmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UiextensionmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiextensionmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UiextensionmodelPackage.ACTIVITY_EXTENSION: return createActivityExtension();
			case UiextensionmodelPackage.CASE_EXTENSION: return createCaseExtension();
			case UiextensionmodelPackage.COPY_EXTENSION: return createCopyExtension();
			case UiextensionmodelPackage.END_NODE: return createEndNode();
			case UiextensionmodelPackage.LINK_EXTENSION: return createLinkExtension();
			case UiextensionmodelPackage.ON_ALARM_EXTENSION: return createOnAlarmExtension();
			case UiextensionmodelPackage.ON_EVENT_EXTENSION: return createOnEventExtension();
			case UiextensionmodelPackage.ON_MESSAGE_EXTENSION: return createOnMessageExtension();
			case UiextensionmodelPackage.PARTNER_LINK_EXTENSION: return createPartnerLinkExtension();
			case UiextensionmodelPackage.PROCESS_EXTENSION: return createProcessExtension();
			case UiextensionmodelPackage.REFERENCE_PARTNER_LINKS: return createReferencePartnerLinks();
			case UiextensionmodelPackage.START_NODE: return createStartNode();
			case UiextensionmodelPackage.VARIABLE_EXTENSION: return createVariableExtension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityExtension createActivityExtension() {
		ActivityExtensionImpl activityExtension = new ActivityExtensionImpl();
		return activityExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseExtension createCaseExtension() {
		CaseExtensionImpl caseExtension = new CaseExtensionImpl();
		return caseExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyExtension createCopyExtension() {
		CopyExtensionImpl copyExtension = new CopyExtensionImpl();
		return copyExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndNode createEndNode() {
		EndNodeImpl endNode = new EndNodeImpl();
		return endNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkExtension createLinkExtension() {
		LinkExtensionImpl linkExtension = new LinkExtensionImpl();
		return linkExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAlarmExtension createOnAlarmExtension() {
		OnAlarmExtensionImpl onAlarmExtension = new OnAlarmExtensionImpl();
		return onAlarmExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnEventExtension createOnEventExtension() {
		OnEventExtensionImpl onEventExtension = new OnEventExtensionImpl();
		return onEventExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnMessageExtension createOnMessageExtension() {
		OnMessageExtensionImpl onMessageExtension = new OnMessageExtensionImpl();
		return onMessageExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLinkExtension createPartnerLinkExtension() {
		PartnerLinkExtensionImpl partnerLinkExtension = new PartnerLinkExtensionImpl();
		return partnerLinkExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessExtension createProcessExtension() {
		ProcessExtensionImpl processExtension = new ProcessExtensionImpl();
		return processExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencePartnerLinks createReferencePartnerLinks() {
		ReferencePartnerLinksImpl referencePartnerLinks = new ReferencePartnerLinksImpl();
		return referencePartnerLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartNode createStartNode() {
		StartNodeImpl startNode = new StartNodeImpl();
		return startNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExtension createVariableExtension() {
		VariableExtensionImpl variableExtension = new VariableExtensionImpl();
		return variableExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiextensionmodelPackage getUiextensionmodelPackage() {
		return (UiextensionmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UiextensionmodelPackage getPackage() {
		return UiextensionmodelPackage.eINSTANCE;
	}

} //UiextensionmodelFactoryImpl
