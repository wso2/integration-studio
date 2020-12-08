package org.wso2.developerstudio.eclipse.registry.core.interfaces;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.registry.core.RegistryManager;
import org.wso2.developerstudio.eclipse.registry.core.ui.widgets.GRegImageUtils;

public class RegistryCollectionImpl extends RegistryResourceImpl implements
		IRegistryCollection {
	private List<IRegistryResource> children;
	public RegistryCollectionImpl(IRegistryCollection parent) {
		super(parent);
	}

	public IRegistryResource[] getChildren(final Map<String,List<String>> filters) {
		if (children==null) {
			children = new ArrayList<IRegistryResource>();
			final List<IRegistryFile> childrenFiles = new ArrayList<IRegistryFile>();
			final List<IRegistryCollection> childrenCollections = new ArrayList<IRegistryCollection>();
			if (getSource() instanceof File) {
				File parent = (File) getSource();
				if (parent.isDirectory()) {
					File[] files = parent.listFiles();
					for (File file : files) {
						RegistryResourceImpl registrySource = null;
						if (file.isFile()) {
							boolean passed = RegistryManager
									.isMediaTypeFilterPassed(filters, file);
							if (!passed) {
								continue;
							}
							registrySource = new RegistryFileImpl(getSelf());
							childrenFiles.add((IRegistryFile) registrySource);
						} else {
							if (!file.getName().equals(".meta")) {
								registrySource = new RegistryCollectionImpl(
										getSelf());
								if (registrySource.hasChildren(filters)) {
									childrenCollections
											.add((IRegistryCollection) registrySource);
								}
							}
						}
						if (registrySource != null) {
							registrySource.setPath(getPath(), file.getName());
							registrySource.setName(file.getName());
							registrySource.setSource(file);
						}
					}
				}
			} else if (getSource() instanceof IFolder) {
				final IFolder folder = (IFolder) getSource();
				try {
					folder.accept(new IResourceVisitor() {
						public boolean visit(IResource resource)
								throws CoreException {
							RegistryResourceImpl registrySource = null;
							if (folder.getLocation().toOSString().equals(
									resource.getLocation().toOSString())) {
								return true;
							} else if (resource instanceof IFile) {
								registrySource = new RegistryFileImpl(getSelf());
								registrySource.setPath(getPath(), resource
										.getName());
								registrySource.setSource(resource);
								registrySource.setName(resource.getName());
								boolean passed = RegistryManager
										.isMediaTypeFilterPassed(filters,
												(IFile) resource);
								if (passed) {
									childrenFiles
											.add((IRegistryFile) registrySource);
								}
							} else if (resource instanceof IFolder
									&& !resource.getName().equals(".meta")) {
								boolean passed = DeveloperStudioProviderUtils
										.isInProjectFilterPassed(filters,
												resource);
								if (passed) {
									registrySource = new RegistryCollectionImpl(
											getSelf());
									registrySource.setPath(getPath(), resource
											.getName());
									registrySource.setSource(resource);
									registrySource.setName(resource.getName());
									if (registrySource.hasChildren(filters)) {
										childrenCollections
												.add((IRegistryCollection) registrySource);
									}
								}
							}
							if (registrySource != null) {
								
							}
							return false;
						}

					});
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			children.addAll(childrenCollections);
			children.addAll(childrenFiles);
		}
		return children.toArray(new IRegistryResource[] {});
	}

	private IRegistryCollection getSelf() {
		return this;
	}
	
	public ImageDescriptor getIcon() {
		return GRegImageUtils.getInstance().getImageDescriptor("folder.png");
	}

	public String getId() {
		return null;
	}

	public boolean hasChildren(Map<String,List<String>> filters) {
		return getChildren(filters).length>0;
	}

	public String getText() {
		return getParent()==null? getPath():getName()+"/";
	}

	public String getKey() {
		return getPath();
	}

}
