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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MissingAttributeException;

/**
 * This interface should be implemented by classes which have the
 * implementations to locate mediator according to Debug Point Event Occurred in
 * ESB Server Debugger
 *
 */
public interface IMediatorLocator {

    /**
     * This method search through ESB mediation flow diagram and give the
     * editPart of the matching mediator with debugpoint
     * 
     * @param esbServer
     * @param breakpoint
     * @return
     * @throws MediatorNotFoundException
     * @throws MissingAttributeException
     * @throws CoreException
     * @throws DebugPointMarkerNotFoundException
     */
    EditPart getMediatorEditPart(EsbServer esbServer, ESBDebugPoint breakpoint) throws MediatorNotFoundException,
            MissingAttributeException, DebugPointMarkerNotFoundException, CoreException;

}
