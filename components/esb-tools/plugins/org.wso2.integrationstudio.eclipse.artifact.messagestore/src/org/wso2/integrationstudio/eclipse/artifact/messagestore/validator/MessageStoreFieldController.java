/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.artifact.messagestore.validator;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IResource;
import org.wso2.integrationstudio.eclipse.artifact.messagestore.model.MessageStoreModel;
import org.wso2.integrationstudio.eclipse.artifact.messagestore.provider.JDBCConnectionInformationList.JDBCConnectionInformationType;
import org.wso2.integrationstudio.eclipse.artifact.messagestore.provider.DatabaseTypeList.DatabaseType;
import org.wso2.integrationstudio.eclipse.artifact.messagestore.provider.JMSProfileTypeList.JMSProfileType;
import org.wso2.integrationstudio.eclipse.artifact.messagestore.provider.MessageStoreTypeList.MessageStoreType;
import org.wso2.integrationstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.integrationstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.integrationstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.integrationstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import static org.wso2.integrationstudio.eclipse.artifact.messagestore.Constants.*;
import static org.wso2.integrationstudio.eclipse.artifact.messagestore.DefaultValueConstants.*;

/**
 * The controller class for message-store artifact wizard specific fields.
 */
public class MessageStoreFieldController extends AbstractFieldController {

