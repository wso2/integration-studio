/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.welcome.perspective.intro.action;

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
import org.wso2.developerstudio.eclipse.welcome.perspective.Activator;

/**
 * Action handler for switch to WSO2 welcome perspective
 *
 */
public class ShowWelcomePerspective extends Action {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public void run() {
        try {
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            PlatformUI.getWorkbench().showPerspective("WELCOME_PERSPECTIVE", window);
        } catch (Exception e) {
            log.error("Cannot open welcome perspective", e);
        }
    }

    public String getText() {
        return "Switch to welcome perspective";
    }

    public ImageDescriptor getImageDescriptor() {
        return ImageDescriptor
                .createFromImage(
                        resizeImage(
                                SWTResourceManager.getImage(this.getClass(), "/intro/css/graphics/welcome.png"),
                                16, 16));
    }

    public String getDescription() {
        return "Switch to welcome perspective";
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
