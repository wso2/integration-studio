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

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.viewers.CComboViewer;
import org.eclipse.bpel.common.ui.details.widgets.DecoratedLabel;
import org.eclipse.bpel.common.ui.details.widgets.StatusLabel2;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.details.providers.AddNullFilter;
import org.eclipse.bpel.ui.details.providers.AddSelectedObjectFilter;
import org.eclipse.bpel.ui.details.providers.FaultContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.ModelViewerSorter;
import org.eclipse.bpel.ui.details.providers.OperationContentProvider;
import org.eclipse.bpel.ui.details.providers.PortTypeContentProvider;
import org.eclipse.bpel.ui.details.providers.VariableTypeTreeContentProvider;
import org.eclipse.bpel.ui.dialogs.TypeSelectorDialog;
import org.eclipse.bpel.ui.uiextensionmodel.VariableExtension;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BrowseUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Output;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * A composite for selecting either a "Data Type" (XSD type, or XSD element containing
 * an anonymous XSD type) an "Interface" type (actually a WSDL message, specified by
 * choosing then Interface+Operation+direction/fault)
 */
public class VariableTypeSelector extends Composite {

	public static final int KIND_UNKNOWN = VariableExtension.KIND_UNKNOWN;
	public static final int KIND_INTERFACE = VariableExtension.KIND_INTERFACE;
	public static final int KIND_DATATYPE = VariableExtension.KIND_DATATYPE;
	
	protected static final int DATATYPE_RADIO_CONTEXT = 1;
	protected static final int INTERFACE_RADIO_CONTEXT = 2;
	
	protected static final int OPERATION_INPUTRADIO_CONTEXT = 3;
	protected static final int OPERATION_OUTPUTRADIO_CONTEXT = 4;
	protected static final int OPERATION_FAULTRADIO_CONTEXT = 5;
	protected static final int OPERATION_COMBO_CONTEXT = 6;
	protected static final int INTERFACE_COMBO_CONTEXT = 7;
	protected static final int INTERFACE_BROWSE_CONTEXT = 8;
	protected static final int DATATYPE_BROWSE_CONTEXT = 9;
	protected static final int FAULT_COMBO_CONTEXT = 10;

	protected int lastChangeContext = -1;
	
	protected boolean inUpdate = false;

	protected int kindHint = KIND_UNKNOWN;
	
	public static final int STANDARD_LABEL_WIDTH_SM = 125;
	public static final int STANDARD_LABEL_WIDTH_AVG = STANDARD_LABEL_WIDTH_SM * 5/4;
	
	// private static final StructuredViewer dataTypeViewer = null;

	protected EObject variableType;
	protected Variable myVariable;

	protected Button dataTypeRadio, interfaceRadio;
	protected Composite dataTypeComposite, interfaceComposite;

	protected TabbedPropertySheetWidgetFactory wf;
	
	protected CComboViewer interfaceViewer;
	protected Button interfaceBrowseButton;
	protected CComboViewer operationViewer;
	protected Button operationInputRadio, operationOutputRadio, operationFaultRadio;
	protected CComboViewer faultViewer;
	
	protected Label interfaceLabel, operationLabel, faultLabel;
	
	protected AddSelectedObjectFilter interfaceAddSelectedObjectFilter;
	protected AddSelectedObjectFilter operationAddSelectedObjectFilter;
	protected AddSelectedObjectFilter faultAddSelectedObjectFilter;
	
	protected Button dataTypeBrowseButton;
	protected Hyperlink dataTypeNameText;
	protected Tree dataTypeTree;
	protected TreeViewer dataTypeTreeViewer;
	protected StatusLabel2 dataTypeLabel;

	protected BPELEditor bpelEditor;
	protected Callback callback;
	protected Shell shell;
	protected boolean nullFilterAdded = false;
	
	protected int filter = TypeSelectorDialog.INCLUDE_ALL;
	protected boolean requireLowerTreeSelection = false;

