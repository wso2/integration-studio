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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.viewers.CComboViewer;
import org.eclipse.bpel.common.ui.details.viewers.ComboViewerCellEditor;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddCorrelationCommand;
import org.eclipse.bpel.ui.commands.RemoveCorrelationCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.commands.SetCorrelationInitiateCommand;
import org.eclipse.bpel.ui.commands.SetCorrelationSetRefCommand;
import org.eclipse.bpel.ui.details.providers.AbstractContentProvider;
import org.eclipse.bpel.ui.details.providers.AddNullFilter;
import org.eclipse.bpel.ui.details.providers.ColumnTableProvider;
import org.eclipse.bpel.ui.details.providers.CorrelationContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.ModelViewerSorter;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.TableCursor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the incoming/outgoing correlation sets used by an
 * Invoke/Receive/Reply activity.
 */
public class CorrelationSection extends BPELPropertySection {
	
	public static final String YES = "yes"; //$NON-NLS-1$
	public static final String NO = "no"; //$NON-NLS-1$
	public static final String JOIN = "join"; //$NON-NLS-1$
	
	protected Table correlationTable;
	protected TableViewer correlationViewer;
	protected ColumnTableProvider tableProvider;
	protected TableCursor tableCursor = null;

	protected Button addButton;
	protected Button removeButton;
	
	protected boolean allowOutgoing;
	protected boolean allowIncoming;

	public class DirectionColumn extends ColumnTableProvider.Column implements ILabelProvider, ICellModifier {
		@Override
		public String getHeaderText() { return Messages.CorrelationDetails_Direction_1; } 
		@Override
		public String getProperty() { return "direction"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 15; }

		// TODO: convert DirectionColumn to use images instead of text?
		
		protected final String[] oneWayStrings = { Messages.CorrelationDetails_Send_5, Messages.CorrelationDetails_Receive_4 }; 
		protected final String[] twoWayStrings = { Messages.CorrelationDetails_Send_5, Messages.CorrelationDetails_Receive_6, Messages.CorrelationDetails_Both_7 }; 

		@Override
		public CellEditor createCellEditor(Composite parent) {
			return new ComboBoxCellEditor(parent, twoWayStrings);
		}
		protected int patternIndex(CorrelationPattern pattern) {
			if (pattern == CorrelationPattern.RESPONSE_LITERAL)  return 0;
			if (pattern == CorrelationPattern.REQUEST_LITERAL)  return 1;
			if (pattern == CorrelationPattern.REQUESTRESPONSE_LITERAL)  return 2;
			return allowOutgoing? 0 : 1;
		}
		protected CorrelationPattern indexPattern(int index) {
			switch (index) {
			case 0: return CorrelationPattern.RESPONSE_LITERAL;
			case 1: return CorrelationPattern.REQUEST_LITERAL;
			case 2: return CorrelationPattern.REQUESTRESPONSE_LITERAL;
			}
			throw new IllegalArgumentException();
		}
		@Override
		public Image getImage(Object element) {
			return null;
		}
		public String getText(Object element) {
			if (allowOutgoing && allowIncoming) {
				return twoWayStrings[patternIndex(((Correlation)element).getPattern())]; 
			}
			return oneWayStrings[allowOutgoing? 0 : 1];
		}
		public boolean canModify(Object element, String property) {
			return allowOutgoing && allowIncoming;
		}
		public Object getValue(Object element, String property) {
			return Integer.valueOf( patternIndex(((Correlation)element).getPattern()));
		}
		public void modify(Object element, String property, Object value) {
			int index = ((Integer)value).intValue();
			CorrelationPattern pattern = indexPattern(index);
			Command cmd = new SetCommand((EObject)element, pattern, BPELPackage.eINSTANCE.getCorrelation_Pattern());
			getCommandFramework().execute(wrapInShowContextCommand(cmd));
		}
	}

