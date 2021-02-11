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
package org.wso2.integrationstudio.artifact.synapse.api.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.api.API;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;

/**
 * This class will create a metadata file an API with the given details.
 */
public class MetadataUtils {
    public static void createMedataFile(IContainer metadataLocation, API synapseApi, String fileName)
            throws IOException {

        IFile swaggerFile = metadataLocation.getFile(new Path(fileName + "_metadata.yaml"));

        File newFile = new File(swaggerFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            try (FileWriter fw = new FileWriter(newFile);) {
                StringBuilder builder = new StringBuilder();

                String version = synapseApi.getVersion();
                if (StringUtils.isEmpty(version)) {
                    version = "1.0.0";
                }
                // Creating the YAML file
                builder.append("---\n");
                builder.append("key: \"").append(synapseApi.getAPIName()).append("-").append(version).append("\"\n");
                builder.append("name : \"").append(synapseApi.getAPIName()).append("\"\n");
                builder.append("displayName : \"").append(synapseApi.getAPIName()).append("\"\n");
                builder.append("description: \"Sample API\"\n");
                builder.append("version: \"").append(version).append("\"\n");
                builder.append("serviceUrl: \"https://{host}:{port}").append(synapseApi.getContext()).append("\"\n");
                builder.append("definitionType: \"OAS3\"\n");
                builder.append("securityType: \"BASIC\"\n");
                builder.append("mutualSSLEnabled: false\n");
                fw.write(builder.toString());
            }
        }
    }

}
