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

package org.wso2.developerstudio.eclipse.capp.core.model;

public class CARDescriptor {
	private String id;
	private String title;
	private String version;
	private String provider;
	
	/**
     * @return the id
     */
    public String getId() {
    	return id;
    }
	/**
     * @param id the id to set
     */
    public void setId(String id) {
    	this.id = id;
    }
	/**
     * @return the title
     */
    public String getTitle() {
    	return title;
    }
	/**
     * @param title the title to set
     */
    public void setTitle(String title) {
    	this.title = title;
    }
	/**
     * @return the version
     */
    public String getVersion() {
    	return version;
    }
	/**
     * @param version the version to set
     */
    public void setVersion(String version) {
    	this.version = version;
    }
    
    public CARDescriptor clone(){
    	CARDescriptor o = new CARDescriptor();
    	o.setId(getId());
    	o.setTitle(getTitle());
    	o.setVersion(getVersion());
    	o.setProvider(getProvider());
    	return o;
    }
	public void setProvider(String provider) {
	    this.provider = provider;
    }
	public String getProvider() {
	    return provider;
    }
}
