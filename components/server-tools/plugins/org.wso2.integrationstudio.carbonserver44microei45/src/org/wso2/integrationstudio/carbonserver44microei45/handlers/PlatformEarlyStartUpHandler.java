/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.integrationstudio.carbonserver44microei45.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.carbonserver44microei45.Activator;
import org.wso2.integrationstudio.distribution.project.util.MavenMultiModuleImportUtils;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;

/**
 * This is the early startup handler of the Integration Studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {

    public static final String DEBUG_PROFILE_NAME = "Debug on embedded Micro Integrator Server";
    public static final String RUN_PROFILE_NAME = "Run on embedded Micro Integrator Server";
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    // relative path to where microesb is packaged
    public static final String MICRO_ESB_PATH = "runtime" + File.separator + "microesb";
    public static final String MICRO_ESB_EXTRACT_PATH = "runtime";
    public static final String MICRO_ESB_VERSION_PROPERTIES_FILE = "runtime" + File.separator +"version.properties";
    public static final String INTEGRATION_STUDIO_HOME_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";    

    @Override
    public void earlyStartup() {

        try {
            // Copy the micro integrator runtime from the plugin
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
            String PluginServerVersion = null;
            String internalServerVersion = null;

            URL pluginServerVersionURL = bundle.getEntry("resources/server/version.properties");
            URL resolvedVersionURL = FileLocator.toFileURL(pluginServerVersionURL);
            URI resolvedVersionURI = new URI(resolvedVersionURL.getProtocol(), resolvedVersionURL.getPath(), null);
            File pluginServerVersionFile = new File(resolvedVersionURI);

            try (InputStream inStream = new FileInputStream(pluginServerVersionFile)) {
                Properties prop = new Properties();
                prop.load(inStream);
                PluginServerVersion = prop.get("version").toString();
            } catch (IOException io) {
                log.error("Error occured while trying to retreive server version from the plugin", io);
            }

            File internalServerVersionFile = null;
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                boolean isRelativeToolingAppExists = false;
                File macOSRelativeToolingApp = null;
                try {
                    macOSRelativeToolingApp = new File((new File(".").getCanonicalFile()).getParent().toString() 
                            + File.separator + "Eclipse");
                    if (macOSRelativeToolingApp.exists()) {
                        isRelativeToolingAppExists = true;
                    }
                } catch (IOException e) {}
                if (isRelativeToolingAppExists && macOSRelativeToolingApp != null) {
                    internalServerVersionFile = new File(macOSRelativeToolingApp.getAbsolutePath() 
                            + File.separator + MICRO_ESB_VERSION_PROPERTIES_FILE);
                } else  {
                    internalServerVersionFile = new File(
                            INTEGRATION_STUDIO_HOME_MAC + File.separator + MICRO_ESB_VERSION_PROPERTIES_FILE);
                }
            } else {
                internalServerVersionFile = new File(MICRO_ESB_VERSION_PROPERTIES_FILE);
            }
            if (internalServerVersionFile.exists()) {
                try (InputStream inStream = new FileInputStream(internalServerVersionFile)) {
                    Properties prop = new Properties();
                    prop.load(inStream);
                    Object property = prop.get("version");
                    if (property == null) {
                        internalServerVersion = "00";
                    } else {
                        internalServerVersion = property.toString();
                    }

                } catch (IOException io) {
                    log.error("Error occured while trying to retreive server version from the application", io);
                }
            } else {
                internalServerVersion = "00";
            }
            int internalVersion = Integer.parseInt(internalServerVersion);
            int pluginVersion = Integer.parseInt(PluginServerVersion);

            if (internalVersion < pluginVersion) {
                URL fileURL = bundle.getEntry("resources/server/microesb.zip");
                URL resolvedFileURL = FileLocator.toFileURL(fileURL);
                URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
                File esbServerZipFromPlugin = new File(resolvedURI);

                File esbSeverDestination = null;
                if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                    boolean isRelativeToolingAppExists = false;
                    File macOSRelativeToolingApp = null;
                    try {
                        macOSRelativeToolingApp = new File((new File(".").getCanonicalFile()).getParent().toString() 
                                + File.separator + "Eclipse");
                        if (macOSRelativeToolingApp.exists()) {
                            isRelativeToolingAppExists = true;
                        }
                    } catch (IOException e) {
                    }
                    if (isRelativeToolingAppExists && macOSRelativeToolingApp != null) {
                        esbSeverDestination = new File(macOSRelativeToolingApp.getAbsolutePath() + File.separator + MICRO_ESB_EXTRACT_PATH);
                    } else  {
                        esbSeverDestination = new File(INTEGRATION_STUDIO_HOME_MAC + File.separator + MICRO_ESB_EXTRACT_PATH);
                    }
                } else {
                    esbSeverDestination = new File(MICRO_ESB_EXTRACT_PATH);
                }
                if (esbSeverDestination.exists()) {
                    File backupDir = new File(esbSeverDestination.getAbsolutePath().concat("_old"));
                    if (backupDir.exists()) {
                        FileUtils.deleteDirectory(backupDir);
                    }
                    esbSeverDestination.renameTo(backupDir);
                }
                MavenMultiModuleImportUtils.extractZipFile(esbServerZipFromPlugin, esbSeverDestination);
                // Set executable permission for micro-integrator executable
                File serverExecutableFile = new File(esbSeverDestination + File.separator + "microesb" + File.separator
                        + "bin" + File.separator + "micro-integrator.sh");
                if (serverExecutableFile.exists()) {
                    serverExecutableFile.setExecutable(true);
                } else {
                    log.error("Cannot Find Micro Integrator executable");
                }

                if (!internalServerVersionFile.exists()) {
                    internalServerVersionFile.getParentFile().mkdirs();
                    internalServerVersionFile.createNewFile();
                }
                try (OutputStream output = new FileOutputStream(internalServerVersionFile)) {
                    Properties prop = new Properties();
                    prop.setProperty("version", PluginServerVersion);
                    prop.store(output, null);
                } catch (IOException io) {
                    log.error("Error occured while trying to update server version of the application", io);
                }
            }

        } catch (URISyntaxException | IOException e) {
            log.error("Unable to extract Micro Integrator Runtime", e);
        }

        // Create ESB mediation debug launch configuration in the EI tooling IDE
        ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
        try {
            createESBDebugProfile(launchManager);
            createMicroIntegratorRunProfile(launchManager);
        } catch (CoreException e) {
            log.error("Exception occured while creating micro-integrator debug profile", e);
        }

        // The following section will remove the unwanted
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {

                try {
                    @SuppressWarnings("restriction")
                    WorkbenchWindow workbenchWin = (WorkbenchWindow) PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow();
                    @SuppressWarnings("restriction")
                    MenuManager menuManager = workbenchWin.getMenuManager();
                    IContributionItem[] items = menuManager.getItems();

                    // The following code will delete selected entries under the Help menu
                    for (int i = 0; i < items.length; i++) {
                        if (items[i] instanceof IMenuManager) {
                            IMenuManager submenu = (IMenuManager) items[i];
                            // This removes Welcome
                            IContributionItem welcomeItem = submenu.find("intro");
                            if (welcomeItem != null) {
                                submenu.remove(welcomeItem);
                            }
                            // This removes Key Binding
                            IContributionItem keyBindingItem = submenu
                                    .find("org.eclipse.ui.actions.showKeyAssistHandler");
                            if (keyBindingItem != null) {
                                submenu.remove(keyBindingItem);
                            }
                            // This removes Update
                            // IContributionItem updateItem = submenu.find("org.eclipse.equinox.p2.ui.sdk.update");
                            // if (updateItem != null) {
                            //     submenu.remove(updateItem);
                            // }
                            // This removes Update
                            IContributionItem v8CrhomeRunItem = submenu.find(
                                    "org.eclipse.wst.jsdt.chromium.debug.ui.actions.AddExceptionBreakpointAction");
                            if (v8CrhomeRunItem != null) {
                                submenu.remove(v8CrhomeRunItem);
                            }
                            // This removes Help Contents
                            IContributionItem helpContentItem = submenu.find("helpContents");
                            if (helpContentItem != null) {
                                submenu.remove(helpContentItem);
                            }
                            // This removes Help Search
                            IContributionItem helpSearchItem = submenu.find("helpSearch");
                            if (helpSearchItem != null) {
                                submenu.remove(helpSearchItem);
                            }
                            // This removes Dynamic Help
                            IContributionItem dynamicHelpItem = submenu.find("dynamicHelp");
                            if (dynamicHelpItem != null) {
                                submenu.remove(dynamicHelpItem);
                            }
                            // This removes Tip and Tricks
                            IContributionItem TipsAndTricksItem = submenu.find("tipsAndTricks");
                            if (TipsAndTricksItem != null) {
                                submenu.remove(TipsAndTricksItem);
                            }
                            // This removes Cheet Sheet
                            IContributionItem cheatSheetItem = submenu
                                    .find("org.eclipse.ui.cheatsheets.actions.CheatSheetHelpMenuAction");
                            if (cheatSheetItem != null) {
                                submenu.remove(cheatSheetItem);
                            }
                        }
                    }

                    final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                    if (workbenchWindow != null) {

                        workbenchWindow.addPerspectiveListener(new PerspectiveAdapter() {
                            @Override
                            public void perspectiveActivated(IWorkbenchPage page,
                                    IPerspectiveDescriptor perspectiveDescriptor) {
                                super.perspectiveActivated(page, perspectiveDescriptor);
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                                .hideActionSet("org.eclipse.ui.externaltools.ExternalToolsSet");
                            }
                        });

                        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .hideActionSet("org.eclipse.ui.externaltools.ExternalToolsSet");
                    }
                } catch (Exception e) {
                    log.error(e);
                }
            }
        });

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
                                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                                IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

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
                            log.error("Error occured while delete module from pom file of the maven multi module project", e);
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
                    .getLaunchConfigurationType("org.wso2.integrationstudio.gmf.esb.diagram.debugger.launch");
            ILaunchConfigurationWorkingCopy debugESBLaunchConfig = debugESBLaunchType.newInstance(null,
                    DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(DEBUG_PROFILE_NAME));
            debugESBLaunchConfig.doSave();
        }
    }

    private void createMicroIntegratorRunProfile(ILaunchManager launchManager) throws CoreException {
        if (findLaunchConfigurationByName(launchManager, RUN_PROFILE_NAME) == null) {
            ILaunchConfigurationType debugESBLaunchType = launchManager
                    .getLaunchConfigurationType("org.wso2.integrationstudio.carbonserver44microei45.launch");
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
