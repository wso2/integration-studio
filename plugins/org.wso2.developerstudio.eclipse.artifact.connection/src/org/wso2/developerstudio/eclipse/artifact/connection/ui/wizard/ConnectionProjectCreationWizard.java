package org.wso2.developerstudio.eclipse.artifact.connection.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class ConnectionProjectCreationWizard extends LocalEntryProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Connection Artifact";

	private ConnectionModel connectionModel;
	private IntegrationProjectArtifact integrationProjectArtifact;
	private List<File> fileLst = new ArrayList<File>();
	private IProject project;
	private String version = "1.0.0";

	public ConnectionProjectCreationWizard() {
	    super();
		this.connectionModel = new ConnectionModel();
		setModel(this.connectionModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		// TODO
		// setDefaultPageImageDescriptor(LocalEntryImageUtils.getInstance().getImageDescriptor("local-entries-wizard-artifact.png"));
	}

	public boolean createConnectionArtifact(ConnectionModel connectionModel) throws Exception {
		this.connectionModel = connectionModel;
		boolean isNewArtifact = true;
		IContainer location = project.getFolder("src" + File.separator + "main" + File.separator + "integration-config"
				+ File.separator + "connections");

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
			artifact.setFile(
					FileUtils
							.getRelativePath(project.getLocation().toFile(),
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
