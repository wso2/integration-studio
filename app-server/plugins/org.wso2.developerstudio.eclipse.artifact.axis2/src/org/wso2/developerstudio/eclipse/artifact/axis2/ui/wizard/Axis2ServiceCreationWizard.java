/*
 * Copyright (c) 2011 - 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.axis2.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.axis2.wsdl.WSDL2Java;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.axis2.Activator;
import org.wso2.developerstudio.eclipse.artifact.axis2.model.Axis2Model;
import org.wso2.developerstudio.eclipse.artifact.axis2.model.DataModel;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ParametersUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class Axis2ServiceCreationWizard  extends AbstractWSO2ProjectCreationWizard {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String AXIS2_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.axis2.project.nature";
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Axis2 Service Project";
	private Axis2Model axis2Model;
	private Axis2ConfigurationPage wsdlConfigurationPage;
	private DataModel dataModel;
	private IWizardPage[] pages;

	public Axis2ServiceCreationWizard(){
		dataModel = new DataModel();
		setAxis2Model(new Axis2Model());
		setModel(getAxis2Model());
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor("axis2-wizard.png"));
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
	}

	public boolean performFinish() {
		IFile axis2GenServiceXML =null;
		try {
			IProject project = createNewProject();
			IFolder sourceFolder =ProjectUtils.getWorkspaceFolder(project, "src", "main", "java");
			JavaUtils.addJavaSupportAndSourceFolder(project, sourceFolder);
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("service/axis2");
			createPOM(pomfile);
			getModel().addToWorkingSet(project);
			ProjectUtils.addNatureToProject(project,
											false,
			                                AXIS2_PROJECT_NATURE);
			MavenUtils
					.updateWithMavenEclipsePlugin(
							pomfile,
							new String[] { JDT_BUILD_COMMAND},
							new String[] {
									AXIS2_PROJECT_NATURE,
									JDT_PROJECT_NATURE});

			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			if (getModel().getSelectedOption().equals("import.Axis2")) {
				//TODO: import AAR

			} else if (getModel().getSelectedOption().equals("new.Axis2")) {
				String className =  axis2Model.getServiceClass();
				String packageName = axis2Model.getPackageName();

				IJavaProject javaProject = JavaCore.create(project);
			    IFolder resourceFolder = ProjectUtils.getWorkspaceFolder(project, "src", "main", "resources");
			    if(!resourceFolder.exists()){
			    	resourceFolder.create(false, true, null);
			    }

				IFolder metaFolder = ProjectUtils.getWorkspaceFolder(project, "src", "main", "resources","META-INF");
				 if(!metaFolder.exists()){
					 metaFolder.create(false, true, null);
				 }
				IFile serviceXML = metaFolder.getFile("services.xml");
				createServiceXML(serviceXML,className,packageName.concat(".").concat(className));
				IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
				IPackageFragment sourcePackage = root.createPackageFragment(packageName, false, null);
				StringBuffer buffer = new StringBuffer();
				if(!packageName.equalsIgnoreCase("")){
					buffer.append("package " + packageName + ";\n");
					buffer.append("\n");
				}
				buffer.append("public class " + className +"{\n\n}" );
				ICompilationUnit compilationUnit = sourcePackage.createCompilationUnit(className+".java", buffer.toString(), false, null);
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				IPath path = compilationUnit.getResource().getProjectRelativePath();
				IFile sourceFile = project.getFile(path);
				try {
					refreshDistProjects();
					IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),sourceFile);
				} catch (Exception e) {
					log.error("Cannot open file in editor", e);
				}
			}
			else if (getModel().getSelectedOption().equals("import.Axis2wsdl")) {
				ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(getShell());
				IFolder mainFolder =ProjectUtils.getWorkspaceFolder(project, "src", "main");
				dataModel.setSourceFolder("java");
				dataModel.setGeneratedCodeLocation(mainFolder.getRawLocation().toPortableString());
				dataModel.setSelectedProject(project);
				progressMonitorDialog.create();
				progressMonitorDialog.open();
				progressMonitorDialog.run(false, false, new CodegenJob());

				IFolder resourceFolder = ProjectUtils.getWorkspaceFolder(project, "src", "main", "resources");
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				IFolder metaFolder = resourceFolder.getFolder("META-INF");
				if(!metaFolder.exists()){
					metaFolder.create(false, true, null);
				}
				axis2GenServiceXML = resourceFolder.getFile("services.xml");
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				if(axis2GenServiceXML.exists()){
					IFile metaServiceXML = metaFolder.getFile("services.xml");
					FileUtils.copy(axis2GenServiceXML.getLocation().toFile(), metaServiceXML.getLocation().toFile());
					project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
					//axis2GenServiceXML.delete(true, new NullProgressMonitor());
				}
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				refreshDistProjects();
			}

			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (IOException e) {
			log.error("I/O error has occurred", e);
		} catch (InvocationTargetException e) {
			log.error("An error occurred while generating codes", e.getTargetException());
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}

    private void createServiceXML(IFile serviceXML, String serviceName, String serviceClass) {
        String serviceXMLContent = "<service name=\"" + serviceName + "\">\n" +
                "\t<description>\n" +
                "\t\tPlease Type your service description here\n" +
                "\t</description>\n" +
                "\t<messageReceivers>\n" +
                "\t\t<messageReceiver class=\"org.apache.axis2.rpc.receivers.RPCInOnlyMessageReceiver\" " +
                "mep=\"http://www.w3.org/2004/08/wsdl/in-only\"/>\n" +
                "\t\t<messageReceiver class=\"org.apache.axis2.rpc.receivers.RPCMessageReceiver\" " +
                "mep=\"http://www.w3.org/2004/08/wsdl/in-out\"/>\n" +
                "\t</messageReceivers>\n" +
                "\t<parameter locked=\"false\" name=\"ServiceClass\">" + serviceClass + "</parameter>\n" +
                "</service>\n";
        try {
            serviceXML.create(new ByteArrayInputStream(serviceXMLContent.getBytes()), true, new NullProgressMonitor());
        } catch (CoreException e) {
            log.error("Error occurred while creating services.xml file for Axis2 service, service name : "
                    + serviceName + ", service class : " + serviceClass, e);
        }
    }

	private class CodegenJob implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			dataModel.setGenerateServicedescriptor(true);
			String operationText="Generating server side code";
			monitor.beginTask(operationText, 100);
			monitor.subTask("Processing configuration...");
			String[] parameterArray = Axis2ParametersUtils
					.getParameterArray(Axis2ParametersUtils.getParameterList(dataModel));
			monitor.worked(10);
			try {
				monitor.subTask("Generating code...");
				WSDL2Java.main(parameterArray);
				monitor.worked(75);
				monitor.subTask("Adding dependent libraries to the project...");
				JavaUtils.addJarLibraryToProject(dataModel.getSelectedProject(), LibraryUtils.getDependencyPath(LibraryUtils.axis2_1_6_1_wso2vXX_jar));
				JavaUtils.addJarLibraryToProject(dataModel.getSelectedProject(), LibraryUtils.getDependencyPath(LibraryUtils.axiom_1_2_11_wso2vXX_jar));
				monitor.worked(10);
				monitor.subTask("Refreshing project...");
				dataModel.getSelectedProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				monitor.worked(5);
				monitor.done();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
		}

	}

	public void setAxis2Model(Axis2Model axis2Model) {
		this.axis2Model = axis2Model;
	}

	public Axis2Model getAxis2Model() {
		return axis2Model;
	}

	public void addPages() {
		wsdlConfigurationPage = new Axis2ConfigurationPage("Axis2 Service Configuration", dataModel);
		super.addPages();
		addPage(wsdlConfigurationPage);
		pages = getPages();
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(page instanceof ProjectOptionsDataPage ){
			if(getModel().getSelectedOption().equalsIgnoreCase("import.Axis2wsdl")){
				dataModel.setWsdlURI(getModel().getImportFile().getAbsolutePath());
				dataModel.setGenerateServerSideCode(true);
				nextPage = wsdlConfigurationPage;
				wsdlConfigurationPage.populateParamsFromWSDL();
			}
		}
		if(page instanceof Axis2ConfigurationPage ){
			nextPage = pages[2];
		}
		if(page instanceof MavenDetailsPage ){
				nextPage = null;
		}
		return nextPage;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getPreviousPage(page);
		if(page instanceof MavenDetailsPage ){
			if(getModel().getSelectedOption().equalsIgnoreCase("import.Axis2wsdl")){
				previousPage = wsdlConfigurationPage;
			}
		}
		if(page instanceof Axis2ConfigurationPage ){
			previousPage = pages[1];
		}
		return previousPage;
	}

	public IResource getCreatedResource() {
		// TODO Auto-generated method stub
		return null;
	}

}