	// https://issues.jboss.org/browse/JBIDE-8045
	// removed unused "allowElements" param
	public VariableTypeSelector(Composite parent, int style, BPELEditor bpelEditor,
		TabbedPropertySheetWidgetFactory wf, Callback callback)
	{
		super(parent, style);
		this.bpelEditor = bpelEditor;
		this.shell = bpelEditor.getSite().getShell();
		this.wf = wf;
		this.callback = callback;
		
		Composite parentComposite = createComposite(this);
		this.setLayout(new FillLayout(SWT.VERTICAL));
				
		FlatFormLayout formLayout = new FlatFormLayout();
		
		formLayout.marginWidth = formLayout.marginHeight = 0;
		parentComposite.setLayout(formLayout);

		createDataTypeWidgets(parentComposite);
	}

	// https://issues.jboss.org/browse/JBIDE-8045
	// new constructor to allow constraining the filter checkboxes to only those types
	// valid for the object being defined/modified
	public VariableTypeSelector(Composite parent, int style, BPELEditor bpelEditor,
		TabbedPropertySheetWidgetFactory wf, Callback callback, boolean requireLowerTreeSelection, int filter)
	{
		this(parent, style, bpelEditor, wf, callback);
		this.filter = filter;
		this.requireLowerTreeSelection = requireLowerTreeSelection;
	}
	
	/**
	 * Refresh the given CComboViewer, and also make sure selectedObject is selected in it.
	 */
	protected void refreshCCombo(CComboViewer viewer, Object selectedObject) {
		viewer.refresh();
		if (selectedObject == null) {
			// work-around the null check in StructuredSelection(Object) ctor.
			viewer.setSelectionNoNotify(new StructuredSelection(Collections.singletonList(null)), false);
		} else {
			viewer.setSelectionNoNotify(new StructuredSelection(selectedObject), false);
		}
	}

	protected void selectComposite(int n) {
		
		interfaceRadio.setSelection(n == Callback.KIND_INTERFACE);
		
		interfaceComposite.setVisible(n == Callback.KIND_INTERFACE);
		dataTypeRadio.setSelection(n == Callback.KIND_DATATYPE);
		dataTypeComposite.setVisible(n == Callback.KIND_DATATYPE);
	}

	/**
	 * Expects either a WSDL message, an XSD type, or an XSD element.
	 */
	public void setVariableType(EObject variableType) {
		//System.out.println("setVariableType: "+variableType);
		this.variableType = variableType;
		refresh();
	}

	/**
	 * This method is preferred over the EObject method if the caller has a BPELVariable
	 * model object, because this method supports hints stored in the VariableExtension.
	 */
	public void setVariable(Variable variable) {
		kindHint = KIND_UNKNOWN;
		myVariable = variable;
		
		if (variable != null) {  
			if (variable.getMessageType() != null) {
				setVariableType(variable.getMessageType()); return;
			}
			if (variable.getType() != null) {
				setVariableType(variable.getType()); return;
			}
			if (variable.getXSDElement() != null) {
				setVariableType(variable.getXSDElement()); return;
			}
			VariableExtension varExt = (VariableExtension)ModelHelper.getExtension(variable);
			if (varExt != null) {
				kindHint = varExt.getVariableKind();
			}
		}
		setVariableType(null);
	}

