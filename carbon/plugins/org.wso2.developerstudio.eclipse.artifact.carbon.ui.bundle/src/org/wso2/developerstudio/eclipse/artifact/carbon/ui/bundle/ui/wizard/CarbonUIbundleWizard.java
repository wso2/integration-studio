/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.Activator;
import org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.model.CarbonUiModel;
import org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.templates.CarbonUIbudleTemplate;
import org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.utils.CarbonUIImageUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsPage;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class CarbonUIbundleWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Carbon UI Bundle";
	private static final String CARBON_UI_BUNDLE_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.project.nature";
    private static final String CARBON_UI_BUNDLE_WIZARD_IMAGE = "carbon-ui-bundle-wizard.png";
	private static CarbonUiModel uibundleModel;
	private  IProject project;
	private Map<String, Text> controlersMap ;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private String projectName="";
	
	public CarbonUIbundleWizard() {
		setUibundleModel(new CarbonUiModel());
		setModel(uibundleModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
        setDefaultPageImageDescriptor(CarbonUIImageUtils.getInstance()
                .getImageDescriptor(CARBON_UI_BUNDLE_WIZARD_IMAGE));
	}
       
    public void executeListener(){	
    	try{
    		 controlersMap = getMap();
    	    	if(controlersMap!=null){
    	            ModifyListener listener = new ModifyListener() {
    	       	      public void modifyText(ModifyEvent e) {
    	       	       String curprojectName = ((Text)e.widget).getText();	  
    	       	       if(!projectName.equals(curprojectName)){
    	       	    	   Text activator = controlersMap.get("Activator");       	       
    	          	       Text id = controlersMap.get("Id*");
    	          	       Text name = controlersMap.get("Name");
    	          	       Text path = controlersMap.get("Deploy Path*");
    	          	       
    	          	       String actiatorName =projectName+".Activator";
    	          	       if(actiatorName.equals(activator.getText())){
    	          	    	 activator.setText(curprojectName+".Activator"); 
    	          	       }
    	          	       if(projectName.equals(id.getText())){
    	          	    	 id.setText(curprojectName);
    	          	       }
    	          	       if(projectName.equals(name.getText())){
    	          	    	 name.setText(curprojectName);
    	          	       }
    	          	       String oldpath = "web/customui/"+projectName;
    	          	       if(oldpath.equals(path.getText())){
    	          	    	 path.setText("web/customui/"+curprojectName);
    	          	       }        
    	       	    	   projectName = curprojectName;
    	       	       }   
    	       	      }
    	       	    };
    	    	Text projectName = controlersMap.get("Project Name*");
    	    	       if(projectName!=null){
    	    			projectName.addModifyListener(listener);
    	    	    }
    	    	}
    	}catch (Exception e) {
			 log.error("add execution Linstner"+e);
		}
    }
    
    public IWizardPage getNextPage(IWizardPage page) {	    
	   IWizardPage currentPage = super.getContainer().getCurrentPage();
	   if(currentPage instanceof ProjectOptionsPage){	
			executeListener(); 
		}
		
	  IWizardPage nextPage = super.getNextPage(page);
		if(page instanceof ProjectOptionsDataPage ){
		
				if(getModel().getSelectedOption().equalsIgnoreCase("import.uibundle")){
					IProject temp =uibundleModel.getCarbonUIproject();
					File pomfile = temp.getFile("pom.xml").getLocation().toFile();
					if(!pomfile.exists()){
				      try {
				    	  getModel().setMavenInfo(new MavenInfo("org.wso2.carbon." + temp.getName(),temp.getName(),
				    			  "1.0.0"));
					      getModel().setProjectName(temp.getName());
					} catch (Exception e) {
						log.error("project update fail",e);
					}
					}else{					    
					   nextPage=null;
					}
				}
		}
		return nextPage;
	}
    
	public boolean performFinish(){
	    try {
			if(uibundleModel.getSelectedOption().equals("new.uibundle")){
				project = createNewProject();
				IFolder  srcFolder= ProjectUtils.getWorkspaceFolder(project, "src");
		     	JavaUtils.addJavaSupportAndSourceFolder(project, srcFolder);
		     	ProjectUtils.createFolder(srcFolder);
		     	
		     	if(uibundleModel.isActivatorRequired()){
		     		String className = uibundleModel.getActivatorClassName();
		     		if(".Activator".equals(className)){
		     			className = "Activator";
		     			uibundleModel.setActivatorClassName(className);
		     		}
		     		className = getClassName(uibundleModel.getActivatorClassName());
		     		String packageName = getPackageName(uibundleModel.getActivatorClassName());
			     	IJavaProject iJavaProject = JavaCore.create(project);
			     	IPackageFragmentRoot root = iJavaProject.getPackageFragmentRoot(srcFolder);
			     	IPackageFragment sourcePackage = root.createPackageFragment(packageName, false, null);
			     	String template = CarbonUIbudleTemplate.createActivatorClassTemplete(packageName, className);
					sourcePackage.createCompilationUnit(className+".java", template, false, null);
		     	}
		     	/*create Meta INF Folder data*/
				IFolder metaInf = this.createWorkspaceFolder("META-INF");
				String componentXmlSource = CarbonUIbudleTemplate.createComponentXMLTemplate();
				createProjectFile(metaInf, "component.xml", componentXmlSource);
				String metaInfSource = CarbonUIbudleTemplate.createManifestFileTemplate(uibundleModel);
				createProjectFile(metaInf, "MANIFEST.MF", metaInfSource);
			    IFolder webDir = createDirectoryhierarchy(uibundleModel.getDeployPath()); 
			    IFolder cssDir = webDir.getFolder("css");
			    cssDir.create(true, true, new NullProgressMonitor());
			    IFolder imgDir = webDir.getFolder("images");
			    imgDir.create(true, true, new NullProgressMonitor());
			    IFolder jsDir = webDir.getFolder("js");
			    jsDir.create(true, true, new NullProgressMonitor());
			    
			    copyResourceFiles(cssDir.getLocation().toFile(), "menu.css");
			    copyResourceFiles(webDir.getLocation().toFile(), "index.jsp");
			    
			    project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			} else{
		      project = uibundleModel.getCarbonUIproject();
			}
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("bundle");
			if(!pomfile.exists()){
				createPOM(pomfile);		
			}
			addDependancies(project);
			MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
			Dependency dependencies = new Dependency();
			dependencies.setGroupId("org.eclipse.osgi");
			dependencies.setArtifactId("org.eclipse.osgi");
			dependencies.setVersion("3.7.0.v20110613");
			MavenUtils.addMavenDependency(mavenProject, dependencies);	
			mavenProject.getBuild().setSourceDirectory("src");
			MavenUtils.saveMavenProject(mavenProject, pomfile);

			boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
					"org.apache.felix", "maven-bundle-plugin", "2.3.4");
			if(pluginExists){
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				return true;
			}
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			ProjectUtils.addNatureToProject(project,false,
			                       CARBON_UI_BUNDLE_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							CARBON_UI_BUNDLE_PROJECT_NATURE,
							JDT_PROJECT_NATURE });
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			try {
				refreshDistProjects();
				IFile activatorClassForProject = getManifestFileForProject(project);
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),activatorClassForProject);
			} catch (Exception e) {
				log.error("Cannot open file in editor", e);
			}
	    } catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		return true;
	}
		
	private void copyResourceFiles (File dir, String resourceName) throws Exception{
		String content = CarbonUIbudleTemplate.createTemplete(resourceName);
		File resourceFile = new File(dir, resourceName);
		FileUtils.createFile(resourceFile, content);
		
	}
	
	private IFile getManifestFileForProject(IProject project) throws JavaModelException{
		List<File> manifestFileList = new ArrayList<File>();
		File[] manifestFiles = FileUtils.getAllExactMatchingFiles(project.getLocation().toString(), "MANIFEST", "MF", manifestFileList);
		for (File manifest : manifestFiles) {
			String relativePath = FileUtils.getRelativePath(project.getLocation().toFile(), manifest);
			IFile sourceFile = project.getFile(relativePath);
//			boolean isClassImplemented = JavaUtils.isClassImplement(project, "BundleActivator");
//			if(isClassImplemented){
			return sourceFile;
		}
		return null;
	}
	
	private String getClassName(String fullyQualifiedClassName){
		return (fullyQualifiedClassName.lastIndexOf('.') > 0)?fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf('.')+1):fullyQualifiedClassName;
	}
	
	private String getPackageName(String fullyQualifiedClassName){
		return (fullyQualifiedClassName.lastIndexOf('.') > 0)?fullyQualifiedClassName.substring(0,fullyQualifiedClassName.lastIndexOf('.')):"";
	}

	private IFolder createDirectoryhierarchy(String path) throws CoreException {
		 StringBuffer buff = new StringBuffer();
		 String delimiter = "/";
		 String[]  temp =path.split(delimiter);
		 IFolder folder = null;
		  for(int i =0; i < temp.length ; i++){
			  buff.append(temp[i]);
			  folder = project.getFolder(buff.toString()); 
			  if(!folder.exists()){
				  folder.create(true, true, new NullProgressMonitor());
				  buff.append("/");
			  }
			  
		  }
		  if(folder != null){
			  return folder;
		  }
		  return null;
		  
	}
	
	public static CarbonUiModel getUibundleModel() {
		return uibundleModel;
	}

	public void setUibundleModel(CarbonUiModel uiModel) {
		uibundleModel = uiModel;
	}
	
	public IResource getCreatedResource() {
		return project;
	}
	
	private void createProjectFile(IFolder folder,String fileName,String fileSource) throws IOException{
		File  metaInf = new File(folder.getLocation().toFile(),fileName);
		FileUtils.createFile(metaInf, fileSource);
	}
	
	private IFolder createWorkspaceFolder(String folderName) throws CoreException {
		IFolder folder = ProjectUtils.getWorkspaceFolder(project,folderName);
		if (!folder.exists()) {
			folder.create(false, true, null);
		}
		return folder;
	}
	
	private void addDependancies(IProject project) throws JavaModelException {
 
			String[] depedencyList1 = getDepandanceyList();
			for (String libName : depedencyList1) {
				File dependencyPath = LibraryUtils.getDependencyPath(libName);
				JavaUtils.addJarLibraryToProject(project, dependencyPath);
			}
		 
	}
	
	private String[] getDepandanceyList(){
		String[] depedencyList = new String[] { LibraryUtils.eclips_osgi_xxx_jar};
		return depedencyList;
	}
}
