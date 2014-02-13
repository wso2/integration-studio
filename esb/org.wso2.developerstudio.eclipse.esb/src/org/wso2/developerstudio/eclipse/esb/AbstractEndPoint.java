/*
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
 * A representation of the model object '<em><b>Abstract End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isAddressingEnabled <em>Addressing Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getAddressingVersion <em>Addressing Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isAddressingSeparateListener <em>Addressing Separate Listener</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getTimeOutDuration <em>Time Out Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getTimeOutAction <em>Time Out Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getRetryErrorCodes <em>Retry Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getRetryCount <em>Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getRetryDelay <em>Retry Delay</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendErrorCodes <em>Suspend Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendInitialDuration <em>Suspend Initial Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendMaximumDuration <em>Suspend Maximum Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendProgressionFactor <em>Suspend Progression Factor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getReliableMessagingPolicy <em>Reliable Messaging Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSecurityPolicy <em>Security Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEndPoint extends EndPoint {
    /**
	 * Returns the value of the '<em><b>Reliable Messaging Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reliable Messaging Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Reliable Messaging Enabled</em>' attribute.
	 * @see #setReliableMessagingEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_ReliableMessagingEnabled()
	 * @model default="false"
	 * @generated
	 */
    boolean isReliableMessagingEnabled();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reliable Messaging Enabled</em>' attribute.
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 */
    void setReliableMessagingEnabled(boolean value);

    /**
	 * Returns the value of the '<em><b>Reliable Messaging Policy</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reliable Messaging Policy</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Reliable Messaging Policy</em>' reference.
	 * @see #setReliableMessagingPolicy(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_ReliableMessagingPolicy()
	 * @model
	 * @generated
	 */
    RegistryKeyProperty getReliableMessagingPolicy();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getReliableMessagingPolicy <em>Reliable Messaging Policy</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reliable Messaging Policy</em>' reference.
	 * @see #getReliableMessagingPolicy()
	 * @generated
	 */
    void setReliableMessagingPolicy(RegistryKeyProperty value);

    /**
	 * Returns the value of the '<em><b>Security Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Security Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Enabled</em>' attribute.
	 * @see #setSecurityEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_SecurityEnabled()
	 * @model default="false"
	 * @generated
	 */
    boolean isSecurityEnabled();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isSecurityEnabled <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Enabled</em>' attribute.
	 * @see #isSecurityEnabled()
	 * @generated
	 */
    void setSecurityEnabled(boolean value);

    /**
	 * Returns the value of the '<em><b>Security Policy</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Security Policy</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Policy</em>' reference.
	 * @see #setSecurityPolicy(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_SecurityPolicy()
	 * @model
	 * @generated
	 */
    RegistryKeyProperty getSecurityPolicy();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSecurityPolicy <em>Security Policy</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Policy</em>' reference.
	 * @see #getSecurityPolicy()
	 * @generated
	 */
    void setSecurityPolicy(RegistryKeyProperty value);

    /**
	 * Returns the value of the '<em><b>Addressing Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Addressing Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Addressing Enabled</em>' attribute.
	 * @see #setAddressingEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_AddressingEnabled()
	 * @model default="false"
	 * @generated
	 */
    boolean isAddressingEnabled();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isAddressingEnabled <em>Addressing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addressing Enabled</em>' attribute.
	 * @see #isAddressingEnabled()
	 * @generated
	 */
    void setAddressingEnabled(boolean value);

    /**
	 * Returns the value of the '<em><b>Addressing Version</b></em>' attribute.
	 * The default value is <code>"final"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EndPointAddressingVersion}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Addressing Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Addressing Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointAddressingVersion
	 * @see #setAddressingVersion(EndPointAddressingVersion)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_AddressingVersion()
	 * @model default="final"
	 * @generated
	 */
    EndPointAddressingVersion getAddressingVersion();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getAddressingVersion <em>Addressing Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addressing Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointAddressingVersion
	 * @see #getAddressingVersion()
	 * @generated
	 */
    void setAddressingVersion(EndPointAddressingVersion value);

    /**
	 * Returns the value of the '<em><b>Addressing Separate Listener</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Addressing Separate Listener</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Addressing Separate Listener</em>' attribute.
	 * @see #setAddressingSeparateListener(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_AddressingSeparateListener()
	 * @model default="false"
	 * @generated
	 */
    boolean isAddressingSeparateListener();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#isAddressingSeparateListener <em>Addressing Separate Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addressing Separate Listener</em>' attribute.
	 * @see #isAddressingSeparateListener()
	 * @generated
	 */
    void setAddressingSeparateListener(boolean value);

    /**
	 * Returns the value of the '<em><b>Time Out Duration</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Time Out Duration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Out Duration</em>' attribute.
	 * @see #setTimeOutDuration(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_TimeOutDuration()
	 * @model default="0"
	 * @generated
	 */
    long getTimeOutDuration();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getTimeOutDuration <em>Time Out Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Out Duration</em>' attribute.
	 * @see #getTimeOutDuration()
	 * @generated
	 */
    void setTimeOutDuration(long value);

    /**
	 * Returns the value of the '<em><b>Time Out Action</b></em>' attribute.
	 * The default value is <code>"discard"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EndPointTimeOutAction}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Time Out Action</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Out Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointTimeOutAction
	 * @see #setTimeOutAction(EndPointTimeOutAction)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_TimeOutAction()
	 * @model default="discard"
	 * @generated
	 */
    EndPointTimeOutAction getTimeOutAction();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getTimeOutAction <em>Time Out Action</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Out Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointTimeOutAction
	 * @see #getTimeOutAction()
	 * @generated
	 */
    void setTimeOutAction(EndPointTimeOutAction value);

    /**
	 * Returns the value of the '<em><b>Retry Error Codes</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Retry Error Codes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Error Codes</em>' attribute.
	 * @see #setRetryErrorCodes(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_RetryErrorCodes()
	 * @model
	 * @generated
	 */
    String getRetryErrorCodes();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getRetryErrorCodes <em>Retry Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Error Codes</em>' attribute.
	 * @see #getRetryErrorCodes()
	 * @generated
	 */
    void setRetryErrorCodes(String value);

    /**
	 * Returns the value of the '<em><b>Retry Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Retry Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Count</em>' attribute.
	 * @see #setRetryCount(int)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_RetryCount()
	 * @model default="0"
	 * @generated
	 */
    int getRetryCount();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getRetryCount <em>Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Count</em>' attribute.
	 * @see #getRetryCount()
	 * @generated
	 */
    void setRetryCount(int value);

    /**
	 * Returns the value of the '<em><b>Retry Delay</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Retry Delay</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Delay</em>' attribute.
	 * @see #setRetryDelay(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_RetryDelay()
	 * @model default="0"
	 * @generated
	 */
    long getRetryDelay();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getRetryDelay <em>Retry Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Delay</em>' attribute.
	 * @see #getRetryDelay()
	 * @generated
	 */
    void setRetryDelay(long value);

    /**
	 * Returns the value of the '<em><b>Suspend Error Codes</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suspend Error Codes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend Error Codes</em>' attribute.
	 * @see #setSuspendErrorCodes(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_SuspendErrorCodes()
	 * @model
	 * @generated
	 */
    String getSuspendErrorCodes();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendErrorCodes <em>Suspend Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Error Codes</em>' attribute.
	 * @see #getSuspendErrorCodes()
	 * @generated
	 */
    void setSuspendErrorCodes(String value);

    /**
	 * Returns the value of the '<em><b>Suspend Initial Duration</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suspend Initial Duration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend Initial Duration</em>' attribute.
	 * @see #setSuspendInitialDuration(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_SuspendInitialDuration()
	 * @model default="0"
	 * @generated
	 */
    long getSuspendInitialDuration();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendInitialDuration <em>Suspend Initial Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Initial Duration</em>' attribute.
	 * @see #getSuspendInitialDuration()
	 * @generated
	 */
    void setSuspendInitialDuration(long value);

    /**
	 * Returns the value of the '<em><b>Suspend Maximum Duration</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suspend Maximum Duration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend Maximum Duration</em>' attribute.
	 * @see #setSuspendMaximumDuration(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_SuspendMaximumDuration()
	 * @model default="0"
	 * @generated
	 */
    long getSuspendMaximumDuration();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendMaximumDuration <em>Suspend Maximum Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Maximum Duration</em>' attribute.
	 * @see #getSuspendMaximumDuration()
	 * @generated
	 */
    void setSuspendMaximumDuration(long value);

    /**
	 * Returns the value of the '<em><b>Suspend Progression Factor</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suspend Progression Factor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend Progression Factor</em>' attribute.
	 * @see #setSuspendProgressionFactor(float)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractEndPoint_SuspendProgressionFactor()
	 * @model default="1.0"
	 * @generated
	 */
    float getSuspendProgressionFactor();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint#getSuspendProgressionFactor <em>Suspend Progression Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Progression Factor</em>' attribute.
	 * @see #getSuspendProgressionFactor()
	 * @generated
	 */
    void setSuspendProgressionFactor(float value);

} // AbstractEndPoint
