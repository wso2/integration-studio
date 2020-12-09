package org.wso2.developerstudio.eclipse.ds.presentation.md;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl;
import org.wso2.developerstudio.eclipse.ds.presentation.DsActionBarContributor;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;

public class OutlineBlock extends MasterDetailsBlock {

	public static boolean isEditAction;
	private ComposedAdapterFactory adapterFactory;
	private EditingDomain domain;
	private IDetailsPageProvider dsDetailsPageProvider;
	private DsEditor dseditor;
	private ScrolledForm scrolledForm;
	private TreeViewer viewer;
	private ISelection currentSelection;

	public OutlineBlock(DsEditor editor, ComposedAdapterFactory adapterFactory, EditingDomain domain) {
		this.adapterFactory = adapterFactory;
		this.domain = domain;
		this.dseditor = editor;
		dsDetailsPageProvider = new DetailPageProvider(dseditor);
	}

	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		scrolledForm = managedForm.getForm();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText("Data Service Outline");
		section.marginWidth = 10;
		section.marginHeight = 5;
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		Tree tr = null;
		tr = toolkit.createTree(client, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 20;
		gd.widthHint = 100;
		tr.setLayoutData(gd);
		toolkit.paintBordersFor(client);

		section.setClient(client);

		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);

		viewer = new TreeViewer(tr);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {

				currentSelection = event.getSelection();

				DsActionBarContributor dscbc =
				                               (DsActionBarContributor) dseditor.getActionBarContributor();
				dscbc.selectionChanged(event);

				managedForm.fireSelectionChanged(spart, event.getSelection());

			}
		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				try {
					dseditor.getEditorSite().getPage()
					        .showView("org.eclipse.ui.views.PropertySheet");
				} catch (PartInitException ex) {
					ex.printStackTrace();
				}
			}
		});
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		// make sure that the workbench selection service knows about the object
		// selected in tree viewer.
		dseditor.getSite().setSelectionProvider(viewer);

		if (domain != null) {
			if (domain.getResourceSet() != null) {
				if (domain.getResourceSet().getResources() != null &&
				    domain.getResourceSet().getResources().size() != 0) {
					if (domain.getResourceSet().getResources().get(0) != null) {
						Resource resource =
						                    (Resource) domain.getResourceSet().getResources()
						                                     .get(0);
						Boolean hasNodes = checkResourceAvilability(resource);
						if (hasNodes == false) {

							toolkit.decorateFormHeading(scrolledForm.getForm());
							scrolledForm.getForm()
							            .setMessage("No data available in the .dbs file to populate the Modle Tree",
							                        IMessageProvider.ERROR);
						}
						if (resource.getContents() != null && resource.getContents().size() != 0) {
							if (resource.getContents().get(0) != null) {
								DocumentRootImpl root =
								                        (DocumentRootImpl) resource.getContents()
								                                                   .get(0);
								viewer.setInput(root);
								viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
								viewer.setSelection(new StructuredSelection(root), true);
							}

						} else {
							scrolledForm.getForm()
							            .setMessage("No data available in the .dbs file to populate the Modle Tree",
							                        IMessageProvider.ERROR);
						}
						dseditor.createContextMenuFor(viewer);
					} else {
						toolkit.decorateFormHeading(scrolledForm.getForm());
						scrolledForm.getForm()
						            .setMessage("No data available in the .dbs file to populate the Modle Tree",
						                        IMessageProvider.ERROR);
					}
				} else {
					toolkit.decorateFormHeading(scrolledForm.getForm());
					scrolledForm.getForm()
					            .setMessage("No data available in the .dbs file to populate the Modle Tree",
					                        IMessageProvider.ERROR);
				}
			} else {
				toolkit.decorateFormHeading(scrolledForm.getForm());
				scrolledForm.getForm()
				            .setMessage("No data available in the .dbs file to populate the Modle Tree",
				                        IMessageProvider.ERROR);
			}
		} else {
			toolkit.decorateFormHeading(scrolledForm.getForm());
			scrolledForm.getForm()
			            .setMessage("No data available in the .dbs file to populate the Modle Tree",
			                        IMessageProvider.ERROR);
		}

	}

	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		Action haction = new Action("Horizontal", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal");
		Action vaction = new Action("Vertical", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("vertical");
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}

	protected void registerPages(DetailsPart detailsPart) {

		// Register the DetailPage provider for OutlineBlock

		detailsPart.setPageProvider(dsDetailsPageProvider);

	}

	private Boolean checkResourceAvilability(Resource resource) {
		TreeIterator<EObject> tre = resource.getAllContents();
		Boolean hasNodes = tre.hasNext();
		return hasNodes;
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	public ISelection getCurrentSelection() {
		return currentSelection;
	}

	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;

		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = new Runnable() {
				public void run() {
					// Try to select the item in the current content viewer of
					// the editor.
					//
					if (viewer != null && !isEditAction) {

						Object selectedObject = null;

						Object[] arr = theSelection.toArray();

						if (arr.length >= 1 && arr[0] != null) {

							// get the current viewer selection
							IStructuredSelection ssel =
							                            (IStructuredSelection) viewer.getSelection();

							if (ssel != null && ssel.size() == 1) {

								selectedObject = (EObjectImpl) ssel.getFirstElement();
							}
							// check whether newly selected object already
							// selected.
							if (selectedObject != null && !selectedObject.equals(arr[0])) {

								viewer.setSelection(new StructuredSelection(arr[0]));
							}
						}
					} else {

						isEditAction = false;
					}
				}
			};
			dseditor.getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

}
