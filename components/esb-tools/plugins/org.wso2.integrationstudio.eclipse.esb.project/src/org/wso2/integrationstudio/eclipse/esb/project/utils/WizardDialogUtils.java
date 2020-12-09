/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.eclipse.esb.project.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Contains the utils used by wizards
 *
 */
public class WizardDialogUtils {
 
    static int isCanceled = 0;
    
    /**
     * Shows error pop ups
     * 
     * @param message
     * @param title
     */
    public static void showErrorMessage(String message, String title) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, SWT.ICON_ERROR);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }

    /**
     * Show success message pop up
     * 
     * @param message
     * @param title
     */
    public static int showSuccessMessage(String message, String title, boolean isCancelEnabled) {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg;
                if (isCancelEnabled) {
                    exportMsg = new MessageBox(shell, SWT.ICON_WORKING | SWT.OK | SWT.CANCEL);
                } else {
                    exportMsg = new MessageBox(shell, SWT.ICON_WORKING);
                }
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                isCanceled = exportMsg.open();
            }
        });
        
        return isCanceled;
    }

}
