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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediatorProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.JSON_TRANSFORM_MEDIATOR__SCHEMA;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES;

public class JsonTransformMediatorDeserializer
        extends AbstractEsbNodeDeserializer<AbstractMediator, JsonTransformMediator> {

    @Override
    public JsonTransformMediator createNode(IGraphicalEditPart part, AbstractMediator mediator)
            throws DeserializerException {
        Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.JSONTransformMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());

        org.apache.synapse.mediators.builtin.JSONTransformMediator jsonTransformMediator = (org.apache.synapse.mediators.builtin.JSONTransformMediator) mediator;
        JsonTransformMediator visualJsonTransform = (JsonTransformMediator) DeserializerUtils.createNode(part,
                EsbElementTypes.JsonTransformMediator_3791);
        setElementToEdit(visualJsonTransform);
        setCommonProperties(jsonTransformMediator, visualJsonTransform);

        if (jsonTransformMediator.getSchemaKey() != null
                && !jsonTransformMediator.getSchemaKey().getKeyValue().equals("")) {
            RegistryKeyProperty schema = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            schema.setKeyValue(jsonTransformMediator.getSchemaKey().getKeyValue());
            executeSetValueCommand(JSON_TRANSFORM_MEDIATOR__SCHEMA, schema);
        }

        if (!jsonTransformMediator.getProperties().isEmpty()) {
            EList<JsonTransformMediatorProperty> JsonTransformMediatorPropertyList = new BasicEList<JsonTransformMediatorProperty>();
            for (MediatorProperty mediatorProperty : jsonTransformMediator.getProperties()) {
                JsonTransformMediatorProperty jsonTransformMediatorProperty = EsbFactory.eINSTANCE
                        .createJsonTransformMediatorProperty();
                jsonTransformMediatorProperty.setPropertyName(mediatorProperty.getName());
                jsonTransformMediatorProperty.setPropertyValue(mediatorProperty.getValue());
                JsonTransformMediatorPropertyList.add(jsonTransformMediatorProperty);
            }
            executeSetValueCommand(JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES,
                    JsonTransformMediatorPropertyList);
        }

        return visualJsonTransform;
    }
}
