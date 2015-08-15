/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.connector.ui.wizard;

import java.io.File;
import java.util.regex.Pattern;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.connector.Activator;
import org.wso2.developerstudio.eclipse.artifact.connector.artifact.ConnectorArtifact;
import org.wso2.developerstudio.eclipse.artifact.connector.artifact.ConnectorProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.connector.model.ConnectorModel;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class AddRemoveConnectorWizard extends AbstractWSO2ProjectCreationWizard {

	private static final String GROUP_ID =".lib";
	private ConnectorModel libraryModel;
	private ConnectorWizardPage wizardPage;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private MavenProject mavenProject;
	private IProject project;

	public AddRemoveConnectorWizard() throws Exception {
		super();
		setNeedsProgressMonitor(false);
		IPath path = null;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof IAdaptable) {
				project = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
				path = project.getFullPath();
			}
		}

		if (path != null & project != null) {
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			mavenProject = MavenUtils.getMavenProject(pomfile);

			libraryModel = new ConnectorModel();
			libraryModel.setProjectName(path.lastSegment());
			File projectFile = pomfile.getParentFile();
			libraryModel.setLocation(projectFile);

			for (Object obj : mavenProject.getDependencies()) {

				Dependency dependency = (Dependency) obj;
				String artifact = dependency.getArtifactId();
				String groupID = dependency.getGroupId();
				if (groupID.equals("dummy.groupid")) {
					libraryModel.getConnectors().add(new File(projectFile.getPath() + File.separator + artifact));
				} else if (groupID.startsWith("org.wso2.carbon.")) {
					IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(artifact);
					libraryModel.getConnectors().add(resource);
				}
			}

			String fragmentHostBundleName = "";
			for (Plugin pluginDom : mavenProject.getBuild().getPlugins()) {
				String artifact = pluginDom.getArtifactId();
				if (artifact.equals("maven-bundle-plugin")) {
					Object configuration = pluginDom.getConfiguration();
					if (configuration instanceof Xpp3Dom) {
						Xpp3Dom configDom = (Xpp3Dom) configuration;
						Xpp3Dom fragmentHostNode = configDom.getChild("instructions").getChild("Fragment-Host");
						if (fragmentHostNode != null) {
							fragmentHostBundleName = fragmentHostNode.getValue();
						}
					}
				}
			}

			wizardPage = new ConnectorWizardPage(true);
			super.setModel(libraryModel);
		}
		wizardPage = new ConnectorWizardPage(true);
	}

	@Override
	public void addPages() {
		addPage(wizardPage);
	}

	@Override
	public boolean canFinish() {
		if (wizardPage != null) {
			return wizardPage.isValid();
		} else {
			return true;
		}
	}

	public boolean performFinish() {
		boolean result;
		try {
			copyConnectors();
			result = true;
		} catch (Exception e) {
			log.error("Error while copying connectors into project", e);
			MessageDialog.openError(getShell(), "Error while copying connectors into project", e.getMessage());
			result = false;
		}
		return result;
	}

	private void copyConnectors() throws Exception{
		for (Object resource : libraryModel.getConnectors()) {
			File libraryResource = null;
			if (resource instanceof File) {
				libraryResource = (File) resource;
			} else if (resource instanceof IFile) {
				libraryResource = new File(((IFile) resource).getLocation().toOSString());
			}
			if (libraryResource != null) {
				String dest = new File(project.getLocation().toFile(), libraryResource.getName()).toString();
				if (!libraryResource.toString().equals(dest)) {
					FileUtils.copyFile(libraryResource.toString(), dest);
				}
			}

			File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

			ConnectorProjectArtifact artifact = new ConnectorProjectArtifact();
			artifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

			ConnectorArtifact connectorArtifact = new ConnectorArtifact();
			String connectorName = libraryResource.getName().substring(0, libraryResource.getName().lastIndexOf("-"));
			String[] segment = libraryResource.getName().split("-");
			String version = segment[segment.length - 1].split(".zip")[0];
			connectorArtifact.setName(connectorName);
			connectorArtifact.setVersion(version);
			connectorArtifact.setType("synapse/lib");
			connectorArtifact.setServerRole("EnterpriseServiceBus");
			connectorArtifact.setGroupId(mavenProject.getGroupId() + GROUP_ID);
			connectorArtifact.setFile(FileUtils.getRelativePath(project.getLocation().toFile(),
					new File(project.getLocation().toFile(), libraryResource.getName())).replaceAll(
					Pattern.quote(File.separator), "/"));
			artifact.addESBArtifact(connectorArtifact);
			artifact.toFile();
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		}
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	@Override
	public IResource getCreatedResource() {
		return null;
	}

	public ConnectorModel getLibraryModel() {
		return libraryModel;
	}
}