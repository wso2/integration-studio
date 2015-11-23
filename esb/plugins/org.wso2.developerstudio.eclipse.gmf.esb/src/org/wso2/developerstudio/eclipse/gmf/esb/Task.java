/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskName <em>Task Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskGroup <em>Task Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getCount <em>Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getCron <em>Cron</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getPinnedServers <em>Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskImplementation <em>Task Implementation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskProperties <em>Task Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EsbElement {
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_TaskName()
	 * @model
	 * @generated
	 */
	String getTaskName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskName <em>Task Name</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_TaskGroup()
	 * @model default="synapse.simple.quartz"
	 * @generated
	 */
	String getTaskGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskGroup <em>Task Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Group</em>' attribute.
	 * @see #getTaskGroup()
	 * @generated
	 */
	void setTaskGroup(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.TaskTriggerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.TaskTriggerType
	 * @see #setTriggerType(TaskTriggerType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_TriggerType()
	 * @model
	 * @generated
	 */
	TaskTriggerType getTriggerType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTriggerType <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.TaskTriggerType
	 * @see #getTriggerType()
	 * @generated
	 */
	void setTriggerType(TaskTriggerType value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_Count()
	 * @model default="-1"
	 * @generated
	 */
	long getCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getCount <em>Count</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_Interval()
	 * @model
	 * @generated
	 */
	long getInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getInterval <em>Interval</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_Cron()
	 * @model
	 * @generated
	 */
	String getCron();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getCron <em>Cron</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_PinnedServers()
	 * @model
	 * @generated
	 */
	String getPinnedServers();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getPinnedServers <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pinned Servers</em>' attribute.
	 * @see #getPinnedServers()
	 * @generated
	 */
	void setPinnedServers(String value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_TaskImplementation()
	 * @model default="org.apache.synapse.startup.tasks.MessageInjector" required="true"
	 * @generated
	 */
	String getTaskImplementation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Task#getTaskImplementation <em>Task Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Implementation</em>' attribute.
	 * @see #getTaskImplementation()
	 * @generated
	 */
	void setTaskImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Task Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTask_TaskProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskProperty> getTaskProperties();

} // Task
