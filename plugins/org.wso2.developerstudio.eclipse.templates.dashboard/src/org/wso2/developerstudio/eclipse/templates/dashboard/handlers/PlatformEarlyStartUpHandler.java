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

package org.wso2.developerstudio.eclipse.templates.dashboard.handlers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2e.core.internal.MavenPluginActivator;
import org.eclipse.m2e.core.internal.launch.AbstractMavenRuntime;
import org.eclipse.m2e.core.internal.launch.MavenExternalRuntime;
import org.eclipse.m2e.core.internal.launch.MavenRuntimeManagerImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.dialogs.WorkbenchWizardElement;
import org.eclipse.ui.internal.wizards.AbstractExtensionWizardRegistry;
import org.eclipse.ui.wizards.IWizardCategory;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.JSEmbeddedFunctions;

/**
 * This is the early startup handler of the developer studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private static final String EMPTY_STRING = "";
    private static final String MAVEN_HOME = "apache-maven";
    private static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    private static final String IMPORT_EXPORT_SECTION = "ImportExportAction";
    private static final String EXPORT_WIZARD_CATEGORY = "ImportExportPage.STORE_EXPANDED_EXPORT_CATEGORIES";
    private static final String IMPORT_WIZARD_CATEGORY = "ImportExportPage.STORE_EXPANDED_IMPORT_CATEGORIES";
    private static final String EXPORT_WIZARD_SELECT = "ImportExportPage.STORE_SELECTED_EXPORT_WIZARD_ID";
    private static final String IMPORT_WIZARD_SELECT = "ImportExportPage.STORE_SELECTED_IMPORT_WIZARD_ID";
    private static final String EXPORT_WIZARD_SELCTED_CATEGORY = "org.wso2.developerstudio.eclipse.distribution.export";
    private static final String IMPORT_WIZARD_SELCTED_CATEGORY = "org.wso2.developerstudio.eclipse.import";
    private static final String EXPORT_SELECTED_WIZARD = "org.wso2.developerstudio.eclipse.distribution.exportAsArchiveFile";
    private static final String IMPORT_SELECTED_WIZARD = "org.wso2.developerstudio.eclipse.distribution.importAsArtifact";
    
    @Override
    public void earlyStartup() {
        // This method fires before startup and we use this to start embedded jetty
        if(!JettyServerHandler.serverStarted) {
            JettyServerHandler.getInstance().startEmbeddedJetty(FunctionServerConstants.EMBEDDED_SERVER_PORT);
            JettyServerHandler.serverStarted = true;
            openGettingStartedPage();
        } else {
            openGettingStartedPage();
        }
        removeWizardEntries();
        setFileAssociations();
        setDefaultMavenInstallation();
        setDefaultImportAndExportOptions();
    }
    
    /**
     * Set the default options in Import and Export dialogs to WSO2 options.
     */
    private void setDefaultImportAndExportOptions() {
        IDialogSettings workbenchSettings = WorkbenchPlugin.getDefault().getDialogSettings();
        IDialogSettings wizardSettings = workbenchSettings.getSection(IMPORT_EXPORT_SECTION);
        if (wizardSettings == null) {
            wizardSettings = workbenchSettings.addNewSection(IMPORT_EXPORT_SECTION);
            // Export wizard.
            // Expand WSO2 category.
            wizardSettings.put(EXPORT_WIZARD_CATEGORY, new String[] { EXPORT_WIZARD_SELCTED_CATEGORY });
            // Set default option.
            wizardSettings.put(EXPORT_WIZARD_SELECT, EXPORT_SELECTED_WIZARD);

            // Import wizard.
            // Expand WSO2 category.
            wizardSettings.put(IMPORT_WIZARD_CATEGORY, new String[] { IMPORT_WIZARD_SELCTED_CATEGORY });
            // Set default option.
            wizardSettings.put(IMPORT_WIZARD_SELECT, IMPORT_SELECTED_WIZARD);
        }
    }

    /**
     * This method sets initial custom file associations.
     * This setting can be overridden by user preference
     */
    private void setFileAssociations() {
        PlatformUI.getWorkbench().getEditorRegistry().setDefaultEditor("*.html", "org.eclipse.ui.browser.editorSupport");
    }
    
    /**
     * This method sets the apache maven packed with Integration Studio as the default maven installation.
     */
    @SuppressWarnings("restriction")
    private void setDefaultMavenInstallation() {
        final MavenRuntimeManagerImpl runtimeManager = MavenPluginActivator.getDefault().getMavenRuntimeManager();
        List<AbstractMavenRuntime> runtimes = runtimeManager.getMavenRuntimes(false);
        String mavenHomePath = getMavenHomePath();
        if (Files.exists(Paths.get(mavenHomePath))) {
            AbstractMavenRuntime newRuntime = new MavenExternalRuntime("IntegrationStudioEmbedded", mavenHomePath);
            runtimes.add(newRuntime);
            runtimeManager.setRuntimes(runtimes);
            runtimeManager.setDefaultRuntime(newRuntime);
        }
    }
    
    /**
     * Method of getting MAVEN_HOME path based on the OS type.
     * 
     * @return MAVEN_HOME path
     */
    private String getMavenHomePath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = TOOLING_PATH_MAC + File.separator + MAVEN_HOME;
            } else {
                java.nio.file.Path path = Paths.get(EMPTY_STRING);
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MAVEN_HOME;
            }
        } else {
            java.nio.file.Path path = Paths.get(EMPTY_STRING);
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MAVEN_HOME;
        }
        return microInteratorPath;
    }

    /**
     * This method removes unwanted new wizard entries
     */
    private void removeWizardEntries() {

        // Wizard category ids and the respective categories are below
        // org.eclipse.datatools.connectivity : Connection Profiles
        // org.eclipse.egit.ui.wizardCategory : Git
        // org.eclipse.emf.codegen.ecore.ui.wizardCategory : Eclipse Modeling Framework
        // org.eclipse.emf.codegen.ecore.ui.mappingWizardCategory : Mapping
        // org.eclipse.emf.codegen.ui.JETNewWizards : Java Emitter Templates
        // org.eclipse.emf.ecore.Wizard.category.ID : Example EMF Model Creation Wizards
        // org.eclipse.jdt.ui.java : Java
        // org.eclipse.jdt.debug.ui.java : Java Run/Debug
        // org.eclipse.jdt.junit : JUnit
        // org.eclipse.jst.ejb.ui : EJB
        // org.eclipse.jst.j2ee.internal : Java EE
        // org.eclipse.jst.ws.ui.new : Web Services
        // org.eclipse.m2e : Maven
        // org.eclipse.pde.PDE : Plug-in Development
        // org.eclipse.pde.userAssistance : User Assistance
        // org.eclipse.ui.Basic : General
        // org.eclipse.ui.Examples : Examples
        // org.eclipse.wst.xml.examples : XML
        // org.eclipse.wst.jsdt.ui.java : JavaScript
        // org.eclipse.wst.server.ui : Server
        // org.eclipse.wst.web.ui : Web
        // org.eclipse.wst.XMLCategory : XML
        // org.jboss.tools.smooks.configuration : Smooks

        // List of removable new wizard category IDs
        ArrayList<String> removableNewWizardCategoryIDs = new ArrayList<String>();
        removableNewWizardCategoryIDs.add("org.eclipse.jst.ejb.ui");
        removableNewWizardCategoryIDs.add("org.eclipse.emf.codegen.ecore.ui.wizardCategory");
        removableNewWizardCategoryIDs.add("org.eclipse.emf.ecore.Wizard.category.ID");
        removableNewWizardCategoryIDs.add("org.eclipse.emf.codegen.ui.JETNewWizards");
        removableNewWizardCategoryIDs.add("org.eclipse.emf.codegen.ecore.ui.mappingWizardCategory");
        removableNewWizardCategoryIDs.add("org.eclipse.pde.PDE");
        removableNewWizardCategoryIDs.add("org.eclipse.pde.userAssistance");
        removableNewWizardCategoryIDs.add("org.eclipse.ui.Examples");
        removableNewWizardCategoryIDs.add("org.eclipse.wst.xml.examples");
        removableNewWizardCategoryIDs.add("org.eclipse.datatools.connectivity");
        removableNewWizardCategoryIDs.add("org.eclipse.jst.j2ee.internal");
        removableNewWizardCategoryIDs.add("org.eclipse.ui.Basic");

        AbstractExtensionWizardRegistry wizardRegistry = (AbstractExtensionWizardRegistry) PlatformUI.getWorkbench()
                .getNewWizardRegistry();
        IWizardCategory[] categories = PlatformUI.getWorkbench().getNewWizardRegistry().getRootCategory()
                .getCategories();

        for (IWizardDescriptor wizard : getAllWizards(categories)) {
            if (removableNewWizardCategoryIDs.contains(wizard.getCategory().getId())) {
                WorkbenchWizardElement wizardElement = (WorkbenchWizardElement) wizard;
                wizardRegistry.removeExtension(wizardElement.getConfigurationElement().getDeclaringExtension(),
                        new Object[] { wizardElement });
            }
        }
    }

    private IWizardDescriptor[] getAllWizards(IWizardCategory[] categories) {
        List<IWizardDescriptor> results = new ArrayList<IWizardDescriptor>();
        for (IWizardCategory wizardCategory : categories) {
            results.addAll(Arrays.asList(wizardCategory.getWizards()));
            results.addAll(Arrays.asList(getAllWizards(wizardCategory.getCategories())));
        }
        return results.toArray(new IWizardDescriptor[0]);
    }

    /**
     * This method will open getting started page at workbench startup.
     * When using this method we need to remove default intro from
     * rcp-product/plugin_customization.ini with org.eclipse.ui/showIntro = false parameter.
     */
    private void openGettingStartedPage() {
		if (JSEmbeddedFunctions.getDisableWelcomePrameterValue().equals("false")) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					try {
						PlatformUI.getWorkbench().showPerspective(FunctionServerConstants.WELCOME_PERSPECTIVE_ID,
								PlatformUI.getWorkbench().getActiveWorkbenchWindow());
						page.openEditor(new GettingStartedEditorInput(),
								FunctionServerConstants.TEMPLATE_DASHBOARD_EDITOR_ID, false);
					} catch (WorkbenchException e) {
						MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
								"Could not open Getting started page", e.getMessage());
					}
				}
			});
		}
    }

    /**
     * Wrapper editor input class for template dashboard.
     *
     */
    private class GettingStartedEditorInput implements IEditorInput {

        @Override
        public <T> T getAdapter(Class<T> arg0) {
            return null;
        }

        @Override
        public boolean exists() {
            return true;
        }

        @Override
        public ImageDescriptor getImageDescriptor() {
            return null;
        }

        @Override
        public String getName() {
            return "Getting Started";
        }

        @Override
        public IPersistableElement getPersistable() {
            return null;
        }

        @Override
        public String getToolTipText() {
            return "Getting Started";
        }
    }

}
