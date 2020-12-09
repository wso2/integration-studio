/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediatorProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class JsonTransformMediatorTransformer extends AbstractEsbNodeTransformer {

    @Override
    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        Assert.isTrue(subject instanceof JsonTransformMediator, "Invalid subject.");
        JsonTransformMediator visualJsonTransform = (JsonTransformMediator) subject;

        information.getParentSequence().addChild(createJsonTransformMediator(visualJsonTransform, false));
        // Transform the jsonTransform mediator output data flow path.
        doTransform(information, visualJsonTransform.getOutputConnector());
    }

    private Mediator createJsonTransformMediator(JsonTransformMediator visualJsonTransform, boolean b) {
        org.apache.synapse.mediators.builtin.JSONTransformMediator jsonTransformMediator = new org.apache.synapse.mediators.builtin.JSONTransformMediator();
        setCommonProperties(jsonTransformMediator, visualJsonTransform);

        boolean hasNoSchema = false;
        if (visualJsonTransform.getSchema() != null && !visualJsonTransform.getSchema().getKeyValue().equals("")) {
            jsonTransformMediator.setSchemaKey(new Value(visualJsonTransform.getSchema().getKeyValue()));
        } else {
            hasNoSchema = true;
        }

        boolean hasNoProperties = false;
        if (!visualJsonTransform.getJsonTransformProperties().isEmpty()) {
            List<MediatorProperty> mediatorPropertyList = new ArrayList<MediatorProperty>();
            for (JsonTransformMediatorProperty jsonTransformMediatorProperty : visualJsonTransform
                    .getJsonTransformProperties()) {
                MediatorProperty mediatorProperty = new MediatorProperty();
                if (jsonTransformMediatorProperty.getPropertyName() != null) {
                	mediatorProperty.setName(jsonTransformMediatorProperty.getPropertyName());
                } else {
                	mediatorProperty.setName(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
                }
                if (jsonTransformMediatorProperty.getPropertyValue() != null) {
                	mediatorProperty.setValue(jsonTransformMediatorProperty.getPropertyValue());
                } else {
                	mediatorProperty.setValue(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
                }
                mediatorPropertyList.add(mediatorProperty);
            }
            jsonTransformMediator.addAllProperties(mediatorPropertyList);
        } else {
            hasNoProperties = true;
        }
        
        if (hasNoSchema && hasNoProperties) {
            jsonTransformMediator.setSchemaKey(new Value(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION));
        }

        return jsonTransformMediator;

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
