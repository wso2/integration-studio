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
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;

/**
 * This is the item provider adapter for a
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class InboundEndpointItemProvider extends EsbElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InboundEndpointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		InboundEndpoint inboundEndpoint = (InboundEndpoint) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addNamePropertyDescriptor(object);
		addTypePropertyDescriptor(object);

		switch (inboundEndpoint.getType()) {
		case HTTP:
			addInboundHttpPortPropertyDescriptor(object);
			addApiDispatchingEnabledPropertyDescriptor(object);
			break;
		case FILE:
			addSequentialPropertyDescriptor(object);
			addCoordinationPropertyDescriptor(object);
			addTransportVFSFileURIPropertyDescriptor(object);
			addTransportVFSContentTypePropertyDescriptor(object);
			addTransportVFSFileNamePatternPropertyDescriptor(object);
			addTransportVFSFileProcessIntervalPropertyDescriptor(object);
			addTransportVFSFileProcessCountPropertyDescriptor(object);
			addTransportVFSLockingPropertyDescriptor(object);
			addTransportVFSMaxRetryCountPropertyDescriptor(object);
			addTransportVFSReconnectTimeoutPropertyDescriptor(object);
			addTransportVFSActionAfterProcessPropertyDescriptor(object);
			addTransportVFSMoveAfterProcessPropertyDescriptor(object);
			addTransportVFSActionAfterErrorsPropertyDescriptor(object);
			addTransportVFSMoveAfterErrorsPropertyDescriptor(object);
			addTransportVFSActionAfterFailurePropertyDescriptor(object);
			addTransportVFSMoveAfterFailurePropertyDescriptor(object);
			addTransportVFSAutoLockReleasePropertyDescriptor(object);
			addTransportVFSAutoLockReleaseIntervalPropertyDescriptor(object);
			addTransportVFSLockReleaseSameNodePropertyDescriptor(object);
			addTransportVFSDistributedLockPropertyDescriptor(object);
			addTransportVFSDistributedTimeoutPropertyDescriptor(object);
			addTransportVFSFileSortAttributePropertyDescriptor(object);
			addTransportVFSFileSortAscendingPropertyDescriptor(object);
			addTransportVFSSubFolderTimestampFormatPropertyDescriptor(object);
			addTransportVFSCreateFolderPropertyDescriptor(object);
			break;
		case JMS:
			addSequentialPropertyDescriptor(object);
			addCoordinationPropertyDescriptor(object);
			addIntervalPropertyDescriptor(object);
			addJavaNamingFactoryInitialPropertyDescriptor(object);
			addJavaNamingProviderUrlPropertyDescriptor(object);
			addTransportJMSConnectionFactoryJNDINamePropertyDescriptor(object);
			addTransportJMSConnectionFactoryTypePropertyDescriptor(object);
			addTransportJMSDestinationPropertyDescriptor(object);
			addTransportJMSSessionTransactedPropertyDescriptor(object);
			addTransportJMSSessionAcknowledgementPropertyDescriptor(object);
			addTransportJMSCacheLevelPropertyDescriptor(object);
			addTransportJMSUserNamePropertyDescriptor(object);
			addTransportJMSPasswordPropertyDescriptor(object);
			addTransportJMSJMSSpecVersionPropertyDescriptor(object);
			addTransportJMSSubscriptionDurablePropertyDescriptor(object);
			addTransportJMSDurableSubscriberClientIDPropertyDescriptor(object);
			addTransportJMSMessageSelectorPropertyDescriptor(object);
			addTransportJMSReceiveTimeoutPropertyDescriptor(object);
			addTransportJMSContentTypePropertyDescriptor(object);
			break;
		case CUSTOM:
			addClassPropertyDescriptor(object);
			addIntervalPropertyDescriptor(object);
			addSequentialPropertyDescriptor(object);
			addCoordinationPropertyDescriptor(object);
			addServiceParametersPropertyDescriptor(object);
			break;
		case HTTPS:
			addInboundHttpPortPropertyDescriptor(object);
			addKeystorePropertyDescriptor(object);
			addApiDispatchingEnabledPropertyDescriptor(object);
			addTruststorePropertyDescriptor(object);
			addSslVerifyClientPropertyDescriptor(object);
			addSslProtocolPropertyDescriptor(object);
			addHttpsProtocolsPropertyDescriptor(object);
			addCertificateRevocationVerifierPropertyDescriptor(object);
			break;
		case HL7:
			addInboundHL7PortPropertyDescriptor(object);
			addInboundHL7AutoAckPropertyDescriptor(object);
			addInboundHL7TimeOutPropertyDescriptor(object);
			addInboundHL7MessagePreProcessorPropertyDescriptor(object);
			addInboundHL7CharSetPropertyDescriptor(object);
			addInboundHL7ValidateMessagePropertyDescriptor(object);
			addInboundHL7BuildInvalidMessagesPropertyDescriptor(object);
			addInboundHL7PassThroughInvalidMessagesPropertyDescriptor(object);
			break;
		case KAFKA:
			addIntervalPropertyDescriptor(object);
			addSequentialPropertyDescriptor(object);
			addCoordinationPropertyDescriptor(object);
			addZookeeperConnectPropertyDescriptor(object);
			addGroupIdPropertyDescriptor(object);
			addConsumerTypePropertyDescriptor(object);
			addContentTypePropertyDescriptor(object);
			addTopicsPropertyDescriptor(object);
			addSimpleTopicPropertyDescriptor(object);
			addSimpleBrokersPropertyDescriptor(object);
			addSimplePortPropertyDescriptor(object);
			addSimplePartitionPropertyDescriptor(object);
			addSimpleMaxMessagesToReadPropertyDescriptor(object);
			addThreadCountPropertyDescriptor(object);
			addZookeeperSessionTimeoutMsPropertyDescriptor(object);
			addZookeeperSyncTimeMsPropertyDescriptor(object);
			addAutoCommitIntervalMsPropertyDescriptor(object);
			addAutoOffsetResetPropertyDescriptor(object);
			break;
		case CXF_WS_RM:
			addInboundCxfRmHostPropertyDescriptor(object);
			addInboundCxfRmPortPropertyDescriptor(object);
			addInboundCxfRmConfigFilePropertyDescriptor(object);
			addEnableSSLPropertyDescriptor(object);
			break;
		default:
			break;
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_name_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_type_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	protected void addInboundHL7PortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7Port_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7Port_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Auto Ack feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7AutoAckPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7AutoAck_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7AutoAck_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Message Pre Processor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7MessagePreProcessorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7MessagePreProcessor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7MessagePreProcessor_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Char Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7CharSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7CharSet_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7CharSet_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Time Out feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7TimeOutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7TimeOut_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7TimeOut_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Validate Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7ValidateMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7ValidateMessage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7ValidateMessage_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Build Invalid Messages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7BuildInvalidMessagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7BuildInvalidMessages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7BuildInvalidMessages_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound HL7 Pass Through Invalid Messages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundHL7PassThroughInvalidMessagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundHL7PassThroughInvalidMessages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHL7PassThroughInvalidMessages_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Zookeeper Connect feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addZookeeperConnectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_zookeeperConnect_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_zookeeperConnect_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Group Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addGroupIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_groupId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_groupId_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__GROUP_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Consumer Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addConsumerTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_consumerType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_consumerType_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__CONSUMER_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Content Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addContentTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_contentType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_contentType_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__CONTENT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Topics feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTopicsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_topics_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_topics_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__TOPICS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Topic feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSimpleTopicPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_simpleTopic_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_simpleTopic_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_TOPIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Brokers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSimpleBrokersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_simpleBrokers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_simpleBrokers_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_BROKERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSimplePortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_simplePort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_simplePort_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Partition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSimplePartitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_simplePartition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_simplePartition_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_PARTITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Max Messages To Read feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSimpleMaxMessagesToReadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_simpleMaxMessagesToRead_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_simpleMaxMessagesToRead_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Thread Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addThreadCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_threadCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_threadCount_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__THREAD_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Zookeeper Session Timeout Ms feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addZookeeperSessionTimeoutMsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_zookeeperSessionTimeoutMs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_zookeeperSessionTimeoutMs_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Zookeeper Sync Time Ms feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addZookeeperSyncTimeMsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_zookeeperSyncTimeMs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_zookeeperSyncTimeMs_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Auto Commit Interval Ms feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAutoCommitIntervalMsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_autoCommitIntervalMs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_autoCommitIntervalMs_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Auto Offset Reset feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAutoOffsetResetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_autoOffsetReset_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_autoOffsetReset_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__AUTO_OFFSET_RESET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound Cxf Rm Host feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundCxfRmHostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundCxfRmHost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundCxfRmHost_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound Cxf Rm Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundCxfRmPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundCxfRmPort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundCxfRmPort_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound Cxf Rm Config File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundCxfRmConfigFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_inboundCxfRmConfigFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundCxfRmConfigFile_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable SSL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addEnableSSLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_enableSSL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_enableSSL_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__ENABLE_SSL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Service Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addServiceParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_serviceParameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_serviceParameters_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS,
				 true,
				 false,
				 true,
				 null,
				 "Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Class feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_class_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_class_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__CLASS, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Protocol feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addProtocolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_protocol_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_protocol_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__PROTOCOL, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Inbound Http Port feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addInboundHttpPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_inboundHttpPort_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_inboundHttpPort_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HTTP_PORT, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Interval feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_interval_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_interval_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__INTERVAL, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Sequential feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addSequentialPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_sequential_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_sequential_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENTIAL, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Coordination feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addCoordinationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_coordination_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_coordination_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__COORDINATION, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS File URI feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSFileURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSFileURI_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportVFSFileURI_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Content Type
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSContentTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSContentType_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportVFSContentType_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS File Name Pattern
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSFileNamePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSFileNamePattern_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSFileNamePattern_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS File Process
	 * Interval feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSFileProcessIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSFileProcessInterval_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSFileProcessInterval_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS File Process Count
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSFileProcessCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSFileProcessCount_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSFileProcessCount_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Locking feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSLockingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSLocking_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportVFSLocking_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Max Retry Count
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSMaxRetryCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSMaxRetryCount_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSMaxRetryCount_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Reconnect Timeout
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSReconnectTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSReconnectTimeout_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSReconnectTimeout_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Action After
	 * Process feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSActionAfterProcessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSActionAfterProcess_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSActionAfterProcess_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Move After Process
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSMoveAfterProcessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSMoveAfterProcess_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSMoveAfterProcess_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Action After Errors
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSActionAfterErrorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSActionAfterErrors_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSActionAfterErrors_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Move After Errors
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSMoveAfterErrorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSMoveAfterErrors_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSMoveAfterErrors_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Action After
	 * Failure feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSActionAfterFailurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSActionAfterFailure_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSActionAfterFailure_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Move After Failure
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSMoveAfterFailurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSMoveAfterFailure_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSMoveAfterFailure_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Auto Lock Release
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSAutoLockReleasePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSAutoLockRelease_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSAutoLockRelease_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Auto Lock Release
	 * Interval feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSAutoLockReleaseIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSAutoLockReleaseInterval_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSAutoLockReleaseInterval_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Lock Release Same
	 * Node feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSLockReleaseSameNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSLockReleaseSameNode_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSLockReleaseSameNode_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Distributed Lock
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSDistributedLockPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSDistributedLock_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSDistributedLock_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Distributed Timeout
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSDistributedTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSDistributedTimeout_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSDistributedTimeout_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Java Naming Factory Initial
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addJavaNamingFactoryInitialPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_javaNamingFactoryInitial_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_javaNamingFactoryInitial_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Java Naming Provider Url feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addJavaNamingProviderUrlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_javaNamingProviderUrl_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_javaNamingProviderUrl_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Connection Factory
	 * JNDI Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSConnectionFactoryJNDINamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_InboundEndpoint_transportJMSConnectionFactoryJNDIName_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_InboundEndpoint_transportJMSConnectionFactoryJNDIName_feature",
								"_UI_InboundEndpoint_type"),
						EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Connection Factory
	 * Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSConnectionFactoryTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSConnectionFactoryType_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSConnectionFactoryType_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Destination
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSDestinationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSDestination_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportJMSDestination_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Session Transacted
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSSessionTransactedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSSessionTransacted_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSSessionTransacted_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Session
	 * Acknowledgement feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSSessionAcknowledgementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSSessionAcknowledgement_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSSessionAcknowledgement_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Cache Level
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSCacheLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSCacheLevel_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportJMSCacheLevel_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS User Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSUserNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSUserName_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportJMSUserName_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Password feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSPassword_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportJMSPassword_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMSJMS Spec Version
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSJMSSpecVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSJMSSpecVersion_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSJMSSpecVersion_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Subscription
	 * Durable feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSSubscriptionDurablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSSubscriptionDurable_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSSubscriptionDurable_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Durable Subscriber
	 * Client ID feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSDurableSubscriberClientIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_InboundEndpoint_transportJMSDurableSubscriberClientID_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_InboundEndpoint_transportJMSDurableSubscriberClientID_feature",
								"_UI_InboundEndpoint_type"),
						EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Message Selector
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSMessageSelectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSMessageSelector_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSMessageSelector_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Api Dispatching Enabled feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addApiDispatchingEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_apiDispatchingEnabled_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_apiDispatchingEnabled_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Move Timestamp Format feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransportVFSMoveTimestampFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_transportVFSMoveTimestampFormat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportVFSMoveTimestampFormat_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS File Sort Attribute
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSFileSortAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSFileSortAttribute_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSFileSortAttribute_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS File Sort Ascending
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSFileSortAscendingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSFileSortAscending_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportVFSFileSortAscending_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Sub Folder
	 * Timestamp Format feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSSubFolderTimestampFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_InboundEndpoint_transportVFSSubFolderTimestampFormat_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_InboundEndpoint_transportVFSSubFolderTimestampFormat_feature",
								"_UI_InboundEndpoint_type"),
						EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport VFS Create Folder
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportVFSCreateFolderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportVFSCreateFolder_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportVFSCreateFolder_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER,
				true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Receive Timeout
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSReceiveTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSReceiveTimeout_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_transportJMSReceiveTimeout_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Transport JMS Content Type
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTransportJMSContentTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_transportJMSContentType_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_transportJMSContentType_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Truststore feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addTruststorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_truststore_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_truststore_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__TRUSTSTORE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Keystore feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addKeystorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_keystore_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_keystore_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__KEYSTORE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Ssl Verify Client feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addSslVerifyClientPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_sslVerifyClient_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_sslVerifyClient_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Ssl Protocol feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addSslProtocolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_sslProtocol_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_sslProtocol_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__SSL_PROTOCOL, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Https Protocols feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addHttpsProtocolsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_httpsProtocols_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_httpsProtocols_feature",
						"_UI_InboundEndpoint_type"), EsbPackage.Literals.INBOUND_ENDPOINT__HTTPS_PROTOCOLS, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This adds a property descriptor for the Certificate Revocation Verifier
	 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addCertificateRevocationVerifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InboundEndpoint_certificateRevocationVerifier_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_InboundEndpoint_certificateRevocationVerifier_feature", "_UI_InboundEndpoint_type"),
				EsbPackage.Literals.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, "Parameters", null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__CONTAINER);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns InboundEndpoint.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InboundEndpoint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InboundEndpoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InboundEndpoint_type") :
			getString("_UI_InboundEndpoint_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(InboundEndpoint.class)) {
			case EsbPackage.INBOUND_ENDPOINT__NAME:
			case EsbPackage.INBOUND_ENDPOINT__TYPE:
			case EsbPackage.INBOUND_ENDPOINT__CLASS:
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HTTP_PORT:
			case EsbPackage.INBOUND_ENDPOINT__INTERVAL:
			case EsbPackage.INBOUND_ENDPOINT__SEQUENTIAL:
			case EsbPackage.INBOUND_ENDPOINT__COORDINATION:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT:
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL:
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR:
			case EsbPackage.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT:
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE:
			case EsbPackage.INBOUND_ENDPOINT__TRUSTSTORE:
			case EsbPackage.INBOUND_ENDPOINT__KEYSTORE:
			case EsbPackage.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT:
			case EsbPackage.INBOUND_ENDPOINT__SSL_PROTOCOL:
			case EsbPackage.INBOUND_ENDPOINT__HTTPS_PROTOCOLS:
			case EsbPackage.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PORT:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES:
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT:
			case EsbPackage.INBOUND_ENDPOINT__GROUP_ID:
			case EsbPackage.INBOUND_ENDPOINT__CONSUMER_TYPE:
			case EsbPackage.INBOUND_ENDPOINT__CONTENT_TYPE:
			case EsbPackage.INBOUND_ENDPOINT__TOPICS:
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_TOPIC:
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_BROKERS:
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PORT:
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PARTITION:
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ:
			case EsbPackage.INBOUND_ENDPOINT__THREAD_COUNT:
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS:
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS:
			case EsbPackage.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS:
			case EsbPackage.INBOUND_ENDPOINT__AUTO_OFFSET_RESET:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT:
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE:
			case EsbPackage.INBOUND_ENDPOINT__ENABLE_SSL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
			case EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointSequenceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointSequenceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointOnErrorSequenceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointOnErrorSequenceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__CONTAINER,
				 EsbFactory.eINSTANCE.createInboundEndpointContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS,
				 EsbFactory.eINSTANCE.createInboundEndpointParameter()));
	}

}
