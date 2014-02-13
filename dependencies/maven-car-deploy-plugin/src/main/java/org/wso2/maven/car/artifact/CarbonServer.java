package org.wso2.maven.car.artifact;

public class CarbonServer {
	
	private String trustStorePath;
	
	private String trustStorePassword;
	
	private String trustStoreType;
	
	private String serverUrl;
	
	private String userName;
	
	
	private String password;
	
	private String operation;


	public String getTrustStorePath() {
		return trustStorePath;
	}


	public void setTrustStorePath(String trustStorePath) {
		this.trustStorePath = trustStorePath;
	}


	public String getTrustStorePassword() {
		return trustStorePassword;
	}


	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}


	public String getTrustStoreType() {
		return trustStoreType;
	}


	public void setTrustStoreType(String trustStoreType) {
		this.trustStoreType = trustStoreType;
	}


	public String getServerUrl() {
		return serverUrl;
	}


	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
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


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String getOperation() {
		return operation;
	}

}
