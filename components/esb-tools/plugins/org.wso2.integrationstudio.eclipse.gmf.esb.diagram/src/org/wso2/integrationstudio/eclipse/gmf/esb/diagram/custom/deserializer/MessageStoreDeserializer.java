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

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__CACHE_CONNECTION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__CONNECTION_FACTORY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__FAILOVER_MESSAGE_STORE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_CONNECTION_INFORMATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_DATABASE_TABLE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_DATASOURCE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_DRIVER;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_PASSWORD;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_URL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JDBC_USER;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_CONNECTION_INFORMATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_DATABASE_TABLE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_DATASOURCE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_DRIVER;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_PASSWORD;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_URL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_USER;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCEPOLLING;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RESEQUENCE_XPATH_ATTR;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JMS_SPEC_VERSION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__JNDI_QUEUE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__PASSWORD;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__PROVIDER_CLASS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__PROVIDER_URL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_EXCHANGE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_PASSWORD;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_QUEUE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_PORT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_USER_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__ROUTING_KEY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__STORE_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__STORE_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__USER_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.MESSAGE_STORE__VIRTUAL_HOST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.message.store.MessageStore;
import org.apache.synapse.message.store.impl.memory.InMemoryStore;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.JDBCConnectionInformationType;
import org.wso2.integrationstudio.eclipse.gmf.esb.JMSSpecVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.MessageStoreParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.MessageStoreType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageStore;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.MessageStoreFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.CustomStore;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.IMessageStore;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.InMemory;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.JDBC;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.JMS;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.RabbitMQ;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.Resequence;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores.WSO2MB;

/**
 * Deserializes a message-store configuration to a graphical message-Store
 * object
 */
