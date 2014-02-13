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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getTaskName <em>Task Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getTaskGroup <em>Task Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getTaskImplementationClass <em>Task Implementation Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getCount <em>Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getCron <em>Cron</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.Task#getPinnedServers <em>Pinned Servers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends ConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Task Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Name</em>' attribute.
	 * @see #setTaskName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_TaskName()
	 * @model required="true"
	 * @generated
	 */
	String getTaskName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getTaskName <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Name</em>' attribute.
	 * @see #getTaskName()
	 * @generated
	 */
	void setTaskName(String value);

	/**
	 * Returns the value of the '<em><b>Task Group</b></em>' attribute.
	 * The default value is <code>"synapse.simple.quartz"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Group</em>' attribute.
	 * @see #setTaskGroup(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_TaskGroup()
	 * @model default="synapse.simple.quartz" required="true"
	 * @generated
	 */
	String getTaskGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getTaskGroup <em>Task Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Group</em>' attribute.
	 * @see #getTaskGroup()
	 * @generated
	 */
	void setTaskGroup(String value);

	/**
	 * Returns the value of the '<em><b>Task Implementation Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Implementation Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Implementation Class</em>' containment reference.
	 * @see #setTaskImplementationClass(TaskImplementation)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_TaskImplementationClass()
	 * @model containment="true"
	 * @generated
	 */
	TaskImplementation getTaskImplementationClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getTaskImplementationClass <em>Task Implementation Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Implementation Class</em>' containment reference.
	 * @see #getTaskImplementationClass()
	 * @generated
	 */
	void setTaskImplementationClass(TaskImplementation value);

	/**
	 * Returns the value of the '<em><b>Trigger Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.TaskTriggerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.TaskTriggerType
	 * @see #setTriggerType(TaskTriggerType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_TriggerType()
	 * @model required="true"
	 * @generated
	 */
	TaskTriggerType getTriggerType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getTriggerType <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.TaskTriggerType
	 * @see #getTriggerType()
	 * @generated
	 */
	void setTriggerType(TaskTriggerType value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_Count()
	 * @model
	 * @generated
	 */
	long getCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(long value);

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' attribute.
	 * @see #setInterval(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_Interval()
	 * @model required="true"
	 * @generated
	 */
	long getInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' attribute.
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(long value);

	/**
	 * Returns the value of the '<em><b>Cron</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cron</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cron</em>' attribute.
	 * @see #setCron(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_Cron()
	 * @model
	 * @generated
	 */
	String getCron();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getCron <em>Cron</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cron</em>' attribute.
	 * @see #getCron()
	 * @generated
	 */
	void setCron(String value);

	/**
	 * Returns the value of the '<em><b>Pinned Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pinned Servers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pinned Servers</em>' attribute.
	 * @see #setPinnedServers(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getTask_PinnedServers()
	 * @model
	 * @generated
	 */
	String getPinnedServers();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.Task#getPinnedServers <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pinned Servers</em>' attribute.
	 * @see #getPinnedServers()
	 * @generated
	 */
	void setPinnedServers(String value);

} // Task
