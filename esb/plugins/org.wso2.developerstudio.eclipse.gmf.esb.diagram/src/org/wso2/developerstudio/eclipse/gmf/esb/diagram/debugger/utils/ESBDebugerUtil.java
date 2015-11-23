/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class consists exclusively of reusable static methods used by ESB
 * Mediation Debugger implementation.
 *
 */
public class ESBDebugerUtil {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * This method will handle an error occurred in the application. The thrown
	 * exception will be logged using {@link IDeveloperStudioLog} and also pop
	 * up an error Dialog of {@link ErrorDialog} mentioning the given message
	 * and occurred exception.
	 * 
	 * @param ex
	 * @param message
	 * @see ErrorDialog
	 * @see IStatus
	 */
	public static void popUpErrorDialogAndLogException(Exception ex,
			final String message) {
		log.error(message, ex);
		String simpleMessage = ex.getMessage();
		final IStatus editorStatus = new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, simpleMessage);
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				ErrorDialog.openError(Display.getDefault().getActiveShell(),
						Messages.ESBDebugerUtil_ErrorDialogTitle, message,
						editorStatus);

			}
		});
	}

}
