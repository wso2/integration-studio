/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.ui.pages;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.xml.namespace.QName;

import org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TService;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddFactory;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;
import org.eclipse.bpel.apache.ode.deploy.ui.Activator;
import org.eclipse.bpel.apache.ode.deploy.ui.editors.ODEDeployMultiPageEditor;
import org.eclipse.bpel.apache.ode.deploy.ui.messages.ODEDeployUIMessages;
import org.eclipse.bpel.apache.ode.deploy.ui.util.DeployResourceSetImpl;
import org.eclipse.bpel.apache.ode.deploy.ui.util.DeployUtils;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.IModelVisitor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

/**
 * Main process page, renders UI for all relevant deployment settings.
 * 
 * @author Simon Moser (IBM)
 * @author Tammo van Lessen (IAAS)
 */
public class ProcessPage extends FormPage implements IResourceChangeListener {
	public static final int PARTNER_LINK_COLUMN = 0;
	public static final int PORT_COLUMN = 1;
	public static final int SERVICE_COLUMN = 2;
	public static final int BINDING_COLUMN = 3;
	
	public static final String INSTANCE_LIFECYCLE_NAME = "instanceLifecycle"; //$NON-NLS-1$
	public static final String ACTIVITY_LIFECYCLE_NAME = "activityLifecycle"; //$NON-NLS-1$
	public static final String DATA_HANDLING_NAME = "dataHandling"; //$NON-NLS-1$
	public static final String SCOPE_HANDLING_NAME = "scopeHandling"; //$NON-NLS-1$
	public static final String CORRELATION_NAME = "correlation"; //$NON-NLS-1$
	
	public static final String[] PROCESS_STATUS = new String[] {"activated", "deactivated", "retired"};
	public static final int STATUS_ACTIVATED = 0;
	public static final int STATUS_DEACTIVATED = 1;
	public static final int STATUS_RETIRED = 2;
	
	public static final Map<String, String> eventNameById = new HashMap<String, String>();
	static {
		eventNameById.put(INSTANCE_LIFECYCLE_NAME, "Instance life cycle");
		eventNameById.put(ACTIVITY_LIFECYCLE_NAME, "Activity life cycle");
		eventNameById.put(DATA_HANDLING_NAME, "Data handling");
		eventNameById.put(SCOPE_HANDLING_NAME, "Scope handling");
		eventNameById.put(CORRELATION_NAME, "Correlation");
	}

	protected ODEDeployMultiPageEditor editor;
	protected ProcessType processType;
	protected FormToolkit toolkit;
	private EditingDomain domain;
	private TableViewer scopeTableViewer;
	private Form mainform;
	// Bugzilla 324164
	// we will manage this for ServiceCellEditor and PortTypeLabelProvider
	private DeployResourceSetImpl resourceSet = null;
	
