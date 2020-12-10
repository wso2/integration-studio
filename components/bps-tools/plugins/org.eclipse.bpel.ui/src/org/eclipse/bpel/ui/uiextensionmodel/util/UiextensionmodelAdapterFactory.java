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
 * $Id: UiextensionmodelAdapterFactory.java,v 1.2 2007/08/09 02:02:15 mchmielewski Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.util;

import org.eclipse.bpel.ui.uiextensionmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage
 * @generated
 */
public class UiextensionmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiextensionmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiextensionmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UiextensionmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UiextensionmodelSwitch<Adapter> modelSwitch =
		new UiextensionmodelSwitch<Adapter>() {
			@Override
			public Adapter caseActivityExtension(ActivityExtension object) {
				return createActivityExtensionAdapter();
			}
			@Override
			public Adapter caseCaseExtension(CaseExtension object) {
				return createCaseExtensionAdapter();
			}
			@Override
			public Adapter caseCopyExtension(CopyExtension object) {
				return createCopyExtensionAdapter();
			}
			@Override
			public Adapter caseEndNode(EndNode object) {
				return createEndNodeAdapter();
			}
			@Override
			public Adapter caseLinkExtension(LinkExtension object) {
				return createLinkExtensionAdapter();
			}
			@Override
			public Adapter caseOnAlarmExtension(OnAlarmExtension object) {
				return createOnAlarmExtensionAdapter();
			}
			@Override
			public Adapter caseOnEventExtension(OnEventExtension object) {
				return createOnEventExtensionAdapter();
			}
			@Override
			public Adapter caseOnMessageExtension(OnMessageExtension object) {
				return createOnMessageExtensionAdapter();
			}
			@Override
			public Adapter casePartnerLinkExtension(PartnerLinkExtension object) {
				return createPartnerLinkExtensionAdapter();
			}
			@Override
			public Adapter caseProcessExtension(ProcessExtension object) {
				return createProcessExtensionAdapter();
			}
			@Override
			public Adapter caseReferencePartnerLinks(ReferencePartnerLinks object) {
				return createReferencePartnerLinksAdapter();
			}
			@Override
			public Adapter caseStartNode(StartNode object) {
				return createStartNodeAdapter();
			}
			@Override
			public Adapter caseVariableExtension(VariableExtension object) {
				return createVariableExtensionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension <em>Activity Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension
	 * @generated
	 */
	public Adapter createActivityExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.CaseExtension <em>Case Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CaseExtension
	 * @generated
	 */
	public Adapter createCaseExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.CopyExtension <em>Copy Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CopyExtension
	 * @generated
	 */
	public Adapter createCopyExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.EndNode <em>End Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.EndNode
	 * @generated
	 */
	public Adapter createEndNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.LinkExtension <em>Link Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.LinkExtension
	 * @generated
	 */
	public Adapter createLinkExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension <em>On Alarm Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension
	 * @generated
	 */
	public Adapter createOnAlarmExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension <em>On Event Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension
	 * @generated
	 */
	public Adapter createOnEventExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension <em>On Message Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension
	 * @generated
	 */
	public Adapter createOnMessageExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension <em>Partner Link Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension
	 * @generated
	 */
	public Adapter createPartnerLinkExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension <em>Process Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension
	 * @generated
	 */
	public Adapter createProcessExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks <em>Reference Partner Links</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks
	 * @generated
	 */
	public Adapter createReferencePartnerLinksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.StartNode <em>Start Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.StartNode
	 * @generated
	 */
	public Adapter createStartNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.ui.uiextensionmodel.VariableExtension <em>Variable Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.VariableExtension
	 * @generated
	 */
	public Adapter createVariableExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UiextensionmodelAdapterFactory
