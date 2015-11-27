/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.appfactory.core.model;

public class AppVersionInfo {
 
	  private String isAutoDeploy;
	  private String repoURL;
	  private String version;
	  private String stage;
	  private String isAutoBuild;
	  private String lastBuildResult;
	  private String appName;
	  private String localRepo;
	  private boolean isCheckedout;
	  private boolean isbuildRequestCansel;
	  private boolean isForkedVersion;
	  private AppVersionGroup versionGroup;
	  
	public String getIsAutoDeploy() {
		return isAutoDeploy;
	}
	
	public void setIsAutoDeploy(String isAutoDeploy) {
		this.isAutoDeploy = isAutoDeploy;
	}
	public String getRepoURL() {
		return repoURL;
	}
	public void setRepoURL(String repoURL) {
		this.repoURL = repoURL;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getIsAutoBuild() {
		return isAutoBuild;
	}
	public void setIsAutoBuild(String isAutoBuild) {
		this.isAutoBuild = isAutoBuild;
	}
	public String getLastBuildResult() {
		return lastBuildResult;
	}
	public void setLastBuildResult(String lastBuildResult) {
		this.lastBuildResult = lastBuildResult;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public boolean isIsbuildRequestCansel() {
		return isbuildRequestCansel;
	}

	public void setIsbuildRequestCansel(boolean isbuildRequest) {
		this.isbuildRequestCansel = isbuildRequest;
	}

	public String getLocalRepo() {
		return localRepo;
	}

	public void setLocalRepo(String localRepo) {
		this.localRepo = localRepo;
	}

	public boolean isCheckedout() {
		return isCheckedout;
	}

	public void setCheckedout(boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}

	public boolean isForkedVersion() {
		return isForkedVersion;
	}

	public void setForkedVersion(boolean isForkedVersion) {
		this.isForkedVersion = isForkedVersion;
	}

	public AppVersionGroup getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(AppVersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	} 

}
