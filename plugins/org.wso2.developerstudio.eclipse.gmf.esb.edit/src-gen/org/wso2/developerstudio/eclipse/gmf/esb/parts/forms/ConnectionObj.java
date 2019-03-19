package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

public class ConnectionObj {

	ConnectionObj() {
	}

	private String dbType;
	private String dbDriver;
	private String url;
	private String userName;
	private String password;
	private String host;
	private String port;
	private String database;
	private String version;
	private String jarPath;
	private String jdbcProtocol;

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}

	public String getJdbcProtocol() {
		return jdbcProtocol;
	}

	public void setJdbcProtocol(String jdbcProtocol) {
		this.jdbcProtocol = jdbcProtocol;
	}

	@Override
	public String toString() {
		return "ConnectionObj [dbType=" + dbType + ", dbDriver=" + dbDriver + ", url=" + url + ", userName="
				+ userName + ", password=" + password + ", host=" + host + ", port=" + port + ", database="
				+ database + ", version=" + version + ", jarPath=" + jarPath + ", jdbcProtocol=" + jdbcProtocol
				+ "]";
	}

}