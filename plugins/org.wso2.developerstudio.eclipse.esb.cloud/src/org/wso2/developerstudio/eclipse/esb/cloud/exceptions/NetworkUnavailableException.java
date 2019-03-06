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

package org.wso2.developerstudio.eclipse.esb.cloud.exceptions;

/**
 * Exception thrown when network is unavailable
 *
 */
public class NetworkUnavailableException extends Exception {

    private static final String message = "No internet connection available!";

    public NetworkUnavailableException() {
        super(message);
    }

    public NetworkUnavailableException(String message) {
        super(message);
    }

    public NetworkUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkUnavailableException(Throwable cause) {
        super(cause);
    }

    protected NetworkUnavailableException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
