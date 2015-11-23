/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
package org.wso2.wsf.ide.core.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.internal.FacetedProjectFrameworkImpl;
import org.eclipse.wst.common.project.facet.core.runtime.IRuntime;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;
import org.wso2.wsf.ide.core.plugin.WebServiceWSASCorePlugin;

public class ClassLoadingUtil {
	private static IDeveloperStudioLog log=Logger.getLog(WebServiceWSASCorePlugin.PLUGIN_ID);

	private static String[] wsasClassPath = null;
	private static List<String> tmpClassPaths = null;
	private static String[] classLoadPath = null;
	private static AntClassLoader antClassLoader;
	private static boolean libsLoaded = false;
	private static URL[] urls = null;
	private static boolean alreadyInit = false;
	private static boolean initByClient = false;
	private static String lastWebProjectName = null;
	private static String runtimeLocation = "";

	public static void init() throws Exception {
		if (!alreadyInit) {

		//Obtain a ant class loader instance
			if(antClassLoader==null){
		antClassLoader =  new AntClassLoader();
			}
		
		// Set the class loader to child first
		antClassLoader.setParentFirst(false);
		
			if (!(wsasClassPath ==null) || !libsLoaded){
				classLoadPath = getWSASLibs();
			}
			
			if(urls == null){
				urls= new URL[classLoadPath.length];
			}

		Path classpath = new Path(new Project());
		
		try{
			for (int i = 0; i < classLoadPath.length; i++) {
				//Create a File object on the root of the directory containing the class file
				if(classLoadPath[i]!=null){
					File file = new File(classLoadPath[i]);
//					if (file.isFile()){
					// Convert File to a URL
						URL url = file.toURL();          
						urls[i]= url;
						classpath.setPath(classLoadPath[i]);
//					}
				}
			}
			
		}catch(MalformedURLException e){
			log.error(e);
		}
			antClassLoader.setClassPath(classpath);
			alreadyInit = true;
				}
			}

	
	
	public static Class loadClassFromAntClassLoader(String fillyQualifiedClassName){
		
		Class cls = null;
		try{	
			cls = antClassLoader.loadClass(fillyQualifiedClassName);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
		return cls;
	}
	
	private static String getWebProjectRuntimeId() throws CoreException{
		Set<IFacetedProject> facetedProjects = FacetedProjectFrameworkImpl.getInstance().getFacetedProjects();
		for(IFacetedProject fp:facetedProjects){
			if (fp.getProject().getName().equals(getLastWebProjectName())){
				Set<IRuntime> targetedRuntimes = fp.getTargetedRuntimes();
				for(IRuntime r:targetedRuntimes){
					if (ServerController.getInstance().getServerManager().isRuntimeIdPresent(r.getRuntimeComponents().get(0).getProperty("type-id"))){
						runtimeLocation=r.getRuntimeComponents().get(0).getProperty("location");
						return r.getRuntimeComponents().get(0).getProperty("type-id");
					}
					
				}
			}
		}
		return null;
	}
	
	private static String[] getWSASLibs() throws Exception{
		String[] serverIds = ServerController.getInstance().getServerManager().getServerIds();
		String wsasHome=null;
		String serverId="";
		for(String id:serverIds){
			IPath serverLocation = ServerController.getInstance().getServerManager().getServerHome(id);
			if ((new File(serverLocation.toOSString())).exists()){
				serverId=id;
				break;
			}
		}
		if(serverId==null || serverId.equalsIgnoreCase("")){
			String runtimeId=getWebProjectRuntimeId();
			if (runtimeId!=null){
				wsasClassPath = ServerController.getInstance().getServerManager().getServerCodegenLibrariesFromRuntimeId(runtimeId, runtimeLocation);
			}
		} else {
			wsasClassPath=ServerController.getInstance().getServerManager().getServerCodegenLibraries(serverId);
    	}
		
		if(wsasHome!=null){
			
    	}else{
    		//TODO Throw and error
    	}
		return wsasClassPath;
	}


	public static void visitAllFiles(File dir) {
		if(!dir.toString().endsWith(".txt")){
			if (dir.isDirectory()) {
				if(dir.getName().toString().equals("tomcat") 
						|| dir.getName().toString().equals("wsf") 
						|| dir.getName().toString().equals("patches") ){
					//skip these libraris being loaded
				}
				else{
					String[] children = dir.list();
					for (int i=0; i<children.length; i++) {
						visitAllFiles(new File(dir, children[i]));
					}
				}
			} else {
				tmpClassPaths.add(dir.getAbsolutePath());
			}

		}
		libsLoaded = true;
	}

	public static void cleanAntClassLoader(){
		if(initByClient){
			antClassLoader.cleanup();
			alreadyInit = false;
		}
}
	public static void setInitByClient(boolean status){
		initByClient = status;
	}



	public static void setLastWebProjectName(String lastWebProject) {
		ClassLoadingUtil.lastWebProjectName = lastWebProject;
	}



	public static String getLastWebProjectName() {
		return lastWebProjectName;
	}
}
