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

package org.wso2.developerstudio.eclipse.registry.base.ui.util;

import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ObjectPluginAction;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.CredentialsDialog;

public class SWTControlUtils {

	/**
	 * create label
	 * @param parent
	 * @param style
	 * @param text
	 * @param layoutData
	 * @param backColor
	 * @param font
	 * @return
	 */
	public static Label createLabel(Composite parent, 
									int style, 
									String text,
									Object layoutData, 
									Color backColor, 
									Font font) {
		Label lbl = new Label(parent, style);
		if (font != null){
			lbl.setFont(font);
		}
		if (backColor != null){
			lbl.setBackground(backColor);
		}
		lbl.setText(text);
		if (layoutData != null){
			lbl.setLayoutData(layoutData);
		}
		return lbl;
	}

	/**
	 * request for credentials
	 * @param shell
	 * @param registryUrl
	 * @param username
	 * @return
	 */
	public static Credentials requestCredentials(Shell shell,
												 String registryUrl, 
												 String username){
		CredentialsDialog dialog = new CredentialsDialog(shell, 
														 registryUrl,
														 username);
		dialog.setBlockOnOpen(true);
		dialog.create();
		dialog.getShell().setSize(450, 198);
		int status = dialog.open();
		if (status == dialog.OK) {
			Credentials credentials = new Credentials();
//			if(dialog.getUserName().equals(RegistryCredentialData.getInstance().getUsername(registryUrl)) &&
//					dialog.getPasswd().equals(RegistryCredentialData.getInstance().getPassword(registryUrl))){
				credentials.setUsername(dialog.getUserName());
				credentials.setPassword(dialog.getPasswd());
				if (dialog.isSavePassword()) {
					RegistryCredentialData.getInstance().setCredentials(registryUrl, credentials);
				}
				return credentials;
//			}else{
//				return null;
//			}
       } else if(status==dialog.CANCEL){
        	dialog.close();
        	//return new Credentials();
		} 
			return null;	
	}

	/**
	 * derive selection
	 * @param arg
	 * @return
	 */
	public static Object deriveSelection(Object arg) {
		if (arg instanceof ObjectPluginAction) {
			ObjectPluginAction obj = (ObjectPluginAction) arg;
			arg = obj.getSelection();
		}
		if (arg instanceof TreeSelection) {
			TreeSelection tree = (TreeSelection) arg;
			return tree.getFirstElement();
		}
		return null;
	}

	/**
	 * close associated editor
	 * @param editorInput
	 */
	public static void closeAssociatedEditor(IEditorInput editorInput) {
		if (editorInput == null){
			return;
		}
		IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
		IWorkbenchPage correctPage = null;
		IEditorPart editorPart = null;
		for (IWorkbenchPage page : pages) {
			if (page.getActiveEditor() != null
					&& page.getActiveEditor().getEditorInput() == editorInput) {
				correctPage = page;
				editorPart = page.getActiveEditor();
				break;
			}
		}
		if (correctPage != null) {
			correctPage.activate(editorPart);
			correctPage.closeEditor(editorPart, false);
		}

	}
}
