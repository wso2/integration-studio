package org.wso2.developerstudio.eclipse.carbonserver.remote.internal;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.wst.server.core.model.RuntimeDelegate;

public class RemoteCarbonRuntimeDeligate extends RuntimeDelegate {
	private static final String ATTR_USERNAME = "USERNAME";
	private static final String ATTR_PASSWORD = "PASSWORD";
	private static final String ATTR_URL = "SERVER_URL";

	public String getUsername() {
		return getAttribute(ATTR_USERNAME, "admin");
	}

	public String getPassword() {
		return getAttribute(ATTR_PASSWORD, "admin");
	}

	public URL getServerURL() {
		String urlAttr = getAttribute(ATTR_URL, "");
		try {
			URL url = new URL(urlAttr);
			return url;
		} catch (Exception e) {
			return null;
		}
	}

	public void setUsername(String username) {
		setAttribute(ATTR_USERNAME, username);
	}

	public void setPassword(String password) {
		setAttribute(ATTR_PASSWORD, password);
	}

	public void setServerURL(String url) throws MalformedURLException {
		setServerURL(new URL(url));
	}

	public void setServerURL(URL url) throws MalformedURLException {
		if (getRuntimeWorkingCopy() == null) {

		}
		if (url == null) {
			setAttribute(ATTR_URL, "");
		} else {
			String[] paths = url.getPath().split("/");
			String firstPath = paths[0];
			if (firstPath.equalsIgnoreCase("carbon") || firstPath.equalsIgnoreCase("registry") ||
			    firstPath.equalsIgnoreCase("services")) {
				firstPath = "/";
			}
			URL serverURL = new URL(url.getProtocol(), url.getHost(), url.getPort(), firstPath);
			setAttribute(ATTR_URL, serverURL.toString());
		}
	}

}
