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

package org.wso2.developerstudio.eclipse.artifact.messagestore;

import org.eclipse.osgi.util.NLS;

public class Constants extends NLS {
	
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.messagestore.constants"; //$NON-NLS-1$
	
	public static String FIELD_AVAILABLE_STORES;
	public static String FIELD_CREATE_ESB_PRJ;
	public static String FIELD_CREATE_STORE;
	public static String FIELD_CUSTOM_PROVIDER_CLASS;
	public static String FIELD_IMPORT_FILE;
	public static String FIELD_IMPORT_STORE;
	public static String FIELD_JMS_API_VERSION;
	public static String FIELD_JMS_CONNECTION_FACTORY;
	public static String FIELD_JMS_CONTEXT_FACTORY;
	public static String FIELD_JMS_PASSWORD;
	public static String FIELD_JMS_PROVIDER_URL;
	public static String FIELD_JMS_QUEUE_NAME;
	public static String FIELD_JMS_ENABLE_CACHING;
	public static String FIELD_JMS_TIMEOUT;
	public static String FIELD_JMS_USER_NAME;
	public static String FIELD_JMS_ENABLE_PRODUCER_GUARANTEED_DELIVERY;
	public static String FIELD_JMS_FAILOVER_MESSAGE_STORE;
	public static String FIELD_RABBITMQ_SERVER_HOST_NAME;
	public static String FIELD_RABBITMQ_SERVER_HOST_PORT;
	public static String FIELD_RABBITMQ_QUEUE_NAME;
	public static String FIELD_RABBITMQ_EXCHANGE_NAME;
	public static String FIELD_RABBITMQ_ROUTING_KEY;
	public static String FIELD_RABBITMQ_USER_NAME;
	public static String FIELD_RABBITMQ_PASSWORD;
	public static String FIELD_RABBITMQ_VIRTUAL_HOST;
	public static String FIELD_RABBITMQ_ENABLE_PRODUCER_GUARANTEED_DELIVERY;
	public static String FIELD_RABBITMQ_FAILOVER_MESSAGE_STORE;	
	public static String FIELD_JDBC_DATABASE_TABLE;
	public static String FIELD_JDBC_CONNECTION_INFORMATION;
	public static String FIELD_JDBC_DRIVER;
	public static String FIELD_JDBC_URL;
	public static String FIELD_JDBC_USER;
	public static String FIELD_JDBC_PASSWORD;
	public static String FIELD_JDBC_DATASOURCE_NAME;
	public static String FIELD_JDBC_ENABLE_PRODUCER_GUARANTEED_DELIVERY;
	public static String FIELD_JDBC_FAILOVER_MESSAGE_STORE;
	public static String FIELD_SAVE_LOCATION;
	public static String FIELD_STORE_NAME;
	public static String FIELD_STORE_TYPE;
	public static String FIELD_CUSTOM_PARAMETERS;
	public static String TXT_CUSTOM;
	public static String TXT_IN_MEMORY;
	public static String TXT_JMS;
	public static String TXT_RABBITMQ;
	public static String TXT_JDBC;
	public static String TXT_JMS_FIELD_PREFIX;
	public static String TXT_CUSTOM_FIELD_PREFIX;
	public static String TXT_RABBITMQ_FIELD_PREFIX;
	public static String TXT_JDBC_FIELD_PREFIX;
	public static String TXT_JDBC_POOL_TYPE;
	public static String TXT_JDBC_CARBON_DATASOURCE_TYPE;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Constants.class);
	}

	private Constants() {
		
	}
}
