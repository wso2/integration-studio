/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;


public class JSEmbeddedFunctions {
    
    private static final String J2EE_PERSPECTIVE = "org.eclipse.jst.j2ee.J2EEPerspective";
    private static final String PORT_PROPERTIES = "serverproperties.js";
    private static final String WELCOME_PAGE_WEB_SITE_FOLDER = "TemplateDash";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    /**
     * Opens a eclipse wizard when wizard ID is given
     * @param id Wizard ID
     * @throws CoreException
     */
    public void openWizard(String id) throws CoreException {
        // First see if this is a "new wizard".
        IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
        // If not check if it is an "import wizard".
        if (descriptor == null) {
            descriptor = PlatformUI.getWorkbench().getImportWizardRegistry().findWizard(id);
        }
        // Or maybe an export wizard
        if (descriptor == null) {
            descriptor = PlatformUI.getWorkbench().getExportWizardRegistry().findWizard(id);
        }
        // Then if we have a wizard, open it.
        if (descriptor != null) {
            IWizard wizard = descriptor.createWizard();
            WizardDialog wd = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
            wd.setTitle(wizard.getWindowTitle());
            if (wd.open() == WizardDialog.OK) {
                try {
                    PlatformUI.getWorkbench().showPerspective(J2EE_PERSPECTIVE,
                            PlatformUI.getWorkbench().getActiveWorkbenchWindow());
                } catch (WorkbenchException e) {
                    log.error("Error while opening J2EE perspective.", e);
                }
            }
        }
    }
    
    /**
     * Get wizard link contributions json
     * @return json of the wizard links along with categories
     */
    public String getWizardsList() {
        return DashboardContributionsHandler.getCategoriesJson();
    }
    
    /**
     * Get Description of the wizard when ID is given
     * @param id wizard id
     * @return Description of the wizard
     */
    public String getDescription(String id) throws CoreException {
        // First see if this is a "new wizard".
        IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
        // If not check if it is an "import wizard".
        if (descriptor == null) {
            descriptor = PlatformUI.getWorkbench().getImportWizardRegistry().findWizard(id);
        }
        // Or maybe an export wizard
        if (descriptor == null) {
            descriptor = PlatformUI.getWorkbench().getExportWizardRegistry().findWizard(id);
        }
        // Then if we have a wizard, open it.
        if (descriptor != null) {
            // IWizard wizard = descriptor.createWizard();
            return descriptor.getDescription();
        }
        return null;
    }
    
    /**
     * Get Name of the wizard when ID is given
     * @param id wizard id
     * @return name of the wizard
     */
    public String getName(String id) {
        // First see if this is a "new wizard".
        IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
        // If not check if it is an "import wizard".
        if (descriptor == null) {
            descriptor = PlatformUI.getWorkbench().getImportWizardRegistry().findWizard(id);
        }
        // Or maybe an export wizard
        if (descriptor == null) {
            descriptor = PlatformUI.getWorkbench().getExportWizardRegistry().findWizard(id);
        }
        // Then if we have a wizard, open it.
        if (descriptor != null) {
            // IWizard wizard = descriptor.createWizard();
            return descriptor.getLabel();
        }
        return null;
    }
    
    /**
     * This method writes the port value to js file in web app so that app_new js can read it directly
     * @param port port to be written
     * @throws URISyntaxException
     * @throws IOException
     */
    public void writePortValue(int port) throws URISyntaxException, IOException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL webAppURL = bundle.getEntry(WELCOME_PAGE_WEB_SITE_FOLDER);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        File resolvedWebAppIndex = new File(resolvedWebAppFolder, PORT_PROPERTIES);
        String path = resolvedWebAppIndex.getAbsolutePath();
        String str = contructJSProperty(port);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(str);         
        writer.close();
    }

    /**
     * This method sets resolved port value to eclipse preferences(Global registry)
     * @param port port to be written
     */
    public void setPortGlobalVariable(int port) {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        rootNode.put("portDetails", String.valueOf(port));
    }
    
    private String contructJSProperty(int port) {
        StringBuilder sb = new StringBuilder();
        sb.append("serverDetails = {\n" + 
                "  port: '"+port+"',\n" +
                "}");
        return sb.toString();
    }
}
