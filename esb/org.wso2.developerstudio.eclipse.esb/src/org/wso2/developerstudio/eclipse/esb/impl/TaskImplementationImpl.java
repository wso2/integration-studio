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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.TaskImplementation;
import org.wso2.developerstudio.eclipse.esb.TaskProperty;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.TaskImplementationImpl#getTaskImplementation <em>Task Implementation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.TaskImplementationImpl#getTaskProperties <em>Task Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImplementationImpl extends ModelObjectImpl implements TaskImplementation {
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
	protected TaskImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.TASK_IMPLEMENTATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TASK_IMPLEMENTATION__TASK_IMPLEMENTATION, oldTaskImplementation, taskImplementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskProperty> getTaskProperties() {
		if (taskProperties == null) {
			taskProperties = new EObjectContainmentEList<TaskProperty>(TaskProperty.class, this, EsbPackage.TASK_IMPLEMENTATION__TASK_PROPERTIES);
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
			case EsbPackage.TASK_IMPLEMENTATION__TASK_PROPERTIES:
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
			case EsbPackage.TASK_IMPLEMENTATION__TASK_IMPLEMENTATION:
				return getTaskImplementation();
			case EsbPackage.TASK_IMPLEMENTATION__TASK_PROPERTIES:
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
			case EsbPackage.TASK_IMPLEMENTATION__TASK_IMPLEMENTATION:
				setTaskImplementation((String)newValue);
				return;
			case EsbPackage.TASK_IMPLEMENTATION__TASK_PROPERTIES:
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
			case EsbPackage.TASK_IMPLEMENTATION__TASK_IMPLEMENTATION:
				setTaskImplementation(TASK_IMPLEMENTATION_EDEFAULT);
				return;
			case EsbPackage.TASK_IMPLEMENTATION__TASK_PROPERTIES:
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
			case EsbPackage.TASK_IMPLEMENTATION__TASK_IMPLEMENTATION:
				return TASK_IMPLEMENTATION_EDEFAULT == null ? taskImplementation != null : !TASK_IMPLEMENTATION_EDEFAULT.equals(taskImplementation);
			case EsbPackage.TASK_IMPLEMENTATION__TASK_PROPERTIES:
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
		result.append(" (TaskImplementation: ");
		result.append(taskImplementation);
		result.append(')');
		return result.toString();
	}

	@Override
	public Map<String, ObjectValidator> validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Element doSave(Element parent) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

} //TaskImplementationImpl
