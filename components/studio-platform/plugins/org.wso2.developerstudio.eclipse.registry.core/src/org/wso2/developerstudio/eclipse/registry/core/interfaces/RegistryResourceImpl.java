package org.wso2.developerstudio.eclipse.registry.core.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class RegistryResourceImpl implements IRegistryResource {
	private String path;
	private Object source;
	private String name;
	private IRegistryCollection parent;
	
	private List<String> mediaTypes=new ArrayList<String>();
	
	public RegistryResourceImpl(IRegistryCollection parent) {
		setParent(parent);
	}
	
	public String[] getMediaTypes() {
		return mediaTypes.toArray(new String[]{});
	}

	public String getPath() {
		return path;
	}

	public Object getSource() {
		return source;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setPath(String parentPath, String child) {
		setPath(parentPath.trim().endsWith("/")?parentPath+child:parentPath+"/"+child);
	}
	
	public void setSource(Object source) {
		this.source = source;
	}

	public void addMediaType(String... mediaTypes){
		this.mediaTypes.addAll(Arrays.asList(mediaTypes));
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParent(IRegistryCollection parent) {
		this.parent = parent;
	}

	public IRegistryCollection getParent() {
		return parent;
	}
}