	protected void updateDataTypeWidgets() {
		
		String name = null;
		ILabeledElement label =  (ILabeledElement) BPELUtil.adapt(variableType, ILabeledElement.class, myVariable);
		if (label != null) {
			name = label.getLabel(variableType);
		} 	
					
		if (name == null) {
			dataTypeNameText.setText(Messages.VariableTypeSelector_None_1); 
			dataTypeNameText.setEnabled(false);
			dataTypeTreeViewer.setInput(null);
			dataTypeLabel.setText(Messages.VariableTypeSelector_Data_Type_2);
			return ;
		}
		
		dataTypeNameText.setText(name);
		if (variableType instanceof XSDTypeDefinition) {
			dataTypeNameText.setEnabled(true);
			dataTypeTreeViewer.setInput(variableType);
			dataTypeLabel.setText(Messages.VariableTypeSelector_Data_Type_2);				
		} else if (variableType instanceof XSDElementDeclaration) {
			dataTypeNameText.setEnabled(true);
			dataTypeTreeViewer.setInput(variableType);
			dataTypeLabel.setText(Messages.VariableTypeSelector_0);
		} else if (variableType instanceof Message) {
			dataTypeNameText.setEnabled(true);
			dataTypeTreeViewer.setInput(variableType);
			dataTypeLabel.setText(Messages.VariableTypeSelector_1);
		}
		
		// scroll to the top ...
		ScrollBar bar = dataTypeTree.getVerticalBar();
		if (bar != null) {
			bar.setSelection(0);
		}			
				
	}

	protected void updateInterfaceWidgets()  {
		PortType portType = null;
		Operation operation = null;
		Message message = null;
		if (variableType instanceof Message) {
			message = (Message)variableType;
		}
		if (message != null) operation = BPELUtil.getOperationFromMessage(message);
		if (operation != null) portType = (PortType)operation.eContainer();
		
		interfaceViewer.setInput(bpelEditor.getProcess());
		interfaceAddSelectedObjectFilter.setSelectedObject(portType);
		inUpdate = true;
		try {
			refreshCCombo(interfaceViewer, portType);
	
			if (operation == null) {
				if (!nullFilterAdded) {
					operationViewer.addFilter(AddNullFilter.getInstance());
					nullFilterAdded = true;
				}
			} else {
				if (nullFilterAdded) {
					operationViewer.removeFilter(AddNullFilter.getInstance());
					nullFilterAdded = false;
				}
			}
			operationViewer.setInput(portType);
			operationAddSelectedObjectFilter.setSelectedObject(operation);
			refreshCCombo(operationViewer, operation);
		} finally {
			inUpdate = false;
		}
		updateFaultRadio(message, operation);
	}

	protected void updateCompositeSelection() {
		int kind = kindHint;
		if (variableType instanceof Message) {
			kind = KIND_INTERFACE;
		} else if (variableType instanceof XSDTypeDefinition) {
			kind = KIND_DATATYPE;
		} else if (variableType instanceof XSDElementDeclaration) {
			kind = KIND_DATATYPE;
		}
		if (kind == KIND_UNKNOWN) kind = KIND_DATATYPE;
		selectComposite(kind);
		doChildLayout();
	}
	
	protected void doChildLayout() {
		dataTypeComposite.layout(true);
	}

	/**
	 * 
	 */
	
	public void refresh() {
		// updateInterfaceWidgets();
		updateDataTypeWidgets();
		// updateCompositeSelection();
	}

	/**
	 * Returns either a WSDL message, an XSD type, an XSD element, or null.
	 * @return the variable type
	 */
	
	public EObject getVariableType() { 
		return variableType; 
	}
	
	protected Composite createFlatFormComposite(Composite parent) {
		Composite result = createComposite(parent);
		FlatFormLayout formLayout = new FlatFormLayout();
		formLayout.marginWidth = formLayout.marginHeight = 0;
		result.setLayout(formLayout);
		return result;
		
	}

	/**
	 * If the widgets are set for faults and the new operation doesn't have any,
	 * this won't work - use computeMessageFromOperation instead.
	 */
	protected Message getStoreMessageFromOperation(Operation operation) {
		// TODO: dialog box if there are no operations?
		Message message = null;
		if (operation != null) {
			if (operationFaultRadio.getSelection()) {
				StructuredSelection sel = (StructuredSelection)faultViewer.getSelection();
				Fault fault = (Fault)sel.getFirstElement();
				if (fault != null) message = fault.getEMessage();
				return message;
			} else if (operationOutputRadio.getSelection()) {
				Output output = operation.getEOutput();
				if (output != null) message = output.getEMessage();
				return message;
			} else {
				Input input = operation.getEInput();
				if (input != null) message = input.getEMessage();
				return message;
			}
		}
		return message;
	}
	
