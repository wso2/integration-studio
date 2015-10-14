package org.wso2.developerstudio.eclipse.utils.ide;

import org.eclipse.core.resources.IResource;

public class FileNameResourceVisitor extends AbstractResourceVisitor{
	private String resourceFileName;
	private int resourceType;

	public FileNameResourceVisitor(String filename, int resourceType){
		setResourceFileName(filename);
		setResourceType(resourceType);
	}
	
	protected boolean isValid(IResource resource) {
		return ((resource.getType() & getResourceType())>0) && resource.getName().equalsIgnoreCase(getResourceFileName());
	}

	public void setResourceFileName(String resourceFileName) {
		this.resourceFileName = resourceFileName;
	}

	public String getResourceFileName() {
		return resourceFileName;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}

	public int getResourceType() {
		return resourceType;
	}

	
}
