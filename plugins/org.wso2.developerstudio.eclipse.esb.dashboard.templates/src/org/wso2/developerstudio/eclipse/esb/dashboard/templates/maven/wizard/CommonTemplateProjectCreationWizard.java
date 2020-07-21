/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *  http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.esb.dashboard.templates.maven.wizard;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.distribution.project.util.MavenMultiModuleImportUtils;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.maven.wizard.TemplateProjectWizardPage;

public class CommonTemplateProjectCreationWizard extends Wizard implements INewWizard, IExecutableExtension {

    private static final String TEMP_DIRECTORY_PATH = ResourcesPlugin.getWorkspace().getRoot().getLocation()
            .toOSString() + File.separator + ".tmp";

    private TemplateProjectWizardPage page;
    private String wizardId = null;
    private String wizardName;
    private String userEnteredProjectName;

    @Override
    public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
            throws CoreException {

        if (data instanceof Map) {
            wizardId = ((Map<String, String>) data).get(TemplateProjectConstants.WIZARD_PARAM);
        }
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        try {
            setHelpAvailable(false);
            wizardName = loadWizardDetails(wizardId);
            page = new TemplateProjectWizardPage(selection, wizardName);
        } catch (CoreException e) {
            // TODO Auto-generated catch block
        }
    }