	class RadioListener implements SelectionListener {
		int index;

		/** Radio listener for indexed button index.
		 * @param index
		 */
		public RadioListener(int index) {
			this.index = index;
		}

		public void widgetSelected(SelectionEvent e) {
			if (!((Button) e.widget).getSelection())
				return;
			lastChangeContext = index;
			callback.selectRadioButton(index);
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
	
	protected void createRadioButtonWidgets(Composite composite) {
		FlatFormData data;

		dataTypeRadio = createButton(composite, Messages.VariableTypeSelector_Data_Type_1, SWT.RADIO); 
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 0);
		data.left = new FlatFormAttachment(0, 0);
		dataTypeRadio.setLayoutData(data);

		interfaceRadio = createButton(composite, Messages.VariableTypeSelector_Interface_1, SWT.RADIO); 
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 0);
		data.left = new FlatFormAttachment(dataTypeRadio, IDetailsAreaConstants.HSPACE);
		interfaceRadio.setLayoutData(data);

		interfaceRadio.addSelectionListener(new RadioListener(Callback.KIND_INTERFACE));
		dataTypeRadio.addSelectionListener(new RadioListener(Callback.KIND_DATATYPE));
	}
	
	protected void createInterfaceWidgets(Composite parent) {
		FlatFormData data;

		Composite composite = interfaceComposite = createFlatFormComposite(parent);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(interfaceRadio, IDetailsAreaConstants.VMARGIN);
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		interfaceComposite.setLayoutData(data);
		
		interfaceBrowseButton = createButton(composite, Messages.VariableTypeSelector_Browse_1, SWT.PUSH); 

		interfaceLabel = createLabel(composite, Messages.VariableTypeSelector_Interface_2); 
		CCombo interfaceCombo = createCCombo(composite);
		interfaceViewer = new CComboViewer(interfaceCombo);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(interfaceCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(interfaceCombo, 0, SWT.CENTER);
		interfaceLabel.setLayoutData(data);

		interfaceAddSelectedObjectFilter = new AddSelectedObjectFilter();
		interfaceViewer.addFilter(AddNullFilter.getInstance());
		interfaceViewer.addFilter(interfaceAddSelectedObjectFilter);
		interfaceViewer.setLabelProvider(new ModelLabelProvider());
		interfaceViewer.setContentProvider(new PortTypeContentProvider());
		interfaceViewer.setSorter(ModelViewerSorter.getInstance());
		interfaceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection)event.getSelection();
				PortType portType = (PortType)selection.getFirstElement();
				Operation operation = null;
				if (portType != null && !portType.getEOperations().isEmpty()) {
					operation = (Operation)portType.getEOperations().get(0);
				}
				lastChangeContext = INTERFACE_COMBO_CONTEXT;
				
				Message message = computeMessageFromOperation(operation);
				callback.selectMessageType(message);
				updateFaultRadio(message, operation);				
			}
		});
		
		interfaceBrowseButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
            	PortType portType = BrowseUtil.browseForPortType(bpelEditor.getResourceSet(), shell);
            	if (portType != null) {
            		Operation operation = null;
					if (!portType.getEOperations().isEmpty()) {
						operation = (Operation)portType.getEOperations().get(0);
					}
					lastChangeContext = INTERFACE_BROWSE_CONTEXT;
					
					Message message = computeMessageFromOperation(operation);
					callback.selectMessageType(message);
					updateFaultRadio(message, operation);				
			    }
			}
		});
		
		operationLabel = createLabel(composite, Messages.VariableTypeSelector_Operation_1); 
		CCombo operationCombo = createCCombo(composite);
		operationViewer = new CComboViewer(operationCombo);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(operationCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(operationCombo, 0, SWT.CENTER);
		operationLabel.setLayoutData(data);

		operationAddSelectedObjectFilter = new AddSelectedObjectFilter();
		//operationViewer.addFilter(AddNullFilter.getInstance());			
		operationViewer.addFilter(operationAddSelectedObjectFilter);			
		operationViewer.setLabelProvider(new ModelLabelProvider());
		operationViewer.setContentProvider(new OperationContentProvider());
		operationViewer.setSorter(ModelViewerSorter.getInstance());
		operationViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection)event.getSelection();
				Operation operation = (Operation)selection.getFirstElement();
				lastChangeContext = OPERATION_COMBO_CONTEXT;
				Message message = computeMessageFromOperation(operation);
				callback.selectMessageType(message);
				updateFaultRadio(message, operation);				
			}
		});

		Label directionLabel = createLabel(composite, Messages.VariableTypeSelector_Direction_1); 
		
		// TODO: should these radio buttons really be a check box for the Reply case??
		// - for now no, since I'm afraid it might be kind of confusing.
		
		operationInputRadio = createButton(composite, Messages.VariableTypeSelector_Input_1, SWT.RADIO); 
		data = new FlatFormData();
		data.top = new FlatFormAttachment(operationViewer.getCCombo(), IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(directionLabel, STANDARD_LABEL_WIDTH_SM));
		operationInputRadio.setLayoutData(data);
		operationInputRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!operationInputRadio.getSelection()) return;
				StructuredSelection selection = (StructuredSelection)operationViewer.getSelection();
				Operation operation = (Operation)selection.getFirstElement();
				lastChangeContext = OPERATION_INPUTRADIO_CONTEXT;
				callback.selectMessageType(getStoreMessageFromOperation(operation));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		operationOutputRadio = createButton(composite, Messages.VariableTypeSelector_Output_1, SWT.RADIO); 
		data = new FlatFormData();
		data.top = new FlatFormAttachment(operationInputRadio, 0, SWT.TOP);
		data.left = new FlatFormAttachment(operationInputRadio, IDetailsAreaConstants.HSPACE);
		operationOutputRadio.setLayoutData(data);
		operationOutputRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!operationOutputRadio.getSelection()) return;
				StructuredSelection selection = (StructuredSelection)operationViewer.getSelection();
				Operation operation = (Operation)selection.getFirstElement();
				lastChangeContext = OPERATION_OUTPUTRADIO_CONTEXT;
				callback.selectMessageType(getStoreMessageFromOperation(operation));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		operationFaultRadio = createButton(composite, Messages.VariableTypeSelector_Fault_1, SWT.RADIO); 
		data = new FlatFormData();
		data.top = new FlatFormAttachment(operationOutputRadio, 0, SWT.TOP);
		data.left = new FlatFormAttachment(operationOutputRadio, IDetailsAreaConstants.HSPACE);
		operationFaultRadio.setLayoutData(data);
		operationFaultRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!operationFaultRadio.getSelection()) return;
				StructuredSelection selection = (StructuredSelection)operationViewer.getSelection();
				Operation operation = (Operation)selection.getFirstElement();				
				lastChangeContext = OPERATION_FAULTRADIO_CONTEXT;
				// Get the fault from the operation.
				Fault fault = (Fault)operation.getEFaults().get(0);
				Message message = fault.getEMessage();
				callback.selectMessageType(message);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		faultLabel = createLabel(composite, Messages.VariableTypeSelector_Fault_2); 
			
		CCombo faultCombo = createCCombo(composite);
		faultViewer = new CComboViewer(faultCombo);

