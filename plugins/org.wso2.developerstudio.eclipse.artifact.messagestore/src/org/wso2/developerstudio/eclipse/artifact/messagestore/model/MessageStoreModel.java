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

package org.wso2.developerstudio.eclipse.artifact.messagestore.model;

import static org.wso2.developerstudio.eclipse.platform.core.utils.Constants.ESB_PROJECT_NATURE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.messagestore.Activator;
import org.wso2.developerstudio.eclipse.artifact.messagestore.Constants;
import org.wso2.developerstudio.eclipse.artifact.messagestore.provider.MessageStoreTypeList.MessageStoreType;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;

/**
 * The model class for message-store artifact wizard specific objects.
 */
public class MessageStoreModel extends ProjectDataModel  {
	
	/*logger*/
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	/* model data*/
	private MessageStoreType messageStoreType = MessageStoreType.JMS;
	private String customProviderClass;
	private String jmsApiVersion;
	private String jmsConnectionFactory;
	private String jmsContextFactory;
	private String jmsPassword;
	private String jmsProviderUrl;
	private String jmsQueueName;
	private boolean jmsEnableCaching;
	private int jmsTimeout;
	private String jmsUsername;	
	private String jmsEnableProducerGuaranteedDelivery;
	private String jmsFailoverMessageStore;
	
	private String storeName;
	private IContainer saveLocation;
	private Map<String,String> customParameters = new HashMap<String,String>();
	private List<OMElement> availableStoreslist;
	private List<OMElement> selectedStoresList;

	private String rabbitMQServerHostName;
	private String rabbitMQServerHostPort;
	private String rabbitMQQueueName;
	private String rabbitMQExchangeName;
	private String rabbitMQRoutingKey;
	private String rabbitMQUserName;
	private String rabbitMQPassword;
	private String rabbitMQVirtualHost;
	private String rabbitMQEnableProducerGuaranteedDelivery;
	private String rabbitMQFailoverMessageStore;

	private String jdbcDatabaseTable;
	private String jdbcConnectionInformation;
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPassword;
	private String jdbcDatasourceName;
	private String jdbcEnableProducerGuaranteedDelivery;
	private String jdbcFailoverMessageStore;

	public MessageStoreModel() {
		availableStoreslist = new ArrayList<OMElement>();
		selectedStoresList = new ArrayList<OMElement>();
	}

	public String getJdbcDatabaseTable() {
		return jdbcDatabaseTable;
	}

	public void setJdbcDatabaseTable(String jdbcDatabaseTable) {
		this.jdbcDatabaseTable = jdbcDatabaseTable;
	}

	public String getJdbcConnectionInformation() {
		return jdbcConnectionInformation;
	}

	public void setJdbcConnectionInformation(String jdbcConnectionInformation) {
		this.jdbcConnectionInformation = jdbcConnectionInformation;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getJdbcURL() {
		return jdbcURL;
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}

	public String getJdbcUser() {
		return jdbcUser;
	}

	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}

	public String getJdbcPassword() {
		return jdbcPassword;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}

	public String getJdbcDatasourceName() {
		return jdbcDatasourceName;
	}

	public void setJdbcDatasourceName(String jdbcDatasourceName) {
		this.jdbcDatasourceName = jdbcDatasourceName;
	}

	public String getRabbitMQServerHostName() {
		return rabbitMQServerHostName;
	}

	public void setRabbitMQServerHostName(String rabbitMQServerHostName) {
		this.rabbitMQServerHostName = rabbitMQServerHostName;
	}

	public String getRabbitMQServerHostPort() {
		return rabbitMQServerHostPort;
	}

	public void setRabbitMQServerHostPort(String rabbitMQServerHostPort) {
		this.rabbitMQServerHostPort = rabbitMQServerHostPort;
	}

	public String getRabbitMQQueueName() {
		return rabbitMQQueueName;
	}

	public void setRabbitMQQueueName(String rabbitMQQueueName) {
		this.rabbitMQQueueName = rabbitMQQueueName;
	}

	public String getRabbitMQExchangeName() {
		return rabbitMQExchangeName;
	}

	public void setRabbitMQExchangeName(String rabbitMQExchangeName) {
		this.rabbitMQExchangeName = rabbitMQExchangeName;
	}

	public String getRabbitMQRoutingKey() {
		return rabbitMQRoutingKey;
	}

	public void setRabbitMQRoutingKey(String rabbitMQRoutingKey) {
		this.rabbitMQRoutingKey = rabbitMQRoutingKey;
	}

