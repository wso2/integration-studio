/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.platform.core.intro.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;

public class OpenDashboardAction extends Action implements IIntroAction {

    private static IDeveloperStudioLog log = Logger.getLog(DashboardActivator.PLUGIN_ID);
    static final String DASHBOARD_VIEW_ID = "org.wso2.developerstudio.eclipse.dashboard";

    public void run(IIntroSite introSite, Properties properties) {
        final IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
        PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        try {
            hideDashboards();
            PlatformUI.getWorkbench().showPerspective("org.eclipse.jst.j2ee.J2EEPerspective", window);
            ProjectPresentation.setHierarchicalProjectPresentation();
            page.openEditor(new NullEditorInput(), DASHBOARD_VIEW_ID);
        } catch (Exception e) {
            log.error("Cannot open dashboard", e);
        }
    }

    /**
     * hide open dashboards
     */
    private void hideDashboards() {
        try {
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage page = window.getActivePage();
            List<IEditorReference> openEditors = new ArrayList<IEditorReference>();
            IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .getEditorReferences();
            for (IEditorReference iEditorReference : editorReferences) {
                if (DASHBOARD_VIEW_ID.equals(iEditorReference.getId())) {
                    openEditors.add(iEditorReference);
                }
            }
            if (openEditors.size() > 0) {
                page.closeEditors(openEditors.toArray(new IEditorReference[] {}), false);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    class NullEditorInput implements IEditorInput {

        public boolean exists() {
            return true;
        }

        public ImageDescriptor getImageDescriptor() {
            return ImageDescriptor.getMissingImageDescriptor();
        }

        public String getName() {
            return "Kernel Dashboard";
        }

        public IPersistableElement getPersistable() {
            return null;
        }

        public String getToolTipText() {
            return "Developer Studio Dashboard";
        }

        public Object getAdapter(Class adapter) {
            return null;
        }
    }

}
