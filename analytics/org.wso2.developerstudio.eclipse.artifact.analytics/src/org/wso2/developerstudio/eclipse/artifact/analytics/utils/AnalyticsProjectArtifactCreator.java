/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.utils;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.artifact.analytics.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

/**
 * This class represents the artifact.xml file which keeps the metadata of the
 * artifacts included in an Analytics project.
 * Structure of the file is as follows.
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <artifacts>
 * 	<artifact name="testStream" version="1.0.0" type="event/stream"
 * 			serverRole="ComplexEventProcessor"
 * 			groupId="com.example.Analytics.stream">
 * 		<file>src/main/stream/testStream.json</file>
 * 	</artifact>
 * 	<artifact name="testPublisher" version="1.0.0" type="event/publisher"
 * 			serverRole="ComplexEventProcessor"
 * 			groupId="com.example.Analytics.publisher">
 * 		<file>src/main/publisher/testPublisher.xml</file>
 * 	</artifact>
 * </artifacts>
 * 
 * Sep 09, 2015
 * 
 */
public class AnalyticsProjectArtifactCreator extends AbstractXMLDoc implements Observer{
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private File artifactFile;
	List<AnalyticsArtifactModel> analyticsArtifactList=new ArrayList<AnalyticsArtifactModel>();
	
	public void update(Observable o, Object arg) {
		
	}

	protected void deserialize(OMElement documentElement) {
		List<OMElement> artifactElements = getChildElements(documentElement, "artifact");
		for (OMElement omElement : artifactElements) {
	        AnalyticsArtifactModel artifact=new AnalyticsArtifactModel();
	        artifact.setName(getAttribute(omElement, "name"));
	        artifact.setVersion(getAttribute(omElement, "version"));
	        artifact.setType(getAttribute(omElement, "type"));
	        artifact.setServerRole(getAttribute(omElement, "serverRole"));
	        artifact.setGroupId(getAttribute(omElement, "groupId"));
	        artifact.setFile(getChildElements(omElement, "file").size()>0?getChildElements(omElement, "file").get(0).getText():null);
	        
	        analyticsArtifactList.add(artifact);
        }
	}

	protected String serialize() {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		try {
			result = getPretifiedString(documentElement);
		} catch (Exception e) {
			log.error("CoreException has occurred during serialize Artifact Doc", e);
			return null;
		}
		return result;
	}

	protected String getDefaultName() {
		return null;
	}
	
	public void addAnalyticsArtifact(AnalyticsArtifactModel artifact){
		analyticsArtifactList.add(artifact);
	}
	
	public boolean removeAnalyticsArtifact(AnalyticsArtifactModel artifact){
		return analyticsArtifactList.remove(artifact);
	}
	
	public List<AnalyticsArtifactModel> getAllAnalyticsArtifacts(){
		return Collections.unmodifiableList(analyticsArtifactList);
	}
	
	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifacts", "");
		
		for (AnalyticsArtifactModel analyticsArtifact : analyticsArtifactList) {
			OMElement artifactElement = getElement("artifact", "");
			
			if (!analyticsArtifact.isAnonymous()){
				addAttribute(artifactElement, "name", analyticsArtifact.getName());
			}
			
			if (!analyticsArtifact.isAnonymous() && analyticsArtifact.getGroupId() != null){
				addAttribute(artifactElement, "groupId", analyticsArtifact.getGroupId());
			}
	        
			if (!analyticsArtifact.isAnonymous() && analyticsArtifact.getVersion() != null){
				addAttribute(artifactElement, "version", analyticsArtifact.getVersion());
			}
			
			if (analyticsArtifact.getType() != null){
				addAttribute(artifactElement, "type", analyticsArtifact.getType());
			}
			
			if (analyticsArtifact.getServerRole() != null){
				addAttribute(artifactElement, "serverRole", analyticsArtifact.getServerRole());
			}
			
			if (analyticsArtifact.getFile() != null){
				artifactElement.addChild(getElement("file", analyticsArtifact.getFile()));
			}
			
			documentElement.addChild(artifactElement);
        }
		
		return documentElement;
	}

	public void setArtifactFile(File artifactFile) {
	    this.artifactFile = artifactFile;
    }

	public File getArtifactFile() {
	    return artifactFile;
    }
	
	public File toFile() throws Exception {
		File savedFile = new File(toFile(getArtifactFile()).toString());
	    return savedFile;
	}

	public void fromFile(File artifactFile) throws FactoryConfigurationError, Exception{
		setArtifactFile(artifactFile);
		if (getArtifactFile().exists()){
    		deserialize(getArtifactFile());
		}
	}

}
