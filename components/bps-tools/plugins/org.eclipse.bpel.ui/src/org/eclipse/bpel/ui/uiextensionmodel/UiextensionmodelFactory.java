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
 * $Id: UiextensionmodelFactory.java,v 1.2 2007/08/09 02:02:14 mchmielewski Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage
 * @generated
 */
public interface UiextensionmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiextensionmodelFactory eINSTANCE = org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Activity Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Extension</em>'.
	 * @generated
	 */
	ActivityExtension createActivityExtension();

	/**
	 * Returns a new object of class '<em>Case Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Extension</em>'.
	 * @generated
	 */
	CaseExtension createCaseExtension();

	/**
	 * Returns a new object of class '<em>Copy Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copy Extension</em>'.
	 * @generated
	 */
	CopyExtension createCopyExtension();

	/**
	 * Returns a new object of class '<em>End Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Node</em>'.
	 * @generated
	 */
	EndNode createEndNode();

	/**
	 * Returns a new object of class '<em>Link Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Extension</em>'.
	 * @generated
	 */
	LinkExtension createLinkExtension();

	/**
	 * Returns a new object of class '<em>On Alarm Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Alarm Extension</em>'.
	 * @generated
	 */
	OnAlarmExtension createOnAlarmExtension();

	/**
	 * Returns a new object of class '<em>On Event Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Event Extension</em>'.
	 * @generated
	 */
	OnEventExtension createOnEventExtension();

	/**
	 * Returns a new object of class '<em>On Message Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Message Extension</em>'.
	 * @generated
	 */
	OnMessageExtension createOnMessageExtension();

	/**
	 * Returns a new object of class '<em>Partner Link Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partner Link Extension</em>'.
	 * @generated
	 */
	PartnerLinkExtension createPartnerLinkExtension();

	/**
	 * Returns a new object of class '<em>Process Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Extension</em>'.
	 * @generated
	 */
	ProcessExtension createProcessExtension();

	/**
	 * Returns a new object of class '<em>Reference Partner Links</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Partner Links</em>'.
	 * @generated
	 */
	ReferencePartnerLinks createReferencePartnerLinks();

	/**
	 * Returns a new object of class '<em>Start Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Node</em>'.
	 * @generated
	 */
	StartNode createStartNode();

	/**
	 * Returns a new object of class '<em>Variable Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Extension</em>'.
	 * @generated
	 */
	VariableExtension createVariableExtension();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UiextensionmodelPackage getUiextensionmodelPackage();

} //UiextensionmodelFactory
