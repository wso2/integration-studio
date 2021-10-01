/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.esb.project.ui.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.api.API;
import org.apache.synapse.api.version.URLBasedVersionStrategy;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.carbon.rest.api.service.RestApiAdmin;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.utils.file.FileUtils;

public class MetadataGenerationUtil {

    public static void createMedataFile(IContainer metadataLocation, API synapseApi, String fileName)
            throws IOException {

        IFile swaggerFile = metadataLocation.getFile(new Path(fileName + "_metadata.yaml"));
        String context = synapseApi.getContext();
        String version = synapseApi.getVersion();
        if (synapseApi.getVersionStrategy() instanceof URLBasedVersionStrategy && !StringUtils.isEmpty(version)) {
            context = context + "/" + version;
        }
        if (StringUtils.isEmpty(version)) {
            version = "1.0.0";
        }

        File newFile = new File(swaggerFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            try (FileWriter fw = new FileWriter(newFile);) {
                StringBuilder builder = new StringBuilder();
                // Creating the YAML file
                builder.append("---\n");
                builder.append("key: \"").append(synapseApi.getAPIName()).append("-").append(version).append("\"\n");
                builder.append("name : \"").append(synapseApi.getAPIName()).append("\"\n");
                builder.append("displayName : \"").append(synapseApi.getAPIName()).append("\"\n");
                builder.append("description: \"Sample API\"\n");
                builder.append("version: \"").append(version).append("\"\n");
                builder.append("serviceUrl: \"https://{MI_HOST}:{MI_PORT}").append(context).append("\"\n");
                builder.append("definitionType: \"OAS3\"\n");
                builder.append("securityType: \"BASIC\"\n");
                builder.append("mutualSSLEnabled: false\n");
                fw.write(builder.toString());
            }
        }
    }

    public static void createMedataFileForProxyServices(IContainer metadataLocation, String fileName)
            throws IOException {

        IFile metadataFile = metadataLocation.getFile(new Path(fileName + "_proxy_metadata.yaml"));
        String version = "1.0.0";
        File newFile = new File(metadataFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            try (FileWriter fw = new FileWriter(newFile);) {
                StringBuilder builder = new StringBuilder();
                // Creating the YAML file
                builder.append("---\n");
                builder.append("key: \"").append(fileName).append("_proxy-").append(version).append("\"\n");
                builder.append("name : \"").append(fileName).append("\"\n");
                builder.append("displayName : \"").append(fileName).append("\"\n");
                builder.append("description: \"Sample Proxy Service\"\n");
                builder.append("version: \"").append(version).append("\"\n");
                builder.append("serviceUrl: \"https://{MI_HOST}:{MI_PORT}/services/").append(fileName).append("\"\n");
                builder.append("definitionType: \"WSDL1\"\n");
                builder.append("securityType: \"BASIC\"\n");
                builder.append("mutualSSLEnabled: false\n");
                fw.write(builder.toString());
            }
        }
    }
    
    public static void createSwaggerYAMLForAPIs(IContainer metadataLocation, API synapseApi, String apiName) throws Exception {
        RestApiAdmin restAPIAdmin = new RestApiAdmin();
        String swagger = restAPIAdmin.generateSwaggerFromSynapseAPIByFormat(synapseApi, false);
        IFile swaggerFile = metadataLocation.getFile(new Path(apiName + "_swagger.yaml"));
        FileUtils.createFile(swaggerFile.getLocation().toFile(), swagger);
    }
    
    public static void createArtifactXMLEntryForAPIMetadata(ESBProjectArtifact esbProjectArtifact, IProject iProject,
            IContainer metadataLocation, String proxyName, String metadataGroupId, String version, boolean isSwagger) throws Exception {

        String filePathPostfix = "_metadata.yaml";
        String namePostfix = "_metadata";
        if (isSwagger) {
            filePathPostfix = "_swagger.yaml";
            namePostfix = "_swagger";
        }
        String metaRelativePath = FileUtils
                .getRelativePath(iProject.getLocation().toFile(),
                        new File(metadataLocation.getLocation().toFile(), proxyName + filePathPostfix))
                .replaceAll(Pattern.quote(File.separator), "/");
        esbProjectArtifact
                .addESBArtifact(createArtifact(proxyName + namePostfix, metadataGroupId, version, metaRelativePath));
    }

    public static void createArtifactXMLEntryForProxyServiceMetadata(ESBProjectArtifact esbProjectArtifact, IProject iProject,
            IContainer metadataLocation, String proxyName, String metadataGroupId, String version) throws Exception {

        String filePathPostfix = "_proxy_metadata.yaml";
        String namePostfix = "_proxy_metadata";
        String metaRelativePath = FileUtils
                .getRelativePath(iProject.getLocation().toFile(),
                        new File(metadataLocation.getLocation().toFile(), proxyName + filePathPostfix))
                .replaceAll(Pattern.quote(File.separator), "/");
        esbProjectArtifact
                .addESBArtifact(createArtifact(proxyName + namePostfix, metadataGroupId, version, metaRelativePath));
    }

    private static ESBArtifact createArtifact(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/metadata");
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * Method for getting current project from IStructuredSelection.
     * 
     * @param obj IStructuredSelection as an object
     * @return IProject
     */
    public static IProject getSelectedProject(Object obj) {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }

    /**
     * Method for getting shell display.
     * 
     * @return Shell
     */
    public static Shell getShell() {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0].getShell();
            }
        } else {
            return window.getShell();
        }
        return null;
    }
}
