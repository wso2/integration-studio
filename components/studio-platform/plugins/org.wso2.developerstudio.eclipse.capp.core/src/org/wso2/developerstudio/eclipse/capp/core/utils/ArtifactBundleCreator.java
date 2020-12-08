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

package org.wso2.developerstudio.eclipse.capp.core.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact;
import org.wso2.developerstudio.eclipse.capp.core.manifest.CAppArtifactBundleManifest;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ArtifactBundleCreator {
	private Artifact artifact;
	private String parentApplication;
	private File location;
	
	public ArtifactBundleCreator(Artifact artifact,File location, String parentApplication) {
	    setArtifact(artifact);
	    setParentApplication(parentApplication);
	    setLocation(location);
    }

	public void setArtifact(Artifact artifact) {
	    this.artifact = artifact;
    }

	public Artifact getArtifact() {
	    return artifact;
    }

	public void setParentApplication(String parentApplication) {
	    this.parentApplication = parentApplication;
    }

	public String getParentApplication() {
	    return parentApplication;
    }
	
	public File getBundle() throws Exception{
        File tmpFolder = FileUtils.createTempDirectory();
        File bundleContentPath = new File(tmpFolder,"bundle-content");
        FileUtils.copyDirectory(getLocation(), bundleContentPath);
        File metainfPath = new File(bundleContentPath,"META-INF");
        File manifestFile=new File(metainfPath,"MANIFEST.MF");
        manifestFile.getParentFile().mkdirs();
        CAppArtifactBundleManifest cAppArtifactBundleManifest = new CAppArtifactBundleManifest(getArtifact());
        cAppArtifactBundleManifest.setParentApplication(getParentApplication());
        cAppArtifactBundleManifest.toFile(manifestFile);
        File bundle = new File(tmpFolder,getArtifact().getName()+"-"+getArtifact().getTimestampedVersion() + ".jar");
        new ArchiveManipulator().archiveDir(bundle.toString(), bundleContentPath.toString());
        return bundle;
	}

	public Map<Artifact,File> getArtifactContent() throws Exception{
        return getArtifactContent(null);
	}
	
	public Map<Artifact,File> getArtifactContent(File contentLocation) throws Exception{
        File tmpFolder = contentLocation==null? new File(FileUtils.createTempDirectory(),getArtifact().getName() 
        		+ "-" + getArtifact().getTimestampedVersion()):contentLocation;
        FileUtils.copyDirectory(getLocation(), tmpFolder);
        return createArtifactMap(getArtifact(),tmpFolder);
	}

	protected Map<Artifact, File> createArtifactMap(Artifact artifact, File tmpFolder) {
        return createArtifactMap(artifact, tmpFolder, null);
    }

	protected Map<Artifact, File> createArtifactMap(Artifact artifact, File tmpFolder,
            Map<Artifact, File> artifacts) {
		if (artifacts==null){
			artifacts = new HashMap<Artifact, File>();
		}
	    artifacts.put(artifact, tmpFolder);
	    return artifacts;
    }
	
	public void setLocation(File location) {
	    this.location = location;
    }

	public File getLocation() {
	    return location;
    }
	
}
