package org.wso2.developerstudio.eclipse.utils.ide;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

public abstract class AbstractResourceVisitor implements IResourceVisitor {
	private List<IResource> resourceList;
	private boolean searchOnFail=true;
	private boolean searchOnSucess=false;

	public boolean visit(IResource resource) throws CoreException {
		if (isValid(resource)) {
			getResourceList().add(resource);
			return isSearchOnSucess();
		}
		return isSearchOnFail();
	}

	protected abstract boolean isValid(IResource resource);

	public List<IResource> getResourceList() {
		if(resourceList == null){
			resourceList = new ArrayList<IResource>();
		}
		return resourceList;
	}

	public void setSearchOnFail(boolean searchOnFail) {
		this.searchOnFail = searchOnFail;
	}

	public boolean isSearchOnFail() {
		return searchOnFail;
	}

	public void setSearchOnSucess(boolean searchOnSucess) {
		this.searchOnSucess = searchOnSucess;
	}

	public boolean isSearchOnSucess() {
		return searchOnSucess;
	}
	
}
