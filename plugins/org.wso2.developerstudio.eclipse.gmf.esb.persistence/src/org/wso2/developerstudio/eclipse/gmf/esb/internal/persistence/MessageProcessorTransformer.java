/*
 * Copyright (c) 2012-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.MessageProcessorSerializer;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.esb.form.editors.article.rcp.MessageProcessorFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors.CustomProcessor;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors.Sampling;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors.ScheduledFailoverForwarding;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors.ScheduledForwarding;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor} model
 * objects into corresponding synapse artifact(s).
 */
public class MessageProcessorTransformer extends AbstractEsbNodeTransformer {

    private static final String messageSamplingProcessor = "org.apache.synapse.message.processor.impl.sampler.SamplingProcessor";
    private static final String scheduledMessageForwardingProcessor = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";
    private static final String scheduledFailoverMessageForwardingProcessor = "org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor";
    private static final String customProcessor = "customProcessor";

    @Deprecated
    public static OMElement createMessageProcessor(MessageProcessor model) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        String className = null;

        org.apache.synapse.message.processor.MessageProcessor messageProcessor = new ScheduledMessageForwardingProcessor();

        messageProcessor.setName(model.getProcessorName());
        messageProcessor.setMessageStoreName(model.getMessageStore());

        if (model.getProcessorType() == MessageProcessorType.SCHEDULED_MSG_FORWARDING) {
            className = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";
            if (model.getEndpointName() != null && StringUtils.isNotBlank(model.getEndpointName().getKeyValue())) {
                messageProcessor.setTargetEndpoint(model.getEndpointName().getKeyValue());
            }

            if (StringUtils.isNotBlank(model.getProcessorState().getLiteral())) {
                if (model.getProcessorState().getLiteral().equals("Activate")) {
                    Boolean isActive = true;
                    parameters.put("is.active", isActive.toString());
                } else {
                    Boolean isActive = false;
                    parameters.put("is.active", isActive.toString());
                }
            }

            parameters.put("interval", ((Long) model.getForwardingInterval()).toString());
            parameters.put("client.retry.interval", ((Long) model.getRetryInterval()).toString());
            parameters.put("max.delivery.attempts", ((Integer) model.getMaxDeliveryAttempts()).toString());
            parameters.put("max.store.connection.attempts", Integer.toString(model.getMaxStoreConnectionAttempts()));
            parameters.put("store.connection.retry.interval", Integer.toString(model.getStoreConnectionInterval()));

            if (StringUtils.isNotBlank(model.getAxis2ClientRepository())) {
                parameters.put("axis2.repo", model.getAxis2ClientRepository());
            }
            if (StringUtils.isNotBlank(model.getAxis2Configuration())) {
                parameters.put("axis2.config", model.getAxis2Configuration());
            }
            if (model.getReplySequenceName() != null
                    && StringUtils.isNotBlank(model.getReplySequenceName().getKeyValue())) {
                parameters.put("message.processor.reply.sequence", model.getReplySequenceName().getKeyValue());
            }
            if (model.getFaultSequenceName() != null
                    && StringUtils.isNotBlank(model.getFaultSequenceName().getKeyValue())) {
                parameters.put("message.processor.fault.sequence", model.getFaultSequenceName().getKeyValue());
            }
            if (model.getDeactivateSequenceName() != null
                    && StringUtils.isNotBlank(model.getDeactivateSequenceName().getKeyValue())) {
                parameters.put("message.processor.deactivate.sequence",
                        model.getDeactivateSequenceName().getKeyValue());
            }
            if (model.getFailMessagesStore() != null && StringUtils.isNotBlank(model.getFailMessagesStore())) {
                parameters.put("message.processor.failMessagesStore", model.getFailMessagesStore());
            }
            if (StringUtils.isNotBlank(model.getQuartzConfigFilePath())) {
                parameters.put("quartz.conf", model.getQuartzConfigFilePath());
            }
            if (StringUtils.isNotBlank(model.getCronExpression())) {
                parameters.put("cronExpression", model.getCronExpression());
            }
            if (StringUtils.isNotBlank(model.getNonRetryHttpStatusCodes())) {
                parameters.put("non.retry.status.codes", model.getNonRetryHttpStatusCodes());
            }
            if (StringUtils.isNotBlank(model.getDropMessageAfterMaximumDeliveryAttempts().getLiteral())) {
                parameters.put("max.delivery.drop", model.getDropMessageAfterMaximumDeliveryAttempts().getLiteral());
            }
            if (StringUtils.isNotBlank(model.getTaskCount())) {
                parameters.put("member.count", model.getTaskCount());
            }

            EList<MessageProcessorParameter> processorParameters = model.getParameters();
            for (MessageProcessorParameter param : processorParameters) {
                if (StringUtils.isNotBlank(param.getParameterName())
                        && StringUtils.isNotBlank(param.getParameterValue())) {
                    parameters.put(param.getParameterName(), param.getParameterValue());
                }
            }

        }
        if (model.getProcessorType() == MessageProcessorType.SCHEDULED_FAILOVER_MSG_FORWARDING) {
            className = "org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor";
            messageProcessor.setMessageStoreName(model.getSourceMessageStore());

            if (StringUtils.isNotBlank(model.getProcessorState().getLiteral())) {
                if (model.getProcessorState().getLiteral().equals("Activate")) {
                    Boolean isActive = true;
                    parameters.put("is.active", isActive.toString());
                } else {
                    Boolean isActive = false;
                    parameters.put("is.active", isActive.toString());
                }
            }

            parameters.put("interval", ((Long) model.getForwardingInterval()).toString());
            parameters.put("client.retry.interval", ((Long) model.getRetryInterval()).toString());
            parameters.put("max.delivery.attempts", ((Integer) model.getMaxDeliveryAttempts()).toString());

            if (model.getFaultSequenceName() != null
                    && StringUtils.isNotBlank(model.getFaultSequenceName().getKeyValue())) {
                parameters.put("message.processor.fault.sequence", model.getFaultSequenceName().getKeyValue());
            }
            if (model.getDeactivateSequenceName() != null
                    && StringUtils.isNotBlank(model.getDeactivateSequenceName().getKeyValue())) {
                parameters.put("message.processor.deactivate.sequence",
                        model.getDeactivateSequenceName().getKeyValue());
            }
            if (StringUtils.isNotBlank(model.getQuartzConfigFilePath())) {
                parameters.put("quartz.conf", model.getQuartzConfigFilePath());
            }
            if (StringUtils.isNotBlank(model.getCronExpression())) {
                parameters.put("cronExpression", model.getCronExpression());
            }
            if (StringUtils.isNotBlank(model.getDropMessageAfterMaximumDeliveryAttempts().getLiteral())) {
                parameters.put("max.delivery.drop", model.getDropMessageAfterMaximumDeliveryAttempts().getLiteral());
            }
            if (StringUtils.isNotBlank(model.getTaskCount())) {
                parameters.put("member.count", model.getTaskCount());
            }
            if (StringUtils.isNotBlank(model.getTargetMessageStore())) {
                parameters.put("message.target.store.name", model.getTargetMessageStore());
            }

            EList<MessageProcessorParameter> processorParameters = model.getParameters();
            for (MessageProcessorParameter param : processorParameters) {
                if (StringUtils.isNotBlank(param.getParameterName())
                        && StringUtils.isNotBlank(param.getParameterValue())) {
                    parameters.put(param.getParameterName(), param.getParameterValue());
                }
            }

        } else if (model.getProcessorType() == MessageProcessorType.MSG_SAMPLING) {
            className = "org.apache.synapse.message.processor.impl.sampler.SamplingProcessor";

            if (StringUtils.isNotBlank(model.getProcessorState().getLiteral())) {
                if (model.getProcessorState().getLiteral().equals("Activate")) {
                    Boolean isActive = true;
                    parameters.put("is.active", isActive.toString());
                } else {
                    Boolean isActive = false;
                    parameters.put("is.active", isActive.toString());
                }
            }

            parameters.put("sequence", model.getSequence().getKeyValue());
            parameters.put("interval", ((Long) model.getSamplingInterval()).toString());
            parameters.put("concurrency", ((Integer) model.getSamplingConcurrency()).toString());

            if (StringUtils.isNotBlank(model.getQuartzConfigFilePath())) {
                parameters.put("quartz.conf", model.getQuartzConfigFilePath());
            }
            if (StringUtils.isNotBlank(model.getCronExpression())) {
                parameters.put("cronExpression", model.getCronExpression());
            }

            EList<MessageProcessorParameter> processorParameters = model.getParameters();
            for (MessageProcessorParameter param : processorParameters) {
                if (StringUtils.isNotBlank(param.getParameterName())
                        && StringUtils.isNotBlank(param.getParameterValue())) {
                    parameters.put(param.getParameterName(), param.getParameterValue());
                }
            }

        } else if (model.getProcessorType() == MessageProcessorType.CUSTOM) {
            if (StringUtils.isNotBlank(model.getMessageProcessorProvider())) {
                className = model.getMessageProcessorProvider();
            } else {
                className = "";
            }

            EList<MessageProcessorParameter> processorParameters = model.getParameters();
            for (MessageProcessorParameter param : processorParameters) {
                if (StringUtils.isNotBlank(param.getParameterName())
                        && StringUtils.isNotBlank(param.getParameterValue())) {
                    parameters.put(param.getParameterName(), param.getParameterValue());
                }
            }
        }

