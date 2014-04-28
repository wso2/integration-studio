package org.wso2.developerstudio.appfactory.core.model;

public class AppVersionGroup {
	
	private ApplicationInfo application;
	private String versionGroupName;
	private AppVersionInfo mainVersion;
	private AppVersionInfo forkedVersion;
	
	public AppVersionGroup() {
	}
	
	
	
	public AppVersionGroup(ApplicationInfo application,
			String versionGroupName, AppVersionInfo mainVersion) {
		super();
		this.application = application;
		this.versionGroupName = versionGroupName;
		this.mainVersion = mainVersion;
	}



	public AppVersionGroup(ApplicationInfo application,
			String versionGroupName, AppVersionInfo mainVersion,
			AppVersionInfo forkedVersion) {
		super();
		this.application = application;
		this.versionGroupName = versionGroupName;
		this.mainVersion = mainVersion;
		this.forkedVersion = forkedVersion;
	}
	
	public ApplicationInfo getApplication() {
		return application;
	}
	
	public void setApplication(ApplicationInfo application) {
		this.application = application;
	}
	
	public String getVersionGroupName() {
		return versionGroupName;
	}
	
	public void setVersionGroupName(String versionGroupName) {
		this.versionGroupName = versionGroupName;
	}
	
	public AppVersionInfo getMainVersion() {
		return mainVersion;
	}
	
	public void setMainVersion(AppVersionInfo mainVersion) {
		this.mainVersion = mainVersion;
	}
	
	public AppVersionInfo getForkedVersion() {
		return forkedVersion;
	}
	
	public void setForkedVersion(AppVersionInfo forkedVersion) {
		this.forkedVersion = forkedVersion;
	}
	
	public boolean hasForkedBranch(){
		
		return forkedVersion!=null;
	}
	

}
