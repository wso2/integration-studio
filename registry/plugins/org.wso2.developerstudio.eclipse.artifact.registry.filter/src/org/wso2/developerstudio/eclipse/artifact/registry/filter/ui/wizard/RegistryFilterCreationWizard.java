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

package org.wso2.developerstudio.eclipse.artifact.registry.filter.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorPart;
import org.wso2.developerstudio.eclipse.artifact.registry.filter.model.RegistryFilterModel;
import org.wso2.developerstudio.eclipse.artifact.registry.filter.util.Constants;
import org.wso2.developerstudio.eclipse.artifact.registry.filter.util.RegistryFilterImageUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.maven.util.ProjectDependencyConstants;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class RegistryFilterCreationWizard extends
		AbstractWSO2ProjectCreationWizard {
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Registry Filter Artifact";
	private RegistryFilterModel filterModel;
	private IProject project;
	private IFolder sourceFolder;
	private IJavaProject javaProject;
	private IPackageFragmentRoot root;
	
	
	public RegistryFilterCreationWizard() {
		filterModel = new RegistryFilterModel();
		setFilterModel(filterModel);
		setModel(getFilterModel());
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(RegistryFilterImageUtils.getInstance().getImageDescriptor("new-registry-filter-wizard.png"));
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
			addDependancies(project);
			
			String className = filterModel.getFilterClass();
			String packageName = filterModel.getFilterClassPackage();
			
			IPackageFragment sourcePackage = root.createPackageFragment(packageName, false, null);
			
			ICompilationUnit cu = sourcePackage.createCompilationUnit(className+".java", getFilterClassSource(packageName,className), false, null);
			project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("bundle");
			if (!pomfile.exists()) {
				createPOM(pomfile);
			}

			MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);

			mavenProject.getModel().getProperties().put("CApp.type","lib/registry/filter");
			
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject,
					"org.apache.felix", "maven-bundle-plugin", "2.3.4",
					true);
			
			Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(plugin);
			Xpp3Dom instructionNode = MavenUtils.createXpp3Node(configurationNode, "instructions");
			Xpp3Dom symbolicNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-SymbolicName");
			symbolicNameNode.setValue(mavenProject.getArtifactId());
			Xpp3Dom bundleNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Name");
			bundleNameNode.setValue(mavenProject.getArtifactId());
			Xpp3Dom exportPackageNode = MavenUtils.createXpp3Node(instructionNode, "Export-Package");
			exportPackageNode.setValue(packageName);
			Xpp3Dom dynamicImportNode = MavenUtils.createXpp3Node(instructionNode, "DynamicImport-Package");
			dynamicImportNode.setValue("*");
		

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
			MavenUtils.addMavenDependency(mavenProject, dependencyList);
			MavenUtils.saveMavenProject(mavenProject, pomfile);
			ProjectUtils.addNatureToProject(project,
                    false,
                    Constants.REGISTRY_FILTER_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							Constants.REGISTRY_FILTER_PROJECT_NATURE,
							JDT_PROJECT_NATURE });
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			try {
				refreshDistProjects();
				IEditorPart javaEditor = JavaUI.openInEditor(cu);
				JavaUI.revealInEditor(javaEditor, (IJavaElement) cu);
			} catch (Exception e) { /* ignore */}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
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
	
	private void addDependancies(IProject project) throws Exception {

		String[] depedencyList = new String[] { LibraryUtils.abdera_wso2vXX_jar, LibraryUtils.axiom_1_2_11_wso2vXX_jar,
				LibraryUtils.axis2_1_6_1_wso2vXX_jar, LibraryUtils.commons_codec_wso2vXX_jar,
				LibraryUtils.commons_httpclient_wso2vXX_jar, LibraryUtils.commons_io_wso2vXX_jar,
				LibraryUtils.commons_loggingwso2vXX_jar, LibraryUtils.geronimo_stax_api_wso2vXX_jar,
				LibraryUtils.httpcore_4_3_0_wso2vXX_jar, LibraryUtils.neethi_wso2vXX_jar,
				LibraryUtils.not_yet_commons_ssl_wso2vXX_jar, LibraryUtils.carbon_registry_api_xxx_jar,
				LibraryUtils.carbon_registry_core_xxx_jar, LibraryUtils.wsdl4j_wso2vXX_jar,
				LibraryUtils.XmlSchema_wso2vXX_jar, LibraryUtils.woden_1_0_0_M8_wso2vXX_jar };
			
			for (String dependency : depedencyList) {
				JavaUtils.addJarLibraryToProject(project,
						LibraryUtils.getDependencyPath(dependency));
			}
	}

	public void setFilterModel(RegistryFilterModel filterModel) {
		this.filterModel = filterModel;
	}

	public RegistryFilterModel getFilterModel() {
		return filterModel;
	}

}
