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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.dialog;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;

public class ClassNameBrowseDlg extends FilteredItemsSelectionDialog {
	private String filter;
	private ClassFilter classFilter;
	private HashMap<String, ICompilationUnit> classes = new HashMap<String, ICompilationUnit>();
	private JavaPluginImages javaImg = new JavaPluginImages();

	public ClassNameBrowseDlg(Shell shell, ClassFilter classFilter, String filter) {
		super(shell);
		this.filter = filter;
		this.classFilter = classFilter;
		setTitle("Class Browser");
		setListLabelProvider(new ILabelProvider() {

			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object arg0, String arg1) {
				return false;
			}

			public void dispose() {
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public String getText(Object item) {
				if (null != item) {
					IType type = (IType) item;
					return type.getTypeQualifiedName() + " : " + type.getFullyQualifiedName();
				}
				return null;
			}

			public Image getImage(Object obj) {
				return javaImg.get(javaImg.IMG_OBJS_CLASS);
			}
		});
		setDetailsLabelProvider(new ILabelProvider() {

			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object arg0, String arg1) {
				return false;
			}

			public void dispose() {
			}

			public void addListener(ILabelProviderListener arg0) {
			}

			public String getText(Object item) {
				if (null != item) {
					IType type = (IType) item;
					return type.getPackageFragment().getElementName();
				}
				return null;
			}

			public Image getImage(Object arg0) {
				return javaImg.get(javaImg.IMG_OBJS_PACKAGE);
			}
		});
		setSelectionHistory(new ResourceSelectionHistory());
	}

	protected Control createExtendedContentArea(Composite arg0) {
		return null;
	}

	protected ItemsFilter createFilter() {
		return new ItemsFilter() {
			public boolean matchItem(Object item) {
				IType type = (IType) item;
				return matches(type.getTypeQualifiedName()) ||
				       matches(type.getFullyQualifiedName());
			}

			public boolean isConsistentItem(Object item) {
				return true;
			}
		};
	}

	protected void fillContentProvider(AbstractContentProvider contentProvider,
	                                   ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
	                                                                                             throws CoreException {
		progressMonitor.beginTask("Searching", 1000);
		classes.clear();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();

		for (IProject project : projects) {
			if (project.isOpen()) {
				if (project.hasNature("org.eclipse.jdt.core.javanature")) {
					IJavaProject javaProject = JavaCore.create(project);
					IPackageFragment[] packages = javaProject.getPackageFragments();
					for (IPackageFragment jPackage : packages) {
						if (jPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
							for (final ICompilationUnit compilationUnit : jPackage.getCompilationUnits()) {
								IType[] types = compilationUnit.getTypes();
								for (IType type : types) {
									switch (classFilter) {
										case FILTER_ANNOTATION:
											IAnnotation annotation = type.getAnnotation(filter);
											if (annotation.exists()) {
												contentProvider.add(type, itemsFilter);
											}
											break;
										case FILTER_SUPERINTERFACE:
											if (type.getSuperInterfaceNames().length > 0 &&
											    Arrays.asList(type.getSuperInterfaceNames())
											          .contains(filter)) {
												contentProvider.add(type, itemsFilter);
											}
											break;
										case FILTER_SUPERCLASS:
										default:
											if (filter.equals(type.getSuperclassName())) {
												contentProvider.add(type, itemsFilter);
											}
											break;
									}
								}
							}
							progressMonitor.worked(1);
						}

					}
				}
			}
			progressMonitor.done();
		}
	}

	protected IDialogSettings getDialogSettings() {
		String DIALOG_SETTINGS ="ClassBrowserSettings";
		IDialogSettings settings = Activator.getDefault().getDialogSettings()
		                                    .getSection(DIALOG_SETTINGS);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}
		return settings;
	}

	public String getElementName(Object item) {
		return item.toString();
	}

	protected Comparator getItemsComparator() {
		return new Comparator() {
			public int compare(Object arg0, Object arg1) {
				return arg0.toString().compareTo(arg1.toString());
			}
		};
	}

	private class ResourceSelectionHistory extends SelectionHistory {
		protected Object restoreItemFromMemento(IMemento element) {
			return null;
		}

		protected void storeItemToMemento(Object item, IMemento element) {
		}
	}

	protected IStatus validateItem(Object obj) {
		return Status.OK_STATUS;
	}

	public enum ClassFilter {
		FILTER_ANNOTATION, FILTER_SUPERINTERFACE, FILTER_SUPERCLASS
	}
}
