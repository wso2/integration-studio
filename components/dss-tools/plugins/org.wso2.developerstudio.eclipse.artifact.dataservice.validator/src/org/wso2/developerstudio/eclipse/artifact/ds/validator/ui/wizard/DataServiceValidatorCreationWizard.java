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

package org.wso2.developerstudio.eclipse.artifact.ds.validator.ui.wizard;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IEditorPart;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.Activator;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.model.DataServiceValidatorModel;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.template.DataServiceValidatorClassTemplate;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.utils.DSValidatorImageUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;


public class DataServiceValidatorCreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Data Service Validator";
    private static final String DS_VALIDATOR_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.artifact.ds.validator.project.nature";
	private static  DataServiceValidatorModel dsValidatorModel;
	private  IProject project;
	private IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
    public DataServiceValidatorCreationWizard(){
     setDsValidatorModel(new DataServiceValidatorModel());
     setModel(dsValidatorModel);
     setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
     setDefaultPageImageDescriptor(DSValidatorImageUtils.getInstance().getImageDescriptor("ds-validate-wizard.png"));
    }
     
    public void addPages() { 
		try {
		 super.addPages();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

 	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(page instanceof ProjectOptionsDataPage ){
				if(getModel().getSelectedOption().equalsIgnoreCase("import.validator")){
					IProject temp =dsValidatorModel.getValidatorProject();
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
			if(dsValidatorModel.getSelectedOption().equals("new.validator")){
				project = createNewProject();
				IFolder  srcFolder= ProjectUtils.getWorkspaceFolder(project, "src", "main","java");
		     	JavaUtils.addJavaSupportAndSourceFolder(project, srcFolder);
		     	
		    	/*create the new Java project*/
		     	String className = dsValidatorModel.getValidatorClass();
		     	String packageName = dsValidatorModel.getValidatorClassPackage();
		     	IJavaProject iJavaProject = JavaCore.create(project);
		     	IPackageFragmentRoot root = iJavaProject.getPackageFragmentRoot(srcFolder);
		     	IPackageFragment sourcePackage = root.createPackageFragment(packageName, false, null);
		     	
		     	/*get the validator class template*/
		     	String template = DataServiceValidatorClassTemplate.getClassTemplete(packageName, className);
				ICompilationUnit cu = sourcePackage.createCompilationUnit(className+".java", template, false, null);
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				try {
					IEditorPart javaEditor = JavaUI.openInEditor(cu);
					JavaUI.revealInEditor(javaEditor, (IJavaElement) cu);
				} catch (Exception e) { /* ignore */}
			} else{
		     project = dsValidatorModel.getValidatorProject();
			}
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("bundle");
			if(!pomfile.exists()){
				createPOM(pomfile);
				addDependancies(project);
			}
			MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
			boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
					"org.apache.felix", "maven-bundle-plugin", "2.3.4");
			if(pluginExists){
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				return true;
			}
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			ProjectUtils.addNatureToProject(project,false,
			                       DS_VALIDATOR_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							DS_VALIDATOR_PROJECT_NATURE,
							JDT_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
	    } catch (CoreException e) {
			 log.error(e);
		} catch (Exception e) {
			 log.error(e);
		}
		return true;
	}
	
	public void setDsValidatorModel(DataServiceValidatorModel dsModel) {
			dsValidatorModel = dsModel;
		}
	 
	public static DataServiceValidatorModel getCustomMediatorModel() {
		return dsValidatorModel;
	}

	
	public IResource getCreatedResource() {
		return project;
	}
	
	private void addDependancies(IProject project) throws JavaModelException {

			String[] depedencyList1 = getDepandanceyList();
			for (String libName : depedencyList1) {
				JavaUtils.addJarLibraryToProject(project,
						LibraryUtils.getDependencyPath(libName));
			}		
	}
	
	private String[] getDepandanceyList() {
		String[] depedencyList = new String[] { LibraryUtils.abdera_wso2vXX_jar, LibraryUtils.axiom_1_2_11_wso2vXX_jar,
				LibraryUtils.axis2_1_6_1_wso2vXX_jar, LibraryUtils.commons_codec_wso2vXX_jar,
				LibraryUtils.commons_httpclient_wso2vXX_jar, LibraryUtils.commons_io_wso2vXX_jar,
				LibraryUtils.commons_loggingwso2vXX_jar, LibraryUtils.geronimo_stax_api_wso2vXX_jar,
				LibraryUtils.httpcore_4_3_0_wso2vXX_jar, LibraryUtils.neethi_wso2vXX_jar,
				LibraryUtils.not_yet_commons_ssl_wso2vXX_jar, LibraryUtils.carbon_dataservices_core_xxx_jar,
				LibraryUtils.wsdl4j_wso2vXX_jar, LibraryUtils.XmlSchema_wso2vXX_jar,
				LibraryUtils.woden_1_0_0_M8_wso2vXX_jar };
		
		return depedencyList;
	}
}