	public String getRabbitMQUserName() {
		return rabbitMQUserName;
	}

	public void setRabbitMQUserName(String rabbitMQUserName) {
		this.rabbitMQUserName = rabbitMQUserName;
	}

	public String getRabbitMQPassword() {
		return rabbitMQPassword;
	}

	public void setRabbitMQPassword(String rabbitMQPassword) {
		this.rabbitMQPassword = rabbitMQPassword;
	}

	public String getRabbitMQVirtualHost() {
		return rabbitMQVirtualHost;
	}

	public void setRabbitMQVirtualHost(String rabbitMQVirtualHost) {
		this.rabbitMQVirtualHost = rabbitMQVirtualHost;
	}

	public MessageStoreType getMessageStoreType() {
		return messageStoreType;
	}

	public String getCustomProviderClass() {
		return customProviderClass;
	}

	public void setCustomProviderClass(String customProviderClass) {
		this.customProviderClass = customProviderClass;
	}

	public String getJmsApiVersion() {
		return jmsApiVersion;
	}

	public void setJmsApiVersion(String jmsApiVersion) {
		this.jmsApiVersion = jmsApiVersion;
	}

	public String getJmsConnectionFactory() {
		return jmsConnectionFactory;
	}

	public void setJmsConnectionFactory(String jmsConnectionFactory) {
		this.jmsConnectionFactory = jmsConnectionFactory;
	}

	public String getJmsContextFactory() {
		return jmsContextFactory;
	}

	public void setJmsContextFactory(String jmsContextFactory) {
		this.jmsContextFactory = jmsContextFactory;
	}

	public String getJmsPassword() {
		return jmsPassword;
	}

	public void setJmsPassword(String jmsPassword) {
		this.jmsPassword = jmsPassword;
	}

	public String getJmsProviderUrl() {
		return jmsProviderUrl;
	}

	public void setJmsProviderUrl(String jmsProviderUrl) {
		this.jmsProviderUrl = jmsProviderUrl;
	}

	public String getJmsQueueName() {
		return jmsQueueName;
	}

	public void setJmsQueueName(String jmsQueueName) {
		this.jmsQueueName = jmsQueueName;
	}

	public boolean getJmsEnableCaching() {
		return jmsEnableCaching;
	}

	public void setJmsEnableCaching(boolean jmsEnableCaching) {
		this.jmsEnableCaching = jmsEnableCaching;
	}

	public int getJmsTimeout() {
		return jmsTimeout;
	}

	public void setJmsTimeout(int jmsTimeout) {
		this.jmsTimeout = jmsTimeout;
	}

	public String getJmsUsername() {
		return jmsUsername;
	}

