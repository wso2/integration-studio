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

package org.wso2.developerstudio.eclipse.registry.apim.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.CloneFailedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.registry.apim.action.Login;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.RegistryBrowserTraverseListener;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.managers.RemoteContentManager;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.RegistryTreeViewer;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.registry.manager.remote.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.remote.dialog.RegistryInfoDialog;
import org.wso2.developerstudio.eclipse.registry.manager.remote.views.RegistryPropertyViewer;
import org.wso2.developerstudio.eclipse.registry.manager.remote.views.ResourceInfoViewer;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.event.EsbEditorEvent;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.xml.sax.SAXException;

public class RegistryBrowserAPIMView extends ViewPart implements Observer {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
    private static final String SELECT_FILE_TO_BE_UPLOADED = "Select file to be uploaded to the registry";
	private static final String ERROR_WHILE_PERFORMING_THIS_OPERATION_MSG = "Error while performing this operation";
	private static final String SUCCESSFULLY_DISCARDED_THE_LOCAL_CHANGES = "Successfully discarded the local changes";
	private static final String Q_DISCARD_LOCAL_CHANGES = "Are you sure you want to discard local changes ?";
	private static final String DISCARD_CHANGES_DIALOG_TITLE = "Discard Changes";
	private static final String DISCARD_LOCAL_CHANGES_TITLE = "discard local changes";
	private static final String Q_SAVE_CHANGES_AND_COMMIT = "' has been modified, Do you want to save changes and commit ?";
	private static final String SUCCESSFULLY_APPLIED_THE_LOCAL_CHANGES = "Successfully applied the local changes";
	private static final String ARE_YOU_SURE_YOU_WANT_TO_PUSH_CHANGES_INTO_REMOTE_REGISTRY = "Are you sure you want to push changes into remote registry ?";
	private static final String APPLY_CHANGES_DIALOG_TITLE = "Apply Changes";
	private static final String COMMIT_FILE_MENU_NAME = "Commit file ";
	private static final String PUSH_CHANGES_MENU_NAME = "Push Changes ";
	private static final String DO_YOU_WANT_TO_SAVE_CHANGES = "Do you want to save changes?";
	private static final String SPECIFY_A_NEW_NAME_TO_THE_RESOURCE = "Specify a new name to the resource";
	private static final String NEW_NAME_LABEL = "New name:";
	private static final String RENAME_RESOURCE_DIALOG_TITLE = "Rename resource";
	private static final String CREATE_SEQUENCE_DIALOG_TITLE = "Create Sequence";
	private static final String RESOURCE_MEDIA_TYPE = "application/xml";
	private static final String RESOURCE_ALREADY_EXISTS = "resource already exists!";
	private static final String PASTE_OPERATION_MONITOR = "Paste operation";
	private static final String THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE = "This operation cannot be performed because the ";
	private static final String CONTINUE = ". Continue?";
	private static final String WILL_BE_COPIED_TO = " will be copied to ";
	private static final String CONTINUE_COPY_PASTE = "Continue copy-paste...";
	private static final String COULD_NOT_CLOSE_ASSOCIATED_EDITOR_FOR_THIS_RESOURCE = "Could not close associated editor for this resource";
	private static final String DO_YOU_WANT_TO_SAVE_CHANGES_AND_COPY = "Do you want to save changes and copy?";
	private static final String TOOLBAR_ACTION_COMMIT = "Push all changes ";
	private static final String TOOLTIP_COMMIT_ALL_CHANGES = "Push all changes to the server";
	private static final String TOOLTIP_DISCARD_CHANGES = "Discard all local changes and synchronize with server";
	private static final String DISCARD_ALL_LOCAL_CHANGES = "discard all local changes ";
	private static final String EXIST_MSG = "There are uncommitted changes. Commit Changes ? \n(All changes will be discarded unless they are committed before exist)";
	private static final String DELETE_ACTION_LABEL = "Delete   ";
	private static final String RENAME_ACTION_LABEL = "Rename   ";
	private static final String CREATE_ACTION_LABEL = "Create   ";
	private static final String PASTE_ACTION_LABEL  = "Paste   ";
	private static final String COPY_ACTION_LABEL   = "Copy    ";
	private static final String LOGIN_ACTION_LABEL  = "Login   ";
	

	private static final int EXPAND_LEVEL = 4;
	private static final int LOGIN_SHELL_HEIGHT = 250;
	private static final int LOGIN_SHELL_WIDTH = 600;
	private static final String DEFAULT_PATH = "/";	
	private static final String APIM_CUSTOM_SEQUENCES_DEFAULT_PATH = "/_system/governance/apimgt/customsequences";
	
	private String uname;
	private String resourcePath;
	private String pwd;
	private URL serverURL;
	private String apimRegpath;
	
	private Action addRegistryAction;
	private Action discardAllchangesAction;
	private Action commitAllchangesAction;

	private Tree tree;
	private RegistryTreeViewer treeViewer;
	private RegistryURLNode regUrlNode1;
	private RegistryURLNode localUrlNode;
	private RegistryNode regNode;
	private RegistryResourceNode regResourceNode;
	private Map<String, RegistryResourceNode> changedResourceNodes;
	private Map<String, RegistryResourceNode> openNodesMap;
	private Set<RegistryResourceNode> openNodeSet;
	private Registry registry;
	private RegistryBrowserAPIMViewLabelProvider labelProvider;

	private ExceptionHandler exceptionHandler;
	//public static RegistryBrowserAPIMView lastInstance1;
	private static RegistryPropertyViewer registryPropertyViewer;
	private static ResourceInfoViewer resourceInfoViewer;

	private MenuManager apimMenuManager;
	private boolean isApiManagerview;
	private String apimRegPath;
	private Text txtTraverse;
	private boolean linkedWithEditor;
	public static final int CNTRL_KEY_CODE = 262144;
	boolean cntrlKeyPressed;

	private RegistryResourceNode selectedEditorRegistryResourcePathData;
	private RegistryResourceNode copyRegResourceNode;
	//private IEventBroker broker;
	private boolean traversePathChanged;

	private IContextActivation activation;
	private IHandlerActivation activateDeleteHandler;
	private IHandlerActivation activateRefreshHandler;
	private IHandlerActivation activateAddResourceHandler;
	private IHandlerActivation activateRenameHandler;
	private IHandlerActivation activateCopyHandler;
	private IHandlerActivation activatePasteHandler;
	




	public RegistryBrowserAPIMView() {
		super();
		setApiManagerview(true);	
		try {
			setApimRegPath(new Login().getRegpath());
		} catch (Exception e) {
			log.error("API Manager Registry path cannot be resolve due to", e);
			setApimRegPath(APIM_CUSTOM_SEQUENCES_DEFAULT_PATH);	 
		}
		

		EsbEditorEvent.CreateBroker(Activator.PLUGIN_ID);
		EsbEditorEvent.subscribe(getDoSaveEventHandler());
		
		changedResourceNodes = new HashMap<String, RegistryResourceNode>();
		exceptionHandler = new ExceptionHandler();
		this.localUrlNode = new RegistryURLNode();
		openNodeSet = new HashSet<RegistryResourceNode>();
		openNodesMap = new HashMap<String, RegistryResourceNode>();
		localUrlNode.addObserver(this);
		 
	}

