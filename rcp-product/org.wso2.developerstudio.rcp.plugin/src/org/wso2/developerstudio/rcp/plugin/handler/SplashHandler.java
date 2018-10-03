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
package org.wso2.developerstudio.rcp.plugin.handler;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class SplashHandler extends EclipseSplashHandler {

    private static final String PLUGIN_ID = "org.wso2.developerstudio.rcp.plugin";
    private static final String BETA_PNG = "icons/version/420_4.png";
    private static final int BORDER = 165;
    private Image image;

    public SplashHandler() {
        super();
    }

    @Override
    public void init(Shell splash) {
        super.init(splash);
        ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, BETA_PNG);
        if (descriptor != null)
            image = descriptor.createImage();
        if (image != null) {
            final int xposition = splash.getSize().x - image.getImageData().width - 60;
            final int yposition = BORDER;
            getContent().addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    e.gc.drawImage(image, xposition, yposition);
                }
            });
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        if (image != null) {
            image.dispose();
        }
    }

}