	public void setJmsUsername(String jmsUsername) {
		this.jmsUsername = jmsUsername;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Map<String, String> getCustomParameters() {
		return customParameters;
	}

	public void setMessageStoreType(MessageStoreType messageStoreType) {
		this.messageStoreType = messageStoreType;
	}
	
	public String getJmsEnableProducerGuaranteedDelivery() {
		return jmsEnableProducerGuaranteedDelivery;
	}

	public void setJmsEnableProducerGuaranteedDelivery(String jmsEnableProducerGuaranteedDelivery) {
		this.jmsEnableProducerGuaranteedDelivery = jmsEnableProducerGuaranteedDelivery;
	}

	public String getJmsFailoverMessageStore() {
		return jmsFailoverMessageStore;
	}

	public void setJmsFailoverMessageStore(String jmsFailoverMessageStore) {
		this.jmsFailoverMessageStore = jmsFailoverMessageStore;
	}

	public String getRabbitMQEnableProducerGuaranteedDelivery() {
		return rabbitMQEnableProducerGuaranteedDelivery;
	}

	public void setRabbitMQEnableProducerGuaranteedDelivery(String rabbitMQEnableProducerGuaranteedDelivery) {
		this.rabbitMQEnableProducerGuaranteedDelivery = rabbitMQEnableProducerGuaranteedDelivery;
	}

	public String getRabbitMQFailoverMessageStore() {
		return rabbitMQFailoverMessageStore;
	}

	public void setRabbitMQFailoverMessageStore(String rabbitMQFailoverMessageStore) {
		this.rabbitMQFailoverMessageStore = rabbitMQFailoverMessageStore;
	}

	public String getJdbcEnableProducerGuaranteedDelivery() {
		return jdbcEnableProducerGuaranteedDelivery;
	}

	public void setJdbcEnableProducerGuaranteedDelivery(String jdbcEnableProducerGuaranteedDelivery) {
		this.jdbcEnableProducerGuaranteedDelivery = jdbcEnableProducerGuaranteedDelivery;
	}

	public String getJdbcFailoverMessageStore() {
		return jdbcFailoverMessageStore;
	}

	public void setJdbcFailoverMessageStore(String jdbcFailoverMessageStore) {
		this.jdbcFailoverMessageStore = jdbcFailoverMessageStore;
	}
	
	@Override
	public Object getModelPropertyValue(String key) {
		Object value = super.getModelPropertyValue(key);
		if (key.equals(Constants.FIELD_STORE_TYPE)) {
			value = getMessageStoreType();
		} else if (key.equals(Constants.FIELD_CUSTOM_PROVIDER_CLASS)) {
			value = getCustomProviderClass();
		} else if (key.equals(Constants.FIELD_JMS_API_VERSION)) {
			value = getJmsApiVersion();
		} else if (key.equals(Constants.FIELD_JMS_CONNECTION_FACTORY)) {
			value = getJmsConnectionFactory();
		} else if (key.equals(Constants.FIELD_JMS_CONTEXT_FACTORY)) {
			value = getJmsContextFactory();
		} else if (key.equals(Constants.FIELD_JMS_PASSWORD)) {
			value = getJmsPassword();
		} else if (key.equals(Constants.FIELD_JMS_PROVIDER_URL)) {
			value = getJmsProviderUrl();
		} else if (key.equals(Constants.FIELD_JMS_QUEUE_NAME)) {
			value = getJmsQueueName();
		} else if (key.equals(Constants.FIELD_JMS_ENABLE_CACHING)) {
			value = getJmsEnableCaching();
		} else if (key.equals(Constants.FIELD_JMS_TIMEOUT)) {
			value = getJmsTimeout();
		} else if (key.equals(Constants.FIELD_JMS_USER_NAME)) {
			value = getJmsUsername();
		} else if (key.equals(Constants.FIELD_JMS_ENABLE_PRODUCER_GUARANTEED_DELIVERY)) {
			value = getJmsEnableCaching();
		} else if (key.equals(Constants.FIELD_JMS_FAILOVER_MESSAGE_STORE)) {
			value = getJmsTimeout();
		} else if (key.equals(Constants.FIELD_RABBITMQ_SERVER_HOST_NAME)) {
			value = getRabbitMQServerHostName();
		} else if (key.equals(Constants.FIELD_RABBITMQ_SERVER_HOST_PORT)) {
			value = getRabbitMQServerHostPort();
		} else if (key.equals(Constants.FIELD_RABBITMQ_QUEUE_NAME)) {
			value = getRabbitMQQueueName();
		} else if (key.equals(Constants.FIELD_RABBITMQ_EXCHANGE_NAME)) {
			value = getRabbitMQExchangeName();
		} else if (key.equals(Constants.FIELD_RABBITMQ_ROUTING_KEY)) {
			value = getRabbitMQRoutingKey();
		} else if (key.equals(Constants.FIELD_RABBITMQ_USER_NAME)) {
			value = getRabbitMQUserName();
		} else if (key.equals(Constants.FIELD_RABBITMQ_PASSWORD)) {
			value = getRabbitMQPassword();
		} else if (key.equals(Constants.FIELD_RABBITMQ_VIRTUAL_HOST)) {
			value = getRabbitMQVirtualHost();
		} else if (key.equals(Constants.FIELD_RABBITMQ_ENABLE_PRODUCER_GUARANTEED_DELIVERY)) {
			value = getJmsEnableCaching();
		} else if (key.equals(Constants.FIELD_RABBITMQ_FAILOVER_MESSAGE_STORE)) {
			value = getJmsTimeout();
		} else if (key.equals(Constants.FIELD_JDBC_DATABASE_TABLE)) {
			value = getJdbcDatabaseTable();
		} else if (key.equals(Constants.FIELD_JDBC_CONNECTION_INFORMATION)) {
			value = getJdbcConnectionInformation();
		} else if (key.equals(Constants.FIELD_JDBC_DRIVER)) {
			value = getJdbcDriver();
		} else if (key.equals(Constants.FIELD_JDBC_URL)) {
			value = getJdbcURL();
		} else if (key.equals(Constants.FIELD_JDBC_USER)) {
			value = getJdbcUser();
		} else if (key.equals(Constants.FIELD_JDBC_PASSWORD)) {
			value = getJdbcPassword();
		} else if (key.equals(Constants.FIELD_JDBC_DATASOURCE_NAME)) {
			value = getJdbcDatasourceName();
		} else if (key.equals(Constants.FIELD_JDBC_ENABLE_PRODUCER_GUARANTEED_DELIVERY)) {
			value = getJmsEnableCaching();
		} else if (key.equals(Constants.FIELD_JDBC_FAILOVER_MESSAGE_STORE)) {
			value = getJmsTimeout();
		} else if (key.equals(Constants.FIELD_STORE_NAME)) {
			value = getStoreName();
		} else if(key.equals(Constants.FIELD_SAVE_LOCATION)){
			IContainer container= getSaveLocation();
			if(container != null && container instanceof IFolder){
				IFolder mStoresFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("message-stores");
				value = mStoresFolder;
			}else{
				value = container;
			}
		} else if(key.equals(Constants.FIELD_AVAILABLE_STORES)){
			if(selectedStoresList!=null){
			value = selectedStoresList.toArray();
				}
		}
		return value;
	}
	
	@Override
	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean result = super.setModelPropertyValue(key, data);
		if (key.equals(Constants.FIELD_STORE_TYPE)) {
			setMessageStoreType((MessageStoreType) data);
		} else if (key.equals(Constants.FIELD_CUSTOM_PROVIDER_CLASS)) {
			setCustomProviderClass(data.toString());
		} else if (key.equals(Constants.FIELD_JMS_CONNECTION_FACTORY)) {
			setJmsConnectionFactory(data.toString());
		} else if (key.equals(Constants.FIELD_JMS_CONTEXT_FACTORY)) {
			setJmsContextFactory(data.toString());
		} else if (key.equals(Constants.FIELD_JMS_PASSWORD)) {
			setJmsPassword(data.toString());
		} else if (key.equals(Constants.FIELD_JMS_PROVIDER_URL)) {
			setJmsProviderUrl(data.toString());
		} else if (key.equals(Constants.FIELD_JMS_QUEUE_NAME)) {
			setJmsQueueName(data.toString());
		} else if (key.equals(Constants.FIELD_JMS_ENABLE_CACHING)) {
			try {
				setJmsEnableCaching(Boolean.parseBoolean(data.toString()));
			} catch (NumberFormatException e) {
				/*ignore*/
			}
		} else if (key.equals(Constants.FIELD_JMS_TIMEOUT)) {
			try {
				setJmsTimeout(Integer.parseInt(data.toString()));
			} catch (NumberFormatException e) {
				/*ignore*/
			}
		} else if (key.equals(Constants.FIELD_JMS_USER_NAME)) {
			setJmsUsername(data.toString());
		} 
		
		 else if (key.equals(Constants.FIELD_JMS_ENABLE_PRODUCER_GUARANTEED_DELIVERY)) {
				setJmsEnableProducerGuaranteedDelivery(data.toString());
			}
		 else if (key.equals(Constants.FIELD_JMS_FAILOVER_MESSAGE_STORE)) {
				setJmsFailoverMessageStore(data.toString());
			}
		
		else if (key.equals(Constants.FIELD_RABBITMQ_SERVER_HOST_NAME)) {
			setRabbitMQServerHostName(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_SERVER_HOST_PORT)) {
			setRabbitMQServerHostPort(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_QUEUE_NAME)) {
			setRabbitMQQueueName(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_EXCHANGE_NAME)) {
			setRabbitMQExchangeName(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_ROUTING_KEY)) {
			setRabbitMQRoutingKey(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_USER_NAME)) {
			setRabbitMQUserName(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_PASSWORD)) {
			setRabbitMQPassword(data.toString());
		} else if (key.equals(Constants.FIELD_RABBITMQ_VIRTUAL_HOST)) {
			setRabbitMQVirtualHost(data.toString());
		}
		
		 else if (key.equals(Constants.FIELD_RABBITMQ_ENABLE_PRODUCER_GUARANTEED_DELIVERY)) {
				setRabbitMQEnableProducerGuaranteedDelivery(data.toString());
			}
		 else if (key.equals(Constants.FIELD_RABBITMQ_FAILOVER_MESSAGE_STORE)) {
				setRabbitMQFailoverMessageStore(data.toString());
			}
		
		
		else if (key.equals(Constants.FIELD_JDBC_DATABASE_TABLE)) {
			setJdbcDatabaseTable(data.toString());
		} else if (key.equals(Constants.FIELD_JDBC_CONNECTION_INFORMATION)) {
			setJdbcConnectionInformation(data.toString());
		} else if (key.equals(Constants.FIELD_JDBC_DRIVER)) {
			setJdbcDriver(data.toString());
		} else if (key.equals(Constants.FIELD_JDBC_URL)) {
			setJdbcURL(data.toString());
		} else if (key.equals(Constants.FIELD_JDBC_USER)) {
			setJdbcUser(data.toString());
		} else if (key.equals(Constants.FIELD_JDBC_PASSWORD)) {
			setJdbcPassword(data.toString());
		} else if (key.equals(Constants.FIELD_JDBC_DATASOURCE_NAME)) {
			setJdbcDatasourceName(data.toString());
		} 
		
		 else if (key.equals(Constants.FIELD_JDBC_ENABLE_PRODUCER_GUARANTEED_DELIVERY)) {
				setJdbcEnableProducerGuaranteedDelivery(data.toString());
			}
		 else if (key.equals(Constants.FIELD_JDBC_FAILOVER_MESSAGE_STORE)) {
				setJdbcFailoverMessageStore(data.toString());
			}
		
		else if (key.equals(Constants.FIELD_STORE_NAME)) {
			setStoreName(data.toString());
		} else if (key.equals(Constants.FIELD_CUSTOM_PROVIDER_CLASS)) {
			setCustomProviderClass(data.toString());
		} else if (key.equals(Constants.FIELD_CREATE_ESB_PRJ)) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
			if(esbProject!=null){
				setSaveLocation(esbProject);
			}
		} else if(key.equals(Constants.FIELD_SAVE_LOCATION)){
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder mStoresFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("message-stores");
				setSaveLocation(mStoresFolder);
			}else{
				setSaveLocation(container);
			}
		} else if (key.equals(Constants.FIELD_IMPORT_FILE)) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableStores = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),
					                                        SynapseEntryType.MESSAGE_STORE)) {
						availableStores =
						        SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						        		SynapseEntryType.MESSAGE_STORE);
						setAvailableStoreslist(availableStores);
					} else {
						setAvailableStoreslist(new ArrayList<OMElement>());
					}
					result = false;
				} catch (OMException e) {
					log.error("Error reading object model", e);
				} catch (XMLStreamException e) {
					log.error("XML stream error", e);
				} catch (IOException e) {
					log.error("I/O error has occurred", e);
				} catch (Exception e) {
					log.error("An unexpected error has occurred", e);
				}
			}
		} else if(key.equals(Constants.FIELD_AVAILABLE_STORES)){
			Object[] selectedStores = (Object[])data;
			selectedStoresList.clear();
			for (Object object : selectedStores) {
				if(object instanceof OMElement){
					if(!selectedStoresList.contains((OMElement)object)){
						selectedStoresList.add((OMElement)object);
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getSaveLocation() == null && absolutionPath != null) {
			IContainer newSaveLocation =
			        getContainer(absolutionPath, ESB_PROJECT_NATURE);
			setSaveLocation(newSaveLocation);
		}
	}
	public static IContainer getContainer(File absolutionPath, String projectNature) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		int length = 0;
		IProject currentSelection = null;
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.hasNature(projectNature)) {
					File projectLocation = project.getLocation().toFile();
					int projectLocationLength = projectLocation.toString().length();
					if (projectLocationLength > length &&
					    projectLocationLength <= absolutionPath.toString().length()) {
						if (absolutionPath.toString().startsWith(projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (CoreException e) {
				log.error("An unexpected error has occurred", e);
			}
		}
		IContainer newSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newSaveLocation = currentSelection;
			} else {
				newSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newSaveLocation;
	}

	public IContainer getSaveLocation() {
		return saveLocation;
	}

	public void setSaveLocation(IContainer saveLocation) {
		this.saveLocation = saveLocation;
	}

	public List<OMElement> getAvailableStoreslist() {
		return availableStoreslist;
	}

	public void setAvailableStoreslist(List<OMElement> availableStoreslist) {
		this.availableStoreslist = availableStoreslist;
	}

	public List<OMElement> getSelectedStoresList() {
		return selectedStoresList;
	}

	public void setSelectedStoresList(List<OMElement> selectedStoresList) {
		this.selectedStoresList = selectedStoresList;
	}

}
