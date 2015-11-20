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
 * A representation of the model object '<em><b>Message Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getProcessorName <em>Processor Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getProcessorType <em>Processor Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getMessageProcessorProvider <em>Message Processor Provider</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getMessageStore <em>Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSourceMessageStore <em>Source Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getTargetMessageStore <em>Target Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getProcessorState <em>Processor State</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getEndpointName <em>Endpoint Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getRetryInterval <em>Retry Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getForwardingInterval <em>Forwarding Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSamplingInterval <em>Sampling Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSamplingConcurrency <em>Sampling Concurrency</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getMaxDeliveryAttempts <em>Max Delivery Attempts</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getDropMessageAfterMaximumDeliveryAttempts <em>Drop Message After Maximum Delivery Attempts</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getAxis2ClientRepository <em>Axis2 Client Repository</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getAxis2Configuration <em>Axis2 Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getReplySequenceName <em>Reply Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getFaultSequenceName <em>Fault Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getDeactivateSequenceName <em>Deactivate Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getQuartzConfigFilePath <em>Quartz Config File Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getCronExpression <em>Cron Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getNonRetryHttpStatusCodes <em>Non Retry Http Status Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getTaskCount <em>Task Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor()
 * @model
 * @generated
 */
public interface MessageProcessor extends EsbElement {
	/**
	 * Returns the value of the '<em><b>Processor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor Name</em>' attribute.
	 * @see #setProcessorName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_ProcessorName()
	 * @model
	 * @generated
	 */
	String getProcessorName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getProcessorName <em>Processor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor Name</em>' attribute.
	 * @see #getProcessorName()
	 * @generated
	 */
	void setProcessorName(String value);

	/**
	 * Returns the value of the '<em><b>Processor Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType
	 * @see #setProcessorType(MessageProcessorType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_ProcessorType()
	 * @model
	 * @generated
	 */
	MessageProcessorType getProcessorType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getProcessorType <em>Processor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType
	 * @see #getProcessorType()
	 * @generated
	 */
	void setProcessorType(MessageProcessorType value);

	/**
	 * Returns the value of the '<em><b>Message Processor Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Processor Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Processor Provider</em>' attribute.
	 * @see #setMessageProcessorProvider(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_MessageProcessorProvider()
	 * @model
	 * @generated
	 */
	String getMessageProcessorProvider();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getMessageProcessorProvider <em>Message Processor Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Processor Provider</em>' attribute.
	 * @see #getMessageProcessorProvider()
	 * @generated
	 */
	void setMessageProcessorProvider(String value);

	/**
	 * Returns the value of the '<em><b>Message Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Store</em>' attribute.
	 * @see #setMessageStore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_MessageStore()
	 * @model
	 * @generated
	 */
	String getMessageStore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getMessageStore <em>Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Store</em>' attribute.
	 * @see #getMessageStore()
	 * @generated
	 */
	void setMessageStore(String value);

	/**
	 * Returns the value of the '<em><b>Source Message Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Message Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Message Store</em>' attribute.
	 * @see #setSourceMessageStore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_SourceMessageStore()
	 * @model
	 * @generated
	 */
	String getSourceMessageStore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSourceMessageStore <em>Source Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Message Store</em>' attribute.
	 * @see #getSourceMessageStore()
	 * @generated
	 */
	void setSourceMessageStore(String value);

	/**
	 * Returns the value of the '<em><b>Target Message Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Message Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Message Store</em>' attribute.
	 * @see #setTargetMessageStore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_TargetMessageStore()
	 * @model
	 * @generated
	 */
	String getTargetMessageStore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getTargetMessageStore <em>Target Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Message Store</em>' attribute.
	 * @see #getTargetMessageStore()
	 * @generated
	 */
	void setTargetMessageStore(String value);

