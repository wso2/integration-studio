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

package org.wso2.developerstudio.eclipse.distribution.project.export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.distribution.project.model.ArtifactData;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.file.TempFileUtils;

public class CarExportHandler extends ProjectArtifactHandler {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	DistProjectUtils distProjectUtils = new DistProjectUtils();
	private static final String POM_FILE = "pom.xml";
	private static final String SPLIT_DIR_NAME = "split_esb_resources";
	DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
	boolean isExecClassFound;

	public List<IResource> exportArtifact(IProject project) throws Exception {
		List<IResource> exportResources = new ArrayList<IResource>();
		List<ArtifactData> artifactList = new ArrayList<ArtifactData>();
		Map<IProject, Map<String, IResource>> resourceProjectList =
		                                                            new HashMap<IProject, Map<String, IResource>>();
		IFile pomFileRes;
		File pomFile;
		MavenProject parentPrj;
		ArchiveManipulator archiveManipulator = new ArchiveManipulator();

		clearTarget(project);

		// Let's create a temp project
		File tempProject = createTempProject();

		File carResources = createTempDir(tempProject, "car_resources");
		pomFileRes = project.getFile(POM_FILE);
		if (!pomFileRes.exists()) {
			throw new Exception("not a valid carbon application project");
		}
		pomFile = pomFileRes.getLocation().toFile();

		ProjectList projectListProvider = new ProjectList();
		List<ListData> projectListData = projectListProvider.getListData(null, null);
		Map<String, DependencyData> projectList = new HashMap<String, DependencyData>();
		Map<String, String> serverRoleList = new HashMap<String, String>();
		for (ListData data : projectListData) {
			DependencyData dependencyData = (DependencyData) data.getData();
			projectList.put(DistProjectUtils.getArtifactInfoAsString(dependencyData.getDependency()),
			                dependencyData);
		}

		parentPrj = MavenUtils.getMavenProject(pomFile);

		for (Dependency dependency : (List<Dependency>) parentPrj.getDependencies()) {
			String dependencyKey = DistProjectUtils.getArtifactInfoAsString(dependency);
			serverRoleList.put(dependencyKey, DistProjectUtils.getServerRole(parentPrj, dependency));
			if (projectList.containsKey(dependencyKey)) {
				DependencyData dependencyData = projectList.get(dependencyKey);
				Object parent = dependencyData.getParent();
				Object self = dependencyData.getSelf();
				String serverRole =
				                    serverRoleList.get(DistProjectUtils.getArtifactInfoAsString(dependency));
				dependencyData.setServerRole(serverRole.replaceAll("^capp/", ""));
				if (parent != null && self != null) { // multiple artifact
					if (parent instanceof IProject && self instanceof String) {
						IFile file = ((IProject) parent).getFile((String) self);
						if (file.exists()) {
							ArtifactData artifactData = new ArtifactData();
							artifactData.setDependencyData(dependencyData);
							artifactData.setFile(distProjectUtils.getFileName(dependencyData));
							artifactData.setResource((IResource) file);
							artifactList.add(artifactData);
						}
					}
				} else if (parent == null && self != null) { // artifacts as
					// single artifact archive
					DefaultArtifactExportHandler artifactExportHandler =
					                                                     new DefaultArtifactExportHandler();
					artifactExportHandler.exportArtifact(artifactList, null, null, dependencyData,
					                                     null, self);

				} else if (parent != null && self == null) { // these are
					                                         // registry
					                                         // resources
					exportRegistryResourceArtifact(artifactList, resourceProjectList,
					                               dependencyData, parent);
				} else {
					log.error("unidentified artifact structure, cannot be exported as a deployable artifact for server " +
					          serverRole);
				}
			}
		}

		OMFactory factory = OMAbstractFactory.getOMFactory();
		OMElement artifactsDocRoot = factory.createOMElement(new QName("artifacts"));
		OMElement artifactElt = factory.createOMElement(new QName("artifact"));
		artifactElt.addAttribute("name", parentPrj.getModel().getArtifactId(), null);
		artifactElt.addAttribute("version", parentPrj.getModel().getVersion(), null);
		artifactElt.addAttribute("type", "carbon/application", null);

		Collections.sort(artifactList);

		for (ArtifactData artifact : artifactList) {
			File artifactDir = new File(carResources, getArtifactDir(artifact.getDependencyData()));
			if (artifact.getResource() instanceof IFolder) {
				FileUtils.copyDirectory(artifact.getResource().getLocation().toFile(), artifactDir);
			} else if (artifact.getResource() instanceof IFile) {
				FileUtils.copy(artifact.getResource().getLocation().toFile(),
				               new File(artifactDir, artifact.getFile()));
			}
			artifactElt.addChild(createDependencyElement(factory, artifact));
			createArtifactXML(artifactDir, artifact);
		}

		artifactsDocRoot.addChild(artifactElt);
		File artifactsXml = new File(carResources, "artifacts.xml");
		XMLUtil.prettify(artifactsDocRoot, new FileOutputStream(artifactsXml));

		File tmpArchive =
		                  new File(tempProject, project.getName().concat("_")
		                                               .concat(parentPrj.getVersion())
		                                               .concat(".car"));
		archiveManipulator.archiveDir(tmpArchive.toString(), carResources.toString());

		IFile carbonArchive = getTargetArchive(project, parentPrj.getVersion(), "car");
		FileUtils.copy(tmpArchive, carbonArchive.getLocation().toFile());
		exportResources.add((IResource) carbonArchive);
		clearTempDirInWorksapce(project.getName(), SPLIT_DIR_NAME);
		TempFileUtils.cleanUp();

		return exportResources;
	}