public class MessageStoreDeserializer
        extends AbstractEsbNodeDeserializer<MessageStore, org.wso2.integrationstudio.eclipse.gmf.esb.MessageStore> {

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

    private static final String STORE_WSO2MB_QUEUE_CONNECTION_FACTORY = "connectionfactory.QueueConnectionFactory";

    private static final String STORE_RABBITMQ_VIRTUAL_HOST = "store.rabbitmq.virtual.host";
    private static final String STORE_RABBITMQ_PASSWORD = "store.rabbitmq.password";
    private static final String STORE_RABBITMQ_USERNAME = "store.rabbitmq.username";
    private static final String STORE_RABBITMQ_ROUTE_KEY = "store.rabbitmq.route.key";
    private static final String STORE_RABBITMQ_EXCHANGE_NAME = "store.rabbitmq.exchange.name";
    private static final String STORE_RABBITMQ_QUEUE_NAME = "store.rabbitmq.queue.name";
    private static final String STORE_RABBITMQ_HOST_PORT = "store.rabbitmq.host.port";
    private static final String STORE_RABBITMQ_HOST_NAME = "store.rabbitmq.host.name";

    private static final String STORE_RABBITMQ_SSL_ENABLED = "rabbitmq.connection.ssl.enabled";
    private static final String STORE_RABBITMQ_SSL_KEYSTORE_LOCATION = "rabbitmq.connection.ssl.keystore.location";
    private static final String STORE_RABBITMQ_SSL_KEYSTORE_TYPE = "rabbitmq.connection.ssl.keystore.type";
    private static final String STORE_RABBITMQ_SSL_KEYSTORE_PASSWORD = "rabbitmq.connection.ssl.keystore.password";
    private static final String STORE_RABBITMQ_SSL_TRUSTSTORE_LOCATION = "rabbitmq.connection.ssl.truststore.location";
    private static final String STORE_RABBITMQ_SSL_TRUSTSTORE_TYPE = "rabbitmq.connection.ssl.truststore.type";
    private static final String STORE_RABBITMQ_SSL_TRUSTSTORE_PASSWORD = "rabbitmq.connection.ssl.truststore.password";
    private static final String STORE_RABBITMQ_SSL_VERSION = "rabbitmq.connection.ssl.version";

    private static final String STORE_JDBC_DS_NAME = "store.jdbc.dsName";
    private static final String STORE_JDBC_PASSWORD = "store.jdbc.password";
    private static final String STORE_JDBC_USERNAME = "store.jdbc.username";
    private static final String STORE_JDBC_CONNECTION_URL = "store.jdbc.connection.url";
    private static final String STORE_JDBC_DRIVER = "store.jdbc.driver";
    private static final String STORE_JDBC_TABLE = "store.jdbc.table";

    private static final String STORE_RESEQUENCE_DS_NAME = "store.jdbc.dsName";
    private static final String STORE_RESEQUENCE_PASSWORD = "store.jdbc.password";
    private static final String STORE_RESEQUENCE_USERNAME = "store.jdbc.username";
    private static final String STORE_RESEQUENCE_CONNECTION_URL = "store.jdbc.connection.url";
    private static final String STORE_RESEQUENCE_DRIVER = "store.jdbc.driver";
    private static final String STORE_RESEQUENCE_TABLE = "store.jdbc.table";
    private static final String STORE_RESEQUENCE_POLLING_COUNT = "store.resequence.timeout";
    private static final String STORE_RESEQUENCE_XPATH = "store.resequence.id.path";
    // Fixing TOOLS-2026.
    private static final String JMS_MS_FQN_Old = "org.wso2.carbon.message.store.persistence.jms.JMSMessageStore";
    private static final String IN_MEMORY_MS_FQN_Old = "org.apache.synapse.message.store.InMemoryMessageStore";

    private static final String IN_MEMORY_MS_FQN = "org.apache.synapse.message.store.impl.memory.InMemoryStore";
    private static final String JMS_MS_FQN = "org.apache.synapse.message.store.impl.jms.JmsStore";
    private static final String WSO2MB = "wso2mb";
    private static final String RABBITMQ_MS_FQN = "org.apache.synapse.message.store.impl.rabbitmq.RabbitMQStore";
    private static final String JDBC_MS_FQN = "org.apache.synapse.message.store.impl.jdbc.JDBCMessageStore";
    private static final String RESEQUENCE_MS_FQN = "org.apache.synapse.message.store.impl.resequencer.ResequenceMessageStore";
    private static final String customStore = "customStore";

    @Deprecated
    @Override
    public org.wso2.integrationstudio.eclipse.gmf.esb.MessageStore createNode(IGraphicalEditPart part,
            MessageStore store) {
        org.wso2.integrationstudio.eclipse.gmf.esb.MessageStore messageStore = (org.wso2.integrationstudio.eclipse.gmf.esb.MessageStore) DeserializerUtils
                .createNode(part, EsbElementTypes.MessageStore_3715);
        setElementToEdit(messageStore);

        if (store instanceof DummyMessageStore) {
            DummyMessageStore dummyStore = (DummyMessageStore) store;
            if (StringUtils.isNotBlank(dummyStore.getClassName())) {
                if (dummyStore.getClassName().equals(JMS_MS_FQN) || dummyStore.getClassName().equals(JMS_MS_FQN_Old)) {
                    executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.JMS);
                    Map<String, Object> params = dummyStore.getParameters();

                    for (Entry<String, Object> param : params.entrySet()) {
                        if (param.getKey().equals(JAVA_NAMING_FACTORY_INITIAL)) {
                            Object value = params.get(JAVA_NAMING_FACTORY_INITIAL);
                            if (StringUtils.isNotBlank(value.toString())) {
                                executeSetValueCommand(MESSAGE_STORE__INITIAL_CONTEXT_FACTORY, value.toString());
                            }
                        } else if (param.getKey().equals(JAVA_NAMING_PROVIDER_URL)) {
                            Object value = params.get(JAVA_NAMING_PROVIDER_URL);
                            if (StringUtils.isNotBlank(value.toString())) {
                                executeSetValueCommand(MESSAGE_STORE__PROVIDER_URL, value.toString());
                            }
                        } else if (param.getKey().equals(STORE_JMS_DESTINATION)) {
                            Object value = params.get(STORE_JMS_DESTINATION);
                            if (StringUtils.isNotBlank(value.toString())) {
                                executeSetValueCommand(MESSAGE_STORE__JNDI_QUEUE_NAME, value.toString());
                            }
                        } else if (param.getKey().equals(STORE_JMS_CONNECTION_FACTORY)) {
                            Object value = params.get(STORE_JMS_CONNECTION_FACTORY);
                            if (StringUtils.isNotBlank(value.toString())) {
                                executeSetValueCommand(MESSAGE_STORE__CONNECTION_FACTORY, value.toString());
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
                                        ("1.1".equals(value)) ? JMSSpecVersion.JMS_11 : JMSSpecVersion.JMS_10);
                            }
                        } else if (param.getKey().equals(STORE_JMS_CACHE_CONNECTION)) {
                            Object value = params.get(STORE_JMS_CACHE_CONNECTION);
                            if (value != null) {
                                if ("true".equals(value)) {
                                    executeSetValueCommand(MESSAGE_STORE__CACHE_CONNECTION, true);
                                } else if ("false".equals(value)) {
                                    executeSetValueCommand(MESSAGE_STORE__CACHE_CONNECTION, false);
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
                                executeSetValueCommand(MESSAGE_STORE__FAILOVER_MESSAGE_STORE, value.toString());
                            }
                        }
                        /*
                         * else if (param.getKey().equals(
                         * "store.jms.ConsumerReceiveTimeOut")) { Object value =
                         * params.get("store.jms.ConsumerReceiveTimeOut"); if
                         * (value != null) { if
                         * (StringUtils.isNumeric(value.toString())) {
                         * executeSetValueCommand(MESSAGE_STORE__TIMEOUT, new
                         * Long(value.toString())); } } }
                         */
                        else {
                            /*
                             * Any additional parameters not listed above will
                             * handle here Fixing TOOLS-2286
                             */
                            if (StringUtils.isNotBlank(param.getKey()) && param.getValue() != null
                                    && StringUtils.isNotBlank(param.getValue().toString())) {
                                MessageStoreParameter parameter = EsbFactory.eINSTANCE.createMessageStoreParameter();
                                parameter.setParameterName(param.getKey());
                                parameter.setParameterValue(param.getValue().toString());
                                executeAddValueCommand(messageStore.getParameters(), parameter, false);
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
                } else if (dummyStore.getClassName().equals(RESEQUENCE_MS_FQN)) {
                    executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.RESEQUENCE);
                    Map<String, Object> params = dummyStore.getParameters();

                    for (Entry<String, Object> param : params.entrySet()) {
                        String value = param.getValue().toString();
                        if (param.getKey().equals(STORE_RESEQUENCE_TABLE) && StringUtils.isNotBlank(value)) {
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_DATABASE_TABLE, value);
                        } else if (param.getKey().equals(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE)) {
                            if (value != null) {
                                if ("true".equals(value)) {
                                    executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, true);
                                } else if ("false".equals(value)) {
                                    executeSetValueCommand(MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY, false);
                                }
                            }
                        } else if (param.getKey().equals(STORE_FAILOVER_MESSAGE_STORE_NAME)
                                && StringUtils.isNotBlank(value)) {
                            executeSetValueCommand(MESSAGE_STORE__FAILOVER_MESSAGE_STORE, value);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_POLLING_COUNT)
                                && StringUtils.isNotBlank(value)) {
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCEPOLLING, value);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_XPATH)
                                && param.getValue() instanceof SynapseXPath) {
                            SynapseXPath xpath = (SynapseXPath) param.getValue();
                            NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_XPATH_ATTR, namespaceProp);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_DS_NAME) && StringUtils.isNotBlank(value)) {
                            // Set connection information to datasource
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_CONNECTION_INFORMATION,
                                    JDBCConnectionInformationType.JDBC_CARBON_DATASOURCE);
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_DATASOURCE_NAME, value);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_DRIVER) && StringUtils.isNotBlank(value)) {
                            // Set connection information to pool
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_CONNECTION_INFORMATION,
                                    JDBCConnectionInformationType.JDBC_POOL);
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_DRIVER, value);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_CONNECTION_URL)
                                && StringUtils.isNotBlank(value)) {
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_CONNECTION_INFORMATION,
                                    JDBCConnectionInformationType.JDBC_POOL);
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_URL, value);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_USERNAME) && StringUtils.isNotBlank(value)) {
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_CONNECTION_INFORMATION,
                                    JDBCConnectionInformationType.JDBC_POOL);
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_USER, value);
                        } else if (param.getKey().equals(STORE_RESEQUENCE_PASSWORD) && StringUtils.isNotBlank(value)) {
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_CONNECTION_INFORMATION,
                                    JDBCConnectionInformationType.JDBC_POOL);
                            executeSetValueCommand(MESSAGE_STORE__RESEQUENCE_PASSWORD, value);
                        }
                    }
                } else {
                    executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.CUSTOM);
                    executeSetValueCommand(MESSAGE_STORE__PROVIDER_CLASS, dummyStore.getClassName());
                    for (Entry<String, Object> param : dummyStore.getParameters().entrySet()) {
                        MessageStoreParameter parameter = EsbFactory.eINSTANCE.createMessageStoreParameter();
                        parameter.setParameterName(param.getKey());
                        parameter.setParameterValue(param.getValue().toString());
                        executeAddValueCommand(messageStore.getParameters(), parameter, false);
                    }

                }
            }

        } else if (store instanceof InMemoryStore) {
            // Default is In-Memory Store.
            executeSetValueCommand(MESSAGE_STORE__STORE_TYPE, MessageStoreType.IN_MEMORY);
        }
        executeSetValueCommand(MESSAGE_STORE__STORE_NAME, store.getName());

        return messageStore;
    }

    @Override
    public void createNode(FormEditor formEditor, MessageStore store) {
        ESBFormEditor messageStoreFormEditor = (ESBFormEditor) formEditor;
        MessageStoreFormPage messageStorePage = (MessageStoreFormPage) messageStoreFormEditor
                .getFormPageForArtifact(ArtifactType.MESSAGE_STORE);
        org.wso2.integrationstudio.eclipse.gmf.esb.MessageStore messageStore = EsbFactoryImpl.eINSTANCE
                .createMessageStore();

        messageStore.setStoreName(store.getName());
        messageStore.setDescription(store.getDescription());

        messageStorePage.setEsbNode(messageStore);

        if (store instanceof InMemoryStore) {
            messageStorePage.storeType.select(0);
            messageStorePage.storeName.setText(store.getName());
            messageStorePage.guaranteedDeliveryEnable.select(1);
        } else {

            DummyMessageStore dummyMessageStore = (DummyMessageStore) store;

            if (dummyMessageStore.getName() != null) {
                messageStorePage.storeName.setText(dummyMessageStore.getName());
            }

            if (dummyMessageStore.getParameters().get(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE) != null
                    && dummyMessageStore.getParameters().get(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE).toString()
                            .equalsIgnoreCase("true")) {
                messageStorePage.guaranteedDeliveryEnable.select(0);
                if (dummyMessageStore.getParameters().get(STORE_FAILOVER_MESSAGE_STORE_NAME) != null) {
                    messageStorePage.failoverMessageStore.setText(
                            dummyMessageStore.getParameters().get(STORE_FAILOVER_MESSAGE_STORE_NAME).toString());
                }
            } else {
                messageStorePage.guaranteedDeliveryEnable.select(1);
            }

            if (dummyMessageStore.getParameters().get(STORE_WSO2MB_QUEUE_CONNECTION_FACTORY) != null) {
                // This is a MB store
                messageStorePage.storeType.select(2);

                WSO2MB wso2mbStore = (WSO2MB) messageStorePage.getStoreImpl(WSO2MB);

                setTextValue(wso2mbStore.wso2mb_initCtxFactory, store.getParameters().get(JAVA_NAMING_FACTORY_INITIAL));
                setTextValue(wso2mbStore.wso2mb_QueueConnFactory,
                        store.getParameters().get(STORE_WSO2MB_QUEUE_CONNECTION_FACTORY));
                setTextValue(wso2mbStore.wso2mb_jndiQueueName, store.getParameters().get(STORE_JMS_DESTINATION));

                if (store.getParameters().get(STORE_JMS_JMS_SPEC_VERSION) != null
                        && store.getParameters().get(STORE_JMS_JMS_SPEC_VERSION).toString().equalsIgnoreCase("1.0")) {
                    wso2mbStore.wso2mb_apiVersion.select(1);
                } else {
                    wso2mbStore.wso2mb_apiVersion.select(0);
                }

                if (store.getParameters().get(STORE_JMS_CACHE_CONNECTION) != null
                        && store.getParameters().get(STORE_JMS_CACHE_CONNECTION).toString().equalsIgnoreCase("false")) {
                    wso2mbStore.mb_cacheConnection.select(0);
                } else {
                    wso2mbStore.mb_cacheConnection.select(1);
                }
            } else if (dummyMessageStore.getClassName().equalsIgnoreCase(IN_MEMORY_MS_FQN)) {
                messageStorePage.storeType.select(0);

                InMemory inMemoryStore = (InMemory) messageStorePage.getStoreImpl(IN_MEMORY_MS_FQN);

            } else if (dummyMessageStore.getClassName().equalsIgnoreCase(JMS_MS_FQN)) {
                messageStorePage.storeType.select(1);

                JMS jmsStore = (JMS) messageStorePage.getStoreImpl(JMS_MS_FQN);

                setTextValue(jmsStore.jms_initCtxFactory, store.getParameters().get(JAVA_NAMING_FACTORY_INITIAL));
                setTextValue(jmsStore.jms_providerUrl, store.getParameters().get(JAVA_NAMING_PROVIDER_URL));
                setTextValue(jmsStore.jms_jndiQueueName, store.getParameters().get(STORE_JMS_DESTINATION));
                setTextValue(jmsStore.jms_connectionFactory, store.getParameters().get(STORE_JMS_CONNECTION_FACTORY));
                setTextValue(jmsStore.jms_username, store.getParameters().get(STORE_JMS_USERNAME));
                setTextValue(jmsStore.jms_password, store.getParameters().get(STORE_JMS_PASSWORD));

                if (store.getParameters().get(STORE_JMS_CACHE_CONNECTION) != null
                        && store.getParameters().get(STORE_JMS_CACHE_CONNECTION).toString().equalsIgnoreCase("false")) {
                    jmsStore.jms_cacheConnection.select(0);
                } else {
                    jmsStore.jms_cacheConnection.select(1);
                }

                if (store.getParameters().get(STORE_JMS_JMS_SPEC_VERSION) != null
                        && store.getParameters().get(STORE_JMS_JMS_SPEC_VERSION).toString().equalsIgnoreCase("1.0")) {
                    jmsStore.jms_apiVersion.select(1);
                } else {
                    jmsStore.jms_apiVersion.select(0);
                }
            } else if (dummyMessageStore.getClassName().equalsIgnoreCase(RABBITMQ_MS_FQN)) {
                messageStorePage.storeType.select(3);

                RabbitMQ rabbitMQStore = (RabbitMQ) messageStorePage.getStoreImpl(RABBITMQ_MS_FQN);

                setTextValue(rabbitMQStore.rabbitMQ_hostname, store.getParameters().get(STORE_RABBITMQ_HOST_NAME));
                setTextValue(rabbitMQStore.rabbitMQ_port, store.getParameters().get(STORE_RABBITMQ_HOST_PORT));
                setTextValue(rabbitMQStore.rabbitMQ_queueName, store.getParameters().get(STORE_RABBITMQ_QUEUE_NAME));
                setTextValue(rabbitMQStore.rabbitMQ_exchangeName,
                        store.getParameters().get(STORE_RABBITMQ_EXCHANGE_NAME));
                setTextValue(rabbitMQStore.rabbitMQ_routingKey, store.getParameters().get(STORE_RABBITMQ_ROUTE_KEY));
                setTextValue(rabbitMQStore.rabbitMQ_username, store.getParameters().get(STORE_RABBITMQ_USERNAME));
                setTextValue(rabbitMQStore.rabbitMQ_password, store.getParameters().get(STORE_RABBITMQ_PASSWORD));
                setTextValue(rabbitMQStore.rabbitMQ_virtualhost,
                        store.getParameters().get(STORE_RABBITMQ_VIRTUAL_HOST));

                if (store.getParameters().get(STORE_RABBITMQ_SSL_ENABLED) == null) {
                    rabbitMQStore.rabbitMQ_sslEnabled.select(1);
                    rabbitMQStore.setSSLFields(false);
                } else {
                    if (store.getParameters().get(STORE_RABBITMQ_SSL_ENABLED).toString().equalsIgnoreCase("false")) {
                        rabbitMQStore.rabbitMQ_sslEnabled.select(1);
                        rabbitMQStore.setSSLFields(false);
                    } else {
                        rabbitMQStore.rabbitMQ_sslEnabled.select(0);
                        rabbitMQStore.setSSLFields(true);
                        setTextValue(rabbitMQStore.rabbitMQ_keyStoreLocation,
                                store.getParameters().get(STORE_RABBITMQ_SSL_KEYSTORE_LOCATION));
                        setTextValue(rabbitMQStore.rabbitMQ_keyStoreType,
                                store.getParameters().get(STORE_RABBITMQ_SSL_KEYSTORE_TYPE));
                        setTextValue(rabbitMQStore.rabbitMQ_keyStorePassword,
                                store.getParameters().get(STORE_RABBITMQ_SSL_KEYSTORE_PASSWORD));
                        setTextValue(rabbitMQStore.rabbitMQ_trustStoreLocation,
                                store.getParameters().get(STORE_RABBITMQ_SSL_TRUSTSTORE_LOCATION));
                        setTextValue(rabbitMQStore.rabbitMQ_trustStoreType,
                                store.getParameters().get(STORE_RABBITMQ_SSL_TRUSTSTORE_TYPE));
                        setTextValue(rabbitMQStore.rabbitMQ_trustStorePassword,
                                store.getParameters().get(STORE_RABBITMQ_SSL_TRUSTSTORE_PASSWORD));
                        setTextValue(rabbitMQStore.rabbitMQ_sslVersion,
                                store.getParameters().get(STORE_RABBITMQ_SSL_VERSION));
                    }
                }

            } else if (dummyMessageStore.getClassName().equalsIgnoreCase(JDBC_MS_FQN)) {
                messageStorePage.storeType.select(4);

                JDBC jdbcStore = (JDBC) messageStorePage.getStoreImpl(JDBC_MS_FQN);

                setTextValue(jdbcStore.jdbc_dbTable, store.getParameters().get(STORE_JDBC_TABLE));
                if (store.getParameters().get(STORE_JDBC_DS_NAME) != null) {
                    jdbcStore.jdbc_connectionInfo.select(1);
                    jdbcStore.setDataSourceFields(true);
                    setTextValue(jdbcStore.jdbc_DsName, store.getParameters().get(STORE_JDBC_DS_NAME));
                } else if (store.getParameters().get(STORE_JDBC_DRIVER) != null
                        || store.getParameters().get(STORE_JDBC_CONNECTION_URL) != null
                        || store.getParameters().get(STORE_JDBC_USERNAME) != null
                        || store.getParameters().get(STORE_JDBC_PASSWORD) != null) {
                    jdbcStore.jdbc_connectionInfo.select(0);
                    jdbcStore.setPoolingFields(true);
                    setTextValue(jdbcStore.jdbc_driver, store.getParameters().get(STORE_JDBC_DRIVER));
                    setTextValue(jdbcStore.jdbc_url, store.getParameters().get(STORE_JDBC_CONNECTION_URL));
                    setTextValue(jdbcStore.jdbc_username, store.getParameters().get(STORE_JDBC_USERNAME));
                    setTextValue(jdbcStore.jdbc_password, store.getParameters().get(STORE_JDBC_PASSWORD));
                }
            } else if (dummyMessageStore.getClassName().equalsIgnoreCase(RESEQUENCE_MS_FQN)) {
                messageStorePage.storeType.select(5);

                Resequence resquenceStore = (Resequence) messageStorePage.getStoreImpl(RESEQUENCE_MS_FQN);
                setTextValue(resquenceStore.resequence_dbTable, store.getParameters().get(STORE_RESEQUENCE_TABLE));
                setTextValue(resquenceStore.resequence_poll_count,
                        store.getParameters().get(STORE_RESEQUENCE_POLLING_COUNT));
                setXPathValue(resquenceStore, resquenceStore.resequence_xpath,
                        store.getParameters().get(STORE_RESEQUENCE_XPATH));
                if (store.getParameters().get(STORE_RESEQUENCE_DS_NAME) != null) {
                    resquenceStore.resequence_connectionInfo.select(1);
                    resquenceStore.setDataSourceFields(true);
                    setTextValue(resquenceStore.resequence_DsName, store.getParameters().get(STORE_RESEQUENCE_DS_NAME));
                } else if (store.getParameters().get(STORE_RESEQUENCE_DRIVER) != null
                        || store.getParameters().get(STORE_RESEQUENCE_CONNECTION_URL) != null
                        || store.getParameters().get(STORE_JDBC_USERNAME) != null
                        || store.getParameters().get(STORE_JDBC_PASSWORD) != null) {
                    resquenceStore.resequence_connectionInfo.select(0);
                    resquenceStore.setPoolingFields(true);
                    setTextValue(resquenceStore.resequence_driver, store.getParameters().get(STORE_RESEQUENCE_DRIVER));
                    setTextValue(resquenceStore.resequence_url,
                            store.getParameters().get(STORE_RESEQUENCE_CONNECTION_URL));
                    setTextValue(resquenceStore.resequence_username,
                            store.getParameters().get(STORE_RESEQUENCE_USERNAME));
                    setTextValue(resquenceStore.resequence_password,
                            store.getParameters().get(STORE_RESEQUENCE_PASSWORD));
                }
            } else {
                messageStorePage.storeType.select(6);

                CustomStore customStoreImpl = (CustomStore) messageStorePage.getStoreImpl(customStore);

                setTextValue(customStoreImpl.custom_providerClass, dummyMessageStore.getClassName());
                if (!dummyMessageStore.getParameters().entrySet().isEmpty()) {
                    List<MessageStoreParameter> existingProperties = customStoreImpl.messageStoreParameterList;
                    List<MessageStoreParameter> newlyAddedProperties = new ArrayList<MessageStoreParameter>();
                    List<MessageStoreParameter> removedProperties = new ArrayList<MessageStoreParameter>();
                    List<MessageStoreParameter> newProperties = new ArrayList<MessageStoreParameter>();

                    for (Entry<String, Object> param : dummyMessageStore.getParameters().entrySet()) {
                        MessageStoreParameter parameter = EsbFactory.eINSTANCE.createMessageStoreParameter();
                        parameter.setParameterName(param.getKey());
                        parameter.setParameterValue(param.getValue().toString());

                        if (existingProperties != null) {
                            for (MessageStoreParameter propertyItem : existingProperties) {
                                // When updating the existing properties from
                                // source view, then remove the property
                                // from old list and add to new list
                                if (propertyItem.getParameterName().equals(param.getKey())) {
                                    existingProperties.remove(propertyItem);
                                    newlyAddedProperties.add(parameter);
                                    break;
                                }
                            }
                        }
                        // When adding a new property from source then add it to
                        // the new list
                        if (!newlyAddedProperties.contains(parameter)) {
                            newlyAddedProperties.add(parameter);
                        }
                    }

                    // If old properties contain any property values, then
                    // remove the value and add the property to the
                    // new
                    // list, DEVTOOLESB-505
                    if (existingProperties != null) {
                        for (MessageStoreParameter prop : existingProperties) {
                            String value = prop.getParameterName();
                            String name = prop.getParameterName();
                            if (StringUtils.isNotEmpty(value)) {
                                // Add the property to removed list
                                removedProperties.add(prop);
                                /*
                                 * MessageStoreParameter newPrp =
                                 * createProperty(name); if
                                 * (!newlyAddedProperties.contains(newPrp)) { //
                                 * Add to the new properties list
                                 * newProperties.add(newPrp); }
                                 */
                            }
                        }
                    }
                    // First remove the removed properties from existing
                    // properties
                    if (removedProperties.size() > 0) {
                        existingProperties.removeAll(removedProperties);
                    }
                    // Adds the new properties
                    if (newProperties.size() > 0) {
                        newlyAddedProperties.addAll(newProperties);
                    }
                    // Adds the existing old properties (which didn't get
                    // updated)
                    // to the new list
                    if (existingProperties != null) {
                        newlyAddedProperties.addAll(existingProperties);
                    }
                    customStoreImpl.messageStoreParameterList = newlyAddedProperties;
                } else {
                    // When removing all properties from the source view then
                    // clear the list
                    customStoreImpl.messageStoreParameterList = null;
                }
            }

            // Refresh settings of the message processor
            messageStorePage.refreshStoreSettings();
        }

    }

    /**
     * Creates a new property
     * 
     * @param name
     * @return
     */
    private MessageStoreParameter createProperty(String name) {
        MessageStoreParameter newPrp = EsbFactory.eINSTANCE.createMessageStoreParameter();
        newPrp.setParameterName(name);
        newPrp.setParameterValue(null);
        return newPrp;
    }

    private void setTextValue(Text textField, Object value) {
        if (value != null) {
            textField.setText(value.toString());
        }
    }

    private void setXPathValue(IMessageStore storeImpl, Text textField, Object value) {
        if (value != null && value instanceof SynapseXPath) {
            textField.setText(((SynapseXPath) value).getExpression());
            if (storeImpl instanceof Resequence) {
                ((Resequence) storeImpl).nsp.setNamespaces(((SynapseXPath) value).getNamespaces());
            }
        }
    }
}
