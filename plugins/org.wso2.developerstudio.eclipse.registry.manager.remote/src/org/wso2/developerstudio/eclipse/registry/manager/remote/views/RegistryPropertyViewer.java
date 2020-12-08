/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.manager.remote.views;

import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.wso2.carbon.registry.core.Association;
import org.wso2.carbon.registry.core.Comment;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.Tag;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.ws.client.registry.WSRegistryClientUtils;
import org.wso2.carbon.registry.ws.client.registry.WSRegistryServiceClient;
import org.wso2.carbon.registry.ws.stub.xsd.WSAssociation;
import org.wso2.carbon.registry.ws.stub.xsd.WSComment;
import org.wso2.carbon.registry.ws.stub.xsd.WSResourceData;
import org.wso2.carbon.registry.ws.stub.xsd.WSTag;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.core.RegistryAssociation;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.RegistryInformationEditorObservable;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.RegistryItemSelectionListener;
import org.wso2.developerstudio.eclipse.registry.base.managers.RemoteContentManager;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.registry.manager.remote.Activator;

public class RegistryPropertyViewer extends ViewPart implements
		RegistryItemSelectionListener, Observer{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private static final String DEPENDENCY_ASSOCIATION_TYPE = "depends";

	TabFolder tabFolder;
	private RegistryResourceNode registryResourcePathData;
	TabItem tabPageTags;
//	TabItem tabPageGeneralInfo;
	TabItem tabPageComments;
	TabItem tabPageProperties;
	TabItem tabPageDependencies;
	TabItem tabPageAssociations;
	private Action actionAddProperty;
	private Action actionAddTag;
	private Action actionAddComment;
	private Action actionAddDependency;
	private Action actionAddAssociation;
//	private Action actionRemoveProperty;
//	private Action actionRemoveTag;
//	private Action actionRemoveComment;
//	private Action actionRemoveDependency;
//	private Action actionRemoveAssociation;
	private Action actionRefresh;
	private Label lblNoData;

	public void createPartControl(Composite parent) {
		tabFolder = new TabFolder(parent, SWT.BORDER);
		RegistryBrowserView.setRegistryPropertyViewer(this);
		tabFolder.setBackground(tabFolder.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		createTabPages();
		createToolbar();
		tabFolder.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
				decideToolBarButtons();
			}

			public void widgetSelected(SelectionEvent arg0) {
				decideToolBarButtons();
			}

		});
		lblNoData = new Label(tabFolder, SWT.CENTER);
		lblNoData.setBackground(tabFolder.getBackground());
