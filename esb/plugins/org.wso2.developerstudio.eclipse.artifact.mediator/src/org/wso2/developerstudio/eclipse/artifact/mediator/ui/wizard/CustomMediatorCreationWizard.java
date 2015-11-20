/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.mediator.ui.wizard;

import java.io.File;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
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
import org.wso2.developerstudio.eclipse.artifact.mediator.model.CustomMediatorModel;
import org.wso2.developerstudio.eclipse.artifact.mediator.template.CustomMediatorClassTemplate;
import org.wso2.developerstudio.eclipse.artifact.mediator.utils.MediatorImageUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.Activator;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class CustomMediatorCreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Mediator Artifact";
    private static final String MEDIATOR_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.artifact.mediator.project.nature";
	private  CustomMediatorModel customMediatorModel;
    private  IProject project;
    private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
    public CustomMediatorCreationWizard(){
     setCustomMediatorModel(new CustomMediatorModel());
     setModel(customMediatorModel);
     setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
     setDefaultPageImageDescriptor(MediatorImageUtils.getInstance().getImageDescriptor("new-mediator-wizard.png"));
    }
    
    public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(page instanceof ProjectOptionsDataPage ){
				if(getModel().getSelectedOption().equalsIgnoreCase("import.mediator")){
					IProject temp =customMediatorModel.getMediatorProject();
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
	    	
			if(customMediatorModel.getSelectedOption().equals("new.mediator")){
				project = createNewProject();
				IFolder  srcFolder= ProjectUtils.getWorkspaceFolder(project, "src", "main","java");
		     	JavaUtils.addJavaSupportAndSourceFolder(project, srcFolder);	     	
		     	
		    	/*create the new Java project*/
		     	String className = customMediatorModel.getMediatorClassName();
		     	String packageName = customMediatorModel.getMediatorClassPackageName();
		     	IJavaProject iJavaProject = JavaCore.create(project);
		     	IPackageFragmentRoot root = iJavaProject.getPackageFragmentRoot(srcFolder);
		     	IPackageFragment sourcePackage = root.createPackageFragment(packageName, false, null);
		     	
		     	/*get the Mediator class template*/
		     	String template = CustomMediatorClassTemplate.getClassTemplete(packageName, className);
				ICompilationUnit cu = sourcePackage.createCompilationUnit(className+".java", template, false, null);

				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				try {
					IEditorPart javaEditor = JavaUI.openInEditor(cu);
					JavaUI.revealInEditor(javaEditor, (IJavaElement) cu);
				} catch (Exception e) {
					log.error(e);
				}
			} else{
		     project = customMediatorModel.getMediatorProject();
			 project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			}
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("bundle");
			if(!pomfile.exists()){
				createPOM(pomfile);
				addDependancies(project);
			}
			MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
			boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
					"org.apache.felix", "maven-bundle-plugin",
					"2.3.4");
			if(!pluginExists){
				Plugin plugin = MavenUtils
				.createPluginEntry(mavenProject, "org.apache.felix",
						"maven-bundle-plugin", "2.3.4", true);
		
				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(plugin);
				Xpp3Dom instructionNode = MavenUtils.createXpp3Node("instructions");
				Xpp3Dom bundleSymbolicNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-SymbolicName");
				Xpp3Dom bundleNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Name");;
				Xpp3Dom exportPackageNode =
				MavenUtils.createXpp3Node(instructionNode, "Export-Package");
				Xpp3Dom dynamicImportNode = MavenUtils.createXpp3Node(
						instructionNode, "DynamicImport-Package");
				bundleSymbolicNameNode.setValue(project.getName());
				bundleNameNode.setValue(project.getName());
				if (customMediatorModel.getMediatorClassPackageName() != null
						&& !customMediatorModel.getMediatorClassPackageName()
								.trim().isEmpty()) {
					exportPackageNode.setValue(customMediatorModel.getMediatorClassPackageName());
				} else{
					IJavaProject javaProject = JavaCore.create(project);
					if (null != javaProject) {
						StringBuffer sb = new StringBuffer();
						for (IPackageFragment pkg : javaProject.getPackageFragments()) {
							if (pkg.getKind() == IPackageFragmentRoot.K_SOURCE) {
								if (pkg.hasChildren()) {
									sb.append(pkg.getElementName()).append(",");
								}
							}
						}
						exportPackageNode.setValue(sb.toString().replaceAll(",$", ""));
					}
				}
				dynamicImportNode.setValue("*");
				configurationNode.addChild(instructionNode);
				MavenUtils.saveMavenProject(mavenProject, pomfile);
			}

			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			ProjectUtils.addNatureToProject(project,false,
			                       MEDIATOR_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							MEDIATOR_PROJECT_NATURE,
							JDT_PROJECT_NATURE });
			customMediatorModel.addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
	    } catch (CoreException e) {
			 log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
		return true;
	}

	public void setCustomMediatorModel(CustomMediatorModel customMediatorModel) {
		this.customMediatorModel = customMediatorModel;
	}

	public CustomMediatorModel getCustomMediatorModel() {
		return customMediatorModel;
	}

	
	public IResource getCreatedResource() {
		return project;
	}
	
	private void addDependancies(IProject project) throws JavaModelException {
 
			String[] depedencyList1 = getDepandanceyList();
			for (String libName : depedencyList1) {
				File dependencyPath = LibraryUtils.getDependencyPath(libName);
				if(dependencyPath!=null){
					JavaUtils.addJarLibraryToProject(project,
							dependencyPath);
				}
			}
		 
	}
	
	private String[] getDepandanceyList(){
		String[] depedencyList = new String[] { LibraryUtils.abdera_wso2vXX_jar, LibraryUtils.axiom_1_2_11_wso2vXX_jar,
				LibraryUtils.axis2_1_6_1_wso2vXX_jar, LibraryUtils.commons_codec_wso2vXX_jar,
				LibraryUtils.commons_httpclient_wso2vXX_jar, LibraryUtils.commons_io_wso2vXX_jar,
				LibraryUtils.commons_loggingwso2vXX_jar, LibraryUtils.geronimo_stax_api_wso2vXX_jar,
				LibraryUtils.httpcore_4_3_0_wso2vXX_jar, LibraryUtils.neethi_wso2vXX_jar,
				LibraryUtils.not_yet_commons_ssl_wso2vXX_jar, LibraryUtils.synapse_core_2_1_2_wso2vXX_jar,
				LibraryUtils.wsdl4j_wso2vXX_jar, LibraryUtils.XmlSchema_wso2vXX_jar,
				LibraryUtils.woden_1_0_0_M8_wso2vXX_jar };
		
		return depedencyList;
	}
}
