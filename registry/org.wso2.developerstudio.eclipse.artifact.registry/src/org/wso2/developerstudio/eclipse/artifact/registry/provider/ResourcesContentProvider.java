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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;

public class ResourcesContentProvider implements ITreeContentProvider {
	private static final String navigatorLabel = "Registry Resources View";
	private IProject project;
	NavigatorNode root;
	
	public void initContent(){
		List<RegistryElement> content = new ArrayList<RegistryElement>();
		GeneralProjectArtifact generalProjectArtifact=new GeneralProjectArtifact();
		   try {
			    File artifactXml =  getProject().getFile("artifact.xml").getLocation().toFile();
			    generalProjectArtifact.fromFile(artifactXml);
			    List<RegistryArtifact> regArtifact = generalProjectArtifact.getAllArtifacts();
			    for (RegistryArtifact artifact : regArtifact) {
			    	List<RegistryElement> items = artifact.getAllRegistryItems();
			    	for (RegistryElement item : items) {
	                    content.add(item);
                    }
		    	}
			    root = new NavigatorNode();
			    root.setRoot(true);
			    root.setContent(content);
			    root.setPath("/");
			    root.setProject(project);
		      } catch (Exception e) {
			 /*ignore*/
		  }
	   }

	
    public void dispose() {
	    
    }

	
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		initContent();  
    }

	
    public Object[] getChildren(Object element) {
		if(IProject.class.isInstance(element)){
			setProject((IProject)element);
			initContent();
			return new String[]{navigatorLabel};
		} else if(String.class.isInstance(element)){
			if(navigatorLabel.equals(element.toString())){
				return new Object[]{root};
			}
		} else if (NavigatorNode.class.isInstance(element)){
			return ((NavigatorNode)element).getChildren();
		}
		return new String[]{};
    }

	
    public Object[] getElements(Object element) {
	    return getChildren(element);
    }

	
    public Object getParent(Object element) {
	    return "root";
    }

	
    public boolean hasChildren(Object element) {
    if(element instanceof NavigatorNode){
		return ((NavigatorNode)element).hasChildren();
	} else{
		return true;
	}
    }

	public void setProject(IProject project) {
	    this.project = project;
    }

	public IProject getProject() {
	    return project;
    }
	
}
