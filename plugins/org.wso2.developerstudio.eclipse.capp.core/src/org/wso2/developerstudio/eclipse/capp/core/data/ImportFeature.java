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

package org.wso2.developerstudio.eclipse.capp.core.data;


public class ImportFeature {
	private String featureId;
	private String version;
	private String compatibility;
	

	/**
     * @return the featureId
     */
    public String getFeatureId() {
    	return featureId;
    }
	/**
     * @param featureId the featureId to set
     */
    public void setFeatureId(String featureId) {
    	this.featureId = featureId;
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
	/**
     * @return the compatibility
     */
    public String getCompatibility() {
    	return compatibility;
    }
	/**
     * @param compatibility the compatibility to set
     */
    public void setCompatibility(String compatibility) {
    	this.compatibility = compatibility;
    }
	
 
}
