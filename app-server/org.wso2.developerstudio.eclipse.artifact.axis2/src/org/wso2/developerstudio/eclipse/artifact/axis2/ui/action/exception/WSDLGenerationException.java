/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.artifact.axis2.ui.action.exception;

/**
 * This is a DevStudio defined Exception type that will be thrown in all the exceptional situations occurred
 * when generating WSDL file for an Axis2 service project.
 */
public class WSDLGenerationException extends Exception {

    /**
     * Constructor for creating WSDLGenerationException with an Exception and a message
     *
     * @param exception Exception to be included
     * @param message Exception message
     */
    public WSDLGenerationException(String message, Exception exception) {
        super(message, exception);
    }

    /**
     * Constructor for creating WSDLGenerationException with a message
     *
     * @param message Exception message
     */
    public WSDLGenerationException(String message) {
        super(message);
    }

    /**
     * Constructor for creating WSDLGenerationException with an Exception
     *
     * @param exception Exception to be included
     */
    public WSDLGenerationException(Exception exception) {
        super(exception);
    }
}
