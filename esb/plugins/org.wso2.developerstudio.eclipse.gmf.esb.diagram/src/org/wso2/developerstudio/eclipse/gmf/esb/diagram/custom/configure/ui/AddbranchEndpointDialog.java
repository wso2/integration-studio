package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointAdditionalOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;

public class AddbranchEndpointDialog extends Dialog{
	private EndPoint endpoint;
	private Text count;
	private Label branchesCount;
	private EditPart editpart;

	public AddbranchEndpointDialog(Shell parentShell,
			EndPoint endpoint, TransactionalEditingDomain editingDomain,EditPart editpart) {
		super(parentShell);
		this.endpoint=endpoint;
		this.editpart=editpart;
		// TODO Auto-generated constructor stub
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Add Endpoint Branches.");
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);
		
		branchesCount = new Label(container, SWT.NONE);
		{
			branchesCount.setText("Number of branches: ");
			FormData branchesCountLabelLayoutData = new FormData();
			branchesCountLabelLayoutData.top = new FormAttachment(0, 5);
			branchesCountLabelLayoutData.left = new FormAttachment(0);
			branchesCount.setLayoutData(branchesCountLabelLayoutData);
		}
		
		 count=new Text(container, SWT.NONE);
		{
			FormData countLayoutData = new FormData();
			countLayoutData.width=50;
			countLayoutData.top = new FormAttachment(
					branchesCount, 0, SWT.CENTER);
			countLayoutData.left = new FormAttachment(
					branchesCount, 5);
			count.setLayoutData(countLayoutData);
			int i=(endpoint instanceof LoadBalanceEndPoint)? ((LoadBalanceEndPoint)endpoint).getOutputConnector().size():((FailoverEndPoint)endpoint).getOutputConnector().size();
			count.setText(Integer.toString(i));
		}
		
		return container;
	}
	
	protected void okPressed() {
		if(endpoint instanceof LoadBalanceEndPoint){
			LoadBalanceEndPoint parentEndpoint = (LoadBalanceEndPoint) endpoint;
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentEndpoint);
			int number=Integer.parseInt(count.getText())-parentEndpoint.getOutputConnector().size();
			if(number>0){
			for(int i=0;i<number;++i){
			LoadBalanceEndPointOutputConnector cb = EsbFactory.eINSTANCE.createLoadBalanceEndPointOutputConnector();
			AddCommand addCmd = new AddCommand(domain,parentEndpoint,EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR, cb);
			if (addCmd.canExecute()){
				domain.getCommandStack().execute(addCmd);
			}
			}
			}else{
				Collection collection=new ArrayList();
				for(int i=0;i<Math.abs(number);++i){
					Object lastConnector=parentEndpoint.getOutputConnector().get(parentEndpoint.getOutputConnector().size()-1);
				collection.add(lastConnector);
				DeleteCommand deleteCmd=new DeleteCommand(domain, collection);
				if (deleteCmd.canExecute()){
					domain.getCommandStack().execute(deleteCmd);
				} 
				collection.remove(lastConnector);
			}
			}
			reorder(Integer.parseInt(count.getText()));
		} else if(endpoint instanceof FailoverEndPoint){
			FailoverEndPoint parentEndpoint=(FailoverEndPoint) endpoint;
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentEndpoint);
			int number=Integer.parseInt(count.getText())-parentEndpoint.getOutputConnector().size();
			if(number>0){
			for(int i=0;i<number;++i){
			FailoverEndPointOutputConnector cb = EsbFactory.eINSTANCE.createFailoverEndPointOutputConnector();
			AddCommand addCmd = new AddCommand(domain,parentEndpoint,EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR, cb);
			if (addCmd.canExecute()){
				domain.getCommandStack().execute(addCmd);
			} 
			}
			}else{
				Collection collection=new ArrayList();
				for(int i=0;i<Math.abs(number);++i){
					Object lastConnector=parentEndpoint.getOutputConnector().get(parentEndpoint.getOutputConnector().size()-1);
				collection.add(lastConnector);
				DeleteCommand deleteCmd=new DeleteCommand(domain, collection);
				if (deleteCmd.canExecute()){
					domain.getCommandStack().execute(deleteCmd);
				} 
				collection.remove(lastConnector);
			}
			}
			reorder(Integer.parseInt(count.getText()));
		}
		super.okPressed();
	}

	private void reorder(float number) {

		List<IFigure> outputConnectors = new ArrayList<IFigure>();
		List<BorderItemLocator> outputLocators = new ArrayList<BorderItemLocator>();
		float pos = 0;
		for (int i = 0; i < editpart.getChildren().size(); ++i) {
			if (editpart.getChildren().get(i) instanceof AbstractEndpointAdditionalOutputConnectorEditPart) {
				pos = pos + (1 / (number + 1));
				IFigure borderItemFigure = ((AbstractEndpointAdditionalOutputConnectorEditPart) editpart
						.getChildren().get(i)).getFigure();
				outputConnectors.add(borderItemFigure);
				BorderItemLocator locator = new FixedBorderItemLocator(
						((AbstractEndpoint) editpart).getMainFigure(),
						borderItemFigure, PositionConstants.EAST, pos);
				outputLocators.add(locator);
			}
		}
		for (int i = 0; i < outputConnectors.size(); ++i) {
			((AbstractEndpoint) editpart).getBorderedFigure()
					.getBorderItemContainer().remove(outputConnectors.get(i));
			((AbstractEndpoint) editpart).getBorderedFigure()
					.getBorderItemContainer()
					.add(outputConnectors.get(i), outputLocators.get(i));
		}
	}

}
