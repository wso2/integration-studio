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

package org.wso2.developerstudio.appfactory.ui.perspective;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;

public class AppFactoryPerspectiveManager implements IStartup {

	static boolean val;
	@Override
	public void earlyStartup() {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (workbenchWindow != null) {
                    workbenchWindow.addPerspectiveListener(new PerspectiveAdapter() {
                        @Override
                        public void perspectiveActivated(IWorkbenchPage page,
                                IPerspectiveDescriptor perspectiveDescriptor) {
                          //  super.perspectiveActivated(page, perspectiveDescriptor);
                            if("org.wso2.developerstudio.appfactory.ui.perspective".equals(perspectiveDescriptor.getId())){
                            	
                            	try {
                            		if(val){
                            		  //PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closePerspective(perspectiveDescriptor, true, true);
                            	  //	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().setPerspective(perspectiveDescriptor);
                            	    //  PlatformUI.getWorkbench().showPerspective("org.eclipse.jst.j2ee.J2EEPerspective", PlatformUI.getWorkbench().getActiveWorkbenchWindow());
                            	   PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closePerspective(perspectiveDescriptor, false, true);

                            		}
                            	} catch (Exception e) {
                            		
								}
                            }
                        }
                    });
                }
            }
        });
    }
}