	public class InitiationColumn extends ColumnTableProvider.Column implements ILabelProvider, ICellModifier {
		@Override
		public String getHeaderText() { return Messages.CorrelationDetails_Initiation_8; } 
		@Override
		public String getProperty() { return "initiation"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 10; }

		protected final String[] strings = {
			Messages.CorrelationDetails_No_10, 
			Messages.CorrelationDetails_Yes_11, 
			Messages.CorrelationDetails_Join_11
		};
		
		@Override
		public CellEditor createCellEditor(Composite parent) {
			ComboBoxCellEditor result = new ComboBoxCellEditor();
			result.setStyle(SWT.READ_ONLY);
			result.create(parent);
			result.setItems(strings);
			return result;
		}
		protected int initiationIndex(String initiation) {
			if (YES.equals(initiation))
				return 1;
			if (JOIN.equals(initiation))
				return 2;
			return 0;
		}
		public String getText(Object element) {
			return strings[initiationIndex(((Correlation)element).getInitiate())]; 
		}
		public boolean canModify(Object element, String property) {
			return true;
		}
		public Object getValue(Object element, String property) {
			return Integer.valueOf( initiationIndex(((Correlation)element).getInitiate()));
		}
		public void modify(Object element, String property, Object value) {
			int index = ((Integer)value).intValue();
			String initiation = NO;
			switch (index) {
				case 0:
					initiation = NO;
					break;
				case 1:
					initiation = YES;
					break;
				case 2:
					initiation = JOIN;
					break;
			}
			Command cmd = new SetCorrelationInitiateCommand((Correlation)element, initiation);
			getCommandFramework().execute(wrapInShowContextCommand(cmd));
		}
	}

	public class NameColumn extends ColumnTableProvider.Column implements ILabelProvider, ICellModifier {
		@Override
		public String getHeaderText() { return Messages.CorrelationDetails_Correlation_Set_12; } 
		@Override
		public String getProperty() { return "setName"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 30; }

		ComboViewerCellEditor cellEditor;
		ModelLabelProvider labelProvider;

		@Override
		public CellEditor createCellEditor(Composite parent) {
			cellEditor = new ComboViewerCellEditor();
			cellEditor.setStyle(SWT.READ_ONLY);
			cellEditor.create(parent);
			labelProvider = new ModelLabelProvider();
			CComboViewer viewer = cellEditor.getViewer();
			viewer.addFilter(AddNullFilter.getInstance());
			viewer.setContentProvider(new AbstractContentProvider(){
				
				@Override
				public Object[] getElements(Object input)  {
					if (input instanceof EObject)						
						return BPELUtil.getVisibleCorrelationSets((EObject)input);
					return EMPTY_ARRAY;
				}
				
			});
			viewer.setLabelProvider(labelProvider);
			viewer.setSorter(ModelViewerSorter.getInstance());
			viewer.setInput(ModelHelper.getContainingScope(getInput()));
			return cellEditor;
		}
		public String getText(Object element) {
			return labelProvider.getText(((Correlation)element).getSet());
		}
		public boolean canModify(Object element, String property) {
			return true;
		}
		public Object getValue(Object element, String property) {
			return ((Correlation)element).getSet();
		}
		public void modify(Object element, String property, Object value) {
			Command cmd = new SetCorrelationSetRefCommand((Correlation)element, (CorrelationSet)value);
			getCommandFramework().execute(wrapInShowContextCommand(cmd));
		}
	}

	@Override
	public boolean shouldUseExtraSpace() { return true; }

