/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.impl;

import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.IMediatorLocator;

/**
 * Factory design pattern implementation to get Mediator Locator according to
 * the type.
 *
 */
public class MediatorLocatorFactory {

    /**
     * This private constructor is to hide the implicit public constructor
     */
    private MediatorLocatorFactory() {
    }

    /**
     * This method takes project type as a input and returns specific Mediator
     * Locator
     * 
     * @param type
     * @return
     * @throws ESBDebuggerException
     */
    public static IMediatorLocator getMediatorLocator(ArtifactType type) throws ESBDebuggerException {

        switch (type) {
        case PROXY:
            return new ProxyMediatorLocator();
        case SEQUENCE:
            return new SequenceMediatorLocator();
        case TEMPLATE_SEQUENCE:
            return new TemplateMediatorLocator();
        case API:
            return new APIMediatorLocator();
        case MAIN_SEQUENCE:
            return new MainSequenceMediatorLocator();
        default:
            throw new ESBDebuggerException("Unsupported Project Type for Debugging Requested from Mediator Locator");
        }
    }
}
