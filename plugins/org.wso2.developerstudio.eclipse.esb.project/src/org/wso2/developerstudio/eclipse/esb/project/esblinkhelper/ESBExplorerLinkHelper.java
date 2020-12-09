/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.project.esblinkhelper;

import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;

public class ESBExplorerLinkHelper implements ILinkHelper{

	@Override
	public void activateEditor(IWorkbenchPage arg0, IStructuredSelection arg1) {
		
	}

	@Override
	public IStructuredSelection findSelection(IEditorInput iEditorInput) {
		
		if(iEditorInput instanceof FileEditorInput){
			return getSelection((FileEditorInput) iEditorInput);
		}
		
		return StructuredSelection.EMPTY;
	}
	
	public IStructuredSelection getSelection(FileEditorInput fei){
		
		String filePath = fei.getFile().getFullPath().toOSString();
		
		filePath = filePath.replaceAll(Pattern.quote("\\"), "/"); 
		filePath = filePath.replaceAll("/graphical-synapse-config/", "/synapse-config/");
		filePath = filePath.replaceAll("/(endpoint_|localentry_|proxy_|sequence_|task_|template_|api_)", "/");
		filePath = filePath.replaceAll("esb_diagram$", "xml");	
		 
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePath));
		
		
		return new StructuredSelection(file);
		
	}

}
