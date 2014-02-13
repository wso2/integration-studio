package org.wso2.developerstudio.eclipse.artifact.ds.validator.utils;

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
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.constants.ProjectConstants;

public class ProjectData extends AbstractListDataProvider{

	
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		   List<ListData> list = new ArrayList<ListData>();
		   IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		   for (IProject prj : projects) {
				try {
		            if (!prj.isOpen() || !prj.hasNature(ProjectConstants.JAVA_NATURE_ID) ){
		            	continue;
		            }
	            } catch (CoreException e1) {
		            e1.printStackTrace();
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
										String[] superInterfaceNames = type.getSuperInterfaceNames();
										if(superInterfaceNames != null){
											for (String interfaceName : superInterfaceNames) {
												if(interfaceName.equals("Validator")){
													  ListData data = createListData(prj.getName(), prj);
														if(!list.contains(data)){
															 list.add(data);
														}
												}
											}
											
										}
										
									}
								}
						}
					}
				} catch (JavaModelException e) {
					 e.printStackTrace();
				}
			}
		return list;
	}

}
