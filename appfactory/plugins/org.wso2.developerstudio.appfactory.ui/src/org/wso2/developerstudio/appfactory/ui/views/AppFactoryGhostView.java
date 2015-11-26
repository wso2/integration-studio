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

package org.wso2.developerstudio.appfactory.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class AppFactoryGhostView extends ViewPart{

	@Override
	public void createPartControl(Composite parent) {
	
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					IWorkbench workbench = PlatformUI.getWorkbench();
			    	IPerspectiveDescriptor perspective = workbench.getActiveWorkbenchWindow().getActivePage().getPerspective();
			    	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closePerspective(perspective, false, true);	
				} catch (Exception e) {
					/*Ignore*/ //$NON-NLS-1$
				}

			}
		});
	}

	@Override
	public void setFocus() {
	}
}
