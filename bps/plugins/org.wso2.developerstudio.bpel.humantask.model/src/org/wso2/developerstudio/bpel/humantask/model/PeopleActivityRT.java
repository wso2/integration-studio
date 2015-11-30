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

import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Variable;

import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>People Activity RT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getInputVariable <em>Input Variable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isIsSkipable <em>Is Skipable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isDontShareComments <em>Dont Share Comments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getRemoteTask <em>Remote Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRT()
 * @model
 * @generated
 */
public interface PeopleActivityRT extends ExtensionActivity, ExtensionElement {
	/**
	 * Returns the value of the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable</em>' reference.
	 * @see #setInputVariable(Variable)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRT_InputVariable()
	 * @model
	 * @generated
	 */
	Variable getInputVariable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getInputVariable <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Variable</em>' reference.
	 * @see #getInputVariable()
	 * @generated
	 */
	void setInputVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable</em>' reference.
	 * @see #setOutputVariable(Variable)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRT_OutputVariable()
	 * @model
	 * @generated
	 */
	Variable getOutputVariable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getOutputVariable <em>Output Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Variable</em>' reference.
	 * @see #getOutputVariable()
	 * @generated
	 */
	void setOutputVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Is Skipable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Skipable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Skipable</em>' attribute.
	 * @see #setIsSkipable(boolean)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRT_IsSkipable()
	 * @model
	 * @generated
	 */
	boolean isIsSkipable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isIsSkipable <em>Is Skipable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Skipable</em>' attribute.
	 * @see #isIsSkipable()
	 * @generated
	 */
	void setIsSkipable(boolean value);

	/**
	 * Returns the value of the '<em><b>Dont Share Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dont Share Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dont Share Comments</em>' attribute.
	 * @see #setDontShareComments(boolean)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRT_DontShareComments()
	 * @model
	 * @generated
	 */
	boolean isDontShareComments();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#isDontShareComments <em>Dont Share Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dont Share Comments</em>' attribute.
	 * @see #isDontShareComments()
	 * @generated
	 */
	void setDontShareComments(boolean value);

	/**
	 * Returns the value of the '<em><b>Remote Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Task</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Task</em>' containment reference.
	 * @see #setRemoteTask(RemoteTask)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getPeopleActivityRT_RemoteTask()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RemoteTask getRemoteTask();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT#getRemoteTask <em>Remote Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Task</em>' containment reference.
	 * @see #getRemoteTask()
	 * @generated
	 */
	void setRemoteTask(RemoteTask value);

} // PeopleActivityRT
