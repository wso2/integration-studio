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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.AbstractEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;

public class GraphicalEditorStartupUtils implements Openable {

	@Override
	public void editorOpen(String name, String type, String locatioin,
			String source) throws Exception {
         Integer val =null;
		if (name.indexOf(".") > 0) {
			name = name.substring(0, name.lastIndexOf("."));
		}
		if(type.contains("endpoint")){
			String[] types = type.split("-");
			if(types.length>1){
			type=types[0];
			val = new Integer(types[1]);
			}
		}
		locatioin = locatioin.replace("synapse-config",
				"graphical-synapse-config");
		Resource diagram = EsbDiagramEditorUtil.createDiagram(
				URI.createPlatformResourceURI(locatioin + name
						+ EditorUtils.DIAGRAM_FILE_EXTENSION, false),
				URI.createPlatformResourceURI(locatioin + name
						+ EditorUtils.DOMAIN_FILE_EXTENSION, false),
				new NullProgressMonitor(), type, name, val);
		
		String path = diagram.getURI().toPlatformString(true);
		IFile diagramFile = (IFile) ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(path));
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IEditorPart openEditor = activePage.openEditor(new FileEditorInput(
				diagramFile), EsbDiagramEditor.ID);
		EsbMultiPageEditor multipageEitor = ((EsbMultiPageEditor) openEditor);
		final EsbDiagramEditor graphicalEditor = multipageEitor
				.getGraphicalEditor();
		Deserializer deserializer = Deserializer.getInstance();
		deserializer.updateDesign(source, graphicalEditor);
		Display.getCurrent().asyncExec(new Runnable() {
			
			public void run() {
				AbstractEsbNodeDeserializer.relocateStartNodes();
				graphicalEditor.doSave(new NullProgressMonitor());
				EditorUtils.setLockmode(graphicalEditor, false);
			}
		});
		
		if("endpoint".equals(type)){
			EditorUtils.updateToolpalette();
		}else if("sequence".equals(type)){
			EditorUtils.updateToolpalette();
		}
	}
}
