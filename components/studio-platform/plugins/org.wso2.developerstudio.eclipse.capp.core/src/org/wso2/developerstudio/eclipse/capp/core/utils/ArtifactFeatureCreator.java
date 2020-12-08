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

import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.ICAppArtifactHandler;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.data.Bundle;
import org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact;
import org.wso2.developerstudio.eclipse.capp.core.manifest.CARArtifactFeatureManifest;
import org.wso2.developerstudio.eclipse.capp.core.manifest.SimpleJarManifest;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ArtifactFeatureCreator {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private Artifact artifact;
	private String parentApplication;
	private File location;
	
	public ArtifactFeatureCreator(Artifact artifact,File location, String parentApplication) {
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

	public void setLocation(File location) {
	    this.location = location;
    }

	public File getLocation() {
	    return location;
    }
	
	public File getFeature() throws Exception{
		File tmpFolder;
        try {
	        tmpFolder = FileUtils.createTempDirectory();
	        File pluginsPath = new File(tmpFolder,"plugins");
	        File featuresPath = new File(tmpFolder,"features");
	        File featurePath = new File(featuresPath,artifact.getName() + "_" + artifact.getVersion());
	        File featureMetaInfPath = new File(featurePath,"META-INF");
	        featureMetaInfPath.mkdirs();
	        pluginsPath.mkdirs();
	        File featureManifestFile = new File(featureMetaInfPath,"MANIFEST.MF");
	        new SimpleJarManifest().toFile(featureManifestFile);
	        File featureXmlManifestFile = new File(featurePath,"feature.xml");
	        CARArtifactFeatureManifest carArtifactFeatureManifest = new CARArtifactFeatureManifest(artifact);
	        ICAppArtifactHandler artifactHandler = CAppEnvironment.getcAppManager().getArtifactHandler(artifact);
	        File bundle;
	        if (artifactHandler!=null) {
	            bundle = artifactHandler.getBundle(getLocation(), artifact, getParentApplication());
            }else{
            	bundle = new ArtifactBundleCreator(artifact, location, parentApplication).getBundle();
            }
            FileUtils.copy(bundle, new File(pluginsPath, bundle.getName()));
	        Bundle artifactBundle = new Bundle();
	        artifactBundle.setName(artifact.getName());
	        artifactBundle.setVersion(artifact.getTimestampedVersion());
	        artifactBundle.setUnpack(false);
	        carArtifactFeatureManifest.getBundles().add(artifactBundle);
	        carArtifactFeatureManifest.toFile(featureXmlManifestFile);
			return tmpFolder;
        } catch (Exception e) {
	        log.error(e);
	        throw e;
        }
	}
}
