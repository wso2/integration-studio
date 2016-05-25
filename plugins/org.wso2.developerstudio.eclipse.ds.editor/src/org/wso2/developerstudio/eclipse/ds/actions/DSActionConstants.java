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
package org.wso2.developerstudio.eclipse.ds.actions;

/**
 * Defines the Action Constants for DS Editor
 */
public interface DSActionConstants {

	// Actions

	public String ADD_DESCRIPTION_ACTION = "Add Description";
	
	public String ADD_POLICY_ACTION = "Add Policy";

	public String ADD_DATASOURCE_ACTION = "Add DataSource";

	public String ADD_CONFIG_PROPERTY_ACTION = "Add Property";

	public String ADD_QUERY_ACTION = "Add Query";

	public String ADD_OPERATION_ACTION = "Add Operation";

	public String ADD_RESOURCE_ACTION = "Add Resource";

	public String ADD_SQL_ACTION = "Add Sql";

	public String ADD_SPARQL_ACTION = "Add Sparql";
	
	public String ADD_QUERY_EXPRESSION_ACTION = "Add Expression";	

	public String ADD_RESULT_ACTION = "Add Result";

	public String ADD_EVENT_TRIGGER_ACTION = "Add Event Trigger";

	public String ADD_OUTPUT_MAPPING_ACTION = "Add Output Mapping";

	public String ADD_OUTPUT_MAPPING_COMPLEX_ELEMENT = "Add Complex Element";

	public String ADD_OUTOUT_MAPPING_NESTED_ELEMENT = "Add Nested Element";

	public String ADD_OUTPUT_MAPPING_ELEMENT_ACTION = "Add Element";

	public String ADD_OUTPUT_MAPPING_ATTRIBUTE_ACTION = "Add Attribute";

	public String ADD_OUTPUT_MAPPING_CALL_QUERY_ACTION = "Add Call-Query";

	public String ADD_OUTPUT_MAPPING_CALL_QUERY_GROUP_ACTION = "Add Call-Query Group";

	public String ADD_INPUT_MAPPING_ACTION = "Add Input Mapping";

	public String ADD_VALIDATOR_ACTION = "Add Validator";

	public String ADD_EXPRESSION_ACTION = "Add Expression";

	public String ADD_TARGET_TOPOIC_ACTION = "Add Target Topic";

	public String ADD_SUBSCRIPTIONS_ACTION = "Add Subscriptions";

	public String ADD_SUBSCRIPTION_ACTION = "ADD Subscription";

	public String ADD_LONG_RANGE_VALIDATOR_ACTION = "Add Long Range Validator";

	public String ADD_DOUBLE_RANGE_VALIDATOR_ACTION = "Add Double Range Validator";

	public String ADD_LENGTH_VALIDATOR_ACTION = "Add Length Validator";

	public String ADD_PATTERN_VALIDATOR_ACTION = "Add Pattern Validator";

	public String ADD_CUSTOM_VALIDATOR_ACTION = "Add Custom Validator";

	public String ADD_QUERY_PROPERTY_LIST_ACTION = "Add Properties";

	public String ADD_QUERY_PROPERTY_ACTION = "Add Property";

	// excel query

	public String ADD_EXCEL_QUERY_ACTION = "Add Excel Query";

	// gspred query

	public String ADD_GSPREAD_QUERY_ACTION = "Add Gspread Query";

	// query param

	public String ADD_QUERY_PARAM_ACTION = "Add Query Param";

	// RDBMS Properties

	public String RDBMS_TYPE = "RDBMS";

	public String DRIVER_PROPERTY = "org.wso2.ws.dataservice.driver";

	public String PROTOCOL_PROPERTY = "org.wso2.ws.dataservice.protocol";

	public String USER_PROPERTY = "org.wso2.ws.dataservice.user";

	public String PASSWORD_PROPERTY = "org.wso2.ws.dataservice.password";

	public String MINPOOLSIZE_PROPERTY = "org.wso2.ws.dataservice.minpoolsize";

	public String MAXPOOLSIZE_PROPERTY = "org.wso2.ws.dataservice.maxpoolsize";

	public String VALIDATIONQUERY_PROPERTY = "org.wso2.ws.dataservice.validation_query";

	public String ENABLE_AUTO_COMMIT = "org.wso2.ws.dataservice.autocommit";

	// RDBMS Display Values

	public String DRIVER_DISPLAY = "Driver Class";

	public String PROTOCOL_DISPLAY = "JDBC URL";

