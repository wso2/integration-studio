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

package org.wso2.developerstudio.eclipse.ui.utils;

import java.io.File;

import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;

public class UIDialogs {
	public static File getSavePath(Shell shell,String message){
    	String fileName = null;
    	DirectoryDialog dlg = new DirectoryDialog(shell);
    	//dlg.setFilterExtensions(new String[]{".zip"});
        boolean done = false;
        dlg.setMessage(message);
        File file = null; 
        while (!done) {
          // Open the File Dialog
          fileName = dlg.open();
          if (fileName == null) {
            // User has cancelled, so quit and return
            done = true;
          } else {
            // User has selected a file; see if it already exists
            file = new File(fileName);
            if (file.exists()) {
              // If they click Yes, we're done and we drop out. If
              // they click No, we redisplay the File Dialog
              done = true;
            } else {
              // File does not exist, so drop out
              done = false;
            }
          }
        }
        return file;
    }
}
