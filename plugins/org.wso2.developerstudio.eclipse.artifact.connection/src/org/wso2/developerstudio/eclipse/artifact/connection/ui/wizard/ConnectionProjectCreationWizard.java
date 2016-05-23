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

package org.wso2.developerstudio.eclipse.artifact.connection.ui.wizard;

import java.io.File;
import java.util.regex.Pattern;

import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.connection.Activator;
import org.wso2.developerstudio.eclipse.artifact.connection.model.ConnectionModel;
import org.wso2.developerstudio.eclipse.artifact.localentry.ui.wizard.LocalEntryProjectCreationWizard;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationArtifact;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ConnectionProjectCreationWizard extends LocalEntryProjectCreationWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Connection Artifact";

    private ConnectionModel connectionModel;
    private IntegrationProjectArtifact integrationProjectArtifact;
    private IProject project;
    private String version = "1.0.0";

    public ConnectionProjectCreationWizard() {
        super();
        this.connectionModel = new ConnectionModel();
        setModel(this.connectionModel);
        setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
    }

    public boolean createConnectionArtifact(ConnectionModel connectionModel) throws Exception {
        this.connectionModel = connectionModel;
        boolean isNewArtifact = true;
        IContainer location = project.getFolder("src" + File.separator + "main" + File.separator +
                                                "integration-config" + File.separator +
                                                "connections");

        updatePom();
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        File pomLocation = project.getFile("pom.xml").getLocation().toFile();
        String groupId = getMavenGroupId(pomLocation);
        groupId += ".local-entry";

        // Adding the metadata about the localentry to the metadata store.
        integrationProjectArtifact = new IntegrationProjectArtifact();
        integrationProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

        if (getModel().getSelectedOption().equals("import.localentry")) {
            IFile connectionFile = location.getFile(new Path(getModel().getImportFile().getName()));
            if (connectionFile.exists()) {
                if (!MessageDialog.openQuestion(getShell(), "WARNING",
                                                "Do you like to override exsiting project in the workspace")) {
                    return false;
                }
                isNewArtifact = false;
            }
            copyImportFile(location, isNewArtifact, groupId);

        } else {
            File connectionFile = new File(location.getLocation().toFile(),
                                           connectionModel.getLocalENtryName() + ".xml");
            writeTemplete(connectionFile);

            IntegrationArtifact artifact = new IntegrationArtifact();
            artifact.setName(connectionModel.getLocalENtryName());
            artifact.setVersion(version);
            artifact.setType("synapse/local-entry");
            artifact.setServerRole("EnterpriseServiceBus");
            artifact.setGroupId(groupId);
            artifact.setFile(FileUtils.getRelativePath(project.getLocation().toFile(),
                                                       new File(location.getLocation().toFile(),
                                                                connectionModel.getLocalENtryName() + ".xml"))
                                      .replaceAll(Pattern.quote(File.separator), "/"));
            integrationProjectArtifact.addIntegrationArtifact(artifact);
        }
        File pomfile = project.getFile("pom.xml").getLocation().toFile();
        getModel().getMavenInfo().setPackageName("synapse/local-entry");
        if (!pomfile.exists()) {
            createPOM(pomfile);
        }

        integrationProjectArtifact.toFile();
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        return true;
    }

    public void setProject(IProject project) {
        super.setProject(project);
        this.project = project;
    }

}
