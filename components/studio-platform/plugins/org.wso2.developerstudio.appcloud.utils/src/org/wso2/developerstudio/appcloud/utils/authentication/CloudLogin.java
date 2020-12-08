/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appcloud.utils.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.wso2.developerstudio.appcloud.utils.Activator;
import org.wso2.developerstudio.appcloud.utils.Messages;
import org.wso2.developerstudio.appcloud.utils.client.CloudAdminServiceClient;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CloudLogin {

	private UserPasswordCredentials credentials;
	private static Label error;
	private String selectedTenant;
	private boolean isAppCloud;
	private boolean isTenant;
	private String tenantString;
	
	public boolean isTenant() {
		return isTenant;
	}

	public void setTenant(boolean isTenant) {
		this.isTenant = isTenant;
	}

	public String getTenantString() {
		return tenantString;
	}

	public void setTenantString(String tenantString) {
		this.tenantString = tenantString;
	}

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public void setAppCloud(boolean isAppCloud) {
		this.isAppCloud = isAppCloud;
	}

	public boolean login(String user, String password) {
		boolean val = true;
		UserPasswordCredentials oldCredentials = null;
		String oldServerURL = null;
		setCursorBusy();
		try {
			if (Authenticator.getInstance().isLoaded()) {
				oldCredentials = Authenticator.getInstance().getCredentials();
				oldServerURL = Authenticator.getInstance().getServerURL();
			}

			credentials = new UserPasswordCredentials(user, password);

			if (isAppCloud()) {
				Map<String, String> tenants = CloudAdminServiceClient
						.getTenantDomains(new UserPasswordCredentials(user, password));
				if (tenants.size() == 0) {
					val = false;
				} else if (tenants.size() == 1) {
					Authenticator.getInstance().setSelectedTenant(tenants.entrySet().iterator().next().getValue());
					val = Authenticator.getInstance().Authenticate(JagApiProperties.getLoginUrl(), credentials);

				} else {

					List<String[]> tenantList = new ArrayList<String[]>();

					for (Entry<String, String> tenant : tenants.entrySet()) {

						tenantList.add(new String[] { tenant.getKey(), tenant.getValue() });
					}

					ListDialog dialog = getTenantSeclectionDialog(
							PlatformUI.getWorkbench().getDisplay().getActiveShell());
					dialog.setInput(tenantList);

					String selectedTenant = getSelectedTenant(dialog);

					if (selectedTenant != null) {
						setTenant(true);
						setTenantString(selectedTenant);
						Authenticator.getInstance().setSelectedTenant(selectedTenant);
						String tenantUser = user + "@" + selectedTenant;
						credentials = new UserPasswordCredentials(tenantUser, password);
						val = Authenticator.getInstance().Authenticate(JagApiProperties.getLoginUrl(), credentials);
					} else {

						val = false;
					}

				}
			} else {

				val = Authenticator.getInstance().Authenticate(JagApiProperties.getLoginUrl(), credentials);
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

	private boolean isAppCloud() {
		return isAppCloud;
	}

	private ListDialog getTenantSeclectionDialog(Shell shell) {

		ListDialog dialog = new ListDialog(shell);
		dialog.setContentProvider(new ArrayContentProvider());
		dialog.setTitle(Messages.TenantSelectionDialog_Title);
		dialog.setMessage(Messages.TenantSelectionDialog_Title_2);
		dialog.setLabelProvider(new ArrayLabelProvider());
		return dialog;
	}

	private static class ArrayLabelProvider extends LabelProvider implements ITableLabelProvider {
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

	private void setCursorNormal() {
		try {
			Display.getCurrent().getActiveShell().setCursor((new Cursor(Display.getCurrent(), SWT.CURSOR_ARROW)));
		} catch (Throwable e) {
			/* safe to ignore */
		}
	}

	private void setCursorBusy() {
		try {
			Display.getCurrent().getActiveShell().setCursor((new Cursor(Display.getCurrent(), SWT.CURSOR_WAIT)));
		} catch (Throwable e) {
			/* safe to ignore */
		}
	}

	private void resetCredintials(boolean val, UserPasswordCredentials oldCredentials, String oldServerURL) {
		if (!val) {
			if (Authenticator.getInstance().isLoaded()) {
				Authenticator.getInstance().setCredentials(oldCredentials);
				Authenticator.getInstance().setServerURL(oldServerURL);
			} else {
				Authenticator.getInstance().setCredentials(null);
			}
		}
	}

	public String getSelectedTenant() {
		return selectedTenant;
	}

	public void setSelectedTenant(String selectedTenant) {
		this.selectedTenant = selectedTenant;
	}

	@SuppressWarnings("unused")
	private static String getSelectedTenant(ListDialog dialog) {

		int feedback = dialog.open();

		if (feedback == Window.OK) {
			Object[] result = dialog.getResult();
			for (int i = 0; i < result.length; i++) {
				String[] ss = (String[]) result[i];
				return ss[1];
			}
		} else if (feedback == Window.CANCEL) {
			error.setText(Messages.APP_CLOUD_ORG_NOT_SELECT_ERROR);
		}
		return null;
	}

}
