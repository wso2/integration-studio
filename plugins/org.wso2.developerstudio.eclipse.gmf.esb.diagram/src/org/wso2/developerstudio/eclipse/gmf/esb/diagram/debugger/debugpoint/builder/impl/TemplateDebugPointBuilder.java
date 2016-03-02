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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TEMPLATE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TEMPLATE_SEQUENCE;

import java.util.List;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBMediatorPosition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBTemplateBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBTemplateDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateImpl;

/**
 * This class has methods related to creation and modification of debug points
 * for Sequence Template artifacts.
 * <p>
 * If the affected mediator of debug point related action is in a Sequence Template, this builder class can be use
 * directly or ask from {@link ESBDebugPointBuilderFactory} for a instance of this class to create or modify the debug
 * point.
 */
public class TemplateDebugPointBuilder extends AbstractESBDebugPointBuilder {

    /**
     * This method returns the {@link ESBDebugPoint} object for the selected
     * editpart in the sequence template.
     * 
     * @throws MediatorNotFoundException
     * @throws CoreException
     */
    @Override
    public ESBDebugPoint getESBDebugPoint(EsbServer esbServer, IResource resource, AbstractMediator part,
            String commandArgument) throws MediatorNotFoundException, CoreException {

        TemplateImpl template = (TemplateImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);

        if (template.getChild() instanceof SequencesImpl) {
            EsbElement sequnce = template.getChild();
            EObject selection = ((View) part.getModel()).getElement();
            List<Integer> position = getMediatorPosition(((SequencesImpl) sequnce).getOutputConnector(), selection);
            int lineNumber = -1;
            ESBTemplateBean templateBean = new ESBTemplateBean(template.getName(), new ESBMediatorPosition(position));
            ESBTemplateDebugPointMessage templateDebugPoint = new ESBTemplateDebugPointMessage(null, commandArgument,
                    TEMPLATE_LABEL, templateBean);
            return new ESBDebugPoint(resource, lineNumber, templateDebugPoint);
        } else {
            throw new UnsupportedOperationException("Debug Point Integration not supported for template : "
                    + template.getChild());
        }
    }

    /**
     * This method update all debug points affected by the mediator insertion or
     * deletion action specified by action parameter and mediator object
     * specified by abstractMediator parameter.
     * 
     * @throws MediatorNotFoundException
     */
    @Override
    public void updateExistingDebugPoints(IResource resource, AbstractMediator abstractMediator, EsbServer esbServer,
            String action) throws MediatorNotFoundException {
        TemplateImpl template = (TemplateImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);

        if (template.getChild() instanceof SequencesImpl) {
            EsbElement sequnce = template.getChild();
            List<Integer> position = getMediatorPosition(((SequencesImpl) sequnce).getOutputConnector(),
                    abstractMediator);
            List<ESBDebugPoint> breakpontList = getDebugPointsRelatedToModification(resource, position,
                    TEMPLATE_SEQUENCE, action);
            if (MEDIATOR_INSERT_ACTION.equalsIgnoreCase(action)) {
                increaseBreakpointPosition(breakpontList, position);
            } else {
                decreaseBreakpointPosition(breakpontList, position);
            }

        }
    }

}
