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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType;
import org.wso2.developerstudio.eclipse.gmf.esb.ContentType;
import org.wso2.developerstudio.eclipse.gmf.esb.Enable;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.FeedType;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
import org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicsType;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSAction;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

public class InboundEndpointDeserializer extends
		AbstractEsbNodeDeserializer<InboundEndpoint, org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint> {

	@Override
	public org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint createNode(IGraphicalEditPart part,
			InboundEndpoint object) {

		// Creating a new graphical InboundEndpoint object.
		org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint inboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) DeserializerUtils
				.createNode(part, EsbElementTypes.InboundEndpoint_3767);

		setElementToEdit(inboundEndpoint);
		refreshEditPartMap();

		executeSetValueCommand(INBOUND_ENDPOINT__NAME, object.getName());

		if (object.isSuspend()) {
			executeSetValueCommand(INBOUND_ENDPOINT__SUSPEND, true);
		} else {
			executeSetValueCommand(INBOUND_ENDPOINT__SUSPEND, false);
		}

		if (StringUtils.isNotBlank(object.getClassImpl())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CUSTOM);
			executeSetValueCommand(INBOUND_ENDPOINT__CLASS, object.getClassImpl());
			updateParameters(object);
			updateCustomParameters(object);
		}

		if (InboundEndpointConstants.HTTP.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HTTP);
			updateParameters(object);
		} else if (InboundEndpointConstants.FILE.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.FILE);
			updateParameters(object);
		} else if (InboundEndpointConstants.JMS.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.JMS);
			updateParameters(object);
		} else if (InboundEndpointConstants.HTTPS.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HTTPS);
			updateParameters(object);
		} else if (InboundEndpointConstants.HL7.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HL7);
			updateParameters(object);
		} else if (InboundEndpointConstants.KAFKA.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.KAFKA);
			updateParameters(object);
		} else if (InboundEndpointConstants.CUSTOM.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CUSTOM);
			updateParameters(object);
		} else if (InboundEndpointConstants.CXF_WS_RM.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CXF_WS_RM);
			updateParameters(object);
		} else if (InboundEndpointConstants.MQTT.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.MQTT);
			updateParameters(object);
		} else if (InboundEndpointConstants.RABBITMQ.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.RABBITMQ);
			updateParameters(object);
		} else if (InboundEndpointConstants.FEED.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.FEED);
			updateParameters(object);
		}

		// Creating Sequence mediator graphically
		if (object.getInjectingSeq() != null && !"".equals(object.getInjectingSeq())) {
			addRootInputConnector(inboundEndpoint.getSequenceInputConnector());
			IGraphicalEditPart sequenceCompartment = (IGraphicalEditPart) getEditpart(
					inboundEndpoint.getContainer().getSequenceContainer().getMediatorFlow()).getChildren().get(0);
			setRootCompartment((GraphicalEditPart) sequenceCompartment);
			SequenceMediator sequenceContainer = new SequenceMediator();
			SequenceMediator sequenceMediator = new SequenceMediator();
			Value sequenceKey = new Value(object.getInjectingSeq());
			sequenceMediator.setKey(sequenceKey);
			sequenceContainer.addChild(sequenceMediator);
			deserializeSequence(sequenceCompartment, sequenceContainer, inboundEndpoint.getSequenceOutputConnector());
		}

		// Creating OnErrorSequence mediator graphically
		if (object.getOnErrorSeq() != null && !"".equals(object.getOnErrorSeq())) {
			addRootInputConnector(inboundEndpoint.getOnErrorSequenceInputConnector());
			IGraphicalEditPart onErrorSequenceCompartment = (IGraphicalEditPart) getEditpart(
					inboundEndpoint.getContainer().getOnErrorSequenceContainer().getMediatorFlow()).getChildren()
					.get(0);
			setRootCompartment((GraphicalEditPart) onErrorSequenceCompartment);
			SequenceMediator onErrorSequenceContainer = new SequenceMediator();
			SequenceMediator onErrorSequenceMediator = new SequenceMediator();
			Value onErrorSequenceKey = new Value(object.getOnErrorSeq());
			onErrorSequenceMediator.setKey(onErrorSequenceKey);
			onErrorSequenceContainer.addChild(onErrorSequenceMediator);
			deserializeSequence(onErrorSequenceCompartment, onErrorSequenceContainer,
					inboundEndpoint.getOnErrorSequenceOutputConnector());
		}

		addPairMediatorFlow(inboundEndpoint.getSequenceOutputConnector(),inboundEndpoint.getSequenceInputConnector());
		addPairMediatorFlow(inboundEndpoint.getOnErrorSequenceOutputConnector(),inboundEndpoint.getOnErrorSequenceInputConnector());
		return inboundEndpoint;
	}

	/**
	 * Update parameters for custom Inbound Endpoints
	 * 
	 * @param object
	 */
	private void updateCustomParameters(InboundEndpoint object) {
		EList<InboundEndpointParameter> parameters = new BasicEList<InboundEndpointParameter>();
		for (Map.Entry<String, String> entry : object.getParametersMap().entrySet()) {
			InboundEndpointParameter parameter = EsbFactory.eINSTANCE.createInboundEndpointParameter();
			parameter.setName(entry.getKey());
			parameter.setValue(entry.getValue().toString());
			parameters.add(parameter);
		}
		if (parameters.size() > 0) {
			executeSetValueCommand(INBOUND_ENDPOINT__SERVICE_PARAMETERS, parameters);
		}

	}

	/**
	 * Updates parameters of the Inbound Endpoint
	 * 
	 * @param object
	 */
	private void updateParameters(InboundEndpoint object) {
		for (Map.Entry<String, String> paramEntry : object.getParametersMap().entrySet()) {
			if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HTTP_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HTTP_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INTERVAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INTERVAL, paramEntry.getValue());
			}			
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_CORE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_MAX)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_WORKER_POOL_QUEUE_LENGTH)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_THREAD_GROUOP_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_THREAD_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_THREAD_ID, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.DISPATCH_FILTER_PATTERN)) {
				executeSetValueCommand(INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN, paramEntry.getValue());
			}		
			else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__SEQUENTIAL, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__SEQUENTIAL, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.COORDINATION)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__COORDINATION, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__COORDINATION, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_BEHAVIOUR)) {
				if (paramEntry.getValue().equals("polling")) {
					executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR, InboundEndpointBehaviourType.POLLING_INBOUND_ENDPOINT);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR, InboundEndpointBehaviourType.LISTENING_INBOUND_ENDPOINT);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILE_URI)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_CONTENT_TYPE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILE_NAME_PATTERN)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILE_PROCESS_INTERVAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILE_PROCESS_COUNT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILE_PROCESS_COUNT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_LOCKING)) {
				if (paramEntry.getValue().equals(ENABLE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING, Enable.ENABLE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING, Enable.DISABLE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MAX_RETRY_COUNT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_RECONNECT_TIMEOUT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_ACTION_AFTER_PROCESS)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.DELETE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS, VFSAction.DELETE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS, VFSAction.MOVE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_AFTER_PROCESS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_ACTION_AFTER_FAILURE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.DELETE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE, VFSAction.DELETE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE, VFSAction.MOVE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_AFTER_FAILURE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_TIMESTAMP_FORMAT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE_INTERVAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_LOCK_RELEASE_SAME_NODE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_DISTRIBUTED_LOCK)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_DISTRIBUTED_TIMEOUT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILESORT_ATTRIBUTE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.NONE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, VFSFileSort.NONE);
				} else if (paramEntry.getValue().equals(InboundEndpointConstants.NAME)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, VFSFileSort.NAME);
				} else if (paramEntry.getValue().equals(InboundEndpointConstants.SIZE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, VFSFileSort.SIZE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE,
							VFSFileSort.LASTMODIFIEDTIMESTAMP);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILESORT_ASCENDING)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_SUBFOLDER_TIMESTAMP_FORMAT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_CREATE_FOLDER)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, false);
				}
			}			
			else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_STREAMING)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, false);
				}
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_BUILD)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD, false);
				}
			}		
			else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_JAVA_NAMING_PROVIDER_URL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CONNECTION_FACTORY_JNDI_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TOPIC)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
							JMSConnectionFactoryType.TOPIC);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
							JMSConnectionFactoryType.QUEUE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_DESTINATION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SESSION_TRANSACTED)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.AUTO_ACKNOWLEDGE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
							JMSSessionAcknowledgement.AUTO_ACKNOWLEDGE);
				} else if (paramEntry.getValue().equals(InboundEndpointConstants.CLIENT_ACKNOWLEDGE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
							JMSSessionAcknowledgement.CLIENT_ACKNOWLEDGE);
				} else if (paramEntry.getValue().equals(InboundEndpointConstants.DUPS_OK_ACKNOWLEDGE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
							JMSSessionAcknowledgement.DUPS_OK_ACKNOWLEDGE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
							JMSSessionAcknowledgement.SESSION_TRANSACTED);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CACHE_LEVEL)) {
				if (paramEntry.getValue().equals("1")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL, JMSCacheLevel.ONE);
				} else if (paramEntry.getValue().equals("2")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL, JMSCacheLevel.TWO);
				} else if (paramEntry.getValue().equals("3")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL, JMSCacheLevel.THREE);
				} 
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_USERNAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_PASSWORD)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_JMS_SPEC_VERSION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SUBSCRIPTION_DURABLE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_CLIENT_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_MESSAGE_SELECTOR)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_RECIEVE_TIMEOUT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CONTENT_TYPE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_REPLY_DESTINATION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_PUB_SUB_NO_LOCAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CONTENT_TYPE_PROPERTY)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY, paramEntry.getValue());
			}		
			else if (paramEntry.getKey().equals(InboundEndpointConstants.KEYSTORE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__KEYSTORE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.TRUSTSTORE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRUSTSTORE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SSL_VERIFY_CLIENT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SSL_VERIFY_CLIENT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SSL_PROTOCOL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SSL_PROTOCOL, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.HTTPS_PROTOCOLS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__HTTPS_PROTOCOLS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CERTIFICATE_REVOCATION_VERIFIER)) {
				executeSetValueCommand(INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_AUTOACK)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_TIMEOUT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_MESSAGE_PRE_PROCESSOR)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_CHARSET)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_VALIDATE_MESSAGE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_BUILD_INVALID_MESSAGES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES,
						paramEntry.getValue());
			} 
			
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_CONNECTION_FACTORY)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY, paramEntry.getValue());
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SERVER_HOST_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME, paramEntry.getValue());
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SERVER_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT, paramEntry.getValue());
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_TOPIC_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME, paramEntry.getValue());
			}			
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_QOS)) {
				if (paramEntry.getValue().equals("0")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS, MQTTSubscriptionQOS.ZERO);
				} else if (paramEntry.getValue().equals("1")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS, MQTTSubscriptionQOS.ONE);
				} else if (paramEntry.getValue().equals("2")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS, MQTTSubscriptionQOS.TWO);
				}
			}		
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SSL_ENABLE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE, paramEntry.getValue());
			}		
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_TEMPORARY_STORE_DIRECTORY)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY, paramEntry.getValue());
			}		
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_USERNAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME, paramEntry.getValue());
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_PASSWORD)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD, paramEntry.getValue());
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_CLIENT_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID, paramEntry.getValue());
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_RECONNECTION_INTERVAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INTERVAL, paramEntry.getValue());
			}
			
			// KAFKA properties
			else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_CONNECT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_CONNECT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.GROUP_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__GROUP_ID, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CONTENT_TYPE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.APPLICATION_XML)) {
					executeSetValueCommand(INBOUND_ENDPOINT__CONTENT_TYPE, ContentType.XML);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__CONTENT_TYPE, ContentType.JSON);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CONSUMER_TYPE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.HIGHLEVEL)) {
					executeSetValueCommand(INBOUND_ENDPOINT__CONSUMER_TYPE, ConsumerType.HIGHLEVEL);					
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__CONSUMER_TYPE, ConsumerType.SIMPLE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.TOPICS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TOPICS_OR_TOPIC_FILTER, TopicsType.TOPICS);
				executeSetValueCommand(INBOUND_ENDPOINT__TOPICS_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.TOPIC_FILTER)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TOPICS_OR_TOPIC_FILTER, TopicsType.TOPIC_FILTER);
				executeSetValueCommand(INBOUND_ENDPOINT__TOPIC_FILTER_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.FILTER_FROM_WHITELIST)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TOPIC_FILTER_FROM, TopicFilterFromType.FILTER_FROM_WHITELIST);
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.FILTER_FROM_BLACKLIST)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TOPIC_FILTER_FROM, TopicFilterFromType.FILTER_FROM_BLACKLIST);
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_TOPIC)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_CONSUMER_TOPIC, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_BROKERS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_CONSUMER_BROKERS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_CONSUMER_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_PARTITION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_CONSUMER_PARTITION, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_MAX_MESSAGES_TO_READ)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_CONSUMER_MAX_MESSAGES_TO_READ, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.THREAD_COUNT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__THREAD_COUNT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CONSUMER_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__CONSUMER_ID, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SOCKET_TIMEOUT_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SOCKET_TIMEOUT_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SOCKET_RECEIVE_BUFFER_BYTES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SOCKET_RECEIVE_BUFFER_BYTES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.FETCH_MESSAGE_MAX_BYTES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__FETCH_MESSAGE_MAX_BYTES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.NUM_CONSUMER_FETCHES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__NUM_CONSUMER_FETCHES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.AUTO_COMMIT_ENABLE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__AUTO_COMMIT_ENABLE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.AUTO_COMMIT_INTERVAL_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.QUEUED_MAX_MESSAGE_CHUNKS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__QUEUED_MAX_MESSAGE_CHUNKS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.REBALANCE_MAX_RETRIES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__REBALANCE_MAX_RETRIES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.FETCH_MIN_BYTES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__FETCH_MIN_BYTES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.FETCH_WAIT_MAX_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__FETCH_WAIT_MAX_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.REBALANCE_BACKOFF_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__REBALANCE_BACKOFF_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.REFRESH_LEADER_BACKOFF_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__REFRESH_LEADER_BACKOFF_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.AUTO_OFFSET_RESET)) {
				executeSetValueCommand(INBOUND_ENDPOINT__AUTO_OFFSET_RESET, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CONSUMER_TIMEOUT_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__CONSUMER_TIMEOUT_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.EXCLUDE_INTERNAL_TOPICS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__EXCLUDE_INTERNAL_TOPICS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.PARTITION_ASSIGNMENT_STRATEGY)) {
				executeSetValueCommand(INBOUND_ENDPOINT__PARTITION_ASSIGNMENT_STRATEGY, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CLIENT_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__CLIENT_ID, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_SESSION_TIMEOUT_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_CONNECTION_TIMEOUT_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_CONNECTION_TIMEOUT_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_SYNC_TIME_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.OFFSETS_STORAGE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__OFFSETS_STORAGE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.OFFSETS_CHANNEL_BACKOFF_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__OFFSETS_CHANNEL_BACKOFF_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.OFFSETS_COMMIT_MAX_RETRIES)) {
				executeSetValueCommand(INBOUND_ENDPOINT__OFFSETS_COMMIT_MAX_RETRIES, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.DUAL_COMMIT_ENABLED)) {
				executeSetValueCommand(INBOUND_ENDPOINT__DUAL_COMMIT_ENABLED, paramEntry.getValue());
			}
			
			// RabbitMQ properties
			else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_FACTORY)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_FACTORY, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_SERVER_HOST_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_HOST_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_SERVER_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_SERVER_USER_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_USER_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_SERVER_PASSWORD)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PASSWORD, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_EXCHANGE_NAME)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_NAME, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_DURABLE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DURABLE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_EXCLUSIVE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_EXCLUSIVE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_DELETE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_DELETE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_ACK)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_ACK, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_ROUTING_KEY)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_ROUTING_KEY, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_DELIVERY_MODE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DELIVERY_MODE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_EXCHANGE_TYPE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_TYPE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_EXCHANGE_DURABLE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_DURABLE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_EXCHANGE_AUTO_DELETE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DELETE,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_SERVER_VIRTUAL_HOST)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_VIRTUAL_HOST, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_FACTORY_HEARTBEAT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_FACTORY_HEARTBEAT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_ENABLED)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_ENABLED,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_LOCATION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_LOCATION,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_TYPE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_TYPE,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_PASSWORD)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_PASSWORD,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_LOCATION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_LOCATION,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_TYPE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_TYPE,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_VERSION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_VERSION,
						paramEntry.getValue());
			}
			
			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_FEED_URL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_FEED_URL, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_FEED_TYPE)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.ATOM)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_FEED_TYPE, FeedType.ATOM);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_FEED_TYPE, FeedType.RSS);
				}
			}

			else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_CXF_RM_HOST)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_CXF_RM_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_CXF_RM_CONFIG_FILE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ENABLE_SSL)) {
				if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__ENABLE_SSL, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__ENABLE_SSL, false);
				}
			}
		}

	}
}
