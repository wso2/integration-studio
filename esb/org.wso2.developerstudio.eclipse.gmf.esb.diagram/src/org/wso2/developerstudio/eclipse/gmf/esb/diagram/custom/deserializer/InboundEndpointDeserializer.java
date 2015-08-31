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
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
import org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSAction;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

public class InboundEndpointDeserializer extends
		AbstractEsbNodeDeserializer<InboundEndpoint, org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint> {

	private static final String HTTP = "http";
	private static final String FILE = "file";
	private static final String JMS = "jms";
	private static final String HTTPS = "https";
	private static final String HL7 = "hl7";
	private static final String KAFKA = "kafka";
	private static final String CXF_WS_RM = "cxf_ws_rm";
	private static final String MQTT = "mqtt";
	private static final String TRUE = "true";
	private static final String NONE = "none";
	private static final String ENABLE = "enable";
	private static final String NAME = "name";
	private static final String SIZE = "size";
	private static final String TOPIC = "topic";
	private static final String AUTO_ACKNOWLEDGE = "AUTO_ACKNOWLEDGE";
	private static final String CLIENT_ACKNOWLEDGE = "CLIENT_ACKNOWLEDGE";
	private static final String DUPS_OK_ACKNOWLEDGE = "DUPS_OK_ACKNOWLEDGE";
	private static final String HIGHLEVEL = "highlevel";
	private static final String APPLICATION_XML = "application/xml";

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

		if (HTTP.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HTTP);
			updateParameters(object);
		} else if (FILE.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.FILE);
			updateParameters(object);
		} else if (JMS.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.JMS);
			updateParameters(object);
		} else if (HTTPS.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HTTPS);
			updateParameters(object);
		} else if (HL7.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HL7);
			updateParameters(object);
		} else if (KAFKA.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.KAFKA);
			updateParameters(object);
		} else if (CXF_WS_RM.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CXF_WS_RM);
			updateParameters(object);
		} else if (MQTT.equals(object.getProtocol())) {
			executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.MQTT);
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
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.API_DISPATCHING_ENABLED)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__API_DISPATCHING_ENABLED, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__API_DISPATCHING_ENABLED, false);
				}
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
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__SEQUENTIAL, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__SEQUENTIAL, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.COORDINATION)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__COORDINATION, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__COORDINATION, false);
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
				if (paramEntry.getValue().equals(NONE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS, VFSAction.NONE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS, VFSAction.MOVE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_AFTER_PROCESS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_ACTION_AFTER_ERRORS)) {
				if (paramEntry.getValue().equals(NONE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS, VFSAction.NONE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS, VFSAction.MOVE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_AFTER_ERRORS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_ACTION_AFTER_FAILURE)) {
				if (paramEntry.getValue().equals(NONE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE, VFSAction.NONE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE, VFSAction.MOVE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_AFTER_FAILURE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_MOVE_TIMESTAMP_FORMAT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE_INTERVAL)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_LOCK_RELEASE_SAME_NODE)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_DISTRIBUTED_LOCK)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_DISTRIBUTED_TIMEOUT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILESORT_ATTRIBUTE)) {
				if (paramEntry.getValue().equals(NONE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, VFSFileSort.NONE);
				} else if (paramEntry.getValue().equals(NAME)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, VFSFileSort.NAME);
				} else if (paramEntry.getValue().equals(SIZE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, VFSFileSort.SIZE);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE,
							VFSFileSort.LASTMODIFIEDTIMESTAMP);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILESORT_ASCENDING)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_SUBFOLDER_TIMESTAMP_FORMAT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT,
						paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_CREATE_FOLDER)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, false);
				}
			}			
			else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_STREAMING)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, false);
				}
			}
			else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_BUILD)) {
				if (paramEntry.getValue().equals(TRUE)) {
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
				if (paramEntry.getValue().equals(TOPIC)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
							JMSConnectionFactoryType.TOPIC);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
							JMSConnectionFactoryType.QUEUE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_DESTINATION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SESSION_TRANSACTED)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED, false);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT)) {
				if (paramEntry.getValue().equals(AUTO_ACKNOWLEDGE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
							JMSSessionAcknowledgement.AUTO_ACKNOWLEDGE);
				} else if (paramEntry.getValue().equals(CLIENT_ACKNOWLEDGE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
							JMSSessionAcknowledgement.CLIENT_ACKNOWLEDGE);
				} else if (paramEntry.getValue().equals(DUPS_OK_ACKNOWLEDGE)) {
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
				} else if (paramEntry.getValue().equals("4")) {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL, JMSCacheLevel.FOUR);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL, JMSCacheLevel.FIVE);
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
				if (paramEntry.getValue().equals(TRUE)) {
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
				if (paramEntry.getValue().equals(TRUE)) {
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
			else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_CONNECT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_CONNECT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.GROUP_ID)) {
				executeSetValueCommand(INBOUND_ENDPOINT__GROUP_ID, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CONSUMER_TYPE)) {
				if (paramEntry.getValue().equals(HIGHLEVEL)) {
					executeSetValueCommand(INBOUND_ENDPOINT__CONSUMER_TYPE, ConsumerType.HIGHLEVEL);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__CONSUMER_TYPE, ConsumerType.SIMPLE);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.CONTENT_TYPE)) {
				if (paramEntry.getValue().equals(APPLICATION_XML)) {
					executeSetValueCommand(INBOUND_ENDPOINT__CONTENT_TYPE, ContentType.XML);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__CONTENT_TYPE, ContentType.JSON);
				}
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.TOPICS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__TOPICS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_TOPIC)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_TOPIC, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_BROKERS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_BROKERS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_PARTITION)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_PARTITION, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.SIMPLE_MAX_MESSAGE_TOREAD)) {
				executeSetValueCommand(INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.THREAD_COUNT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__THREAD_COUNT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_SEESION_TIMEOUT_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ZOOKEEPER_SYNC_TIME_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.AUTO_COMMIY_INTERVAL_MS)) {
				executeSetValueCommand(INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.AUTO_OFFSET_REST)) {
				executeSetValueCommand(INBOUND_ENDPOINT__AUTO_OFFSET_RESET, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_CXF_RM_HOST)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_CXF_RM_PORT)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_CXF_RM_CONFIG_FILE)) {
				executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE, paramEntry.getValue());
			} else if (paramEntry.getKey().equals(InboundEndpointConstants.ENABLE_SSL)) {
				if (paramEntry.getValue().equals(TRUE)) {
					executeSetValueCommand(INBOUND_ENDPOINT__ENABLE_SSL, true);
				} else {
					executeSetValueCommand(INBOUND_ENDPOINT__ENABLE_SSL, false);
				}
			}
		}

	}
}
