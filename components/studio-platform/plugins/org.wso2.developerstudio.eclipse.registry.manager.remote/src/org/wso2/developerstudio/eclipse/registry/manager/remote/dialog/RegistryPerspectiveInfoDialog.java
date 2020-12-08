package org.wso2.developerstudio.eclipse.registry.manager.remote.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.registry.manager.remote.dialog.RegistryInfoDialog;

public class RegistryPerspectiveInfoDialog extends RegistryInfoDialog {

	private String path;

	public RegistryPerspectiveInfoDialog(Shell shell, RegistryURLNode regUrlNode) {
	    super(shell, regUrlNode);
    }


	@Override
    public void createAdditionalUIs(Composite container ) {
		Label pathLabel = new Label(container, SWT.NONE);
		pathLabel.setText("Path: ");
		
		GridData gd = new GridData();
		pathLabel.setLayoutData(gd);

		Text pathText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText.setLayoutData(gd);

		pathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text url = (Text) event.widget;
				path = url.getText();
				setPath(path);
			}
		});
		pathText.setText("/");

		final Button button = new Button(container, SWT.CHECK);
		button.setText("Save Credentials");
		button.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
				setSavePassword(button.getSelection());
			}

			public void widgetSelected(SelectionEvent arg0) {
				widgetDefaultSelected(arg0);

			}

		});
	    
    }

}
