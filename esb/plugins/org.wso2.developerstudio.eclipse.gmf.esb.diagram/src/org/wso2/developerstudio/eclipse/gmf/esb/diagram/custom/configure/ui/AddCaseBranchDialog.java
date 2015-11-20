package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.SwitchMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;


public class AddCaseBranchDialog extends Dialog {

	private SwitchMediator switchMediator;
	private Label caseCount;
	private Text count;
	private EditPart editpart;
	private TransactionalEditingDomain editingDomain;
	private ArrayList<SwitchCaseContainer> caseBranches=new ArrayList<SwitchCaseContainer>();
	private ArrayList<SwitchCaseBranchOutputConnector> caseOutputConnectors=new ArrayList<SwitchCaseBranchOutputConnector>();



	public AddCaseBranchDialog(Shell parentShell, SwitchMediator switchMediator,
	                           TransactionalEditingDomain editingDomain, EditPart editpart) {
		super(parentShell);
		this.switchMediator=switchMediator;
		this.editpart=editpart;
		this.editingDomain=editingDomain;
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Add Case Branches.");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		caseCount = new Label(container, SWT.NONE);
		{
			caseCount.setText("Number of branches: ");
			FormData caseCountLabelLayoutData = new FormData();
			caseCountLabelLayoutData.top = new FormAttachment(0, 5);
			caseCountLabelLayoutData.left = new FormAttachment(0);
			caseCount.setLayoutData(caseCountLabelLayoutData);
		}

		count = new Text(container, SWT.NONE);
		{
			count.addModifyListener(new ModifyListener() {					
				public void modifyText(ModifyEvent arg0) {
					if(getOKButton()!=null){
					if(count.getText().equals("0")){
						getOKButton().setEnabled(false);
					}else{						
						getOKButton().setEnabled(true);
					}	
					}
				}
			});
			FormData countLayoutData = new FormData();
			countLayoutData.width = 50;
			countLayoutData.top = new FormAttachment(caseCount, 0, SWT.CENTER);
			countLayoutData.left = new FormAttachment(caseCount, 5);
			count.setLayoutData(countLayoutData);
			int i =switchMediator.getSwitchContainer().getSwitchCaseParentContainer().getSwitchCaseContainer().size();
			count.setText(Integer.toString(i));
		}

		return container;
	}
	
	
	
	protected void okPressed() {		
			int number=Integer.parseInt(count.getText())-switchMediator.getSwitchContainer().getSwitchCaseParentContainer().getSwitchCaseContainer().size();
			if(number>0){
			for(int i=0;i<number;++i){
			SwitchCaseContainer caseContainer = EsbFactory.eINSTANCE.createSwitchCaseContainer();
			AddCommand addCmd = new AddCommand(editingDomain,switchMediator.getSwitchContainer().getSwitchCaseParentContainer(),EsbPackage.Literals.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER, caseContainer);
			if (addCmd.canExecute()){
				editingDomain.getCommandStack().execute(addCmd);
			}
			SwitchCaseBranchOutputConnector caseOutputConnector=EsbFactory.eINSTANCE.createSwitchCaseBranchOutputConnector();
			AddCommand addCaseOutputConnectorCommand=new AddCommand(editingDomain, switchMediator, EsbPackage.Literals.SWITCH_MEDIATOR__CASE_BRANCHES,caseOutputConnector);
			if (addCaseOutputConnectorCommand.canExecute()){
				editingDomain.getCommandStack().execute(addCaseOutputConnectorCommand);
			}			
			}
			}else{
				
				for(int i=0;i<Math.abs(number);++i){
					SwitchCaseContainer lastCaseContainer=switchMediator.getSwitchContainer().getSwitchCaseParentContainer().getSwitchCaseContainer().get(switchMediator.getSwitchContainer().getSwitchCaseParentContainer().getSwitchCaseContainer().size()-1);
					caseBranches.add(lastCaseContainer);
				DeleteCommand deleteCmd=new DeleteCommand(editingDomain, caseBranches);
				if (deleteCmd.canExecute()){
					editingDomain.getCommandStack().execute(deleteCmd);
				} 
				caseBranches.remove(lastCaseContainer);
				
				
				SwitchCaseBranchOutputConnector lastCaseOutputConnector=switchMediator.getCaseBranches().get(switchMediator.getCaseBranches().size()-1);
				caseOutputConnectors.add(lastCaseOutputConnector);
				DeleteCommand deleteCaseOutputConnectorscmd=new DeleteCommand(editingDomain, caseOutputConnectors);
				if (deleteCaseOutputConnectorscmd.canExecute()){
					editingDomain.getCommandStack().execute(deleteCaseOutputConnectorscmd);
				} 
				caseOutputConnectors.remove(lastCaseOutputConnector);
				
			}
			}
			if(editpart instanceof SwitchMediatorEditPart){
				if(((SwitchMediatorEditPart)editpart).reversed){
					SwitchMediatorUtils.reorderWhenRevered(editpart);
				}
				else{
					SwitchMediatorUtils.reorderWhenForward(editpart);
				}
			}
			super.okPressed();
			
			// Rearrange Switch mediator on add or remove of case branches. 
			reArrange();
		}	
	
	/**
	 * Rearrange Switch mediator on add or remove of case branches.
	 */
	private void reArrange(){
		Display.getCurrent().asyncExec(new Runnable() {			
			@Override
			public void run() {	
				XYRepossition.resizeContainers((IGraphicalEditPart) editpart);
				XYRepossition.reArrange((IGraphicalEditPart) editpart);	
			}});
	}
}
