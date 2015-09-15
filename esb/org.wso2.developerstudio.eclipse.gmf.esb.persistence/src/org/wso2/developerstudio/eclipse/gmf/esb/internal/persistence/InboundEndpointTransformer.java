/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicsType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class InboundEndpointTransformer extends AbstractEsbNodeTransformer {

	private static final String CUSTOM = "custom";

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		Assert.isTrue(
				subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint,
				"Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) subject;

		information.getSynapseConfiguration().addInboundEndpoint(
				visualInboundEndpoint.getName(), create(visualInboundEndpoint));
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) throws TransformerException {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence)
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
	 * org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint
	 * 
	 * @param visualInboundEndpoint
	 * @return
	 * @throws TransformerException
	 * @throws Exception
	 */
	private InboundEndpoint create(
			org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint)
			throws TransformerException {
		InboundEndpoint inboundEndpoint = new InboundEndpoint();
		inboundEndpoint.setName(visualInboundEndpoint.getName());

		// TODO: This validation should be done properly for specific inbound
		// endpoint types
		// TOOLS-3039
		Sequence sequence = getSequence(visualInboundEndpoint
				.getSequenceOutputConnector());
		Sequence onErrorSequence = getSequence(visualInboundEndpoint
				.getOnErrorSequenceOutputConnector());

		/*
		 * if (sequence == null && onErrorSequence == null) { throw new
		 * TransformerException(
		 * "Sequence and On Error Sequence cannot be empty. Please include a Sequence and an On Error Sequence"
		 * ); }
		 */

		if (sequence != null) {
			inboundEndpoint.setInjectingSeq(sequence.getName());
		}
		/*
		 * else { throw new TransformerException(
		 * "Sequence cannot be empty. Please include a Sequence"); }
		 */

		if (onErrorSequence != null) {
			inboundEndpoint.setOnErrorSeq(onErrorSequence.getName());
		}
		/*
		 * else { throw new TransformerException(
		 * "On Error Sequence cannot be empty. Please include an On Error Sequence"
		 * ); }
		 */

		if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
				.isSuspend()))) {
			inboundEndpoint.setSuspend(visualInboundEndpoint.isSuspend());
		}

		if (visualInboundEndpoint.getType().getName().equals(CUSTOM)) {
			if (StringUtils.isNotBlank(visualInboundEndpoint.getClass_())) {
				inboundEndpoint.setClassImpl(visualInboundEndpoint.getClass_());
			} else {
				throw new TransformerException(
						"Class cannot be empty. Please specify a Class");
			}

			// Service Parameters.
			for (int i = 0; i < visualInboundEndpoint.getServiceParameters()
					.size(); ++i) {
				String value = visualInboundEndpoint.getServiceParameters()
						.get(i).getValue();
				if (StringUtils.isNotBlank(value)) {
					inboundEndpoint.addParameter(visualInboundEndpoint
							.getServiceParameters().get(i).getName(), value);
				}
			}
		} else if (StringUtils.isNotBlank(visualInboundEndpoint.getType()
				.getName())) {
			inboundEndpoint.setProtocol(visualInboundEndpoint.getType()
					.getName());
		}

		switch (visualInboundEndpoint.getType()) {
		case HTTP:
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundHttpPort())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HTTP_PORT,
						visualInboundEndpoint.getInboundHttpPort());
			} else {
				throw new IllegalArgumentException("HTTP Inbound Endpoint Error : Inbound HTTP Port is Required");
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerPoolSizeCore()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_CORE,
						String.valueOf(visualInboundEndpoint
								.getInboundWorkerPoolSizeCore()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerPoolSizeMax()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_MAX,
						String.valueOf(visualInboundEndpoint
								.getInboundWorkerPoolSizeMax()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerThreadKeepAliveSec()))) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC,
								String.valueOf(visualInboundEndpoint
										.getInboundWorkerThreadKeepAliveSec()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerPoolQueueLength()))) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_WORKER_POOL_QUEUE_LENGTH,
								String.valueOf(visualInboundEndpoint
										.getInboundWorkerPoolQueueLength()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundThreadGroupId()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_THREAD_GROUOP_ID,
						String.valueOf(visualInboundEndpoint
								.getInboundThreadGroupId()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundThreadId()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_THREAD_ID, String
								.valueOf(visualInboundEndpoint
										.getInboundThreadId()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getDispatchFilterPattern()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.DISPATCH_FILTER_PATTERN,
						String.valueOf(visualInboundEndpoint
								.getDispatchFilterPattern()));
			}
			break;
		case FILE:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL,
						visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSContentType())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_CONTENT_TYPE,
						visualInboundEndpoint.getTransportVFSContentType());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSLockReleaseSameNode()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_LOCK_RELEASE_SAME_NODE,
						String.valueOf(visualInboundEndpoint
								.isTransportVFSLockReleaseSameNode()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSAutoLockReleaseInterval())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE_INTERVAL,
								visualInboundEndpoint
										.getTransportVFSAutoLockReleaseInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSAutoLockRelease()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE, String
								.valueOf(visualInboundEndpoint
										.isTransportVFSAutoLockRelease()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportVFSActionAfterFailure().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_ACTION_AFTER_FAILURE,
						visualInboundEndpoint
								.getTransportVFSActionAfterFailure()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSMaxRetryCount())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_MAX_RETRY_COUNT,
						visualInboundEndpoint.getTransportVFSMaxRetryCount());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSReconnectTimeout())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.VFS_RECONNECT_TIMEOUT,
								visualInboundEndpoint
										.getTransportVFSReconnectTimeout());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportVFSActionAfterProcess().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_ACTION_AFTER_PROCESS,
						visualInboundEndpoint
								.getTransportVFSActionAfterProcess()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSFileURI())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_FILE_URI,
						visualInboundEndpoint.getTransportVFSFileURI());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSMoveAfterFailure())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.VFS_MOVE_AFTER_FAILURE,
								visualInboundEndpoint
										.getTransportVFSMoveAfterFailure());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSMoveTimestampFormat())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_MOVE_TIMESTAMP_FORMAT,
						visualInboundEndpoint
								.getTransportVFSMoveTimestampFormat());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSDistributedLock()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_DISTRIBUTED_LOCK, String
								.valueOf(visualInboundEndpoint
										.isTransportVFSDistributedLock()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSFileNamePattern())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_FILE_NAME_PATTERN,
						visualInboundEndpoint.getTransportVFSFileNamePattern());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSFileProcessInterval())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_FILE_PROCESS_INTERVAL,
						visualInboundEndpoint
								.getTransportVFSFileProcessInterval());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSMoveAfterProcess())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.VFS_MOVE_AFTER_PROCESS,
								visualInboundEndpoint
										.getTransportVFSMoveAfterProcess());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportVFSLocking().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_LOCKING,
						visualInboundEndpoint.getTransportVFSLocking()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSDistributedTimeout())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_DISTRIBUTED_TIMEOUT,
						String.valueOf(visualInboundEndpoint
								.getTransportVFSDistributedTimeout()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportVFSFileSortAttribute().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_FILESORT_ATTRIBUTE,
						visualInboundEndpoint
								.getTransportVFSFileSortAttribute()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSFileSortAscending()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_FILESORT_ASCENDING, String
								.valueOf(visualInboundEndpoint
										.isTransportVFSFileSortAscending()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSSubFolderTimestampFormat())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.VFS_SUBFOLDER_TIMESTAMP_FORMAT,
								visualInboundEndpoint
										.getTransportVFSSubFolderTimestampFormat());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSCreateFolder()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_CREATE_FOLDER, String
								.valueOf(visualInboundEndpoint
										.isTransportVFSCreateFolder()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportVFSFileProcessCount())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.VFS_FILE_PROCESS_COUNT,
								visualInboundEndpoint
										.getTransportVFSFileProcessCount());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSStreaming()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_STREAMING, String
								.valueOf(visualInboundEndpoint
										.isTransportVFSStreaming()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportVFSBuild()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.VFS_BUILD, String
								.valueOf(visualInboundEndpoint
										.isTransportVFSBuild()));
			}
			break;
		case JMS:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL,
						visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSMessageSelector())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_MESSAGE_SELECTOR,
						visualInboundEndpoint.getTransportJMSMessageSelector());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSDestination())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_DESTINATION,
						visualInboundEndpoint.getTransportJMSDestination());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportJMSCacheLevel().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_CACHE_LEVEL,
						visualInboundEndpoint.getTransportJMSCacheLevel()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSConnectionFactoryJNDIName())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.JMS_CONNECTION_FACTORY_JNDI_NAME,
								visualInboundEndpoint
										.getTransportJMSConnectionFactoryJNDIName());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getJavaNamingFactoryInitial())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL,
								visualInboundEndpoint
										.getJavaNamingFactoryInitial());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getJavaNamingProviderUrl())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_JAVA_NAMING_PROVIDER_URL,
						visualInboundEndpoint.getJavaNamingProviderUrl());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSUserName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_USERNAME,
						visualInboundEndpoint.getTransportJMSUserName());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportJMSSessionAcknowledgement().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT,
						visualInboundEndpoint
								.getTransportJMSSessionAcknowledgement()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSPassword())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_PASSWORD,
						visualInboundEndpoint.getTransportJMSPassword());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportJMSSessionTransacted()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_SESSION_TRANSACTED, String
								.valueOf(visualInboundEndpoint
										.isTransportJMSSessionTransacted()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSSubscriptionDurable())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_SUBSCRIPTION_DURABLE,
						visualInboundEndpoint
								.getTransportJMSSubscriptionDurable());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportJMSConnectionFactoryType().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE,
						visualInboundEndpoint
								.getTransportJMSConnectionFactoryType()
								.getLiteral());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSJMSSpecVersion())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_JMS_SPEC_VERSION,
						visualInboundEndpoint.getTransportJMSJMSSpecVersion());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSDurableSubscriberClientID())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
								visualInboundEndpoint
										.getTransportJMSDurableSubscriberClientID());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSReceiveTimeout())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_RECIEVE_TIMEOUT,
						visualInboundEndpoint.getTransportJMSReceiveTimeout());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSContentType())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_CONTENT_TYPE,
						visualInboundEndpoint.getTransportJMSContentType());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSReplyDestination())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.JMS_REPLY_DESTINATION,
								visualInboundEndpoint
										.getTransportJMSReplyDestination());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSPubSubNoLocal())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_PUB_SUB_NO_LOCAL,
						visualInboundEndpoint.getTransportJMSPubSubNoLocal());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSDurableSubscriberName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_NAME,
						visualInboundEndpoint
								.getTransportJMSDurableSubscriberName());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportJMSContentTypeProperty())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.JMS_CONTENT_TYPE_PROPERTY,
						visualInboundEndpoint
								.getTransportJMSContentTypeProperty());
			}
			break;
		case CUSTOM:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL,
						visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundEndpointBehaviour()))) {
				String behaviourValue = visualInboundEndpoint
						.getInboundEndpointBehaviour()
						.getLiteral()
						.equals(InboundEndpointBehaviourType.POLLING_INBOUND_ENDPOINT
								.getLiteral()) ? "polling" : "listening";
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_BEHAVIOUR,
						behaviourValue);
			}
			break;
		case HTTPS:
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundHttpPort())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HTTP_PORT,
						visualInboundEndpoint.getInboundHttpPort());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getKeystore())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.KEYSTORE,
						visualInboundEndpoint.getKeystore());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerPoolSizeCore()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_CORE,
						String.valueOf(visualInboundEndpoint
								.getInboundWorkerPoolSizeCore()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerPoolSizeMax()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_MAX,
						String.valueOf(visualInboundEndpoint
								.getInboundWorkerPoolSizeMax()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerThreadKeepAliveSec()))) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC,
								String.valueOf(visualInboundEndpoint
										.getInboundWorkerThreadKeepAliveSec()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundWorkerPoolQueueLength()))) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_WORKER_POOL_QUEUE_LENGTH,
								String.valueOf(visualInboundEndpoint
										.getInboundWorkerPoolQueueLength()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundThreadGroupId()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_THREAD_GROUOP_ID,
						String.valueOf(visualInboundEndpoint
								.getInboundThreadGroupId()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getInboundThreadId()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_THREAD_ID, String
								.valueOf(visualInboundEndpoint
										.getInboundThreadId()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getDispatchFilterPattern()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.DISPATCH_FILTER_PATTERN,
						String.valueOf(visualInboundEndpoint
								.getDispatchFilterPattern()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTruststore())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.TRUSTSTORE,
						visualInboundEndpoint.getTruststore());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getSslVerifyClient())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SSL_VERIFY_CLIENT,
						visualInboundEndpoint.getSslVerifyClient());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getSslProtocol())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SSL_PROTOCOL,
						visualInboundEndpoint.getSslProtocol());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getHttpsProtocols())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.HTTPS_PROTOCOLS,
						visualInboundEndpoint.getHttpsProtocols());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getCertificateRevocationVerifier())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.CERTIFICATE_REVOCATION_VERIFIER,
								visualInboundEndpoint
										.getCertificateRevocationVerifier());
			}
			break;
		case HL7:
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundHL7Port())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HL7_PORT,
						visualInboundEndpoint.getInboundHL7Port());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isInboundHL7AutoAck()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HL7_AUTOACK, String
								.valueOf(visualInboundEndpoint
										.isInboundHL7AutoAck()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundHL7TimeOut())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HL7_TIMEOUT,
						visualInboundEndpoint.getInboundHL7TimeOut());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundHL7MessagePreProcessor())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_HL7_MESSAGE_PRE_PROCESSOR,
								visualInboundEndpoint
										.getInboundHL7MessagePreProcessor());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundHL7CharSet())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HL7_CHARSET,
						visualInboundEndpoint.getInboundHL7CharSet());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isInboundHL7ValidateMessage()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_HL7_VALIDATE_MESSAGE,
						String.valueOf(visualInboundEndpoint
								.isInboundHL7ValidateMessage()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isInboundHL7BuildInvalidMessages()))) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_HL7_BUILD_INVALID_MESSAGES,
								String.valueOf(visualInboundEndpoint
										.isInboundHL7BuildInvalidMessages()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isInboundHL7PassThroughInvalidMessages()))) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES,
								String.valueOf(visualInboundEndpoint
										.isInboundHL7PassThroughInvalidMessages()));
			}
			break;
		case KAFKA:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL,
						visualInboundEndpoint.getInterval());
			} else {
				throw new TransformerException("Interval cannot be empty");
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getZookeeperConnect())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.ZOOKEEPER_CONNECT,
						visualInboundEndpoint.getZookeeperConnect());
			} else {
				throw new TransformerException(
						"Zookeeper connect cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getGroupId())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.GROUP_ID,
						visualInboundEndpoint.getGroupId());
			} else {
				throw new TransformerException("Group ID cannot be empty");
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getContentType().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.CONTENT_TYPE,
						visualInboundEndpoint.getContentType().getLiteral());
			}

			String consumerType = visualInboundEndpoint.getConsumerType()
					.getLiteral();
			if (StringUtils.isNotBlank(consumerType)) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.CONSUMER_TYPE, consumerType);
				if (consumerType.equals(InboundEndpointConstants.HIGHLEVEL)) { // Consumer
																				// type
																				// highlevel
																				// case
					String topicsOrTopicFilter = visualInboundEndpoint
							.getTopicsOrTopicFilter().getLiteral();
					if (StringUtils.isNotBlank(topicsOrTopicFilter)) {
						if (topicsOrTopicFilter.equals(TopicsType.TOPICS
								.getLiteral())) { // Topics type selected
							if (StringUtils.isNotBlank(visualInboundEndpoint
									.getTopicsName())) {
								inboundEndpoint.addParameter(
										InboundEndpointConstants.TOPICS,
										visualInboundEndpoint.getTopicsName());
							} else {
								throw new TransformerException(
										"Topics name cannot be empty");
							}
						} else { // Topic filter type selected
							String topicFilterFromValue = visualInboundEndpoint
									.getTopicFilterFrom().getLiteral();
							if (topicFilterFromValue
									.equals(TopicFilterFromType.FILTER_FROM_WHITELIST
											.getLiteral())) { // Whitelist
								inboundEndpoint
										.addParameter(
												InboundEndpointConstants.FILTER_FROM_WHITELIST,
												InboundEndpointConstants.TRUE);
							} else { // Blacklist
								inboundEndpoint
										.addParameter(
												InboundEndpointConstants.FILTER_FROM_BLACKLIST,
												InboundEndpointConstants.TRUE);
							}

							// Topic filter name
							if (StringUtils.isNotBlank(visualInboundEndpoint
									.getTopicFilterName())) {
								inboundEndpoint.addParameter(
										InboundEndpointConstants.TOPIC_FILTER,
										visualInboundEndpoint
												.getTopicFilterName());
							} else {
								throw new TransformerException(
										"Topic filter name cannot be empty");
							}
						}
					}
				} else { // Consumer type simple case
					if (StringUtils.isNotBlank(visualInboundEndpoint
							.getSimpleConsumerTopic())) {
						inboundEndpoint.addParameter(
								InboundEndpointConstants.SIMPLE_TOPIC,
								visualInboundEndpoint.getSimpleConsumerTopic());
					} else {
						throw new TransformerException(
								"Simple consumer topic cannot be empty");
					}
					if (StringUtils.isNotBlank(visualInboundEndpoint
							.getSimpleConsumerBrokers())) {
						inboundEndpoint.addParameter(
								InboundEndpointConstants.SIMPLE_BROKERS,
								visualInboundEndpoint
										.getSimpleConsumerBrokers());
					} else {
						throw new TransformerException(
								"Simple consumer brokers cannot be empty");
					}
					if (StringUtils.isNotBlank(visualInboundEndpoint
							.getSimpleConsumerPort())) {
						inboundEndpoint.addParameter(
								InboundEndpointConstants.SIMPLE_PORT,
								visualInboundEndpoint.getSimpleConsumerPort());
					} else {
						throw new TransformerException(
								"Simple consumer port cannot be empty");
					}
					if (StringUtils.isNotBlank(visualInboundEndpoint
							.getSimpleConsumerPartition())) {
						inboundEndpoint.addParameter(
								InboundEndpointConstants.SIMPLE_PARTITION,
								visualInboundEndpoint
										.getSimpleConsumerPartition());
					} else {
						throw new TransformerException(
								"Simple consumer partition cannot be empty");
					}
					if (StringUtils.isNotBlank(visualInboundEndpoint
							.getSimpleConsumerMaxMessagesToRead())) {
						inboundEndpoint
								.addParameter(
										InboundEndpointConstants.SIMPLE_MAX_MESSAGES_TO_READ,
										visualInboundEndpoint
												.getSimpleConsumerMaxMessagesToRead());
					} else {
						throw new TransformerException(
								"Max messages to read cannot be empty");
					}
				}
			}

			// Non-mandatory fields
			if (StringUtils.isNotBlank(visualInboundEndpoint.getThreadCount())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.THREAD_COUNT,
						visualInboundEndpoint.getThreadCount());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getConsumerId())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.CONSUMER_ID,
						visualInboundEndpoint.getConsumerId());
			}
			inboundEndpoint.addParameter(
					InboundEndpointConstants.SOCKET_TIMEOUT_MS, Integer
							.toString(visualInboundEndpoint
									.getSocketTimeoutMs()));
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getSocketReceiveBufferBytes())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SOCKET_RECEIVE_BUFFER_BYTES,
						visualInboundEndpoint.getSocketReceiveBufferBytes());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getFetchMessageMaxBytes())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.FETCH_MESSAGE_MAX_BYTES,
						visualInboundEndpoint.getFetchMessageMaxBytes());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getNumConsumerFetches())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.NUM_CONSUMER_FETCHES,
						visualInboundEndpoint.getNumConsumerFetches());
			}
			if (visualInboundEndpoint.isAutoCommitEnable()) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.AUTO_COMMIT_ENABLE,
						InboundEndpointConstants.TRUE);
			} else {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.AUTO_COMMIT_ENABLE,
						InboundEndpointConstants.FALSE);
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getAutoCommitIntervalMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.AUTO_COMMIT_INTERVAL_MS,
						visualInboundEndpoint.getAutoCommitIntervalMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getQueuedMaxMessageChunks())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.QUEUED_MAX_MESSAGE_CHUNKS,
						visualInboundEndpoint.getQueuedMaxMessageChunks());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getRebalanceMaxRetries())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.REBALANCE_MAX_RETRIES,
						visualInboundEndpoint.getRebalanceMaxRetries());
			}
			if (StringUtils
					.isNotBlank(visualInboundEndpoint.getFetchMinBytes())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.FETCH_MIN_BYTES,
						visualInboundEndpoint.getFetchMinBytes());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getFetchWaitMaxMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.FETCH_WAIT_MAX_MS,
						visualInboundEndpoint.getFetchWaitMaxMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getRebalanceBackoffMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.REBALANCE_BACKOFF_MS,
						visualInboundEndpoint.getRebalanceBackoffMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getRefreshLeaderBackoffMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.REFRESH_LEADER_BACKOFF_MS,
						visualInboundEndpoint.getRefreshLeaderBackoffMs());
			}
			inboundEndpoint.addParameter(
					InboundEndpointConstants.AUTO_OFFSET_RESET,
					visualInboundEndpoint.getAutoOffsetReset().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getConsumerTimeoutMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.CONSUMER_TIMEOUT_MS,
						visualInboundEndpoint.getConsumerTimeoutMs());
			}
			if (visualInboundEndpoint.isExcludeInternalTopics()) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.EXCLUDE_INTERNAL_TOPICS,
						InboundEndpointConstants.TRUE);
			} else {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.EXCLUDE_INTERNAL_TOPICS,
						InboundEndpointConstants.FALSE);
			}
			inboundEndpoint.addParameter(
					InboundEndpointConstants.PARTITION_ASSIGNMENT_STRATEGY,
					visualInboundEndpoint.getPartitionAssignmentStrategy()
							.getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getClientId())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.CLIENT_ID,
						visualInboundEndpoint.getClientId());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getZookeeperSessionTimeoutMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.ZOOKEEPER_SESSION_TIMEOUT_MS,
						visualInboundEndpoint.getZookeeperSessionTimeoutMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getZookeeperConnectionTimeoutMs())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.ZOOKEEPER_CONNECTION_TIMEOUT_MS,
								visualInboundEndpoint
										.getZookeeperConnectionTimeoutMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getZookeeperSyncTimeMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.ZOOKEEPER_SYNC_TIME_MS,
						visualInboundEndpoint.getZookeeperSyncTimeMs());
			}
			inboundEndpoint.addParameter(
					InboundEndpointConstants.OFFSETS_STORAGE,
					visualInboundEndpoint.getOffsetsStorage().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getOffsetsChannelBackoffMs())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.OFFSETS_CHANNEL_BACKOFF_MS,
						visualInboundEndpoint.getOffsetsChannelBackoffMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getOffsetsChannelSocketTimeoutMs())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS,
								visualInboundEndpoint
										.getOffsetsChannelSocketTimeoutMs());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getOffsetsCommitMaxRetries())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.OFFSETS_COMMIT_MAX_RETRIES,
						visualInboundEndpoint.getOffsetsCommitMaxRetries());
			}
			if (visualInboundEndpoint.isDualCommitEnabled()) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.DUAL_COMMIT_ENABLED,
						InboundEndpointConstants.TRUE);
			} else {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.DUAL_COMMIT_ENABLED,
						InboundEndpointConstants.FALSE);
			}
			break;
		case CXF_WS_RM:
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundCxfRmHost())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_CXF_RM_HOST,
						visualInboundEndpoint.getInboundCxfRmHost());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundCxfRmPort())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_CXF_RM_PORT,
						visualInboundEndpoint.getInboundCxfRmPort());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getInboundCxfRmConfigFile())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_CXF_RM_CONFIG_FILE,
						visualInboundEndpoint.getInboundCxfRmConfigFile());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isEnableSSL()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.ENABLE_SSL,
						String.valueOf(visualInboundEndpoint.isEnableSSL()));
			}
			break;
		case MQTT:
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTConnectionFactory())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_MQTT_CONNECTION_FACTORY,
								visualInboundEndpoint
										.getTransportMQTTConnectionFactory());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTServerHostName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_SERVER_HOST_NAME,
						visualInboundEndpoint.getTransportMQTTServerHostName());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTServerPort())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_SERVER_PORT,
						visualInboundEndpoint.getTransportMQTTServerPort());
			}

			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTTopicName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_TOPIC_NAME,
						visualInboundEndpoint.getTransportMQTTTopicName());
			}

			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getContentType().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_CONTENT_TYPE,
						visualInboundEndpoint.getContentType().getLiteral());
			}

			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportMQTTSubscriptionQOS().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_QOS,
						visualInboundEndpoint.getTransportMQTTSubscriptionQOS()
								.getLiteral());
			}

			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isTransportMQTTSessionClean()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_SESSION_CLEAN,
						String.valueOf(visualInboundEndpoint
								.isTransportMQTTSessionClean()));
			}

			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTSslEnable())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_SSL_ENABLE,
						visualInboundEndpoint.getTransportMQTTSslEnable());
			}

			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTTemporaryStoreDirectory())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_MQTT_TEMPORARY_STORE_DIRECTORY,
								visualInboundEndpoint
										.getTransportMQTTTemporaryStoreDirectory());
			}

			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTSubscriptionUsername())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_USERNAME,
								visualInboundEndpoint
										.getTransportMQTTSubscriptionUsername());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTSubscriptionPassword())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_PASSWORD,
								visualInboundEndpoint
										.getTransportMQTTSubscriptionPassword());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportMQTTClientId())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_MQTT_CLIENT_ID,
						visualInboundEndpoint.getTransportMQTTClientId());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.INBOUND_MQTT_RECONNECTION_INTERVAL,
								visualInboundEndpoint.getInterval());
			}
			break;
		case RABBITMQ:
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.isSequential()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionFactory())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_CONNECTION_FACTORY,
						visualInboundEndpoint
								.getTransportRabbitMqConnectionFactory());
			} else {
				throw new TransformerException(
						"RabbitMQ connection factory cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqServerHostName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_SERVER_HOST_NAME,
						visualInboundEndpoint
								.getTransportRabbitMqServerHostName());
			} else {
				throw new TransformerException(
						"RabbitMQ server hostname cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqServerPort())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_SERVER_PORT,
						visualInboundEndpoint.getTransportRabbitMqServerPort());
			} else {
				throw new TransformerException(
						"RabbitMQ server port cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqServerUserName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_SERVER_USER_NAME,
						visualInboundEndpoint
								.getTransportRabbitMqServerUserName());
			} else {
				throw new TransformerException(
						"RabbitMQ server username cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqServerPassword())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_SERVER_PASSWORD,
						visualInboundEndpoint
								.getTransportRabbitMqServerPassword());
			} else {
				throw new TransformerException(
						"RabbitMQ server password cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_NAME,
						visualInboundEndpoint.getTransportRabbitMqQueueName());
			} else {
				throw new TransformerException(
						"RabbitMQ queue name cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqExchangeName())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_EXCHANGE_NAME,
						visualInboundEndpoint
								.getTransportRabbitMqExchangeName());
			} else {
				throw new TransformerException(
						"RabbitMQ exchange name cannot be empty");
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueDurable())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_DURABLE,
						visualInboundEndpoint
								.getTransportRabbitMqQueueDurable());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueExclusive())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_EXCLUSIVE,
						visualInboundEndpoint
								.getTransportRabbitMqQueueExclusive());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueAutoDelete())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_DELETE,
						visualInboundEndpoint
								.getTransportRabbitMqQueueAutoDelete());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueAutoAck())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_ACK,
						visualInboundEndpoint
								.getTransportRabbitMqQueueAutoAck());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueRoutingKey())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_ROUTING_KEY,
						visualInboundEndpoint
								.getTransportRabbitMqQueueRoutingKey());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqQueueDeliveryMode())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_QUEUE_DELIVERY_MODE,
						visualInboundEndpoint
								.getTransportRabbitMqQueueDeliveryMode());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqExchangeType())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_EXCHANGE_TYPE,
						visualInboundEndpoint
								.getTransportRabbitMqExchangeType());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqExchangeDurable())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_EXCHANGE_DURABLE,
						visualInboundEndpoint
								.getTransportRabbitMqExchangeDurable());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqExchangeAutoDelete())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_EXCHANGE_AUTO_DELETE,
						visualInboundEndpoint
								.getTransportRabbitMqExchangeAutoDelete());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqServerVirtualHost())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_SERVER_VIRTUAL_HOST,
						visualInboundEndpoint
								.getTransportRabbitMqServerVirtualHost());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqFactoryHeartbeat())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.RABBITMQ_FACTORY_HEARTBEAT,
						visualInboundEndpoint
								.getTransportRabbitMqFactoryHeartbeat());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslEnabled())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_ENABLED,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslEnabled());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslKeystoreLocation())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_LOCATION,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslKeystoreLocation());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslKeystoreType())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_TYPE,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslKeystoreType());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslKeystorePassword())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_PASSWORD,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslKeystorePassword());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslTruststoreLocation())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_LOCATION,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslTruststoreLocation());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslTruststoreType())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_TYPE,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslTruststoreType());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslTruststorePassword())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslTruststorePassword());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportRabbitMqConnectionSslVersion())) {
				inboundEndpoint
						.addParameter(
								InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_VERSION,
								visualInboundEndpoint
										.getTransportRabbitMqConnectionSslVersion());
			}
			break;
		case FEED:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL,
						visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint
					.getTransportFeedURL())) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_FEED_URL,
						visualInboundEndpoint.getTransportFeedURL());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint
					.getTransportFeedType().getLiteral()))) {
				inboundEndpoint.addParameter(
						InboundEndpointConstants.INBOUND_FEED_TYPE,
						visualInboundEndpoint.getTransportFeedType()
								.getLiteral());
			}
			break;
		default:
			break;
		}
		return inboundEndpoint;
	}

}