        messageProcessor.setParameters(parameters);

        OMElement messageProcessorElement = MessageProcessorSerializer.serializeMessageProcessor(null,
                messageProcessor);
        OMAttribute classAttr = messageProcessorElement.getAttribute(new QName("class"));
        if (classAttr != null) {
            classAttr.setAttributeValue(className);
        } else {
            messageProcessorElement.addAttribute("class", className, null);
        }

        return messageProcessorElement;
    }

    public OMElement createMessageProcessor(FormPage visualForm) {

        org.apache.synapse.message.processor.MessageProcessor messageProcessor = new org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor();
        OMElement configXml = null;
        Map<String, Object> parameterMap = new HashMap<>();
        String className = "";

        if (visualForm instanceof MessageProcessorFormPage) {

            MessageProcessorFormPage messageProcessorFormPage = (MessageProcessorFormPage) visualForm;

            if (messageProcessorFormPage.processorName.getText().length() > 0) {

                int processorIndex = messageProcessorFormPage.processorType.getSelectionIndex();

                switch (processorIndex) {
                case 0: {
                    // messageSamplingProcessor
                    className = messageSamplingProcessor;
                    messageProcessor = new org.apache.synapse.message.processor.impl.sampler.SamplingProcessor();
                    Sampling sampling = (Sampling) messageProcessorFormPage.getProcessorImpl(messageSamplingProcessor);

                    if (StringUtils.isNotEmpty(sampling.sampling_sequence.getText())) {
                        parameterMap.put("sequence", sampling.sampling_sequence.getText());
                    }
                    if (StringUtils.isNotEmpty(sampling.sampling_interval.getText())) {
                        parameterMap.put("interval", sampling.sampling_interval.getText());
                    }
                    if (StringUtils.isNotEmpty(sampling.sampling_concurrency.getText())) {
                        parameterMap.put("concurrency", sampling.sampling_concurrency.getText());
                    }
                    if (StringUtils.isNotEmpty(sampling.sampling_quartzConfigFilePath.getText())) {
                        parameterMap.put("quartz.conf", sampling.sampling_quartzConfigFilePath.getText());
                    }
                    if (StringUtils.isNotEmpty(sampling.sampling_cronExpression.getText())) {
                        parameterMap.put("cronExpression", sampling.sampling_cronExpression.getText());
                    }

                    if (sampling.sampling_state.getSelectionIndex() == 0) {
                        parameterMap.put("is.active", "true");
                    } else {
                        parameterMap.put("is.active", "false");
                    }
                    List<MessageProcessorParameter> parameters = sampling.messageProcessorParameterList;
                    if (parameters != null) {
                        for (MessageProcessorParameter param : parameters) {
                            if (!StringUtils.isBlank(param.getParameterName())
                                    && !StringUtils.isBlank(param.getParameterValue())) {
                                parameterMap.put(param.getParameterName(), param.getParameterValue());
                            }
                        }
                    }

                    break;
                }
                case 1: {
                    // scheduledMessageForwardingProcessor
                    className = scheduledMessageForwardingProcessor;
                    ScheduledForwarding forwarder = (ScheduledForwarding) messageProcessorFormPage
                            .getProcessorImpl(scheduledMessageForwardingProcessor);

                    if (StringUtils.isNotEmpty(forwarder.forwarding_endpoint.getText())) {
                        messageProcessor.setTargetEndpoint(forwarder.forwarding_endpoint.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_interval.getText())) {
                        parameterMap.put("interval", forwarder.forwarding_interval.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_retryInterval.getText())) {
                        parameterMap.put("client.retry.interval", forwarder.forwarding_retryInterval.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_nonRetryHttpCodes.getText())) {
                        parameterMap.put("non.retry.status.codes",
                                forwarder.forwarding_nonRetryHttpCodes.getText().split(","));
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_maxDeliveryAttempts.getText())) {
                        parameterMap.put("max.delivery.attempts", forwarder.forwarding_maxDeliveryAttempts.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_maxStoreConnectionAttempts.getText())) {
                        parameterMap.put("max.store.connection.attempts",
                                forwarder.forwarding_maxStoreConnectionAttempts.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_storeConnectionAttemptInterval.getText())) {
                        parameterMap.put("store.connection.retry.interval",
                                forwarder.forwarding_storeConnectionAttemptInterval.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_axis2ClientRepo.getText())) {
                        parameterMap.put("axis2.repo", forwarder.forwarding_axis2ClientRepo.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_axis2Config.getText())) {
                        parameterMap.put("axis2.config", forwarder.forwarding_axis2Config.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_replySequence.getText())) {
                        parameterMap.put("message.processor.reply.sequence",
                                forwarder.forwarding_replySequence.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_faultSequence.getText())) {
                        parameterMap.put("message.processor.fault.sequence",
                                forwarder.forwarding_faultSequence.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_deactiveSequence.getText())) {
                        parameterMap.put("message.processor.deactivate.sequence",
                                forwarder.forwarding_deactiveSequence.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_failMessagesStore.getText())) {
                        parameterMap.put("message.processor.failMessagesStore",
                                forwarder.forwarding_failMessagesStore.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_quartzConfigFilePath.getText())) {
                        parameterMap.put("quartz.conf", forwarder.forwarding_quartzConfigFilePath.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_cronExpression.getText())) {
                        parameterMap.put("cronExpression", forwarder.forwarding_cronExpression.getText());
                    }
                    if (StringUtils.isNotEmpty(forwarder.forwarding_taskCount.getText())) {
                        parameterMap.put("member.count", forwarder.forwarding_taskCount.getText());
                    }

                    if (forwarder.forwarding_state.getSelectionIndex() == 0) {
                        parameterMap.put("is.active", "true");
                    } else {
                        parameterMap.put("is.active", "false");
                    }

                    if (forwarder.forwarding_dropMessageAfterMaxDeliveryAttempts.getSelectionIndex() == 0) {
                        parameterMap.put("max.delivery.drop", "Enabled");
                    } else {
                        parameterMap.put("max.delivery.drop", "Disabled");
                    }

                    List<MessageProcessorParameter> parameters = forwarder.messageProcessorParameterList;
                    if (parameters != null) {
                        for (MessageProcessorParameter param : parameters) {
                            if (!StringUtils.isBlank(param.getParameterName())
                                    && !StringUtils.isBlank(param.getParameterValue())) {
                                parameterMap.put(param.getParameterName(), param.getParameterValue());
                            }
                        }
                    }

                    break;
                }
                case 2: {
                    // scheduledFailoverMessageForwardingProcessor
                    className = scheduledFailoverMessageForwardingProcessor;
                    ScheduledFailoverForwarding failover = (ScheduledFailoverForwarding) messageProcessorFormPage
                            .getProcessorImpl(scheduledFailoverMessageForwardingProcessor);
                    if (StringUtils.isNotEmpty(failover.failover_store.getText())) {
                        parameterMap.put("store.failover.message.store.name", failover.failover_store.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_interval.getText())) {
                        parameterMap.put("interval", failover.failover_interval.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_retryInterval.getText())) {
                        parameterMap.put("client.retry.interval", failover.failover_retryInterval.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_maxDeliveryAttempts.getText())) {
                        parameterMap.put("max.delivery.attempts", failover.failover_maxDeliveryAttempts.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_faultSequence.getText())) {
                        parameterMap.put("message.processor.fault.sequence", failover.failover_faultSequence.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_deactiveSequence.getText())) {
                        parameterMap.put("message.processor.deactivate.sequence",
                                failover.failover_deactiveSequence.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_quartzConfigFilePath.getText())) {
                        parameterMap.put("quartz.conf", failover.failover_quartzConfigFilePath.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_cronExpression.getText())) {
                        parameterMap.put("cronExpression", failover.failover_cronExpression.getText());
                    }
                    if (StringUtils.isNotEmpty(failover.failover_taskCount.getText())) {
                        parameterMap.put("member.count", failover.failover_taskCount.getText());
                    }

                    if (failover.failover_state.getSelectionIndex() == 0) {
                        parameterMap.put("is.active", "true");
                    } else {
                        parameterMap.put("is.active", "false");
                    }

                    if (failover.failover_dropMessageAfterMaxDeliveryAttempts.getSelectionIndex() == 0) {
                        parameterMap.put("max.delivery.drop", "Enabled");
                    } else {
                        parameterMap.put("max.delivery.drop", "Disabled");
                    }

                    List<MessageProcessorParameter> parameters = failover.messageProcessorParameterList;
                    if (parameters != null) {
                        for (MessageProcessorParameter param : parameters) {
                            if (!StringUtils.isBlank(param.getParameterName())
                                    && !StringUtils.isBlank(param.getParameterValue())) {
                                parameterMap.put(param.getParameterName(), param.getParameterValue());
                            }
                        }
                    }

                    break;
                }
                default: {
                    // customProcessor
                    CustomProcessor custom = (CustomProcessor) messageProcessorFormPage
                            .getProcessorImpl(customProcessor);

                    className = custom.custom_providerClass.getText();
                    List<MessageProcessorParameter> parameters = custom.messageProcessorParameterList;
                    if (parameters != null) {
                        for (MessageProcessorParameter param : parameters) {
                            if (!StringUtils.isBlank(param.getParameterName())
                                    && !StringUtils.isBlank(param.getParameterValue())) {
                                parameterMap.put(param.getParameterName(), param.getParameterValue());
                            }
                        }
                    }

                    break;
                }

                }

                messageProcessor.setParameters(parameterMap);

                messageProcessor.setName(messageProcessorFormPage.processorName.getText());
                messageProcessor.setMessageStoreName(messageProcessorFormPage.storeName.getText());

                configXml = MessageProcessorSerializer.serializeMessageProcessor(null, messageProcessor);

                OMAttribute classAttr = configXml.getAttribute(new QName("class"));
                if (classAttr != null) {
                    classAttr.setAttributeValue(className);
                } else {
                    configXml.addAttribute("class", className, null);
                }

            }

        }

        return configXml;
    }

    @Override
    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        // TODO Auto-generated method stub

    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub

    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        // TODO Auto-generated method stub

    }
}
