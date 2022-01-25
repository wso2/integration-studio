/*
* Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

var configParameterTagToId = {
    defaultAutoCommit: "#ds-default-auto-commit-select",
    defaultReadOnly: "#ds-default-read-only-select",
    defaultTransactionIsolation: "#ds-default-transaction-isolation",
    defaultCatalog: "#ds-default-catalog-input",
    maxActive: "#ds-max-active-input",
    maxIdle: "#ds-max-idle-input",
    minIdle: "#ds-min-idle-input",
    initialSize: "#ds-initial-size-input",
    maxWait: "#ds-max-wait-input",
    testOnBorrow: "#ds-test-on-borrow-select",
    testOnReturn: "#ds-test-on-return-select",
    testWhileIdle: "#ds-test-while-idle-select",
    validationQuery: "#ds-validation-query-input",
    validatorClassName: "#ds-validation-class-name-input",
    timeBetweenEvictionRunsMillis: "#ds-time-between-eviction-runs-input",
    numTestsPerEvictionRun: "#ds-tests-per-eviction-run-input",
    minEvictableIdleTimeMillis: "#ds-min-evictable-idle-time-input",
    accessToUnderlyingConnectionAllowed: "#ds-access-underlying-connection-select",
    removeAbandoned: "#ds-remove-abandoned-select",
    removeAbandonedTimeout: "#ds-remove-abandoned-timeout-input",
    logAbandoned: "#ds-log-abandoned-select",
    connectionProperties: "#ds-connection-properties-input",
    initSQL: "#ds-init-sql-input",
    jdbcInterceptors: "#ds-jdbc-interceptors-input",
    validationInterval: "#ds-validation-interval-input",
    jmxEnabled: "#ds-jmx-enabled-select",
    fairQueue: "#ds-fair-queue-select",
    abandonWhenPercentageFull: "#ds-abandon-when-percentage-full-input",
    maxAge: "#ds-max-age-input",
    useEquals: "#ds-use-equals-select",
    suspectTimeout: "#ds-suspect-timeout-input",
    validationQueryTimeout: "#ds-validation-query-timeout-input",
    alternateUsernameAllowed: "#ds-alternate-username-allowed-select"
}

// Common constants
const EMPTY_STRING = "";
const TRUE_STRING = "true";
const FALSE_STRING = "false";

// Contains constants related to the DSS editor
const OPERATION_TYPE_HEADER_SAVE_ALL = "save-all";
const HEADER_VALUE_SAVE_DS_METADATA = "save-ds-metadata";
const HEADER_VALUE_RETRIEVE_DS_METADATA = "get-ds-metadata";
const HEADER_VALUE_TEST_DS_CONNECTION = "test-ds-connection";

// Metadata related constants
const DS_METADATA_KEYVALUE_SEPARATOR = "|";
const DS_METADATA_DATA_MODEL = "datamodel";
const CURRENT_PAGE_KEY = "currentpage";
const CURRENT_PAGE_VAL_DESIGN = "design";
const CURRENT_PAGE_VAL_SOURCE = "source";
const XML_SOURCE_VALIDITY_KEY = "xmlvalidity";
const XML_SOURCE_INVALID = "invalid";
const XML_SOURCE_VALID = "valid";

// DS Types
const DS_TYPE_RDBMS = "rdbms_ds";
const DS_TYPE_CUSTOM = "custom_ds";

//// RDBMS Types
const RDBMS_TYPE_DEFAULT = "default_ds";
const RDBMS_TYPE_EXTERNAL = "external_ds";

// DB Engines
const DB_ENGINE_MYSQL = "mysql";
const DB_ENGINE_ORACLE = "oracle";
const DB_ENGINE_MSSQL = "mssql";
const DB_ENGINE_H2 = "h2";
const DB_ENGINE_POSTGRESQL = "postgresql";
const DB_ENGINE_APACHEDERBY = "apachederby";
const DB_ENGINE_IBMDB2 = "ibmdb2";
const DB_ENGINE_HSQLDB = "hsqldb";
const DB_ENGINE_INFORMIX = "informix";
const DB_ENGINE_SYBASE = "sybasease";
const DB_ENGINE_GENERIC = "generic";

// Default values for DB engines
//// MySQL
const DEFAULT_MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
const DEFAULT_MYSQL_URL = "jdbc:mysql://[machine-name/ip]:[port]/[database-name]";
//// MSSQL
const DEFAULT_MSSQL_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
const DEFAULT_MSSQL_URL = "jdbc:sqlserver://[HOST]:[PORT1433];databaseName=[DB]";
//// Oracle
const DEFAULT_ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
const DEFAULT_ORACLE_URL = "jdbc:oracle:[drivertype]:[username/password]@[host]:[port]/[database]";
//// H2
const DEFAULT_H2_DRIVER_CLASS = "org.h2.Driver";
const DEFAULT_H2_URL = "jdbc:h2:tcp:[HOST]:[PORT]/[database]";
//// PostgreSQL
const DEFAULT_POSTGRESQL_DRIVER_CLASS = "org.postgresql.Driver";
const DEFAULT_POSTGRESQL_URL = "jdbc:postgresql://[HOST]:[PORT5432]/[database]";
//// Apache Derby
const DEFAULT_DERBY_DRIVER_CLASS = "org.apache.derby.jdbc.EmbeddedDriver";
const DEFAULT_DERBY_URL = "jdbc:derby://[HOST]:[PORT]/[database]";
//// IBM DB2
const DEFAULT_IBMDB2_DRIVER_CLASS = "com.ibm.db2.jcc.DB2Driver";
const DEFAULT_IBMDB2_URL = "jdbc:db2:[database]";
//// HSQL
const DEFAULT_HSQL_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
const DEFAULT_HSQL_URL = "jdbc:hsqldb:[path]";
//// Informix
const DEFAULT_INFORMIX_DRIVER_CLASS = "com.informix.jdbc.IfxDriver";
const DEFAULT_INFORMIX_URL = "jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[server-name]";
//// Sybase
const DEFAULT_SYBASE_DRIVER_CLASS = "com.sybase.jdbc3.jdbc.SybDriver";
const DEFAULT_SYBASE_URL = "jdbc:sybase:Tds:[HOST]:[PORT2048]/[database]";
