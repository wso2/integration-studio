/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.gmf.esb.internal.persistence;

import java.util.List;
import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.integrationstudio.gmf.esb.EsbNode;
import org.wso2.integrationstudio.gmf.esb.DSSMediator;
import org.wso2.integrationstudio.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.gmf.esb.persistence.TransformerException;

public class DataServiceCallMediatorTransformer extends AbstractEsbNodeTransformer {

    @Override
    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        Assert.isTrue(subject instanceof DSSMediator, "Invalid subject.");
        DSSMediator visualDataServicesCall = (DSSMediator) subject;

        information.getParentSequence().addChild(createDataServicesCallMediator(visualDataServicesCall));
        // Transform the DataServicesCall mediator output data flow path.
        doTransform(information, visualDataServicesCall.getOutputConnector());
    }

    private Mediator createDataServicesCallMediator(DSSMediator visualDataServicesCall) {
    	org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator dataServicesCallMediator = new org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator();
        setCommonProperties(dataServicesCallMediator, visualDataServicesCall);

        if (visualDataServicesCall.getServiceName() != null) {
            dataServicesCallMediator.setDsName(visualDataServicesCall.getServiceName());
        } else {
        	dataServicesCallMediator.setDsName("");
        }

        String sourceType = visualDataServicesCall.getSourceType().getLiteral();
        String targetType = visualDataServicesCall.getTargetType().getLiteral();

        if (!sourceType.isEmpty()) {
            dataServicesCallMediator.setSourceType(sourceType);
        } 

        if (!targetType.isEmpty()) {
            dataServicesCallMediator.setTargetType(targetType);
            if(targetType.equals("PROPERTY")) {
            	 String targetProperty = visualDataServicesCall.getTargetProperty();
            	 if(!targetProperty.isEmpty()) {
            		 dataServicesCallMediator.setTargetPropertyName(targetProperty);
            	 }
            }
        }

        return dataServicesCallMediator;

    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub
    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        // TODO Auto-generated method stub
    }

}
