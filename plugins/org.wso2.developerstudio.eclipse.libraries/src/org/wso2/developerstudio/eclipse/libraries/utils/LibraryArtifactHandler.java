package org.wso2.developerstudio.eclipse.libraries.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class LibraryArtifactHandler {
	private static final String LIBRARY_ARTIFACT_EXTENSION="org.wso2.developerstudio.libraries.libraryprovider";
	private static Map<String,LibraryCategory> categoryList;
	public static final String ALL_LIB_CATEGORY_ID = "org.wso2.developerstudio.eclipse.libraries.alllibs";
	
	private static void addDefaultAllList(Map<String,LibraryCategory> categoryList){
		LibraryCategory libraryCategory = new LibraryCategory();
		libraryCategory.setId(ALL_LIB_CATEGORY_ID);
		libraryCategory.setName("All");
		libraryCategory.setDescription("All the libraries offered");
		categoryList.put(libraryCategory.getId(),libraryCategory);
	}
	
	private static void loadLibraryArtifactInfo(){
		categoryList=new HashMap<String, LibraryCategory>();
		addDefaultAllList(categoryList);
		ArrayList<LibraryArtifact> libraryList = new ArrayList<LibraryArtifact>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(LIBRARY_ARTIFACT_EXTENSION);
		for (IConfigurationElement e : config) {		
			try {
				if (e.getName().equalsIgnoreCase("category")){
					LibraryCategory libraryCategory = new LibraryCategory();
					libraryCategory.setId(e.getAttribute("id"));
					libraryCategory.setName(e.getAttribute("name"));
					Bundle bundle = Platform.getBundle(e.getContributor().getName());
					libraryCategory.setLibraryBundle(bundle);
					libraryCategory.setIconFile(e.getAttribute("icon"));
					IConfigurationElement[] children = e.getChildren("description");
					if (children!=null && children.length>0){
						libraryCategory.setDescription(children[0].getValue());
					}
					categoryList.put(libraryCategory.getId(),libraryCategory);
					
				}else if (e.getName().equalsIgnoreCase("library")){
					LibraryArtifact libraryArtifact = new LibraryArtifact();
					libraryArtifact.setName(e.getAttribute("name"));
					String catgories = e.getAttribute("categoryId");
					if (catgories!=null){
						String[] categoryList = catgories.split(",");
						libraryArtifact.addCategories(categoryList);
					}
					String fileName = e.getAttribute("jar");
					Bundle bundle = Platform.getBundle(e.getContributor().getName());
					libraryArtifact.setLibraryFileName(fileName);
					libraryArtifact.setLibraryBundle(bundle);
					IConfigurationElement[] children = e.getChildren("description");
					if (children!=null && children.length>0){
						libraryArtifact.setDescription(children[0].getValue());
					}
					libraryList.add(libraryArtifact);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		for (LibraryArtifact libraryArtifact : libraryList) {
			categoryList.get(ALL_LIB_CATEGORY_ID).getLibraryArtifacts().add(libraryArtifact);
			List<String> categories = libraryArtifact.getCategories();
			for (String categoryId : categories) {
				if (categoryList.containsKey(categoryId)){
					categoryList.get(categoryId).getLibraryArtifacts().add(libraryArtifact);
				}
			}
		}
	}

	static {
		loadLibraryArtifactInfo();
	}
	
	public static Map<String,LibraryCategory> getLibraryArtifactCategories(){
		return categoryList;
	}

}
