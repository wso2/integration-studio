/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.AbstractEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.EsbDeserializerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.apache.commons.io.FileUtils;

public class OpenEditorUtils {

	private static IDeveloperStudioLog log =
	                                         Logger.getLog("org.wso2.developerstudio.eclipse.gmf.esb.diagram");

	public void openSeparateEditor(IFile fileTobeOpened, String diagramPath) {
		IResource workspaceResource =
		                              ResourcesPlugin.getWorkspace().getRoot()
		                                             .findMember(new Path(diagramPath));
		try {
			if (workspaceResource instanceof IFile) {
				final String source =
				                      FileUtils.readFileToString(fileTobeOpened.getLocation()
				                                                               .toFile());

				IWorkbenchPage page =
				                      PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				                                .getActivePage();
				IEditorPart editorPart =
				                         page.openEditor(new FileEditorInput(
				                                                             (IFile) workspaceResource),
				                                         EsbDiagramEditor.ID);
				EsbMultiPageEditor editor = (EsbMultiPageEditor) editorPart;
				final EsbDiagramEditor subDiagramEditor = editor.getGraphicalEditor();
				if (subDiagramEditor != null) {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {

							EsbDeserializerRegistry.getInstance().init(subDiagramEditor);
							Deserializer deserializer = Deserializer.getInstance();
							try {

								deserializer.updateDesign(source, subDiagramEditor);
								AbstractEsbNodeDeserializer.relocateStartNodes();
								subDiagramEditor.doSave(new NullProgressMonitor());
								EditorUtils.setLockmode(subDiagramEditor, false);
							} catch (Exception e) {
								log.error("Error occured while deserializing ", e);
							}

						}
					});
				}

			}
		} catch (PartInitException e) {
			log.error("Error occured while opening a separate editor", e);
		} catch (IOException e) {
			log.error("Error occured while opening a separate editor", e);
		}
	}
}
