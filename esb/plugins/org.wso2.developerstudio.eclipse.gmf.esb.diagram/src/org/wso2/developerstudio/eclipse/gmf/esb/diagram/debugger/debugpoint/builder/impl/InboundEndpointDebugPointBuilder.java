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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INBOUND_SEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INBOUND_FAULT_SEQ_LABEL;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBInboundEndpointBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBInboundEndpointDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBInboundEndpointSequenceBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBMediatorPosition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointOnErrorSequenceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointSequenceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl;

/**
 * This class builds ESB breakpoints related to Inbound Endpoint Services.
 */
public class InboundEndpointDebugPointBuilder extends AbstractESBDebugPointBuilder {

    /**
     * This method returns the ESBDebugPoint object for the selection
     * 
     * @throws ESBDebuggerException
     * @throws CoreException
     */
    @Override
    public ESBDebugPoint getESBDebugPoint(EsbServer esbServer, IResource resource, AbstractMediator part,
            String commandArgument) throws ESBDebuggerException, CoreException {

        int lineNumber = -1;
        InboundEndpointImpl inboundEndpoint = (InboundEndpointImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);
        List<Integer> position = new ArrayList<>();
        String sequenceType = EMPTY_STRING;
        EditPart container = getContainerFromEditPart(part, InboundEndpointContainerEditPart.class);
        if (container instanceof InboundEndpointSequenceContainerEditPart) {
            position.add(0);
            sequenceType = INBOUND_SEQ_LABEL;
        } else if (container instanceof InboundEndpointOnErrorSequenceContainerEditPart) {
            position.add(0);
            sequenceType = INBOUND_FAULT_SEQ_LABEL;
        } else {
            throw new IllegalArgumentException("Selected Metdiator Edit Part is in a unknown position : "
                    + container.toString());
        }

        ESBInboundEndpointBean inboundBean = new ESBInboundEndpointBean(inboundEndpoint.getName(), sequenceType,
                new ESBMediatorPosition(position));
        ESBInboundEndpointDebugPointMessage inboundDebugPoint = new ESBInboundEndpointDebugPointMessage(null,
                commandArgument, new ESBInboundEndpointSequenceBean(inboundBean));
        return new ESBDebugPoint(resource, lineNumber, inboundDebugPoint);
    }

    @Override
    public void updateExistingDebugPoints(IResource resource, AbstractMediator abstractMediator, EsbServer esbServer,
            String action) throws MediatorNotFoundException {
        // no implementation because Inbound endpoint can only have one sequence
        // on both "onErrorSequence" and "sequence"
    }

}
