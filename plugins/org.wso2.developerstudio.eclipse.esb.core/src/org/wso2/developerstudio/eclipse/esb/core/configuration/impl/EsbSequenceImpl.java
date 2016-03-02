package org.wso2.developerstudio.eclipse.esb.core.configuration.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbSequence;

public class EsbSequenceImpl implements IEsbSequence{
	private String name;
	private Object source;
	private ImageDescriptor icon;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSource(Object source) {
		this.source = source;
	}
	public Object getSource() {
		return source;
	}
	public void setIcon(ImageDescriptor icon) {
		this.icon = icon;
	}
	public ImageDescriptor getIcon() {
		return icon;
	}
	public Object[] getChildren(Map<String,List<String>> filters) {
		return null;
	}
	public String getId() {
		return null;
	}
	public boolean hasChildren(Map<String,List<String>> filters) {
		return false;
	}
	public String getText() {
		return getName();
	}
	public String getKey() {
		return getName();
	}
	

}