	/**
	 * Returns the value of the '<em><b>Processor State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ProcessorState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor State</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ProcessorState
	 * @see #setProcessorState(ProcessorState)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_ProcessorState()
	 * @model
	 * @generated
	 */
	ProcessorState getProcessorState();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getProcessorState <em>Processor State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor State</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ProcessorState
	 * @see #getProcessorState()
	 * @generated
	 */
	void setProcessorState(ProcessorState value);

	/**
	 * Returns the value of the '<em><b>Endpoint Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Name</em>' containment reference.
	 * @see #setEndpointName(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_EndpointName()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getEndpointName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getEndpointName <em>Endpoint Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Name</em>' containment reference.
	 * @see #getEndpointName()
	 * @generated
	 */
	void setEndpointName(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' containment reference.
	 * @see #setSequence(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_Sequence()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSequence <em>Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence</em>' containment reference.
	 * @see #getSequence()
	 * @generated
	 */
	void setSequence(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Retry Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Interval</em>' attribute.
	 * @see #setRetryInterval(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_RetryInterval()
	 * @model
	 * @generated
	 */
	long getRetryInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getRetryInterval <em>Retry Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Interval</em>' attribute.
	 * @see #getRetryInterval()
	 * @generated
	 */
	void setRetryInterval(long value);

	/**
	 * Returns the value of the '<em><b>Forwarding Interval</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forwarding Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forwarding Interval</em>' attribute.
	 * @see #setForwardingInterval(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_ForwardingInterval()
	 * @model default="1000"
	 * @generated
	 */
	long getForwardingInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getForwardingInterval <em>Forwarding Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forwarding Interval</em>' attribute.
	 * @see #getForwardingInterval()
	 * @generated
	 */
	void setForwardingInterval(long value);

	/**
	 * Returns the value of the '<em><b>Sampling Interval</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sampling Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampling Interval</em>' attribute.
	 * @see #setSamplingInterval(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_SamplingInterval()
	 * @model default="1000"
	 * @generated
	 */
	long getSamplingInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSamplingInterval <em>Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampling Interval</em>' attribute.
	 * @see #getSamplingInterval()
	 * @generated
	 */
	void setSamplingInterval(long value);

	/**
	 * Returns the value of the '<em><b>Sampling Concurrency</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sampling Concurrency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampling Concurrency</em>' attribute.
	 * @see #setSamplingConcurrency(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_SamplingConcurrency()
	 * @model default="1"
	 * @generated
	 */
	int getSamplingConcurrency();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getSamplingConcurrency <em>Sampling Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampling Concurrency</em>' attribute.
	 * @see #getSamplingConcurrency()
	 * @generated
	 */
	void setSamplingConcurrency(int value);

	/**
	 * Returns the value of the '<em><b>Max Delivery Attempts</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Delivery Attempts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Delivery Attempts</em>' attribute.
	 * @see #setMaxDeliveryAttempts(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_MaxDeliveryAttempts()
	 * @model default="4"
	 * @generated
	 */
	int getMaxDeliveryAttempts();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getMaxDeliveryAttempts <em>Max Delivery Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Delivery Attempts</em>' attribute.
	 * @see #getMaxDeliveryAttempts()
	 * @generated
	 */
	void setMaxDeliveryAttempts(int value);

	/**
	 * Returns the value of the '<em><b>Drop Message After Maximum Delivery Attempts</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EnableDisableState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drop Message After Maximum Delivery Attempts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drop Message After Maximum Delivery Attempts</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnableDisableState
	 * @see #setDropMessageAfterMaximumDeliveryAttempts(EnableDisableState)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts()
	 * @model
	 * @generated
	 */
	EnableDisableState getDropMessageAfterMaximumDeliveryAttempts();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getDropMessageAfterMaximumDeliveryAttempts <em>Drop Message After Maximum Delivery Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drop Message After Maximum Delivery Attempts</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnableDisableState
	 * @see #getDropMessageAfterMaximumDeliveryAttempts()
	 * @generated
	 */
	void setDropMessageAfterMaximumDeliveryAttempts(EnableDisableState value);

	/**
	 * Returns the value of the '<em><b>Axis2 Client Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis2 Client Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis2 Client Repository</em>' attribute.
	 * @see #setAxis2ClientRepository(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_Axis2ClientRepository()
	 * @model
	 * @generated
	 */
	String getAxis2ClientRepository();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getAxis2ClientRepository <em>Axis2 Client Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis2 Client Repository</em>' attribute.
	 * @see #getAxis2ClientRepository()
	 * @generated
	 */
	void setAxis2ClientRepository(String value);

	/**
	 * Returns the value of the '<em><b>Axis2 Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis2 Configuration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis2 Configuration</em>' attribute.
	 * @see #setAxis2Configuration(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_Axis2Configuration()
	 * @model
	 * @generated
	 */
	String getAxis2Configuration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getAxis2Configuration <em>Axis2 Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis2 Configuration</em>' attribute.
	 * @see #getAxis2Configuration()
	 * @generated
	 */
	void setAxis2Configuration(String value);

	/**
	 * Returns the value of the '<em><b>Reply Sequence Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply Sequence Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply Sequence Name</em>' containment reference.
	 * @see #setReplySequenceName(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_ReplySequenceName()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getReplySequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getReplySequenceName <em>Reply Sequence Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reply Sequence Name</em>' containment reference.
	 * @see #getReplySequenceName()
	 * @generated
	 */
	void setReplySequenceName(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Name</em>' containment reference.
	 * @see #setFaultSequenceName(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_FaultSequenceName()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getFaultSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getFaultSequenceName <em>Fault Sequence Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Name</em>' containment reference.
	 * @see #getFaultSequenceName()
	 * @generated
	 */
	void setFaultSequenceName(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Deactivate Sequence Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deactivate Sequence Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deactivate Sequence Name</em>' containment reference.
	 * @see #setDeactivateSequenceName(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_DeactivateSequenceName()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getDeactivateSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getDeactivateSequenceName <em>Deactivate Sequence Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deactivate Sequence Name</em>' containment reference.
	 * @see #getDeactivateSequenceName()
	 * @generated
	 */
	void setDeactivateSequenceName(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Quartz Config File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quartz Config File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quartz Config File Path</em>' attribute.
	 * @see #setQuartzConfigFilePath(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_QuartzConfigFilePath()
	 * @model
	 * @generated
	 */
	String getQuartzConfigFilePath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getQuartzConfigFilePath <em>Quartz Config File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quartz Config File Path</em>' attribute.
	 * @see #getQuartzConfigFilePath()
	 * @generated
	 */
	void setQuartzConfigFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Cron Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cron Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cron Expression</em>' attribute.
	 * @see #setCronExpression(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_CronExpression()
	 * @model
	 * @generated
	 */
	String getCronExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getCronExpression <em>Cron Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cron Expression</em>' attribute.
	 * @see #getCronExpression()
	 * @generated
	 */
	void setCronExpression(String value);

	/**
	 * Returns the value of the '<em><b>Non Retry Http Status Codes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Retry Http Status Codes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Retry Http Status Codes</em>' attribute.
	 * @see #setNonRetryHttpStatusCodes(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_NonRetryHttpStatusCodes()
	 * @model
	 * @generated
	 */
	String getNonRetryHttpStatusCodes();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getNonRetryHttpStatusCodes <em>Non Retry Http Status Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Retry Http Status Codes</em>' attribute.
	 * @see #getNonRetryHttpStatusCodes()
	 * @generated
	 */
	void setNonRetryHttpStatusCodes(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<MessageProcessorParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Task Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Count</em>' attribute.
	 * @see #setTaskCount(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageProcessor_TaskCount()
	 * @model
	 * @generated
	 */
	String getTaskCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor#getTaskCount <em>Task Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Count</em>' attribute.
	 * @see #getTaskCount()
	 * @generated
	 */
	void setTaskCount(String value);

} // MessageProcessor
