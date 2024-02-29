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
package org.wso2.integrationstudio.rcp.plugin.handler;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This class handles the splash events. We are using this to change the splash screen
 */
public class SplashHandler extends EclipseSplashHandler {

    private static final String PLUGIN_ID = "org.wso2.integrationstudio.rcp.plugin";
    private static final String BETA_PNG = "icons/version/420_4.png";
    private static final int BORDER = 165;
    private Image image;
    private static final String JAVA_VERSION_PROPERTY = "java.version";
    private static final String ALERT_TITLE = "Java Version Update Required";
    private static final String CONTINUE_BUTTON = "Continue";
    private static final String EXIT_BUTTON = "Exit";
    private static final String DOT_SEPARATOR = ".";

    public SplashHandler() {
        super();
    }

    /**
     * This method fires once the workspace is selected and splash screen is initializing.
     */
    @Override
    public void init(Shell splash) {
        if (Util.isMac() && System.getProperty("os.version").startsWith("14")) {
            configureShell(splash);
        }
        super.init(splash);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
    
    /**
     * Fix the splash screen flip issue in new Mac versions.
     * https://github.com/eclipse-platform/eclipse.platform.swt/issues/772
     * @param splash splash reference. 
     */
    private void configureShell(Shell splash) {        
        GC gc = new GC(splash.getBackgroundImage());
        Transform tr = new Transform(splash.getDisplay());
        tr.setElements(1, 0, 0, -1, 0, 0);
        gc.setTransform(tr);
        Point location = splash.toDisplay(0, 0);
        gc.drawImage(image, location.x , location.y);
        tr.dispose();
        gc.dispose();
    }
}
