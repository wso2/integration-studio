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
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getStoreName <em>Store Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getStoreType <em>Store Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getInitialContextFactory <em>Initial Context Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getProviderURL <em>Provider URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJndiQueueName <em>Jndi Queue Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getConnectionFactory <em>Connection Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJmsSpecVersion <em>Jms Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#isEnableCaching <em>Enable Caching</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getProviderClass <em>Provider Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQServerHostName <em>Rabbit MQ Server Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQServerHostPort <em>Rabbit MQ Server Host Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQQueueName <em>Rabbit MQ Queue Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQExchangeName <em>Rabbit MQ Exchange Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRoutingKey <em>Routing Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQUserName <em>Rabbit MQ User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQPassword <em>Rabbit MQ Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getVirtualHost <em>Virtual Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcDatabaseTable <em>Jdbc Database Table</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcConnectionInformation <em>Jdbc Connection Information</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcDriver <em>Jdbc Driver</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcURL <em>Jdbc URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcUser <em>Jdbc User</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcPassword <em>Jdbc Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcDatasourceName <em>Jdbc Datasource Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#isEnableProducerGuaranteedDelivery <em>Enable Producer Guaranteed Delivery</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getFailoverMessageStore <em>Failover Message Store</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore()
 * @model
 * @generated
 */
public interface MessageStore extends EsbElement {
	/**
	 * Returns the value of the '<em><b>Store Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Name</em>' attribute.
	 * @see #setStoreName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_StoreName()
	 * @model
	 * @generated
	 */
	String getStoreName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getStoreName <em>Store Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Name</em>' attribute.
	 * @see #getStoreName()
	 * @generated
	 */
	void setStoreName(String value);

	/**
	 * Returns the value of the '<em><b>Store Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType
	 * @see #setStoreType(MessageStoreType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_StoreType()
	 * @model
	 * @generated
	 */
	MessageStoreType getStoreType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getStoreType <em>Store Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType
	 * @see #getStoreType()
	 * @generated
	 */
	void setStoreType(MessageStoreType value);

	/**
	 * Returns the value of the '<em><b>Initial Context Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Context Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Context Factory</em>' attribute.
	 * @see #setInitialContextFactory(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_InitialContextFactory()
	 * @model
	 * @generated
	 */
	String getInitialContextFactory();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getInitialContextFactory <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Context Factory</em>' attribute.
	 * @see #getInitialContextFactory()
	 * @generated
	 */
	void setInitialContextFactory(String value);

	/**
	 * Returns the value of the '<em><b>Provider URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider URL</em>' attribute.
	 * @see #setProviderURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_ProviderURL()
	 * @model
	 * @generated
	 */
	String getProviderURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getProviderURL <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider URL</em>' attribute.
	 * @see #getProviderURL()
	 * @generated
	 */
	void setProviderURL(String value);

	/**
	 * Returns the value of the '<em><b>Jndi Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jndi Queue Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jndi Queue Name</em>' attribute.
	 * @see #setJndiQueueName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JndiQueueName()
	 * @model
	 * @generated
	 */
	String getJndiQueueName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJndiQueueName <em>Jndi Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Queue Name</em>' attribute.
	 * @see #getJndiQueueName()
	 * @generated
	 */
	void setJndiQueueName(String value);

	/**
	 * Returns the value of the '<em><b>Connection Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Factory</em>' attribute.
	 * @see #setConnectionFactory(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_ConnectionFactory()
	 * @model
	 * @generated
	 */
	String getConnectionFactory();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getConnectionFactory <em>Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Factory</em>' attribute.
	 * @see #getConnectionFactory()
	 * @generated
	 */
	void setConnectionFactory(String value);

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_UserName()
	 * @model
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Jms Spec Version</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jms Spec Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jms Spec Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion
	 * @see #setJmsSpecVersion(JMSSpecVersion)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JmsSpecVersion()
	 * @model
	 * @generated
	 */
	JMSSpecVersion getJmsSpecVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJmsSpecVersion <em>Jms Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jms Spec Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion
	 * @see #getJmsSpecVersion()
	 * @generated
	 */
	void setJmsSpecVersion(JMSSpecVersion value);