	public String USER_DISPLAY = "User Name";

	public String PASSWORD_DISPLAY = "Password";

	public String MINPOOLSIZE_DISPLAY = "Min Pool Size";

	public String MAXPOOLSIZE_DISPLAY = "Max Pool Size";

	public String VALIDATIONQUERY_DISPLAY = "Validation Query";

	public String ENABLE_AUTO_COMMIT_DISPLAY = "Enable Auto Commit";
		
	
	// Cassandra Data Source Properties

	public String CASSANDRA_TYPE = "Cassandra";
	
	public String CASSANDRA_DATASOURCE_PROPERTY = "cassandra_datasource";
	
	public String CASSANDRA_SERVER_URL = "url";

	public String CASSANDRA_USERNAME = "username";

	public String CASSANDRA_PASSWORD = "password";
	
	public String CASSANDRA_DRIVER_CLASS_NAME = "driverClassName";

	// Cassandra Data Source Display Values

	public String CASSANDRA_SERVER_URL_DISPLAY = "Server URL";

	public String CASSANDRA_USERNAME_DISPLAY = "User Name";

	public String CASSANDRA_PASSWORD_DISPLAY = "Password";
	
	public String CASSANDRA_DRIVER_CLASS_NAME_DISPLAY = "Driver Class Name";
		

	// CSV Properties

	public String CSV_TYPE = "CSV";

	public String CSV_DATASOURCE_PROPERTY = "csv_datasource";

	public String COLUMN_SEPERATOR_PROPERTY = "csv_columnseperator";

	public String STARTING_ROW_PROPERTY = "csv_startingrow";

	public String MAX_ROW_COUNT_PROPERTY = "csv_maxrowcount";

	public String HAS_HEADER_PROPERTY = "csv_hasheader";

	// CSV Display Values

	public String CSV_DATASOURCE_DISPLAY = "CSV File Location";

	public String COLUMN_SEPERATOR_DISPLAY = "Column Seperator";

	public String STARTING_ROW_DISPLAY = "Start Reading From Row";

	public String MAX_ROW_COUNT_DISPLAY = "Max Rows To Read";

	public String HAS_HEADER_DISPLAY = "Contains Column Header Row";

	// Spreadsheet Properties

	public String SPREADSHEET_TYPE = "Spreadsheet";

	public String EXCEL_DATASOURCE_PROPERTY = "excel_datasource";

	// Spreadsheet Dislay Values

	public String EXCEL_DATASOURCE_DISPLAY = "Excel File Location";

	// JNDI Data Source Properties

	public String JNDI_TYPE = "JNDI Data Source";

	public String JNDI_CONTEXT_PROPERTY = "jndi_context_class";

	public String JNDI_PROVIDER_URL_PROPERTY = "jndi_provider_url";

	public String JNDI_RESOURCE_PROPERTY = "jndi_resource_name";

	public String JNDI_PASSWORD_PROPERTY = "jndi_password";

	// JNDI Data Source Display Values

	public String JNDI_CONTEXT_DISPLAY = "JNDI Context Class";

	public String JNDI_PROVIDER_URL_DISPLAY = "Provider URL";

	public String JNDI_RESOURCE_DISPLAY = "Resource Name";

	public String JNDI_PASSWORD_DISPLAY = "Password";

	// Google Spreadsheet Properties

	public String GSPREAD_TYPE = "Google Spreadsheet";

	public String GSPREAD_DATASOURCE_PROPERTY = "gspread_datasource";

	public String GSPREAD_VISIBILITY_PROPERTY = "gspread_visibility";

	public String GSPREAD_USERNAME_PROPERTY = "gspread_username";

	public String GSPREAD_PASSWORD_PROPERTY = "gspread_password";

	// Google Spreadsheet Display Values

	public String GSPREAD_DATASOURCE_DISPLAY = "Google Spreadsheet URL";

	public String GSPREAD_VISIBILITY_DISPLAY = "Visibility";

	public String GSPREAD_USERNAME_DISPLAY = "User Name";

	public String GSPREAD_PASSWORD_DISPLAY = "Password";

	// Carbon Data Source Properties

	public String CARBON_DATASOURCE_TYPE = "Carbon Data Source";

	public String CARBON_DATASOURCE_NAME_PROPERTY = "carbon_datasource_name";

	// Carbon Data Source Values

	public String CARBON_DATASOURCE_NAME_DISPLAY = "Data Source Name";

	// MySQL

	public String MYSQL_DATASOURCE_TYPE = "MySQL";

