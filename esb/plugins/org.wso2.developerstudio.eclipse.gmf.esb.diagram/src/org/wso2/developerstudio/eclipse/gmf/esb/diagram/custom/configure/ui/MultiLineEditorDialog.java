package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MultiLineEditorDialog extends Dialog{

	/**
	 * Evaluator Expression Property text field.
	 */
	private Text eETextField;
	private String value;
	
	public MultiLineEditorDialog(Shell parentShell,
			String value) {
		super(parentShell);
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Label lblEvaluatorExpression = new Label(container, SWT.NONE);
		lblEvaluatorExpression.setText("Evaluator Expression");
		

		eETextField = new Text(container, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		eETextField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));


		eETextField.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				saveConfiguration();
			}
		});
		loadConfiguration();
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	private void loadConfiguration() {
		if (!StringUtils.isBlank(value)) {
			eETextField
					.setText(value);
		}
	}

	
	protected void okPressed() {
		saveConfiguration();
		super.okPressed();
	}

	private void saveConfiguration() {
		value=eETextField.getText();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
}