    @Override
    public void validate(String key, Object value, ProjectDataModel model) throws FieldValidationException {
        boolean jms = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.JMS;
        boolean custom = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.CUSTOM;
        boolean rabbitmq = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.RABBITMQ;
        boolean jdbc = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.JDBC;
        boolean mb = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.WSO2_MB;
        boolean resequence = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.RESEQUENCE;

        boolean isCarbonDataSource = false;
        // Decide connection information type only if JDBC
        if (jdbc) {
            isCarbonDataSource = ((MessageStoreModel) model)
                    .getJdbcConnectionInformation() == JDBCConnectionInformationType.CARBON_DATASOURCE.name();
        }

        // Decide connection information type if Resequence
        if (resequence) {
            isCarbonDataSource = ((MessageStoreModel) model)
                    .getResequenceConnectionInformation() == JDBCConnectionInformationType.CARBON_DATASOURCE.name();
        }

        // Mandatory fields validation
        if (key.equals(FIELD_STORE_NAME)) {
            CommonFieldValidator.validateArtifactName(value);
        } else if (key.equals(FIELD_CUSTOM_PROVIDER_CLASS)) {
            if (custom) {
                CommonFieldValidator.validateJavaFQN(value);
            }
        } else if (key.equals(FIELD_JMS_CONTEXT_FACTORY)) {
            if (jms) {
                CommonFieldValidator.validateRequiredField(value, "JMS context factory cannot be empty");
            }
        } else if (key.equals(FIELD_JMS_NAMING_FACTORY_INITIAL)) {
            if (jms) {
                CommonFieldValidator.validateRequiredField(value, "Java Naming Factory initial cannot be empty");
            }
        } else if (key.equals(FIELD_MB_CONTEXT_FACTORY)) {
            if (mb) {
                CommonFieldValidator.validateRequiredField(value, "Java Naming Factory initial cannot be empty");
            }
        } else if (key.equals(FIELD_MB_CONNECTION_FACTORY)) {
            if (mb) {
                CommonFieldValidator.validateRequiredField(value, "Queue Connection Factory cannot be empty");
            }
        } else if (key.equals(FIELD_MB_QUEUE_NAME)) {
            if (mb) {
                CommonFieldValidator.validateRequiredField(value, "JNDI Queue Name cannot be empty");
            }
        } else if (key.equals(FIELD_JMS_PROVIDER_URL)) {
            if (jms) {
                validateJMSProviderURL(value);
            }
        } else if (key.equals(FIELD_JMS_TIMEOUT)) {
            if (jms) {
                if (!StringUtils.isNumeric(value.toString())) {
                    throw new FieldValidationException("Time-out value is invalid");
                }
            }
        } else if (key.equals(FIELD_RABBITMQ_SERVER_HOST_NAME)) {
            if (rabbitmq) {
                CommonFieldValidator.validateRequiredField(value, "RabbitMQ Server Host Name cannot be empty");
            }
        } else if (key.equals(FIELD_RABBITMQ_SERVER_HOST_PORT)) {
            if (rabbitmq) {
                CommonFieldValidator.validateRequiredField(value, "RabbitMQ Server Host Port cannot be empty");
            }
        } else if (key.equals(FIELD_JDBC_DATABASE_TABLE)) {
            if (jdbc) {
                CommonFieldValidator.validateRequiredField(value, "Database Table cannot be empty");
            }
        } else if (key.equals(FIELD_JDBC_DRIVER)) {
            if (jdbc && !isCarbonDataSource) {
                CommonFieldValidator.validateRequiredField(value, "JDBC Driver cannot be empty");
            }
        } else if (key.equals(FIELD_JDBC_URL)) {
            if (jdbc && !isCarbonDataSource) {
                CommonFieldValidator.validateRequiredField(value, "JDBC URL cannot be empty");
                CommonFieldValidator.isValidUrl(value.toString(), "JDBC");
            }
        } else if (key.equals(FIELD_JDBC_USER)) {
            if (jdbc && !isCarbonDataSource) {
                CommonFieldValidator.validateRequiredField(value, "JDBC User cannot be empty");
            }
        } else if (key.equals(FIELD_JDBC_DATASOURCE_NAME)) {
            if (jdbc && isCarbonDataSource) {
                CommonFieldValidator.validateRequiredField(value, "JDBC Datasource Name cannot be empty");
            }
        } else if (key.equals(FIELD_RESEQUENCER_DATABASE_TABLE) && resequence) {
            CommonFieldValidator.validateRequiredField(value, "Database Table cannot be empty");
        } else if (key.equals(FIELD_RESEQUENCER_POLLING_COUNT) && resequence && !StringUtils.isEmpty((String) value)
                && !StringUtils.isNumeric((String) value)) {
            throw new FieldValidationException("Polling count should be numeric");
        } else if (key.equals(FIELD_RESEQUENCER_DRIVER) && resequence && !isCarbonDataSource) {
            CommonFieldValidator.validateRequiredField(value, "Resequence Driver cannot be empty");
        } else if (key.equals(FIELD_RESEQUENCER_URL) && resequence && !isCarbonDataSource) {
            CommonFieldValidator.validateRequiredField(value, "Resequence URL cannot be empty");
            CommonFieldValidator.isValidUrl(value.toString(), "JDBC");
        } else if (key.equals(FIELD_RESEQUENCER_USER) && resequence && !isCarbonDataSource) {
            CommonFieldValidator.validateRequiredField(value, "Resequence User cannot be empty");
        } else if (key.equals(FIELD_RESEQUENCER_DATASOURCE_NAME) && resequence && isCarbonDataSource) {
            CommonFieldValidator.validateRequiredField(value, "Resequence Datasource Name cannot be empty");
        } else if (key.equals(FIELD_SAVE_LOCATION)) {
            IResource resource = (IResource) value;
            if (resource == null || !resource.exists())
                throw new FieldValidationException("Specified project or path doesn't exist.");
        } else if (key.equals(FIELD_IMPORT_FILE)) {
            CommonFieldValidator.validateImportFile(value);
        } else if (key.equals(FIELD_AVAILABLE_STORES)) {
            MessageStoreModel storeModel = (MessageStoreModel) model;
            if (null != storeModel.getAvailableStoreslist() && storeModel.getAvailableStoreslist().size() > 0) {
                if (null == storeModel.getSelectedStoresList() || storeModel.getSelectedStoresList().size() <= 0) {
                    throw new FieldValidationException("Please select at least one artifact");
                }
            }
        }
    }