//		data = new FlatFormData();
//		data.top = new FlatFormAttachment(operationFaultRadio, IDetailsAreaConstants.VSPACE);
//		data.left = new FlatFormAttachment(faultLabel, IDetailsAreaConstants.HSPACE);
//		faultCombo.setLayoutData(data);

		data = new FlatFormData();
		data.top = new FlatFormAttachment(faultCombo, 0, SWT.CENTER);
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultCombo, -IDetailsAreaConstants.HSPACE);
		faultLabel.setLayoutData(data);

		faultAddSelectedObjectFilter = new AddSelectedObjectFilter();
		faultViewer.addFilter(faultAddSelectedObjectFilter);			
		faultViewer.setLabelProvider(new ModelLabelProvider());
		faultViewer.setContentProvider(new FaultContentProvider());
		faultViewer.setSorter(ModelViewerSorter.getInstance());
		faultViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection)operationViewer.getSelection();
				Operation operation = (Operation)selection.getFirstElement();
				lastChangeContext = FAULT_COMBO_CONTEXT;
				callback.selectMessageType(getStoreMessageFromOperation(operation));
			}
		});
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(operationCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(operationInputRadio, 0, SWT.CENTER);
		directionLabel.setLayoutData(data);
		
		internalSetLayoutData();	
	}
	
	protected void createDataTypeWidgets(Composite parent) {
		FlatFormData data;

		Composite composite = dataTypeComposite = createFlatFormComposite(parent);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VMARGIN);
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		dataTypeComposite.setLayoutData(data);
		
		
		dataTypeBrowseButton = createButton(composite, Messages.VariableTypeSelector_Browse_2, SWT.PUSH);
		DecoratedLabel label = new DecoratedLabel(composite,SWT.LEFT);
		label.setText(Messages.VariableTypeSelector_Data_Type_2);
		wf.adapt(label);
		dataTypeLabel = new StatusLabel2( label );
		// https://jira.jboss.org/browse/JBIDE-7107
		dataTypeLabel.getLabel().setBackground(this.getBackground());
		dataTypeNameText = createHyperlink(composite, "", SWT.NONE); //$NON-NLS-1$
		dataTypeNameText.setToolTipText(Messages.VariableTypeSelector_3);
		dataTypeNameText.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				// https://issues.jboss.org/browse/JBIDE-8048
				// don't bother trying to open editor if variable is not defined
				if (getVariableType() != null)
					BPELUtil.openEditor(getVariableType(), bpelEditor);
			}
		});
		
		Label dataTypeTreeLabel = createLabel(composite, Messages.VariableTypeSelector_2); 
		
		// Tree viewer for variable structure ...
		dataTypeTree = wf.createTree(composite, SWT.NONE);
		VariableTypeTreeContentProvider variableContentProvider = new VariableTypeTreeContentProvider(true, true);
		dataTypeTreeViewer = new TreeViewer(dataTypeTree);
		dataTypeTreeViewer.setContentProvider(variableContentProvider);
		dataTypeTreeViewer.setLabelProvider(new ModelTreeLabelProvider());
		dataTypeTreeViewer.setInput ( null );
		dataTypeTreeViewer.setAutoExpandLevel(3);
		// end tree viewer for variable structure
				
		// layout data type label
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(dataTypeLabel.getControl(), 
				  STANDARD_LABEL_WIDTH_SM));
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		data.right = new FlatFormAttachment(60,0);
		dataTypeNameText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0,IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(dataTypeNameText, -IDetailsAreaConstants.HSPACE);
		// https://jira.jboss.org/browse/JBIDE-7107
		data.top = new FlatFormAttachment(dataTypeNameText, -IDetailsAreaConstants.VSPACE, SWT.TOP);
		data.bottom = new FlatFormAttachment(dataTypeNameText,0,SWT.BOTTOM);
		dataTypeLabel.setLayoutData(data);
				
		data = new FlatFormData();
		data.top = new FlatFormAttachment(dataTypeNameText, -2, SWT.TOP);
		data.bottom = new FlatFormAttachment(dataTypeLabel.getLabel(), +2, SWT.BOTTOM);
		data.right = new FlatFormAttachment(100,-IDetailsAreaConstants.HSPACE);		
		dataTypeBrowseButton.setLayoutData(data);
		
		dataTypeBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				
				// https://issues.jboss.org/browse/JBIDE-8045
				Object selection[] = BrowseUtil.browseForVariableType(
						bpelEditor.getProcess(), getShell(),requireLowerTreeSelection,filter);
				if (selection != null) {
					Object xsdType = selection[0];
    				lastChangeContext = DATATYPE_BROWSE_CONTEXT;
					if (xsdType instanceof XSDTypeDefinition) {
						// TODO:WDG: if type is anonymous, use enclosing element 
						callback.selectXSDType((XSDTypeDefinition)xsdType);
					} else if (xsdType instanceof XSDElementDeclaration) {
						callback.selectXSDElement((XSDElementDeclaration)xsdType);
					} else if (xsdType instanceof Message) {
						callback.selectMessageType((Message) xsdType);
					}
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);		
		data.top = new FlatFormAttachment(dataTypeLabel.getLabel(), 3*IDetailsAreaConstants.VSPACE, SWT.BOTTOM);
		dataTypeTreeLabel.setLayoutData(data);

		data = new FlatFormData();
		// https://jira.jboss.org/browse/JBIDE-7107