    @Override
    public boolean performFinish() {
        userEnteredProjectName = page.getContainerName();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(monitor);
                } catch (Exception e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };

        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), TemplateProjectConstants.ERROR_MESSAGE, realException.getMessage());
            return false;
        }

        return true;
    }

    /**
     * The worker method. import the relevant sample from the bundle.
     */
    private void doFinish(IProgressMonitor monitor) throws Exception {
        String selectedSample = wizardName.replaceAll("\\s+", "");
        replaceProjectNameOfSample(selectedSample);
    }

    private void replaceProjectNameOfSample(String selectedSample) throws Exception {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL fileURL = bundle
                .getEntry("NewSamples/" + selectedSample + "/" + TemplateProjectConstants.GENERAL_TEMPLATE_NAME + ".zip");
        URL resolvedFileURL = FileLocator.toFileURL(fileURL);
        URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
        File sampleTemplateDirectory = new File(resolvedURI);
        File tmpSampleDirectory = new File(TEMP_DIRECTORY_PATH + File.separator + userEnteredProjectName);
        
        // get Readme.html file from NewSamples
        URL readmeFileURL = bundle.getEntry("NewSamples/" + selectedSample + "/Readme.html");
        URL resolvedReadmeFileURL = FileLocator.toFileURL(readmeFileURL);
        URI resolvedReadmeURI = new URI(resolvedReadmeFileURL.getProtocol(), resolvedReadmeFileURL.getPath(), null);
        File sampleReadmeFile = new File(resolvedReadmeURI);

        MavenMultiModuleImportUtils.extractZipFile(sampleTemplateDirectory, tmpSampleDirectory);
        if (!userEnteredProjectName.equals(TemplateProjectConstants.GENERAL_TEMPLATE_NAME)) {
            replaceStringRecursively(tmpSampleDirectory);
        }

        MavenMultiModuleImportUtils.isProcessOfSampleCreating = true;
        if (MavenMultiModuleImportUtils.importMavenMultiModuleProjectToWorkspace(tmpSampleDirectory)) {
            // delete project in .tmp due to creation is success
            MavenMultiModuleImportUtils.isProcessOfSampleCreating = false;
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            MavenMultiModuleImportUtils.addModuleToParentPOM(root.getProject(userEnteredProjectName));
        } else {
            throw new Exception("Error while creating selected sample on workspace");
        }

        org.apache.commons.io.FileUtils.deleteDirectory(tmpSampleDirectory);
        openRespectiveEditorWithSample(selectedSample, sampleReadmeFile);
    }

    private void replaceStringRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            if (file.getName().indexOf(TemplateProjectConstants.GENERAL_TEMPLATE_NAME) >= 0) {
                String newDirName = file.getName().replaceAll(TemplateProjectConstants.GENERAL_TEMPLATE_NAME,
                        userEnteredProjectName);
                org.apache.commons.io.FileUtils.moveDirectory(file,
                        new File(file.getParent() + File.separator + newDirName));
                file = new File(file.getParent() + File.separator + newDirName);
            }

            if (!file.getName().equals("src")) {
                File[] listOfFiles = file.listFiles();
                for (File item : listOfFiles) {
                    replaceStringRecursively(item);
                }
            }
        } else {
            if (file.isFile() && (file.getName().equals("pom.xml") || file.getName().equals(".project")
                    || file.getName().equals("artifact.xml") || file.getParentFile().getName().equals("test")
                    || file.getParentFile().getName().equals("mock-services"))) {
                String content = org.apache.commons.io.FileUtils.readFileToString(file, "UTF-8");
                content = content.replaceAll(TemplateProjectConstants.GENERAL_TEMPLATE_NAME, userEnteredProjectName);
                if (file.getName().equals("pom.xml") && file.getParentFile().getName().contains("Configs")) {
                    //replace unit test plugin version
                    content = content.replaceAll("<version>5.2.27</version>", "<version>5.2.27</version>");
                }
                if (file.getName().equals("pom.xml") && (file.getParentFile().getName().contains("DockerExporter")
                        || file.getParentFile().getName().contains("KubernetesExporter"))) {
                    // replace mi base image
                    content = content.replaceAll("<dockerfile.base.image>wso2/wso2mi:1.1.0</dockerfile.base.image>",
                            "<dockerfile.base.image>wso2/wso2mi:1.2.0</dockerfile.base.image>");
                    
                    //replace config mapper plugin version
                    content = content.replaceAll("<version>5.2.28</version>", "<version>5.2.28</version>");
                    
                    //replace config mapper plugin's mi version
                    content = content.replaceAll("<miVersion>1.1.0</miVersion>", "<miVersion>1.2.0</miVersion>");
                    
                    //replace dockerfile-spotify plugin version
                    content = content.replaceAll("<version>1.4.13</version>", "<version>1.4.13</version>");
                }
                org.apache.commons.io.FileUtils.writeStringToFile(file, content, "UTF-8");
            }
        }
    }

    private void openRespectiveEditorWithSample(String selectedSample, File sampleReadmeFile) throws Exception {
        Map.Entry <IProject, String> entry = getMainLinkingSampleProject();
        String editorId = entry.getValue();
        IProject project = entry.getKey();
        
        //copy sample readme file
        FileUtils.copyFile(sampleReadmeFile,  new File(project.getLocation().toOSString() + File.separator + "ReadMe.html"));
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        IFile artifactFileDesc = project.getFile(getFileToLinkWithEditor(selectedSample));
        Shell shell = getShell();

        // point Readme.html file to open
        URL readmeUrl = sampleReadmeFile.toURI().toURL();
        TemplateCreationUtil.openEditor(shell, artifactFileDesc, editorId, readmeUrl);
    }
    
    private Map.Entry<IProject, String> getMainLinkingSampleProject() {
        IProject dockerProject = MavenMultiModuleImportUtils.IMPORTED_DOCKER_PROJECT;
        IProject k8sProject = MavenMultiModuleImportUtils.IMPORTED_K8S_PROJECT;
        if (dockerProject != null) {
            MavenMultiModuleImportUtils.IMPORTED_DOCKER_PROJECT = null;
            MavenMultiModuleImportUtils.IMPORTED_K8S_PROJECT = null;
            return new AbstractMap.SimpleImmutableEntry<>(dockerProject, TemplateProjectConstants.DOCKER_EDITOR);
        }

        if (k8sProject != null) {
            MavenMultiModuleImportUtils.IMPORTED_K8S_PROJECT = null;
            return new AbstractMap.SimpleImmutableEntry<>(k8sProject, TemplateProjectConstants.DOCKER_EDITOR);
        }

        String editorId;
        IProject selectedProject;
        IProject project = MavenMultiModuleImportUtils.IMPORTED_ESB_PROJECT;
        if (project == null) {
            selectedProject = MavenMultiModuleImportUtils.IMPORTED_DSS_PROJECT;
            MavenMultiModuleImportUtils.IMPORTED_DSS_PROJECT = null;
            editorId = TemplateProjectConstants.DS_EDITOR_ID;
        } else {
            selectedProject = project;
            MavenMultiModuleImportUtils.IMPORTED_ESB_PROJECT = null;
            editorId = TemplateProjectConstants.SYNAPSE_CONFIG_EDITOR_ID;
        }

        return new AbstractMap.SimpleImmutableEntry<>(selectedProject, editorId);
    }

    private String loadWizardDetails(String id) throws CoreException {
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
            return descriptor.getLabel();
        }

        return null;
    }

    private String getFileToLinkWithEditor(String selectedTemplate) {
        String openFileName = null;

        switch (selectedTemplate) {
        case "HelloWorldService":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "HelloWorld.xml";
            break;
        case "ProxyingaSOAPService":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "proxy-services" + File.separator + "ProxyForEchoService.xml";
            break;
        case "RabbitMQIntegration":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "proxy-services" + File.separator + "SalesOrderAddService.xml";
            break;
        case "JMSIntegration":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "OrderPaymentServiceAPI.xml";
            break;
        case "DatabasePolling":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "tasks" + File.separator + "DoctorsRecordsSyncTask.xml";
            break;
        case "ProxyingaRESTService":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "UserInfoRestAPI.xml";
            break;
        case "ContentBasedRouting":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "ArithmaticOperationServiceAPI.xml";
            break;
        case "HeaderBasedRouting":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "CalculatorAPI.xml";
            break;
        case "MessageFiltering":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "PhoneVerifyAPI.xml";
            break;
        case "ProtocolSwitching":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "StudentRegistrationAPI.xml";
            break;
        case "ScatterGatherIntegrationPattern":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "MissionServiceAPI.xml";
            break;
        case "FileTransfer":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "inbound-endpoints" + File.separator + "StudentDataFileProcessInboundEP.xml";
            break;
        case "GuaranteedDelivery":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "UserRegistrationAPI.xml";
            break;
        case "RESTtoSOAPConversion":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "CityInformationAPI.xml";
            break;
        case "ExceptionHandling":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "TimeoutAPI.xml";
            break;
        case "XMLToJSONTransformation":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "ScienceLabAPI.xml";
            break;
        case "PeriodicalScheduledTasks":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "tasks" + File.separator + "PersonRecordRetrieveTask.xml";
            break;
        case "FetchSalesForceAccounts":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "SalesForceAccountServiceAPI.xml";
            break;
        case "JSONtoXMLMapping":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "SalesforceLeads.xml";
            break;
        case "XMLtoJSONMapping":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "EngineerEmployeeServiceAPI.xml";
            break;
        case "KafkaConsumerandProducer":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "api" + File.separator + "WeatherDataPublishAPI.xml";
            break;
        case "StudentsDataService":
            openFileName = "dataservice" + File.separator + "StudentDataService.dbs";
            break;
        case "RESTDataService":
            openFileName = "dataservice" + File.separator + "RESTDataService.dbs";
            break;
        case "HelloDocker":
            openFileName = "pom.xml";
            break;
        case "HelloKubernetes":
            openFileName = "pom.xml";
            break;
        case "UnitTestTutorial":
        	openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
            + "api" + File.separator + "business-logic.xml";
        	break;
        case "APITesting":
        	openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
            + "api" + File.separator + "RESTApi.xml";
        	break;
        case "EmailService":
            openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "api"
                    + File.separator + "EmailService.xml";
            break;
        }

        return openFileName;
    }

    @Override
    public void addPages() {
        addPage(page);
    }
}
