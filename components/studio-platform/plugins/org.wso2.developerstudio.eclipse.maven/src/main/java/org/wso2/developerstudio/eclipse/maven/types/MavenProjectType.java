/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.maven.types;

import java.util.Observable;


/**
 * This class contains the parameter to be set for the generated project using
 * the maven archetype.
 * 
 * @since 1.1.0
 * 
 */
public class MavenProjectType extends Observable{

	private String groupId;
	private String artifactId;
	private String version;
	private String packageName;
	private String relativePath;
	
	public MavenProjectType(String groupId, String projectName, String version,
			String packageName) {
		setGroupId(groupId);
		setArtifactId(projectName);
		setVersion(version);
		this.packageName = packageName;
	}

	public MavenProjectType(String groupId, String projectName, String version) {
		setGroupId(groupId);
		setArtifactId(projectName);
		setVersion(version);
	}

	public String getGroupId() {
		return groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getVersion() {
		return version;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setGroupId(String groupId) {
		if (isTriggerObservers(this.groupId,groupId)) {
			this.groupId = groupId;
			triggerObservers();
		}
	}

	public void setArtifactId(String artifactId) {
		boolean triggerObservers = isTriggerObservers(this.artifactId, artifactId);
		this.artifactId = artifactId;
		if (triggerObservers) {
			triggerObservers();
		}
	}

	public void setVersion(String version) {
		boolean triggerObservers = isTriggerObservers(this.version, version);
		this.version = version;
		if (triggerObservers) {
			triggerObservers();
		}
	}

	private void triggerObservers() {
		setChanged();
		notifyObservers();
	}
	
	private boolean isTriggerObservers(String oldValue, String newValue){
		if (oldValue == null && newValue == null) {
			return false;
		}
		if ((oldValue != null && !oldValue.equals(newValue))
				|| (newValue != null && !newValue.equals(oldValue))) {
			return true;
		}
		return false;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getRelativePath() {
		return relativePath;
	}
}
