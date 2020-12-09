/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
  *      http://www.apache.org/licenses/LICENSE-2.0
  * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyGroupMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class PropertyGroupMediatorDeserializer
        extends AbstractEsbNodeDeserializer<AbstractMediator, PropertyGroupMediator> {

    @Override
    public PropertyGroupMediator createNode(IGraphicalEditPart part, AbstractMediator mediator)
            throws DeserializerException {
        Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.PropertyGroupMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());

        org.apache.synapse.mediators.builtin.PropertyGroupMediator propertyGroupMediator = (org.apache.synapse.mediators.builtin.PropertyGroupMediator) mediator;

        org.wso2.integrationstudio.eclipse.gmf.esb.PropertyGroupMediator visualPropertyGroup = (org.wso2.integrationstudio.eclipse.gmf.esb.PropertyGroupMediator) DeserializerUtils
                .createNode(part, EsbElementTypes.PropertyGroupMediator_3788);
        setElementToEdit(visualPropertyGroup);
        setCommonProperties(propertyGroupMediator, visualPropertyGroup);

        PropertyMediatorDeserializer propertyMediatorDeserializer = new PropertyMediatorDeserializer();

        EList<org.wso2.integrationstudio.eclipse.gmf.esb.PropertyMediator> propertyList = new BasicEList<org.wso2.integrationstudio.eclipse.gmf.esb.PropertyMediator>();
        for (PropertyMediator propretyMediator : propertyGroupMediator.getPropGroupList()) {
            org.wso2.integrationstudio.eclipse.gmf.esb.PropertyMediator propMediator = propertyMediatorDeserializer
                    .createNode(part, propretyMediator);
            propertyList.add(propMediator);
        }
        executeSetValueCommand(PROPERTY_GROUP_MEDIATOR__PROPERTIES, propertyList);
        return visualPropertyGroup;
    }
}
