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
 * A representation of the model object '<em><b>Inbound Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceInputConnector <em>Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceOutputConnector <em>Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundEndpointBehaviour <em>Inbound Endpoint Behaviour</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHttpPort <em>Inbound Http Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeCore <em>Inbound Worker Pool Size Core</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeMax <em>Inbound Worker Pool Size Max</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerThreadKeepAliveSec <em>Inbound Worker Thread Keep Alive Sec</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolQueueLength <em>Inbound Worker Pool Queue Length</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadGroupId <em>Inbound Thread Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadId <em>Inbound Thread Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getDispatchFilterPattern <em>Dispatch Filter Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSequential <em>Sequential</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isCoordination <em>Coordination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileURI <em>Transport VFS File URI</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWso2mbConnectionUrl <em>Wso2mb Connection Url</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSContentType <em>Transport VFS Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileNamePattern <em>Transport VFS File Name Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessInterval <em>Transport VFS File Process Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessCount <em>Transport VFS File Process Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSLocking <em>Transport VFS Locking</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMaxRetryCount <em>Transport VFS Max Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterFailedMove <em>Transport VFS Move After Failed Move</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReconnectTimeout <em>Transport VFS Reconnect Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSSharedSubscription <em>Transport JMS Shared Subscription</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSubscriptionName <em>Transport JMS Subscription Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPinnedServers <em>Transport JMS Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterProcess <em>Transport VFS Action After Process</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterProcess <em>Transport VFS Move After Process</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterErrors <em>Transport VFS Action After Errors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterErrors <em>Transport VFS Move After Errors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFailedRecordsFileName <em>Transport VFS Failed Records File Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFailedRecordsFileDestination <em>Transport VFS Failed Records File Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveFailedRecordTimestampFormat <em>Transport VFS Move Failed Record Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFailedRecordNextRetryDuration <em>Transport VFS Failed Record Next Retry Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterFailure <em>Transport VFS Action After Failure</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterFailure <em>Transport VFS Move After Failure</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReplyFileURI <em>Transport VFS Reply File URI</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReplyFileName <em>Transport VFS Reply File Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSAutoLockRelease <em>Transport VFS Auto Lock Release</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSAutoLockReleaseInterval <em>Transport VFS Auto Lock Release Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSLockReleaseSameNode <em>Transport VFS Lock Release Same Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSDistributedLock <em>Transport VFS Distributed Lock</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSStreaming <em>Transport VFS Streaming</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSBuild <em>Transport VFS Build</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSDistributedTimeout <em>Transport VFS Distributed Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSFTPIdentities <em>Transport VFSSFTP Identities</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSFTPIdentityPassPhrase <em>Transport VFSSFTP Identity Pass Phrase</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSSFTPUserDirIsRoot <em>Transport VFSSFTP User Dir Is Root</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingFactoryInitial <em>Java Naming Factory Initial</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingProviderUrl <em>Java Naming Provider Url</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryJNDIName <em>Transport JMS Connection Factory JNDI Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryType <em>Transport JMS Connection Factory Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConcurrentConsumers <em>Transport JMS Concurrent Consumers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDestination <em>Transport JMS Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSSessionTransacted <em>Transport JMS Session Transacted</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSessionAcknowledgement <em>Transport JMS Session Acknowledgement</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSCacheLevel <em>Transport JMS Cache Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSUserName <em>Transport JMS User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPassword <em>Transport JMS Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSJMSSpecVersion <em>Transport JMSJMS Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSubscriptionDurable <em>Transport JMS Subscription Durable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDurableSubscriberClientID <em>Transport JMS Durable Subscriber Client ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSMessageSelector <em>Transport JMS Message Selector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSRetryDuration <em>Transport JMS Retry Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveTimestampFormat <em>Transport VFS Move Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileSortAttribute <em>Transport VFS File Sort Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSFileSortAscending <em>Transport VFS File Sort Ascending</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSubFolderTimestampFormat <em>Transport VFS Sub Folder Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSCreateFolder <em>Transport VFS Create Folder</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReceiveTimeout <em>Transport JMS Receive Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentType <em>Transport JMS Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentTypeProperty <em>Transport JMS Content Type Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReplyDestination <em>Transport JMS Reply Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPubSubNoLocal <em>Transport JMS Pub Sub No Local</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDurableSubscriberName <em>Transport JMS Durable Subscriber Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSBrokerType <em>Transport JMS Broker Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTConnectionFactory <em>Transport MQTT Connection Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerHostName <em>Transport MQTT Server Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerPort <em>Transport MQTT Server Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTopicName <em>Transport MQTT Topic Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionQOS <em>Transport MQTT Subscription QOS</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportMQTTSessionClean <em>Transport MQTT Session Clean</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslEnable <em>Transport MQTT Ssl Enable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTemporaryStoreDirectory <em>Transport MQTT Temporary Store Directory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionUsername <em>Transport MQTT Subscription Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionPassword <em>Transport MQTT Subscription Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTClientId <em>Transport MQTT Client Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTruststore <em>Truststore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getKeystore <em>Keystore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslVerifyClient <em>Ssl Verify Client</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslProtocol <em>Ssl Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getHttpsProtocols <em>Https Protocols</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getCertificateRevocationVerifier <em>Certificate Revocation Verifier</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7Port <em>Inbound HL7 Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7AutoAck <em>Inbound HL7 Auto Ack</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7MessagePreProcessor <em>Inbound HL7 Message Pre Processor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7CharSet <em>Inbound HL7 Char Set</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7TimeOut <em>Inbound HL7 Time Out</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7ValidateMessage <em>Inbound HL7 Validate Message</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7BuildInvalidMessages <em>Inbound HL7 Build Invalid Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7PassThroughInvalidMessages <em>Inbound HL7 Pass Through Invalid Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperConnect <em>Zookeeper Connect</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerType <em>Consumer Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicsOrTopicFilter <em>Topics Or Topic Filter</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicsName <em>Topics Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicFilterFrom <em>Topic Filter From</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicFilterName <em>Topic Filter Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerTopic <em>Simple Consumer Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerBrokers <em>Simple Consumer Brokers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerPort <em>Simple Consumer Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerPartition <em>Simple Consumer Partition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerMaxMessagesToRead <em>Simple Consumer Max Messages To Read</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getThreadCount <em>Thread Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerId <em>Consumer Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSocketTimeoutMs <em>Socket Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSocketReceiveBufferBytes <em>Socket Receive Buffer Bytes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getFetchMessageMaxBytes <em>Fetch Message Max Bytes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getNumConsumerFetches <em>Num Consumer Fetches</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isAutoCommitEnable <em>Auto Commit Enable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoCommitIntervalMs <em>Auto Commit Interval Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getQueuedMaxMessageChunks <em>Queued Max Message Chunks</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getRebalanceMaxRetries <em>Rebalance Max Retries</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getFetchMinBytes <em>Fetch Min Bytes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getFetchWaitMaxMs <em>Fetch Wait Max Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getRebalanceBackoffMs <em>Rebalance Backoff Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getRefreshLeaderBackoffMs <em>Refresh Leader Backoff Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoOffsetReset <em>Auto Offset Reset</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerTimeoutMs <em>Consumer Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isExcludeInternalTopics <em>Exclude Internal Topics</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getPartitionAssignmentStrategy <em>Partition Assignment Strategy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getClientId <em>Client Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSessionTimeoutMs <em>Zookeeper Session Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperConnectionTimeoutMs <em>Zookeeper Connection Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSyncTimeMs <em>Zookeeper Sync Time Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsStorage <em>Offsets Storage</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsChannelBackoffMs <em>Offsets Channel Backoff Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsChannelSocketTimeoutMs <em>Offsets Channel Socket Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsCommitMaxRetries <em>Offsets Commit Max Retries</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isDualCommitEnabled <em>Dual Commit Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmHost <em>Inbound Cxf Rm Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmPort <em>Inbound Cxf Rm Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmConfigFile <em>Inbound Cxf Rm Config File</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isEnableSSL <em>Enable SSL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSuspend <em>Suspend</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionFactory <em>Transport Rabbit Mq Connection Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerHostName <em>Transport Rabbit Mq Server Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerPort <em>Transport Rabbit Mq Server Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerUserName <em>Transport Rabbit Mq Server User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerPassword <em>Transport Rabbit Mq Server Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueName <em>Transport Rabbit Mq Queue Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeName <em>Transport Rabbit Mq Exchange Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueDurable <em>Transport Rabbit Mq Queue Durable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueExclusive <em>Transport Rabbit Mq Queue Exclusive</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueAutoDelete <em>Transport Rabbit Mq Queue Auto Delete</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueAutoAck <em>Transport Rabbit Mq Queue Auto Ack</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueRoutingKey <em>Transport Rabbit Mq Queue Routing Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueDeliveryMode <em>Transport Rabbit Mq Queue Delivery Mode</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeType <em>Transport Rabbit Mq Exchange Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeDurable <em>Transport Rabbit Mq Exchange Durable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeAutoDelete <em>Transport Rabbit Mq Exchange Auto Delete</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerVirtualHost <em>Transport Rabbit Mq Server Virtual Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqFactoryHeartbeat <em>Transport Rabbit Mq Factory Heartbeat</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslEnabled <em>Transport Rabbit Mq Connection Ssl Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslKeystoreLocation <em>Transport Rabbit Mq Connection Ssl Keystore Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslKeystoreType <em>Transport Rabbit Mq Connection Ssl Keystore Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslKeystorePassword <em>Transport Rabbit Mq Connection Ssl Keystore Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslTruststoreLocation <em>Transport Rabbit Mq Connection Ssl Truststore Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslTruststoreType <em>Transport Rabbit Mq Connection Ssl Truststore Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslTruststorePassword <em>Transport Rabbit Mq Connection Ssl Truststore Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslVersion <em>Transport Rabbit Mq Connection Ssl Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqMessageContentType <em>Transport Rabbit Mq Message Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionRetryCount <em>Transport Rabbit Mq Connection Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionRetryInterval <em>Transport Rabbit Mq Connection Retry Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerRetryInterval <em>Transport Rabbit Mq Server Retry Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerQosKey <em>Transport Rabbit Mq Consumer Qos Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsInboundPort <em>Ws Inbound Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsClientSideBroadcastLevel <em>Ws Client Side Broadcast Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsOutflowDispatchSequence <em>Ws Outflow Dispatch Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsOutflowDispatchFaultSequence <em>Ws Outflow Dispatch Fault Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsBossThreadPoolSize <em>Ws Boss Thread Pool Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsWorkerThreadPoolSize <em>Ws Worker Thread Pool Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsSubprotocolHandlerClass <em>Ws Subprotocol Handler Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsPipelineHandlerClass <em>Ws Pipeline Handler Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportFeedURL <em>Transport Feed URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportFeedType <em>Transport Feed Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSRetriesBeforeSuspension <em>Transport JMS Retries Before Suspension</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSResetConnectionOnPollingSuspension <em>Transport JMS Reset Connection On Polling Suspension</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPollingSuspensionPeriod <em>Transport JMS Polling Suspension Period</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslKeystoreLocation <em>Transport MQTT Ssl Keystore Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslKeystoreType <em>Transport MQTT Ssl Keystore Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslKeystorePassword <em>Transport MQTT Ssl Keystore Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslTruststoreLocation <em>Transport MQTT Ssl Truststore Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslTruststoreType <em>Transport MQTT Ssl Truststore Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslTruststorePassword <em>Transport MQTT Ssl Truststore Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslVersion <em>Transport MQTT Ssl Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslKeyStoreFile <em>Wss Ssl Key Store File</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslKeyStorePass <em>Wss Ssl Key Store Pass</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslTrustStoreFile <em>Wss Ssl Trust Store File</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslTrustStorePass <em>Wss Ssl Trust Store Pass</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslCertPass <em>Wss Ssl Cert Pass</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsDefaultContentType <em>Ws Default Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsShutdownStatusCode <em>Ws Shutdown Status Code</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsShutdownStatusMessage <em>Ws Shutdown Status Message</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isWsUsePortOffset <em>Ws Use Port Offset</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslProtocols <em>Wss Ssl Protocols</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslCipherSuites <em>Wss Ssl Cipher Suites</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerQos <em>Transport Rabbit Mq Consumer Qos</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerQosType <em>Transport Rabbit Mq Consumer Qos Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDBUrl <em>Transport JMSDB Url</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportRabbitMqAutoDeclare <em>Transport Rabbit Mq Auto Declare</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqMaxDeadLetteredCount <em>Transport Rabbit Mq Max Dead Lettered Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqRequeueDelay <em>Transport Rabbit Mq Requeue Delay</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportRabbitMqExchangeAutoDeclare <em>Transport Rabbit Mq Exchange Auto Declare</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerTag <em>Transport Rabbit Mq Consumer Tag</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqErrorQueueRoutingKey <em>Transport Rabbit Mq Error Queue Routing Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqErrorExchangeName <em>Transport Rabbit Mq Error Exchange Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqFactoryConnectionTimeout <em>Transport Rabbit Mq Factory Connection Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqFactoryNetworkRecoveryInterval <em>Transport Rabbit Mq Factory Network Recovery Interval</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint()
 * @model
 * @generated
 */
public interface InboundEndpoint extends EsbElement {
    /**
     * Returns the value of the '<em><b>Sequence Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sequence Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sequence Input Connector</em>' containment reference.
     * @see #setSequenceInputConnector(InboundEndpointSequenceInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SequenceInputConnector()
     * @model containment="true"
     * @generated
     */
    InboundEndpointSequenceInputConnector getSequenceInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceInputConnector <em>Sequence Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sequence Input Connector</em>' containment reference.
     * @see #getSequenceInputConnector()
     * @generated
     */
    void setSequenceInputConnector(InboundEndpointSequenceInputConnector value);

    /**
     * Returns the value of the '<em><b>Sequence Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sequence Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sequence Output Connector</em>' containment reference.
     * @see #setSequenceOutputConnector(InboundEndpointSequenceOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SequenceOutputConnector()
     * @model containment="true"
     * @generated
     */
    InboundEndpointSequenceOutputConnector getSequenceOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceOutputConnector <em>Sequence Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sequence Output Connector</em>' containment reference.
     * @see #getSequenceOutputConnector()
     * @generated
     */
    void setSequenceOutputConnector(InboundEndpointSequenceOutputConnector value);

