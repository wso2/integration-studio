/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.ds.presentation.custom.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Data service editor perspective
 *
 */
public class DataServiceEditorPerspective implements IPerspectiveFactory {
    
    private static final String TEMPLATE_GUIDE_VIEW = "org.wso2.developerstudio.eclipse.esb.templates.view";

    public void createInitialLayout(IPageLayout perspectiveLayout) {
        defineAction(perspectiveLayout);
        defineLayout(perspectiveLayout);
    }

    public void defineAction(IPageLayout layout) {
        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
        // Add eclipse launch action set including running and debugging tool buttons
        layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
    }

    public void defineLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();
        // Top left: Project Explorer
        IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.15f, editorArea);
        topLeft.addView(IPageLayout.ID_PROJECT_EXPLORER);
        
        IFolderLayout rightPane = layout.createFolder("right", IPageLayout.RIGHT, 0.75f, editorArea);
        rightPane.addView(TEMPLATE_GUIDE_VIEW);
    }
}
