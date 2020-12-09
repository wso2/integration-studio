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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer.DeserializeStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;

public class FileDecorator extends LabelProvider implements ILightweightLabelDecorator {

    private static final String ICON = "/icons/error.png";
    private static final String API = "api";
    private static final String ENDPOINTS = "endpoints";
    private static final String INBOUND_ENDPOINT = "inbound-endpoints";
    private static final String LOCAL_ENTRY = "local-entries";
    private static final String MS_PROCESSOR = "message-processors";
    private static final String MS_STORE = "message-stores";
    private static final String PROXY = "proxy-services";
    private static final String SEQUENCES = "sequences";
    private static final String TASKS = "tasks";
    private static final String TEMPLATES = "templates";
    private static final String SRC = "src";
    private static final String MAIN = "main";
    private static final String SYNAPSE_CONFIG = "synapse-config";
    private static final String SOURCE_VIEW_ERROR = "SOURCE_VIEW_ERROR";
    private static final String CAPP_NOT_ALLOWED = "CAPP_NOT_ALLOWED";
    private static final String[] ARTIFACTS = { API, ENDPOINTS, INBOUND_ENDPOINT, LOCAL_ENTRY, MS_PROCESSOR, MS_STORE,
            PROXY, SEQUENCES, TASKS, TEMPLATES };
    private static final ImageDescriptor IMAGE_DESCRIPTOR = ImageDescriptor.createFromFile(FileDecorator.class, ICON);

    private static Deserializer deserializer = null;

    /**
     * Method which is triggered by the org.eclipse.ui.decorators extension.
     */
    @Override
    public void decorate(Object element, IDecoration decoration) {

        if (element instanceof IFile) {

            IFile iFile = (IFile) element;
            String fileName = iFile.getName();
            if (!fileName.equals("pom.xml") && iFile.getFileExtension() != null
                    && iFile.getFileExtension().equals("xml")
                    && getProjectType(iFile.getFullPath().toString(), iFile.getProject().getName(), fileName)) {

                try {
                    String source = new Scanner(iFile.getContents()).useDelimiter("\\A").next();
                    if (!isValid(source, iFile)) {
                        addDecorator(decoration);
                    }
                } catch (CoreException e) {
                    // ignore
                }

            }

        } else if (element instanceof Folder) {

            Folder folder = (Folder) element;
            if (folder != null && folder.getLocation() != null) {
                String fullPath = folder.getLocation().toString();

                if (fullPath.endsWith(SRC)) {
                    // process src
                    if (!validSrc(fullPath)) {
                        addDecorator(decoration);
                    }

                } else if (fullPath.endsWith(MAIN)) {
                    // process main
                    if (!validMain(fullPath)) {
                        addDecorator(decoration);
                    }

                } else if (fullPath.endsWith(SYNAPSE_CONFIG)) {
                    // process synapse-config
                    if (!validSynapseConfig(fullPath)) {
                        addDecorator(decoration);
                    }

                } else if (fullPath.endsWith(API) || fullPath.endsWith(ENDPOINTS) || fullPath.endsWith(INBOUND_ENDPOINT)
                        || fullPath.endsWith(LOCAL_ENTRY) || fullPath.endsWith(MS_PROCESSOR) || fullPath.endsWith(MS_STORE)
                        || fullPath.endsWith(PROXY) || fullPath.endsWith(SEQUENCES) || fullPath.endsWith(TASKS)
                        || fullPath.endsWith(TEMPLATES)) {
                    // process xml files
                    if (!validArtifacts(fullPath)) {
                        addDecorator(decoration);
                    }

                } else {
                    // process project
                    if (!validProject(fullPath)) {
                        addDecorator(decoration);
                    }
                }
            }
            
        } else if (element instanceof Project) {
            // process project
            Project project = (Project) element;
            if (project != null && project.getLocation() != null && !validProject(project.getLocation().toString())) {
                addDecorator(decoration);
            }

        }
    }

