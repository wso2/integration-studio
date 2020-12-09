/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.core.utils;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Refreshable;

public class ESBUtils {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	protected final static String DIST_EDITOR_ID = "org.wso2.developerstudio.eclipse.distribution.project.editor.DistProjectEditor";

	/**
	 * This method will refresh opened Composite Application project pom
	 * editors. If there are new artifacts created we can call this method to
	 * get those artifacts into opened pom editor's artifact list.
	 */
	public static void refreshDistProjects() {
		try {
			IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getEditorReferences();
			for (IEditorReference reference : editorReferences) {
				if (DIST_EDITOR_ID.equals(reference.getId())) {
					IEditorPart editor = reference.getEditor(false);
					if (editor instanceof Refreshable) {
						Refreshable refreshable = (Refreshable) editor;
						refreshable.refresh();
					}
				}
			}
		} catch (Exception e) {
			log.warn("Cannot refresh Carbon application project list", e);
		}
	}
}
