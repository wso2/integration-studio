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

import java.util.HashMap;
import java.util.Map;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.POJOCommandMediatorExt;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class POJOCommandMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CommandMediator> {

	@Override
	public CommandMediator createNode(IGraphicalEditPart part, AbstractMediator object) {

		Assert.isTrue(object instanceof POJOCommandMediatorExt,
				"Unsupported mediator passed in for deserialization");

		POJOCommandMediatorExt mediator = (POJOCommandMediatorExt) object;
		CommandMediator mediatorModel = (CommandMediator) DeserializerUtils.createNode(part, EsbElementTypes.CommandMediator_3511);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);
		executeSetValueCommand(COMMAND_MEDIATOR__CLASS_NAME, mediator.getPojoClass());
		
		Map<String,CommandProperty> properties = new HashMap<String,CommandProperty>();
		
		for (String propName : mediator.getStaticSetterProperties().keySet()) {
			CommandProperty property = EsbFactory.eINSTANCE.createCommandProperty();
			property.setPropertyName(propName);
            Object value = mediator.getStaticSetterProperties().get(propName);
            property.setValueLiteral(value.toString());
            if (mediator.getContextGetterProperties().containsKey(propName)) {
            	property.setValueContextPropertyName(mediator.getContextGetterProperties().get(propName).toString());
            } else if (mediator.getMessageGetterProperties().containsKey(propName)) {
            	property.setValueMessageElementXpath(createNamespacedProperty(mediator.getMessageGetterProperties().get(propName)));
            }
            property.setValueType(CommandPropertyValueType.LITERAL);
            properties.put(propName, property);
        }

        for (String propName : mediator.getMessageSetterProperties().keySet()) {
        	CommandProperty property = EsbFactory.eINSTANCE.createCommandProperty();
			property.setPropertyName(propName);
			property.setValueMessageElementXpath(createNamespacedProperty(mediator.getMessageGetterProperties().get(propName)));
			property.setValueType(CommandPropertyValueType.MESSAGE_ELEMENT);
            if (mediator.getMessageGetterProperties().containsKey(propName)) {
            	property.setMessageAction(CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE);
            } else if (mediator.getContextGetterProperties().containsKey(propName)) {
            	property.setValueContextPropertyName(mediator.getContextGetterProperties().get(propName));
            	property.setMessageAction(CommandPropertyMessageAction.READ_MESSAGE);
            } else {
            	property.setMessageAction(CommandPropertyMessageAction.READ_MESSAGE);                              
            }
            properties.put(propName, property);
        }

        for (String propName : mediator.getContextSetterProperties().keySet()) {
        	CommandProperty property = EsbFactory.eINSTANCE.createCommandProperty();
			property.setPropertyName(propName);
			property.setValueContextPropertyName(mediator.getContextSetterProperties().get(propName));

            if (mediator.getContextGetterProperties().containsKey(propName)) {
            	property.setContextAction(CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT);
            } else if (mediator.getMessageGetterProperties().containsKey(propName)) {
            	property.setContextAction(CommandPropertyContextAction.READ_CONTEXT);
            	property.setValueMessageElementXpath(createNamespacedProperty(mediator.getMessageGetterProperties().get(propName)));
            } else {
            	property.setContextAction(CommandPropertyContextAction.READ_CONTEXT);               
            }
            property.setValueType(CommandPropertyValueType.CONTEXT_PROPERTY);
            properties.put(propName, property);
        }

        for (String propName : mediator.getContextGetterProperties().keySet()) {
            if (!isSerialized(propName, mediator)) {
                String value = mediator.getContextGetterProperties().get(propName);
            	CommandProperty property = EsbFactory.eINSTANCE.createCommandProperty();
    			property.setPropertyName(propName);
    			property.setValueContextPropertyName(value);
                property.setContextAction(CommandPropertyContextAction.UPDATE_CONTEXT);
                properties.put(propName, property);
            }
        }

        for (String propName : mediator.getMessageGetterProperties().keySet()) {
            if (!isSerialized(propName, mediator)) {
            	CommandProperty property = EsbFactory.eINSTANCE.createCommandProperty();
    			property.setPropertyName(propName);
    			property.setMessageAction(CommandPropertyMessageAction.UPDATE_MESSAGE);
    			property.setValueMessageElementXpath(createNamespacedProperty(mediator.getMessageGetterProperties().get(propName)));
    			properties.put(propName, property);
            }
        }
        
        for (CommandProperty property : properties.values()) {
			executeAddValueCommand(mediatorModel.getProperties(), property);
		}
		
		return mediatorModel;
	}
	
    private boolean isSerialized(String propName, POJOCommandMediatorExt m) {
        return m.getContextSetterProperties().containsKey(propName) ||
            m.getStaticSetterProperties().containsKey(propName) ||
            m.getMessageSetterProperties().containsKey(propName);
    }


}
