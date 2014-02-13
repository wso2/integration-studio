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
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getProviderClass <em>Provider Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getParameters <em>Parameters</em>}</li>
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
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageStore_Timeout()
	 * @model
	 * @generated
	 */
	long getTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(long value);

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

} // MessageStore
