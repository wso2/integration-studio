/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__CRON_EXPRESSION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__ENDPOINT_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__FORWARDING_INTERVAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__MAX_STORE_CONNECTION_ATTEMPTS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__STORE_CONNECTION_INTERVAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__FAIL_MESSAGES_STORE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__MESSAGE_STORE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_STATE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__RETRY_INTERVAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__SAMPLING_INTERVAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__SEQUENCE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_PROCESSOR__TASK_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.message.processor.MessageProcessor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnableDisableState;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessorType;
import org.wso2.integrationstudio.eclipse.gmf.esb.ProcessorState;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageProcessor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.MessageProcessorFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.processors.CustomProcessor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.processors.Sampling;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.processors.ScheduledFailoverForwarding;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.processors.ScheduledForwarding;

/**
 * Deserializes a message-processor configuration to a graphical message
 * processor object
 */
public class MessageProcessorDeserializer extends
        AbstractEsbNodeDeserializer<MessageProcessor, org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessor> {

    // Fixing TOOLS-2026.
    // private static final String scheduledMessageForwardingProcessorOld =
    // "org.apache.synapse.message.processors.forward.ScheduledMessageForwardingProcessor";
    // private static final String messageSamplingProcessorOld =
    // "org.apache.synapse.message.processors.sampler.SamplingProcessor";
    private static final String scheduledMessageForwardingProcessor = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";
    private static final String messageSamplingProcessor = "org.apache.synapse.message.processor.impl.sampler.SamplingProcessor";
    private static final String scheduledFailoverMessageForwardingProcessor = "org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor";
    private static final String customProcessor = "customProcessor";

    @Deprecated
    @Override
    public org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessor createNode(IGraphicalEditPart part,
            MessageProcessor processor) {
        org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessor messageProcessor = (org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessor) DeserializerUtils
                .createNode(part, EsbElementTypes.MessageProcessor_3701);
        setElementToEdit(messageProcessor);

        if (processor instanceof DummyMessageProcessor) {
            DummyMessageProcessor dummyMessageProcessor = (DummyMessageProcessor) processor;
            if (StringUtils.isNotBlank(dummyMessageProcessor.getClassName())) {
                if (dummyMessageProcessor.getClassName().equals(scheduledMessageForwardingProcessor)) {
                    // Scheduled Message Forwarding Processor
                    executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_TYPE,
                            MessageProcessorType.SCHEDULED_MSG_FORWARDING);
                    Map<String, Object> parameters = dummyMessageProcessor.getParameters();
                    Set<String> keySet = parameters.keySet();

                    // Endpoint name.
                    if (StringUtils.isNotBlank(processor.getTargetEndpoint())) {
                        RegistryKeyProperty endpointName = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                        endpointName.setKeyValue(processor.getTargetEndpoint());
                        executeSetValueCommand(MESSAGE_PROCESSOR__ENDPOINT_NAME, endpointName);
                    }

                    // Parameters.
                    if (parameters.containsKey("client.retry.interval")) {
                        Object value = parameters.get("client.retry.interval");
                        if (value != null && StringUtils.isNumeric(value.toString())) {

                            executeSetValueCommand(MESSAGE_PROCESSOR__RETRY_INTERVAL, new Long(value.toString()));
                        }
                        keySet.remove("client.retry.interval");
                    }
                    if (parameters.containsKey("interval")) {
                        Object value = parameters.get("interval");
                        if (value != null && StringUtils.isNumeric(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__FORWARDING_INTERVAL, new Long(value.toString()));

                        }
                        keySet.remove("interval");
                    }
                    if (parameters.containsKey("max.delivery.attempts")) {
                        Object value = parameters.get("max.delivery.attempts");
                        if (value != null) {
                            try {
                                executeSetValueCommand(MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS,
                                        new Integer(value.toString()));
                            } catch (NumberFormatException e) {
                                // set default value -1
                                executeSetValueCommand(MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS, -1);
                            }
                        }
                        keySet.remove("max.delivery.attempts");
                    }
                    if (parameters.containsKey("max.store.connection.attempts")) {
                        Object value = parameters.get("max.store.connection.attempts");
                        if (value != null) {
                            try {
                                executeSetValueCommand(MESSAGE_PROCESSOR__MAX_STORE_CONNECTION_ATTEMPTS,
                                        new Integer(value.toString()));
                            } catch (NumberFormatException e) {
                                // set default value -1
                                executeSetValueCommand(MESSAGE_PROCESSOR__MAX_STORE_CONNECTION_ATTEMPTS, -1);
                            }
                        }
                        keySet.remove("max.store.connection.attempts");
                    }
                    if (parameters.containsKey("store.connection.retry.interval")) {
                        Object value = parameters.get("store.connection.retry.interval");
                        if (value != null) {
                            try {
                                executeSetValueCommand(MESSAGE_PROCESSOR__STORE_CONNECTION_INTERVAL,
                                        new Integer(value.toString()));
                            } catch (NumberFormatException e) {
                                // set default value -1
                                executeSetValueCommand(MESSAGE_PROCESSOR__STORE_CONNECTION_INTERVAL, -1);
                            }
                        }
                        keySet.remove("store.connection.retry.interval");
                    }
                    if (parameters.containsKey("axis2.repo")) {
                        Object value = parameters.get("axis2.repo");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY, value.toString());

                        }
                        keySet.remove("axis2.repo");
                    }
                    if (parameters.containsKey("axis2.config")) {
                        Object value = parameters.get("axis2.config");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__AXIS2_CONFIGURATION, value.toString());
                        }
                        keySet.remove("axis2.config");
                    }
                    if (parameters.containsKey("message.processor.reply.sequence")) {
                        Object value = parameters.get("message.processor.reply.sequence");
                        if (StringUtils.isNotBlank(value.toString())) {
                            RegistryKeyProperty replaySequence = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                            replaySequence.setKeyValue(value.toString());
                            executeSetValueCommand(MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME, replaySequence);
                        }
                        keySet.remove("message.processor.reply.sequence");
                    }
                    if (parameters.containsKey("message.processor.fault.sequence")) {
                        Object value = parameters.get("message.processor.fault.sequence");
                        if (StringUtils.isNotBlank(value.toString())) {
                            RegistryKeyProperty faultSequence = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                            faultSequence.setKeyValue(value.toString());
                            executeSetValueCommand(MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME, faultSequence);

                        }
                        keySet.remove("message.processor.fault.sequence");

                    }
                    if (parameters.containsKey("message.processor.deactivate.sequence")) {
                        Object value = parameters.get("message.processor.deactivate.sequence");
                        if (StringUtils.isNotBlank(value.toString())) {
                            RegistryKeyProperty deactivateSequence = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                            deactivateSequence.setKeyValue(value.toString());
                            executeSetValueCommand(MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME, deactivateSequence);

                        }
                        keySet.remove("message.processor.deactivate.sequence");
                    }
                    if (parameters.containsKey("message.processor.failMessagesStore")) {
                        Object value = parameters.get("message.processor.failMessagesStore");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__FAIL_MESSAGES_STORE, value.toString());

                        }
                        keySet.remove("message.processor.failMessagesStore");

                    }
                    if (parameters.containsKey("quartz.conf")) {
                        Object value = parameters.get("quartz.conf");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH, value.toString());

                        }
                        keySet.remove("quartz.conf");
                    }
                    if (parameters.containsKey("cronExpression")) {
                        Object value = parameters.get("cronExpression");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__CRON_EXPRESSION, value.toString());

                        }
                        keySet.remove("cronExpression");
                    }
                    if (parameters.containsKey("is.active")) {
                        Object value = parameters.get("is.active");
                        if (StringUtils.isNotBlank(value.toString())) {
                            if ("true".equals(value)) {
                                executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_STATE, ProcessorState.ACTIVATE);
                            } else {
                                executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_STATE, ProcessorState.DEACTIVATE);
                            }

                        }
                        keySet.remove("is.active");
                    }
                    if (parameters.containsKey("non.retry.status.codes")) {
                        Object value = parameters.get("non.retry.status.codes");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES, value.toString());

                        }
                        keySet.remove("non.retry.status.codes");
                    }
                    if (parameters.containsKey("max.delivery.drop")) {
                        Object value = parameters.get("max.delivery.drop");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
                                    value.toString());
                            if ("Enabled".equals(value)) {
                                executeSetValueCommand(MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
                                        EnableDisableState.ENABLED);
                            } else {
                                executeSetValueCommand(MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
                                        EnableDisableState.DISABLED);
                            }

                        }
                        keySet.remove("max.delivery.drop");
                    }
                    if (parameters.containsKey("member.count")) {
                        Object value = parameters.get("member.count");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__TASK_COUNT, value.toString());

                        }
                        keySet.remove("member.count");
                    }

                    // Adding custom parameters
                    for (String parameter : keySet) {
                        MessageProcessorParameter processorParameter = EsbFactory.eINSTANCE
                                .createMessageProcessorParameter();
                        processorParameter.setParameterName(parameter);
                        processorParameter.setParameterValue(parameters.get(parameter).toString());
                        executeAddValueCommand(messageProcessor.getParameters(), processorParameter, false);
                    }

                } else if (dummyMessageProcessor.getClassName().equals(
                        "org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor")) {
                    // Scheduled Fail over Message Forwarding Processor
                    executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_TYPE,
                            MessageProcessorType.SCHEDULED_FAILOVER_MSG_FORWARDING);
                    Map<String, Object> parameters = dummyMessageProcessor.getParameters();
                    Set<String> keySet = parameters.keySet();
                    // Parameters.
                    if (parameters.containsKey("client.retry.interval")) {
                        Object value = parameters.get("client.retry.interval");
                        if (value != null && StringUtils.isNumeric(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__RETRY_INTERVAL, new Long(value.toString()));

                        }
                        keySet.remove("client.retry.interval");
                    }
                    if (parameters.containsKey("interval")) {
                        Object value = parameters.get("interval");
                        if (value != null && StringUtils.isNumeric(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__FORWARDING_INTERVAL, new Long(value.toString()));

                        }
                        keySet.remove("interval");
                    }
                    if (parameters.containsKey("max.delivery.attempts")) {
                        Object value = parameters.get("max.delivery.attempts");
                        if (value != null) {
                            try {
                                executeSetValueCommand(MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS,
                                        new Integer(value.toString()));
                            } catch (NumberFormatException e) {
                                // set default value -1
                                executeSetValueCommand(MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS, -1);
                            }
                        }
                        keySet.remove("max.delivery.attempts");
                    }
                    if (parameters.containsKey("message.processor.fault.sequence")) {
                        Object value = parameters.get("message.processor.fault.sequence");
                        if (StringUtils.isNotBlank(value.toString())) {
                            RegistryKeyProperty faultSequence = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                            faultSequence.setKeyValue(value.toString());
                            executeSetValueCommand(MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME, faultSequence);
                        }
                        keySet.remove("message.processor.fault.sequence");
                    }
                    if (parameters.containsKey("message.processor.deactivate.sequence")) {
                        Object value = parameters.get("message.processor.deactivate.sequence");
                        if (StringUtils.isNotBlank(value.toString())) {
                            RegistryKeyProperty deactivateSequence = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                            deactivateSequence.setKeyValue(value.toString());
                            executeSetValueCommand(MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME, deactivateSequence);
                        }
                        keySet.remove("message.processor.deactivate.sequence");
                    }
                    if (parameters.containsKey("quartz.conf")) {
                        Object value = parameters.get("quartz.conf");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH, value.toString());
                        }
                        keySet.remove("quartz.conf");
                    }
                    if (parameters.containsKey("cronExpression")) {
                        Object value = parameters.get("cronExpression");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__CRON_EXPRESSION, value.toString());
                        }
                        keySet.remove("cronExpression");
                    }
                    if (parameters.containsKey("is.active")) {
                        Object value = parameters.get("is.active");
                        if (StringUtils.isNotBlank(value.toString())) {
                            if ("true".equals(value)) {
                                executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_STATE, ProcessorState.ACTIVATE);
                            } else {
                                executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_STATE, ProcessorState.DEACTIVATE);
                            }
                        }
                        keySet.remove("is.active");
                    }
                    if (parameters.containsKey("max.delivery.drop")) {
                        Object value = parameters.get("max.delivery.drop");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
                                    value.toString());
                            if ("Enabled".equals(value)) {
                                executeSetValueCommand(MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
                                        EnableDisableState.ENABLED);
                            } else {
                                executeSetValueCommand(MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS,
                                        EnableDisableState.DISABLED);
                            }
                        }
                        keySet.remove("max.delivery.drop");
                    }
                    if (parameters.containsKey("member.count")) {
                        Object value = parameters.get("member.count");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__TASK_COUNT, value.toString());
                        }
                        keySet.remove("member.count");
                    }
                    if (parameters.containsKey("message.target.store.name")) {
                        Object value = parameters.get("message.target.store.name");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE, value.toString());
                        }
                        keySet.remove("message.target.store.name");
                    }
                    // Adding custom parameters
                    for (String parameter : keySet) {
                        MessageProcessorParameter processorParameter = EsbFactory.eINSTANCE
                                .createMessageProcessorParameter();
                        processorParameter.setParameterName(parameter);
                        processorParameter.setParameterValue(parameters.get(parameter).toString());
                        executeAddValueCommand(messageProcessor.getParameters(), processorParameter, false);
                    }

                } else if (dummyMessageProcessor.getClassName().equals(messageSamplingProcessor)
                // || dummyMessageProcessor.getClassName().equals(
                // messageSamplingProcessorOld)
                ) {
                    // Message Sampling Processor
                    executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_TYPE, MessageProcessorType.MSG_SAMPLING);
                    Map<String, Object> parameters = dummyMessageProcessor.getParameters();
                    Set<String> keySet = parameters.keySet();

                    if (parameters.containsKey("sequence")) {
                        Object value = parameters.get("sequence");
                        if (StringUtils.isNotBlank(value.toString())) {
                            RegistryKeyProperty sequence = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                            sequence.setKeyValue(value.toString());
                            executeSetValueCommand(MESSAGE_PROCESSOR__SEQUENCE, sequence);
                        }
                        keySet.remove("sequence");
                    }
                    if (parameters.containsKey("interval")) {
                        Object value = parameters.get("interval");
                        if (value != null && StringUtils.isNumeric(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__SAMPLING_INTERVAL, new Long(value.toString()));
                        }
                        keySet.remove("interval");
                    }
                    if (parameters.containsKey("concurrency")) {
                        Object value = parameters.get("concurrency");
                        if (value != null && StringUtils.isNumeric(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY,
                                    new Integer(value.toString()));
                        }
                        keySet.remove("concurrency");
                    }
                    if (parameters.containsKey("quartz.conf")) {
                        Object value = parameters.get("quartz.conf");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH, value.toString());
                        }
                        keySet.remove("quartz.conf");
                    }
                    if (parameters.containsKey("cronExpression")) {
                        Object value = parameters.get("cronExpression");
                        if (StringUtils.isNotBlank(value.toString())) {
                            executeSetValueCommand(MESSAGE_PROCESSOR__CRON_EXPRESSION, value.toString());
                        }
                        keySet.remove("cronExpression");
                    }
                    if (parameters.containsKey("is.active")) {
                        Object value = parameters.get("is.active");
                        if (StringUtils.isNotBlank(value.toString())) {
                            if ("true".equals(value)) {
                                executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_STATE, ProcessorState.ACTIVATE);
                            } else {
                                executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_STATE, ProcessorState.DEACTIVATE);
                            }
                        }
                        keySet.remove("is.active");
                    }

                    // Adding custom parameters
                    for (String parameter : keySet) {
                        MessageProcessorParameter processorParameter = EsbFactory.eINSTANCE
                                .createMessageProcessorParameter();
                        processorParameter.setParameterName(parameter);
                        processorParameter.setParameterValue(parameters.get(parameter).toString());
                        executeAddValueCommand(messageProcessor.getParameters(), processorParameter, false);
                    }

                } else {
                    // Custom Message Processor
                    executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_TYPE, MessageProcessorType.CUSTOM);
                    executeSetValueCommand(MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER,
                            dummyMessageProcessor.getClassName());

                    for (Entry<String, Object> parameter : dummyMessageProcessor.getParameters().entrySet()) {
                        MessageProcessorParameter processorParameter = EsbFactory.eINSTANCE
                                .createMessageProcessorParameter();
                        processorParameter.setParameterName(parameter.getKey());
                        processorParameter.setParameterValue(parameter.getValue().toString());
                        executeAddValueCommand(messageProcessor.getParameters(), processorParameter, false);
                    }
                }
            }
        }

        executeSetValueCommand(MESSAGE_PROCESSOR__PROCESSOR_NAME, processor.getName());
        executeSetValueCommand(MESSAGE_PROCESSOR__MESSAGE_STORE, processor.getMessageStoreName());
        executeSetValueCommand(MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE, processor.getMessageStoreName());

        return messageProcessor;
    }

    @Override
    public void createNode(FormEditor formEditor, MessageProcessor processor) {
        ESBFormEditor messageProcessorFormEditor = (ESBFormEditor) formEditor;
        MessageProcessorFormPage messageProcessorPage = (MessageProcessorFormPage) messageProcessorFormEditor
                .getFormPageForArtifact(ArtifactType.MESSAGE_PROCESSOR);
        org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessor messageProcessor = EsbFactoryImpl.eINSTANCE
                .createMessageProcessor();

        messageProcessor.setProcessorName(processor.getName());
        messageProcessor.setDescription(processor.getDescription());
        messageProcessor.setMessageStore(processor.getMessageStoreName());

        messageProcessorPage.setEsbNode(messageProcessor);

        DummyMessageProcessor dummyMessageProcessor = (DummyMessageProcessor) processor;

        if (dummyMessageProcessor.getName() != null) {
            messageProcessorPage.processorName.setText(dummyMessageProcessor.getName());
        }
        messageProcessorPage.storeName.setText(dummyMessageProcessor.getMessageStoreName());

        if (dummyMessageProcessor.getClassName().equalsIgnoreCase(messageSamplingProcessor)) {
            messageProcessorPage.processorType.select(0);

            Map<String, Object> parameters = dummyMessageProcessor.getParameters();
            Set<String> keySet = parameters.keySet();

            Sampling sampling = (Sampling) messageProcessorPage.getProcessorImpl(messageSamplingProcessor);

            setTextValue(sampling.sampling_sequence, processor.getParameters().get("sequence"));
            keySet.remove("sequence");
            setTextValue(sampling.sampling_interval, processor.getParameters().get("interval"));
            keySet.remove("interval");
            setTextValue(sampling.sampling_concurrency, processor.getParameters().get("concurrency"));
            keySet.remove("concurrency");
            setTextValue(sampling.sampling_quartzConfigFilePath, processor.getParameters().get("quartz.conf"));
            keySet.remove("quartz.conf");
            setTextValue(sampling.sampling_cronExpression, processor.getParameters().get("cronExpression"));
            keySet.remove("cronExpression");

            // non-textbox items
            if (processor.getParameters().get("is.active") != null
                    && processor.getParameters().get("is.active").toString().equalsIgnoreCase("true")) {
                sampling.sampling_state.select(0);
            } else {
                sampling.sampling_state.select(1);
            }
            keySet.remove("is.active");

            if (keySet.size() > 0) {
                List<MessageProcessorParameter> existingProperties = sampling.messageProcessorParameterList;
                sampling.messageProcessorParameterList = (getMessageProcessorProperties(keySet, parameters,
                        existingProperties));
            } else {
                // When removing all properties from the source view then clear the list
                sampling.messageProcessorParameterList = null;
            }

        } else if (dummyMessageProcessor.getClassName().equalsIgnoreCase(scheduledMessageForwardingProcessor)) {
            messageProcessorPage.processorType.select(1);
            Map<String, Object> parameters = dummyMessageProcessor.getParameters();
            Set<String> keySet = parameters.keySet();

            ScheduledForwarding forwarder = (ScheduledForwarding) messageProcessorPage
                    .getProcessorImpl(scheduledMessageForwardingProcessor);

            setTextValue(forwarder.forwarding_endpoint, processor.getTargetEndpoint());
            setTextValue(forwarder.forwarding_interval, processor.getParameters().get("interval"));
            keySet.remove("interval");
            setTextValue(forwarder.forwarding_retryInterval, processor.getParameters().get("client.retry.interval"));
            keySet.remove("client.retry.interval");
            setTextValue(forwarder.forwarding_nonRetryHttpCodes,
                    processor.getParameters().get("non.retry.status.codes"));
            keySet.remove("non.retry.status.codes");
            setTextValue(forwarder.forwarding_maxDeliveryAttempts,
                    processor.getParameters().get("max.delivery.attempts"));
            keySet.remove("max.delivery.attempts");
            setTextValue(forwarder.forwarding_maxStoreConnectionAttempts,
                    processor.getParameters().get("max.store.connection.attempts"));
            keySet.remove("max.store.connection.attempts");
            setTextValue(forwarder.forwarding_storeConnectionAttemptInterval,
                    processor.getParameters().get("store.connection.retry.interval"));
            keySet.remove("store.connection.retry.interval");
            setTextValue(forwarder.forwarding_axis2ClientRepo, processor.getParameters().get("axis2.repo"));
            keySet.remove("axis2.repo");
            setTextValue(forwarder.forwarding_axis2Config, processor.getParameters().get("axis2.config"));
            keySet.remove("axis2.config");
            setTextValue(forwarder.forwarding_replySequence,
                    processor.getParameters().get("message.processor.reply.sequence"));
            keySet.remove("message.processor.reply.sequence");
            setTextValue(forwarder.forwarding_faultSequence,
                    processor.getParameters().get("message.processor.fault.sequence"));
            keySet.remove("message.processor.fault.sequence");
            setTextValue(forwarder.forwarding_deactiveSequence,
                    processor.getParameters().get("message.processor.deactivate.sequence"));
            keySet.remove("message.processor.deactivate.sequence");
            setTextValue(forwarder.forwarding_failMessagesStore,
                    processor.getParameters().get("message.processor.failMessagesStore"));
            keySet.remove("message.processor.failMessagesStore");
            setTextValue(forwarder.forwarding_quartzConfigFilePath, processor.getParameters().get("quartz.conf"));
            keySet.remove("quartz.conf");
            setTextValue(forwarder.forwarding_cronExpression, processor.getParameters().get("cronExpression"));
            keySet.remove("cronExpression");
            setTextValue(forwarder.forwarding_taskCount, processor.getParameters().get("member.count"));
            keySet.remove("member.count");

            // non-textbox items
            if (processor.getParameters().get("is.active") != null
                    && processor.getParameters().get("is.active").toString().equalsIgnoreCase("true")) {
                forwarder.forwarding_state.select(0);
            } else {
                forwarder.forwarding_state.select(1);
            }
            keySet.remove("is.active");

            if (processor.getParameters().get("max.delivery.drop") != null
                    && processor.getParameters().get("max.delivery.drop").toString().equalsIgnoreCase("Enabled")) {
                forwarder.forwarding_dropMessageAfterMaxDeliveryAttempts.select(0);
            } else {
                forwarder.forwarding_dropMessageAfterMaxDeliveryAttempts.select(1);
            }
            keySet.remove("max.delivery.drop");

            if (keySet.size() > 0) {
                List<MessageProcessorParameter> existingProperties = forwarder.messageProcessorParameterList;
                forwarder.messageProcessorParameterList = (getMessageProcessorProperties(keySet, parameters,
                        existingProperties));
            } else {
                // When removing all properties from the source view then clear the list
                forwarder.messageProcessorParameterList = null;
            }

        } else if (dummyMessageProcessor.getClassName().equalsIgnoreCase(scheduledFailoverMessageForwardingProcessor)) {
            messageProcessorPage.processorType.select(2);

            Map<String, Object> parameters = dummyMessageProcessor.getParameters();
            Set<String> keySet = parameters.keySet();

            ScheduledFailoverForwarding failover = (ScheduledFailoverForwarding) messageProcessorPage
                    .getProcessorImpl(scheduledFailoverMessageForwardingProcessor);

            setTextValue(failover.failover_store, processor.getParameters().get("store.failover.message.store.name"));
            keySet.remove("store.failover.message.store.name");
            setTextValue(failover.failover_interval, processor.getParameters().get("interval"));
            keySet.remove("interval");
            setTextValue(failover.failover_retryInterval, processor.getParameters().get("client.retry.interval"));
            keySet.remove("client.retry.interval");
            setTextValue(failover.failover_maxDeliveryAttempts, processor.getParameters().get("max.delivery.attempts"));
            keySet.remove("max.delivery.attempts");
            setTextValue(failover.failover_faultSequence,
                    processor.getParameters().get("message.processor.fault.sequence"));
            keySet.remove("message.processor.fault.sequence");
            setTextValue(failover.failover_deactiveSequence,
                    processor.getParameters().get("message.processor.deactivate.sequence"));
            keySet.remove("message.processor.deactivate.sequence");
            setTextValue(failover.failover_quartzConfigFilePath, processor.getParameters().get("quartz.conf"));
            keySet.remove("quartz.conf");
            setTextValue(failover.failover_cronExpression, processor.getParameters().get("cronExpression"));
            keySet.remove("cronExpression");
            setTextValue(failover.failover_taskCount, processor.getParameters().get("member.count"));
            keySet.remove("member.count");

            // non-textbox items
            if (processor.getParameters().get("is.active") != null
                    && processor.getParameters().get("is.active").toString().equalsIgnoreCase("true")) {
                failover.failover_state.select(0);
            } else {
                failover.failover_state.select(1);
            }
            keySet.remove("is.active");

            failover.failover_dropMessageAfterMaxDeliveryAttempts
                    .setText((String) processor.getParameters().get("max.delivery.drop"));

            if (processor.getParameters().get("max.delivery.drop") != null
                    && processor.getParameters().get("max.delivery.drop").toString().equalsIgnoreCase("Enabled")) {
                failover.failover_dropMessageAfterMaxDeliveryAttempts.select(0);
            } else {
                failover.failover_dropMessageAfterMaxDeliveryAttempts.select(1);
            }
            keySet.remove("max.delivery.drop");

            if (keySet.size() > 0) {
                List<MessageProcessorParameter> existingProperties = failover.messageProcessorParameterList;
                failover.messageProcessorParameterList = getMessageProcessorProperties(keySet, parameters,
                        existingProperties);
            } else {
                // When removing all properties from the source view then clear the list
                failover.messageProcessorParameterList = null;
            }

        } else {
            messageProcessorPage.processorType.select(3);

            Map<String, Object> parameters = dummyMessageProcessor.getParameters();
            Set<String> keySet = parameters.keySet();

            CustomProcessor custom = (CustomProcessor) messageProcessorPage.getProcessorImpl(customProcessor);

            custom.custom_providerClass.setText((String) dummyMessageProcessor.getClassName());

            if (!dummyMessageProcessor.getParameters().entrySet().isEmpty()) {
                List<MessageProcessorParameter> existingProperties = custom.messageProcessorParameterList;
                custom.messageProcessorParameterList = getMessageProcessorProperties(keySet, parameters,
                        existingProperties);
            } else {
                // When removing all properties from the source view then clear the list
                custom.messageProcessorParameterList = null;
            }

        }

        // Refresh settings of the message processor
        messageProcessorPage.refreshProcessorSettings();

    }

    /**
     * Sets the properties
     * 
     * @param dummyMessageProcessor
     * @param existingProperties2
     */
    private List<MessageProcessorParameter> getMessageProcessorProperties(Set<String> keySet,
            Map<String, Object> parameters, List<MessageProcessorParameter> existingProperties) {

        List<MessageProcessorParameter> newlyAddedProperties = new ArrayList<MessageProcessorParameter>();
        List<MessageProcessorParameter> removedProperties = new ArrayList<MessageProcessorParameter>();
        List<MessageProcessorParameter> newProperties = new ArrayList<MessageProcessorParameter>();

        for (String param : keySet) {
            MessageProcessorParameter parameter = EsbFactory.eINSTANCE.createMessageProcessorParameter();
            parameter.setParameterName(param);
            parameter.setParameterValue(parameters.get(param).toString());

            if (existingProperties != null) {
                for (MessageProcessorParameter propertyItem : existingProperties) {
                    // When updating the existing properties from source view, then remove the property
                    // from old list and add to new list
                    if (propertyItem.getParameterName().equals(param)) {
                        existingProperties.remove(propertyItem);
                        newlyAddedProperties.add(parameter);
                        break;
                    }
                }
            }
            // When adding a new property from source then add it to the new list
            if (!newlyAddedProperties.contains(parameter)) {
                newlyAddedProperties.add(parameter);
            }
        }

        // If old properties contain any property values, then remove the value and add the property to the
        // new
        // list, DEVTOOLESB-505
        if (existingProperties != null) {
            for (MessageProcessorParameter prop : existingProperties) {
                String value = prop.getParameterName();
                String name = prop.getParameterName();
                if (StringUtils.isNotEmpty(value)) {
                    // Add the property to removed list
                    removedProperties.add(prop);
                    /*
                     * MessageProcessorParameter newPrp = createProperty(name);
                     * if (!newlyAddedProperties.contains(newPrp)) {
                     * // Add to the new properties list
                     * newProperties.add(newPrp);
                     * }
                     */
                }
            }
        }
        // First remove the removed properties from existing properties
        if (removedProperties.size() > 0) {
            existingProperties.removeAll(removedProperties);
        }
        // Adds the new properties
        if (newProperties.size() > 0) {
            newlyAddedProperties.addAll(newProperties);
        }
        // Adds the existing old properties (which didn't get updated)
        // to the new list
        if (existingProperties != null) {
            newlyAddedProperties.addAll(existingProperties);
        }
        return newlyAddedProperties;

    }

    /**
     * Creates a new property
     * 
     * @param name
     * @return
     */
    private MessageProcessorParameter createProperty(String name) {
        MessageProcessorParameter newPrp = EsbFactory.eINSTANCE.createMessageProcessorParameter();
        newPrp.setParameterName(name);
        newPrp.setParameterValue(null);
        return newPrp;
    }

    private void setTextValue(Text textField, Object value) {
        if (value != null) {
            textField.setText(value.toString());
        } else {
            textField.setText("");
        }
    }

}
