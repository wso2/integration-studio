/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.ds.provider.labelProvider;

import java.util.HashMap;

public class DSEditPropertiesLabelProvider {

	private static DSEditPropertiesLabelProvider thisInstance;
	private HashMap<String, String> nameMap;

	// RDBMS Properties
	private String DRIVER_PROPERTY = "org.wso2.ws.dataservice.driver";
	private String DRIVER_DISPLAY = "Driver Class";

	private String PROTOCOL_PROPERTY = "org.wso2.ws.dataservice.protocol";
	private String PROTOCOL_DISPLAY = "JDBC URL";

	private String USER_PROPERTY = "org.wso2.ws.dataservice.user";
	private String USER_DISPLAY = "User Name";

	private String PASSWORD_PROPERTY = "org.wso2.ws.dataservice.password";
	private String PASSWORD_DISPLAY = "Password";

	private String MINPOOLSIZE_PROPERTY = "org.wso2.ws.dataservice.minpoolsize";
	private String MINPOOLSIZE_DISPLAY = "Min Pool Size";

	private String MAXPOOLSIZE_PROPERTY = "org.wso2.ws.dataservice.maxpoolsize";
	private String MAXPOOLSIZE_DISPLAY = "Max Pool Size";

	private String VALIDATIONQUERY_PROPERTY = "org.wso2.ws.dataservice.validation_query";
	private String VALIDATIONQUERY_DISPLAY = "Validation Query";

	private String AUTO_COMMIT_PROPERTY = "org.wso2.ws.dataservice.autocommit";
	private String AUTO_COMMIT_DISPLAY = "Auto Commit";

	
	// Cassandra Data Source Properties

	private String CASSANDRA_SERVER_URL = "url";
	private String CASSANDRA_SERVER_URL_DISPLAY = "Server URL";

	private String CASSANDRA_USER_NAME = "username";
	private String CASSANDRA_USER_NAME_DISPLAY = "User Name";

	private String CASSANDRA_PASSWORD= "password";
	private String CASSANDRA_PASSWORD_DISPLAY = "Password";
	
	private String CASSANDRA_DRIVER_CLASS_NAME= "driverClassName";
	private String CASSANDRA_DRIVER_CLASS_NAME_DISPLAY = "Driver Class Name";
		
	
	// CSV Properties

	private String CSV_DATASOURCE_PROPERTY = "csv_datasource";
	private String CSV_DATASOURCE_DISPLAY = "CSV File Location";

	private String COLUMN_SEPERATOR_PROPERTY = "csv_columnseperator";
	private String COLUMN_SEPERATOR_DISPLAY = "Column Seperator";

	private String STARTING_ROW_PROPERTY = "csv_startingrow";
	private String STARTING_ROW_DISPLAY = "Start Reading From Row";

	private String MAX_ROW_COUNT_PROPERTY = "csv_maxrowcount";
	private String MAX_ROW_COUNT_DISPLAY = "Max Rows To Read";

	private String HAS_HEADER_PROPERTY = "csv_hasheader";
	private String HAS_HEADER_DISPLAY = "Contains Column Header Row";

	// Spreadsheet Properties

	private String EXCEL_DATASOURCE_PROPERTY = "excel_datasource";
	private String EXCEL_DATASOURCE_DISPLAY = "Excel File Location";

	// JNDI Data Source Properties

	private String JNDI_CONTEXT_PROPERTY = "jndi_context_class";
	private String JNDI_CONTEXT_DISPLAY = "JNDI Context Class";

	private String JNDI_PROVIDER_URL_PROPERTY = "jndi_provider_url";
	private String JNDI_PROVIDER_URL_DISPLAY = "Provider URL";

	private String JNDI_RESOURCE_PROPERTY = "jndi_resource_name";
	private String JNDI_RESOURCE_DISPLAY = "Resource Name";

	private String JNDI_PASSWORD_PROPERTY = "jndi_password";
	private String JNDI_PASSWORD_DISPLAY = "Password";

	// Google Spreadsheet Properties

	private String GSPREAD_DATASOURCE_PROPERTY = "gspread_datasource";
	private String GSPREAD_DATASOURCE_DISPLAY = "Google Spreadsheet URL";

	private String GSPREAD_VISIBILITY_PROPERTY = "gspread_visibility";
	private String GSPREAD_VISIBILITY_DISPLAY = "Visibility";

	private String GSPREAD_USERNAME_PROPERTY = "gspread_username";
	private String GSPREAD_USERNAME_DISPLAY = "User Name";

	private String GSPREAD_PASSWORD_PROPERTY = "gspread_password";
	private String GSPREAD_PASSWORD_DISPLAY = "Password";

	// Carbon Data Source Properties

	private String CARBON_DATASOURCE_NAME_PROPERTY = "carbon_datasource_name";
	private String CARBON_DATASOURCE_NAME_DISPLAY = "Data Source Name";

	// XA Data Source
	private String XA_DATASOURCE_CLASS_PROPERTY = "org.wso2.ws.dataservice.xa_datasource_class";
	private String XA_DATASOURCE_CLASS_DISPLAY = "Xa Data Source Class";

	private String XA_DATASOURCE_PROPS_PROPERTY =
	                                              "org.wso2.ws.dataservice.xa_datasource_properties";
	private String XA_DATASOURCE_PROPS_DISPLAY = "Xa Data Source Properties";
	// Query Properties

