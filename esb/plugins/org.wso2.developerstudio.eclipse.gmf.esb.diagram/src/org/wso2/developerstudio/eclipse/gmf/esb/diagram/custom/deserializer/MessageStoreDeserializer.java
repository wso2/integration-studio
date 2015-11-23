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
import org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType;
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
	
	private static final String STORE_JMS_CACHE_CONNECTION = "store.jms.cache.connection";
	private static final String STORE_JMS_JMS_SPEC_VERSION = "store.jms.JMSSpecVersion";
	private static final String STORE_JMS_PASSWORD = "store.jms.password";
	private static final String STORE_JMS_USERNAME = "store.jms.username";
	private static final String STORE_JMS_CONNECTION_FACTORY = "store.jms.connection.factory";
	private static final String STORE_JMS_DESTINATION = "store.jms.destination";
	
	private static final String STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE = "store.producer.guaranteed.delivery.enable";
	private static final String STORE_FAILOVER_MESSAGE_STORE_NAME = "store.failover.message.store.name";
	
	private static final String JAVA_NAMING_PROVIDER_URL = "java.naming.provider.url";
	private static final String JAVA_NAMING_FACTORY_INITIAL = "java.naming.factory.initial";
	
	private static final String STORE_RABBITMQ_VIRTUAL_HOST = "store.rabbitmq.virtual.host";
	private static final String STORE_RABBITMQ_PASSWORD = "store.rabbitmq.password";
	private static final String STORE_RABBITMQ_USERNAME = "store.rabbitmq.username";
	private static final String STORE_RABBITMQ_ROUTE_KEY = "store.rabbitmq.route.key";
	private static final String STORE_RABBITMQ_EXCHANGE_NAME = "store.rabbitmq.exchange.name";
	private static final String STORE_RABBITMQ_QUEUE_NAME = "store.rabbitmq.queue.name";
	private static final String STORE_RABBITMQ_HOST_PORT = "store.rabbitmq.host.port";
	private static final String STORE_RABBITMQ_HOST_NAME = "store.rabbitmq.host.name";
	
	private static final String STORE_JDBC_DS_NAME = "store.jdbc.dsName";
	private static final String STORE_JDBC_PASSWORD = "store.jdbc.password";
	private static final String STORE_JDBC_USERNAME = "store.jdbc.username";
	private static final String STORE_JDBC_CONNECTION_URL = "store.jdbc.connection.url";
	private static final String STORE_JDBC_DRIVER = "store.jdbc.driver";
	private static final String STORE_JDBC_TABLE = "store.jdbc.table";
	// Fixing TOOLS-2026.
	private static final String JMS_MS_FQN_Old = "org.wso2.carbon.message.store.persistence.jms.JMSMessageStore";	
	private static final String IN_MEMORY_MS_FQN_Old = "org.apache.synapse.message.store.InMemoryMessageStore";
	private static final String JMS_MS_FQN = "org.apache.synapse.message.store.impl.jms.JmsStore";	
	private static final String IN_MEMORY_MS_FQN = "org.apache.synapse.message.store.impl.memory.InMemoryStore";
	private static final String RABBITMQ_MS_FQN = "org.apache.synapse.message.store.impl.rabbitmq.RabbitMQStore";
	private static final String JDBC_MS_FQN = "org.apache.synapse.message.store.impl.jdbc.JDBCMessageStore";

	@Override
	public org.wso2.developerstudio.eclipse.gmf.esb.MessageStore createNode(
			IGraphicalEditPart part, MessageStore store) {
		org.wso2.developerstudio.eclipse.gmf.esb.MessageStore messageStore = (org.wso2.developerstudio.eclipse.gmf.esb.MessageStore) DeserializerUtils
				.createNode(part, EsbElementTypes.MessageStore_3715);
		setElementToEdit(messageStore);
		
		if (store instanceof DummyMessageStore) {
			DummyMessageStore dummyStore = (DummyMessageStore) store;
			if (StringUtils.isNotBlank(dummyStore.getClassName())) {
				if (dummyStore.getClassName().equals(JMS_MS_FQN)
						|| dummyStore.getClassName().equals(JMS_MS_FQN_Old)) {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE,MessageStoreType.JMS);
					Map<String, Object> params = dummyStore.getParameters();
					
					for (Entry<String, Object> param : params.entrySet()) {
						if (param.getKey().equals(JAVA_NAMING_FACTORY_INITIAL)) {
							Object value = params.get(JAVA_NAMING_FACTORY_INITIAL);
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__INITIAL_CONTEXT_FACTORY,
										value.toString());
							}
						} else if (param.getKey().equals(JAVA_NAMING_PROVIDER_URL)) {
							Object value = params.get(JAVA_NAMING_PROVIDER_URL);
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__PROVIDER_URL,
										value.toString());
							}
						} else if (param.getKey().equals(STORE_JMS_DESTINATION)) {
							Object value = params.get(STORE_JMS_DESTINATION);
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__JNDI_QUEUE_NAME,
										value.toString());
							}
						} else if (param.getKey().equals(STORE_JMS_CONNECTION_FACTORY)) {
							Object value = params.get(STORE_JMS_CONNECTION_FACTORY);
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__CONNECTION_FACTORY,
										value.toString());
							}
						} else if (param.getKey().equals(STORE_JMS_USERNAME)) {
							Object value = params.get(STORE_JMS_USERNAME);
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__USER_NAME, value.toString());
							}
						} else if (param.getKey().equals(STORE_JMS_PASSWORD)) {
							Object value = params.get(STORE_JMS_PASSWORD);
							if (StringUtils.isNotBlank(value.toString())) {
								executeSetValueCommand(MESSAGE_STORE__PASSWORD, value.toString());
							}
						} else if (param.getKey().equals(STORE_JMS_JMS_SPEC_VERSION)) {
							Object value = params.get(STORE_JMS_JMS_SPEC_VERSION);
							if (value != null) {
								executeSetValueCommand(MESSAGE_STORE__JMS_SPEC_VERSION,
										("1.1".equals(value)) ? JMSSpecVersion.JMS_11
												: JMSSpecVersion.JMS_10);
							}
						} else if (param.getKey().equals(STORE_JMS_CACHE_CONNECTION)) {
							Object value = params.get(STORE_JMS_CACHE_CONNECTION);
							if (value != null) {
								if ("true".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_CACHING, true);
								} else if ("false".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_CACHING, false);
								}
							}
						} else if (param.getKey().equals(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE)) {
							Object value = params.get(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE);							
							if (value != null) {
								if ("true".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, true);
								} else if ("false".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, false);
								}
							}
						} else if (param.getKey().equals(STORE_FAILOVER_MESSAGE_STORE_NAME)) {
								Object value = params.get(STORE_FAILOVER_MESSAGE_STORE_NAME);
								if (StringUtils.isNotBlank(value.toString())) {
									executeSetValueCommand(MESSAGE_STORE__FAILOVER_MESSAGE_STORE,
											value.toString());
								}
						} 
					/*	else if (param.getKey().equals("store.jms.ConsumerReceiveTimeOut")) {
							Object value = params.get("store.jms.ConsumerReceiveTimeOut");
							if (value != null) {
								if (StringUtils.isNumeric(value.toString())) {
									executeSetValueCommand(MESSAGE_STORE__TIMEOUT,
											new Long(value.toString()));
								}
							}
						}*/
						else {
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
				} else if (dummyStore.getClassName().equals(IN_MEMORY_MS_FQN)
						|| dummyStore.getClassName().equals(IN_MEMORY_MS_FQN_Old)) {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.IN_MEMORY);
				} else if (dummyStore.getClassName().equals(RABBITMQ_MS_FQN)) {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.RABBITMQ);
					Map<String, Object> params = dummyStore.getParameters();

					for (Entry<String, Object> param : params.entrySet()) {
						String value = param.getValue().toString();
						if (param.getKey().equals(STORE_RABBITMQ_HOST_NAME)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_NAME, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_HOST_PORT)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_PORT, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_QUEUE_NAME)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__RABBIT_MQ_QUEUE_NAME, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_EXCHANGE_NAME)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__RABBIT_MQ_EXCHANGE_NAME, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_ROUTE_KEY)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__ROUTING_KEY, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_USERNAME)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__RABBIT_MQ_USER_NAME, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_PASSWORD)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__RABBIT_MQ_PASSWORD, value);
							}
						} else if (param.getKey().equals(STORE_RABBITMQ_VIRTUAL_HOST)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__VIRTUAL_HOST, value);
							}
						} else if (param.getKey().equals(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE)) {							
							if (value != null) {
								if ("true".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, true);
								} else if ("false".equals(value)) {
									executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, false);
								}
							}
						} else if (param.getKey().equals(STORE_FAILOVER_MESSAGE_STORE_NAME)) {
								if (StringUtils.isNotBlank(value)) {
									executeSetValueCommand(MESSAGE_STORE__FAILOVER_MESSAGE_STORE, value);
								}
						}
					}
				} else if (dummyStore.getClassName().equals(JDBC_MS_FQN)) {
					executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.JDBC);
					Map<String, Object> params = dummyStore.getParameters();

					for (Entry<String, Object> param : params.entrySet()) {
						String value = param.getValue().toString();
						if (param.getKey().equals(STORE_JDBC_TABLE)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__JDBC_DATABASE_TABLE, value);
							}
						} else if (param.getKey().equals(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE)) {							
								if (value != null) {
									if ("true".equals(value)) {
										executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, true);
									} else if ("false".equals(value)) {
										executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, false);
									}
								}
						} else if (param.getKey().equals(STORE_FAILOVER_MESSAGE_STORE_NAME)) {
									if (StringUtils.isNotBlank(value)) {
										executeSetValueCommand(MESSAGE_STORE__FAILOVER_MESSAGE_STORE, value);
									}
						} else if (param.getKey().equals(STORE_JDBC_DS_NAME)) {
							if (StringUtils.isNotBlank(value)) {
								// Set connection information to datasource
								executeSetValueCommand(MESSAGE_STORE__JDBC_CONNECTION_INFORMATION,
										JDBCConnectionInformationType.JDBC_CARBON_DATASOURCE);
								executeSetValueCommand(MESSAGE_STORE__JDBC_DATASOURCE_NAME, value);
							}
						} else if (param.getKey().equals(STORE_JDBC_DRIVER)) {
							// Set connection information to pool
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__JDBC_CONNECTION_INFORMATION,
										JDBCConnectionInformationType.JDBC_POOL);
								executeSetValueCommand(MESSAGE_STORE__JDBC_DRIVER, value);
							}
						} else if (param.getKey().equals(STORE_JDBC_CONNECTION_URL)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__JDBC_CONNECTION_INFORMATION,
										JDBCConnectionInformationType.JDBC_POOL);
								executeSetValueCommand(MESSAGE_STORE__JDBC_URL, value);
							}
						} else if (param.getKey().equals(STORE_JDBC_USERNAME)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__JDBC_CONNECTION_INFORMATION,
										JDBCConnectionInformationType.JDBC_POOL);
								executeSetValueCommand(MESSAGE_STORE__JDBC_USER, value);
							}
						} else if (param.getKey().equals(STORE_JDBC_PASSWORD)) {
							if (StringUtils.isNotBlank(value)) {
								executeSetValueCommand(MESSAGE_STORE__JDBC_CONNECTION_INFORMATION,
										JDBCConnectionInformationType.JDBC_POOL);
								executeSetValueCommand(MESSAGE_STORE__JDBC_PASSWORD, value);
							}
						}
					}
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