	public ProcessPage(FormEditor editor, ProcessType pt) {
		super(editor, "ODED" + pt.getName().toString(), pt.getName().getLocalPart()); //$NON-NLS-1$
		this.processType = pt;
		this.editor = (ODEDeployMultiPageEditor)editor;
		
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
		
		this.domain = this.editor.getEditingDomain();
		// Bugzilla 324164
		resourceSet = new DeployResourceSetImpl();
		Process process = processType.getModel();
		for (Import imp : process.getImports()) {
			try {
				// NOTE: File URIs will be resolved by DeployUtils#loadAllWSDLFromProject(). This avoids the
				// hassle of having to deal with relative file paths here.
				URI uri = URI.createURI(imp.getLocation());
				if (!uri.isFile())
					resourceSet.getResource(uri, true);
			} catch (Exception e) {
				MessageDialog.openError(editor.getSite().getShell(), "Load Error", "Unable to load the import file:\n\n\t"+
						imp.getLocation()+"\n\n"+
						"Reason: "+e.getMessage()+"\n"+
						"Process definitions may not be available!"
				);
			}
		}
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText(MessageFormat.format("Process {0} - {1}", processType.getName().getLocalPart(), processType.getName().getNamespaceURI()));
		toolkit.decorateFormHeading(form.getForm());
		mainform = form.getForm(); 
		mainform.addMessageHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				refreshModel();
			}
		
		});

		form.setImage(BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PROCESS_32));

		RowLayout layout = new RowLayout();
 		layout.wrap = false;
 		layout.pack = true;
 		layout.justify = false;
 		layout.fill = true;
 		layout.type = SWT.VERTICAL;
 		layout.marginLeft = 5;
 		layout.marginTop = 5;
 		layout.marginRight = 5;
 		layout.marginBottom = 5;
 		layout.spacing = 5;
 		
		form.getBody().setLayout(layout);
		Dialog.applyDialogFont(form.getBody());
		
		Composite client = createSection(form.getBody(), "General", null, 1);

		final Composite statusArea = new Composite(client, SWT.NONE);
		statusArea.setLayout(new GridLayout(2, false));
		toolkit.createLabel(statusArea, ODEDeployUIMessages.ProcessPage_GeneralStatus_Label);
		final Combo comboStatus = new Combo(statusArea, SWT.READ_ONLY);
		toolkit.adapt(comboStatus);
		comboStatus.setItems(PROCESS_STATUS);
		if (processType.isActive()) {
			comboStatus.select(STATUS_ACTIVATED);
		} else {
			if (processType.isRetired()) {
				comboStatus.select(STATUS_RETIRED);
			} else {
				comboStatus.select(STATUS_DEACTIVATED);
			}
		}
		comboStatus.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				Command setActiveCommand = SetCommand.create(domain, processType, ddPackage.eINSTANCE.getProcessType_Active(), comboStatus.getSelectionIndex() == STATUS_ACTIVATED);
				Command setRetiredCommand = SetCommand.create(domain, processType, ddPackage.eINSTANCE.getProcessType_Retired(), comboStatus.getSelectionIndex() == STATUS_RETIRED);				
				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(setActiveCommand);
				compoundCommand.append(setRetiredCommand);					
				domain.getCommandStack().execute(compoundCommand);
			}
		});
		
		final Button btnRunInMemory = toolkit.createButton(client, ODEDeployUIMessages.ProcessPage_GeneralMemoryButton, SWT.CHECK); 
		btnRunInMemory.setToolTipText(ODEDeployUIMessages.ProcessPage_GeneralMemoryButton_Tooltip);
		btnRunInMemory.setSelection(processType.isInMemory());
		btnRunInMemory.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				Command setInMemoryCommand = SetCommand.create(domain, processType, ddPackage.eINSTANCE.getProcessType_InMemory(), btnRunInMemory.getSelection());
				domain.getCommandStack().execute(setInMemoryCommand);
			}
		
		});

		createInterfaceWidget(form.getBody(), processType, managedForm, "Inbound Interfaces (Services)", ODEDeployUIMessages.ProcessPage_Service_Description, true);
		createInterfaceWidget(form.getBody(), processType, managedForm, "Outbound Interfaces (Invokes)", ODEDeployUIMessages.ProcessPage_Invoke_Description, false);		

		createProcessMonitoringSection(form.getBody());
		createScopeMonitoringSection(form.getBody());
				
		form.reflow(true);
	}

	private void createInterfaceWidget(Composite fClient, ProcessType current, final IManagedForm managedForm, String title, String description, boolean isInbound) {
		
		// Set column names
		String[] columnNames = new String[] { 
				//"Partner Link (click on entry to open definition)",
				"Partner Link",
				"Associated Port",
				"Related Service",
				"Binding Used"
				};
		
		Section section = toolkit.createSection(fClient, Section.TWISTIE | Section.EXPANDED | Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText(title); 
		section.setDescription(description); 
		section.marginHeight = 5;
		
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		final Table t = toolkit.createTable(client, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		
	    TableColumn tc1 = new TableColumn(t, SWT.CENTER);
	    tc1.setText(columnNames[0]);

	    TableColumn tc2 = new TableColumn(t, SWT.CENTER);
	    tc2.setText(columnNames[1]);
	    
	    TableColumn tc3 = new TableColumn(t, SWT.CENTER);
	    tc3.setText(columnNames[2]);
	    
	    TableColumn tc4 = new TableColumn(t, SWT.CENTER);    
	    tc4.setText(columnNames[3]);
	    
	    t.setHeaderVisible(true);
		t.setLinesVisible(true);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);
		
		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);
		
		
	    URI deployDescriptorURI = current.eResource().getURI();
	    IFile ddFile = DeployUtils.getIFileForURI(deployDescriptorURI);
	    
		TableViewer viewer = new TableViewer(t);
		viewer.setUseHashlookup(true);
		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new PortTypeContentProvider(isInbound));
		// Bugzilla 324164
		viewer.setLabelProvider(new PortTypeLabelProvider(ddFile.getProject(), resourceSet));
		viewer.setInput(current);		

	    for (int i = 0, n = t.getColumnCount(); i < n; i++) {
		      t.getColumn(i).pack();
		}		
		
	    // Create the cell editors
	    CellEditor[] editors = new CellEditor[columnNames.length];

	    // TODO: Column 1 : HyperLink Listener
