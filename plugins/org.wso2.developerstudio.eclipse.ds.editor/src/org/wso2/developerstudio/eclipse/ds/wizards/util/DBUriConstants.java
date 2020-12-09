package org.wso2.developerstudio.eclipse.ds.wizards.util;

public interface DBUriConstants {

	public String REGEX_RDBMS = "jdbc";

	public String REGEX_COLON = ":";

	public String REGEX_SLASH = "/";

	public String REGEX_DSLASH = "//";

	public String REGEX_AT = "@";

	public String REGEX_SCOLON = ";";

	public String REGEX_EQL = "=";

	public String MYSQL_ID = "mysql";

	public String DERBY_ID = "derby";

	public String MS_SQL_ID = "sqlserver";

	public String ORACLE_ID = "oracle";

	public String DB2_ID = "db2";

	public String HSQL_ID = "hsqldb";

	public String INFORMIX_ID = "informix-sqli";

	public String POSTGRESQL_ID = "postgresql";

	public String SYBASE_ID = "sybase";

	public String H2_ID = "h2";

	// Driver classes

	public String MY_SQL_DRIVER = "com.mysql.jdbc.Driver";

	public String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

	public String MS_SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

	public String DB2_DRIVER = "com.ibm.db2.jcc.DB2Driver";

	public String HSQL_DRIVER = "org.hsqldb.jdbcDriver";

	public String INFORMIX_DRIVER = "com.informix.jdbc.IfxDriver";

	public String POSTGRESQL_DRIVER = "org.postgresql.Driver";

	public String SYBASE_DRIVER = "com.sybase.jdbc3.jdbc.SybDriver";

	public String H2_DRIVER = "org.h2.Driver";

	public String DB_NI = "DB Not Identified";

	public String CSV_TYPE = ".csv";

	public String CSV_TYPE_ONLIN = "csv_online";

	public String XLS_TYPE_ONLIN = "xls_online";

	public String XLS_TYPE = ".xls";

	public String NO_TYPE = "EXTNI";

	public String GSS_TYPE = "https://docs.google.com/spreadsheet/"; // length =
	                                                                 // 36

	public String REGEX_GSS_SPREAD = "spreadsheet{1}";

	public String VIS_PUB = "public";

	public String VISS_PRI = "private";

	public String ONLINE_R = "http://"; // 7

	public String ONLINE_RS = "https://"; // 8

	public String NI = "Not Identified";

	// JDBC properties
	public String DB_URL = "db_url";

	public String DB_TYPE = "db_type";

	public String DB_DRIVER = "db_driver";

	public String HOST = "host";

	public String PORT = "port";

	public String DB_NAME = "db_name";

	public String DB_U_NAME = "user_name";

	public String DB_PASSWD = "passwd";

	public String DB_FILE_PATH = "db_file_path";

	public String DB_DRIVE_TYPE = "db_drive_type";

	public String DB_SERVER_NAME = "server_name";

	public String RDBMS_FLAG = "rdbms_flag";

	// MsSql properties

	public String MS_DBNAME = "databaseName";

	// oracle properties

	public String ORC_TYPE = "oracle_url_type";

	public String ORC_TYPE_ONE = "ORC_ONE";

	public String ORC_TYPE_TWO = "ORC_TWO";

	public String ORC_TYPE_THREE = "ORC_THREE";

	// informix properties

	public String INFORMIXSERVER = "INFORMIXSERVER";

	// sybase properties

	public String SYBASE_TDS = "Tds";

	// h2 properties

	public String H2_TCP = "tcp";

	public String CHEK_BTN_FLG = "checkbutton";

	public String RADIO_BTN_FLG = "radiobtn";

}
