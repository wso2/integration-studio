/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.project;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class FileModificationManager implements IResourceChangeListener {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String SYNAPSE_CONFIG_DIR = "synapse-config";
	private static final String FILE_PATH = "src/main/synapse-config/";
	private static final String ESB_SEVER_ROLE = "EnterpriseServiceBus";
	private static final String POM = "pom.xml";
	private static final String COMMAN_NAME = "synapse/";
	private static final String ARTIFACT_MEATADATA_FILE = "artifact.xml";
	private static final String ESB_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.esb.project.nature";

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			event.getDelta().accept(new IResourceDeltaVisitor() {
				public boolean visit(final IResourceDelta delta) {

					final IResource resource = delta.getResource();
					if (resource.getType() == IResource.ROOT) {
						return true;
					} else if (resource.getType() == IResource.PROJECT) {
						try {
							IProject iProject = (IProject) resource;
							if (iProject != null && iProject.isOpen() && iProject.hasNature(ESB_PROJECT_NATURE)) {
								return true;
							}
						} catch (CoreException e) {
							log.error("Error while checking the project nature", e);
							return false;
						}
						return false;
					} else if (resource.getType() == IResource.FILE) {
						if (delta.getKind() == IResourceDelta.ADDED) {

							Job job = new Job("update ArifactXML") {

								@Override
								protected IStatus run(IProgressMonitor monitor) {
									try {
										if (resource instanceof IFile) {
											final IFile file = (IFile) resource;
											IProject iProject = file.getProject();
											if (file.getParent() instanceof IFolder) {
												IFolder folder = (IFolder) file.getParent();
												IPath location = file.getLocation();
												IPath removeLastSegments = location.removeLastSegments(2);
												String grandParentDir = removeLastSegments.lastSegment();

												if (SYNAPSE_CONFIG_DIR.equals(grandParentDir)) {

													String source = FileUtils.getContentAsString(file.getLocationURI()
															.toURL());
													Openable openable = ESBGraphicalEditor.getOpenable();
													ArtifactType artifactType = (ArtifactType) openable
															.artifactTypeResolver(source);

													final String folderType = folder.getName();
													final String arifacLiteral = artifactType.getName().toLowerCase();

													if (folderType.startsWith(arifacLiteral)) {

														File arifact = iProject.getFile(ARTIFACT_MEATADATA_FILE)
																.getLocation().toFile();
														ESBProjectArtifact artifact = new ESBProjectArtifact();
														artifact.fromFile(arifact);
														List<ESBArtifact> allESBArtifacts = artifact
																.getAllESBArtifacts();
														ESBArtifact esbTempartifact = null;
														for (ESBArtifact esbartifact : allESBArtifacts) {
															String name = esbartifact.getName() + ".xml";
															if (name.equals(file.getName())) {
																return Status.OK_STATUS;
															}
															esbTempartifact = esbartifact;
														}

														String version = "";
														String type = COMMAN_NAME
																+ ESBProjectUtils.getType(folder.getName());
														String groupId = "";
														String name = file.getName().split("\\.")[0];

														if (esbTempartifact == null) {
															File pomLocation = iProject.getFile(POM).getLocation()
																	.toFile();
															MavenProject mavenProject = MavenUtils
																	.getMavenProject(pomLocation);
															version = mavenProject.getVersion();
															groupId = mavenProject.getGroupId();
														} else {
															version = esbTempartifact.getVersion();
															groupId = esbTempartifact.getGroupId();
														}

														ESBArtifact esbArtifact = new ESBArtifact();
														esbArtifact.setName(name);
														esbArtifact.setVersion(version);
														esbArtifact.setType(type);
														esbArtifact.setServerRole(ESB_SEVER_ROLE);
														esbArtifact.setGroupId(groupId);
														// Should not use file separator here
														esbArtifact.setFile(FILE_PATH + folder.getName() + "/"
																+ file.getName());
														artifact.addESBArtifact(esbArtifact);
														artifact.toFile();
													} else {
														IPath movedFromPath = delta.getMovedFromPath();
														if (movedFromPath != null) {
															Display.getDefault().syncExec(new Runnable() {

																@Override
																public void run() {

																	MessageDialog.openError(Display.getCurrent()
																			.getActiveShell(), "Error Move",
																			"Cannot move due to invalid location");

																	try {
																		IUndoContext workspaceContext = (IUndoContext) ResourcesPlugin
																				.getWorkspace().getAdapter(
																						IUndoContext.class);
																		OperationHistoryFactory
																				.getOperationHistory()
																				.undo(workspaceContext,
																						new NullProgressMonitor(), null);

																	} catch (ExecutionException e) {
																		log.error("Cannot undo last operation", e);
																	}

																}
															});
														}
													}
												}
											}
										}
									} catch (FactoryConfigurationError | Exception e) {
										log.error("Error while updating the arifactxml", e);
									}
									return Status.OK_STATUS;
								}
							};
							job.schedule();
							return true;
						} else if (delta.getKind() == IResourceDelta.REMOVED) {

							Job job = new Job("update ArifactXML") {

								@Override
								protected IStatus run(IProgressMonitor monitor) {
									try {
										if (resource instanceof IFile) {
											IFile file = (IFile) resource;
											if (file.exists()) {
												IProject project = file.getProject();
												IPath location = file.getLocation();
												IPath removeLastSegments = location.removeLastSegments(2);
												String grandParentDir = removeLastSegments.lastSegment();

												if (SYNAPSE_CONFIG_DIR.equals(grandParentDir)) {
													File arifact = project.getFile(ARTIFACT_MEATADATA_FILE)
															.getLocation().toFile();
													ESBProjectArtifact artifact = new ESBProjectArtifact();
													artifact.fromFile(arifact);
													List<ESBArtifact> allESBArtifacts = artifact.getAllESBArtifacts();
													ESBArtifact removeNode = null;
													Iterator<ESBArtifact> iterator = allESBArtifacts.iterator();
													while (iterator.hasNext()) {
														ESBArtifact esbartifact = iterator.next();
														String name = esbartifact.getName() + ".xml";
														if (name.equals(file.getName())) {
															removeNode = esbartifact;
															break;
														}

													}
													if (removeNode != null) {
														artifact.removeESBArtifact(removeNode);
														artifact.toFile();
													}
												}
											}
										}
									} catch (FactoryConfigurationError | Exception e) {
										log.error("Error while updating the arifactxml", e);
									}
									return Status.OK_STATUS;
								}
							};
							job.schedule();
							return true;
						}

						return false;
					}
					return true;

				}
			});

		} catch (CoreException e) {
			log.error("Error while updating the arifactxml", e);
		}

	}

}
