/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProviderData;

 

public class DeveloperStudioRegistryResourceProviderDialog extends Dialog {
	private Class<?>[] type;
	private TreeViewer treeViewer;
	private String selectedPath = null;
	private Map<String, List<String>> filters;
	private String title;


	public DeveloperStudioRegistryResourceProviderDialog(Shell parentShell, Class<?>[] type, Map<String, List<String>> filters) {
		super(parentShell);
		setType(type);
		setFilters(filters);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (title != null) {
			newShell.setText(title);
		}
	}

	protected Control createDialogArea(Composite parent) {
		final Composite container = (Composite) super.createDialogArea(parent);
		treeViewer = new TreeViewer(container, SWT.BORDER);
		Tree treeResrouceProviders = treeViewer.getTree();
		treeResrouceProviders.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateSelectedElement();
				updateOKButtonStatus();
			}
		});

		treeResrouceProviders.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1));

		treeViewer.setContentProvider(new ITreeContentProvider() {

			public Object[] getChildren(Object o) {
				return createTreeItemList(o);
			}

			private Object[] createTreeItemList(Object o) {
				List<Object> list = new ArrayList<Object>();
				if (o instanceof IDeveloperStudioProviderData[]) {
					IDeveloperStudioProviderData[] oo = (IDeveloperStudioProviderData[]) o;
					for (IDeveloperStudioProviderData data : oo) {
						IDeveloperStudioProvider provider = data.getProvider();
						if (isChildElementsPresent(provider)) {
							list.add(data);
						}
					}
				} else if (o instanceof IDeveloperStudioProvider
						|| o instanceof IDeveloperStudioProviderData) {
					IDeveloperStudioProvider provider = o instanceof IDeveloperStudioProvider ? (IDeveloperStudioProvider) o
							: ((IDeveloperStudioProviderData) o).getProvider();
					IDeveloperStudioElement[] resources = provider
							.getElements(getFilters());
					if (resources != null) {
						list.addAll(Arrays.asList(resources));
					}
					IDeveloperStudioProvider[] categories = provider
							.getCategories(getFilters());
					if (categories != null) {
						list.addAll(Arrays.asList(categories));
					}
				} else if (o instanceof IDeveloperStudioElement) {
					IDeveloperStudioElement element = (IDeveloperStudioElement) o;
					list.addAll(Arrays.asList(element.getChildren(getFilters())));
				}
				return list.toArray();
			}

			private boolean isChildElementsPresent(
					IDeveloperStudioProvider provider) {
				IDeveloperStudioElement[] resources = provider
						.getElements(getFilters());
				IDeveloperStudioProvider[] categories = provider
						.getCategories(getFilters());
				return (resources != null && resources.length > 0)
						|| (categories != null && categories.length > 0);
			}

			public Object getParent(Object arg0) {
				return null;
			}

			public boolean hasChildren(Object o) {
				if (o instanceof IDeveloperStudioProviderData[]) {
					return ((IDeveloperStudioProviderData[]) o).length > 0;
				} else if (o instanceof IDeveloperStudioProviderData) {
					IDeveloperStudioProviderData provider = (IDeveloperStudioProviderData) o;
					return isChildElementsPresent(provider.getProvider());
				} else if (o instanceof IDeveloperStudioProvider) {
					IDeveloperStudioProvider provider = (IDeveloperStudioProvider) o;
					return isChildElementsPresent(provider);
				} else if (o instanceof IDeveloperStudioElement) {
					IDeveloperStudioElement element = (IDeveloperStudioElement) o;
					return element.hasChildren(getFilters());
				}
				return false;
			}

			public Object[] getElements(Object o) {
				return getChildren(o);
			}

			public void dispose() {
			}

			public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
			}
		});
		
		treeViewer.setLabelProvider(new ILabelProvider() {
			public Image getImage(Object o) {
				if (o instanceof IDeveloperStudioProviderData) {
					IDeveloperStudioProviderData oo = (IDeveloperStudioProviderData) o;
					if (oo.getProvider().getIcon() != null) {
						return oo.getProvider().getIcon().createImage();
					}
				} else if (o instanceof IDeveloperStudioProvider) {
					IDeveloperStudioProvider provider = (IDeveloperStudioProvider) o;
					if (provider.getIcon() != null) {
						return provider.getIcon().createImage();
					}
				} else if (o instanceof IDeveloperStudioElement) {
					IDeveloperStudioElement resource = (IDeveloperStudioElement) o;
					if (resource.getIcon() != null) {
						return resource.getIcon().createImage();
					}
				}
				return null;
			}

			public String getText(Object o) {
				if (o instanceof IDeveloperStudioProviderData) {
					IDeveloperStudioProviderData oo = (IDeveloperStudioProviderData) o;
					return oo.getName();
				} else if (o instanceof IDeveloperStudioProvider) {
					IDeveloperStudioProvider provider = (IDeveloperStudioProvider) o;
					return provider.getText();
				} else if (o instanceof IDeveloperStudioElement) {
					IDeveloperStudioElement resource = (IDeveloperStudioElement) o;
					return resource.getText();
				}
				return null;
			}

			public void addListener(ILabelProviderListener arg0) {
			}

			public void dispose() {

			}

			public boolean isLabelProperty(Object arg0, String arg1) {
				return false;
			}

			public void removeListener(ILabelProviderListener arg0) {

			}

		});

		List<Object> list = new ArrayList<Object>();
		
		EvaluateExtentionHandler extentionHandler = new EvaluateExtentionHandler();
		extentionHandler.execute(Platform.getExtensionRegistry());		
		List<IDeveloperStudioProviderData> typesList = Arrays.asList(extentionHandler.getType());
		list.addAll(typesList);
		treeViewer.setInput(list.toArray(new IDeveloperStudioProviderData[] {}));
		return container;
	}

	private void updateOKButtonStatus() {
		Object firstElement = getSelectedElement();
		boolean okButtonEnabled = firstElement == null ? false
				: isContainsClass(firstElement, getType());
		getButton(IDialogConstants.OK_ID).setEnabled(okButtonEnabled);
	}

	private boolean isContainsClass(Object objectToTest, Class<?>[] classes) {
		for (Class<?> class1 : classes) {
			try {
				class1.cast(objectToTest);
				return true;
			} catch (Exception e) {
				//No need to log as this is an expected result/behaviour
				//log.error("Object is not an instance of "+ class1, e);
			}
		}
		return false;
	}

	protected void okPressed() {
		//Object selectedElement = getSelectedElement();
		//IDeveloperStudioElement resource = (IDeveloperStudioElement) selectedElement;
		super.okPressed();
	}

	private Object getSelectedElement() {
		return ((ITreeSelection) treeViewer.getSelection()).getFirstElement();
	}


	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		updateOKButtonStatus();
	}


	protected Point getInitialSize() {
		return new Point(464, 335);
	}

	public void setType(Class<?>[] type) {
		this.type = type;
	}

	public Class<?>[] getType() {
		return type;
	}

	public void setSelectedPath(String selectedPath) {
		this.selectedPath = selectedPath;
	}

	public String getSelectedPath() {
		return selectedPath;
	}

	private void updateSelectedElement() {
		Object selectedElement = getSelectedElement();
		if (selectedElement instanceof IDeveloperStudioElement) {
			setSelectedPath(((IDeveloperStudioElement) selectedElement).getKey());
		} else {
			setSelectedPath(null);
		}
	}

	public void setFilters(Map<String, List<String>> filters) {
		this.filters = filters;
	}

	public Map<String, List<String>> getFilters() {
		return filters;
	}

	public void configureDialog(String title, boolean showOpenResourceCheckBox,
			boolean showCreateNewResourceLink) {
		this.title = title;
	}

}
