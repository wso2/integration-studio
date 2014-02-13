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


import java.util.Map;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class CallTemplateMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CallTemplateMediator>{

	@Override
	public CallTemplateMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof InvokeMediator,
		"Unsupported mediator passed in for deserialization");
		
		InvokeMediator  mediator = (InvokeMediator) object;
		
		CallTemplateMediator mediatorModel = (CallTemplateMediator) DeserializerUtils.createNode(part, EsbElementTypes.CallTemplateMediator_3594);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);
		executeSetValueCommand(CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE, mediator.getTargetTemplate());
		executeSetValueCommand(CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES, "Select From Templates");

		Map<String, Value> parameters = mediator.getpName2ExpressionMap();
		for(Map.Entry<String, Value> entry : parameters.entrySet()){
			CallTemplateParameter parameter = EsbFactory.eINSTANCE.createCallTemplateParameter();
			parameter.setParameterName(entry.getKey());
			Value value = entry.getValue();
			if(value.getExpression() != null){
				boolean dynamic = value.hasExprTypeKey();
				NamespacedProperty namespacedProperty = createNamespacedProperty(value.getExpression());
				namespacedProperty.setDynamic(dynamic);
				namespacedProperty.setSupportsDynamicXPaths(true);
				parameter.setParameterExpression(namespacedProperty);
				parameter.setTemplateParameterType(RuleOptionType.EXPRESSION);
			} else{
				parameter.setParameterValue(value.getKeyValue());
				parameter.setTemplateParameterType(RuleOptionType.VALUE);
			}
			executeAddValueCommand(mediatorModel.getTemplateParameters(), parameter);
		}
		
		return mediatorModel;
	}
	

}
