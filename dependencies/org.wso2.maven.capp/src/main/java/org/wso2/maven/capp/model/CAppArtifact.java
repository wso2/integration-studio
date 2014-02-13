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

package org.wso2.maven.capp.model;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.CAppUtils;
import org.wso2.maven.core.model.AbstractXMLDoc;

import sun.security.action.GetLongAction;

public class CAppArtifact extends AbstractXMLDoc{

	private MavenProject project;
	private String serverRole;
	
	/**
	 * Artifact content file.
	 */
	List<CAppArtifactDependency> dependencies;
	private List<CAppArtifactDependency> dummyDependencies=new ArrayList<CAppArtifactDependency>();
	private List<String> ignoreDependencies=new ArrayList<String>();
	
	List<CAppArtifact> subArtifacts;
	private long modificationStamp;
	/**
	 * Artifact descriptor file (artifact.xml file).
	 */
	private String carTimestamp = "";
	private String timestampedVersion;
	private String file;
	private boolean root;
	private String type;
	
	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public CAppArtifact(MavenProject project, String serverRole) {
		setProject(project);
		setServerRole(serverRole);
	}

	public String getId(){
		return getProject().getGroupId()+":"+getProject().getArtifactId()+":"+getProject().getVersion();
	}
	
	public String getName() {
		return getProject().getArtifactId();
	}

	public String getVersion() {
		return getProject().getVersion();
	}

	public List<CAppArtifactDependency> getDependencies() throws MojoExecutionException {
		List<CAppArtifactDependency> dependencies = new ArrayList<CAppArtifactDependency>();
		Properties properties = getProject().getProperties();
		for (Object object: getProject().getDependencies()) {
			Dependency dependency=(Dependency)object;
			String property = properties.getProperty(dependency.getGroupId()+"_._"+dependency.getArtifactId());
			if (property !=null && property.toLowerCase().startsWith(CAppMavenUtils.CAPP_SCOPE_PREFIX)){
				String[] scopeElements = property.split("/");
				String dependencyServerRole;
				if (scopeElements.length>1){
					dependencyServerRole=scopeElements[1];
				}else{
					dependencyServerRole=getServerRole();
				}
				CAppArtifactDependency artifactDependency = new CAppArtifactDependency(dependency,dependencyServerRole);
				if (!ignoreDependencies.contains(artifactDependency.getName()+":"+artifactDependency.getVersion())){
					dependencies.add(artifactDependency);
				}
			}
		}
		for (CAppArtifactDependency cAppArtifactDependency : getDummyDependencies()) {
			if (!ignoreDependencies.contains(cAppArtifactDependency.getName()+":"+cAppArtifactDependency.getVersion())){
				dependencies.add(cAppArtifactDependency);
			}
		}
		return dependencies;
	}
	
	public void addIgnoreDependency(CAppArtifactDependency cAppArtifactDependency){
		ignoreDependencies.add(cAppArtifactDependency.getName()+":"+cAppArtifactDependency.getVersion());
	}
	
	public String getType() {
		if (type==null){
			String packagingType = getProject().getPackaging();
			Properties properties = getProject().getProperties();
			if (properties.containsKey(CAppUtils.PROPERTY_CAPP_TYPE)){
					type=properties.get(CAppUtils.PROPERTY_CAPP_TYPE).toString();
			}else{
				type=packagingType;
			}
		}
		
		return type;
	}


	private Map<String,CAppArtifactDependency> getDependencyMap() throws MojoExecutionException{
		Map<String,CAppArtifactDependency> dependencyMap=new HashMap<String, CAppArtifactDependency>();
		List<CAppArtifactDependency> dependencies = getDependencies();
		for (CAppArtifactDependency dependency : dependencies) {
			dependencyMap.put(dependency.getDependencyId(), dependency);
		}
		return dependencyMap;
	}
	
