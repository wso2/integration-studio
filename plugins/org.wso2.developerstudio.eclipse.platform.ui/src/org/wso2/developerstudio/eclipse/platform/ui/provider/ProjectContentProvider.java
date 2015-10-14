/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
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
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.platform.ui.provider.internal.EmptyNavigatorContentProvider;

public class ProjectContentProvider extends EmptyNavigatorContentProvider {

    private Viewer viewer;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public Object[] getChildren(Object obj) {
    	File location=null;
    	if (obj instanceof IProject || obj instanceof IFolder){
    		location=((IResource)obj).getLocation().toFile();
    	
    		List<File> locationList = Arrays.asList(location.listFiles());
    		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    		List<IProject> projectsToAdd = new ArrayList<IProject>();
    		if (locationList != null) {
				for (IProject project : projects) {
					if (locationList.contains(project.getLocation().toFile())) {
						projectsToAdd.add(project);
					}
				}
			}
			return projectsToAdd.toArray();
    	}
	    return new Object[]{};
    }

    public boolean hasChildren(Object obj) {
    	if (obj instanceof IProject){
            return true;
    	}
    	return false;
    }

    public void dispose() {
    	ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    }

    public void inputChanged(Viewer viewer, Object arg1, Object arg2) {
    	this.viewer = viewer;
	}

	public void resourceChanged(IResourceChangeEvent event) {
		if (event != null && event.getDelta() != null) {
			try {
				event.getDelta().accept(new IResourceDeltaVisitor() {
					@Override
					public boolean visit(IResourceDelta delta) throws CoreException {
						IResource resource = delta.getResource();
						if (((resource.getType() & IResource.PROJECT) != 0)
								&& delta.getKind() == IResourceDelta.CHANGED
								&& ((delta.getFlags() & IResourceDelta.OPEN) != 0)) {
							IProject changedProject = (IProject) resource;
							List<IProject> childProjects = getChildProjects(changedProject);

							for (IProject childProject : childProjects) {
								if (changedProject.isOpen()) { // open event
									scheduleOpenJob(childProject);
								} else { // close event
									scheduleCloseJob(childProject);
								}
							}
						}
						return true;
					}

					private List<IProject> getChildProjects(IProject changedProject) {
						List<IProject> childProjects = new ArrayList<>();

						IProject[] workspaceProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
						for (IProject workspaceProject : workspaceProjects) {
							IPath changedProjectPath = changedProject.getLocation();
							IPath workspaceProjectPath = workspaceProject.getLocation();
							IPath pathRelativeToChangedProject = workspaceProjectPath
									.makeRelativeTo(changedProjectPath);
							// checks if the changed project is the parent
							if (pathRelativeToChangedProject.toString().equals(workspaceProject.getName())) {
								childProjects.add(workspaceProject);
							}
						}
						return childProjects;
					}

					private void scheduleOpenJob(final IProject project) {
						// workspace is locked therefore scheduling the event
						WorkspaceJob job = new WorkspaceJob("Open child project: " + project.getName()) {
							@Override
							public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
								project.open(monitor);
								return Status.OK_STATUS;
							}
						};
						job.setRule(project);
						job.schedule();
					}

					private void scheduleCloseJob(final IProject project) {
						// workspace is locked therefore scheduling the event
						WorkspaceJob job = new WorkspaceJob("Close child project: " + project.getName()) {
							@Override
							public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
								project.close(monitor);
								return Status.OK_STATUS;
							}
						};
						job.setRule(project);
						job.schedule();
					}
				});
			} catch (CoreException e) {
				log.error("Error occured while changing child projects", e);
				IStatus changeStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
				ErrorDialog.openError(Display.getCurrent().getActiveShell(),
						"Error occured while changing child projects", e.getMessage(), changeStatus);
			}
		}

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (viewer != null) {
					viewer.refresh();
				}
			}
		});
	}
}