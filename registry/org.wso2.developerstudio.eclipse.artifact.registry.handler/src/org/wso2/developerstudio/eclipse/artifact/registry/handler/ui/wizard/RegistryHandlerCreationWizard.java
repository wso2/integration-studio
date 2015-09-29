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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.model.RegistryHandlerModel;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.FilterCreationOptionsWizardPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.HandlerMethodsInfoPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.ImportFilterClassWizardPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.ImportHandlerClassWizardPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.ImportHandlerJarWizardPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.NewFilterClassWizardPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages.NewHandlerClassWizardPage;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerImageUtils;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.PropertyData;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.JavaCodeFormatter;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.RegistryHandlerUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.maven.util.ProjectDependencyConstants;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils.WSO2JavaMethod;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class RegistryHandlerCreationWizard extends
		AbstractWSO2ProjectCreationWizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Registry Handler Artifact";
	private static final String ACTIVATOR_FQN= "org.osgi.framework.BundleActivator";
	private NewHandlerClassWizardPage newHandlerClassWizardPage;
	private ImportHandlerClassWizardPage importHandlerClassWizardPage;
	private NewFilterClassWizardPage newFilterClassWizardPage;
	private ImportFilterClassWizardPage importFilterClassWizardPage;
	private HandlerMethodsInfoPage handlerMethodsInfoPage;
	private FilterCreationOptionsWizardPage filterCreationOptionsWizardPage;
	private ImportHandlerJarWizardPage importHandlerJarWizardPage;
	private IWizardPage[] pages;
	private RegistryHandlerModel regModel;
	private IProject project;
	private IFolder sourceFolder;
	private IJavaProject javaProject;
	private IPackageFragmentRoot root;
	private String handlerClass;
	private String handlerPackageName;
	private String fullyQualifiedHandlerClassName;
	private String fullyQualifiedFilterClassName;
	private String filterClass;
	private String filterPackageName;
	private String handlerSelectedMethod;
	private String filterClassSelectedMethod;
	private List<String> selectedHandlerMethods;
	private Map<String, PropertyData> filterProperties;
	private Map<String, PropertyData> handlerProperties;
	private boolean isResourceImported = false;
	private boolean isCollectionImported = false;
	private boolean isAssociationImported = false;
	private boolean isCommentImported = false;
	private boolean isTaggedResourcePathImported = false;
	private boolean isTagImported = false;
	private IPackageFragment handlerSourcePackage;
	private IPackageFragment filterSourcePackage;
	private String activatorPackageName = "org.wso2.custom.internal.registry.handler";
	private IPackageFragment activatorSourcePackage;
	private final String BUNDLE_ACTIVATOR_NAME = "org.wso2.custom.internal.registry.handler.Activator";
	private IProject importHandlerProject;
	private boolean importHandlerFromWs;
	
	public RegistryHandlerCreationWizard() {
		regModel = new RegistryHandlerModel();
		setFilterModel(regModel);
		setModel(getFilterModel());
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(HandlerImageUtils.getInstance().getImageDescriptor("registry-handler-wizard.png"));
	}

	public IResource getCreatedResource() {
		return null;
	}

	public boolean performFinish() {
		try {
				project = createNewProject();
				sourceFolder =ProjectUtils.getWorkspaceFolder(project, "src", "main", "java");
				javaProject = JavaCore.create(project);
				root = javaProject.getPackageFragmentRoot(sourceFolder);
				JavaUtils.addJavaSupportAndSourceFolder(project, sourceFolder);
//				IFolder resourcesDir = ProjectUtils.getWorkspaceFolder(project, "src", "main", "resources");
//				if(!resourcesDir.exists()){
//					resourcesDir.create(false, true, null);
//				}
				javaProject = JavaCore.create(project);
				boolean isImportJar = regModel.getHandlerClassSeletionMethod().equals(Constants.IMPORT_HANDLER_CLASS_FROM_FS_TEXT);
				
				if(isImportJar){
					IFile distFile = project.getFile(regModel.getExternalJar().getName());
					FileUtils.copy(regModel.getExternalJar(), distFile.getLocation().toFile());
					IClasspathEntry prjEntry = JavaCore.newLibraryEntry(distFile.getLocation(), null, null);
					IClasspathEntry[] classPath = javaProject.getRawClasspath();
					int classPathCount = classPath.length;
					IClasspathEntry[] newClassPath =  new IClasspathEntry[classPathCount+1];
					System.arraycopy(classPath, 0, newClassPath, 0, classPathCount);
					newClassPath[classPathCount] = prjEntry;
					javaProject.setRawClasspath(newClassPath, null);
					File pomfile = project.getFile("pom.xml").getLocation().toFile();
					getModel().getMavenInfo().setPackageName("bundle");
					if (!pomfile.exists()) {
						createPOM(pomfile);
					}
					ProjectUtils.addNatureToProject(project, false, Constants.REGISTRY_HANDLER_PROJECT_NATURE);
					MavenUtils
					.updateWithMavenEclipsePlugin(
							pomfile,
							new String[] { JDT_BUILD_COMMAND },
							new String[] {
									Constants.REGISTRY_HANDLER_PROJECT_NATURE,
									JDT_PROJECT_NATURE });
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
					updatePom(project);
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} else{
					handlerSelectedMethod = regModel.getHandlerClassSeletionMethod();
					if (handlerSelectedMethod.equals(Constants.NEW_HANDLER_CLASS_TEXT)) {
						handlerClass = newHandlerClassWizardPage.getClassName();
						handlerPackageName = newHandlerClassWizardPage.getPackageName();
						fullyQualifiedHandlerClassName = handlerPackageName + "." + handlerClass;
					} else if (handlerSelectedMethod.equals(Constants.IMPORT_HANDLER_CLASS_FROM_WS_TEXT)) {
						fullyQualifiedHandlerClassName = importHandlerClassWizardPage.getHandlerClassName();
						importHandlerFromWs = true;
						importHandlerProject =
						                       getKeyByValue(regModel.getImportHandlerList(),
						                                     fullyQualifiedHandlerClassName);
					}
					addDependencies(project);
					generateHandler();
				}
			
				
        } catch (Exception e) {
        	MessageDialog.openError(getShell(), "Registry Handler Artifact",
        	    					"Unable to create registry handler project: " + project.getName());
        	log.error("Error occured while creating the Registry Handler Project "+ project.getName(), e);
        	
        }

		return true;
	}
	
	private void generateHandler() throws Exception {
		selectedHandlerMethods = handlerMethodsInfoPage.getSelectedMethods();
		handlerProperties = handlerMethodsInfoPage.getHandlerPropertyMap();

		filterClassSelectedMethod = filterCreationOptionsWizardPage.getFilterClassCreationMethod();

		if (filterClassSelectedMethod.equals(Constants.NEW_FILTER_CLASS)) {
			filterClass = newFilterClassWizardPage.getClassName();
			filterPackageName = newFilterClassWizardPage.getPackageName();
			fullyQualifiedFilterClassName = filterPackageName + "." + filterClass;
			filterProperties = newFilterClassWizardPage.getFilterMap();
		} else if (filterClassSelectedMethod.equals(Constants.FROM_EXISTING_FILTER_CLASS)) {
			fullyQualifiedFilterClassName = importFilterClassWizardPage.getClassName();
			String filterProject =
			                       importFilterClassWizardPage.getProject(fullyQualifiedFilterClassName);
			filterProperties = importFilterClassWizardPage.getFilterMap();
			addFilterProjectDependency(filterProject);
		}

		HandlerInfo handlerInfo = new HandlerInfo();
		handlerInfo.setHandlerClass(fullyQualifiedHandlerClassName);
		handlerInfo.setFilterClass(fullyQualifiedFilterClassName);
		handlerInfo.setSelectedMethods(selectedHandlerMethods);

		Map<String, PropertyData> propertyMap = handlerProperties;
		for (String propertyName : propertyMap.keySet()) {
			PropertyData propertyData = propertyMap.get(propertyName);
			handlerInfo.addHandlerProperty(propertyName, propertyData.type, propertyData.data);
		}
		propertyMap = filterProperties;
		for (String propertyName : propertyMap.keySet()) {
			PropertyData propertyData = propertyMap.get(propertyName);
			handlerInfo.addFilterProperty(propertyName, propertyData.type, propertyData.data);
		}

		if (handlerPackageName != null) {
			handlerSourcePackage = root.createPackageFragment(handlerPackageName, false, null);
			handlerSourcePackage.createCompilationUnit(handlerClass + ".java",
			                                           JavaCodeFormatter.format(getHandlerClassSource(handlerPackageName,
			                                                                                          handlerClass),
			                                                                    javaProject),
			                                           false, null);

		}
		if (filterPackageName != null) {
			filterSourcePackage = root.createPackageFragment(filterPackageName, false, null);
			filterSourcePackage.createCompilationUnit(filterClass + ".java",
			                                          JavaCodeFormatter.format(getFilterClassSource(filterPackageName,
			                                                                                        filterClass),
			                                                                   javaProject), false,
			                                          null);
		}

		IType javaITypeForClass = null;
		propertyMap = handlerInfo.getHandlerProperties();
		String projectName = regModel.getProjectName();
		if (projectName != null && !projectName.equalsIgnoreCase("")) {
			javaITypeForClass =
			                    JavaUtils.getJavaITypeForClass(JavaCore.create(ResourcesPlugin.getWorkspace()
			                                                                                  .getRoot()
			                                                                                  .getProject(projectName)),
			                                                   handlerInfo.getHandlerClass());
			if (javaITypeForClass != null) {
				for (String propertyName : propertyMap.keySet()) {
					PropertyData propertyData = propertyMap.get(propertyName);
					WSO2JavaMethod method = new WSO2JavaMethod();
					method.setModifier("public");
					method.setReturnType(null);
					method.setElementName(JavaUtils.getSetMethod(propertyName));
					propertyName =
					               propertyName.matches("^\\d+") ? ("var" + propertyName)
					                                            : propertyName;
					method.addParameter(propertyName + "Value",
					                    propertyData.type == DataType.STRING
					                                                        ? "String"
					                                                        : "org.apache.axiom.om.OMElement");
					method.addMethodCode("//TODO add property set code");
					JavaUtils.addMethod(javaITypeForClass, method);
				}
			}
		}

		javaITypeForClass = null;
		propertyMap = handlerInfo.getFilterProperties();
		// projectName = regModel.getProjectName();
		if (!handlerInfo.getFilterClass()
		                .equals("org.wso2.carbon.registry.core.jdbc.handlers.filters.MediaTypeMatcher") &&
		    !handlerInfo.getFilterClass()
		                .equals("org.wso2.carbon.registry.core.jdbc.handlers.filters.URLMatcher")) {
			// if (projectName != null && !projectName.equalsIgnoreCase("")) {
			javaITypeForClass =
			                    JavaUtils.getJavaITypeForClass(JavaCore.create(ResourcesPlugin.getWorkspace()
			                                                                                  .getRoot()
			                                                                                  .getProject(projectName)),
			                                                   handlerInfo.getFilterClass());
			if (javaITypeForClass != null) {
				for (String propertyName : propertyMap.keySet()) {
					PropertyData propertyData = propertyMap.get(propertyName);
					WSO2JavaMethod method = new WSO2JavaMethod();
					method.setModifier("public");
					method.setReturnType(null);
					method.setElementName(JavaUtils.getSetMethod(propertyName));
					method.addParameter(propertyName + "Value",
					                    propertyData.type == DataType.STRING
					                                                        ? "String"
					                                                        : "org.apache.axiom.om.OMElement");
					method.addMethodCode("//TODO add property set code");
					JavaUtils.addMethod(javaITypeForClass, method);
				}
			}
		}

		javaITypeForClass = null;
		projectName = regModel.getProjectName();
		if (projectName != null && !projectName.equalsIgnoreCase("")) {
			javaITypeForClass =
			                    JavaUtils.getJavaITypeForClass(JavaCore.create(ResourcesPlugin.getWorkspace()
			                                                                                  .getRoot()
			                                                                                  .getProject(projectName)),
			                                                   handlerInfo.getHandlerClass());
			if (javaITypeForClass != null) {

				if (!handlerInfo.getSelectedMethods().isEmpty()) {
					javaITypeForClass.getCompilationUnit()
					                 .createImport("org.wso2.carbon.registry.core.exceptions.RegistryException",
					                               null, new NullProgressMonitor());
					javaITypeForClass.getCompilationUnit()
					                 .createImport("org.wso2.carbon.registry.core.jdbc.handlers.RequestContext",
					                               null, new NullProgressMonitor());
				}
				for (String selectedMethod : handlerInfo.getSelectedMethods()) {
					overrideMethods(selectedMethod, javaITypeForClass);
				}
			}
		}

		createRegInfo(project, handlerInfo);
		IFolder handlerActivatorPackage = createSourceLocationForActivator(project);
		RegistryHandlerUtils.getActivatorJavaClass(handlerActivatorPackage.getLocation().toFile(),
		                                           handlerInfo);

		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("bundle");
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}
		ProjectUtils.addNatureToProject(project, false, Constants.REGISTRY_HANDLER_PROJECT_NATURE);

		updatePom(project, handlerInfo);
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		try {
			refreshDistProjects();
			IFile openFile = project.getFile("registry-handler-info.xml");
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
			               openFile);
		} catch (Exception e) { /* ignore */
		}

	}
	
	private void addFilterProjectDependency(String filterProjectName) {
		// import filter class case
		try {
			IJavaProject javaProject = JavaCore.create(project);
			IClasspathEntry[] classPath = javaProject.getRawClasspath();

			List<IClasspathEntry> classPathList =
			                                      new ArrayList<IClasspathEntry>(
			                                                                     Arrays.asList(classPath));
			IClasspathEntry prjEntry =
			                           JavaCore.newProjectEntry(new Path(
			                                                             "/".concat(filterProjectName)),
			                                                    true);
			classPathList.add(prjEntry);
			IClasspathEntry[] newClassPath = new IClasspathEntry[classPathList.size()];
			classPathList.toArray(newClassPath);
			javaProject.setRawClasspath(newClassPath, null);
		} catch (Exception e) {
			log.error("Error occured while adding filter project dependency", e);
		}
	}

	public IFolder createSourceLocationForActivator(IProject project) throws JavaModelException, CoreException{
		IFolder workspaceFolder = ProjectUtils.getWorkspaceFolder(sourceFolder, "org", "wso2", "custom", "internal", "registry", "handler");
		activatorSourcePackage = root.createPackageFragment(activatorPackageName, false, null);
		activatorSourcePackage.createCompilationUnit("Activator.java", "", false, null);

		return workspaceFolder;
	}
	
	private void createRegInfo(IProject project, HandlerInfo handlerInfo) throws IOException{
		File regInfoFile = project.getFile("registry-handler-info.xml").getLocation().toFile();
		handlerInfo.toFile(regInfoFile);
	}
	
	private String getHandlerClassSource(String packageName, String className){
		StringBuffer buffer = new StringBuffer();
		if(!packageName.equalsIgnoreCase("")){
		buffer.append("package " + packageName + ";\n");
		buffer.append("\n");
		}
		buffer.append("import org.wso2.carbon.registry.core.exceptions.RegistryException;\n");
		buffer.append("import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;\n");
		buffer.append("import org.wso2.carbon.registry.core.jdbc.handlers.Handler;\n");
		buffer.append("\n");
		buffer.append("public class " + className +" extends Handler{\n\n" );

		buffer.append("\n}");
		return buffer.toString();
	} 
	
	private String getFilterClassSource(String packageName, String className){
		StringBuffer buffer = new StringBuffer();
		if(!packageName.equalsIgnoreCase("")){
		buffer.append("package " + packageName + ";\n");
		buffer.append("\n");
		}
		buffer.append("import org.wso2.carbon.registry.core.exceptions.RegistryException;\n");
		buffer.append("import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;\n");
		buffer.append("import org.wso2.carbon.registry.core.jdbc.handlers.filters.Filter;\n");
		buffer.append("\n");
		buffer.append("public class " + className +" extends Filter{\n\n" );

		buffer.append("\t\n");
		buffer.append("\tpublic boolean handleDelete(RequestContext requestContext)\n");
		buffer.append("\t\t\tthrows RegistryException {\n");
		buffer.append("\t\t// TODO Implement your logic here\n");
		buffer.append("\t\treturn false;\n");
		buffer.append("\t}\n\n");

		buffer.append("\t\n");
		buffer.append("\tpublic boolean handleGet(RequestContext requestContext)\n");
		buffer.append("\t\t\tthrows RegistryException {\n");
		buffer.append("\t\t// TODO Implement your logic here\n");
		buffer.append("\t\treturn false;\n");
		buffer.append("\t}\n\n");

		buffer.append("\t\n");
		buffer.append("\tpublic boolean handleImportChild(RequestContext requestContext)\n");
		buffer.append("\t\t\tthrows RegistryException {\n");
		buffer.append("\t\t// TODO Implement your logic here\n");
		buffer.append("\treturn false;\n");
		buffer.append("\t}\n\n");

		buffer.append("\t\n");
		buffer.append("\tpublic boolean handleImportResource(RequestContext requestContext)\n");
		buffer.append("\t\tthrows RegistryException {\n");
		buffer.append("\t\t// TODO Implement your logic here\n");
		buffer.append("\treturn false;\n");
		buffer.append("\t}\n\n");

		buffer.append("\t\n");
		buffer.append("\tpublic boolean handlePut(RequestContext requestContext)\n");
		buffer.append("\t\t\tthrows RegistryException {\n");
		buffer.append("\t\t// TODO Implement your logic here\n");
		buffer.append("\treturn false;\n");
		buffer.append("\t}\n\n");

		buffer.append("\t\n");
		buffer.append("\tpublic boolean handlePutChild(RequestContext requestContext)\n");
		buffer.append("\t\t\tthrows RegistryException {\n");
		buffer.append("\t\t// TODO Implement your logic here\n");
		buffer.append("\treturn false;\n");
		buffer.append("\t}\n\n");

		buffer.append("\n}");
		return buffer.toString();
	} 

	
	private void addDependencies(IProject project) throws Exception {

		String[] depedencyList = new String[] { LibraryUtils.abdera_wso2vXX_jar, LibraryUtils.axiom_1_2_11_wso2vXX_jar,
				LibraryUtils.axis2_1_6_1_wso2vXX_jar, LibraryUtils.commons_codec_wso2vXX_jar,
				LibraryUtils.commons_httpclient_wso2vXX_jar, LibraryUtils.commons_io_wso2vXX_jar,
				LibraryUtils.commons_loggingwso2vXX_jar, LibraryUtils.geronimo_stax_api_wso2vXX_jar,
				LibraryUtils.httpcore_4_3_0_wso2vXX_jar, LibraryUtils.neethi_wso2vXX_jar,
				LibraryUtils.not_yet_commons_ssl_wso2vXX_jar, LibraryUtils.carbon_registry_api_xxx_jar,
				LibraryUtils.carbon_registry_core_xxx_jar, LibraryUtils.wsdl4j_wso2vXX_jar,
				LibraryUtils.XmlSchema_wso2vXX_jar, LibraryUtils.woden_1_0_0_M8_wso2vXX_jar,
				LibraryUtils.eclips_osgi_xxx_jar };
		
			for (String dependency : depedencyList) {
				JavaUtils.addJarLibraryToProject(project,
						LibraryUtils.getDependencyPath(dependency));
			}
			if (importHandlerFromWs  && importHandlerProject!=null ) {
				try {
					IJavaProject javaProject = JavaCore.create(project);
					IClasspathEntry[] classPath = javaProject.getRawClasspath();
					IClasspathEntry prjEntry = JavaCore.newProjectEntry(new Path("/".concat(importHandlerProject.getName())), true); 
					int classPathCount = classPath.length;
					IClasspathEntry[] newClassPath =  new IClasspathEntry[classPathCount+1];
					System.arraycopy(classPath, 0, newClassPath, 0, classPathCount);
					newClassPath[classPathCount] = prjEntry;
					javaProject.setRawClasspath(newClassPath, null);
				} catch (Exception ignored) {/*ignored*/}
			}
	}

	public void setFilterModel(RegistryHandlerModel filterModel) {
		this.regModel = filterModel;
	}

	public RegistryHandlerModel getFilterModel() {
		return regModel;
	}
	
	public void addPages() {
		newHandlerClassWizardPage = new NewHandlerClassWizardPage("New Handler Class", regModel);
		importHandlerClassWizardPage = new ImportHandlerClassWizardPage("Import Handler Class", regModel);
		handlerMethodsInfoPage = new HandlerMethodsInfoPage("Handler Methods");
		filterCreationOptionsWizardPage = new FilterCreationOptionsWizardPage("Filter Class Creation Methods");
		newFilterClassWizardPage = new NewFilterClassWizardPage("New Filter Class", filterCreationOptionsWizardPage);
		importFilterClassWizardPage = new ImportFilterClassWizardPage("Import Filter Class");
		importHandlerJarWizardPage = new ImportHandlerJarWizardPage("Import Handler from File System", regModel);
		
		super.addPages();
		addPage(newHandlerClassWizardPage);
		addPage(importHandlerClassWizardPage);
		addPage(handlerMethodsInfoPage);
		addPage(filterCreationOptionsWizardPage);
		addPage(importFilterClassWizardPage);
		addPage(newFilterClassWizardPage);
		addPage(importHandlerJarWizardPage);
		
		pages = getPages();
		
		
		
	}
	
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (page instanceof ProjectOptionsDataPage) {
			if(regModel.getHandlerClassSeletionMethod().equals(Constants.NEW_HANDLER_CLASS_TEXT)){
				nextPage = newHandlerClassWizardPage;
			}else if(regModel.getHandlerClassSeletionMethod().equals(Constants.IMPORT_HANDLER_CLASS_FROM_FS_TEXT)){
				nextPage = importHandlerJarWizardPage;
			}
			else{
				nextPage = importHandlerClassWizardPage;
			}
		}else if(page instanceof NewHandlerClassWizardPage || page instanceof ImportHandlerClassWizardPage){
			nextPage = handlerMethodsInfoPage;
		}else if(page instanceof HandlerMethodsInfoPage){
			nextPage = filterCreationOptionsWizardPage;
		}else if(page instanceof FilterCreationOptionsWizardPage){
			if(filterCreationOptionsWizardPage.getFilterClassCreationMethod().equals(Constants.FROM_EXISTING_FILTER_CLASS)){
				nextPage = importFilterClassWizardPage;
			}else{
				nextPage = newFilterClassWizardPage;
			}
			
		}else if(page instanceof ImportFilterClassWizardPage || page instanceof NewFilterClassWizardPage|| page instanceof ImportHandlerJarWizardPage){
			nextPage = pages[1];
		}else if(page instanceof MavenDetailsPage ){
			nextPage=null;

		}
		return nextPage;
	}
	
	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getPreviousPage(page);
		if (page instanceof MavenDetailsPage) {
			if(filterCreationOptionsWizardPage.getFilterClassCreationMethod().equals(Constants.FROM_EXISTING_FILTER_CLASS)){
				previousPage = importFilterClassWizardPage;
			}else if(filterCreationOptionsWizardPage.getFilterClassCreationMethod().equals(Constants.IMPORT_HANDLER_CLASS_FROM_WS_TEXT)){
				previousPage = importHandlerJarWizardPage;
			}else{
				previousPage = newFilterClassWizardPage;
			}
		}
		if (page instanceof ImportFilterClassWizardPage || page instanceof NewFilterClassWizardPage) {
			previousPage = filterCreationOptionsWizardPage;
		}
		if(page instanceof FilterCreationOptionsWizardPage){
			if(regModel.getHandlerClassSeletionMethod().equals(Constants.NEW_HANDLER_CLASS_TEXT)){
				previousPage = newHandlerClassWizardPage;
			}else if(regModel.getHandlerClassSeletionMethod().equals(Constants.IMPORT_HANDLER_CLASS_FROM_WS_TEXT)){
				previousPage = importHandlerClassWizardPage;
			}
		}
		
		return previousPage;
	}
	
	public void overrideMethods(String key, IType javaITypeForClass) throws JavaModelException {

		WSO2JavaMethod method = new WSO2JavaMethod();
		method.setModifier("public");

		String methodName = null;
		String methodCode = null;

		if ("PUT".equals(key)) {
			methodName = "put";
			methodCode = "super.put(requestContext);";
			method.setReturnType(null);
		}

		else if ("PUT_CHILD".equals(key)) {
			methodName = "putChild";
			methodCode = "super.putChild(requestContext);";
			method.setReturnType(null);
		}

		else if ("COPY".equals(key)) {
			methodName = "copy";
			methodCode = "return super.copy(requestContext);";
			method.setReturnType("String");
		}

		else if ("MOVE".equals(key)) {
			methodName = "move";
			methodCode = "return super.move(requestContext);";
			method.setReturnType("String");
		}

		else if ("DELETE".equals(key)) {
			methodName = "delete";
			methodCode = "super.delete(requestContext);";
			method.setReturnType(null);
		}

		else if ("RENAME".equals(key)) {
			methodName = "rename";
			methodCode = "return super.rename(requestContext);";
			method.setReturnType("String");
		}

		else if ("GET".equals(key)) {
			methodName = "get";
			methodCode = "return super.get(requestContext);";
			method.setReturnType("Resource");
			if (!isResourceImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Resource", null,
						new NullProgressMonitor());
				isResourceImported = true;
			}
		}

		else if ("RESOURCE_EXISTS".equals(key)) {
			methodName = "resourceExists";
			methodCode = "return super.resourceExists(requestContext);";
			method.setReturnType("boolean");
		}

		else if ("IMPORT_CHILD".equals(key)) {
			methodName = "importChild";
			methodCode = "super.importChild(requestContext);";
			method.setReturnType(null);
		}

		else if ("IMPORT".equals(key)) {
			methodName = "importResource";
			methodCode = "super.importResource(requestContext);";
			method.setReturnType(null);
		}

		else if ("ADD_ASSOCIATION".equals(key)) {
			methodName = "addAssociation";
			methodCode = "super.addAssociation(requestContext);";
			method.setReturnType(null);
		}

		else if ("ADD_COMMENT".equals(key)) {
			methodName = "addComment";
			methodCode = "return super.addComment(requestContext);";
			method.setReturnType("String");
		}

		else if ("APPLY_TAG".equals(key)) {
			methodName = "applyTag";
			methodCode = "super.applyTag(requestContext);";
			method.setReturnType(null);
		}

		else if ("CREATE_LINK".equals(key)) {
			methodName = "createLink";
			methodCode = "super.createLink(requestContext);";
			method.setReturnType(null);
		}

		else if ("CREATE_VERSION".equals(key)) {
			methodName = "createVersion";
			methodCode = "super.createVersion(requestContext);";
			method.setReturnType(null);
		}

		else if ("DUMP".equals(key)) {
			methodName = "dump";
			methodCode = "super.dump(requestContext);";
			method.setReturnType(null);
		}

		else if ("EDIT_COMMENT".equals(key)) {
			methodName = "editComment";
			methodCode = "super.editComment(requestContext);";
			method.setReturnType(null);
		}

		else if ("EXECUTE_QUERY".equals(key)) {
			methodName = "executeQuery";
			methodCode = "return super.executeQuery(requestContext);";
			method.setReturnType("Collection");
			if (!isCollectionImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Collection", null,
						new NullProgressMonitor());
				isCollectionImported = true;
			}
		}

		else if ("GET_ALL_ASSOCIATIONS".equals(key)) {
			methodName = "getAllAssociations";
			methodCode = "return super.getAllAssociations(requestContext);";
			method.setReturnType("Association[]");
			if (!isAssociationImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Association", null,
						new NullProgressMonitor());
				isAssociationImported = true;
			}
		}

		else if ("GET_ASSOCIATIONS".equals(key)) {
			methodName = "getAssociations";
			methodCode = "return super.getAssociations(requestContext);";
			method.setReturnType("Association[]");
			if (!isAssociationImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Association", null,
						new NullProgressMonitor());
				isAssociationImported = true;
			}
		}

		else if ("GET_AVERAGE_RATING".equals(key)) {
			methodName = "getAverageRating";
			methodCode = "return super.getAverageRating(requestContext);";
			method.setReturnType("float");
		}

		else if ("GET_COMMENTS".equals(key)) {
			methodName = "getComments";
			methodCode = "return super.getComments(requestContext);";
			method.setReturnType("Comment[]");
			if (!isCommentImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Comment", null,
						new NullProgressMonitor());
				isCommentImported = true;
			}
		}

		else if ("GET_RESOURCE_PATHS_WITH_TAG".equals(key)) {
			methodName = "getResourcePathsWithTag";
			methodCode = "return super.getResourcePathsWithTag(requestContext);";
			method.setReturnType("TaggedResourcePath[]");
			if (!isTaggedResourcePathImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.TaggedResourcePath",
						null, new NullProgressMonitor());
				isTaggedResourcePathImported = true;
			}
		}

		else if ("GET_TAGS".equals(key)) {
			methodName = "getTags";
			methodCode = "return super.getTags(requestContext);";
			method.setReturnType("Tag[]");
			if (!isTagImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Tag", null,
						new NullProgressMonitor());
				isTagImported = true;
			}
		}

		else if ("GET_VERSIONS".equals(key)) {
			methodName = "getVersions";
			methodCode = "return super.getVersions(requestContext);";
			method.setReturnType("String[]");
		}

		else if ("REMOVE_LINK".equals(key)) {
			methodName = "removeLink";
			methodCode = "super.removeLink(requestContext);";
			method.setReturnType(null);
		}

		else if ("RATE_RESOURCE".equals(key)) {
			methodName = "rateResource";
			methodCode = "super.rateResource(requestContext);";
			method.setReturnType(null);
		}

		else if ("REMOVE_ASSOCIATION".equals(key)) {
			methodName = "removeAssociation";
			methodCode = "super.removeAssociation(requestContext);";
			method.setReturnType(null);
		}

		else if ("REMOVE_COMMENT".equals(key)) {
			methodName = "removeComment";
			methodCode = "super.removeComment(requestContext);";
			method.setReturnType(null);
		}

		else if ("REMOVE_TAG".equals(key)) {
			methodName = "removeTag";
			methodCode = "super.removeTag(requestContext);";
			method.setReturnType(null);
		}

		else if ("RESTORE".equals(key)) {
			methodName = "restore";
			methodCode = "super.restore(requestContext);";
			method.setReturnType(null);
		}

		else if ("RESTORE_VERSION".equals(key)) {
			methodName = "restoreVersion";
			methodCode = "super.restoreVersion(requestContext);";
			method.setReturnType(null);
		}

		else if ("SEARCH_CONTENT".equals(key)) {
			methodName = "searchContent";
			methodCode = "return super.searchContent(requestContext);";
			method.setReturnType("Collection");
			if (!isCollectionImported) {
				javaITypeForClass.getCompilationUnit().createImport("org.wso2.carbon.registry.core.Collection", null,
						new NullProgressMonitor());
				isCollectionImported = true;
			}
		}

		else if ("INVOKE_ASPECT".equals(key)) {
			methodName = "invokeAspect";
			methodCode = "super.invokeAspect(requestContext);";
			method.setReturnType(null);
		}

		else if ("GET_RATING".equals(key)) {
			methodName = "getRating";
			methodCode = "return super.getRating(requestContext);";
			method.setReturnType("int");
		}

		method.setElementName(methodName);
		method.addParameter("requestContext", "RequestContext");
		method.addExceptionType("RegistryException");
		method.addMethodCode("// TODO Auto-generated method stub");
		method.addMethodCode(methodCode);
		JavaUtils.addMethod(javaITypeForClass, method);
	}
	
	public boolean canFinish() {
		IWizardPage currentPage = getContainer().getCurrentPage();
		if (currentPage instanceof ImportHandlerClassWizardPage){
			String handlerClassName = importHandlerClassWizardPage.getHandlerClassName();
			if (handlerClassName == null || "".equals(handlerClassName))
				return false;
			else
				return true;
		} else if (currentPage instanceof ImportHandlerJarWizardPage){
			if (regModel.getExternalJar() == null || !regModel.getExternalJar().exists())
				return false;
			else
				return true;
		} else if (currentPage instanceof HandlerMethodsInfoPage) {
			return true;
		} else if (currentPage instanceof FilterCreationOptionsWizardPage) {
			if(filterCreationOptionsWizardPage.getFilterClassCreationMethod().equals(Constants.FROM_EXISTING_FILTER_CLASS)) {
				return true;
			}
			return false;
		} else if (currentPage instanceof NewFilterClassWizardPage) {
			return !("".equalsIgnoreCase(newFilterClassWizardPage.getPackageName()) || "".equalsIgnoreCase(newFilterClassWizardPage.getClassName()));
		} else if(currentPage instanceof ImportFilterClassWizardPage || currentPage instanceof ImportHandlerJarWizardPage) {
			return true;
		} else if(currentPage instanceof MavenDetailsPage) {
			return true;
		}
		return super.canFinish();
	}
	
	public void updatePom(IProject project) throws Exception {
		File mavenProjectPomLocation = project.getFile("pom.xml")
				.getLocation().toFile();
		MavenProject mavenProject = MavenUtils
				.getMavenProject(mavenProjectPomLocation);
		StringBuffer sb=new StringBuffer();
		String activatorClass=new String(); 
		
		Properties properties = mavenProject.getModel().getProperties();
		properties.put("CApp.type", "lib/registry/handlers");
		mavenProject.getModel().setProperties(properties);
		
		Plugin plugin = MavenUtils
				.createPluginEntry(mavenProject, "org.apache.felix",
						"maven-bundle-plugin", "2.3.4", true);
		
		
		// getting export packages
		IPackageFragmentRoot rootPkg = JavaCore.createJarPackageFragmentRootFrom(project.getFile(regModel.getExternalJar().getName()));
		
		for (IJavaElement item : rootPkg.getChildren()) {
			if (item instanceof IPackageFragment) {
				IPackageFragment pkg = (IPackageFragment) item;
				if (pkg.hasChildren()) {
					sb.append(pkg.getElementName()).append(",");
					for (IClassFile clazz : pkg.getClassFiles()) {
						IType type = clazz.getType();
						if (type.getSuperInterfaceNames().length > 0 &&
						    Arrays.asList(type.getSuperInterfaceNames()).contains(ACTIVATOR_FQN)) {
							activatorClass = type.getFullyQualifiedName();
						}
					}
				}
			}
		}
		String exportedPackageList = sb.toString().replaceAll(",$", "");
		
		
		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(plugin);
		Xpp3Dom instructionNode = MavenUtils.createXpp3Node("instructions");
		Xpp3Dom bundleSymbolicNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-SymbolicName");
		Xpp3Dom bundleNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Name");
		Xpp3Dom bundleActivatorNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Activator");
		Xpp3Dom exportPackageNode = MavenUtils.createXpp3Node(instructionNode, "Export-Package");
		Xpp3Dom dynamicImportNode = MavenUtils.createXpp3Node(instructionNode, "DynamicImport-Package");
		bundleSymbolicNameNode.setValue(project.getName());
		bundleNameNode.setValue(project.getName());
		bundleActivatorNode.setValue(activatorClass);
	    exportPackageNode.setValue(exportedPackageList);
		dynamicImportNode.setValue("*");
		
		configurationNode.addChild(instructionNode);

		Repository repo = new Repository();
		repo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-maven2-repository-1");

		mavenProject.getModel().addRepository(repo);
		mavenProject.getModel().addPluginRepository(repo);

		List<Dependency> dependencyList = new ArrayList<Dependency>();

			Dependency dependency = new Dependency();
			dependency.setArtifactId(regModel.getExternalJar().getName());
			dependency.setGroupId("dummy.groupid");
			dependency.setVersion("1.0.0");
			dependency.setScope("system");
			dependency.setSystemPath("${basedir}/" + regModel.getExternalJar().getName());
			dependencyList.add(dependency);
			dependencyList.add(dependency);
		
		MavenUtils.addMavenDependency(mavenProject, dependencyList);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

	}
	
	public void updatePom(IProject project, HandlerInfo handlerInfo) throws Exception {
		File mavenProjectPomLocation = project.getFile("pom.xml")
				.getLocation().toFile();
		MavenProject mavenProject = MavenUtils
				.getMavenProject(mavenProjectPomLocation);
		
		Properties properties = mavenProject.getModel().getProperties();
		properties.put("CApp.type", "lib/registry/handlers");
		mavenProject.getModel().setProperties(properties);
		
		Plugin plugin = MavenUtils
				.createPluginEntry(mavenProject, "org.apache.felix",
						"maven-bundle-plugin", "2.3.4", true);
		
		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(plugin);
		Xpp3Dom instructionNode = MavenUtils.createXpp3Node("instructions");
		Xpp3Dom bundleSymbolicNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-SymbolicName");
		Xpp3Dom bundleNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Name");
		Xpp3Dom bundleActivatorNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Activator");
		Xpp3Dom exportPackageNode = MavenUtils.createXpp3Node(instructionNode, "Export-Package");
		Xpp3Dom dynamicImportNode = MavenUtils.createXpp3Node(instructionNode, "DynamicImport-Package");
		bundleSymbolicNameNode.setValue(project.getName());
		bundleNameNode.setValue(project.getName());
		bundleActivatorNode.setValue(BUNDLE_ACTIVATOR_NAME);
		exportPackageNode.setValue(getExportedPackage(handlerInfo));
		dynamicImportNode.setValue("*");
		configurationNode.addChild(instructionNode);

		Repository repo = new Repository();
		repo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-maven2-repository-1");

		mavenProject.getModel().addRepository(repo);
		mavenProject.getModel().addPluginRepository(repo);

		List<Dependency> dependencyList = new ArrayList<Dependency>();

		Map<String, JavaLibraryBean> dependencyInfoMap = JavaLibraryUtil
				.getDependencyInfoMap(project);
		Map<String, String> map = ProjectDependencyConstants.DEPENDENCY_MAP;
		for (JavaLibraryBean bean : dependencyInfoMap.values()) {
			if (bean.getVersion().contains("${")) {
				for (String path : map.keySet()) {
					bean.setVersion(bean.getVersion().replace(path,
							map.get(path)));
				}
			}
			Dependency dependency = new Dependency();
			dependency.setArtifactId(bean.getArtifactId());
			dependency.setGroupId(bean.getGroupId());
			dependency.setVersion(bean.getVersion());
			dependencyList.add(dependency);
		}

		if (importHandlerFromWs && importHandlerProject!=null) {	
			try {
				IFile pomFile = importHandlerProject.getFile("pom.xml");
				MavenProject workspaceProject;
				if(pomFile.exists()){
					workspaceProject = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
				} else{
					String srcDir = "src";
					workspaceProject = MavenUtils.createMavenProject(
							"org.wso2.carbon." + importHandlerProject.getName(),
							importHandlerProject.getName(), "1.0.0", "jar");
					IJavaProject javaProject = JavaCore.create(importHandlerProject);
					IClasspathEntry[] classpath = javaProject.getRawClasspath();
					int entryCount = 0;
					for (IClasspathEntry classpathEntry : classpath) {
						if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
							if (entryCount == 0) {
								String entryPath = "";
								String[] pathSegments = classpathEntry.getPath().segments();
								if(pathSegments.length >1){
									for (int i = 1; i < pathSegments.length; i++) {
										if(i==1){
											entryPath = pathSegments[i];
										} else{
											entryPath += "/" + pathSegments[i];
										}
									}
									if(entryPath.length()>0){
										srcDir = entryPath;
										++entryCount;
									}
								}
							} else {
								log.warn("multiple source directories found, Considering '" + srcDir + "' as source directory");
								break;
							}
						}
					}
					if(entryCount==0){
						log.warn("No source directory specified, using default source directory.");
					}
					workspaceProject.getBuild().setSourceDirectory(srcDir);
					
					Repository nexusRepo = new Repository();
					nexusRepo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
					nexusRepo.setId("wso2-maven2-repository-1");
					workspaceProject.getModel().addRepository(nexusRepo);
					workspaceProject.getModel().addPluginRepository(nexusRepo);

					List<Dependency> libList = new ArrayList<Dependency>();

					Map<String, JavaLibraryBean> dependencyMap = JavaLibraryUtil
							.getDependencyInfoMap(importHandlerProject);
					
					for (JavaLibraryBean bean : dependencyMap.values()) {
						Dependency dependency = new Dependency();
						dependency.setArtifactId(bean.getArtifactId());
						dependency.setGroupId(bean.getGroupId());
						dependency.setVersion(bean.getVersion());
						libList.add(dependency);
					}
					
					workspaceProject.setDependencies(libList);
					MavenUtils.saveMavenProject(workspaceProject, pomFile.getLocation().toFile());
					project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				}
				
				Dependency dependency = new Dependency();
				dependency.setArtifactId(workspaceProject.getArtifactId());
				dependency.setGroupId(workspaceProject.getGroupId());
				dependency.setVersion(workspaceProject.getVersion());
				dependencyList.add(dependency);
			} catch (Exception e) { 
				log.warn("Error reading or updating pom file.",e);	
			}
		}
		
		MavenUtils.addMavenDependency(mavenProject, dependencyList);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

	}
	
	private String getExportedPackage(HandlerInfo handlerInfo){
		String handlerCls = handlerInfo.getHandlerClass();
		String filterCls =handlerInfo.getFilterClass();
		String[] collection = handlerCls.split("\\.");
		StringBuffer sb=new StringBuffer();
		if (collection.length > 0) {
			sb.append(collection[0]);
			for (int i = 1; i < (collection.length - 1); i++) {
				sb.append(".").append(collection[i]);
			}
		}
		if (filterCls != null) {
			if (!(filterCls.equals(Constants.CLASS_FQN_URL_MATCHER) || filterCls
					.equals(Constants.CLASS_FQN_MEDIA_TYPE_MATCHER))) {
				String[] segments = filterCls.split("\\.");
				StringBuffer buffer=new StringBuffer();
				buffer.append(segments[0]);
				if (segments.length > 0) {
					for (int i = 1; i < (segments.length - 1); i++) {
						buffer.append(".").append(segments[i]);
					}
				}
				if(!sb.toString().equals(buffer.toString())){
					sb.append(",").append(buffer);
				}
			}
		}
		return sb.toString();
		
	}
	
	private <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (value.equals(entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
}
