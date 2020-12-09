/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.esb.dashboard.templates.maven.wizard;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.templates.dashboard.help.TemplateGuideView;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Util class to for sample template creation.
 */
public class TemplateCreationUtil {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Used to open the carbon app pom file with dist project nature.
     *
     * @param shell Eclipse shell reference
     * @param fileDesc IFile instance of the file to be opened
     * @param editorID ID of the editor which used to open this file
     */
    public static void openEditor(Shell shell, IFile fileDesc, String editorId, URL url) {
        shell.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    page.openEditor(new FileEditorInput(fileDesc), editorId);
                    IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                            .findView(IPageLayout.ID_PROJECT_EXPLORER);
                    ((ISetSelectionTarget) view).selectReveal(new StructuredSelection(fileDesc));
                    openHelp(shell, url);
                } catch (WorkbenchException e) {
                    MessageDialog.openError(shell, TemplateProjectConstants.ERROR_MESSAGE_OPENING_EDITOR,
                            e.getMessage());
                }
            }
        });
    }

    /**
     * Used to open the help content of the relevant sample.
     *
     * @param shell Eclipse shell reference
     * @param helpURL URL of the help html page
     */
    public static void openHelp(Shell shell, URL helpURL) {
        final Shell shellRef = shell;
        final URL helpUrl = helpURL;

        shellRef.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    TemplateGuideView templateGuideView = (TemplateGuideView) PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getActivePage()
                            .showView(TemplateProjectConstants.TEMPLATE_GUIDE_VIEW_ID);
                    templateGuideView.setURL(helpUrl);
                } catch (PartInitException e) {
                    MessageDialog.openError(shellRef, TemplateProjectConstants.ERROR_MESSAGE_OPENING_EDITOR,
                            e.getMessage());
                }
            }
        });
    }

    public static void createSynapseUnitTestPlugin(File pomFile) {
        try {
            MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
            Plugin unitTestPlugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven",
                    "synapse-unit-test-maven-plugin", "5.2.27", false);

            PluginExecution pluginExecution = new PluginExecution();
            pluginExecution.addGoal("synapse-unit-test");
            pluginExecution.setPhase("test");
            pluginExecution.setId("synapse-unit-test");
            unitTestPlugin.addExecution(pluginExecution);

            // adding plugin configuration
            Xpp3Dom unitTestConfElement = MavenUtils.createMainConfigurationNode(unitTestPlugin);
            Xpp3Dom serverDetails = MavenUtils.createXpp3Node(unitTestConfElement, "server");
            Xpp3Dom testServerType = MavenUtils.createXpp3Node(serverDetails, "testServerType");
            testServerType.setValue("${testServerType}");
            Xpp3Dom testServerHost = MavenUtils.createXpp3Node(serverDetails, "testServerHost");
            testServerHost.setValue("${testServerHost}");
            Xpp3Dom testServerPort = MavenUtils.createXpp3Node(serverDetails, "testServerPort");
            testServerPort.setValue("${testServerPort}");
            Xpp3Dom testServerPath = MavenUtils.createXpp3Node(serverDetails, "testServerPath");
            testServerPath.setValue("${testServerPath}");
            Xpp3Dom testCasesFilePath = MavenUtils.createXpp3Node(unitTestConfElement, "testCasesFilePath");
            testCasesFilePath.setValue("${project.basedir}" + File.separator + "test" + File.separator + "${testFile}");
            Xpp3Dom testSkip = MavenUtils.createXpp3Node(unitTestConfElement, "mavenTestSkip");
            testSkip.setValue("${maven.test.skip}");

            // save the pom with plugin configuration
            MavenUtils.saveMavenProject(mavenProject, pomFile);

        } catch (XmlPullParserException e) {
            log.error("XmlPullParserException error while adding synapse-unit-test plugin to the pom", e);
        } catch (IOException e) {
            log.error("IOException error while adding synapse-unit-test plugin to the pom", e);
        }
    }

    /**
     * This method sets the perspective to ESB
     *
     * @param shell shell object that should be switched to ESB perspective
     */
    public static void setPerspective(Shell shell) {
        shell.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (!TemplateProjectConstants.ESB_GRAPHICAL_PERSPECTIVE
                        .equals(window.getActivePage().getPerspective().getId())) {
                    try {
                        PlatformUI.getWorkbench().showPerspective(TemplateProjectConstants.ESB_GRAPHICAL_PERSPECTIVE,
                                window);
                        ProjectPresentation.setHierarchicalProjectPresentation();
                    } catch (Exception e) {
                        log.error("Cannot switch to ESB Graphical Perspective", e);
                    }
                }
            }
        });
    }
}
