/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.ui.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.core.authentication.UserPasswordCredentials;
import org.wso2.developerstudio.appfactory.core.client.CloudAdminServiceClient;
import org.wso2.developerstudio.appfactory.core.jag.api.JagApiProperties;
import org.wso2.developerstudio.appfactory.core.model.ErrorType;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.appfactory.ui.actions.LoginAction;
import org.wso2.developerstudio.appfactory.ui.utils.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class PasswordDialog extends Dialog {
  private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
  static final String DASHBOARD_VIEW_ID = "org.wso2.developerstudio.eclipse.dashboard";
  private Text userText;
  private Text passwordText;
  private Text hostText;
  private String user;
  private String password;
  private String host;
  private boolean isSave;
  private boolean isOT;
  private Label error;
  private boolean isAppCloud;
  private UserPasswordCredentials credentials;
  private boolean fromDashboad;
  private ISecurePreferences gitTempNode;
  private Button btnCheckButton;
  private Button btnCloudCheckButton;
  private Button btnAFCheckButton;
  private ISecurePreferences preferences;
  private LoginAction action;
  private Label lblHost;
  private Label lblUser;
  
/** * Create the dialog. * * @param parentShell 
 * @param loginAction */

  public PasswordDialog(Shell parentShell, LoginAction loginAction) {
    super(parentShell);
    setDefaultImage(ResourceManager.getPluginImage(
			"org.wso2.developerstudio.appfactory.ui", //$NON-NLS-1$
			"icons/users.gif")); //$NON-NLS-1$
    this.action = loginAction;
    this.isAppCloud = true;
     
  }
  
  protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.PasswordDialog_LoginDialog_title);
		newShell.setImage(ResourceManager.getPluginImage(
			"org.wso2.developerstudio.appfactory.ui", //$NON-NLS-1$
			"icons/users.gif"));
	}
  
/** * Create contents of the dialog. * * @param parent */

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    //container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
    GridLayout gl_container = new GridLayout(2, false);
    gl_container.marginRight = 10;
    gl_container.marginLeft = 10;
    gl_container.marginTop = 15;
    gl_container.marginBottom = 5;
    container.setLayout(gl_container);
    
//    Label lblNewLabel = new Label(container, SWT.NONE);
//	lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
//	lblNewLabel.setImage(ResourceManager.getPluginImage(
//			"org.wso2.developerstudio.appfactory.ui", //$NON-NLS-1$
//			"icons/appfactory_logo.png")); //$NON-NLS-1$
//	GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.TOP, false,
//			true, 2, 1);
//	gd_lblNewLabel.widthHint = 509;
//	gd_lblNewLabel.heightHint = 38;
//	lblNewLabel.setLayoutData(gd_lblNewLabel);
    
    Label lblTmp =new Label(container, SWT.NONE);
    lblTmp.setText("Connect to :");
    
    Composite composite = new Composite(container, SWT.NULL);
    composite.setLayout( new RowLayout());
    composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
        1, 1));

    btnCloudCheckButton = new Button(composite, SWT.RADIO);
    btnCloudCheckButton.setText("App Cloud");
    btnCloudCheckButton.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    		 Button button = (Button) e.widget;    		 
    		 isAppCloud = button.getSelection();
    		 swapLookAndFeel();
    	}
    });
    btnCloudCheckButton.setSelection(isAppCloud);
    
    btnAFCheckButton = new Button(composite, SWT.RADIO);
    btnAFCheckButton.setText("App Factory");
    btnAFCheckButton.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    		 Button button = (Button) e.widget;    		 
    		 isAppCloud = !button.getSelection();
    		 swapLookAndFeel();    		 
    	}
    });
    btnAFCheckButton.setSelection(!isAppCloud);
    
	
    lblHost = new Label(container, SWT.NONE);
    lblHost.setText(Messages.PasswordDialog_URL);
    hostText = new Text(container, SWT.BORDER);
    hostText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
        1, 1));
    hostText.setText(host);
    
    lblUser = new Label(container, SWT.NONE);
    lblUser.setText(Messages.PasswordDialog_USER);
    userText = new Text(container, SWT.BORDER);
    userText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
        1, 1));
    userText.setText(user);

    Label lblNewLabel1 = new Label(container, SWT.NONE);
    GridData gd_lblNewLabel1= new GridData(SWT.LEFT, SWT.CENTER, false,
        false, 1, 1);
    gd_lblNewLabel1.horizontalIndent = 1;
    lblNewLabel1.setLayoutData(gd_lblNewLabel1);
    lblNewLabel1.setText(Messages.PasswordDialog_Password);
    passwordText = new Text(container, SWT.PASSWORD|SWT.BORDER);
     
    passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
        false, 1, 1));
    passwordText.setText(password);
    
    new Label(container, SWT.NONE);

    error = new Label(container, SWT.NONE);
    GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    data.heightHint = 35;
    error.setLayoutData(data);
    error.setForeground(container.getDisplay().getSystemColor(SWT.COLOR_RED));
    FocusAdapter adapter = new FocusAdapter() {
    	@Override
    	public void focusGained(FocusEvent e) {
    		 error.setText("");
    		super.focusGained(e);
    	}
	};
    hostText.addFocusListener(adapter);
    userText.addFocusListener(adapter);
    passwordText.addFocusListener(adapter);
    
    new Label(container, SWT.NONE);
    
    btnCheckButton = new Button(container, SWT.CHECK);
    btnCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
            1, 1));
    btnCheckButton.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    		 Button button = (Button) e.widget;
    		 if("".equals(userText.getText())||"".equals( passwordText.getText())){
    				error.setText("Username or Password cannot be empty !");
    				btnCheckButton.setSelection(false);
    			}else{
    	        if (button.getSelection()){
    	        	setSave(true);
    	        	 try {
    	        		  preferences = SecurePreferencesFactory.getDefault();
    	        	      gitTempNode = preferences.node("Test");
						  gitTempNode.put("user","testUser", true);/*get secure store password*/
					} catch (StorageException e1) {
						btnCheckButton.setSelection(false);
						log.error(e1);
					}
    	        }else{
    	        	setSave(false);
    	           }
    			} 
    	}
    });
    btnCheckButton.setText("Save connection details");
 
    swapLookAndFeel();
    
    return container;
  }
  
  private void swapLookAndFeel(){
	  
	  if(isAppCloud){
		 hostText.setText(Messages.APP_CLOUD_URL);
		 hostText.setEditable(false);
		 lblHost.setText(Messages.PasswordDialog_Cloud_URL);
		 lblUser.setText(Messages.PasswordDialog_Cloud_USER);
		 
	 }else{
		 
		 hostText.setEditable(true);
		 lblHost.setText(Messages.PasswordDialog_URL);
		 lblUser.setText(Messages.PasswordDialog_USER);
	 }	 
  }

  