	public void addDependencies(CAppArtifactDependency dependency) throws MojoExecutionException {
		if (dependency.isDummyDependency()){
			getDummyDependencies().add(dependency);
		}else{
			Map<String, CAppArtifactDependency> dependencyMap = getDependencyMap();
			String dependencyId=dependency.getDependencyId();
			if (!dependencyMap.containsKey(dependencyId)){
				project.getModel().addDependency(dependency.getMavenDependency());
			}
		}
	}

	public String getCaption() {
		return getName() + " - " + getVersion() + "";
	}

	public String getDefaultName() {
		return "artifact.xml";
	}

	public boolean isDependencyPresent(CAppArtifact artifact) throws MojoExecutionException {
		return isDependencyPresent(artifact.getName(), artifact.getVersion());
	}

	public boolean isDependencyPresent(String name, String version) throws MojoExecutionException {
		for (CAppArtifactDependency dependency : getDependencies()) {
			if (dependency.getName().equals(name)
					&& dependency.getVersion().equals(version))
				return true;
		}
		return false;
	}

	public String getTimestampedVersion() {
		if (carTimestamp == null) {
			timestampedVersion = getVersion();
		} else {
			timestampedVersion = getVersion() + ".v" + carTimestamp;
		}
		return timestampedVersion;
	}

	public void setCarTimestamp(String carTimestamp) {
		this.carTimestamp = carTimestamp;
	}

	public String getCarTimestamp() {
		return carTimestamp;
	}

	public void setModificationStamp(long modificationStamp) {
		this.modificationStamp = modificationStamp;
	}

	public long getModificationStamp() {
		return modificationStamp;
	}

	public void setProject(MavenProject project) {
		type=null;
		this.project = project;
	}

	public MavenProject getProject() {
		return project;
	}

	public void setServerRole(String serverRole) {
		this.serverRole = serverRole;
	}

	public String getServerRole() {
		return serverRole;
	}

	public String serialize() throws Exception {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			prettify(documentElement, outputStream);
		} catch (Exception e) {
			throw new MojoExecutionException("Error serializing",e);
        }
		result = outputStream.toString();
		return result;
	}

	protected void deserialize(OMElement documentElement) {
		//Nothing to do
	}

	public OMElement getDocumentElement() throws MojoExecutionException {
        OMElement documentElement = null;
        OMElement artifactElement = getElement("artifact", "");
        if(isRoot()){
            documentElement = getElement("artifacts", "");
            documentElement.addChild(artifactElement);
        }else{
        	documentElement=artifactElement;
        }
		addAttribute(artifactElement, "name", getName());
		addAttribute(artifactElement, "version", getVersion());
		addAttribute(artifactElement, "type", getType());
		if (serverRole != null)
			addAttribute(artifactElement, "serverRole", getServerRole());
		if (getFile() != null)
			artifactElement.addChild(getElement("file", getFile()));
		List<CAppArtifactDependency> artifactDependencies = getDependencies();
		
		/*
		 * Sort artifacts in order to arrange them based on their priorities.
		 * Fixing TOOLS-2335, TOOLS-2197
		 */
		Collections.sort(artifactDependencies);
		
		for (CAppArtifactDependency dependency : artifactDependencies) {
			OMElement dependecyElement = getElement("dependency", "");
			dependecyElement = addAttribute(dependecyElement, "artifact", dependency.getName());
			dependecyElement = addAttribute(dependecyElement, "version", dependency.getVersion());
			dependecyElement = addAttribute(dependecyElement, "include", Boolean.toString(true));
			if (dependency.getServerRole()!=null){
				dependecyElement = addAttribute(dependecyElement, "serverRole", dependency.getServerRole());
			}
			artifactElement.addChild(dependecyElement);
		}
		return documentElement;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setDummyDependencies(List<CAppArtifactDependency> dummyDependencies) {
		this.dummyDependencies = dummyDependencies;
	}

	public List<CAppArtifactDependency> getDummyDependencies() {
		return dummyDependencies;
	}

}
