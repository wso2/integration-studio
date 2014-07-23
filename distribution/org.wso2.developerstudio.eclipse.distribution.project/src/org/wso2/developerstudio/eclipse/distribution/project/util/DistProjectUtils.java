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

package org.wso2.developerstudio.eclipse.distribution.project.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;


public class DistProjectUtils {

	public static MavenProject getMavenProject(IProject project) throws Exception {
               IFile pomFile=project.getFile(Constants.POM_FILE_NAME + "." + Constants.POM_FILE_EXTENSION);
	       return MavenUtils.getMavenProject(pomFile.getLocation().toFile());
	}
	
	
	public static String getArtifactInfoAsString(Dependency dep) {
		return getArtifactInfoAsString(dep,null);
	}
	
	public static String getArtifactInfoAsString(Dependency dep,String parent) {
		String suffix= "";
		if(parent!=null){
			suffix =  parent + ":=";
		} 
		return  suffix.concat(dep.getGroupId().concat("_._").concat(dep.getArtifactId()));
	}
	
	public static String getMavenInfoAsString(String info) {
		String suffix="";
		Pattern pattern = Pattern.compile("^(.*?):=");
		Matcher matcher = pattern.matcher(info);
		 while (matcher.find()) {
			 suffix= matcher.group().toString();
	        }
		return info.replaceFirst(suffix,"");
	}
	
	public static String getServerRole(final MavenProject project,final Dependency dependency){
		String serverRole = "";
		if(project!=null){
			Properties properties = project.getModel().getProperties();
			String artifactInfo = getArtifactInfoAsString(dependency);
			String artifactInfoOld = getArtifactInfoAsStringOld(dependency);	//get artifact info in old property format
			if(properties.containsKey(artifactInfo)){
				serverRole = properties.getProperty(artifactInfo);
			} 
			else if(properties.containsKey(artifactInfoOld )){
				//if properties in old format (devs 3.2 or above)
				serverRole = properties.getProperty(artifactInfoOld);
			}
			else {
				ProjectList projectListProvider = new ProjectList();
				List<ListData> projectListData = projectListProvider.getListData(null, null);
				Map<String,DependencyData> projectList= new HashMap<String, DependencyData>();
				for (ListData data : projectListData) {
					DependencyData dependencyData = (DependencyData)data.getData();
					projectList.put(data.getCaption(), dependencyData);
				}
				serverRole = getDefaultServerRole(projectList, artifactInfo);
			}
		}
		return serverRole;
	}
	
	/*
		 * method for create property key in old format (devs 3.2 or above)
		 */
	public static String getArtifactInfoAsStringOld(Dependency dep) {
		return  dep.getGroupId().concat(":").concat(dep.getArtifactId()).concat(":").concat(dep.getVersion());
	}
	
	public static String getDefaultServerRole(final Map<String, DependencyData> projectList,final Dependency dependency){
		return getDefaultServerRole(projectList,DistProjectUtils.getArtifactInfoAsString(dependency));
	}
	
	public static String getDefaultServerRole(final Map<String, DependencyData> projectList,final String artifactInfo){
		String serverRole = "capp/ApplicationServer"; // default role
		if(projectList.containsKey(artifactInfo)){
			serverRole = projectList.get(artifactInfo).getServerRole();
		} else{
			for(Map.Entry<String,DependencyData> entry : projectList.entrySet()){
				String mavenInfoAsString = getMavenInfoAsString(entry.getKey());
				if(mavenInfoAsString.equals(artifactInfo)){
					serverRole = entry.getValue().getServerRole();
					break;
				}
			}
		}
		return serverRole;
	}
	
}
