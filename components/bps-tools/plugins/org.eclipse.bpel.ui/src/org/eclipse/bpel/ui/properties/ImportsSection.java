/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import java.util.List;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddImportCommand;
import org.eclipse.bpel.ui.commands.RemoveImportCommand;
import org.eclipse.bpel.ui.details.providers.ColumnTableProvider;
import org.eclipse.bpel.ui.details.providers.ImportContentProvider;
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

/**
 * Edits the import statements of the BPEL file.
 */
public class ImportsSection extends BPELPropertySection {

	protected Composite parentComposite;

	protected Composite activityComposite;

	protected Label importLabel;

	protected Table importTable;

	protected TableViewer importViewer;

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
				importViewer.setInput(getInput());
			}
		}, };
	}

	protected void createImportWidgets(Composite parent) {

		FlatFormData data;

		Button browseWSDL = fWidgetFactory.createButton(parent,
				Messages.ImportsSection_0, SWT.PUSH);
		Button browseXSD = fWidgetFactory.createButton(parent,
				Messages.ImportsSection_1, SWT.PUSH);
		final Button removeImport = fWidgetFactory.createButton(parent,
				Messages.ImportsSection_2, SWT.PUSH);
		removeImport.setEnabled(false);

		removeImport.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				removeImport();
			}
		});

		browseWSDL.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				browseAndImportWSDL();
			}
		});

		browseXSD.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				browseAndImportXSD();
			}

		});

		data = new FlatFormData();
		data.right = new FlatFormAttachment(100, -5
				* IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		removeImport.setLayoutData(data);

		data = new FlatFormData();
		data.right = new FlatFormAttachment(removeImport,
				-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		browseXSD.setLayoutData(data);

		data = new FlatFormData();
		data.right = new FlatFormAttachment(browseXSD,
				-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		browseWSDL.setLayoutData(data);

		importLabel = fWidgetFactory.createLabel(parent,
				Messages.ImportDetails_Imports_20);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(browseWSDL,
				IDetailsAreaConstants.VSPACE);
		importLabel.setLayoutData(data);

		// create table
		importTable = fWidgetFactory.createTable(parent, SWT.FULL_SELECTION | SWT.V_SCROLL
				| SWT.READ_ONLY);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(100, -5
				* IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(importLabel,
				IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, -IDetailsAreaConstants.HSPACE);
		importTable.setLayoutData(data);

		// set up table
		importTable.setLinesVisible(true);
		importTable.setHeaderVisible(true);
		
		tableProvider = new ColumnTableProvider();
		tableProvider.add(new LocationColumn());
		tableProvider.add(new NamespaceColumn());
		tableProvider.add(new ImportTypeColumn());

		importViewer = new TableViewer(importTable);
		tableProvider.createTableLayout(importTable);
		importViewer.setLabelProvider(tableProvider);
		importViewer.setCellModifier(tableProvider);
		importViewer.setContentProvider(new ImportContentProvider());
		importViewer.setColumnProperties(tableProvider.getColumnProperties());
		importViewer.setCellEditors(tableProvider
				.createCellEditors(importTable));

		importViewer
				.addPostSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						removeImport
								.setEnabled(!event.getSelection().isEmpty());
					}
				});

		tableCursor = BPELUtil.createTableCursor(importTable, importViewer);
	}

	public class NamespaceColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		@Override
		public String getHeaderText() {
			return Messages.ImportDetails_Import_Namespace_12;
		}

		@Override
		public String getProperty() {
			return "Namespace"; //$NON-NLS-1$
		} 

		@Override
		public int getInitialWeight() {
			return 30;
		}

		public String getText(Object element) {
			String s = ((Import) element).getNamespace();
			return (s == null) ? "" : NamespaceUtils.convertUriToNamespace(s); //$NON-NLS-1$
		}
	}

	public class LocationColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		@Override
		public String getHeaderText() {
			return Messages.ImportDetails_Import_Location_12;
		}

		@Override
		public String getProperty() {
			return "Location"; //$NON-NLS-1$
		}

		@Override
		public int getInitialWeight() {
			return 30;
		}

		public String getText(Object element) {
			String s = ((Import) element).getLocation();
			return (s == null) ? "" : s; //$NON-NLS-1$			
		}
	}

	public class ImportTypeColumn extends ColumnTableProvider.Column implements
			ILabelProvider {
		@Override
		public String getHeaderText() {
			return Messages.ImportsSection_3;
		}

		@Override
		public String getProperty() {
			return "ImportType"; //$NON-NLS-1$
		}

		@Override
		public int getInitialWeight() {
			return 30;
		}

		public String getText(Object element) {
			String s = ((Import) element).getImportType();
			return (s == null) ? "" : s; //$NON-NLS-1$			
		}
	}
	
	

	@Override
	protected void basicSetInput(EObject newInput) {		
		super.basicSetInput(newInput);
		
		if (getInput() != null) {
			importViewer.setInput(getInput());
		}
	}
	

	@Override
	protected void createClient(Composite parent) {
		Composite composite = parentComposite = createFlatFormComposite(parent);

		createImportWidgets(composite);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite, IHelpContextIds.PROPERTY_PAGE_IMPORTS);
	}

	@Override
	public Object getUserContext() {
		return ((StructuredSelection) importViewer.getSelection())
				.getFirstElement();
	}

	@Override
	public void restoreUserContext(Object userContext) {
		importTable.setFocus();
		if (userContext != null) {
			importViewer.setSelection(new StructuredSelection(userContext));
		}
	}

	void removeImport () {
		
		ISelection selection = importViewer.getSelection();
		if (selection.isEmpty()) {
			return ;
		}
		IStructuredSelection ssel = null;
		if ( (selection instanceof IStructuredSelection) == false) {
			return;
		}
		
		ssel = (IStructuredSelection) selection;		
		Object obj = ssel.getFirstElement();
		
		RemoveImportCommand cmd = new RemoveImportCommand ( 
				BPELUtils.getProcess( getInput() ), 
				obj,
				IBPELUIConstants.CMD_REMOVE_IMPORT);
		
		if (cmd.canDoExecute()) {
			getCommandFramework().execute( cmd );
		}
	}
	
	void browseAndImportWSDL() {

		SchemaImportDialog dialog = new SchemaImportDialog(importLabel
				.getShell(), getInput());
		dialog.configureAsWSDLImport();
		if (dialog.open() != Window.OK) {
			return;
		}
		Object result[] = dialog.getResult();
		if (result.length < 1) {
			return;
		}

		AddImportCommand cmd = new AddImportCommand(BPELUtils
				.getProcess(getInput()), result[0]);
		if (cmd.canDoExecute() && cmd.wouldCreateDuplicateImport() == false) {
			getCommandFramework().execute(cmd);
		}
	}

	void browseAndImportXSD() {

		SchemaImportDialog dialog = new SchemaImportDialog(importLabel
				.getShell(), getInput());
		if (dialog.open() != Window.OK) {
			return;
		}

		Object result[] = dialog.getResult();
		if (result.length < 1) {
			return;
		}

		AddImportCommand cmd = new AddImportCommand(BPELUtils
				.getProcess(getInput()), result[0]);
		if (cmd.canDoExecute() && cmd.wouldCreateDuplicateImport() == false) {
			getCommandFramework().execute(cmd);
		}
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
