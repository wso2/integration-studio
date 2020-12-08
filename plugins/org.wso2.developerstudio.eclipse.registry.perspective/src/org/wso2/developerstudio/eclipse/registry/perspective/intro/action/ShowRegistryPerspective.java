 /* Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.registry.perspective.intro.action;

import java.io.File;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.registry.perspective.Activator;

/**
 * Action handler for switch to WSO2 registry perspective
 *
 */
public class ShowRegistryPerspective extends Action {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public void run() {
		 try {
			 	IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	        	PlatformUI.getWorkbench().showPerspective("org.wso2.developerstudio.registry.remote.registry.pespective", window);
			} catch (Exception e) {
				log.error("Cannot open registry perspective",e);
			}
	}
	public String getText() {
		return "Switch to registry perspective";
	}
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.createFromImage(resizeImage(SWTResourceManager.getImage(this.getClass(), "/intro/css/graphics/registry.png"),16,16));
	}
	public String getDescription() {
		return "Switch to registry perspective";
	}
	
	private Image resizeImage(Image image, int width, int height) {
        Image scaled = new Image(Display.getDefault(), width, height);
        GC gc = new GC(scaled);
        gc.setAntialias(SWT.ON);
        gc.setInterpolation(SWT.HIGH);
        gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
        gc.dispose();
        return scaled;
    }

}
