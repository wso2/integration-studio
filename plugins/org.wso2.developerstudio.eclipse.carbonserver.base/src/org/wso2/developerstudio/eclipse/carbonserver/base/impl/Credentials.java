package org.wso2.developerstudio.eclipse.carbonserver.base.impl;

import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICredentials;

public class Credentials implements ICredentials {
	private String username;
	private String password;

	public Credentials(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
