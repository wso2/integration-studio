/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.wso2.developerstudio.bpel.humantask.model.util;

import java.util.List;

import javax.wsdl.extensions.AttributeExtensible;
import javax.wsdl.extensions.ElementExtensible;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.ExtensionActivity;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.wst.wsdl.ExtensibleElement;
import org.eclipse.wst.wsdl.WSDLElement;


import org.wso2.developerstudio.bpel.humantask.model.*;
import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;

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
 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
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
			case ModelPackage.PEOPLE_ACTIVITY_RT: {
				PeopleActivityRT peopleActivityRT = (PeopleActivityRT)theEObject;
				T result = casePeopleActivityRT(peopleActivityRT);
				if (result == null) result = caseExtensionActivity(peopleActivityRT);
				if (result == null) result = caseExtensionElement(peopleActivityRT);
				if (result == null) result = caseActivity(peopleActivityRT);
				if (result == null) result = caseBPELExtensibleElement(peopleActivityRT);
				if (result == null) result = caseExtensibleElement(peopleActivityRT);
				if (result == null) result = caseWSDLElement(peopleActivityRT);
				if (result == null) result = caseIElementExtensible(peopleActivityRT);
				if (result == null) result = caseIAttributeExtensible(peopleActivityRT);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PEOPLE_ACTIVITY_RN: {
				PeopleActivityRN peopleActivityRN = (PeopleActivityRN)theEObject;
				T result = casePeopleActivityRN(peopleActivityRN);
				if (result == null) result = caseExtensionActivity(peopleActivityRN);
				if (result == null) result = caseExtensionElement(peopleActivityRN);
				if (result == null) result = caseActivity(peopleActivityRN);
				if (result == null) result = caseBPELExtensibleElement(peopleActivityRN);
				if (result == null) result = caseExtensibleElement(peopleActivityRN);
				if (result == null) result = caseWSDLElement(peopleActivityRN);
				if (result == null) result = caseIElementExtensible(peopleActivityRN);
				if (result == null) result = caseIAttributeExtensible(peopleActivityRN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.REMOTE_TASK: {
				RemoteTask remoteTask = (RemoteTask)theEObject;
				T result = caseRemoteTask(remoteTask);
				if (result == null) result = caseExtensionElement(remoteTask);
				if (result == null) result = caseBPELExtensibleElement(remoteTask);
				if (result == null) result = caseExtensibleElement(remoteTask);
				if (result == null) result = caseWSDLElement(remoteTask);
				if (result == null) result = caseIElementExtensible(remoteTask);
				if (result == null) result = caseIAttributeExtensible(remoteTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.REMOTE_NOTIFICATION: {
				RemoteNotification remoteNotification = (RemoteNotification)theEObject;
				T result = caseRemoteNotification(remoteNotification);
				if (result == null) result = caseExtensionElement(remoteNotification);
				if (result == null) result = caseBPELExtensibleElement(remoteNotification);
				if (result == null) result = caseExtensibleElement(remoteNotification);
				if (result == null) result = caseWSDLElement(remoteNotification);
				if (result == null) result = caseIElementExtensible(remoteNotification);
				if (result == null) result = caseIAttributeExtensible(remoteNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>People Activity RT</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>People Activity RT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeopleActivityRT(PeopleActivityRT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>People Activity RN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>People Activity RN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeopleActivityRN(PeopleActivityRN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoteTask(RemoteTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoteNotification(RemoteNotification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSDLElement(WSDLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IElement Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IElement Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIElementExtensible(ElementExtensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAttribute Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAttribute Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAttributeExtensible(AttributeExtensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPELExtensibleElement(BPELExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionActivity(ExtensionActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionElement(ExtensionElement object) {
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

} //ModelSwitch
