/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.distribution.project.export.CappArtifactsListProvider;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;


public class ProjectList extends AbstractListDataProvider {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		
		List<ListData> list = new ArrayList<ListData>();

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		final String EXTENSIONPOINT_ID = "org.wso2.developerstudio.eclipse.capp.artifacts.provider";
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSIONPOINT_ID);
	    
	      for (IConfigurationElement element : config) {
	    	Object obj = null;
			try {
				 obj = element.createExecutableExtension("class");
			} catch (CoreException ex) {
				log.error("Error executing CappArtifactsListProvider extension ", ex);
			}
			
	        if (obj instanceof CappArtifactsListProvider) {
	        	
	        	CappArtifactsListProvider provider = (CappArtifactsListProvider)obj;
	        	String nature = element.getAttribute("nature");
	        	for(IProject project : projects) {
					try {
						if (project.isOpen() && project.hasNature(nature)) {
							List<ListData> listReceivedFromprovider = null;
							listReceivedFromprovider = provider.getArtifactsListForCappExport(project);
							list.addAll(listReceivedFromprovider);
						}
					} catch (Exception e) {
						log.error("Error getting artifacts from extension", e);
					}
	        	}
	        }
	        
	      }
	    
		return list;
	}
	
}
