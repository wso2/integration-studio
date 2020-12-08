/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class MessageDialogUtils {
	private static final String COMMON_TITLE = "Developer Studio";

	public static void info(Shell shell, String message) {
		info(shell, message, COMMON_TITLE);
	}

	public static void info(Shell shell, String title, String message) {
		MessageDialog.openInformation(shell, title, message);
	}

	public static void error(Shell shell, Exception e) {
		error(shell, e.getMessage(), e);
	}

	public static void error(Shell shell, String message, Exception e) {
		error(shell, message, COMMON_TITLE, e);
	}

	public static void error(Shell shell, String message, String title, Exception e) {
		MessageDialog.openError(shell, title, message);
	}

	public static void error(Shell shell, String title, String message) {
		MessageDialog.openError(shell, title, message);
	}

	public static void error(Shell shell, String message) {
		MessageDialog.openError(shell, COMMON_TITLE, message);
	}

	public static boolean question(Shell shell, String message) {
		return MessageDialog.openQuestion(shell, COMMON_TITLE, message);
	}

	public static MultiStatus createMultiStatus(String msg, Throwable t, String packageID) {

		List<Status> childStatuses = new ArrayList<>();
		StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

		for (StackTraceElement stackTrace : stackTraces) {
			Status status = new Status(IStatus.ERROR, packageID, stackTrace.toString());
			childStatuses.add(status);
		}

		MultiStatus ms = new MultiStatus(packageID, IStatus.ERROR, childStatuses.toArray(new Status[] {}),
		                                 t.toString(), t);
		return ms;
	}
}
