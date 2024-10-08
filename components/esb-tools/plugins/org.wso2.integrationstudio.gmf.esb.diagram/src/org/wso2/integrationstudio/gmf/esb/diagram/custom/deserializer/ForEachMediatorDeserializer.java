/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.ForEachMediator;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.gmf.esb.SequenceType;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.*;

public class ForEachMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, ForEachMediator> {

    @Override
    public ForEachMediator createNode(IGraphicalEditPart part, AbstractMediator object) throws DeserializerException {
        Assert.isTrue(object instanceof org.apache.synapse.mediators.builtin.ForEachMediator,
                "Unsupported mediator passed in for deserialization");

        org.apache.synapse.mediators.builtin.ForEachMediator mediator = (org.apache.synapse.mediators.builtin.ForEachMediator) object;
        ForEachMediator mediatorModel = (ForEachMediator) DeserializerUtils.createNode(part,
                EsbElementTypes.ForEachMediator_3780);
        setElementToEdit(mediatorModel);
        setCommonProperties(mediator, mediatorModel);

        executeSetValueCommand(FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION,
                createNamespacedProperty(mediator.getExpression()));
        executeSetValueCommand(FOR_EACH_MEDIATOR__FOR_EACH_ID, mediator.getId());
        executeSetValueCommand(FOR_EACH_MEDIATOR__CONTINUE_LOOP_ON_FAILURE, mediator.getContinueLoopOnFailure());

        if (mediator.getSequence() != null) {
            executeSetValueCommand(FOR_EACH_MEDIATOR__SEQUENCE_TYPE, SequenceType.ANONYMOUS);
            refreshEditPartMap();
            IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(mediatorModel.getMediatorFlow())
                    .getChildren().get(0);
            deserializeSequence(compartment, mediator.getSequence(), mediatorModel.getTargetOutputConnector());
        } else if (mediator.getSequenceRef() != null && !mediator.getSequenceRef().equals("")) {
            executeSetValueCommand(FOR_EACH_MEDIATOR__SEQUENCE_TYPE, SequenceType.REGISTRY_REFERENCE);
            RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            regkey.setKeyValue(mediator.getSequenceRef());
            executeSetValueCommand(FOR_EACH_MEDIATOR__SEQUENCE_KEY, regkey);
        }

        return mediatorModel;
    }

}