/** * Create contents of the button bar. * * @param parent */

  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
        true);
    createButton(parent, IDialogConstants.CANCEL_ID,
        IDialogConstants.CANCEL_LABEL, false);
  }

  

/** * Return the initial size of the dialog. */

  @Override
  protected Point getInitialSize() {
    return new Point(539, 300);
  }

  @Override
  protected void okPressed() {
	  user = userText.getText(); 
	/* if((isOT)&&(user!=null)&&(!user.isEmpty())){
	   String[] temp = user.split("@");
	   user = temp[0]+".."+temp[1]+"@wso2.org";
	 }*/
    password = passwordText.getText();
    host =hostText.getText().trim();
    if(!host.startsWith("http")||!host.startsWith("https")){ //$NON-NLS-1$ //$NON-NLS-2$
    	host = "https://"+host; //$NON-NLS-1$
    }
    if("".equals(getUser())||"".equals(getPassword())){
		error.setText("Username or Password cannot be empty !");
		return;
	}
    action.setUsername(getUser());
    action.setPassword(getPassword());
    action.setLoginUrl(getHost());
    action.setSave(isSave());
    action.setAppCloud(isAppCloud());
    Authenticator.getInstance().setAppCloud(isAppCloud());
    
    if(login()){
    	try {
    		if (isSave) {
				 gitTempNode.removeNode();
				 ISecurePreferences preferences = SecurePreferencesFactory.getDefault();
				 ISecurePreferences node = preferences.node("GIT");
				 node.put("user",getUser(), true);
				 node.put("password",Authenticator.getInstance().getCredentials().getPassword(), true);
			}
		} catch (StorageException e) {
			 error.setText("Failed to save Credentials in secure storage");
			 log.error(e);
		}
    	super.okPressed();
    }else {
    	ErrorType errorcode = Authenticator.getInstance().getErrorcode();
    	switch (errorcode) {
        case INVALID:
        	    error.setText("Invalid username or password");
                break;
        case FAILD:
        	    error.setText(Authenticator.getInstance().getErrormsg());
                break;
        case ERROR:
        	   error.setText("Connection failed");
                break;
          }
    }
  }
   
  private boolean login() {
		boolean val = true;
		UserPasswordCredentials oldCredentials = null;
		String oldServerURL = null;
		setCursorBusy();
		try { 
			if(Authenticator.getInstance().isLoaded()){
				oldCredentials = Authenticator.getInstance().getCredentials();
				oldServerURL = Authenticator.getInstance().getServerURL();
			}
			
			credentials = new UserPasswordCredentials(getUser(),getPassword());	
			
			if(isAppCloud())
			{
				Map<String, String> tenants = CloudAdminServiceClient
						.getTenantDomains(new UserPasswordCredentials(getUser(), getPassword()));
				if(tenants.size()==0){
					error.setText(Messages.APP_CLOUD_ZERO_TENANTS_WARNING);
					val = false;
				}
				else if(tenants.size()==1){					
					Authenticator.getInstance().setSelectedTenant(tenants.entrySet().iterator().next().getValue());
					val = Authenticator.getInstance().Authenticate(JagApiProperties.getLoginUrl(), credentials); 
					
				}else{
					
					List<String[]> tenantList = new ArrayList<String[]>();
					
					for(Entry<String, String> tenant:tenants.entrySet()){
						
						tenantList.add(new String[]{tenant.getKey(), tenant.getValue()});
					}

					ListDialog dialog = getTenantSeclectionDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
					dialog.setInput(tenantList);
					
					String selectedTenant = getSelectedTenant(dialog);
					
					if(selectedTenant!=null)
					{
						Authenticator.getInstance().setSelectedTenant(selectedTenant);	
						val = Authenticator.getInstance().Authenticate(JagApiProperties.getLoginUrl(), credentials); 
					}else{
						
						val = false;
					}
					
				}
			}else{
				
				 	val = Authenticator.getInstance().Authenticate(JagApiProperties.getLoginUrl(), credentials); 
			}
			
		    if(val && isfromDashboad()){
		    	Authenticator.getInstance().setFromDashboad(isfromDashboad());
		    } 
		    resetCredintials(val, oldCredentials, oldServerURL);
		} catch (Exception e) {
	        log.error("Login failed", e);
	        error.setText("Login failed.");
	        setCursorNormal();
	        resetCredintials(val, oldCredentials, oldServerURL);
	        return false;
		} 
		setCursorNormal();
		return val;
	}
  
	private String getSelectedTenant(ListDialog dialog) {
		
		int feedback = dialog.open();
		
		if (feedback == Window.OK) {
			Object[] result = dialog.getResult();
			for (int i = 0; i < result.length; i++) {
				String[] ss = (String[]) result[i];
				return ss[1];
			}
		}
		else if (feedback == Window.CANCEL) {
			error.setText(Messages.APP_CLOUD_ORG_NOT_SELECT_ERROR);	
		}
		return null;
	}
  
    private ListDialog getTenantSeclectionDialog(Shell shell){
    	
    	ListDialog dialog = new ListDialog(shell);
    	dialog.setContentProvider(new ArrayContentProvider());
    	dialog.setTitle(Messages.TenantSelectionDialog_Title);
    	dialog.setMessage(Messages.TenantSelectionDialog_Title_2);
    	dialog.setLabelProvider(new ArrayLabelProvider());    	
    	return dialog;
    }
    
	private static class ArrayLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getText(Object element) {
			return ((String[]) element)[0].toString();
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		
		@Override
		public String getColumnText(Object element, int columnIndex) {
			String[] ss = (String[]) element;
			return ss[columnIndex];
		}
		
	}
    

