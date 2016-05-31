package org.wso2.developerstudio.datamapper.diagram.custom.util;

import java.util.ArrayList;

import org.apache.synapse.transport.http.conn.ClientSSLSetupHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.Split;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditor;
import org.wso2.developerstudio.datamapper.impl.SplitImpl;

public class ConfigureSplitOperatorDialog extends Dialog {

	private Split splitOperator;
	private Label caseCount;
	private Label caseDelimiter;
	private Text count;
	private Text delimiter;
	private EditPart editpart;
	private TransactionalEditingDomain editingDomain;
	SplitImpl spliter = null;
	// private ArrayList<OperatorLeftContainer> caseBranches=new
	// ArrayList<OperatorLeftContainer>();
	private ArrayList<OperatorRightConnector> caseOutputConnectors = new ArrayList<OperatorRightConnector>();

	public ConfigureSplitOperatorDialog(Shell parentShell, Split splitOperator,
			TransactionalEditingDomain editingDomain, EditPart editpart) {
		
		super(parentShell);
		this.splitOperator = splitOperator;
		this.editpart = editpart;
		this.editingDomain = editingDomain;
		CSSShapeImpl spliterdd = (CSSShapeImpl) this.editpart.getModel();
		spliter = (SplitImpl) spliterdd.getElement();
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Split Operator Properties");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		caseCount = new Label(container, SWT.NONE);
		{
			caseCount.setText("No of Branches :         ");
			FormData caseCountLabelLayoutData = new FormData();
			caseCountLabelLayoutData.top = new FormAttachment(0, 5);
			caseCountLabelLayoutData.left = new FormAttachment(0);
			caseCount.setLayoutData(caseCountLabelLayoutData);
		}

		count = new Text(container, SWT.NONE);
		{
			count.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					validate();
				}
			});
			FormData countLayoutData = new FormData();
			countLayoutData.width = 50;
			countLayoutData.top = new FormAttachment(caseCount, 0, SWT.CENTER);
			countLayoutData.left = new FormAttachment(caseCount, 5);
			count.setLayoutData(countLayoutData);
			int i = splitOperator.getBasicContainer().getRightContainer().getRightConnectors().size();
			count.setText(Integer.toString(i));
		}
		caseDelimiter = new Label(container, SWT.NONE);
		{
			caseDelimiter.setText("Delimiter to Split : ");
			FormData caseDelimiterLabelLayoutData = new FormData();
			caseDelimiterLabelLayoutData.top = new FormAttachment(0, 40);
			caseDelimiterLabelLayoutData.left = new FormAttachment(0);
			caseDelimiter.setLayoutData(caseDelimiterLabelLayoutData);
		}

		delimiter = new Text(container, SWT.NONE);
		
		if (spliter.getDelimiterValue() != null) {
		delimiter.setText(spliter.getDelimiterValue());
		} else {
			delimiter.setText(",");
		}
		{
			delimiter.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					validate();
				}
			});
			FormData delimiterLayoutData = new FormData();
			delimiterLayoutData.width = 50;
			delimiterLayoutData.top = new FormAttachment(caseDelimiter, 0, SWT.CENTER);
			delimiterLayoutData.left = new FormAttachment(caseDelimiter, 40);
			delimiter.setLayoutData(delimiterLayoutData);
		}

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		validate();
	}

	private void validate() {
		boolean isEnabled = false;
		Button okButton = getButton(IDialogConstants.OK_ID);
		if (delimiter != null && count != null) {
			if (!delimiter.getText().equals("") && delimiter.getText() != null && !delimiter.getText().isEmpty()
					&& delimiter.getText().length() == 1) {
				if (!count.getText().equals("0") && !count.getText().equals("") && count.getText() != null && !count.getText().isEmpty()) {
				isEnabled = true;
				}
			}
		}
	if (okButton != null) {
		okButton.setEnabled(isEnabled);
	}
	}

	protected void okPressed() {
		if (delimiter.getText() != null && !delimiter.getText().isEmpty()) {
			/*SetRequest reqSet = new SetRequest(editingDomain,
					spliter, DataMapperPackage.Literals.SPLIT__DELIMITER, delimiter.getText());
			 SetValueCommand operation = new SetValueCommand(reqSet);*/
			/*if (operation.canExecute()) {
				editingDomain.getCommandStack().execute((Command) operation);
			}*/
			spliter.setDelimiterValue(delimiter.getText());
		}
		int number = Integer.parseInt(count.getText())
				- splitOperator.getBasicContainer().getRightContainer().getRightConnectors().size();
		if (number > 0) {
			for (int i = 0; i < number; ++i) {
				OperatorRightConnector concatOperatorContainers = DataMapperFactory.eINSTANCE
						.createOperatorRightConnector();
				AddCommand addCmd = new AddCommand(editingDomain, splitOperator.getBasicContainer().getRightContainer(),
						DataMapperPackage.Literals.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS,
						concatOperatorContainers);
				if (addCmd.canExecute()) {
					editingDomain.getCommandStack().execute(addCmd);
				}

			}
		} else if (number < 0) {

			for (int i = 0; i < Math.abs(number); i++) {
				EList<OperatorRightConnector> listOfRightConnectors = splitOperator.getBasicContainer()
						.getRightContainer().getRightConnectors();
				OperatorRightConnector splitOperatorConnector = listOfRightConnectors
						.get(listOfRightConnectors.size() - 1);
				caseOutputConnectors.add(splitOperatorConnector);
				DeleteCommand deleteCmd = new DeleteCommand(editingDomain, caseOutputConnectors);
				if (deleteCmd.canExecute()) {
					editingDomain.getCommandStack().execute(deleteCmd);
				}
				caseOutputConnectors.remove(splitOperatorConnector);
			}
		}

		super.okPressed();
	}

}
