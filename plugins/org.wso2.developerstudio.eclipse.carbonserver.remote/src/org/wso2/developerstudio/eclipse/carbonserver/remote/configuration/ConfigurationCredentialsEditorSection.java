/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver.remote.configuration;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;
import org.wso2.developerstudio.eclipse.carbonserver.remote.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonServer;
import org.wso2.developerstudio.eclipse.carbonserver.remote.ui.RemoteServerCredentialDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ConfigurationCredentialsEditorSection extends ServerEditorSection{
	Text usernameText;
//	Text passwordText;
//	Text confirmPasswordText;
//	Button changePWDButton;
//	Button changeUserName;
	
	String username;
	private RemoteCarbonServer remoteCarbonServer;
//	String pwd="";
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


//	public String getPwd() {
//		return pwd;
//	}
//
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	protected boolean updating;
	/**
	 * ConfigurationPortEditorSection constructor comment.
	 */
	public ConfigurationCredentialsEditorSection() {
		super();
	}

	
	/**
	 * Creates the SWT controls for this workbench part.
	 *
	 * @param parent the parent control
	 */
	public void createSection(Composite parent) {
		super.createSection(parent);
		remoteCarbonServer =(RemoteCarbonServer)server.loadAdapter(RemoteCarbonServer.class, null);
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());
		
		Section section = toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED
			| ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | ExpandableComposite.FOCUS_TITLE);
		section.setText("Credentials");
		section.setDescription("Credentials to authenticate with the Carbon Admin Services");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));
		
		// ports
		final Composite composite = toolkit.createComposite(section);
		GridLayout layout = new GridLayout(2,true);
		layout.marginHeight = 8;
		layout.marginWidth = 8;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		toolkit.createLabel(composite, "Username");
		usernameText = toolkit.createText(composite, "");
		usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		String givenUName = remoteCarbonServer.getUsername();
		usernameText.setText(givenUName);
		usernameText.setEditable(false);
		
//		toolkit.createLabel(composite, "");
//		changeUserName = toolkit.createButton(composite, "Change", SWT.PUSH);
//		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END | GridData.BEGINNING);
//		gd.widthHint = 70;
//		changeUserName.setLayoutData(gd);
		
//		toolkit.createLabel(composite, "Password");
//		passwordText = toolkit.createText(composite, "");
//		passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		
//		toolkit.createLabel(composite, "Confirm Password");
//		confirmPasswordText = toolkit.createText(composite, "");
//		confirmPasswordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		
//		toolkit.createLabel(composite, "");
//		changePWDButton =  toolkit.createButton(composite, "Change Password", SWT.PUSH);
//		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
//		gd.widthHint = 120;
////		gd.horizontalSpan = 2;
//		changePWDButton.setLayoutData(gd);
		
//		passwordText.addFocusListener(new FocusListener(){
//			public void focusGained(FocusEvent arg0) {
//				setPasswordTextBoxOnFocus();
//			}
//			public void focusLost(FocusEvent arg0) {
//				setPasswordTextBoxOnLostFocus();
//			}
//		});
//		
//		confirmPasswordText.addFocusListener(new FocusListener(){
//			public void focusGained(FocusEvent arg0) {
//				setConfirmPasswordTextBoxOnFocus();
//			}
//			public void focusLost(FocusEvent arg0) {
//				setConfirmPasswordTextBoxOnLostFocus();
//			}
//		});
		
		usernameText.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent arg0) {
				setUsername(usernameText.getText().trim());
			}
			
		});
		
//		changeUserName.addSelectionListener(new SelectionListener() {
//			
//			public void widgetSelected(SelectionEvent arg0) {
//				RemoteServerCredentialDialog dialog = new RemoteServerCredentialDialog(composite.getShell(),remoteCarbonServer);
//				dialog.setBlockOnOpen(true);
//				dialog.create();
//				dialog.getShell().setSize(300, 170);
//				dialog.open();
//			}
//			
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		passwordText.addModifyListener(new ModifyListener(){
//			public void modifyText(ModifyEvent arg0) {
//				setPwd(passwordText.getText().trim());
//			}
//			
//		});
//		
//		changePWDButton.addSelectionListener(new SelectionListener() {
//			
//			public void widgetSelected(SelectionEvent event) {
//				saveInfo();
//			}
//			
//			
//
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				
//			}
//		});
		
		initialize();
	}
	
//	private void saveInfo() {
//		if(!validateUsername()){
//			MessageDialog.openError(this.getShell(), "Error", "Username not valid");
//			return;
//		}
////		else if(!validatePWD()){
////			MessageDialog.openError(this.getShell(), "Error", "Passwords does not match");
////			return;
////		}
//		RemoteCarbonServer rcs=(RemoteCarbonServer)server.loadAdapter(RemoteCarbonServer.class, null);
//		rcs.setUsername(username);
////		rcs.setPassword(pwd);
//	}

//	private boolean validateUsername() {
//		if(username==null || username.equals("")){
//			return false;
//		}
//		return true;
//	}


//	public boolean validatePWD(){
//		if(pwd.equals(confirmPasswordText.getText())){
//			return true;
//		}
//		return false;
//	}
	
	
	
	public void dispose() {
	}
	
	/* (non-Javadoc)
	 * Initializes the editor part with a site and input.
	 */
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		initialize();
	}

	/**
	 * Initialize the fields in this editor.
	 */
	protected void initialize() {
//		if (usernameText!=null && passwordText!=null){
//			try {
//				ICredentials serverCredentials = CarbonServerManager.getServerCredentials(server.getOriginal());
//				usernameText.setText(serverCredentials.getUsername());
//				setPasswordTextBoxOnLostFocus();
//			} catch (Exception e) {
//				log.error(e);
//			}
//
//		}
	}
	
//	private void setPasswordTextBoxOnFocus(){
//		updatePassword=false;
//		passwordText.setText(pwd);
//		passwordText.setEchoChar('*'); 
//		passwordText.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_BLACK));
//		updatePassword=true;
//	}
//	
//	private void setPasswordTextBoxOnLostFocus(){
//		updatePassword=false;
//		if (pwd==null || pwd.equals("")){
//			passwordText.setEchoChar('\0');
//			passwordText.setText("[Click to change the password]");
//			passwordText.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
//		}
//		updatePassword=true;
//	}
//	
//	private void setConfirmPasswordTextBoxOnFocus(){
//		updatePassword=false;
//		confirmPasswordText.setText(pwd);
//		confirmPasswordText.setEchoChar('*'); 
//		confirmPasswordText.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_BLACK));
//		updatePassword=true;
//	}
//	
//	private void setConfirmPasswordTextBoxOnLostFocus(){
//		updatePassword=false;
//		if (confirmPasswordText.getText()==null || confirmPasswordText.getText().equals("")){
//			confirmPasswordText.setEchoChar('\0');
//			confirmPasswordText.setText("[Re-type the password]");
//			confirmPasswordText.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
//		}
//		updatePassword=true;
//	}
	
	
}