//		final TableEditor editor = new TableEditor(t);
//		editor.horizontalAlignment = SWT.LEFT;
//		editor.grabHorizontal = true;
//		IWorkbenchPage wbPage= getEditor().getSite().getPage();
//		InterfaceTableListener tableListener = new InterfaceTableListener(current, t, editor, toolkit, wbPage, isInbound);
//		t.addListener(SWT.MouseDown, tableListener);

	    // Column 2 : Associate Service (ComboBox)
	    // Bugzilla 324164
	    ServiceCellEditor sCellEditor = new ServiceCellEditor(t, ddFile.getProject(), resourceSet);
	    editors[1] = sCellEditor;

        // Assign the cell editors to the viewer 
	    viewer.setCellEditors(editors);
	    
	    // Set the cell modifier for the viewer
	    viewer.setCellModifier(new InterfaceWidgetCellModifier(viewer, columnNames));
      
	}
	

	class InterfaceWidgetCellModifier implements ICellModifier {
		private Viewer viewer;
		private String[] columnNames;

		public InterfaceWidgetCellModifier(Viewer viewer, String[] columnNames) {
			this.viewer = viewer;
			this.columnNames = columnNames;
		}
		
		public boolean canModify(Object element, String property) {
			if (property.equals(columnNames[1])) {
				return true; 
			}
			return false;
		}

		public Object getValue(Object element, String property) {
			if (!property.equals(columnNames[1])) {
				return null;
			}			
			if (element instanceof TProvide) {
				TProvide provide = (TProvide) element;
				return provide.getService();
			} 
			else if (element instanceof TInvoke) {
				TInvoke invoke = (TInvoke) element;
				return invoke.getService();
			}
			else {
				return null;
			}
			
		}

		public void modify(Object element, String property, Object value) {
			assert element instanceof Item;
			if (!property.equals(columnNames[1])) {
				return;
			}
			
			Item item = (Item) element;
			Object o = item.getData();
			if (o instanceof TProvide) {
				TProvide provide = (TProvide) o;
				
				TService service = provide.getService();
				if (service == null) {
					service = ddFactory.eINSTANCE.createTService();
					provide.setService(service);
				}
				
				if (value == null) {
					Command unsetServiceCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Name(), SetCommand.UNSET_VALUE);
					Command unsetPortCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Port(), SetCommand.UNSET_VALUE);				
					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(unsetServiceCommand);
					compoundCommand.append(unsetPortCommand);					
					domain.getCommandStack().execute(compoundCommand);
				}
				else {
					Port port = (Port) value;
					String portName = port.getName();
					
					Command setPortCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Port(), portName);
					
					Service wsdlService = (Service) port.eContainer();
					QName qname = wsdlService.getQName();
					Command setServiceCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Name(), qname);

					
					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(setServiceCommand);
					compoundCommand.append(setPortCommand);
									
					domain.getCommandStack().execute(compoundCommand);
				}
			}
			else if (o instanceof TInvoke) {
				TInvoke invoke = (TInvoke) o;
			
				TService service = invoke.getService();
				if (service == null) {
					service = ddFactory.eINSTANCE.createTService();
					invoke.setService(service);
				}	
				
				if (value == null) {
					Command unsetServiceCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Name(), SetCommand.UNSET_VALUE);
					Command unsetPortCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Port(), SetCommand.UNSET_VALUE);				
					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(unsetServiceCommand);
					compoundCommand.append(unsetPortCommand);					
					domain.getCommandStack().execute(compoundCommand);
				}
				else {		
					Port port = (Port) value;
					String portName = port.getName();
					
					Command setPortCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Port(), portName);
					
					Service wsdlService = (Service) port.eContainer();
					QName qname = wsdlService.getQName();
					Command setServiceCommand = SetCommand.create(domain, service, ddPackage.eINSTANCE.getTService_Name(), qname);

					
					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(setServiceCommand);
					compoundCommand.append(setPortCommand);
									
					domain.getCommandStack().execute(compoundCommand);
				}
			}
					
			viewer.refresh();
		}

	}
	
	private Composite createSection(Composite parent, String title, String desc, int numColumns) {

		Section section = null;
		if (desc != null) {
			section = toolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
			section.setDescription(desc);
		} else {
			section = toolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		}
		section.setText(title);
		
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.numColumns = numColumns;
		client.setLayout(layout);
		section.setClient(client);
		
		return client;
	}

	private void createProcessMonitoringSection(Composite parent) {
		final Composite client = createSection(parent, "Process-level Monitoring Events", null, 2);
		final Composite group = toolkit.createComposite(client);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		GridData gd = new GridData();
		gd.verticalAlignment = SWT.BEGINNING;
		gd.horizontalIndent = 5;
		group.setLayoutData(gd);

		final Button btnNone = toolkit.createButton(group, "None", SWT.RADIO);
		final Button btnAll = toolkit.createButton(group, "All", SWT.RADIO); 
		final Button btnSelected = toolkit.createButton(group, "Selected", SWT.RADIO);

		Composite wrapper = toolkit.createComposite(client);
		wrapper.setLayout(new RowLayout());
		final CheckboxTableViewer ctv = CheckboxTableViewer.newCheckList(wrapper, SWT.NONE);
		wrapper.setLayoutData(gd);
		toolkit.paintBordersFor(wrapper);
		
		ctv.setContentProvider(new ArrayContentProvider());
		ctv.setLabelProvider(new LabelProvider() {
		
			@Override
			public String getText(Object element) {
				return eventNameById.get(element);
			}
		
		});
		ctv.setInput(new String[] {INSTANCE_LIFECYCLE_NAME, ACTIVITY_LIFECYCLE_NAME, 
	    		DATA_HANDLING_NAME, SCOPE_HANDLING_NAME, CORRELATION_NAME});

		//create defaulting process event settings
		if (processType.getProcessEvents() == null) {
			TProcessEvents pe = ddFactory.eINSTANCE.createTProcessEvents();
			pe.setGenerate(GenerateType.ALL);
			processType.setProcessEvents(pe);
		}

		if (processType.getProcessEvents().isSetGenerate()) {
			switch (processType.getProcessEvents().getGenerate()) {
			case ALL:
				btnAll.setSelection(true);
				ctv.getControl().setEnabled(false);
				break;
			case NONE:
				btnNone.setSelection(true);
				ctv.getControl().setEnabled(false);
				break;
			}
		} else {
			btnSelected.setSelection(true);
			ctv.getControl().setEnabled(true);
		}
		
		final SelectionAdapter sa = new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnAll == e.getSource()) {
					ctv.getControl().setEnabled(false);
					Command command = SetCommand.create(domain, processType.getProcessEvents(), ddPackage.eINSTANCE.getTProcessEvents_Generate(), GenerateType.ALL);
					domain.getCommandStack().execute(command);
				} else if (btnNone == e.getSource()) {
					ctv.getControl().setEnabled(false);
					Command command = SetCommand.create(domain, processType.getProcessEvents(), ddPackage.eINSTANCE.getTProcessEvents_Generate(), GenerateType.NONE);
					domain.getCommandStack().execute(command);
				} else {
					ctv.getControl().setEnabled(true);
					Command command = SetCommand.create(domain, processType.getProcessEvents(), ddPackage.eINSTANCE.getTProcessEvents_Generate(), SetCommand.UNSET_VALUE);
					domain.getCommandStack().execute(command);
				}
			}
		};

		btnAll.addSelectionListener(sa);
		btnNone.addSelectionListener(sa);
		btnSelected.addSelectionListener(sa);

		ctv.setCheckedElements(processType.getProcessEvents().getEnableEvent().toArray());
		final ISelectionChangedListener scl = new ISelectionChangedListener() {
		
			public void selectionChanged(SelectionChangedEvent event) {
				Command command = SetCommand.create(domain, processType.getProcessEvents(), ddPackage.eINSTANCE.getTEnableEventList_EnableEvent(), Arrays.asList(ctv.getCheckedElements()));
				domain.getCommandStack().execute(command);
			}
		
		};
		
		ctv.addSelectionChangedListener(scl);
	}
	
	@SuppressWarnings("deprecation")
	private void createScopeMonitoringSection(Composite parent) {
		Composite client = createSection(parent, "Scope-level Monitoring Events", null, 1);
		
		scopeTableViewer = new TableViewer(toolkit.createTable(client, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
				SWT.FULL_SELECTION | SWT.HIDE_SELECTION));
		Table table = scopeTableViewer.getTable();
		scopeTableViewer.setContentProvider(new ScopeMonitoringEventContentProvider());
		scopeTableViewer.setUseHashlookup(true);
		TableViewerColumn column = new TableViewerColumn(scopeTableViewer, SWT.NONE);
		column.getColumn().setText("Scope");
		column.setLabelProvider(new ColumnLabelProvider() {
		
			@Override
			public String getText(Object element) {
				return ((Scope)element).getName();
			}

			@Override
			public Image getImage(Object element) {
				return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_SCOPE_16);
			}
		});
		
		String[] columns = new String[] {INSTANCE_LIFECYCLE_NAME, ACTIVITY_LIFECYCLE_NAME, DATA_HANDLING_NAME, SCOPE_HANDLING_NAME, CORRELATION_NAME};
		for (String columnId : columns) {
			column = new TableViewerColumn(scopeTableViewer, SWT.NONE);
			column.getColumn().setText(eventNameById.get(columnId));
			column.setLabelProvider(new ScopeEventCheckboxColumnLabelProvider(columnId));
			column.setEditingSupport(new ScopeEventEditingSupport(scopeTableViewer, columnId));
		}		

		OwnerDrawLabelProvider.setUpOwnerDraw(scopeTableViewer);

		table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    scopeTableViewer.setInput(processType);
	    
	    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
		      table.getColumn(i).pack();
		}
	}
	
	class PortTypeLabelProvider extends LabelProvider implements ITableLabelProvider {
		
		protected IProject bpelProject = null; 
		protected ResourceSetImpl resourceSet = null;
		
		public PortTypeLabelProvider(IProject bpelProject, ResourceSetImpl resourceSet){
			this.bpelProject = bpelProject;
			// Bugzilla 324164
			// ProcessPage allocates the resourceSet - this should never be null!
			if (resourceSet != null) {
			this.resourceSet = resourceSet;
			}
			else {
				this.resourceSet = new ResourceSetImpl();
			}
		}
		
		public String getColumnText(Object obj, int index) {
			
			if (obj instanceof TProvide && index == PARTNER_LINK_COLUMN){
				TProvide current = (TProvide) obj;
				return current.getPartnerLink();
			}
			else if (obj instanceof TProvide && index == SERVICE_COLUMN){
				TProvide current = (TProvide) obj;
				TService service = current.getService();	
				if (service != null) {
					QName serviceQName = service.getName();
					if (serviceQName != null) {
						return serviceQName.toString();
					}
				}
			}
			else if (obj instanceof TProvide && index == PORT_COLUMN){
				TProvide current = (TProvide) obj;
				TService service = current.getService();	
				if (service != null) {	
					String portName = service.getPort();
					if (portName != null) {
						return portName;
					}
				}
			}
			else if (obj instanceof TProvide && index == BINDING_COLUMN){
				TProvide current = (TProvide) obj;
				TService service = current.getService();	
				if (service != null) {	
					String portName = service.getPort();
					if (portName != null) {
						Port port = DeployUtils.findPortByName(portName, this.bpelProject, this.resourceSet);
						if (port != null) {
							Binding binding = port.getBinding();
							QName bindingQName = binding.getQName();
							if (bindingQName != null) {
								return bindingQName.getLocalPart();
							}
						}
					}
				}
			}			
			
			if (obj instanceof TInvoke && index == PARTNER_LINK_COLUMN){
				TInvoke current = (TInvoke) obj;
				return current.getPartnerLink();
			}
			else if (obj instanceof TInvoke && index == SERVICE_COLUMN){
				TInvoke current = (TInvoke) obj;
				TService service = current.getService();
				if (service != null) {
					QName serviceQName = service.getName();
					if (serviceQName != null) {
						return serviceQName.toString();
					}
				}
			}
			else if (obj instanceof TInvoke && index == PORT_COLUMN){
				TInvoke current = (TInvoke) obj;
				TService service = current.getService();	
				if (service != null) {
					String portName = service.getPort();
					if (portName != null) {
						return portName;
					}
				}
			}
			else if (obj instanceof TInvoke && index == BINDING_COLUMN){
				TInvoke current = (TInvoke) obj;
				TService service = current.getService();	
				if (service != null) {
					String portName = service.getPort();
					if (portName != null) {
						Port port = DeployUtils.findPortByName(portName, this.bpelProject, this.resourceSet);
						if (port != null) {
							Binding binding = port.getBinding();
							QName bindingQName = binding.getQName();
							if (bindingQName != null) {
								return bindingQName.getLocalPart();
							}
						}
					}
				}
			}
			
			return DeployUtils.NONE_STRING;
		}

		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}
	
	class PortTypeContentProvider implements IStructuredContentProvider {
		
		protected boolean forInbound = false;
		
		public PortTypeContentProvider(boolean bForInbound){
			forInbound = bForInbound;
		}
		
		public Object[] getElements(Object inputElement) {
			
			// Bugzilla 320545:
			try
			{
				if (inputElement instanceof ProcessType){
					ProcessType type  = (ProcessType) inputElement;
					if (forInbound){
						EList<TProvide> provide = type.getProvide();
					
						if (provide.isEmpty()){
							Process process = type.getModel();
							PartnerLinks pls = process.getPartnerLinks();
							EList<PartnerLink> plList = pls.getChildren();
							for (Iterator<PartnerLink> iterator = plList.iterator(); iterator.hasNext();) {
								PartnerLink current = (PartnerLink) iterator.next();
								if (current.getMyRole() != null){
									TProvide currentProvide = ddFactory.eINSTANCE.createTProvide();
									currentProvide.setPartnerLink(current.getName());
									provide.add(currentProvide);
								}	
							}
						}
					
						return provide.toArray();
					}
					else {
						EList<TInvoke> invoke = type.getInvoke();
					
						if (invoke.isEmpty()){
							Process process = type.getModel();
							PartnerLinks pls = process.getPartnerLinks();
							if (pls != null) {
								EList<PartnerLink> plList = pls.getChildren();
								for (Iterator<PartnerLink> iterator = plList.iterator(); iterator
										.hasNext();) {
									PartnerLink current = (PartnerLink) iterator
											.next();
									if (current.getPartnerRole() != null) {
										TInvoke currentInvoke = ddFactory.eINSTANCE
												.createTInvoke();
										currentInvoke.setPartnerLink(current
												.getName());
										invoke.add(currentInvoke);
									}
								}
							}
						}
					
						return invoke.toArray();
					}
				}
			}
			catch(NullPointerException ex)
			{
			}
			// Bugzilla 320545:
			// create a stub invoke so the editor doesn't crash
			return new TInvoke[] { ddFactory.eINSTANCE.createTInvoke() };
		}
		
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	class ScopeMonitoringEventContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			final List<Object> scopes = new ArrayList<Object>(); 

			BPELUtil.visitModelDepthFirst(processType.getModel(), new IModelVisitor() {
				public boolean visit(Object modelObject) {
					if ((modelObject instanceof Scope) && 
							(((Scope)modelObject).getName() != null)) {
						scopes.add(modelObject);
					}
					return true;
				}
			});

			return scopes.toArray();
		}

		public void dispose() {}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
		
	}

	protected void refreshModel() {
		
		try {
			editor.populateModel();
			scopeTableViewer.refresh();
			mainform.setMessage(null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void resourceChanged(IResourceChangeEvent event) {

		IResourceDeltaVisitor rdv = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) {
				IResource res = delta.getResource();
				// Bugzilla 320545:
				if (DeployUtils.isBPELFile(res)) {
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							mainform.setMessage(ODEDeployUIMessages.ProcessPage_UpdateWarning_Message, IMessageProvider.WARNING);
						}
					});
				}
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330394
				// close editor when file is deleted
				else {
					IFile editorFile = ((IFileEditorInput)getEditorInput()).getFile();
					IResource target = delta.getResource();
					if (delta.getKind() == IResourceDelta.REMOVED &&
							target instanceof IFile &&
							editorFile.equals(target))
					{
						// Close the editor if its input file has been moved or deleted.
						Display display = getSite().getShell().getDisplay();
						display.asyncExec(new Runnable() {
							public void run() {
								getSite().getPage().closeEditor(ProcessPage.this.editor, false);
							}
						});
					}
				}
				return true; // visit the children
			}
		};
		try {
			event.getDelta().accept(rdv);
		} catch (CoreException e) {
			//ignore
		}	
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}

	class ScopeEventEditingSupport extends EditingSupport {

		private String eventType;
		private CheckboxCellEditor checkboxCellEditor;
		public ScopeEventEditingSupport(TableViewer viewer, String eventType) {
			super(viewer);
			this.eventType = eventType;
			this.checkboxCellEditor = new CheckboxCellEditor(viewer.getTable());
		}
		
		@Override
		protected boolean canEdit(Object element) {
			String scName = ((Scope)element).getName();
			return scName != null && !"".equals(scName); //$NON-NLS-1$
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return checkboxCellEditor;
		}

		@Override
		protected Object getValue(Object element) {
			String scName = ((Scope)element).getName();
			for (TScopeEvents se : processType.getProcessEvents().getScopeEvents()) {
				if (scName.equals(se.getName()) &&
						se.getEnableEvent().contains(eventType)) {
					return true;
				}
			}
			return false;
		}

		@Override
		protected void setValue(Object element, Object value) {
			String scName = ((Scope)element).getName();
			TScopeEvents match = null;
			for (TScopeEvents se : processType.getProcessEvents().getScopeEvents()) {
				if (scName.equals(se.getName())) {
					match = se;
					break;
				}
			}
			
			if (match == null) {
				match = ddFactory.eINSTANCE.createTScopeEvents();
				match.setName(scName);
				processType.getProcessEvents().getScopeEvents().add(match);
			}
			
			if (((Boolean)value).booleanValue()) { 
				if (!match.getEnableEvent().contains(eventType)) {
					Command command = AddCommand.create(domain, match, ddPackage.eINSTANCE.getTEnableEventList_EnableEvent(), eventType);
					domain.getCommandStack().execute(command);
				}
			} else {
				Command command = RemoveCommand.create(domain, match, ddPackage.eINSTANCE.getTEnableEventList_EnableEvent(), eventType);
				domain.getCommandStack().execute(command);
			}
			
			getViewer().refresh();
		}
	}
	
	class ScopeEventCheckboxColumnLabelProvider extends OwnerDrawLabelProvider {
		
		private String eventType;

		public ScopeEventCheckboxColumnLabelProvider(String eventType) {
			this.eventType = eventType;
		}
		
		protected void measure(Event event, Object element) {
			Image img = getImage(element);
			event.setBounds(new Rectangle(event.x, event.y, img.getBounds().width,
					img.getBounds().height));

		}

		protected void paint(Event event, Object element) {

			Image img = getImage(element);

			if (img != null) {
				Rectangle bounds = ((TableItem) event.item)
						.getBounds(event.index);
				Rectangle imgBounds = img.getBounds();
				bounds.width /= 2;
				bounds.width -= imgBounds.width / 2;
				bounds.height /= 2;
				bounds.height -= imgBounds.height / 2;

				int x = bounds.width > 0 ? bounds.x + bounds.width : bounds.x;
				int y = bounds.height > 0 ? bounds.y + bounds.height : bounds.y;

				event.gc.drawImage(img, x, y);
			}
		}


		public Image getImage(Object element) {
			if (isChecked(element)) {
				return Activator.getDefault().getImageRegistry().get(Activator.IMG_CHECKED);
			} else {
				return Activator.getDefault().getImageRegistry().get(Activator.IMG_UNCHECKED);
			}
		}

		public boolean isChecked(Object element) {
			String scName = ((Scope)element).getName();
			for (TScopeEvents se : processType.getProcessEvents().getScopeEvents()) {
				if (se.getName().equals(scName) &&
						se.getEnableEvent().contains(eventType)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	
}