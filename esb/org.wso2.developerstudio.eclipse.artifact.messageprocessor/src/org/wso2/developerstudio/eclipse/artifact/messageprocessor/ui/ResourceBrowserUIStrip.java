package org.wso2.developerstudio.eclipse.artifact.messageprocessor.ui;

import static org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants.FILTER_MEDIA_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
// TODO fix this
// import
// org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IFieldControlData;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IOnAction;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.UIControl;
import org.wso2.developerstudio.eclipse.platform.ui.utils.WSO2UIToolkit;

public class ResourceBrowserUIStrip implements UIControl {

	Label regLabel;
	Button btnRegBrowse;

	@Override
	public IFieldControlData createUIField(String id, Composite container, int columns, Integer verticalIndent,
	                                       Integer horizontalIndent, boolean isTextReadonly, Shell shell, String label,
	                                       String fileButtonCaption, int selectedOption, ProjectDataModel model,
	                                       String pathBindingProperty) {
		if (id.equals("resource.browser")) {
			regLabel = new Label(container, SWT.None);
			regLabel.setText(label);
			GridData gridData = new GridData();
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			regLabel.setLayoutData(gridData);

			final Text txtValue = new Text(container, SWT.BORDER);
			txtValue.setEditable(!isTextReadonly);
			if (columns != -1) {
				gridData = new GridData();
				gridData.horizontalSpan = columns - 3;
				gridData.grabExcessHorizontalSpace = true;
				gridData.horizontalAlignment = SWT.FILL;
				txtValue.setLayoutData(gridData);
			}

			IFieldControlData regControlData =
			                                   addRegistryBrowseButton(container, shell, label, fileButtonCaption,
			                                                           txtValue, selectedOption, model,
			                                                           pathBindingProperty);
			return regControlData;
		}
		return null;
	}

	@Override
	public IFieldControlData addRegistryBrowseButton(Composite container, Shell shell, String label,
	                                                 String buttonCaption, Text txtValue, int selectedOption,
	                                                 ProjectDataModel model, String pathBindingProperty) {

		IFieldControlData regFiledControlData = null;

		if (txtValue.getEditable()) {
			regFiledControlData = new ResourceTextFieldControlData(txtValue);
		} else {
			regFiledControlData = new ResourceFieldControlData(txtValue);
		}

		btnRegBrowse = new Button(container, SWT.None);
		btnRegBrowse.setText(buttonCaption);
		btnRegBrowse.addSelectionListener(createResourceSelectionListner(shell, txtValue, selectedOption, model,
		                                                                 pathBindingProperty));

		WSO2UIToolkit.propagateControlStatus(txtValue, regLabel, btnRegBrowse);
		return regFiledControlData;
	}

	private SelectionListener createResourceSelectionListner(final Shell shell, final Text txtValue,
	                                                         final int selectedOption, final ProjectDataModel model,
	                                                         final String pathBindingProperty) {

		return new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent evt) {
				selectRegistryResource(shell, txtValue, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
			}

			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		};
	}

	private void selectRegistryResource(final Shell shell, Text textBox, String mediaType) {
		RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		RegistryKeyPropertyEditorDialog dialog =
		                                         new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
		                                                                             registryKeyProperty, null); // new
																												 // ArrayList<NamedEntityDescriptor>()
		int open = dialog.open();
		if (open == Window.OK) {
			String keyValue = registryKeyProperty.getKeyValue();
			textBox.setText(keyValue);
		}
	}

	private static class ResourceFieldControlData implements IFieldControlData {

		private Control control;
		private IOnAction onAction;

		public Object getData() {
			return getControl().getData();
		}

		public void setData(Object data) {
			if (data != null) {
				((Text) getControl()).setText(data.toString());
				getControl().setData(data);
			} else {
				((Text) getControl()).setText("");
				getControl().setData(null);
			}
		}

		public Control getControl() {
			return this.control;
		}

		public IOnAction getOnAction() {
			return onAction;
		}

		public void setOnAction(IOnAction action) {
			this.onAction = action;
			final Text ctrl = (Text) getControl();
			ctrl.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent evt) {
					getOnAction().onModifyAction();
				}
			});
			ctrl.addKeyListener(new KeyAdapter() {

				public void keyReleased(KeyEvent e) {
					getControl().setData(null);
					// FIXME
					super.keyReleased(e);
				}
			});

		}

		public ResourceFieldControlData(Control control) {
			this.control = control;
		}
	}

	private static class ResourceTextFieldControlData implements IFieldControlData {
		private Control control;
		private IOnAction onAction;

		public Object getData() {
			return getControl().getData();
		}

		public void setData(Object data) {
			if (data != null) {
				((Text) getControl()).setText(data.toString());
				getControl().setData(data);
			} else {
				((Text) getControl()).setText("");
				getControl().setData(null);
			}
		}

		public Control getControl() {
			return this.control;
		}

		public IOnAction getOnAction() {
			return onAction;
		}

		public void setOnAction(IOnAction action) {
			this.onAction = action;
			final Text ctrl = (Text) getControl();
			ctrl.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent evt) {
					getControl().setData(ctrl.getText());
					getOnAction().onModifyAction();
				}
			});

		}

		public ResourceTextFieldControlData(Control control) {
			this.control = control;
		}

	}
}
