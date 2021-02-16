/*
 * Copyright (c) 2021 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software He
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.artifact.registry.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.artifact.registry.Activator;
import org.wso2.integrationstudio.general.project.artifact.GeneralProjectArtifact;
import org.wso2.integrationstudio.general.project.artifact.RegistryArtifact;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

/**
 * Class responsible for add new registry properties to registry resources.
 */
public class RegistryPropertiesCreationWizard extends Wizard implements IExportWizard {

    private static final IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String WINDOW_TITLE = "Registry Resource Properties";
    private boolean initError = false;
    private RegistryPropertiesCreationWizardPage registryPropertiesCreationWizardPage;
    GeneralProjectArtifact generalProjectArtifact;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        try {
            String path = null;
            if (selection.getFirstElement() instanceof IFile) {
                path = ((IFile) selection.getFirstElement()).getProjectRelativePath().toString();
            } else if (selection.getFirstElement() instanceof IFolder) {
                path = ((IFolder) selection.getFirstElement()).getProjectRelativePath().toString();
            }
            generalProjectArtifact = new GeneralProjectArtifact();
            generalProjectArtifact
                    .fromFile(getSelectedProject(selection).getFile("artifact.xml").getLocation().toFile());
            registryPropertiesCreationWizardPage = new RegistryPropertiesCreationWizardPage(generalProjectArtifact,
                    path);
        } catch (Exception e) {
            log.error("Error reading project", e);
        }
    }

    @Override
    public boolean performFinish() {
        try {
            // First remove the updated registry artifact object from the artifact.xml file
            RegistryArtifact selectedRegistryartifact = registryPropertiesCreationWizardPage
                    .getSelectedRegistryResource();
            generalProjectArtifact.removeArtifact(selectedRegistryartifact);

            // Set the updated property list in the registry artifact object
            RegistryElement registryElement = selectedRegistryartifact.getAllRegistryItems().get(0);
            registryElement.setProperties(registryPropertiesCreationWizardPage.getRegistryProperties());

            // Add the updated registry artifact object to the artifact.xml file
            generalProjectArtifact.addArtifact(selectedRegistryartifact);
            generalProjectArtifact.toFile();
        } catch (Exception e) {
            log.error("cannot update properties ", e);
        }
        return true;
    }

    @Override
    public void addPages() {
        if (!initError) {
            addPage(registryPropertiesCreationWizardPage);
            super.addPages();
        }
    }

    @Override
    public boolean canFinish() {
        if (registryPropertiesCreationWizardPage.isPageComplete()) {
            return true;
        }
        return false;
    }

    /**
     * Method for getting current project from IStructuredSelection.
     *
     * @param obj IStructuredSelection as an object
     * @return IProject
     */
    public static IProject getSelectedProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }
}