//		lblNoData
//				.setText("Please double click on a registry resource/collection in registry browser viewer");
		decideToolBarButtons();
		try {
			if (getRegistryResourcePathData() != null) {
				updateMe(getRegistryResourcePathData().getConnectionInfo().getRegistry().getAll(getRegistryResourcePathData().getRegistryResourcePath()));
			}
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
	}

	private void createTabPages() {
//		tabPageGeneralInfo = new TabItem(tabFolder, SWT.NULL);
//		tabPageGeneralInfo.setText("Information");

		tabPageProperties = new TabItem(tabFolder, SWT.NULL);
		tabPageProperties.setText("Properties");

		tabPageTags = new TabItem(tabFolder, SWT.NULL);
		tabPageTags.setText("Tags");

		tabPageComments = new TabItem(tabFolder, SWT.NULL);
		tabPageComments.setText("Comments");

		tabPageDependencies = new TabItem(tabFolder, SWT.NULL);
		tabPageDependencies.setText("Dependencies");

		tabPageAssociations = new TabItem(tabFolder, SWT.NULL);
		tabPageAssociations.setText("Associations");
	}

	public void setFocus() {
	}

	public void setSelectionChanged(
			RegistryResourceNode selectedRegistryResourcePathData) {
		setRegistryResourcePathData(selectedRegistryResourcePathData);
	}

	private void updateInfo(WSResourceData wsResourceData) throws InvalidRegistryURLException, UnknownRegistryException{
//		updateGeneralInfo();
//		WSResourceData wsResourceData = getRegistryResourcePathData().getConnectionInfo().getRegistry().getAll(getRegistryResourcePathData().getRegistryResourcePath());
		updateProperties(wsResourceData);
		updateTags(wsResourceData);
		updateComments(wsResourceData);
		RegistryAssociation[] wsRegistryAssociations = getWSRegistryAssociations(wsResourceData);
		updateDependencies(wsRegistryAssociations);
		updateAssociations(wsRegistryAssociations);
	}

	private void updateProperties(WSResourceData wsResourceData) throws InvalidRegistryURLException, UnknownRegistryException{
		if (getRegistryResourcePathData() == null) {
			setBlankPage(tabPageProperties);
			return;
		}
		TableViewer viewer = new TableViewer(tabFolder, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		String[] titles = { "Name", "Value" };
		int[] bounds = { 100, 100 };
		Table table = viewer.getTable();

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
		}
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		Resource resource = null;
		if(wsResourceData!=null){
			try {
	            resource= WSRegistryClientUtils.transformWSResourcetoResource((WSRegistryServiceClient)getRegistryResourcePathData()
	                                                          				.getConnectionInfo()
	                                                        				.getRegistry().getRegistry(), wsResourceData.getResource(), null);
            } catch (RegistryException e) {
	            e.printStackTrace();
            }
		}
		
		if(resource==null){
		 resource= getRegistryResourcePathData()
				.getConnectionInfo()
				.getRegistry()
				.getResourcesPerCollection(
						getRegistryResourcePathData().getRegistryResourcePath());
		}
		Properties properties = resource.getProperties();
		for (Enumeration e = properties.keys(); e.hasMoreElements(); /**/) {
			String key = (String) e.nextElement();
			String value = resource.getPropertyValues(key).get(0) == null ? ""
					: resource.getPropertyValues(key).get(0).toString();
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] { key, value });
		}
		tabPageProperties.setControl(table);
	}

	private void updateTags(WSResourceData wsResourceData) throws InvalidRegistryURLException, UnknownRegistryException{
		if (getRegistryResourcePathData() == null) {
			setBlankPage(tabPageTags);
			return;
		}
		ListViewer listViewer = new ListViewer(tabFolder);
		
		Tag[] tags=null;
		if (wsResourceData != null) {
			WSTag[] wsTags = new WSTag[0] ;
	        wsTags = wsResourceData.getTags();
	        if (wsTags != null) {
	            Tag[] transformed = new Tag[wsTags.length];
	            for (int i = 0; i < wsTags.length; i++) {
		            transformed[i] = WSRegistryClientUtils.transformWSTagToTag(wsTags[i]);
	            }
	            tags = transformed;
            }else{
            	tags=new Tag[0];
            }
        }
		
		 if (tags == null) {
	        tags =
	               getRegistryResourcePathData().getConnectionInfo()
	                                            .getRegistry()
	                                            .getTags(getRegistryResourcePathData().getRegistryResourcePath());
        }
		listViewer.setContentProvider(new IStructuredContentProvider() {

			public Object[] getElements(Object arg0) {
				if (arg0 instanceof Tag[]) {
					Tag[] tags = (Tag[]) arg0;
					return tags;
				}
				return new Object[] {};
			}

			public void dispose() {

			}

			public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

			}

		});
		listViewer.setLabelProvider(new LabelProvider() {
			public Image getImage(Object element) {
				return null;
			}

			public String getText(Object element) {
				if (element instanceof Tag)
					return ((Tag) element).getTagName();
				return null;
			}
		});
		listViewer.setInput(tags);
		tabPageTags.setControl(listViewer.getControl());

	}

	private void updateComments(WSResourceData wsResourceData) throws InvalidRegistryURLException, UnknownRegistryException{
		if (getRegistryResourcePathData() == null) {
			setBlankPage(tabPageComments);
			return;
		}
		TableViewer viewer = new TableViewer(tabFolder, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		String[] titles = { "Comment" };
		int[] bounds = { 100 };
		Table table = viewer.getTable();

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
		}
		table.setHeaderVisible(false);
		table.setLinesVisible(true);
		Comment[] comments=null;
		if (wsResourceData != null) {
			 WSComment[] wsComments=new WSComment[0];
	         wsComments= wsResourceData.getComments();
	         if (wsComments != null) {
	            Comment[] transformed = new Comment[wsComments.length];
	            for (int i = 0; i < wsComments.length; i++) {
		            transformed[i] =
		                             WSRegistryClientUtils.WSCommenttoRegistryComment(wsComments[i]);
	            }
	            comments = transformed;
            }else{
            	comments= new Comment[0];
            }
        }
		if (comments == null) {
	        comments =
	                   getRegistryResourcePathData().getConnectionInfo()
	                                                .getRegistry()
	                                                .getComments(getRegistryResourcePathData().getRegistryResourcePath());
        }
		for (Comment comment : comments) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(comment.getCreatedTime() + " by "
					+ comment.getAuthorUserName() + "\n"
					+ comment.getDescription());
		}

		tabPageComments.setControl(table);
	}

	private void updateDependencies(RegistryAssociation[] registryAssociations) throws InvalidRegistryURLException, UnknownRegistryException{
		if (getRegistryResourcePathData() == null) {
			setBlankPage(tabPageDependencies);
			return;
		}
		TableViewer viewer = new TableViewer(tabFolder, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		String[] titles = { "Dependency" };
		int[] bounds = { 100 };
		Table table = viewer.getTable();

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
		}
		table.setHeaderVisible(false);
		table.setLinesVisible(false);

		RegistryAssociation[] associations=null;
		if (registryAssociations !=null) {
	        associations = registryAssociations;
        }else {
		 associations = getRegistryResourcePathData()
				.getConnectionInfo().getRegistry().getAssociations(
						(getRegistryResourcePathData()
								.getRegistryResourcePath()),
						DEPENDENCY_ASSOCIATION_TYPE);
        }
		for (RegistryAssociation association : associations) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(association.getDestinationPath());
		}

		tabPageDependencies.setControl(table);
	}


	private void updateAssociations(RegistryAssociation[] registryAssociations) throws InvalidRegistryURLException, UnknownRegistryException{
		if (getRegistryResourcePathData() == null) {
			setBlankPage(tabPageAssociations);
			return;
		}
		TableViewer viewer = new TableViewer(tabFolder, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		String[] titles = { "Path", "Type" };
		int[] bounds = { 100, 100 };
		Table table = viewer.getTable();

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
		}
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		RegistryAssociation[] associations=null;
		if (registryAssociations !=null) {
	        associations = registryAssociations;
        }else {
	        associations =
	                       getRegistryResourcePathData().getConnectionInfo()
	                                                    .getRegistry()
	                                                    .getAllAssociations(getRegistryResourcePathData().getRegistryResourcePath());
        }
		for (RegistryAssociation association : associations) {
			if (!association.getAssociationType().equalsIgnoreCase(
					DEPENDENCY_ASSOCIATION_TYPE)) {
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {
						association.getDestinationPath(),
						association.getAssociationType() });
			}
		}
		tabPageAssociations.setControl(table);
	}

	/**
     * @param wsResourceData
     * @param associations
     * @return
     */
    private RegistryAssociation[] getWSRegistryAssociations(WSResourceData wsResourceData) {
	    if (wsResourceData != null) {
			WSAssociation[] wsAssociations=new WSAssociation[0];
	        wsAssociations = wsResourceData.getAssociations();
	        if (wsAssociations != null) {
	            RegistryAssociation[] transformed = new RegistryAssociation[wsAssociations.length];
	            for (int i = 0; i < wsAssociations.length; i++) {
		            transformed[i] =
		                             Registry.createRegistryAssociation(WSRegistryClientUtils.transformWSAssociationToAssociation(wsAssociations[i]));
	            }
	            return transformed;
            }else{
            	return new RegistryAssociation[0];
            }
        }
	    return null;
    }

	private void setBlankPage(TabItem tabpage) {
		tabpage.setControl(lblNoData);
	}

