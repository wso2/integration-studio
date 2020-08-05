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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.ENABLE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CLASS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CONSUMER_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__COORDINATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__ENABLE_SSL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENTIAL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__STATISTICS_ENABLED;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SUSPEND;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPICS_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPICS_OR_TOPIC_FILTER;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPIC_FILTER_FROM;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPIC_FILTER_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRACE_ENABLED;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_FEED_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_RESET_CONNECTION_ON_POLLING_SUSPENSION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_BROKER_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONSUMER_QOS_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONSUMER_QOS_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_AUTO_DECLARE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DECLARE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_LOCATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_PASSWORD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_LOCATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_PASSWORD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_VERSION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_USE_PORT_OFFSET;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_VFSSFTP_USER_DIR_IS_ROOT;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType;
import org.wso2.developerstudio.eclipse.gmf.esb.Enable;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.FeedType;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSBrokerType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
import org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicsType;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSAction;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort;
import org.wso2.developerstudio.eclipse.gmf.esb.WSClientSideBroadcastLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

public class InboundEndpointDeserializer
        extends AbstractEsbNodeDeserializer<InboundEndpoint, org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint> {

    private enum ParameterKeyValueType {
        KEY, VALUE
    }

    private static final String KEY_TYPE_PARAMETER_PREFIX = "$registry:";
    private static final String POLLING_BEHAVIOUR = "polling";
    private static final String LISTENING_BEHAVIOUR = "listening";
    private static final String EVENT_BASED_BEHAVIOUR = "eventBased";
    private static final String WSO2_MB_TOPIC_CONNECTION_URL = "connectionfactory.TopicConnectionFactory";
    private static final String WSO2_MB__QUEUE_CONNECTION_URL = "connectionfactory.QueueConnectionFactory";

    @Override
    public org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint createNode(IGraphicalEditPart part,
            InboundEndpoint object) throws DeserializerException {

        // Creating a new graphical InboundEndpoint object.
        org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint inboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) DeserializerUtils
                .createNode(part, EsbElementTypes.InboundEndpoint_3767);

        setElementToEdit(inboundEndpoint);
        refreshEditPartMap();
        executeSetValueCommand(INBOUND_ENDPOINT__NAME, object.getName());
        AspectConfiguration aspectConfiguration = object.getAspectConfiguration();
        if (aspectConfiguration != null && object.getAspectConfiguration().isStatisticsEnable()) {
            executeSetValueCommand(INBOUND_ENDPOINT__STATISTICS_ENABLED, new Boolean(true));
        } else {
            executeSetValueCommand(INBOUND_ENDPOINT__STATISTICS_ENABLED, new Boolean(false));
        }
        if (aspectConfiguration != null && object.getAspectConfiguration().isTracingEnabled()) {
            executeSetValueCommand(INBOUND_ENDPOINT__TRACE_ENABLED, new Boolean(true));
        } else {
            executeSetValueCommand(INBOUND_ENDPOINT__TRACE_ENABLED, new Boolean(false));
        }
        if (object.isSuspend()) {
            executeSetValueCommand(INBOUND_ENDPOINT__SUSPEND, true);
        } else {
            executeSetValueCommand(INBOUND_ENDPOINT__SUSPEND, false);
        }

        if (StringUtils.isNotBlank(object.getClassImpl())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CUSTOM);
            executeSetValueCommand(INBOUND_ENDPOINT__CLASS, object.getClassImpl());
            updateParameters(object, InboundEndpointType.CUSTOM);
            updateCustomParameters(object);
        }

        if (InboundEndpointConstants.HTTP.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HTTP);
            updateParameters(object, InboundEndpointType.HTTP);
        } else if (InboundEndpointConstants.FILE.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.FILE);
            updateParameters(object, InboundEndpointType.FILE);
        } else if (InboundEndpointConstants.JMS.equals(object.getProtocol())) {
            // Since both have the protocol as JMS check for mb instance
            boolean isWso2Mb = isWSO2MBInstance(object);
            if (isWso2Mb) {
                executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.WSO2_MB);
                updateParameters(object, InboundEndpointType.WSO2_MB);
            } else {
                executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.JMS);
                updateParameters(object, InboundEndpointType.JMS);
            }
        } else if (InboundEndpointConstants.HTTPS.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HTTPS);
            updateParameters(object, InboundEndpointType.HTTPS);
        } else if (InboundEndpointConstants.HL7.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.HL7);
            updateParameters(object, InboundEndpointType.HL7);
        } else if (InboundEndpointConstants.KAFKA.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.KAFKA);
            updateParameters(object, InboundEndpointType.KAFKA);
        } else if (InboundEndpointConstants.CUSTOM.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CUSTOM);
            updateParameters(object, InboundEndpointType.CUSTOM);
        } else if (InboundEndpointConstants.CXF_WS_RM.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.CXF_WS_RM);
            updateParameters(object, InboundEndpointType.CXF_WS_RM);
        } else if (InboundEndpointConstants.MQTT.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.MQTT);
            updateParameters(object, InboundEndpointType.MQTT);
        } else if (InboundEndpointConstants.RABBITMQ.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.RABBITMQ);
            updateParameters(object, InboundEndpointType.RABBITMQ);
        } else if (InboundEndpointConstants.FEED.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.FEED);
            updateParameters(object, InboundEndpointType.FEED);
        } else if (InboundEndpointConstants.WS.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.WS);
            updateParameters(object, InboundEndpointType.WS);
        } else if (InboundEndpointConstants.WSS.equals(object.getProtocol())) {
            executeSetValueCommand(INBOUND_ENDPOINT__TYPE, InboundEndpointType.WSS);
            updateParameters(object, InboundEndpointType.WSS);
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

        addPairMediatorFlow(inboundEndpoint.getSequenceOutputConnector(), inboundEndpoint.getSequenceInputConnector());
        addPairMediatorFlow(inboundEndpoint.getOnErrorSequenceOutputConnector(),
                inboundEndpoint.getOnErrorSequenceInputConnector());
        return inboundEndpoint;
    }

    /**
     * Gets the WSO2 Mb instance
     * 
     * @param object
     * @return
     */
    private boolean isWSO2MBInstance(InboundEndpoint object) {
        if (object.getParameter(WSO2_MB_TOPIC_CONNECTION_URL) != null) {
            return true;
        } else if (object.getParameter(WSO2_MB__QUEUE_CONNECTION_URL) != null) {
            return true;
        } else {
            return false;
        }
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
     * @param inboundEndpointInstance
     */
    private void updateParameters(InboundEndpoint inboundEndpointInstance, InboundEndpointType inboundEndpointType) {
        for (Map.Entry<String, String> paramEntry : inboundEndpointInstance.getParametersMap().entrySet()) {
            if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS)) {
                if (inboundEndpointInstance.getParameterKey(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS) != null) {
                    addParameterKeyForInboundEndpoint(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS,
                            inboundEndpointInstance.getParameterKey(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS),
                            ParameterKeyValueType.KEY, inboundEndpointType);
                    executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONSUMER_QOS_TYPE,
                            PayloadFormatType.REGISTRY_REFERENCE);
                } else {
                    addParameterForInboundEndpoint(paramEntry, ParameterKeyValueType.VALUE, inboundEndpointType);
                    executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONSUMER_QOS_TYPE,
                            PayloadFormatType.INLINE);
                }
            } else {
                addParameterForInboundEndpoint(paramEntry, ParameterKeyValueType.VALUE, inboundEndpointType);
            }
        }

        // TODO proper fix after synapse release getParameterKeyMap
        for (InboundEndpointParameterType parameter : InboundEndpointParameterType.values()) {
            if (inboundEndpointInstance.getParameterKey(parameter.getName()) != null) {
                addParameterForInboundEndpoint(
                        new ParameterEntry<String, String>(parameter.getName(),
                                inboundEndpointInstance.getParameterKey(parameter.getName())),
                        ParameterKeyValueType.KEY, inboundEndpointType);
            }
        }
    }

    private void addParameterKeyForInboundEndpoint(String paramEntryKey, String paramEntryValue,
            ParameterKeyValueType type, InboundEndpointType inboundEndpointType) {
        if (paramEntryKey.equals(InboundEndpointConstants.RABBITMQ_CONSUMER_QOS)) {
            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONSUMER_QOS_KEY,
                    InboundEndpointType.RABBITMQ_VALUE);
            RegistryKeyProperty consumerQosKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            consumerQosKey.setKeyValue(paramEntryValue);
            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONSUMER_QOS_KEY, consumerQosKey);
        }
    }

    private void addParameterForInboundEndpoint(Map.Entry<String, String> paramEntry, ParameterKeyValueType type,
            InboundEndpointType inboundEndpointType) {
        if (InboundEndpointType.HTTP.equals(inboundEndpointType)) {
            for (HTTPInboundEndpointParameter parameterType : HTTPInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    }
                }
            }
        } else if (InboundEndpointType.FILE.equals(inboundEndpointType)) {
            for (FileInboundEndpointParameter parameterType : FileInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_LOCKING)) {
                        if (paramEntry.getValue().equals(ENABLE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING, Enable.ENABLE);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING, Enable.DISABLE);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_ACTION_AFTER_PROCESS)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.DELETE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS,
                                    VFSAction.DELETE);
                        } else if (paramEntry.getValue().equals(InboundEndpointConstants.VSF_ACTION_NONE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS,
                                    VFSAction.NONE);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS,
                                    VFSAction.MOVE);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_ACTION_AFTER_FAILURE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.DELETE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE,
                                    VFSAction.DELETE);
                        } else if (paramEntry.getValue().equals(InboundEndpointConstants.VSF_ACTION_NONE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE,
                                    VFSAction.NONE);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE,
                                    VFSAction.MOVE);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_AUTO_LOCK_RELEASE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, false);
                        }
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_SFTP_USER_DIR_IS_ROOT)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFSSFTP_USER_DIR_IS_ROOT, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFSSFTP_USER_DIR_IS_ROOT, false);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_FILESORT_ATTRIBUTE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.NONE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE,
                                    VFSFileSort.NONE);
                        } else if (paramEntry.getValue().equals(InboundEndpointConstants.NAME)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE,
                                    VFSFileSort.NAME);
                        } else if (paramEntry.getValue().equals(InboundEndpointConstants.SIZE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE,
                                    VFSFileSort.SIZE);
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_CREATE_FOLDER)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, false);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_STREAMING)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, false);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.VFS_BUILD)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD, false);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.JMS.equals(inboundEndpointType)) {
            for (JMSInboundEndpointParameter parameterType : JMSInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            
                            // The following checks are to persist the values set under different broker types
                            if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL)) {
                                if (paramEntry.getValue().toLowerCase().contains(InboundEndpointConstants.JMS_BROKER_TYPE_IDENTIFIER_ACTIVEMQ)) {
                                    executeSetValueCommand(
                                            INBOUND_ENDPOINT__TRANSPORT_JMS_BROKER_TYPE, JMSBrokerType.ACTIVE_MQ);
                                }
                            }
                            
                            if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL)) {
                                if (paramEntry.getValue().toLowerCase().contains(InboundEndpointConstants.JMS_BROKER_TYPE_IDENTIFIER_WSO2MB)) {
                                    executeSetValueCommand(
                                            INBOUND_ENDPOINT__TRANSPORT_JMS_BROKER_TYPE, JMSBrokerType.WSO2_BROKER_PROFILE);
                                }
                            }
                            
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TOPIC)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
                                    JMSConnectionFactoryType.TOPIC);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
                                    JMSConnectionFactoryType.QUEUE);
                        }
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SHARED_SUBSCRIPTION)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION, false);
                        }
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.JMS_RESET_CONNECTION_ON_POLLING_SUSPENSION)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(
                                    INBOUND_ENDPOINT__TRANSPORT_JMS_RESET_CONNECTION_ON_POLLING_SUSPENSION, true);
                        } else {
                            executeSetValueCommand(
                                    INBOUND_ENDPOINT__TRANSPORT_JMS_RESET_CONNECTION_ON_POLLING_SUSPENSION, false);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.WSO2_MB.equals(inboundEndpointType)) {
            for (WSO2MBInboundEndpointParameter parameterType : WSO2MBInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TOPIC)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
                                    JMSConnectionFactoryType.TOPIC);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
                                    JMSConnectionFactoryType.QUEUE);
                        }
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.JMS_SHARED_SUBSCRIPTION)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION, false);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.CUSTOM.equals(inboundEndpointType)) {
            for (CustomInboundEndpointParameter parameterType : CustomInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_BEHAVIOUR)) {
                        if (paramEntry.getValue().equals(POLLING_BEHAVIOUR)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR,
                                    InboundEndpointBehaviourType.POLLING_INBOUND_ENDPOINT);
                        } else if (paramEntry.getValue().equals(LISTENING_BEHAVIOUR)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR,
                                    InboundEndpointBehaviourType.LISTENING_INBOUND_ENDPOINT);
                        } else if (paramEntry.getValue().equals(EVENT_BASED_BEHAVIOUR)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR,
                                    InboundEndpointBehaviourType.EVENT_BASED_INBOUND_ENDPOINT);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    }
                }
            }
        } else if (InboundEndpointType.HTTPS.equals(inboundEndpointType)) {
            for (HTTPSInboundEndpointParameter parameterType : HTTPSInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    }
                }
            }
        } else if (InboundEndpointType.HL7.equals(inboundEndpointType)) {
            for (HL7InboundEndpointParameter parameterType : HL7InboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_AUTOACK)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK, false);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_HL7_VALIDATE_MESSAGE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE, false);
                        }
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.INBOUND_HL7_BUILD_INVALID_MESSAGES)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES, false);
                        }
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES, false);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.KAFKA.equals(inboundEndpointType)) {
            for (KAFKAInboundEndpointParameter parameterType : KAFKAInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.FILTER_FROM_WHITELIST)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TOPIC_FILTER_FROM,
                                TopicFilterFromType.FILTER_FROM_WHITELIST);
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.FILTER_FROM_BLACKLIST)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TOPIC_FILTER_FROM,
                                TopicFilterFromType.FILTER_FROM_BLACKLIST);
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    }
                }
            }
        } else if (InboundEndpointType.MQTT.equals(inboundEndpointType)) {
            for (MQTTInboundEndpointParameter parameterType : MQTTInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_QOS)) {
                        if (paramEntry.getValue().equals("0")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS,
                                    MQTTSubscriptionQOS.ZERO);
                        } else if (paramEntry.getValue().equals("1")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS,
                                    MQTTSubscriptionQOS.ONE);
                        } else if (paramEntry.getValue().equals("2")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS,
                                    MQTTSubscriptionQOS.TWO);
                        }
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_LOCATION)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_LOCATION,
                                paramEntry.getValue());
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_TYPE)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_TYPE,
                                paramEntry.getValue());
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_PASSWORD)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_PASSWORD,
                                paramEntry.getValue());
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_LOCATION)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_LOCATION,
                                paramEntry.getValue());
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_TYPE)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_TYPE,
                                paramEntry.getValue());
                    } else if (paramEntry.getKey()
                            .equals(InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_PASSWORD)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_PASSWORD,
                                paramEntry.getValue());
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_MQTT_SSL_VERSION)) {
                        executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_VERSION, paramEntry.getValue());
                    }
                }
            }
        } else if (InboundEndpointType.RABBITMQ.equals(inboundEndpointType)) {
            for (RABBITMQInboundEndpointParameter parameterType : RABBITMQInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.SEQUENTIAL)) {
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
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_QUEUE_AUTODECLARE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.FALSE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_AUTO_DECLARE, false);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_AUTO_DECLARE, true);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.RABBITMQ_EXCHANGE_AUTODECLARE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.FALSE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DECLARE, false);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DECLARE, true);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.FEED.equals(inboundEndpointType)) {
            for (FEEDInboundEndpointParameter parameterType : FEEDInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.INBOUND_FEED_TYPE)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.ATOM)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_FEED_TYPE, FeedType.ATOM);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__TRANSPORT_FEED_TYPE, FeedType.RSS);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.CXF_WS_RM.equals(inboundEndpointType)) {
            for (CXFWSRMInboundEndpointParameter parameterType : CXFWSRMInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.ENABLE_SSL)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__ENABLE_SSL, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__ENABLE_SSL, false);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.WS.equals(inboundEndpointType)) {
            for (WSInboundEndpointParameter parameterType : WSInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.WS_CLIENT_SIDE_BROADCAST_LEVEL)) {
                        if (paramEntry.getValue().equals("0")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                                    WSClientSideBroadcastLevel.ZERO);
                        } else if (paramEntry.getValue().equals("1")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                                    WSClientSideBroadcastLevel.ONE);
                        } else if (paramEntry.getValue().equals("2")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                                    WSClientSideBroadcastLevel.TWO);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.WS_USE_PORT_OFFSET)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_USE_PORT_OFFSET, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_USE_PORT_OFFSET, false);
                        }
                    }
                }
            }
        } else if (InboundEndpointType.WSS.equals(inboundEndpointType)) {
            for (WSSInboundEndpointParameter parameterType : WSSInboundEndpointParameter.values()) {
                if (parameterType.isMatchedWithParameterName(paramEntry.getKey())) {
                    if (parameterType.canHoldKeyValue()) {
                        if (ParameterKeyValueType.VALUE.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(), paramEntry.getValue());
                        } else if (ParameterKeyValueType.KEY.equals(type)) {
                            executeSetValueCommand(parameterType.getEAttributeValue(),
                                    KEY_TYPE_PARAMETER_PREFIX + paramEntry.getValue());
                        } else {
                            throw new UnsupportedOperationException(
                                    "Operation for ParameterKeyValueType " + type + " is not supported");
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.WS_CLIENT_SIDE_BROADCAST_LEVEL)) {
                        if (paramEntry.getValue().equals("0")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                                    WSClientSideBroadcastLevel.ZERO);
                        } else if (paramEntry.getValue().equals("1")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                                    WSClientSideBroadcastLevel.ONE);
                        } else if (paramEntry.getValue().equals("2")) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                                    WSClientSideBroadcastLevel.TWO);
                        }
                    } else if (paramEntry.getKey().equals(InboundEndpointConstants.WS_USE_PORT_OFFSET)) {
                        if (paramEntry.getValue().equals(InboundEndpointConstants.TRUE)) {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_USE_PORT_OFFSET, true);
                        } else {
                            executeSetValueCommand(INBOUND_ENDPOINT__WS_USE_PORT_OFFSET, false);
                        }
                    }
                }
            }
        }
    }

    final class ParameterEntry<key, value> implements Map.Entry<String, String> {
        private final String key;
        private String value;

        public ParameterEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            String old = this.value;
            this.value = value;
            return old;
        }

    }

}
