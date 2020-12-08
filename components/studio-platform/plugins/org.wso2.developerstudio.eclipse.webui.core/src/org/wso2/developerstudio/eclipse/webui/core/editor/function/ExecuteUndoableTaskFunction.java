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
package org.wso2.developerstudio.eclipse.webui.core.editor.function;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.commands.operations.UndoContext;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;
import org.wso2.developerstudio.eclipse.webui.core.editor.Constants;
import org.wso2.developerstudio.eclipse.webui.core.editor.operation.UndoableBrowserOperation;

public class ExecuteUndoableTaskFunction extends AbstractWebEditorFunction {

	protected UndoContext undoContext;
	
	public ExecuteUndoableTaskFunction(AbstractWebBasedEditor editor) {
		super(editor, Constants.IDE_EXEC_UNDOABLE_OPERATION_FUNCTION);
		this.undoContext = editor.getUndoContext();
	}

	@Override
	public Object function(Object[] arguments) {

		String label = (String) arguments[0];
		String uniqueOpID = (String) arguments[1];

		IUndoableOperation operation = new UndoableBrowserOperation(label,
				uniqueOpID, editor);
		operation.addContext(undoContext);
		try {
			OperationHistoryFactory.getOperationHistory().execute(
					operation, null, null);
			return true;
		} catch (ExecutionException e) {
			log.error("Error executing undoable operation.", e);
			return false;
		}
	}
}
