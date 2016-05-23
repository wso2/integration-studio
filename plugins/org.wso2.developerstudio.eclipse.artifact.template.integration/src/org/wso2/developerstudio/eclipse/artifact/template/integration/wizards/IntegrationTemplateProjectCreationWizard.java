/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.template.integration.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.template.integration.Activator;
import org.wso2.developerstudio.eclipse.artifact.template.integration.model.IntegrationTemplateModel;
import org.wso2.developerstudio.eclipse.artifact.template.wizards.TemplateProjectCreationWizard;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationArtifact;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class IntegrationTemplateProjectCreationWizard extends TemplateProjectCreationWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Integration Template Artifact";

    private IntegrationTemplateModel integrationTemplateModel = null;

    private IProject project;

    private List<File> fileLst = new ArrayList<File>();

    private IntegrationProjectArtifact integrationProjectArtifact;

    private String version = "1.0.0";

    public IntegrationTemplateProjectCreationWizard() {
        super();
        this.integrationTemplateModel = new IntegrationTemplateModel();
        setModel(this.integrationTemplateModel);
        setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
    }

    public boolean performFinish() {
        try {
            project = integrationTemplateModel.getTemplateSaveLocation().getProject();
            setProject(project);
            createIntegrationTemplateArtifact(integrationTemplateModel);
            if (fileLst.size() > 0) {
                openEditor(fileLst.get(0));
            }
        } catch (Exception e) {
            log.error("An unexpected error has occurred", e);
        }
        return true;
    }

    private boolean createIntegrationTemplateArtifact(IntegrationTemplateModel integrationTemplateModel) throws Exception {
        boolean isNewArtifact = true;
        IContainer location = project.getFolder("src" + File.separator + "main" + File.separator +
                                                "integration-config" + File.separator +
                                                "integration-templates");
        integrationProjectArtifact = new IntegrationProjectArtifact();
        integrationProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
        File pomfile = project.getFile("pom.xml").getLocation().toFile();
        getModel().getMavenInfo().setPackageName("integration-config/integration-template");
        if (!pomfile.exists()) {
            createPOM(pomfile);
        }

        updatePom();
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        String groupId = getMavenGroupId(pomfile);
        groupId += ".template";

        if (getModel().getSelectedOption().equals("import.template")) {// TODO
                                                                       // verify
                                                                       // this
            IFile sequence = location.getFile(new Path(getModel().getImportFile().getName()));
            if (sequence.exists()) {
                if (!MessageDialog.openQuestion(getShell(), "WARNING",
                                                "Do you like to override exsiting project in the workspace")) {
                    return false;
                }
                isNewArtifact = false;
            }
            copyImportFile(location, isNewArtifact, groupId);
        } else {
            String templateContent = "";
            String template = "";
            ArtifactTemplate selectedTemplate = integrationTemplateModel.getSelectedTemplate();
            templateContent =
                            FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());

            if (selectedTemplate.getName().equals("Sequence Template")) {
                template = createEPTemplate(templateContent, "Sequence Template");
            } else {
                template = createEPTemplate(templateContent, "");
            }

            File destFile = new File(location.getLocation().toFile(),
                                     integrationTemplateModel.getTemplateName() + ".xml");
            FileUtils.createFile(destFile, template);
            fileLst.add(destFile);
            IntegrationArtifact artifact = new IntegrationArtifact();
            artifact.setName(integrationTemplateModel.getTemplateName());
            artifact.setVersion(version);
            if ("Sequence Template".equals(selectedTemplate.getName())) {
                artifact.setType("synapse/sequenceTemplate");
                artifact.setServerRole("EnterpriseServiceBus");
                artifact.setGroupId(groupId);
                artifact.setFile(FileUtils.getRelativePath(project.getLocation().toFile(),
                                                           new File(location.getLocation().toFile(),
                                                                    integrationTemplateModel.getTemplateName() + ".xml"))
                                          .replaceAll(Pattern.quote(File.separator), "/"));
                integrationProjectArtifact.addIntegrationArtifact(artifact);
            }
            integrationProjectArtifact.toFile();
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            return true;

        }
        return true;
    }
}
