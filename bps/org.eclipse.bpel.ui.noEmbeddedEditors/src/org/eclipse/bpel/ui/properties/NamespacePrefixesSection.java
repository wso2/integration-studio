/*
 * Copyright (c) 2010, 2012 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.ui.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddImportCommand;
import org.eclipse.bpel.ui.commands.RemoveImportCommand;
import org.eclipse.bpel.ui.details.providers.ColumnTableProvider;
import org.eclipse.bpel.ui.dialogs.NamespaceMappingDialog;
import org.eclipse.bpel.ui.dialogs.SchemaImportDialog;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.NamespaceUtils;
import org.eclipse.bpel.ui.util.TableCursor;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.wsdl.internal.impl.ImportImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * The Namespaces Property Tab contains a table of namespaces in scope for the currently
 * selected BPEL activity or the process. The table has the following columns:
 *
 * Prefix - the namespace prefix. This could be empty if the namespace was defined in
 *          an imported artifact (WSDL or XSD)
 * Namespace - the namespace definition
 * Context - the Activity or Process in which the namespace prefix was defined
 * Location - the resource artifact that defines the namespace
 *
 * A button with the label "Assign Prefix" will be enabled if the current selection in
 * the able has no namespace prefix. This will allow the user to assign a prefix.
 *
 * @see https://jira.jboss.org/browse/JBIDE-6765
 * @author Bob Brodt
 * @date Aug 13, 2010
 */
public class NamespacePrefixesSection extends BPELPropertySection {

	protected Composite parentComposite;

	protected Composite activityComposite;

	protected Label tabLabel;

	protected Table prefixesTable;

	protected TableViewer prefixesViewer;

	protected ColumnTableProvider tableProvider;

	protected TableCursor tableCursor = null;

