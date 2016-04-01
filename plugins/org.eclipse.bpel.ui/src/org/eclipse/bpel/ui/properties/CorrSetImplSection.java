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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.*;
import org.eclipse.bpel.ui.commands.AddPropertyCommand;
import org.eclipse.bpel.ui.commands.RemovePropertyCommand;
import org.eclipse.bpel.ui.commands.ReplacePropertyCommand;
import org.eclipse.bpel.ui.details.providers.ColumnTableProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.PropertyContentProvider;
import org.eclipse.bpel.ui.details.providers.UnusedPropertyFilter;
import org.eclipse.bpel.ui.dialogs.EditMessagePropertyDialog;
import org.eclipse.bpel.ui.dialogs.PropertySelectorDialog;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProvider;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;


/**
 * Details section to select which properties are part of a CorrelationSet. 
 */
public class CorrSetImplSection extends BPELPropertySection  {

	protected Table propertyTable;
	protected TableViewer propertyViewer;
	protected ColumnTableProvider tableProvider;

	protected Button addButton;
	protected Button editButton;
	protected Button removeButton;
	
	public class NameColumn extends ColumnTableProvider.Column implements ILabelProvider, ICellModifier {
		@Override
		public String getHeaderText() { return Messages.CorrSetImplDetails_Property_1; } 
		@Override
		public String getProperty() { return "propertyName"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 100; }

//		ComboViewerCellEditor cellEditor;
		ModelLabelProvider labelProvider = new ModelLabelProvider();
		UnusedPropertyFilter propertyFilter = new UnusedPropertyFilter();

		@Override
		public CellEditor createCellEditor(Composite parent) {
//			cellEditor = new ComboViewerCellEditor(parent);
//			CComboViewer viewer = cellEditor.getViewer();
//			viewer.addFilter(propertyFilter);
//			viewer.setContentProvider(new PropertyContentProvider());
//			viewer.setLabelProvider(labelProvider);
//			viewer.setInput(getProcess());
//			return cellEditor;
			return null;
		}
		public String getText(Object element) {
			return labelProvider.getText(element);
		}
		public boolean canModify(Object element, String property) {
			// HACK: this method is called before activation of the cell editor
			// Update the UnusedPropertyFilter with the proper contents.
			propertyFilter.setCandidates(((CorrelationSet)getInput()).getProperties(),
				Collections.singletonList(element));

			// Bug290346 - change true to false by Grid.Qian
			// because the cell editor is null, if the column can be modified,
			// when the system will active the cell editor, will get a null exception
			return false;
		}
		public Object getValue(Object element, String property) {
			return element;
		}
		public void modify(Object element, String property, Object value) {
			Command cmd = new ReplacePropertyCommand((CorrelationSet)getInput(),
				(Property)element, (Property)value);
			getCommandFramework().execute(wrapInShowContextCommand(cmd));
		}
	}

	@Override
	public boolean shouldUseExtraSpace() { return true; }

