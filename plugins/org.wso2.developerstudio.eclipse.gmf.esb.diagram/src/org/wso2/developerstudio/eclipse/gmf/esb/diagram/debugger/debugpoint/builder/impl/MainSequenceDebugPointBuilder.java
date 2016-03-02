/* Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MAIN_SEQUENCE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MAIN_SEQUENCE_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_INSERT_ACTION;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.NAMED_SEQUENCE_LABEL;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBMediatorPosition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBSequenceBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBSequenceDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;

/**
 * This class builds ESB breakpoints related to Main Sequence.
 */
public class MainSequenceDebugPointBuilder extends AbstractESBDebugPointBuilder {

    private static final int OUT_SEQ_POSITION = 1;
    private static final int IN_SEQ_POSITION = 0;

    /**
     * This method returns the ESBBreakpoint object for the selection
     * 
     * @throws MediatorNotFoundException
     */
    @Override
    public ESBDebugPoint getESBDebugPoint(EsbServer esbServer, IResource resource, AbstractMediator part,
            String commandArgument) throws CoreException, MediatorNotFoundException {

        int lineNumber = -1;
        ProxyServiceImpl mainSequence = (ProxyServiceImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);

        int listSeqPosition;
        List<Integer> position = null;
        EObject selection = ((View) part.getModel()).getElement();
        if (part.reversed) {
            listSeqPosition = OUT_SEQ_POSITION;
            position = getMediatorPosition(mainSequence.getOutSequenceOutputConnector(), selection);
        } else {
            listSeqPosition = IN_SEQ_POSITION;
            position = getMediatorPosition(mainSequence.getOutputConnector(), selection);
        }
        position.add(INDEX_OF_FIRST_ELEMENT, listSeqPosition);
        ESBSequenceBean mainSequenceBean = new ESBSequenceBean(NAMED_SEQUENCE_LABEL, MAIN_SEQUENCE_NAME,
                new ESBMediatorPosition(position));
        ESBSequenceDebugPointMessage mainSeqDebugPoint = new ESBSequenceDebugPointMessage(null, commandArgument,
                MAIN_SEQUENCE_LABEL, mainSequenceBean);
        return new ESBDebugPoint(resource, lineNumber, mainSeqDebugPoint);
    }

    /**
     * This method update all breakpoints affected by the mediator insertion or
     * deletion action specified by action parameter and mediator object
     * specified by abstractMediator parameter.
     * 
     * @throws MediatorNotFoundException
     */
    @Override
    public void updateExistingDebugPoints(IResource resource, AbstractMediator abstractMediator, EsbServer esbServer,
            String action) throws MediatorNotFoundException {

        ProxyServiceImpl mainSequence = (ProxyServiceImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);

        String listSequenceNumber = EMPTY_STRING + OUT_SEQ_POSITION;
        if (abstractMediator.reversed) {
            List<Integer> position = new ArrayList<>();
            position.add(OUT_SEQ_POSITION);
            position.addAll(1, getMediatorPosition(mainSequence.getOutputConnector(), abstractMediator));
            List<ESBDebugPoint> breakpontList = getDebugPointsRelatedToModification(resource, position,
                    listSequenceNumber, action);
            if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
                increaseBreakpointPosition(breakpontList, position);
            } else {
                decreaseBreakpointPosition(breakpontList, position);
            }
        } else {
            listSequenceNumber = EMPTY_STRING + IN_SEQ_POSITION;
            List<Integer> position = new ArrayList<>();
            position.add(IN_SEQ_POSITION);
            position.addAll(1, getMediatorPosition(mainSequence.getOutputConnector(), abstractMediator));
            List<ESBDebugPoint> breakpontList = getDebugPointsRelatedToModification(resource, position,
                    listSequenceNumber, action);
            if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
                increaseBreakpointPosition(breakpontList, position);
            } else {
                decreaseBreakpointPosition(breakpontList, position);
            }
        }
    }

}
