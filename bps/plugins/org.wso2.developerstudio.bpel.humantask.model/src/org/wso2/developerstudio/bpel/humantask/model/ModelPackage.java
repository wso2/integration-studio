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
package org.wso2.developerstudio.bpel.humantask.model;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.wso2.developerstudio.bpel.humantask.record.RecordPackage;

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
 * @see org.wso2.developerstudio.bpel.humantask.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://docs.oasis-open.org/ns/bpel4people/bpel4people/200803";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "b4p";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl <em>People Activity RT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getPeopleActivityRT()
	 * @generated
	 */
	int PEOPLE_ACTIVITY_RT = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__INPUT_VARIABLE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Skipable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__IS_SKIPABLE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dont Share Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Remote Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT__REMOTE_TASK = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>People Activity RT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RT_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRNImpl <em>People Activity RN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRNImpl
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getPeopleActivityRN()
	 * @generated
	 */
	int PEOPLE_ACTIVITY_RN = 1;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__INPUT_VARIABLE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Remote Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>People Activity RN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_ACTIVITY_RN_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.RemoteTaskImpl <em>Remote Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.RemoteTaskImpl
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getRemoteTask()
	 * @generated
	 */
	int REMOTE_TASK = 2;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__DOCUMENTATION_ELEMENT = RecordPackage.EXTENSION_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__ELEMENT = RecordPackage.EXTENSION_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__EEXTENSIBILITY_ELEMENTS = RecordPackage.EXTENSION_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__DOCUMENTATION = RecordPackage.EXTENSION_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__PARTNER_LINK = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__OPERATION = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Response Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK__RESPONSE_OPERATION = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Remote Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_TASK_FEATURE_COUNT = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.RemoteNotificationImpl <em>Remote Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.RemoteNotificationImpl
	 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getRemoteNotification()
	 * @generated
	 */
	int REMOTE_NOTIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION__DOCUMENTATION_ELEMENT = RecordPackage.EXTENSION_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION__ELEMENT = RecordPackage.EXTENSION_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION__EEXTENSIBILITY_ELEMENTS = RecordPackage.EXTENSION_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION__DOCUMENTATION = RecordPackage.EXTENSION_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION__PARTNER_LINK = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION__OPERATION = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Remote Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_NOTIFICATION_FEATURE_COUNT = RecordPackage.EXTENSION_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT <em>People Activity RT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>People Activity RT</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT
	 * @generated
	 */
	EClass getPeopleActivityRT();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getInputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Variable</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getInputVariable()
	 * @see #getPeopleActivityRT()
	 * @generated
	 */
	EReference getPeopleActivityRT_InputVariable();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Variable</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getOutputVariable()
	 * @see #getPeopleActivityRT()
	 * @generated
	 */
	EReference getPeopleActivityRT_OutputVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isIsSkipable <em>Is Skipable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Skipable</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isIsSkipable()
	 * @see #getPeopleActivityRT()
	 * @generated
	 */
	EAttribute getPeopleActivityRT_IsSkipable();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isDontShareComments <em>Dont Share Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dont Share Comments</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isDontShareComments()
	 * @see #getPeopleActivityRT()
	 * @generated
	 */
	EAttribute getPeopleActivityRT_DontShareComments();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getRemoteTask <em>Remote Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Remote Task</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getRemoteTask()
	 * @see #getPeopleActivityRT()
	 * @generated
	 */
	EReference getPeopleActivityRT_RemoteTask();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN <em>People Activity RN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>People Activity RN</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN
	 * @generated
	 */
	EClass getPeopleActivityRN();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getInputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Variable</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getInputVariable()
	 * @see #getPeopleActivityRN()
	 * @generated
	 */
	EReference getPeopleActivityRN_InputVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getRemoteNotification <em>Remote Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Remote Notification</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN#getRemoteNotification()
	 * @see #getPeopleActivityRN()
	 * @generated
	 */
	EReference getPeopleActivityRN_RemoteNotification();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask <em>Remote Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Task</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteTask
	 * @generated
	 */
	EClass getRemoteTask();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Partner Link</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getPartnerLink()
	 * @see #getRemoteTask()
	 * @generated
	 */
	EReference getRemoteTask_PartnerLink();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getOperation()
	 * @see #getRemoteTask()
	 * @generated
	 */
	EReference getRemoteTask_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getResponseOperation <em>Response Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Response Operation</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getResponseOperation()
	 * @see #getRemoteTask()
	 * @generated
	 */
	EReference getRemoteTask_ResponseOperation();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification <em>Remote Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Notification</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteNotification
	 * @generated
	 */
	EClass getRemoteNotification();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Partner Link</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getPartnerLink()
	 * @see #getRemoteNotification()
	 * @generated
	 */
	EReference getRemoteNotification_PartnerLink();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.model.RemoteNotification#getOperation()
	 * @see #getRemoteNotification()
	 * @generated
	 */
	EReference getRemoteNotification_Operation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl <em>People Activity RT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getPeopleActivityRT()
		 * @generated
		 */
		EClass PEOPLE_ACTIVITY_RT = eINSTANCE.getPeopleActivityRT();

		/**
		 * The meta object literal for the '<em><b>Input Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEOPLE_ACTIVITY_RT__INPUT_VARIABLE = eINSTANCE.getPeopleActivityRT_InputVariable();

		/**
		 * The meta object literal for the '<em><b>Output Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE = eINSTANCE.getPeopleActivityRT_OutputVariable();

		/**
		 * The meta object literal for the '<em><b>Is Skipable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEOPLE_ACTIVITY_RT__IS_SKIPABLE = eINSTANCE.getPeopleActivityRT_IsSkipable();

		/**
		 * The meta object literal for the '<em><b>Dont Share Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS = eINSTANCE.getPeopleActivityRT_DontShareComments();

		/**
		 * The meta object literal for the '<em><b>Remote Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEOPLE_ACTIVITY_RT__REMOTE_TASK = eINSTANCE.getPeopleActivityRT_RemoteTask();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRNImpl <em>People Activity RN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRNImpl
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getPeopleActivityRN()
		 * @generated
		 */
		EClass PEOPLE_ACTIVITY_RN = eINSTANCE.getPeopleActivityRN();

		/**
		 * The meta object literal for the '<em><b>Input Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEOPLE_ACTIVITY_RN__INPUT_VARIABLE = eINSTANCE.getPeopleActivityRN_InputVariable();

		/**
		 * The meta object literal for the '<em><b>Remote Notification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION = eINSTANCE.getPeopleActivityRN_RemoteNotification();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.RemoteTaskImpl <em>Remote Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.RemoteTaskImpl
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getRemoteTask()
		 * @generated
		 */
		EClass REMOTE_TASK = eINSTANCE.getRemoteTask();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_TASK__PARTNER_LINK = eINSTANCE.getRemoteTask_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_TASK__OPERATION = eINSTANCE.getRemoteTask_Operation();

		/**
		 * The meta object literal for the '<em><b>Response Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_TASK__RESPONSE_OPERATION = eINSTANCE.getRemoteTask_ResponseOperation();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.bpel.humantask.model.impl.RemoteNotificationImpl <em>Remote Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.RemoteNotificationImpl
		 * @see org.wso2.developerstudio.bpel.humantask.model.impl.ModelPackageImpl#getRemoteNotification()
		 * @generated
		 */
		EClass REMOTE_NOTIFICATION = eINSTANCE.getRemoteNotification();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_NOTIFICATION__PARTNER_LINK = eINSTANCE.getRemoteNotification_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_NOTIFICATION__OPERATION = eINSTANCE.getRemoteNotification_Operation();

	}

} //ModelPackage
