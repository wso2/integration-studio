/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.ui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.axis2.wsdl.WSDL2Java;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.Activator;
import org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class Axis2ClientGenerationWizard extends Wizard implements INewWizard,
		IExecutableExtension {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String CLIENT_PROJECT_WIZARD_WINDOW_TITLE = "New Apache Axis2 Web Service Client";
	private static final String SKELETON_PROJECT_WIZARD_WINDOW_TITLE = "New Apache Axis2 Web Service Skeleton";
	private IStructuredSelection selection;
	private Axis2SelectWSDLPage wsdlPage;
	Axis2CodeGenerationOptionPage codeGenOptionPage;
	private Axis2ClientConfigurationPage clientConfigurationPage;
	private DataModel model;
	private String wsdlFileLocation;
	private static final int CREATE_CLIENT = 0;
	private static final int CREATE_SERVICE = 1;

	private int modelGeneratingType;
	private IPackageFragmentRoot sourceFolder;

	public int getModelGeneratingType() {
		return modelGeneratingType;
	}
	
	public void setModelGeneratingType(int modelGeneratingType) {
		this.modelGeneratingType = modelGeneratingType;
	}

	public String getWsdlFile() {
		return wsdlFileLocation;
	}

	public void setWsdlFile(String wsdlFile) {
		this.wsdlFileLocation = wsdlFile;
	}

	public Axis2ClientGenerationWizard() {
		if (model == null) {
			model = new DataModel();
		}
	}

	public Axis2ClientGenerationWizard(String wsdlFileLocation, int type,
			IPackageFragmentRoot sourceFolderLocation) {
		setWsdlFile(wsdlFileLocation);
		setModelGeneratingType(type);
		this.sourceFolder = sourceFolderLocation;
		if (model == null) {
			model = new DataModel();
		}
	}

	private class CodegenJob implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			boolean createServicesXML = model.isGenerateServerSideCode();
			model.setGenerateServicedescriptor(createServicesXML);
			String operationText = "Generating Client Side Code";
			if (model.isGenerateServerSideCode()) {
				operationText = "Generating Server Side Code";
			}
			monitor.beginTask(operationText, 100);
			monitor.subTask("Processing configuration...");
			String[] parameterArray = Axis2ParametersUtils
					.getParameterArray(Axis2ParametersUtils
							.getParameterList(model));
			monitor.worked(10);
			try {
				monitor.subTask("Generating code...");
				WSDL2Java.main(parameterArray);
				monitor.worked(75);
				monitor.subTask("Adding dependent libraries to the project...");
				JavaUtils.addJarLibraryToProject(model.getSelectedProject(),
						LibraryUtils
								.getDependencyPath(LibraryUtils.axis2_1_6_1_wso2vXX_jar));
				JavaUtils.addJarLibraryToProject(model.getSelectedProject(),
						LibraryUtils
								.getDependencyPath(LibraryUtils.axiom_1_2_11_wso2vXX_jar));
				monitor.worked(10);
				monitor.subTask("Refreshing project...");
				model.getSelectedProject().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
				monitor.worked(5);
				monitor.done();
				if (createServicesXML) {
					if (MessageDialog
							.openQuestion(getShell(), "Axis2 service",
									"Do you want to create an axis2 service out of the generated skeleton class?")) {
						createAxis2Artifact(model, monitor);
					}
				}
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
		}

	}

	public boolean performFinish() {
		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
				getShell());
		progressMonitorDialog.create();
		progressMonitorDialog.open();
		try {
			progressMonitorDialog.run(false, false, new CodegenJob());
		} catch (Exception e) {
			log.error(e);
			MessageDialog.openError(getShell(), "Generate code",
					"Error in performing the operations:" + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean canFinish() {
		if (clientConfigurationPage.isDataPopulated()) {
			return true;
		}
		return false;

	}

	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return super.needsPreviousAndNextButtons();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		model = new DataModel();
	}

	public void addPages() {

		if (wsdlFileLocation == null) {
			wsdlPage = new Axis2SelectWSDLPage("Select WSDL", model);
			wsdlPage.setImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor("axis2-wizard.png"));
			addPage(wsdlPage);
		} else {
			model.setWsdlURI(wsdlFileLocation);
		}
		if (sourceFolder != null) {
			model.setSourceFolder(sourceFolder.getPath().toPortableString()
					.substring(1));
			model.setSelectedProject(sourceFolder.getJavaProject().getProject());
		}
		// model.addDataEventListener(clientOptionPage);
		String codeGenOptionPageTitle = "Web Service Client";
		String clientConfigOptionPageTitle = "Client Configuration";
		String windowTitle = CLIENT_PROJECT_WIZARD_WINDOW_TITLE;

		if (getModelGeneratingType() == CREATE_CLIENT) {
			model.setGenerateServerSideCode(false);
		} else {
			codeGenOptionPageTitle = "Web Service Skeleton";
			clientConfigOptionPageTitle = "Axis2 Service Skeleton Generation";
			windowTitle = SKELETON_PROJECT_WIZARD_WINDOW_TITLE;

			model.setGenerateServerSideCode(true);
		}

		setWindowTitle(windowTitle);
		codeGenOptionPage = new Axis2CodeGenerationOptionPage(
				codeGenOptionPageTitle, sourceFolder, model,
				modelGeneratingType);
		codeGenOptionPage.setImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor("axis2-wizard.png"));

		clientConfigurationPage = new Axis2ClientConfigurationPage(
				clientConfigOptionPageTitle, model);
		clientConfigurationPage.setImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor("axis2-wizard.png"));

		addPage(codeGenOptionPage);
		addPage(clientConfigurationPage);
	}

	private void createAxis2Artifact(DataModel model, IProgressMonitor monitor)
			throws CoreException, Exception {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				getShell(), new WorkbenchLabelProvider(),
				new CAppProjectSelectionDialog());
		dialog.setTitle("Select Carbon Application project to create the Axis2 Service");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setHelpAvailable(false);
		while (dialog.open() == Window.OK) {
			Object element = dialog.getFirstResult();
			if (element instanceof IProject) {
				// IProject project= (IProject)element;

				// String artifactName = model.getServiceName();
				// String artifactVersion = "1.0.0";

				monitor.beginTask("Create Axis2 service...", 100);
				monitor.subTask("Create resources directory...");
				// File generatedResourceDir =
				// model.getSelectedProject().getFolder("resources").getLocation().toFile();
				// File servicesXML = new
				// File(generatedResourceDir,"services.xml");
				// String serviceClassNameFromFile =
				// Axis2ServiceUtils.getServiceClassNameFromServicesXML(servicesXML);
				monitor.worked(10);
				// Axis2Artifact axis2Artifact = new
				// Axis2Artifact(model.getSelectedProject(),artifactName,serviceClassNameFromFile);
				// ITemporaryFileTag createNewTempTag =
				// FileUtils.createNewTempTag();
				// File resourceDir=FileUtils.createTempDirectory();
				// File tempDirectory = FileUtils.createTempDirectory();
				// File manifestLocation = axis2Artifact.updateMETAINF(new
				// File(resourceDir,"resources"));
				monitor.worked(10);
				// FileUtils.copyDirectoryContents(generatedResourceDir,
				// manifestLocation);
				monitor.worked(20);
				// File archiveFile = new
				// File(tempDirectory,artifactName+".service");
				// axis2Artifact.writeServiceInformation(archiveFile);
				// String archiveFilePath=archiveFile.toString();
				monitor.worked(10);
				monitor.subTask("Generating CApp artifact...");
				// IFile file =
				// project.getFolder(artifactName).getFile("artifact.xml");
				// Artifact artifact = new Artifact(file);
				// artifact.setName(artifactName);
				// artifact.setType(Axis2ArtifactHandler.getType());
				// artifact.setVersion(artifactVersion);
				// artifact.setServerRole(CAppEnvironment.getDefaultServerRole().getServerRoleName());
				// artifact.setFile(archiveFilePath);
				// monitor.worked(10);
				// cAppManager.createArtifact(file, artifact, resourceDir);
				// createNewTempTag.clearAndEnd();
				monitor.worked(40);
				monitor.done();
			}
			break;
		}
	}

	private class CAppProjectSelectionDialog implements ITreeContentProvider {

		public Object[] getChildren(Object parent) {
			if (parent instanceof IWorkspaceRoot) {
				IWorkspaceRoot root = (IWorkspaceRoot) parent;
				List<IProject> children = new ArrayList<IProject>();
				IProject[] projects = root.getProjects();
				for (IProject project : projects) {
					if (project.isOpen()) {
						children.add(project);
					}
				}
				return children.toArray();
			}
			return new Object[] {};
		}

		public Object getParent(Object arg0) {
			return null;
		}

		public boolean hasChildren(Object parent) {
			return getChildren(parent).length > 0;
		}

		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		public void dispose() {
		}

		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		}

	}

	public Axis2SelectWSDLPage getWsdlPage() {
		return wsdlPage;
	}

	public Axis2ClientConfigurationPage getClientConfigurationPage() {
		return clientConfigurationPage;
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(nextPage!=null){
			nextPage.setImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor("axis2-wizard.png"));
		}
		// if (page instanceof Axis2GenerateClientOptionPage){
		// // if (clientOptionPage.getSourceFolder()==null){
		// // clientOptionPage.setSourceFolder(sourceFolder);
		// // clientOptionPage.update(null, null);
		// // }
		// }

		if (nextPage instanceof Axis2ClientConfigurationPage) {
			((Axis2ClientConfigurationPage) nextPage).update();
		}
		return nextPage;
	}

	public void setInitializationData(IConfigurationElement arg0, String arg1,
			Object arg2) throws CoreException {
		setModelGeneratingType(Integer.parseInt(((Map) arg2).get("type")
				.toString()));
	}
}
