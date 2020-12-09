/*
 * Copyright 2015-2018 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpointBehaviourType;
import org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.Sequence;
import org.wso2.integrationstudio.eclipse.gmf.esb.TopicFilterFromType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TopicsType;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;

public class InboundEndpointTransformer extends AbstractEsbNodeTransformer {

    private static final String CUSTOM = "custom";
    private static final String POLLING_BEHAVIOUR = "polling";
    private static final String LISTENING_BEHAVIOUR = "listening";
    private static final String EVENT_BASED_BEHAVIOUR = "eventBased";
    private static final String REGISTRY_PREFIX = "$registry:";
    private static final String WSO2MB = "wso2_mb";
    private static final String TOPIC = "topic";
    private static final String QUEUE = "queue";
    private static final String JMS = "jms";

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        Assert.isTrue(subject instanceof org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpoint, "Invalid subject.");
        org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint = (org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpoint) subject;
        if (visualInboundEndpoint.getName() != null) {
            information.getSynapseConfiguration().addInboundEndpoint(visualInboundEndpoint.getName(),
                    create(visualInboundEndpoint));
        }
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        // TODO Auto-generated method stub

    }

    /**
     * User can retrieve associated sequence providing the relevant output
     * connector.
     * 
     * @param outputConnector
     * @return
     */
    private Sequence getSequence(OutputConnector outputConnector) {
        EObject container;
        if (outputConnector != null) {
            EsbLink link = outputConnector.getOutgoingLink();
            if (link != null) {
                container = link.getTarget().eContainer();
                if (container instanceof Sequence) {
                    return (Sequence) container;
                }
            }
        }
        return null;
    }

    /**
     * Create an org.apache.synapse.inbound.InboundEndpoint object from an
     * org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpoint
     * 
     * @param visualInboundEndpoint
     * @return
     * @throws TransformerException
     * @throws Exception
     */
    private InboundEndpoint create(org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint)
            throws TransformerException {
        InboundEndpoint inboundEndpoint = new InboundEndpoint();
        inboundEndpoint.setName(visualInboundEndpoint.getName());

        Sequence sequence = getSequence(visualInboundEndpoint.getSequenceOutputConnector());
        Sequence onErrorSequence = getSequence(visualInboundEndpoint.getOnErrorSequenceOutputConnector());

        inboundEndpoint.configure(new AspectConfiguration(visualInboundEndpoint.getName()));
        if (visualInboundEndpoint.isStatisticsEnabled()) {
            inboundEndpoint.getAspectConfiguration().enableStatistics();
        } else {
            inboundEndpoint.getAspectConfiguration().disableStatistics();
        }
        if (visualInboundEndpoint.isTraceEnabled()) {
            inboundEndpoint.getAspectConfiguration().enableTracing();
        } else {
            inboundEndpoint.getAspectConfiguration().disableTracing();
        }
        if (sequence != null) {
            inboundEndpoint.setInjectingSeq(sequence.getName());
        }

        if (onErrorSequence != null) {
            inboundEndpoint.setOnErrorSeq(onErrorSequence.getName());
        }

        if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSuspend()))) {
            inboundEndpoint.setSuspend(visualInboundEndpoint.isSuspend());
        }

        if (visualInboundEndpoint.getType().getName().equals(CUSTOM)) {
            if (StringUtils.isNotBlank(visualInboundEndpoint.getClass_())) {
                inboundEndpoint.setClassImpl(visualInboundEndpoint.getClass_());
            } else {
                inboundEndpoint.setClassImpl("org.wso2.carbon.inbound.custom.poll.SamplePollingClient");
            }
            EList<InboundEndpointParameter> serviceParameters = visualInboundEndpoint.getServiceParameters();
            for (InboundEndpointParameter inboundEndpointParameter : serviceParameters) {
                String value = inboundEndpointParameter.getValue();
                if (StringUtils.isNotBlank(value)) {
                    inboundEndpoint.addParameter(inboundEndpointParameter.getName(), value);
                }

            }
        } else if (StringUtils.isNotBlank(visualInboundEndpoint.getType().getName())) {
            if (visualInboundEndpoint.getType().getName().equals(WSO2MB)) {
                inboundEndpoint.setProtocol(JMS);
            } else {
                inboundEndpoint.setProtocol(visualInboundEndpoint.getType().getName());
            }

        }

        switch (visualInboundEndpoint.getType()) {
        case HTTP:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHttpPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HTTP_PORT,
                        visualInboundEndpoint.getInboundHttpPort());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HTTP_PORT, "8000");
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerPoolSizeCore()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_CORE,
                        visualInboundEndpoint.getInboundWorkerPoolSizeCore());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerPoolSizeMax()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_MAX,
                        visualInboundEndpoint.getInboundWorkerPoolSizeMax());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerThreadKeepAliveSec()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC,
                        visualInboundEndpoint.getInboundWorkerThreadKeepAliveSec());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerPoolQueueLength()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_POOL_QUEUE_LENGTH,
                        visualInboundEndpoint.getInboundWorkerPoolQueueLength());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundThreadGroupId()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_THREAD_GROUOP_ID,
                        visualInboundEndpoint.getInboundThreadGroupId());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundThreadId()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_THREAD_ID,
                        visualInboundEndpoint.getInboundThreadId());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getDispatchFilterPattern()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.DISPATCH_FILTER_PATTERN,
                        visualInboundEndpoint.getDispatchFilterPattern());
            }
            break;
        case FILE:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL,
                        visualInboundEndpoint.getInterval());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.COORDINATION,
                        String.valueOf(visualInboundEndpoint.isCoordination()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_CONTENT_TYPE,
                        visualInboundEndpoint.getTransportVFSContentType());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSLockReleaseSameNode()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_LOCK_RELEASE_SAME_NODE,
                        String.valueOf(visualInboundEndpoint.isTransportVFSLockReleaseSameNode()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSAutoLockReleaseInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE_INTERVAL,
                        visualInboundEndpoint.getTransportVFSAutoLockReleaseInterval());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSAutoLockRelease()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE,
                        String.valueOf(visualInboundEndpoint.isTransportVFSAutoLockRelease()));
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportVFSActionAfterFailure().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_ACTION_AFTER_FAILURE,
                        visualInboundEndpoint.getTransportVFSActionAfterFailure().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMaxRetryCount())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_MAX_RETRY_COUNT,
                        visualInboundEndpoint.getTransportVFSMaxRetryCount());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterFailedMove())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_MOVE_AFTER_FAILED_MOVE,
                        visualInboundEndpoint.getTransportVFSMoveAfterFailedMove());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFailedRecordsFileName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FAILED_RECORDS_FILE_NAME,
                        visualInboundEndpoint.getTransportVFSFailedRecordsFileName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFailedRecordsFileDestination())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FAILED_RECORDS_FILE_DESTINATION,
                        visualInboundEndpoint.getTransportVFSFailedRecordsFileDestination());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveFailedRecordTimestampFormat())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_MOVE_FAILED_RECORD_TIMESTAMP_FORMAT,
                        visualInboundEndpoint.getTransportVFSMoveFailedRecordTimestampFormat());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFailedRecordNextRetryDuration())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FAILED_RECORD_NEXT_RETRY_DURATION,
                        visualInboundEndpoint.getTransportVFSFailedRecordNextRetryDuration());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSReconnectTimeout())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_RECONNECT_TIMEOUT,
                        visualInboundEndpoint.getTransportVFSReconnectTimeout());
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportVFSActionAfterProcess().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_ACTION_AFTER_PROCESS,
                        visualInboundEndpoint.getTransportVFSActionAfterProcess().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileURI())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FILE_URI,
                        visualInboundEndpoint.getTransportVFSFileURI());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterFailure())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_MOVE_AFTER_FAILURE,
                        visualInboundEndpoint.getTransportVFSMoveAfterFailure());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSReplyFileURI())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_REPLY_FILE_URI,
                        visualInboundEndpoint.getTransportVFSReplyFileURI());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSReplyFileName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_REPLY_FILE_NAME,
                        visualInboundEndpoint.getTransportVFSReplyFileName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveTimestampFormat())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_MOVE_TIMESTAMP_FORMAT,
                        visualInboundEndpoint.getTransportVFSMoveTimestampFormat());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSDistributedLock()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_DISTRIBUTED_LOCK,
                        String.valueOf(visualInboundEndpoint.isTransportVFSDistributedLock()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileNamePattern())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FILE_NAME_PATTERN,
                        visualInboundEndpoint.getTransportVFSFileNamePattern());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileProcessInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FILE_PROCESS_INTERVAL,
                        visualInboundEndpoint.getTransportVFSFileProcessInterval());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterProcess())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_MOVE_AFTER_PROCESS,
                        visualInboundEndpoint.getTransportVFSMoveAfterProcess());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getTransportVFSLocking().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_LOCKING,
                        visualInboundEndpoint.getTransportVFSLocking().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSDistributedTimeout())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_DISTRIBUTED_TIMEOUT,
                        visualInboundEndpoint.getTransportVFSDistributedTimeout());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSSFTPIdentities())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_SFTP_IDENTITIES,
                        visualInboundEndpoint.getTransportVFSSFTPIdentities());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSSFTPIdentityPassPhrase())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_SFTP_IDENTITY_PASSPHRASE,
                        visualInboundEndpoint.getTransportVFSSFTPIdentityPassPhrase());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSSFTPUserDirIsRoot()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_SFTP_USER_DIR_IS_ROOT,
                        String.valueOf(visualInboundEndpoint.isTransportVFSSFTPUserDirIsRoot()));
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportVFSFileSortAttribute().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FILESORT_ATTRIBUTE,
                        visualInboundEndpoint.getTransportVFSFileSortAttribute().getLiteral());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSFileSortAscending()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FILESORT_ASCENDING,
                        String.valueOf(visualInboundEndpoint.isTransportVFSFileSortAscending()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSSubFolderTimestampFormat())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_SUBFOLDER_TIMESTAMP_FORMAT,
                        visualInboundEndpoint.getTransportVFSSubFolderTimestampFormat());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSCreateFolder()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_CREATE_FOLDER,
                        String.valueOf(visualInboundEndpoint.isTransportVFSCreateFolder()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileProcessCount())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_FILE_PROCESS_COUNT,
                        visualInboundEndpoint.getTransportVFSFileProcessCount());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSStreaming()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_STREAMING,
                        String.valueOf(visualInboundEndpoint.isTransportVFSStreaming()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportVFSBuild()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.VFS_BUILD,
                        String.valueOf(visualInboundEndpoint.isTransportVFSBuild()));
            }
            break;
        case JMS:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL,
                        visualInboundEndpoint.getInterval());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.COORDINATION,
                        String.valueOf(visualInboundEndpoint.isCoordination()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSMessageSelector())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_MESSAGE_SELECTOR,
                        visualInboundEndpoint.getTransportJMSMessageSelector());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDestination())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DESTINATION,
                        visualInboundEndpoint.getTransportJMSDestination());
            }
            if (StringUtils
                    .isNotBlank(String.valueOf(visualInboundEndpoint.getTransportJMSCacheLevel().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CACHE_LEVEL,
                        visualInboundEndpoint.getTransportJMSCacheLevel().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONNECTION_FACTORY_JNDI_NAME,
                        visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingFactoryInitial())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL,
                        visualInboundEndpoint.getJavaNamingFactoryInitial());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingProviderUrl())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_JAVA_NAMING_PROVIDER_URL,
                        visualInboundEndpoint.getJavaNamingProviderUrl());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSUserName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_USERNAME,
                        visualInboundEndpoint.getTransportJMSUserName());
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportJMSSessionAcknowledgement().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT,
                        visualInboundEndpoint.getTransportJMSSessionAcknowledgement().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPassword())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_PASSWORD,
                        visualInboundEndpoint.getTransportJMSPassword());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportJMSSessionTransacted()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SESSION_TRANSACTED,
                        String.valueOf(visualInboundEndpoint.isTransportJMSSessionTransacted()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSSubscriptionDurable())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SUBSCRIPTION_DURABLE,
                        visualInboundEndpoint.getTransportJMSSubscriptionDurable());
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportJMSConnectionFactoryType().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE,
                        visualInboundEndpoint.getTransportJMSConnectionFactoryType().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSJMSSpecVersion())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_JMS_SPEC_VERSION,
                        visualInboundEndpoint.getTransportJMSJMSSpecVersion());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDurableSubscriberClientID())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
                        visualInboundEndpoint.getTransportJMSDurableSubscriberClientID());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSReceiveTimeout())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_RECIEVE_TIMEOUT,
                        visualInboundEndpoint.getTransportJMSReceiveTimeout());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONTENT_TYPE,
                        visualInboundEndpoint.getTransportJMSContentType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSReplyDestination())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_REPLY_DESTINATION,
                        visualInboundEndpoint.getTransportJMSReplyDestination());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPubSubNoLocal())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_PUB_SUB_NO_LOCAL,
                        visualInboundEndpoint.getTransportJMSPubSubNoLocal());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDurableSubscriberName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_NAME,
                        visualInboundEndpoint.getTransportJMSDurableSubscriberName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSContentTypeProperty())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONTENT_TYPE_PROPERTY,
                        visualInboundEndpoint.getTransportJMSContentTypeProperty());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportJMSSharedSubscription()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SHARED_SUBSCRIPTION,
                        String.valueOf(visualInboundEndpoint.isTransportJMSSharedSubscription()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPinnedServers())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_ENDPOINT_PINNED_SERVERS,
                        visualInboundEndpoint.getTransportJMSPinnedServers());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSConcurrentConsumers())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONCURRENT_CONSUMERS,
                        visualInboundEndpoint.getTransportJMSConcurrentConsumers());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSRetryDuration())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_RETRY_DURATION,
                        visualInboundEndpoint.getTransportJMSRetryDuration());
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.isTransportJMSResetConnectionOnPollingSuspension()))) {
                addParameterForConfig(inboundEndpoint,
                        InboundEndpointConstants.JMS_RESET_CONNECTION_ON_POLLING_SUSPENSION,
                        String.valueOf(visualInboundEndpoint.isTransportJMSResetConnectionOnPollingSuspension()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSRetriesBeforeSuspension())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_RETRIES_BEFORE_SUSPENSION,
                        visualInboundEndpoint.getTransportJMSRetriesBeforeSuspension());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPollingSuspensionPeriod())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_POLLING_SUSPENSION_PERIOD,
                        visualInboundEndpoint.getTransportJMSPollingSuspensionPeriod());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDBUrl())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DB_URL,
                        visualInboundEndpoint.getTransportJMSDBUrl());
            }
            break;
        case WSO2_MB:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL,
                        visualInboundEndpoint.getInterval());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.COORDINATION,
                        String.valueOf(visualInboundEndpoint.isCoordination()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSMessageSelector())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_MESSAGE_SELECTOR,
                        visualInboundEndpoint.getTransportJMSMessageSelector());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDestination())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DESTINATION,
                        visualInboundEndpoint.getTransportJMSDestination());
            }
            if (StringUtils
                    .isNotBlank(String.valueOf(visualInboundEndpoint.getTransportJMSCacheLevel().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CACHE_LEVEL,
                        visualInboundEndpoint.getTransportJMSCacheLevel().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONNECTION_FACTORY_JNDI_NAME,
                        visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingFactoryInitial())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL,
                        visualInboundEndpoint.getJavaNamingFactoryInitial());
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportJMSSessionAcknowledgement().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT,
                        visualInboundEndpoint.getTransportJMSSessionAcknowledgement().getLiteral());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportJMSSessionTransacted()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SESSION_TRANSACTED,
                        String.valueOf(visualInboundEndpoint.isTransportJMSSessionTransacted()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSSubscriptionDurable())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SUBSCRIPTION_DURABLE,
                        visualInboundEndpoint.getTransportJMSSubscriptionDurable());
            }
            if (StringUtils.isNotBlank(
                    String.valueOf(visualInboundEndpoint.getTransportJMSConnectionFactoryType().getLiteral()))) {

                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE,
                        visualInboundEndpoint.getTransportJMSConnectionFactoryType().getLiteral());
                if (visualInboundEndpoint.getTransportJMSConnectionFactoryType().getLiteral().equals(TOPIC)) {
                    // When the type is topic, add the topic connection url
                    addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSO2_MB_TOPIC_CONNECTION_URL,
                            visualInboundEndpoint.getWso2mbConnectionUrl());
                } else if (visualInboundEndpoint.getTransportJMSConnectionFactoryType().getLiteral().equals(QUEUE)) {
                    // When the type is queue, add the queue connection url
                    addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSO2_MB__QUEUE_CONNECTION_URL,
                            visualInboundEndpoint.getWso2mbConnectionUrl());
                }

            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSJMSSpecVersion())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_JMS_SPEC_VERSION,
                        visualInboundEndpoint.getTransportJMSJMSSpecVersion());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDurableSubscriberClientID())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
                        visualInboundEndpoint.getTransportJMSDurableSubscriberClientID());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSReceiveTimeout())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_RECIEVE_TIMEOUT,
                        visualInboundEndpoint.getTransportJMSReceiveTimeout());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONTENT_TYPE,
                        visualInboundEndpoint.getTransportJMSContentType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSReplyDestination())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_REPLY_DESTINATION,
                        visualInboundEndpoint.getTransportJMSReplyDestination());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPubSubNoLocal())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_PUB_SUB_NO_LOCAL,
                        visualInboundEndpoint.getTransportJMSPubSubNoLocal());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDurableSubscriberName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_NAME,
                        visualInboundEndpoint.getTransportJMSDurableSubscriberName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSContentTypeProperty())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONTENT_TYPE_PROPERTY,
                        visualInboundEndpoint.getTransportJMSContentTypeProperty());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportJMSSharedSubscription()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SHARED_SUBSCRIPTION,
                        String.valueOf(visualInboundEndpoint.isTransportJMSSharedSubscription()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPinnedServers())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_ENDPOINT_PINNED_SERVERS,
                        visualInboundEndpoint.getTransportJMSPinnedServers());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSSubscriptionName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_SUBSCRIPTION_NAME,
                        visualInboundEndpoint.getTransportJMSSubscriptionName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSConcurrentConsumers())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_CONCURRENT_CONSUMERS,
                        visualInboundEndpoint.getTransportJMSConcurrentConsumers());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSRetryDuration())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_RETRY_DURATION,
                        visualInboundEndpoint.getTransportJMSRetryDuration());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDBUrl())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.JMS_DB_URL,
                        visualInboundEndpoint.getTransportJMSDBUrl());
            }
            break;
        case CUSTOM:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL,
                        visualInboundEndpoint.getInterval());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getClass_())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CLASS,
                        visualInboundEndpoint.getClass_());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isCoordination()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.COORDINATION,
                        String.valueOf(visualInboundEndpoint.isCoordination()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundEndpointBehaviour()))) {
                String behaviourXMLValue = "";
                String behaviourUIValue = visualInboundEndpoint.getInboundEndpointBehaviour().getLiteral();
                if (behaviourUIValue.equals(InboundEndpointBehaviourType.POLLING_INBOUND_ENDPOINT.getLiteral())) {
                    behaviourXMLValue = POLLING_BEHAVIOUR;
                } else if (behaviourUIValue
                        .equals(InboundEndpointBehaviourType.LISTENING_INBOUND_ENDPOINT.getLiteral())) {
                    behaviourXMLValue = LISTENING_BEHAVIOUR;
                } else if (behaviourUIValue
                        .equals(InboundEndpointBehaviourType.EVENT_BASED_INBOUND_ENDPOINT.getLiteral())) {
                    behaviourXMLValue = EVENT_BASED_BEHAVIOUR;
                }
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_BEHAVIOUR, behaviourXMLValue);
            }
            break;
        case HTTPS:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHttpPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HTTP_PORT,
                        visualInboundEndpoint.getInboundHttpPort());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getKeystore())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.KEYSTORE,
                        visualInboundEndpoint.getKeystore());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerPoolSizeCore()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_CORE,
                        String.valueOf(visualInboundEndpoint.getInboundWorkerPoolSizeCore()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerPoolSizeMax()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_MAX,
                        String.valueOf(visualInboundEndpoint.getInboundWorkerPoolSizeMax()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerThreadKeepAliveSec()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC,
                        String.valueOf(visualInboundEndpoint.getInboundWorkerThreadKeepAliveSec()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundWorkerPoolQueueLength()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WORKER_POOL_QUEUE_LENGTH,
                        String.valueOf(visualInboundEndpoint.getInboundWorkerPoolQueueLength()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundThreadGroupId()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_THREAD_GROUOP_ID,
                        String.valueOf(visualInboundEndpoint.getInboundThreadGroupId()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getInboundThreadId()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_THREAD_ID,
                        String.valueOf(visualInboundEndpoint.getInboundThreadId()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getDispatchFilterPattern()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.DISPATCH_FILTER_PATTERN,
                        String.valueOf(visualInboundEndpoint.getDispatchFilterPattern()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTruststore())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.TRUSTSTORE,
                        visualInboundEndpoint.getTruststore());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getSslVerifyClient())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SSL_VERIFY_CLIENT,
                        visualInboundEndpoint.getSslVerifyClient());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getSslProtocol())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SSL_PROTOCOL,
                        visualInboundEndpoint.getSslProtocol());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getHttpsProtocols())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.HTTPS_PROTOCOLS,
                        visualInboundEndpoint.getHttpsProtocols());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getCertificateRevocationVerifier())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CERTIFICATE_REVOCATION_VERIFIER,
                        visualInboundEndpoint.getCertificateRevocationVerifier());
            }
            break;
        case HL7:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHL7Port())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_PORT,
                        visualInboundEndpoint.getInboundHL7Port());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isInboundHL7AutoAck()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_AUTOACK,
                        String.valueOf(visualInboundEndpoint.isInboundHL7AutoAck()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHL7TimeOut())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_TIMEOUT,
                        visualInboundEndpoint.getInboundHL7TimeOut());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHL7MessagePreProcessor())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_MESSAGE_PRE_PROCESSOR,
                        visualInboundEndpoint.getInboundHL7MessagePreProcessor());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHL7CharSet())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_CHARSET,
                        visualInboundEndpoint.getInboundHL7CharSet());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isInboundHL7ValidateMessage()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_VALIDATE_MESSAGE,
                        String.valueOf(visualInboundEndpoint.isInboundHL7ValidateMessage()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isInboundHL7BuildInvalidMessages()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_HL7_BUILD_INVALID_MESSAGES,
                        String.valueOf(visualInboundEndpoint.isInboundHL7BuildInvalidMessages()));
            }
            if (StringUtils
                    .isNotBlank(String.valueOf(visualInboundEndpoint.isInboundHL7PassThroughInvalidMessages()))) {
                addParameterForConfig(inboundEndpoint,
                        InboundEndpointConstants.INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES,
                        String.valueOf(visualInboundEndpoint.isInboundHL7PassThroughInvalidMessages()));
            }
            break;
        case KAFKA:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL,
                        visualInboundEndpoint.getInterval());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL, "100");
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.COORDINATION,
                        String.valueOf(visualInboundEndpoint.isCoordination()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getZookeeperConnect())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.ZOOKEEPER_CONNECT,
                        visualInboundEndpoint.getZookeeperConnect());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.ZOOKEEPER_CONNECT, "localhost:2181");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getGroupId())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.GROUP_ID,
                        visualInboundEndpoint.getGroupId());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.GROUP_ID, "sample-group");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CONTENT_TYPE,
                        visualInboundEndpoint.getContentType());
            }

            String consumerType = visualInboundEndpoint.getConsumerType().getLiteral();
            if (StringUtils.isNotBlank(consumerType)) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CONSUMER_TYPE, consumerType);
                if (consumerType.equals(InboundEndpointConstants.HIGHLEVEL)) {
                    String topicsOrTopicFilter = visualInboundEndpoint.getTopicsOrTopicFilter().getLiteral();
                    if (StringUtils.isNotBlank(topicsOrTopicFilter)) {
                        if (topicsOrTopicFilter.equals(TopicsType.TOPICS.getLiteral())) { // Topics type selected
                            if (StringUtils.isNotBlank(visualInboundEndpoint.getTopicsName())) {
                                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.TOPICS,
                                        visualInboundEndpoint.getTopicsName());
                            } else {
                                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.TOPICS, "sample-topic");
                            }
                        } else { // Topic filter type selected
                            String topicFilterFromValue = visualInboundEndpoint.getTopicFilterFrom().getLiteral();
                            if (topicFilterFromValue.equals(TopicFilterFromType.FILTER_FROM_WHITELIST.getLiteral())) { // Whitelist
                                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.FILTER_FROM_WHITELIST,
                                        InboundEndpointConstants.TRUE);
                            } else { // Blacklist
                                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.FILTER_FROM_BLACKLIST,
                                        InboundEndpointConstants.TRUE);
                            }

                            // Topic filter name
                            if (StringUtils.isNotBlank(visualInboundEndpoint.getTopicFilterName())) {
                                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.TOPIC_FILTER,
                                        visualInboundEndpoint.getTopicFilterName());
                            } else {
                                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.TOPIC_FILTER,
                                        "sample-topic-filter");
                            }
                        }
                    }
                } else { // Consumer type simple case
                    if (StringUtils.isNotBlank(visualInboundEndpoint.getSimpleConsumerTopic())) {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_TOPIC,
                                visualInboundEndpoint.getSimpleConsumerTopic());
                    } else {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_TOPIC,
                                "sample-consumer-topc");
                    }
                    if (StringUtils.isNotBlank(visualInboundEndpoint.getSimpleConsumerBrokers())) {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_BROKERS,
                                visualInboundEndpoint.getSimpleConsumerBrokers());
                    } else {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_BROKERS, "localhost");
                    }
                    if (StringUtils.isNotBlank(visualInboundEndpoint.getSimpleConsumerPort())) {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_PORT,
                                visualInboundEndpoint.getSimpleConsumerPort());
                    } else {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_PORT, "9092");
                    }
                    if (StringUtils.isNotBlank(visualInboundEndpoint.getSimpleConsumerPartition())) {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_PARTITION,
                                visualInboundEndpoint.getSimpleConsumerPartition());
                    } else {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_PARTITION, "1");
                    }
                    if (StringUtils.isNotBlank(visualInboundEndpoint.getSimpleConsumerMaxMessagesToRead())) {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_MAX_MESSAGES_TO_READ,
                                visualInboundEndpoint.getSimpleConsumerMaxMessagesToRead());
                    } else {
                        addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SIMPLE_MAX_MESSAGES_TO_READ,
                                "5");
                    }
                }
            }

            // Non-mandatory fields
            if (StringUtils.isNotBlank(visualInboundEndpoint.getThreadCount())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.THREAD_COUNT,
                        visualInboundEndpoint.getThreadCount());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getConsumerId())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CONSUMER_ID,
                        visualInboundEndpoint.getConsumerId());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getSocketTimeoutMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SOCKET_TIMEOUT_MS,
                        visualInboundEndpoint.getSocketTimeoutMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getSocketReceiveBufferBytes())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SOCKET_RECEIVE_BUFFER_BYTES,
                        visualInboundEndpoint.getSocketReceiveBufferBytes());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getFetchMessageMaxBytes())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.FETCH_MESSAGE_MAX_BYTES,
                        visualInboundEndpoint.getFetchMessageMaxBytes());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getNumConsumerFetches())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.NUM_CONSUMER_FETCHES,
                        visualInboundEndpoint.getNumConsumerFetches());
            }
            if (visualInboundEndpoint.isAutoCommitEnable()) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.AUTO_COMMIT_ENABLE,
                        InboundEndpointConstants.TRUE);
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.AUTO_COMMIT_ENABLE,
                        InboundEndpointConstants.FALSE);
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getAutoCommitIntervalMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.AUTO_COMMIT_INTERVAL_MS,
                        visualInboundEndpoint.getAutoCommitIntervalMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getQueuedMaxMessageChunks())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.QUEUED_MAX_MESSAGE_CHUNKS,
                        visualInboundEndpoint.getQueuedMaxMessageChunks());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getRebalanceMaxRetries())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.REBALANCE_MAX_RETRIES,
                        visualInboundEndpoint.getRebalanceMaxRetries());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getFetchMinBytes())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.FETCH_MIN_BYTES,
                        visualInboundEndpoint.getFetchMinBytes());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getFetchWaitMaxMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.FETCH_WAIT_MAX_MS,
                        visualInboundEndpoint.getFetchWaitMaxMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getRebalanceBackoffMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.REBALANCE_BACKOFF_MS,
                        visualInboundEndpoint.getRebalanceBackoffMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getRefreshLeaderBackoffMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.REFRESH_LEADER_BACKOFF_MS,
                        visualInboundEndpoint.getRefreshLeaderBackoffMs());
            }
            addParameterForConfig(inboundEndpoint, InboundEndpointConstants.AUTO_OFFSET_RESET,
                    visualInboundEndpoint.getAutoOffsetReset().getLiteral());
            if (StringUtils.isNotBlank(visualInboundEndpoint.getConsumerTimeoutMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CONSUMER_TIMEOUT_MS,
                        visualInboundEndpoint.getConsumerTimeoutMs());
            }
            if (visualInboundEndpoint.isExcludeInternalTopics()) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.EXCLUDE_INTERNAL_TOPICS,
                        InboundEndpointConstants.TRUE);
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.EXCLUDE_INTERNAL_TOPICS,
                        InboundEndpointConstants.FALSE);
            }
            addParameterForConfig(inboundEndpoint, InboundEndpointConstants.PARTITION_ASSIGNMENT_STRATEGY,
                    visualInboundEndpoint.getPartitionAssignmentStrategy().getLiteral());
            if (StringUtils.isNotBlank(visualInboundEndpoint.getClientId())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.CLIENT_ID,
                        visualInboundEndpoint.getClientId());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getZookeeperSessionTimeoutMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.ZOOKEEPER_SESSION_TIMEOUT_MS,
                        visualInboundEndpoint.getZookeeperSessionTimeoutMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getZookeeperConnectionTimeoutMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.ZOOKEEPER_CONNECTION_TIMEOUT_MS,
                        visualInboundEndpoint.getZookeeperConnectionTimeoutMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getZookeeperSyncTimeMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.ZOOKEEPER_SYNC_TIME_MS,
                        visualInboundEndpoint.getZookeeperSyncTimeMs());
            }
            addParameterForConfig(inboundEndpoint, InboundEndpointConstants.OFFSETS_STORAGE,
                    visualInboundEndpoint.getOffsetsStorage().getLiteral());
            if (StringUtils.isNotBlank(visualInboundEndpoint.getOffsetsChannelBackoffMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.OFFSETS_CHANNEL_BACKOFF_MS,
                        visualInboundEndpoint.getOffsetsChannelBackoffMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getOffsetsChannelSocketTimeoutMs())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS,
                        visualInboundEndpoint.getOffsetsChannelSocketTimeoutMs());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getOffsetsCommitMaxRetries())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.OFFSETS_COMMIT_MAX_RETRIES,
                        visualInboundEndpoint.getOffsetsCommitMaxRetries());
            }
            if (visualInboundEndpoint.isDualCommitEnabled()) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.DUAL_COMMIT_ENABLED,
                        InboundEndpointConstants.TRUE);
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.DUAL_COMMIT_ENABLED,
                        InboundEndpointConstants.FALSE);
            }
            break;
        case CXF_WS_RM:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundCxfRmHost())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_CXF_RM_HOST,
                        visualInboundEndpoint.getInboundCxfRmHost());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundCxfRmPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_CXF_RM_PORT,
                        visualInboundEndpoint.getInboundCxfRmPort());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundCxfRmConfigFile())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_CXF_RM_CONFIG_FILE,
                        visualInboundEndpoint.getInboundCxfRmConfigFile());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isEnableSSL()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.ENABLE_SSL,
                        String.valueOf(visualInboundEndpoint.isEnableSSL()));
            }
            break;
        case MQTT:
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTConnectionFactory())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_CONNECTION_FACTORY,
                        visualInboundEndpoint.getTransportMQTTConnectionFactory());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTServerHostName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SERVER_HOST_NAME,
                        visualInboundEndpoint.getTransportMQTTServerHostName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTServerPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SERVER_PORT,
                        visualInboundEndpoint.getTransportMQTTServerPort());
            }

            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTTopicName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_TOPIC_NAME,
                        visualInboundEndpoint.getTransportMQTTTopicName());
            }

            if (StringUtils.isNotBlank(visualInboundEndpoint.getContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_CONTENT_TYPE,
                        visualInboundEndpoint.getContentType());
            }

            if (StringUtils
                    .isNotBlank(String.valueOf(visualInboundEndpoint.getTransportMQTTSubscriptionQOS().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_QOS,
                        visualInboundEndpoint.getTransportMQTTSubscriptionQOS().getLiteral());
            }

            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isTransportMQTTSessionClean()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SESSION_CLEAN,
                        String.valueOf(visualInboundEndpoint.isTransportMQTTSessionClean()));
            }

            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslEnable())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_ENABLE,
                        visualInboundEndpoint.getTransportMQTTSslEnable());
            }

            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTTemporaryStoreDirectory())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_TEMPORARY_STORE_DIRECTORY,
                        visualInboundEndpoint.getTransportMQTTTemporaryStoreDirectory());
            }

            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSubscriptionUsername())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_USERNAME,
                        visualInboundEndpoint.getTransportMQTTSubscriptionUsername());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSubscriptionPassword())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_PASSWORD,
                        visualInboundEndpoint.getTransportMQTTSubscriptionPassword());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTClientId())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_CLIENT_ID,
                        visualInboundEndpoint.getTransportMQTTClientId());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_RECONNECTION_INTERVAL,
                        visualInboundEndpoint.getInterval());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslKeystoreLocation())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_LOCATION,
                        visualInboundEndpoint.getTransportMQTTSslKeystoreLocation());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslKeystoreType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_TYPE,
                        visualInboundEndpoint.getTransportMQTTSslKeystoreType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslKeystorePassword())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_PASSWORD,
                        visualInboundEndpoint.getTransportMQTTSslKeystorePassword());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslTruststoreLocation())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_LOCATION,
                        visualInboundEndpoint.getTransportMQTTSslTruststoreLocation());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslTruststoreType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_TYPE,
                        visualInboundEndpoint.getTransportMQTTSslTruststoreType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslTruststorePassword())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_PASSWORD,
                        visualInboundEndpoint.getTransportMQTTSslTruststorePassword());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportMQTTSslVersion())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_MQTT_SSL_VERSION,
                        visualInboundEndpoint.getTransportMQTTSslVersion());
            }

            break;
        case RABBITMQ:
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.SEQUENTIAL,
                        String.valueOf(visualInboundEndpoint.isSequential()));
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.COORDINATION,
                        String.valueOf(visualInboundEndpoint.isCoordination()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionFactory())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_FACTORY,
                        visualInboundEndpoint.getTransportRabbitMqConnectionFactory());
            } 
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqServerHostName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_HOST_NAME,
                        visualInboundEndpoint.getTransportRabbitMqServerHostName());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_HOST_NAME, "localhost");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqServerPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_PORT,
                        visualInboundEndpoint.getTransportRabbitMqServerPort());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_PORT, "5672");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqServerUserName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_USER_NAME,
                        visualInboundEndpoint.getTransportRabbitMqServerUserName());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_USER_NAME, "guest");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqServerPassword())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_PASSWORD,
                        visualInboundEndpoint.getTransportRabbitMqServerPassword());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_PASSWORD, "guest");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_NAME,
                        visualInboundEndpoint.getTransportRabbitMqQueueName());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_NAME, "queue");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqExchangeName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_EXCHANGE_NAME,
                        visualInboundEndpoint.getTransportRabbitMqExchangeName());
            } else {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_EXCHANGE_NAME, "exchange");
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueDurable())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_DURABLE,
                        visualInboundEndpoint.getTransportRabbitMqQueueDurable());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueExclusive())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_EXCLUSIVE,
                        visualInboundEndpoint.getTransportRabbitMqQueueExclusive());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueAutoDelete())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_DELETE,
                        visualInboundEndpoint.getTransportRabbitMqQueueAutoDelete());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueAutoAck())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_ACK,
                        visualInboundEndpoint.getTransportRabbitMqQueueAutoAck());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueRoutingKey())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_ROUTING_KEY,
                        visualInboundEndpoint.getTransportRabbitMqQueueRoutingKey());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqQueueDeliveryMode())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_DELIVERY_MODE,
                        visualInboundEndpoint.getTransportRabbitMqQueueDeliveryMode());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqExchangeType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_EXCHANGE_TYPE,
                        visualInboundEndpoint.getTransportRabbitMqExchangeType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqExchangeDurable())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_EXCHANGE_DURABLE,
                        visualInboundEndpoint.getTransportRabbitMqExchangeDurable());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqExchangeAutoDelete())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_EXCHANGE_AUTO_DELETE,
                        visualInboundEndpoint.getTransportRabbitMqExchangeAutoDelete());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqServerVirtualHost())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_VIRTUAL_HOST,
                        visualInboundEndpoint.getTransportRabbitMqServerVirtualHost());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqFactoryHeartbeat())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_FACTORY_HEARTBEAT,
                        visualInboundEndpoint.getTransportRabbitMqFactoryHeartbeat());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslEnabled())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_ENABLED,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslEnabled());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslKeystoreLocation())) {
                addParameterForConfig(inboundEndpoint,
                        InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_LOCATION,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslKeystoreLocation());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslKeystoreType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_TYPE,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslKeystoreType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslKeystorePassword())) {
                addParameterForConfig(inboundEndpoint,
                        InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_PASSWORD,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslKeystorePassword());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslTruststoreLocation())) {
                addParameterForConfig(inboundEndpoint,
                        InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_LOCATION,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslTruststoreLocation());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslTruststoreType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_TYPE,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslTruststoreType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslTruststorePassword())) {
                addParameterForConfig(inboundEndpoint,
                        InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslTruststorePassword());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionSslVersion())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_VERSION,
                        visualInboundEndpoint.getTransportRabbitMqConnectionSslVersion());
            }

            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqMessageContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_MESSAGE_CONTENT_TYPE,
                        visualInboundEndpoint.getTransportRabbitMqMessageContentType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionRetryCount())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_RETRY_COUNT,
                        visualInboundEndpoint.getTransportRabbitMqConnectionRetryCount());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConnectionRetryInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_RETRY_INTERVAL,
                        visualInboundEndpoint.getTransportRabbitMqConnectionRetryInterval());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqServerRetryInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_SERVER_RETRY_INTERVAL,
                        visualInboundEndpoint.getTransportRabbitMqServerRetryInterval());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConsumerQos())
                    && visualInboundEndpoint.getTransportRabbitMqConsumerQosType().toString() == "Inline") {
                inboundEndpoint.addParameter(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS,
                        visualInboundEndpoint.getTransportRabbitMqConsumerQos());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConsumerQosKey().getKeyValue())
                    && visualInboundEndpoint.getTransportRabbitMqConsumerQosType().toString() == "Registry Reference") {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONSUMER_QOS,
                        visualInboundEndpoint.getTransportRabbitMqConsumerQosKey().getKeyValue());
            }
            if (!visualInboundEndpoint.isTransportRabbitMqAutoDeclare()) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_QUEUE_AUTODECLARE,
                        InboundEndpointConstants.FALSE);
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqMaxDeadLetteredCount())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_MESSAGE_MAX_DEAD_LETTERED_COUNT,
                        visualInboundEndpoint.getTransportRabbitMqMaxDeadLetteredCount());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqRequeueDelay())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_MESSAGE_REQUEUE_DELAY,
                        visualInboundEndpoint.getTransportRabbitMqRequeueDelay());
            }
            if (!visualInboundEndpoint.isTransportRabbitMqExchangeAutoDeclare()) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_EXCHANGE_AUTODECLARE,
                        InboundEndpointConstants.FALSE);
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqConsumerTag())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONSUMER_TAG,
                        visualInboundEndpoint.getTransportRabbitMqConsumerTag());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqErrorQueueRoutingKey())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_MESSAGE_ERROR_QUEUE_ROUTING_KEY,
                        visualInboundEndpoint.getTransportRabbitMqErrorQueueRoutingKey());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqErrorExchangeName())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_MESSAGE_ERROR_EXCHANGE_NAME,
                        visualInboundEndpoint.getTransportRabbitMqErrorExchangeName());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqFactoryConnectionTimeout())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_FACTORY_CONENCTION_TIMEOUT,
                        visualInboundEndpoint.getTransportRabbitMqFactoryConnectionTimeout());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportRabbitMqFactoryNetworkRecoveryInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.RABBITMQ_CONNECTION_FACTORY_NETWORK_RECOVERY_INTERVAL,
                        visualInboundEndpoint.getTransportRabbitMqFactoryNetworkRecoveryInterval());
            }
            break;
        case FEED:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INTERVAL,
                        visualInboundEndpoint.getInterval());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportFeedURL())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_FEED_URL,
                        visualInboundEndpoint.getTransportFeedURL());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.getTransportFeedType().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_FEED_TYPE,
                        visualInboundEndpoint.getTransportFeedType().getLiteral());
            }
            break;
        case WS:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsInboundPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WS_PORT,
                        visualInboundEndpoint.getWsInboundPort());
            }
            if (StringUtils
                    .isNotBlank(String.valueOf(visualInboundEndpoint.getWsClientSideBroadcastLevel().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_CLIENT_SIDE_BROADCAST_LEVEL,
                        visualInboundEndpoint.getWsClientSideBroadcastLevel().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsOutflowDispatchSequence())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_OUTFLOW_DISPATCH_SEQUENCE,
                        visualInboundEndpoint.getWsOutflowDispatchSequence());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsOutflowDispatchFaultSequence())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_OUTFLOW_DISPATCH_FAULT_SEQUENCE,
                        visualInboundEndpoint.getWsOutflowDispatchFaultSequence());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsBossThreadPoolSize())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_BOSS_THREAD_POOL_SIZE,
                        visualInboundEndpoint.getWsBossThreadPoolSize());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsWorkerThreadPoolSize())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_WORKER_THREAD_POOL_SIZE,
                        visualInboundEndpoint.getWsWorkerThreadPoolSize());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsSubprotocolHandlerClass())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_SUBPROTOCOL_HANDLER_CLASS,
                        visualInboundEndpoint.getWsSubprotocolHandlerClass());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsDefaultContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_DEFAULT_CONTENT_TYPE,
                        visualInboundEndpoint.getWsDefaultContentType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsShutdownStatusCode())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_SHUTDWN_STATUS_CODE,
                        visualInboundEndpoint.getWsShutdownStatusCode());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsShutdownStatusMessage())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_SHUTDOWN_STATUS_MESSAGE,
                        visualInboundEndpoint.getWsShutdownStatusMessage());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsPipelineHandlerClass())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_PIPELINE_HANDLER_CLASS,
                        visualInboundEndpoint.getWsPipelineHandlerClass());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isWsUsePortOffset()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_USE_PORT_OFFSET,
                        String.valueOf(visualInboundEndpoint.isWsUsePortOffset()));
            }
            break;
        case WSS:
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsInboundPort())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.INBOUND_WS_PORT,
                        visualInboundEndpoint.getWsInboundPort());
            }
            if (StringUtils
                    .isNotBlank(String.valueOf(visualInboundEndpoint.getWsClientSideBroadcastLevel().getLiteral()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_CLIENT_SIDE_BROADCAST_LEVEL,
                        visualInboundEndpoint.getWsClientSideBroadcastLevel().getLiteral());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsOutflowDispatchSequence())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_OUTFLOW_DISPATCH_SEQUENCE,
                        visualInboundEndpoint.getWsOutflowDispatchSequence());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsOutflowDispatchFaultSequence())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_OUTFLOW_DISPATCH_FAULT_SEQUENCE,
                        visualInboundEndpoint.getWsOutflowDispatchFaultSequence());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslKeyStoreFile())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_KEY_STORE_FILE,
                        visualInboundEndpoint.getWssSslKeyStoreFile());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslKeyStorePass())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_KEY_STORE_PASS,
                        visualInboundEndpoint.getWssSslKeyStorePass());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslTrustStoreFile())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_TRUST_STORE_FILE,
                        visualInboundEndpoint.getWssSslTrustStoreFile());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslTrustStorePass())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_TRUST_STORE_PASS,
                        visualInboundEndpoint.getWssSslTrustStorePass());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslCertPass())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_CERT_PASS,
                        visualInboundEndpoint.getWssSslCertPass());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsBossThreadPoolSize())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_BOSS_THREAD_POOL_SIZE,
                        visualInboundEndpoint.getWsBossThreadPoolSize());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsWorkerThreadPoolSize())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_WORKER_THREAD_POOL_SIZE,
                        visualInboundEndpoint.getWsWorkerThreadPoolSize());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsSubprotocolHandlerClass())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_SUBPROTOCOL_HANDLER_CLASS,
                        visualInboundEndpoint.getWsSubprotocolHandlerClass());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsDefaultContentType())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_DEFAULT_CONTENT_TYPE,
                        visualInboundEndpoint.getWsDefaultContentType());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsShutdownStatusCode())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_SHUTDWN_STATUS_CODE,
                        visualInboundEndpoint.getWsShutdownStatusCode());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWsShutdownStatusMessage())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_SHUTDOWN_STATUS_MESSAGE,
                        visualInboundEndpoint.getWsShutdownStatusMessage());
            }
            if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isWsUsePortOffset()))) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WS_USE_PORT_OFFSET,
                        String.valueOf(visualInboundEndpoint.isWsUsePortOffset()));
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslProtocols())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_PROTOCOLS,
                        visualInboundEndpoint.getWssSslProtocols());
            }
            if (StringUtils.isNotBlank(visualInboundEndpoint.getWssSslCipherSuites())) {
                addParameterForConfig(inboundEndpoint, InboundEndpointConstants.WSS_SSL_CIPHER_SUITES,
                        visualInboundEndpoint.getWssSslCipherSuites());
            }
        default:
            break;
        }
        return inboundEndpoint;
    }

    private void addParameterForConfig(InboundEndpoint inboundEndpoint, String parameterName,
            String parameterKeyValue) {
        if (parameterKeyValue.startsWith(REGISTRY_PREFIX)) {
            parameterKeyValue = parameterKeyValue.replace(REGISTRY_PREFIX, "");
            inboundEndpoint.addParameter(parameterName, "", parameterKeyValue);
        } else if (parameterName.startsWith(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS)) {
            inboundEndpoint.addParameter(parameterName, "", parameterKeyValue);
        } else {
            inboundEndpoint.addParameter(parameterName, parameterKeyValue);
        }
    }

}