	public String MYSQL_DRIVER_VALUE = "com.mysql.jdbc.Driver";

	public String MYSQL_PROTOCOL_VALUE = "jdbc:mysql://[machine-name/ip]:[port]/[database-name]";

	// Apache Derby

	public String APACHE_DERBY_DATASOURCE_TYPE = "Apache Derby";

	public String APACHE_DERBY_DRIVER_VALUE = "org.apache.derby.jdbc.EmbeddedDriver";

	public String APACHE_DERBY_PROTOCOL_VALUE = "jdbc:derby:[path-to-data-file]";

	// Microsoft SQL Server

	public String MS_SQL_SERVER_DATASOURCE_TYPE = "Microsoft SQL Server";

	public String MS_SQL_SERVER_DRIVER_VALUE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public String MS_SQL_SERVER_PROTOCOL_VALUE =
	                                             "jdbc:sqlserver://[HOST][PORT1433];databaseName=[DB]";

	// Oracle

	public String ORACLE_DATASOURCE_TYPE = "Oracle";

	public String ORACLE_DRIVER_VALUE = "oracle.jdbc.driver.OracleDriver";

	public String ORACLE_PROTOCOL_VALUE =
	                                      "jdbc:oracle:[drivertype]:[username/password]@[host]:[port]/[database]";

	// IBM DB2

	public String IBM_DB2_DATASOURCE_TYPE = "IBM DB2";

	public String IBM_DB2_DRIVER_VALUE = "com.ibm.db2.jcc.DB2Driver";

	public String IBM_DB2_PROTOCOL_VALUE = "jdbc:db2:[database]";

	// HSQLDB

	public String HSQLDB_DATASOURCE_TYPE = "HSQLDB";

	public String HSQLDB_DB_DRIVER_VALUE = "org.hsqldb.jdbcDriver";

	public String HSQLDB_DB_PROTOCOL_VALUE = "jdbc:hsqldb:[path]";

	// Informix

	public String INFORMIX_DATASOURCE_TYPE = "Informix";

	public String INFORMIX_DRIVER_VALUE = "com.informix.jdbc.IfxDriver";

	public String INFORMIX_PROTOCOL_VALUE =
	                                        "jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[server-name]";

	// PostgreSQL

	public String POSTGRESQL_DATASOURCE_TYPE = "PostgreSQL";

	public String POSTGRESQL_DRIVER_VALUE = "org.postgresql.Driver";

	public String POSTGRESQL_PROTOCOL_VALUE = "jdbc:postgresql://[HOST]:[PORT5432]/[database]";

	// Sybase ASE

	public String SYBASE_ASE_DATASOURCE_TYPE = "Sybase ASE";

	public String SYBASE_ASE_DRIVER_VALUE = "com.sybase.jdbc3.jdbc.SybDriver";

	public String SYBASE_ASE_PROTOCOL_VALUE = "jdbc:sybase:Tds:[HOST]:[PORT2048]/[database]";

	// H2

	public String H2_DATASOURCE_TYPE = "H2";

	public String H2_DRIVER_VALUE = "org.h2.Driver";

	public String H2_PROTOCOL_VALUE = "jdbc:h2:tcp:[HOST]:[PORT]/[database]";

	// Generic

	public String GENERIC_DATASOURCE_TYPE = "Generic";

	public String GENERIC_DRIVER_VALUE = "Generic";

	public String GENERIC_PROTOCOL_VALUE = "Generic";
	
	// Cassandra
	
	public String CASSANDRA_DRIVER_VALUE = "org.apache.cassandra.cql.jdbc.CassandraDriver";

	// Query Properties

	public String QUERY_TIMEOUT = "org.wso2.ws.dataservice.query_timeout";

	public String FETCH_DIRECTION = "org.wso2.ws.dataservice.fetch_direction";

	public String FETCH_SIZE = "org.wso2.ws.dataservice.fetch_size";

	public String MAX_FIELD_SIZE = "org.wso2.ws.dataservice.max_field_size";

	public String MAX_ROWS = "org.wso2.ws.dataservice.max_rows";

	// Query Property Display Values

	public String QUERY_TIMEOUT_DISPLAY = "Timeout (Seconds)";

	public String FETCH_DIRECTION_DISPLAY = "Fetch Direction";

	public String FETCH_SIZE_DISPLAY = "Fetch Size";

	public String MAX_FIELD_SIZE_DISPLAY = "Max Field Size (Bytes)";

	public String MAX_ROWS_DISPLAY = "Max Rows";
}
