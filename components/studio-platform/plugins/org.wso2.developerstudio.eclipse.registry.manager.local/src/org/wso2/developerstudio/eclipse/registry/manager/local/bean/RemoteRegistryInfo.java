package org.wso2.developerstudio.eclipse.registry.manager.local.bean;

import java.net.URL;

public class RemoteRegistryInfo {
	private URL url;
	private boolean collection;
	private long resourceCreationTime;
	private long resourceLastUpdateTime;
	private String resourceCreationUser;
	private String resourceLastUpdateUser;
	private String path;

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public boolean isCollection() {
		return collection;
	}

	public void setCollection(boolean collection) {
		this.collection = collection;
	}

	public long getResourceCreationTime() {
		return resourceCreationTime;
	}

	public void setResourceCreationTime(long resourceCreationTime) {
		this.resourceCreationTime = resourceCreationTime;
	}

	public long getResourceLastUpdateTime() {
		return resourceLastUpdateTime;
	}

	public void setResourceLastUpdateTime(long resourceLastUpdateTime) {
		this.resourceLastUpdateTime = resourceLastUpdateTime;
	}

	public String getResourceCreationUser() {
		return resourceCreationUser;
	}

	public void setResourceCreationUser(String resourceCreationUser) {
		this.resourceCreationUser = resourceCreationUser;
	}

	public String getResourceLastUpdateUser() {
		return resourceLastUpdateUser;
	}

	public void setResourceLastUpdateUser(String resourceLastUpdateUser) {
		this.resourceLastUpdateUser = resourceLastUpdateUser;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
