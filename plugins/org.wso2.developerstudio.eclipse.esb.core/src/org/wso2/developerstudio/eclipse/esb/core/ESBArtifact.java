package org.wso2.developerstudio.eclipse.esb.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class ESBArtifact extends AbstractXMLDoc implements Observer{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	String name;
	String version;
	String serverRole;
	String type;	
	/**
	 * Artifact content file.
	 */
	String file;	
	private ESBArtifact parent;
	private boolean anonymouse = false;
	List<ESBArtifactDependency> dependencies;
	List<ESBArtifact> subArtifacts;
	private long modificationStamp;
	private boolean superArtifact=false;
	/**
	 * Artifact descriptor file (artifact.xml file).
	 */
	private IFile source;
	private Map<ESBArtifact, ESBArtifactDependency> allPosibleLocalDependencies;
	private String carTimestamp="";
	private List<OMElement> dependenciesElements;
	private String  timestampedVersion;
	private List<Observer> observers;
	
	public ESBArtifact() {
    }
	
	public ESBArtifact(IFile source) {
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
	
	/*
	public List<CappArtifactDependency> getDependencies() {
		if (dependencies == null){
			dependencies = new ArrayList<CappArtifactDependency>();
			if (dependenciesElements!=null){
    			for (OMElement element : dependenciesElements) {
    				String dependancyName = getAttribute(element, "artifact");
    				String dependencyVersion = getAttribute(element, "version");
    				String includeStr = getAttribute(element, "include");
    				boolean isInclude=false;
    				if (includeStr != null) {
    					isInclude=Boolean.parseBoolean(includeStr);			
                    }

    				ICAppArtifactManager cAppManager = CAppEnvironment.getcAppManager();
    				CappArtifact artifact = cAppManager.getArtifact(dependancyName, dependencyVersion, getSource().getProject());
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
	*/

	public void setDependencies(List<ESBArtifactDependency> dependencies) {
		this.dependencies = dependencies;
	}

	public List<ESBArtifact> getSubArtifacts() {
		if (subArtifacts == null) {
			subArtifacts = new ArrayList<ESBArtifact>();
        }

		return subArtifacts;
	}

	public void setSubArtifacts(List<ESBArtifact> subArtifacts) {
		this.subArtifacts = subArtifacts;
	}

	/*
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
	*/

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
				ESBArtifact artifact = new ESBArtifact(null);
				artifact.deserialize(element);
				artifact.setParent(this);
				getSubArtifacts().add(artifact);
			}
		}
	}

	/*
	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifact", "");
		if (!isAnonymouse()) {
			addAttribute(documentElement, "name", name);
        }

		if (!isAnonymouse() && version != null) {
			addAttribute(documentElement, "version", version);
        }

		if (type != null) {
			addAttribute(documentElement, "type", type);
        }

		if (serverRole != null) {
			addAttribute(documentElement, "serverRole", serverRole);
        }

		if (file != null) {
			documentElement.addChild(getElement("file", file));
        }

		for (CappArtifactDependency dependency : getDependencies()) {
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
			for (CappArtifact subArtifact : getSubArtifacts()) {
				subArtifactElement.addChild(subArtifact.getDocumentElement());
			}
			documentElement.addChild(subArtifactElement);
		}
		return documentElement;
	}
	*/

	public void setAnonymouse(boolean anonymouse) {
		this.anonymouse = anonymouse;
	}

	public boolean isAnonymouse() {
		return (name == null) || anonymouse;
	}

	/*
	public CappArtifact clone() {
		CappArtifact artifact = new CappArtifact(getSource());
		return clone(artifact);
	}
	
	
	public CappArtifact clone(CappArtifact artifact) {
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
	*/

	public ESBArtifact cloneData() {
		ESBArtifact artifact = new ESBArtifact(getSource());
		return cloneData(artifact);
	}
	
	public ESBArtifact cloneData(ESBArtifact artifact)  {
		try {
	        artifact.deserialize(this.serialize());
	        artifact.setSuperArtifact(isSuperArtifact());
        } catch (XMLStreamException e) {
	        log.error(e);
        } catch (FactoryConfigurationError e) {
	        log.error(e);
        } catch (Exception e) {
        	log.error(e);
        }
        artifact.setModificationStamp(getModificationStamp());
	    return artifact;
	}
	
	public void setParent(ESBArtifact parent) {
	    this.parent = parent;
    }

	public ESBArtifact getParent() {
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
	
	public IFile toFile(IFile file) throws CoreException {
		IFile savedFile = super.toFile(file);
		setModificationStamp(savedFile.getModificationStamp());
	    return savedFile;
	}

    public void update(Observable o, Object arg) {
	    if (o instanceof ESBArtifactDependency){
	    	try {
	            toFile();
	            ((ESBArtifactDependency)o).syncOriginalValues();
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
    		try {
				deserialize(getSource().getContents());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	/*
	public void removeDependencies(){
		List<CappArtifactDependency> dependencies = getDependencies();
		for (CappArtifactDependency dependency : dependencies) {
	        dependency.release();
        }
		getDependencies().clear();
	}
	*/

	public void setAllPosibleLocalDependencies(Map<ESBArtifact, ESBArtifactDependency> allPosibleLocalDependencies) {
	    this.allPosibleLocalDependencies = allPosibleLocalDependencies;
    }

	public Map<ESBArtifact, ESBArtifactDependency> getAllPosibleLocalDependencies() {
		if (allPosibleLocalDependencies==null){
			allPosibleLocalDependencies=new HashMap<ESBArtifact, ESBArtifactDependency>();
		}
	    return allPosibleLocalDependencies;
    }
	
	public ESBArtifactDependency getDependencyForArtifact(ESBArtifact artifact){
		if (!getAllPosibleLocalDependencies().containsKey(artifact)){
			ESBArtifactDependency artifactDependency = new ESBArtifactDependency(this, artifact);
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
	
	/*
	public boolean isDependencyPresent(CappArtifact artifact){
		return isDependencyPresent(artifact.getName(), artifact.getVersion());
	}
	
	
	public boolean isDependencyPresent(String name, String version){
		for (CappArtifactDependency dependency : getDependencies()) {
	        if (dependency.getName().equals(name) && dependency.getVersion().equals(version)) {
	        	return true;
            }
        }
		return false;
	}
	*/

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

	@Override
	protected String serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}