	protected boolean isCorrelationListAffected(Notification n) {
		if (n.getNotifier() instanceof Correlations) return true;
		if (n.getNotifier() instanceof PartnerActivity) {
			return (n.getFeatureID(PartnerActivity.class) ==
				BPELPackage.PARTNER_ACTIVITY__CORRELATIONS);
		}
		if (n.getNotifier() instanceof OnMessage) {
			return (n.getFeatureID(OnMessage.class) == BPELPackage.ON_MESSAGE__CORRELATIONS);
		}
		if (n.getNotifier() instanceof OnEvent) {
			return (n.getFeatureID(OnEvent.class) == BPELPackage.ON_EVENT__CORRELATIONS);
		}
		return false;
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object and Correlations object */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {
					if (isCorrelationListAffected(n)) {
						updateCorrelationWidgets(null);
						refreshAdapters();
					}
				}
			},
			/* correlation(s) and correlation set(s) */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {
					if (n.getNotifier() instanceof Correlation) {
						updateCorrelationWidgets((Correlation)n.getNotifier());
						refreshAdapters();
					} else if (n.getNotifier() instanceof CorrelationSet) {
						Correlations c = ModelHelper.getCorrelations(getInput());
						if (c != null) {
							for (Iterator it = c.getChildren().iterator(); it.hasNext(); ) {
								Correlation corr = (Correlation)it.next();
								fAdapters[1].addToObject(corr);
								if (n.getNotifier() == corr.getSet()) {
									updateCorrelationWidgets(corr);
									refreshAdapters();
									break;
								} 
							}
						}
					}
				}
			}
		};
	}

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Correlations c = ModelHelper.getCorrelations(getInput());
		if (c != null) {
			fAdapters[0].addToObject(c);
			for (Iterator it = c.getChildren().iterator(); it.hasNext(); ) {
				Correlation corr = (Correlation)it.next();
				fAdapters[1].addToObject(corr);
				if (corr.getSet() != null)  fAdapters[1].addToObject(corr.getSet());
			}
		}
	}

	protected Correlation newDefaultCorrelation() {
		Correlation correlation = BPELFactory.eINSTANCE.createCorrelation();
		correlation.setInitiate(NO);
		if (getInput() instanceof Invoke) {
			correlation.setPattern(CorrelationPattern.RESPONSE_LITERAL);
		}
		
		// Try to select a correlation set that isn't already in the table.
		CorrelationSet firstUnusedSet = null;

		Correlations c = ModelHelper.getCorrelations(getInput());
		List corrList = (c == null)? Collections.EMPTY_LIST : c.getChildren();
		HashSet usedSets = new HashSet(corrList.size());
		for (Iterator it = corrList.iterator(); it.hasNext(); ) {
			usedSets.add(((Correlation)it.next()).getSet());
		}
		for (Iterator it = getProcess().getCorrelationSets().getChildren().iterator(); it.hasNext(); ) {
			CorrelationSet set = (CorrelationSet)it.next();
			if (!usedSets.contains(set)) {
				// found one we're not using.
				firstUnusedSet = set; break;
			}
		}
		// note: it's okay if firstUnusedSet is still null here (we'll show "-- none --").
		correlation.setSet(firstUnusedSet);
		return correlation;
	}

	protected void createCorrelationSetWidgets(Composite composite)  {
		FlatFormData data;
		
		addButton = fWidgetFactory.createButton(composite, Messages.CorrelationDetails_Add_18, SWT.PUSH); 
		removeButton = fWidgetFactory.createButton(composite, Messages.CorrelationDetails_Remove_19, SWT.PUSH); 
		Label correlationSetLabel = fWidgetFactory.createLabel(composite, Messages.CorrelationDetails_Correlation_Sets__20); 
		correlationTable = fWidgetFactory.createTable(composite, SWT.FULL_SELECTION | SWT.V_SCROLL);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		correlationSetLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(addButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(removeButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		addButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(removeButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		removeButton.setLayoutData(data);
		removeButton.setEnabled(false);
		
		addButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Correlation correlation = newDefaultCorrelation();
				Command cmd = new AddCorrelationCommand(getInput(), correlation);
				getCommandFramework().execute(wrapInShowContextCommand(cmd));
				correlationViewer.setSelection(new StructuredSelection(correlation));
				removeButton.setEnabled(true);
				if (tableCursor != null)
					tableCursor.refresh();
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
		Listener removeListener = new Listener() {
			public void handleEvent(Event e) {
				if (e.type == SWT.KeyUp && e.character != SWT.DEL)  return;
				IStructuredSelection sel = (IStructuredSelection)correlationViewer.getSelection();
				Correlation correlation = (Correlation)sel.getFirstElement();
				int selectionIndex = correlationTable.getSelectionIndex();
				if (correlation != null)  {
					Command cmd = new RemoveCorrelationCommand(getInput(), correlation);
					getCommandFramework().execute(wrapInShowContextCommand(cmd));
				}
				// selects the element at the deleted element position
				int items = correlationTable.getItemCount();
				if (items > 0) {
					selectionIndex = (selectionIndex < items) ? selectionIndex : 0;
					correlationTable.setSelection(selectionIndex);
				}
				if (tableCursor != null)
					tableCursor.refresh();
				updateButtonEnablement();
			}
		};
		correlationTable.addListener(SWT.KeyUp, removeListener);
		
		removeButton.addListener(SWT.Selection, removeListener);
		removeButton.addListener(SWT.DefaultSelection, removeListener);

		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(addButton, IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, 0);
		correlationTable.setLayoutData(data);

		correlationTable.setLinesVisible(true);
		correlationTable.setHeaderVisible(true);
		
		tableProvider = new ColumnTableProvider();
		tableProvider.add(new DirectionColumn());
		tableProvider.add(new InitiationColumn());
		tableProvider.add(new NameColumn());
		
		correlationTable.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				removeButton.setEnabled(!correlationViewer.getSelection().isEmpty());
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
	
		correlationViewer = new TableViewer(correlationTable);
		tableProvider.createTableLayout(correlationTable);
		correlationViewer.setLabelProvider(tableProvider);
		correlationViewer.setCellModifier(tableProvider);
		correlationViewer.setContentProvider(new CorrelationContentProvider());
		// TODO: should this have a sorter?
		correlationViewer.setColumnProperties(tableProvider.getColumnProperties());
		correlationViewer.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtonEnablement();
			}
		});
		
		tableCursor = BPELUtil.createTableCursor(correlationTable, correlationViewer);
	}
	
	@Override
	protected void createClient(Composite parent)  {
		Composite composite = createFlatFormComposite(parent);
		createCorrelationSetWidgets(composite);
		
    PlatformUI.getWorkbench().getHelpSystem().setHelp(
      composite, IHelpContextIds.PROPERTY_PAGE_CORRELATION);
	}

	protected void updateCorrelationWidgets(Correlation corr) {
		Object input = getInput();
		if (input == null)  throw new IllegalStateException();
		
		allowOutgoing = ModelHelper.isMessageActivity(input, ModelHelper.OUTGOING);
		allowIncoming = ModelHelper.isMessageActivity(input, ModelHelper.INCOMING);
		correlationViewer.setInput(getInput());
		if (corr != null) {
			correlationViewer.refresh(corr, true);
		} else {
			correlationViewer.refresh();
		}
		if (tableCursor != null)
			tableCursor.refresh();
	}
	
	@Override
	public void refresh() {
		super.refresh();
		updateCorrelationWidgets(null);
	}

	@Override
	public Object getUserContext() {
		return ((StructuredSelection)correlationViewer.getSelection()).getFirstElement();
	}
	@Override
	public void restoreUserContext(Object userContext) {
		correlationTable.setFocus();
		if (userContext != null) {
			correlationViewer.setSelection(new StructuredSelection(userContext));
		}
	}
	
	@Override
	protected void basicSetInput(EObject newInput) {
		super.basicSetInput(newInput);
		correlationViewer.setCellEditors(tableProvider.createCellEditors(correlationTable));
	}
	

	protected void updateButtonEnablement(){
		boolean hasSelection = !correlationViewer.getSelection().isEmpty();
		removeButton.setEnabled(hasSelection);
	}	
}
