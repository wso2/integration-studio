// Common constants
const EMPTY_STRING = "";
const TRUE_STRING = "true";
const FALSE_STRING = "false";

// Contains constants related to the DSS editor
const OPERATION_TYPE_HEADER = "x-operation-type";
const OPERATION_TYPE_HEADER_SAVE_ALL = "save-all";
const HEADER_VALUE_SAVE_DS_METADATA = "save-ds-metadata";
const HEADER_VALUE_RETRIEVE_DS_METADATA = "get-ds-metadata";
const HEADER_VALUE_TEST_DS_CONNECTION = "test-ds-connection";
const HEADER_VALUE_GENERATE_MAPPINGS = "generate-mappings";

// Metadata related constants
const DS_METADATA_ID_SEPARATOR = "?";
const DS_METADATA_SEPARATOR = ",";
const DS_METADATA_KEYVALUE_SEPARATOR = ":";
const DS_METADATA_DS_TYPE = "dstype";
const DS_METADATA_RDBMS_TYPE = "rdbmstype";
const DS_METADATA_DB_ENGINE = "dbengine";

// DS Types
const DS_TYPE_RDBMS = "rdbms_ds";
const DS_TYPE_CARBONDS = "carbon_ds";
const DS_TYPE_MONGODB = "mongodb_ds";
const DS_TYPE_CSV = "csv";

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

// Secret alias
const SECRET_ALIAS_NAMESPACE = "http://org.wso2.securevault/configuration";
const SECRET_ALIAS_NAMESPACE_ATTRIBUTE = "xmlns:svns";
const SECRET_ALIAS_ATTRIBUTE = "svns:secretAlias";

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

// Queries
////SQL query
//////SQL terms
const SQL_WHERE = "where";

//// Input Mappings
////// Attributes
const QUERY_PARAM_OPTIONAL_CHECK_INPUT = "#q-im-optional-check";
const QUERY_PARAM_OPTIONAL = "optional";

////// Validators
const VALIDATOR_LONGRANGE = "validateLongRange";
const VALIDATOR_DOUBLERANGE = "validateDoubleRange";
const VALIDATOR_LENGTH = "validateLength";
const VALIDATOR_PATTERN = "validatePattern";
const VALIDATOR_TYPE_RANGE = "range";
const VALIDATOR_TYPE_PATTERN = "pattern";

//// Output Mappings
////// Attributes
const RESULT_ATTRIBUTE_ELEMENT = "element";
const RESULT_ATTRIBUTE_ROW_NAME = "rowName";
const RESULT_ATTRIBUTE_DEF_NAME_SPACE = "defaultNamespace";
const RESULT_ATTRIBUTE_XSLT_PATH = "xsltPath";