//	private void updateGeneralInfo() throws InvalidRegistryURLException, UnknownRegistryException{
//		if (getRegistryResourcePathData() == null) {
//			setBlankPage(tabPageGeneralInfo);
//			return;
//		}
//
//		Composite composite = new Composite(tabFolder, SWT.NONE);
//		composite.setBackground(tabFolder.getBackground());
//		GridLayout gridLayout = new GridLayout(2, false);
//		gridLayout.marginWidth = 20;
//		composite.setLayout(gridLayout);
//		String path = getRegistryResourcePathData().getRegistryResourcePath();
//		Registry registry = getRegistryResourcePathData()
//				.getConnectionInfo().getRegistry();
//		int rating = registry
//				.getRating(path, getRegistryResourcePathData()
//						.getConnectionInfo().getUsername());
//		float averageRating = registry.getAverageRating(path);
//
//		String[] names = new String[] { "Url", "Path", "Created",
//				"Last Modified", "Media Type", "My Rating", "Average Rating",
//				"Description" };
//		Resource resource = registry.get(path);
//
//		String[] values = new String[] {
//				getRegistryResourcePathData().getConnectionInfo().getUrl()
//						.toString(),
//				path,
//				resource.getCreatedTime().toString() + " by "
//						+ resource.getAuthorUserName(),
//				resource.getLastModified().toString() + " by "
//						+ resource.getLastUpdaterUserName(),
//				resource.getMediaType() == null ? "Not Specified" : resource
//						.getMediaType(), Integer.toString(rating),
//				Float.toString(averageRating), resource.getDescription() };
//		for (int i = 0; i < names.length; i++) {
//			String name = names[i];
//			String value = values[i];
//			SWTControlUtils.createLabel(composite, SWT.NONE, name,
//					new GridData(), composite.getBackground(), new Font(null,
//							"", 8, SWT.BOLD));
//			SWTControlUtils.createLabel(composite, SWT.NONE, value,
//					new GridData(), composite.getBackground(), null);
//		}
//
//		tabPageGeneralInfo.setControl(composite);
//	}

	public void updateMe(WSResourceData wsResourceData) throws InvalidRegistryURLException, UnknownRegistryException {
		updateInfo(wsResourceData);
		decideToolBarButtons();
	}

	private void createToolbar() {
		actionAddProperty = new Action("Edit Properties") {
			public void run() {
				RegistryResourceNode r = getRegistryResourcePathData();
				RegistryResourceEditor openFormEditor = getRegistryResourceEditor(r);
				openFormEditor.performAction(IRegistryFormEditorPage.PAGE_PROPERTIES,
											 IRegistryFormEditorPage.ACTION_ADD_PROPERTY, 
											 null);

			}
		};
		actionAddTag = new Action("Edit Tags") {
			public void run() {
				RegistryResourceNode r = getRegistryResourcePathData();
				RegistryResourceEditor openFormEditor = getRegistryResourceEditor(r);
				openFormEditor.performAction(IRegistryFormEditorPage.PAGE_TAGS,
											 IRegistryFormEditorPage.ACTION_ADD_TAGS, 
											 null);
			}
		};
		actionAddComment = new Action("Edit Comments") {
			public void run() {
				RegistryResourceNode r = getRegistryResourcePathData();
				RegistryResourceEditor openFormEditor = getRegistryResourceEditor(r);
				openFormEditor.performAction(IRegistryFormEditorPage.PAGE_COMMENTS,
											 IRegistryFormEditorPage.ACTION_ADD_COMMENT, 
											 null);
			}
		};
		actionAddDependency = new Action("Edit Dependencies") {
			public void run() {
				RegistryResourceNode r = getRegistryResourcePathData();
				RegistryResourceEditor openFormEditor = getRegistryResourceEditor(r);
				openFormEditor.performAction(IRegistryFormEditorPage.PAGE_DEPENDENCY,
											 IRegistryFormEditorPage.ACTION_ADD_DEPENDENCY, 
											 null);

			}
		};
		actionAddAssociation = new Action("Edit Associations") {
			public void run() {
				RegistryResourceNode r = getRegistryResourcePathData();
				RegistryResourceEditor openFormEditor = getRegistryResourceEditor(r);
				openFormEditor.performAction(IRegistryFormEditorPage.PAGE_ASSOCIATIONS,
						                     IRegistryFormEditorPage.ACTION_ADD_ASSOCIATION, 
						                     null);
			}
		};
//		actionRemoveProperty = new Action("Remove Property") {
//			public void run() {
//
//			}
//		};
//		actionRemoveTag = new Action("Remove Tag") {
//			public void run() {
//				
//			}
//		};
//		actionRemoveComment = new Action("Remove Comment") {
//			public void run() {
//
//			}
//		};
//		actionRemoveDependency = new Action("Remove Dependency") {
//			public void run() {
//
//			}
//		};
//		actionRemoveAssociation = new Action("Remove Association") {
//			public void run() {
//
//			}
//		};
		actionRefresh = new Action("Refresh") {
			public void run() {
				try {
					updateMe(getRegistryResourcePathData().getConnectionInfo().getRegistry().getAll(getRegistryResourcePathData().getRegistryResourcePath()));
				} catch (Exception e) {
					log.error(e);
				}
			}
		};
		actionAddProperty.setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_ADD_PROPERTIES));
		actionAddTag.setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_ADD_TAGS));
		actionAddComment.setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_ADD_COMMENT));
		actionAddDependency.setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_ADD_DEPENDENCY));
		actionAddAssociation.setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_ADD_ASSOCIATION));
