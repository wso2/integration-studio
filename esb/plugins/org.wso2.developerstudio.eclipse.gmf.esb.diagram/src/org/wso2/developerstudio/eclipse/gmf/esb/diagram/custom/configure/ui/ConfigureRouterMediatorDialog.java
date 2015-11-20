/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.RegistryKeyPropertyUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

/*
 *  Configuration dialog for router mediator routes
 */
public class ConfigureRouterMediatorDialog extends Dialog {
	/**
	 * UI variables 
	 */
	private Table tblRoutes;
	private Text txtRouteExpression;
	private Text txtRoutePattern;
	private Text txtSequenceKey;
	private Text txtEndpointKey;
	private Label lblEndpointKey;
	private Composite comConfig;
	private Button cmdSetBreakAfterRoute;
	private Button cmdSetEndpointKey;
	private Combo cmbSequenceType;
	private Combo cmbEndpointType;
	private Label lblSequenceKey;
	private Button cmdSetSequenceKey;
	private Button cmdRouteAdd;
	private Button cmdRouteRemove;
	private Listener updateListener;
	
	private boolean updateLock=false;
	
	private final static String CMB_CAPTION_REGISTRY_REFERENCE = "From Registry";
	private final static String CMB_CAPTION_ANONYMOUS = "Anonymous";
	private final static String CMB_CAPTION_NONE = "None";

	
	/**
	 * Router Mediator eclass
	 */
	RouterMediator routerMediator;
	
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ConfigureRouterMediatorDialog(Shell parentShell,
			RouterMediator routerMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.routerMediator = routerMediator;
		this.editingDomain = editingDomain;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());
		
		updateListener = new Listener() {
			
			public void handleEvent(Event e) {
				if(tblRoutes.getSelectionIndex()!=-1){
					TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
					RouteWrapper wrapper = (RouteWrapper)item.getData();
					
					if (!updateLock) {
						updateLock=true;
						wrapper.setBreakAfterRoute(cmdSetBreakAfterRoute.getSelection());
						wrapper.setRoutePattern(txtRoutePattern.getText());
						wrapper.setDynamicSequence(CMB_CAPTION_REGISTRY_REFERENCE.equals(cmbSequenceType.getText()));
						updateLock=false;
					}
		
				}
			}
		};
		
		Label lblRouters = new Label(container, SWT.NONE);
		FormData fd_lblRouters = new FormData();
		fd_lblRouters.right = new FormAttachment(0, 75);
		fd_lblRouters.top = new FormAttachment(0, 10);
		fd_lblRouters.left = new FormAttachment(0, 10);
		lblRouters.setLayoutData(fd_lblRouters);
		lblRouters.setText("Routes");
		
		tblRoutes = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_tblRouters = new FormData();
		fd_tblRouters.top = new FormAttachment(lblRouters, 9);
		fd_tblRouters.left = new FormAttachment(0, 10);
		fd_tblRouters.bottom = new FormAttachment(0, 169);
		tblRoutes.setHeaderVisible(true);
		