    private boolean getProjectType(String fullPath, String projectName, String fileName) {

        for (int i = 0; i < ARTIFACTS.length; i++) {

            if (fullPath.equals(File.separator + projectName + File.separator + SRC + File.separator + MAIN
                    + File.separator + SYNAPSE_CONFIG + File.separator + ARTIFACTS[i] + File.separator + fileName)) {
                return true;
            }
        }
        return false;
    }

    private boolean validSrc(String folderPath) {

        String newPath = folderPath + File.separator + MAIN;
        File newFile = new File(newPath);

        if (newFile.exists() && newFile.isDirectory() && !validMain(newPath)) {
            return false;
        }
        return true;
    }

    private boolean validMain(String folderPath) {

        String newPath = folderPath + File.separator + SYNAPSE_CONFIG;
        File newFile = new File(newPath);

        if (newFile.exists() && newFile.isDirectory() && !validSynapseConfig(newPath)) {
            return false;
        }
        return true;
    }

    private boolean validSynapseConfig(String folderPath) {

        for (int i = 0; i < ARTIFACTS.length; i++) {

            File newFile = new File(folderPath + File.separator + ARTIFACTS[i]);
            if (newFile.exists() && newFile.isDirectory()
                    && !validArtifacts(folderPath + File.separator + ARTIFACTS[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean validArtifacts(String folderPath) {

        File rootfFolder = new File(folderPath);
        String[] files = rootfFolder.list();

        if (files != null) {

            for (int i = 0; i < files.length; i++) {

                String fileName = files[i];
                if (fileName.endsWith(".xml")) {

                    try (FileReader fileReader = new FileReader(folderPath + File.separator + fileName);
                            Scanner scanner = new Scanner(fileReader);) {
                        String source = scanner.useDelimiter("\\A").next();
                        if (!isValid(source)) {
                            return false;
                        }
                    } catch (FileNotFoundException e) {
                        // ignore
                    } catch (IOException e1) {
                        // ignore
                    }
                }
            }
        }
        return true;
    }

    private boolean validProject(String folderPath) {

        String newPath = folderPath + File.separator + SRC;
        File newFile = new File(newPath);

        if (newFile.exists() && newFile.isDirectory() && !validSrc(newPath)) {
            return false;
        } else {
            File rootFile = new File(folderPath);
            File projectFile = new File (folderPath + File.separator + ".project");
            if (rootFile.isDirectory() && projectFile.exists()) {
                for(File file : rootFile.listFiles()) {
                    if (file.isDirectory() && Files.exists(Paths.get(file.getAbsolutePath() + File.separator + SRC))) {
                        return validProject(file.getAbsolutePath());
                    }
                }
            }
        }
        return true;
    }

    /**
     * Add decorator to the IResource.
     * 
     * @param decoration Default decoration
     */
    private void addDecorator(IDecoration decoration) {
        decoration.addOverlay(IMAGE_DESCRIPTOR, IDecoration.BOTTOM_LEFT);
    }

    /**
     * Check for the validity of a given synapse configuration.
     * 
     * @param source Synapse configuration
     * @return Validity of the synapse configuration
     */
    private boolean isValid(String source) {
        if (deserializer == null) {
            deserializer = Deserializer.getInstance();
        }
        DeserializeStatus deserializeStatus = deserializer.isValidSynapseConfig(source, true, false);

        if (deserializeStatus.isValid()) {
            return true;
        }
        return false;
    }

    private boolean isValid(String source, IFile iFile) {

        try {
            if (!isValid(source)) {
                iFile.deleteMarkers(CAPP_NOT_ALLOWED, false, 1);
                iFile.createMarker(CAPP_NOT_ALLOWED);
                return false;

            } else if (iFile.findMarkers(SOURCE_VIEW_ERROR, false, 1).length > 0) {
                return false;

            } else {
                // Remove the created markers for validation
                iFile.deleteMarkers(CAPP_NOT_ALLOWED, false, 1);
                iFile.deleteMarkers(SOURCE_VIEW_ERROR, false, 1);

            }
        } catch (CoreException e) {
            // ignore
        }
        return true;
    }
}