	/**
	 * Make this section use all the vertical space it can get.
	 * 
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	/**
	 * Bug 290085 - Override the super-class because the input is Process not Import
	 * If use super-class's directly, when change the import attributes
	 * the properties section do not change. Grid Qian
	 */
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		if (fAdapters.length > 0) {
			if (getModel() != null) {
				EObject obj = getModel();
				if (obj instanceof Process) {
					List<Import> list = ((Process) obj).getImports();
					for (int i = 0; i < list.size(); i++) {
						fAdapters[0].addToObject((Import) list.get(i));
					}
				}
			}
		}
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] { new MultiObjectAdapter() {
			@Override
			public void notify(Notification n) {
				prefixesViewer.setInput(getInput());
			}
		}, };
	}

	protected void createWidgets(Composite parent) {

		FlatFormData data;

		final Button assignPrefixButton = fWidgetFactory.createButton(parent,
				Messages.NamespacePrefixesSection_4, SWT.PUSH);
		assignPrefixButton.setEnabled(false);

		assignPrefixButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				assignPrefix();
			}
		});

		data = new FlatFormData();
		data.right = new FlatFormAttachment(100, -5
				* IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		assignPrefixButton.setLayoutData(data);

		tabLabel = fWidgetFactory.createLabel(parent,
				Messages.NamespacePrefixesSection);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(assignPrefixButton,
				IDetailsAreaConstants.VSPACE);
		tabLabel.setLayoutData(data);

		// create table
		prefixesTable = fWidgetFactory.createTable(parent, SWT.FULL_SELECTION | SWT.V_SCROLL
				| SWT.READ_ONLY);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(100, -5
				* IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(tabLabel,
				IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, -IDetailsAreaConstants.HSPACE);
		prefixesTable.setLayoutData(data);

		// set up table
		prefixesTable.setLinesVisible(true);
		prefixesTable.setHeaderVisible(true);
		
		tableProvider = new ColumnTableProvider();
		tableProvider.add(new PrefixColumn());
		tableProvider.add(new NamespaceColumn());
		tableProvider.add(new ContextColumn());
		tableProvider.add(new LocationColumn());

		prefixesViewer = new TableViewer(prefixesTable);
		tableProvider.createTableLayout(prefixesTable);
		prefixesViewer.setLabelProvider(tableProvider);
		prefixesViewer.setCellModifier(tableProvider);
		prefixesViewer.setContentProvider(new NamespacePrefixesProvider());
		prefixesViewer.setColumnProperties(tableProvider.getColumnProperties());
		prefixesViewer.setCellEditors(tableProvider.createCellEditors(prefixesTable));

		prefixesViewer
				.addPostSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						if (event.getSelection() instanceof StructuredSelection)
						{
							StructuredSelection sel = (StructuredSelection)event.getSelection();
							NamespacePrefixElement elem = (NamespacePrefixElement)sel.getFirstElement();
							if (elem!=null && (elem.prefix==null || elem.prefix.length()==0))
								assignPrefixButton.setEnabled(true);
							else
								assignPrefixButton.setEnabled(false);
						}
					}
				});

		tableCursor = BPELUtil.createTableCursor(prefixesTable, prefixesViewer);
	}

	public class PrefixColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		
		@Override
		public String getHeaderText() {
			return Messages.NamespacePrefixesSection_0;
		}

		@Override
		public String getProperty() {
			return "NamespacePrefix"; //$NON-NLS-1$
		}

		@Override
		public int getInitialWeight() {
			return 10;
		}

		public String getText(Object element) {
			
			String s = ((NamespacePrefixElement)element).prefix;
			return (s == null) ? "" : s; //$NON-NLS-1$			
		}
	}
	
	public class NamespaceColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		@Override
		public String getHeaderText() {
			return Messages.NamespacePrefixesSection_1;
		}

		@Override
		public String getProperty() {
			return "Namespace"; //$NON-NLS-1$
		} 

		@Override
		public int getInitialWeight() {
			return 40;
		}

		public String getText(Object element) {

			String s = ((NamespacePrefixElement)element).namespace;
			return (s == null) ? "" : s; //$NON-NLS-1$			
		}
	}

	public class ContextColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		
		@Override
		public String getHeaderText() {
			return Messages.NamespacePrefixesSection_2;
		}

		@Override
		public String getProperty() {
			return "Context"; //$NON-NLS-1$
		}

		@Override
		public int getInitialWeight() {
			return 10;
		}

		public String getText(Object element) {
			
			String s = null;
			EObject obj = ((NamespacePrefixElement)element).context;
			if (obj instanceof Process)
				s = "Process " + ((Process)obj).getName();
			else if (obj instanceof Activity)
				s = "Activity " + ((Activity)obj).getName();
			return (s == null) ? "" : s; //$NON-NLS-1$			
		}
	}

	public class LocationColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		@Override
		public String getHeaderText() {
			return Messages.NamespacePrefixesSection_3;
		}

		@Override
		public String getProperty() {
			return "Location"; //$NON-NLS-1$
		}

		@Override
		public int getInitialWeight() {
			return 40;
		}

		public String getText(Object element) {
			
			String s = ((NamespacePrefixElement)element).location;
			return (s == null) ? "" : s; //$NON-NLS-1$			
		}
	}

	

	@Override
	protected void basicSetInput(EObject newInput) {		
		super.basicSetInput(newInput);
		
		if (getInput() != null) {
			prefixesViewer.setInput(getInput());
		}
	}
	

	@Override
	protected void createClient(Composite parent) {
		Composite composite = parentComposite = createFlatFormComposite(parent);

		createWidgets(composite);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite,
				IHelpContextIds.PROPERTY_PAGE_NAMESPACE_PREFIXES);
	}

	@Override
	public Object getUserContext() {
		return ((StructuredSelection) prefixesViewer.getSelection())
				.getFirstElement();
	}

	@Override
	public void restoreUserContext(Object userContext) {
		prefixesTable.setFocus();
		if (userContext != null) {
			prefixesViewer.setSelection(new StructuredSelection(userContext));
		}
	}

	void assignPrefix () {
		
		ISelection selection = prefixesViewer.getSelection();
		if (selection.isEmpty()) {
			return ;
		}
		IStructuredSelection ssel = null;
		if ( (selection instanceof IStructuredSelection) == false) {
			return;
		}
		
		ssel = (IStructuredSelection) selection;		
		NamespacePrefixElement elem = (NamespacePrefixElement)ssel.getFirstElement();
		
		EObject modelObject = elem.context;
		if (modelObject==null)
			modelObject = this.fModelObject;
		
		// We have to map the namespace to a prefix. 
		NamespaceMappingDialog dialog = new NamespaceMappingDialog(tabLabel.getShell(),modelObject);
		dialog.setNamespace( elem.namespace );
		
		if (dialog.open() == Window.CANCEL) {
			return;
		}
		
		// define the prefix
		BPELUtils.setPrefix( modelObject, elem.namespace, dialog.getPrefix());
		elem.prefix = dialog.getPrefix();
		elem.context = modelObject;
		
		prefixesViewer.refresh();
	}

	
	
	@Override
	public void gotoMarker(IMarker marker) {
		// TODO Auto-generated method stub
		super.gotoMarker(marker);
	}
	
	/**
	 * 
	 */
	

	@Override
	public boolean isValidMarker(IMarker marker) {
		return super.isValidMarker(marker);
	}

	
	
}
