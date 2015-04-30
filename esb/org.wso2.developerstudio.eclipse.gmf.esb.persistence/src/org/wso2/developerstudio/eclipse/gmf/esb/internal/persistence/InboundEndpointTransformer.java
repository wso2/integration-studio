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
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class InboundEndpointTransformer extends AbstractEsbNodeTransformer {

	final static String SEQUENCE = "sequence";
	final static String ON_ERROR = "onError";
	final static String INBOUND_HTTP_PORT = "inbound.http.port";
	final static String INTERVAL = "interval";
	final static String SEQUENTIAL = "sequential";
	final static String COORDINATION = "coordination";
	final static String VFS_FILE_URI = "transport.vfs.FileURI";
	final static String VFS_CONTENT_TYPE = "transport.vfs.ContentType";
	final static String VFS_FILE_NAME_PATTERN = "transport.vfs.FileNamePattern";
	final static String VFS_FILE_PROCESS_INTERVAL = "transport.vfs.FileProcessInterval";
	final static String VFS_FILE_PROCESS_COUNT = "transport.vfs.FileProcessCount";
	final static String VFS_LOCKING = "transport.vfs.Locking";
	final static String VFS_MAX_RETRY_COUNT = "transport.vfs.MaxRetryCount";
	final static String VFS_RECONNECT_TIMEOUT = "transport.vfs.ReconnectTimeout";
	final static String VFS_ACTION_AFTER_PROCESS = "transport.vfs.ActionAfterProcess";
	final static String VFS_MOVE_AFTER_PROCESS = "transport.vfs.MoveAfterProcess";
	final static String VFS_ACTION_AFTER_ERRORS = "transport.vfs.ActionAfterErrors";
	final static String VFS_MOVE_AFTER_ERRORS = "transport.vfs.MoveAfterErrors";
	final static String VFS_ACTION_AFTER_FAILURE = "transport.vfs.ActionAfterFailure";
	final static String VFS_MOVE_AFTER_FAILURE = "transport.vfs.MoveAfterFailure";
	final static String VFS_AUTO_LOCK_RELEASE = "transport.vfs.AutoLockRelease";
	final static String VFS_AUTO_LOCK_RELEASE_INTERVAL = "transport.vfs.AutoLockReleaseInterval";
	final static String VFS_LOCK_RELEASE_SAME_NODE = "transport.vfs.LockReleaseSameNode";
	final static String VFS_DISTRIBUTED_LOCK = "transport.vfs.DistributedLock";
	final static String VFS_DISTRIBUTED_TIMEOUT = "transport.vfs.DistributedTimeout";
	final static String JMS_JAVA_NAMING_FACTORY_INITIAL = "java.naming.factory.initial";
	final static String JMS_JAVA_NAMING_PROVIDER_URL = "java.naming.provider.url";
	final static String JMS_CONNECTION_FACTORY_JNDI_NAME = "transport.jms.ConnectionFactoryJNDIName";
	final static String JMS_CONNECTION_FACTORY_TYPE = "transport.jms.ConnectionFactoryType";
	final static String JMS_DESTINATION = "transport.jms.Destination";
	final static String JMS_SESSION_TRANSACTED = "transport.jms.SessionTransacted";
	final static String JMS_SESSION_ACKNOWLEDGEMENT = "transport.jms.SessionAcknowledgement";
	final static String JMS_CACHE_LEVEL = "transport.jms.CacheLevel";
	final static String JMS_USERNAME = "transport.jms.UserName";
	final static String JMS_PASSWORD = "transport.jms.Password";
	final static String JMS_JMS_SPEC_VERSION = "transport.jms.JMSSpecVersion";
	final static String JMS_SUBSCRIPTION_DURABLE = "transport.jms.SubscriptionDurable";
	final static String JMS_DURABLE_SUBSCRIBER_CLIENT_ID = "transport.jms.DurableSubscriberClientID";
	final static String JMS_MESSAGE_SELECTOR = "transport.jms.MessageSelector";

	public void transform(TransformationInfo information, EsbNode subject) throws Exception {
		Assert.isTrue(subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint, "Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) subject;

		information.getSynapseConfiguration().addInboundEndpoint(visualInboundEndpoint.getName(),
				create(visualInboundEndpoint));
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws Exception {
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
	 * @throws Exception
	 */
	private InboundEndpoint create(org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint)
			throws Exception {
		InboundEndpoint inboundEndpoint = new InboundEndpoint();
		inboundEndpoint.setName(visualInboundEndpoint.getName());
		Sequence sequence = getSequence(visualInboundEndpoint.getSequenceOutputConnector());
		if (sequence != null) {
			inboundEndpoint.setInjectingSeq(sequence.getName());
		} else {
			throw new Exception();
		}
		Sequence onErrorSequence = getSequence(visualInboundEndpoint.getOnErrorSequenceOutputConnector());
		if (onErrorSequence != null) {
			inboundEndpoint.setOnErrorSeq(onErrorSequence.getName());
		} else {
			throw new Exception();
		}

		inboundEndpoint.setSuspend(false);
		inboundEndpoint.setClassImpl(visualInboundEndpoint.getClass_());
		if (StringUtils.isNotBlank(visualInboundEndpoint.getProtocol())) {
			inboundEndpoint.setProtocol(visualInboundEndpoint.getProtocol());
		}

		switch (visualInboundEndpoint.getType()) {
		case HTTP:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHttpPort())) {
				inboundEndpoint.addParameter(INBOUND_HTTP_PORT, visualInboundEndpoint.getInboundHttpPort());
			}
			break;
		case FILE:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(INTERVAL, visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(SEQUENTIAL, String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(COORDINATION, String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			inboundEndpoint.addParameter(VFS_ACTION_AFTER_ERRORS, visualInboundEndpoint
					.getTransportVFSActionAfterErrors().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSContentType())) {
				inboundEndpoint.addParameter(VFS_CONTENT_TYPE, visualInboundEndpoint.getTransportVFSContentType());
			}
			inboundEndpoint.addParameter(VFS_LOCK_RELEASE_SAME_NODE,
					String.valueOf(visualInboundEndpoint.isTransportVFSLockReleaseSameNode()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSAutoLockReleaseInterval())) {
				inboundEndpoint.addParameter(VFS_AUTO_LOCK_RELEASE_INTERVAL,
						visualInboundEndpoint.getTransportVFSAutoLockReleaseInterval());
			}
			inboundEndpoint.addParameter(VFS_AUTO_LOCK_RELEASE,
					String.valueOf(visualInboundEndpoint.isTransportVFSAutoLockRelease()));
			inboundEndpoint.addParameter(VFS_ACTION_AFTER_FAILURE, visualInboundEndpoint
					.getTransportVFSActionAfterFailure().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMaxRetryCount())) {
				inboundEndpoint.addParameter(VFS_MAX_RETRY_COUNT, visualInboundEndpoint.getTransportVFSMaxRetryCount());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSReconnectTimeout())) {
				inboundEndpoint.addParameter(VFS_RECONNECT_TIMEOUT,
						visualInboundEndpoint.getTransportVFSReconnectTimeout());
			}
			inboundEndpoint.addParameter(VFS_ACTION_AFTER_PROCESS, visualInboundEndpoint
					.getTransportVFSActionAfterProcess().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileURI())) {
				inboundEndpoint.addParameter(VFS_FILE_URI, visualInboundEndpoint.getTransportVFSFileURI());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterFailure())) {
				inboundEndpoint.addParameter(VFS_MOVE_AFTER_FAILURE,
						visualInboundEndpoint.getTransportVFSMoveAfterFailure());
			}
			inboundEndpoint.addParameter(VFS_DISTRIBUTED_LOCK,
					String.valueOf(visualInboundEndpoint.isTransportVFSDistributedLock()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileNamePattern())) {
				inboundEndpoint.addParameter(VFS_FILE_NAME_PATTERN,
						visualInboundEndpoint.getTransportVFSFileNamePattern());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileProcessInterval())) {
				inboundEndpoint.addParameter(VFS_FILE_PROCESS_INTERVAL,
						visualInboundEndpoint.getTransportVFSFileProcessInterval());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterErrors())) {
				inboundEndpoint.addParameter(VFS_MOVE_AFTER_ERRORS,
						visualInboundEndpoint.getTransportVFSMoveAfterErrors());
			}
			inboundEndpoint.addParameter(VFS_MOVE_AFTER_PROCESS,
					String.valueOf(visualInboundEndpoint.getTransportVFSMoveAfterProcess()));
			inboundEndpoint.addParameter(VFS_LOCKING, visualInboundEndpoint.getTransportVFSLocking().getLiteral());
			inboundEndpoint.addParameter(VFS_DISTRIBUTED_TIMEOUT,
					String.valueOf(visualInboundEndpoint.getTransportVFSDistributedTimeout()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileProcessCount())) {
				inboundEndpoint.addParameter(VFS_FILE_PROCESS_COUNT,
						visualInboundEndpoint.getTransportVFSFileProcessCount());
			}
			break;
		case JMS:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(INTERVAL, visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(SEQUENTIAL, String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(COORDINATION, String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSMessageSelector())) {
				inboundEndpoint.addParameter(JMS_MESSAGE_SELECTOR,
						visualInboundEndpoint.getTransportJMSMessageSelector());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDestination())) {
				inboundEndpoint.addParameter(JMS_DESTINATION, visualInboundEndpoint.getTransportJMSDestination());
			}
			inboundEndpoint.addParameter(JMS_CACHE_LEVEL, visualInboundEndpoint.getTransportJMSCacheLevel()
					.getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName())) {
				inboundEndpoint.addParameter(JMS_CONNECTION_FACTORY_JNDI_NAME,
						visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingFactoryInitial())) {
				inboundEndpoint.addParameter(JMS_JAVA_NAMING_FACTORY_INITIAL,
						visualInboundEndpoint.getJavaNamingFactoryInitial());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingProviderUrl())) {
				inboundEndpoint.addParameter(JMS_JAVA_NAMING_PROVIDER_URL,
						visualInboundEndpoint.getJavaNamingProviderUrl());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSUserName())) {
				inboundEndpoint.addParameter(JMS_USERNAME, visualInboundEndpoint.getTransportJMSUserName());
			}
			inboundEndpoint.addParameter(JMS_SESSION_ACKNOWLEDGEMENT, visualInboundEndpoint
					.getTransportJMSSessionAcknowledgement().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPassword())) {
				inboundEndpoint.addParameter(JMS_PASSWORD, visualInboundEndpoint.getTransportJMSPassword());
			}
			inboundEndpoint.addParameter(JMS_SESSION_TRANSACTED,
					String.valueOf(visualInboundEndpoint.isTransportJMSSessionTransacted()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSSubscriptionDurable())) {
				inboundEndpoint.addParameter(JMS_SUBSCRIPTION_DURABLE,
						visualInboundEndpoint.getTransportJMSSubscriptionDurable());
			}
			inboundEndpoint.addParameter(JMS_CONNECTION_FACTORY_TYPE, visualInboundEndpoint
					.getTransportJMSConnectionFactoryType().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSJMSSpecVersion())) {
				inboundEndpoint.addParameter(JMS_JMS_SPEC_VERSION,
						visualInboundEndpoint.getTransportJMSJMSSpecVersion());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDurableSubscriberClientID())) {
				inboundEndpoint.addParameter(JMS_MESSAGE_SELECTOR,
						visualInboundEndpoint.getTransportJMSDurableSubscriberClientID());
			}
			break;
		case CUSTOM:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(INTERVAL, visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(SEQUENTIAL, String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(COORDINATION, String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			break;
		default:
			break;
		}
		return inboundEndpoint;
	}

}
