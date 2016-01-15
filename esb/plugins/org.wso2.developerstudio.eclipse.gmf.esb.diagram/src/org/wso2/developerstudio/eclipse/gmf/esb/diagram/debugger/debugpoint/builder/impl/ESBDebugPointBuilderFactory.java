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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.impl;

import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.IESBDebugPointBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;

/**
 * Factory design pattern implementation to get Debug Point Builder's according
 * to the type required.
 *
 */
public class ESBDebugPointBuilderFactory {

    /**
     * This private constructor added to hide the implicit public constructor
     */
    private ESBDebugPointBuilderFactory() {

    }

    /**
     * This method takes project type as a input and returns specific Debug
     * point Builder
     * 
     * @param type
     * @return BreakpointBuilder
     * @throws ESBDebuggerException
     *             when artifact type is not valid for mark debug points
     */
    public static IESBDebugPointBuilder getBreakpointBuilder(ArtifactType type) throws ESBDebuggerException {

        switch (type) {
        case PROXY:
            return new ProxyDebugPointBuilder();
        case SEQUENCE:
            return new SequenceDebugPointBuilder();
        case TEMPLATE_SEQUENCE:
            return new TemplateDebugPointBuilder();
        case API:
            return new APIDebugPointBuilder();
        case MAIN_SEQUENCE:
            return new MainSequenceDebugPointBuilder();
        case INBOUND_ENDPOINT:
            return new InboundEndpointDebugPointBuilder();
        default:
            throw new ESBDebuggerException("Unsupported Project Type for Debugging");
        }
    }
}