	public static boolean isAPIMperspective(){
	
	IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	 IPerspectiveDescriptor perspective = workbenchWindow.getActivePage().getPerspective();
	
	if ("org.wso2.developerstudio.registry.remote.registry.apim.pespective".equals(perspective.getId())){
		return true;
	}
	return false;
}

	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IContextService contextService = (IContextService) getSite().getService(IContextService.class);
		activation = contextService.activateContext("org.wso2.developerstudio.registry.browser.keybindings.context");
	}

	public void init(IViewSite site, IMemento memento) throws PartInitException {
		init(site);
		 
	}

	public RegistryResourceNode getCopyRegResourceNode() {
		return copyRegResourceNode;
	}

	public void setCopyRegResourceNode(RegistryResourceNode copyRegResourceNode) {
		this.copyRegResourceNode = copyRegResourceNode;
	}

	public boolean isCntrlKeyPressed() {
		return cntrlKeyPressed;

	}

	public void setCntrlKeyPressed(boolean cntrlKeyPressed) {
		this.cntrlKeyPressed = cntrlKeyPressed;
	}
	
	public void createPartControl(Composite parent) {

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);
		createContent(parent);
		getSite().setSelectionProvider(treeViewer);
		createToolbar(parent);

	}
	
	@Override
	public void setFocus() {

	}
	
	public void update(Observable o, Object arg) {
		if (o instanceof RegistryBrowserTraverseListener) {
			RegistryBrowserTraverseListener r = (RegistryBrowserTraverseListener) o;
			traverseRegistryBrowser(r.getUrl(), r.getPath());
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					treeViewer.refresh(localUrlNode.isRefreshExisting());
				}
			});
		}
	}

	public void traverseRegistryBrowser(String url, String path) {
		List<RegistryNode> urlInfoList = localUrlNode.getUrlInfoList();
		RegistryNode correctRegistryData = null;
		for (RegistryNode registryData : urlInfoList) {
			if (registryData.getUrl().toString().equals(url) && path.startsWith(registryData.getRegistryStartingPath())) {
				correctRegistryData = registryData;
				break;
			}
		}
		if (correctRegistryData == null) {
			try {
				RegistryURLInfo registryUrlInfo = new RegistryURLInfo();

				registryUrlInfo.setPersist(false);
				registryUrlInfo.setUrl(new URL(url));
				registryUrlInfo.setPath(DEFAULT_PATH);
				correctRegistryData = localUrlNode.addRegistry(registryUrlInfo, null);
			} catch (MalformedURLException e) {
				log.error(e.getMessage(), e);
			}

		}
		selectTreeViewerPath(correctRegistryData, path);
	}

	public void dispose() {
		checkUnCommitChanages();
		cleanWorkSpace();

		deactivateActionHandlers();
		IContextService contextService = (IContextService) getSite().getService(IContextService.class);
		contextService.deactivateContext(activation);

		super.dispose();
	}

	private void checkUnCommitChanages() {
		if (!changedResourceNodes.isEmpty()) {

			if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), APPLY_CHANGES_DIALOG_TITLE,
					EXIST_MSG)) {
				Set<String> keySet = changedResourceNodes.keySet();
				for (String key : keySet) {

					RegistryResourceNode registryResourceNode = changedResourceNodes.get(key);
					try {
						commitSequence(registryResourceNode);
					} catch (InvalidRegistryURLException | UnknownRegistryException | IOException | CoreException e) {
						log.error("Error while committing changes on exist", e);
					}

				}
			}
		}
		changedResourceNodes.clear();
	}

	private void cleanWorkSpace() {
		for (RegistryResourceNode registryResourceNode : openNodeSet) {
			closeEditor(registryResourceNode);
		}
		IWorkspace ws = ResourcesPlugin.getWorkspace(); // Crash recovery system IProject[] projects =
		IProject[] projects = ws.getRoot().getProjects();
		for (IProject iProject : projects) {
			try {
				if (iProject != null && iProject.exists() && iProject.isOpen()
						&& iProject.hasNature(RemoteContentManager.ESB_REMOTE_TEMP_PROJECT_NATURE)) {

					iProject.delete(true, new NullProgressMonitor());
				}
			} catch (CoreException e) {
				log.error("Error while deleting the temp projects file due to " + e.getMessage(), e);
			}
		}
	}
	
	private void deactivateActionHandlers() {
	IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);

	handlerService.deactivateHandler(activateDeleteHandler);
	handlerService.deactivateHandler(activateRefreshHandler);
	handlerService.deactivateHandler(activateAddResourceHandler);
	handlerService.deactivateHandler(activateRenameHandler);
	handlerService.deactivateHandler(activateCopyHandler);
	handlerService.deactivateHandler(activatePasteHandler);
}

	public void removeRegistryNode(String url, String path) {
		List<RegistryNode> urlInfoList = localUrlNode.getUrlInfoList();
		RegistryNode correctRegistryData = null;
		for (RegistryNode registryData : urlInfoList) {
			if (registryData.getUrl().toString().equals(url) && path.startsWith(registryData.getRegistryStartingPath())) {
				correctRegistryData = registryData;
				break;
			}
		}
		localUrlNode.removeRegistry(correctRegistryData);
	}

	public void traverseRegistryBrowser(RegistryResourceNode registryResourcePathData) {
		selectTreeViewerPath(registryResourcePathData.getConnectionInfo(),
				registryResourcePathData.getRegistryResourcePath());
	}

	protected void loginToAPIMRegistry(Composite parent) throws InvalidRegistryURLException, UnknownRegistryException, MalformedURLException, URISyntaxException {
		exceptionHandler = new ExceptionHandler();

		RegistryInfoDialog dialog = null;
		dialog = new RegistryInfoDialog(parent.getShell(), regUrlNode1, getApimRegPath());
		dialog.setBlockOnOpen(true);
		dialog.create();
		dialog.getShell().setSize(LOGIN_SHELL_WIDTH, LOGIN_SHELL_HEIGHT);
		int status = dialog.open();
		if (status == Window.OK) {
			URI pathUri = null;
			try {
				pathUri = new URI(dialog.getServerUrl());
				serverURL = pathUri.toURL();
				uname = dialog.getUserName();
				pwd = dialog.getPasswd();
				apimRegpath = dialog.getPath();

				verifyRegistryPath(dialog);
				cloneRegistryModel();

			} catch (CloneFailedException e) {
				exceptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Registry cloning process has failed due to " + e.getMessage());
				log.error("Registry cloning process has failed due to " + e.getMessage(), e);
			}

		}

	}

	private void cloneRegistryModel() throws CloneFailedException {

	 Job job = new Job("Cloning Job") {
		
		@Override
		protected IStatus run(IProgressMonitor monitor) {
			try {
				regUrlNode1 = new RegistryURLNode();
				regUrlNode1.addRegistry(
						RegistryUrlStore.getInstance().addRegistryUrl(serverURL, uname, apimRegpath, isApiManagerview()), pwd);
				setUname(uname);
				setPwd(pwd);
				setServerURL(serverURL);

				List<RegistryNode> urlInfoList = regUrlNode1.getUrlInfoList();
				localUrlNode = new RegistryURLNode();
				localUrlNode.setUrlInfoList(urlInfoList);
				RegistryNode registryNode = urlInfoList.get(0);
				RegistryNode localRegnode = localUrlNode.getUrlInfoList().get(0);
				RegistryContentContainer registryContainer = registryNode.getRegistryContainer();
				RegistryContentContainer localContainer = new RegistryContentContainer();
				RegistryResourceNode localcustomSequenceNode = null;
				RegistryResourceNode remotecustomSequenceNode = registryContainer.getRegistryContent().get(0);

				localcustomSequenceNode = (RegistryResourceNode) remotecustomSequenceNode.clone();
				localContainer.addRegistryContent(localcustomSequenceNode);
				localRegnode.setRegistryContent(localContainer);
				updateDirtyState();
				Display.getDefault().syncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						treeViewer.setInput(localUrlNode);
						treeViewer.expandToLevel(EXPAND_LEVEL);
					}
				});	
				
			} catch (CloneNotSupportedException e) {
				 throw new CloneFailedException(e);
				
			}
			return Status.OK_STATUS;
		}
	};
	
	job.schedule();	
	}

	private void verifyRegistryPath(RegistryInfoDialog dialog) throws InvalidRegistryURLException,
			UnknownRegistryException {

		Registry reg = new Registry(uname, pwd, dialog.getServerUrl());
		reg.getResourcesPerCollection(getApimRegPath());
	}

	protected Control createContent(final Composite parent) {
		addControls(parent);
		addListeners();
		Menu menu = addContextMenu();
		apimMenuManager.setRemoveAllWhenShown(true);
		treeViewer.getControl().setMenu(menu);
		treeViewer.setInput(localUrlNode);

		return tree;

	}

	private void addControls(final Composite parent) {
		treeViewer = new RegistryTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER,
				exceptionHandler, false, true);
		tree = treeViewer.getTree();
		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = 450;
		data.heightHint = 250;
		tree.setLayoutData(data);
		labelProvider = new RegistryBrowserAPIMViewLabelProvider();
		treeViewer.setLabelProvider(labelProvider);
	}

	private void addListeners() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				final Object selectionEvent = event.getSelection();
				if (selectionEvent instanceof TreeSelection) {							
					Object object = ((TreeSelection) selectionEvent).getFirstElement();
					if (object instanceof RegistryResourceNode) {
						final RegistryResourceNode resourcePathObj = (RegistryResourceNode) object;
						openResourceInEditor(resourcePathObj);
					}	
				}
		 
			}
		});
	}
			
	private Menu addContextMenu() {
		ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_METADATA);
		apimMenuManager = new MenuManager("Actions menu", metadataImgDes, "org.wso2.apim.devs");
		Menu menu = apimMenuManager.createContextMenu(treeViewer.getControl());
		menu.setVisible(true);
		menu.setEnabled(true);
		apimMenuManager.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(final IMenuManager manager) {
				try {
					if (treeViewer.getSelection().isEmpty()) {
						return;
					}

					if (treeViewer.getSelection() instanceof IStructuredSelection) {
						IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();

						if (selection.getFirstElement() instanceof RegistryResourceNode) {
							RegistryResourceNode node = (RegistryResourceNode) selection.getFirstElement();
							if (node.getResourceType() == RegistryResourceType.RESOURCE) {

								manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
								manager.add(new Separator());
								manager.add(copySequenceAction(node));
								manager.add(renameSequenceAction(node));
								manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
								manager.add(new Separator());
								manager.add(deleteSequenceAction(node));
								
								if(node.isIsnew()){
									manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
									manager.add(new Separator());
									manager.add(commitSequenceAction(node));
									 
								}else{
									if (node.isIsmodifiyed() || node.isIsdeleted() || node.isRename()) {
										manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
										manager.add(new Separator());
										manager.add(commitSequenceAction(node));
										manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
										manager.add(new Separator());
										manager.add(discartSequenceAction(node));
									}
								}

							} else if (node.getResourceType() == RegistryResourceType.COLLECTION) {
								String resourceName = node.getResourceName();
								if ("in".equals(resourceName) || "out".equals(resourceName)
										|| "fault".equals(resourceName)) {
									manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
									manager.add(new Separator());
									manager.add(createSequenceAction(node));
									manager.add(importSequenceAction(node));
									manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
									manager.add(new Separator());

									final RegistryResourceNode copyRegResource = getCopyRegResourceNode();
									if (copyRegResource != null) {
										manager.add(pasteSequenceAction(node, copyRegResource));
									}
								}
							}
						}
					}
				} catch (Throwable e) {
					/* safe to ignore */
				}
			}

		});
		return menu;
	}

	private void createToolbar(final Composite parent) {
		addLoginToolbarAction(parent);
		discardAllChnangesToolbarAction();
		commitAllChangesToolbarAction();

		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		mgr.add(discardAllchangesAction);
		mgr.add(commitAllchangesAction);
		mgr.add(addRegistryAction);
		mgr.update(true);
	}

	private void commitAllChangesToolbarAction() {
		commitAllchangesAction = new Action(TOOLBAR_ACTION_COMMIT) {
			public void run() {
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), APPLY_CHANGES_DIALOG_TITLE,
						"Are You Sure, You want to Push all local changes into the remote APIManager server ?")) {
					pushAllchanges();
				}
			}
		};
		commitAllchangesAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_TO_REGSITRY));
		commitAllchangesAction.setToolTipText(TOOLTIP_COMMIT_ALL_CHANGES);
		commitAllchangesAction.setEnabled(false);
	}

	private void discardAllChnangesToolbarAction() {
		discardAllchangesAction = new Action(DISCARD_ALL_LOCAL_CHANGES) {
			public void run() {
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), DISCARD_CHANGES_DIALOG_TITLE,
						"Are you sure, that you want to discard all local changes ?")) {
					try {
						 
						 for (RegistryResourceNode registryResourceNode : openNodeSet) {
								closeEditor(registryResourceNode);
						 }
						changedResourceNodes.clear();	
						 
						updateDirtyState();
						cloneRegistryModel();
					} catch (CloneFailedException e) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Remote synchronisation",
								"Registry synchronisation process has failed due to " + e.getMessage());
						
						log.error("Registry cloning process has failed due to " + e.getMessage(), e);
					}
				}
			}
		};
		// Synchronise
		discardAllchangesAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ACTION_CHECK_OUT_MENU));
		discardAllchangesAction.setToolTipText(TOOLTIP_DISCARD_CHANGES);
		discardAllchangesAction.setEnabled(false);
	}

	private void addLoginToolbarAction(final Composite parent) {
		addRegistryAction = new Action(LOGIN_ACTION_LABEL) {
			public void run() {
				try {
					loginToAPIMRegistry(parent);
				} catch (InvalidRegistryURLException | UnknownRegistryException | MalformedURLException
						| URISyntaxException e) {
					 log.error("Failed to login to the APIManager view due to", e);
				}
			}
		};
		addRegistryAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ICON_USERS));
		addRegistryAction.setToolTipText("Login");
	}

	private void pushAllchanges() {
	    try {         
            Set<String> keySet = changedResourceNodes.keySet();
            for (String key : keySet) { 
                RegistryResourceNode registryResourceNode = changedResourceNodes.get(key);
                commitSequence(registryResourceNode);
            }
            changedResourceNodes.clear();
            updateDirtyState();
            Display.getDefault().asyncExec(new Runnable() {
                @SuppressWarnings({})
                @Override
                public void run() {
                    treeViewer.setInput(localUrlNode);
                    treeViewer.expandToLevel(EXPAND_LEVEL);
                    MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ",
                            SUCCESSFULLY_APPLIED_THE_LOCAL_CHANGES);
                }
            });   
        } catch (InvalidRegistryURLException | UnknownRegistryException | IOException | CoreException e) {
            MessageDialog.openError(Display.getCurrent().getActiveShell(), "Push Changes Dialog",
                    "Cannot push all the changes due to " + e.getMessage());
            log.error("Cannot push all the changes due to " + e.getMessage(), e);
        }	
	}

	private void updateDirtyState() {
		if (changedResourceNodes.isEmpty()) {
			discardAllchangesAction.setEnabled(false);
			commitAllchangesAction.setEnabled(false);
		} else {
			discardAllchangesAction.setEnabled(true);
			commitAllchangesAction.setEnabled(true);
		}
	}
	
	private void refreshTreeviewer(final RegistryResourceNode regResourceNode) {
		treeViewer.setInput(localUrlNode);
		RegistryNode registryNode = localUrlNode.getUrlInfoList().get(0);
		treeViewer.expandTree(registryNode, regResourceNode.getRegistryResourcePath());
	}
	
	private EventHandler getDoSaveEventHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						String fileName = (String) event.getProperty(IEventBroker.DATA);
						fileName = getLastTwoSegments(fileName);
						if (!openNodesMap.isEmpty()) {
							RegistryResourceNode registryResourceNode = openNodesMap.get(fileName);
							if (registryResourceNode != null) {
								if(registryResourceNode.isDirty()){
								 openNodesMap.remove(fileName);
								if (!registryResourceNode.isIsnew()) {
									registryResourceNode.setIsmodifiyed(true);
									changedResourceNodes.put(registryResourceNode.getRegistryResourcePath(),
									registryResourceNode);
									updateDirtyState();
									treeViewer.setInput(localUrlNode);
									RegistryNode registryNode = localUrlNode.getUrlInfoList().get(0);
									treeViewer.expandTree(registryNode, registryResourceNode.getRegistryResourcePath());
								}

						    	}else{
						    		registryResourceNode.setDirty(true);
						    	}
							} 

						}

					}

				
				});
			}
		};
	}

	private String getLastTwoSegments(String fileName) {
		org.eclipse.core.runtime.Path path = new org.eclipse.core.runtime.Path(fileName);
		 int segmentCount = path.segmentCount();
		 int firstSegmentCount=0;
		 if(segmentCount>2){
			 firstSegmentCount = segmentCount-2;
		 }else{
			 return fileName;
		 }
		 return path.removeFirstSegments(firstSegmentCount).toOSString();
	}
	
	private void openResourceInEditor(final RegistryResourceNode resourceNode) {
		
		try {
			new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
				public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
 
						monitor.beginTask("Opening the editor", 100);
						
						Display.getDefault().syncExec(new Runnable() {
							
							@Override
							public void run() {
								if (resourceNode.isIsdeleted()) {
									MessageDialogUtils.error(Display.getCurrent().getActiveShell(), resourceNode.getResourceName()
											+ " cannot be"
											+ " opened since this is marked as a deleted resource, if you want to open undo the delete "
											+ "operation and try again");
									return;
								}
								monitor.worked(20);
								File tempFile = null;
								if (resourceNode.isIsnew() || resourceNode.isRename()) {
									tempFile = resourceNode.getNewFile();
								}else{
									if (resourceNode.getNewFile() != null && resourceNode.getNewFile().exists()) {
										try {
											FileUtils.forceDelete(resourceNode.getLocalFile());
										} catch (IOException e) {
											log.error("Failed to delete the old file", e);
										}
									}
									
									tempFile = resourceNode.getLocalFile();
								}
								monitor.worked(30);
								final IEditorPart editor = RemoteContentManager.openFile(tempFile);
								monitor.worked(70);
								resourceNode.setFileEditor(editor);
								editor.getEditorSite().getPage().addPartListener(new IPartListener2() {
                                    
                                    @Override
                                    public void partVisible(IWorkbenchPartReference arg0) {
                                        // Do nothing
                                    }
                                    
                                    @Override
                                    public void partOpened(IWorkbenchPartReference arg0) {
                                        // Do nothing 
                                    }
                                    
                                    @Override
                                    public void partInputChanged(IWorkbenchPartReference arg0) {
                                        // Do nothing
                                    }
                                    
                                    @Override
                                    public void partHidden(IWorkbenchPartReference arg0) {
                                        // Do nothing
                                    }
                                    
                                    @Override
                                    public void partDeactivated(IWorkbenchPartReference arg0) {
                                        // Do nothing
                                    }
                                    
                                    @Override
                                    public void partClosed(IWorkbenchPartReference partRef) {
                                       if(partRef.getPart(false).equals(editor)){
                                           resourceNode.setFileEditor(null);
                                       }  
                                    }
                                    
                                    @Override
                                    public void partBroughtToTop(IWorkbenchPartReference arg0) {
                                        // Do nothing     
                                    }
                                    
                                    @Override
                                    public void partActivated(IWorkbenchPartReference arg0) {
                                        // Do nothing
                                    }
                                });
								openNodeSet.add(resourceNode);
								String absolutePath = resourceNode.getLocalFile().getAbsolutePath();
								absolutePath = getLastTwoSegments(absolutePath);
								openNodesMap.put(absolutePath, resourceNode);
								resourceNode.setDirty(false);
								resourceNode.setWorkspaceFile(RemoteContentManager.getWorkspaceFile()); 
								monitor.done();
								
							}
						});
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			log.error("Error opening sequence.", e);
		}
		
	}

	/*private EventHandler getOPenEditorEvent() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						TreeSelection selectionEvent = (TreeSelection) event.getProperty(IEventBroker.DATA);
						Object object = ((TreeSelection) selectionEvent).getFirstElement();
						if (object instanceof RegistryResourceNode) {
							final RegistryResourceNode resourcePathObj = (RegistryResourceNode) object;
							registry = resourcePathObj.getConnectionInfo().getRegistry();
							if (resourcePathObj.getResourceType() == RegistryResourceType.RESOURCE) {
								try {
									openResourceInEditor(resourcePathObj);
								} catch (Exception e) {
									log.error("Drag-Drop resources", e);
								}
							}
						}
					}

				});

			}

		};

	}*/

	private boolean closeEditor(final RegistryResourceNode regResourceNode) {
		boolean closeEditor = true;
		RegistryResourceType resourceType = regResourceNode.getResourceType();
		IEditorPart fileEditor = regResourceNode.getFileEditor();
		if (resourceType == RegistryResourceType.RESOURCE && fileEditor != null) {
			closeEditor = regResourceNode.getFileEditor().getEditorSite().getPage()
					.closeEditor(regResourceNode.getFileEditor(), false);
		}
		return closeEditor;
	}

	private Action copySequenceAction(final RegistryResourceNode regResourceNode) {
		Action copyActionAM = new Action(COPY_ACTION_LABEL) {
			public void run() {
				
				try {
					if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
						try {
							if (regResourceNode.getFileEditor() != null
									&& regResourceNode.getFileEditor().isDirty()
									&& MessageDialogUtils.question(regResourceNode.getFileEditor().getSite().getShell(),
											DO_YOU_WANT_TO_SAVE_CHANGES_AND_COPY)) {
								regResourceNode.getFileEditor().doSave(new NullProgressMonitor());
							}
						} catch (Exception e) {
							exceptionHandler.showMessage(Display.getDefault().getActiveShell(),
									COULD_NOT_CLOSE_ASSOCIATED_EDITOR_FOR_THIS_RESOURCE);
						}
					}
					setCopyRegResourceNode(regResourceNode);
				} catch (Exception e) {
					 log.error("Copying error due to"+e.getMessage(),e);
				}
			};

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ICON_COPY);
				return metadataImgDes;
			}

		};

		return copyActionAM;

	}

	private Action pasteSequenceAction(final RegistryResourceNode targetRegResource,
			final RegistryResourceNode copyRegResource) {
		Action paste = new Action(PASTE_ACTION_LABEL) {
			@Override
			public void run() {
				try {
					if (copyRegResource != null) {
						if (MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),CONTINUE_COPY_PASTE,
								copyRegResource.getRegistryResourcePath() + WILL_BE_COPIED_TO
										+ targetRegResource.getCaption() + CONTINUE)) {
							pasteSequence(copyRegResource, targetRegResource);
						}
					}

				} catch (Exception e) {
					log.error("Copy action error", e);
					MessageDialogUtils.error(Display.getCurrent().getActiveShell(), "",
							THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE + e.getMessage());
				}
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ICON_PASTE);
				return metadataImgDes;
			}
		};

		return paste;
	}
	
	private void pasteSequence(final RegistryResourceNode copyRegResource, final RegistryResourceNode targetRegResource)
			throws InvocationTargetException, InterruptedException {
		new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {


				try {
					monitor.beginTask(PASTE_OPERATION_MONITOR, 100);
					if (copyRegResource != null) {

						String path = copyRegResource.getRegistryResourcePath();
						String destinationPath = targetRegResource.getRegistryResourcePath()
								+ path.substring(copyRegResource.getRegistryResourceNodeParent()
										.getRegistryResourcePath().length());

						ArrayList<RegistryResourceNode> localResourceNodeList = targetRegResource
								.getLocalResourceNodeList();
						for (RegistryResourceNode registryResourceNode : localResourceNodeList) {
							if (copyRegResource.getResourceName()
									.equals(registryResourceNode.getResourceName())) {
								
								Display.getDefault().syncExec(new Runnable() {
									@SuppressWarnings({})
									@Override
									public void run() {
										MessageDialogUtils.error(Display.getCurrent().getActiveShell(), "",
												THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE
														+ copyRegResource.getResourceName()
														+ RESOURCE_ALREADY_EXISTS);
										
									}

								});
							
								return;
							}
						}
						monitor.worked(30);
						final RegistryResourceNode newNode = new RegistryResourceNode(localUrlNode.getUrlInfoList()
								.get(0), destinationPath, targetRegResource);
						newNode.setRegistryResource(RegistryResourceType.RESOURCE);
						newNode.setResourceName(copyRegResource.getResourceName());
						newNode.setNew(true);
						newNode.setAllowExapand(false);
						newNode.setIterativeRefresh(false);
						newNode.setMediaType(RESOURCE_MEDIA_TYPE);
						monitor.worked(60);
						Path tempDir = Files.createTempDirectory("tempfiles"+targetRegResource.getResourceName());
						String filePath = tempDir.toString() + File.separator + copyRegResource.getResourceName();
						File dest = new File(filePath);
						File sourceFile = copyRegResource.getFile();
						copyFileToFile(sourceFile, dest);
						newNode.setNewFile(dest);
						targetRegResource.addChildResource(newNode);
						changedResourceNodes.put(newNode.getRegistryResourcePath(), newNode);
						updateDirtyState();
						monitor.worked(80);
						Display.getDefault().asyncExec(new Runnable() {
							@SuppressWarnings({})
							@Override
							public void run() {
								refreshTreeviewer(newNode);
								monitor.done();
							}

						});
						
					}
				} catch (IOException e) {
					 log.error("Pasting error",e);
					  throw new InvocationTargetException(e);
				}
			}
		});

	}
	
	private Action createSequenceAction(final RegistryResourceNode selectedNode) {
		Action createResource = new Action(CREATE_ACTION_LABEL) {
			public void run() {
				
				
				InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), CREATE_SEQUENCE_DIALOG_TITLE,
						"Sequence Name : ", "newSequnce", null);
				if (dialog.open() != Window.OK) {
					return;
				}
				String sqNameWithoutExtetion = dialog.getValue();		 				
				try {
					createSequenceJob(selectedNode, sqNameWithoutExtetion);
				} catch (InvocationTargetException | InterruptedException e) {
					  MessageDialogUtils.error(Display.getCurrent().getActiveShell(), "", 
							  THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE + e.getMessage());
			    	  log.error("Error while creating a new file", e);
				}
								
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_RESOURCE);
				return metadataImgDes;
			}

		};

		return createResource;

	}
			
	private void createSequenceJob(final RegistryResourceNode selectedNode, final String newName) throws InvocationTargetException, InterruptedException{
				
		new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor) throws InvocationTargetException,
					InterruptedException{
				try {
					monitor.beginTask("Create new Sequence", 100);					
					String sqName = "";
					if (newName.contains(".xml")) {
						sqName = newName;
					} else {
						sqName = newName + ".xml";
					}
					monitor.worked(5);
					
					ArrayList<RegistryResourceNode> localResourceNodeList = selectedNode.getLocalResourceNodeList();
					for (RegistryResourceNode registryResourceNode : localResourceNodeList) {
						if (sqName.equals(registryResourceNode.getResourceName())) {
							
							  Runnable runnable = new Runnable() {
							      @Override
							      public void run() {
							    	  MessageDialogUtils.error(Display.getCurrent().getActiveShell(), "",
												THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE+" '"+ newName +"' "+ " already exists!");
							    	  
							      }
							    };
							   
						 Display.getDefault().syncExec(runnable);
						 
						 return;
						}
					}
					monitor.worked(15);
					
					selectedNode.getRegistryResourcePath();
					selectedNode.getConnectionInfo().getRegistry();
					String selectedPath = selectedNode.getRegistryResourcePath();
					selectedPath = selectedPath.endsWith("/") ? selectedPath : selectedPath + "/";
					
					monitor.worked(25);
					
					ArtifactTemplate selectedTemplate = ArtifactTemplateHandler
							.getArtifactTemplates("org.wso2.developerstudio.eclipse.esb.sequence");
					String templateContent = org.wso2.developerstudio.eclipse.utils.file.FileUtils
							.getContentAsString(selectedTemplate.getTemplateDataStream());
					templateContent = templateContent.replaceFirst("name=", " name=");
					String source = MessageFormat.format(templateContent, newName);
					
					monitor.worked(35);
					
					Path tempDir = Files.createTempDirectory("tempfiles");
					String filePath = tempDir.toString() + File.separator + sqName;
					File sourceFile = new File(filePath);
					
					FileUtils.writeStringToFile(sourceFile, source);
					monitor.worked(50);
					
					String registryResourcePath = selectedPath + sqName;
					
					localUrlNode.getUrlInfoList().get(0);
					final RegistryResourceNode	newNode = new RegistryResourceNode(localUrlNode.getUrlInfoList().get(0),
							registryResourcePath, selectedNode);
					newNode.setRegistryResource(RegistryResourceType.RESOURCE);
					newNode.setResourceName(sqName);
					newNode.setNew(true);
					newNode.setAllowExapand(false);
					newNode.setIterativeRefresh(false);
					newNode.setMediaType(RESOURCE_MEDIA_TYPE);
					newNode.setNewFile(sourceFile);
					selectedNode.addChildResource(newNode);
					monitor.worked(80);
					changedResourceNodes.put(newNode.getRegistryResourcePath(), newNode);
					updateDirtyState();
	 
				  Runnable runnable = new Runnable() {
					      @Override
					      public void run() {
					    	   refreshTreeviewer(newNode);	
					    	   openResourceInEditor(newNode);
					    	   monitor.worked(100);
					    	  
					      }
					    };
					   
				 Display.getDefault().syncExec(runnable);
				 monitor.done();
				
				
				} catch (IOException e) {
					 log.error("Paste operation failed due to ",e);
					 
				}
 
				}
			});

	}

	protected Action renameSequenceAction(final RegistryResourceNode regResourceNode) {

		Action rename = new Action(RENAME_ACTION_LABEL) {
			@Override
			public void run() {
		 	
						try {
							renameSequence(regResourceNode);
							changedResourceNodes.put(regResourceNode.getRegistryResourcePath(), regResourceNode);
							updateDirtyState();
							refreshTreeviewer(regResourceNode);		
						} catch (InvocationTargetException | IOException | InterruptedException e) {
					    	  log.error("Error while creating a new file", e);
						}
			}
			
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ICON_RENAME);
				return metadataImgDes;
			}
		};
		return rename;
	}

	private void renameSequence(final RegistryResourceNode regResourceNode) throws IOException, InvocationTargetException, InterruptedException{
		
		final String currentName = regResourceNode.getLastSegmentInPath().split("\\.")[0];
		InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), RENAME_RESOURCE_DIALOG_TITLE,
				NEW_NAME_LABEL, currentName, new IInputValidator() {
					public String isValid(String value) {
						if (value == null || value.equals("")) {
							return SPECIFY_A_NEW_NAME_TO_THE_RESOURCE;
						} else if (value.equals(currentName)) {
							return SPECIFY_A_NEW_NAME_TO_THE_RESOURCE;
						} else {
							return null;
						}
					}
				});
		if (inputDialog.open() == InputDialog.OK) {
			 String inputName = inputDialog.getValue();
			if (!inputName.contains(".xml")) {
				inputName = inputName + ".xml";
			}
			final String newName = inputName;
			
			
	
		new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
					InterruptedException{
				 
					monitor.beginTask("", 100);
					monitor.worked(60);
                     
						String newPath = regResourceNode.getParent()
								+ (regResourceNode.getParent().endsWith(DEFAULT_PATH) ? newName : DEFAULT_PATH + newName);
						
					ArrayList<RegistryResourceNode> localResourceNodeList = regResourceNode
							.getRegistryResourceNodeParent().getLocalResourceNodeList();
						for (RegistryResourceNode registryResourceNode : localResourceNodeList) {
							if (newName.equals(registryResourceNode.getResourceName())) {
								
								  Runnable runnable = new Runnable() {
								      @Override
								      public void run() {
								    	  MessageDialogUtils.error(Display.getCurrent().getActiveShell(), "",
													THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE+" '"+ newName +"' "+ " already exists!");
								    	  
								      }
								    };
								   
							     Display.getDefault().syncExec(runnable);
							    return;
							}
						}

						File source = regResourceNode.getFile();
						Path tempDir = null;
						try {
							tempDir = Files.createTempDirectory("tempfiles");
						} catch (IOException e) {
							throw new InvocationTargetException(e);
						}
						String filePath = tempDir.toString() + File.separator + newName;
						File dest = new File(filePath);
						try {
							copyFileToFile(source, dest);
						} catch (IOException e) {
							throw new InvocationTargetException(e);
						}
						if (regResourceNode.isIsnew()) {
							regResourceNode.setResourceName(newName);
							regResourceNode.setNewFile(dest);
						} else if(regResourceNode.isRename()){
							regResourceNode.setNewPath(newPath);
							regResourceNode.setResourceName(newName);
						}else {
							regResourceNode.setOldPath(regResourceNode.getRegistryResourcePath());
							regResourceNode.setNewPath(newPath);
							regResourceNode.setRename(true);
							regResourceNode.setNewFile(dest);
							regResourceNode.setResourceName(newName);
						}
						
					 
							Display.getDefault().syncExec(new Runnable() {
								@SuppressWarnings({})
								@Override
								public void run() {
                                    if (regResourceNode.getFileEditor() != null) {
                                        if (regResourceNode.getFileEditor().isDirty()) {
                                            if (MessageDialogUtils.question(regResourceNode.getFileEditor().getSite()
                                                    .getShell(), DO_YOU_WANT_TO_SAVE_CHANGES)) {
                                                regResourceNode.getFileEditor().doSave(new NullProgressMonitor());
                                            }
                                        }
                                        closeEditor(regResourceNode);
                                        updateSequenceName(regResourceNode.getNewFile());
                                        openResourceInEditor(regResourceNode);
                                    } else {
                                        updateSequenceName(regResourceNode.getNewFile());
                                    }					 
								}

                                private void updateSequenceName(File file) {
                                    try {
                                        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                                        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                                        Document doc = docBuilder.parse(file);
                                        Node sequence = doc.getElementsByTagName("sequence").item(0);
                                        Node sequenceName = sequence.getAttributes().getNamedItem("name");
                                        sequenceName.setNodeValue(newName);  
                                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                                        Transformer transformer = transformerFactory.newTransformer();
                                        DOMSource source = new DOMSource(doc);
                                        StreamResult result = new StreamResult(file);
                                        transformer.transform(source, result);
                                    } catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {
                                        log.error("Error while renaming sequence.", e);
                                    }
                                }
							});	
								
					monitor.worked(100);
					monitor.done();	
					
			}
		});
		
		}
	}
		
	public Action deleteSequenceAction(final RegistryResourceNode regResourceNode) {

		Action delete = new Action(DELETE_ACTION_LABEL) {
			@Override
			public void run() {
				 String msg = null;
				 if(regResourceNode.isIsnew()){
					 msg = "Are you sure you want to delete the item permanently ?";
				 }else{
					 msg = "Are you sure you want to mark this as a deleted item ?";
				 }
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Delete Item",msg)) {

					boolean closeEditor = closeEditor(regResourceNode);
					if (closeEditor) {
						if (regResourceNode.isIsnew()) {
							RegistryResourceNode registryResourceNodeParent = regResourceNode
									.getRegistryResourceNodeParent();

							Iterator<RegistryResourceNode> temp = registryResourceNodeParent.getLocalResourceNodeList()
									.iterator();
							while (temp.hasNext()) {
								RegistryResourceNode resourceNode = temp.next();
								if (resourceNode.getResourceName().equals(regResourceNode.getResourceName())) {
									temp.remove();
									break;
								}
							}
							changedResourceNodes.remove(regResourceNode.getRegistryResourcePath());
						} else {
							regResourceNode.setIsdeleted(true);
							changedResourceNodes.put(regResourceNode.getRegistryResourcePath(), regResourceNode);

						}
						updateDirtyState();
						boolean empty = regResourceNode.getRegistryResourceNodeParent().getLocalResourceNodeList()
								.isEmpty();
						RegistryResourceNode tempResourceNode = null;
						if (!empty) {
							tempResourceNode = regResourceNode.getRegistryResourceNodeParent()
									.getLocalResourceNodeList().get(0);
						}
						treeViewer.setInput(localUrlNode);
						if (empty) {
							treeViewer.expandToLevel(4);
						} else {
							if (tempResourceNode != null) {
								RegistryNode registryNode = localUrlNode.getUrlInfoList().get(0);
								treeViewer.expandTree(registryNode, tempResourceNode.getRegistryResourcePath());
							}
						}

					} else {
						MessageDialog
								.openError(Display.getCurrent().getActiveShell(), "Editor closing dialog",
										"Associated editor couldn't close, please close the editor first and re-try to delete");
					}
				}
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_DELETE_RESOURCE);
				return metadataImgDes;
			}
		};
		return delete;
	}

	private void deleteSequence(final RegistryResourceNode regResourceNode) {
		try {
			// Deleting the resource from remote model
			registry = regResourceNode.getConnectionInfo().getRegistry();
			String selectedPath = regResourceNode.getRegistryResourcePath();
			SWTControlUtils.closeAssociatedEditor(regResourceNode.getEditorInput());
			registry.delete(selectedPath);

			// Removing resource from localModel
			RegistryResourceNode nodeParent = regResourceNode.getRegistryResourceNodeParent();
			nodeParent.getResourceNodeList().remove(regResourceNode);
			
			refreshTreeviewer(regResourceNode);

		} catch (Exception e) {
			MessageDialogUtils.error(Display.getCurrent().getActiveShell(),
					THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE + e.getMessage());
			log.error("Error while deleting due to " + e.getMessage(), e);
		}
	}

	public Action importSequenceAction(final RegistryResourceNode regResourceNode) {
		Action importAction = new Action("Import sequence") {
			@Override
			public void run() {
				try {
					importFiles(regResourceNode);
				} catch (IOException e) {
					MessageDialogUtils.error(Display.getCurrent().getActiveShell(),
							THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE + e.getMessage());
					log.error("Error while importing due to " + e.getMessage(), e);
				}
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_IMPORT_TO_REGISTRY);
				return metadataImgDes;
			}
		};
		return importAction;
	}

	private Action commitSequenceAction(final RegistryResourceNode regResourceNode) {
        String menuName = PUSH_CHANGES_MENU_NAME;
        if(regResourceNode.isIsnew()){
        	menuName = COMMIT_FILE_MENU_NAME;
        }
        
		Action commit = new Action(menuName) {
			public void run() {
				 

					if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), APPLY_CHANGES_DIALOG_TITLE,
							ARE_YOU_SURE_YOU_WANT_TO_PUSH_CHANGES_INTO_REMOTE_REGISTRY)) {					
						   
							try {
								commitSequence(regResourceNode);
								changedResourceNodes.remove(regResourceNode.getRegistryResourcePath());
								updateDirtyState();
								refreshTreeviewer(regResourceNode);
								MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ", SUCCESSFULLY_APPLIED_THE_LOCAL_CHANGES);
							} catch (InvalidRegistryURLException | UnknownRegistryException | IOException
									| CoreException e) {
								MessageDialogUtils.error(Display.getCurrent().getActiveShell(), " ",
										THIS_OPERATION_CANNOT_BE_PERFORMED_BECAUSE_THE + e.getMessage(), e);
								log.error("Error while closing the editor due to " + e.getMessage(), e);
							}						 
							
					}

			 
			}
			
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_TO_REGSITRY);
				return metadataImgDes;
			}

		};

		return commit;
	}
	
    private void commitSequence(final RegistryResourceNode regResourceNode) throws IOException,
            InvalidRegistryURLException, UnknownRegistryException, CoreException {
        if (regResourceNode.isIsdeleted()) {
            deleteSequence(regResourceNode);
            IFile workspaceFile = regResourceNode.getWorkspaceFile();
            if (workspaceFile != null && workspaceFile.exists()) {
                workspaceFile.getProject().delete(true, new NullProgressMonitor());
            }
        } else {
            if (regResourceNode.getFileEditor() != null
                    && regResourceNode.getFileEditor().isDirty()
                    && MessageDialogUtils.question(regResourceNode.getFileEditor().getSite().getShell(), "'"
                            + regResourceNode.getResourceName() + Q_SAVE_CHANGES_AND_COMMIT)) {
                regResourceNode.setDirty(false);
                regResourceNode.getFileEditor().doSave(new NullProgressMonitor());
            }
            if (regResourceNode.isIsnew()) {
                File newFile = regResourceNode.getNewFile();
                regResourceNode.putFile();
                regResourceNode.setNew(false);
                if(regResourceNode.getFileEditor() != null){
                    closeEditor(regResourceNode);
                    newFile.delete();
                    openResourceInEditor(regResourceNode);
                }
            } else if (regResourceNode.isRename()) {
                regResourceNode.rename();
                File source = regResourceNode.getFile();
                regResourceNode.setRename(false);
                File dest = regResourceNode.getFile();
                copyFileToFile(source, dest);
                regResourceNode.saveChangesToRegistry();
                regResourceNode.removeFromVersionContent();
            } else {
                regResourceNode.saveChangesToRegistry();
            }
            String filepath = getLastTwoSegments(regResourceNode.getLocalFile().getAbsolutePath());
            openNodesMap.put(filepath, regResourceNode);
        }
        regResourceNode.setIsmodifiyed(false);
    }

	private Action discartSequenceAction(final RegistryResourceNode regResourceNode) {

		Action commit = new Action(DISCARD_LOCAL_CHANGES_TITLE) {
			public void run() {
			 
					if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), DISCARD_CHANGES_DIALOG_TITLE,
							Q_DISCARD_LOCAL_CHANGES)) {						
						boolean discardSequence = discardSequence(regResourceNode);						
						if(discardSequence){							
							changedResourceNodes.remove(regResourceNode.getRegistryResourcePath());
							updateDirtyState();
							regResourceNode.setIsdeleted(false);
							refreshTreeviewer(regResourceNode);							
							MessageDialogUtils.info(Display.getCurrent().getActiveShell(), "",
									SUCCESSFULLY_DISCARDED_THE_LOCAL_CHANGES);
						}else{
							MessageDialogUtils.error(Display.getCurrent().getActiveShell(), "",
									ERROR_WHILE_PERFORMING_THIS_OPERATION_MSG);
						}
					}			 
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_CHECK_OUT_MENU);
				return metadataImgDes;
			}

		};

		return commit;
	}
	
	private boolean discardSequence(final RegistryResourceNode regResourceNode) {		
		closeEditor(regResourceNode);		
		boolean result = regResourceNode.removeLocalContent();
		if(result){
			regResourceNode.setDirty(false);
			regResourceNode.setIsmodifiyed(false);			
			return true;
		}
		
		return false;
	}

	private void copyFileToFile(File source, File dest) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

	private void importFiles(final RegistryResourceNode regResourceNode) throws IOException {
		final FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SINGLE);
		fileDialog.setText(SELECT_FILE_TO_BE_UPLOADED);
		if (fileDialog.open() != null) {
			final String fileName = fileDialog.getFileName();
				File source = new File(fileDialog.getFilterPath(), fileName);				
				if (source.exists()) {

					String destinationPath = regResourceNode.getRegistryResourcePath() + File.separator + fileName;
					RegistryResourceNode newNode = new RegistryResourceNode(localUrlNode.getUrlInfoList().get(0),
							destinationPath, regResourceNode);
					Path tempDir=null;					 
					tempDir = Files.createTempDirectory("tempfiles");				 
					String filePath = tempDir.toString() + File.separator + fileName;					
					File dest = new File(filePath);
					copyFileToFile(source, dest);		
					newNode.setRegistryResource(RegistryResourceType.RESOURCE);
					newNode.setResourceName(fileName);
					newNode.setNew(true);
					newNode.setAllowExapand(false);
					newNode.setIterativeRefresh(false);
					newNode.setMediaType(RESOURCE_MEDIA_TYPE);
					newNode.setNewFile(dest);
					regResourceNode.addChildResource(newNode);
					changedResourceNodes.put(newNode.getRegistryResourcePath(), newNode);
                    refreshTreeviewer(newNode); 
                    openResourceInEditor(newNode);
				}
		}
	}


	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isApiManagerview() {
		return isApiManagerview;
	}

	public String getApimRegPath() {
		return apimRegPath;
	}

	public void setApimRegPath(String apimRegPath) {
		this.apimRegPath = apimRegPath;
	}

	public void setApiManagerview(boolean isApiManagerview) {
		this.isApiManagerview = isApiManagerview;
	}

	public URL getServerURL() {
		return serverURL;
	}

	public void setServerURL(URL serverURL) {
		this.serverURL = serverURL;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getUname() {
		return uname;
	}

	public RegistryURLNode getRegUrlData() {
		return localUrlNode;
	}

	public void setRegUrlData(RegistryURLNode regUrlData) {
		this.localUrlNode = regUrlData;
	}

	public RegistryNode getRegData() {
		return regNode;
	}

	public void setRegData(RegistryNode regData) {
		this.regNode = regData;
	}

	public RegistryResourceNode getRegResourcePathData() {
		return regResourceNode;
	}

	public void setRegResourcePathData(RegistryResourceNode regResourcePathData) {
		this.regResourceNode = regResourcePathData;
	}

	public static void setRegistryPropertyViewer(RegistryPropertyViewer existingRegistryPropertyViewer) {
		registryPropertyViewer = existingRegistryPropertyViewer;
	}

	public static RegistryPropertyViewer getRegistryPropertyViewer() {
		return registryPropertyViewer;
	}

	public static void setResourceInfoViewer(ResourceInfoViewer existingResourceInfoViewer) {
		resourceInfoViewer = existingResourceInfoViewer;
	}

	public static ResourceInfoViewer getResourceInfoViewer() {
		return resourceInfoViewer;
	}

	public String getTraversePath() {
		return txtTraverse.getText() == null ? "" : txtTraverse.getText();// .substring(0,
	}

	public void setTraversePathChanged(boolean traversePathChanged) {
		this.traversePathChanged = traversePathChanged;
	}

	public boolean isTraversePathChanged() {
		return traversePathChanged;
	}

	public void setLinkedWithEditor(boolean linkedWithEditor) {
		this.linkedWithEditor = linkedWithEditor;
	}

	public boolean isLinkedWithEditor() {
		return linkedWithEditor;
	}

	public void setSelectedEditorRegistryResourcePathData(RegistryResourceNode selectedEditorRegistryResourcePathData) {
		this.selectedEditorRegistryResourcePathData = selectedEditorRegistryResourcePathData;
	}

	public RegistryResourceNode getSelectedEditorRegistryResourcePathData() {
		return selectedEditorRegistryResourcePathData;
	}

	private void selectTreeViewerPath(RegistryNode registryData, String path) {
		treeViewer.expandTree(registryData, path);
	}

	public class RegistryContentPartListener implements IPartListener2 {
		RegistryResourceNode resourcePathObj;
		IEditorPart editor;

		public RegistryContentPartListener(RegistryResourceNode resourcePathObj, IEditorPart editor) {
			this.resourcePathObj = resourcePathObj;
			this.editor = editor;
		}

		public void partVisible(IWorkbenchPartReference reference) {

		}

		public void partOpened(IWorkbenchPartReference reference) {

		}

		public void partInputChanged(IWorkbenchPartReference reference) {

		}

		public void partHidden(IWorkbenchPartReference reference) {

		}

		public void partDeactivated(IWorkbenchPartReference reference) {
			if (reference.getPage().getActiveEditor() == editor) {
				setSelectedEditorRegistryResourcePathData(null);
			}
		}

		public void partClosed(IWorkbenchPartReference reference) {
			if (reference.getPage().getActiveEditor() == editor) {
			}
		}

		public void partBroughtToTop(IWorkbenchPartReference reference) {
		}

		public void partActivated(IWorkbenchPartReference reference) {
			if (reference.getPage().getActiveEditor() == editor) {
				if (isLinkedWithEditor())
					traverseRegistryBrowser(resourcePathObj);
				setSelectedEditorRegistryResourcePathData(resourcePathObj);
			}
		}
	}
	
}
