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
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MessageProcessorItemProvider
	extends EsbElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageProcessorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		MessageProcessor messageProcessor = (MessageProcessor)object;
		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		
		super.getPropertyDescriptors(object);

		addProcessorTypePropertyDescriptor(object);
		addProcessorNamePropertyDescriptor(object);
		
		switch (messageProcessor.getProcessorType()) {
		case SCHEDULED_MSG_FORWARDING: {
			addMessageStorePropertyDescriptor(object);
			addEndpointNamePropertyDescriptor(object);
			addProcessorStatePropertyDescriptor(object);
			addForwardingIntervalPropertyDescriptor(object);
			addRetryIntervalPropertyDescriptor(object);
			addNonRetryHttpStatusCodesPropertyDescriptor(object);
			addMaxDeliveryAttemptsPropertyDescriptor(object);
			addDropMessageAfterMaximumDeliveryAttemptsPropertyDescriptor(object);
			addAxis2ClientRepositoryPropertyDescriptor(object);
			addAxis2ConfigurationPropertyDescriptor(object);
			addReplySequenceNamePropertyDescriptor(object);
			addFaultSequenceNamePropertyDescriptor(object);
			addDeactivateSequenceNamePropertyDescriptor(object);
            addQuartzConfigFilePathPropertyDescriptor(object);
			addCronExpressionPropertyDescriptor(object);
			addTaskCountPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			break;
		}
		case SCHEDULED_FAILOVER_MSG_FORWARDING: {
			addSourceMessageStorePropertyDescriptor(object);
			addTargetMessageStorePropertyDescriptor(object);
            addProcessorStatePropertyDescriptor(object);
			addForwardingIntervalPropertyDescriptor(object);
			addRetryIntervalPropertyDescriptor(object);
			addMaxDeliveryAttemptsPropertyDescriptor(object);
			addDropMessageAfterMaximumDeliveryAttemptsPropertyDescriptor(object);
			addFaultSequenceNamePropertyDescriptor(object);
			addDeactivateSequenceNamePropertyDescriptor(object);
            addQuartzConfigFilePathPropertyDescriptor(object);
			addCronExpressionPropertyDescriptor(object);
			addTaskCountPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			break;
		}
		case MSG_SAMPLING: {
			addMessageStorePropertyDescriptor(object);
			addProcessorStatePropertyDescriptor(object);
			addSequencePropertyDescriptor(object);
			addSamplingIntervalPropertyDescriptor(object);
			addSamplingConcurrencyPropertyDescriptor(object);
			addQuartzConfigFilePathPropertyDescriptor(object);
			addCronExpressionPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			break;
		}
		case CUSTOM: {
			addMessageStorePropertyDescriptor(object);
			addMessageProcessorProviderPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			break;
		}
		default:
			break;
		}
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Processor Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessorNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_processorName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_processorName_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Processor Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessorTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_processorType_feature"),
				 getString("_UI_MessageProcessor_processorType_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Message Processor Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessageProcessorProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_messageProcessorProvider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_messageProcessorProvider_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Message Store feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessageStorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_messageStore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_messageStore_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__MESSAGE_STORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Message Store feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceMessageStorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_sourceMessageStore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_sourceMessageStore_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Message Store feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetMessageStorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_targetMessageStore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_targetMessageStore_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Processor State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessorStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_processorState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_processorState_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_endpointName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_endpointName_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__ENDPOINT_NAME,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_sequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_sequence_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Retry Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRetryIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_retryInterval_feature"),
				 getString("_UI_MessageProcessor_retryInterval_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__RETRY_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Forwarding Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForwardingIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_forwardingInterval_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_forwardingInterval_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__FORWARDING_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sampling Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSamplingIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_samplingInterval_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_samplingInterval_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__SAMPLING_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sampling Concurrency feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSamplingConcurrencyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_samplingConcurrency_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_samplingConcurrency_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Delivery Attempts feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxDeliveryAttemptsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_maxDeliveryAttempts_feature"),
				 getString("_UI_MessageProcessor_maxDeliveryAttempts_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Drop Message After Maximum Delivery Attempts feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDropMessageAfterMaximumDeliveryAttemptsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_dropMessageAfterMaximumDeliveryAttempts_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_dropMessageAfterMaximumDeliveryAttempts_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Axis2 Client Repository feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAxis2ClientRepositoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_axis2ClientRepository_feature"),
				 getString("_UI_MessageProcessor_axis2ClientRepository_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Axis2 Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAxis2ConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_axis2Configuration_feature"),
				 getString("_UI_MessageProcessor_axis2Configuration_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Reply Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReplySequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_replySequenceName_feature"),
				 getString("_UI_MessageProcessor_replySequenceName_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_faultSequenceName_feature"),
				 getString("_UI_MessageProcessor_faultSequenceName_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Deactivate Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDeactivateSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_deactivateSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_deactivateSequenceName_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Quartz Config File Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQuartzConfigFilePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_quartzConfigFilePath_feature"),
				 getString("_UI_MessageProcessor_quartzConfigFilePath_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Cron Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCronExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_cronExpression_feature"),
				 getString("_UI_MessageProcessor_cronExpression_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__CRON_EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Non Retry Http Status Codes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNonRetryHttpStatusCodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_nonRetryHttpStatusCodes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_nonRetryHttpStatusCodes_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_parameters_feature"),
				 getString("_UI_MessageProcessor_parameters_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PARAMETERS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Task Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTaskCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_taskCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_taskCount_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__TASK_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.MESSAGE_PROCESSOR__ENDPOINT_NAME);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MessageProcessor.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MessageProcessor"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MessageProcessor)object).getProcessorName();
		return label == null || label.length() == 0 ?
			getString("_UI_MessageProcessor_type") :
			getString("_UI_MessageProcessor_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MessageProcessor.class)) {
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME:
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE:
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER:
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE:
			case EsbPackage.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE:
			case EsbPackage.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE:
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_STATE:
			case EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL:
			case EsbPackage.MESSAGE_PROCESSOR__FORWARDING_INTERVAL:
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_INTERVAL:
			case EsbPackage.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY:
			case EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS:
			case EsbPackage.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS:
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY:
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION:
			case EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH:
			case EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION:
			case EsbPackage.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES:
			case EsbPackage.MESSAGE_PROCESSOR__TASK_COUNT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.MESSAGE_PROCESSOR__ENDPOINT_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.MESSAGE_PROCESSOR__ENDPOINT_NAME,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));
	}

}
