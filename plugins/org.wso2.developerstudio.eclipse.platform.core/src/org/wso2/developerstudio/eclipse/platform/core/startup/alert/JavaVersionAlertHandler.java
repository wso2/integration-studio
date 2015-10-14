/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.platform.core.startup.alert;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

/**
 * A Startup class that checks whether Developer Studio has started with a suitable Java version.
 * If not, it will show a warning message to user to update the Java version.
 */
public class JavaVersionAlertHandler implements IStartup {
    private static final String JAVA_VERSION_PROPERTY = "java.version";
    private static final String ALERT_TITLE = "Java Version Update Required";
    private static final String CONTINUE_BUTTON = "Continue";
    private static final String EXIT_BUTTON = "Exit";
    private static final String DOT_SEPARATOR = ".";

    @Override
    public void earlyStartup() {
        final String version = System.getProperty(JAVA_VERSION_PROPERTY);
       
        //If Developer Studio starts with an unsupported version, then show a warning
        double detectedJavaVersion = getJavaVersionInDouble(version);
        if (detectedJavaVersion < Constants.MINIMUM_REQUIRED_JAVA_VERSION) {
            final IWorkbench workbench = PlatformUI.getWorkbench();
            workbench.getDisplay().asyncExec(new Runnable() {
                public void run() {
                    if (workbench.getDisplay() != null) {
                        Shell shell = new Shell(workbench.getDisplay());

                        Monitor primaryMonitor = workbench.getDisplay().getPrimaryMonitor();
                        Rectangle primaryBounds = primaryMonitor.getBounds();
                        Rectangle shellBounds = shell.getBounds();

                        //Calculating center position to show message dialog
                        int xCenter = primaryBounds.x + (primaryBounds.width - shellBounds.width) / 2;
                        int yCenter = primaryBounds.y + (primaryBounds.height - shellBounds.height) / 2;

                        shell.setLocation(xCenter, yCenter);

                        String warningMessage = Constants.DETECTED_JAVA_VERSION_MESSAGE + version + "\n" +
                                Constants.RECOMMENDED_JAVA_VERSION_MESSAGE + Constants.MINIMUM_REQUIRED_JAVA_VERSION
                                + ".x" + "\n" +
                                Constants.JAVA_VERSION_ALERT_MESSAGE + "\n" + 
                                Constants.JAVA_VERSION_CONTINUE_MESSAGE;
                        MessageDialog dialog = new MessageDialog(shell, ALERT_TITLE, null, warningMessage,
                                MessageDialog.ERROR, new String[]{CONTINUE_BUTTON, EXIT_BUTTON}, 0) {
                            protected void buttonPressed(int buttonId) {
                                if (buttonId  == 1) {
                                    System.exit(0);
                                }
                                super.buttonPressed(buttonId);
                            }
                        };
                        dialog.open();
                    }
                }
            });
        }
    }

    /**
     * Method that returns Java version as a double value
     * For example, if 1.7.0_67 is given as input it will return 1.7
     */
    private double getJavaVersionInDouble(String version) {
        String[] versionElements = version.split("\\.");
        String desiredVersionElements = versionElements[0] + DOT_SEPARATOR + versionElements[1];
        return Double.parseDouble(desiredVersionElements);
    }
}
