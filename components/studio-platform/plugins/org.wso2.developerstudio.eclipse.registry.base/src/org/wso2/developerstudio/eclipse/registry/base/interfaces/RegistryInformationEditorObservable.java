package org.wso2.developerstudio.eclipse.registry.base.interfaces;

import java.util.Observable;

import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;

public class RegistryInformationEditorObservable extends Observable{
	RegistryResourceNode regResourceNode;
	public static final int EVENT_NONE=0;
	public static final int EVENT_SAVED=1;
	public static final int EVENT_EDITOR_ACITVATED=2;
	
	private int lastEvent=EVENT_NONE;
	
	public RegistryResourceNode getRegResourceNode() {
		return regResourceNode;
	}

	public void setRegResourceNode(RegistryResourceNode regResourceNode) {
		this.regResourceNode = regResourceNode;
		setChanged();
		notifyObservers();
	}

	public void setLastEvent(int lastEvent) {
		this.lastEvent = lastEvent;
	}

	public int getLastEvent() {
		return lastEvent;
	}

	public void triggerObservers() {
		setChanged();
		notifyObservers();
	}

	
}
