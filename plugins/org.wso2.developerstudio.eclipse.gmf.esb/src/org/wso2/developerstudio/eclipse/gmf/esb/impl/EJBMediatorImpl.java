/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EJB Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getBeanstalk <em>Beanstalk</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getSessionIdType <em>Session Id Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getSessionIdLiteral <em>Session Id Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getSessionIdExpression <em>Session Id Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#isRemove <em>Remove</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getJNDIName <em>JNDI Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EJBMediatorImpl#getMethodArguments <em>Method Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EJBMediatorImpl extends MediatorImpl implements EJBMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected EJBMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EJBMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getBeanstalk() <em>Beanstalk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeanstalk()
	 * @generated
	 * @ordered
	 */
	protected static final String BEANSTALK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBeanstalk() <em>Beanstalk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeanstalk()
	 * @generated
	 * @ordered
	 */
	protected String beanstalk = BEANSTALK_EDEFAULT;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected String method = METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSessionIdType() <em>Session Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionIdType()
	 * @generated
	 * @ordered
	 */
	protected static final PropertyValueType SESSION_ID_TYPE_EDEFAULT = PropertyValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getSessionIdType() <em>Session Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionIdType()
	 * @generated
	 * @ordered
	 */
	protected PropertyValueType sessionIdType = SESSION_ID_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSessionIdLiteral() <em>Session Id Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionIdLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String SESSION_ID_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSessionIdLiteral() <em>Session Id Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionIdLiteral()
	 * @generated
	 * @ordered
	 */
	protected String sessionIdLiteral = SESSION_ID_LITERAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSessionIdExpression() <em>Session Id Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionIdExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty sessionIdExpression;

	/**
	 * The default value of the '{@link #isRemove() <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemove()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemove() <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemove()
	 * @generated
	 * @ordered
	 */
	protected boolean remove = REMOVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getJNDIName() <em>JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJNDIName() <em>JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMethodArguments() <em>Method Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<MethodArgument> methodArguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EJBMediatorImpl() {
		super();
		NamespacedProperty sessionIdExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		sessionIdExpression.setPrettyName("SessionId Expression");
		sessionIdExpression.setPropertyName("expression");
		sessionIdExpression.setPropertyValue("/default/expression");
		setSessionIdExpression(sessionIdExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.EJB_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EJBMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(EJBMediatorInputConnector newInputConnector, NotificationChain msgs) {
		EJBMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(EJBMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EJBMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(EJBMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		EJBMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(EJBMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBeanstalk() {
		return beanstalk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeanstalk(String newBeanstalk) {
		String oldBeanstalk = beanstalk;
		beanstalk = newBeanstalk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__BEANSTALK, oldBeanstalk, beanstalk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethod(String newMethod) {
		String oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueType getSessionIdType() {
		return sessionIdType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionIdType(PropertyValueType newSessionIdType) {
		PropertyValueType oldSessionIdType = sessionIdType;
		sessionIdType = newSessionIdType == null ? SESSION_ID_TYPE_EDEFAULT : newSessionIdType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__SESSION_ID_TYPE, oldSessionIdType, sessionIdType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSessionIdLiteral() {
		return sessionIdLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionIdLiteral(String newSessionIdLiteral) {
		String oldSessionIdLiteral = sessionIdLiteral;
		sessionIdLiteral = newSessionIdLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__SESSION_ID_LITERAL, oldSessionIdLiteral, sessionIdLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSessionIdExpression() {
		return sessionIdExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSessionIdExpression(NamespacedProperty newSessionIdExpression, NotificationChain msgs) {
		NamespacedProperty oldSessionIdExpression = sessionIdExpression;
		sessionIdExpression = newSessionIdExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION, oldSessionIdExpression, newSessionIdExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionIdExpression(NamespacedProperty newSessionIdExpression) {
		if (newSessionIdExpression != sessionIdExpression) {
			NotificationChain msgs = null;
			if (sessionIdExpression != null)
				msgs = ((InternalEObject)sessionIdExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION, null, msgs);
			if (newSessionIdExpression != null)
				msgs = ((InternalEObject)newSessionIdExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION, null, msgs);
			msgs = basicSetSessionIdExpression(newSessionIdExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION, newSessionIdExpression, newSessionIdExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemove() {
		return remove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemove(boolean newRemove) {
		boolean oldRemove = remove;
		remove = newRemove;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__REMOVE, oldRemove, remove));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJNDIName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJNDIName(String newJNDIName) {
		String oldJNDIName = jndiName;
		jndiName = newJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.EJB_MEDIATOR__JNDI_NAME, oldJNDIName, jndiName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodArgument> getMethodArguments() {
		if (methodArguments == null) {
			methodArguments = new EObjectContainmentEList<MethodArgument>(MethodArgument.class, this, EsbPackage.EJB_MEDIATOR__METHOD_ARGUMENTS);
		}
		return methodArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION:
				return basicSetSessionIdExpression(null, msgs);
			case EsbPackage.EJB_MEDIATOR__METHOD_ARGUMENTS:
				return ((InternalEList<?>)getMethodArguments()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.EJB_MEDIATOR__BEANSTALK:
				return getBeanstalk();
			case EsbPackage.EJB_MEDIATOR__CLASS:
				return getClass_();
			case EsbPackage.EJB_MEDIATOR__METHOD:
				return getMethod();
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_TYPE:
				return getSessionIdType();
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_LITERAL:
				return getSessionIdLiteral();
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION:
				return getSessionIdExpression();
			case EsbPackage.EJB_MEDIATOR__REMOVE:
				return isRemove();
			case EsbPackage.EJB_MEDIATOR__TARGET:
				return getTarget();
			case EsbPackage.EJB_MEDIATOR__JNDI_NAME:
				return getJNDIName();
			case EsbPackage.EJB_MEDIATOR__METHOD_ARGUMENTS:
				return getMethodArguments();
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
			case EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EJBMediatorInputConnector)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EJBMediatorOutputConnector)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__BEANSTALK:
				setBeanstalk((String)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__CLASS:
				setClass((String)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__METHOD:
				setMethod((String)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_TYPE:
				setSessionIdType((PropertyValueType)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_LITERAL:
				setSessionIdLiteral((String)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION:
				setSessionIdExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__REMOVE:
				setRemove((Boolean)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__TARGET:
				setTarget((String)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__JNDI_NAME:
				setJNDIName((String)newValue);
				return;
			case EsbPackage.EJB_MEDIATOR__METHOD_ARGUMENTS:
				getMethodArguments().clear();
				getMethodArguments().addAll((Collection<? extends MethodArgument>)newValue);
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
			case EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EJBMediatorInputConnector)null);
				return;
			case EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EJBMediatorOutputConnector)null);
				return;
			case EsbPackage.EJB_MEDIATOR__BEANSTALK:
				setBeanstalk(BEANSTALK_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__METHOD:
				setMethod(METHOD_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_TYPE:
				setSessionIdType(SESSION_ID_TYPE_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_LITERAL:
				setSessionIdLiteral(SESSION_ID_LITERAL_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION:
				setSessionIdExpression((NamespacedProperty)null);
				return;
			case EsbPackage.EJB_MEDIATOR__REMOVE:
				setRemove(REMOVE_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__JNDI_NAME:
				setJNDIName(JNDI_NAME_EDEFAULT);
				return;
			case EsbPackage.EJB_MEDIATOR__METHOD_ARGUMENTS:
				getMethodArguments().clear();
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
			case EsbPackage.EJB_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.EJB_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.EJB_MEDIATOR__BEANSTALK:
				return BEANSTALK_EDEFAULT == null ? beanstalk != null : !BEANSTALK_EDEFAULT.equals(beanstalk);
			case EsbPackage.EJB_MEDIATOR__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case EsbPackage.EJB_MEDIATOR__METHOD:
				return METHOD_EDEFAULT == null ? method != null : !METHOD_EDEFAULT.equals(method);
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_TYPE:
				return sessionIdType != SESSION_ID_TYPE_EDEFAULT;
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_LITERAL:
				return SESSION_ID_LITERAL_EDEFAULT == null ? sessionIdLiteral != null : !SESSION_ID_LITERAL_EDEFAULT.equals(sessionIdLiteral);
			case EsbPackage.EJB_MEDIATOR__SESSION_ID_EXPRESSION:
				return sessionIdExpression != null;
			case EsbPackage.EJB_MEDIATOR__REMOVE:
				return remove != REMOVE_EDEFAULT;
			case EsbPackage.EJB_MEDIATOR__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case EsbPackage.EJB_MEDIATOR__JNDI_NAME:
				return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT.equals(jndiName);
			case EsbPackage.EJB_MEDIATOR__METHOD_ARGUMENTS:
				return methodArguments != null && !methodArguments.isEmpty();
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
		result.append(" (beanstalk: ");
		result.append(beanstalk);
		result.append(", class: ");
		result.append(class_);
		result.append(", method: ");
		result.append(method);
		result.append(", sessionIdType: ");
		result.append(sessionIdType);
		result.append(", sessionIdLiteral: ");
		result.append(sessionIdLiteral);
		result.append(", remove: ");
		result.append(remove);
		result.append(", target: ");
		result.append(target);
		result.append(", JNDIName: ");
		result.append(jndiName);
		result.append(')');
		return result.toString();
	}

} //EJBMediatorImpl
