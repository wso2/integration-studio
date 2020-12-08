/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.remote.operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jst.ws.internal.common.J2EEUtils;
import org.eclipse.jst.ws.internal.common.ResourceUtils;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.CarbonServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerModulePublisher;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerInformation;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.remote.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.remote.util.RemoteCarbonServerUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.wst.Axis2ServiceUtils;

public class ServiceModuleOperations {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IProject project;
	private IServer server;

	public ServiceModuleOperations(IProject project, IServer server) {
		this.project = project;
		this.server = server;
	}

	public void hotUpdateModule() throws CoreException {
		if (!project.exists() || !project.isOpen()) {
			redeployModule(false);
			return;
		}
		redeployModule(true);
	}

	public void redeployModule() {
		redeployModule(true);
	}

	public void redeployModule(boolean force) {
		CarbonServerInformation wsasServerInformation = CarbonServerManager.getAppServerInformation().get(server);
		if (!force && !wsasServerInformation.getChangedProjects().contains(project)) {
			return;
		}
		wsasServerInformation.getChangedProjects().remove(project);
		List<ICarbonServerModulePublisher> projectPublishers = CarbonServer.getProjectPublishers(server);
		if (projectPublishers != null && !projectPublishers.isEmpty()) {
			for (ICarbonServerModulePublisher publisher : projectPublishers) {
				try {
					publisher.hotUpdate(project, server, null, null);
				} catch (Exception e) {
					log.error(e);
				}
			}
		} else {
			IPath webInfPath = J2EEUtils.getWebInfPath(project);
			String servicesFolder = webInfPath.removeFirstSegments(1).toOSString() + "/services";
			String absServicesFolder =
			                           FileUtils.addAnotherNodeToPath(project.getLocation().toOSString(),
			                                                          servicesFolder);
			IFolder folder = project.getFolder(servicesFolder);
			File webTemp = new File(absServicesFolder);
			String[] list = webTemp.list();
			Visitor visitor = new Visitor(false);
			IPath defaultClassesSubDirectory = ResourceUtils.getJavaOutputLocation(project);
			IPath projectRoot = project.getLocation();

			String classesDirectory = null;
			if (projectRoot.toOSString().contains(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString())) {
				classesDirectory =
				                   ResourcesPlugin.getWorkspace().getRoot().getLocation()
				                                  .append(defaultClassesSubDirectory).toOSString();
			} else {
				classesDirectory = projectRoot.append(defaultClassesSubDirectory).toOSString();
			}
			try {
				folder.accept(visitor);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
			for (IResource resource : visitor.getResources()) {
				try {
					if ((!folder.getLocation().toOSString().equals(resource.getLocation().toOSString())) &&
					    resource instanceof IFolder) {
						IFolder folder2 = (IFolder) resource;
						if (folder2.getFullPath().removeFirstSegments(folder.getFullPath().segmentCount())
						           .segmentCount() == 1) {
							String repoServiceLocation = folder2.getLocation().toOSString();
							FileUtils.copyDirectory(new File(classesDirectory), new File(repoServiceLocation));
							folder2.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
							String serviceName = Axis2ServiceUtils.getServiceNameFromFolder(repoServiceLocation);
							IPath location = folder2.getLocation();
							startServiceWSDLWatcher(server, serviceName, project, location, 11);
						}
					}
				} catch (Exception e) {
					log.error(e);
				}
			}
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				log.error(e);
			}
		}
	}

	public void publishServiceModule(String webTempFolder, String Service) {
		List<ICarbonServerModulePublisher> projectPublishers = CarbonServer.getProjectPublishers(server);
		if (projectPublishers != null && !projectPublishers.isEmpty()) {
			for (ICarbonServerModulePublisher publisher : projectPublishers) {
				try {
					publisher.publish(project, server, null, null);
				} catch (Exception e) {
					log.error(e);
				}
			}
		} else {
			String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
			File deployPath =
			                  new File(
			                           RemoteCarbonServerUtils.getRepositoryPathFromLocalWorkspaceRepo(serverLocalWorkspacePath));
			String serverLocalRepoServiceLocation =
			                                        FileUtils.addNodesToPath(deployPath.toString(),
			                                                                 new String[] { "axis2services" });
			IPath webInfPath = J2EEUtils.getWebInfPath(project);
			String servicesFolder = webInfPath.removeFirstSegments(1).toOSString() + "/services";
			String absServicesFolder =
			                           FileUtils.addAnotherNodeToPath(project.getLocation().toOSString(),
			                                                          servicesFolder);
			IFolder folder = project.getFolder(servicesFolder);
			File webTemp = new File(absServicesFolder);
			String[] list = webTemp.list();
			try {
				IJavaProject javaProject = (IJavaProject) project.getNature(JavaCore.NATURE_ID);
				IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
				List list2 = new LinkedList(java.util.Arrays.asList(rawClasspath));
				if (list == null)
					return;
				for (String path : list) {
					File tmpService = new File(FileUtils.addAnotherNodeToPath(absServicesFolder, path));
					String serverRepoServicePath =
					                               FileUtils.addAnotherNodeToPath(serverLocalRepoServiceLocation,
					                                                              project.getName() + "_" + path);
					try {
						String serviceName = null;
						IPath location = null;
						if (tmpService.isDirectory()) {
							FileUtils.copyDirectory(tmpService, new File(serverRepoServicePath));
							FileUtils.deleteDirectories(tmpService);
							IFolder folder2 = folder.getFolder(path);
							folder2.delete(true, new NullProgressMonitor());
							folder2.createLink(new Path(serverRepoServicePath), IResource.NONE, null);
							IClasspathEntry srcEntry = JavaCore.newSourceEntry(folder2.getFullPath());
							list2.add(srcEntry);
							serviceName = Axis2ServiceUtils.getServiceNameFromFolder(serverRepoServicePath);
							location = folder2.getLocation();
							addProjectDeployedServices(project.getName(), location.toOSString());
							startServiceWSDLWatcher(server, serviceName, project, location);
						} else {
							FileUtils.copy(tmpService, new File(serverRepoServicePath));
							tmpService.delete();
							IFile file2 = folder.getFile(path);
							file2.delete(true, new NullProgressMonitor());
							file2.createLink(new Path(serverRepoServicePath), IResource.NONE, null);
						}
					} catch (IOException e) {
						log.error(e);
					} catch (Exception e) {
						log.error(e);
					}
				}
				IClasspathEntry[] newClasspath = (IClasspathEntry[]) list2.toArray(new IClasspathEntry[] {});
			} catch (JavaModelException e) {
				log.error(e);
			} catch (CoreException e) {
				log.error(e);
			}
		}
	}

	public void startServiceWSDLWatcher(IServer server, String serviceName, IProject project, IPath location) {
		startServiceWSDLWatcher(server, serviceName, project, location, 0);
	}

	public void startServiceWSDLWatcher(IServer server, String serviceName, IProject project, IPath location, int delay) {
		if (serviceName == null)
			return;
		try {
			ServiceWSDLRetriever.startWSDLRetriever(new Path(FileUtils.addNodesToPath(location.toOSString(),
			                                                                          new String[] { serviceName +
			                                                                                         ".wsdl" })),
			                                        CarbonServerManager.getServiceWSDLUrl(server, serviceName),
			                                        project, delay);
		} catch (Exception e1) {
			log.error(e1);
		}
	}

