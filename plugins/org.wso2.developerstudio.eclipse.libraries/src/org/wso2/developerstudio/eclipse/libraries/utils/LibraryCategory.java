package org.wso2.developerstudio.eclipse.libraries.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public class LibraryCategory {
	private String id;
	private String name;
	private String description;
	private String iconFile;
	private Bundle bundle;
	
	private List<LibraryArtifact> libraryArtifacts;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		if (description==null){
			return "Libraries relating to "+getName();
		}
		return description;
	}

	public ImageDescriptor getIcon() {
		if (getIconFile()!=null && bundle!=null){
			return ImageDescriptor.createFromURL(bundle.getResource(getIconFile()));
		}
		return null;
	}

	public List<LibraryArtifact> getLibraryArtifacts() {
		if (libraryArtifacts==null){
			libraryArtifacts=new ArrayList<LibraryArtifact>();
		}
		return libraryArtifacts;
	}
	public void setLibraryBundle(Bundle bundle) {
		this.bundle = bundle;
	}
	public void setIconFile(String iconFile) {
		this.iconFile = iconFile;
	}
	public String getIconFile() {
		return iconFile;
	}

}
