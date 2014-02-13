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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.message.store.MessageStore;
import org.apache.synapse.message.store.impl.memory.InMemoryStore;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageStore;

/**
 * Deserializes a message-store configuration to a graphical message-Store object
 */
public class MessageStoreDeserializer
		extends
		AbstractEsbNodeDeserializer<MessageStore, org.wso2.developerstudio.eclipse.gmf.esb.MessageStore> {
	
	// Fixing TOOLS-2026.
	private static final String jmsMessageStoreFQNOld = "org.wso2.carbon.message.store.persistence.jms.JMSMessageStore";	
	private static final String inMemoryMessageStoreFQNOld = "org.apache.synapse.message.store.InMemoryMessageStore";
	private static final String jmsMessageStoreFQN = "org.apache.synapse.message.store.impl.jms.JmsStore";	
	private static final String inMemoryMessageStoreFQN = "org.apache.synapse.message.store.impl.memory.InMemoryStore";

	@Override
	public org.wso2.developerstudio.eclipse.gmf.esb.MessageStore createNode(
			IGraphicalEditPart part, MessageStore store) {
		org.wso2.developerstudio.eclipse.gmf.esb.MessageStore messageStore = (org.wso2.developerstudio.eclipse.gmf.esb.MessageStore) DeserializerUtils
				.createNode(part, EsbElementTypes.MessageStore_3715);
		setElementToEdit(messageStore);
		
		if (store instanceof DummyMessageStore) {
			DummyMessageStore dummyStore = (DummyMessageStore) store;
			if (StringUtils.isNotBlank(dummyStore.getClassName())) {
				if (dummyStore.getClassName().equals(jmsMessageStoreFQN)
						|| dummyStore.getClassName().equals(jmsMessageStoreFQNOld)) {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE,MessageStoreType.JMS);
					Map<String, Object> params = dummyStore.getParameters();
					
					for (Entry<String, Object> param : params.entrySet()) {
						if (param.getKey().equals("java.naming.factory.initial")) {
							Object value = params.get("java.naming.factory.initial");
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__INITIAL_CONTEXT_FACTORY,
										value.toString());
							}
						} else if (param.getKey().equals("java.naming.provider.url")) {
							Object value = params.get("java.naming.provider.url");
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__PROVIDER_URL,
										value.toString());
							}
						} else if (param.getKey().equals("store.jms.destination")) {
							Object value = params.get("store.jms.destination");
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__JNDI_QUEUE_NAME,
										value.toString());
							}
						} else if (param.getKey().equals("store.jms.connection.factory")) {
							Object value = params.get("store.jms.connection.factory");
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__CONNECTION_FACTORY,
										value.toString());
							}
						} else if (param.getKey().equals("store.jms.username")) {
							Object value = params.get("store.jms.username");
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__USER_NAME, value.toString());
							}
						} else if (param.getKey().equals("store.jms.password")) {
							Object value = params.get("store.jms.password");
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__PASSWORD, value.toString());
							}
						} else if (param.getKey().equals("store.jms.JMSSpecVersion")) {
							Object value = params.get("store.jms.JMSSpecVersion");
							if (value != null) {
								executeSetValueCommand(MESSAGE_STORE__JMS_SPEC_VERSION,
										("1.1".equals(value)) ? JMSSpecVersion.JMS_11
												: JMSSpecVersion.JMS_10);
							}
						} else if (param.getKey().equals("store.jms.cache.connection")) {
							Object value = params.get("store.jms.cache.connection");
							if (value != null) {
								if ("true".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_CACHING, true);
								} else if ("false".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_CACHING, false);
								}
							}
						} else if (param.getKey().equals("store.jms.ConsumerReceiveTimeOut")) {
							Object value = params.get("store.jms.ConsumerReceiveTimeOut");
							if (value != null) {
								if (StringUtils.isNumeric(value.toString())) {
									executeSetValueCommand(MESSAGE_STORE__TIMEOUT,
											new Long(value.toString()));
								}
							}
						} else {
							/*
							 * Any additional parameters not listed above will handle here
							 * Fixing TOOLS-2286
							 */
							if (StringUtils.isNotBlank(param.getKey()) && param.getValue() != null
									&& StringUtils.isNotBlank(param.getValue().toString())) {
								MessageStoreParameter parameter = EsbFactory.eINSTANCE
										.createMessageStoreParameter();
								parameter.setParameterName(param.getKey());
								parameter.setParameterValue(param.getValue().toString());
								executeAddValueCommand(messageStore.getParameters(), parameter);
							}

						}

					}
				} else if (dummyStore.getClassName().equals(inMemoryMessageStoreFQN)
						|| dummyStore.getClassName().equals(inMemoryMessageStoreFQNOld)) {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.IN_MEMORY);
				} else {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE,MessageStoreType.CUSTOM);
					executeSetValueCommand(MESSAGE_STORE__PROVIDER_CLASS,dummyStore.getClassName());
					for (Entry<String, Object> param : dummyStore.getParameters().entrySet()) {
						MessageStoreParameter parameter = EsbFactory.eINSTANCE.createMessageStoreParameter();
						parameter.setParameterName(param.getKey());
						parameter.setParameterValue(param.getValue().toString());
						executeAddValueCommand(messageStore.getParameters(), parameter);
					}
					
				}
			}

		} else if (store instanceof InMemoryStore) {
			// Default is In-Memory Store. 
			executeSetValueCommand(MESSAGE_STORE__STORE_TYPE,MessageStoreType.IN_MEMORY);
		}
		executeSetValueCommand(MESSAGE_STORE__STORE_NAME,store.getName());
		
		return messageStore;
	}

}