    /**
     * Returns the value of the '<em><b>On Error Sequence Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Error Sequence Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Error Sequence Input Connector</em>' containment reference.
     * @see #setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequenceInputConnector()
     * @model containment="true"
     * @generated
     */
    InboundEndpointOnErrorSequenceInputConnector getOnErrorSequenceInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Error Sequence Input Connector</em>' containment reference.
     * @see #getOnErrorSequenceInputConnector()
     * @generated
     */
    void setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector value);

    /**
     * Returns the value of the '<em><b>On Error Sequence Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Error Sequence Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Error Sequence Output Connector</em>' containment reference.
     * @see #setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequenceOutputConnector()
     * @model containment="true"
     * @generated
     */
    InboundEndpointOnErrorSequenceOutputConnector getOnErrorSequenceOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Error Sequence Output Connector</em>' containment reference.
     * @see #getOnErrorSequenceOutputConnector()
     * @generated
     */
    void setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector value);

    /**
     * Returns the value of the '<em><b>Container</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' containment reference.
     * @see #setContainer(InboundEndpointContainer)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Container()
     * @model containment="true"
     * @generated
     */
    InboundEndpointContainer getContainer();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContainer <em>Container</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' containment reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer(InboundEndpointContainer value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType
     * @see #setType(InboundEndpointType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Type()
     * @model
     * @generated
     */
    InboundEndpointType getType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType
     * @see #getType()
     * @generated
     */
    void setType(InboundEndpointType value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Port</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Port</em>' attribute.
     * @see #setInboundHL7Port(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7Port()
     * @model default=""
     * @generated
     */
    String getInboundHL7Port();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7Port <em>Inbound HL7 Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Port</em>' attribute.
     * @see #getInboundHL7Port()
     * @generated
     */
    void setInboundHL7Port(String value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Auto Ack</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Auto Ack</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Auto Ack</em>' attribute.
     * @see #setInboundHL7AutoAck(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7AutoAck()
     * @model default="true"
     * @generated
     */
    boolean isInboundHL7AutoAck();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7AutoAck <em>Inbound HL7 Auto Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Auto Ack</em>' attribute.
     * @see #isInboundHL7AutoAck()
     * @generated
     */
    void setInboundHL7AutoAck(boolean value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Message Pre Processor</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Message Pre Processor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Message Pre Processor</em>' attribute.
     * @see #setInboundHL7MessagePreProcessor(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7MessagePreProcessor()
     * @model default=""
     * @generated
     */
    String getInboundHL7MessagePreProcessor();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7MessagePreProcessor <em>Inbound HL7 Message Pre Processor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Message Pre Processor</em>' attribute.
     * @see #getInboundHL7MessagePreProcessor()
     * @generated
     */
    void setInboundHL7MessagePreProcessor(String value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Char Set</b></em>' attribute.
     * The default value is <code>"UTF-8"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Char Set</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Char Set</em>' attribute.
     * @see #setInboundHL7CharSet(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7CharSet()
     * @model default="UTF-8"
     * @generated
     */
    String getInboundHL7CharSet();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7CharSet <em>Inbound HL7 Char Set</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Char Set</em>' attribute.
     * @see #getInboundHL7CharSet()
     * @generated
     */
    void setInboundHL7CharSet(String value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Time Out</b></em>' attribute.
     * The default value is <code>"10000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Time Out</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Time Out</em>' attribute.
     * @see #setInboundHL7TimeOut(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7TimeOut()
     * @model default="10000"
     * @generated
     */
    String getInboundHL7TimeOut();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7TimeOut <em>Inbound HL7 Time Out</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Time Out</em>' attribute.
     * @see #getInboundHL7TimeOut()
     * @generated
     */
    void setInboundHL7TimeOut(String value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Validate Message</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Validate Message</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Validate Message</em>' attribute.
     * @see #setInboundHL7ValidateMessage(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7ValidateMessage()
     * @model default="true"
     * @generated
     */
    boolean isInboundHL7ValidateMessage();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7ValidateMessage <em>Inbound HL7 Validate Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Validate Message</em>' attribute.
     * @see #isInboundHL7ValidateMessage()
     * @generated
     */
    void setInboundHL7ValidateMessage(boolean value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Build Invalid Messages</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Build Invalid Messages</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Build Invalid Messages</em>' attribute.
     * @see #setInboundHL7BuildInvalidMessages(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7BuildInvalidMessages()
     * @model default="true"
     * @generated
     */
    boolean isInboundHL7BuildInvalidMessages();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7BuildInvalidMessages <em>Inbound HL7 Build Invalid Messages</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Build Invalid Messages</em>' attribute.
     * @see #isInboundHL7BuildInvalidMessages()
     * @generated
     */
    void setInboundHL7BuildInvalidMessages(boolean value);

    /**
     * Returns the value of the '<em><b>Inbound HL7 Pass Through Invalid Messages</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound HL7 Pass Through Invalid Messages</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound HL7 Pass Through Invalid Messages</em>' attribute.
     * @see #setInboundHL7PassThroughInvalidMessages(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7PassThroughInvalidMessages()
     * @model default="true"
     * @generated
     */
    boolean isInboundHL7PassThroughInvalidMessages();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7PassThroughInvalidMessages <em>Inbound HL7 Pass Through Invalid Messages</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound HL7 Pass Through Invalid Messages</em>' attribute.
     * @see #isInboundHL7PassThroughInvalidMessages()
     * @generated
     */
    void setInboundHL7PassThroughInvalidMessages(boolean value);

    /**
     * Returns the value of the '<em><b>Zookeeper Connect</b></em>' attribute.
     * The default value is <code>"localhost:2181"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zookeeper Connect</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zookeeper Connect</em>' attribute.
     * @see #setZookeeperConnect(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperConnect()
     * @model default="localhost:2181"
     * @generated
     */
    String getZookeeperConnect();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperConnect <em>Zookeeper Connect</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zookeeper Connect</em>' attribute.
     * @see #getZookeeperConnect()
     * @generated
     */
    void setZookeeperConnect(String value);

    /**
     * Returns the value of the '<em><b>Group Id</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Group Id</em>' attribute.
     * @see #setGroupId(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_GroupId()
     * @model default=""
     * @generated
     */
    String getGroupId();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getGroupId <em>Group Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Group Id</em>' attribute.
     * @see #getGroupId()
     * @generated
     */
    void setGroupId(String value);

    /**
     * Returns the value of the '<em><b>Consumer Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consumer Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Consumer Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType
     * @see #setConsumerType(ConsumerType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ConsumerType()
     * @model
     * @generated
     */
    ConsumerType getConsumerType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerType <em>Consumer Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Consumer Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType
     * @see #getConsumerType()
     * @generated
     */
    void setConsumerType(ConsumerType value);

    /**
     * Returns the value of the '<em><b>Topics Or Topic Filter</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.TopicsType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Topics Or Topic Filter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Topics Or Topic Filter</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.TopicsType
     * @see #setTopicsOrTopicFilter(TopicsType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TopicsOrTopicFilter()
     * @model
     * @generated
     */
    TopicsType getTopicsOrTopicFilter();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicsOrTopicFilter <em>Topics Or Topic Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topics Or Topic Filter</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.TopicsType
     * @see #getTopicsOrTopicFilter()
     * @generated
     */
    void setTopicsOrTopicFilter(TopicsType value);

    /**
     * Returns the value of the '<em><b>Topics Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Topics Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Topics Name</em>' attribute.
     * @see #setTopicsName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TopicsName()
     * @model
     * @generated
     */
    String getTopicsName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicsName <em>Topics Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topics Name</em>' attribute.
     * @see #getTopicsName()
     * @generated
     */
    void setTopicsName(String value);

    /**
     * Returns the value of the '<em><b>Topic Filter From</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Topic Filter From</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Topic Filter From</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType
     * @see #setTopicFilterFrom(TopicFilterFromType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TopicFilterFrom()
     * @model
     * @generated
     */
    TopicFilterFromType getTopicFilterFrom();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicFilterFrom <em>Topic Filter From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topic Filter From</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType
     * @see #getTopicFilterFrom()
     * @generated
     */
    void setTopicFilterFrom(TopicFilterFromType value);

    /**
     * Returns the value of the '<em><b>Topic Filter Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Topic Filter Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Topic Filter Name</em>' attribute.
     * @see #setTopicFilterName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TopicFilterName()
     * @model
     * @generated
     */
    String getTopicFilterName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopicFilterName <em>Topic Filter Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topic Filter Name</em>' attribute.
     * @see #getTopicFilterName()
     * @generated
     */
    void setTopicFilterName(String value);

    /**
     * Returns the value of the '<em><b>Simple Consumer Topic</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Simple Consumer Topic</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Consumer Topic</em>' attribute.
     * @see #setSimpleConsumerTopic(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleConsumerTopic()
     * @model
     * @generated
     */
    String getSimpleConsumerTopic();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerTopic <em>Simple Consumer Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Consumer Topic</em>' attribute.
     * @see #getSimpleConsumerTopic()
     * @generated
     */
    void setSimpleConsumerTopic(String value);

    /**
     * Returns the value of the '<em><b>Simple Consumer Brokers</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Simple Consumer Brokers</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Consumer Brokers</em>' attribute.
     * @see #setSimpleConsumerBrokers(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleConsumerBrokers()
     * @model
     * @generated
     */
    String getSimpleConsumerBrokers();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerBrokers <em>Simple Consumer Brokers</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Consumer Brokers</em>' attribute.
     * @see #getSimpleConsumerBrokers()
     * @generated
     */
    void setSimpleConsumerBrokers(String value);

    /**
     * Returns the value of the '<em><b>Simple Consumer Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Simple Consumer Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Consumer Port</em>' attribute.
     * @see #setSimpleConsumerPort(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleConsumerPort()
     * @model
     * @generated
     */
    String getSimpleConsumerPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerPort <em>Simple Consumer Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Consumer Port</em>' attribute.
     * @see #getSimpleConsumerPort()
     * @generated
     */
    void setSimpleConsumerPort(String value);

    /**
     * Returns the value of the '<em><b>Simple Consumer Partition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Simple Consumer Partition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Consumer Partition</em>' attribute.
     * @see #setSimpleConsumerPartition(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleConsumerPartition()
     * @model
     * @generated
     */
    String getSimpleConsumerPartition();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerPartition <em>Simple Consumer Partition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Consumer Partition</em>' attribute.
     * @see #getSimpleConsumerPartition()
     * @generated
     */
    void setSimpleConsumerPartition(String value);

    /**
     * Returns the value of the '<em><b>Simple Consumer Max Messages To Read</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Simple Consumer Max Messages To Read</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Consumer Max Messages To Read</em>' attribute.
     * @see #setSimpleConsumerMaxMessagesToRead(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleConsumerMaxMessagesToRead()
     * @model
     * @generated
     */
    String getSimpleConsumerMaxMessagesToRead();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleConsumerMaxMessagesToRead <em>Simple Consumer Max Messages To Read</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Consumer Max Messages To Read</em>' attribute.
     * @see #getSimpleConsumerMaxMessagesToRead()
     * @generated
     */
    void setSimpleConsumerMaxMessagesToRead(String value);

    /**
     * Returns the value of the '<em><b>Content Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Content Type</em>' attribute.
     * @see #setContentType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ContentType()
     * @model
     * @generated
     */
    String getContentType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContentType <em>Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content Type</em>' attribute.
     * @see #getContentType()
     * @generated
     */
    void setContentType(String value);

    /**
     * Returns the value of the '<em><b>Thread Count</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Thread Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Thread Count</em>' attribute.
     * @see #setThreadCount(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ThreadCount()
     * @model default="1"
     * @generated
     */
    String getThreadCount();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getThreadCount <em>Thread Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Thread Count</em>' attribute.
     * @see #getThreadCount()
     * @generated
     */
    void setThreadCount(String value);

    /**
     * Returns the value of the '<em><b>Consumer Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consumer Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Consumer Id</em>' attribute.
     * @see #setConsumerId(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ConsumerId()
     * @model
     * @generated
     */
    String getConsumerId();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerId <em>Consumer Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Consumer Id</em>' attribute.
     * @see #getConsumerId()
     * @generated
     */
    void setConsumerId(String value);

    /**
     * Returns the value of the '<em><b>Socket Timeout Ms</b></em>' attribute.
     * The default value is <code>"30000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Socket Timeout Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Socket Timeout Ms</em>' attribute.
     * @see #setSocketTimeoutMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SocketTimeoutMs()
     * @model default="30000"
     * @generated
     */
    String getSocketTimeoutMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSocketTimeoutMs <em>Socket Timeout Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Socket Timeout Ms</em>' attribute.
     * @see #getSocketTimeoutMs()
     * @generated
     */
    void setSocketTimeoutMs(String value);

    /**
     * Returns the value of the '<em><b>Socket Receive Buffer Bytes</b></em>' attribute.
     * The default value is <code>"65536"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Socket Receive Buffer Bytes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Socket Receive Buffer Bytes</em>' attribute.
     * @see #setSocketReceiveBufferBytes(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SocketReceiveBufferBytes()
     * @model default="65536"
     * @generated
     */
    String getSocketReceiveBufferBytes();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSocketReceiveBufferBytes <em>Socket Receive Buffer Bytes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Socket Receive Buffer Bytes</em>' attribute.
     * @see #getSocketReceiveBufferBytes()
     * @generated
     */
    void setSocketReceiveBufferBytes(String value);

    /**
     * Returns the value of the '<em><b>Fetch Message Max Bytes</b></em>' attribute.
     * The default value is <code>"1048576"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fetch Message Max Bytes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fetch Message Max Bytes</em>' attribute.
     * @see #setFetchMessageMaxBytes(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_FetchMessageMaxBytes()
     * @model default="1048576"
     * @generated
     */
    String getFetchMessageMaxBytes();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getFetchMessageMaxBytes <em>Fetch Message Max Bytes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fetch Message Max Bytes</em>' attribute.
     * @see #getFetchMessageMaxBytes()
     * @generated
     */
    void setFetchMessageMaxBytes(String value);

    /**
     * Returns the value of the '<em><b>Num Consumer Fetches</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Num Consumer Fetches</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Num Consumer Fetches</em>' attribute.
     * @see #setNumConsumerFetches(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_NumConsumerFetches()
     * @model default="1"
     * @generated
     */
    String getNumConsumerFetches();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getNumConsumerFetches <em>Num Consumer Fetches</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Num Consumer Fetches</em>' attribute.
     * @see #getNumConsumerFetches()
     * @generated
     */
    void setNumConsumerFetches(String value);

    /**
     * Returns the value of the '<em><b>Auto Commit Enable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Commit Enable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Auto Commit Enable</em>' attribute.
     * @see #setAutoCommitEnable(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_AutoCommitEnable()
     * @model
     * @generated
     */
    boolean isAutoCommitEnable();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isAutoCommitEnable <em>Auto Commit Enable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Auto Commit Enable</em>' attribute.
     * @see #isAutoCommitEnable()
     * @generated
     */
    void setAutoCommitEnable(boolean value);

    /**
     * Returns the value of the '<em><b>Zookeeper Session Timeout Ms</b></em>' attribute.
     * The default value is <code>"6000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zookeeper Session Timeout Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zookeeper Session Timeout Ms</em>' attribute.
     * @see #setZookeeperSessionTimeoutMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperSessionTimeoutMs()
     * @model default="6000"
     * @generated
     */
    String getZookeeperSessionTimeoutMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSessionTimeoutMs <em>Zookeeper Session Timeout Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zookeeper Session Timeout Ms</em>' attribute.
     * @see #getZookeeperSessionTimeoutMs()
     * @generated
     */
    void setZookeeperSessionTimeoutMs(String value);

    /**
     * Returns the value of the '<em><b>Zookeeper Connection Timeout Ms</b></em>' attribute.
     * The default value is <code>"6000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zookeeper Connection Timeout Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zookeeper Connection Timeout Ms</em>' attribute.
     * @see #setZookeeperConnectionTimeoutMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperConnectionTimeoutMs()
     * @model default="6000"
     * @generated
     */
    String getZookeeperConnectionTimeoutMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperConnectionTimeoutMs <em>Zookeeper Connection Timeout Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zookeeper Connection Timeout Ms</em>' attribute.
     * @see #getZookeeperConnectionTimeoutMs()
     * @generated
     */
    void setZookeeperConnectionTimeoutMs(String value);

    /**
     * Returns the value of the '<em><b>Zookeeper Sync Time Ms</b></em>' attribute.
     * The default value is <code>"2000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zookeeper Sync Time Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zookeeper Sync Time Ms</em>' attribute.
     * @see #setZookeeperSyncTimeMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperSyncTimeMs()
     * @model default="2000"
     * @generated
     */
    String getZookeeperSyncTimeMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSyncTimeMs <em>Zookeeper Sync Time Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zookeeper Sync Time Ms</em>' attribute.
     * @see #getZookeeperSyncTimeMs()
     * @generated
     */
    void setZookeeperSyncTimeMs(String value);

    /**
     * Returns the value of the '<em><b>Offsets Storage</b></em>' attribute.
     * The default value is <code>"zookeeper"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.OffsetsStorageType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offsets Storage</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offsets Storage</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.OffsetsStorageType
     * @see #setOffsetsStorage(OffsetsStorageType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OffsetsStorage()
     * @model default="zookeeper"
     * @generated
     */
    OffsetsStorageType getOffsetsStorage();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsStorage <em>Offsets Storage</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offsets Storage</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.OffsetsStorageType
     * @see #getOffsetsStorage()
     * @generated
     */
    void setOffsetsStorage(OffsetsStorageType value);

    /**
     * Returns the value of the '<em><b>Offsets Channel Backoff Ms</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offsets Channel Backoff Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offsets Channel Backoff Ms</em>' attribute.
     * @see #setOffsetsChannelBackoffMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OffsetsChannelBackoffMs()
     * @model default="1000"
     * @generated
     */
    String getOffsetsChannelBackoffMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsChannelBackoffMs <em>Offsets Channel Backoff Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offsets Channel Backoff Ms</em>' attribute.
     * @see #getOffsetsChannelBackoffMs()
     * @generated
     */
    void setOffsetsChannelBackoffMs(String value);

    /**
     * Returns the value of the '<em><b>Offsets Channel Socket Timeout Ms</b></em>' attribute.
     * The default value is <code>"10000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offsets Channel Socket Timeout Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offsets Channel Socket Timeout Ms</em>' attribute.
     * @see #setOffsetsChannelSocketTimeoutMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OffsetsChannelSocketTimeoutMs()
     * @model default="10000"
     * @generated
     */
    String getOffsetsChannelSocketTimeoutMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsChannelSocketTimeoutMs <em>Offsets Channel Socket Timeout Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offsets Channel Socket Timeout Ms</em>' attribute.
     * @see #getOffsetsChannelSocketTimeoutMs()
     * @generated
     */
    void setOffsetsChannelSocketTimeoutMs(String value);

    /**
     * Returns the value of the '<em><b>Offsets Commit Max Retries</b></em>' attribute.
     * The default value is <code>"5"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offsets Commit Max Retries</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offsets Commit Max Retries</em>' attribute.
     * @see #setOffsetsCommitMaxRetries(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OffsetsCommitMaxRetries()
     * @model default="5"
     * @generated
     */
    String getOffsetsCommitMaxRetries();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOffsetsCommitMaxRetries <em>Offsets Commit Max Retries</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offsets Commit Max Retries</em>' attribute.
     * @see #getOffsetsCommitMaxRetries()
     * @generated
     */
    void setOffsetsCommitMaxRetries(String value);

    /**
     * Returns the value of the '<em><b>Dual Commit Enabled</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dual Commit Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dual Commit Enabled</em>' attribute.
     * @see #setDualCommitEnabled(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_DualCommitEnabled()
     * @model default="true"
     * @generated
     */
    boolean isDualCommitEnabled();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isDualCommitEnabled <em>Dual Commit Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dual Commit Enabled</em>' attribute.
     * @see #isDualCommitEnabled()
     * @generated
     */
    void setDualCommitEnabled(boolean value);

    /**
     * Returns the value of the '<em><b>Auto Commit Interval Ms</b></em>' attribute.
     * The default value is <code>"60000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Commit Interval Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Auto Commit Interval Ms</em>' attribute.
     * @see #setAutoCommitIntervalMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_AutoCommitIntervalMs()
     * @model default="60000"
     * @generated
     */
    String getAutoCommitIntervalMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoCommitIntervalMs <em>Auto Commit Interval Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Auto Commit Interval Ms</em>' attribute.
     * @see #getAutoCommitIntervalMs()
     * @generated
     */
    void setAutoCommitIntervalMs(String value);

    /**
     * Returns the value of the '<em><b>Queued Max Message Chunks</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Queued Max Message Chunks</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Queued Max Message Chunks</em>' attribute.
     * @see #setQueuedMaxMessageChunks(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_QueuedMaxMessageChunks()
     * @model default="2"
     * @generated
     */
    String getQueuedMaxMessageChunks();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getQueuedMaxMessageChunks <em>Queued Max Message Chunks</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Queued Max Message Chunks</em>' attribute.
     * @see #getQueuedMaxMessageChunks()
     * @generated
     */
    void setQueuedMaxMessageChunks(String value);

    /**
     * Returns the value of the '<em><b>Rebalance Max Retries</b></em>' attribute.
     * The default value is <code>"4"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rebalance Max Retries</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rebalance Max Retries</em>' attribute.
     * @see #setRebalanceMaxRetries(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_RebalanceMaxRetries()
     * @model default="4"
     * @generated
     */
    String getRebalanceMaxRetries();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getRebalanceMaxRetries <em>Rebalance Max Retries</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rebalance Max Retries</em>' attribute.
     * @see #getRebalanceMaxRetries()
     * @generated
     */
    void setRebalanceMaxRetries(String value);

    /**
     * Returns the value of the '<em><b>Fetch Min Bytes</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fetch Min Bytes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fetch Min Bytes</em>' attribute.
     * @see #setFetchMinBytes(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_FetchMinBytes()
     * @model default="1"
     * @generated
     */
    String getFetchMinBytes();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getFetchMinBytes <em>Fetch Min Bytes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fetch Min Bytes</em>' attribute.
     * @see #getFetchMinBytes()
     * @generated
     */
    void setFetchMinBytes(String value);

    /**
     * Returns the value of the '<em><b>Fetch Wait Max Ms</b></em>' attribute.
     * The default value is <code>"100"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fetch Wait Max Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fetch Wait Max Ms</em>' attribute.
     * @see #setFetchWaitMaxMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_FetchWaitMaxMs()
     * @model default="100"
     * @generated
     */
    String getFetchWaitMaxMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getFetchWaitMaxMs <em>Fetch Wait Max Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fetch Wait Max Ms</em>' attribute.
     * @see #getFetchWaitMaxMs()
     * @generated
     */
    void setFetchWaitMaxMs(String value);

    /**
     * Returns the value of the '<em><b>Rebalance Backoff Ms</b></em>' attribute.
     * The default value is <code>"2000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rebalance Backoff Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rebalance Backoff Ms</em>' attribute.
     * @see #setRebalanceBackoffMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_RebalanceBackoffMs()
     * @model default="2000"
     * @generated
     */
    String getRebalanceBackoffMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getRebalanceBackoffMs <em>Rebalance Backoff Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rebalance Backoff Ms</em>' attribute.
     * @see #getRebalanceBackoffMs()
     * @generated
     */
    void setRebalanceBackoffMs(String value);

    /**
     * Returns the value of the '<em><b>Refresh Leader Backoff Ms</b></em>' attribute.
     * The default value is <code>"200"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Refresh Leader Backoff Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Refresh Leader Backoff Ms</em>' attribute.
     * @see #setRefreshLeaderBackoffMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_RefreshLeaderBackoffMs()
     * @model default="200"
     * @generated
     */
    String getRefreshLeaderBackoffMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getRefreshLeaderBackoffMs <em>Refresh Leader Backoff Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Refresh Leader Backoff Ms</em>' attribute.
     * @see #getRefreshLeaderBackoffMs()
     * @generated
     */
    void setRefreshLeaderBackoffMs(String value);

    /**
     * Returns the value of the '<em><b>Auto Offset Reset</b></em>' attribute.
     * The default value is <code>"largest"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.AutoOffsetResetType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Offset Reset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Auto Offset Reset</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.AutoOffsetResetType
     * @see #setAutoOffsetReset(AutoOffsetResetType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_AutoOffsetReset()
     * @model default="largest"
     * @generated
     */
    AutoOffsetResetType getAutoOffsetReset();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoOffsetReset <em>Auto Offset Reset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Auto Offset Reset</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.AutoOffsetResetType
     * @see #getAutoOffsetReset()
     * @generated
     */
    void setAutoOffsetReset(AutoOffsetResetType value);

    /**
     * Returns the value of the '<em><b>Consumer Timeout Ms</b></em>' attribute.
     * The default value is <code>"3000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consumer Timeout Ms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Consumer Timeout Ms</em>' attribute.
     * @see #setConsumerTimeoutMs(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ConsumerTimeoutMs()
     * @model default="3000"
     * @generated
     */
    String getConsumerTimeoutMs();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerTimeoutMs <em>Consumer Timeout Ms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Consumer Timeout Ms</em>' attribute.
     * @see #getConsumerTimeoutMs()
     * @generated
     */
    void setConsumerTimeoutMs(String value);

    /**
     * Returns the value of the '<em><b>Exclude Internal Topics</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exclude Internal Topics</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exclude Internal Topics</em>' attribute.
     * @see #setExcludeInternalTopics(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ExcludeInternalTopics()
     * @model default="false"
     * @generated
     */
    boolean isExcludeInternalTopics();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isExcludeInternalTopics <em>Exclude Internal Topics</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exclude Internal Topics</em>' attribute.
     * @see #isExcludeInternalTopics()
     * @generated
     */
    void setExcludeInternalTopics(boolean value);

    /**
     * Returns the value of the '<em><b>Partition Assignment Strategy</b></em>' attribute.
     * The default value is <code>"roundrobin"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PartitionAssignmentStrategyType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Partition Assignment Strategy</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Partition Assignment Strategy</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.PartitionAssignmentStrategyType
     * @see #setPartitionAssignmentStrategy(PartitionAssignmentStrategyType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_PartitionAssignmentStrategy()
     * @model default="roundrobin"
     * @generated
     */
    PartitionAssignmentStrategyType getPartitionAssignmentStrategy();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getPartitionAssignmentStrategy <em>Partition Assignment Strategy</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Partition Assignment Strategy</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.PartitionAssignmentStrategyType
     * @see #getPartitionAssignmentStrategy()
     * @generated
     */
    void setPartitionAssignmentStrategy(PartitionAssignmentStrategyType value);

    /**
     * Returns the value of the '<em><b>Client Id</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Client Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Client Id</em>' attribute.
     * @see #setClientId(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ClientId()
     * @model default=""
     * @generated
     */
    String getClientId();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getClientId <em>Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Client Id</em>' attribute.
     * @see #getClientId()
     * @generated
     */
    void setClientId(String value);

    /**
     * Returns the value of the '<em><b>Inbound Cxf Rm Host</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Cxf Rm Host</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Cxf Rm Host</em>' attribute.
     * @see #setInboundCxfRmHost(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundCxfRmHost()
     * @model default=""
     * @generated
     */
    String getInboundCxfRmHost();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmHost <em>Inbound Cxf Rm Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Cxf Rm Host</em>' attribute.
     * @see #getInboundCxfRmHost()
     * @generated
     */
    void setInboundCxfRmHost(String value);

    /**
     * Returns the value of the '<em><b>Inbound Cxf Rm Port</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Cxf Rm Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Cxf Rm Port</em>' attribute.
     * @see #setInboundCxfRmPort(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundCxfRmPort()
     * @model default=""
     * @generated
     */
    String getInboundCxfRmPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmPort <em>Inbound Cxf Rm Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Cxf Rm Port</em>' attribute.
     * @see #getInboundCxfRmPort()
     * @generated
     */
    void setInboundCxfRmPort(String value);

    /**
     * Returns the value of the '<em><b>Inbound Cxf Rm Config File</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Cxf Rm Config File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Cxf Rm Config File</em>' attribute.
     * @see #setInboundCxfRmConfigFile(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundCxfRmConfigFile()
     * @model default=""
     * @generated
     */
    String getInboundCxfRmConfigFile();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmConfigFile <em>Inbound Cxf Rm Config File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Cxf Rm Config File</em>' attribute.
     * @see #getInboundCxfRmConfigFile()
     * @generated
     */
    void setInboundCxfRmConfigFile(String value);

    /**
     * Returns the value of the '<em><b>Enable SSL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable SSL</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable SSL</em>' attribute.
     * @see #setEnableSSL(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_EnableSSL()
     * @model
     * @generated
     */
    boolean isEnableSSL();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isEnableSSL <em>Enable SSL</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable SSL</em>' attribute.
     * @see #isEnableSSL()
     * @generated
     */
    void setEnableSSL(boolean value);

    /**
     * Returns the value of the '<em><b>Service Parameters</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Parameters</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Parameters</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ServiceParameters()
     * @model containment="true"
     * @generated
     */
    EList<InboundEndpointParameter> getServiceParameters();

    /**
     * Returns the value of the '<em><b>Suspend</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suspend</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Suspend</em>' attribute.
     * @see #setSuspend(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Suspend()
     * @model default="false"
     * @generated
     */
    boolean isSuspend();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSuspend <em>Suspend</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Suspend</em>' attribute.
     * @see #isSuspend()
     * @generated
     */
    void setSuspend(boolean value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Factory</b></em>' attribute.
     * The default value is <code>"AMQPConnectionFactory"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Factory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Factory</em>' attribute.
     * @see #setTransportRabbitMqConnectionFactory(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionFactory()
     * @model default="AMQPConnectionFactory"
     * @generated
     */
    String getTransportRabbitMqConnectionFactory();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionFactory <em>Transport Rabbit Mq Connection Factory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Factory</em>' attribute.
     * @see #getTransportRabbitMqConnectionFactory()
     * @generated
     */
    void setTransportRabbitMqConnectionFactory(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Server Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Server Host Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Server Host Name</em>' attribute.
     * @see #setTransportRabbitMqServerHostName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqServerHostName()
     * @model
     * @generated
     */
    String getTransportRabbitMqServerHostName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerHostName <em>Transport Rabbit Mq Server Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Server Host Name</em>' attribute.
     * @see #getTransportRabbitMqServerHostName()
     * @generated
     */
    void setTransportRabbitMqServerHostName(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Server Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Server Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Server Port</em>' attribute.
     * @see #setTransportRabbitMqServerPort(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqServerPort()
     * @model
     * @generated
     */
    String getTransportRabbitMqServerPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerPort <em>Transport Rabbit Mq Server Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Server Port</em>' attribute.
     * @see #getTransportRabbitMqServerPort()
     * @generated
     */
    void setTransportRabbitMqServerPort(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Server User Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Server User Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Server User Name</em>' attribute.
     * @see #setTransportRabbitMqServerUserName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqServerUserName()
     * @model
     * @generated
     */
    String getTransportRabbitMqServerUserName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerUserName <em>Transport Rabbit Mq Server User Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Server User Name</em>' attribute.
     * @see #getTransportRabbitMqServerUserName()
     * @generated
     */
    void setTransportRabbitMqServerUserName(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Server Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Server Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Server Password</em>' attribute.
     * @see #setTransportRabbitMqServerPassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqServerPassword()
     * @model
     * @generated
     */
    String getTransportRabbitMqServerPassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerPassword <em>Transport Rabbit Mq Server Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Server Password</em>' attribute.
     * @see #getTransportRabbitMqServerPassword()
     * @generated
     */
    void setTransportRabbitMqServerPassword(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Name</em>' attribute.
     * @see #setTransportRabbitMqQueueName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueName()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueName <em>Transport Rabbit Mq Queue Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Name</em>' attribute.
     * @see #getTransportRabbitMqQueueName()
     * @generated
     */
    void setTransportRabbitMqQueueName(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Exchange Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Exchange Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Exchange Name</em>' attribute.
     * @see #setTransportRabbitMqExchangeName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqExchangeName()
     * @model
     * @generated
     */
    String getTransportRabbitMqExchangeName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeName <em>Transport Rabbit Mq Exchange Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Exchange Name</em>' attribute.
     * @see #getTransportRabbitMqExchangeName()
     * @generated
     */
    void setTransportRabbitMqExchangeName(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Durable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Durable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Durable</em>' attribute.
     * @see #setTransportRabbitMqQueueDurable(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueDurable()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueDurable();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueDurable <em>Transport Rabbit Mq Queue Durable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Durable</em>' attribute.
     * @see #getTransportRabbitMqQueueDurable()
     * @generated
     */
    void setTransportRabbitMqQueueDurable(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Exclusive</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Exclusive</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Exclusive</em>' attribute.
     * @see #setTransportRabbitMqQueueExclusive(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueExclusive()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueExclusive();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueExclusive <em>Transport Rabbit Mq Queue Exclusive</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Exclusive</em>' attribute.
     * @see #getTransportRabbitMqQueueExclusive()
     * @generated
     */
    void setTransportRabbitMqQueueExclusive(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Auto Delete</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Auto Delete</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Auto Delete</em>' attribute.
     * @see #setTransportRabbitMqQueueAutoDelete(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueAutoDelete()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueAutoDelete();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueAutoDelete <em>Transport Rabbit Mq Queue Auto Delete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Auto Delete</em>' attribute.
     * @see #getTransportRabbitMqQueueAutoDelete()
     * @generated
     */
    void setTransportRabbitMqQueueAutoDelete(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Auto Ack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Auto Ack</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Auto Ack</em>' attribute.
     * @see #setTransportRabbitMqQueueAutoAck(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueAutoAck()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueAutoAck();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueAutoAck <em>Transport Rabbit Mq Queue Auto Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Auto Ack</em>' attribute.
     * @see #getTransportRabbitMqQueueAutoAck()
     * @generated
     */
    void setTransportRabbitMqQueueAutoAck(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Routing Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Routing Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Routing Key</em>' attribute.
     * @see #setTransportRabbitMqQueueRoutingKey(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueRoutingKey()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueRoutingKey();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueRoutingKey <em>Transport Rabbit Mq Queue Routing Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Routing Key</em>' attribute.
     * @see #getTransportRabbitMqQueueRoutingKey()
     * @generated
     */
    void setTransportRabbitMqQueueRoutingKey(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Queue Delivery Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Queue Delivery Mode</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Queue Delivery Mode</em>' attribute.
     * @see #setTransportRabbitMqQueueDeliveryMode(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqQueueDeliveryMode()
     * @model
     * @generated
     */
    String getTransportRabbitMqQueueDeliveryMode();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqQueueDeliveryMode <em>Transport Rabbit Mq Queue Delivery Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Queue Delivery Mode</em>' attribute.
     * @see #getTransportRabbitMqQueueDeliveryMode()
     * @generated
     */
    void setTransportRabbitMqQueueDeliveryMode(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Exchange Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Exchange Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Exchange Type</em>' attribute.
     * @see #setTransportRabbitMqExchangeType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqExchangeType()
     * @model
     * @generated
     */
    String getTransportRabbitMqExchangeType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeType <em>Transport Rabbit Mq Exchange Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Exchange Type</em>' attribute.
     * @see #getTransportRabbitMqExchangeType()
     * @generated
     */
    void setTransportRabbitMqExchangeType(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Exchange Durable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Exchange Durable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Exchange Durable</em>' attribute.
     * @see #setTransportRabbitMqExchangeDurable(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqExchangeDurable()
     * @model
     * @generated
     */
    String getTransportRabbitMqExchangeDurable();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeDurable <em>Transport Rabbit Mq Exchange Durable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Exchange Durable</em>' attribute.
     * @see #getTransportRabbitMqExchangeDurable()
     * @generated
     */
    void setTransportRabbitMqExchangeDurable(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Exchange Auto Delete</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Exchange Auto Delete</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Exchange Auto Delete</em>' attribute.
     * @see #setTransportRabbitMqExchangeAutoDelete(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqExchangeAutoDelete()
     * @model
     * @generated
     */
    String getTransportRabbitMqExchangeAutoDelete();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqExchangeAutoDelete <em>Transport Rabbit Mq Exchange Auto Delete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Exchange Auto Delete</em>' attribute.
     * @see #getTransportRabbitMqExchangeAutoDelete()
     * @generated
     */
    void setTransportRabbitMqExchangeAutoDelete(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Server Virtual Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Server Virtual Host</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Server Virtual Host</em>' attribute.
     * @see #setTransportRabbitMqServerVirtualHost(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqServerVirtualHost()
     * @model
     * @generated
     */
    String getTransportRabbitMqServerVirtualHost();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerVirtualHost <em>Transport Rabbit Mq Server Virtual Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Server Virtual Host</em>' attribute.
     * @see #getTransportRabbitMqServerVirtualHost()
     * @generated
     */
    void setTransportRabbitMqServerVirtualHost(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Factory Heartbeat</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Factory Heartbeat</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Factory Heartbeat</em>' attribute.
     * @see #setTransportRabbitMqFactoryHeartbeat(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqFactoryHeartbeat()
     * @model
     * @generated
     */
    String getTransportRabbitMqFactoryHeartbeat();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqFactoryHeartbeat <em>Transport Rabbit Mq Factory Heartbeat</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Factory Heartbeat</em>' attribute.
     * @see #getTransportRabbitMqFactoryHeartbeat()
     * @generated
     */
    void setTransportRabbitMqFactoryHeartbeat(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Enabled</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslEnabled(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslEnabled()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslEnabled();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslEnabled <em>Transport Rabbit Mq Connection Ssl Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Enabled</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslEnabled()
     * @generated
     */
    void setTransportRabbitMqConnectionSslEnabled(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Keystore Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Keystore Location</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Keystore Location</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslKeystoreLocation(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslKeystoreLocation();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslKeystoreLocation <em>Transport Rabbit Mq Connection Ssl Keystore Location</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Keystore Location</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslKeystoreLocation()
     * @generated
     */
    void setTransportRabbitMqConnectionSslKeystoreLocation(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Keystore Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Keystore Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Keystore Type</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslKeystoreType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslKeystoreType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslKeystoreType <em>Transport Rabbit Mq Connection Ssl Keystore Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Keystore Type</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslKeystoreType()
     * @generated
     */
    void setTransportRabbitMqConnectionSslKeystoreType(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Keystore Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Keystore Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Keystore Password</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslKeystorePassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslKeystorePassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslKeystorePassword <em>Transport Rabbit Mq Connection Ssl Keystore Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Keystore Password</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslKeystorePassword()
     * @generated
     */
    void setTransportRabbitMqConnectionSslKeystorePassword(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Truststore Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Truststore Location</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Truststore Location</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslTruststoreLocation(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslTruststoreLocation();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslTruststoreLocation <em>Transport Rabbit Mq Connection Ssl Truststore Location</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Truststore Location</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslTruststoreLocation()
     * @generated
     */
    void setTransportRabbitMqConnectionSslTruststoreLocation(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Truststore Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Truststore Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Truststore Type</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslTruststoreType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslTruststoreType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslTruststoreType <em>Transport Rabbit Mq Connection Ssl Truststore Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Truststore Type</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslTruststoreType()
     * @generated
     */
    void setTransportRabbitMqConnectionSslTruststoreType(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Truststore Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Truststore Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Truststore Password</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslTruststorePassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslTruststorePassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslTruststorePassword <em>Transport Rabbit Mq Connection Ssl Truststore Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Truststore Password</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslTruststorePassword()
     * @generated
     */
    void setTransportRabbitMqConnectionSslTruststorePassword(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Ssl Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Ssl Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Ssl Version</em>' attribute.
     * @see #setTransportRabbitMqConnectionSslVersion(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionSslVersion()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionSslVersion();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionSslVersion <em>Transport Rabbit Mq Connection Ssl Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Ssl Version</em>' attribute.
     * @see #getTransportRabbitMqConnectionSslVersion()
     * @generated
     */
    void setTransportRabbitMqConnectionSslVersion(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Message Content Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Message Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Message Content Type</em>' attribute.
     * @see #setTransportRabbitMqMessageContentType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqMessageContentType()
     * @model
     * @generated
     */
    String getTransportRabbitMqMessageContentType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqMessageContentType <em>Transport Rabbit Mq Message Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Message Content Type</em>' attribute.
     * @see #getTransportRabbitMqMessageContentType()
     * @generated
     */
    void setTransportRabbitMqMessageContentType(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Retry Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Retry Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Retry Count</em>' attribute.
     * @see #setTransportRabbitMqConnectionRetryCount(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionRetryCount()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionRetryCount();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionRetryCount <em>Transport Rabbit Mq Connection Retry Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Retry Count</em>' attribute.
     * @see #getTransportRabbitMqConnectionRetryCount()
     * @generated
     */
    void setTransportRabbitMqConnectionRetryCount(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Connection Retry Interval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Connection Retry Interval</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Connection Retry Interval</em>' attribute.
     * @see #setTransportRabbitMqConnectionRetryInterval(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConnectionRetryInterval()
     * @model
     * @generated
     */
    String getTransportRabbitMqConnectionRetryInterval();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConnectionRetryInterval <em>Transport Rabbit Mq Connection Retry Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Connection Retry Interval</em>' attribute.
     * @see #getTransportRabbitMqConnectionRetryInterval()
     * @generated
     */
    void setTransportRabbitMqConnectionRetryInterval(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Server Retry Interval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Server Retry Interval</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Server Retry Interval</em>' attribute.
     * @see #setTransportRabbitMqServerRetryInterval(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqServerRetryInterval()
     * @model
     * @generated
     */
    String getTransportRabbitMqServerRetryInterval();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqServerRetryInterval <em>Transport Rabbit Mq Server Retry Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Server Retry Interval</em>' attribute.
     * @see #getTransportRabbitMqServerRetryInterval()
     * @generated
     */
    void setTransportRabbitMqServerRetryInterval(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Consumer Qos Key</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Consumer Qos Key</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Consumer Qos Key</em>' containment reference.
     * @see #setTransportRabbitMqConsumerQosKey(RegistryKeyProperty)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConsumerQosKey()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getTransportRabbitMqConsumerQosKey();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerQosKey <em>Transport Rabbit Mq Consumer Qos Key</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Consumer Qos Key</em>' containment reference.
     * @see #getTransportRabbitMqConsumerQosKey()
     * @generated
     */
    void setTransportRabbitMqConsumerQosKey(RegistryKeyProperty value);

    /**
     * Returns the value of the '<em><b>Ws Inbound Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Inbound Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Inbound Port</em>' attribute.
     * @see #setWsInboundPort(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsInboundPort()
     * @model
     * @generated
     */
    String getWsInboundPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsInboundPort <em>Ws Inbound Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Inbound Port</em>' attribute.
     * @see #getWsInboundPort()
     * @generated
     */
    void setWsInboundPort(String value);

    /**
     * Returns the value of the '<em><b>Ws Client Side Broadcast Level</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.WSClientSideBroadcastLevel}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Client Side Broadcast Level</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Client Side Broadcast Level</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.WSClientSideBroadcastLevel
     * @see #setWsClientSideBroadcastLevel(WSClientSideBroadcastLevel)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsClientSideBroadcastLevel()
     * @model
     * @generated
     */
    WSClientSideBroadcastLevel getWsClientSideBroadcastLevel();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsClientSideBroadcastLevel <em>Ws Client Side Broadcast Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Client Side Broadcast Level</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.WSClientSideBroadcastLevel
     * @see #getWsClientSideBroadcastLevel()
     * @generated
     */
    void setWsClientSideBroadcastLevel(WSClientSideBroadcastLevel value);

    /**
     * Returns the value of the '<em><b>Ws Outflow Dispatch Sequence</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Outflow Dispatch Sequence</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Outflow Dispatch Sequence</em>' attribute.
     * @see #setWsOutflowDispatchSequence(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsOutflowDispatchSequence()
     * @model
     * @generated
     */
    String getWsOutflowDispatchSequence();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsOutflowDispatchSequence <em>Ws Outflow Dispatch Sequence</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Outflow Dispatch Sequence</em>' attribute.
     * @see #getWsOutflowDispatchSequence()
     * @generated
     */
    void setWsOutflowDispatchSequence(String value);

    /**
     * Returns the value of the '<em><b>Ws Outflow Dispatch Fault Sequence</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Outflow Dispatch Fault Sequence</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Outflow Dispatch Fault Sequence</em>' attribute.
     * @see #setWsOutflowDispatchFaultSequence(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsOutflowDispatchFaultSequence()
     * @model
     * @generated
     */
    String getWsOutflowDispatchFaultSequence();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsOutflowDispatchFaultSequence <em>Ws Outflow Dispatch Fault Sequence</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Outflow Dispatch Fault Sequence</em>' attribute.
     * @see #getWsOutflowDispatchFaultSequence()
     * @generated
     */
    void setWsOutflowDispatchFaultSequence(String value);

    /**
     * Returns the value of the '<em><b>Ws Boss Thread Pool Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Boss Thread Pool Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Boss Thread Pool Size</em>' attribute.
     * @see #setWsBossThreadPoolSize(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsBossThreadPoolSize()
     * @model
     * @generated
     */
    String getWsBossThreadPoolSize();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsBossThreadPoolSize <em>Ws Boss Thread Pool Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Boss Thread Pool Size</em>' attribute.
     * @see #getWsBossThreadPoolSize()
     * @generated
     */
    void setWsBossThreadPoolSize(String value);

    /**
     * Returns the value of the '<em><b>Ws Worker Thread Pool Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Worker Thread Pool Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Worker Thread Pool Size</em>' attribute.
     * @see #setWsWorkerThreadPoolSize(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsWorkerThreadPoolSize()
     * @model
     * @generated
     */
    String getWsWorkerThreadPoolSize();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsWorkerThreadPoolSize <em>Ws Worker Thread Pool Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Worker Thread Pool Size</em>' attribute.
     * @see #getWsWorkerThreadPoolSize()
     * @generated
     */
    void setWsWorkerThreadPoolSize(String value);

    /**
     * Returns the value of the '<em><b>Ws Subprotocol Handler Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Subprotocol Handler Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Subprotocol Handler Class</em>' attribute.
     * @see #setWsSubprotocolHandlerClass(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsSubprotocolHandlerClass()
     * @model
     * @generated
     */
    String getWsSubprotocolHandlerClass();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsSubprotocolHandlerClass <em>Ws Subprotocol Handler Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Subprotocol Handler Class</em>' attribute.
     * @see #getWsSubprotocolHandlerClass()
     * @generated
     */
    void setWsSubprotocolHandlerClass(String value);

    /**
     * Returns the value of the '<em><b>Ws Pipeline Handler Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Pipeline Handler Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Pipeline Handler Class</em>' attribute.
     * @see #setWsPipelineHandlerClass(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsPipelineHandlerClass()
     * @model
     * @generated
     */
    String getWsPipelineHandlerClass();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsPipelineHandlerClass <em>Ws Pipeline Handler Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Pipeline Handler Class</em>' attribute.
     * @see #getWsPipelineHandlerClass()
     * @generated
     */
    void setWsPipelineHandlerClass(String value);

    /**
     * Returns the value of the '<em><b>Transport Feed URL</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Feed URL</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Feed URL</em>' attribute.
     * @see #setTransportFeedURL(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportFeedURL()
     * @model default=""
     * @generated
     */
    String getTransportFeedURL();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportFeedURL <em>Transport Feed URL</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Feed URL</em>' attribute.
     * @see #getTransportFeedURL()
     * @generated
     */
    void setTransportFeedURL(String value);

    /**
     * Returns the value of the '<em><b>Transport Feed Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FeedType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Feed Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Feed Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.FeedType
     * @see #setTransportFeedType(FeedType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportFeedType()
     * @model
     * @generated
     */
    FeedType getTransportFeedType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportFeedType <em>Transport Feed Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Feed Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.FeedType
     * @see #getTransportFeedType()
     * @generated
     */
    void setTransportFeedType(FeedType value);

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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TraceEnabled()
     * @model
     * @generated
     */
    boolean isTraceEnabled();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTraceEnabled <em>Trace Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trace Enabled</em>' attribute.
     * @see #isTraceEnabled()
     * @generated
     */
    void setTraceEnabled(boolean value);

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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_StatisticsEnabled()
     * @model
     * @generated
     */
    boolean isStatisticsEnabled();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isStatisticsEnabled <em>Statistics Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Statistics Enabled</em>' attribute.
     * @see #isStatisticsEnabled()
     * @generated
     */
    void setStatisticsEnabled(boolean value);

    /**
     * Returns the value of the '<em><b>Transport JMS Retries Before Suspension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Retries Before Suspension</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Retries Before Suspension</em>' attribute.
     * @see #setTransportJMSRetriesBeforeSuspension(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSRetriesBeforeSuspension()
     * @model
     * @generated
     */
    String getTransportJMSRetriesBeforeSuspension();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSRetriesBeforeSuspension <em>Transport JMS Retries Before Suspension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Retries Before Suspension</em>' attribute.
     * @see #getTransportJMSRetriesBeforeSuspension()
     * @generated
     */
    void setTransportJMSRetriesBeforeSuspension(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Reset Connection On Polling Suspension</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Reset Connection On Polling Suspension</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Reset Connection On Polling Suspension</em>' attribute.
     * @see #setTransportJMSResetConnectionOnPollingSuspension(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSResetConnectionOnPollingSuspension()
     * @model default="false"
     * @generated
     */
    boolean isTransportJMSResetConnectionOnPollingSuspension();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSResetConnectionOnPollingSuspension <em>Transport JMS Reset Connection On Polling Suspension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Reset Connection On Polling Suspension</em>' attribute.
     * @see #isTransportJMSResetConnectionOnPollingSuspension()
     * @generated
     */
    void setTransportJMSResetConnectionOnPollingSuspension(boolean value);

    /**
     * Returns the value of the '<em><b>Transport JMS Polling Suspension Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Polling Suspension Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Polling Suspension Period</em>' attribute.
     * @see #setTransportJMSPollingSuspensionPeriod(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSPollingSuspensionPeriod()
     * @model
     * @generated
     */
    String getTransportJMSPollingSuspensionPeriod();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPollingSuspensionPeriod <em>Transport JMS Polling Suspension Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Polling Suspension Period</em>' attribute.
     * @see #getTransportJMSPollingSuspensionPeriod()
     * @generated
     */
    void setTransportJMSPollingSuspensionPeriod(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Keystore Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Keystore Location</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Keystore Location</em>' attribute.
     * @see #setTransportMQTTSslKeystoreLocation(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslKeystoreLocation()
     * @model
     * @generated
     */
    String getTransportMQTTSslKeystoreLocation();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslKeystoreLocation <em>Transport MQTT Ssl Keystore Location</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Keystore Location</em>' attribute.
     * @see #getTransportMQTTSslKeystoreLocation()
     * @generated
     */
    void setTransportMQTTSslKeystoreLocation(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Keystore Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Keystore Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Keystore Type</em>' attribute.
     * @see #setTransportMQTTSslKeystoreType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslKeystoreType()
     * @model
     * @generated
     */
    String getTransportMQTTSslKeystoreType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslKeystoreType <em>Transport MQTT Ssl Keystore Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Keystore Type</em>' attribute.
     * @see #getTransportMQTTSslKeystoreType()
     * @generated
     */
    void setTransportMQTTSslKeystoreType(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Keystore Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Keystore Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Keystore Password</em>' attribute.
     * @see #setTransportMQTTSslKeystorePassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslKeystorePassword()
     * @model
     * @generated
     */
    String getTransportMQTTSslKeystorePassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslKeystorePassword <em>Transport MQTT Ssl Keystore Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Keystore Password</em>' attribute.
     * @see #getTransportMQTTSslKeystorePassword()
     * @generated
     */
    void setTransportMQTTSslKeystorePassword(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Truststore Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Truststore Location</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Truststore Location</em>' attribute.
     * @see #setTransportMQTTSslTruststoreLocation(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslTruststoreLocation()
     * @model
     * @generated
     */
    String getTransportMQTTSslTruststoreLocation();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslTruststoreLocation <em>Transport MQTT Ssl Truststore Location</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Truststore Location</em>' attribute.
     * @see #getTransportMQTTSslTruststoreLocation()
     * @generated
     */
    void setTransportMQTTSslTruststoreLocation(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Truststore Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Truststore Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Truststore Type</em>' attribute.
     * @see #setTransportMQTTSslTruststoreType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslTruststoreType()
     * @model
     * @generated
     */
    String getTransportMQTTSslTruststoreType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslTruststoreType <em>Transport MQTT Ssl Truststore Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Truststore Type</em>' attribute.
     * @see #getTransportMQTTSslTruststoreType()
     * @generated
     */
    void setTransportMQTTSslTruststoreType(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Truststore Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Truststore Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Truststore Password</em>' attribute.
     * @see #setTransportMQTTSslTruststorePassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslTruststorePassword()
     * @model
     * @generated
     */
    String getTransportMQTTSslTruststorePassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslTruststorePassword <em>Transport MQTT Ssl Truststore Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Truststore Password</em>' attribute.
     * @see #getTransportMQTTSslTruststorePassword()
     * @generated
     */
    void setTransportMQTTSslTruststorePassword(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Version</em>' attribute.
     * @see #setTransportMQTTSslVersion(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslVersion()
     * @model
     * @generated
     */
    String getTransportMQTTSslVersion();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslVersion <em>Transport MQTT Ssl Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Version</em>' attribute.
     * @see #getTransportMQTTSslVersion()
     * @generated
     */
    void setTransportMQTTSslVersion(String value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Key Store File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Key Store File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Key Store File</em>' attribute.
     * @see #setWssSslKeyStoreFile(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslKeyStoreFile()
     * @model
     * @generated
     */
    String getWssSslKeyStoreFile();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslKeyStoreFile <em>Wss Ssl Key Store File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Key Store File</em>' attribute.
     * @see #getWssSslKeyStoreFile()
     * @generated
     */
    void setWssSslKeyStoreFile(String value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Key Store Pass</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Key Store Pass</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Key Store Pass</em>' attribute.
     * @see #setWssSslKeyStorePass(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslKeyStorePass()
     * @model
     * @generated
     */
    String getWssSslKeyStorePass();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslKeyStorePass <em>Wss Ssl Key Store Pass</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Key Store Pass</em>' attribute.
     * @see #getWssSslKeyStorePass()
     * @generated
     */
    void setWssSslKeyStorePass(String value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Trust Store File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Trust Store File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Trust Store File</em>' attribute.
     * @see #setWssSslTrustStoreFile(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslTrustStoreFile()
     * @model
     * @generated
     */
    String getWssSslTrustStoreFile();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslTrustStoreFile <em>Wss Ssl Trust Store File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Trust Store File</em>' attribute.
     * @see #getWssSslTrustStoreFile()
     * @generated
     */
    void setWssSslTrustStoreFile(String value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Trust Store Pass</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Trust Store Pass</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Trust Store Pass</em>' attribute.
     * @see #setWssSslTrustStorePass(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslTrustStorePass()
     * @model default=""
     * @generated
     */
    String getWssSslTrustStorePass();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslTrustStorePass <em>Wss Ssl Trust Store Pass</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Trust Store Pass</em>' attribute.
     * @see #getWssSslTrustStorePass()
     * @generated
     */
    void setWssSslTrustStorePass(String value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Cert Pass</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Cert Pass</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Cert Pass</em>' attribute.
     * @see #setWssSslCertPass(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslCertPass()
     * @model
     * @generated
     */
    String getWssSslCertPass();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslCertPass <em>Wss Ssl Cert Pass</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Cert Pass</em>' attribute.
     * @see #getWssSslCertPass()
     * @generated
     */
    void setWssSslCertPass(String value);

    /**
     * Returns the value of the '<em><b>Ws Default Content Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Default Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Default Content Type</em>' attribute.
     * @see #setWsDefaultContentType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsDefaultContentType()
     * @model
     * @generated
     */
    String getWsDefaultContentType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsDefaultContentType <em>Ws Default Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Default Content Type</em>' attribute.
     * @see #getWsDefaultContentType()
     * @generated
     */
    void setWsDefaultContentType(String value);

    /**
     * Returns the value of the '<em><b>Ws Shutdown Status Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Shutdown Status Code</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Shutdown Status Code</em>' attribute.
     * @see #setWsShutdownStatusCode(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsShutdownStatusCode()
     * @model
     * @generated
     */
    String getWsShutdownStatusCode();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsShutdownStatusCode <em>Ws Shutdown Status Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Shutdown Status Code</em>' attribute.
     * @see #getWsShutdownStatusCode()
     * @generated
     */
    void setWsShutdownStatusCode(String value);

    /**
     * Returns the value of the '<em><b>Ws Shutdown Status Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Shutdown Status Message</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Shutdown Status Message</em>' attribute.
     * @see #setWsShutdownStatusMessage(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsShutdownStatusMessage()
     * @model
     * @generated
     */
    String getWsShutdownStatusMessage();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWsShutdownStatusMessage <em>Ws Shutdown Status Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Shutdown Status Message</em>' attribute.
     * @see #getWsShutdownStatusMessage()
     * @generated
     */
    void setWsShutdownStatusMessage(String value);

    /**
     * Returns the value of the '<em><b>Ws Use Port Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Use Port Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Use Port Offset</em>' attribute.
     * @see #setWsUsePortOffset(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WsUsePortOffset()
     * @model
     * @generated
     */
    boolean isWsUsePortOffset();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isWsUsePortOffset <em>Ws Use Port Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Use Port Offset</em>' attribute.
     * @see #isWsUsePortOffset()
     * @generated
     */
    void setWsUsePortOffset(boolean value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Protocols</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Protocols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Protocols</em>' attribute.
     * @see #setWssSslProtocols(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslProtocols()
     * @model
     * @generated
     */
    String getWssSslProtocols();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslProtocols <em>Wss Ssl Protocols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Protocols</em>' attribute.
     * @see #getWssSslProtocols()
     * @generated
     */
    void setWssSslProtocols(String value);

    /**
     * Returns the value of the '<em><b>Wss Ssl Cipher Suites</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wss Ssl Cipher Suites</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wss Ssl Cipher Suites</em>' attribute.
     * @see #setWssSslCipherSuites(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_WssSslCipherSuites()
     * @model
     * @generated
     */
    String getWssSslCipherSuites();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWssSslCipherSuites <em>Wss Ssl Cipher Suites</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wss Ssl Cipher Suites</em>' attribute.
     * @see #getWssSslCipherSuites()
     * @generated
     */
    void setWssSslCipherSuites(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Consumer Qos</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Consumer Qos</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Consumer Qos</em>' attribute.
     * @see #setTransportRabbitMqConsumerQos(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConsumerQos()
     * @model
     * @generated
     */
    String getTransportRabbitMqConsumerQos();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerQos <em>Transport Rabbit Mq Consumer Qos</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Consumer Qos</em>' attribute.
     * @see #getTransportRabbitMqConsumerQos()
     * @generated
     */
    void setTransportRabbitMqConsumerQos(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Consumer Qos Type</b></em>' attribute.
     * The default value is <code>"Registry Reference"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Consumer Qos Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Consumer Qos Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType
     * @see #setTransportRabbitMqConsumerQosType(PayloadFormatType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConsumerQosType()
     * @model default="Registry Reference"
     * @generated
     */
    PayloadFormatType getTransportRabbitMqConsumerQosType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerQosType <em>Transport Rabbit Mq Consumer Qos Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Consumer Qos Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType
     * @see #getTransportRabbitMqConsumerQosType()
     * @generated
     */
    void setTransportRabbitMqConsumerQosType(PayloadFormatType value);

    /**
     * Returns the value of the '<em><b>Transport JMSDB Url</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMSDB Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMSDB Url</em>' attribute.
     * @see #setTransportJMSDBUrl(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSDBUrl()
     * @model default=""
     * @generated
     */
    String getTransportJMSDBUrl();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDBUrl <em>Transport JMSDB Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMSDB Url</em>' attribute.
     * @see #getTransportJMSDBUrl()
     * @generated
     */
    void setTransportJMSDBUrl(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Auto Declare</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Auto Declare</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Auto Declare</em>' attribute.
     * @see #setTransportRabbitMqAutoDeclare(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqAutoDeclare()
     * @model default="true"
     * @generated
     */
    boolean isTransportRabbitMqAutoDeclare();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportRabbitMqAutoDeclare <em>Transport Rabbit Mq Auto Declare</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Auto Declare</em>' attribute.
     * @see #isTransportRabbitMqAutoDeclare()
     * @generated
     */
    void setTransportRabbitMqAutoDeclare(boolean value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Max Dead Lettered Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Max Dead Lettered Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Max Dead Lettered Count</em>' attribute.
     * @see #setTransportRabbitMqMaxDeadLetteredCount(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqMaxDeadLetteredCount()
     * @model
     * @generated
     */
    String getTransportRabbitMqMaxDeadLetteredCount();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqMaxDeadLetteredCount <em>Transport Rabbit Mq Max Dead Lettered Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Max Dead Lettered Count</em>' attribute.
     * @see #getTransportRabbitMqMaxDeadLetteredCount()
     * @generated
     */
    void setTransportRabbitMqMaxDeadLetteredCount(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Requeue Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Requeue Delay</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Requeue Delay</em>' attribute.
     * @see #setTransportRabbitMqRequeueDelay(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqRequeueDelay()
     * @model
     * @generated
     */
    String getTransportRabbitMqRequeueDelay();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqRequeueDelay <em>Transport Rabbit Mq Requeue Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Requeue Delay</em>' attribute.
     * @see #getTransportRabbitMqRequeueDelay()
     * @generated
     */
    void setTransportRabbitMqRequeueDelay(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Exchange Auto Declare</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Exchange Auto Declare</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Exchange Auto Declare</em>' attribute.
     * @see #setTransportRabbitMqExchangeAutoDeclare(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqExchangeAutoDeclare()
     * @model default="true"
     * @generated
     */
    boolean isTransportRabbitMqExchangeAutoDeclare();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportRabbitMqExchangeAutoDeclare <em>Transport Rabbit Mq Exchange Auto Declare</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Exchange Auto Declare</em>' attribute.
     * @see #isTransportRabbitMqExchangeAutoDeclare()
     * @generated
     */
    void setTransportRabbitMqExchangeAutoDeclare(boolean value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Consumer Tag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Consumer Tag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Consumer Tag</em>' attribute.
     * @see #setTransportRabbitMqConsumerTag(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqConsumerTag()
     * @model
     * @generated
     */
    String getTransportRabbitMqConsumerTag();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqConsumerTag <em>Transport Rabbit Mq Consumer Tag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Consumer Tag</em>' attribute.
     * @see #getTransportRabbitMqConsumerTag()
     * @generated
     */
    void setTransportRabbitMqConsumerTag(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Error Queue Routing Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Error Queue Routing Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Error Queue Routing Key</em>' attribute.
     * @see #setTransportRabbitMqErrorQueueRoutingKey(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqErrorQueueRoutingKey()
     * @model
     * @generated
     */
    String getTransportRabbitMqErrorQueueRoutingKey();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqErrorQueueRoutingKey <em>Transport Rabbit Mq Error Queue Routing Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Error Queue Routing Key</em>' attribute.
     * @see #getTransportRabbitMqErrorQueueRoutingKey()
     * @generated
     */
    void setTransportRabbitMqErrorQueueRoutingKey(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Error Exchange Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Error Exchange Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Error Exchange Name</em>' attribute.
     * @see #setTransportRabbitMqErrorExchangeName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqErrorExchangeName()
     * @model
     * @generated
     */
    String getTransportRabbitMqErrorExchangeName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqErrorExchangeName <em>Transport Rabbit Mq Error Exchange Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Error Exchange Name</em>' attribute.
     * @see #getTransportRabbitMqErrorExchangeName()
     * @generated
     */
    void setTransportRabbitMqErrorExchangeName(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Factory Connection Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Factory Connection Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Factory Connection Timeout</em>' attribute.
     * @see #setTransportRabbitMqFactoryConnectionTimeout(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqFactoryConnectionTimeout()
     * @model
     * @generated
     */
    String getTransportRabbitMqFactoryConnectionTimeout();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqFactoryConnectionTimeout <em>Transport Rabbit Mq Factory Connection Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Factory Connection Timeout</em>' attribute.
     * @see #getTransportRabbitMqFactoryConnectionTimeout()
     * @generated
     */
    void setTransportRabbitMqFactoryConnectionTimeout(String value);

    /**
     * Returns the value of the '<em><b>Transport Rabbit Mq Factory Network Recovery Interval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport Rabbit Mq Factory Network Recovery Interval</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport Rabbit Mq Factory Network Recovery Interval</em>' attribute.
     * @see #setTransportRabbitMqFactoryNetworkRecoveryInterval(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportRabbitMqFactoryNetworkRecoveryInterval()
     * @model
     * @generated
     */
    String getTransportRabbitMqFactoryNetworkRecoveryInterval();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportRabbitMqFactoryNetworkRecoveryInterval <em>Transport Rabbit Mq Factory Network Recovery Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport Rabbit Mq Factory Network Recovery Interval</em>' attribute.
     * @see #getTransportRabbitMqFactoryNetworkRecoveryInterval()
     * @generated
     */
    void setTransportRabbitMqFactoryNetworkRecoveryInterval(String value);

    /**
     * Returns the value of the '<em><b>Class</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Class</em>' attribute.
     * @see #setClass(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Class()
     * @model default=""
     * @generated
     */
    String getClass_();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getClass_ <em>Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Class</em>' attribute.
     * @see #getClass_()
     * @generated
     */
    void setClass(String value);

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' attribute.
     * @see #setProtocol(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Protocol()
     * @model default=""
     * @generated
     */
    String getProtocol();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getProtocol <em>Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' attribute.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(String value);

    /**
     * Returns the value of the '<em><b>Inbound Endpoint Behaviour</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Endpoint Behaviour</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Endpoint Behaviour</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType
     * @see #setInboundEndpointBehaviour(InboundEndpointBehaviourType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundEndpointBehaviour()
     * @model
     * @generated
     */
    InboundEndpointBehaviourType getInboundEndpointBehaviour();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundEndpointBehaviour <em>Inbound Endpoint Behaviour</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Endpoint Behaviour</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType
     * @see #getInboundEndpointBehaviour()
     * @generated
     */
    void setInboundEndpointBehaviour(InboundEndpointBehaviourType value);

    /**
     * Returns the value of the '<em><b>Inbound Http Port</b></em>' attribute.
     * The default value is <code>"8000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Http Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Http Port</em>' attribute.
     * @see #setInboundHttpPort(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHttpPort()
     * @model default="8000"
     * @generated
     */
    String getInboundHttpPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHttpPort <em>Inbound Http Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Http Port</em>' attribute.
     * @see #getInboundHttpPort()
     * @generated
     */
    void setInboundHttpPort(String value);

    /**
     * Returns the value of the '<em><b>Inbound Worker Pool Size Core</b></em>' attribute.
     * The default value is <code>"400"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Worker Pool Size Core</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Worker Pool Size Core</em>' attribute.
     * @see #setInboundWorkerPoolSizeCore(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerPoolSizeCore()
     * @model default="400"
     * @generated
     */
    String getInboundWorkerPoolSizeCore();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeCore <em>Inbound Worker Pool Size Core</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Worker Pool Size Core</em>' attribute.
     * @see #getInboundWorkerPoolSizeCore()
     * @generated
     */
    void setInboundWorkerPoolSizeCore(String value);

    /**
     * Returns the value of the '<em><b>Inbound Worker Pool Size Max</b></em>' attribute.
     * The default value is <code>"500"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Worker Pool Size Max</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Worker Pool Size Max</em>' attribute.
     * @see #setInboundWorkerPoolSizeMax(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerPoolSizeMax()
     * @model default="500"
     * @generated
     */
    String getInboundWorkerPoolSizeMax();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeMax <em>Inbound Worker Pool Size Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Worker Pool Size Max</em>' attribute.
     * @see #getInboundWorkerPoolSizeMax()
     * @generated
     */
    void setInboundWorkerPoolSizeMax(String value);

    /**
     * Returns the value of the '<em><b>Inbound Worker Thread Keep Alive Sec</b></em>' attribute.
     * The default value is <code>"60"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Worker Thread Keep Alive Sec</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Worker Thread Keep Alive Sec</em>' attribute.
     * @see #setInboundWorkerThreadKeepAliveSec(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerThreadKeepAliveSec()
     * @model default="60"
     * @generated
     */
    String getInboundWorkerThreadKeepAliveSec();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerThreadKeepAliveSec <em>Inbound Worker Thread Keep Alive Sec</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Worker Thread Keep Alive Sec</em>' attribute.
     * @see #getInboundWorkerThreadKeepAliveSec()
     * @generated
     */
    void setInboundWorkerThreadKeepAliveSec(String value);

    /**
     * Returns the value of the '<em><b>Inbound Worker Pool Queue Length</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Worker Pool Queue Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Worker Pool Queue Length</em>' attribute.
     * @see #setInboundWorkerPoolQueueLength(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerPoolQueueLength()
     * @model default="-1"
     * @generated
     */
    String getInboundWorkerPoolQueueLength();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolQueueLength <em>Inbound Worker Pool Queue Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Worker Pool Queue Length</em>' attribute.
     * @see #getInboundWorkerPoolQueueLength()
     * @generated
     */
    void setInboundWorkerPoolQueueLength(String value);

    /**
     * Returns the value of the '<em><b>Inbound Thread Group Id</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Thread Group Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Thread Group Id</em>' attribute.
     * @see #setInboundThreadGroupId(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundThreadGroupId()
     * @model default=""
     * @generated
     */
    String getInboundThreadGroupId();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadGroupId <em>Inbound Thread Group Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Thread Group Id</em>' attribute.
     * @see #getInboundThreadGroupId()
     * @generated
     */
    void setInboundThreadGroupId(String value);

    /**
     * Returns the value of the '<em><b>Inbound Thread Id</b></em>' attribute.
     * The default value is <code>"PassThroughInboundWorkerPool"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inbound Thread Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Thread Id</em>' attribute.
     * @see #setInboundThreadId(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundThreadId()
     * @model default="PassThroughInboundWorkerPool"
     * @generated
     */
    String getInboundThreadId();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadId <em>Inbound Thread Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Thread Id</em>' attribute.
     * @see #getInboundThreadId()
     * @generated
     */
    void setInboundThreadId(String value);

    /**
     * Returns the value of the '<em><b>Dispatch Filter Pattern</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dispatch Filter Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dispatch Filter Pattern</em>' attribute.
     * @see #setDispatchFilterPattern(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_DispatchFilterPattern()
     * @model default=""
     * @generated
     */
    String getDispatchFilterPattern();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getDispatchFilterPattern <em>Dispatch Filter Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dispatch Filter Pattern</em>' attribute.
     * @see #getDispatchFilterPattern()
     * @generated
     */
    void setDispatchFilterPattern(String value);

    /**
     * Returns the value of the '<em><b>Interval</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interval</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interval</em>' attribute.
     * @see #setInterval(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Interval()
     * @model default="1000"
     * @generated
     */
    String getInterval();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInterval <em>Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interval</em>' attribute.
     * @see #getInterval()
     * @generated
     */
    void setInterval(String value);

    /**
     * Returns the value of the '<em><b>Sequential</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sequential</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sequential</em>' attribute.
     * @see #setSequential(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Sequential()
     * @model default="true"
     * @generated
     */
    boolean isSequential();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSequential <em>Sequential</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sequential</em>' attribute.
     * @see #isSequential()
     * @generated
     */
    void setSequential(boolean value);

    /**
     * Returns the value of the '<em><b>Coordination</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Coordination</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Coordination</em>' attribute.
     * @see #setCoordination(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Coordination()
     * @model default="true"
     * @generated
     */
    boolean isCoordination();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isCoordination <em>Coordination</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Coordination</em>' attribute.
     * @see #isCoordination()
     * @generated
     */
    void setCoordination(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS File URI</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS File URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS File URI</em>' attribute.
     * @see #setTransportVFSFileURI(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileURI()
     * @model default=""
     * @generated
     */
    String getTransportVFSFileURI();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileURI <em>Transport VFS File URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS File URI</em>' attribute.
     * @see #getTransportVFSFileURI()
     * @generated
     */
    void setTransportVFSFileURI(String value);

    /**
     * Returns the value of the '<em><b>Wso2mb Connection Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wso2mb Connection Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wso2mb Connection Url</em>' attribute.
     * @see #setWso2mbConnectionUrl(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Wso2mbConnectionUrl()
     * @model
     * @generated
     */
    String getWso2mbConnectionUrl();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getWso2mbConnectionUrl <em>Wso2mb Connection Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wso2mb Connection Url</em>' attribute.
     * @see #getWso2mbConnectionUrl()
     * @generated
     */
    void setWso2mbConnectionUrl(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Content Type</b></em>' attribute.
     * The default value is <code>"text/plain"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Content Type</em>' attribute.
     * @see #setTransportVFSContentType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSContentType()
     * @model default="text/plain"
     * @generated
     */
    String getTransportVFSContentType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSContentType <em>Transport VFS Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Content Type</em>' attribute.
     * @see #getTransportVFSContentType()
     * @generated
     */
    void setTransportVFSContentType(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS File Name Pattern</b></em>' attribute.
     * The default value is <code>".*.txt"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS File Name Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS File Name Pattern</em>' attribute.
     * @see #setTransportVFSFileNamePattern(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileNamePattern()
     * @model default=".*.txt"
     * @generated
     */
    String getTransportVFSFileNamePattern();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileNamePattern <em>Transport VFS File Name Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS File Name Pattern</em>' attribute.
     * @see #getTransportVFSFileNamePattern()
     * @generated
     */
    void setTransportVFSFileNamePattern(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS File Process Interval</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS File Process Interval</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS File Process Interval</em>' attribute.
     * @see #setTransportVFSFileProcessInterval(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileProcessInterval()
     * @model default=""
     * @generated
     */
    String getTransportVFSFileProcessInterval();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessInterval <em>Transport VFS File Process Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS File Process Interval</em>' attribute.
     * @see #getTransportVFSFileProcessInterval()
     * @generated
     */
    void setTransportVFSFileProcessInterval(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS File Process Count</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS File Process Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS File Process Count</em>' attribute.
     * @see #setTransportVFSFileProcessCount(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileProcessCount()
     * @model default=""
     * @generated
     */
    String getTransportVFSFileProcessCount();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessCount <em>Transport VFS File Process Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS File Process Count</em>' attribute.
     * @see #getTransportVFSFileProcessCount()
     * @generated
     */
    void setTransportVFSFileProcessCount(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Locking</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.Enable}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Locking</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Locking</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.Enable
     * @see #setTransportVFSLocking(Enable)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSLocking()
     * @model
     * @generated
     */
    Enable getTransportVFSLocking();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSLocking <em>Transport VFS Locking</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Locking</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.Enable
     * @see #getTransportVFSLocking()
     * @generated
     */
    void setTransportVFSLocking(Enable value);

    /**
     * Returns the value of the '<em><b>Transport VFS Max Retry Count</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Max Retry Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Max Retry Count</em>' attribute.
     * @see #setTransportVFSMaxRetryCount(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMaxRetryCount()
     * @model default=""
     * @generated
     */
    String getTransportVFSMaxRetryCount();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMaxRetryCount <em>Transport VFS Max Retry Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Max Retry Count</em>' attribute.
     * @see #getTransportVFSMaxRetryCount()
     * @generated
     */
    void setTransportVFSMaxRetryCount(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Move After Failed Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Move After Failed Move</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Move After Failed Move</em>' attribute.
     * @see #setTransportVFSMoveAfterFailedMove(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterFailedMove()
     * @model
     * @generated
     */
    String getTransportVFSMoveAfterFailedMove();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterFailedMove <em>Transport VFS Move After Failed Move</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Move After Failed Move</em>' attribute.
     * @see #getTransportVFSMoveAfterFailedMove()
     * @generated
     */
    void setTransportVFSMoveAfterFailedMove(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Reconnect Timeout</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Reconnect Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Reconnect Timeout</em>' attribute.
     * @see #setTransportVFSReconnectTimeout(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSReconnectTimeout()
     * @model default=""
     * @generated
     */
    String getTransportVFSReconnectTimeout();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReconnectTimeout <em>Transport VFS Reconnect Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Reconnect Timeout</em>' attribute.
     * @see #getTransportVFSReconnectTimeout()
     * @generated
     */
    void setTransportVFSReconnectTimeout(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Shared Subscription</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Shared Subscription</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Shared Subscription</em>' attribute.
     * @see #setTransportJMSSharedSubscription(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSharedSubscription()
     * @model default="false"
     * @generated
     */
    boolean isTransportJMSSharedSubscription();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSSharedSubscription <em>Transport JMS Shared Subscription</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Shared Subscription</em>' attribute.
     * @see #isTransportJMSSharedSubscription()
     * @generated
     */
    void setTransportJMSSharedSubscription(boolean value);

    /**
     * Returns the value of the '<em><b>Transport JMS Subscription Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Subscription Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Subscription Name</em>' attribute.
     * @see #setTransportJMSSubscriptionName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSubscriptionName()
     * @model
     * @generated
     */
    String getTransportJMSSubscriptionName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSubscriptionName <em>Transport JMS Subscription Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Subscription Name</em>' attribute.
     * @see #getTransportJMSSubscriptionName()
     * @generated
     */
    void setTransportJMSSubscriptionName(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Pinned Servers</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Pinned Servers</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Pinned Servers</em>' attribute.
     * @see #setTransportJMSPinnedServers(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSPinnedServers()
     * @model
     * @generated
     */
    String getTransportJMSPinnedServers();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPinnedServers <em>Transport JMS Pinned Servers</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Pinned Servers</em>' attribute.
     * @see #getTransportJMSPinnedServers()
     * @generated
     */
    void setTransportJMSPinnedServers(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Action After Process</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSAction}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Action After Process</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Action After Process</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
     * @see #setTransportVFSActionAfterProcess(VFSAction)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSActionAfterProcess()
     * @model
     * @generated
     */
    VFSAction getTransportVFSActionAfterProcess();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterProcess <em>Transport VFS Action After Process</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Action After Process</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
     * @see #getTransportVFSActionAfterProcess()
     * @generated
     */
    void setTransportVFSActionAfterProcess(VFSAction value);

    /**
     * Returns the value of the '<em><b>Transport VFS Move After Process</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Move After Process</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Move After Process</em>' attribute.
     * @see #setTransportVFSMoveAfterProcess(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterProcess()
     * @model default=""
     * @generated
     */
    String getTransportVFSMoveAfterProcess();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterProcess <em>Transport VFS Move After Process</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Move After Process</em>' attribute.
     * @see #getTransportVFSMoveAfterProcess()
     * @generated
     */
    void setTransportVFSMoveAfterProcess(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Action After Errors</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSAction}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Action After Errors</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Action After Errors</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
     * @see #setTransportVFSActionAfterErrors(VFSAction)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSActionAfterErrors()
     * @model
     * @generated
     */
    VFSAction getTransportVFSActionAfterErrors();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterErrors <em>Transport VFS Action After Errors</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Action After Errors</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
     * @see #getTransportVFSActionAfterErrors()
     * @generated
     */
    void setTransportVFSActionAfterErrors(VFSAction value);

    /**
     * Returns the value of the '<em><b>Transport VFS Move After Errors</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Move After Errors</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Move After Errors</em>' attribute.
     * @see #setTransportVFSMoveAfterErrors(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterErrors()
     * @model default=""
     * @generated
     */
    String getTransportVFSMoveAfterErrors();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterErrors <em>Transport VFS Move After Errors</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Move After Errors</em>' attribute.
     * @see #getTransportVFSMoveAfterErrors()
     * @generated
     */
    void setTransportVFSMoveAfterErrors(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Failed Records File Name</b></em>' attribute.
     * The default value is <code>"vfs-move-failed-records.properties"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Failed Records File Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Failed Records File Name</em>' attribute.
     * @see #setTransportVFSFailedRecordsFileName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFailedRecordsFileName()
     * @model default="vfs-move-failed-records.properties"
     * @generated
     */
    String getTransportVFSFailedRecordsFileName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFailedRecordsFileName <em>Transport VFS Failed Records File Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Failed Records File Name</em>' attribute.
     * @see #getTransportVFSFailedRecordsFileName()
     * @generated
     */
    void setTransportVFSFailedRecordsFileName(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Failed Records File Destination</b></em>' attribute.
     * The default value is <code>"repository/conf/"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Failed Records File Destination</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Failed Records File Destination</em>' attribute.
     * @see #setTransportVFSFailedRecordsFileDestination(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFailedRecordsFileDestination()
     * @model default="repository/conf/"
     * @generated
     */
    String getTransportVFSFailedRecordsFileDestination();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFailedRecordsFileDestination <em>Transport VFS Failed Records File Destination</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Failed Records File Destination</em>' attribute.
     * @see #getTransportVFSFailedRecordsFileDestination()
     * @generated
     */
    void setTransportVFSFailedRecordsFileDestination(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Move Failed Record Timestamp Format</b></em>' attribute.
     * The default value is <code>"dd-MM-yyyy HH:mm:ss"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Move Failed Record Timestamp Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Move Failed Record Timestamp Format</em>' attribute.
     * @see #setTransportVFSMoveFailedRecordTimestampFormat(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveFailedRecordTimestampFormat()
     * @model default="dd-MM-yyyy HH:mm:ss"
     * @generated
     */
    String getTransportVFSMoveFailedRecordTimestampFormat();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveFailedRecordTimestampFormat <em>Transport VFS Move Failed Record Timestamp Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Move Failed Record Timestamp Format</em>' attribute.
     * @see #getTransportVFSMoveFailedRecordTimestampFormat()
     * @generated
     */
    void setTransportVFSMoveFailedRecordTimestampFormat(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Failed Record Next Retry Duration</b></em>' attribute.
     * The default value is <code>"3000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Failed Record Next Retry Duration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Failed Record Next Retry Duration</em>' attribute.
     * @see #setTransportVFSFailedRecordNextRetryDuration(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFailedRecordNextRetryDuration()
     * @model default="3000"
     * @generated
     */
    String getTransportVFSFailedRecordNextRetryDuration();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFailedRecordNextRetryDuration <em>Transport VFS Failed Record Next Retry Duration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Failed Record Next Retry Duration</em>' attribute.
     * @see #getTransportVFSFailedRecordNextRetryDuration()
     * @generated
     */
    void setTransportVFSFailedRecordNextRetryDuration(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Action After Failure</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSAction}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Action After Failure</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Action After Failure</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
     * @see #setTransportVFSActionAfterFailure(VFSAction)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSActionAfterFailure()
     * @model
     * @generated
     */
    VFSAction getTransportVFSActionAfterFailure();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterFailure <em>Transport VFS Action After Failure</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Action After Failure</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
     * @see #getTransportVFSActionAfterFailure()
     * @generated
     */
    void setTransportVFSActionAfterFailure(VFSAction value);

    /**
     * Returns the value of the '<em><b>Transport VFS Move After Failure</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Move After Failure</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Move After Failure</em>' attribute.
     * @see #setTransportVFSMoveAfterFailure(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterFailure()
     * @model default=""
     * @generated
     */
    String getTransportVFSMoveAfterFailure();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterFailure <em>Transport VFS Move After Failure</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Move After Failure</em>' attribute.
     * @see #getTransportVFSMoveAfterFailure()
     * @generated
     */
    void setTransportVFSMoveAfterFailure(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Reply File URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Reply File URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Reply File URI</em>' attribute.
     * @see #setTransportVFSReplyFileURI(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSReplyFileURI()
     * @model
     * @generated
     */
    String getTransportVFSReplyFileURI();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReplyFileURI <em>Transport VFS Reply File URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Reply File URI</em>' attribute.
     * @see #getTransportVFSReplyFileURI()
     * @generated
     */
    void setTransportVFSReplyFileURI(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Reply File Name</b></em>' attribute.
     * The default value is <code>"response.xml"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Reply File Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Reply File Name</em>' attribute.
     * @see #setTransportVFSReplyFileName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSReplyFileName()
     * @model default="response.xml"
     * @generated
     */
    String getTransportVFSReplyFileName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReplyFileName <em>Transport VFS Reply File Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Reply File Name</em>' attribute.
     * @see #getTransportVFSReplyFileName()
     * @generated
     */
    void setTransportVFSReplyFileName(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Auto Lock Release</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Auto Lock Release</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Auto Lock Release</em>' attribute.
     * @see #setTransportVFSAutoLockRelease(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSAutoLockRelease()
     * @model default="false"
     * @generated
     */
    boolean isTransportVFSAutoLockRelease();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSAutoLockRelease <em>Transport VFS Auto Lock Release</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Auto Lock Release</em>' attribute.
     * @see #isTransportVFSAutoLockRelease()
     * @generated
     */
    void setTransportVFSAutoLockRelease(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS Auto Lock Release Interval</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Auto Lock Release Interval</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Auto Lock Release Interval</em>' attribute.
     * @see #setTransportVFSAutoLockReleaseInterval(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSAutoLockReleaseInterval()
     * @model default=""
     * @generated
     */
    String getTransportVFSAutoLockReleaseInterval();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSAutoLockReleaseInterval <em>Transport VFS Auto Lock Release Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Auto Lock Release Interval</em>' attribute.
     * @see #getTransportVFSAutoLockReleaseInterval()
     * @generated
     */
    void setTransportVFSAutoLockReleaseInterval(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Lock Release Same Node</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Lock Release Same Node</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Lock Release Same Node</em>' attribute.
     * @see #setTransportVFSLockReleaseSameNode(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSLockReleaseSameNode()
     * @model default="false"
     * @generated
     */
    boolean isTransportVFSLockReleaseSameNode();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSLockReleaseSameNode <em>Transport VFS Lock Release Same Node</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Lock Release Same Node</em>' attribute.
     * @see #isTransportVFSLockReleaseSameNode()
     * @generated
     */
    void setTransportVFSLockReleaseSameNode(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS Distributed Lock</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Distributed Lock</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Distributed Lock</em>' attribute.
     * @see #setTransportVFSDistributedLock(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSDistributedLock()
     * @model default="false"
     * @generated
     */
    boolean isTransportVFSDistributedLock();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSDistributedLock <em>Transport VFS Distributed Lock</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Distributed Lock</em>' attribute.
     * @see #isTransportVFSDistributedLock()
     * @generated
     */
    void setTransportVFSDistributedLock(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS Streaming</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Streaming</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Streaming</em>' attribute.
     * @see #setTransportVFSStreaming(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSStreaming()
     * @model default="false"
     * @generated
     */
    boolean isTransportVFSStreaming();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSStreaming <em>Transport VFS Streaming</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Streaming</em>' attribute.
     * @see #isTransportVFSStreaming()
     * @generated
     */
    void setTransportVFSStreaming(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS Build</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Build</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Build</em>' attribute.
     * @see #setTransportVFSBuild(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSBuild()
     * @model default="false"
     * @generated
     */
    boolean isTransportVFSBuild();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSBuild <em>Transport VFS Build</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Build</em>' attribute.
     * @see #isTransportVFSBuild()
     * @generated
     */
    void setTransportVFSBuild(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS Distributed Timeout</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Distributed Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Distributed Timeout</em>' attribute.
     * @see #setTransportVFSDistributedTimeout(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSDistributedTimeout()
     * @model default=""
     * @generated
     */
    String getTransportVFSDistributedTimeout();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSDistributedTimeout <em>Transport VFS Distributed Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Distributed Timeout</em>' attribute.
     * @see #getTransportVFSDistributedTimeout()
     * @generated
     */
    void setTransportVFSDistributedTimeout(String value);

    /**
     * Returns the value of the '<em><b>Transport VFSSFTP Identities</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFSSFTP Identities</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFSSFTP Identities</em>' attribute.
     * @see #setTransportVFSSFTPIdentities(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSSFTPIdentities()
     * @model
     * @generated
     */
    String getTransportVFSSFTPIdentities();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSFTPIdentities <em>Transport VFSSFTP Identities</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFSSFTP Identities</em>' attribute.
     * @see #getTransportVFSSFTPIdentities()
     * @generated
     */
    void setTransportVFSSFTPIdentities(String value);

    /**
     * Returns the value of the '<em><b>Transport VFSSFTP Identity Pass Phrase</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFSSFTP Identity Pass Phrase</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFSSFTP Identity Pass Phrase</em>' attribute.
     * @see #setTransportVFSSFTPIdentityPassPhrase(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSSFTPIdentityPassPhrase()
     * @model
     * @generated
     */
    String getTransportVFSSFTPIdentityPassPhrase();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSFTPIdentityPassPhrase <em>Transport VFSSFTP Identity Pass Phrase</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFSSFTP Identity Pass Phrase</em>' attribute.
     * @see #getTransportVFSSFTPIdentityPassPhrase()
     * @generated
     */
    void setTransportVFSSFTPIdentityPassPhrase(String value);

    /**
     * Returns the value of the '<em><b>Transport VFSSFTP User Dir Is Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFSSFTP User Dir Is Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFSSFTP User Dir Is Root</em>' attribute.
     * @see #setTransportVFSSFTPUserDirIsRoot(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSSFTPUserDirIsRoot()
     * @model
     * @generated
     */
    boolean isTransportVFSSFTPUserDirIsRoot();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSSFTPUserDirIsRoot <em>Transport VFSSFTP User Dir Is Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFSSFTP User Dir Is Root</em>' attribute.
     * @see #isTransportVFSSFTPUserDirIsRoot()
     * @generated
     */
    void setTransportVFSSFTPUserDirIsRoot(boolean value);

    /**
     * Returns the value of the '<em><b>Java Naming Factory Initial</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Java Naming Factory Initial</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Java Naming Factory Initial</em>' attribute.
     * @see #setJavaNamingFactoryInitial(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_JavaNamingFactoryInitial()
     * @model default=""
     * @generated
     */
    String getJavaNamingFactoryInitial();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingFactoryInitial <em>Java Naming Factory Initial</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Java Naming Factory Initial</em>' attribute.
     * @see #getJavaNamingFactoryInitial()
     * @generated
     */
    void setJavaNamingFactoryInitial(String value);

    /**
     * Returns the value of the '<em><b>Java Naming Provider Url</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Java Naming Provider Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Java Naming Provider Url</em>' attribute.
     * @see #setJavaNamingProviderUrl(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_JavaNamingProviderUrl()
     * @model default=""
     * @generated
     */
    String getJavaNamingProviderUrl();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingProviderUrl <em>Java Naming Provider Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Java Naming Provider Url</em>' attribute.
     * @see #getJavaNamingProviderUrl()
     * @generated
     */
    void setJavaNamingProviderUrl(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Connection Factory JNDI Name</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Connection Factory JNDI Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Connection Factory JNDI Name</em>' attribute.
     * @see #setTransportJMSConnectionFactoryJNDIName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSConnectionFactoryJNDIName()
     * @model default=""
     * @generated
     */
    String getTransportJMSConnectionFactoryJNDIName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryJNDIName <em>Transport JMS Connection Factory JNDI Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Connection Factory JNDI Name</em>' attribute.
     * @see #getTransportJMSConnectionFactoryJNDIName()
     * @generated
     */
    void setTransportJMSConnectionFactoryJNDIName(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Connection Factory Type</b></em>' attribute.
     * The default value is <code>"queue"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Connection Factory Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Connection Factory Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType
     * @see #setTransportJMSConnectionFactoryType(JMSConnectionFactoryType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSConnectionFactoryType()
     * @model default="queue"
     * @generated
     */
    JMSConnectionFactoryType getTransportJMSConnectionFactoryType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryType <em>Transport JMS Connection Factory Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Connection Factory Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType
     * @see #getTransportJMSConnectionFactoryType()
     * @generated
     */
    void setTransportJMSConnectionFactoryType(JMSConnectionFactoryType value);

    /**
     * Returns the value of the '<em><b>Transport JMS Concurrent Consumers</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Concurrent Consumers</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Concurrent Consumers</em>' attribute.
     * @see #setTransportJMSConcurrentConsumers(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSConcurrentConsumers()
     * @model
     * @generated
     */
    String getTransportJMSConcurrentConsumers();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConcurrentConsumers <em>Transport JMS Concurrent Consumers</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Concurrent Consumers</em>' attribute.
     * @see #getTransportJMSConcurrentConsumers()
     * @generated
     */
    void setTransportJMSConcurrentConsumers(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Destination</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Destination</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Destination</em>' attribute.
     * @see #setTransportJMSDestination(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSDestination()
     * @model default=""
     * @generated
     */
    String getTransportJMSDestination();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDestination <em>Transport JMS Destination</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Destination</em>' attribute.
     * @see #getTransportJMSDestination()
     * @generated
     */
    void setTransportJMSDestination(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Session Transacted</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Session Transacted</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Session Transacted</em>' attribute.
     * @see #setTransportJMSSessionTransacted(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSessionTransacted()
     * @model default="false"
     * @generated
     */
    boolean isTransportJMSSessionTransacted();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSSessionTransacted <em>Transport JMS Session Transacted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Session Transacted</em>' attribute.
     * @see #isTransportJMSSessionTransacted()
     * @generated
     */
    void setTransportJMSSessionTransacted(boolean value);

    /**
     * Returns the value of the '<em><b>Transport JMS Session Acknowledgement</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Session Acknowledgement</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Session Acknowledgement</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement
     * @see #setTransportJMSSessionAcknowledgement(JMSSessionAcknowledgement)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSessionAcknowledgement()
     * @model
     * @generated
     */
    JMSSessionAcknowledgement getTransportJMSSessionAcknowledgement();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSessionAcknowledgement <em>Transport JMS Session Acknowledgement</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Session Acknowledgement</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement
     * @see #getTransportJMSSessionAcknowledgement()
     * @generated
     */
    void setTransportJMSSessionAcknowledgement(JMSSessionAcknowledgement value);

    /**
     * Returns the value of the '<em><b>Transport JMS Cache Level</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Cache Level</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Cache Level</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel
     * @see #setTransportJMSCacheLevel(JMSCacheLevel)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSCacheLevel()
     * @model
     * @generated
     */
    JMSCacheLevel getTransportJMSCacheLevel();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSCacheLevel <em>Transport JMS Cache Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Cache Level</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel
     * @see #getTransportJMSCacheLevel()
     * @generated
     */
    void setTransportJMSCacheLevel(JMSCacheLevel value);

    /**
     * Returns the value of the '<em><b>Transport JMS User Name</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS User Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS User Name</em>' attribute.
     * @see #setTransportJMSUserName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSUserName()
     * @model default=""
     * @generated
     */
    String getTransportJMSUserName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSUserName <em>Transport JMS User Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS User Name</em>' attribute.
     * @see #getTransportJMSUserName()
     * @generated
     */
    void setTransportJMSUserName(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Password</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Password</em>' attribute.
     * @see #setTransportJMSPassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSPassword()
     * @model default=""
     * @generated
     */
    String getTransportJMSPassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPassword <em>Transport JMS Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Password</em>' attribute.
     * @see #getTransportJMSPassword()
     * @generated
     */
    void setTransportJMSPassword(String value);

    /**
     * Returns the value of the '<em><b>Transport JMSJMS Spec Version</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMSJMS Spec Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMSJMS Spec Version</em>' attribute.
     * @see #setTransportJMSJMSSpecVersion(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSJMSSpecVersion()
     * @model default=""
     * @generated
     */
    String getTransportJMSJMSSpecVersion();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSJMSSpecVersion <em>Transport JMSJMS Spec Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMSJMS Spec Version</em>' attribute.
     * @see #getTransportJMSJMSSpecVersion()
     * @generated
     */
    void setTransportJMSJMSSpecVersion(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Subscription Durable</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Subscription Durable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Subscription Durable</em>' attribute.
     * @see #setTransportJMSSubscriptionDurable(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSubscriptionDurable()
     * @model default=""
     * @generated
     */
    String getTransportJMSSubscriptionDurable();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSubscriptionDurable <em>Transport JMS Subscription Durable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Subscription Durable</em>' attribute.
     * @see #getTransportJMSSubscriptionDurable()
     * @generated
     */
    void setTransportJMSSubscriptionDurable(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Durable Subscriber Client ID</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Durable Subscriber Client ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Durable Subscriber Client ID</em>' attribute.
     * @see #setTransportJMSDurableSubscriberClientID(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSDurableSubscriberClientID()
     * @model default=""
     * @generated
     */
    String getTransportJMSDurableSubscriberClientID();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDurableSubscriberClientID <em>Transport JMS Durable Subscriber Client ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Durable Subscriber Client ID</em>' attribute.
     * @see #getTransportJMSDurableSubscriberClientID()
     * @generated
     */
    void setTransportJMSDurableSubscriberClientID(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Message Selector</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Message Selector</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Message Selector</em>' attribute.
     * @see #setTransportJMSMessageSelector(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSMessageSelector()
     * @model default=""
     * @generated
     */
    String getTransportJMSMessageSelector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSMessageSelector <em>Transport JMS Message Selector</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Message Selector</em>' attribute.
     * @see #getTransportJMSMessageSelector()
     * @generated
     */
    void setTransportJMSMessageSelector(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Retry Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Retry Duration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Retry Duration</em>' attribute.
     * @see #setTransportJMSRetryDuration(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSRetryDuration()
     * @model
     * @generated
     */
    String getTransportJMSRetryDuration();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSRetryDuration <em>Transport JMS Retry Duration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Retry Duration</em>' attribute.
     * @see #getTransportJMSRetryDuration()
     * @generated
     */
    void setTransportJMSRetryDuration(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Move Timestamp Format</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Move Timestamp Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Move Timestamp Format</em>' attribute.
     * @see #setTransportVFSMoveTimestampFormat(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveTimestampFormat()
     * @model default=""
     * @generated
     */
    String getTransportVFSMoveTimestampFormat();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveTimestampFormat <em>Transport VFS Move Timestamp Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Move Timestamp Format</em>' attribute.
     * @see #getTransportVFSMoveTimestampFormat()
     * @generated
     */
    void setTransportVFSMoveTimestampFormat(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS File Sort Attribute</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS File Sort Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS File Sort Attribute</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort
     * @see #setTransportVFSFileSortAttribute(VFSFileSort)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileSortAttribute()
     * @model
     * @generated
     */
    VFSFileSort getTransportVFSFileSortAttribute();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileSortAttribute <em>Transport VFS File Sort Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS File Sort Attribute</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort
     * @see #getTransportVFSFileSortAttribute()
     * @generated
     */
    void setTransportVFSFileSortAttribute(VFSFileSort value);

    /**
     * Returns the value of the '<em><b>Transport VFS File Sort Ascending</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS File Sort Ascending</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS File Sort Ascending</em>' attribute.
     * @see #setTransportVFSFileSortAscending(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileSortAscending()
     * @model default="true"
     * @generated
     */
    boolean isTransportVFSFileSortAscending();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSFileSortAscending <em>Transport VFS File Sort Ascending</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS File Sort Ascending</em>' attribute.
     * @see #isTransportVFSFileSortAscending()
     * @generated
     */
    void setTransportVFSFileSortAscending(boolean value);

    /**
     * Returns the value of the '<em><b>Transport VFS Sub Folder Timestamp Format</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Sub Folder Timestamp Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Sub Folder Timestamp Format</em>' attribute.
     * @see #setTransportVFSSubFolderTimestampFormat(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSSubFolderTimestampFormat()
     * @model default=""
     * @generated
     */
    String getTransportVFSSubFolderTimestampFormat();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSubFolderTimestampFormat <em>Transport VFS Sub Folder Timestamp Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Sub Folder Timestamp Format</em>' attribute.
     * @see #getTransportVFSSubFolderTimestampFormat()
     * @generated
     */
    void setTransportVFSSubFolderTimestampFormat(String value);

    /**
     * Returns the value of the '<em><b>Transport VFS Create Folder</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport VFS Create Folder</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport VFS Create Folder</em>' attribute.
     * @see #setTransportVFSCreateFolder(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSCreateFolder()
     * @model default="true"
     * @generated
     */
    boolean isTransportVFSCreateFolder();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSCreateFolder <em>Transport VFS Create Folder</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport VFS Create Folder</em>' attribute.
     * @see #isTransportVFSCreateFolder()
     * @generated
     */
    void setTransportVFSCreateFolder(boolean value);

    /**
     * Returns the value of the '<em><b>Transport JMS Receive Timeout</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Receive Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Receive Timeout</em>' attribute.
     * @see #setTransportJMSReceiveTimeout(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSReceiveTimeout()
     * @model default=""
     * @generated
     */
    String getTransportJMSReceiveTimeout();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReceiveTimeout <em>Transport JMS Receive Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Receive Timeout</em>' attribute.
     * @see #getTransportJMSReceiveTimeout()
     * @generated
     */
    void setTransportJMSReceiveTimeout(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Content Type</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Content Type</em>' attribute.
     * @see #setTransportJMSContentType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSContentType()
     * @model default=""
     * @generated
     */
    String getTransportJMSContentType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentType <em>Transport JMS Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Content Type</em>' attribute.
     * @see #getTransportJMSContentType()
     * @generated
     */
    void setTransportJMSContentType(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Content Type Property</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Content Type Property</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Content Type Property</em>' attribute.
     * @see #setTransportJMSContentTypeProperty(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSContentTypeProperty()
     * @model default=""
     * @generated
     */
    String getTransportJMSContentTypeProperty();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentTypeProperty <em>Transport JMS Content Type Property</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Content Type Property</em>' attribute.
     * @see #getTransportJMSContentTypeProperty()
     * @generated
     */
    void setTransportJMSContentTypeProperty(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Reply Destination</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Reply Destination</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Reply Destination</em>' attribute.
     * @see #setTransportJMSReplyDestination(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSReplyDestination()
     * @model default=""
     * @generated
     */
    String getTransportJMSReplyDestination();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReplyDestination <em>Transport JMS Reply Destination</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Reply Destination</em>' attribute.
     * @see #getTransportJMSReplyDestination()
     * @generated
     */
    void setTransportJMSReplyDestination(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Pub Sub No Local</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Pub Sub No Local</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Pub Sub No Local</em>' attribute.
     * @see #setTransportJMSPubSubNoLocal(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSPubSubNoLocal()
     * @model default=""
     * @generated
     */
    String getTransportJMSPubSubNoLocal();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPubSubNoLocal <em>Transport JMS Pub Sub No Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Pub Sub No Local</em>' attribute.
     * @see #getTransportJMSPubSubNoLocal()
     * @generated
     */
    void setTransportJMSPubSubNoLocal(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Durable Subscriber Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Durable Subscriber Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Durable Subscriber Name</em>' attribute.
     * @see #setTransportJMSDurableSubscriberName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSDurableSubscriberName()
     * @model
     * @generated
     */
    String getTransportJMSDurableSubscriberName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDurableSubscriberName <em>Transport JMS Durable Subscriber Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Durable Subscriber Name</em>' attribute.
     * @see #getTransportJMSDurableSubscriberName()
     * @generated
     */
    void setTransportJMSDurableSubscriberName(String value);

    /**
     * Returns the value of the '<em><b>Transport JMS Broker Type</b></em>' attribute.
     * The default value is <code>"OTHER"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSBrokerType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport JMS Broker Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport JMS Broker Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSBrokerType
     * @see #setTransportJMSBrokerType(JMSBrokerType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSBrokerType()
     * @model default="OTHER"
     * @generated
     */
    JMSBrokerType getTransportJMSBrokerType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSBrokerType <em>Transport JMS Broker Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport JMS Broker Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSBrokerType
     * @see #getTransportJMSBrokerType()
     * @generated
     */
    void setTransportJMSBrokerType(JMSBrokerType value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Connection Factory</b></em>' attribute.
     * The default value is <code>"AMQPConnectionFactory"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Connection Factory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Connection Factory</em>' attribute.
     * @see #setTransportMQTTConnectionFactory(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTConnectionFactory()
     * @model default="AMQPConnectionFactory"
     * @generated
     */
    String getTransportMQTTConnectionFactory();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTConnectionFactory <em>Transport MQTT Connection Factory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Connection Factory</em>' attribute.
     * @see #getTransportMQTTConnectionFactory()
     * @generated
     */
    void setTransportMQTTConnectionFactory(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Server Host Name</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Server Host Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Server Host Name</em>' attribute.
     * @see #setTransportMQTTServerHostName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTServerHostName()
     * @model default=""
     * @generated
     */
    String getTransportMQTTServerHostName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerHostName <em>Transport MQTT Server Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Server Host Name</em>' attribute.
     * @see #getTransportMQTTServerHostName()
     * @generated
     */
    void setTransportMQTTServerHostName(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Server Port</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Server Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Server Port</em>' attribute.
     * @see #setTransportMQTTServerPort(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTServerPort()
     * @model default=""
     * @generated
     */
    String getTransportMQTTServerPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerPort <em>Transport MQTT Server Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Server Port</em>' attribute.
     * @see #getTransportMQTTServerPort()
     * @generated
     */
    void setTransportMQTTServerPort(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Topic Name</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Topic Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Topic Name</em>' attribute.
     * @see #setTransportMQTTTopicName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTTopicName()
     * @model default=""
     * @generated
     */
    String getTransportMQTTTopicName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTopicName <em>Transport MQTT Topic Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Topic Name</em>' attribute.
     * @see #getTransportMQTTTopicName()
     * @generated
     */
    void setTransportMQTTTopicName(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Subscription QOS</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Subscription QOS</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Subscription QOS</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS
     * @see #setTransportMQTTSubscriptionQOS(MQTTSubscriptionQOS)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSubscriptionQOS()
     * @model
     * @generated
     */
    MQTTSubscriptionQOS getTransportMQTTSubscriptionQOS();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionQOS <em>Transport MQTT Subscription QOS</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Subscription QOS</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS
     * @see #getTransportMQTTSubscriptionQOS()
     * @generated
     */
    void setTransportMQTTSubscriptionQOS(MQTTSubscriptionQOS value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Session Clean</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Session Clean</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Session Clean</em>' attribute.
     * @see #setTransportMQTTSessionClean(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSessionClean()
     * @model
     * @generated
     */
    boolean isTransportMQTTSessionClean();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportMQTTSessionClean <em>Transport MQTT Session Clean</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Session Clean</em>' attribute.
     * @see #isTransportMQTTSessionClean()
     * @generated
     */
    void setTransportMQTTSessionClean(boolean value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Ssl Enable</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Ssl Enable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Ssl Enable</em>' attribute.
     * @see #setTransportMQTTSslEnable(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslEnable()
     * @model default=""
     * @generated
     */
    String getTransportMQTTSslEnable();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslEnable <em>Transport MQTT Ssl Enable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Ssl Enable</em>' attribute.
     * @see #getTransportMQTTSslEnable()
     * @generated
     */
    void setTransportMQTTSslEnable(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Temporary Store Directory</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Temporary Store Directory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Temporary Store Directory</em>' attribute.
     * @see #setTransportMQTTTemporaryStoreDirectory(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTTemporaryStoreDirectory()
     * @model default=""
     * @generated
     */
    String getTransportMQTTTemporaryStoreDirectory();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTemporaryStoreDirectory <em>Transport MQTT Temporary Store Directory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Temporary Store Directory</em>' attribute.
     * @see #getTransportMQTTTemporaryStoreDirectory()
     * @generated
     */
    void setTransportMQTTTemporaryStoreDirectory(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Subscription Username</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Subscription Username</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Subscription Username</em>' attribute.
     * @see #setTransportMQTTSubscriptionUsername(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSubscriptionUsername()
     * @model default=""
     * @generated
     */
    String getTransportMQTTSubscriptionUsername();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionUsername <em>Transport MQTT Subscription Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Subscription Username</em>' attribute.
     * @see #getTransportMQTTSubscriptionUsername()
     * @generated
     */
    void setTransportMQTTSubscriptionUsername(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Subscription Password</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Subscription Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Subscription Password</em>' attribute.
     * @see #setTransportMQTTSubscriptionPassword(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSubscriptionPassword()
     * @model default=""
     * @generated
     */
    String getTransportMQTTSubscriptionPassword();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionPassword <em>Transport MQTT Subscription Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Subscription Password</em>' attribute.
     * @see #getTransportMQTTSubscriptionPassword()
     * @generated
     */
    void setTransportMQTTSubscriptionPassword(String value);

    /**
     * Returns the value of the '<em><b>Transport MQTT Client Id</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transport MQTT Client Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transport MQTT Client Id</em>' attribute.
     * @see #setTransportMQTTClientId(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTClientId()
     * @model default=""
     * @generated
     */
    String getTransportMQTTClientId();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTClientId <em>Transport MQTT Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transport MQTT Client Id</em>' attribute.
     * @see #getTransportMQTTClientId()
     * @generated
     */
    void setTransportMQTTClientId(String value);

    /**
     * Returns the value of the '<em><b>Truststore</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Truststore</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Truststore</em>' attribute.
     * @see #setTruststore(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Truststore()
     * @model default=""
     * @generated
     */
    String getTruststore();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTruststore <em>Truststore</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Truststore</em>' attribute.
     * @see #getTruststore()
     * @generated
     */
    void setTruststore(String value);

    /**
     * Returns the value of the '<em><b>Keystore</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Keystore</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Keystore</em>' attribute.
     * @see #setKeystore(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Keystore()
     * @model default=""
     * @generated
     */
    String getKeystore();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getKeystore <em>Keystore</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Keystore</em>' attribute.
     * @see #getKeystore()
     * @generated
     */
    void setKeystore(String value);

    /**
     * Returns the value of the '<em><b>Ssl Verify Client</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ssl Verify Client</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ssl Verify Client</em>' attribute.
     * @see #setSslVerifyClient(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SslVerifyClient()
     * @model default=""
     * @generated
     */
    String getSslVerifyClient();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslVerifyClient <em>Ssl Verify Client</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ssl Verify Client</em>' attribute.
     * @see #getSslVerifyClient()
     * @generated
     */
    void setSslVerifyClient(String value);

    /**
     * Returns the value of the '<em><b>Ssl Protocol</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ssl Protocol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ssl Protocol</em>' attribute.
     * @see #setSslProtocol(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SslProtocol()
     * @model default=""
     * @generated
     */
    String getSslProtocol();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslProtocol <em>Ssl Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ssl Protocol</em>' attribute.
     * @see #getSslProtocol()
     * @generated
     */
    void setSslProtocol(String value);

    /**
     * Returns the value of the '<em><b>Https Protocols</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Https Protocols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Https Protocols</em>' attribute.
     * @see #setHttpsProtocols(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_HttpsProtocols()
     * @model default=""
     * @generated
     */
    String getHttpsProtocols();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getHttpsProtocols <em>Https Protocols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Https Protocols</em>' attribute.
     * @see #getHttpsProtocols()
     * @generated
     */
    void setHttpsProtocols(String value);

    /**
     * Returns the value of the '<em><b>Certificate Revocation Verifier</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Certificate Revocation Verifier</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Certificate Revocation Verifier</em>' attribute.
     * @see #setCertificateRevocationVerifier(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_CertificateRevocationVerifier()
     * @model default=""
     * @generated
     */
    String getCertificateRevocationVerifier();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getCertificateRevocationVerifier <em>Certificate Revocation Verifier</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Certificate Revocation Verifier</em>' attribute.
     * @see #getCertificateRevocationVerifier()
     * @generated
     */
    void setCertificateRevocationVerifier(String value);

} // InboundEndpoint
