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

import org.apache.synapse.mediators.Value;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BeanMediatorExt;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class BeanMediatorDeserializer extends
		AbstractEsbNodeDeserializer<BeanMediatorExt, BeanMediator> {

	@Override
	public BeanMediator createNode(IGraphicalEditPart part, BeanMediatorExt mediator) {
		BeanMediator mediatorModel = (BeanMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.BeanMediator_3683);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);

		executeSetValueCommand(BEAN_MEDIATOR__VAR, mediator.getVarName());

		switch (mediator.getAction()) {
		case CREATE:
			executeSetValueCommand(BEAN_MEDIATOR__ACTION, BeanMediatorAction.CREATE);
			executeSetValueCommand(BEAN_MEDIATOR__CLASS, mediator.getClassName());
			break;
		case GET_PROPERTY:
			executeSetValueCommand(BEAN_MEDIATOR__ACTION, BeanMediatorAction.GET_PROPERTY);
			executeSetValueCommand(BEAN_MEDIATOR__PROPERTY, mediator.getPropertyName());

			Value targetValue = mediator.getTargetValue();
			if (targetValue != null) {
				if (targetValue.getExpression() != null) {
					executeSetValueCommand(BEAN_MEDIATOR__TARGET_TYPE, PropertyValueType.EXPRESSION);
					executeSetValueCommand(BEAN_MEDIATOR__TARGET_EXPRESSION,
							createNamespacedProperty(targetValue.getExpression()));
				} else {
					executeSetValueCommand(BEAN_MEDIATOR__TARGET_TYPE, PropertyValueType.LITERAL);
					executeSetValueCommand(BEAN_MEDIATOR__TARGET_LITERAL, targetValue.getKeyValue());
				}
			}
			break;
		case REMOVE:
			executeSetValueCommand(BEAN_MEDIATOR__ACTION, BeanMediatorAction.REMOVE);
			break;
		case SET_PROPERTY:
			executeSetValueCommand(BEAN_MEDIATOR__ACTION, BeanMediatorAction.SET_PROPERTY);
			executeSetValueCommand(BEAN_MEDIATOR__PROPERTY, mediator.getPropertyName());
			
			Value value = mediator.getValue();
			if (value != null) {
				if (value.getExpression() != null) {
					executeSetValueCommand(BEAN_MEDIATOR__VALUE_TYPE, PropertyValueType.EXPRESSION);
					executeSetValueCommand(BEAN_MEDIATOR__VALUE_EXPRESSION,
							createNamespacedProperty(value.getExpression()));
				} else {
					executeSetValueCommand(BEAN_MEDIATOR__VALUE_TYPE, PropertyValueType.LITERAL);
					executeSetValueCommand(BEAN_MEDIATOR__VALUE_LITERAL, value.getKeyValue());
				}
			}
			break;
		}
		return mediatorModel;
	}

}
