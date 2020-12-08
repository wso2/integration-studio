/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.registry.provider;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryDump;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class NavigatorNode {
	
	public String getPath() {
    	return path;
    }
	
	public void setPath(String path) {
    	this.path = path;
    }
	
	public Image getGetImage() {
		RegistryElement item = getData();
		if (null != item) {
			if (item instanceof RegistryItem) {
				String filename = ((RegistryItem) item).getFile();
				if (filename.lastIndexOf(".") != -1) {
					filename = "file" + filename.substring(filename.lastIndexOf("."));
					
					/*return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(filename)
					                 .createImage();*/
					return SWTResourceManager.getImage(this.getClass(), "/icons/resource.png");
				}
			}
		}
		return SWTResourceManager.getImage(this.getClass(), "/icons/registry_nav.png");
	}

	public Object[] getChildren() {
		List<RegistryElement> items = getContent();
		Map<String,NavigatorNode> node = new HashMap<String,NavigatorNode>();
		for (RegistryElement item : items) {
	        String path = item.getPath().replaceAll("^" + Pattern.quote(getPath()),"");
	        path = path.replaceAll("^" + Pattern.quote("/"),"");
	        String prefix = getPath() + (getPath().equals("/")?"":"/");
	        if(!"".equals(path)){
	        	if(path.indexOf("/")!=-1){
	        		path = prefix + path.substring(0, path.indexOf("/"));
	        	} else{
	        		path = prefix + path.substring(0, path.length());
	        	}
	        	if(node.containsKey(path)){
	        		node.get(path).getContent().add(item);
	        	} else{
	        		NavigatorNode navigatorNode = new NavigatorNode();
	        		navigatorNode.setContent(new ArrayList<RegistryElement>());
	        		navigatorNode.getContent().add(item);
	        		navigatorNode.setPath(path);
	        		navigatorNode.setProject(getProject());
	        		node.put(path, navigatorNode);
	        	}
	        } else{
	    		 String name ="";
		    	  if(item instanceof RegistryItem){
		    		  name = ((RegistryItem)item).getFile();
		    		  NavigatorNode navigatorNode = new NavigatorNode();
		        	  navigatorNode.setContent(new ArrayList<RegistryElement>());
		        	  navigatorNode.setPath(prefix+name);
		        	  navigatorNode.setProject(getProject());
		        	  navigatorNode.setData(item);
		        	  node.put(prefix+name, navigatorNode);
		    	  } else if(item instanceof RegistryDump){
		    		  name = ((RegistryDump)item).getFile();
		    		  NavigatorNode navigatorNode = new NavigatorNode();
		        	  navigatorNode.setContent(new ArrayList<RegistryElement>());
		        	  navigatorNode.setPath(prefix+name);
		        	  navigatorNode.setProject(getProject());
		        	  navigatorNode.setData(item);
		        	  node.put(prefix+name, navigatorNode);
		    	  }else{
		    		  RegistryCollection collection = (RegistryCollection)item;
		    		  File dir = getProject().getFolder(collection.getDirectory()).getLocation().toFile();
		    		  if(dir.exists()){
		    			  node.putAll(createNodes(dir, prefix+name));
		    		  }
		    	  }
	        }
        }
    	return node.values().toArray(new NavigatorNode[]{});
		
    }
	
	private Map<String,NavigatorNode> createNodes(File dir,String basePath){
		Map<String,NavigatorNode> nodes = new HashMap<String,NavigatorNode>();
		String[] files = dir.list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return !name.equals(".meta");
			}
		});
		for(String filename : files){
			File resource = new File(dir,filename); 
			String resourcePath = resource.toString().replaceAll("^" + Pattern.quote(getProject().getLocation().toOSString() + File.separator) ,"");
			if(resource.isDirectory()){
				RegistryCollection collection = new RegistryCollection();
				collection.setPath(basePath + resource.getName());
				collection.setDirectory(resourcePath);
				NavigatorNode navigatorNode = new NavigatorNode();
        		navigatorNode.setContent(new ArrayList<RegistryElement>());
        		navigatorNode.getContent().add(collection);
        		navigatorNode.setPath(basePath + resource.getName());
        		navigatorNode.setProject(getProject());
        		nodes.put(basePath + resource.getName(), navigatorNode);
			} else {
				RegistryItem item = new RegistryItem();
				item.setFile(resourcePath);
				item.setPath(basePath);
				NavigatorNode navigatorNode = new NavigatorNode();
				navigatorNode.setContent(new ArrayList<RegistryElement>());
				navigatorNode.setPath(basePath + resource.getName());
				navigatorNode.setProject(getProject());
				navigatorNode.setData(item);
				nodes.put(basePath + resource.getName(), navigatorNode);
			}
		}
		return nodes;
	}
	
	
	public String getText() {
		int index = getPath().lastIndexOf("/");
		if (index == -1 || isRoot() || index == getPath().length()) {
			return path;
		} else {
			return getPath().substring(index + 1);
		}
	}
	
	public void setRoot(boolean root) {
	    this.root = root;
    }
	public boolean isRoot() {
	    return root;
    }

	public boolean hasChildren() {
	    return getChildren().length!=0;
    }

	public void setContent(List<RegistryElement> content) {
	    this.content = content;
    }
	public List<RegistryElement> getContent() {
	    return content;
    }
	
	public RegistryElement getData() {
    	return data;
    }
	public void setData(RegistryElement data) {
    	this.data = data;
    }

	public void setProject(IProject project) {
	    this.project = project;
    }

	public IProject getProject() {
	    return project;
    }

	private String path;
	private List<RegistryElement> content;
	private boolean root;
	private RegistryElement data;
	private IProject project; 
	
}
