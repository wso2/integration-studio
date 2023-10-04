/*
 * Copyright (c) 2023, WSO2 LLC (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.esb.project.ui.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.project.MavenProject;
import org.wso2.integrationstudio.esb.project.Activator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.logging.core.Logger;

public class SelectMainSequence implements IActionDelegate {

    IStructuredSelection selection;
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String COMBOBOX_DEFAULT = "None";

    public void run(IAction action) {
        if (selection != null) {
            IProject project = (IProject) selection.getFirstElement();
            if (project != null) {
                IFile pomXml = project.getFile("pom.xml");
                IPath pomFilePath = pomXml.getLocation();
                File pomFile = pomFilePath.toFile();

                final SequenceComboDialog sequenceInput = new SequenceComboDialog(
                        Display.getCurrent().getActiveShell());
                
                int open = sequenceInput.open();
                if (open == Dialog.OK) {
                    String sequenceName = sequenceInput.getSelectedValue();
                    MavenProject mavenProject = getMavenProject(pomFile);
                    if (COMBOBOX_DEFAULT.equals(sequenceName)) {
                        mavenProject.getProperties().remove("mainSequence");
                    } else {
                        mavenProject.getProperties().put("mainSequence", sequenceName);
                    }
                    try {
                        MavenUtils.saveMavenProject(mavenProject, pomFile);
                    } catch (Exception e) {
                        log.error("Error occured while trying to save the maven project", e);
                    }
                }
            }
        }
    }

    public static MavenProject getMavenProject(File pomLocation) {
        MavenProject mavenProject = null;
        if (pomLocation != null && pomLocation.exists()) {
            try {
                mavenProject = MavenUtils.getMavenProject(pomLocation);
            } catch (Exception e) {
                log.error("error reading pom file", e);
            }
        }
        return mavenProject;

    }

    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }

    }

    protected ArrayList<String> getAvailableArtifactListFromProject() {

        String synapseArtifcatCategory = "synapse/sequence";
        ArrayList<String> availableList = new ArrayList<String>();
        availableList.add(COMBOBOX_DEFAULT);
        File projectPath = null;
        Shell shell = Display.getCurrent().getActiveShell();

        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
        for (IProject workspaceProject : projects) {
            try {
                if (workspaceProject.isOpen()
                        && workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
                    ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
                    projectPath = workspaceProject.getLocation().toFile();
                    try {
                        esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
                        List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
                        for (ESBArtifact esbArtifact : allESBArtifacts) {
                            if (synapseArtifcatCategory.equals(esbArtifact.getType())) {
                                File artifact = new File(projectPath, esbArtifact.getFile());
                                availableList.add(artifact.getName().replaceAll("[.]xml$", ""));
                            }
                        }
                    } catch (Exception e) {
                        ErrorDialog.openError(shell,
                                "Error occured while scanning the project for " + synapseArtifcatCategory
                                        + " artifacts",
                                e.getMessage(), new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
                    }
                }
            } catch (CoreException e) {
                ErrorDialog.openError(shell, "Error occured while scanning the project", e.getMessage(),
                        new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
            }
        }

        return availableList;
    }

    public class SequenceComboDialog extends Dialog {
        private Combo combo;
        private String selectedValue;

        public SequenceComboDialog(Shell parentShell) {
            super(parentShell);
        }

        @Override
        protected Control createDialogArea(Composite parent) {

            ArrayList<String> availableSequences = getAvailableArtifactListFromProject();
            String[] sequenceArray = availableSequences.toArray(new String[availableSequences.size()]);

            Composite container = (Composite) super.createDialogArea(parent);
            container.setLayout(new GridLayout(2, false));

            Label label = new Label(container, SWT.NONE);
            label.setText("Select a main sequence:");

            combo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
            combo.setItems(sequenceArray);
            combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

            return container;
        }

        @Override
        protected void okPressed() {
            selectedValue = combo.getText();
            super.okPressed();
        }

        public String getSelectedValue() {
            return selectedValue;
        }

        @Override
        protected void configureShell(Shell shell) {
            super.configureShell(shell);
            // Set the desired width of the shell (dialog)
            shell.setSize(600, 200);
            // Center the shell on the display (screen)
            shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getSize().x / 2,
                    Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
            shell.setText("Select a Main Sequence for this Composite Application");

        }
    }
}
