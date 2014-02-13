package org.wso2.developerstudio.eclipse.esb.presentation.ui;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;

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

		Group grpXmlEditor = new Group(container, SWT.NONE);
		grpXmlEditor.setText("Evaluator Expression");
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(gl_container.createParallelGroup(
				GroupLayout.LEADING).add(
				gl_container
						.createSequentialGroup()
						.addContainerGap()
						.add(grpXmlEditor, GroupLayout.PREFERRED_SIZE, 423,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE)));
		gl_container.setVerticalGroup(gl_container.createParallelGroup(
				GroupLayout.LEADING).add(
				gl_container
						.createSequentialGroup()
						.addContainerGap()
						.add(grpXmlEditor, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		eETextField = new Text(grpXmlEditor, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		eETextField.setBounds(10, 22, 403, 155);

		container.setLayout(gl_container);
		eETextField.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				saveConfiguration();
			}
		});

		String elements[] = { "<condition></<condition>", "<match/>",
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

				public Image getImage(Object arg0) {
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
