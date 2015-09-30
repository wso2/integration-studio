/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.analytics.stream.project.export;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StreamArtifactExportHandler extends ProjectArtifactHandler {
    private static final String FILE_EXTENSION = "json";

    public List<IResource> exportArtifact(IProject project) throws Exception {
        List<IResource> exportResources = new ArrayList<IResource>();
        File[] jsonfiles = FileUtils.getAllMatchingFiles(project.getLocation()
                        .toString(), null, FILE_EXTENSION,
                new ArrayList<File>());
        for (File jsonfile : jsonfiles) {
            if (isStream(jsonfile)) {
                String jsonFileLocation = jsonfile.toString()
                        .replaceAll(
                                "^" + project.getLocation().toString()
                                        + File.separator, "");
                IFile jsonFileRef = project.getFile(jsonFileLocation);
                exportResources.add((IResource) jsonFileRef);
            }
        }
        return exportResources;
    }

    private boolean isStream(File jsonFile) {
        try {
            OMElement documentElement = new StAXOMBuilder(new FileInputStream(jsonFile))
                    .getDocumentElement();
            String localName = documentElement.getLocalName();
            if (localName.equals("stream")) {
                return true;
            }
        } catch (Exception ignored) {
            // ignored
        }
        return false;
    }

}
