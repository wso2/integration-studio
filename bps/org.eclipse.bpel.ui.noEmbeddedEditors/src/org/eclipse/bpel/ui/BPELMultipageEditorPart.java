/*******************************************************************************
 * Copyright (c) 2007, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vitaly Tishkov, Intel - Initial API and Implementation
 *
 *******************************************************************************/ 

package org.eclipse.bpel.ui;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.ui.editmodel.IEditModelListener;
import org.eclipse.bpel.common.ui.editmodel.ResourceInfo;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.adapters.AdapterNotification;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.ProcessTrayEditPart;
import org.eclipse.bpel.ui.editparts.util.OutlineTreePartFactory;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.uiextensionmodel.StartNode;
import org.eclipse.bpel.ui.util.BPELEditModelClient;
import org.eclipse.bpel.ui.util.BPELEditorUtil;
import org.eclipse.bpel.ui.util.BPELReader;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabDescriptor;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyViewer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabContents;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.xml.core.internal.provisional.contenttype.ContentTypeIdForXML;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BPELMultipageEditorPart extends MultiPageEditorPart
implements IEditModelListener,
IGotoMarker/*, CommandStackListener*/ {

	class OutlinePage extends ContentOutlinePage {
		private PageBook pageBook;
		private Control outline;
		private Canvas overview;
		private IAction showOutlineAction, showOverviewAction;
		static final int ID_OUTLINE  = 0;
		static final int ID_OVERVIEW = 1;
		private Thumbnail thumbnail;

		public OutlinePage(EditPartViewer viewer) {
			super(viewer);
		}

		// increase visibility.
		@Override
		public EditPartViewer getViewer() {
			return super.getViewer();
		}

		private void configureOutlineViewer() {
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new OutlineTreePartFactory());

			BPELMultipageEditorPart.this.fDesignViewer.registerViewer(getViewer());

			//FIXME should we add the same for src tab?
			ContextMenuProvider provider = new ProcessContextMenuProvider(getDesignEditor(), BPELMultipageEditorPart.this.fDesignViewer.getActionRegistry());

			getViewer().setContextMenu(provider);
			getSite().registerContextMenu("org.eclipse.bpel.outline.contextmenu", //$NON-NLS-1$
					provider,
					getSite().getSelectionProvider());
			getViewer().setKeyHandler(BPELMultipageEditorPart.this.fDesignViewer.getKeyHandler());
			// TODO: Drag and drop support goes here
			// getViewer().addDropTargetListener(new BPELTemplateTransferDropTargetListener(getViewer()));
			IToolBarManager tbm = getSite().getActionBars().getToolBarManager();
			this.showOutlineAction = new Action() {
				@Override
				public void run() {
					showPage(ID_OUTLINE);
				}

				@Override
				public String getToolTipText() {
					return Messages.OutlinePage_showOutlineView;
				}
			};
			this.showOutlineAction.setImageDescriptor(BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_OUTLINE_16));
			tbm.add(this.showOutlineAction);
			this.showOverviewAction = new Action() {
				@Override
				public void run() {
					showPage(ID_OVERVIEW);
				}

				@Override
				public String getToolTipText() {
					return Messages.OutlinePage_showOverviewView;
				}
			};
			this.showOverviewAction.setImageDescriptor(BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_OVERVIEW_16));
			tbm.add(this.showOverviewAction);
			showPage(ID_OUTLINE);
		}

		@Override
		public Control getControl() {
			return this.pageBook;
		}

		@Override
		public void createControl(Composite parent) {
			this.pageBook = new PageBook(parent, SWT.NONE);
			this.outline = getViewer().createControl(this.pageBook);
			this.overview = new Canvas(this.pageBook, SWT.NONE);
			this.pageBook.showPage(this.outline);
			configureOutlineViewer();
			// TODO: Add to the adapting selection provider
			//getSelectionSynchronizer().addViewer(getViewer());

			getViewer().setContents(getProcess());
		}

		private void initializeOverview() {
			LightweightSystem lws = new LightweightSystem(this.overview);
			RootEditPart rep = BPELMultipageEditorPart.this.fDesignViewer.getGraphicalViewer().getRootEditPart();
			if (rep instanceof GraphicalBPELRootEditPart) {
				GraphicalBPELRootEditPart root = (GraphicalBPELRootEditPart)rep;
				this.thumbnail = new ScrollableThumbnail((Viewport)root.getFigure());
				this.thumbnail.setSource(root.getLayer(LayerConstants.PRINTABLE_LAYERS));
				lws.setContents(this.thumbnail);
			}
		}

		private void showPage(int id) {
			if (id == ID_OUTLINE) {
				this.showOutlineAction.setChecked(true);
				this.showOverviewAction.setChecked(false);
				this.pageBook.showPage(this.outline);
				if (this.thumbnail != null)
					this.thumbnail.setVisible(false);
			} else if (id == ID_OVERVIEW) {
				initializeOverview();
				this.showOutlineAction.setChecked(false);
				this.showOverviewAction.setChecked(true);
				this.pageBook.showPage(this.overview);
				this.thumbnail.setVisible(true);
			}
		}

		@Override
		public void dispose() {
			super.dispose();
		}

		@Override
		public void init(IPageSite pageSite) {
			super.init(pageSite);
			//should ActionRegistry be here too?
			ActionRegistry registry = BPELMultipageEditorPart.this.fDesignViewer.getActionRegistry();
			IActionBars bars = pageSite.getActionBars();
			String id = ActionFactory.UNDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.REDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.DELETE.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.REVERT.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			bars.updateActionBars();
		}
	}

	protected class TextEditorSelectionListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			if (getActivePage() != DESIGN_PAGE_INDEX) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					List<Object> selections = new ArrayList<Object>();
					for (Iterator<Object> i = ((IStructuredSelection) selection).iterator(); i.hasNext();) {
						Object domNode = i.next();
						if (domNode instanceof Element) {
							Object facade = BPELEditorUtil.getInstance().findModelObjectForElement(BPELMultipageEditorPart.this.process, (Element)domNode);
							if (facade != null) {
								selections.add(facade);
							}
						}
					}

					if (!selections.isEmpty()) {
						StructuredSelection bpelSelection = new StructuredSelection(selections);
						BPELMultipageEditorPart.this.fDesignViewer.getAdaptingSelectionProvider().setSelection(bpelSelection);
					}
				}
			}
		}
	}

	protected class DesignViewerSelectionListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			//force selection update if only source page is not active
			if (getActivePage() != SOURCE_PAGE_INDEX) {
				try {
					ISelection sel = BPELMultipageEditorPart.this.fDesignViewer.getSelection();
					Object selectedNode = ((IStructuredSelection)sel).getFirstElement();
					Element selectedNodeElement = null;

					if (selectedNode instanceof StartNode) {
						selectedNodeElement = ((StartNode)selectedNode).getProcess().getElement();
					} else if (selectedNode instanceof BPELExtensibleElement) {
						selectedNodeElement = ((BPELExtensibleElement)selectedNode).getElement();
					}

					if (selectedNodeElement != null) {
						if (selectedNodeElement instanceof IDOMNode && ((IDOMNode)selectedNodeElement).getModel().isModelStateChanging()) {
							return;
						}
						StructuredSelection nodeSelection = new StructuredSelection(selectedNodeElement);
						getTextEditor().getSelectionProvider().setSelection(nodeSelection);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Process process;

	private DefaultEditDomain editDomain;

	protected ModelListenerAdapter modelListenerAdapter;

	private Resource extensionsResource;

	private ExtensionMap extensionMap;

	protected StructuredTextEditor fTextEditor = null;
	protected BPELEditor fDesignViewer = null;
	protected int currentPage = -1;


	protected TextEditorSelectionListener textEditorSelectionListener;
	protected DesignViewerSelectionListener designViewerSelectionListener;

	// reacts to changes on the BPEL file (e.g. move, rename)
	private IFileChangeListener fileChangeListener;

	// refactoring listeners
	protected IResourceChangeListener postBuildRefactoringListener;

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	protected IResourceChangeListener preBuildRefactoringListener;
	BPELModelReconcileAdapter bpelModelReconcileAdapter;

	private OutlinePage outlinePage;
	protected BPELTabbedPropertySheetPage currentPropertySheetPage;

	protected ActionRegistry actionRegistry;

	private static int DESIGN_PAGE_INDEX = 0;
	private static int SOURCE_PAGE_INDEX = 1;

	private final Map<Long, EObject>fMarkers2EObject = new HashMap<Long, EObject>();
	private final Notification fMarkersStale = new NotificationImpl(
			AdapterNotification.NOTIFICATION_MARKERS_STALE, null, null);

	public BPELMultipageEditorPart() {
		super();
		setEditDomain(new BPELEditDomain(this));
	}

	/**
	 * Connects the design viewer with the viewer selection manager. Should be
	 * done after createSourcePage() is done because we need to get the
	 * ViewerSelectionManager from the TextEditor. setModel is also done here
	 * because getModel() needs to reference the TextEditor.
	 */
	protected void connectDesignPage() {

		/*
		 * Connect selection from the Design page to the selection provider of
		 * the Source page so that selection in the Design page will drive
		 * selection in the Source page.
		 */
		this.designViewerSelectionListener = new DesignViewerSelectionListener();
		this.fDesignViewer.getAdaptingSelectionProvider().addSelectionChangedListener(this.designViewerSelectionListener);

		/*
		 * Connect selection from the Source page to the selection provider of
		 * the Design page so that selection in the Source page will drive
		 * selection in the Design page.
		 */
		this.textEditorSelectionListener = new TextEditorSelectionListener();
		ISelectionProvider provider = getTextEditor().getSelectionProvider();
		if (provider instanceof IPostSelectionProvider) {
			((IPostSelectionProvider) provider).addPostSelectionChangedListener(this.textEditorSelectionListener);
		} else {
			provider.addSelectionChangedListener(this.textEditorSelectionListener);
		}

	}

	/**
	 * Creates the design page of the multi-page editor.
	 */
	protected void createDesignPage() {
		this.fDesignViewer = new BPELEditor(getEditDomain(), this);
		// Bug #209341 - starting patch
		if( getFileInput() == null ) {
			MessageDialog.openError(
					getSite().getShell(),
					Messages.Editor_load_error_title, // Bugzilla 330513
					Messages.Editor_load_error
			);
			return;
		}
		// End of patch
		try
		{
			loadModel();
			addPage(0, this.fDesignViewer, getEditorInput());
			//FIXME I18N
			setPageText(0, "Design");
		} catch (PartInitException e) {
			ErrorDialog.openError(
					getSite().getShell(),
					Messages.Editor_design_page_error, // Bugzilla 330513
					null,
					e.getStatus()); //$NON-NLS-1$
		} catch (CoreException e) {
			// TODO: what to do here?
		}
	}

	// https://jira.jboss.org/browse/JBIDE-6917
	@Override
	protected IEditorSite createSite(IEditorPart page) {
		IEditorSite site = null;
		if (page == fTextEditor) {
			site = new org.eclipse.ui.part.MultiPageEditorSite(this, page) {
				public String getId() {
					// Sets this ID so nested editor is configured for BPEL source
					return BPELResourceSetImpl.BPEL_CONTENT_TYPE;
				}
			};
		}
		else {
			site = super.createSite(page);
		}
		return site;
	}

	/**
	 * Creates the source page of the multi-page editor.
	 */
	protected void createSourcePage() throws PartInitException {
		this.fTextEditor = new StructuredTextEditor();
		try
		{
			addPage(0, this.fTextEditor, getEditorInput());
			//FIXME I18N
			setPageText(0, "Source");
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), "Error creating Source page", null, e.getStatus()); //$NON-NLS-1$
		}
	}

	/**
	 * Creates the pages of this multi-page editor.
	 */
	@Override
	protected void createPages() {
		try {
			// source page must be created before design page
			createSourcePage();
			createDesignPage();
			firePropertyChange(PROP_TITLE);
			connectDesignPage();
			initializeFileChangeListener();
			initializeRefactoringListener();
		} catch (PartInitException e) {
			//Logger.logException(e);
			throw new RuntimeException(e);
		}

		if (BPELUIPlugin.INSTANCE.getDefaultPage().equals(IBPELUIConstants.SOURCE_PAGE)) {
			setActivePage(SOURCE_PAGE_INDEX);
		} else {
			setActivePage(DESIGN_PAGE_INDEX);
		}

		//updateTitle();
	}


	@Override
	public void dispose() {
		/*if (outlinePage != null && outlinePage.getViewer() != null) {
			outlinePage.getViewer().setContents(null);
		}*/
		if (this.currentPage == SOURCE_PAGE_INDEX) {
			BPELUIPlugin.INSTANCE.setDefaultPage(IBPELUIConstants.SOURCE_PAGE);
		} else {
			BPELUIPlugin.INSTANCE.setDefaultPage(IBPELUIConstants.DESIGN_PAGE);
		}

		this.outlinePage = null;
		this.process = null;

		if (this.fileChangeListener != null) {
			BPELUIPlugin.INSTANCE.getResourceChangeListener().removeListener(this.fileChangeListener);
		}

		if (this.postBuildRefactoringListener != null) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(this.postBuildRefactoringListener);
		}

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-6365
		if (this.preBuildRefactoringListener != null) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(this.preBuildRefactoringListener);
		}
		IStructuredModel model = this.fTextEditor.getModel();
		if (model != null) {
			model.releaseFromEdit();
			this.fDesignViewer.dispose();
			this.fTextEditor.dispose();
		}

		super.dispose();
	}
	
	public void doRevertToSaved(IProgressMonitor monitor) {
		// Do the work within an operation because this is a long running activity that modifies the workbench.
//		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
//			protected void execute(IProgressMonitor monitor) throws CoreException {
//				try {
//					getCommandFramework().abortCurrentChange();
//					getCommandStack().flush();
//					
//					// de-select anything selected on the canvas!  Otherwise removing things
//					// will trigger a bunch of behaviour when the selected object(s) are
//					// removed..
//					adaptingSelectionProvider.setSelection(StructuredSelection.EMPTY);
//					
//					process = null;
//					extensionMap = null;
//					extensionsResource = null;
//					lastSelectedEditPart = null;
//					// unload all resources (otherwise they stay around taking up space..?)
//					for (Iterator it = getResourceSet().getResources().iterator(); it.hasNext(); ) {
//						Resource res = (Resource)it.next();
//						res.unload();
//					}
//					loadModel();
//					getGraphicalViewer().setContents(process);
//					getTrayViewer().setContents(process);
//					if (outlinePage != null && outlinePage.getViewer() != null) {
//                      // hack!
//						if (Platform.getWS().equals(Platform.WS_GTK)) {
//							Tree tree = (Tree) outlinePage.getViewer().getControl();
//							if (tree != null) {
//								tree.setRedraw(false);
//								TreeItem[] items = tree.getItems();
//								for (int i = 0; i < items.length; i++) {
//									items[i].dispose();
//								}
//								tree.setRedraw(true);
//							}
//						}
//						outlinePage.getViewer().setContents(process);
//					}
//					selectModelObject(getProcess());
//				}
//				catch (Exception e) {
//					BPELUIPlugin.log(e);
//				}
//			}
//		};
//
//		try {
//			// This runs the options, and shows progress.
//			// (It appears to be a bad thing to fork this onto another thread.)
//			new ProgressMonitorDialog(getSite().getShell()).run(false, false, operation);
//
//			// Refresh the necessary state.
//			firePropertyChange(IEditorPart.PROP_DIRTY);
//		} catch (Exception e) {
//			BPELUIPlugin.log(e);
//		}
	}

	/**
	 * @see org.eclipse.ui.IEditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// We use fTextEditor to save, because fDesignViewer.doSave() removes comments on save
		// Save bpel only
		this.fDesignViewer.getCommandFramework().applyCurrentChange();
		this.fTextEditor.doSave(progressMonitor);
		// Reset sync stamp and modified flag after save
		this.fDesignViewer.getEditModelClient().getPrimaryResourceInfo().resetSynchronizeStamp();
		this.fDesignViewer.getEditModelClient().getPrimaryResourceInfo().getResource().setModified(false);
		// Save extensions
		this.fDesignViewer.doSave(progressMonitor);
		getCommandStack().markSaveLocation();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		//saveAs is not allowed; do nothing
	}

	protected BPELTabbedPropertySheetPage createBPELTabbedPropertySheetPage() {
		//FIXME should the BPELTabbedPropertySheetPage has BPELMultiPageEditorPart as the 2nd argument?
		return new BPELTabbedPropertySheetPage(new ITabbedPropertySheetPageContributor() {
			public String getContributorId() {
				// same as the palette one
				//return fDesignViewer.getPaletteAdditionsContributorId();
				return IBPELUIConstants.BPEL_EDITOR_ID;
			}
		}, this.fDesignViewer);
	}


	protected ActionRegistry getActionRegistry() {
		if (this.actionRegistry == null)
			this.actionRegistry = new ActionRegistry();
		return this.actionRegistry;
	}


	@Override
	public Object getAdapter(Class type) {
		if (type == Process.class) {
			return this.process;
		}

		if (type == BPELEditModelClient.class) {
			return this.process;
		}

		//FIXME should we kill it?
		if (type == ModelListenerAdapter.class) {
			return this.modelListenerAdapter;
		}

		//FIXME should we kill it?
		if (type == Resource.class) {
			return this.extensionsResource;
		}

		//FIXME should we kill it?
		if (type == ExtensionMap.class) {
			return this.extensionMap;
		}

		//FIXME should we kill it?
		if (type == CommandStack.class) {
			return getCommandStack();
		}

		if (type == IContentOutlinePage.class) {
			if (this.outlinePage == null) {
				this.outlinePage = new OutlinePage(new TreeViewer());
			}
			return this.outlinePage;
		}

		if (type == IPropertySheetPage.class) {
			// We can't cache this object because the properties framework needs a new instance
			// every time it calls this method.
			this.currentPropertySheetPage = createBPELTabbedPropertySheetPage();
			return this.currentPropertySheetPage;
		}

		if (type == ActionRegistry.class) {
			return getActionRegistry();
		}

		return super.getAdapter(type);
	}

	public CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}

	protected int getDefaultPageTypeIndex() {
		int pageIndex = DESIGN_PAGE_INDEX;
		if (BPELUIPlugin.INSTANCE.getDefaultPage().equals(IBPELUIConstants.SOURCE_PAGE)) {
			pageIndex = SOURCE_PAGE_INDEX;
		}
		return pageIndex;
	}


	/**
	 * Returns the design viewer
	 * @return the design viewer
	 */
	protected BPELEditor getDesignEditor() {
		return this.fDesignViewer;
	}

	/**
	 * Returns the edit domain.
	 * @return the edit domain
	 */
	protected DefaultEditDomain getEditDomain() {
		return this.editDomain;
	}

	// Bug #209341 - patch
	// By Vincent Zurczak - EBM WebSourcing
	private IFile openFile;
	private static String filePrefix = new SimpleDateFormat( "yyyyMMF_" ).format( new GregorianCalendar().getTime());

	/**
	 * 
	 * @return
	 */
	protected IFile getFileInput() {

		if( this.openFile == null ) {
			try {
				// Case where the file is in the workspace
				if( getEditorInput() instanceof IFileEditorInput )
					this.openFile = ((IFileEditorInput) getEditorInput()).getFile();

				// Outside the workspace
				// Since everything relies on IFiles, we create a temporary file in the workspace
				// linking to the file outside the workspace
				else if( getEditorInput() instanceof FileStoreEditorInput ) {
					File f = new File(((FileStoreEditorInput) getEditorInput()).getURI());
					IPath path = new Path( f.getAbsolutePath());

					// Create a temporary project
					IProgressMonitor monitor =  new NullProgressMonitor();
					IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject( ".temp" );
					if( ! tempProject.exists())
						tempProject.create( monitor );

					if( ! tempProject.isOpen())
						tempProject.open( monitor );

					// Remove old temporary files
					// The file prefix is designed so that natural comparison order is enough
					for( IResource res : tempProject.members()) {
						if( res.getName().substring( 0, 7 ).compareTo( filePrefix ) < 0 ) {
							try {
								res.delete( false, monitor );
							} catch( Exception e ) {
								e.printStackTrace();
							}
						}
					}

					// Create a temporary file
					this.openFile = tempProject.getFile( filePrefix + path.lastSegment());
					this.openFile.createLink( path, IResource.NONE, monitor );
				}

			} catch( CoreException e ) {
				e.printStackTrace();
			}
		}

		return this.openFile;
	}
	// End of patch

	public Process getProcess() {
		return this.process;
	}

	/**
	 * Returns the design viewer
	 * @return the design viewer
	 */
	protected StructuredTextEditor getSourceViewer() {
		return this.fTextEditor;
	}

	StructuredTextEditor getTextEditor() {
		return this.fTextEditor;
	}

	public void gotoMarker(IMarker marker) {

		// One such mechanism is to use the href of the model object
		// generated by the validator or whatever ...

		String href = null;
		try {
			href = (String) marker.getAttribute( "address.model" );
		} catch (CoreException ex) {
			BPELUIPlugin.log(ex);
		}

		// lookup by object href in the model.
		EObject modelObject = null;

		if (href != null) {
			try {
				modelObject = this.fDesignViewer.getResource().getEObject( href );
			} catch (Throwable t) {
				BPELUIPlugin.log(t);
			}
		}

		gotoText(marker);

		if (modelObject == null) {
			return;
		}

		gotoMarker ( marker, modelObject );
	}

	private void gotoText(IMarker marker) {
		Integer charStart = null;
		Integer charEnd = null;
		try {
			charStart = (Integer) marker.getAttribute( "charStart" );
			charEnd = (Integer) marker.getAttribute( "charEnd" );
		} catch (CoreException ex) {
			BPELUIPlugin.log(ex);
		}
		charStart = charStart == null ? 0 : charStart;
		charEnd = charEnd == null ? charStart : charEnd;
		try {
			this.fTextEditor.setHighlightRange(charStart, charEnd - charStart, true);
		} catch (Throwable t) {
			BPELUIPlugin.log(t);
		}
	}

	void gotoMarker ( IMarker marker, EObject modelObject ) {

		// TODO: is this bogus now that we have AdaptingSelectionProvider?


		// The closest parent which has an edit part in the graph view.
		//
		// The following do not have viewers in the graph view:
		//  1) Variables, PartnerLinks, Correlation Sets, Message Exchanges
		// If it's any of those, then we have to reveal the closest container
		// and then select the model object and show the properties.

		GraphicalViewer graphViewer = this.fDesignViewer.getGraphicalViewer();
		EObject refObj = null;

		EditPart editPart = null;
		if ( modelObject instanceof Variable ||
				modelObject instanceof PartnerLink ||
				modelObject instanceof CorrelationSet ||
				modelObject instanceof MessageExchange) {

			refObj = ModelHelper.getContainingScope(modelObject);
			editPart = (EditPart)graphViewer.getEditPartRegistry().get(refObj);
			if (editPart != null) {
				graphViewer.reveal(editPart);
			}
			this.fDesignViewer.selectModelObject(modelObject);

		} else if (modelObject instanceof Activity) {

			// activity objects are on the graphical viewer
			refObj = modelObject;
			editPart = (EditPart)graphViewer.getEditPartRegistry().get(refObj);

			if (editPart != null) {
				graphViewer.reveal(editPart);
			}

			this.fDesignViewer.selectModelObject(modelObject);


		} else {

			refObj = modelObject;
			while (refObj != null && !(refObj instanceof Activity) ) {
				refObj = refObj.eContainer();
			}

			// select process by default.
			if (refObj == null) {
				refObj = BPELUtils.getProcess( modelObject ) ;
			}

			modelObject = refObj;

			editPart = (EditPart)graphViewer.getEditPartRegistry().get(modelObject);

			if (editPart != null) {
				graphViewer.reveal(editPart);
			}

			this.fDesignViewer.selectModelObject(modelObject);
		}

		// If possible, try to display the marker in a property section.
		BPELTabbedPropertySheetPage propertySheetPage = this.currentPropertySheetPage;
		if (propertySheetPage == null) {
			return;
			// if currentPropertySheetPage is null it means that the properties
			// page hasn't shown yet. Since we only want to show it if we have
			// markers for it we create a new BPELTabbedPropertySheetPage. This
			// new one should only be used to select which tab and section to show.
			// TODO: this doesn't work
			//propertySheetPage = createBPELTabbedPropertySheetPage();
		}

		TabbedPropertyViewer viewer = propertySheetPage.getTabbedPropertyViewer();

		int j = 0;
		while (true) { // while we don't get an exception...
			TabDescriptor descriptor = null;
			try {
				descriptor = (TabDescriptor)viewer.getElementAt(j++);
			} catch (IndexOutOfBoundsException iobe) {
				break;
			}

			if (descriptor == null) {
				break; // no more descriptors
			}

			TabContents tab = descriptor.createTab();
			ISection[] sections = tab.getSections();
			for (int i = 0; i < sections.length; i++) {

				if (BPELPropertySection.class.isInstance( sections[i]) == false) {
					continue;
				}

				BPELPropertySection section = (BPELPropertySection)sections[i];

				// HACK: we have to fake the initialization of this section in order to
				// make isValidMarker work. This section should not be used as a normal section.
				section.createControls(new Composite(getSite().getShell(), 0), propertySheetPage);
				section.setInput(this, new StructuredSelection(modelObject));

				if (section.isValidMarker (marker) ) {

					// the first section that handles this kind of marker wins
					showPropertiesView();
					// get real viewer, Tab and ISection objects since we are probably using fake ones
					viewer = this.currentPropertySheetPage.getTabbedPropertyViewer();
					viewer.setSelection(new StructuredSelection(descriptor));
					tab = this.currentPropertySheetPage.getCurrentTab();
					section = (BPELPropertySection)tab.getSectionAtIndex(i);
					section.gotoMarker(marker);
					return; // ignore other sections and tabs

				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorPart#init(org.eclipse.ui.IEditorSite,
	 *      org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		try {
			super.init(site, input);
			//			getCommandStack().addCommandStackListener(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setPartName(input.getName());
	}

	protected void initializeFileChangeListener() {
		this.fileChangeListener = new IFileChangeListener() {
			public void deleted(IFile file) {
				IFile current = ((IFileEditorInput)getEditorInput()).getFile();
				if (current.equals(file)) {
					// Close the editor.
					Display display = getSite().getShell().getDisplay();
					display.asyncExec(new Runnable() {
						public void run() {
							getSite().getPage().closeEditor(BPELMultipageEditorPart.this, false);
						}
					});
				}
			}
			public void moved(IFile source, final IFile destination) {
//				IFile current = ((IFileEditorInput) getEditorInput()).getFile();
//				if (!current.equals(source)) {
//					return;
//				}
//				// update editors input
//				final IFileEditorInput input = new FileEditorInput(destination);
//				Display display = getDetailsEditor().getSite().getShell().getDisplay();
//				display.syncExec(new Runnable() {
//					public void run() {
//						getBPELDetailsEditor().setInput(input);
//						setInput(input);
//					}
//				});
//				// update resources
//				IPath path = destination.getFullPath();
//				URI uri = URI.createPlatformResourceURI(path.toString());
//				processResource.setURI(uri);
//				// JM: Comment out. We don't want to re-name the process just because
//				// the file name has changed
////				display.syncExec(new Runnable() {
////					public void run() {
////						BPELUtil.updateNameAndNamespace(destination, process);
////					}
////				});
//				path = path.removeFileExtension().addFileExtension(IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS);
//				URI extensionsUri = URI.createPlatformResourceURI(path.toString());
//				extensionsResource = resourceSet.createResource(extensionsUri);
//				extensionsResource.setURI(extensionsUri);
//				try {
//					// JM: Comment out for now. We should re-test this
////					processResource.save(Collections.EMPTY_MAP);
////					destination.refreshLocal(IResource.DEPTH_ZERO, null);
//				} catch (Exception e) {
//					BPELUIPlugin.log(e);
//				}
			}
		};
		BPELUIPlugin.INSTANCE.getResourceChangeListener().addListener(this.fileChangeListener);
	}


	/**
	 * Installs the refactoring listener
	 */
	protected void initializeRefactoringListener() {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		this.postBuildRefactoringListener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				IFile newFile = ((FileEditorInput)getEditorInput()).getFile();
				final IResourceDelta bpelFileDelta = event.getDelta().findMember(newFile.getFullPath());
				// we only care about the change if it is a move or a rename
				if (bpelFileDelta != null && (bpelFileDelta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
					getSite().getShell().getDisplay().syncExec(new Runnable() {
						public void run() {
							doRevertToSaved(null);
						}
					});
				}
			}
		};
		workspace.addResourceChangeListener(this.postBuildRefactoringListener, IResourceChangeEvent.POST_BUILD);

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-6365
		this.preBuildRefactoringListener = new RefactoringListener();
		workspace.addResourceChangeListener(this.preBuildRefactoringListener, IResourceChangeEvent.PRE_BUILD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	protected void loadModel() throws CoreException {
		Document structuredDocument = null;

		try {
			IDocument doc = this.fTextEditor.getDocumentProvider().getDocument(getEditorInput());
			if (doc instanceof IStructuredDocument) {
				IStructuredModel model = StructuredModelManager.getModelManager().getExistingModelForEdit(doc);
				if (model == null) {
					model = StructuredModelManager.getModelManager().getModelForEdit((IStructuredDocument) doc);
				}
				if (model != null) {
					structuredDocument = ((IDOMModel) model).getDocument();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HashMap<String, Document> loadOptions = null;
		if (structuredDocument != null) {
			loadOptions = new HashMap<String, Document> (1);
			loadOptions.put("DOMDocument", structuredDocument);
		}

		//FIXME WSDLEditor has gef command stack; in order to have gef command stack we need to add design page first

		// Bug # 209341 - starting patch
		// By Vincent Zurczak
		IFile file = null;
		BPELEditModelClient editModelClient = new BPELEditModelClient(this);

		// Bugzilla 330513
		// first load the primary resource (the *.bpel file)
		boolean keepGoing = false;
		Shell shell = getEditorSite().getShell();
		try {
			file = getFileInput();
			editModelClient.loadPrimaryResource(file,loadOptions);
		}
		catch (RuntimeException ex) {
			String msg = NLS.bind(Messages.EditModelClient_bpel_load_error,
					new String[]{file.toString()}
			); 

			keepGoing = MessageDialog.openQuestion(
					shell, 
					Messages.EditModelClient_load_error_title,  
					msg);
			
			if (!keepGoing)
				throw ex;
		}

		// next load the extensions resource (the *.bpelex file)
		try {
			editModelClient.loadExtensionsResource();
		}
		catch (RuntimeException ex) {
			file = editModelClient.getExtensionsFile();
			String msg = NLS.bind(Messages.EditModelClient_bpelex_load_error,
					new String[]{file.toString()}
			); 

			keepGoing = MessageDialog.openQuestion(
					shell, 
					Messages.EditModelClient_load_error_title,  
					msg);
			
			if (!keepGoing)
				throw ex;
			
			try {
				file.delete(true, null);
				editModelClient.loadExtensionsResource();
			} catch (CoreException ce) {
				MessageDialog.openError(shell, Messages.EditModelClient_delete_error_title, Messages.EditModelClient_delete_error_message);
				throw ce;
			}
		}

		// finally load the artifacts resource (the *.wsdl file)
		try {
			editModelClient.loadArtifactsResource();
		}
		catch (RuntimeException ex) {
			file = editModelClient.getArtifactsFile();
			String msg = NLS.bind(Messages.EditModelClient_wsdl_load_error,
					new String[]{file.toString()}
			); 

			keepGoing = MessageDialog.openQuestion(
					shell, 
					Messages.EditModelClient_load_error_title,  
					msg);
			
			if (!keepGoing)
				throw ex;
			
			try {
				file.delete(true, null);
				editModelClient.loadArtifactsResource();
			} catch (CoreException ce) {
				MessageDialog.openError(shell, Messages.EditModelClient_delete_error_title, Messages.EditModelClient_delete_error_message);
				throw ce;
			}
		}
		this.fDesignViewer.setEditModelClient(editModelClient);
		getEditDomain().setCommandStack(editModelClient.getCommandStack());

		Resource bpelResource = editModelClient.getPrimaryResourceInfo().getResource();
		BPELReader reader = new BPELReader();
		reader.read(bpelResource, getFileInput(), this.fDesignViewer.getResourceSet());
		// End of patch

		this.process = reader.getProcess();
		this.bpelModelReconcileAdapter = new BPELModelReconcileAdapter (structuredDocument, this.process, bpelResource, this.fDesignViewer);

		if (getEditDomain() != null) {
			((BPELEditDomain)getEditDomain()).setProcess(getProcess());
		}
		this.extensionsResource = reader.getExtensionsResource();
		this.extensionMap = reader.getExtensionMap();

		this.modelListenerAdapter = new ModelListenerAdapter();
		this.modelListenerAdapter.setExtensionMap(this.extensionMap);

		// Bugzilla 330519
		updateMarkersHard();
	}

	public void modelDeleted(ResourceInfo resourceInfo) {
		if (!isDirty()) {
			getSite().getPage().closeEditor(this, false);
		}
	}

	public void modelDirtyStateChanged(ResourceInfo resourceInfo) {
		firePropertyChange(PROP_DIRTY);
	}

	public void modelLocationChanged(ResourceInfo resourceInfo, IFile movedToFile) {
		// TODO!
		//updateInputFile(movedToFile.getFullPath());
	}

	public void modelReloaded(ResourceInfo resourceInfo) {
		Resource bpelResource = this.fDesignViewer.getEditModelClient().getPrimaryResourceInfo().getResource();

		IFile file = getFileInput();
		BPELReader reader = new BPELReader();
		reader.read(bpelResource, file, this.fDesignViewer.getResourceSet());

		this.process = reader.getProcess();
		if (getEditDomain() != null) {
			((BPELEditDomain)getEditDomain()).setProcess(getProcess());
		}
		this.extensionMap = reader.getExtensionMap();

		this.modelListenerAdapter.setExtensionMap(this.fDesignViewer.getExtensionMap());

		this.fDesignViewer.getGraphicalViewer().setContents(getProcess());

		// The ProcessTrayEditPart tries to remove its selection listener on deactivate.
		// In this case, it will fail because the edit part can't find the editor because
		// the process no longer belongs to a resource. Help it out and remove the
		// listener manually.
		ProcessTrayEditPart processTrayEditPart = (ProcessTrayEditPart)this.fDesignViewer.getTrayViewer().getContents();
		this.fDesignViewer.getGraphicalViewer().removeSelectionChangedListener(processTrayEditPart.getSelectionChangedListener());

		this.fDesignViewer.getTrayViewer().setContents(getProcess());

		//Bugzilla 294501 - When markers are added on the BPEL file, the meta-model 
		//objects are notified about the marker change. But the display of the markers 
		//on the diagram fails because of several invalid thread access exceptions.
		//Thus, encapsulating the marker update into a separate thread
		//Note: supposedly only happens on Galileo (== Eclipse 3.5)
		Display.getDefault().asyncExec( new Runnable() {
		    public void run() {
		    	updateMarkersHard();
		    }
		});

	}

	/**
	 * Erase and reload markers for the given model object.
	 * This will create the necessary adapters so that marker
	 * notifications are delegated to the correct activity displayed
	 * in the graphical viewer.
	 * 
	 * @param modelObject
	 * @see Bugzilla 330519
	 */
	public void updateMarkers(EObject modelObject) {
		List<Long> removed = new ArrayList<Long>();
		for (Entry<Long, EObject> e : fMarkers2EObject.entrySet()){
			if (e.getValue() == modelObject)
				removed.add(e.getKey());
		}
		for (Long key : removed) {
			fMarkers2EObject.remove(key);
		}

		modelObject.eNotify(fMarkersStale);
		
		for (TreeIterator<EObject> iter=EcoreUtil.getAllContents((EObject)modelObject, true); iter.hasNext(); ){
			EObject obj = iter.next();
			BPELUtil.adapt(obj, IMarkerHolder.class);
		}

		IMarker[] markers = null;
		IFile file = getFileInput();
		Resource resource = getProcess().eResource();

		try {
			markers = file.findMarkers(null, true, IResource.DEPTH_ZERO);
		} catch (Exception ex) {
			BPELUIPlugin.log(ex);
			return;
		}

		for (IMarker m : markers) {

			String href = null;
			EObject target = null;
			try {
				href = (String) m.getAttribute( "address.model" ); //$NON-NLS-1$
				if (href == null) {
					continue;
				}
				target = resource.getEObject(href);
			} catch (Exception ex) {
				continue;
			}

			if (target == modelObject) {
				this.fMarkers2EObject.put(m.getId(), target);
				EObject obj = target;
				while (obj!=null) {
					BPELUtil.adapt(obj, IMarkerHolder.class);
					obj = obj.eContainer();
				}
				target.eNotify( new NotificationImpl (AdapterNotification.NOTIFICATION_MARKER_ADDED , null, m ));
			}
		}
		
	}

	protected void updateMarkersHard () {

		for(EObject obj : this.fMarkers2EObject.values()) {
			obj.eNotify(this.fMarkersStale);
		}

		this.fMarkers2EObject.clear();

		IMarker[] markers = null;
		IFile file = getFileInput();
		Resource resource = getProcess().eResource();

		try {
			markers = file.findMarkers(null, true, IResource.DEPTH_ZERO);
		} catch (Exception ex) {
			BPELUIPlugin.log(ex);
			return;
		}

		for (IMarker m : markers) {

			String href = null;
			EObject target = null;
			try {
				href = (String) m.getAttribute( "address.model" ); //$NON-NLS-1$
				if (href == null) {
					continue;
				}
				target = resource.getEObject(href);
			} catch (Exception ex) {
				continue;
			}
			if (target == null) {
				continue;
			}

			this.fMarkers2EObject.put(m.getId(), target);
			EObject obj = target;
			while (obj!=null) {
				BPELUtil.adapt(obj, IMarkerHolder.class);
				obj = obj.eContainer();
			}
			target.eNotify( new NotificationImpl (AdapterNotification.NOTIFICATION_MARKER_ADDED , null, m ));
		}

	}


	@Override
	protected void pageChange(int newPageIndex) {
		this.currentPage = newPageIndex;
		super.pageChange(newPageIndex);
	}


	/**
	 * Sets the EditDomain for this EditorPart.
	 * @param ed the domain
	 */
	protected void setEditDomain(DefaultEditDomain ed) {
		this.editDomain = ed;
	}

	protected void showPropertiesView() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		try {
			page.showView(IBPELUIConstants.PROPERTY_VIEW_ID);
		} catch (PartInitException e) {
			BPELUIPlugin.log(e);
		}
	}

	/**
	 * The editor part name should be the same as the one appearing in the logical view.
	 */
	protected void updateTitle() {
		setPartName(getProcess().getName());
	}

	public void modelMarkersChanged ( ResourceInfo resourceInfo , IMarkerDelta [] markerDelta ) {

		Resource resource = resourceInfo.getResource();

		for ( IMarkerDelta delta : markerDelta ) {

			String href = (String) delta.getAttribute( "address.model" ); //$NON-NLS-1$
			if (href == null) {
				continue;
			}

			EObject target = null;

			switch (delta.getKind()) {
			case IResourceDelta.ADDED :
				target = resource.getEObject(href);
				if (target != null) {
					this.fMarkers2EObject.put(delta.getId(),target);
					target.eNotify( new NotificationImpl(AdapterNotification.NOTIFICATION_MARKER_ADDED,null,delta.getMarker() ));
				}
				break;
			case IResourceDelta.CHANGED :
				target = this.fMarkers2EObject.remove(delta.getId());
				if (target != null) {
					target.eNotify( new NotificationImpl(AdapterNotification.NOTIFICATION_MARKER_CHANGED,delta.getMarker(),null));
				}
				break;
			case IResourceDelta.REMOVED :
				target = this.fMarkers2EObject.remove(delta.getId());
				if (target != null) {
					target.eNotify( new NotificationImpl(AdapterNotification.NOTIFICATION_MARKER_DELETED,delta.getMarker(),null));
				}
				break;
			}

		}
	}

	@Override
	public boolean isDirty() {
		return this.fTextEditor.isDirty() || this.editDomain.getCommandStack().isDirty();
	}

	@Override
	public IEditorPart getActiveEditor() {
		return super.getActiveEditor();
	}
	
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-6365
	// TODO: this is just a quick hack to get past the problem of import files being moved/renamed.
	// The proper way to do this is to implement the eclipse refactoring framework for bpel files.
	public class RefactoringListener implements IResourceChangeListener {

		public void resourceChanged(IResourceChangeEvent event) {
			
			IResourceDeltaVisitor dv = new IResourceDeltaVisitor() {

				public boolean visit(IResourceDelta delta) throws CoreException {
					IPath newPath = delta.getMovedToPath();
					if (delta.getKind()==IResourceDelta.REMOVED && newPath!=null) {
						// a file was moved or renamed - check if it's an imported file
						List<Import> imports = process.getImports();
						for (Import imp : imports)
						{
							IPath path = new Path(imp.getLocation());
							IPath folder = ((IFileEditorInput)getEditorInput()).getFile().getFullPath().removeLastSegments(1);
							if (!path.isAbsolute()) {
								// need absolute path
								path = folder.append(path);
							}
							if (path.equals(delta.getResource().getFullPath())) {
								IPath relPath = newPath.makeRelativeTo(folder);
								imp.setLocation(relPath.toString());

								Display.getDefault().asyncExec( new Runnable() {
								    public void run() {
										doSave(null);
								    }
								});
							}
						}
					}
					return true;
				}
			};
			
			try {
				event.getDelta().accept(dv);
			} catch (CoreException e) {
				BPELUIPlugin.log(e);
			}
		}
	
	}
}