//		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(dataTypeLabel.getLabel(), STANDARD_LABEL_WIDTH_SM));
//		data.top = new FlatFormAttachment(dataTypeTreeLabel,0, SWT.TOP);
		data.left = new FlatFormAttachment(dataTypeTreeLabel,0, SWT.LEFT);
		data.top = new FlatFormAttachment(dataTypeTreeLabel,0, SWT.BOTTOM);
		data.right = new FlatFormAttachment(100,  -IDetailsAreaConstants.HSPACE) ;		
		// https://issues.jboss.org/browse/JBIDE-8048
		// make the message structure viewer a wee bit larger than just a single line
		data.bottom = new FlatFormAttachment(dataTypeTreeLabel,150, SWT.BOTTOM); //new FlatFormAttachment(100, -IDetailsAreaConstants.HSPACE);	
		dataTypeTree.setLayoutData(data);
		
	}
	
	public interface Callback {
		public static final int KIND_DATATYPE = VariableExtension.KIND_DATATYPE;
		public static final int KIND_INTERFACE = VariableExtension.KIND_INTERFACE;
		public void selectRadioButton(int index);
		
		public void selectXSDType(XSDTypeDefinition xsdType);
		public void selectXSDElement(XSDElementDeclaration xsdElement);
		public void selectMessageType(Message message);
	}
	
	public Object getUserContext() {
		return Integer.valueOf( lastChangeContext );
	}
	public void restoreUserContext(Object userContext) {
		switch (((Integer)userContext).intValue()) {
		case DATATYPE_RADIO_CONTEXT: dataTypeRadio.setFocus(); return;
		case INTERFACE_RADIO_CONTEXT: interfaceRadio.setFocus(); return;
		case OPERATION_INPUTRADIO_CONTEXT: operationInputRadio.setFocus(); return;
		case OPERATION_OUTPUTRADIO_CONTEXT: operationOutputRadio.setFocus(); return;
		case OPERATION_FAULTRADIO_CONTEXT: operationFaultRadio.setFocus(); return;
		case OPERATION_COMBO_CONTEXT: operationViewer.getCCombo().setFocus(); return;
		case INTERFACE_COMBO_CONTEXT: interfaceViewer.getCCombo().setFocus(); return;
		case INTERFACE_BROWSE_CONTEXT: interfaceBrowseButton.setFocus(); return;
		case DATATYPE_BROWSE_CONTEXT: dataTypeBrowseButton.setFocus(); return;
		case FAULT_COMBO_CONTEXT: faultViewer.getCCombo().setFocus(); return;
		}
		throw new IllegalStateException();
	}
	
	@Override
	public void setEnabled(boolean enabled) {	
		setEnabled(enabled, this,0);
	}

	void setEnabled ( boolean enabled, Control control , int depth) {
		
		if (control instanceof Composite) {
			Composite root = (Composite) control;
			Control list[] = root.getChildren();
			for(int i=0; i<list.length; i++) {
				setEnabled(enabled,list[i],depth+1);
			}
		}
		if (depth > 0) {
			control.setEnabled(enabled);
		}
	}
	
	
	protected Button createButton(Composite parent, String text, int style) {
		return wf.createButton(parent, text, style);
	}	
	protected Composite createComposite(Composite parent) {
		return wf.createComposite(parent);
	}
	protected Label createLabel(Composite parent, String text) {
		return wf.createLabel(parent, text);
	}	
	protected Hyperlink createHyperlink(Composite parent, String text, int style) {
		return wf.createHyperlink(parent, text, style);
	}	
	protected CCombo createCCombo(Composite parent) {
		return wf.createCCombo(parent);
	}
	
	protected void internalSetLayoutData() {
		FlatFormData data = new FlatFormData();
		// data.left = new FlatFormAttachment(50, -IDetailsAreaConstants.CENTER_SPACE + IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(interfaceViewer.getControl(), -1, SWT.TOP);
		data.bottom = new FlatFormAttachment(interfaceViewer.getControl(), +1, SWT.BOTTOM);
		data.right = new FlatFormAttachment(100,-IDetailsAreaConstants.HSPACE);
		interfaceBrowseButton.setLayoutData(data);	
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 2);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(interfaceLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(interfaceBrowseButton, -IDetailsAreaConstants.HSPACE);
		interfaceViewer.getControl().setLayoutData(data);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(interfaceViewer.getControl(), IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(operationLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(interfaceBrowseButton, -IDetailsAreaConstants.HSPACE);
		operationViewer.getControl().setLayoutData(data);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(operationFaultRadio, IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(interfaceBrowseButton, -IDetailsAreaConstants.HSPACE);
		faultViewer.getCCombo().setLayoutData(data);
	}
	
	protected void updateFaultRadio(Message message, Operation operation) {
		boolean isInput = true;
		boolean isOutput = false;
		boolean isFault = false;
		Fault fault = null;
		if (operation != null && message != null) {
			Iterator it = operation.getEFaults().iterator();
			while (it.hasNext()) {
				Fault nextFault = (Fault)it.next();
				Message faultMessage = nextFault.getEMessage();
				if (faultMessage != null && faultMessage.getQName() != null) {
					if (faultMessage.getQName().equals(message.getQName())) {
						isFault = true;
						isInput = false;
						isOutput = false;
						fault = nextFault;
					}
				}
			}
			Output output = operation.getEOutput();
			if (output != null) {
				Message outputMessage = output.getEMessage();
				if (outputMessage != null && outputMessage.getQName() != null) {
					if (outputMessage.getQName().equals(message.getQName())) {
						isOutput = true;
						isInput = false;
						isFault = false;
					}
				}
			}
		}
		operationInputRadio.setSelection(isInput);
		operationOutputRadio.setSelection(isOutput);
		operationFaultRadio.setSelection(isFault);
		operationFaultRadio.setVisible(operation != null && !operation.getEFaults().isEmpty());
		faultLabel.setVisible(isFault);
		faultViewer.getCCombo().setVisible(isFault);
		if (isFault) {
			if (operation != null) {
				faultViewer.setInput(operation);
				refreshCCombo(faultViewer, fault);
			}
		}
		this.layout(true);
		faultViewer.getCCombo().getParent().redraw();
		faultViewer.getCCombo().redraw();
		interfaceComposite.layout(true);
	}
	
	/**
	 * This one handles faults, also whacks the radio buttons when appropriate.
	 * Use this one after changing the operation, and the other one when 
	 * leaving the operation alone.
	 */
	protected Message computeMessageFromOperation(Operation operation) {
		Message message = null;
		if (operationFaultRadio.getSelection()) {
			if (operation.getEFaults().isEmpty()) {
				operationFaultRadio.setSelection(false);
				operationOutputRadio.setSelection(true);
				message = getStoreMessageFromOperation(operation);
			} else {
				Fault fault = (Fault)operation.getEFaults().get(0);
				message = fault.getEMessage();
			}
		} else {
			message = getStoreMessageFromOperation(operation);
		}	
		return message;
	}
}
