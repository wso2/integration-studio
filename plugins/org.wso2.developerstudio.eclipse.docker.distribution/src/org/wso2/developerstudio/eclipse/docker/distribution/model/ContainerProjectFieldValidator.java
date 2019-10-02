/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.docker.distribution.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PlatformUIConstants;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UserInputValidator;

public class ContainerProjectFieldValidator extends AbstractFieldController {

    @Override
    public void validate(String modelProperty, Object value, ProjectDataModel model) throws FieldValidationException {
        if (modelProperty.equals("project.name")) {
            validateProjectField(value);
        } else {
            fieldValidator(modelProperty, value);
        }
    }

    private void validateProjectField(Object value) throws FieldValidationException {
        if (value == null) {
            throw new FieldValidationException("Project name cannot be empty");
        } else {
            String projectName = value.toString();
            if (projectName.trim().equals("")) {
                throw new FieldValidationException("Project name cannot be empty");
            } else if (projectName.indexOf(32) != -1) {
                throw new FieldValidationException("Project name cannot contain spaces");
            } else if (!isValidArtifactName(projectName)) {
                throw new FieldValidationException(
                        "Project name cannot contain invalid characters(^/ : ; * # $ ? \" <> + $)");
            } else {
                IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
                if (project.exists()) {
                    throw new FieldValidationException("Project with the name '" + projectName + "' already exists");
                }
            }
        }
    }

    private void validateContainerField(Object value) throws FieldValidationException {
        if (value == null) {
            throw new FieldValidationException("Container name cannot be empty");
        } else {
            String projectName = value.toString();
            if (projectName.trim().equals("")) {
                throw new FieldValidationException("Container name cannot be empty");
            } else if (projectName.indexOf(32) != -1) {
                throw new FieldValidationException("Container name cannot contain spaces");
            } else if (!isValidArtifactName(projectName)) {
                throw new FieldValidationException(
                        "Container name cannot contain invalid characters(^/ : ; * # $ ? \" <> + $)");
            }
        }
    }

    private boolean isValidArtifactName(String name) {
        Pattern pattern = Pattern.compile("^[^/\\ \\\\:@%\\^+;,=\\[\\{\\]\\}*#\\$?\"<>|\\(\\)]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private void fieldValidator(String modelProperty, Object value) throws FieldValidationException {
        if (modelProperty.equals("project.repository")) {
            String targetRepo = value.toString();
            if (targetRepo == null || targetRepo.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_TARGET_REPO_MESSAGE);
            } else if (!UserInputValidator.isRepositoryValid(targetRepo)) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_TARGET_REPO_MESSAGE);
            }
        } else if (modelProperty.equals("project.tag")) {
            String targetTag = value.toString();
            if (targetTag == null || targetTag.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_TARGET_TAG_MESSAGE);
            } else if (!UserInputValidator.isTagValid(targetTag)) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_TARGET_TAG_MESSAGE);
            }
        } else if (modelProperty.equals("project.remoteRepository")) {
            String remoteRepo = value.toString();
            if (remoteRepo == null || remoteRepo.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_REMOTE_REPOSITORY_MESSAGE);
            }
        } else if (modelProperty.equals("project.remoteTag")) {
            String remoteTag = value.toString();
            if (remoteTag == null || remoteTag.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_REMOTE_TAG_MESSAGE);
            }
        } else if (modelProperty.equals("kube.name")) {
            validateContainerField(value);
        } else if (modelProperty.equals("kube.replicas")) {
            String replicas = value.toString();
            if (replicas == null || replicas.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_REPLICA_COUNT);
            } else if (!replicas.matches("-?\\d+(\\.\\d+)?")) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_REPLICA_COUNT_NOT_AS_INT);
            }
        } else if (modelProperty.equals("kube.remoteRepository")) {
            String remoteRepository = value.toString();
            if (remoteRepository == null || remoteRepository.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_KUBE_REMOTE_REPOSITORY);
            }
        } else if (modelProperty.equals("kube.remoteTag")) {
            String remoteTag = value.toString();
            if (remoteTag == null || remoteTag.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_KUBE_REMOTE_TAG);
            }
        } else if (modelProperty.equals("kube.targetRepository")) {
            String targetRepository = value.toString();
            if (targetRepository == null || targetRepository.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_KUBE_TARGET_REPOSITORY);
            } else if (!UserInputValidator.isRepositoryValid(targetRepository)) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_TARGET_REPO_MESSAGE);
            } else if (targetRepository != null
                    && (targetRepository.split("/").length != 2 && targetRepository.split("/").length != 3)) {
                throw new FieldValidationException(PlatformUIConstants.KUBE_TARGET_REPOSITORY_INVALID);
            }
        } else if (modelProperty.equals("kube.targetTag")) {
            String targetTag = value.toString();
            if (targetTag == null || targetTag.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.NO_TARGET_TAG_ERROR);
            } else if (!UserInputValidator.isTagValid(targetTag)) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_TARGET_TAG_MESSAGE);
            }
        } else if (modelProperty.equals("kube.exposePort")) {
            String ports = value.toString();
            if (ports == null || ports.isEmpty()) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_PORT);
            } else if (!ports.matches("-?\\d+(\\.\\d+)?")) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_PORT_TYPE);
            } else if (ports.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(ports) > 65535) {
                throw new FieldValidationException(PlatformUIConstants.INVALID_PORT_RANGE);
            }
        }
    }
}
