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

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPIBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPIDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPIResourceBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPISequenceBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBMediatorPosition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceContainer2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceFaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceSequenceAndEndpointContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SynapseAPIAPICompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This class builds ESB breakpoints related to API Resources.
 */
public class APIDebugPointBuilder extends AbstractESBDebugPointBuilder {

    /**
     * This method returns the ESBBreakpoint object for the selection
     * 
     * @throws ESBDebuggerException
     */
    @Override
    public ESBDebugPoint getESBDebugPoint(EsbServer esbServer, IResource resource, AbstractMediator part,
            String commandArgument) throws CoreException, ESBDebuggerException {
        int lineNumber = -1;
        SynapseAPIImpl api = (SynapseAPIImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);

        EditPart proxyContainer = getContainerFromEditPart(part, ProxyServiceContainer2EditPart.class);
        EditPart apiContainer = getContainerFromEditPart(proxyContainer, SynapseAPIAPICompartmentEditPart.class);
        EList<APIResource> apiResources = api.getResources();
        APIResource apiResource = getAPIResourceFromAPIEditPart(apiResources, apiContainer);
        EObject selection = ((View) part.getModel()).getElement();
        List<Integer> position;
        String sequenceType;
        if (proxyContainer instanceof ProxyServiceSequenceAndEndpointContainerEditPart) {
            if (part.reversed) {
                position = getMediatorPosition(apiResource.getOutSequenceOutputConnector(), selection);
                sequenceType = API_OUTSEQ_LABEL;
            } else {
                position = getMediatorPosition(apiResource.getOutputConnector(), selection);
                sequenceType = API_INSEQ_LABEL;
            }
        } else {
            position = getMediatorPositionInFaultSeq(apiResource.getContainer().getFaultContainer().getMediatorFlow()
                    .getChildren(), selection);
            sequenceType = getFaultSequenceName(apiResource);
        }
        ESBAPIResourceBean resourse = new ESBAPIResourceBean(ESBDebuggerUtil.getMethodValuesFromResource(apiResource),
                apiResource.getUrlMapping(), apiResource.getUriTemplate());

        ESBAPIBean apiBean = new ESBAPIBean(api.getApiName(), resourse, sequenceType, new ESBMediatorPosition(position));
        ESBAPIDebugPointMessage apiDebugPoint = new ESBAPIDebugPointMessage(null, commandArgument,
                new ESBAPISequenceBean(apiBean));
        return new ESBDebugPoint(resource, lineNumber, apiDebugPoint);

    }

    /**
     * This method will select the matching <code>APIResource</code> from the
     * list with the provided <code>EditPart</code>
     * 
     * @param apiResources
     * @param apiResourceEditPart
     * @return
     * @throws ESBDebuggerException
     */
    private APIResource getAPIResourceFromAPIEditPart(EList<APIResource> apiResources, EditPart apiResourceEditPart)
            throws ESBDebuggerException {
        NodeImpl apiModel = (NodeImpl) apiResourceEditPart.getModel();
        APIResourceImpl apiResourceImpl = (APIResourceImpl) apiModel.getElement();
        for (APIResource apiResource : apiResources) {
            if (apiResource.equals(apiResourceImpl)) {
                return apiResource;
            }
        }
        throw new ESBDebuggerException("Matching APIResource is not found for APIResourceEditPart :"
                + apiResourceEditPart);
    }

    /**
     * This method update all breakpoints affected by the mediator insertion or
     * deletion action specified by action parameter and mediator object
     * specified by abstractMediator parameter.
     * 
     * @throws ESBDebuggerException
     */
    @Override
    public void updateExistingDebugPoints(IResource resource, AbstractMediator abstractMediator, EsbServer esbServer,
            String action) throws ESBDebuggerException {
        SynapseAPIImpl api = (SynapseAPIImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);
        EditPart proxyContainer = getContainerFromEditPart(abstractMediator, ProxyServiceContainer2EditPart.class);
        EditPart apiContainer = getContainerFromEditPart(proxyContainer, SynapseAPIAPICompartmentEditPart.class);
        EList<APIResource> apiResources = api.getResources();
        APIResource apiResource = getAPIResourceFromAPIEditPart(apiResources, apiContainer);
        if (proxyContainer instanceof ProxyServiceSequenceAndEndpointContainerEditPart) {
            if (abstractMediator.reversed) {
                List<Integer> position = getMediatorPosition(apiResource.getOutSequenceOutputConnector(),
                        abstractMediator);
                List<ESBDebugPoint> breakpontList = getDebugPointsRelatedToModification(resource, position,
                        API_OUTSEQ_LABEL, action);
                if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
                    increaseBreakpointPosition(breakpontList, position);
                } else {
                    decreaseBreakpointPosition(breakpontList, position);
                }
            } else {
                List<Integer> position = getMediatorPosition(apiResource.getOutputConnector(), abstractMediator);
                List<ESBDebugPoint> breakpontList = getDebugPointsRelatedToModification(resource, position,
                        API_INSEQ_LABEL, action);
                if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
                    increaseBreakpointPosition(breakpontList, position);
                } else {
                    decreaseBreakpointPosition(breakpontList, position);
                }
            }
        } else if (proxyContainer instanceof ProxyServiceFaultContainerEditPart) {
            List<Integer> position = getMediatorPositionInFaultSeq(apiResource.getContainer().getFaultContainer()
                    .getMediatorFlow().getChildren(), abstractMediator);
            List<ESBDebugPoint> breakpontList = getDebugPointsRelatedToModification(resource, position,
                    getFaultSequenceName(apiResource), action);
            if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
                increaseBreakpointPosition(breakpontList, position);
            } else {
                decreaseBreakpointPosition(breakpontList, position);
            }
        } else {
            throw new IllegalArgumentException("Selected Metdiator Edit Part is in a unknown position : "
                    + proxyContainer.toString());
        }
    }
}
