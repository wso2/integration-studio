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
 * $Id: UiextensionmodelSwitch.java,v 1.2 2007/08/09 02:02:15 mchmielewski Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.util;

import java.util.List;

import org.eclipse.bpel.ui.uiextensionmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage
 * @generated
 */
public class UiextensionmodelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiextensionmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiextensionmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = UiextensionmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UiextensionmodelPackage.ACTIVITY_EXTENSION: {
				ActivityExtension activityExtension = (ActivityExtension)theEObject;
				T result = caseActivityExtension(activityExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.CASE_EXTENSION: {
				CaseExtension caseExtension = (CaseExtension)theEObject;
				T result = caseCaseExtension(caseExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.COPY_EXTENSION: {
				CopyExtension copyExtension = (CopyExtension)theEObject;
				T result = caseCopyExtension(copyExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.END_NODE: {
				EndNode endNode = (EndNode)theEObject;
				T result = caseEndNode(endNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.LINK_EXTENSION: {
				LinkExtension linkExtension = (LinkExtension)theEObject;
				T result = caseLinkExtension(linkExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.ON_ALARM_EXTENSION: {
				OnAlarmExtension onAlarmExtension = (OnAlarmExtension)theEObject;
				T result = caseOnAlarmExtension(onAlarmExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.ON_EVENT_EXTENSION: {
				OnEventExtension onEventExtension = (OnEventExtension)theEObject;
				T result = caseOnEventExtension(onEventExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.ON_MESSAGE_EXTENSION: {
				OnMessageExtension onMessageExtension = (OnMessageExtension)theEObject;
				T result = caseOnMessageExtension(onMessageExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.PARTNER_LINK_EXTENSION: {
				PartnerLinkExtension partnerLinkExtension = (PartnerLinkExtension)theEObject;
				T result = casePartnerLinkExtension(partnerLinkExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.PROCESS_EXTENSION: {
				ProcessExtension processExtension = (ProcessExtension)theEObject;
				T result = caseProcessExtension(processExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.REFERENCE_PARTNER_LINKS: {
				ReferencePartnerLinks referencePartnerLinks = (ReferencePartnerLinks)theEObject;
				T result = caseReferencePartnerLinks(referencePartnerLinks);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.START_NODE: {
				StartNode startNode = (StartNode)theEObject;
				T result = caseStartNode(startNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiextensionmodelPackage.VARIABLE_EXTENSION: {
				VariableExtension variableExtension = (VariableExtension)theEObject;
				T result = caseVariableExtension(variableExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityExtension(ActivityExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseExtension(CaseExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Copy Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Copy Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCopyExtension(CopyExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndNode(EndNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkExtension(LinkExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Alarm Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Alarm Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnAlarmExtension(OnAlarmExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Event Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Event Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnEventExtension(OnEventExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Message Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Message Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnMessageExtension(OnMessageExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partner Link Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Link Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerLinkExtension(PartnerLinkExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessExtension(ProcessExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Partner Links</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Partner Links</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencePartnerLinks(ReferencePartnerLinks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartNode(StartNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExtension(VariableExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //UiextensionmodelSwitch
