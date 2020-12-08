package org.wso2.developerstudio.eclipse.libraries;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.libraries.utils.Constants;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryArtifact;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryArtifactHandler;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryCategory;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.ide.EclipseUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class LibraryBundleStartupHandler implements IStartup {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	List<IProject> projectsPresent=new ArrayList<IProject>();
	
	public void earlyStartup() {
		initialize();
		updateWorkspaceVariable();
		updateClasspathsForWorkspaceLibraries();
		setupProjectAdditionListeners();
	}

	private void setupProjectAdditionListeners() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
			
			public void resourceChanged(IResourceChangeEvent event) {
				if (event.getDelta()!=null) {
					IResourceDelta[] affectedChildren = event.getDelta()
							.getAffectedChildren();
					for (IResourceDelta resourceDelta : affectedChildren) {
						IResource resource = resourceDelta.getResource();
						processResourceChange(event, resource);
					}
				}
				if(event.getResource()!=null){
					processResourceChange(event, event.getResource());
				}
			}
		}, IResourceChangeEvent.PRE_DELETE|IResourceChangeEvent.POST_CHANGE);
	}

	protected void processResourceChange(IResourceChangeEvent event,
			IResource resource) {
		synchronized (projectsPresent) {
			if (resource != null) {
				IProject project = resource.getProject();
				switch (event.getType()) {
				case IResourceChangeEvent.PRE_DELETE:
					if (projectsPresent.contains(project)) {
						projectsPresent.remove(project);
					}
					break;
				case IResourceChangeEvent.POST_CHANGE:
					if (project.exists()) {
						if (!projectsPresent.contains(project)) {
							projectsPresent.add(project);
							updateWorkspaceLibraryPaths(project);
						} else if (resource.getName().equals(".classpath")) {
							updateWorkspaceLibraryPaths(project);
						}
					}

				}
			}		
		}
	}

	private void initialize() {
		projectsPresent.addAll(Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects()));
	}

	private void updateClasspathsForWorkspaceLibraries() {
		try {
			for (IProject project : projectsPresent) {
				updateWorkspaceLibraryPaths(project);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	private void updateWorkspaceLibraryPaths(IProject project) {
		try {
			if (project.isOpen() && JavaUtils.isJavaProject(project)) {
				IClasspathEntry[] classpathEntries = JavaUtils
						.getClasspathEntries(project);
				for (IClasspathEntry classpathEntry : classpathEntries) {
					try {
						if (classpathEntry.getPath().toOSString().startsWith(
								Constants.ECLIPSE_WORKSPACE_PATH)) {
							String filename = classpathEntry.getPath().segment(classpathEntry.getPath().segmentCount() - 1);
							URL fileUrlToAdd = getLibraryUrlFromLibraries(filename);
							if (fileUrlToAdd != null) {
								LibraryUtils.getDependencyPath(fileUrlToAdd);
							}
						}
					} catch (Exception e) {
						log.error(e);
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	private URL getLibraryUrlFromLibraries(String filename) {
		URL fileUrlToAdd = null;
		Map<String, LibraryCategory> libraryArtifactCategories = LibraryArtifactHandler
				.getLibraryArtifactCategories();
		for (LibraryCategory category : libraryArtifactCategories.values()) {
			List<LibraryArtifact> libraryArtifacts = category
					.getLibraryArtifacts();
			for (LibraryArtifact libraryArtifact : libraryArtifacts) {
				if (libraryArtifact.getFileName().equals(filename)) {
					fileUrlToAdd = libraryArtifact.getLibraryUrl();
				}
			}
		}
		return fileUrlToAdd;
	}

	private void updateWorkspaceVariable() {
		JavaUtils.addClasspathVariable(Constants.ECLIPSE_WORKSPACE_PATH,
				EclipseUtils.getWorkspacePath());
	}

}
