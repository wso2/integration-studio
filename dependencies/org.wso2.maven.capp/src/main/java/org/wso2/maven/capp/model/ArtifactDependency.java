/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.maven.capp.model;

import java.util.Observable;
import java.util.Observer;

public class ArtifactDependency extends Observable implements Observer{
	private String name;
	private String version;
	private String serverRole;
	
	private Artifact parentArtifact;
	
	boolean include=false;
	
	public ArtifactDependency(Artifact parentArtifact) {
		setParentArtifact(parentArtifact);
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isInclude() {
		return include;
	}
	public void setInclude(boolean include) {
		this.include = include;
	}

	public String toString() {
	    return getCaption();
	}
	
	public void setServerRole(String serverRole) {
	    this.serverRole = serverRole;
    }
	
	public String getServerRole() {
		if(getParentArtifact()!= null){
			if (!getParentArtifact().isSuperArtifact()){
				return null;
			}
		}
		return serverRole;
    }

	public void setParentArtifact(Artifact parentArtifact) {
	    this.parentArtifact = parentArtifact;
    }
	
	public Artifact getParentArtifact() {
	    return parentArtifact;
    }
	
	public String getCaption(){
		return getName()+" - "+getVersion();
	}

	public void update(Observable o, Object arg) {
		
	}
}
