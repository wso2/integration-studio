package org.wso2.developerstudio.eclipse.registry.base.persistent;

import java.net.URL;

/**
 * RegistryURLInfo inner class
 * 
 *
 */
public class RegistryURLInfo {
	private URL url;
	private String path;
	private String username;
	private boolean enabled = true;
	private boolean persist = true;
	private boolean isSpecificControl; // True when it Registry Url create from out side the Registry perspective

	public void setUrl(URL url) {
		this.url = url;
		if (isPersist()){
			RegistryUrlStore.getInstance().persist();
		}
	}

	public URL getUrl() {
		return url;
	}

	public void setPath(String path) {
		this.path = path;
		if (isPersist()){
			RegistryUrlStore.getInstance().persist();
		}
	}

	public String getPath() {
		return path;
	}

	public void setUsername(String username) {
		this.username = username;
		if (isPersist()){
			RegistryUrlStore.getInstance().persist();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setPersist(boolean persist) {
		this.persist = persist;
	}

	public boolean isPersist() {
		return persist;
	}

	public boolean isSpecificControl() {
		return isSpecificControl;
	}

	public void setSpecificControl(boolean isAPImanager) {
		this.isSpecificControl = isAPImanager;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (isPersist()){
			RegistryUrlStore.getInstance().persist();
		}
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	      public boolean equals(Object obj) {
		                if (obj instanceof RegistryURLInfo){
		            if(path.equals(((RegistryURLInfo)obj).path) &&url.equals(((RegistryURLInfo)obj).url) &&
		                       username.equals(((RegistryURLInfo)obj).username)){
		               return true;
		            }
		               }
		                return false;
		     }

}