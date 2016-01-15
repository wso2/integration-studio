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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_INSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_OUTSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_FAULTSEQ_LABEL;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MissingAttributeException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBProxyDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;

/**
 * This class contains methods related locate and get mediators in a Proxy
 * Service
 */
public class ProxyMediatorLocator extends AbstractMediatorLocator {

    /**
     * This method returns EditPart of a Proxy Service according to given
     * information Map
     * 
     * @throws MediatorNotFoundException
     * @throws MissingAttributeException
     * @throws CoreException
     * @throws DebugPointMarkerNotFoundException
     */
    @Override
    public EditPart getMediatorEditPart(EsbServer esbServer, ESBDebugPoint debugPoint)
            throws MediatorNotFoundException, MissingAttributeException, DebugPointMarkerNotFoundException,
            CoreException {
        ESBProxyDebugPointMessage debugPointMessage = (ESBProxyDebugPointMessage) debugPoint.getLocation();
        List<Integer> positionArray = debugPointMessage.getSequence().getProxy().getMediatorPosition().getPosition();
        String sequenceType = debugPointMessage.getSequence().getProxy().getSequenceType();
        ProxyServiceImpl proxy = (ProxyServiceImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);
        if (sequenceType.equals(PROXY_FAULTSEQ_LABEL)) {
            return getMediatorInFaultSeq(proxy.getContainer().getFaultContainer().getMediatorFlow().getChildren(),
                    positionArray);
        } else if (sequenceType.equals(PROXY_INSEQ_LABEL)) {

            return getMediatorFromMediationFlow(proxy.getOutputConnector(), positionArray);

        } else if (sequenceType.equals(PROXY_OUTSEQ_LABEL)) {

            return getMediatorFromMediationFlow(proxy.getOutSequenceOutputConnector(), positionArray);
        } else {
            throw new IllegalArgumentException("Unknown sequence type for proxy service detected : " + sequenceType);
        }
    }
}
