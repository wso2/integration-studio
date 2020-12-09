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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.List;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class ClassMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, ClassMediator> {

    @Override
    public ClassMediator createNode(IGraphicalEditPart part, AbstractMediator object) {

        Assert.isTrue(object instanceof ClassMediatorExt, "Unsupported mediator passed in for deserialization");
        ClassMediatorExt mediator = (ClassMediatorExt) object;

        final ClassMediator mediatorModel = (ClassMediator) DeserializerUtils.createNode(part,
                EsbElementTypes.ClassMediator_3506);
        setElementToEdit(mediatorModel);
        setCommonProperties(mediator, mediatorModel);
        executeSetValueCommand(CLASS_MEDIATOR__CLASS_NAME, mediator.getMediatorClass());

        List<MediatorProperty> properties = mediator.getProperties();
        for (MediatorProperty entry : properties) {
            final ClassProperty property = EsbFactory.eINSTANCE.createClassProperty();
            property.setPropertyName(entry.getName());

            if (null != entry.getValue()) {
                property.setPropertyValueType(PropertyValueType.LITERAL);
                property.setPropertyValue(entry.getValue());

            } else if (null != entry.getExpression()) {
                property.setPropertyValueType(PropertyValueType.EXPRESSION);
                SynapsePath xpath = entry.getExpression();
                NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
                property.setPropertyExpression(namespaceProp);

            }
            executeAddValueCommand(mediatorModel.getProperties(), property, false);
        }

        return mediatorModel;
    }

}
