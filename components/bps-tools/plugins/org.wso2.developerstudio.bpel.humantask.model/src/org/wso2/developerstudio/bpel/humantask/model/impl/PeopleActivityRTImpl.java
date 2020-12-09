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
package org.wso2.developerstudio.bpel.humantask.model.impl;

import org.eclipse.bpel.model.Variable;

import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.eclipse.smila.processing.designer.model.processor.util.DOMUtils;

import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT;
import org.wso2.developerstudio.bpel.humantask.model.RemoteTask;
import org.wso2.developerstudio.bpel.humantask.model.util.HTConstants;
import org.wso2.developerstudio.bpel.humantask.record.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>People Activity RT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl#getInputVariable <em>Input Variable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl#isIsSkipable <em>Is Skipable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl#isDontShareComments <em>Dont Share Comments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.impl.PeopleActivityRTImpl#getRemoteTask <em>Remote Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeopleActivityRTImpl extends ExtensionActivityImpl implements PeopleActivityRT {
	/**
	 * The cached value of the '{@link #getInputVariable() <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable inputVariable;

	/**
	 * The cached value of the '{@link #getOutputVariable() <em>Output Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable outputVariable;

	/**
	 * The default value of the '{@link #isIsSkipable() <em>Is Skipable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSkipable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SKIPABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSkipable() <em>Is Skipable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSkipable()
	 * @generated
	 * @ordered
	 */
	protected boolean isSkipable = IS_SKIPABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDontShareComments() <em>Dont Share Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDontShareComments()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DONT_SHARE_COMMENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDontShareComments() <em>Dont Share Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDontShareComments()
	 * @generated
	 * @ordered
	 */
	protected boolean dontShareComments = DONT_SHARE_COMMENTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRemoteTask() <em>Remote Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteTask()
	 * @generated
	 * @ordered
	 */
	protected RemoteTask remoteTask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeopleActivityRTImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PEOPLE_ACTIVITY_RT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getInputVariable() {
		if (inputVariable != null && inputVariable.eIsProxy()) {
			InternalEObject oldInputVariable = (InternalEObject)inputVariable;
			inputVariable = (Variable)eResolveProxy(oldInputVariable);
			if (inputVariable != oldInputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PEOPLE_ACTIVITY_RT__INPUT_VARIABLE, oldInputVariable, inputVariable));
			}
		}
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetInputVariable() {
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setInputVariable(Variable newInputVariable) {
		Variable oldInputVariable = inputVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					HTConstants.AT_INPUT_VARIABLE,
					newInputVariable == null ? null : newInputVariable
							.getName());
		}
		inputVariable = newInputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PEOPLE_ACTIVITY_RT__INPUT_VARIABLE, oldInputVariable, inputVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getOutputVariable() {
		if (outputVariable != null && outputVariable.eIsProxy()) {
			InternalEObject oldOutputVariable = (InternalEObject)outputVariable;
			outputVariable = (Variable)eResolveProxy(oldOutputVariable);
			if (outputVariable != oldOutputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE, oldOutputVariable, outputVariable));
			}
		}
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetOutputVariable() {
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOutputVariable(Variable newOutputVariable) {
		Variable oldOutputVariable = outputVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					HTConstants.AT_OUTPUT_VARIABLE,
					newOutputVariable == null ? null : newOutputVariable
							.getName());
		}
		outputVariable = newOutputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE, oldOutputVariable, outputVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSkipable() {
		return isSkipable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setIsSkipable(boolean newIsSkipable) {
		boolean oldIsSkipable = isSkipable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					HTConstants.AT_IS_SKIPABLE,
					BPELUtils.boolean2XML(newIsSkipable));
		}
		isSkipable = newIsSkipable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PEOPLE_ACTIVITY_RT__IS_SKIPABLE, oldIsSkipable, isSkipable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDontShareComments() {
		return dontShareComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDontShareComments(boolean newDontShareComments) {
		boolean oldDontShareComments = dontShareComments;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					HTConstants.AT_DO_NT_SHARE_COMMENTS,
					BPELUtils.boolean2XML(newDontShareComments));
		}
		dontShareComments = newDontShareComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS, oldDontShareComments, dontShareComments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteTask getRemoteTask() {
		return remoteTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetRemoteTask(RemoteTask newRemoteTask, NotificationChain msgs) {
		RemoteTask oldRemoteTask = remoteTask;
		
		replaceChild(oldRemoteTask, newRemoteTask);
		
		remoteTask = newRemoteTask;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK, oldRemoteTask, newRemoteTask);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteTask(RemoteTask newRemoteTask) {
		if (newRemoteTask != remoteTask) {
			NotificationChain msgs = null;
			if (remoteTask != null)
				msgs = ((InternalEObject)remoteTask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK, null, msgs);
			if (newRemoteTask != null)
				msgs = ((InternalEObject)newRemoteTask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK, null, msgs);
			msgs = basicSetRemoteTask(newRemoteTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK, newRemoteTask, newRemoteTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element fixElement(Document document) {
		if (getElement() == null && !isUpdatingDOM()) {
		      try {
		        setUpdatingDOM(true);
		        Element element =
		          document.createElementNS(ModelPackage.eNS_URI, HTConstants.ND_PEOPLE_ACTIVITY_RT);
		        element.setPrefix(ModelPackage.eNS_PREFIX);
		        setElement(element);
		        if (getRemoteTask() != null) {
		          DOMUtils.appendIndented(element, getRemoteTask().fixElement(document));
		        }
		      } finally {
		        setUpdatingDOM(false);
		      }
		    }
		    return getElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK:
				return basicSetRemoteTask(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PEOPLE_ACTIVITY_RT__INPUT_VARIABLE:
				if (resolve) return getInputVariable();
				return basicGetInputVariable();
			case ModelPackage.PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE:
				if (resolve) return getOutputVariable();
				return basicGetOutputVariable();
			case ModelPackage.PEOPLE_ACTIVITY_RT__IS_SKIPABLE:
				return isIsSkipable();
			case ModelPackage.PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS:
				return isDontShareComments();
			case ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK:
				return getRemoteTask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.PEOPLE_ACTIVITY_RT__INPUT_VARIABLE:
				setInputVariable((Variable)newValue);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE:
				setOutputVariable((Variable)newValue);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__IS_SKIPABLE:
				setIsSkipable((Boolean)newValue);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS:
				setDontShareComments((Boolean)newValue);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK:
				setRemoteTask((RemoteTask)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.PEOPLE_ACTIVITY_RT__INPUT_VARIABLE:
				setInputVariable((Variable)null);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE:
				setOutputVariable((Variable)null);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__IS_SKIPABLE:
				setIsSkipable(IS_SKIPABLE_EDEFAULT);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS:
				setDontShareComments(DONT_SHARE_COMMENTS_EDEFAULT);
				return;
			case ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK:
				setRemoteTask((RemoteTask)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.PEOPLE_ACTIVITY_RT__INPUT_VARIABLE:
				return inputVariable != null;
			case ModelPackage.PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE:
				return outputVariable != null;
			case ModelPackage.PEOPLE_ACTIVITY_RT__IS_SKIPABLE:
				return isSkipable != IS_SKIPABLE_EDEFAULT;
			case ModelPackage.PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS:
				return dontShareComments != DONT_SHARE_COMMENTS_EDEFAULT;
			case ModelPackage.PEOPLE_ACTIVITY_RT__REMOTE_TASK:
				return remoteTask != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isSkipable: ");
		result.append(isSkipable);
		result.append(", dontShareComments: ");
		result.append(dontShareComments);
		result.append(')');
		return result.toString();
	}
	
	
	protected <E extends ExtensionElement> void replaceChild(E oldElement, E newElement) {
	    if (!isReconciling() && !isUpdatingDOM() && getElement() != null && !ReconciliationHelper.isLoading(this)) {
	      if (newElement.fixElement(getElement().getOwnerDocument()) != null) {
	        ReconciliationHelper.replaceChild(this, oldElement, newElement);
	      }
	    }
	  }
} //PeopleActivityRTImpl
