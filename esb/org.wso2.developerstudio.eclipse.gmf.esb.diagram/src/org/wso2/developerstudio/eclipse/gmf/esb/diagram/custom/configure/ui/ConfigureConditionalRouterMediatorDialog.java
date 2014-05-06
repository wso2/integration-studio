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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.RegistryKeyPropertyUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

/**
 *  Configuration dialog for conditional router mediator routes
 */
public class ConfigureConditionalRouterMediatorDialog extends Dialog {
	private Table tblRoutes;
	private Text txtEvaluatorExpression;
	private Text txtTargetSequence;
	private Button cmdSetTargetSequence;
	private Button cmdSetEvaluatorExpression;
	private Label lblTargetSequence;
	private Label lblEvaluatorExpression;
	private Composite comConfig;
	private Button cmdRouteRemove;
	private Button cmdSetBreakAfterRoute;
	
	private boolean updateLock=false;
	
	
	/**
	 * Conditional Router Mediator
	 */
	ConditionalRouterMediator conditionalRouter;
	
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
	public ConfigureConditionalRouterMediatorDialog(Shell parentShell,
			ConditionalRouterMediator router, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.conditionalRouter = router;
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
		
		Label lblRoutes = new Label(container, SWT.NONE);
		FormData fd_lblRoutes = new FormData();
		fd_lblRoutes.right = new FormAttachment(0, 138);
		fd_lblRoutes.top = new FormAttachment(0, 10);
		fd_lblRoutes.left = new FormAttachment(0, 10);
		lblRoutes.setLayoutData(fd_lblRoutes);
		lblRoutes.setText("Conditional Routes");
		
		tblRoutes = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_tblRoutes = new FormData();
		fd_tblRoutes.top = new FormAttachment(lblRoutes, 9);
		fd_tblRoutes.left = new FormAttachment(0, 10);
		tblRoutes.setLayoutData(fd_tblRoutes);
		tblRoutes.setHeaderVisible(true);
		tblRoutes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateSelection();
			}
		});
		
		TableColumn tblclmnRoutes = new TableColumn(tblRoutes, SWT.NONE);
		tblclmnRoutes.setWidth(315);
		tblclmnRoutes.setText("Routes");
		
		
		Button cmdRouteAdd = new Button(container, SWT.NONE);
		fd_tblRoutes.right = new FormAttachment(cmdRouteAdd, -6);
		FormData fd_cmdRouteAdd = new FormData();
		fd_cmdRouteAdd.top = new FormAttachment(0, 36);
		fd_cmdRouteAdd.left = new FormAttachment(0, 334);
		cmdRouteAdd.setLayoutData(fd_cmdRouteAdd);
		cmdRouteAdd.setText("Add");
		cmdRouteAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConditionalRouteBranch conditionalRouteBranch = EsbFactory.eINSTANCE.createConditionalRouteBranch();
				RouteWrapper wrapper = new RouteWrapper(conditionalRouteBranch);
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
					updateSelection();
				}
			}
		});
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_tblRoutes.bottom = new FormAttachment(label, -6);
		fd_cmdRouteAdd.right = new FormAttachment(label, 0, SWT.RIGHT);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(0, 175);
		fd_label.right = new FormAttachment(100, -22);
		fd_label.left = new FormAttachment(0, 10);
		label.setLayoutData(fd_label);
		
		comConfig = new Composite(container, SWT.NONE);
		FormData fd_comConfig = new FormData();
		fd_comConfig.bottom = new FormAttachment(100, -10);
		fd_comConfig.left = new FormAttachment(0, 11);
		fd_comConfig.right = new FormAttachment(100, -22);
		fd_comConfig.top = new FormAttachment(0, 177);
		comConfig.setLayoutData(fd_comConfig);
		comConfig.setLayout(new GridLayout(3, false));
		
		lblEvaluatorExpression = new Label(comConfig, SWT.NONE);
		lblEvaluatorExpression.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblEvaluatorExpression.setText("Evaluator expression");
		
		
		txtEvaluatorExpression = new Text(comConfig, SWT.BORDER | SWT.MULTI);
		GridData gd_txtEvaluatorExpression = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_txtEvaluatorExpression.widthHint = 397;
		gd_txtEvaluatorExpression.heightHint = 126;
		txtEvaluatorExpression.setLayoutData(gd_txtEvaluatorExpression);
		txtEvaluatorExpression.setEditable(false);
		
		cmdSetEvaluatorExpression = new Button(comConfig, SWT.NONE);
		cmdSetEvaluatorExpression.setText("..");
		cmdSetEvaluatorExpression.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		cmdSetEvaluatorExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tblRoutes.getSelectionIndex() != -1) {
					TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
					RouteWrapper wrapper = (RouteWrapper) item.getData();
					EvaluatorExpressionProperty evaluatorExpression = EsbFactory.eINSTANCE
							.copyEvaluatorExpressionProperty(wrapper.getEvaluatorExpression());
					EvaluatorExpressionEditorDialog dialog = new EvaluatorExpressionEditorDialog(
							getShell(), evaluatorExpression);
					dialog.create();
					dialog.getShell().setText("Evaluator Expression Editor");
					dialog.open();

					if (dialog.getReturnCode() == Window.OK) {
						wrapper.setEvaluatorExpression(evaluatorExpression);
						txtEvaluatorExpression.setText(evaluatorExpression.getEvaluatorValue());
						item.setText("Route ["
								+ evaluatorExpression.getEvaluatorValue().replaceAll(
										System.getProperty("line.separator", "\n"), "") + "]");
					}
				}
				super.widgetSelected(e);
			}
		});
		
		cmdSetBreakAfterRoute = new Button(comConfig, SWT.CHECK);
		cmdSetBreakAfterRoute.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		cmdSetBreakAfterRoute.setText("Break after route");
		cmdSetBreakAfterRoute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(tblRoutes.getSelectionIndex()!=-1){
					TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
					RouteWrapper wrapper = (RouteWrapper)item.getData();
					
					if (!updateLock) {
						updateLock=true;
						wrapper.setBreakAfterRoute(cmdSetBreakAfterRoute.getSelection());
						updateLock=false;
					}
				}
				super.widgetSelected(e);
			}
		});
		
		lblTargetSequence = new Label(comConfig, SWT.NONE);
		lblTargetSequence.setText("Target sequence");
		
		txtTargetSequence = new Text(comConfig, SWT.BORDER | SWT.READ_ONLY);
		txtTargetSequence.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtTargetSequence.setEditable(false);
		
		cmdSetTargetSequence = new Button(comConfig, SWT.NONE);
		cmdSetTargetSequence.setText("..");
		cmdSetTargetSequence.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(tblRoutes.getSelectionIndex()!=-1){
					TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
					RouteWrapper wrapper = (RouteWrapper)item.getData();
					RegistryKeyProperty sequenceKey = EsbFactory.eINSTANCE.copyRegistryKeyProperty(wrapper.getTargetSequence()) ;
					RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(getShell(),
							SWT.TITLE, sequenceKey, RegistryKeyPropertyUtil.findLocalNamedEntities(wrapper.getConditionalRoute()));
					dialog.create();
					dialog.getShell().setSize(520,180);
					dialog.getShell().setText("Resource Key Editor");
					dialog.open();
					if (dialog.getReturnCode()==Window.OK) {
						wrapper.setTargetSequence(sequenceKey);
						txtTargetSequence.setText(wrapper.getTargetSequence().getKeyValue());
					}
				}				
				super.widgetSelected(e);
			}
		});
		comConfig.setEnabled(false);
		
		populateRoutes();

		return container;
	}

	private void populateRoutes(){
		EList<ConditionalRouteBranch> conditionalRouteBranches = conditionalRouter.getConditionalRouteBranches();
		for (ConditionalRouteBranch routeBranch : conditionalRouteBranches) {
			RouteWrapper wrapper = new RouteWrapper(routeBranch);
			bindRoute(wrapper);
		}
	}
	
	private TableItem bindRoute(RouteWrapper wrapper) {
		TableItem item = new TableItem(tblRoutes, SWT.NONE);
		item.setText("Route");
		item.setImage(SWTResourceManager
		.getImage(this.getClass(), "/icons/custom/12px/conditional-router.png"));
		ConditionalRouteBranch conditionalRoute = wrapper.getConditionalRoute();
		wrapper.setBreakAfterRoute(conditionalRoute.isBreakAfterRoute());
		wrapper.setEvaluatorExpression(EsbFactory.eINSTANCE.copyEvaluatorExpressionProperty(conditionalRoute.getEvaluatorExpression()));
		wrapper.setTargetSequence(EsbFactory.eINSTANCE.copyRegistryKeyProperty(conditionalRoute.getTargetSequence()));
		item.setText("Route [" + wrapper.getEvaluatorExpression().getEvaluatorValue().replaceAll(
				System.getProperty("line.separator", "\n"), "") + "]");
		item.setData(wrapper);
		return item;
	}
	
	private void unbindRoute(int itemIndex) {
		TableItem item = tblRoutes.getItem(itemIndex);
		RouteWrapper wrapper = (RouteWrapper) item.getData();
		ConditionalRouteBranch conditionalRoute = wrapper.getConditionalRoute();
		if (null != conditionalRoute.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					conditionalRouter, EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES,
					conditionalRoute);
			getResultCommand().append(removeCmd);
		}
		tblRoutes.remove(tblRoutes.indexOf(item));
	}
	
	
	@Override
	protected void okPressed() {
		for (TableItem item : tblRoutes.getItems()) {
			RouteWrapper wrapper = (RouteWrapper) item.getData();
			ConditionalRouteBranch conditionalRoute = wrapper.getConditionalRoute();
			
			// If the route is a new one, add it to the model.
			if (null == conditionalRoute.eContainer()) {
				AddCommand addCmd = new AddCommand(editingDomain,
						conditionalRouter,
						EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES,
						conditionalRoute);
				getResultCommand().append(addCmd);
			}
			
			SetCommand setCmd = null;
			
			if (!conditionalRoute.getEvaluatorExpression().equals(wrapper.getEvaluatorExpression())) {
				setCmd = new SetCommand(
						editingDomain,
						conditionalRoute,
						EsbPackage.Literals.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION,
						wrapper.getEvaluatorExpression());
				getResultCommand().append(setCmd);
			}
			
			if(conditionalRoute.isBreakAfterRoute()!=wrapper.isBreakAfterRoute()){
				setCmd = new SetCommand(
						editingDomain,
						conditionalRoute,
						EsbPackage.Literals.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE,
						wrapper.isBreakAfterRoute());
				getResultCommand().append(setCmd);
			}
			
			if (!conditionalRoute.getTargetSequence().equals(wrapper.getTargetSequence())) {
				setCmd = new SetCommand(
						editingDomain,
						conditionalRoute,
						EsbPackage.Literals.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE,
						wrapper.getTargetSequence());
				getResultCommand().append(setCmd);
			}
			
		}
		
		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} 
		super.okPressed();
	}

	protected void updateSelection() {
		if(tblRoutes.getSelectionIndex()==-1){

			txtEvaluatorExpression.setText("");
			comConfig.setEnabled(false);
			cmdRouteRemove.setEnabled(false);
		} else{
			comConfig.setEnabled(true);
			cmdRouteRemove.setEnabled(true);
			
			if (!updateLock) {
				updateLock=true;
				TableItem item = tblRoutes.getItem(tblRoutes.getSelectionIndex());
				RouteWrapper wrapper = (RouteWrapper) item.getData();
				txtEvaluatorExpression.setText(wrapper.getEvaluatorExpression().getEvaluatorValue());
				cmdSetBreakAfterRoute.setSelection(wrapper.isBreakAfterRoute());
				txtTargetSequence.setText(wrapper.getTargetSequence().getKeyValue());
				updateLock=false;
			}
		}
		
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

		newShell.setText("Conditional Router Mediator Configuration");
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
		
		public RouteWrapper(ConditionalRouteBranch conditionalRoute){
			this.setConditionalRoute(conditionalRoute);
		}

		public void setBreakAfterRoute(boolean breakAfterRoute) {
			this.breakAfterRoute = breakAfterRoute;
		}
		public boolean isBreakAfterRoute() {
			return breakAfterRoute;
		}

		public void setEvaluatorExpression(EvaluatorExpressionProperty evaluatorExpression) {
			this.evaluatorExpression = evaluatorExpression;
		}

		public EvaluatorExpressionProperty getEvaluatorExpression() {
			return evaluatorExpression;
		}

		public void setConditionalRoute(ConditionalRouteBranch conditionalRoute) {
			this.conditionalRoute = conditionalRoute;
		}

		public ConditionalRouteBranch getConditionalRoute() {
			return conditionalRoute;
		}

		public void setTargetSequence(RegistryKeyProperty targetSequence) {
			this.targetSequence = targetSequence;
		}

		public RegistryKeyProperty getTargetSequence() {
			return targetSequence;
		}

		private boolean breakAfterRoute;
		private EvaluatorExpressionProperty evaluatorExpression;
		private RegistryKeyProperty targetSequence;
		private ConditionalRouteBranch conditionalRoute;
		
	}
}
