package org.wso2.developerstudio.eclipse.esb.core;

import java.util.Observable;
import java.util.Observer;


public class ESBArtifactDependency extends Observable implements Observer{
	private String name;
	private String version;
	private String serverRole;
	
	private String originalName;
	private String originalVersion;
	private String originalServerRole;
	
	private ESBArtifact parentArtifact;
	private ESBArtifact connectingArtifact;
	private long lastModificationStamp;
	
	boolean include=false;
	
	public ESBArtifactDependency(ESBArtifact parentArtifact, ESBArtifact connectingArtifact) {
		setConnectingArtifact(connectingArtifact);
		setParentArtifact(parentArtifact);
    }
	
	public String getName() {
		if (getConnectingArtifact()==null){
			return name;
		}else{
			return getConnectingArtifact().getName();
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		if (getConnectingArtifact()==null){
			return version;
		}else{
			return getConnectingArtifact().getVersion();
		}
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isInclude() {
		return include;
	}
	public void setInclude(boolean include) {
		this.include = include;
	}

	public String toString() {
	    return getCaption();
	}
	
	public void setServerRole(String serverRole) {
	    this.serverRole = serverRole;
    }
	
	public String getServerRole() {
		if(getParentArtifact()!= null){
			if (!getParentArtifact().isSuperArtifact()){
				return null;
			}
		}
		if (getConnectingArtifact()==null){
			return serverRole;
		}else{
			return getConnectingArtifact().getServerRole();
		}
    }

	public void update(Observable o, Object arg) {
		boolean hasChanged=getParentArtifact().isSuperArtifact() ? hasOriginalsChanged():hasEssentialOriginalsChanged();
		if (hasChanged){
			updated();
		}
    }

	private void updated(){
		setChanged();
		notifyObservers();
	}
	
	public void setConnectingArtifact(ESBArtifact connectingArtifact) {
		if (this.connectingArtifact!=null){
			this.connectingArtifact.deleteObserver(this);
		}
	    this.connectingArtifact = connectingArtifact;
	    if (connectingArtifact!=null){
	    	this.connectingArtifact.addObserver(this);
	    }
	    syncOriginalValues();
    }
	
	public void syncOriginalValues(){
		if (connectingArtifact!=null){
			originalName=getConnectingArtifact().getName();
			originalVersion=getConnectingArtifact().getVersion();
			originalServerRole=getConnectingArtifact().getServerRole();
			lastModificationStamp=getConnectingArtifact().getModificationStamp();
		}
	}
	
	private boolean hasEssentialOriginalsChanged(){
		return originalName.equals(getConnectingArtifact().getName())||
			originalVersion.equals(getConnectingArtifact().getVersion()) ||
			originalServerRole.equals(getConnectingArtifact().getServerRole());
	}

	private boolean hasOriginalsChanged(){
		return hasEssentialOriginalsChanged() ||
			lastModificationStamp!=getConnectingArtifact().getModificationStamp();
	}

	
	public ESBArtifact getConnectingArtifact() {
	    return connectingArtifact;
    }
	
	public void setParentArtifact(ESBArtifact parentArtifact) {
	    this.parentArtifact = parentArtifact;
    }
	
	public ESBArtifact getParentArtifact() {
	    return parentArtifact;
    }
	
	public boolean isDisconnected(){
		return getConnectingArtifact()==null;
	}
	
	public void release(){
		if (getConnectingArtifact()!=null){
			getConnectingArtifact().deleteObserver(this);
		}
	}
	
	public String getCaption(){
		return getName()+" - "+getVersion();
	}
}