	protected boolean isPropertyListAffected(Notification n) {
		return (n.getFeatureID(CorrelationSet.class) == BPELPackage.CORRELATION_SET__PROPERTIES);
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {
					if (isPropertyListAffected(n)) {
						updatePropertyWidgets(null);
						refreshAdapters();
					}
				}
			},
			/* property(s) */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {
					if (n.getNotifier() instanceof Property) {
						updatePropertyWidgets((Property)n.getNotifier());
						refreshAdapters();
					}
				}
			}
		};
	}

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		List<Property> corrList = ((CorrelationSet)getInput()).getProperties();
		for (Iterator<Property> it = corrList.iterator(); it.hasNext(); ) {
			Property property = (Property)it.next();
			fAdapters[1].addToObject(property);
		}
	}

	protected void createPropertyWidgets(Composite composite)  {
		FlatFormData data;

		Label correlationSetLabel = fWidgetFactory.createLabel(composite, Messages.CorrSetImplDetails_Properties__5); 
		propertyTable = fWidgetFactory.createTable(composite, SWT.FULL_SELECTION | SWT.V_SCROLL);
		addButton = fWidgetFactory.createButton(composite, Messages.CorrSetImplDetails_Browse____6, SWT.PUSH); 
		editButton = fWidgetFactory.createButton(composite, Messages.CorrSetImplDetails_Edit____7, SWT.PUSH); 
		removeButton = fWidgetFactory.createButton(composite, Messages.CorrSetImplDetails_Remove_4, SWT.PUSH); 

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		correlationSetLabel.setLayoutData(data);

		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(addButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(editButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		addButton.setLayoutData(data);

		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(editButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(removeButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		editButton.setLayoutData(data);
		editButton.setEnabled(false);	
		
		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(removeButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		removeButton.setLayoutData(data);
		removeButton.setEnabled(false);
		
		addButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				PropertySelectorDialog dialog = new PropertySelectorDialog(getPart().getSite().getShell(), (CorrelationSet)getInput(), fWidgetFactory);
				if (dialog.open() == Window.OK) {
					Property property = dialog.getProperty();
					if (property != null) {
						Command cmd = new AddPropertyCommand((CorrelationSet) getInput(), property);
						getCommandFramework().execute(wrapInShowContextCommand(cmd));
						propertyViewer.setSelection(new StructuredSelection(property));
					}
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});

		editButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection)propertyViewer.getSelection();
				Property property = (Property) sel.getFirstElement();
				if (property != null)  {
					BPELEditor bpelEditor = getBPELEditor();
					Shell shell = bpelEditor.getEditorSite().getShell();
					EditMessagePropertyDialog dialog = new EditMessagePropertyDialog(shell, property, null, bpelEditor, fWidgetFactory);
					int rtn = dialog.open(); 
					if (rtn == Window.OK) {
				        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
						// https://jira.jboss.org/browse/JBIDE-7107
						// this fixes a nasty bug caused by manual editing of the ProcessArtifacts.wsdl
						if (property != null && dialog.getProperty()!=null) {
							if (property.eIsProxy()) {
								// the Propery is not resolved (it was probably removed from the WSDL)
								// remove the old Property before adding the newly created one.
								Command cmd = new RemovePropertyCommand((CorrelationSet)getInput(), property);
								getCommandFramework().execute(wrapInShowContextCommand(cmd));
								property = dialog.getProperty();
							}
							Command cmd = new AddPropertyCommand((CorrelationSet)getInput(), property);
							getCommandFramework().execute(wrapInShowContextCommand(cmd));
							propertyViewer.setSelection(new StructuredSelection(property));
						}
					}
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});

		Listener removeListener = new Listener() {
			public void handleEvent(Event e) {
				if (e.type == SWT.KeyUp && e.character != SWT.DEL)  return;
				IStructuredSelection sel = (IStructuredSelection)propertyViewer.getSelection();
				Property property = (Property)sel.getFirstElement();
				int selectionIndex = propertyTable.getSelectionIndex();
				if (property != null)  {
					Command cmd = new RemovePropertyCommand((CorrelationSet)getInput(), property);
					getCommandFramework().execute(wrapInShowContextCommand(cmd));
				}
				// selects the element at the deleted element position
				int items = propertyTable.getItemCount();
				if (items > 0) {
					selectionIndex = (selectionIndex < items) ? selectionIndex : items-1;
					propertyTable.setSelection(selectionIndex);
				}
				updateButtonEnablement();
			}
		};
		removeButton.addListener(SWT.Selection, removeListener);
		removeButton.addListener(SWT.DefaultSelection, removeListener);

		propertyTable.addListener(SWT.KeyUp, removeListener);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(addButton, IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, 0);
		propertyTable.setLayoutData(data);

		propertyTable.setLinesVisible(true);
		propertyTable.setHeaderVisible(true);

		tableProvider = new ColumnTableProvider();
		tableProvider.add(new NameColumn());
	
		propertyViewer = new TableViewer(propertyTable);
		tableProvider.createTableLayout(propertyTable);
		propertyViewer.setLabelProvider(tableProvider);
		propertyViewer.setCellModifier(tableProvider);
		propertyViewer.setContentProvider(new PropertyContentProvider());
		// TODO: should this have a sorter?
		propertyViewer.setColumnProperties(tableProvider.getColumnProperties());
		propertyViewer.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtonEnablement();
			}
		});
//		propertyViewer.setCellEditors(tableProvider.createCellEditors(propertyTable));
	}
	
	@Override
	protected void createClient(Composite parent)  {
		Composite composite = createFlatFormComposite(parent);

		createPropertyWidgets(composite);
		
    PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.PROPERTY_PAGE_CORRELATION_SET);
	}

	protected void updateButtonEnablement(){
		boolean hasSelection = !propertyViewer.getSelection().isEmpty();
		removeButton.setEnabled(hasSelection);
		editButton.setEnabled(hasSelection);
	}
	
	protected void updatePropertyWidgets(final Property property) {
		Object input = getInput();
		if (input == null)  throw new IllegalStateException();
		
		propertyViewer.setInput(getInput());
        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7351
		propertyViewer.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (property != null) {
					propertyViewer.refresh(property, true);
				} else {
					propertyViewer.refresh();
				}
			}
		});
	}
	
	@Override
	public void refresh() {
		super.refresh();
		updatePropertyWidgets(null);
	}

	@Override
	public Object getUserContext() {
		return ((StructuredSelection)propertyViewer.getSelection()).getFirstElement();
	}
	@Override
	public void restoreUserContext(Object userContext) {
		propertyTable.setFocus();
		if (userContext != null) {
			propertyViewer.setSelection(new StructuredSelection(userContext));
		}
	}	
}
