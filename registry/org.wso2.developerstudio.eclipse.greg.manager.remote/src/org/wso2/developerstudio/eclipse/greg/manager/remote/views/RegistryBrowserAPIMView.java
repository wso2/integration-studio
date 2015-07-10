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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.carbon.registry.core.Collection;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.ws.stub.xsd.WSResourceData;
import org.wso2.developerstudio.eclipse.greg.base.core.Registry;
import org.wso2.developerstudio.eclipse.greg.base.heartbeat.RegistryHeartBeatTester;
import org.wso2.developerstudio.eclipse.greg.base.interfaces.RegistryBrowserTraverseListener;
import org.wso2.developerstudio.eclipse.greg.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.greg.base.managers.RemoteContentManager;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryUser;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryUserManagerContainer;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryUserRole;
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
import org.wso2.developerstudio.eclipse.greg.manager.remote.dragdrop.DragDropUtils;
import org.wso2.developerstudio.eclipse.greg.manager.remote.dragdrop.Queue;
import org.wso2.developerstudio.eclipse.greg.manager.remote.utils.Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class RegistryBrowserAPIMView extends ViewPart implements Observer {

	private static final int LOGIN_SHELL_HEIGHT = 250;
	private static final int LOGIN_SHELL_WIDTH = 600;
	private static final String OUT_SEQUENCE_LOCATION = "out";
	private static final String IN_SEQUENCE_LOCATION = "in";
	private static final String FAULT_SEQUENCE_LOCATION = "fault";
	public static final String EVENT_TOPIC_EXPAND_TREE = "ExpandTree";
	public static final String EVENT_TOPIC_OPEN_EDITOR = "OPEN_EDITOR";
	public static final String EVENT_TOPIC_POPULATE_NODE_DATA = "NODEDATA_PUPULATE";
	public static final String EVENT_TOPIC_POPULATE_TREE_DATA = "TREE_DATA_PUPULATE";
	public static final String EVENT_TOPIC_POPULATE_CHANGE_NODE_DATA = "CHANGE_NODE_DATA_POPULATE";
	private static final String DEFAULT_PATH = "/";
	private static final int CHAR_SHIFT = 32;
	private static final int CHAR_R = 114;
	private static final int CHAR_V = 118;
	private static final int CHAR_C = 99;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	Action addRegistryAction;
	Action addCollectionAction;
	Action addResourceAction;
	Action deleteAction;
	Action renameAction;
	Action enableAction;
	Action disableAction;
	Action refreshAction;

	Action multipleFileAction;
	Action multipleFolderAction;
	Action metaDataAction;
	Action propertyAction;
	Action associationAction;
	Action lifeCyclesAction;
	Action dependenciesAction;

	Action communityAction;
	Action commentsAction;
	Action ratingsAction;
	Action tagsAction;
	Action linkWithEditorAction;

	Action importFromAction;
	Action exportToAction;

	Action changeRolePermission;
	Action modifyResourcePermission;

	Action addUsers;
	Action addRoles;
	Action modifyUserInfo;

	Action copyAction;
	Action pasteAction;

	IMemento memento;
	private Tree tree;
	private RegistryTreeViewer treeViewer;

	private RegistryURLNode regUrlNode;
	private RegistryNode regNode;
	private RegistryResourceNode regResourceNode;
	private RegistryResourceNode targetRegResourceNode;
	private RegistryUserRole regUserRole;
	private RegistryUserContainer regUserContainer;
	private RegistryUserRoleContainer regRoleContainer;
	private UserManager um;

	private ArrayList<RegistryResourceNode> resourceNodes;
	private ArrayList<RegistryNode> list;
	private Registry registry;

	private String uname;
	private String resourcePath;

	private String pwd;
	private URL serverURL;

	private Composite parentComposite;
	private ExceptionHandler exeptionHandler;

	private Object selectedObj;
	public static RegistryBrowserAPIMView lastInstance;

	private static RegistryPropertyViewer registryPropertyViewer;
	private static ResourceInfoViewer resourceInfoViewer;

	/*
	 * private MenuManager communitySubMenu; private MenuManager metadatMenu; private MenuManager
	 * multipleResourceUploadMenu; private MenuManager versionSubMenu;
	 */
	private MenuManager apimMenuManager;

	private DragDropUtils dragDropUtils;

	private boolean isApiManagerview;
	private String apimRegPath;

	// private String[] children= null;
	// private IViewSite viewSite;

	private ArrayList<String> children;
	private Action resourceInformationAction;

	private Text txtTraverse;
	private ArrayList<Object> selectedItemList;

	private boolean linkedWithEditor;

	public static final int CNTRL_KEY_CODE = 262144;

	boolean cntrlKeyPressed;

	private List<String> versionList;

	private RegistryResourceNode selectedEditorRegistryResourcePathData;

	private RegistryHeartBeatTester registryHeartBeatTester;

	private RegistryResourceNode copyRegResourceNode;

	private IEventBroker broker;

	private boolean traversePathChanged;

	private int chkTraverseDelay = 100;

	private int elapsedTime = 0;

	IContextActivation activation;
	IHandlerActivation activateDeleteHandler;
	IHandlerActivation activateRefreshHandler;
	IHandlerActivation activateAddResourceHandler;
	IHandlerActivation activateRenameHandler;
	IHandlerActivation activateCopyHandler;
	IHandlerActivation activatePasteHandler;

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
		selectedItemList = new ArrayList<Object>();
		this.regUrlNode = new RegistryURLNode();
		regUrlNode.addObserver(this);
		lastInstance = this;
		// registryHeartBeatTester = new RegistryHeartBeatTester(regUrlNode);
		new Thread(registryHeartBeatTester).start();
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

		parentComposite = parent;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);
		createContent(parent);
		getSite().setSelectionProvider(treeViewer);
		createToolbar(parent);

	}

	protected void loginToAPIMRegistry(Composite parent) {
		exeptionHandler = new ExceptionHandler();
		RegistryInfoDialog dialog = null;

		dialog = new RegistryInfoDialog(parent.getShell(), regUrlNode, getApimRegPath(), true);
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
				String path = dialog.getPath();

				if (!Utils.isValidServerURL(dialog.getServerUrl())) {
					if (!MessageDialog.openQuestion(parent.getShell(), "Connection Fail",
							"Establishing connection to the server failed. Do you want to add it anyway ?")) {
						return;
					}
				}

				// Verify the Registry path
				Registry reg = new Registry(uname, pwd, dialog.getServerUrl());
				reg.getResourcesPerCollection(getApimRegPath());

				regUrlNode.addRegistry(
						RegistryUrlStore.getInstance().addRegistryUrl(serverURL, uname, path, isApiManagerview()), pwd);
				setUname(uname);
				setPwd(pwd);
				setServerURL(serverURL);

				// EXPANDING THE THREE
				try {
					new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {

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

			} catch (URISyntaxException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Cannot establish the connection with given URL");
				log.error("Cannot establish the connection with given URL", e);
			} catch (MalformedURLException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Cannot establish the connection with given URL");
				log.error("Cannot establish the connection with given URL", e);
			} catch (UnknownRegistryException e) {
				MultiStatus createMultiStatusMsg = createMultiStatus("Error Registry path , "
						+ "This can be due to multipe reasons \n 1) This may not a APIM server \n  2 ) De"
						+ "fault sequence location has been changed \n\n "
						+ "You can overide the default setting from eclipse prefernace", e);
				ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Cannot Load APIM Reg browser",
						"Error Registry path , This can be due to multipe reasons \n Wrong server",
						createMultiStatusMsg);
				log.error("Login Error", e);
			} catch (InvalidRegistryURLException e) {
				MultiStatus createMultiStatusMsg = createMultiStatus("Error Registry path , "
						+ "This can be due to multipe reasons \n 1) This may not a APIM server \n  2 ) De"
						+ "fault sequence location has been changed \n\n "
						+ "You can overide the default setting from eclipse prefernace", e);
				ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Cannot Load APIM Reg browser",
						"Error Registry path , This can be due to multipe reasons \n Wrong server",
						createMultiStatusMsg);
				log.error("Login Error", e);
			}

		}

	}

	protected Control createContent(final Composite parent) {
		exeptionHandler = new ExceptionHandler();
		txtTraverse = new Text(parent, SWT.SINGLE | SWT.BORDER);
		txtTraverse.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectedItemList = new ArrayList<Object>();

		txtTraverse.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setTraversePathChanged(true);

			}

		});
		txtTraverse.setEnabled(false);
		getSite().getShell().getDisplay().timerExec(chkTraverseDelay, new TextContributionItem());
		treeViewer = new RegistryTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER,
				exeptionHandler, false, true);
		tree = treeViewer.getTree();
		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = 450;
		data.heightHint = 250;
		tree.setLayoutData(data);
		// treeViewer.setLabelProvider(labelProvider);

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

		// APIM spesific implimentaion
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

								if (node.isFileLocallyModified()) {
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
									manager.add(imporSequenceAction(node));
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
		apimMenuManager.setRemoveAllWhenShown(true);
		treeViewer.getControl().setMenu(menu);
		treeViewer.setInput(regUrlNode);

		return tree;

	}

	private void createToolbar(final Composite parent) {

		addRegistryAction = new Action("Login ") {
			public void run() {
				loginToAPIMRegistry(parent);
			}
		};
		addRegistryAction.setImageDescriptor(ImageUtils.getImageDescriptor(ImageUtils.ICON_USERS));
		IToolBarManager mgr;
		mgr = getViewSite().getActionBars().getToolBarManager();
		mgr.add(addRegistryAction);
		mgr.update(true);
	}

	protected void renameItem(Composite parent) {
		// for (int i = 0; i < selectedItemList.size(); i++) {
		// selectedObj = selectedItemList.get(i);
		if (selectedObj instanceof RegistryResourceNode) {
			RegistryResourceNode regResourceNode = (RegistryResourceNode) selectedObj;
			final String currentName = regResourceNode.getLastSegmentInPath();
			InputDialog inputDialog = new InputDialog(parent.getShell(), "Rename resource", "New name:", currentName,
					new IInputValidator() {
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
				registry = regResourceNode.getConnectionInfo().getRegistry();
				try {
					if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
						try {
							if (regResourceNode.getFileEditor() != null) {
								if (regResourceNode.getFileEditor().isDirty()) {
									if (MessageDialogUtils.question(regResourceNode.getFileEditor().getSite()
											.getShell(), "Do you want to save changes?")) {

										regResourceNode.getFileEditor().doSave(new NullProgressMonitor());

										regResourceNode.saveChangesToRegistry();
										// Resource
										// renamedResource=registry.get(regResourceNode.getRegistryResourcePath());
										// renamedResource.setContentStream(new
										// FileInputStream(regResourceNode.getFile()));
										// registry.put(regResourceNode.getRegistryResourcePath(),renamedResource );
									}
								}
								regResourceNode.getFileEditor().getEditorSite().getPage()
										.closeEditor(regResourceNode.getFileEditor(), false);
								regResourceNode.getFileEditor().dispose();
							}

						} catch (Exception e) {
							log.error("Could not close associated editor for this resource" + e.getMessage(), e);
							exeptionHandler.showMessage(parent.getShell(),
									"Could not close associated editor for this resource");
						}
					}
					registry.rename(regResourceNode.getRegistryResourcePath(), newPath);
					regResourceNode.setResourceName(newName);
					regResourceNode.getRegistryResourceNodeParent().setIterativeRefresh(true);
					regUrlNode.dataChanged(true);

					/*
					 * try { openResourceInEditor(regResourceNode); } catch (Exception e) {
					 * log.error("Could not open the file type in the editor" + e.getMessage(), e); exeptionHandler
					 * .showMessage(parent.getShell(), "Could not open the file type in the editor"); }
					 */
				} catch (InvalidRegistryURLException e) {
					log.error("Resouece renanming issue due to " + e.getMessage(), e);
				} catch (UnknownRegistryException e) {
					log.error("Resouece renaming issue due to " + e.getMessage(), e);
				}
			}
			// }

		}

	}

	protected EventHandler getTreeExpandHandler() {
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
		regUrlNode.dataChanged(false);
	}

	public void setFocus() {

	}

	private void openResourceInEditor(RegistryResourceNode resourcePathObj) {
		if (resourcePathObj.getFile() != null && resourcePathObj.getFile().exists()) {
			try {
				FileUtils.forceDelete(resourcePathObj.getFile());

				// saveChangesToRegistry(); RegistryresourceNode clazz
			} catch (IOException e) {
				log.error("Failed to delete the old file", e);
			}
		}

		// FIXME- use broker to open the editor and block the display thread while opening the editor

		File tempFile = resourcePathObj.getFile();
		IEditorPart editor = RemoteContentManager.openFile(tempFile);
		if (resourcePathObj.getFileEditor() != editor) {
			editor.getSite().getPage().addPartListener(new RegistryContentPartListener(resourcePathObj, editor));
		}

		resourcePathObj.setFileEditor(editor);

	}

	protected EventHandler getOPenEditorEvent() {
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

	protected EventHandler getTreeSelectionChenageHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						System.out.println("This is getTreeSelectionChenageHandler()");
						SelectionEvent selectionEvent = (SelectionEvent) event.getProperty(IEventBroker.DATA);
						Object obj = selectionEvent.getSource();
						if (obj instanceof Tree) {
							if (selectionEvent.stateMask == SWT.CTRL) {
								setCntrlKeyPressed(true);
								if (!selectedItemList.contains(obj)) {
									selectedItemList.add(obj);
								}
							} else {
								selectedItemList = new ArrayList<Object>();
								selectedItemList.add(obj);
							}
						}
					}
				});
			}
		};
	}

	protected EventHandler getTreeNodeSelctionChangedHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {

				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {
						System.out.println("This is getTreeNodeSelctionChangedHandler()");
						TreeSelection obj = (TreeSelection) event.getProperty(IEventBroker.DATA);
						Object object = ((TreeSelection) obj).getFirstElement();
						selectedObj = object;
						if (!(selectedItemList.contains(selectedObj))) {
							selectedItemList.add(selectedObj);
						}
						txtTraverse.setEnabled(true);
						if (object instanceof RegistryNode) {
							deleteAction.setImageDescriptor(ImageUtils
									.getImageDescriptor(ImageUtils.ACTION_DELETE_REGISTRY));
							regNode = (RegistryNode) object;
							if (regNode.isEnabled()) {
								regResourceNode = regNode.getRegistryContainer().getRegistryContent().get(0);
								resourcePath = regResourceNode.getRegistryResourcePath();
								if (resourceNodes != null) {
									if (resourceNodes.isEmpty()) {
										resourceNodes.add(regResourceNode);
									}
								}
								// resourcePathList.add(regResourcePathData);
								// regResourcePathData.setResourcePathList(resourcePathList);
								setResourcePath(resourcePath);
								setRegData(regNode);
								setRegResourcePathData(regResourceNode);
							} else {
								regResourceNode = null;
								resourcePath = null;
								setResourcePath(resourcePath);
								setRegData(regNode);
								setRegResourcePathData(regResourceNode);
							}

						} else if (object instanceof RegistryResourceNode) {

							// regResourceNode = (RegistryResourceNode) object;
							// resourcePath = regResourceNode.getRegistryResourcePath();

							/*
							 * if (resourceNodes != null) { if (resourceNodes.isEmpty()) { try { resourceNodes =
							 * regResourceNode.getResourceNodeList(); } catch (Exception e) {
							 * regResourceNode.setError(true);
							 * exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
							 * "Cannot establish the connection"); } } }
							 */

							/*
							 * if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
							 * deleteAction.setImageDescriptor(ImageUtils
							 * .getImageDescriptor(ImageUtils.ACTION_DELETE_RESOURCE));
							 * 
							 * try {
							 * 
							 * resourceNodes = regResourceNode.getResourceNodeList();
							 * 
							 * } catch (Exception e) { regResourceNode.setError(true);
							 * exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
							 * "Cannot establish the connection with given URL"); } } else {
							 * deleteAction.setImageDescriptor(ImageUtils
							 * .getImageDescriptor(ImageUtils.ACTION_DELETE_COLLECTION)); } if (resourceNodes == null)
							 * resourceNodes = new ArrayList<RegistryResourceNode>(); if (resourceNodes.isEmpty()) { //
							 * resourceNodes.add(regResourceNode); } //setResourcePath(resourcePath);
							 * //setRegResourcePathData(regResourceNode); // } else if (object instanceof
							 * RegistryUserRole) {
							 */
							selectedObj = object;
						} else if (object instanceof RegistryUser) {
							selectedObj = object;
						} else if (object instanceof RegistryUserManagerContainer) {
							selectedObj = object;
						} else if (object instanceof RegistryUserContainer) {
							selectedObj = object;
						} else if (object instanceof RegistryUserRoleContainer) {
							selectedObj = object;
						} else if (object instanceof RegistryContentContainer) {
							selectedObj = object;
						} else {
							selectedObj = null;
							selectedItemList = new ArrayList<Object>();
							txtTraverse.setEnabled(false);
						}
					}
				});
			}
		};
	}

	protected EventHandler getTreeNodeSelctionHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {

				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({})
					@Override
					public void run() {

						SelectionEvent selectionEvent = (SelectionEvent) event.getProperty(IEventBroker.DATA);
						Object obj = selectionEvent.getSource();
						if (obj instanceof Tree) {
							if (((Tree) obj).getSelection().length > 0) {
								Object object = ((Tree) obj).getSelection()[0].getData();
								if (object instanceof RegistryNode) {
									// closeOpenEditor();
									registry = ((RegistryNode) object).getRegistry();
								} else if (object instanceof RegistryResourceNode) {
									registry = ((RegistryResourceNode) object).getConnectionInfo().getRegistry();
								}
								WSResourceData wsResourceData = null;
								if (registry != null && regResourceNode != null
										&& regResourceNode.getConnectionInfo() != null
										&& regResourceNode.getConnectionInfo().isEnabled()) {
									wsResourceData = registry.getAll(regResourceNode.getRegistryResourcePath());
								}
								if (registry != null && getRegistryPropertyViewer() != null) {
									getRegistryPropertyViewer().setRegistryResourcePathData(regResourceNode);
									try {
										if (regResourceNode != null && regResourceNode.getConnectionInfo() != null
												&& regResourceNode.getConnectionInfo().isEnabled()) {
											getRegistryPropertyViewer().updateMe(wsResourceData);
										}
									} catch (Exception e) {
										log.error(e.getMessage(), e);
										registry.clearSessionProperties();
									}
								}
								if (registry != null && getResourceInfoViewer() != null) {
									getResourceInfoViewer().setRegistryResourcePathData(regResourceNode);
									try {
										if (regResourceNode != null && regResourceNode.getConnectionInfo() != null
												&& regResourceNode.getConnectionInfo().isEnabled()) {
											getResourceInfoViewer().updateMe(wsResourceData);
										}
									} catch (Exception e) {
										log.error(e.getMessage(), e);
										registry.clearSessionProperties();
									}
								}
							}
						}
					}
				});
			}
		};
	}

	public void update(Observable o, Object arg) {
		if (o instanceof RegistryBrowserTraverseListener) {
			RegistryBrowserTraverseListener r = (RegistryBrowserTraverseListener) o;
			traverseRegistryBrowser(r.getUrl(), r.getPath());
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					treeViewer.refresh(regUrlNode.isRefreshExisting());
				}
			});
		}
	}

	public void traverseRegistryBrowser(String url, String path) {
		List<RegistryNode> urlInfoList = regUrlNode.getUrlInfoList();
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
				;
				registryUrlInfo.setPersist(false);
				registryUrlInfo.setUrl(new URL(url));
				registryUrlInfo.setPath(DEFAULT_PATH);
				correctRegistryData = regUrlNode.addRegistry(registryUrlInfo, null);
			} catch (MalformedURLException e) {
				log.error(e.getMessage(), e);
			}

		}
		selectTreeViewerPath(correctRegistryData, path);
	}

	public void removeRegistryNode(String url, String path) {
		List<RegistryNode> urlInfoList = regUrlNode.getUrlInfoList();
		RegistryNode correctRegistryData = null;
		for (RegistryNode registryData : urlInfoList) {
			if (registryData.getUrl().toString().equals(url) && path.startsWith(registryData.getRegistryStartingPath())) {
				correctRegistryData = registryData;
				break;
			}
		}
		regUrlNode.removeRegistry(correctRegistryData);
	}

	public void traverseRegistryBrowser(RegistryResourceNode registryResourcePathData) {
		selectTreeViewerPath(registryResourcePathData.getConnectionInfo(),
				registryResourcePathData.getRegistryResourcePath());
	}

	// APIM Actions

	private Action copySequenceAction(final RegistryResourceNode regResourceNode) {

		Action copyActionAM = new Action("Copy") {
			public void run() {
				if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
					try {
						if (regResourceNode.getFileEditor() != null
								&& regResourceNode.getFileEditor().isDirty()
								&& MessageDialogUtils.question(regResourceNode.getFileEditor().getSite().getShell(),
										"Do you want to save changes and copy?")) {
							regResourceNode.getFileEditor().doSave(new NullProgressMonitor());
							// regResourceNode.saveChangesToRegistry();
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

				try {
					if (registry == null) {
						registry = selectedNode.getConnectionInfo().getRegistry();
					}

					Resource resource = registry.newResource();
					resource.setDescription("");
					ArtifactTemplate selectedTemplate = ArtifactTemplateHandler
							.getArtifactTemplates("org.wso2.developerstudio.eclipse.esb.sequence");
					String templateContent = org.wso2.developerstudio.eclipse.utils.file.FileUtils
							.getContentAsString(selectedTemplate.getTemplateDataStream());
					templateContent = templateContent.replaceFirst("name=", " name=");
					String source = MessageFormat.format(templateContent, sqNameWithoutExtetion);

					InputStream is = new ByteArrayInputStream(source.getBytes());
					resource.setContentStream(is);
					resource.setMediaType("application/xml");// FIXME : should not be hardcoded here
					String resourceName = selectedPath + sqName;
					registry.put(resourceName, resource);
					selectedNode.refreshChildren();
					selectedNode.getConnectionInfo().getRegUrlData().refreshViewer(false);

				} catch (InvalidRegistryURLException e) {
					log.error("Create New Sequence from APIM perspective failed due to  " + e.getMessage(), e);
				} catch (UnknownRegistryException e) {
					log.error("Create New Sequence from APIM perspective failed due to  " + e.getMessage(), e);
				} catch (RegistryException e) {
					log.error("Create New Sequence from APIM perspective failed due to  " + e.getMessage(), e);
				} catch (IOException e) {
					log.error("Create New Sequence from APIM perspective failed due to  ", e);
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

	private Action pasteSequenceAction(final RegistryResourceNode targetRegResource,
			final RegistryResourceNode copyRegResource) {

		Action paste = new Action("Paste     ") {
			@Override
			public void run() {

				try {

					if (copyRegResource != null) {

						dragDropUtils = new DragDropUtils();

						Queue queue = dragDropUtils.retrieveContentsFromRegistry(
								targetRegResource.getRegistryResourcePath(), copyRegResource);
						registry = targetRegResource.getConnectionInfo().getRegistry();
						int initialCount = queue.count();
						children = new ArrayList<String>();
						for (int i = 0; i < initialCount; i++) {
							Object element = queue.remove();
							if (element instanceof Collection) {
								String[] elements = ((Collection) element).getChildren();
								for (int j = 0; j < elements.length; j++) {
									children.add(elements[j]);
								}

							} else if (element instanceof Resource) {
								children.add(((Resource) element).getId());
							}
						}

						final Registry fromRegistry = copyRegResource.getConnectionInfo().getRegistry();
						final Registry toRegistry = targetRegResource.getConnectionInfo().getRegistry();

						if (MessageDialog.openConfirm(
								Display.getCurrent().getActiveShell(),
								"Continue copy-paste...",
								copyRegResource.getRegistryResourcePath() + " will be copied to "
										+ targetRegResource.getCaption() + ". Continue?")) {
							try {
								new ProgressMonitorDialog(getSite().getShell()).run(true, true,
										new IRunnableWithProgress() {

											public void run(IProgressMonitor monitor) throws InvocationTargetException,
													InterruptedException {
												List<String> list;
												try {
													monitor.beginTask("Copy-Paste resources...", children.size() + 1);
													list = new ArrayList<String>();
													list.add(copyRegResource.getRegistryResourcePath());
													while (list.size() != 0) {
														String path = list.get(0);
														Resource resource = fromRegistry.get(path);
														if (resource instanceof Collection) {
															String[] children = ((Collection) resource).getChildren();
															for (String child : children) {
																list.add(child);
															}
														}

														String destinationPath = targetRegResource
																.getRegistryResourcePath()
																+ path.substring(copyRegResource
																		.getRegistryResourceNodeParent()
																		.getRegistryResourcePath().length());

														toRegistry.put(destinationPath, resource);
														list.remove(0);
														monitor.worked(1);
													}
													monitor.setTaskName("Refreshing tree...");
													monitor.worked(1);

													try {
														// setCopyRegResourceNode(null);
														Display.getDefault().asyncExec(new Runnable() {
															public void run() {
																try {
																	targetRegResource.refreshChildren();
																} catch (InvalidRegistryURLException e) {
																	log.error(
																			"Resouece paste issue due to "
																					+ e.getMessage(), e);
																} catch (UnknownRegistryException e) {
																	log.error(
																			"Resouece paste issue due to "
																					+ e.getMessage(), e);
																}
																targetRegResource.getConnectionInfo().getRegUrlData()
																		.refreshViewer(false);
															}

														});
														monitor.worked(1);
													} catch (Exception e) {
														log.error("Resouece paste issue due to " + e.getMessage(), e);
													}
												} catch (Exception e) {
													log.error("Resouece paste issue due to " + e.getMessage(), e);
												}
												monitor.done();
											}

										});
							} catch (InvocationTargetException e) {
								log.error("Resouece paste issue due to " + e.getMessage(), e);
							} catch (InterruptedException e) {
								log.error("Resouece paste issue due to " + e.getMessage(), e);
							}

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
					registry = regResourceNode.getConnectionInfo().getRegistry();
					try {
						if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE) {
							try {
								if (regResourceNode.getFileEditor() != null) {
									if (regResourceNode.getFileEditor().isDirty()) {
										if (MessageDialogUtils.question(regResourceNode.getFileEditor().getSite()
												.getShell(), "Do you want to save changes?")) {

											regResourceNode.getFileEditor().doSave(new NullProgressMonitor());

											regResourceNode.saveChangesToRegistry();

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
						registry.rename(regResourceNode.getRegistryResourcePath(), newPath);
						regResourceNode.setResourceName(newName);
						regResourceNode.getRegistryResourceNodeParent().setIterativeRefresh(true);
						regUrlNode.dataChanged(true);

					} catch (InvalidRegistryURLException e) {
						log.error("Resouece renanming issue due to " + e.getMessage(), e);
					} catch (UnknownRegistryException e) {
						log.error("Resouece renaming issue due to " + e.getMessage(), e);
					}
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

					try {

						registry = regResourceNode.getConnectionInfo().getRegistry();
						String selectedPath = regResourceNode.getRegistryResourcePath();
						SWTControlUtils.closeAssociatedEditor(regResourceNode.getEditorInput());
						registry.delete(selectedPath);

						if (regResourceNode.getRegistryResourceNodeParent() == null) {
							refreshItem(regResourceNode.getRegistryResourceNodeParent());
						} else {
							Display.getDefault().asyncExec(new Runnable() {

								public void run() {
									try {
										regResourceNode.getRegistryResourceNodeParent().refreshChildren();
									} catch (InvalidRegistryURLException e) {
										log.error("Error while deleting action error due to " + e.getMessage(), e);
									} catch (UnknownRegistryException e) {
										log.error("Error while deleting action error due to " + e.getMessage(), e);
									}
								}
							});
						}

						// TOOLS-623
						if (regResourceNode.getResourceType() == RegistryResourceType.RESOURCE
								&& regResourceNode.getFileEditor() != null) {
							regResourceNode.getFileEditor().getEditorSite().getPage()
									.closeEditor(regResourceNode.getFileEditor(), false);
						}
						regUrlNode.dataChanged(false);

					} catch (Exception e) {
						MessageDialogUtils.error(Display.getCurrent().getActiveShell(),
								"Error while deleting resource: " + e.getMessage());
						log.error(e);
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

	public Action imporSequenceAction(final RegistryResourceNode regResourceNode) {
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
						regResourceNode.saveChangesToRegistry();
						refreshItem(regResourceNode);
						MessageDialogUtils.info(Display.getCurrent().getActiveShell(), " ",
								"Sucessfully applied the local changes");
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
		fileDialog.setText("Select files to be uploaded to the registry");
		if (fileDialog.open() != null) {
			final String fileName = fileDialog.getFileName();
			if (MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Continue uploading...",
					" file will be uploaded. Continue?")) {
				try {
					new ProgressMonitorDialog(getSite().getShell()).run(true, true, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) throws InvocationTargetException,
								InterruptedException {

							monitor.beginTask("Uploading resources...", 100);
							monitor.worked(0);
							int count = 0;
							monitor.setTaskName("Uploading " + fileName + "...");
							try {
								File file = new File(fileDialog.getFilterPath(), fileName);
								if (file.exists()) {
									regResourceNode.getConnectionInfo().getRegistry()
											.addFileToRegistry(file, regResourceNode.getRegistryResourcePath(), null);
								}
								monitor.worked(1);
							} catch (Exception e) {
								MessageDialogUtils.error(Display.getCurrent().getActiveShell(),
										"Error while Uploading " + fileName + "... due to : " + e.getMessage());
								log.error("Error while Uploading " + fileName + "... due to : " + e.getMessage(), e);
							}
							monitor.setTaskName("Refreshing tree...");
							monitor.worked(1);
							try {
								monitor.worked(++count);
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										try {
											regResourceNode.refreshChildren();
										} catch (InvalidRegistryURLException e) {
											log.error(e.getMessage(), e);
										} catch (UnknownRegistryException e) {
											log.error(e.getMessage(), e);
										}
										regResourceNode.getConnectionInfo().getRegUrlData().refreshViewer(false);
									}

								});

								monitor.setTaskName("Opening the file ...");
								monitor.worked(1);

							} catch (Exception e) {
								MessageDialogUtils.error(Display.getCurrent().getActiveShell(),
										"Error while Refreshing tree... due to : " + e.getMessage());
								log.error("Error while Refreshing tree... due to : " + e.getMessage(), e);
							}
							monitor.done();
						}

					});
				} catch (InvocationTargetException e) {
					log.error(e.getMessage(), e);
				} catch (InterruptedException e) {
					log.error(e.getMessage(), e);
				}

			}
		}
	}

	private static MultiStatus createMultiStatus(String msg, Throwable t) {

		List<Status> childStatuses = new ArrayList<Status>();
		StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

		for (StackTraceElement stackTrace : stackTraces) {
			Status status = new Status(IStatus.ERROR, "com.example.e4.rcp.todo", stackTrace.toString());
			childStatuses.add(status);
		}

		MultiStatus ms = new MultiStatus("com.example.e4.rcp.todo", IStatus.ERROR,
				childStatuses.toArray(new Status[] {}), t.toString(), t);
		return ms;
	}

	// Utitlity methods

	private void changeRegistryUrlStatus(boolean enabled) {
		if (selectedObj instanceof RegistryNode) {
			RegistryNode regData = (RegistryNode) selectedObj;
			if (enabled) {
				if (!Utils.isValidServerURL(regData.getServerUrl())) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Connect with the registry...",
							"This registry instance is unreachable: \n\n\t" + regData.getServerUrl());
					regData.setPersistantEnabled(enabled);
					regData.setEnabled(false);
					return;
				}
			}
			regData.setUserEnabled(enabled);
			regData.setPersistantEnabled(enabled);
			regData.getRegUrlData().refreshViewer(true);
			// updateToolbar();
		}
	}

	public void dispose() {
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
		return regUrlNode;
	}

	public void setRegUrlData(RegistryURLNode regUrlData) {
		this.regUrlNode = regUrlData;
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
		elapsedTime = 0;
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

	public class VersionViewAction extends Action {

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

	public class RestoreVersionAction extends Action {
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

	public class TextContributionItem implements Runnable {
		public void run() {
			if (isTraversePathChanged()) {
				if (elapsedTime > 600) {
					if (regNode == null)
						regNode = regUrlNode.getUrlInfoList().get(0);
					String txt = getTraversePath();
					treeViewer.expandTree(regNode, txt);
					txtTraverse.setFocus();
					setTraversePathChanged(false);
					elapsedTime = 0;
				} else
					elapsedTime += chkTraverseDelay;

			}
			if (getSite().getShell() != null)
				getSite().getShell().getDisplay().timerExec(chkTraverseDelay, this);
		}
	}
}