		tblRoutes.setLayoutData(fd_tblRouters);
		tblRoutes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateSelection();
			}
		});
		
		TableColumn tblclmnRoutes = new TableColumn(tblRoutes, SWT.NONE);
		tblclmnRoutes.setWidth(315);
		tblclmnRoutes.setText("Routes");
		
		cmdRouteAdd = new Button(container, SWT.NONE);
		FormData fd_cmdRouteAdd = new FormData();
		fd_tblRouters.right = new FormAttachment(cmdRouteAdd, -6);
		
		fd_cmdRouteAdd.top = new FormAttachment(0, 36);
		fd_cmdRouteAdd.left = new FormAttachment(0, 334);
		cmdRouteAdd.setLayoutData(fd_cmdRouteAdd);
		cmdRouteAdd.setText("Add");
		cmdRouteAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RouterTargetContainer routerTargetContainer = EsbFactory.eINSTANCE.createRouterTargetContainer();
				RouteWrapper wrapper = new RouteWrapper(routerTargetContainer);
				TableItem item = bindRoute(wrapper);
				tblRoutes.select(tblRoutes.indexOf(item));
				updateSelection();
			}
		});
		
		cmdRouteRemove = new Button(container, SWT.NONE);
		FormData fd_cmdRouteRemove = new FormData();
		fd_cmdRouteRemove.top = new FormAttachment(cmdRouteAdd, 6);
		fd_cmdRouteRemove.right = new FormAttachment(cmdRouteAdd, 0, SWT.RIGHT);
		fd_cmdRouteRemove.left = new FormAttachment(0, 334);
		cmdRouteRemove.setLayoutData(fd_cmdRouteRemove);
		cmdRouteRemove.setText("Remove");
		cmdRouteRemove.setEnabled(false);
		cmdRouteRemove.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblRoutes.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindRoute(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex < tblRoutes.getItemCount()) {
						tblRoutes.select(selectedIndex);
					} else {
						tblRoutes.select(selectedIndex - 1);
					}
				}
			}
		});
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_cmdRouteAdd.right = new FormAttachment(label, 0, SWT.RIGHT);
		FormData fd_label = new FormData();
		fd_label.right = new FormAttachment(100, -22);
		fd_label.left = new FormAttachment(0, 10);
		fd_label.top = new FormAttachment(tblRoutes, 6);
		label.setLayoutData(fd_label);
		
		comConfig = new Composite(container, SWT.NONE);
		FormData fd_comConfig = new FormData();
		fd_comConfig.bottom = new FormAttachment(100, -10);
		fd_comConfig.left = new FormAttachment(0, 11);
		fd_comConfig.right = new FormAttachment(100, -22);
		fd_comConfig.top = new FormAttachment(0, 177);
		comConfig.setLayoutData(fd_comConfig);
		comConfig.setLayout(new GridLayout(3, false));
		comConfig.setEnabled(false);
		
		cmdSetBreakAfterRoute = new Button(comConfig, SWT.CHECK);
		cmdSetBreakAfterRoute.setText("Break After Route");
		cmdSetBreakAfterRoute.addListener(SWT.Selection, updateListener);
		new Label(comConfig, SWT.NONE);
		new Label(comConfig, SWT.NONE);
		
		Label lblRouteExpression = new Label(comConfig, SWT.NONE);
		lblRouteExpression.setText("Route expression");
		
		txtRouteExpression = new Text(comConfig, SWT.BORDER);
		txtRouteExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtRouteExpression.addListener(SWT.Modify, updateListener);
		txtRouteExpression.setEditable(false);
		
		Button cmdSetRouteExpression = new Button(comConfig, SWT.NONE);
		cmdSetRouteExpression.setText("..");
		cmdSetRouteExpression.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if(tblRoutes.getSelectionIndex()!=-1){
					TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
					RouteWrapper wrapper = (RouteWrapper)item.getData();
					NamespacedProperty routeExpression = EsbFactory.eINSTANCE.copyNamespacedProperty(wrapper.getRouteExpression());
					NamespacedPropertyEditorDialog propertyEditor = new NamespacedPropertyEditorDialog(getShell(), routeExpression);
					propertyEditor.open();
					wrapper.setRouteExpression(routeExpression);
					txtRouteExpression.setText(routeExpression.getPropertyValue());
				}
				
				super.widgetSelected(e);
			}
		});
		
		Label lblRoutePattern = new Label(comConfig, SWT.NONE);
		lblRoutePattern.setText("Route pattern");
		
		txtRoutePattern = new Text(comConfig, SWT.BORDER);
		txtRoutePattern.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtRoutePattern.addListener(SWT.Modify,updateListener);
		new Label(comConfig, SWT.NONE);
		
		Label lblSequenceType = new Label(comConfig, SWT.NONE);
		lblSequenceType.setText("Sequence type");
		
		cmbSequenceType = new Combo(comConfig, SWT.READ_ONLY);
		cmbSequenceType.setItems(new String[] {CMB_CAPTION_ANONYMOUS, CMB_CAPTION_REGISTRY_REFERENCE});
		cmbSequenceType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cmbSequenceType.select(0); 
		cmbSequenceType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(tblRoutes.getSelectionIndex()!=-1){
				TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
				RouteWrapper wrapper = (RouteWrapper)item.getData();
				if(cmbSequenceType.getSelectionIndex()==1){
					lblSequenceKey.setEnabled(true);
					txtSequenceKey.setEnabled(true);
					cmdSetSequenceKey.setEnabled(true);
					wrapper.setDynamicSequence(true);
				} else{
					lblSequenceKey.setEnabled(false);
					txtSequenceKey.setEnabled(false);
					cmdSetSequenceKey.setEnabled(false);
					wrapper.setDynamicSequence(false);
				}
				}
				
			}
		});
		new Label(comConfig, SWT.NONE);
		
		lblSequenceKey = new Label(comConfig, SWT.NONE);
		lblSequenceKey.setText("Sequence key");
		lblSequenceKey.setEnabled(false);
		
		txtSequenceKey = new Text(comConfig, SWT.BORDER);
		txtSequenceKey.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtSequenceKey.setEnabled(false);
		txtSequenceKey.setEditable(false);
		
		cmdSetSequenceKey = new Button(comConfig, SWT.NONE);
		cmdSetSequenceKey.setText("..");
		cmdSetSequenceKey.setEnabled(false);
		cmdSetSequenceKey.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(tblRoutes.getSelectionIndex()!=-1){
					TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
					RouteWrapper wrapper = (RouteWrapper)item.getData();
					RegistryKeyProperty sequenceKey = EsbFactory.eINSTANCE.copyRegistryKeyProperty(wrapper.getSequenceKey()) ;
					RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(getShell(),
							SWT.TITLE, sequenceKey, RegistryKeyPropertyUtil.findLocalNamedEntities(wrapper.getContainer().getTarget()));
					dialog.create();
					dialog.getShell().setSize(520,180);
					dialog.getShell().setText("Resource Key Editor");
					dialog.open();
					
					if (dialog.getReturnCode()==Window.OK) {
						wrapper.setSequenceKey(sequenceKey);
						txtSequenceKey.setText(wrapper.getSequenceKey().getKeyValue());
					}

				}				
				super.widgetSelected(e);
			}
		});
		
		Label lblEndpointType = new Label(comConfig, SWT.NONE);
		lblEndpointType.setText("Endpoint type");
		
		cmbEndpointType = new Combo(comConfig, SWT.READ_ONLY);
		cmbEndpointType.setItems(new String[] {CMB_CAPTION_NONE, CMB_CAPTION_ANONYMOUS, CMB_CAPTION_REGISTRY_REFERENCE});
		cmbEndpointType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cmbEndpointType.select(0);
		cmbEndpointType.setEnabled(false); //TODO: implement endpoint support
		cmbEndpointType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(cmbEndpointType.getSelectionIndex()==2){
					lblEndpointKey.setEnabled(true);
					txtEndpointKey.setEnabled(true);
					cmdSetEndpointKey.setEnabled(true);
				} else{
					lblEndpointKey.setEnabled(false);
					txtEndpointKey.setEnabled(false);
					cmdSetEndpointKey.setEnabled(false);
				}
			}
		});
		new Label(comConfig, SWT.NONE);
		
		lblEndpointKey = new Label(comConfig, SWT.NONE);
		lblEndpointKey.setText("Endpoint key");
		lblEndpointKey.setEnabled(false);
		
		txtEndpointKey = new Text(comConfig, SWT.BORDER);
		txtEndpointKey.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtEndpointKey.setEnabled(false);
		
		cmdSetEndpointKey = new Button(comConfig, SWT.NONE);
		cmdSetEndpointKey.setText("..");
		cmdSetEndpointKey.setEnabled(false);
		
		populateRoutes();
		

		return container;
	}
	
	private void updateSelection(){
		if(tblRoutes.getSelectionIndex()==-1){
			comConfig.setEnabled(false);
			cmdRouteRemove.setEnabled(false);
		} else{
			comConfig.setEnabled(true);
			cmdRouteRemove.setEnabled(true);
			
			if (!updateLock) {
				updateLock=true;
				TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
				RouteWrapper wrapper = (RouteWrapper) item.getData();
				txtRouteExpression.setText(wrapper.getRouteExpression().getPropertyValue());
				cmdSetBreakAfterRoute.setSelection(wrapper.isBreakAfterRoute());
				txtRoutePattern.setText(wrapper.getRoutePattern());
				txtSequenceKey.setText(wrapper.getContainer().getTarget().getSequenceKey().getKeyValue());
				if(wrapper.isDynamicSequence()){
					lblSequenceKey.setEnabled(true);
					txtSequenceKey.setEnabled(true);
					cmdSetSequenceKey.setEnabled(true);
					cmbSequenceType.select(1);
				} else{
					lblSequenceKey.setEnabled(false);
					txtSequenceKey.setEnabled(false);
					cmdSetSequenceKey.setEnabled(false);
					cmbSequenceType.select(0);
				}
				updateLock=false;
			}
		}
	}
	
	private void populateRoutes(){
		EList<RouterTargetContainer> routerTargets = routerMediator.getRouterContainer().getRouterTargetContainer();
		for (RouterTargetContainer routerTarget : routerTargets) {
			RouteWrapper wrapper = new RouteWrapper(routerTarget);
			bindRoute(wrapper);
		}
	}
	
	private TableItem bindRoute(RouteWrapper wrapper) {
		TableItem item = new TableItem(tblRoutes, SWT.NONE);
		item.setText("Route");
		item.setImage(SWTResourceManager
		.getImage(this.getClass(), "/icons/custom/12px/router.png"));
		RouterTargetContainer container = wrapper.getContainer();
		wrapper.setBreakAfterRoute(container.isBreakAfterRoute());
		wrapper.setRouteExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(container.getRouteExpression()));
		wrapper.setRoutePattern(container.getRoutePattern());
		wrapper.setSequenceKey(EsbFactory.eINSTANCE.copyRegistryKeyProperty(container.getTarget().getSequenceKey())); /* we read this even for anonymous sequence */
		wrapper.setDynamicSequence(container.getTarget().getSequenceType()==TargetSequenceType.REGISTRY_REFERENCE);
		/* TODO: wrapper.setEndpointKey() */
		item.setData(wrapper);
		return item;
	}
	
	private void unbindRoute(int itemIndex) {
		TableItem item = tblRoutes.getItem(itemIndex);
		RouteWrapper wrapper = (RouteWrapper) item.getData();
		RouterTargetContainer target = wrapper.getContainer();
		if (null != target.eContainer()) {
			int index = routerMediator.getRouterContainer().getRouterTargetContainer().indexOf(target);
			
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					routerMediator.getRouterContainer(), EsbPackage.Literals.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER,
					target);
			getResultCommand().append(removeCmd);
			
			if(index!=-1){
				removeCmd = new RemoveCommand(editingDomain, routerMediator,
						EsbPackage.Literals.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR,
						routerMediator.getTargetOutputConnector().get(index));
				getResultCommand().append(removeCmd);
			}

		}
		tblRoutes.remove(tblRoutes.indexOf(item));
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 504);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText("Router Mediator Configuration");
	}
	
	@Override
	protected void okPressed() {
		for (TableItem item : tblRoutes.getItems()) {
			RouteWrapper wrapper = (RouteWrapper) item.getData();
			RouterTargetContainer target = wrapper.getContainer();
			
			// If the route is a new one, add it to the model.
			if (null == target.eContainer()) {
				AddCommand addCmd = new AddCommand(editingDomain,
						routerMediator.getRouterContainer(),
						EsbPackage.Literals.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER,
						target);
				getResultCommand().append(addCmd);

				RouterMediatorTargetOutputConnector targetOutputConnector = EsbFactory.eINSTANCE
						.createRouterMediatorTargetOutputConnector();

				addCmd = new AddCommand(editingDomain, routerMediator,
						EsbPackage.Literals.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR,
						targetOutputConnector);

				getResultCommand().append(addCmd);
		
			} 
			SetCommand setCmd = null;
			
			if (!target.getRouteExpression().equals(wrapper.getRouteExpression())) {
				setCmd = new SetCommand(
						editingDomain,
						target,
						EsbPackage.Literals.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION,
						wrapper.getRouteExpression());
				getResultCommand().append(setCmd);
			}
			
			if(target.isBreakAfterRoute()!=wrapper.isBreakAfterRoute()){
				setCmd = new SetCommand(
						editingDomain,
						target,
						EsbPackage.Literals.ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE,
						wrapper.isBreakAfterRoute());
				getResultCommand().append(setCmd);
			}
			
			if(!target.getRoutePattern().equals(wrapper.getRoutePattern())){
				setCmd = new SetCommand(
						editingDomain,
						target,
						EsbPackage.Literals.ROUTER_TARGET_CONTAINER__ROUTE_PATTERN,
						wrapper.getRoutePattern());
				getResultCommand().append(setCmd);
			}
			
			if((target.getTarget().getSequenceType()==TargetSequenceType.REGISTRY_REFERENCE)!=wrapper.isDynamicSequence()){
				setCmd = new SetCommand(
						editingDomain,
						target.getTarget(),
						EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE,
						wrapper.isDynamicSequence()?TargetSequenceType.REGISTRY_REFERENCE:TargetSequenceType.ANONYMOUS );
				getResultCommand().append(setCmd);

			}
			
			if(wrapper.isDynamicSequence()){
				setCmd = new SetCommand(
						editingDomain,
						target.getTarget(),
						EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY,
						wrapper.getSequenceKey());
				getResultCommand().append(setCmd);
			} else{
				setCmd = new SetCommand(
						editingDomain,
						target.getTarget(),
						EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY,
						EsbFactory.eINSTANCE.createRegistryKeyProperty());
				getResultCommand().append(setCmd);
			}
			
			//TODO: Target endpoints
		}
		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} 
		
		super.okPressed();
	}
	
	/**
	 * Utility method for retrieving the result {@link CompoundCommand} which is
	 * used to record user operations.
	 * 
	 * @return result command.
	 */
	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
	
	
	class RouteWrapper{
		
		public RouteWrapper(RouterTargetContainer container){
			this.container = container;
		}
		public NamespacedProperty getRouteExpression() {
			return routeExpression;
		}
		public void setRouteExpression(NamespacedProperty routeExpression) {
			this.routeExpression = routeExpression;
		}
		public String getRoutePattern() {
			return routePattern;
		}
		public void setRoutePattern(String routePattern) {
			this.routePattern = routePattern;
		}
		public RegistryKeyProperty getSequenceKey() {
			return sequenceKey;
		}
		public void setSequenceKey(RegistryKeyProperty sequenceKey) {
			this.sequenceKey = sequenceKey;
		}
		public RegistryKeyProperty getEndpointKey() {
			return endpointKey;
		}
		public void setEndpointKey(RegistryKeyProperty endpointKey) {
			this.endpointKey = endpointKey;
		}
		public void setContainer(RouterTargetContainer container) {
			this.container = container;
		}
		public RouterTargetContainer getContainer() {
			return container;
		}
		public void setBreakAfterRoute(boolean breakAfterRoute) {
			this.breakAfterRoute = breakAfterRoute;
		}
		public boolean isBreakAfterRoute() {
			return breakAfterRoute;
		}

		public void setDynamicSequence(boolean dynamicSequence) {
			this.dynamicSequence = dynamicSequence;
		}
		public boolean isDynamicSequence() {
			return dynamicSequence;
		}

		public void setDynamicEndpoint(boolean dynamicEndpoint) {
			this.dynamicEndpoint = dynamicEndpoint;
		}
		public boolean isDynamicEndpoint() {
			return dynamicEndpoint;
		}

		private boolean breakAfterRoute;
		private NamespacedProperty routeExpression;
		private String routePattern;
		private RegistryKeyProperty sequenceKey;
		private boolean dynamicSequence;
		private RegistryKeyProperty endpointKey;
		private boolean dynamicEndpoint;
		private RouterTargetContainer container;
		
	}
	
	
}
