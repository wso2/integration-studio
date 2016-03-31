package org.wso2.developerstudio.eclipse.carbonserver.remote.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonServer;
import org.wso2.developerstudio.eclipse.carbonserver.remote.util.RemoteCarbonServerUtils;
import org.eclipse.swt.widgets.Button;

public class RemoteServerCredentialDialog extends Dialog {

	Text usernameText;
	Text passwordText;

	String username;
	String pwd;

	private RemoteCarbonServer remoteCServer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public RemoteServerCredentialDialog(Shell parentShell, RemoteCarbonServer rcs) {
		super(parentShell);
		remoteCServer = rcs;
	}

	public Control createDialogArea(Composite parent) {
		parent.getShell().setText("Credential Info");
		GridData gd;
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		gd = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);
		Label usernameLabel = new Label(container, SWT.NONE);
		usernameLabel.setText("Username: ");

		usernameText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		usernameText.setLayoutData(gd);
		usernameText.setText(remoteCServer.getUsername());
		setUsername(usernameText.getText());

		Label passwordLabel = new Label(container, SWT.NULL);
		passwordLabel.setText("Password");

		passwordText = new Text(container, SWT.PASSWORD | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		passwordText.setLayoutData(gd);
		new Label(container, SWT.NONE);

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		btnNewButton.setAlignment(SWT.LEFT);
		btnNewButton.setText("Validate Credentials");

		usernameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				setUsername(usernameText.getText());
			}
		});

		passwordText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				setPwd(passwordText.getText());
			}
		});

		btnNewButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				try {
					RemoteCarbonServerUtils.validateCredentials(remoteCServer.getServerURL().toString(), getUsername(),
					                                            getPwd());
					MessageDialog.openInformation(getShell(), "Validation",
					                              "Credentials have been successfully validated");
				} catch (Exception e) {
					MessageDialog.openError(getShell(), "Validation Failed", "Unable to validate the credentials");
				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		return super.createDialogArea(parent);
	}

	protected void okPressed() {
		if (validate()) {
			remoteCServer.setUsername(getUsername());
			remoteCServer.setPassword(getPwd());
		}
		super.okPressed();

	}

	public boolean validate() {
		if (getUsername().equals("") || getUsername() == null) {
			return false;
		}
		if (getPwd().equals("") || getPwd() == null) {
			return false;
		}
		return true;
	}
}
