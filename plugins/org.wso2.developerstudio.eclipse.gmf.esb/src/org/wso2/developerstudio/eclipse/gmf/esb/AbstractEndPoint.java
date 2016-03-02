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
 * A representation of the model object '<em><b>Abstract End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isAddressingEnabled <em>Addressing Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getAddressingVersion <em>Addressing Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isAddressingSeparateListener <em>Addressing Separate Listener</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getTimeOutDuration <em>Time Out Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getTimeOutAction <em>Time Out Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getRetryErrorCodes <em>Retry Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getRetryCount <em>Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getRetryDelay <em>Retry Delay</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendErrorCodes <em>Suspend Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendInitialDuration <em>Suspend Initial Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendMaximumDuration <em>Suspend Maximum Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendProgressionFactor <em>Suspend Progression Factor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getReliableMessagingPolicy <em>Reliable Messaging Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSecurityPolicy <em>Security Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getFormat <em>Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getOptimize <em>Optimize</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getInboundPolicy <em>Inbound Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getOutboundPolicy <em>Outbound Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint()
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_ReliableMessagingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isReliableMessagingEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reliable Messaging Enabled</em>' attribute.
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 */
	void setReliableMessagingEnabled(boolean value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_SecurityEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isSecurityEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isSecurityEnabled <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Enabled</em>' attribute.
	 * @see #isSecurityEnabled()
	 * @generated
	 */
	void setSecurityEnabled(boolean value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_AddressingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isAddressingEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isAddressingEnabled <em>Addressing Enabled</em>}' attribute.
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
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addressing Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addressing Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion
	 * @see #setAddressingVersion(EndPointAddressingVersion)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_AddressingVersion()
	 * @model default="final"
	 * @generated
	 */
	EndPointAddressingVersion getAddressingVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getAddressingVersion <em>Addressing Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addressing Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_AddressingSeparateListener()
	 * @model default="false"
	 * @generated
	 */
	boolean isAddressingSeparateListener();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isAddressingSeparateListener <em>Addressing Separate Listener</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_TimeOutDuration()
	 * @model default="0"
	 * @generated
	 */
	long getTimeOutDuration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getTimeOutDuration <em>Time Out Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Out Duration</em>' attribute.
	 * @see #getTimeOutDuration()
	 * @generated
	 */
	void setTimeOutDuration(long value);

	/**
	 * Returns the value of the '<em><b>Time Out Action</b></em>' attribute.
	 * The default value is <code>"never"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Out Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Out Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction
	 * @see #setTimeOutAction(EndPointTimeOutAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_TimeOutAction()
	 * @model default="never"
	 * @generated
	 */
	EndPointTimeOutAction getTimeOutAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getTimeOutAction <em>Time Out Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Out Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_RetryErrorCodes()
	 * @model
	 * @generated
	 */
	String getRetryErrorCodes();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getRetryErrorCodes <em>Retry Error Codes</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_RetryCount()
	 * @model default="0"
	 * @generated
	 */
	int getRetryCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getRetryCount <em>Retry Count</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_RetryDelay()
	 * @model default="0"
	 * @generated
	 */
	long getRetryDelay();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getRetryDelay <em>Retry Delay</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_SuspendErrorCodes()
	 * @model
	 * @generated
	 */
	String getSuspendErrorCodes();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendErrorCodes <em>Suspend Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Error Codes</em>' attribute.
	 * @see #getSuspendErrorCodes()
	 * @generated
	 */
	void setSuspendErrorCodes(String value);

	/**
	 * Returns the value of the '<em><b>Suspend Initial Duration</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspend Initial Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend Initial Duration</em>' attribute.
	 * @see #setSuspendInitialDuration(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_SuspendInitialDuration()
	 * @model default="-1"
	 * @generated
	 */
	long getSuspendInitialDuration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendInitialDuration <em>Suspend Initial Duration</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_SuspendMaximumDuration()
	 * @model default="0"
	 * @generated
	 */
	long getSuspendMaximumDuration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendMaximumDuration <em>Suspend Maximum Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Maximum Duration</em>' attribute.
	 * @see #getSuspendMaximumDuration()
	 * @generated
	 */
	void setSuspendMaximumDuration(long value);

	/**
	 * Returns the value of the '<em><b>Suspend Progression Factor</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspend Progression Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend Progression Factor</em>' attribute.
	 * @see #setSuspendProgressionFactor(float)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_SuspendProgressionFactor()
	 * @model default="-1"
	 * @generated
	 */
	float getSuspendProgressionFactor();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSuspendProgressionFactor <em>Suspend Progression Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend Progression Factor</em>' attribute.
	 * @see #getSuspendProgressionFactor()
	 * @generated
	 */
	void setSuspendProgressionFactor(float value);

	/**
	 * Returns the value of the '<em><b>Reliable Messaging Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reliable Messaging Policy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reliable Messaging Policy</em>' containment reference.
	 * @see #setReliableMessagingPolicy(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_ReliableMessagingPolicy()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getReliableMessagingPolicy();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getReliableMessagingPolicy <em>Reliable Messaging Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reliable Messaging Policy</em>' containment reference.
	 * @see #getReliableMessagingPolicy()
	 * @generated
	 */
	void setReliableMessagingPolicy(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Security Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Policy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Policy</em>' containment reference.
	 * @see #setSecurityPolicy(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_SecurityPolicy()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSecurityPolicy();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getSecurityPolicy <em>Security Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Policy</em>' containment reference.
	 * @see #getSecurityPolicy()
	 * @generated
	 */
	void setSecurityPolicy(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat
	 * @see #setFormat(EndPointMessageFormat)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_Format()
	 * @model
	 * @generated
	 */
	EndPointMessageFormat getFormat();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(EndPointMessageFormat value);

	/**
	 * Returns the value of the '<em><b>Optimize</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optimize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimize</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization
	 * @see #setOptimize(EndPointAttachmentOptimization)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_Optimize()
	 * @model
	 * @generated
	 */
	EndPointAttachmentOptimization getOptimize();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getOptimize <em>Optimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimize</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization
	 * @see #getOptimize()
	 * @generated
	 */
	void setOptimize(EndPointAttachmentOptimization value);

	/**
	 * Returns the value of the '<em><b>Template Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_TemplateParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateParameter> getTemplateParameters();

	/**
	 * Returns the value of the '<em><b>Statistics Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistics Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #setStatisticsEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_StatisticsEnabled()
	 * @model
	 * @generated
	 */
	boolean isStatisticsEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isStatisticsEnabled <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #isStatisticsEnabled()
	 * @generated
	 */
	void setStatisticsEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Trace Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Enabled</em>' attribute.
	 * @see #setTraceEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_TraceEnabled()
	 * @model
	 * @generated
	 */
	boolean isTraceEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#isTraceEnabled <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Enabled</em>' attribute.
	 * @see #isTraceEnabled()
	 * @generated
	 */
	void setTraceEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Inbound Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Policy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Policy</em>' containment reference.
	 * @see #setInboundPolicy(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_InboundPolicy()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInboundPolicy();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getInboundPolicy <em>Inbound Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Policy</em>' containment reference.
	 * @see #getInboundPolicy()
	 * @generated
	 */
	void setInboundPolicy(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Outbound Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outbound Policy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outbound Policy</em>' containment reference.
	 * @see #setOutboundPolicy(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractEndPoint_OutboundPolicy()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOutboundPolicy();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint#getOutboundPolicy <em>Outbound Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outbound Policy</em>' containment reference.
	 * @see #getOutboundPolicy()
	 * @generated
	 */
	void setOutboundPolicy(RegistryKeyProperty value);

} // AbstractEndPoint
