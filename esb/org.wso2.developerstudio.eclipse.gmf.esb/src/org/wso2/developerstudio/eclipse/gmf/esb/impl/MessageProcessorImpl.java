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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.EnableDisableState;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType;
import org.wso2.developerstudio.eclipse.gmf.esb.ProcessorState;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getProcessorName <em>Processor Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getProcessorType <em>Processor Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getMessageProcessorProvider <em>Message Processor Provider</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getMessageStore <em>Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getSourceMessageStore <em>Source Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getTargetMessageStore <em>Target Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getProcessorState <em>Processor State</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getEndpointName <em>Endpoint Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getRetryInterval <em>Retry Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getForwardingInterval <em>Forwarding Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getSamplingInterval <em>Sampling Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getSamplingConcurrency <em>Sampling Concurrency</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getMaxDeliveryAttempts <em>Max Delivery Attempts</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getDropMessageAfterMaximumDeliveryAttempts <em>Drop Message After Maximum Delivery Attempts</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getAxis2ClientRepository <em>Axis2 Client Repository</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getAxis2Configuration <em>Axis2 Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getReplySequenceName <em>Reply Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getFaultSequenceName <em>Fault Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getDeactivateSequenceName <em>Deactivate Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getQuartzConfigFilePath <em>Quartz Config File Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getCronExpression <em>Cron Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getNonRetryHttpStatusCodes <em>Non Retry Http Status Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageProcessorImpl#getTaskCount <em>Task Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageProcessorImpl extends EsbElementImpl implements MessageProcessor {
	/**
	 * The default value of the '{@link #getProcessorName() <em>Processor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESSOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessorName() <em>Processor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorName()
	 * @generated
	 * @ordered
	 */
	protected String processorName = PROCESSOR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessorType() <em>Processor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorType()
	 * @generated
	 * @ordered
	 */
	protected static final MessageProcessorType PROCESSOR_TYPE_EDEFAULT = MessageProcessorType.SCHEDULED_MSG_FORWARDING;

	/**
	 * The cached value of the '{@link #getProcessorType() <em>Processor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorType()
	 * @generated
	 * @ordered
	 */
	protected MessageProcessorType processorType = PROCESSOR_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageProcessorProvider() <em>Message Processor Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageProcessorProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_PROCESSOR_PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageProcessorProvider() <em>Message Processor Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageProcessorProvider()
	 * @generated
	 * @ordered
	 */
	protected String messageProcessorProvider = MESSAGE_PROCESSOR_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageStore() <em>Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageStore()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_STORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageStore() <em>Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageStore()
	 * @generated
	 * @ordered
	 */
	protected String messageStore = MESSAGE_STORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceMessageStore() <em>Source Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMessageStore()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_MESSAGE_STORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceMessageStore() <em>Source Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMessageStore()
	 * @generated
	 * @ordered
	 */
	protected String sourceMessageStore = SOURCE_MESSAGE_STORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetMessageStore() <em>Target Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMessageStore()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_MESSAGE_STORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetMessageStore() <em>Target Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMessageStore()
	 * @generated
	 * @ordered
	 */
	protected String targetMessageStore = TARGET_MESSAGE_STORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessorState() <em>Processor State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorState()
	 * @generated
	 * @ordered
	 */
	protected static final ProcessorState PROCESSOR_STATE_EDEFAULT = ProcessorState.ACTIVATE;

	/**
	 * The cached value of the '{@link #getProcessorState() <em>Processor State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorState()
	 * @generated
	 * @ordered
	 */
	protected ProcessorState processorState = PROCESSOR_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpointName() <em>Endpoint Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointName()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty endpointName;

	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequence;

	/**
	 * The default value of the '{@link #getRetryInterval() <em>Retry Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryInterval()
	 * @generated
	 * @ordered
	 */
	protected static final long RETRY_INTERVAL_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRetryInterval() <em>Retry Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryInterval()
	 * @generated
	 * @ordered
	 */
	protected long retryInterval = RETRY_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getForwardingInterval() <em>Forwarding Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final long FORWARDING_INTERVAL_EDEFAULT = 1000L;

	/**
	 * The cached value of the '{@link #getForwardingInterval() <em>Forwarding Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardingInterval()
	 * @generated
	 * @ordered
	 */
	protected long forwardingInterval = FORWARDING_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSamplingInterval() <em>Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamplingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final long SAMPLING_INTERVAL_EDEFAULT = 1000L;

	/**
	 * The cached value of the '{@link #getSamplingInterval() <em>Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamplingInterval()
	 * @generated
	 * @ordered
	 */
	protected long samplingInterval = SAMPLING_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSamplingConcurrency() <em>Sampling Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamplingConcurrency()
	 * @generated
	 * @ordered
	 */
	protected static final int SAMPLING_CONCURRENCY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getSamplingConcurrency() <em>Sampling Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamplingConcurrency()
	 * @generated
	 * @ordered
	 */
	protected int samplingConcurrency = SAMPLING_CONCURRENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxDeliveryAttempts() <em>Max Delivery Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDeliveryAttempts()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_DELIVERY_ATTEMPTS_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getMaxDeliveryAttempts() <em>Max Delivery Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDeliveryAttempts()
	 * @generated
	 * @ordered
	 */
	protected int maxDeliveryAttempts = MAX_DELIVERY_ATTEMPTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDropMessageAfterMaximumDeliveryAttempts() <em>Drop Message After Maximum Delivery Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDropMessageAfterMaximumDeliveryAttempts()
	 * @generated
	 * @ordered
	 */
	protected static final EnableDisableState DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS_EDEFAULT = EnableDisableState.DISABLED;

	/**
	 * The cached value of the '{@link #getDropMessageAfterMaximumDeliveryAttempts() <em>Drop Message After Maximum Delivery Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDropMessageAfterMaximumDeliveryAttempts()
	 * @generated
	 * @ordered
	 */
	protected EnableDisableState dropMessageAfterMaximumDeliveryAttempts = DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAxis2ClientRepository() <em>Axis2 Client Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxis2ClientRepository()
	 * @generated
	 * @ordered
	 */
	protected static final String AXIS2_CLIENT_REPOSITORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAxis2ClientRepository() <em>Axis2 Client Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxis2ClientRepository()
	 * @generated
	 * @ordered
	 */
	protected String axis2ClientRepository = AXIS2_CLIENT_REPOSITORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAxis2Configuration() <em>Axis2 Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxis2Configuration()
	 * @generated
	 * @ordered
	 */
	protected static final String AXIS2_CONFIGURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAxis2Configuration() <em>Axis2 Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxis2Configuration()
	 * @generated
	 * @ordered
	 */
	protected String axis2Configuration = AXIS2_CONFIGURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReplySequenceName() <em>Reply Sequence Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplySequenceName()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty replySequenceName;

	/**
	 * The cached value of the '{@link #getFaultSequenceName() <em>Fault Sequence Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceName()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty faultSequenceName;

	/**
	 * The cached value of the '{@link #getDeactivateSequenceName() <em>Deactivate Sequence Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeactivateSequenceName()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty deactivateSequenceName;

	/**
	 * The default value of the '{@link #getQuartzConfigFilePath() <em>Quartz Config File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuartzConfigFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String QUARTZ_CONFIG_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuartzConfigFilePath() <em>Quartz Config File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuartzConfigFilePath()
	 * @generated
	 * @ordered
	 */
	protected String quartzConfigFilePath = QUARTZ_CONFIG_FILE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCronExpression() <em>Cron Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCronExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String CRON_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCronExpression() <em>Cron Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCronExpression()
	 * @generated
	 * @ordered
	 */
	protected String cronExpression = CRON_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNonRetryHttpStatusCodes() <em>Non Retry Http Status Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonRetryHttpStatusCodes()
	 * @generated
	 * @ordered
	 */
	protected static final String NON_RETRY_HTTP_STATUS_CODES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNonRetryHttpStatusCodes() <em>Non Retry Http Status Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonRetryHttpStatusCodes()
	 * @generated
	 * @ordered
	 */
	protected String nonRetryHttpStatusCodes = NON_RETRY_HTTP_STATUS_CODES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageProcessorParameter> parameters;

	/**
	 * The default value of the '{@link #getTaskCount() <em>Task Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskCount()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskCount() <em>Task Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskCount()
	 * @generated
	 * @ordered
	 */
	protected String taskCount = TASK_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MessageProcessorImpl() {
		super();
		
		RegistryKeyProperty sequence = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>) sequence.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		sequence.setPrettyName("Sequence");
		sequence.setKeyName("key");
		sequence.setKeyValue("");
		setSequence(sequence);
		
		RegistryKeyProperty replaySequence = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) replaySequence.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		replaySequence.setPrettyName("Replay Sequence");
		replaySequence.setKeyName("key");
		replaySequence.setKeyValue("");
		setReplySequenceName(replaySequence);
		
		RegistryKeyProperty faultSequence = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) faultSequence.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		faultSequence.setPrettyName("Fault Sequence");
		faultSequence.setKeyName("key");
		faultSequence.setKeyValue("");
		setFaultSequenceName(faultSequence);
		
		RegistryKeyProperty endpointName = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>) sequence.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		endpointName.setPrettyName("Endpoint Name");
		endpointName.setKeyName("key");
		endpointName.setKeyValue("");
		setEndpointName(endpointName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.MESSAGE_PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessorName() {
		return processorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessorName(String newProcessorName) {
		String oldProcessorName = processorName;
		processorName = newProcessorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME, oldProcessorName, processorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageProcessorType getProcessorType() {
		return processorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessorType(MessageProcessorType newProcessorType) {
		MessageProcessorType oldProcessorType = processorType;
		processorType = newProcessorType == null ? PROCESSOR_TYPE_EDEFAULT : newProcessorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE, oldProcessorType, processorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessageProcessorProvider() {
		return messageProcessorProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageProcessorProvider(String newMessageProcessorProvider) {
		String oldMessageProcessorProvider = messageProcessorProvider;
		messageProcessorProvider = newMessageProcessorProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER, oldMessageProcessorProvider, messageProcessorProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessageStore() {
		return messageStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageStore(String newMessageStore) {
		String oldMessageStore = messageStore;
		messageStore = newMessageStore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE, oldMessageStore, messageStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceMessageStore() {
		return sourceMessageStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMessageStore(String newSourceMessageStore) {
		String oldSourceMessageStore = sourceMessageStore;
		sourceMessageStore = newSourceMessageStore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE, oldSourceMessageStore, sourceMessageStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetMessageStore() {
		return targetMessageStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMessageStore(String newTargetMessageStore) {
		String oldTargetMessageStore = targetMessageStore;
		targetMessageStore = newTargetMessageStore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE, oldTargetMessageStore, targetMessageStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorState getProcessorState() {
		return processorState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessorState(ProcessorState newProcessorState) {
		ProcessorState oldProcessorState = processorState;
		processorState = newProcessorState == null ? PROCESSOR_STATE_EDEFAULT : newProcessorState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_STATE, oldProcessorState, processorState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getEndpointName() {
		return endpointName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointName(RegistryKeyProperty newEndpointName, NotificationChain msgs) {
		RegistryKeyProperty oldEndpointName = endpointName;
		endpointName = newEndpointName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME, oldEndpointName, newEndpointName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointName(RegistryKeyProperty newEndpointName) {
		if (newEndpointName != endpointName) {
			NotificationChain msgs = null;
			if (endpointName != null)
				msgs = ((InternalEObject)endpointName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME, null, msgs);
			if (newEndpointName != null)
				msgs = ((InternalEObject)newEndpointName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME, null, msgs);
			msgs = basicSetEndpointName(newEndpointName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME, newEndpointName, newEndpointName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequence() {
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequence(RegistryKeyProperty newSequence, NotificationChain msgs) {
		RegistryKeyProperty oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__SEQUENCE, oldSequence, newSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequence(RegistryKeyProperty newSequence) {
		if (newSequence != sequence) {
			NotificationChain msgs = null;
			if (sequence != null)
				msgs = ((InternalEObject)sequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__SEQUENCE, null, msgs);
			if (newSequence != null)
				msgs = ((InternalEObject)newSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__SEQUENCE, null, msgs);
			msgs = basicSetSequence(newSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__SEQUENCE, newSequence, newSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRetryInterval() {
		return retryInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryInterval(long newRetryInterval) {
		long oldRetryInterval = retryInterval;
		retryInterval = newRetryInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL, oldRetryInterval, retryInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getForwardingInterval() {
		return forwardingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardingInterval(long newForwardingInterval) {
		long oldForwardingInterval = forwardingInterval;
		forwardingInterval = newForwardingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__FORWARDING_INTERVAL, oldForwardingInterval, forwardingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSamplingInterval() {
		return samplingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSamplingInterval(long newSamplingInterval) {
		long oldSamplingInterval = samplingInterval;
		samplingInterval = newSamplingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__SAMPLING_INTERVAL, oldSamplingInterval, samplingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSamplingConcurrency() {
		return samplingConcurrency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSamplingConcurrency(int newSamplingConcurrency) {
		int oldSamplingConcurrency = samplingConcurrency;
		samplingConcurrency = newSamplingConcurrency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY, oldSamplingConcurrency, samplingConcurrency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxDeliveryAttempts() {
		return maxDeliveryAttempts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxDeliveryAttempts(int newMaxDeliveryAttempts) {
		int oldMaxDeliveryAttempts = maxDeliveryAttempts;
		maxDeliveryAttempts = newMaxDeliveryAttempts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS, oldMaxDeliveryAttempts, maxDeliveryAttempts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnableDisableState getDropMessageAfterMaximumDeliveryAttempts() {
		return dropMessageAfterMaximumDeliveryAttempts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDropMessageAfterMaximumDeliveryAttempts(EnableDisableState newDropMessageAfterMaximumDeliveryAttempts) {
		EnableDisableState oldDropMessageAfterMaximumDeliveryAttempts = dropMessageAfterMaximumDeliveryAttempts;
		dropMessageAfterMaximumDeliveryAttempts = newDropMessageAfterMaximumDeliveryAttempts == null ? DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS_EDEFAULT : newDropMessageAfterMaximumDeliveryAttempts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS, oldDropMessageAfterMaximumDeliveryAttempts, dropMessageAfterMaximumDeliveryAttempts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAxis2ClientRepository() {
		return axis2ClientRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis2ClientRepository(String newAxis2ClientRepository) {
		String oldAxis2ClientRepository = axis2ClientRepository;
		axis2ClientRepository = newAxis2ClientRepository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY, oldAxis2ClientRepository, axis2ClientRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAxis2Configuration() {
		return axis2Configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis2Configuration(String newAxis2Configuration) {
		String oldAxis2Configuration = axis2Configuration;
		axis2Configuration = newAxis2Configuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION, oldAxis2Configuration, axis2Configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getReplySequenceName() {
		return replySequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplySequenceName(RegistryKeyProperty newReplySequenceName, NotificationChain msgs) {
		RegistryKeyProperty oldReplySequenceName = replySequenceName;
		replySequenceName = newReplySequenceName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME, oldReplySequenceName, newReplySequenceName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplySequenceName(RegistryKeyProperty newReplySequenceName) {
		if (newReplySequenceName != replySequenceName) {
			NotificationChain msgs = null;
			if (replySequenceName != null)
				msgs = ((InternalEObject)replySequenceName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME, null, msgs);
			if (newReplySequenceName != null)
				msgs = ((InternalEObject)newReplySequenceName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME, null, msgs);
			msgs = basicSetReplySequenceName(newReplySequenceName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME, newReplySequenceName, newReplySequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getFaultSequenceName() {
		return faultSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultSequenceName(RegistryKeyProperty newFaultSequenceName, NotificationChain msgs) {
		RegistryKeyProperty oldFaultSequenceName = faultSequenceName;
		faultSequenceName = newFaultSequenceName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME, oldFaultSequenceName, newFaultSequenceName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceName(RegistryKeyProperty newFaultSequenceName) {
		if (newFaultSequenceName != faultSequenceName) {
			NotificationChain msgs = null;
			if (faultSequenceName != null)
				msgs = ((InternalEObject)faultSequenceName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME, null, msgs);
			if (newFaultSequenceName != null)
				msgs = ((InternalEObject)newFaultSequenceName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME, null, msgs);
			msgs = basicSetFaultSequenceName(newFaultSequenceName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME, newFaultSequenceName, newFaultSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getDeactivateSequenceName() {
		return deactivateSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeactivateSequenceName(RegistryKeyProperty newDeactivateSequenceName, NotificationChain msgs) {
		RegistryKeyProperty oldDeactivateSequenceName = deactivateSequenceName;
		deactivateSequenceName = newDeactivateSequenceName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME, oldDeactivateSequenceName, newDeactivateSequenceName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeactivateSequenceName(RegistryKeyProperty newDeactivateSequenceName) {
		if (newDeactivateSequenceName != deactivateSequenceName) {
			NotificationChain msgs = null;
			if (deactivateSequenceName != null)
				msgs = ((InternalEObject)deactivateSequenceName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME, null, msgs);
			if (newDeactivateSequenceName != null)
				msgs = ((InternalEObject)newDeactivateSequenceName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME, null, msgs);
			msgs = basicSetDeactivateSequenceName(newDeactivateSequenceName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME, newDeactivateSequenceName, newDeactivateSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuartzConfigFilePath() {
		return quartzConfigFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuartzConfigFilePath(String newQuartzConfigFilePath) {
		String oldQuartzConfigFilePath = quartzConfigFilePath;
		quartzConfigFilePath = newQuartzConfigFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH, oldQuartzConfigFilePath, quartzConfigFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCronExpression() {
		return cronExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCronExpression(String newCronExpression) {
		String oldCronExpression = cronExpression;
		cronExpression = newCronExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION, oldCronExpression, cronExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNonRetryHttpStatusCodes() {
		return nonRetryHttpStatusCodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonRetryHttpStatusCodes(String newNonRetryHttpStatusCodes) {
		String oldNonRetryHttpStatusCodes = nonRetryHttpStatusCodes;
		nonRetryHttpStatusCodes = newNonRetryHttpStatusCodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES, oldNonRetryHttpStatusCodes, nonRetryHttpStatusCodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageProcessorParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<MessageProcessorParameter>(MessageProcessorParameter.class, this, EsbPackage.MESSAGE_PROCESSOR__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaskCount() {
		return taskCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskCount(String newTaskCount) {
		String oldTaskCount = taskCount;
		taskCount = newTaskCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_PROCESSOR__TASK_COUNT, oldTaskCount, taskCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME:
				return basicSetEndpointName(null, msgs);
			case EsbPackage.MESSAGE_PROCESSOR__SEQUENCE:
				return basicSetSequence(null, msgs);
			case EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME:
				return basicSetReplySequenceName(null, msgs);
			case EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME:
				return basicSetFaultSequenceName(null, msgs);
			case EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME:
				return basicSetDeactivateSequenceName(null, msgs);
			case EsbPackage.MESSAGE_PROCESSOR__PARAMETERS:
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
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME:
				return getProcessorName();
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE:
				return getProcessorType();
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER:
				return getMessageProcessorProvider();
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE:
				return getMessageStore();
			case EsbPackage.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE:
				return getSourceMessageStore();
			case EsbPackage.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE:
				return getTargetMessageStore();
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_STATE:
				return getProcessorState();
			case EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME:
				return getEndpointName();
			case EsbPackage.MESSAGE_PROCESSOR__SEQUENCE:
				return getSequence();
			case EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL:
				return getRetryInterval();
			case EsbPackage.MESSAGE_PROCESSOR__FORWARDING_INTERVAL:
				return getForwardingInterval();
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_INTERVAL:
				return getSamplingInterval();
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY:
				return getSamplingConcurrency();
			case EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS:
				return getMaxDeliveryAttempts();
			case EsbPackage.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS:
				return getDropMessageAfterMaximumDeliveryAttempts();
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY:
				return getAxis2ClientRepository();
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION:
				return getAxis2Configuration();
			case EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME:
				return getReplySequenceName();
			case EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME:
				return getFaultSequenceName();
			case EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME:
				return getDeactivateSequenceName();
			case EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH:
				return getQuartzConfigFilePath();
			case EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION:
				return getCronExpression();
			case EsbPackage.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES:
				return getNonRetryHttpStatusCodes();
			case EsbPackage.MESSAGE_PROCESSOR__PARAMETERS:
				return getParameters();
			case EsbPackage.MESSAGE_PROCESSOR__TASK_COUNT:
				return getTaskCount();
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
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME:
				setProcessorName((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE:
				setProcessorType((MessageProcessorType)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER:
				setMessageProcessorProvider((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE:
				setMessageStore((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE:
				setSourceMessageStore((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE:
				setTargetMessageStore((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_STATE:
				setProcessorState((ProcessorState)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME:
				setEndpointName((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SEQUENCE:
				setSequence((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL:
				setRetryInterval((Long)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__FORWARDING_INTERVAL:
				setForwardingInterval((Long)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_INTERVAL:
				setSamplingInterval((Long)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY:
				setSamplingConcurrency((Integer)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS:
				setMaxDeliveryAttempts((Integer)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS:
				setDropMessageAfterMaximumDeliveryAttempts((EnableDisableState)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY:
				setAxis2ClientRepository((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION:
				setAxis2Configuration((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME:
				setReplySequenceName((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME:
				setFaultSequenceName((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME:
				setDeactivateSequenceName((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH:
				setQuartzConfigFilePath((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION:
				setCronExpression((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES:
				setNonRetryHttpStatusCodes((String)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends MessageProcessorParameter>)newValue);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__TASK_COUNT:
				setTaskCount((String)newValue);
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
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME:
				setProcessorName(PROCESSOR_NAME_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE:
				setProcessorType(PROCESSOR_TYPE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER:
				setMessageProcessorProvider(MESSAGE_PROCESSOR_PROVIDER_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE:
				setMessageStore(MESSAGE_STORE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE:
				setSourceMessageStore(SOURCE_MESSAGE_STORE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE:
				setTargetMessageStore(TARGET_MESSAGE_STORE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_STATE:
				setProcessorState(PROCESSOR_STATE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME:
				setEndpointName((RegistryKeyProperty)null);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SEQUENCE:
				setSequence((RegistryKeyProperty)null);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL:
				setRetryInterval(RETRY_INTERVAL_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__FORWARDING_INTERVAL:
				setForwardingInterval(FORWARDING_INTERVAL_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_INTERVAL:
				setSamplingInterval(SAMPLING_INTERVAL_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY:
				setSamplingConcurrency(SAMPLING_CONCURRENCY_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS:
				setMaxDeliveryAttempts(MAX_DELIVERY_ATTEMPTS_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS:
				setDropMessageAfterMaximumDeliveryAttempts(DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY:
				setAxis2ClientRepository(AXIS2_CLIENT_REPOSITORY_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION:
				setAxis2Configuration(AXIS2_CONFIGURATION_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME:
				setReplySequenceName((RegistryKeyProperty)null);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME:
				setFaultSequenceName((RegistryKeyProperty)null);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME:
				setDeactivateSequenceName((RegistryKeyProperty)null);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH:
				setQuartzConfigFilePath(QUARTZ_CONFIG_FILE_PATH_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION:
				setCronExpression(CRON_EXPRESSION_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES:
				setNonRetryHttpStatusCodes(NON_RETRY_HTTP_STATUS_CODES_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_PROCESSOR__PARAMETERS:
				getParameters().clear();
				return;
			case EsbPackage.MESSAGE_PROCESSOR__TASK_COUNT:
				setTaskCount(TASK_COUNT_EDEFAULT);
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
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME:
				return PROCESSOR_NAME_EDEFAULT == null ? processorName != null : !PROCESSOR_NAME_EDEFAULT.equals(processorName);
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE:
				return processorType != PROCESSOR_TYPE_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER:
				return MESSAGE_PROCESSOR_PROVIDER_EDEFAULT == null ? messageProcessorProvider != null : !MESSAGE_PROCESSOR_PROVIDER_EDEFAULT.equals(messageProcessorProvider);
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE:
				return MESSAGE_STORE_EDEFAULT == null ? messageStore != null : !MESSAGE_STORE_EDEFAULT.equals(messageStore);
			case EsbPackage.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE:
				return SOURCE_MESSAGE_STORE_EDEFAULT == null ? sourceMessageStore != null : !SOURCE_MESSAGE_STORE_EDEFAULT.equals(sourceMessageStore);
			case EsbPackage.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE:
				return TARGET_MESSAGE_STORE_EDEFAULT == null ? targetMessageStore != null : !TARGET_MESSAGE_STORE_EDEFAULT.equals(targetMessageStore);
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_STATE:
				return processorState != PROCESSOR_STATE_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME:
				return endpointName != null;
			case EsbPackage.MESSAGE_PROCESSOR__SEQUENCE:
				return sequence != null;
			case EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL:
				return retryInterval != RETRY_INTERVAL_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__FORWARDING_INTERVAL:
				return forwardingInterval != FORWARDING_INTERVAL_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_INTERVAL:
				return samplingInterval != SAMPLING_INTERVAL_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY:
				return samplingConcurrency != SAMPLING_CONCURRENCY_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS:
				return maxDeliveryAttempts != MAX_DELIVERY_ATTEMPTS_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS:
				return dropMessageAfterMaximumDeliveryAttempts != DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS_EDEFAULT;
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY:
				return AXIS2_CLIENT_REPOSITORY_EDEFAULT == null ? axis2ClientRepository != null : !AXIS2_CLIENT_REPOSITORY_EDEFAULT.equals(axis2ClientRepository);
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION:
				return AXIS2_CONFIGURATION_EDEFAULT == null ? axis2Configuration != null : !AXIS2_CONFIGURATION_EDEFAULT.equals(axis2Configuration);
			case EsbPackage.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME:
				return replySequenceName != null;
			case EsbPackage.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME:
				return faultSequenceName != null;
			case EsbPackage.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME:
				return deactivateSequenceName != null;
			case EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH:
				return QUARTZ_CONFIG_FILE_PATH_EDEFAULT == null ? quartzConfigFilePath != null : !QUARTZ_CONFIG_FILE_PATH_EDEFAULT.equals(quartzConfigFilePath);
			case EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION:
				return CRON_EXPRESSION_EDEFAULT == null ? cronExpression != null : !CRON_EXPRESSION_EDEFAULT.equals(cronExpression);
			case EsbPackage.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES:
				return NON_RETRY_HTTP_STATUS_CODES_EDEFAULT == null ? nonRetryHttpStatusCodes != null : !NON_RETRY_HTTP_STATUS_CODES_EDEFAULT.equals(nonRetryHttpStatusCodes);
			case EsbPackage.MESSAGE_PROCESSOR__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case EsbPackage.MESSAGE_PROCESSOR__TASK_COUNT:
				return TASK_COUNT_EDEFAULT == null ? taskCount != null : !TASK_COUNT_EDEFAULT.equals(taskCount);
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
		result.append(" (processorName: ");
		result.append(processorName);
		result.append(", processorType: ");
		result.append(processorType);
		result.append(", messageProcessorProvider: ");
		result.append(messageProcessorProvider);
		result.append(", messageStore: ");
		result.append(messageStore);
		result.append(", sourceMessageStore: ");
		result.append(sourceMessageStore);
		result.append(", targetMessageStore: ");
		result.append(targetMessageStore);
		result.append(", processorState: ");
		result.append(processorState);
		result.append(", retryInterval: ");
		result.append(retryInterval);
		result.append(", forwardingInterval: ");
		result.append(forwardingInterval);
		result.append(", samplingInterval: ");
		result.append(samplingInterval);
		result.append(", samplingConcurrency: ");
		result.append(samplingConcurrency);
		result.append(", maxDeliveryAttempts: ");
		result.append(maxDeliveryAttempts);
		result.append(", dropMessageAfterMaximumDeliveryAttempts: ");
		result.append(dropMessageAfterMaximumDeliveryAttempts);
		result.append(", axis2ClientRepository: ");
		result.append(axis2ClientRepository);
		result.append(", axis2Configuration: ");
		result.append(axis2Configuration);
		result.append(", quartzConfigFilePath: ");
		result.append(quartzConfigFilePath);
		result.append(", cronExpression: ");
		result.append(cronExpression);
		result.append(", nonRetryHttpStatusCodes: ");
		result.append(nonRetryHttpStatusCodes);
		result.append(", taskCount: ");
		result.append(taskCount);
		result.append(')');
		return result.toString();
	}

} //MessageProcessorImpl
