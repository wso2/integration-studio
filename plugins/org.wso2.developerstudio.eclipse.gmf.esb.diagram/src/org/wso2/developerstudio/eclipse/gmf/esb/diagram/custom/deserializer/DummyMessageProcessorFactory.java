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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.MessageProcessorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.message.processor.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageProcessor;

/**
 * Create an instance of the given Dummy Message Processor, and sets properties
 * on it.
 * 
 */
public class DummyMessageProcessorFactory {
	private static final Log log = LogFactory.getLog(MessageProcessorFactory.class);

	public static final QName CLASS_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "class");
	public static final QName NAME_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "name");
	public static final QName PARAMETER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE,
			"parameter");
	public static final QName MESSAGE_STORE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE,
			"messageStore");
	private static final QName DESCRIPTION_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE,
			"description");
	
	// Fixing TOOLS-2026.
	public static final String FORWARDING_PROCESSOR_OLD = "org.apache.synapse.message.processors.forward.ScheduledMessageForwardingProcessor";
	public static final String FORWARDING_PROCESSOR = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";
	
	public static final QName TARGET_ENDPOINT_Q = new QName(XMLConfigConstants.NULL_NAMESPACE,
			"targetEndpoint");

	public static MessageProcessor createMessageProcessor(OMElement elem, Properties properties) {

		OMAttribute clssAtt = elem.getAttribute(CLASS_Q);
		MessageProcessor messageProcessor = null;

		if (clssAtt != null) {
			messageProcessor = new DummyMessageProcessor();
			((DummyMessageProcessor) messageProcessor).setClassName(clssAtt.getAttributeValue());
		} else {
			handleException("Can't create Message processor without a provider class");
		}

		OMAttribute nameAtt = elem.getAttribute(NAME_Q);

		if (nameAtt != null) {
			assert messageProcessor != null;
			messageProcessor.setName(nameAtt.getAttributeValue());
		} else {
			handleException("Message Processor name not specified");
		}

		if (FORWARDING_PROCESSOR.equals(clssAtt.getAttributeValue())
				|| FORWARDING_PROCESSOR_OLD.equals(clssAtt.getAttributeValue())) {
			OMAttribute targetSequenceAtt = elem.getAttribute(TARGET_ENDPOINT_Q);

			if (targetSequenceAtt != null) {
				assert messageProcessor != null;
				messageProcessor.setTargetEndpoint(targetSequenceAtt.getAttributeValue());
			} else {
				// This validation is commented due to backward compatibility
				// handleException("Can't create Message processor without a target endpoint ");
			}
		}

		OMAttribute storeAtt = elem.getAttribute(MESSAGE_STORE_Q);

		if (storeAtt != null) {
			assert messageProcessor != null;
			messageProcessor.setMessageStoreName(storeAtt.getAttributeValue());
		} else {
			handleException("Can't create a message processor without a message Store");
		}

		OMElement descriptionElem = elem.getFirstChildWithName(DESCRIPTION_Q);
		if (descriptionElem != null) {
			assert messageProcessor != null;
			messageProcessor.setDescription(descriptionElem.getText());
		}

		assert messageProcessor != null;
		messageProcessor.setParameters(getParameters(elem));

		return messageProcessor;
	}

	private static Map<String, Object> getParameters(OMElement elem) {
		Iterator<?> params = elem.getChildrenWithName(PARAMETER_Q);
		Map<String, Object> parameters = new HashMap<String, Object>();

		while (params.hasNext()) {
			Object o = params.next();
			if (o instanceof OMElement) {
				OMElement prop = (OMElement) o;
				OMAttribute paramName = prop.getAttribute(NAME_Q);
				String paramValue = prop.getText();
				if (paramName != null) {
					if (paramValue != null) {
						parameters.put(paramName.getAttributeValue(), paramValue);
					}
				} else {
					handleException("Invalid MessageProcessor parameter - Parameter must have a name ");
				}
			}
		}
		return parameters;
	}

	private static void handleException(String msg) {
		log.error(msg);
		throw new SynapseException(msg);
	}

}
