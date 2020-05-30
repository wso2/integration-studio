/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver44microei11.handlers;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.carbonserver44microei11.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

/**
 * This is the early startup handler of the developer studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {

	public static final String DEBUG_PROFILE_NAME = "Microei_Debug_Profile";
	public static final String RUN_PROFILE_NAME = "Microei_Run_Profile";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		// Create ESB mediation debug launch configuration in the EI tooling IDE
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		try {
			createESBDebugProfile(launchManager);
			createMicroIntegratorRunProfile(launchManager);
		} catch (CoreException e) {
			log.error("Exception occured while creating micro-integrator debug profile", e);
		}

        // The following resource listener will remove the modules from the maven multi-module pom file when the child
        // projects are deleted
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IResourceChangeListener rcl = new IResourceChangeListener() {
            public void resourceChanged(final IResourceChangeEvent event) {
                new Thread() {
                    public void run() {
                        try {
                            if (event.getType() == IResourceChangeEvent.PRE_DELETE
                                    && event.getResource().getType() == org.eclipse.core.resources.IResource.PROJECT) {

                                IProject deletedProject = event.getResource().getProject();
                                IWorkspace workspace = ResourcesPlugin.getWorkspace();
                                IWorkspaceRoot root = workspace.getRoot();
                                IProject[] projects = root.getProjects();

                                for (IProject project : projects) {
                                    if (project.hasNature(
                                            "org.wso2.developerstudio.eclipse.mavenmultimodule.project.nature")) {
                                        IFile pomFile = project.getFile("pom.xml");
                                        MavenProject mavenProject = MavenUtils
                                                .getMavenProject(pomFile.getLocation().toFile());
                                        for (int i = 0; i < mavenProject.getModules().size(); i++) {
                                            if (mavenProject.getModules().get(i).equals(deletedProject.getName())) {
                                                mavenProject.getModules().remove(i);
                                            }
                                        }

                                        MavenUtils.saveMavenProject(mavenProject, pomFile.getLocation().toFile());
                                        project.getParent().refreshLocal(IResource.DEPTH_INFINITE,
                                                new NullProgressMonitor());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            log.error(
                                    "Error occured while delete module from pom file of the maven multi module project",
                                    e);
                        }

                    }
                }.start();
            }
        };
        workspace.addResourceChangeListener(rcl);

    }

	private void createESBDebugProfile(ILaunchManager launchManager) throws CoreException {
		if (findLaunchConfigurationByName(launchManager, DEBUG_PROFILE_NAME) == null) {
			ILaunchConfigurationType debugESBLaunchType = launchManager
					.getLaunchConfigurationType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch");
			ILaunchConfigurationWorkingCopy debugESBLaunchConfig = debugESBLaunchType.newInstance(null,
					DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(DEBUG_PROFILE_NAME));
			debugESBLaunchConfig.doSave();
		}
	}
	
    private void createMicroIntegratorRunProfile(ILaunchManager launchManager) throws CoreException {
        if (findLaunchConfigurationByName(launchManager, RUN_PROFILE_NAME) == null) {
            ILaunchConfigurationType debugESBLaunchType = launchManager
                    .getLaunchConfigurationType("org.wso2.developerstudio.eclipse.carbonserver44microei11.launch");
            ILaunchConfigurationWorkingCopy debugESBLaunchConfig = debugESBLaunchType.newInstance(null,
                    DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(RUN_PROFILE_NAME));
            debugESBLaunchConfig.doSave();
        }
    }	

	public static ILaunchConfiguration findLaunchConfigurationByName(ILaunchManager launchManager, String configName)
			throws CoreException {
		ILaunchConfiguration[] availableLauchConfigs = launchManager.getLaunchConfigurations();
		for (ILaunchConfiguration iLaunchConfig : availableLauchConfigs) {
			if (configName.equals(iLaunchConfig.getName())) {
				return iLaunchConfig;
			}
		}
		return null;
	}

}
