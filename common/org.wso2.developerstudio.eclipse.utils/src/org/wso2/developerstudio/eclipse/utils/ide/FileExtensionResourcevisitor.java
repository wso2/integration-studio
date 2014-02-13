package org.wso2.developerstudio.eclipse.utils.ide;

import org.eclipse.core.resources.IResource;

public class FileExtensionResourcevisitor extends AbstractResourceVisitor {
	private String resourceFileExtension;
	private int resourceType;

	public FileExtensionResourcevisitor(String fileextension, int resourceType){
		setResourceFileExtension(fileextension);
		setResourceType(resourceType);
	}
	
	
	protected boolean isValid(IResource resource) {
		return ((resource.getType() & getResourceType())>0) && resource.getName().toLowerCase().endsWith(getResourceFileExtension());
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}

	public int getResourceType() {
		return resourceType;
	}

	public void setResourceFileExtension(String resourceFileExtension) {
		this.resourceFileExtension = resourceFileExtension;
	}

	public String getResourceFileExtension() {
		return resourceFileExtension;
	}

}
