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

package org.wso2.developerstudio.eclipse.greg.manager.remote.views;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
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
import org.eclipse.ui.IPropertyListener;
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
import org.osgi.framework.Bundle;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.eclipse.greg.apim.action.Login;
import org.wso2.developerstudio.eclipse.greg.base.core.Registry;
import org.wso2.developerstudio.eclipse.greg.base.interfaces.RegistryBrowserTraverseListener;
import org.wso2.developerstudio.eclipse.greg.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.greg.base.managers.RemoteContentManager;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryUserRoleContainer;
import org.wso2.developerstudio.eclipse.greg.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.greg.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.greg.base.ui.controls.RegistryTreeViewer;
import org.wso2.developerstudio.eclipse.greg.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.greg.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.greg.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.greg.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.greg.manager.remote.Activator;
import org.wso2.developerstudio.eclipse.greg.manager.remote.dialog.RegistryInfoDialog;
import org.wso2.developerstudio.eclipse.greg.manager.remote.utils.Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;

public class RegistryBrowserAPIMView extends ViewPart implements Observer {

	private static final int TARGET_RESOURCE = 2;
	private static final int COPY_RESOURCE = 1;
	private static final int LOGIN_SHELL_HEIGHT = 250;
	private static final int LOGIN_SHELL_WIDTH = 600;

	public static final String EVENT_TOPIC_EXPAND_TREE = "ExpandTree";
	public static final String EVENT_TOPIC_OPEN_EDITOR = "OPEN_EDITOR";
	public static final String EVENT_TOPIC_PASTE = "PASTE_EVENT";
	public static final String EVENT_TOPIC_POPULATE_NODE_DATA = "NODEDATA_PUPULATE";
	public static final String EVENT_TOPIC_POPULATE_TREE_DATA = "TREE_DATA_PUPULATE";
	public static final String EVENT_TOPIC_POPULATE_CHANGE_NODE_DATA = "CHANGE_NODE_DATA_POPULATE";
	private static final String DEFAULT_PATH = "/";
	
/*	private static final int CHAR_SHIFT = 32;
	private static final int CHAR_R = 114;
	private static final int CHAR_V = 118;
	private static final int CHAR_C = 99;*/

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String APIM_CUSTOMSEQUENCES_PATH = "/_system/governance/apimgt/customsequences";

	Action addRegistryAction;
	Action discardAllchangesAction;
	Action commitAllchangesAction;

	IMemento memento;
	private Tree tree;
	private RegistryTreeViewer treeViewer;

	private RegistryURLNode regUrlNode1;
	private RegistryURLNode localUrlNode;
	private RegistryNode regNode;
	private RegistryResourceNode regResourceNode;
	private Map<String, RegistryResourceNode> changedResourceNodes;
	private Registry registry;
	private RegistryBrowserAPIMViewLabelProvider labelProvider;

	private String uname;
	private String resourcePath;
	private String pwd;
	private URL serverURL;

	private ExceptionHandler exeptionHandler;
	public static RegistryBrowserAPIMView lastInstance;
	private static RegistryPropertyViewer registryPropertyViewer;
	private static ResourceInfoViewer resourceInfoViewer;

	/*
	 * private MenuManager communitySubMenu; private MenuManager metadatMenu; private MenuManager
	 * multipleResourceUploadMenu; private MenuManager versionSubMenu;
	 */
	private MenuManager apimMenuManager;
	private boolean isApiManagerview;
	private String apimRegPath;

	// private String[] children= null;
	// private IViewSite viewSite;

	private Text txtTraverse;
	private boolean linkedWithEditor;
	public static final int CNTRL_KEY_CODE = 262144;
	boolean cntrlKeyPressed;

	private RegistryResourceNode selectedEditorRegistryResourcePathData;
	private RegistryResourceNode copyRegResourceNode;
	private IEventBroker broker;
	private boolean traversePathChanged;

	IContextActivation activation;
	IHandlerActivation activateDeleteHandler;
	IHandlerActivation activateRefreshHandler;
	IHandlerActivation activateAddResourceHandler;
	IHandlerActivation activateRenameHandler;
	IHandlerActivation activateCopyHandler;
	IHandlerActivation activatePasteHandler;
	private String apimRegpath;

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

