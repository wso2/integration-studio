/*
 * Copyright (c) WSO2, Inc. (http://wso2.com)
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.config.xml.MessageStoreSerializer;
import org.apache.synapse.message.store.impl.memory.InMemoryStore;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.forms.editor.FormPage;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.esb.form.editors.article.rcp.MessageStoreFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.CustomStore;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.JDBC;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.JMS;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.RabbitMQ;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.Resequence;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.WSO2MB;

public class MessageStoreTransformer {

    private static final Log log = LogFactory.getLog(MessageStoreTransformer.class);

    private static final String STORE_JMS_CACHE_CONNECTION = "store.jms.cache.connection";
    private static final String STORE_JMS_JMS_SPEC_VERSION = "store.jms.JMSSpecVersion";
    private static final String STORE_JMS_PASSWORD = "store.jms.password";
    private static final String STORE_JMS_USERNAME = "store.jms.username";
    private static final String STORE_JMS_CONNECTION_FACTORY = "store.jms.connection.factory";
    private static final String STORE_JMS_DESTINATION = "store.jms.destination";

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

    // private static final String RABBITMQ_MS_FQN = "org.apache.synapse.message.store.impl.rabbitmq.RabbitMQStore";
    // private static final String JDBC_MS_FQN = "org.apache.synapse.message.store.impl.jdbc.JDBCMessageStore";

    private static final String STORE_FAILOVER_MESSAGE_STORE_NAME = "store.failover.message.store.name";
    private static final String STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE = "store.producer.guaranteed.delivery.enable";

    // Message Store types
    private static final String IN_MEMORY_MS_FQN = "org.apache.synapse.message.store.impl.memory.InMemoryStore";
    private static final String JMS_MS_FQN = "org.apache.synapse.message.store.impl.jms.JmsStore";
    private static final String WSO2MB = "wso2mb";
    private static final String RABBITMQ_MS_FQN = "org.apache.synapse.message.store.impl.rabbitmq.RabbitMQStore";
    private static final String JDBC_MS_FQN = "org.apache.synapse.message.store.impl.jdbc.JDBCMessageStore";
    private static final String RESEQUENCE_MS_FQN = "org.apache.synapse.message.store.impl.resequencer.ResequenceMessageStore";
    private static final String customStore = "customStore";

    @Deprecated
    public static OMElement createMessageStore(MessageStore model) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        String className = null;

        org.apache.synapse.message.store.MessageStore messageStore = new InMemoryStore();
        messageStore.setName(model.getStoreName());

        if (model.getStoreType() == MessageStoreType.CUSTOM) {
            className = model.getProviderClass();
            EList<MessageStoreParameter> parameters2 = model.getParameters();
            for (MessageStoreParameter param : parameters2) {
                if (!StringUtils.isBlank(param.getParameterName()) && !StringUtils.isBlank(param.getParameterValue())) {
                    parameters.put(param.getParameterName(), param.getParameterValue());
                }
            }
        } else if (model.getStoreType() == MessageStoreType.JMS) {
            className = "org.apache.synapse.message.store.impl.jms.JmsStore";
            if (!StringUtils.isBlank(model.getInitialContextFactory())) {
                parameters.put("java.naming.factory.initial", model.getInitialContextFactory());
            }
            if (!StringUtils.isBlank(model.getProviderURL())) {
                parameters.put("java.naming.provider.url", model.getProviderURL());
            }
            if (!StringUtils.isBlank(model.getJndiQueueName())) {
                parameters.put("store.jms.destination", model.getJndiQueueName());
            }
            if (!StringUtils.isBlank(model.getConnectionFactory())) {
                parameters.put("store.jms.connection.factory", model.getConnectionFactory());
            }
            if (!StringUtils.isBlank(model.getUserName())) {
                parameters.put("store.jms.username", model.getUserName());
            }
            if (!StringUtils.isBlank(model.getPassword())) {
                parameters.put("store.jms.password", model.getPassword());
            }

            parameters.put("store.jms.JMSSpecVersion", model.getJmsSpecVersion().getLiteral());
            parameters.put("store.jms.cache.connection", ((Boolean) model.isEnableCaching()).toString());

            if (StringUtils.isNotBlank(model.getFailoverMessageStore())) {
                parameters.put(STORE_FAILOVER_MESSAGE_STORE_NAME, model.getFailoverMessageStore());
            }
            parameters.put(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE,
                    ((Boolean) model.isEnableProducerGuaranteedDelivery()).toString());

            /*
             * Any additional parameters not listed above will handle here Fixing TOOLS-2286
             */
            EList<MessageStoreParameter> additionalParameters = model.getParameters();
            for (MessageStoreParameter additionalParameter : additionalParameters) {
                if (!StringUtils.isBlank(additionalParameter.getParameterName())
                        && !StringUtils.isBlank(additionalParameter.getParameterValue())) {
                    parameters.put(additionalParameter.getParameterName(), additionalParameter.getParameterValue());
                }
            }
        } else if (model.getStoreType() == MessageStoreType.RABBITMQ) {
            className = RABBITMQ_MS_FQN;
            if (StringUtils.isNotBlank(model.getRabbitMQServerHostName())) {
                parameters.put(STORE_RABBITMQ_HOST_NAME, model.getRabbitMQServerHostName());
            }
            if (StringUtils.isNotBlank(model.getRabbitMQServerHostPort())) {
                parameters.put(STORE_RABBITMQ_HOST_PORT, model.getRabbitMQServerHostPort());
            }
            if (StringUtils.isNotBlank(model.getRabbitMQQueueName())) {
                parameters.put(STORE_RABBITMQ_QUEUE_NAME, model.getRabbitMQQueueName());
            }
            if (StringUtils.isNotBlank(model.getRabbitMQExchangeName())) {
                parameters.put(STORE_RABBITMQ_EXCHANGE_NAME, model.getRabbitMQExchangeName());
            }
            if (StringUtils.isNotBlank(model.getRoutingKey())) {
                parameters.put(STORE_RABBITMQ_ROUTE_KEY, model.getRoutingKey());
            }
            if (StringUtils.isNotBlank(model.getRabbitMQUserName())) {
                parameters.put(STORE_RABBITMQ_USERNAME, model.getRabbitMQUserName());
            }
            if (StringUtils.isNotBlank(model.getRabbitMQPassword())) {
                parameters.put(STORE_RABBITMQ_PASSWORD, model.getRabbitMQPassword());
            }
            if (StringUtils.isNotBlank(model.getVirtualHost())) {
                parameters.put(STORE_RABBITMQ_VIRTUAL_HOST, model.getVirtualHost());
            }
            if (StringUtils.isNotBlank(model.getFailoverMessageStore())) {
                parameters.put(STORE_FAILOVER_MESSAGE_STORE_NAME, model.getFailoverMessageStore());
            }
            parameters.put(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE,
                    ((Boolean) model.isEnableProducerGuaranteedDelivery()).toString());
        } else if (model.getStoreType() == MessageStoreType.JDBC) {
            className = JDBC_MS_FQN;
            if (StringUtils.isNotBlank(model.getJdbcDatabaseTable())) {
                parameters.put(STORE_JDBC_TABLE, model.getJdbcDatabaseTable());
            }
            if (StringUtils.isNotBlank(model.getFailoverMessageStore())) {
                parameters.put(STORE_FAILOVER_MESSAGE_STORE_NAME, model.getFailoverMessageStore());
            }
            parameters.put(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE,
                    ((Boolean) model.isEnableProducerGuaranteedDelivery()).toString());
            // Switch between connection pool and datasource
            String jdbcConnectionInformation = model.getJdbcConnectionInformation().toString();
            if (StringUtils.isNotBlank(jdbcConnectionInformation)) {
                if (JDBCConnectionInformationType.JDBC_POOL.toString().equals(jdbcConnectionInformation)) {
                    if (StringUtils.isNotBlank(model.getJdbcDriver())) {
                        parameters.put(STORE_JDBC_DRIVER, model.getJdbcDriver());
                    }
                    if (StringUtils.isNotBlank(model.getJdbcURL())) {
                        parameters.put(STORE_JDBC_CONNECTION_URL, model.getJdbcURL());
                    }
                    if (StringUtils.isNotBlank(model.getJdbcUser())) {
                        parameters.put(STORE_JDBC_USERNAME, model.getJdbcUser());
                    }
                    if (StringUtils.isNotBlank(model.getJdbcPassword())) {
                        parameters.put(STORE_JDBC_PASSWORD, model.getJdbcPassword());
                    }
                } else if (JDBCConnectionInformationType.JDBC_CARBON_DATASOURCE.toString()
                        .equals(jdbcConnectionInformation)) {
                    if (StringUtils.isNotBlank(model.getJdbcDatasourceName())) {
                        parameters.put(STORE_JDBC_DS_NAME, model.getJdbcDatasourceName());
                    }
                }
            }
        } else if (model.getStoreType() == MessageStoreType.RESEQUENCE) {
            className = RESEQUENCE_MS_FQN;
            if (StringUtils.isNotBlank(model.getResequenceDatabaseTable())) {
                parameters.put(STORE_RESEQUENCE_TABLE, model.getResequenceDatabaseTable());
            }
            if (StringUtils.isNotBlank(model.getFailoverMessageStore())) {
                parameters.put(STORE_FAILOVER_MESSAGE_STORE_NAME, model.getFailoverMessageStore());
            }
            if (StringUtils.isNotBlank(model.getResequencepolling())) {
                parameters.put(STORE_RESEQUENCE_POLLING_COUNT, model.getResequencepolling());
            }
            if (StringUtils.isNotBlank(model.getResequenceXpathAttr().getPropertyValue())) {
                SynapseXPath xpath;
                try {
                    xpath = (SynapseXPath) CustomSynapsePathFactory
                            .getSynapsePath(model.getResequenceXpathAttr().getPropertyValue());
                    if (model.getResequenceXpathAttr().getNamespaces() != null) {
                        Map<String, String> map = model.getResequenceXpathAttr().getNamespaces();
                        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
                        while (entries.hasNext()) {
                            Map.Entry<String, String> entry = entries.next();
                            xpath.addNamespace(entry.getKey(), entry.getValue());
                        }
                    }
                    parameters.put(STORE_RESEQUENCE_XPATH, xpath);
                } catch (JaxenException e) {
                    log.error("Cannot create resequence xpaths", e);
                }
            }
            parameters.put(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE,
                    ((Boolean) model.isEnableProducerGuaranteedDelivery()).toString());
            // Switch between connection pool and datasource
            String resequenceConnectionInformation = model.getResequenceConnectionInformation().toString();
            if (StringUtils.isNotBlank(resequenceConnectionInformation)) {
                if (JDBCConnectionInformationType.JDBC_POOL.toString().equals(resequenceConnectionInformation)) {
                    if (StringUtils.isNotBlank(model.getResequenceDriver())) {
                        parameters.put(STORE_RESEQUENCE_DRIVER, model.getResequenceDriver());
                    }
                    if (StringUtils.isNotBlank(model.getResequenceURL())) {
                        parameters.put(STORE_RESEQUENCE_CONNECTION_URL, model.getResequenceURL());
                    }
                    if (StringUtils.isNotBlank(model.getResequenceUser())) {
                        parameters.put(STORE_RESEQUENCE_USERNAME, model.getResequenceUser());
                    }
                    if (StringUtils.isNotBlank(model.getResequencePassword())) {
                        parameters.put(STORE_RESEQUENCE_PASSWORD, model.getResequencePassword());
                    }
                } else if (JDBCConnectionInformationType.JDBC_CARBON_DATASOURCE.toString()
                        .equals(resequenceConnectionInformation)) {
                    if (StringUtils.isNotBlank(model.getResequenceDatasourceName())) {
                        parameters.put(STORE_RESEQUENCE_DS_NAME, model.getResequenceDatasourceName());
                    }
                }
            }
        }

        messageStore.setParameters(parameters);

        OMElement messageStoreElement = MessageStoreSerializer.serializeMessageStore(null, messageStore);
        OMAttribute classAttr = messageStoreElement.getAttribute(new QName("class"));
        if (classAttr != null) {
            classAttr.setAttributeValue(className);
        } else if (!StringUtils.isBlank(className)) {
            messageStoreElement.addAttribute("class", className, null);
        } else {
            /*
             * Class attribute is optional for In-Memory Store. If class attribute is not defined it will be considered
             * as an In-Memory Store.
             */
        }

        return messageStoreElement;

    }

    public OMElement createMessageStore(FormPage visualForm) {

        org.apache.synapse.message.store.MessageStore messageStore = new org.apache.synapse.message.store.impl.memory.InMemoryStore();

        OMElement configXml = null;
        Map<String, Object> parameterMap = new HashMap<>();
        String className = "";

        if (visualForm instanceof MessageStoreFormPage) {

            MessageStoreFormPage formPage = (MessageStoreFormPage) visualForm;

            if (formPage.storeName.getText().length() > 0) {

                int storeIndex = formPage.storeType.getSelectionIndex();

                switch (storeIndex) {
                case 0: {
                    // In-Memory store
                    className = IN_MEMORY_MS_FQN;

                    break;
                }
                case 1: {
                    // JMS Store
                    className = JMS_MS_FQN;
                    JMS jmsStore = (JMS) formPage.getStoreImpl(JMS_MS_FQN);

                    if (!StringUtils.isBlank(jmsStore.jms_initCtxFactory.getText())) {
                        parameterMap.put(JAVA_NAMING_FACTORY_INITIAL, jmsStore.jms_initCtxFactory.getText());
                    }
                    if (!StringUtils.isBlank(jmsStore.jms_providerUrl.getText())) {
                        parameterMap.put(JAVA_NAMING_PROVIDER_URL, jmsStore.jms_providerUrl.getText());
                    }

                    if (!StringUtils.isBlank(jmsStore.jms_jndiQueueName.getText())) {
                        parameterMap.put(STORE_JMS_DESTINATION, jmsStore.jms_jndiQueueName.getText());
                    }
                    if (!StringUtils.isBlank(jmsStore.jms_connectionFactory.getText())) {
                        parameterMap.put(STORE_JMS_CONNECTION_FACTORY, jmsStore.jms_connectionFactory.getText());
                    }
                    if (!StringUtils.isBlank(jmsStore.jms_username.getText())) {
                        parameterMap.put(STORE_JMS_USERNAME, jmsStore.jms_username.getText());
                    }
                    if (!StringUtils.isBlank(jmsStore.jms_password.getText())) {
                        parameterMap.put(STORE_JMS_PASSWORD, jmsStore.jms_password.getText());
                    }
                    if (!StringUtils.isBlank(jmsStore.jms_cacheConnection.getText())) {
                        parameterMap.put(STORE_JMS_CACHE_CONNECTION, jmsStore.jms_cacheConnection.getText());
                    }
                    if (!StringUtils.isBlank(jmsStore.jms_apiVersion.getText())) {
                        parameterMap.put(STORE_JMS_JMS_SPEC_VERSION, jmsStore.jms_apiVersion.getText());
                    }

                    break;
                }
                case 2: {
                    // WSO2 MB Store
                    className = JMS_MS_FQN;
                    WSO2MB wso2mbStore = (WSO2MB) formPage.getStoreImpl(WSO2MB);

                    parameterMap.put(JAVA_NAMING_FACTORY_INITIAL, wso2mbStore.wso2mb_initCtxFactory.getText());
                    parameterMap.put(STORE_WSO2MB_QUEUE_CONNECTION_FACTORY,
                            wso2mbStore.wso2mb_QueueConnFactory.getText());

                    parameterMap.put(STORE_JMS_DESTINATION, wso2mbStore.wso2mb_jndiQueueName.getText());

                    parameterMap.put(STORE_JMS_JMS_SPEC_VERSION, wso2mbStore.wso2mb_apiVersion.getText());
                    parameterMap.put(STORE_JMS_CACHE_CONNECTION, wso2mbStore.mb_cacheConnection.getText());

                    break;
                }
                case 3: {
                    // Rabbit-MQ Store
                    className = RABBITMQ_MS_FQN;
                    RabbitMQ rabbitMQStore = (RabbitMQ) formPage.getStoreImpl(RABBITMQ_MS_FQN);

                    parameterMap.put(STORE_RABBITMQ_HOST_NAME, rabbitMQStore.rabbitMQ_hostname.getText());
                    parameterMap.put(STORE_RABBITMQ_HOST_PORT, rabbitMQStore.rabbitMQ_port.getText());
                    parameterMap.put(STORE_RABBITMQ_QUEUE_NAME, rabbitMQStore.rabbitMQ_queueName.getText());
                    parameterMap.put(STORE_RABBITMQ_EXCHANGE_NAME, rabbitMQStore.rabbitMQ_exchangeName.getText());
                    parameterMap.put(STORE_RABBITMQ_ROUTE_KEY, rabbitMQStore.rabbitMQ_routingKey.getText());
                    parameterMap.put(STORE_RABBITMQ_USERNAME, rabbitMQStore.rabbitMQ_username.getText());
                    parameterMap.put(STORE_RABBITMQ_PASSWORD, rabbitMQStore.rabbitMQ_password.getText());
                    parameterMap.put(STORE_RABBITMQ_VIRTUAL_HOST, rabbitMQStore.rabbitMQ_virtualhost.getText());

                    if (rabbitMQStore.rabbitMQ_sslEnabled.getSelectionIndex() == 0) {
                        parameterMap.put(STORE_RABBITMQ_SSL_ENABLED,
                                rabbitMQStore.rabbitMQ_sslEnabled.getText().toLowerCase());
                        parameterMap.put(STORE_RABBITMQ_SSL_KEYSTORE_LOCATION,
                                rabbitMQStore.rabbitMQ_keyStoreLocation.getText());
                        parameterMap.put(STORE_RABBITMQ_SSL_KEYSTORE_TYPE,
                                rabbitMQStore.rabbitMQ_keyStoreType.getText());
                        parameterMap.put(STORE_RABBITMQ_SSL_KEYSTORE_PASSWORD,
                                rabbitMQStore.rabbitMQ_keyStorePassword.getText());
                        parameterMap.put(STORE_RABBITMQ_SSL_TRUSTSTORE_LOCATION,
                                rabbitMQStore.rabbitMQ_trustStoreLocation.getText());
                        parameterMap.put(STORE_RABBITMQ_SSL_TRUSTSTORE_TYPE,
                                rabbitMQStore.rabbitMQ_trustStoreType.getText());
                        parameterMap.put(STORE_RABBITMQ_SSL_TRUSTSTORE_PASSWORD,
                                rabbitMQStore.rabbitMQ_trustStorePassword.getText());
                        parameterMap.put(STORE_RABBITMQ_SSL_VERSION, rabbitMQStore.rabbitMQ_sslVersion.getText());
                    } else {
                        parameterMap.put(STORE_RABBITMQ_SSL_ENABLED,
                                rabbitMQStore.rabbitMQ_sslEnabled.getText().toLowerCase());
                    }

                    break;
                }
                case 4: {
                    // JDBC Store
                    className = JDBC_MS_FQN;
                    JDBC jdbcStore = (JDBC) formPage.getStoreImpl(JDBC_MS_FQN);
                    parameterMap.put(STORE_JDBC_TABLE, jdbcStore.jdbc_dbTable.getText());
                    if (jdbcStore.jdbc_connectionInfo.getSelectionIndex() == 0) {
                        parameterMap.put(STORE_JDBC_DRIVER, jdbcStore.jdbc_driver.getText());
                        parameterMap.put(STORE_JDBC_CONNECTION_URL, jdbcStore.jdbc_url.getText());
                        parameterMap.put(STORE_JDBC_USERNAME, jdbcStore.jdbc_username.getText());
                        parameterMap.put(STORE_JDBC_PASSWORD, jdbcStore.jdbc_password.getText());
                    } else {
                        parameterMap.put(STORE_JDBC_DS_NAME, jdbcStore.jdbc_DsName.getText());
                    }

                    break;
                }

                case 5: {
                    // Resequence Store
                    className = RESEQUENCE_MS_FQN;
                    Resequence resequenceStore = (Resequence) formPage.getStoreImpl(RESEQUENCE_MS_FQN);
                    parameterMap.put(STORE_RESEQUENCE_TABLE, resequenceStore.resequence_dbTable.getText());
                    if (resequenceStore.resequence_poll_count.getText().length() != 0) {
                        parameterMap.put(STORE_RESEQUENCE_POLLING_COUNT,
                                resequenceStore.resequence_poll_count.getText());
                    }
                    if (resequenceStore.resequence_xpath.getText().length() != 0) {
                        SynapseXPath xpath;
                        try {
                            xpath = new SynapseXPath(resequenceStore.resequence_xpath.getText());
                            Map<String, String> maps = resequenceStore.nsp.getNamespaces();
                            for (String key : maps.keySet()) {
                                xpath.addNamespace(key, maps.get(key));
                            }
                            parameterMap.put(STORE_RESEQUENCE_XPATH, xpath);
                        } catch (JaxenException e) {
                            log.error("Cannot create resequence xpaths", e);
                        }
                    }
                    if (resequenceStore.resequence_connectionInfo.getSelectionIndex() == 0) {
                        parameterMap.put(STORE_RESEQUENCE_DRIVER, resequenceStore.resequence_driver.getText());
                        parameterMap.put(STORE_RESEQUENCE_CONNECTION_URL, resequenceStore.resequence_url.getText());
                        parameterMap.put(STORE_RESEQUENCE_USERNAME, resequenceStore.resequence_username.getText());
                        parameterMap.put(STORE_RESEQUENCE_PASSWORD, resequenceStore.resequence_password.getText());
                    } else {
                        parameterMap.put(STORE_RESEQUENCE_DS_NAME, resequenceStore.resequence_DsName.getText());
                    }

                    break;
                }

                default: {
                    // Custom Store
                    CustomStore customStoreImpl = (CustomStore) formPage.getStoreImpl(customStore);

                    className = customStoreImpl.custom_providerClass.getText();
                    List<MessageStoreParameter> parameters = customStoreImpl.messageStoreParameterList;
                    if (parameters != null) {
                        for (MessageStoreParameter param : parameters) {
                            if (!StringUtils.isBlank(param.getParameterName())
                                    && !StringUtils.isBlank(param.getParameterValue())) {
                                parameterMap.put(param.getParameterName(), param.getParameterValue());
                            }
                        }
                    }

                    break;
                }
                }

                if (storeIndex == 1 || storeIndex == 2 || storeIndex == 3 || storeIndex == 4 || storeIndex == 5) {
                    parameterMap.put(STORE_PRODUCER_GUARANTEED_DELIVERY_ENABLE,
                            formPage.guaranteedDeliveryEnable.getText().toLowerCase());
                    if (!StringUtils.isBlank(formPage.failoverMessageStore.getText())) {
                        parameterMap.put(STORE_FAILOVER_MESSAGE_STORE_NAME, formPage.failoverMessageStore.getText());
                    }
                }

                messageStore.setName(formPage.storeName.getText());
                messageStore.setParameters(parameterMap);

                configXml = MessageStoreSerializer.serializeMessageStore(null, messageStore);
                OMAttribute classAttr = configXml.getAttribute(new QName("class"));
                if (classAttr != null) {
                    classAttr.setAttributeValue(className);
                } else if (!StringUtils.isBlank(className)) {
                    configXml.addAttribute("class", className, null);
                } else {
                    /*
                     * Class attribute is optional for In-Memory Store. If class attribute is not defined it will be
                     * considered as an In-Memory Store.
                     */
                }

            }

        }

        return configXml;
    }

}
