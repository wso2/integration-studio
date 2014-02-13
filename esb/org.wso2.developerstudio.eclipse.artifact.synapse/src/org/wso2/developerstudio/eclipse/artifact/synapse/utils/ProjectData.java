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

package org.wso2.developerstudio.eclipse.artifact.synapse.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.artifact.synapse.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.constants.ProjectConstants;

public class ProjectData extends AbstractListDataProvider{

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		   List<ListData> list = new ArrayList<ListData>();
		   IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		   for (IProject prj : projects) {
				try {
		            if (!prj.isOpen() || !prj.hasNature(ProjectConstants.JAVA_NATURE_ID) ){
		            	continue;
		            }
	            } catch (CoreException e1) {
	            	log.error("Error reading project", e1);
		            continue;
	            }
				IJavaProject jp = JavaCore.create(prj);
				try {
					IPackageFragment[] packageFragments = jp.getPackageFragments();
					for (IPackageFragment fragment : packageFragments) {
						IJavaElement[] children = fragment.getChildren();
						for (IJavaElement element : children) {
								ICompilationUnit[] compilationUnits = fragment.getCompilationUnits();
								for (ICompilationUnit unit : compilationUnits) {
								//	String temp = unit.getElementName();
									IType[] types = unit.getTypes();
									for (IType type : types) {
										if(type.getSuperclassName() != null){
											String[][] resolveType = type.resolveType(type.getSuperclassName());
											if(resolveType != null && (resolveType[0][0]).toString().equals("org.apache.synapse.mediators") &&
													(resolveType[0][1]).toString().equals("AbstractMediator")){
												//String className = type.getElementName();
											  ListData data = createListData(prj.getName(), prj);
												if(!list.contains(data)){
													 list.add(data);
												}
												//String fullyQualifiedName = type.getFullyQualifiedName();
											}
										}
									}
								}
						}
					}
				} catch (JavaModelException e) {
					log.error("Java project model error", e);
				}
			}
		return list;
	}

public HashMap<IProject, String> getProjects(){
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		HashMap filterProjectList = new HashMap<IProject, String>();
		for (IProject prj : projects) {
			try {
	            if (!prj.isOpen() || !prj.hasNature(ProjectConstants.JAVA_NATURE_ID) ){
	            	continue;
	            }
            } catch (CoreException e1) {
            	log.error("Error reading project", e1);
	            continue;
            }
			IJavaProject jp = JavaCore.create(prj);
			try {
				IPackageFragment[] packageFragments = jp.getPackageFragments();
				for (IPackageFragment fragment : packageFragments) {
					IJavaElement[] children = fragment.getChildren();
					for (IJavaElement element : children) {
							ICompilationUnit[] compilationUnits = fragment.getCompilationUnits();
							for (ICompilationUnit unit : compilationUnits) {
								String a = unit.getElementName();
								IType[] types = unit.getTypes();
								for (IType type : types) {
									if(type.getSuperclassName() != null){
										String[][] resolveType = type.resolveType(type.getSuperclassName());
										if(resolveType != null && (resolveType[0][0]).toString().equals("org.apache.synapse.mediators") &&
												(resolveType[0][1]).toString().equals("AbstractMediator")){
											String className = type.getElementName();
											if(!filterProjectList.containsKey(prj)){
												filterProjectList.put(prj,className);
											}
											String fullyQualifiedName = type.getFullyQualifiedName();
										}
									}
								}
							}
					}
				}
			} catch (JavaModelException e) {
				log.error("Java project model error", e);
			}
		}
		return filterProjectList;
	}
	
}
