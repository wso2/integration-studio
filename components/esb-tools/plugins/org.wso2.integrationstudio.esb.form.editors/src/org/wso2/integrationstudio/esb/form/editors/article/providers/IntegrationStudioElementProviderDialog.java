/*
 * Copyright (c) 2014- 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.esb.form.editors.article.providers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.integrationstudio.esb.core.EsbConfigurationManager;
import org.wso2.integrationstudio.esb.core.interfaces.IEsbEndpoint;
import org.wso2.integrationstudio.esb.core.interfaces.IEsbLocalEntry;
import org.wso2.integrationstudio.esb.core.interfaces.IEsbSequence;
import org.wso2.integrationstudio.general.project.dialogs.NewResourceTemplateDialog;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioElement;
import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProvider;
import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProviderData;
import org.wso2.integrationstudio.registry.core.RegistryManager;
import org.wso2.integrationstudio.registry.core.interfaces.IRegistryFile;



public class IntegrationStudioElementProviderDialog extends Dialog {
	private Class<?>[] type;
	private TreeViewer treeViewer;
	private String selectedPath = null;
	private String ipathOfselection = null;
	private Button chkOpenResource;
	private static IIntegrationStudioLog log = Logger.getLog("org.wso2.integrationstudio.esb.editor");
	private Map<String, List<String>> filters;
	private String title;
	private boolean showOpenResourceCheckBox = true;
	private boolean showCreateNewResourceLink = false;
	Link createNewLink;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public IntegrationStudioElementProviderDialog(Shell parentShell, Class<?>[] type, Map<String, List<String>> filters) {
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

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
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
				if (o instanceof IIntegrationStudioProviderData[]) {
					IIntegrationStudioProviderData[] oo = (IIntegrationStudioProviderData[]) o;
					for (IIntegrationStudioProviderData data : oo) {
						IIntegrationStudioProvider provider = data
								.getProvider();
						if (isChildElementsPresent(provider)) {
							list.add(data);
						}
					}
				} else if (o instanceof IIntegrationStudioProvider
						|| o instanceof IIntegrationStudioProviderData) {
					IIntegrationStudioProvider provider = o instanceof IIntegrationStudioProvider ? (IIntegrationStudioProvider) o
							: ((IIntegrationStudioProviderData) o)
									.getProvider();
					IIntegrationStudioElement[] resources = provider.getElements(getFilters());
					if (resources != null) {
						list.addAll(Arrays.asList(resources));
					}
					IIntegrationStudioProvider[] categories = provider.getCategories(getFilters());
					if (categories != null) {
						list.addAll(Arrays.asList(categories));
					}
				} else if (o instanceof IIntegrationStudioElement) {
					IIntegrationStudioElement element = (IIntegrationStudioElement) o;
					list.addAll(Arrays.asList(element.getChildren(getFilters())));
				}
				return list.toArray();
			}
		

			private boolean isChildElementsPresent(
					IIntegrationStudioProvider provider) {
				IIntegrationStudioElement[] resources = provider.getElements(getFilters());
				IIntegrationStudioProvider[] categories = provider.getCategories(getFilters());
				return (resources != null && resources.length > 0)
						|| (categories != null && categories.length > 0);
			}

			public Object getParent(Object arg0) {
				return null;
			}

			public boolean hasChildren(Object o) {
				if (o instanceof IIntegrationStudioProviderData[]) {
					return ((IIntegrationStudioProviderData[]) o).length > 0;
				} else if (o instanceof IIntegrationStudioProviderData) {
					IIntegrationStudioProviderData provider = (IIntegrationStudioProviderData) o;
					return isChildElementsPresent(provider
							.getProvider());
				} else if (o instanceof IIntegrationStudioProvider) {
					IIntegrationStudioProvider provider = (IIntegrationStudioProvider) o;
					return isChildElementsPresent(provider);
				} else if (o instanceof IIntegrationStudioElement) {
					IIntegrationStudioElement element = (IIntegrationStudioElement) o;
					return element.hasChildren(getFilters());
				}
				return false;
			}

			public Object[] getElements(Object o) {
				return getChildren(o);
			}

			public void dispose() {
				// TODO Auto-generated method stub
			}

			public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
				// TODO Auto-generated method stub
			}
		});
		treeViewer.setLabelProvider(new ILabelProvider() {
			public Image getImage(Object o) {
				if (o instanceof IIntegrationStudioProviderData) {
					IIntegrationStudioProviderData oo = (IIntegrationStudioProviderData) o;
					if (oo.getProvider().getIcon() != null) {
						return oo.getProvider().getIcon().createImage();
					}
				} else if (o instanceof IIntegrationStudioProvider) {
					IIntegrationStudioProvider provider = (IIntegrationStudioProvider) o;
					if (provider.getIcon() != null) {
						return provider.getIcon().createImage();
					}
				} else if (o instanceof IIntegrationStudioElement) {
					IIntegrationStudioElement resource = (IIntegrationStudioElement) o;
					if (resource.getIcon() != null) {
						return resource.getIcon().createImage();
					}
				}
				return null;
			}

			public String getText(Object o) {
				if (o instanceof IIntegrationStudioProviderData) {
					IIntegrationStudioProviderData oo = (IIntegrationStudioProviderData) o;
					return oo.getName();
				} else if (o instanceof IIntegrationStudioProvider) {
					IIntegrationStudioProvider provider = (IIntegrationStudioProvider) o;
					return provider.getText();
				} else if (o instanceof IIntegrationStudioElement) {
					IIntegrationStudioElement resource = (IIntegrationStudioElement) o;
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
		List<Object> list=new ArrayList<Object>();
		
		List<Class<?>> typesList = Arrays.asList(type);
		
		//IRegistryFile.class, IEsbEndpoint.class, IEsbSequence.class, IEsbLocalEntry.class
		if (typesList.contains(IRegistryFile.class)) {
			list.addAll(Arrays.asList(RegistryManager.getResourceProviders(true)));
		}
		
		if (typesList.contains(IEsbEndpoint.class)) {
			list.addAll(Arrays.asList(EsbConfigurationManager.getEndpointProviders(true)));
		}
		
		if (typesList.contains(IEsbSequence.class)) {
			list.addAll(Arrays.asList(EsbConfigurationManager.getSequenceProviders(true)));
		}
		
		if (typesList.contains(IEsbLocalEntry.class)) {
			list.addAll(Arrays.asList(EsbConfigurationManager.getLocalEntryProviders(true)));
		}
		

		treeViewer.setInput(list.toArray(new IIntegrationStudioProviderData[]{}));
		
		if (showOpenResourceCheckBox) {
			chkOpenResource = new Button(container, SWT.CHECK);
			chkOpenResource.setText("Open the resource for editing");
		}
		
		if (showCreateNewResourceLink) {
			createNewLink = new Link(container, SWT.NONE);
			createNewLink.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					openNewResourceTemplateDialog();
				}
			});
			createNewLink.setText("<a>Create && point to a new DataMapper Configuration. </a>");
		}
		
		
		return container;
	}

	private void updateOKButtonStatus() {
		Object firstElement = getSelectedElement();
		boolean okButtonEnabled = firstElement==null? false:isContainsClass(firstElement,getType());
		getButton(IDialogConstants.OK_ID).setEnabled(okButtonEnabled);
	}

	private boolean isContainsClass(Object objectToTest, Class<?>[] classes){
		for (Class<?> class1 : classes) {
			try {
				class1.cast(objectToTest);
				return true;
			} catch (Exception e) {
				//not an instace of
			} 
		}
		return false;
	}
	
	protected void okPressed() {
		Object selectedElement = getSelectedElement();
		IIntegrationStudioElement resource = (IIntegrationStudioElement) selectedElement;
		
		/*
		if (resource.getSource() instanceof IFile) {
			IFile selectedIFile = (IFile) resource.getSource();
			ipathOfselection = selectedIFile.getFullPath().toString();
			
			IProject project = selectedIFile.getProject();
			RegistryFileImpl rpi = (RegistryFileImpl)selectedElement;
			String fileName = rpi.getName();
			String fullPath = rpi.getPath();
			int index = fullPath.lastIndexOf('/');
			String path = "";
			if (index > 0) {
				path = fullPath.substring(0,index);
			}
			
			if (path != null && !path.isEmpty())
				try {
					CreateNewConfigurationDialog.createRegistryResourcesForInputScemaAndOutputSchema(fileName, project, path);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
		}
		*/
	
		
		
		if (showOpenResourceCheckBox && chkOpenResource.getSelection()) {
			try {
				if (resource.getSource() instanceof IFile) {
					IDE.openEditor(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage(),
							(IFile) resource.getSource());
				} else if (resource.getSource() instanceof File
						&& ((File) resource.getSource()).isFile()) {
					IFileStore fileStore = EFS.getLocalFileSystem().getStore(((File)resource.getSource()).toURI());
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IDE.openEditorOnFileStore(page, fileStore);
				}
			} catch (PartInitException e) {
				log.error("Error opening the resource file",e);
			}

		}
		super.okPressed();
	}

	private Object getSelectedElement() {
		return ((ITreeSelection) treeViewer.getSelection()).getFirstElement();
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		updateOKButtonStatus();
	}

	/**
	 * Return the initial size of the dialog.
	 */
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
	
	public String getIPathOfSelection() {
		return ipathOfselection;
	}

	private void updateSelectedElement() {
		Object selectedElement = getSelectedElement();
		if (selectedElement instanceof IIntegrationStudioElement) {
			setSelectedPath(((IIntegrationStudioElement) selectedElement).getKey());
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

	public void configureDialog(String title, boolean showOpenResourceCheckBox, boolean showCreateNewResourceLink) {
		this.title = title;
		this.showOpenResourceCheckBox = showOpenResourceCheckBox;
		this.showCreateNewResourceLink = showCreateNewResourceLink;
	}
	
	protected void openNewResourceTemplateDialog() {
		//FIXME handle this in a proper way
		try{
			NewResourceTemplateDialog newResourceTemplateDialog = new NewResourceTemplateDialog(getParentShell(),(Map<String, List<String>>) getFilters());
			//CreateNewConfigurationDialog newResourceTemplateDialog = new CreateNewConfigurationDialog(getParentShell(),(Map<String, List<String>>) getFilters());
			newResourceTemplateDialog.create();
			newResourceTemplateDialog.getShell().setText("New DataMapper Configuration");
			newResourceTemplateDialog.open();
			if (newResourceTemplateDialog.getReturnCode()==Window.OK){
				setSelectedPath(newResourceTemplateDialog.getSelectedPath());
				ipathOfselection = newResourceTemplateDialog.getIPathOfSelection();
			    this.close();
			}
		}finally{
			
		}

	}

}
