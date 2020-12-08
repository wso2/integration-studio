package org.wso2.developerstudio.eclipse.libraries.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;

public class LibraryArtifact {

	private String name;
	private String id;
	private String libraryFileName;
	private Bundle libraryBundle;
	private String description;
	private List<String> categories;
	
	public String getName() {
		if (name==null || name.trim().equals("")){
			return getFileName();
		}
		return name;
	}
	
	public String getFileName(){
		String[] libraryPath = libraryFileName.split("/");
		return libraryPath[libraryPath.length - 1];
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLibraryBundle(Bundle libraryBundle) {
		this.libraryBundle = libraryBundle;
	}
	public Bundle getLibraryBundle() {
		return libraryBundle;
	}
	public void setLibraryFileName(String libraryFileName) {
		this.libraryFileName = libraryFileName;
	}
	public String getLibraryFileName() {
		return libraryFileName;
	}
	
	public InputStream getLibraryDataStream() throws IOException{
		URL resource = getLibraryUrl();
		return resource.openStream();
	}
	public URL getLibraryUrl() {
		return getLibraryBundle().getResource(getLibraryFileName());
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		if (description==null){
			return "";
		}
		return description;
	}
	public List<String> getCategories() {
		if (categories==null){
			categories=new ArrayList<String>();
		}
		return categories;
	}
	
	public void addCategories(String...categories){
		for (String category : categories) {
			if (!getCategories().contains(category)){
				getCategories().add(category);
			}			
		}
	}
}
