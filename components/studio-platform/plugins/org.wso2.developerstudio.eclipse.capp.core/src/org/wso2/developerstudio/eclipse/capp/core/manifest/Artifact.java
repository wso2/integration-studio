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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.ICAppArtifactManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class Artifact extends AbstractXMLDoc implements Observer{
	
	private static final String FILE = "file";
	private static final String SUB_ARTIFACTS = "subArtifacts";
	private static final String INCLUDE = "include";
	private static final String ARTIFACT_XML = "artifact.xml";
	private static final String DEPENDENCY = "dependency";
	private static final String ARTIFACT = "artifact";
	private static final String SERVER_ROLE = "serverRole";
	private static final String TYPE = "type";
	private static final String VERSION = "version";
	private static final String NAME = "name";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

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
	private IFile source;
	private Map<Artifact,ArtifactDependency> allPosibleLocalDependencies;
	private String carTimestamp="";
	private List<OMElement> dependenciesElements;
	private String  timestampedVersion;
	private List<Observer> observers;
	
	public Artifact() {
    }
	
	public Artifact(IFile source) {
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

	public String getFile() {
		return file;
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
    				String dependancyName = getAttribute(element, ARTIFACT);
    				String dependencyVersion = getAttribute(element, VERSION);
    				String includeStr = getAttribute(element, INCLUDE);
    				boolean isInclude=false;
    				if (includeStr != null) {
    					isInclude=Boolean.parseBoolean(includeStr);			
                    }

    				ICAppArtifactManager cAppManager = CAppEnvironment.getcAppManager();
    				Artifact artifact = cAppManager.getArtifact(dependancyName, dependencyVersion, getSource().getProject());
    				ArtifactDependency artifactDependency = new ArtifactDependency(this,artifact);
    				if (artifact==null){
    					artifactDependency.setName(dependancyName);
    					artifactDependency.setVersion(dependencyVersion);
    				}
    				artifactDependency.setInclude(isInclude);
    				if (isInclude || artifact==null){
    	    			artifactDependency.setName(dependancyName);
    	    			artifactDependency.setVersion(dependencyVersion);
    				}else{
    					artifactDependency.addObserver(this);
    				}
    				String serverRole = getAttribute(element, SERVER_ROLE);
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
		if (subArtifacts == null) {
			subArtifacts = new ArrayList<Artifact>();
        }

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
			log.error(e);
			return null;
		}
		return result;
	}

	protected void deserialize(OMElement documentElement) {
		setName(getAttribute(documentElement, NAME));
		setVersion(getAttribute(documentElement, VERSION));
		setType(getAttribute(documentElement, TYPE));
		setServerRole(getAttribute(documentElement, SERVER_ROLE));
		List<OMElement> elements = getChildElements(documentElement, FILE);
		if (elements.size() > 0) {
			setFile(elements.get(0).getText());
		}
		setDependencies(null);
		dependenciesElements = getChildElements(documentElement, DEPENDENCY);
		getSubArtifacts().clear();
		elements = getChildElements(documentElement, SUB_ARTIFACTS);
		if (elements.size() > 0) {
			elements = getChildElements(elements.get(0), ARTIFACT);
			for (OMElement element : elements) {
				Artifact artifact = new Artifact(null);
				artifact.deserialize(element);
				artifact.setParent(this);
				getSubArtifacts().add(artifact);
			}
		}
	}

	public OMElement getDocumentElement() {
		OMElement documentElement = getElement(ARTIFACT, "");
		if (!isAnonymouse()) {
			addAttribute(documentElement, NAME, name);
        }

		if (!isAnonymouse() && version != null) {
			addAttribute(documentElement, VERSION, version);
        }

		if (type != null) {
			addAttribute(documentElement, TYPE, type);
        }

		if (serverRole != null) {
			addAttribute(documentElement, SERVER_ROLE, serverRole);
        }

		if (file != null) {
			documentElement.addChild(getElement(FILE, file));
        }

		for (ArtifactDependency dependency : getDependencies()) {
			OMElement dependecyElement = getElement(DEPENDENCY, "");
			dependecyElement = addAttribute(dependecyElement, ARTIFACT, dependency.getName());
			dependecyElement = addAttribute(dependecyElement, VERSION, dependency.getVersion());
			if (dependency.isInclude()) {
				dependecyElement = addAttribute(dependecyElement, INCLUDE, Boolean.toString(dependency.isInclude()));
			}
			if (dependency.getServerRole()!=null){
				dependecyElement = addAttribute(dependecyElement, SERVER_ROLE, dependency.getServerRole());
			}
			documentElement.addChild(dependecyElement);
		}
		if (getSubArtifacts().size() > 0) {
			OMElement subArtifactElement = getElement(SUB_ARTIFACTS, "");
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
        } catch (XMLStreamException e) {
	        log.error(e);
        } catch (FactoryConfigurationError e) {
	        log.error(e);
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
        } catch (XMLStreamException e) {
	        log.error(e);
        } catch (FactoryConfigurationError e) {
	        log.error(e);
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
	    return ARTIFACT_XML;
    }

	public void setModificationStamp(long modificationStamp) {
	    this.modificationStamp = modificationStamp;
    }

	public long getModificationStamp() {
	    return modificationStamp;
    }
	
	public IFile toFile(IFile file) throws CoreException {
		IFile savedFile = super.toFile(file);
		setModificationStamp(savedFile.getModificationStamp());
	    return savedFile;
	}

    public void update(Observable o, Object arg) {
	    if (o instanceof ArtifactDependency){
	    	try {
	            toFile();
	            ((ArtifactDependency)o).syncOriginalValues();
            } catch (Exception e) {
	            log.error(e);
            }
	    }
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

	public void setSource(IFile source) {
	    this.source = source;
    }

	public IFile getSource() {
	    return source;
    }
	
	public void fromFile(IFile file) throws XMLStreamException, FactoryConfigurationError, CoreException{
		setSource(file);
		if (getSource().getLocation().toFile().exists()){
    		deserialize(getSource().getContents());
    		setModificationStamp(getSource().getModificationStamp());
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
		File savedFile = new File(toFile(getSource()).getLocation().toOSString());
		updated();
	    return savedFile;
	}
	
	public void release(){
		//release observer
	}
	
	public void removeDependencies(){
		List<ArtifactDependency> dependencies = getDependencies();
		for (ArtifactDependency dependency : dependencies) {
	        dependency.release();
        }
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
			ArtifactDependency artifactDependency = new ArtifactDependency(this, artifact);
			artifactDependency.setInclude(false);
			getAllPosibleLocalDependencies().put(artifact,artifactDependency);
		}
		return getAllPosibleLocalDependencies().get(artifact);
	}
	
	public void refresh() throws Exception{
		if (getSource()!=null){
			if (!getSource().isSynchronized(IResource.DEPTH_ONE)){
				if (!lastCheckedRefresh){
    				if (MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "File Changed", "The file '"+getSource().getFullPath().toOSString()+"' has been changed in the file system. Do \nyou want to replace the editor contents with these changes?")){
    					getSource().getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    				}else{
    					lastCheckedRefresh=true;
    				}
				}
			}else{
				lastCheckedRefresh=false;
			}
			if (!lastCheckedRefresh && getSource().getModificationStamp()!=getModificationStamp()){
				fromFile(getSource());
			}
		}
	}
	
	public boolean isDependencyPresent(Artifact artifact){
		return isDependencyPresent(artifact.getName(), artifact.getVersion());
	}
	
	public boolean isDependencyPresent(String name, String version){
		for (ArtifactDependency dependency : getDependencies()) {
	        if (dependency.getName().equals(name) && dependency.getVersion().equals(version)) {
	        	return true;
            }
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

	private boolean lastCheckedRefresh=false;
}
