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

package org.wso2.developerstudio.appfactory.core.repository;

import java.util.concurrent.atomic.AtomicReference;


import org.eclipse.jgit.errors.UnsupportedCredentialItem;
import org.eclipse.jgit.transport.CredentialItem;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.appfactory.core.authentication.UserPasswordCredentials;
 
public class JgitCredentialProvider extends CredentialsProvider{

	
	private String user;
	private String password;
	
	public JgitCredentialProvider(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	@Override
	public boolean get(final URIish uri, final CredentialItem... items)
			throws UnsupportedCredentialItem {
		if (items.length == 0) {
			return true;
		}

		CredentialItem.Username userItem = null;
		CredentialItem.Password passwordItem = null;
		boolean isSpecial = false;

		for (CredentialItem item : items) {
			if (item instanceof CredentialItem.Username)
				userItem = (CredentialItem.Username) item;
			else if (item instanceof CredentialItem.Password)
				passwordItem = (CredentialItem.Password) item;
			else
				isSpecial = true;
		}

		if (!isSpecial && (userItem != null || passwordItem != null)) {
			UserPasswordCredentials credentials = null;
			if ((user != null) && (password != null))
				credentials = new UserPasswordCredentials(user, password);
			else
				credentials = getCredentialsFromSecureStore(uri);

			if (credentials == null) {
				credentials = getCredentialsFromUser(uri);
				if (credentials == null)
					return false;
			}
			if (userItem != null)
				userItem.setValue(credentials.getUser());
			if (passwordItem != null)
				passwordItem.setValue(credentials.getPassword().toCharArray());
			return true;
		}

		// special handling for non-user,non-password type items
		final boolean[] result = new boolean[1];

		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();

				if (items.length == 1) {
					CredentialItem item = items[0];
					//result[0] = getSingleSpecial(shell, uri, item);
				} else {
					//result[0] = getMultiSpecial(shell, uri, items);
				}
			}
		});

		return result[0];
	}

	@Override
	public boolean isInteractive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(CredentialItem... items) {
		for (CredentialItem i : items) {
			if (i instanceof CredentialItem.StringType)
				continue;
			else if (i instanceof CredentialItem.CharArrayType)
				continue;
			else if (i instanceof CredentialItem.YesNoType)
				continue;
			else if (i instanceof CredentialItem.InformationalMessage)
				continue;
			else
				return false;
		}
		return true;
	}

	private UserPasswordCredentials getCredentialsFromUser(final URIish uri) {
		final AtomicReference<UserPasswordCredentials> aRef = new AtomicReference<UserPasswordCredentials>(
				null);
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				//aRef.set(LoginService.login(shell, uri));
			}
		});
		return aRef.get();
	}

	private UserPasswordCredentials getCredentialsFromSecureStore(final URIish uri) {
		UserPasswordCredentials credentials = null;
		/*try {
			credentials = Activator.getDefault().getSecureStore()
					.getCredentials(uri);
		} catch (StorageException e) {
			Activator.logError(
					UIText.EGitCredentialsProvider_errorReadingCredentials, e);
		}*/
		return credentials;
	}
	
}
