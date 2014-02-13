/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.perspective;

	
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Responsible for generating the "WSO2 ESB Tools" perspective.
 */
public class EsbToolsPerspective implements IPerspectiveFactory {

	private static final String PROPERTIES_VIEW_ID = "org.eclipse.ui.views.PropertySheet";
		
	public void createInitialLayout(IPageLayout perspectiveLayout) {
		defineAction(perspectiveLayout);
		defineLayout(perspectiveLayout);		
	}

	public void defineAction(IPageLayout layout) {
		layout.addShowViewShortcut(PROPERTIES_VIEW_ID);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
	}

	public void defineLayout(IPageLayout layout) {
		IFolderLayout bottomArea = layout.createFolder("bottomArea",
				IPageLayout.BOTTOM, (float) 0.70, layout.getEditorArea());
		bottomArea.addView(PROPERTIES_VIEW_ID);
		
		IFolderLayout leftArea = layout.createFolder("leftArea",
				IPageLayout.LEFT, (float) 0.20, layout.getEditorArea());
		leftArea.addView(IPageLayout.ID_PROJECT_EXPLORER);
		
		IFolderLayout rightArea = layout.createFolder("rightArea",
				IPageLayout.RIGHT, (float) 0.80, layout.getEditorArea());
		rightArea.addView(IPageLayout.ID_OUTLINE);	
	}
}
