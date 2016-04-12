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
package org.wso2.developerstudio.webeditor.model;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.browser.Browser;

public class UndoalbleOperationTest extends AbstractOperation {

	private Browser browser;
	
	public UndoalbleOperationTest(String label) {
		super(label);
	}

	@Override
	public IStatus execute(IProgressMonitor arg0, IAdaptable arg1)
			throws ExecutionException {
		String newContent = "Executing main operation for " + getLabel();
		String script = "var data ={'data' : {'_type':1, 'filePath':'c:/ssdsd.xml', 'content':'"
				+ newContent + "'}};receiveMessage(data);";
		browser.execute(script);
		return Status.OK_STATUS;
	}

	@Override
	public IStatus redo(IProgressMonitor arg0, IAdaptable arg1)
			throws ExecutionException {
		String newContent = "Executing redo operation for " + getLabel();
		String script = "var data ={'data' : {'_type':1, 'filePath':'c:/ssdsd.xml', 'content':'"
				+ newContent + "'}};receiveMessage(data);";
		browser.execute(script);
		return Status.OK_STATUS;
	}

	@Override
	public IStatus undo(IProgressMonitor arg0, IAdaptable arg1)
			throws ExecutionException {
		String newContent = "Executing undo operation for " + getLabel();
		String script = "var data ={'data' : {'_type':1, 'filePath':'c:/ssdsd.xml', 'content':'"
				+ newContent + "'}};receiveMessage(data);";
		browser.execute(script);
		return Status.OK_STATUS;
	}

}
