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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getStoreName <em>Store Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getStoreType <em>Store Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getInitialContextFactory <em>Initial Context Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getProviderURL <em>Provider URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getJndiQueueName <em>Jndi Queue Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getConnectionFactory <em>Connection Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getJmsSpecVersion <em>Jms Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#isEnableCaching <em>Enable Caching</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getProviderClass <em>Provider Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageStoreImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageStoreImpl extends EsbElementImpl implements MessageStore {
	/**
	 * The default value of the '{@link #getStoreName() <em>Store Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreName()
	 * @generated
	 * @ordered
	 */
	protected static final String STORE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStoreName() <em>Store Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreName()
	 * @generated
	 * @ordered
	 */
	protected String storeName = STORE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStoreType() <em>Store Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreType()
	 * @generated
	 * @ordered
	 */
	protected static final MessageStoreType STORE_TYPE_EDEFAULT = MessageStoreType.IN_MEMORY;

	/**
	 * The cached value of the '{@link #getStoreType() <em>Store Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreType()
	 * @generated
	 * @ordered
	 */
	protected MessageStoreType storeType = STORE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialContextFactory() <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialContextFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_CONTEXT_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialContextFactory() <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialContextFactory()
	 * @generated
	 * @ordered
	 */
	protected String initialContextFactory = INITIAL_CONTEXT_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderURL() <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderURL()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderURL() <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderURL()
	 * @generated
	 * @ordered
	 */
	protected String providerURL = PROVIDER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getJndiQueueName() <em>Jndi Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJndiQueueName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_QUEUE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiQueueName() <em>Jndi Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJndiQueueName()
	 * @generated
	 * @ordered
	 */
	protected String jndiQueueName = JNDI_QUEUE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionFactory() <em>Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionFactory() <em>Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionFactory()
	 * @generated
	 * @ordered
	 */
	protected String connectionFactory = CONNECTION_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getJmsSpecVersion() <em>Jms Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJmsSpecVersion()
	 * @generated
	 * @ordered
	 */
	protected static final JMSSpecVersion JMS_SPEC_VERSION_EDEFAULT = JMSSpecVersion.JMS_11;

	/**
	 * The cached value of the '{@link #getJmsSpecVersion() <em>Jms Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJmsSpecVersion()
	 * @generated
	 * @ordered
	 */
	protected JMSSpecVersion jmsSpecVersion = JMS_SPEC_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnableCaching() <em>Enable Caching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableCaching()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_CACHING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnableCaching() <em>Enable Caching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableCaching()
	 * @generated
	 * @ordered
	 */
	protected boolean enableCaching = ENABLE_CACHING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMEOUT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected long timeout = TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderClass() <em>Provider Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderClass()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderClass() <em>Provider Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderClass()
	 * @generated
	 * @ordered
	 */
	protected String providerClass = PROVIDER_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageStoreParameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.MESSAGE_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreName(String newStoreName) {
		String oldStoreName = storeName;
		storeName = newStoreName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__STORE_NAME, oldStoreName, storeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageStoreType getStoreType() {
		return storeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreType(MessageStoreType newStoreType) {
		MessageStoreType oldStoreType = storeType;
		storeType = newStoreType == null ? STORE_TYPE_EDEFAULT : newStoreType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__STORE_TYPE, oldStoreType, storeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialContextFactory() {
		return initialContextFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialContextFactory(String newInitialContextFactory) {
		String oldInitialContextFactory = initialContextFactory;
		initialContextFactory = newInitialContextFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY, oldInitialContextFactory, initialContextFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderURL() {
		return providerURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderURL(String newProviderURL) {
		String oldProviderURL = providerURL;
		providerURL = newProviderURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__PROVIDER_URL, oldProviderURL, providerURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJndiQueueName() {
		return jndiQueueName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJndiQueueName(String newJndiQueueName) {
		String oldJndiQueueName = jndiQueueName;
		jndiQueueName = newJndiQueueName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__JNDI_QUEUE_NAME, oldJndiQueueName, jndiQueueName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionFactory() {
		return connectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionFactory(String newConnectionFactory) {
		String oldConnectionFactory = connectionFactory;
		connectionFactory = newConnectionFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__CONNECTION_FACTORY, oldConnectionFactory, connectionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSSpecVersion getJmsSpecVersion() {
		return jmsSpecVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJmsSpecVersion(JMSSpecVersion newJmsSpecVersion) {
		JMSSpecVersion oldJmsSpecVersion = jmsSpecVersion;
		jmsSpecVersion = newJmsSpecVersion == null ? JMS_SPEC_VERSION_EDEFAULT : newJmsSpecVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__JMS_SPEC_VERSION, oldJmsSpecVersion, jmsSpecVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableCaching() {
		return enableCaching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableCaching(boolean newEnableCaching) {
		boolean oldEnableCaching = enableCaching;
		enableCaching = newEnableCaching;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__ENABLE_CACHING, oldEnableCaching, enableCaching));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(long newTimeout) {
		long oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderClass() {
		return providerClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderClass(String newProviderClass) {
		String oldProviderClass = providerClass;
		providerClass = newProviderClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_STORE__PROVIDER_CLASS, oldProviderClass, providerClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageStoreParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<MessageStoreParameter>(MessageStoreParameter.class, this, EsbPackage.MESSAGE_STORE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.MESSAGE_STORE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.MESSAGE_STORE__STORE_NAME:
				return getStoreName();
			case EsbPackage.MESSAGE_STORE__STORE_TYPE:
				return getStoreType();
			case EsbPackage.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY:
				return getInitialContextFactory();
			case EsbPackage.MESSAGE_STORE__PROVIDER_URL:
				return getProviderURL();
			case EsbPackage.MESSAGE_STORE__JNDI_QUEUE_NAME:
				return getJndiQueueName();
			case EsbPackage.MESSAGE_STORE__CONNECTION_FACTORY:
				return getConnectionFactory();
			case EsbPackage.MESSAGE_STORE__USER_NAME:
				return getUserName();
			case EsbPackage.MESSAGE_STORE__PASSWORD:
				return getPassword();
			case EsbPackage.MESSAGE_STORE__JMS_SPEC_VERSION:
				return getJmsSpecVersion();
			case EsbPackage.MESSAGE_STORE__ENABLE_CACHING:
				return isEnableCaching();
			case EsbPackage.MESSAGE_STORE__TIMEOUT:
				return getTimeout();
			case EsbPackage.MESSAGE_STORE__PROVIDER_CLASS:
				return getProviderClass();
			case EsbPackage.MESSAGE_STORE__PARAMETERS:
				return getParameters();
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
			case EsbPackage.MESSAGE_STORE__STORE_NAME:
				setStoreName((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__STORE_TYPE:
				setStoreType((MessageStoreType)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY:
				setInitialContextFactory((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__PROVIDER_URL:
				setProviderURL((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__JNDI_QUEUE_NAME:
				setJndiQueueName((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__CONNECTION_FACTORY:
				setConnectionFactory((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__USER_NAME:
				setUserName((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__PASSWORD:
				setPassword((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__JMS_SPEC_VERSION:
				setJmsSpecVersion((JMSSpecVersion)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__ENABLE_CACHING:
				setEnableCaching((Boolean)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__TIMEOUT:
				setTimeout((Long)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__PROVIDER_CLASS:
				setProviderClass((String)newValue);
				return;
			case EsbPackage.MESSAGE_STORE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends MessageStoreParameter>)newValue);
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
			case EsbPackage.MESSAGE_STORE__STORE_NAME:
				setStoreName(STORE_NAME_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__STORE_TYPE:
				setStoreType(STORE_TYPE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY:
				setInitialContextFactory(INITIAL_CONTEXT_FACTORY_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__PROVIDER_URL:
				setProviderURL(PROVIDER_URL_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__JNDI_QUEUE_NAME:
				setJndiQueueName(JNDI_QUEUE_NAME_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__CONNECTION_FACTORY:
				setConnectionFactory(CONNECTION_FACTORY_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__JMS_SPEC_VERSION:
				setJmsSpecVersion(JMS_SPEC_VERSION_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__ENABLE_CACHING:
				setEnableCaching(ENABLE_CACHING_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__PROVIDER_CLASS:
				setProviderClass(PROVIDER_CLASS_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_STORE__PARAMETERS:
				getParameters().clear();
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
			case EsbPackage.MESSAGE_STORE__STORE_NAME:
				return STORE_NAME_EDEFAULT == null ? storeName != null : !STORE_NAME_EDEFAULT.equals(storeName);
			case EsbPackage.MESSAGE_STORE__STORE_TYPE:
				return storeType != STORE_TYPE_EDEFAULT;
			case EsbPackage.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY:
				return INITIAL_CONTEXT_FACTORY_EDEFAULT == null ? initialContextFactory != null : !INITIAL_CONTEXT_FACTORY_EDEFAULT.equals(initialContextFactory);
			case EsbPackage.MESSAGE_STORE__PROVIDER_URL:
				return PROVIDER_URL_EDEFAULT == null ? providerURL != null : !PROVIDER_URL_EDEFAULT.equals(providerURL);
			case EsbPackage.MESSAGE_STORE__JNDI_QUEUE_NAME:
				return JNDI_QUEUE_NAME_EDEFAULT == null ? jndiQueueName != null : !JNDI_QUEUE_NAME_EDEFAULT.equals(jndiQueueName);
			case EsbPackage.MESSAGE_STORE__CONNECTION_FACTORY:
				return CONNECTION_FACTORY_EDEFAULT == null ? connectionFactory != null : !CONNECTION_FACTORY_EDEFAULT.equals(connectionFactory);
			case EsbPackage.MESSAGE_STORE__USER_NAME:
				return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
			case EsbPackage.MESSAGE_STORE__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case EsbPackage.MESSAGE_STORE__JMS_SPEC_VERSION:
				return jmsSpecVersion != JMS_SPEC_VERSION_EDEFAULT;
			case EsbPackage.MESSAGE_STORE__ENABLE_CACHING:
				return enableCaching != ENABLE_CACHING_EDEFAULT;
			case EsbPackage.MESSAGE_STORE__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
			case EsbPackage.MESSAGE_STORE__PROVIDER_CLASS:
				return PROVIDER_CLASS_EDEFAULT == null ? providerClass != null : !PROVIDER_CLASS_EDEFAULT.equals(providerClass);
			case EsbPackage.MESSAGE_STORE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
		result.append(" (storeName: ");
		result.append(storeName);
		result.append(", storeType: ");
		result.append(storeType);
		result.append(", initialContextFactory: ");
		result.append(initialContextFactory);
		result.append(", providerURL: ");
		result.append(providerURL);
		result.append(", jndiQueueName: ");
		result.append(jndiQueueName);
		result.append(", connectionFactory: ");
		result.append(connectionFactory);
		result.append(", userName: ");
		result.append(userName);
		result.append(", password: ");
		result.append(password);
		result.append(", jmsSpecVersion: ");
		result.append(jmsSpecVersion);
		result.append(", enableCaching: ");
		result.append(enableCaching);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", providerClass: ");
		result.append(providerClass);
		result.append(')');
		return result.toString();
	}

} //MessageStoreImpl
