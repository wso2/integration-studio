package org.wso2.developerstudio.eclipse.artifact.gadget.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.gadget.model.GadgetModel;
import org.wso2.developerstudio.eclipse.artifact.gadget.template.GadgetTemplate;
import org.wso2.developerstudio.eclipse.artifact.gadget.utils.GadgetImageUtils;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class GadgetCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String GADGET_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.artifact.gadget.project.nature";
	private GadgetModel gadgetModel;
    private  IProject project;
    private static final String GADGET_CONF_FILE = "gadget-conf.xml";
    
	public GadgetCreationWizard() {
		setGadgetModel(new GadgetModel());
		setModel(getGadgetModel());
		setWindowTitle("Create New Gadget ");
		setDefaultPageImageDescriptor(GadgetImageUtils.getInstance().getImageDescriptor("Gadget-wizard.png"));
	}
	
	public boolean performFinish(){
		try{
		File gadgetFile =null;
		if(gadgetModel.getSelectedOption().equals("new.gadget")){	
		project = createNewProject();
		IFolder gadgetResource =createWorkspaceFolder("gadget-resources");
//		JavaUtils.addJavaSupportAndSourceFolder(project,null);
		String fileName = gadgetModel.getGadgetXml().replaceAll(".xml$","")+".xml";
		createWorkspaceFolder("gadget-resources/thumb");
		gadgetFile = createProjectFile(gadgetResource, fileName,
							GadgetTemplate.createGadgetXmlTemp(project.getName()));
		createProjectFile(gadgetResource, GADGET_CONF_FILE,
				GadgetTemplate.createGadgetConf(gadgetModel));
		project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
		}
		if(gadgetModel.getSelectedOption().equals("import.gadget.fs")){
		   project = createNewProject();
//		   JavaUtils.addJavaSupportAndSourceFolder(project,null);
		   IFolder gadgetResource =createWorkspaceFolder("gadget-resources");
		   File sourceFile = new File(gadgetModel.getResourceDir());
		   FileUtils.copyDirectoryContents(sourceFile, gadgetResource.getLocation().toFile());
		   project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
		}
		if(gadgetModel.getSelectedOption().equals("import.dar")){
			project = createNewProject();
//		    JavaUtils.addJavaSupportAndSourceFolder(project,null);
		    IFolder gadgetResource =createWorkspaceFolder("gadget-resources");
		    File importFile = getModel().getImportFile();
		    ArchiveManipulator archiveManipulator = new ArchiveManipulator();
			archiveManipulator.extract(importFile, gadgetResource.getLocation().toFile());
			gadgetResource.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		}
		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("wso2/gadget");
		if(!pomfile.exists()){
			createPOM(pomfile);
			addDependancies(project);
		}
		MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);

		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.wso2.maven", "maven-gadget-plugin",
				MavenConstants.MAVEN_GADGET_PLUGIN_VERSION);
		if(pluginExists){
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			return true;
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		ProjectUtils.addNatureToProject(project,false,
		                       GADGET_PROJECT_NATURE);
		MavenUtils
		.updateWithMavenEclipsePlugin(
				pomfile,
				new String[] { },
				new String[] { GADGET_PROJECT_NATURE });
		getModel().addToWorkingSet(project);
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		
		if(gadgetModel.getSelectedOption().equals("new.gadget")){
			openEditor(gadgetFile);
		}
	}catch(Exception e){
		 return false;
		}
	 return true;
	}
	
	public void setGadgetModel(GadgetModel gadgetModel) {
		this.gadgetModel = gadgetModel;
	}

	public GadgetModel getGadgetModel() {
		return gadgetModel;
	}

	public String getProjectRelativePath() {
		String path =getModel().getLocation().getPath().substring(ResourcesPlugin.getWorkspace()
		                                                             .getRoot().getLocation()
		                                                             .toOSString().length());
		return path;
	}

	public IResource getCreatedResource() {
		// TODO Auto-generated method stub
		return null;
	}

	private File createProjectFile(IFolder folder,String fileName,String fileSource) throws IOException{
		File  file = new File(folder.getLocation().toFile(),fileName);
		FileUtils.createFile(file, fileSource);
		return file;
	}
	
	private IFolder createWorkspaceFolder(String folderName) throws CoreException {
		IFolder folder = ProjectUtils.getWorkspaceFolder(project,folderName);
		if (!folder.exists()) {
			folder.create(false, true, null);
		}
		return folder;
	}
	
	private void addDependancies(IProject project) {
		try {
			String[] depedencyList1 = getDepandanceyList();
			if(depedencyList1!=null){
				for (String libName : depedencyList1) {
					if(libName!=""){
						File dependencyPath = LibraryUtils.getDependencyPath(libName);
						JavaUtils.addJarLibraryToProject(project, dependencyPath);	
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String[] getDepandanceyList() throws Exception {
		String[] depedencyList =null;
		ResourceBundle mediatorPropetiesBundle = ResourceBundle.getBundle("gadget");
		String jarList = mediatorPropetiesBundle.getString("Plugin_dependencies");
		if(!"".equals(jarList)){
			String delimiter = ",";
		    depedencyList = jarList.split(delimiter);
		}
		return depedencyList;
	}
	
	public void openEditor(File file){
		try {
			refreshDistProjects();
			IFile resFile  = ResourcesPlugin
			.getWorkspace()
			.getRoot()
			.getFileForLocation(
					Path.fromOSString(file.getAbsolutePath()));
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),resFile);
		} catch (Exception e) { /* ignore */}
	}
}
