package org.wso2.developerstudio.datamapper.diagram.custom.util;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;


public class ConfigureConcatOperatorDialog extends Dialog {

	private Concat concatOperator;
	private Label caseCount;
	private Text count;
	private EditPart editpart;
	private TransactionalEditingDomain editingDomain;
//	private ArrayList<OperatorLeftContainer> caseBranches=new ArrayList<OperatorLeftContainer>();
	private ArrayList<OperatorLeftConnector> caseOutputConnectors=new ArrayList<OperatorLeftConnector>();



	public ConfigureConcatOperatorDialog(Shell parentShell, Concat concatOperator,
	                           TransactionalEditingDomain editingDomain, EditPart editpart) {
		super(parentShell);
		this.concatOperator=concatOperator;
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
			int i =concatOperator.getBasicContainer().getLeftContainer().getLeftConnectors().size();
			count.setText(Integer.toString(i));
		}

		return container;
	}
	
	
	
	protected void okPressed() {
		int number = Integer.parseInt(count.getText())
				- concatOperator.getBasicContainer().getLeftContainer()
						.getLeftConnectors().size();
		if (number > 0) {
			for (int i = 0; i < number; ++i) {
				OperatorLeftConnector concatOperatorContainers = DataMapperFactory.eINSTANCE
						.createOperatorLeftConnector();
				AddCommand addCmd = new AddCommand(
						editingDomain,
						concatOperator.getBasicContainer().getLeftContainer(),
						DataMapperPackage.Literals.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS,
						concatOperatorContainers);
				if (addCmd.canExecute()) {
					editingDomain.getCommandStack().execute(addCmd);
				}

			}
		} else if (number < 0) {

			for (int i = 0; i < Math.abs(number); i++) {
				EList<OperatorLeftConnector> listOfLeftConnectors = concatOperator
						.getBasicContainer().getLeftContainer()
						.getLeftConnectors();
				OperatorLeftConnector concatOperatorConnector = listOfLeftConnectors
						.get(listOfLeftConnectors.size() - 1);
				caseOutputConnectors.add(concatOperatorConnector);
				DeleteCommand deleteCmd = new DeleteCommand(editingDomain,
						caseOutputConnectors);
				if (deleteCmd.canExecute()) {
					editingDomain.getCommandStack().execute(deleteCmd);
				}
				caseOutputConnectors.remove(concatOperatorConnector);
			}
		}

		super.okPressed();
	}

}
