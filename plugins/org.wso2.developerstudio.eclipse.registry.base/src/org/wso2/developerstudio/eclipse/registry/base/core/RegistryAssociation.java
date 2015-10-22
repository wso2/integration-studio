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

package org.wso2.developerstudio.eclipse.registry.base.core;

/**
 * This class is to store resource associations. Association can be made between 1. Registry
 * Resource Paths. 2. Path with web url In addition to the source and target paths associations has
 * a type. Dependency is a special case of association where the type field is always equal to
 * Association.DEPENDS constant.
 */
public class RegistryAssociation {

    private String sourcePath;
    private String destinationPath;
    private String associationType;
    public static final String DEPENDS = "depends";
    public static final String USED_BY = "usedBy";

    /**
     * Default constructor for the Association Class. Just create an empty association.
     */
    public RegistryAssociation() {
    }

    /**
     * Construct an association by providing the source, target and the association type.
     *
     * @param sourcePath      the source of the association.
     * @param destinationPath the destination of the association.
     * @param associationType the type of the association.
     */
    public RegistryAssociation(String sourcePath, String destinationPath, String associationType) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.associationType = associationType;
    }

    /**
     * Method to get the source path.
     *
     * @return the source path.
     */
    public String getSourcePath() {
        return sourcePath;
    }

    /**
     * Method to set the source path.
     *
     * @param sourcePath the source path.
     */
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    /**
     * Method to get the destination path.
     *
     * @return the destination path.
     */
    public String getDestinationPath() {
        return destinationPath;
    }

    /**
     * Method to set the destination path.
     *
     * @param destinationPath the destination path.
     */
    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    /**
     * Method to get the association type.
     *
     * @return the association type.
     */
    public String getAssociationType() {
        return associationType;
    }

    /**
     * Method to get the association type.
     *
     * @param associationType the association type.
     */
    public void setAssociationType(String associationType) {
        this.associationType = associationType;
    }
}