	private void exportRegistryResourceArtifact(List<ArtifactData> artifactList,
	                                            Map<IProject, Map<String, IResource>> resourceProjectList,
	                                            DependencyData dependencyData, Object parent)
	                                                                                         throws Exception {
		IProject resProject = (IProject) parent;
		if (!resourceProjectList.containsKey(resProject)) {
			Map<String, IResource> artifacts = new HashMap<String, IResource>();
			List<IResource> buildProject =
			                               ExportUtil.buildProject(resProject,
			                                                       dependencyData.getCApptype());
			for (IResource res : buildProject) {
				if (res instanceof IFolder) {
					artifacts.put(res.getName(), res);
				}
			}
			resourceProjectList.put(resProject, artifacts);
		}
		if (resourceProjectList.containsKey(resProject)) {
			Map<String, IResource> artifacts = resourceProjectList.get(resProject);
			if (artifacts.containsKey(getArtifactDir(dependencyData))) {
				ArtifactData artifactData = new ArtifactData();
				artifactData.setDependencyData(dependencyData);
				artifactData.setFile("registry-info.xml");
				artifactData.setResource(artifacts.get(getArtifactDir(dependencyData)));
				artifactList.add(artifactData);
			}

		}
	}

	private String getArtifactDir(DependencyData dependencyData) {
		String artifactDir =
		                     String.format("%s_%s", dependencyData.getDependency().getArtifactId(),
		                                   dependencyData.getDependency().getVersion());
		return artifactDir;
	}

	private void createArtifactXML(File artifactDir, ArtifactData artifact) {
		OMFactory factory = OMAbstractFactory.getOMFactory();
		OMElement artifactElt = factory.createOMElement(new QName("artifact"));
		artifactElt.addAttribute("name", artifact.getDependencyData().getDependency()
		                                         .getArtifactId(), null);
		artifactElt.addAttribute("version", artifact.getDependencyData().getDependency()
		                                            .getVersion(), null);
		artifactElt.addAttribute("type", artifact.getDependencyData().getCApptype(), null);
		artifactElt.addAttribute("serverRole", artifact.getDependencyData().getServerRole(), null);
		OMElement fileElt = factory.createOMElement(new QName("file"));
		fileElt.setText(artifact.getFile());
		artifactElt.addChild(fileElt);
		File artifactXml = new File(artifactDir, "artifact.xml");
		try {
			XMLUtil.prettify(artifactElt, new FileOutputStream(artifactXml));
		} catch (Exception e) {
			log.error("Error creating artifact.xml", e);
		}
	}

	private OMElement createDependencyElement(OMFactory factory, ArtifactData artifact) {
		OMElement dependencyElt = factory.createOMElement(new QName("dependency"));
		dependencyElt.addAttribute("artifact", artifact.getDependencyData().getDependency()
		                                               .getArtifactId(), null);
		dependencyElt.addAttribute("version", artifact.getDependencyData().getDependency()
		                                              .getVersion(), null);
		dependencyElt.addAttribute("include", "true", null);
		dependencyElt.addAttribute("serverRole", artifact.getDependencyData().getServerRole(), null);
		return dependencyElt;
	}

}