//		actionRemoveProperty.setImageDescriptor(ImageUtils
//				.getImageDescriptor(ImageUtils.ACTION_ADD_PROPERTIES));
//		actionRemoveTag.setImageDescriptor(ImageUtils
//				.getImageDescriptor(ImageUtils.ACTION_ADD_TAGS));
//		actionRemoveComment.setImageDescriptor(ImageUtils
//				.getImageDescriptor(ImageUtils.ACTION_ADD_COMMENT));
//		actionRemoveDependency.setImageDescriptor(ImageUtils
//				.getImageDescriptor(ImageUtils.ACTION_ADD_DEPENDENCY));
//		actionRemoveAssociation.setImageDescriptor(ImageUtils
//				.getImageDescriptor(ImageUtils.ACTION_ADD_ASSOCIATION));
		actionRefresh.setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_REFERESH));

	}
	
	private RegistryResourceEditor getRegistryResourceEditor(
			RegistryResourceNode r) {
		ResourceEditorInput ei = RemoteContentManager
				.getEditorInput(r);
		RegistryResourceEditor openFormEditor = RemoteContentManager
				.openFormEditor(ei);
		openFormEditor.getRegInforChangeObservable().addObserver(this);
		return openFormEditor;
	}
	
	private void showToolBarButtons(Action[] actions) {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		mgr.removeAll();
		for (Action action : actions) {
			mgr.add(action);
		}
		mgr.update(true);
	}

	private void decideToolBarButtons() {
		int selectionIndex = tabFolder.getSelectionIndex();
		TabItem item = tabFolder.getItem(selectionIndex);
		if (getRegistryResourcePathData() == null)
			showToolBarButtons(new Action[] {});
//		else if (item == tabPageGeneralInfo)
//			showToolBarButtons(new Action[] { actionRefresh });
		else if (item == tabPageProperties)
			showToolBarButtons(new Action[] { actionRefresh, actionAddProperty});
		else if (item == tabPageTags)
			showToolBarButtons(new Action[] { actionRefresh, actionAddTag});
		else if (item == tabPageComments)
			showToolBarButtons(new Action[] { actionRefresh, actionAddComment});
		else if (item == tabPageDependencies)
			showToolBarButtons(new Action[] { actionRefresh,
					actionAddDependency});
		else if (item == tabPageAssociations)
			showToolBarButtons(new Action[] { actionRefresh,
					actionAddAssociation});

	}

	public void setRegistryResourcePathData(
			RegistryResourceNode registryResourcePathData) {
		this.registryResourcePathData = registryResourcePathData;
	}

	public RegistryResourceNode getRegistryResourcePathData() {
		return registryResourcePathData;
	}

	public void update(Observable o, Object arg) {
		if (o instanceof RegistryInformationEditorObservable) {
			RegistryInformationEditorObservable r = (RegistryInformationEditorObservable) o;
			setRegistryResourcePathData(r.getRegResourceNode());
			Display.getDefault().asyncExec(new Runnable(){
				public void run() {
					try {
						updateMe(getRegistryResourcePathData().getConnectionInfo().getRegistry().getAll(getRegistryResourcePathData().getRegistryResourcePath()));
					} catch (InvalidRegistryURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnknownRegistryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}});
				
		} 
		
	}

}
