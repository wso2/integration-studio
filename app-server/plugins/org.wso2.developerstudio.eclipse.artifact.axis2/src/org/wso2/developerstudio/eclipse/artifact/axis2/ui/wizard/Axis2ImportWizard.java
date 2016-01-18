package org.wso2.developerstudio.eclipse.artifact.axis2.ui.wizard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.wsdl.WSDL2Java;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.artifact.axis2.model.DataModel;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ParametersUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class Axis2ImportWizard extends Wizard implements INewWizard{


	private IStructuredSelection selection;
	private Axis2ImportWizardPage axisImportWizardPage;
	private Axis2ConfigurationPage configurationPage;
	private IProject activeProject;
	private DataModel dataModel;
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Axis2 Class";
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.dataModel = new DataModel();
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
        setDefaultPageImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor(
                Axis2ParametersUtils.AXIS2_WIZARD_IMAGE));
	}
	
	public void addPages() {
		configurationPage = new Axis2ConfigurationPage("import wsdl page", dataModel);
		axisImportWizardPage = new Axis2ImportWizardPage(dataModel,configurationPage);
		addPage(axisImportWizardPage);
		addPage(configurationPage);
	} 
	
	public boolean performFinish() {
		try {
			IResource resource = (IResource)selection.getFirstElement();
	        activeProject = resource.getProject();
	        ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(getShell());
	        IFolder mainFolder =ProjectUtils.getWorkspaceFolder(activeProject, "src", "main");
			dataModel.setSourceFolder("java");
			dataModel.setGeneratedCodeLocation(mainFolder.getRawLocation().toPortableString());
			dataModel.setSelectedProject(activeProject);
			progressMonitorDialog.create();
			progressMonitorDialog.open();
			progressMonitorDialog.run(false, false, new CodegenJob());
			activeProject.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			IFolder resourceFolder = ProjectUtils.getWorkspaceFolder(activeProject, "src", "main", "resources");
			activeProject.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			IFolder metaFolder = resourceFolder.getFolder("META-INF");
			if(!metaFolder.exists()){
				metaFolder.create(false, true, null);
			}
			IFile axis2GenServiceXML = resourceFolder.getFile("services.xml");
			activeProject.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			if(axis2GenServiceXML.exists()){
				IFile metaServiceXML = metaFolder.getFile("services.xml");
				if(metaServiceXML.exists()){
					 File serviceXml = metaServiceXML.getLocation().toFile();
					 File newServiceXml = axis2GenServiceXML.getLocation().toFile();
					 OMElement serviceGroup = this.readServiceXml(serviceXml);
					 serviceGroup.addAttribute("name", activeProject.getName(), null);
					 OMElement newService = this.readServiceXml(newServiceXml).getFirstElement();
					 serviceGroup.addChild(newService);
					 this.writeToXml(serviceGroup, serviceXml);
				}else{
					FileUtils.copy(axis2GenServiceXML.getLocation().toFile(), metaServiceXML.getLocation().toFile());	
				}
				axis2GenServiceXML.delete(true, null);
				activeProject.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
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
	
	
	private OMElement readServiceXml(File serviceXml) throws FileNotFoundException, XMLStreamException{
		 FileInputStream stream = new FileInputStream(serviceXml);
		 OMElement documentElement = new StAXOMBuilder(stream).getDocumentElement();
		 return documentElement;
	}
	
	private void writeToXml(OMElement Service,File path) throws IOException, XMLStreamException{
		 XMLOutputFactory xof = XMLOutputFactory.newInstance();	   
        FileWriter fstream = new FileWriter(path);
        BufferedWriter out = new BufferedWriter(fstream);
        XMLStreamWriter writer = xof.createXMLStreamWriter(out);
        Service.serialize(writer);
        writer.flush();
}
	
} 
