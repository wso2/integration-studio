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

package org.wso2.developerstudio.eclipse.utils.jdt;

/**
 * This bean class represent a Java Library which is used in a Java program or a
 * C-App and contains the basic details about the Library.
 */
public class JavaLibraryBean {

	private String path;
	private String groupId;
	private String artifactId;
	private String version;

	/**
     * Constructor
     */
	public JavaLibraryBean(String path, String groupId, String artifactId, String version) {
		this.setPath(path);
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	/**
     * @param path the path to set
     */
    public void setPath(String path) {
	    this.path = path;
    }

	/**
     * @return the path
     */
    public String getPath() {
	    return path;
    }
    
    public String toString(){
		return groupId+":"+artifactId+":"+version;
    	
    }

}
