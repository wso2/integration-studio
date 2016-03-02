package org.wso2.developerstudio.eclipse.gmf.esb.impl;


import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskImplementation;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskTriggerType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getTaskName <em>Task Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getTaskGroup <em>Task Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getCron <em>Cron</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getPinnedServers <em>Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getTaskImplementation <em>Task Implementation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TaskImpl#getTaskProperties <em>Task Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends EsbElementImpl implements Task {
	/**
	 * The default value of the '{@link #getTaskName() <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskName()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskName() <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskName()
	 * @generated
	 * @ordered
	 */
	protected String taskName = TASK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskGroup() <em>Task Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_GROUP_EDEFAULT = "synapse.simple.quartz";

	/**
	 * The cached value of the '{@link #getTaskGroup() <em>Task Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskGroup()
	 * @generated
	 * @ordered
	 */
	protected String taskGroup = TASK_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerType()
	 * @generated
	 * @ordered
	 */
	protected static final TaskTriggerType TRIGGER_TYPE_EDEFAULT = TaskTriggerType.SIMPLE;

	/**
	 * The cached value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerType()
	 * @generated
	 * @ordered
	 */
	protected TaskTriggerType triggerType = TRIGGER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final long COUNT_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected long count = COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected static final long INTERVAL_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected long interval = INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCron() <em>Cron</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCron()
	 * @generated
	 * @ordered
	 */
	protected static final String CRON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCron() <em>Cron</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCron()
	 * @generated
	 * @ordered
	 */
	protected String cron = CRON_EDEFAULT;

	/**
	 * The default value of the '{@link #getPinnedServers() <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPinnedServers()
	 * @generated
	 * @ordered
	 */
	protected static final String PINNED_SERVERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPinnedServers() <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPinnedServers()
	 * @generated
	 * @ordered
	 */
	protected String pinnedServers = PINNED_SERVERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskImplementation() <em>Task Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_IMPLEMENTATION_EDEFAULT = "org.apache.synapse.startup.tasks.MessageInjector";

	/**
	 * The cached value of the '{@link #getTaskImplementation() <em>Task Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskImplementation()
	 * @generated
	 * @ordered
	 */
	protected String taskImplementation = TASK_IMPLEMENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTaskProperties() <em>Task Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskProperty> taskProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskName(String newTaskName) {
		String oldTaskName = taskName;
		taskName = newTaskName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__TASK_NAME, oldTaskName, taskName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaskGroup() {
		return taskGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskGroup(String newTaskGroup) {
		String oldTaskGroup = taskGroup;
		taskGroup = newTaskGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__TASK_GROUP, oldTaskGroup, taskGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskTriggerType getTriggerType() {
		return triggerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerType(TaskTriggerType newTriggerType) {
		TaskTriggerType oldTriggerType = triggerType;
		triggerType = newTriggerType == null ? TRIGGER_TYPE_EDEFAULT : newTriggerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__TRIGGER_TYPE, oldTriggerType, triggerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(long newCount) {
		long oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getInterval() {
		return interval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(long newInterval) {
		long oldInterval = interval;
		interval = newInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__INTERVAL, oldInterval, interval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCron() {
		return cron;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCron(String newCron) {
		String oldCron = cron;
		cron = newCron;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__CRON, oldCron, cron));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPinnedServers() {
		return pinnedServers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPinnedServers(String newPinnedServers) {
		String oldPinnedServers = pinnedServers;
		pinnedServers = newPinnedServers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__PINNED_SERVERS, oldPinnedServers, pinnedServers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaskImplementation() {
		return taskImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskImplementation(String newTaskImplementation) {
		String oldTaskImplementation = taskImplementation;
		taskImplementation = newTaskImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK__TASK_IMPLEMENTATION, oldTaskImplementation, taskImplementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskProperty> getTaskProperties() {
		if (taskProperties == null) {
			taskProperties = new EObjectContainmentEList<TaskProperty>(TaskProperty.class, this, EsbPackage.TASK__TASK_PROPERTIES);
		}
		return taskProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.TASK__TASK_PROPERTIES:
				return ((InternalEList<?>)getTaskProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.TASK__TASK_NAME:
				return getTaskName();
			case EsbPackage.TASK__TASK_GROUP:
				return getTaskGroup();
			case EsbPackage.TASK__TRIGGER_TYPE:
				return getTriggerType();
			case EsbPackage.TASK__COUNT:
				return getCount();
			case EsbPackage.TASK__INTERVAL:
				return getInterval();
			case EsbPackage.TASK__CRON:
				return getCron();
			case EsbPackage.TASK__PINNED_SERVERS:
				return getPinnedServers();
			case EsbPackage.TASK__TASK_IMPLEMENTATION:
				return getTaskImplementation();
			case EsbPackage.TASK__TASK_PROPERTIES:
				return getTaskProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.TASK__TASK_NAME:
				setTaskName((String)newValue);
				return;
			case EsbPackage.TASK__TASK_GROUP:
				setTaskGroup((String)newValue);
				return;
			case EsbPackage.TASK__TRIGGER_TYPE:
				setTriggerType((TaskTriggerType)newValue);
				return;
			case EsbPackage.TASK__COUNT:
				setCount((Long)newValue);
				return;
			case EsbPackage.TASK__INTERVAL:
				setInterval((Long)newValue);
				return;
			case EsbPackage.TASK__CRON:
				setCron((String)newValue);
				return;
			case EsbPackage.TASK__PINNED_SERVERS:
				setPinnedServers((String)newValue);
				return;
			case EsbPackage.TASK__TASK_IMPLEMENTATION:
				setTaskImplementation((String)newValue);
				return;
			case EsbPackage.TASK__TASK_PROPERTIES:
				getTaskProperties().clear();
				getTaskProperties().addAll((Collection<? extends TaskProperty>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.TASK__TASK_NAME:
				setTaskName(TASK_NAME_EDEFAULT);
				return;
			case EsbPackage.TASK__TASK_GROUP:
				setTaskGroup(TASK_GROUP_EDEFAULT);
				return;
			case EsbPackage.TASK__TRIGGER_TYPE:
				setTriggerType(TRIGGER_TYPE_EDEFAULT);
				return;
			case EsbPackage.TASK__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case EsbPackage.TASK__INTERVAL:
				setInterval(INTERVAL_EDEFAULT);
				return;
			case EsbPackage.TASK__CRON:
				setCron(CRON_EDEFAULT);
				return;
			case EsbPackage.TASK__PINNED_SERVERS:
				setPinnedServers(PINNED_SERVERS_EDEFAULT);
				return;
			case EsbPackage.TASK__TASK_IMPLEMENTATION:
				setTaskImplementation(TASK_IMPLEMENTATION_EDEFAULT);
				return;
			case EsbPackage.TASK__TASK_PROPERTIES:
				getTaskProperties().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.TASK__TASK_NAME:
				return TASK_NAME_EDEFAULT == null ? taskName != null : !TASK_NAME_EDEFAULT.equals(taskName);
			case EsbPackage.TASK__TASK_GROUP:
				return TASK_GROUP_EDEFAULT == null ? taskGroup != null : !TASK_GROUP_EDEFAULT.equals(taskGroup);
			case EsbPackage.TASK__TRIGGER_TYPE:
				return triggerType != TRIGGER_TYPE_EDEFAULT;
			case EsbPackage.TASK__COUNT:
				return count != COUNT_EDEFAULT;
			case EsbPackage.TASK__INTERVAL:
				return interval != INTERVAL_EDEFAULT;
			case EsbPackage.TASK__CRON:
				return CRON_EDEFAULT == null ? cron != null : !CRON_EDEFAULT.equals(cron);
			case EsbPackage.TASK__PINNED_SERVERS:
				return PINNED_SERVERS_EDEFAULT == null ? pinnedServers != null : !PINNED_SERVERS_EDEFAULT.equals(pinnedServers);
			case EsbPackage.TASK__TASK_IMPLEMENTATION:
				return TASK_IMPLEMENTATION_EDEFAULT == null ? taskImplementation != null : !TASK_IMPLEMENTATION_EDEFAULT.equals(taskImplementation);
			case EsbPackage.TASK__TASK_PROPERTIES:
				return taskProperties != null && !taskProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (taskName: ");
		result.append(taskName);
		result.append(", taskGroup: ");
		result.append(taskGroup);
		result.append(", triggerType: ");
		result.append(triggerType);
		result.append(", count: ");
		result.append(count);
		result.append(", interval: ");
		result.append(interval);
		result.append(", cron: ");
		result.append(cron);
		result.append(", pinnedServers: ");
		result.append(pinnedServers);
		result.append(", taskImplementation: ");
		result.append(taskImplementation);
		result.append(')');
		return result.toString();
	}

} //TaskImpl