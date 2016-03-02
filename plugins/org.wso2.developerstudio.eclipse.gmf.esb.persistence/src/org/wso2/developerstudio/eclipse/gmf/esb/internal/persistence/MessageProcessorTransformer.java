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
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.MessageProcessorSerializer;
import org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor;
import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor} model
 * objects into corresponding synapse artifact(s).
 */
public class MessageProcessorTransformer {

	public static OMElement createMessageProcessor(MessageProcessor model) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String className = null;
		
		org.apache.synapse.message.processor.MessageProcessor messageProcessor = new ScheduledMessageForwardingProcessor();

		messageProcessor.setName(model.getProcessorName());
		messageProcessor.setMessageStoreName(model.getMessageStore());

		if (model.getProcessorType() == MessageProcessorType.SCHEDULED_MSG_FORWARDING) {
			className = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";
			if(model.getEndpointName() != null && StringUtils.isNotBlank(model.getEndpointName().getKeyValue())) {
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

			if (StringUtils.isNotBlank(model.getAxis2ClientRepository())) {
				parameters.put("axis2.repo", model.getAxis2ClientRepository());
			}
			if (StringUtils.isNotBlank(model.getAxis2Configuration())) {
				parameters.put("axis2.config", model.getAxis2Configuration());
			}
			if (model.getReplySequenceName() != null
					&& StringUtils.isNotBlank(model.getReplySequenceName().getKeyValue())) {
				parameters.put("message.processor.reply.sequence", model.getReplySequenceName()
						.getKeyValue());
			}
			if (model.getFaultSequenceName() != null
					&& StringUtils.isNotBlank(model.getFaultSequenceName().getKeyValue())) {
				parameters.put("message.processor.fault.sequence", model.getFaultSequenceName()
						.getKeyValue());
			}
			if (model.getDeactivateSequenceName() != null
					&& StringUtils.isNotBlank(model.getDeactivateSequenceName().getKeyValue())) {
				parameters.put("message.processor.deactivate.sequence", model.getDeactivateSequenceName()
						.getKeyValue());
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

		} if (model.getProcessorType() == MessageProcessorType.SCHEDULED_FAILOVER_MSG_FORWARDING) {
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
				parameters.put("message.processor.fault.sequence", model.getFaultSequenceName()
						.getKeyValue());
			}
			if (model.getDeactivateSequenceName() != null
					&& StringUtils.isNotBlank(model.getDeactivateSequenceName().getKeyValue())) {
				parameters.put("message.processor.deactivate.sequence", model.getDeactivateSequenceName()
						.getKeyValue());
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

		OMElement messageProcessorElement = MessageProcessorSerializer.serializeMessageProcessor(
				null, messageProcessor);
		OMAttribute classAttr = messageProcessorElement.getAttribute(new QName("class"));
		if (classAttr != null) {
			classAttr.setAttributeValue(className);
		} else {
			messageProcessorElement.addAttribute("class", className, null);
		}
			
		return messageProcessorElement;
	}
}
