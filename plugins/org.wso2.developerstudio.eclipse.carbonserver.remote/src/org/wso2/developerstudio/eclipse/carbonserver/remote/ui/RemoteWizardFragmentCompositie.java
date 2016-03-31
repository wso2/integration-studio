package org.wso2.developerstudio.eclipse.carbonserver.remote.ui;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerUtils;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonServer;

public class RemoteWizardFragmentCompositie extends Composite {
	private Text txtUrl;
	private Text txtUsername;
	private Text txtPassword;
	private Text txtServicePath;

	private boolean contentValid = false;
	private IWizardHandle wizard;
	private Object runtimeWC;
	private RemoteCarbonServer remoteCarbonServer;
	private Button btnTestConnection;
	private Button btnTestCredentialsButton;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public RemoteWizardFragmentCompositie(Composite parent, int style, IWizardHandle wizard) {
		super(parent, style);
		setWizard(wizard);
		setLayout(new GridLayout(1, false));

		Group grpServerDetails = new Group(this, SWT.NONE);
		grpServerDetails.setText("Server Details");
		grpServerDetails.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpServerDetails.setLayout(new GridLayout(3, false));

		Label lblServerUrl = new Label(grpServerDetails, SWT.NONE);
		GridData gd_lblServerUrl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblServerUrl.widthHint = 75;
		lblServerUrl.setLayoutData(gd_lblServerUrl);
		lblServerUrl.setText("Server URL");

		txtUrl = new Text(grpServerDetails, SWT.BORDER);
		txtUrl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				try {
					setServerURL(txtUrl.getText());
				} catch (MalformedURLException e) {
					try {
						setServerURL("");
					} catch (MalformedURLException e1) {
					}
				}
				getValidateString();
			}
		});
		txtUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(grpServerDetails, SWT.NONE);

		Label label = new Label(grpServerDetails, SWT.NONE);
		label.setText("Eg: https://localhost:9443/<context-root>");

		btnTestConnection = new Button(grpServerDetails, SWT.NONE);
		btnTestConnection.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				String title = "Carbon Server URL";
				try {
					validateURL();
					MessageDialog.openInformation(getShell(), title, "Server exists");
				} catch (Exception e1) {
					MessageDialog.openError(getShell(), title, e1.toString());
				}
			}
		});
		GridData gd_btnTestConnection = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnTestConnection.widthHint = -1;
		btnTestConnection.setLayoutData(gd_btnTestConnection);
		btnTestConnection.setText("Test connection");

		Label lblServicePath = new Label(grpServerDetails, SWT.NONE);
		GridData gd_lblServicePath = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblServicePath.widthHint = 85;
		lblServicePath.setLayoutData(gd_lblServicePath);
		lblServicePath.setText("ServicePath");

		txtServicePath = new Text(grpServerDetails, SWT.BORDER);
		txtServicePath.setText("services");
		CarbonServerUtils.setRemoteServicePath("services");
		txtServicePath.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				CarbonServerUtils.setRemoteServicePath(txtServicePath.getText());
			}
		});
		txtServicePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(grpServerDetails, SWT.NONE);

		Label servicePathDesc = new Label(grpServerDetails, SWT.CENTER);
		servicePathDesc.setText("(Value of the servicePath parameter defined in the axis2.xml file)");

		new Label(grpServerDetails, SWT.NONE);

		Group grpCredentials = new Group(this, SWT.NONE);
		grpCredentials.setText("Credentials");
		grpCredentials.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		grpCredentials.setLayout(new GridLayout(2, false));

		Label lblUsername = new Label(grpCredentials, SWT.NONE);
		GridData gd_lblUsername = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblUsername.widthHint = 75;
		lblUsername.setLayoutData(gd_lblUsername);
		lblUsername.setText("Username");

		txtUsername = new Text(grpCredentials, SWT.BORDER);
		txtUsername.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setUsername(txtUsername.getText());
				getValidateString();
			}
		});
		GridData gd_txtAdmin_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtAdmin_1.widthHint = 200;
		txtUsername.setLayoutData(gd_txtAdmin_1);

		Label lblPassword = new Label(grpCredentials, SWT.NONE);
		lblPassword.setText("Password");

		txtPassword = new Text(grpCredentials, SWT.BORDER | SWT.PASSWORD);
		txtPassword.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setPassword(txtPassword.getText());
				getValidateString();
			}
		});
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpCredentials, SWT.NONE);

		btnTestCredentialsButton = new Button(grpCredentials, SWT.NONE);
		btnTestCredentialsButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String title = "Carbon Server Credentials";
				try {
					validateCredentials();
					MessageDialog.openInformation(getShell(), title, "Server credentials valid");
				} catch (Exception e1) {
					MessageDialog.openError(getShell(), title, e1.getMessage());
				}
			}
		});
		GridData gd_btnTestCredentialsButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnTestCredentialsButton.widthHint = 100;
		btnTestCredentialsButton.setLayoutData(gd_btnTestCredentialsButton);
		btnTestCredentialsButton.setText("Validate...");
	}

	private void validateURL() throws Exception {
		HttpURLConnection conn = (HttpURLConnection) getServerURL().openConnection();
		conn.connect();
		int responseCode = conn.getResponseCode();
		if (HttpURLConnection.HTTP_OK != responseCode && HttpURLConnection.HTTP_MOVED_TEMP != conn.getResponseCode()) {
			throw new Exception("Server is has not fully started or incorrect URL");
		}
	}

	private void validateCredentials() throws Exception {
		validateURL();
		String sessionCookie =
		                       CarbonServerUtils.createSessionCookie(getServerURL().toString(), getUsername(),
		                                                             getPassword());
		if (sessionCookie == null) {
			throw new Exception("Invalid credentials");
		}
	}

	protected String getValidateString() {
		String msg = null;
		if (getServerURL() == null) {
			msg = "Invalid url for server url.";
		}
		btnTestConnection.setEnabled(getServerURL() != null);
		boolean isUserNameInvalid = getUsername() == null || getUsername().equals("");
		if (msg != null && isUserNameInvalid) {
			msg = "Username cannot be empty.";
		}
		boolean isPasswordInvalid = getPassword() == null || getPassword().equals("");
		if (msg != null && isPasswordInvalid) {
			msg = "Password cannot be empty.";
		}
		btnTestCredentialsButton.setEnabled(btnTestConnection.isEnabled() && !isUserNameInvalid && !isPasswordInvalid);
		setContentValid(msg == null);
		getWizard().setMessage(msg, msg == null ? IStatus.INFO : IStatus.ERROR);
		return msg;
	}

	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void setServerURL(String url) throws MalformedURLException {
		remoteCarbonServer.setServerURL(new URL(url));
	}

	public URL getServerURL() {
		return remoteCarbonServer.getServerURL();
	}

	public void setUsername(String username) {
		remoteCarbonServer.setUsername(username);
	}

	public String getUsername() {
		return remoteCarbonServer.getUsername();
	}

	public void setPassword(String password) {
		remoteCarbonServer.setPassword(password);
	}

	public String getPassword() {
		return remoteCarbonServer.getPassword();
	}

	public void setServicePath(String servicePath) {
		remoteCarbonServer.setServicePath(servicePath);
	}

	public void setContentValid(boolean contentValid) {
		this.contentValid = contentValid;
	}

	public boolean isContentValid() {
		return contentValid;
	}

	public void setWizard(IWizardHandle wizard) {
		this.wizard = wizard;
	}

	public IWizardHandle getWizard() {
		return wizard;
	}

	protected void setRuntime(Object newRuntime) {
		runtimeWC = newRuntime;
		if (newRuntime == null) {
			remoteCarbonServer = null;
		} else {
			if (runtimeWC instanceof IServerWorkingCopy) {
				remoteCarbonServer =
				                     (RemoteCarbonServer) ((IServerWorkingCopy) runtimeWC).loadAdapter(RemoteCarbonServer.class,
				                                                                                       null);
			} else if (runtimeWC instanceof IServer) {
				remoteCarbonServer =
				                     (RemoteCarbonServer) ((IServer) runtimeWC).loadAdapter(RemoteCarbonServer.class,
				                                                                            null);
			}
			txtUsername.setText(remoteCarbonServer.getUsername());
			txtPassword.setText(remoteCarbonServer.getPassword());
		}
	}
}
