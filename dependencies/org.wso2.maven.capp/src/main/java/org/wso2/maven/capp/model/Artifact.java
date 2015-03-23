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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.maven.core.model.AbstractXMLDoc;

public class Artifact extends AbstractXMLDoc implements Observer{

	String name;
	String version;
	String serverRole;
	String type;	
	/**
	 * Artifact content file.
	 */
	String file;	
	private Artifact parent;
	private boolean anonymouse = false;
	List<ArtifactDependency> dependencies;
	List<Artifact> subArtifacts;
	private long modificationStamp;
	private boolean superArtifact=false;
	/**
	 * Artifact descriptor file (artifact.xml file).
	 */
	private File source;
	private Map<Artifact,ArtifactDependency> allPosibleLocalDependencies;
	private String carTimestamp="";
	private List<OMElement> dependenciesElements;
	private String  timestampedVersion;
	private List<Observer> observers;

	public Artifact() {
	}
	
	public Artifact(File source) {
		setSource(source);
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getServerRole() {
		return serverRole;
	}

	public void setServerRole(String serverRole) {
		this.serverRole = serverRole;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getFile() {
		return new File(getSource().getParentFile(),file);
	}

	public void setFile(String file) {
		this.file = file;
	}

	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		getObservers().add(o);
	}
	
	public synchronized void deleteObserver(Observer o) {
		super.deleteObserver(o);
		getObservers().remove(o);
	}
	
	public synchronized void deleteObservers() {
		super.deleteObservers();
		getObservers().clear();
	}
	
	
	public List<ArtifactDependency> getDependencies() {
		if (dependencies == null){
			dependencies = new ArrayList<ArtifactDependency>();
			if (dependenciesElements!=null){
    			for (OMElement element : dependenciesElements) {
    				String dependancyName = getAttribute(element, "artifact");
    				String dependencyVersion = getAttribute(element, "version");
    				String includeStr = getAttribute(element, "include");
    				boolean isInclude=false;
    				if (includeStr != null)
    					isInclude=Boolean.parseBoolean(includeStr);			
    				ArtifactDependency artifactDependency = new ArtifactDependency(this);
					artifactDependency.setName(dependancyName);
					artifactDependency.setVersion(dependencyVersion);
    				artifactDependency.setInclude(isInclude);
    				String serverRole = getAttribute(element, "serverRole");
    				if (serverRole != null && !serverRole.equals("")){
    					artifactDependency.setServerRole(serverRole);
    				}
    				getDependencies().add(artifactDependency);
    			}
			}
		}
		return dependencies;
	}

	public void setDependencies(List<ArtifactDependency> dependencies) {
		this.dependencies = dependencies;
	}

	public List<Artifact> getSubArtifacts() {
		if (subArtifacts == null)
			subArtifacts = new ArrayList<Artifact>();
		return subArtifacts;
	}

	public void setSubArtifacts(List<Artifact> subArtifacts) {
		this.subArtifacts = subArtifacts;
	}

	public String serialize() {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		try {
			result = getPretifiedString(documentElement);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	protected void deserialize(OMElement documentElement) {
		setName(getAttribute(documentElement, "name"));
		setVersion(getAttribute(documentElement, "version"));
		setType(getAttribute(documentElement, "type"));
		setServerRole(getAttribute(documentElement, "serverRole"));
		List<OMElement> elements = getChildElements(documentElement, "file");
		if (elements.size() > 0) {
			setFile(elements.get(0).getText());
		}
		setDependencies(null);
		dependenciesElements = getChildElements(documentElement, "dependency");
		getSubArtifacts().clear();
		elements = getChildElements(documentElement, "subArtifacts");
		if (elements.size() > 0) {
			elements = getChildElements(elements.get(0), "artifact");
			for (OMElement element : elements) {
				Artifact artifact = new Artifact(null);
				artifact.deserialize(element);
				artifact.setParent(this);
				getSubArtifacts().add(artifact);
			}
		}
	}

	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifact", "");
		if (!isAnonymouse())
			addAttribute(documentElement, "name", name);
		if (!isAnonymouse() && version != null)
			addAttribute(documentElement, "version", version);
		if (type != null)
			addAttribute(documentElement, "type", type);
		if (serverRole != null)
			addAttribute(documentElement, "serverRole", serverRole);
		if (file != null)
			documentElement.addChild(getElement("file", file));
		for (ArtifactDependency dependency : getDependencies()) {
			OMElement dependecyElement = getElement("dependency", "");
			dependecyElement = addAttribute(dependecyElement, "artifact", dependency.getName());
			dependecyElement = addAttribute(dependecyElement, "version", dependency.getVersion());
			if (dependency.isInclude()) {
				dependecyElement = addAttribute(dependecyElement, "include", Boolean.toString(dependency.isInclude()));
			}
			if (dependency.getServerRole()!=null){
				dependecyElement = addAttribute(dependecyElement, "serverRole", dependency.getServerRole());
			}
			documentElement.addChild(dependecyElement);
		}
		if (getSubArtifacts().size() > 0) {
			OMElement subArtifactElement = getElement("subArtifacts", "");
			for (Artifact subArtifact : getSubArtifacts()) {
				subArtifactElement.addChild(subArtifact.getDocumentElement());
			}
			documentElement.addChild(subArtifactElement);
		}
		return documentElement;
	}

	public void setAnonymouse(boolean anonymouse) {
		this.anonymouse = anonymouse;
	}

	public boolean isAnonymouse() {
		return (name == null) || anonymouse;
	}

	public Artifact clone() {
		Artifact artifact = new Artifact(getSource());
		return clone(artifact);
	}
	
	public Artifact clone(Artifact artifact) {
		try {
	        artifact.deserialize(this.serialize());
	        artifact.setDependencies(getDependencies());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        artifact.setModificationStamp(getModificationStamp());
	    return artifact;
	}

	public Artifact cloneData() {
		Artifact artifact = new Artifact(getSource());
		return cloneData(artifact);
	}
	
	public Artifact cloneData(Artifact artifact) {
		try {
	        artifact.deserialize(this.serialize());
	        artifact.setSuperArtifact(isSuperArtifact());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        artifact.setModificationStamp(getModificationStamp());
	    return artifact;
	}
	
	public void setParent(Artifact parent) {
	    this.parent = parent;
    }

	public Artifact getParent() {
	    return parent;
    }

	public String getCaption() {
	    return getName()+" - "+getVersion()+"";
	}

    public String getDefaultName() {
	    return "artifact.xml";
    }

	public void setModificationStamp(long modificationStamp) {
	    this.modificationStamp = modificationStamp;
    }

	public long getModificationStamp() {
	    return modificationStamp;
    }

    public void update(Observable o, Object arg) {
	    
    }

	public void setSuperArtifact(boolean superArtifact) {
	    this.superArtifact = superArtifact;
    }

	public boolean isSuperArtifact() {
	    return superArtifact;
    }
	
	public boolean isEqual(String name, String version, String serverRole){
		return isEqual(name, version) && getServerRole().equals(serverRole);
	}
	
	public boolean isEqual(String name, String version){
		return getName().equals(name) && getVersion().equals(version);
	}

	public void setSource(File source) {
	    this.source = source;
    }

	public File getSource() {
	    return source;
    }
	
	public void fromFile(File file) throws FactoryConfigurationError, Exception{
		setSource(file);
		if (getSource().exists()){
    		deserialize(getSource());
    		setModificationStamp(getSource().lastModified());
		}
	}
	
	private void updated(){
		setChanged();
		notifyObservers();
	}
	
	public void notifySourceModification(){
		updated();
	}
	
	public File toFile() throws Exception {
		File savedFile = new File(toFile(getSource()).toString());
		updated();
	    return savedFile;
	}
	
	public void release(){
		//release observer
	}
	
	public void removeDependencies(){
		getDependencies().clear();
	}

	public void setAllPosibleLocalDependencies(Map<Artifact,ArtifactDependency> allPosibleLocalDependencies) {
	    this.allPosibleLocalDependencies = allPosibleLocalDependencies;
    }

	public Map<Artifact,ArtifactDependency> getAllPosibleLocalDependencies() {
		if (allPosibleLocalDependencies==null){
			allPosibleLocalDependencies=new HashMap<Artifact, ArtifactDependency>();
		}
	    return allPosibleLocalDependencies;
    }
	
	public ArtifactDependency getDependencyForArtifact(Artifact artifact){
		if (!getAllPosibleLocalDependencies().containsKey(artifact)){
			ArtifactDependency artifactDependency = new ArtifactDependency(this);
			artifactDependency.setInclude(false);
			getAllPosibleLocalDependencies().put(artifact,artifactDependency);
		}
		return getAllPosibleLocalDependencies().get(artifact);
	}
	
	public boolean isDependencyPresent(Artifact artifact){
		return isDependencyPresent(artifact.getName(), artifact.getVersion());
	}
	
	public boolean isDependencyPresent(String name, String version){
		for (ArtifactDependency dependency : getDependencies()) {
	        if (dependency.getName().equals(name) && dependency.getVersion().equals(version))
	        	return true;
        }
		return false;
	}

	public String getTimestampedVersion() {
		if (carTimestamp==null){
			timestampedVersion=getVersion();
		}else{
			timestampedVersion=getVersion()+".v"+carTimestamp;
		}
	    return timestampedVersion;
    }

	public void setCarTimestamp(String carTimestamp) {
	    this.carTimestamp = carTimestamp;
    }

	public String getCarTimestamp() {
	    return carTimestamp;
    }

	public List<Observer> getObservers() {
		if (observers==null){
			observers=new ArrayList<Observer>();
		}
		return observers;
	}

}
