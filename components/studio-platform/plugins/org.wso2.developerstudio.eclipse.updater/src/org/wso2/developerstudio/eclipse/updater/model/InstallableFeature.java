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

public class InstallableFeature extends Feature {
	
	protected String p2Errors;
	protected boolean installable;
	protected boolean selected;
	
	public InstallableFeature() {
	}

	public InstallableFeature(IInstallableUnit iu) {
		super(iu);
	}

	public InstallableFeature(String id, String label, String version) {
		super(id, label, version);
	}

	public String getP2Errors() {
		return p2Errors;
	}
	public void setP2Errors(String p2Errors) {
		this.p2Errors = p2Errors;
	}
	public boolean isInstallable() {
		return installable;
	}
	public void setInstallable(boolean installable) {
		this.installable = installable;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