	/**
	 * Returns the value of the '<em><b>Enable Caching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Caching</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Caching</em>' attribute.
	 * @see #setEnableCaching(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_EnableCaching()
	 * @model
	 * @generated
	 */
	boolean isEnableCaching();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#isEnableCaching <em>Enable Caching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Caching</em>' attribute.
	 * @see #isEnableCaching()
	 * @generated
	 */
	void setEnableCaching(boolean value);

	/**
	 * Returns the value of the '<em><b>Provider Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Class</em>' attribute.
	 * @see #setProviderClass(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_ProviderClass()
	 * @model
	 * @generated
	 */
	String getProviderClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getProviderClass <em>Provider Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Class</em>' attribute.
	 * @see #getProviderClass()
	 * @generated
	 */
	void setProviderClass(String value);

	/**
	 * Returns the value of the '<em><b>Rabbit MQ Server Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rabbit MQ Server Host Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rabbit MQ Server Host Name</em>' attribute.
	 * @see #setRabbitMQServerHostName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RabbitMQServerHostName()
	 * @model
	 * @generated
	 */
	String getRabbitMQServerHostName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQServerHostName <em>Rabbit MQ Server Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rabbit MQ Server Host Name</em>' attribute.
	 * @see #getRabbitMQServerHostName()
	 * @generated
	 */
	void setRabbitMQServerHostName(String value);

	/**
	 * Returns the value of the '<em><b>Rabbit MQ Server Host Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rabbit MQ Server Host Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rabbit MQ Server Host Port</em>' attribute.
	 * @see #setRabbitMQServerHostPort(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RabbitMQServerHostPort()
	 * @model
	 * @generated
	 */
	String getRabbitMQServerHostPort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQServerHostPort <em>Rabbit MQ Server Host Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rabbit MQ Server Host Port</em>' attribute.
	 * @see #getRabbitMQServerHostPort()
	 * @generated
	 */
	void setRabbitMQServerHostPort(String value);

	/**
	 * Returns the value of the '<em><b>Rabbit MQ Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rabbit MQ Queue Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rabbit MQ Queue Name</em>' attribute.
	 * @see #setRabbitMQQueueName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RabbitMQQueueName()
	 * @model
	 * @generated
	 */
	String getRabbitMQQueueName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQQueueName <em>Rabbit MQ Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rabbit MQ Queue Name</em>' attribute.
	 * @see #getRabbitMQQueueName()
	 * @generated
	 */
	void setRabbitMQQueueName(String value);

	/**
	 * Returns the value of the '<em><b>Rabbit MQ Exchange Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rabbit MQ Exchange Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rabbit MQ Exchange Name</em>' attribute.
	 * @see #setRabbitMQExchangeName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RabbitMQExchangeName()
	 * @model
	 * @generated
	 */
	String getRabbitMQExchangeName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQExchangeName <em>Rabbit MQ Exchange Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rabbit MQ Exchange Name</em>' attribute.
	 * @see #getRabbitMQExchangeName()
	 * @generated
	 */
	void setRabbitMQExchangeName(String value);

	/**
	 * Returns the value of the '<em><b>Routing Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routing Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routing Key</em>' attribute.
	 * @see #setRoutingKey(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RoutingKey()
	 * @model
	 * @generated
	 */
	String getRoutingKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRoutingKey <em>Routing Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routing Key</em>' attribute.
	 * @see #getRoutingKey()
	 * @generated
	 */
	void setRoutingKey(String value);

	/**
	 * Returns the value of the '<em><b>Rabbit MQ User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rabbit MQ User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rabbit MQ User Name</em>' attribute.
	 * @see #setRabbitMQUserName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RabbitMQUserName()
	 * @model
	 * @generated
	 */
	String getRabbitMQUserName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQUserName <em>Rabbit MQ User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rabbit MQ User Name</em>' attribute.
	 * @see #getRabbitMQUserName()
	 * @generated
	 */
	void setRabbitMQUserName(String value);

	/**
	 * Returns the value of the '<em><b>Rabbit MQ Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rabbit MQ Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rabbit MQ Password</em>' attribute.
	 * @see #setRabbitMQPassword(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_RabbitMQPassword()
	 * @model
	 * @generated
	 */
	String getRabbitMQPassword();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getRabbitMQPassword <em>Rabbit MQ Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rabbit MQ Password</em>' attribute.
	 * @see #getRabbitMQPassword()
	 * @generated
	 */
	void setRabbitMQPassword(String value);