private void resetCredintials(boolean val,
		UserPasswordCredentials oldCredentials, String oldServerURL) {
	if(!val){
		if(Authenticator.getInstance().isLoaded()){
			Authenticator.getInstance().setCredentials(oldCredentials);
			Authenticator.getInstance().setServerURL(oldServerURL);
	}else{
		Authenticator.getInstance().setCredentials(null);
	  }
	}
}
  
  private void hideDashboards(){
  	try {
  		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			List<IEditorReference> openEditors = new ArrayList<IEditorReference>();
			IEditorReference[] editorReferences = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for (IEditorReference iEditorReference : editorReferences) {
				if (DASHBOARD_VIEW_ID.equals(iEditorReference.getId())) {
					openEditors.add(iEditorReference);
				}
			}
			if (openEditors.size() > 0) {
				page.closeEditors(openEditors.toArray(new IEditorReference[] {}), false);
			}
		} catch (Exception e) {
			/* safe to ignore */
		}
  }
  
  private void setCursorNormal() {
		try {
			Display.getCurrent().getActiveShell().setCursor((new Cursor(Display.getCurrent(),
					SWT.CURSOR_ARROW)));
		} catch (Throwable e) {
			 /*safe to ignore*/
		}
  }
  private void setCursorBusy() {
		try {
			Display.getCurrent().getActiveShell().setCursor((new Cursor(Display.getCurrent(),
					SWT.CURSOR_WAIT)));
		} catch (Throwable e) {
			 /*safe to ignore*/
		}
	}
  
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


	public String getHost() {
		return host;
	}
	
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public boolean isSave() {
		return isSave;
	}
	
	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}
	
	public boolean isOT() {
		return isOT;
	}
	
	public void setOT(boolean isOT) {
		this.isOT = isOT;
	}
	
	public boolean isfromDashboad() {
		return fromDashboad;
	}
	
	public void setIsfromDashboad(boolean isfromDashboad) {
		this.fromDashboad = isfromDashboad;
	}
	public boolean isAppCloud() {
		return isAppCloud;
	}
	
	public void setAppCloud(boolean isAppCloud) {
		this.isAppCloud = isAppCloud;
	}
}