/*
 * Copyright (c) 2013-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class OpenEditorUtils {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * Open the ESB diagram editor for the given ESB configuration file  
	 * @param fileTobeOpened
	 */
	public IEditorPart openSeparateEditor(IFile fileTobeOpened) {
		try {
			final String source = FileUtils.readFileToString(fileTobeOpened.getLocation().toFile());
			final Deserializer deserializer = Deserializer.getInstance();
			ArtifactType artifactType = null;
			try {
				artifactType = deserializer.getArtifactType(source);
			} catch (Exception e1) {
				log.error("Error occured while getting artifact type for the given ESB configuration ", e1);
			}
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorPart openEditor = activePage.openEditor(
					new EsbEditorInput(null, fileTobeOpened, artifactType.getLiteral()), EsbDiagramEditor.ID, true, IWorkbenchPage.MATCH_INPUT);

			return openEditor;
		} catch (PartInitException e) {
			log.error("Error occured while opening a separate editor", e);
		} catch (IOException e) {
			log.error("Error occured while opening a separate editor", e);
		}
		return null;
	}
	
}
