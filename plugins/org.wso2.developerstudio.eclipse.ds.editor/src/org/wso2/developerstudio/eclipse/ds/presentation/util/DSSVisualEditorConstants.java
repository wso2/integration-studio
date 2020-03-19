/*
 *     Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */

package org.wso2.developerstudio.eclipse.ds.presentation.util;

// Constants related to the DSS visual editor page
public class DSSVisualEditorConstants {

    public static class General {
        public static final String DSS_EDITOR = "DSS Editor";
        public static final String GUI_EDITOR_NAME = "Design";
        public static final String SOURCE_EDITOR_NAME = "Source";
        public static final String EMPTY_INPUT = "";
    }

    public static class WebApp {
        public static final String INDEX_HTML_FILE_NAME = "index.html";
    }

    public static class ErrorMessages {
        public static final String ERROR_CREATING_UI_EDITOR = "Error creating GUI editor";
        public static final String ERROR_CREATING_NESTED_TEXT_EDITOR = "Error creating nested text editor";
        public static final String ERROR_INVALID_INPUT_MUST_BE_IFILE_EDITOR_INPUT = "Invalid input: Must be IFileEditorInput";
    }

    public static class RequestHeaders {
        public static final String HEADER_OPERATION_TYPE = "x-operation-type";
        public static final String HEADER_VALUE_SAVE_ALL = "save-all";
        public static final String HEADER_VALUE_SAVE_DS_METADATA = "save-ds-metadata";
        public static final String HEADER_VALUE_RETRIEVE_DS_METADATA = "get-ds-metadata";
        public static final String HEADER_VALUE_TEST_DS_CONNECTION = "test-ds-connection";
        public static final String HEADER_VALUE_GENERATE_MAPPINGS = "generate-mappings";
    }

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

    public static class DBUrlParams {
        public static final String DB_URL_JDBC_BASE = "jdbc:";
        public static final String DB_DRIVER_URL_BASE = "jar:file:";
        public static final String DB_DRIVER_JAR_BASE = "/dbdrivers/";
        public static final String DB_URL_JDBC_SUFFIX = "!/";
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
        public static final String MYSQL_JAR_5_1_47 = "mysql-connector-java-5.1.47.jar";
        public static final String MYSQL_JAR_8_0_15 = "mysql-connector-java-8.0.15.jar";
        public static final String MSSQL_JAR_6_4_0 = "mssql-jdbc-6.4.0.jre8.jar";
        public static final String MSSQL_JAR_7_20_0 = "mssql-jdbc-7.2.0.jre8.jar";
        public static final String POSTGRESSQL_JAR_42_2_11 = "postgresql-42.2.11.jar";
        public static final String DERBY_JAR_10_14_2_0 = "derbyclient-10.14.2.0.jar";
        public static final String H2_JAR_1_4_200 = "h2-1.4.200.jar";
        
        public static final String MYSQL_VERSION_5_1_47 = "5_1_47";
        public static final String MYSQL_VERSION_8_0_15 = "8_0_15";
        public static final String MSSQL_VERSION_6_4_0 = "6_4_0";
        public static final String MSSQL_VERSION_7_20_0 = "7_20_0";
        public static final String POSTGRESSQL_VERSION_42_2_11 = "42_2_11";
        public static final String DERBY_VERSION_10_14_2_0 = "10_14_2_0";
        public static final String H2_VERSION_1_4_200 = "1_4_200";
    }
}