	public RegistryBrowserAPIMView() {
		super();
		setApiManagerview(true);	
		try {
			setApimRegPath(new Login().getRegpath());
		} catch (Exception e) {
			log.error("API Manager Registry path cannot be reslove due to", e);
			setApimRegPath(APIM_CUSTOMSEQUENCES_PATH);	 
		}
		
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);		
		IEclipseContext eclipseContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		eclipseContext.set(org.eclipse.e4.core.services.log.Logger.class, null);		
		IEventBroker iEventBroker = eclipseContext.get(IEventBroker.class);		
		iEventBroker.subscribe(EVENT_TOPIC_EXPAND_TREE,getTreeExpandHandler() );
		iEventBroker.subscribe(EVENT_TOPIC_OPEN_EDITOR,getOPenEditorEvent());
		iEventBroker.subscribe(EVENT_TOPIC_PASTE,getPasteEvent());		
		setBroker(iEventBroker);
		
		changedResourceNodes = new HashMap<String, RegistryResourceNode>();
		exeptionHandler = new ExceptionHandler();
		this.localUrlNode = new RegistryURLNode();
		localUrlNode.addObserver(this);
		lastInstance = this;
		doSavet();
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
		this.memento = memento;
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
		IEventBroker broker = getBroker();
		if(broker!=null){
			broker.unsubscribe(getTreeExpandHandler());
			broker.unsubscribe(getOPenEditorEvent());
			broker.unsubscribe(getPasteEvent());
		//	broker.unsubscribe(getTreeNodeSelctionHandler());
		}
		deactivateActionHandlers();
		IContextService contextService = (IContextService) getSite().getService(IContextService.class);
		contextService.deactivateContext(activation);
		
		super.dispose();
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

