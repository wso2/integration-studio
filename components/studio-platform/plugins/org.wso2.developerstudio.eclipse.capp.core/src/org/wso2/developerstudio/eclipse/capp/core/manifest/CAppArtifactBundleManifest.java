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

package org.wso2.developerstudio.eclipse.capp.core.manifest;

import java.util.ArrayList;
import java.util.List;


public class CAppArtifactBundleManifest extends BundleManifest{
	private String parentApplication;
	private Artifact artifact;
	
	public CAppArtifactBundleManifest(Artifact artifact) {
		setArtifact(artifact);
    }
	
	/**
     * @return the parentApplication
     */
    public String getParentApplication() {
    	return parentApplication;
    }
	/**
     * @param parentApplication the parentApplication to set
     */
    public void setParentApplication(String parentApplication) {
    	this.parentApplication = parentApplication;
    }
	protected List<String> getAdditionalHeaders() {
		List<String> list=new ArrayList<String>();

	    if (getParentApplication() != null) {
            list.add(getManifestHeaderLine("ParentApplication",getParentApplication()));
        }

	    return list;
    }
	
	public String getTimestampedBundleVersion() {
	    return getArtifact().getTimestampedVersion();
    }
	

	public void setArtifact(Artifact artifact) {
	    this.artifact = artifact;
	    setBundleSymbolicName(artifact.getName());
	    setBundleName(artifact.getName());
	    setBundleDescription(artifact.getName());
	    setBundleVersion(artifact.getVersion());
    }

	public Artifact getArtifact() {
	    return artifact;
    }


}