    @Override
    public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
        List<String> updateFields = super.getUpdateFields(modelProperty, model);
        if (modelProperty.equals(FIELD_STORE_TYPE) || modelProperty.equals(FIELD_JDBC_CONNECTION_INFORMATION)
                || modelProperty.equals(FIELD_RABBITMQ_SSL_ENABLED)
                || modelProperty.equals(FIELD_RESEQUENCER_CONNECTION_INFORMATION)
                || modelProperty.equals(FIELD_JMS_PROFILE_TYPE) || modelProperty.equals(FIELD_JDBC_DATABASE_TYPE)
                || modelProperty.equals(FIELD_RESEQUENCER_DATABASE_TYPE)) {
            updateJMSDefaults(model, ((MessageStoreModel) model).getJmsProfileType());
            updateFields.add(FIELD_JMS_CONTEXT_FACTORY);
            updateFields.add(FIELD_JMS_PROVIDER_URL);
            updateFields.add(FIELD_JMS_QUEUE_NAME);
            updateFields.add(FIELD_JMS_CONNECTION_FACTORY);
            updateFields.add(FIELD_JMS_USER_NAME);
            updateFields.add(FIELD_JMS_PASSWORD);
            updateFields.add(FIELD_JMS_CACHE_CONNECTION);
            updateFields.add(FIELD_JMS_API_VERSION);
            updateFields.add(FIELD_JMS_QUEUE_NAME);
            updateFields.add(FIELD_JMS_ENABLE_CACHING);
            updateFields.add(FIELD_JMS_TIMEOUT);
            updateFields.add(FIELD_JMS_ENABLE_PRODUCER_GUARANTEED_DELIVERY);
            updateFields.add(FIELD_JMS_FAILOVER_MESSAGE_STORE);
            updateFields.add(FIELD_JMS_PROFILE_TYPE);

            updateFields.add(FIELD_MB_API_VERSION);
            updateFields.add(FIELD_MB_CONNECTION_FACTORY);
            updateFields.add(FIELD_MB_CONTEXT_FACTORY);
            updateFields.add(FIELD_MB_QUEUE_NAME);
            updateFields.add(FIELD_MB_ENABLE_PRODUCER_GUARANTEED_DELIVERY);
            updateFields.add(FIELD_MB_FAILOVER_MESSAGE_STORE);
            updateFields.add(FIELD_MB_CACHE_CONNECTION);

            updateRabbitMQDefaults(model);
            updateFields.add(FIELD_RABBITMQ_SERVER_HOST_NAME);
            updateFields.add(FIELD_RABBITMQ_SERVER_HOST_PORT);
            updateFields.add(FIELD_RABBITMQ_QUEUE_NAME);
            updateFields.add(FIELD_RABBITMQ_EXCHANGE_NAME);
            updateFields.add(FIELD_RABBITMQ_ROUTING_KEY);
            updateFields.add(FIELD_RABBITMQ_USER_NAME);
            updateFields.add(FIELD_RABBITMQ_PASSWORD);
            updateFields.add(FIELD_RABBITMQ_VIRTUAL_HOST);
            updateFields.add(FIELD_RABBITMQ_ENABLE_PRODUCER_GUARANTEED_DELIVERY);
            updateFields.add(FIELD_RABBITMQ_FAILOVER_MESSAGE_STORE);
            updateFields.add(FIELD_RABBITMQ_SSL_ENABLED);
            updateFields.add(FIELD_RABBITMQ_SSL_KEYSTORE_LOCATION);
            updateFields.add(FIELD_RABBITMQ_SSL_KEYSTORE_TYPE);
            updateFields.add(FIELD_RABBITMQ_SSL_KEYSTORE_PASSWORD);
            updateFields.add(FIELD_RABBITMQ_SSL_TRUSTSTORE_LOCATION);
            updateFields.add(FIELD_RABBITMQ_SSL_TRUSTSTORE_TYPE);
            updateFields.add(FIELD_RABBITMQ_SSL_TRUSTSTORE_PASSWORD);
            updateFields.add(FIELD_RABBITMQ_SSL_VERSION);

            updateJDBCDefaults(model, ((MessageStoreModel) model).getJdbcDatabaseType());
            updateFields.add(FIELD_JDBC_DATABASE_TABLE);
            updateFields.add(FIELD_JDBC_CONNECTION_INFORMATION);
            updateFields.add(FIELD_JDBC_DATABASE_TYPE);
            updateFields.add(FIELD_JDBC_DRIVER);
            updateFields.add(FIELD_JDBC_URL);
            updateFields.add(FIELD_JDBC_USER);
            updateFields.add(FIELD_JDBC_PASSWORD);
            updateFields.add(FIELD_JDBC_DATASOURCE_NAME);
            updateFields.add(FIELD_JDBC_ENABLE_PRODUCER_GUARANTEED_DELIVERY);
            updateFields.add(FIELD_JDBC_FAILOVER_MESSAGE_STORE);

            updateResequenceDefaults(model, ((MessageStoreModel) model).getResequenceDatabaseType());
            updateFields.add(FIELD_RESEQUENCER_DATABASE_TYPE);
            updateFields.add(FIELD_RESEQUENCER_DATABASE_TABLE);
            updateFields.add(FIELD_RESEQUENCER_CONNECTION_INFORMATION);
            updateFields.add(FIELD_RESEQUENCER_DRIVER);
            updateFields.add(FIELD_RESEQUENCER_URL);
            updateFields.add(FIELD_RESEQUENCER_USER);
            updateFields.add(FIELD_RESEQUENCER_PASSWORD);
            updateFields.add(FIELD_RESEQUENCER_DATASOURCE_NAME);
            updateFields.add(FIELD_RESEQUENCER_ENABLE_PRODUCER_GUARANTEED_DELIVERY);
            updateFields.add(FIELD_RESEQUENCER_FAILOVER_MESSAGE_STORE);
            updateFields.add(FIELD_RESEQUENCER_POLLING_COUNT);
            updateFields.add(FIELD_RESEQUENCER_XPATH);
            updateFields.add(FIELD_RESEQUENCER_XPATH_NAMESPACES);

            updateFields.add(FIELD_CUSTOM_PROVIDER_CLASS);
            updateFields.add(FIELD_CUSTOM_PARAMETERS);
        } else if (modelProperty.equals(FIELD_CREATE_ESB_PRJ)) {
            updateFields.add(FIELD_SAVE_LOCATION);
        } else if (modelProperty.equals(FIELD_IMPORT_FILE)) {
            updateFields.add(FIELD_AVAILABLE_STORES);
        }
        return updateFields;
    }

    @Override
    public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
        boolean visibleField = super.isVisibleField(modelProperty, model);
        if (modelProperty.startsWith(TXT_JMS_FIELD_PREFIX)) {
            visibleField = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.JMS;
        } else if (modelProperty.startsWith(TXT_CUSTOM_FIELD_PREFIX)) {
            visibleField = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.CUSTOM;
        } else if (modelProperty.startsWith(TXT_RABBITMQ_FIELD_PREFIX)) {

            if (((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.RABBITMQ) {
                // SSL enabled should always be visible
                if (modelProperty.equals(FIELD_RABBITMQ_SSL_ENABLED)) {
                    visibleField = true;
                } else {
                    boolean isSSLEnabled = ((MessageStoreModel) model).getRabbitMQSSLEnabled();
                    if (modelProperty.startsWith(TXT_RABBITMQ_SSL_FIELD_PREFIX)) {
                        visibleField = isSSLEnabled;
                    }
                }
            } else { // Non-RabbitMq message store type
                visibleField = false;
            }
        } else if (modelProperty.startsWith(TXT_MB_FIELD_PREFIX)) {
            visibleField = ((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.WSO2_MB;
        } else if (modelProperty.startsWith(TXT_JDBC_FIELD_PREFIX)) {
            // Checks if message store type is JDBC
            if (((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.JDBC) {
                // Database table and Connection information should always be visible
                if (modelProperty.equals(FIELD_JDBC_DATABASE_TABLE)
                        || modelProperty.equals(FIELD_JDBC_CONNECTION_INFORMATION)) {
                    visibleField = true;
                } else {
                    boolean isCarbonDataSource = ((MessageStoreModel) model)
                            .getJdbcConnectionInformation() == JDBCConnectionInformationType.CARBON_DATASOURCE.name();
                    // Carbon data source enables datasource name field only
                    if (modelProperty.equals(FIELD_JDBC_DATASOURCE_NAME)) {
                        visibleField = isCarbonDataSource;
                    } else { // Other fields
                        visibleField = !isCarbonDataSource;
                    }
                }
            } else { // Non-JDBC message store type
                visibleField = false;
            }
        } else if (modelProperty.startsWith(TXT_RESEQUENCER_FIELD_PREFIX)) {
            // Checks if message store type is Resequence
            if (((MessageStoreModel) model).getMessageStoreType() == MessageStoreType.RESEQUENCE) {
                // Database table and Connection information should always be visible
                if (modelProperty.equals(FIELD_RESEQUENCER_DATABASE_TABLE)
                        || modelProperty.equals(FIELD_RESEQUENCER_CONNECTION_INFORMATION)
                        || modelProperty.equals(FIELD_RESEQUENCER_POLLING_COUNT)
                        || modelProperty.equals(FIELD_RESEQUENCER_XPATH)
                        || modelProperty.equals(FIELD_RESEQUENCER_XPATH_NAMESPACES)) {
                    visibleField = true;
                } else {
                    boolean isCarbonDataSource = ((MessageStoreModel) model)
                            .getResequenceConnectionInformation() == JDBCConnectionInformationType.CARBON_DATASOURCE
                                    .name();
                    // Carbon data source enables datasource name field only
                    if (modelProperty.equals(FIELD_RESEQUENCER_DATASOURCE_NAME)) {
                        visibleField = isCarbonDataSource;
                    } else { // Other fields
                        visibleField = !isCarbonDataSource;
                    }
                }
            } else { // Non-Resequence message store type
                visibleField = false;
            }
        } else if (modelProperty.equals(FIELD_AVAILABLE_STORES)) {
            List<OMElement> availableStores = ((MessageStoreModel) model).getAvailableStoreslist();
            visibleField = (availableStores != null && availableStores.size() > 0);
        }

        return visibleField;
    }

    @Override
    public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
        boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
        if (modelProperty.equals(FIELD_SAVE_LOCATION)) {
            readOnlyField = true;
        }
        return readOnlyField;
    }

    /**
     * Updates JMS defaults based on the selected profile
     * 
     * @param model Project Data Model
     * @param jmsProfileType JMS Profile Type
     */
    private void updateJMSDefaults(ProjectDataModel model, JMSProfileType jmsProfileType) {
        MessageStoreModel storeModel = (MessageStoreModel) model;
        if (jmsProfileType == JMSProfileType.WSO2_BROKER) {
            storeModel.setJmsContextFactory(JMS_CONTEXT_FACTORY_WSO2_BROKER);
            storeModel.setJmsProviderUrl(JMS_PROVIDER_URL_WSO2_BROKER);
            storeModel.setJmsConnectionFactory(JMS_CONNECTION_FACTORY_WSO2_BROKER);
        } else if (jmsProfileType == JMSProfileType.ACTIVEMQ) {
            storeModel.setJmsContextFactory(JMS_CONTEXT_FACTORY_ACTIVEMQ);
            storeModel.setJmsProviderUrl(JMS_PROVIDER_URL_ACTIVEMQ);
            storeModel.setJmsConnectionFactory(JMS_CONNECTION_FACTORY_ACTIVEMQ);
        } else {
            storeModel.setJmsContextFactory(EMPTY_STRING);
            storeModel.setJmsProviderUrl(EMPTY_STRING);
            storeModel.setJmsConnectionFactory(EMPTY_STRING);
        }
    }

    /**
     * Updates JDBC defaults based on the selected database type
     * 
     * @param model Project Data Model
     * @param jdbcDatabaseType JDBC Database Type
     */
    private void updateJDBCDefaults(ProjectDataModel model, DatabaseType jdbcDatabaseType) {
        MessageStoreModel storeModel = (MessageStoreModel) model;
        if (jdbcDatabaseType == DatabaseType.MYSQL) {
            storeModel.setJdbcDriver(DATABASE_DRIVER_MYSQL);
            storeModel.setJdbcURL(DATABASE_URL_MYSQL);
            storeModel.setJdbcUser(DATABASE_USER_MYSQL);
        } else if (jdbcDatabaseType == DatabaseType.ORACLE) {
            storeModel.setJdbcDriver(DATABASE_DRIVER_ORACLE);
            storeModel.setJdbcURL(DATABASE_URL_ORACLE);
            storeModel.setJdbcUser(DATABASE_USER_ORACLE);
        } else if (jdbcDatabaseType == DatabaseType.MSSQL) {
            storeModel.setJdbcDriver(DATABASE_DRIVER_MSSQL);
            storeModel.setJdbcURL(DATABASE_URL_MSSQL);
            storeModel.setJdbcUser(DATABASE_USER_MSSQL);
        } else if (jdbcDatabaseType == DatabaseType.POSTGRESQL) {
            storeModel.setJdbcDriver(DATABASE_DRIVER_POSTGRESQL);
            storeModel.setJdbcURL(DATABASE_URL_POSTGRESQL);
            storeModel.setJdbcUser(DATABASE_USER_POSTGRESQL);
        } else if (jdbcDatabaseType == DatabaseType.OTHER) {
            storeModel.setJdbcDriver(EMPTY_STRING);
            storeModel.setJdbcURL(EMPTY_STRING);
            storeModel.setJdbcUser(EMPTY_STRING);
        }
    }

    /**
     * Updates RabbitMQ defaults
     * 
     * @param model Project Data Model
     */
    private void updateRabbitMQDefaults(ProjectDataModel model) {
        MessageStoreModel storeModel = (MessageStoreModel) model;
        storeModel.setRabbitMQServerHostName(RABBITMQ_SERVER_HOST_NAME);
        storeModel.setRabbitMQServerHostPort(RABBITMQ_SERVER_HOST_PORT);
        storeModel.setRabbitMQSSLTrustStoreType(RABBITMQ_SSL_TRUST_STORE_TYPE);
        storeModel.setRabbitMQSSLKeyStoreType(RABBITMQ_SSL_KEY_STORE_TYPE);
        storeModel.setRabbitMQSSLVersion(RABBITMQ_SSL_VERSION);
    }
    
    /**
     * Updates resequence defaults based on the selected database type
     * 
     * @param model Project Data Model
     * @param resequencerDatabaseType 
     */
    private void updateResequenceDefaults(ProjectDataModel model, DatabaseType resequencerDatabaseType) {
        MessageStoreModel storeModel = (MessageStoreModel) model;
        if (resequencerDatabaseType == DatabaseType.MYSQL) {
            storeModel.setResequenceDriver(DATABASE_DRIVER_MYSQL);
            storeModel.setResequenceURL(DATABASE_URL_MYSQL);
            storeModel.setResequenceUser(DATABASE_USER_MYSQL);
        } else if (resequencerDatabaseType == DatabaseType.ORACLE) {
            storeModel.setResequenceDriver(DATABASE_DRIVER_ORACLE);
            storeModel.setResequenceURL(DATABASE_URL_ORACLE);
            storeModel.setResequenceUser(DATABASE_USER_ORACLE);
        } else if (resequencerDatabaseType == DatabaseType.MSSQL) {
            storeModel.setResequenceDriver(DATABASE_DRIVER_MSSQL);
            storeModel.setResequenceURL(DATABASE_URL_MSSQL);
            storeModel.setResequenceUser(DATABASE_USER_MSSQL);
        } else if (resequencerDatabaseType == DatabaseType.POSTGRESQL) {
            storeModel.setResequenceDriver(DATABASE_DRIVER_POSTGRESQL);
            storeModel.setResequenceURL(DATABASE_URL_POSTGRESQL);
            storeModel.setResequenceUser(DATABASE_USER_POSTGRESQL);
        } else if (resequencerDatabaseType == DatabaseType.OTHER) {
            storeModel.setResequenceDriver(EMPTY_STRING);
            storeModel.setResequenceURL(EMPTY_STRING);
            storeModel.setResequenceUser(EMPTY_STRING);
        }
    }

	private void validateJMSProviderURL(Object value) throws FieldValidationException {
		String val = value.toString();
		String urlRegex = "(ftp|http|https|tcp):\\/\\/(\\w+:{0,1}\\w*@)?(\\S+)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?";
		String pathRegex = "^((\\/|\\.\\.\\/|[a-zA-Z0-9_/\\-\\\\])*\\.[a-zA-Z0-9]+)$";
		
		if (value == null || val.trim().equals("")) {
			throw new FieldValidationException("JMS Provider URL cannot be empty.");
		} 
		
		if (!Pattern.matches(urlRegex, val) && !(Pattern.matches(pathRegex, val))) {
			throw new FieldValidationException("JMS Provider URL should be either a URL or a jndi.properties file's relative path.");
		}
	}
}
