/*
* Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.integrationstudio.gmf.esb.DSSMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.DSS_MEDIATOR__SERVICE_NAME;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.DSS_MEDIATOR__SOURCE_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.DSS_MEDIATOR__TARGET_TYPE;

public class DataServicesCallMediatorDeserializer
        extends AbstractEsbNodeDeserializer<AbstractMediator, DSSMediator> {

    @Override
    public DSSMediator createNode(IGraphicalEditPart part, AbstractMediator mediator)
            throws DeserializerException {
        Assert.isTrue(mediator instanceof org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());

        org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator dataServiceCallMediator = (org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator) mediator;
        DSSMediator visualDataServicesCall = (DSSMediator) DeserializerUtils.createNode(part,
                EsbElementTypes.DSSMediator_3794);
        setElementToEdit(visualDataServicesCall);
        setCommonProperties(dataServiceCallMediator, visualDataServicesCall);

        String serviceName = dataServiceCallMediator.getDsName();
        if (serviceName != null) {
            executeSetValueCommand(DSS_MEDIATOR__SERVICE_NAME, serviceName);
        }

        if (!dataServiceCallMediator.getSourceType().isEmpty()) {
            executeSetValueCommand(DSS_MEDIATOR__SOURCE_TYPE, dataServiceCallMediator.getSourceType());
        }

        if (!dataServiceCallMediator.getTargetType().isEmpty()) {
            executeSetValueCommand(DSS_MEDIATOR__TARGET_TYPE, dataServiceCallMediator.getTargetType());
        }

        return visualDataServicesCall;
    }
}