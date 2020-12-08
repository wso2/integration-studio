/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.integrationstudio.eclipse.docker.distribution.exceptions;

import com.spotify.docker.client.exceptions.DockerException;

/**
 * Custom exception class for Docker image generation errors.
 *
 */
public class DockerImageGenerationException extends DockerException {

    private static final long serialVersionUID = -5342001668231321708L;

    public DockerImageGenerationException(String msg) {
        super(msg);
    }

    public DockerImageGenerationException(String msg, Throwable e) {
        super(msg, e);
    }

}