	/**
	 * Returns the value of the '<em><b>Virtual Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Host</em>' attribute.
	 * @see #setVirtualHost(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_VirtualHost()
	 * @model
	 * @generated
	 */
	String getVirtualHost();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getVirtualHost <em>Virtual Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual Host</em>' attribute.
	 * @see #getVirtualHost()
	 * @generated
	 */
	void setVirtualHost(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc Database Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Database Table</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Database Table</em>' attribute.
	 * @see #setJdbcDatabaseTable(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcDatabaseTable()
	 * @model
	 * @generated
	 */
	String getJdbcDatabaseTable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcDatabaseTable <em>Jdbc Database Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Database Table</em>' attribute.
	 * @see #getJdbcDatabaseTable()
	 * @generated
	 */
	void setJdbcDatabaseTable(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc Connection Information</b></em>' attribute.
	 * The default value is <code>"JDBC_POOL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Connection Information</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Connection Information</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType
	 * @see #setJdbcConnectionInformation(JDBCConnectionInformationType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcConnectionInformation()
	 * @model default="JDBC_POOL"
	 * @generated
	 */
	JDBCConnectionInformationType getJdbcConnectionInformation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcConnectionInformation <em>Jdbc Connection Information</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Connection Information</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType
	 * @see #getJdbcConnectionInformation()
	 * @generated
	 */
	void setJdbcConnectionInformation(JDBCConnectionInformationType value);

	/**
	 * Returns the value of the '<em><b>Jdbc Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Driver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Driver</em>' attribute.
	 * @see #setJdbcDriver(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcDriver()
	 * @model
	 * @generated
	 */
	String getJdbcDriver();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcDriver <em>Jdbc Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Driver</em>' attribute.
	 * @see #getJdbcDriver()
	 * @generated
	 */
	void setJdbcDriver(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc URL</em>' attribute.
	 * @see #setJdbcURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcURL()
	 * @model
	 * @generated
	 */
	String getJdbcURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcURL <em>Jdbc URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc URL</em>' attribute.
	 * @see #getJdbcURL()
	 * @generated
	 */
	void setJdbcURL(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc User</em>' attribute.
	 * @see #setJdbcUser(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcUser()
	 * @model
	 * @generated
	 */
	String getJdbcUser();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcUser <em>Jdbc User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc User</em>' attribute.
	 * @see #getJdbcUser()
	 * @generated
	 */
	void setJdbcUser(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Password</em>' attribute.
	 * @see #setJdbcPassword(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcPassword()
	 * @model
	 * @generated
	 */
	String getJdbcPassword();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcPassword <em>Jdbc Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Password</em>' attribute.
	 * @see #getJdbcPassword()
	 * @generated
	 */
	void setJdbcPassword(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc Datasource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Datasource Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Datasource Name</em>' attribute.
	 * @see #setJdbcDatasourceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_JdbcDatasourceName()
	 * @model
	 * @generated
	 */
	String getJdbcDatasourceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getJdbcDatasourceName <em>Jdbc Datasource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Datasource Name</em>' attribute.
	 * @see #getJdbcDatasourceName()
	 * @generated
	 */
	void setJdbcDatasourceName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<MessageStoreParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Enable Producer Guaranteed Delivery</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Producer Guaranteed Delivery</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Producer Guaranteed Delivery</em>' attribute.
	 * @see #setEnableProducerGuaranteedDelivery(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_EnableProducerGuaranteedDelivery()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnableProducerGuaranteedDelivery();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#isEnableProducerGuaranteedDelivery <em>Enable Producer Guaranteed Delivery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Producer Guaranteed Delivery</em>' attribute.
	 * @see #isEnableProducerGuaranteedDelivery()
	 * @generated
	 */
	void setEnableProducerGuaranteedDelivery(boolean value);

	/**
	 * Returns the value of the '<em><b>Failover Message Store</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failover Message Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failover Message Store</em>' attribute.
	 * @see #setFailoverMessageStore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_FailoverMessageStore()
	 * @model default=""
	 * @generated
	 */
	String getFailoverMessageStore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getFailoverMessageStore <em>Failover Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failover Message Store</em>' attribute.
	 * @see #getFailoverMessageStore()
	 * @generated
	 */
	void setFailoverMessageStore(String value);

} // MessageStore
