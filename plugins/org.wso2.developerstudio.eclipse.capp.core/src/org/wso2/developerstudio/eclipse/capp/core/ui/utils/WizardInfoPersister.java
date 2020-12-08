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

package org.wso2.developerstudio.eclipse.capp.core.ui.utils;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class WizardInfoPersister {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private DialogSettings settings;
	private String filename;

	public void addControl(final Control control, final String ID) throws IOException{
		IPath path = Activator.getDefault().getStateLocation();
		filename = path.append("settings.txt").toOSString();
		File file = new File(filename);
		if(!file.exists()){
			file.createNewFile();
		}
		if(settings == null){
			settings = new DialogSettings("Top");
		}
		settings.load(filename);
	
		if(control instanceof Text){
			((Text) control).addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent arg0) {
					if (settings != null) {
						settings.put(ID, ((Text) control).getText());
						try {
							settings.save(filename);
						} catch (IOException e) {
							log.error(e);
						}
					}
				}
			});
	        String temp="";
	        if(settings != null){
	        	try {
					settings.load(filename);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        	 temp = settings.get(ID);
	        }
	        if(temp != null){
	        	((Text) control).setText(temp);
	        }
		}

	}
}
