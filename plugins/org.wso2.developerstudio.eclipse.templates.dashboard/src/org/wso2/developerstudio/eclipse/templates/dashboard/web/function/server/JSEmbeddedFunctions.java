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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;


public class JSEmbeddedFunctions {
    
    private static final String PORT_PROPERTIES = "serverproperties.js";
    private static final String WELCOME_PAGE_WEB_SITE_FOLDER = "WelcomeDashboard";
	private static final String DISABLE_WELCOME_PAGE = "DISABLE_WELCOME_PAGE";
	private static final String PROPERTIES_FILE_PATH = File.separator + ".metadata" + File.separator
			+ "integration-studio.properties";

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
            IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            WizardDialog wd = new WizardDialog(win.getShell(), wizard);
            if (wizard instanceof IWorkbenchWizard) {
                ((IWorkbenchWizard)wizard).init(PlatformUI.getWorkbench(), StructuredSelection.EMPTY);
            }
            wd.setTitle(wizard.getWindowTitle());
            wd.open();
        }
    }
    
    /**
     * This method returns the path to properties file.
     * 
     * @return path of properties file
     */
    public static String getPropertiesFilePath() {
        return PROPERTIES_FILE_PATH;
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

    /**
     * This method returns the current web app path(Which is inside the bundle)
     * @return web app folder absolute path
     * @throws URISyntaxException
     * @throws IOException
     */
    public String getWebAppPath() throws URISyntaxException, IOException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL webAppURL = bundle.getEntry(WELCOME_PAGE_WEB_SITE_FOLDER);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        return resolvedWebAppFolder.getAbsolutePath();
    }
    
	public void updateWelcomeDisplayConfiguration(boolean isChecked) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();
		String configFilePath = workspaceDirectory.getAbsolutePath() + PROPERTIES_FILE_PATH;

		File confFile = new File(configFilePath);
		if (isChecked) {
			if (confFile.exists()) {
				setDisableWelcomePrameterValue(configFilePath, false);
			}
		} else {
			setDisableWelcomePrameterValue(configFilePath, true);
		}
	}
	
    public void openExternalBrowser(String link) {
        String url = "";
        switch (link) {
        case "documentation":
            url = "https://ei.docs.wso2.com/en/latest/micro-integrator/develop/WSO2-Integration-Studio/";
            break;
        case "github":
            url = "https://github.com/wso2/devstudio-tooling-ei";
            break;
        case "slack":
            url = "https://wso2-ei.slack.com";
            break;
        case "video":
            url = "https://wso2.com/library/integration/";
            break;
        default:
            url = "https://ei.docs.wso2.com/en/latest/micro-integrator/develop/intro-integration-development/";
            break;
        }
        try {
            PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(url));
        } catch (PartInitException | MalformedURLException e) {
            log.error("Could not load the external browser.", e);
        }
    }

    private void setDisableWelcomePrameterValue(String configFilePath, boolean disableWelcomePage) {
        File configFile = new File(configFilePath);
        Properties properties = new Properties();
        if (configFile.exists()) {
            try (InputStream input = new FileInputStream(configFilePath)) {
                properties.load(input);
            } catch (IOException e) {
                log.error("Error ocuured while saving the DISABLE_WELCOME_PAGE property.", e);
            }
        }
        properties.setProperty(DISABLE_WELCOME_PAGE, String.valueOf(disableWelcomePage));
        try (OutputStream outputStream = new FileOutputStream(configFilePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            log.error("Error ocuured while saving the DISABLE_WELCOME_PAGE property.", e);
        }
    }

	public static String getDisableWelcomePrameterValue() {

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();
		String configFilePath = workspaceDirectory.getAbsolutePath() + PROPERTIES_FILE_PATH;
		File confFile = new File(configFilePath);

		if (confFile.exists()) {
			try (InputStream input = new FileInputStream(configFilePath)) {
				Properties prop = new Properties();
				prop.load(input);
				String disableWelcomePageValue = prop.getProperty(DISABLE_WELCOME_PAGE);
				return disableWelcomePageValue != null && disableWelcomePageValue.equals("true") ? "true" : "false";

			} catch (IOException e) {
				return "false";
			}

		} else {
			return "false";
		}
	}
}
