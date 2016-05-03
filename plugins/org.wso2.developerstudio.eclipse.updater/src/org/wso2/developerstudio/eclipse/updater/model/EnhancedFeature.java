/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.updater.model;

import org.eclipse.equinox.p2.metadata.IInstallableUnit;

public class EnhancedFeature extends InstallableFeature {

	protected String currentVersion;
	protected String whatIsNew;
	protected String bugFixes;
	protected boolean isKernelFeature;
	protected boolean isHidden;
	protected String[] children;
	protected boolean isUpdateFeature;
	
	public boolean isUpdateFeature() {
		return isUpdateFeature;
	}

	public void setUpdateFeature(boolean isUpdateFeature) {
		this.isUpdateFeature = isUpdateFeature;
	}

	public String[] getChildFeatures() {
		return children;
	}

	public void setChildFeatures(String[] childFeatures) {
		this.children = childFeatures;
	}

	public EnhancedFeature() {
	}

	public EnhancedFeature(IInstallableUnit iu) {
		super(iu);
	}

	public EnhancedFeature(String id, String label, String version) {
		super(id, label, version);
	}

	public String getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	public String getWhatIsNew() {
		return whatIsNew;
	}
	public void setWhatIsNew(String whatIsNew) {
		this.whatIsNew = whatIsNew;
	}
	public String getBugFixes() {
		return bugFixes;
	}
	public void setBugFixes(String bugFixes) {
		this.bugFixes = bugFixes;
	}
	public boolean isKernelFeature(){
		return isKernelFeature;
	}
	public void setKernelFeature(boolean isKernelFeature){
		this.isKernelFeature = isKernelFeature;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

}
