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

package org.wso2.developerstudio.eclipse.artifact.registry.project.export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.artifact.registry.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RegistryArtifactHandler extends ProjectArtifactHandler {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	public static final String ARTIFACT_XML = "artifact.xml";
	public static final String GENERAL_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.general.project.nature";
	List<IResource> exportResources = new ArrayList<IResource>();

	public List<IResource> exportArtifact(IProject project) throws Exception {
			if (project.hasNature(GENERAL_PROJECT_NATURE)) {
				NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();
				project.build(IncrementalProjectBuilder.FULL_BUILD, nullProgressMonitor);
				IFile RegistryResourceFile = project.getFile(ARTIFACT_XML);

				IFolder binaries = project.getFolder("target");
				if (!binaries.exists()) {
					binaries.create(true, true, nullProgressMonitor);
					binaries.setHidden(true);
				} else{ 
					clearTarget(project);
				}
				project.refreshLocal(IResource.DEPTH_INFINITE, nullProgressMonitor);

				IFolder registryResources = binaries.getFolder("registry_resources");
				if (registryResources.exists()) {
					FileUtils.deleteDirectories(registryResources.getLocation().toFile());
				}
				registryResources.create(false, true, nullProgressMonitor);

				project.refreshLocal(IResource.DEPTH_INFINITE, nullProgressMonitor);

				if (RegistryResourceFile.exists()) {
					XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(
							RegistryResourceFile.getContents());
					StAXOMBuilder builder = new StAXOMBuilder(parser);
					OMElement documentElement = builder.getDocumentElement();
					Iterator artifacts = documentElement.getChildElements();
					while (artifacts.hasNext()) {
						Object o = artifacts.next();
						if (o instanceof OMElement) {
							OMElement artifact = (OMElement) o;
							if ("artifact".equals(artifact.getLocalName())) {
								String name = artifact.getAttributeValue(new QName("name"));
								String version = artifact.getAttributeValue(new QName("version"));
								String type = artifact.getAttributeValue(new QName("type"));
								if ("registry/resource".equals(type)) {
									IFolder resourceArtifact = registryResources.getFolder(String
											.format("%s_%s", name, version));
									resourceArtifact.create(true, true, nullProgressMonitor);
									IFolder resourcesDir = resourceArtifact.getFolder("resources");
									resourcesDir.create(true, true, nullProgressMonitor);

									OMFactory factory = OMAbstractFactory.getOMFactory();
									OMElement resourcesEl = factory.createOMElement(new QName(
											"resources"));

									Iterator items = artifact.getChildElements();
									while (items.hasNext()) {
										Object obj = items.next();
										if (obj instanceof OMElement) {
											OMElement item = (OMElement) obj;
											if ("item".equals(item.getLocalName()) || "dump".equals(item.getLocalName())) {
												OMElement fileEl = item.getFirstChildWithName(new QName("file"));
												String fileName = fileEl.getText();
												IFile regItem = project.getFile(fileName);
												if (regItem.exists()) {
													FileUtils.copy(regItem.getLocation().toFile(),
															new File(resourcesDir.getLocation()
																	.toFile(), regItem.getName()));
												}
												fileEl.setText(regItem.getName());
												resourcesEl.addChild(item);
											} else if ("collection".equals(item.getLocalName())) {
												OMElement collectionEl = item.getFirstChildWithName(
																			new QName("directory"));
												String dir = collectionEl.getText();
												IFolder regCollection = project.getFolder(dir);
												if (regCollection.exists()) {
													FileUtils.copyDirectory(regCollection
															.getLocation().toFile(), new File(resourcesDir
															.getLocation().toFile(),regCollection.getName()));
												}
												collectionEl.setText(regCollection.getName());
												resourcesEl.addChild(item);
											} else{
												log.warn("unknown resource type '" +  item.getLocalName() + "'; skipping");
											}
											
										}
									}
									IFile registryInfo = resourceArtifact
											.getFile("registry-info.xml");
									FileOutputStream out = new FileOutputStream(registryInfo
											.getLocation().toFile());
									XMLUtil.prettify(resourcesEl, out);
									out.close();
									exportResources.add((IResource) resourceArtifact);
								}
							}
						}
						project.refreshLocal(IResource.DEPTH_INFINITE, nullProgressMonitor);
					}
					builder.close();
					parser.close();
				}
			}

		return exportResources;
	}

}
