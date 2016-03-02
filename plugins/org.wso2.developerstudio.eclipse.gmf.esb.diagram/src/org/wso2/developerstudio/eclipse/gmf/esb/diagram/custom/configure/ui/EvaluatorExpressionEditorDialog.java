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

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;

/**
 * A SWT based editor dialog to be used for editing evaluator expressions.
 */
public class EvaluatorExpressionEditorDialog extends Dialog {

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	/**
	 * Evaluator Expression Property text field.
	 */
	private Text eETextField;

	/**
	 * Evaluator Expression Property being edited.
	 */
	private EvaluatorExpressionProperty evaluatorExpressionProperty;

	public EvaluatorExpressionEditorDialog(Shell parentShell,
			EvaluatorExpressionProperty evaluatorExpressionProperty) {
		super(parentShell);
		this.evaluatorExpressionProperty = evaluatorExpressionProperty;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	
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

		String elements[] = {"<match/>",
				"<and></and>", "<equal/>", "<or></or>", "<not></not>" };
		try {
			SimpleContentProposalProvider provider = new SimpleContentProposalProvider(
					elements);
			char[] autoActivationCharacters = new char[] { '<', '>' };
			org.eclipse.jface.bindings.keys.KeyStroke keyStroke;

			keyStroke = org.eclipse.jface.bindings.keys.KeyStroke
					.getInstance("Ctrl+Space");
			ContentProposalAdapter adapter = new ContentProposalAdapter(
					eETextField, new TextContentAdapter(), provider, keyStroke,
					autoActivationCharacters);

			adapter.setLabelProvider(new ILabelProvider() {

				public void removeListener(ILabelProviderListener arg0) {

				}

				public boolean isLabelProperty(Object arg0, String arg1) {
					return false;
				}

				public void dispose() {

				}

				public void addListener(ILabelProviderListener arg0) {

				}

				public String getText(Object obj) {
					ContentProposal cp = (ContentProposal) obj;
					String text = "";
					if (!cp.getContent().contains("/>")) {
						text = cp.getContent().substring(0,
								cp.getContent().lastIndexOf("/") - 1);

					} else {
						text = cp.getContent().substring(0,
								cp.getContent().lastIndexOf("/"))
								+ ">";
					}
					return text;
				}

				public Image getImage(Object obj) {
					return null;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		if (!StringUtils.isBlank(evaluatorExpressionProperty
				.getEvaluatorValue())) {
			eETextField
					.setText(evaluatorExpressionProperty.getEvaluatorValue());
		}
	}

	
	protected void okPressed() {
		saveConfiguration();
		super.okPressed();
	}

	private void saveConfiguration() {
		evaluatorExpressionProperty.setEvaluatorValue(eETextField.getText());
	}

	/**
	 * Return the initial size of the dialog.
	 */
	
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