	protected void loginToAPIMRegistry(Composite parent) {
		exeptionHandler = new ExceptionHandler();

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

				if (!Utils.isValidServerURL(dialog.getServerUrl())) {
					if (!MessageDialog.openQuestion(parent.getShell(), "Connection Fail",
							"Establishing connection to the server failed")) {
						return;
					}
				}

				verifyRegistryPath(dialog);
				cloneRegistryModel();
				expanTree();

			} catch (URISyntaxException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Cannot establish the connection with given URL due to " + e.getMessage());
				log.error("Cannot establish the connection with given URL", e);
			} catch (MalformedURLException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Cannot establish the connection with given URL due to " + e.getMessage());
				log.error("Cannot establish the connection with given URL", e);
			} catch (UnknownRegistryException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Cannot establish the connection with given URL due to " + e.getMessage());
				log.error("Cannot establish the connection with given URL", e);

			} catch (InvalidRegistryURLException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Cannot establish the connection with given URL due to " + e.getMessage());
				log.error("Cannot establish the connection with given URL", e);
			} catch (CloneNotSupportedException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Registy cloning process has failed due to " + e.getMessage());
				log.error("Registy cloning process has failed due to " + e.getMessage(), e);
			}

		}

	}

	private void cloneRegistryModel() throws CloneNotSupportedException {

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
		treeViewer.setInput(localUrlNode);
	}

	// Verify the Registry path
	private void verifyRegistryPath(RegistryInfoDialog dialog) throws InvalidRegistryURLException,
			UnknownRegistryException {

		Registry reg = new Registry(uname, pwd, dialog.getServerUrl());
		reg.getResourcesPerCollection(getApimRegPath());
	}

	private void expanTree() {
		try {
			new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					if (treeViewer != null) {
						monitor.beginTask("", 100);
						monitor.worked(60);
						broker.send(EVENT_TOPIC_EXPAND_TREE, null);
						monitor.worked(100);
						monitor.done();
					}
				}
			});
		} catch (InvocationTargetException e) {
			log.error("Tree expanding fail" + e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error("Tree expanding fail" + e.getMessage(), e);
		}
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
				exeptionHandler, false, true);
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
				final Object obj = event.getSelection();
				if (obj instanceof TreeSelection) {
					try {
						new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor) throws InvocationTargetException,
									InterruptedException {
								if (treeViewer != null) {
									monitor.beginTask("", 100);
									monitor.worked(60);
									broker.send(EVENT_TOPIC_OPEN_EDITOR, obj);
									monitor.worked(100);
									monitor.done();
								}
							}
						});

					} catch (InvocationTargetException e) {
						log.error("Tree expanding fail" + e.getMessage(), e);
					} catch (InterruptedException e) {
						log.error("Tree expanding fail" + e.getMessage(), e);
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

								if (node.isFileLocallyModified() || node.isIsdeleted() || node.isRename()) {
									manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
									manager.add(new Separator());
									manager.add(commitSequence(node));
									manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
									manager.add(new Separator());
									manager.add(discartSequence(node));
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
		commitAllchangesAction = new Action("Push all changes ") {
			public void run() {
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Apply Chanages",
						"Are You Sure ,  You want to Push all local changes into remote API Manager server ?")) {
					pushAllchnages();
				}
			}
		};
		commitAllchangesAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_TO_REGSITRY));
		commitAllchangesAction.setToolTipText("Push All changes to the server");
		commitAllchangesAction.setEnabled(false);
	}

	private void discardAllChnangesToolbarAction() {
		discardAllchangesAction = new Action("discard all loacl changes ") {
			public void run() {
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Discard Chanages",
						"Are You Sure , that you want to DISCARD ALL LOCAL CHANGES and "
								+ "synchronize with the remote API Manager server ?")) {
					try {
						cloneRegistryModel();
						expanTree();
						changedResourceNodes.clear();
						updateDirtyState();
					} catch (CloneNotSupportedException e) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Remote synchronization",
								"Registy synchronization process has failed due to " + e.getMessage());
						log.error("Registy cloning process has failed due to " + e.getMessage(), e);
					}
				}
			}
		};
		// Synchronize
		discardAllchangesAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ACTION_CHECK_OUT_MENU));
		discardAllchangesAction.setToolTipText("Discard all loacl changes and synchronize with server");
		discardAllchangesAction.setEnabled(false);
	}

	private void addLoginToolbarAction(final Composite parent) {
		addRegistryAction = new Action("Login ") {
			public void run() {
				loginToAPIMRegistry(parent);
			}
		};
		addRegistryAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ICON_USERS));
		addRegistryAction.setToolTipText("Login");
	}

	private void pushAllchnages() {
		try {
			Set<String> keySet = changedResourceNodes.keySet();
			for (String key : keySet) {
				RegistryResourceNode registryResourceNode = changedResourceNodes.get(key);

				if (registryResourceNode.isIsdeleted()) {
					deleteSequence(registryResourceNode);
				} else if (registryResourceNode.isIsnew()) {
					registryResourceNode.putFile();
					MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ",
							"Sucessfully applied the local changes");
				} else {
					registryResourceNode.saveChangesToRegistry();
					refreshItem(registryResourceNode);
					MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ",
							"Sucessfully applied the local changes");
				}
			}
			changedResourceNodes.clear();
			updateDirtyState();
		} catch (InvalidRegistryURLException | UnknownRegistryException e) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Push Changes Dialog",
					"Cannot push all the chnages due to " + e.getMessage());
			log.error("Cannot push all the chnages due to " + e.getMessage(), e);
		}

	}

	private void updateDirtyState() {
		if (changedResourceNodes.isEmpty()) {
			discardAllchangesAction.setEnabled(false);
			commitAllchangesAction.setEnabled(false);
		} else {
			discardAllchangesAction.setEnabled(true);
			;
			commitAllchangesAction.setEnabled(true);
		}
	}

	private void refreshItem(Object selectedObj) {
		if (selectedObj instanceof RegistryNode) {
			((RegistryNode) selectedObj).setIterativeRefresh(true);
		} else if (selectedObj instanceof RegistryContentContainer) {
			((RegistryContentContainer) selectedObj).setIterativeRefresh(true);
		} else if (selectedObj instanceof RegistryResourceNode) {
			((RegistryResourceNode) selectedObj).setIterativeRefresh(true);
		} else if (selectedObj instanceof RegistryUserContainer) {
			((RegistryUserContainer) selectedObj).setIterativeRefresh(true);
		} else if (selectedObj instanceof RegistryUserRoleContainer) {
			((RegistryUserRoleContainer) selectedObj).setIterativeRefresh(true);
		}
		localUrlNode.dataChanged(false);
	}

	private EventHandler getTreeExpandHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {

				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						treeViewer.expandAll();
					}
				});
			}
		};
	}

	// File Editing
	private void openResourceInEditor(final RegistryResourceNode resourceNode) {
		if (resourceNode.isIsdeleted()) {
			MessageDialogUtils.error(Display.getCurrent().getActiveShell(), resourceNode.getResourceName()
					+ " cannot be"
					+ " opened since this is marked  as a deleted resource , if you want to open undo the delete "
					+ "operation and try again");
			return;
		}
		if (!resourceNode.isIsnew()) {
			if (resourceNode.getNewFile() != null && resourceNode.getNewFile().exists()) {
				try {
					FileUtils.forceDelete(resourceNode.getFile());
				} catch (IOException e) {
					log.error("Failed to delete the old file", e);
				}
			}
		}

		File tempFile = null;
		if (resourceNode.isIsnew()) {
			tempFile = resourceNode.getNewFile();
		} else {
			tempFile = resourceNode.getFile();
		}
		final IEditorPart editor = RemoteContentManager.openFile(tempFile);
		if (resourceNode.getFileEditor() != editor) {
			editor.getSite().getPage().addPartListener(new RegistryContentPartListener(resourceNode, editor));
		}

		resourceNode.setFileEditor(editor);
		if (!resourceNode.isIsnew()) {
			changedResourceNodes.put(resourceNode.getRegistryResourcePath(), resourceNode);
			updateDirtyState();
			editor.addPropertyListener(new IPropertyListener() {
				public void propertyChanged(Object obj, int prop) {
					if (editor.isDirty())
						try {
							changedResourceNodes.put(resourceNode.getRegistryResourcePath(), resourceNode);
							updateDirtyState();
						} catch (Exception e) {
							log.error(e);
						}
				}
			});
		}

	}

	protected int INTERESTING_CHANGES = IResourceDelta.CONTENT | IResourceDelta.MOVED_FROM | IResourceDelta.MOVED_TO
			| IResourceDelta.REPLACED;

	public void doSavet() {
		IResourceChangeListener listener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				try {
					event.getDelta().accept(new IResourceDeltaVisitor() {
						public boolean visit(IResourceDelta delta) {
							IResource resource = delta.getResource();
							if (resource.getType() == IResource.ROOT) {
								return true;
							} else if (resource.getType() == IResource.PROJECT) {
								return true;
							} else if (resource.getType() == IResource.FILE) {
								if (delta.getKind() == IResourceDelta.CHANGED && resource.exists()) {
									if ((delta.getFlags() & INTERESTING_CHANGES) != 0) {
										// modifiedResources.add(resource);
										// System.out.println(resource.getName());
										return true;
									}
								} else if (delta.getKind() == IResourceDelta.ADDED) {
									// System.out.println(resource.getName());
									return true;
								} else if (delta.getKind() == IResourceDelta.REMOVED) {
									// System.out.println(resource.getName());
									return true;
								}
							} else if (resource.getType() == IResource.FOLDER) {
								// System.out.println(resource.getName());
								return true;
							}
							return false;
						}
					});
				} catch (CoreException e) {
					 
					e.printStackTrace();
				}

			}
		};
		ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);
	}

	private EventHandler getOPenEditorEvent() {
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

	}

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
		Action copyActionAM = new Action("Copy	") {
			public void run() {
				if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
					try {
						if (regResourceNode.getFileEditor() != null
								&& regResourceNode.getFileEditor().isDirty()
								&& MessageDialogUtils.question(regResourceNode.getFileEditor().getSite().getShell(),
										"Do you want to save changes and copy?")) {
							regResourceNode.getFileEditor().doSave(new NullProgressMonitor());
						}
					} catch (Exception e) {
						exeptionHandler.showMessage(Display.getDefault().getActiveShell(),
								"Could not close associated editor for this resource");
					}
				}
				setCopyRegResourceNode(regResourceNode);
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
		Action paste = new Action("Paste	") {
			@Override
			public void run() {
				try {
					if (copyRegResource != null) {
						if (MessageDialog.openConfirm(
								Display.getCurrent().getActiveShell(),
								"Continue copy-paste...",
								copyRegResource.getRegistryResourcePath() + " will be copied to "
										+ targetRegResource.getCaption() + ". Continue?")) {

							Map<Integer, RegistryResourceNode> resourceMap = new HashMap<Integer, RegistryResourceNode>();
							resourceMap.put(COPY_RESOURCE, copyRegResource);
							resourceMap.put(TARGET_RESOURCE, targetRegResource);
							broker.send(EVENT_TOPIC_PASTE, targetRegResource);

						}
					}

				} catch (Exception e) {
					log.error("copry action error", e);
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

	private EventHandler getPasteEvent() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						Object property = event.getProperty(IEventBroker.DATA);
						if (property instanceof RegistryResourceNode) {
							RegistryResourceNode copyRegResource = getCopyRegResourceNode();
							RegistryResourceNode targetRegResource = (RegistryResourceNode) property;

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
										MessageDialogUtils.error(
												Display.getCurrent().getActiveShell(),
												"",
												"This operation cannot be performed because the "
														+ copyRegResource.getResourceName()
														+ "resource already exists!");
										return;
									}
								}

								RegistryResourceNode newNode = new RegistryResourceNode(localUrlNode.getUrlInfoList()
										.get(0), destinationPath, targetRegResource);
								newNode.setRegistryResource(RegistryResourceType.RESOURCE);
								newNode.setResourceName(copyRegResource.getResourceName());
								newNode.setNew(true);
								newNode.setAllowExapand(false);
								newNode.setIterativeRefresh(false);
								newNode.setMediaType("application/xml");
								newNode.setNewFile(copyRegResource.getFile());
								targetRegResource.addChildResource(newNode);
								changedResourceNodes.put(newNode.getRegistryResourcePath(), newNode);
								treeViewer.setInput(localUrlNode);
							}
						}
					}

				});

			}

		};

	}

	private Action createSequenceAction(final RegistryResourceNode selectedNode) {
		Action createResource = new Action("Create     ") {
			public void run() {

				InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Create Sequence",
						"Sequence Name : ", "newSequnce", null);
				if (dialog.open() != Window.OK) {
					return;
				}
				String sqNameWithoutExtetion = dialog.getValue();
				String sqName = "";
				if (sqNameWithoutExtetion.contains(".xml")) {
					sqName = sqNameWithoutExtetion;
				} else {
					sqName = sqNameWithoutExtetion + ".xml";
				}

				selectedNode.getRegistryResourcePath();
				selectedNode.getConnectionInfo().getRegistry();
				String selectedPath = selectedNode.getRegistryResourcePath();
				selectedPath = selectedPath.endsWith("/") ? selectedPath : selectedPath + "/";

				treeViewer.getTree();
				createSequnceInRegistry(selectedNode, sqNameWithoutExtetion, sqName, selectedPath);
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_RESOURCE);
				return metadataImgDes;
			}

		};

		return createResource;

	}

	private void createSequnceInRegistry(final RegistryResourceNode selectedNode, String sqNameWithoutExtetion,
			String sqName, String selectedPath) {
		try {

			ArtifactTemplate selectedTemplate = ArtifactTemplateHandler
					.getArtifactTemplates("org.wso2.developerstudio.eclipse.esb.sequence");
			String templateContent = org.wso2.developerstudio.eclipse.utils.file.FileUtils
					.getContentAsString(selectedTemplate.getTemplateDataStream());
			templateContent = templateContent.replaceFirst("name=", " name=");
			String source = MessageFormat.format(templateContent, sqNameWithoutExtetion);
			Path tempDir = Files.createTempDirectory("tempfiles");
			String filePath = tempDir.toString() + File.separator + sqName;
			File sourceFile = new File(filePath);
			FileUtils.writeStringToFile(sourceFile, source);
			String registryResourcePath = selectedPath + sqName;

			localUrlNode.getUrlInfoList().get(0);
			RegistryResourceNode newNode = new RegistryResourceNode(localUrlNode.getUrlInfoList().get(0),
					registryResourcePath, selectedNode);
			newNode.setRegistryResource(RegistryResourceType.RESOURCE);
			newNode.setResourceName(sqName);
			newNode.setNew(true);
			newNode.setAllowExapand(false);
			newNode.setIterativeRefresh(false);
			newNode.setMediaType("application/xml");
			newNode.setNewFile(sourceFile);
			selectedNode.addChildResource(newNode);
			changedResourceNodes.put(newNode.getRegistryResourcePath(), newNode);
			treeViewer.setInput(localUrlNode);

		} catch (IOException e) {
			log.error("Create New Sequence from APIM perspective failed due to  ", e);
		}
	}

	protected Action renameSequenceAction(final RegistryResourceNode regResourceNode) {

		Action rename = new Action("Rename") {
			@Override
			public void run() {
				final String currentName = regResourceNode.getLastSegmentInPath();
				InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), "Rename resource",
						"New name:", currentName, new IInputValidator() {
							public String isValid(String value) {
								if (value == null || value.equals("")) {
									return "Specify a new name to the resource";
								} else if (value.equals(currentName)) {
									return "Specify a new name to the resource";
								} else {
									return null;
								}
							}
						});
				if (inputDialog.open() == InputDialog.OK) {
					String newName = inputDialog.getValue();
					String newPath = regResourceNode.getParent()
							+ (regResourceNode.getParent().endsWith(DEFAULT_PATH) ? newName : DEFAULT_PATH + newName);
					if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
						try {
							if (regResourceNode.getFileEditor() != null) {
								if (regResourceNode.getFileEditor().isDirty()) {
									if (MessageDialogUtils.question(regResourceNode.getFileEditor().getSite()
											.getShell(), "Do you want to save changes?")) {
										regResourceNode.getFileEditor().doSave(new NullProgressMonitor());
									}
								}
								regResourceNode.getFileEditor().getEditorSite().getPage()
										.closeEditor(regResourceNode.getFileEditor(), false);
								regResourceNode.getFileEditor().dispose();
							}

						} catch (Exception e) {
							log.error("Could not close associated editor for this resource" + e.getMessage(), e);
						}
					}

					regResourceNode.setOldPath(regResourceNode.getRegistryResourcePath());
					regResourceNode.setNewPath(newPath);
					regResourceNode.setRename(true);
					regResourceNode.setResourceName(newName);
					changedResourceNodes.put(regResourceNode.getRegistryResourcePath(), regResourceNode);
					updateDirtyState();
					treeViewer.setInput(localUrlNode);
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

	public Action deleteSequenceAction(final RegistryResourceNode regResourceNode) {

		Action delete = new Action("Delete                       ^D") {
			@Override
			public void run() {
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Delete Item",
						"Are you sure you want to delete the item ?")) {

					boolean closeEditor = closeEditor(regResourceNode);
					if (closeEditor) {

						regResourceNode.setIsdeleted(true);
						changedResourceNodes.put(regResourceNode.getRegistryResourcePath(), regResourceNode);
						treeViewer.setInput(localUrlNode);
						try {
							new ProgressMonitorDialog(getSite().getShell()).run(true, true,
									new IRunnableWithProgress() {

										public void run(IProgressMonitor monitor) throws InvocationTargetException,
												InterruptedException {

											if (treeViewer != null) {
												monitor.beginTask("", 100);
												monitor.worked(60);
												broker.send(EVENT_TOPIC_EXPAND_TREE, null);
												monitor.worked(100);
												monitor.done();
											}

										}
									});
						} catch (InvocationTargetException e) {
							log.error("Tree expanding fail" + e.getMessage(), e);
						} catch (InterruptedException e) {
							log.error("Tree expanding fail" + e.getMessage(), e);
						}

					} else {
						MessageDialog
								.openError(Display.getCurrent().getActiveShell(), "Editor closing dialog",
										"Associated editor couldn't close , please close the editor first and re-try to delete");
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

			treeViewer.setInput(localUrlNode);
			expanTree();

		} catch (Exception e) {
			MessageDialogUtils.error(Display.getCurrent().getActiveShell(),
					"Error while deleting resource: " + e.getMessage());
			log.error(e);
		}
	}

	public Action importSequenceAction(final RegistryResourceNode regResourceNode) {
		Action importAction = new Action("Import sequence") {
			@Override
			public void run() {
				importFiles(regResourceNode);
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_IMPORT_TO_REGISTRY);
				return metadataImgDes;
			}
		};
		return importAction;
	}

	private Action commitSequence(final RegistryResourceNode regResourceNode) {

		Action commit = new Action("Push Changes") {
			public void run() {
				try {

					if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Apply Chanages",
							"Are you sure you want to Push Changes into remote registry ?")) {

						if (regResourceNode.isIsdeleted()) {
							deleteSequence(regResourceNode);
						} else if (regResourceNode.isIsnew()) {
							regResourceNode.putFile();
							MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ",
									"Sucessfully applied the local changes");
						} else {
							if (regResourceNode.isRename()) {
								regResourceNode.rename();
							}
							regResourceNode.saveChangesToRegistry();
							refreshItem(regResourceNode);
							MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ",
									"Sucessfully applied the local changes");
						}

						changedResourceNodes.remove(regResourceNode.getRegistryResourcePath());
						updateDirtyState();
					}

				} catch (Exception e) {
					exeptionHandler.showMessage(Display.getDefault().getActiveShell(),
							"Could not close associated editor for this resource");
				}
			};

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_TO_REGSITRY);
				return metadataImgDes;
			}

		};

		return commit;
	}

	private Action discartSequence(final RegistryResourceNode regResourceNode) {

		Action commit = new Action("discard local changes") {
			public void run() {
				try {

					if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Discard Chanages",
							"Are you sure you want to discard local changes ?")) {
						IEditorPart fileEditor = regResourceNode.getFileEditor();
						if (fileEditor != null) {
							SWTControlUtils.closeAssociatedEditor(fileEditor.getEditorInput());
						}
						refreshItem(regResourceNode);
						MessageDialogUtils.info(Display.getCurrent().getActiveShell(), "",
								"Sucessfully discarded the localchanges");
					}

				} catch (Exception e) {
					exeptionHandler.showMessage(Display.getDefault().getActiveShell(),
							"Could not close associated editor for this resource");
				}
			};

			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor metadataImgDes = ImageUtils.getImageDescriptor(ImageUtils.ACTION_CHECK_OUT_MENU);
				return metadataImgDes;
			}

		};

		return commit;
	}

	// Action Methods Secttions

	private void importFiles(final RegistryResourceNode regResourceNode) {
		final FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SINGLE);
		fileDialog.setText("Select file to be uploaded to the registry");
		if (fileDialog.open() != null) {
			final String fileName = fileDialog.getFileName();
			if (MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Continue uploading...",
					" file will be uploaded. Continue?")) {
				File file = new File(fileDialog.getFilterPath(), fileName);
				if (file.exists()) {

					String destinationPath = regResourceNode.getRegistryResourcePath() + File.separator + fileName;
					RegistryResourceNode newNode = new RegistryResourceNode(localUrlNode.getUrlInfoList().get(0),
							destinationPath, regResourceNode);

					newNode.setRegistryResource(RegistryResourceType.RESOURCE);
					newNode.setResourceName(fileName);
					newNode.setNew(true);
					newNode.setAllowExapand(false);
					newNode.setIterativeRefresh(false);
					newNode.setMediaType("application/xml");
					newNode.setNewFile(file);
					regResourceNode.addChildResource(newNode);
					changedResourceNodes.put(newNode.getRegistryResourcePath(), newNode);
					treeViewer.setInput(localUrlNode);

				}
			}
		}
	}

	/*
	 * private Action checkoutAction(final RegistryResourceNode regResourceNode) {
	 * 
	 * Action copyActionAM = new Action("Checkout") { public void run() { if (regResourceNode.getResourceType() ==
	 * RegistryResourceType.COLLECTION) { checkoutRegpath(regResourceNode); } setCopyRegResourceNode(regResourceNode); }
	 * 
	 * @Override public ImageDescriptor getImageDescriptor() { ImageDescriptor metadataImgDes =
	 * ImageUtils.getImageDescriptor(ImageUtils.ACTION_CHECK_OUT_MENU); return metadataImgDes; }
	 * 
	 * };
	 * 
	 * return copyActionAM;
	 * 
	 * }
	 */

	// TODO - If APIM support CAR in the future then we can use method to create Regresource project
	/*
	 * private String checkoutRegpath(final RegistryResourceNode regResourceNode) { try { String checkoutPath=""; String
	 * chkoutFolder=""; if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) { chkoutFolder =
	 * regResourceNode.getRegistryResourceNodeParent().getLastSegmentInPath(); checkoutPath =
	 * regResourceNode.getRegistryResourceNodeParent() .getRegistryResourcePath(); } else if
	 * (regResourceNode.getResourceType() == RegistryResourceType.UNDEFINED) { throw new
	 * Exception("Resource not Defined"); } else { chkoutFolder =regResourceNode.getLastSegmentInPath(); checkoutPath =
	 * regResourceNode.getRegistryResourcePath(); } if (chkoutFolder.equals("/")) { chkoutFolder = "ROOT"; }
	 * 
	 * String projectName = "APIMRegistry"; String rootWorkspaceLocation =
	 * ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator + projectName;
	 * IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot(); IProject project = root.getProject(projectName);
	 * project.create(new NullProgressMonitor()); project.open(new NullProgressMonitor());
	 * 
	 * IPath path = project.getLocation(); path = path.append(chkoutFolder);
	 * 
	 * // IProject project = root.getProject(path.segment(0)); // path = root.getLocation().append(path);
	 * 
	 * 
	 * try { if (RegistryCheckInClientUtils.isCheckoutPathValid(path.toOSString())) { (new
	 * File(path.toOSString())).mkdirs(); try { RegistryCheckInClientUtils.checkout(regResourceNode.getConnectionInfo()
	 * .getUsername(), regResourceNode.getConnectionInfo() .getPassword(), path.toOSString(),
	 * regResourceNode.getConnectionInfo() .getUrl().toString(), checkoutPath); } catch (SynchronizationException e1) {
	 * log.error(e1); } try { project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor()); } catch
	 * (CoreException e) { log.error(e); } }
	 * 
	 * 
	 * } catch (Exception e1) { MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error in checkout path",
	 * e1.getMessage()); } return checkoutPath; } catch (Exception e) { log.error(e); }
	 * 
	 * return null; }
	 */

	// Utitlity methods

	

	// Getter & Setters

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

	public IEventBroker getBroker() {
		return broker;
	}

	public void setBroker(IEventBroker broker) {
		this.broker = broker;
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

	// Clazz implimentations

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

	/*public class VersionViewAction extends Action {

		RegistryResourceNode registryResourcePathData;
		String verstionPath;

		public VersionViewAction(RegistryResourceNode registryResourcePathData, String verstionPath) {
			this("View", registryResourcePathData, verstionPath);
		}

		public VersionViewAction(String caption, RegistryResourceNode registryResourcePathData, String verstionPath) {
			super(caption);
			this.registryResourcePathData = registryResourcePathData;
			this.verstionPath = verstionPath;
			setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ICON_VERSION_VIEW));
		}

		public void run() {
			RegistryResourceNode resourcePathObj = registryResourcePathData;
			registry = resourcePathObj.getConnectionInfo().getRegistry();
			String path = resourcePathObj.getRegistryResourcePath();
			if (resourcePathObj.getResourceType() == RegistryResourceType.RESOURCE) {
				try {
					File tempFile = resourcePathObj.getFile(verstionPath);
					RemoteContentManager.openFile(tempFile);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}
*/
	/*public class RestoreVersionAction extends Action {
		RegistryResourceNode registryResourcePathData;
		String versionPath;

		public RestoreVersionAction(RegistryResourceNode registryResourcePathData, String verstionPath) {
			super("Restore");
			this.registryResourcePathData = registryResourcePathData;
			this.versionPath = verstionPath;
			setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ICON_VERSION_RESTORE));
		}

		public void run() {
			RegistryResourceNode resourcePathObj = registryResourcePathData;
			registry = resourcePathObj.getConnectionInfo().getRegistry();
			if (resourcePathObj.getResourceType() == RegistryResourceType.RESOURCE) {
				try {
					registryResourcePathData.restoreToVersion(versionPath);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}
*/


	
}
