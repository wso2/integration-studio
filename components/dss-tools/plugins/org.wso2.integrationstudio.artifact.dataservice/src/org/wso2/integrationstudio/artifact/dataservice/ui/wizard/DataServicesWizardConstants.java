/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.artifact.dataservice.ui.wizard;

public class DataServicesWizardConstants {
    
    public static final String OS_NAME = "os.name";
    public static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";
    public static final String OS_TYPE_WINDOWS = "windows";
    public static final String HELP_ICON = "/icons/help.png";
    
    public static class DBTypes {
        public static final String DB_TYPE_MYSQL = "mysql";
        public static final String DB_TYPE_ORACLE = "oracle";
        public static final String DB_TYPE_MSSQL = "mssql";
        public static final String DB_TYPE_POSTGRESSQL = "postgresql";
        public static final String DB_TYPE_DERBY = "apachederby";
        public static final String DB_TYPE_DERBY_CONN = "derby";
        public static final String DB_TYPE_MSSQL_CONN = "sqlserver";
        public static final String DB_URL_JDBC_BASE = "jdbc:";
        public static final String DB_TYPE_H2 = "h2";
    }
    
    public static class DBDrivers {
        public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
        public static final String DERBY_CLIENT_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        public static final String MS_SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
        public static final String DB2_DRIVER = "com.ibm.db2.jcc.DB2Driver";
        public static final String HSQL_DRIVER = "org.hsqldb.jdbcDriver";
        public static final String INFORMIX_DRIVER = "com.informix.jdbc.IfxDriver";
        public static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
        public static final String H2_DRIVER = "org.h2.Driver";
    }
    
    public static class DBConnectionParams {
        public static final String MYSQL_JAR = "mysql-connector-java";
        public static final String MSSQL_JAR = "mssql-jdbc";
        public static final String POSTGRESSQL_JAR = "postgresql";
        public static final String DERBY_JAR = "derbyclient";
        public static final String H2_JAR = "h2";
        
        public static final String MYSQL_VERSION_5_1_47 = "5_1_47";
        public static final String MYSQL_VERSION_8_0_15 = "8_0_15";
        public static final String MSSQL_VERSION_6_4_0 = "6_4_0";
        public static final String MSSQL_VERSION_7_20_0 = "7_20_0";
        public static final String POSTGRESSQL_VERSION_42_2_11 = "42_2_11";
        public static final String DERBY_VERSION_10_14_2_0 = "10_14_2_0";
        public static final String H2_VERSION_1_4_200 = "1_4_200";
    }
    
    public static class DBUrlParams {
        public static final String DB_URL_JDBC_BASE = "jdbc:";
        public static final String DB_DRIVER_URL_BASE = "jar:file:";
        public static final String DB_DRIVER_JAR_BASE = "/dbdrivers/";
        public static final String DB_URL_JDBC_SUFFIX = "!/";
    }
    
    public static class ErrorMessages {
        public static final String DATASOURCE_NOT_FOUND = "No datasource found in the current workspace";
        public static final String DATASOURCE_NOT_SELECTED = "Datasource is not selected";
        public static final String TABLE_NOT_FOUND = "No tables found";
        public static final String SELECTED_TABLES_EMPTY = "Select the tables to generate services";
        public static final String INVALID_JAR = "Please select a valid .jar file";
        public static final String EMPTY_JAR_FILE = "Please download or browse driver.";
    }
    
    public static class Tooltips {
        public static final String SELECT_DATASOURCE = "Select the datasource that you have added in the current workspace.";
        public static final String DISABLE_DUE_TO_READONLY = "Disabled as the datasource is read-only";
        public static final String DISABLE_DUE_TO_PRIMARY_KEY = "Disabled as the table doesn't have a primary key"; 
        public static final String SINGLE_SERVICE_GENERATION = "Generate one service for all selected tables";
        public static final String MULTIPLE_SERVICES_GENERATION = "Generate a service per table";
    }

}