	public void unpublishServiceModule(String webTempFolder, String Service) {
		List<ICarbonServerModulePublisher> projectPublishers = CarbonServer.getProjectPublishers(server);
		if (projectPublishers != null && !projectPublishers.isEmpty()) {
			for (ICarbonServerModulePublisher publisher : projectPublishers) {
				try {
					publisher.unpublish(project, server, null, null);
				} catch (Exception e) {
					log.error(e);
				}
			}
		} else {
			if (project == null)
				return;
			if (!project.exists()) {
				String[] projectDeployedServices = getProjectDeployedServices(project.getName());
				for (String path : projectDeployedServices) {
					File file = new File(path);
					if (file != null && file.exists()) {
						FileUtils.deleteDirectories(file);
					}
				}
				return;
			}
			IPath webInfPath = J2EEUtils.getWebInfPath(project);
			String servicesFolder = webInfPath.removeFirstSegments(1).toOSString() + "/services";
			String absServicesFolder =
			                           FileUtils.addAnotherNodeToPath(project.getLocation().toOSString(),
			                                                          servicesFolder);
			IFolder folder = project.getFolder(servicesFolder);
			File webTemp = new File(absServicesFolder);
			String[] list = webTemp.list();
			Visitor visitor = new Visitor(true);
			try {
				folder.accept(visitor);
			} catch (CoreException e1) {
				log.error(e1);
			}
			try {
				IJavaProject javaProject = (IJavaProject) project.getNature(JavaCore.NATURE_ID);
				IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
				List list2 = new LinkedList(java.util.Arrays.asList(rawClasspath));
				for (IResource resource : visitor.getResources()) {
					try {
						if (resource instanceof IFolder) {
							IFolder folder2 = (IFolder) resource;
							removeSourceFromList(list2, folder2.getFullPath());
							String repoServiceLocation = folder2.getLocation().toOSString();
							folder2.delete(true, new NullProgressMonitor());
							String projectServiceLocation = folder2.getFullPath().removeFirstSegments(1).toOSString();
							FileUtils.copyDirectory(new File(repoServiceLocation),
							                        new File(FileUtils.addAnotherNodeToPath(project.getLocation()
							                                                                       .toOSString(),
							                                                                projectServiceLocation)));
							FileUtils.deleteDirectories(new File(repoServiceLocation));
						} else {
							IFile file = (IFile) resource;
							String repoServiceLocation = file.getLocation().toOSString();
							file.delete(true, new NullProgressMonitor());
							String projectServiceLocation = file.getFullPath().removeFirstSegments(1).toOSString();
							FileUtils.copy(new File(repoServiceLocation),
							               new File(FileUtils.addAnotherNodeToPath(project.getLocation().toOSString(),
							                                                       projectServiceLocation)));
							(new File(repoServiceLocation)).delete();
						}
					} catch (Exception e) {
						log.error(e);
					}
				}
				IClasspathEntry[] newClasspath = (IClasspathEntry[]) list2.toArray(new IClasspathEntry[] {});
				javaProject.setRawClasspath(newClasspath, null);
				try {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (CoreException e) {
					log.error(e);
				}
			} catch (JavaModelException e) {
				log.error(e);
			} catch (CoreException e) {
				log.error(e);
			}
		}
	}

	private void removeSourceFromList(List<IClasspathEntry> list, IPath path) {
		IClasspathEntry toRemove = null;
		for (IClasspathEntry cp : list) {
			if (cp.getPath().toOSString().equals(path.toOSString())) {
				toRemove = cp;
				break;
			}
		}
		if (toRemove != null)
			list.remove(toRemove);
	}

	private class Visitor implements IResourceVisitor {
		List<IResource> linkedFolders;
		boolean isGetOnlyLinkedFolders = false;

		public Visitor(boolean isGetOnlyLinkedFolders) {
			linkedFolders = new ArrayList<IResource>();
			this.isGetOnlyLinkedFolders = isGetOnlyLinkedFolders;
		}

		public boolean visit(IResource arg0) throws CoreException {
			if (!isGetOnlyLinkedFolders || arg0.isLinked()) {
				if (arg0 instanceof IFolder || arg0 instanceof IFile)
					linkedFolders.add(arg0);
			}
			return true;
		}

		public IResource[] getResources() {
			return linkedFolders.toArray(new IResource[] {});
		}
	}

	public Map<IFolder, IProject> getServicesList() {
		Map<IFolder, IProject> result = new HashMap<IFolder, IProject>();
		if (project == null) {
			IModule[] modules = server.getModules();
			for (IModule module : modules) {
				getServicesList(module.getProject(), result);
			}
		} else
			getServicesList(project, result);
		return result;
	}

	private void getServicesList(IProject project, Map<IFolder, IProject> list) {
		IPath webInfPath;
		try {
			webInfPath = J2EEUtils.getWebInfPath(project);
		} catch (Exception e) {
			// doesn't have a webinf directory - thus assuming this is not a
			// dynamic web project
			return;
		}
		String servicesFolder = webInfPath.removeFirstSegments(1).toOSString() + "/services";
		IFolder folder = project.getFolder(servicesFolder);
		Visitor visitor = new Visitor(false);
		try {
			folder.accept(visitor);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		for (IResource resource : visitor.getResources()) {
			Path path = new Path(resource.toString().substring(folder.toString().length()));
			if (path.segmentCount() == 1 && resource instanceof IFolder) {
				IFolder folder2 = (IFolder) resource;
				IPath fullPath = folder2.getFullPath();
				list.put(folder2, project);
			}
		}
	}

	private static final String DEPLOYED = "DEPLOYED_";
	private static final String DELIMETER = "\n";

	public String[] getProjectDeployedServices(String projectName) {
		String deployed = RemoteCarbonServerUtils.getServerConfigMapValue(server, DEPLOYED + projectName);
		if (deployed == null)
			deployed = "";
		String[] deployedFiles = deployed.split(DELIMETER);
		return deployedFiles;
	}

	public void removeDeployedServices(String projectName) {
		RemoteCarbonServerUtils.setServerConfigMapValue(server, DEPLOYED + projectName, null);
	}

	public void addProjectDeployedServices(String projectName, String servicePath) {
		String deployed = RemoteCarbonServerUtils.getServerConfigMapValue(server, DEPLOYED + projectName);
		if (deployed == null)
			deployed = "";
		String[] deployedFiles = deployed.split(DELIMETER);
		deployed = deployed + DELIMETER + servicePath;
		boolean found = false;
		for (String string : deployedFiles) {
			if (string.equals(servicePath))
				found = true;
		}
		if (!found)
			RemoteCarbonServerUtils.setServerConfigMapValue(server, DEPLOYED + projectName, deployed);

	}
}
