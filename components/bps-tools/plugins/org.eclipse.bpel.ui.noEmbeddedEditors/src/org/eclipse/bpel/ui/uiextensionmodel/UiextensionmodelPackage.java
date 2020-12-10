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
 * $Id: UiextensionmodelPackage.java,v 1.2 2007/08/09 02:02:14 mchmielewski Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory
 * @model kind="package"
 * @generated
 */
public interface UiextensionmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uiextensionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/bpel/ui/uiextensionmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.bpel.ui.uiextensionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiextensionmodelPackage eINSTANCE = org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ActivityExtensionImpl <em>Activity Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.ActivityExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getActivityExtension()
	 * @generated
	 */
	int ACTIVITY_EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EXTENSION__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EXTENSION__Y = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EXTENSION__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EXTENSION__HEIGHT = 3;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EXTENSION__IMPLICIT = 4;

	/**
	 * The number of structural features of the '<em>Activity Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EXTENSION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.CaseExtensionImpl <em>Case Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.CaseExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getCaseExtension()
	 * @generated
	 */
	int CASE_EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXTENSION__DISPLAY_NAME = 0;

	/**
	 * The number of structural features of the '<em>Case Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXTENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.CopyExtensionImpl <em>Copy Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.CopyExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getCopyExtension()
	 * @generated
	 */
	int COPY_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>From Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_EXTENSION__FROM_TYPE = 0;

	/**
	 * The feature id for the '<em><b>To Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_EXTENSION__TO_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Copy Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_EXTENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.EndNodeImpl <em>End Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.EndNodeImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getEndNode()
	 * @generated
	 */
	int END_NODE = 3;

	/**
	 * The number of structural features of the '<em>End Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.LinkExtensionImpl <em>Link Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.LinkExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getLinkExtension()
	 * @generated
	 */
	int LINK_EXTENSION = 4;

	/**
	 * The number of structural features of the '<em>Link Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EXTENSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.OnAlarmExtensionImpl <em>On Alarm Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.OnAlarmExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getOnAlarmExtension()
	 * @generated
	 */
	int ON_ALARM_EXTENSION = 5;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_ALARM_EXTENSION__DISPLAY_NAME = 0;

	/**
	 * The number of structural features of the '<em>On Alarm Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_ALARM_EXTENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.OnEventExtensionImpl <em>On Event Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.OnEventExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getOnEventExtension()
	 * @generated
	 */
	int ON_EVENT_EXTENSION = 6;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_EVENT_EXTENSION__DISPLAY_NAME = 0;

	/**
	 * The number of structural features of the '<em>On Event Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_EVENT_EXTENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.OnMessageExtensionImpl <em>On Message Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.OnMessageExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getOnMessageExtension()
	 * @generated
	 */
	int ON_MESSAGE_EXTENSION = 7;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_MESSAGE_EXTENSION__DISPLAY_NAME = 0;

	/**
	 * The number of structural features of the '<em>On Message Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_MESSAGE_EXTENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.PartnerLinkExtensionImpl <em>Partner Link Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.PartnerLinkExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getPartnerLinkExtension()
	 * @generated
	 */
	int PARTNER_LINK_EXTENSION = 8;

	/**
	 * The feature id for the '<em><b>Partner Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_LINK_EXTENSION__PARTNER_KIND = 0;

	/**
	 * The number of structural features of the '<em>Partner Link Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_LINK_EXTENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ProcessExtensionImpl <em>Process Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.ProcessExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getProcessExtension()
	 * @generated
	 */
	int PROCESS_EXTENSION = 9;

	/**
	 * The feature id for the '<em><b>Spec Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXTENSION__SPEC_COMPLIANT = 0;

	/**
	 * The feature id for the '<em><b>Modification Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXTENSION__MODIFICATION_STAMP = 1;

	/**
	 * The number of structural features of the '<em>Process Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXTENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ReferencePartnerLinksImpl <em>Reference Partner Links</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.ReferencePartnerLinksImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getReferencePartnerLinks()
	 * @generated
	 */
	int REFERENCE_PARTNER_LINKS = 10;

	/**
	 * The number of structural features of the '<em>Reference Partner Links</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PARTNER_LINKS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.StartNodeImpl <em>Start Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.StartNodeImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getStartNode()
	 * @generated
	 */
	int START_NODE = 11;

	/**
	 * The number of structural features of the '<em>Start Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_NODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.VariableExtensionImpl <em>Variable Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.VariableExtensionImpl
	 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getVariableExtension()
	 * @generated
	 */
	int VARIABLE_EXTENSION = 12;

	/**
	 * The feature id for the '<em><b>Advanced Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXTENSION__ADVANCED_KIND = 0;

	/**
	 * The feature id for the '<em><b>Variable Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXTENSION__VARIABLE_KIND = 1;

	/**
	 * The number of structural features of the '<em>Variable Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXTENSION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension <em>Activity Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension
	 * @generated
	 */
	EClass getActivityExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getX()
	 * @see #getActivityExtension()
	 * @generated
	 */
	EAttribute getActivityExtension_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getY()
	 * @see #getActivityExtension()
	 * @generated
	 */
	EAttribute getActivityExtension_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getWidth()
	 * @see #getActivityExtension()
	 * @generated
	 */
	EAttribute getActivityExtension_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getHeight()
	 * @see #getActivityExtension()
	 * @generated
	 */
	EAttribute getActivityExtension_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#isImplicit()
	 * @see #getActivityExtension()
	 * @generated
	 */
	EAttribute getActivityExtension_Implicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.CaseExtension <em>Case Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CaseExtension
	 * @generated
	 */
	EClass getCaseExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.CaseExtension#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CaseExtension#getDisplayName()
	 * @see #getCaseExtension()
	 * @generated
	 */
	EAttribute getCaseExtension_DisplayName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.CopyExtension <em>Copy Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copy Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CopyExtension
	 * @generated
	 */
	EClass getCopyExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.CopyExtension#getFromType <em>From Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Type</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CopyExtension#getFromType()
	 * @see #getCopyExtension()
	 * @generated
	 */
	EAttribute getCopyExtension_FromType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.CopyExtension#getToType <em>To Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Type</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.CopyExtension#getToType()
	 * @see #getCopyExtension()
	 * @generated
	 */
	EAttribute getCopyExtension_ToType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.EndNode <em>End Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Node</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.EndNode
	 * @generated
	 */
	EClass getEndNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.LinkExtension <em>Link Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.LinkExtension
	 * @generated
	 */
	EClass getLinkExtension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension <em>On Alarm Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On Alarm Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension
	 * @generated
	 */
	EClass getOnAlarmExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension#getDisplayName()
	 * @see #getOnAlarmExtension()
	 * @generated
	 */
	EAttribute getOnAlarmExtension_DisplayName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension <em>On Event Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On Event Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension
	 * @generated
	 */
	EClass getOnEventExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension#getDisplayName()
	 * @see #getOnEventExtension()
	 * @generated
	 */
	EAttribute getOnEventExtension_DisplayName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension <em>On Message Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On Message Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension
	 * @generated
	 */
	EClass getOnMessageExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension#getDisplayName()
	 * @see #getOnMessageExtension()
	 * @generated
	 */
	EAttribute getOnMessageExtension_DisplayName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension <em>Partner Link Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partner Link Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension
	 * @generated
	 */
	EClass getPartnerLinkExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension#getPartnerKind <em>Partner Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Kind</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension#getPartnerKind()
	 * @see #getPartnerLinkExtension()
	 * @generated
	 */
	EAttribute getPartnerLinkExtension_PartnerKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension <em>Process Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension
	 * @generated
	 */
	EClass getProcessExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension#isSpecCompliant <em>Spec Compliant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spec Compliant</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension#isSpecCompliant()
	 * @see #getProcessExtension()
	 * @generated
	 */
	EAttribute getProcessExtension_SpecCompliant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension#getModificationStamp <em>Modification Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modification Stamp</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension#getModificationStamp()
	 * @see #getProcessExtension()
	 * @generated
	 */
	EAttribute getProcessExtension_ModificationStamp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks <em>Reference Partner Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Partner Links</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks
	 * @generated
	 */
	EClass getReferencePartnerLinks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.StartNode <em>Start Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Node</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.StartNode
	 * @generated
	 */
	EClass getStartNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.ui.uiextensionmodel.VariableExtension <em>Variable Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Extension</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.VariableExtension
	 * @generated
	 */
	EClass getVariableExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.VariableExtension#getAdvancedKind <em>Advanced Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Advanced Kind</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.VariableExtension#getAdvancedKind()
	 * @see #getVariableExtension()
	 * @generated
	 */
	EAttribute getVariableExtension_AdvancedKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.ui.uiextensionmodel.VariableExtension#getVariableKind <em>Variable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Kind</em>'.
	 * @see org.eclipse.bpel.ui.uiextensionmodel.VariableExtension#getVariableKind()
	 * @see #getVariableExtension()
	 * @generated
	 */
	EAttribute getVariableExtension_VariableKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UiextensionmodelFactory getUiextensionmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ActivityExtensionImpl <em>Activity Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.ActivityExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getActivityExtension()
		 * @generated
		 */
		EClass ACTIVITY_EXTENSION = eINSTANCE.getActivityExtension();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_EXTENSION__X = eINSTANCE.getActivityExtension_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_EXTENSION__Y = eINSTANCE.getActivityExtension_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_EXTENSION__WIDTH = eINSTANCE.getActivityExtension_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_EXTENSION__HEIGHT = eINSTANCE.getActivityExtension_Height();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_EXTENSION__IMPLICIT = eINSTANCE.getActivityExtension_Implicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.CaseExtensionImpl <em>Case Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.CaseExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getCaseExtension()
		 * @generated
		 */
		EClass CASE_EXTENSION = eINSTANCE.getCaseExtension();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_EXTENSION__DISPLAY_NAME = eINSTANCE.getCaseExtension_DisplayName();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.CopyExtensionImpl <em>Copy Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.CopyExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getCopyExtension()
		 * @generated
		 */
		EClass COPY_EXTENSION = eINSTANCE.getCopyExtension();

		/**
		 * The meta object literal for the '<em><b>From Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_EXTENSION__FROM_TYPE = eINSTANCE.getCopyExtension_FromType();

		/**
		 * The meta object literal for the '<em><b>To Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_EXTENSION__TO_TYPE = eINSTANCE.getCopyExtension_ToType();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.EndNodeImpl <em>End Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.EndNodeImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getEndNode()
		 * @generated
		 */
		EClass END_NODE = eINSTANCE.getEndNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.LinkExtensionImpl <em>Link Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.LinkExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getLinkExtension()
		 * @generated
		 */
		EClass LINK_EXTENSION = eINSTANCE.getLinkExtension();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.OnAlarmExtensionImpl <em>On Alarm Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.OnAlarmExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getOnAlarmExtension()
		 * @generated
		 */
		EClass ON_ALARM_EXTENSION = eINSTANCE.getOnAlarmExtension();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_ALARM_EXTENSION__DISPLAY_NAME = eINSTANCE.getOnAlarmExtension_DisplayName();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.OnEventExtensionImpl <em>On Event Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.OnEventExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getOnEventExtension()
		 * @generated
		 */
		EClass ON_EVENT_EXTENSION = eINSTANCE.getOnEventExtension();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_EVENT_EXTENSION__DISPLAY_NAME = eINSTANCE.getOnEventExtension_DisplayName();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.OnMessageExtensionImpl <em>On Message Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.OnMessageExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getOnMessageExtension()
		 * @generated
		 */
		EClass ON_MESSAGE_EXTENSION = eINSTANCE.getOnMessageExtension();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_MESSAGE_EXTENSION__DISPLAY_NAME = eINSTANCE.getOnMessageExtension_DisplayName();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.PartnerLinkExtensionImpl <em>Partner Link Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.PartnerLinkExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getPartnerLinkExtension()
		 * @generated
		 */
		EClass PARTNER_LINK_EXTENSION = eINSTANCE.getPartnerLinkExtension();

		/**
		 * The meta object literal for the '<em><b>Partner Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTNER_LINK_EXTENSION__PARTNER_KIND = eINSTANCE.getPartnerLinkExtension_PartnerKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ProcessExtensionImpl <em>Process Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.ProcessExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getProcessExtension()
		 * @generated
		 */
		EClass PROCESS_EXTENSION = eINSTANCE.getProcessExtension();

		/**
		 * The meta object literal for the '<em><b>Spec Compliant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_EXTENSION__SPEC_COMPLIANT = eINSTANCE.getProcessExtension_SpecCompliant();

		/**
		 * The meta object literal for the '<em><b>Modification Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_EXTENSION__MODIFICATION_STAMP = eINSTANCE.getProcessExtension_ModificationStamp();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ReferencePartnerLinksImpl <em>Reference Partner Links</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.ReferencePartnerLinksImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getReferencePartnerLinks()
		 * @generated
		 */
		EClass REFERENCE_PARTNER_LINKS = eINSTANCE.getReferencePartnerLinks();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.StartNodeImpl <em>Start Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.StartNodeImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getStartNode()
		 * @generated
		 */
		EClass START_NODE = eINSTANCE.getStartNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.ui.uiextensionmodel.impl.VariableExtensionImpl <em>Variable Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.VariableExtensionImpl
		 * @see org.eclipse.bpel.ui.uiextensionmodel.impl.UiextensionmodelPackageImpl#getVariableExtension()
		 * @generated
		 */
		EClass VARIABLE_EXTENSION = eINSTANCE.getVariableExtension();

		/**
		 * The meta object literal for the '<em><b>Advanced Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_EXTENSION__ADVANCED_KIND = eINSTANCE.getVariableExtension_AdvancedKind();

		/**
		 * The meta object literal for the '<em><b>Variable Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_EXTENSION__VARIABLE_KIND = eINSTANCE.getVariableExtension_VariableKind();

	}

} //UiextensionmodelPackage
