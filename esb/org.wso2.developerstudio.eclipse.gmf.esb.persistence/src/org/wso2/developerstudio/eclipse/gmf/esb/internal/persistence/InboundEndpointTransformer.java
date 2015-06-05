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
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class InboundEndpointTransformer extends AbstractEsbNodeTransformer {

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

		// FIXME include RegistryKey
		if (sequence != null) {
			// FIXME with sequence.getKey()
			inboundEndpoint.setInjectingSeq(sequence.getName());
		} else {
			throw new Exception();
		}
		Sequence onErrorSequence = getSequence(visualInboundEndpoint.getOnErrorSequenceOutputConnector());
		if (onErrorSequence != null) {
			// FIXME with onErrorSequence.getKey()
			inboundEndpoint.setOnErrorSeq(onErrorSequence.getName());
		} else {
			throw new Exception();
		}

		inboundEndpoint.setSuspend(false);
		inboundEndpoint.setClassImpl(visualInboundEndpoint.getClass_());

		if (StringUtils.isNotBlank(visualInboundEndpoint.getType().toString())) {
			inboundEndpoint.setProtocol(visualInboundEndpoint.getType().toString());
		}

		switch (visualInboundEndpoint.getType()) {
		case HTTP:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHttpPort())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INBOUND_HTTP_PORT,
						visualInboundEndpoint.getInboundHttpPort());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.API_DISPATCHING_ENABLED,
					String.valueOf(visualInboundEndpoint.isApiDispatchingEnabled()));
			break;
		case FILE:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL, visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_ACTION_AFTER_ERRORS, visualInboundEndpoint
					.getTransportVFSActionAfterErrors().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSContentType())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_CONTENT_TYPE,
						visualInboundEndpoint.getTransportVFSContentType());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_LOCK_RELEASE_SAME_NODE,
					String.valueOf(visualInboundEndpoint.isTransportVFSLockReleaseSameNode()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSAutoLockReleaseInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE_INTERVAL,
						visualInboundEndpoint.getTransportVFSAutoLockReleaseInterval());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE,
					String.valueOf(visualInboundEndpoint.isTransportVFSAutoLockRelease()));
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_ACTION_AFTER_FAILURE, visualInboundEndpoint
					.getTransportVFSActionAfterFailure().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMaxRetryCount())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_MAX_RETRY_COUNT,
						visualInboundEndpoint.getTransportVFSMaxRetryCount());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSReconnectTimeout())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_RECONNECT_TIMEOUT,
						visualInboundEndpoint.getTransportVFSReconnectTimeout());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_ACTION_AFTER_PROCESS, visualInboundEndpoint
					.getTransportVFSActionAfterProcess().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileURI())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_FILE_URI,
						visualInboundEndpoint.getTransportVFSFileURI());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterFailure())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_MOVE_AFTER_FAILURE,
						visualInboundEndpoint.getTransportVFSMoveAfterFailure());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveTimestampFormat())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_MOVE_TIMESTAMP_FORMAT,
						visualInboundEndpoint.getTransportVFSMoveTimestampFormat());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_DISTRIBUTED_LOCK,
					String.valueOf(visualInboundEndpoint.isTransportVFSDistributedLock()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileNamePattern())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_FILE_NAME_PATTERN,
						visualInboundEndpoint.getTransportVFSFileNamePattern());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileProcessInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_FILE_PROCESS_INTERVAL,
						visualInboundEndpoint.getTransportVFSFileProcessInterval());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSMoveAfterErrors())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_MOVE_AFTER_ERRORS,
						visualInboundEndpoint.getTransportVFSMoveAfterErrors());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_MOVE_AFTER_PROCESS,
					String.valueOf(visualInboundEndpoint.getTransportVFSMoveAfterProcess()));
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_LOCKING, visualInboundEndpoint
					.getTransportVFSLocking().getLiteral());
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_DISTRIBUTED_TIMEOUT,
					String.valueOf(visualInboundEndpoint.getTransportVFSDistributedTimeout()));
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_FILESORT_ATTRIBUTE, visualInboundEndpoint
					.getTransportVFSFileSortAttribute().getLiteral());
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_FILESORT_ASCENDING,
					String.valueOf(visualInboundEndpoint.isTransportVFSFileSortAscending()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSSubFolderTimestampFormat())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_SUBFOLDER_TIMESTAMP_FORMAT,
						visualInboundEndpoint.getTransportVFSSubFolderTimestampFormat());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.VFS_CREATE_FOLDER,
					String.valueOf(visualInboundEndpoint.isTransportVFSCreateFolder()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportVFSFileProcessCount())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.VFS_FILE_PROCESS_COUNT,
						visualInboundEndpoint.getTransportVFSFileProcessCount());
			}
			break;
		case JMS:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL, visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSMessageSelector())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_MESSAGE_SELECTOR,
						visualInboundEndpoint.getTransportJMSMessageSelector());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDestination())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_DESTINATION,
						visualInboundEndpoint.getTransportJMSDestination());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.JMS_CACHE_LEVEL, visualInboundEndpoint
					.getTransportJMSCacheLevel().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_CONNECTION_FACTORY_JNDI_NAME,
						visualInboundEndpoint.getTransportJMSConnectionFactoryJNDIName());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingFactoryInitial())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL,
						visualInboundEndpoint.getJavaNamingFactoryInitial());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getJavaNamingProviderUrl())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_JAVA_NAMING_PROVIDER_URL,
						visualInboundEndpoint.getJavaNamingProviderUrl());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSUserName())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_USERNAME,
						visualInboundEndpoint.getTransportJMSUserName());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT, visualInboundEndpoint
					.getTransportJMSSessionAcknowledgement().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSPassword())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_PASSWORD,
						visualInboundEndpoint.getTransportJMSPassword());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.JMS_SESSION_TRANSACTED,
					String.valueOf(visualInboundEndpoint.isTransportJMSSessionTransacted()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSSubscriptionDurable())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_SUBSCRIPTION_DURABLE,
						visualInboundEndpoint.getTransportJMSSubscriptionDurable());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE, visualInboundEndpoint
					.getTransportJMSConnectionFactoryType().getLiteral());
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSJMSSpecVersion())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_JMS_SPEC_VERSION,
						visualInboundEndpoint.getTransportJMSJMSSpecVersion());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSDurableSubscriberClientID())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
						visualInboundEndpoint.getTransportJMSDurableSubscriberClientID());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSReceiveTimeout())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_RECIEVE_TIMEOUT,
						visualInboundEndpoint.getTransportJMSReceiveTimeout());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTransportJMSContentType())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.JMS_CONTENT_TYPE,
						visualInboundEndpoint.getTransportJMSContentType());
			}
			break;
		case CUSTOM:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInterval())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INTERVAL, visualInboundEndpoint.getInterval());
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(InboundEndpointConstants.SEQUENTIAL,
						String.valueOf(visualInboundEndpoint.isSequential()));
			}
			if (StringUtils.isNotBlank(String.valueOf(visualInboundEndpoint.isSequential()))) {
				inboundEndpoint.addParameter(InboundEndpointConstants.COORDINATION,
						String.valueOf(visualInboundEndpoint.isCoordination()));
			}
			break;
		case HTTPS:
			if (StringUtils.isNotBlank(visualInboundEndpoint.getInboundHttpPort())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.INBOUND_HTTP_PORT,
						visualInboundEndpoint.getInboundHttpPort());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getKeystore())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.KEYSTORE, visualInboundEndpoint.getKeystore());
			}
			inboundEndpoint.addParameter(InboundEndpointConstants.API_DISPATCHING_ENABLED,
					String.valueOf(visualInboundEndpoint.isApiDispatchingEnabled()));
			if (StringUtils.isNotBlank(visualInboundEndpoint.getTruststore())) {
				inboundEndpoint
						.addParameter(InboundEndpointConstants.TRUSTSTORE, visualInboundEndpoint.getTruststore());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getSslVerifyClient())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.SSL_VERIFY_CLIENT,
						visualInboundEndpoint.getSslVerifyClient());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getSslProtocol())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.SSL_PROTOCOL,
						visualInboundEndpoint.getSslProtocol());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getHttpsProtocols())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.HTTPS_PROTOCOLS,
						visualInboundEndpoint.getHttpsProtocols());
			}
			if (StringUtils.isNotBlank(visualInboundEndpoint.getCertificateRevocationVerifier())) {
				inboundEndpoint.addParameter(InboundEndpointConstants.CERTIFICATE_REVOCATION_VERIFIER,
						visualInboundEndpoint.getCertificateRevocationVerifier());
			}
		default:
			break;
		}
		return inboundEndpoint;
	}

}