	public String QUERY_TIMEOUT = "org.wso2.ws.dataservice.query_timeout";
	public String QUERY_TIMEOUT_DISPLAY = "Timeout (Seconds)";

	public String FETCH_DIRECTION = "org.wso2.ws.dataservice.fetch_direction";
	public String FETCH_DIRECTION_DISPLAY = "Fetch Direction";

	public String FETCH_SIZE = "org.wso2.ws.dataservice.fetch_size";
	public String FETCH_SIZE_DISPLAY = "Fetch Size";

	public String MAX_FIELD_SIZE = "org.wso2.ws.dataservice.max_field_size";
	public String MAX_FIELD_SIZE_DISPLAY = "Max Field Size (Bytes)";

	public String MAX_ROWS = "org.wso2.ws.dataservice.max_rows";
	public String MAX_ROWS_DISPLAY = "Max Rows";

	private DSEditPropertiesLabelProvider() {
		nameMap = new HashMap<String, String>();

		// RDBMS
		nameMap.put(DRIVER_PROPERTY, DRIVER_DISPLAY);
		nameMap.put(PROTOCOL_PROPERTY, PROTOCOL_DISPLAY);
		nameMap.put(USER_PROPERTY, USER_DISPLAY);
		nameMap.put(PASSWORD_PROPERTY, PASSWORD_DISPLAY);
		nameMap.put(MINPOOLSIZE_PROPERTY, MINPOOLSIZE_DISPLAY);
		nameMap.put(MAXPOOLSIZE_PROPERTY, MAXPOOLSIZE_DISPLAY);
		nameMap.put(MAXPOOLSIZE_PROPERTY, MAXPOOLSIZE_DISPLAY);
		nameMap.put(VALIDATIONQUERY_PROPERTY, VALIDATIONQUERY_DISPLAY);
		nameMap.put(AUTO_COMMIT_PROPERTY, AUTO_COMMIT_DISPLAY);

		// XA Data Source
		nameMap.put(XA_DATASOURCE_CLASS_PROPERTY, XA_DATASOURCE_CLASS_DISPLAY);
		nameMap.put(XA_DATASOURCE_PROPS_PROPERTY, XA_DATASOURCE_PROPS_DISPLAY);

		// Cassandra Data Source
		nameMap.put(CASSANDRA_SERVER_URL, CASSANDRA_SERVER_URL_DISPLAY);
		nameMap.put(CASSANDRA_USER_NAME, CASSANDRA_USER_NAME_DISPLAY);
		nameMap.put(CASSANDRA_PASSWORD, CASSANDRA_PASSWORD_DISPLAY);
		nameMap.put(CASSANDRA_DRIVER_CLASS_NAME, CASSANDRA_DRIVER_CLASS_NAME_DISPLAY);
		
		// CSV
		nameMap.put(CSV_DATASOURCE_PROPERTY, CSV_DATASOURCE_DISPLAY);
		nameMap.put(COLUMN_SEPERATOR_PROPERTY, COLUMN_SEPERATOR_DISPLAY);
		nameMap.put(STARTING_ROW_PROPERTY, STARTING_ROW_DISPLAY);
		nameMap.put(MAX_ROW_COUNT_PROPERTY, MAX_ROW_COUNT_DISPLAY);
		nameMap.put(HAS_HEADER_PROPERTY, HAS_HEADER_DISPLAY);

		// Spreadsheet
		nameMap.put(EXCEL_DATASOURCE_PROPERTY, EXCEL_DATASOURCE_DISPLAY);

		// JNDI Data Source
		nameMap.put(JNDI_CONTEXT_PROPERTY, JNDI_CONTEXT_DISPLAY);
		nameMap.put(JNDI_PROVIDER_URL_PROPERTY, JNDI_PROVIDER_URL_DISPLAY);
		nameMap.put(JNDI_RESOURCE_PROPERTY, JNDI_RESOURCE_DISPLAY);
		nameMap.put(JNDI_PASSWORD_PROPERTY, JNDI_PASSWORD_DISPLAY);

		// Google Spreadsheet
		nameMap.put(GSPREAD_DATASOURCE_PROPERTY, GSPREAD_DATASOURCE_DISPLAY);
		nameMap.put(GSPREAD_VISIBILITY_PROPERTY, GSPREAD_VISIBILITY_DISPLAY);
		nameMap.put(GSPREAD_USERNAME_PROPERTY, GSPREAD_USERNAME_DISPLAY);
		nameMap.put(GSPREAD_PASSWORD_PROPERTY, GSPREAD_PASSWORD_DISPLAY);

		// Carbon Spreadsheet
		nameMap.put(CARBON_DATASOURCE_NAME_PROPERTY, CARBON_DATASOURCE_NAME_DISPLAY);

		// Query Properties
		nameMap.put(QUERY_TIMEOUT, QUERY_TIMEOUT_DISPLAY);
		nameMap.put(FETCH_DIRECTION, FETCH_DIRECTION_DISPLAY);
		nameMap.put(FETCH_SIZE, FETCH_SIZE_DISPLAY);
		nameMap.put(MAX_FIELD_SIZE, MAX_FIELD_SIZE_DISPLAY);
		nameMap.put(MAX_ROWS, MAX_ROWS_DISPLAY);

	}

	public static DSEditPropertiesLabelProvider getInstance() {
		if (thisInstance == null) {
			thisInstance = new DSEditPropertiesLabelProvider();
		}
		return thisInstance;
	}

	public String getDisplayLabel(String name) {
		return nameMap.get(name);
	}

}
