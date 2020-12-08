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

public class Feature {
	
	protected String id;
	protected String label;
	protected String version;
	protected String provider;
	protected String descriptionURL;
	protected String description;
	protected String copyrightURL;
	protected String copyright;
	protected String licenseURL;
	protected String license;
	protected String iconURL;
	protected String imgURL;
	protected transient IInstallableUnit iu;
	
	public Feature() {
	}

	public Feature(String id, String label, String version) {
		super();
		this.id = id;
		this.label = label;
		this.version = version;
	}
	
	public Feature(IInstallableUnit iu){
		setId(iu.getId());
		this.label = iu.getProperty(IInstallableUnit.PROP_NAME);
		this.version = iu.getVersion().toString();
		this.provider = iu.getProperty(IInstallableUnit.PROP_PROVIDER);
		this.descriptionURL = iu.getProperty(IInstallableUnit.PROP_DESCRIPTION_URL);
		this.description = iu.getProperty(IInstallableUnit.PROP_DESCRIPTION);	
		this.iu = iu;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id.endsWith("feature.jar")){
			id = id.replace("feature.jar", "feature.group");
		}
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getDescriptionURL() {
		return descriptionURL;
	}
	public void setDescriptionURL(String descriptionURL) {
		this.descriptionURL = descriptionURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyrightURL() {
		return copyrightURL;
	}
	public void setCopyrightURL(String copyrightURL) {
		this.copyrightURL = copyrightURL;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getLicenseURL() {
		return licenseURL;
	}
	public void setLicenseURL(String licenseURL) {
		this.licenseURL = licenseURL;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public IInstallableUnit getIu() {
		return iu;
	}

	public void setIu(IInstallableUnit iu) {
		this.iu = iu;
	}	

}
