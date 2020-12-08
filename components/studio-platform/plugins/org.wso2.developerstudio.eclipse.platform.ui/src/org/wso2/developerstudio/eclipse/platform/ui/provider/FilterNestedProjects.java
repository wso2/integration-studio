/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class FilterNestedProjects extends ViewerFilter {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private List<String> pathList;
	private static final String SESSION_PROPERTY_WORKSPACE_FOLDERS = "WORKSPACE_FOLDER";
	private static final String SESSION_PROPERTY_WORKSPACE_PROJECTS = "WORKSPACE_PROJECT";
	private static Map<QualifiedName, Object> sessionProperties;
	private static long previousProjectCountWF = ResourcesPlugin.getWorkspace().getRoot().getProjects().length;
	private static long previousProjectCountWP = ResourcesPlugin.getWorkspace().getRoot().getProjects().length;
	private static IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

	static {
		try {
			sessionProperties = workspaceRoot.getSessionProperties();
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 * @param type
	 *            If 0 - WorkspaceFolders 1- WorkspaceProjects
	 * @return
	 */
	private boolean isValidSessionProperty(int type) {
		int currentProjects = workspaceRoot.getProjects().length;
		switch (type) {
			case 0:
				if (currentProjects != previousProjectCountWF) {
					previousProjectCountWF = currentProjects;
					return false;
				}
				return true;
			case 1:
				if (currentProjects != previousProjectCountWP) {
					previousProjectCountWP = currentProjects;
					return false;
				}
				return true;
			default:
				break;
		}
		return false;
	}

	public boolean select(Viewer arg0, Object parent, Object child) {
		if (parent instanceof IWorkspaceRoot && child instanceof IProject) {
			Object sessionProperty = sessionProperties.get(new QualifiedName("", SESSION_PROPERTY_WORKSPACE_FOLDERS));

			if (sessionProperty != null && isValidSessionProperty(0)) {
				pathList = (List<String>) sessionProperty;
			} else {
				pathList = getPathList();
				sessionProperties.put(new QualifiedName("", SESSION_PROPERTY_WORKSPACE_FOLDERS), pathList);
			}
			if (pathList != null && ((IProject) child).exists()) {
				return !pathList.contains(((IProject) child).getLocation().toOSString());
			} else {
				return false;
			}
		}

		if (child instanceof IFolder) {
			Object sessionProperty = sessionProperties.get(new QualifiedName("", SESSION_PROPERTY_WORKSPACE_PROJECTS));
			List<String> pathList;
			if (sessionProperty != null && isValidSessionProperty(1)) {
				pathList = (List<String>) sessionProperty;
			} else {
				pathList = getProjectListLocations();
				sessionProperties.put(new QualifiedName("", SESSION_PROPERTY_WORKSPACE_PROJECTS), pathList);
			}

			return !pathList.contains(((IFolder) child).getLocation().toOSString());
		}

		return true;
	}

	public List<String> getPathList() {
		List<String> paths = new ArrayList<String>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			File location = project.getLocation().toFile();
			addDirectoryPaths(paths, location);
		}
		return paths;
	}

	public List<String> getProjectListLocations() {
		List<String> paths = new ArrayList<String>();
		IProject[] projects = workspaceRoot.getProjects();
		for (IProject project : projects) {
			paths.add(project.getLocation().toOSString());
		}
		return paths;
	}

	private void addDirectoryPaths(List<String> paths, File location) {
		if (location.isFile()) {
			return;
		}
		File[] children = location.listFiles();
		if (children != null) {
			for (File child : children) {
				if (child.isDirectory() && !paths.contains(child.toString())) {
					paths.add(child.toString());
					addDirectoryPaths(paths, child);
				}
			}
		}
	}
}
