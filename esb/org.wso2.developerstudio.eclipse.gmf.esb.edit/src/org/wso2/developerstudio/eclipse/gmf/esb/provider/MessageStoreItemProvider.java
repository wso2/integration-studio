/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageStore} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MessageStoreItemProvider
	extends EsbElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageStoreItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		MessageStore store = (MessageStore) object;

		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}

		super.getPropertyDescriptors(object);

		addStoreNamePropertyDescriptor(object);
		addStoreTypePropertyDescriptor(object);

		switch (store.getStoreType()) {
		case JMS:
			addInitialContextFactoryPropertyDescriptor(object);
			addProviderURLPropertyDescriptor(object);
			addJndiQueueNamePropertyDescriptor(object);
			addConnectionFactoryPropertyDescriptor(object);
			addUserNamePropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addJmsSpecVersionPropertyDescriptor(object);
			addEnableProducerGuaranteedDeliveryPropertyDescriptor(object);
			addFailoverMessageStorePropertyDescriptor(object);
			//addTimeoutPropertyDescriptor(object);
			break;
		case CUSTOM:
			addProviderClassPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			break;
		case RABBITMQ:
			addRabbitMQServerHostNamePropertyDescriptor(object);
			addRabbitMQServerHostPortPropertyDescriptor(object);
			addRabbitMQQueueNamePropertyDescriptor(object);
			addRabbitMQExchangeNamePropertyDescriptor(object);
			addRoutingKeyPropertyDescriptor(object);
			addRabbitMQUserNamePropertyDescriptor(object);
			addRabbitMQPasswordPropertyDescriptor(object);
			addVirtualHostPropertyDescriptor(object);
			addEnableProducerGuaranteedDeliveryPropertyDescriptor(object);
			addFailoverMessageStorePropertyDescriptor(object);
			break;
		case JDBC:
			addJdbcDatabaseTablePropertyDescriptor(object);
			addJdbcConnectionInformationPropertyDescriptor(object);

			switch (store.getJdbcConnectionInformation()) {
			case JDBC_POOL:
				addJdbcDriverPropertyDescriptor(object);
				addJdbcURLPropertyDescriptor(object);
				addJdbcUserPropertyDescriptor(object);
				addJdbcPasswordPropertyDescriptor(object);
				break;
			case JDBC_CARBON_DATASOURCE:
				addJdbcDatasourceNamePropertyDescriptor(object);
				break;
			}
			addEnableProducerGuaranteedDeliveryPropertyDescriptor(object);
			addFailoverMessageStorePropertyDescriptor(object);
			break;
		default:
			break;
		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Store Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStoreNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_storeName_feature"),
				 getString("_UI_MessageStore_storeName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__STORE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Store Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStoreTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_storeType_feature"),
				 getString("_UI_MessageStore_storeType_description"),
				 EsbPackage.Literals.MESSAGE_STORE__STORE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Context Factory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialContextFactoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_initialContextFactory_feature"),
				 getString("_UI_MessageStore_initialContextFactory_description"),
				 EsbPackage.Literals.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_providerURL_feature"),
				 getString("_UI_MessageStore_providerURL_description"),
				 EsbPackage.Literals.MESSAGE_STORE__PROVIDER_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jndi Queue Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJndiQueueNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jndiQueueName_feature"),
				 getString("_UI_MessageStore_jndiQueueName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JNDI_QUEUE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Factory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionFactoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_connectionFactory_feature"),
				 getString("_UI_MessageStore_connectionFactory_description"),
				 EsbPackage.Literals.MESSAGE_STORE__CONNECTION_FACTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the User Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_userName_feature"),
				 getString("_UI_MessageStore_userName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__USER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_password_feature"),
				 getString("_UI_MessageStore_password_description"),
				 EsbPackage.Literals.MESSAGE_STORE__PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jms Spec Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJmsSpecVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jmsSpecVersion_feature"),
				 getString("_UI_MessageStore_jmsSpecVersion_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JMS_SPEC_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Caching feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableCachingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_enableCaching_feature"),
				 getString("_UI_MessageStore_enableCaching_description"),
				 EsbPackage.Literals.MESSAGE_STORE__ENABLE_CACHING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_providerClass_feature"),
				 getString("_UI_MessageStore_providerClass_description"),
				 EsbPackage.Literals.MESSAGE_STORE__PROVIDER_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rabbit MQ Server Host Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRabbitMQServerHostNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_rabbitMQServerHostName_feature"),
				 getString("_UI_MessageStore_rabbitMQServerHostName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rabbit MQ Server Host Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRabbitMQServerHostPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_rabbitMQServerHostPort_feature"),
				 getString("_UI_MessageStore_rabbitMQServerHostPort_description"),
				 EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rabbit MQ Queue Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRabbitMQQueueNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_rabbitMQQueueName_feature"),
				 getString("_UI_MessageStore_rabbitMQQueueName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_QUEUE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rabbit MQ Exchange Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRabbitMQExchangeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_rabbitMQExchangeName_feature"),
				 getString("_UI_MessageStore_rabbitMQExchangeName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_EXCHANGE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Routing Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoutingKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_routingKey_feature"),
				 getString("_UI_MessageStore_routingKey_description"),
				 EsbPackage.Literals.MESSAGE_STORE__ROUTING_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rabbit MQ User Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRabbitMQUserNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_rabbitMQUserName_feature"),
				 getString("_UI_MessageStore_rabbitMQUserName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_USER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rabbit MQ Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRabbitMQPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_rabbitMQPassword_feature"),
				 getString("_UI_MessageStore_rabbitMQPassword_description"),
				 EsbPackage.Literals.MESSAGE_STORE__RABBIT_MQ_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Virtual Host feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVirtualHostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_virtualHost_feature"),
				 getString("_UI_MessageStore_virtualHost_description"),
				 EsbPackage.Literals.MESSAGE_STORE__VIRTUAL_HOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc Database Table feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcDatabaseTablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcDatabaseTable_feature"),
				 getString("_UI_MessageStore_jdbcDatabaseTable_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_DATABASE_TABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc Connection Information feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcConnectionInformationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcConnectionInformation_feature"),
				 getString("_UI_MessageStore_jdbcConnectionInformation_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_CONNECTION_INFORMATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc Driver feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcDriverPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcDriver_feature"),
				 getString("_UI_MessageStore_jdbcDriver_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_DRIVER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcURL_feature"),
				 getString("_UI_MessageStore_jdbcURL_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc User feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcUserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcUser_feature"),
				 getString("_UI_MessageStore_jdbcUser_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcPassword_feature"),
				 getString("_UI_MessageStore_jdbcPassword_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Jdbc Datasource Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJdbcDatasourceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_jdbcDatasourceName_feature"),
				 getString("_UI_MessageStore_jdbcDatasourceName_description"),
				 EsbPackage.Literals.MESSAGE_STORE__JDBC_DATASOURCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_parameters_feature"),
				 getString("_UI_MessageStore_parameters_description"),
				 EsbPackage.Literals.MESSAGE_STORE__PARAMETERS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Producer Guaranteed Delivery feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addEnableProducerGuaranteedDeliveryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_enableProducerGuaranteedDelivery_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageStore_enableProducerGuaranteedDelivery_feature", "_UI_MessageStore_type"),
				 EsbPackage.Literals.MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Guaranteed Delivery Parameters",
				 null));
	}

	/**
	 * This adds a property descriptor for the Failover Message Store feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFailoverMessageStorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageStore_failoverMessageStore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageStore_failoverMessageStore_feature", "_UI_MessageStore_type"),
				 EsbPackage.Literals.MESSAGE_STORE__FAILOVER_MESSAGE_STORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Guaranteed Delivery Parameters",
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.MESSAGE_STORE__PARAMETERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MessageStore.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MessageStore"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MessageStore)object).getStoreName();
		return label == null || label.length() == 0 ?
			getString("_UI_MessageStore_type") :
			getString("_UI_MessageStore_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MessageStore.class)) {
			case EsbPackage.MESSAGE_STORE__STORE_NAME:
			case EsbPackage.MESSAGE_STORE__STORE_TYPE:
			case EsbPackage.MESSAGE_STORE__INITIAL_CONTEXT_FACTORY:
			case EsbPackage.MESSAGE_STORE__PROVIDER_URL:
			case EsbPackage.MESSAGE_STORE__JNDI_QUEUE_NAME:
			case EsbPackage.MESSAGE_STORE__CONNECTION_FACTORY:
			case EsbPackage.MESSAGE_STORE__USER_NAME:
			case EsbPackage.MESSAGE_STORE__PASSWORD:
			case EsbPackage.MESSAGE_STORE__JMS_SPEC_VERSION:
			case EsbPackage.MESSAGE_STORE__ENABLE_CACHING:
			case EsbPackage.MESSAGE_STORE__PROVIDER_CLASS:
			case EsbPackage.MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_NAME:
			case EsbPackage.MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_PORT:
			case EsbPackage.MESSAGE_STORE__RABBIT_MQ_QUEUE_NAME:
			case EsbPackage.MESSAGE_STORE__RABBIT_MQ_EXCHANGE_NAME:
			case EsbPackage.MESSAGE_STORE__ROUTING_KEY:
			case EsbPackage.MESSAGE_STORE__RABBIT_MQ_USER_NAME:
			case EsbPackage.MESSAGE_STORE__RABBIT_MQ_PASSWORD:
			case EsbPackage.MESSAGE_STORE__VIRTUAL_HOST:
			case EsbPackage.MESSAGE_STORE__JDBC_DATABASE_TABLE:
			case EsbPackage.MESSAGE_STORE__JDBC_CONNECTION_INFORMATION:
			case EsbPackage.MESSAGE_STORE__JDBC_DRIVER:
			case EsbPackage.MESSAGE_STORE__JDBC_URL:
			case EsbPackage.MESSAGE_STORE__JDBC_USER:
			case EsbPackage.MESSAGE_STORE__JDBC_PASSWORD:
			case EsbPackage.MESSAGE_STORE__JDBC_DATASOURCE_NAME:
			case EsbPackage.MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY:
			case EsbPackage.MESSAGE_STORE__FAILOVER_MESSAGE_STORE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.MESSAGE_STORE__PARAMETERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.MESSAGE_STORE__PARAMETERS,
				 EsbFactory.eINSTANCE.createMessageStoreParameter()));
	}

}
