/**
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.TaskImplementation#getTaskImplementation <em>Task Implementation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.TaskImplementation#getTaskProperties <em>Task Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTaskImplementation()
 * @model
 * @generated
 */
public interface TaskImplementation extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Task Implementation</b></em>' attribute.
	 * The default value is <code>"org.apache.synapse.startup.tasks.MessageInjector"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Implementation</em>' attribute.
	 * @see #setTaskImplementation(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTaskImplementation_TaskImplementation()
	 * @model default="org.apache.synapse.startup.tasks.MessageInjector" required="true"
	 * @generated
	 */
	String getTaskImplementation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.TaskImplementation#getTaskImplementation <em>Task Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Implementation</em>' attribute.
	 * @see #getTaskImplementation()
	 * @generated
	 */
	void setTaskImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Task Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.TaskProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTaskImplementation_TaskProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskProperty> getTaskProperties();

} // TaskImplementation
