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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_INSERT_ACTION;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_FAULTSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_INSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_OUTSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_IN_A_UNKNOWN_POSITION_LOG_MESSAGE;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBMediatorPosition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBProxyBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBProxyDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBProxySequenceBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceFaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceSequenceAndEndpointContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;

/**
 * This class builds ESB breakpoints related to Proxy Services.
 */
public class ProxyDebugPointBuilder extends AbstractESBDebugPointBuilder {

    /**
     * This method returns the ESBBreakpoint object for the selection
     * 
     * @throws ESBDebuggerException
     * @throws CoreException
     */
    @Override
    public ESBDebugPoint getESBDebugPoint(EsbServer esbServer, IResource resource, AbstractMediator part,
            String commandArgument) throws ESBDebuggerException, CoreException {

        int lineNumber = -1;
        ProxyServiceImpl proxy = (ProxyServiceImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);
        List<Integer> position = null;
        EObject selection = ((View) part.getModel()).getElement();
        String sequenceType = EMPTY_STRING;
        EditPart container = getContainerFromEditPart(part, ProxyServiceContainerEditPart.class);
        if (container instanceof ProxyServiceSequenceAndEndpointContainerEditPart) {
            if (part.reversed) {
                position = getMediatorPosition(proxy.getOutSequenceOutputConnector(), selection);
                sequenceType = PROXY_OUTSEQ_LABEL;
            } else {
                position = getMediatorPosition(proxy.getOutputConnector(), selection);
                sequenceType = PROXY_INSEQ_LABEL;
            }
        } else if (container instanceof ProxyServiceFaultContainerEditPart) {
            position = getMediatorPositionInFaultSeq(proxy.getContainer().getFaultContainer().getMediatorFlow()
                    .getChildren(), selection);
            sequenceType = PROXY_FAULTSEQ_LABEL;
        } else {
            throw new IllegalArgumentException(MEDIATOR_IN_A_UNKNOWN_POSITION_LOG_MESSAGE + container.toString());
        }

        ESBProxyBean proxyBean = new ESBProxyBean(proxy.getName(), sequenceType, new ESBMediatorPosition(position));
        ESBProxyDebugPointMessage proxyDebugPoint = new ESBProxyDebugPointMessage(null, commandArgument,
                new ESBProxySequenceBean(proxyBean));
        return new ESBDebugPoint(resource, lineNumber, proxyDebugPoint);
    }

    /**
     * This method update all breakpoints affected by the mediator insertion or
     * deletion action of specified by action parameter and mediator object
     * specified by abstractMediator parameter.
     * 
     * @throws ESBDebuggerException
     */
    @Override
    public void updateExistingDebugPoints(IResource resource, AbstractMediator abstractMediator, EsbServer esbServer,
            String action) throws ESBDebuggerException {
        ProxyServiceImpl proxy = (ProxyServiceImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);
        List<Integer> position = new ArrayList<>();
        List<ESBDebugPoint> breakpontList = new ArrayList<>();
        EditPart container = getContainerFromEditPart(abstractMediator, ProxyServiceContainerEditPart.class);
        if (abstractMediator.reversed) {
            if (container instanceof ProxyServiceSequenceAndEndpointContainerEditPart) {
                position = getMediatorPosition(proxy.getOutSequenceOutputConnector(), abstractMediator);
                breakpontList = getDebugPointsRelatedToModification(resource, position, PROXY_OUTSEQ_LABEL, action);
            } else if (container instanceof ProxyServiceFaultContainerEditPart) {
                position = getMediatorPositionInFaultSeq(proxy.getContainer().getFaultContainer().getMediatorFlow()
                        .getChildren(), abstractMediator);
                breakpontList = getDebugPointsRelatedToModification(resource, position, PROXY_FAULTSEQ_LABEL, action);
            } else {
                throw new IllegalArgumentException(MEDIATOR_IN_A_UNKNOWN_POSITION_LOG_MESSAGE + container.toString());
            }
        } else if (container instanceof ProxyServiceSequenceAndEndpointContainerEditPart) {
            position = getMediatorPosition(proxy.getOutputConnector(), abstractMediator);
            breakpontList = getDebugPointsRelatedToModification(resource, position, PROXY_INSEQ_LABEL, action);
        } else {
            throw new IllegalArgumentException(MEDIATOR_IN_A_UNKNOWN_POSITION_LOG_MESSAGE + container.toString());
        }
        if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
            increaseBreakpointPosition(breakpontList, position);
        } else {
            decreaseBreakpointPosition(breakpontList, position);
        }

    }

}
