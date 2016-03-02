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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import java.util.Map;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CloudConnectorOperationExt;

public class CloudConnectorOperationDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CloudConnectorOperation>{

	public static String cloudConnectorName;
		
	@Override
	public CloudConnectorOperation createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof CloudConnectorOperationExt,"Unsupported mediator passed in for deserialization");
		CloudConnectorOperationExt operation = (CloudConnectorOperationExt) object;
		cloudConnectorName=operation.getCloudConnectorName();
		
	//	EditorUtils.getActiveEditor().getEditorSite().getPage().closeEditor(getDiagramEditor(), false);
		
		final CloudConnectorOperation operationModel = (CloudConnectorOperation) DeserializerUtils.createNode(part, EsbElementTypes.CloudConnectorOperation_3722);
		setElementToEdit(operationModel);
		executeSetValueCommand(CLOUD_CONNECTOR_OPERATION__CONFIG_REF, operation.getConfigRef());
		executeSetValueCommand(CLOUD_CONNECTOR_OPERATION__OPERATION_NAME, operation.getOperation());
		executeSetValueCommand(CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME, operation.getConnectorComponentName());	
		executeSetValueCommand(CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME, operation.getCloudConnectorName());
		executeSetValueCommand(ESB_ELEMENT__DESCRIPTION, operation.getOperation());
		
		String addedConnector = operation.getConnectorComponentName();
		String addedOperation = operationModel.getOperationName();
		
		Map<String, Value> existingParameters = operation.getpName2ExpressionMap();
		boolean namespacesExist=false;

		for (String parameter : CloudConnectorDirectoryTraverser.getInstance()
				.getAllParametersOfConnectorOperation(addedConnector, addedOperation)) {
			CallTemplateParameter visualParameter = EsbFactory.eINSTANCE
					.createCallTemplateParameter();
			visualParameter.setParameterName(parameter);
			if (existingParameters != null && existingParameters.containsKey(parameter)) {
				// parameter already exists in the config.
				Value value = existingParameters.get(parameter);

				boolean dynamic = value.hasExprTypeKey();

				if (value.getExpression() == null && value.getKeyValue() != null) {
					NamespacedProperty namespacedProperty = createNamespacedProperty(
							value.getKeyValue(), null);
					namespacedProperty.setDynamic(dynamic);
					namespacedProperty.setSupportsDynamicXPaths(true);
					visualParameter.setParameterExpression(namespacedProperty);
					visualParameter.setParameterValue(value.getKeyValue());
					visualParameter.setTemplateParameterType(RuleOptionType.VALUE);
				}

				if (value.getExpression() != null) {
					NamespacedProperty namespacedProperty = createNamespacedProperty(value
							.getExpression());
					namespacedProperty.setPropertyValue("{" + value.getExpression().toString()
							+ "}");
					namespacedProperty.setDynamic(dynamic);
					namespacedProperty.setSupportsDynamicXPaths(true);
					visualParameter.setParameterExpression(namespacedProperty);
					visualParameter.setParameterValue("{" + value.getExpression().toString() + "}");
					visualParameter.setTemplateParameterType(RuleOptionType.EXPRESSION);
					if (namespacedProperty.getNamespaces().size() > 0) {
						namespacesExist = true;
					}
				}
			} else {
				// parameter does not exist in the config.
			}
			executeAddValueCommand(operationModel.getConnectorParameters(), visualParameter);

		}
		
		/*Map<String, Value> parameters = operation.getpName2ExpressionMap();
		boolean namespacesExist=false;
		for(Map.Entry<String, Value> entry : parameters.entrySet()){
			CallTemplateParameter parameter = EsbFactory.eINSTANCE.createCallTemplateParameter();
			parameter.setParameterName(entry.getKey());
			Value value = entry.getValue();
			
			boolean dynamic = value.hasExprTypeKey();
			
			if(value.getExpression()==null && value.getKeyValue()!=null){
				NamespacedProperty namespacedProperty = createNamespacedProperty(value.getKeyValue(),null);
				namespacedProperty.setDynamic(dynamic);
				namespacedProperty.setSupportsDynamicXPaths(true);
				parameter.setParameterExpression(namespacedProperty);
				parameter.setParameterValue(value.getKeyValue());
				parameter.setTemplateParameterType(RuleOptionType.VALUE);
			}
			
			if(value.getExpression()!=null){
				NamespacedProperty namespacedProperty = createNamespacedProperty(value.getExpression());
				namespacedProperty.setPropertyValue("{"+value.getExpression().toString()+"}");
				namespacedProperty.setDynamic(dynamic);
				namespacedProperty.setSupportsDynamicXPaths(true);
				parameter.setParameterExpression(namespacedProperty);
				parameter.setParameterValue("{"+value.getExpression().toString()+"}");
				parameter.setTemplateParameterType(RuleOptionType.EXPRESSION);
				if(namespacedProperty.getNamespaces().size()>0){
					namespacesExist=true;
				}	
			}
			executeAddValueCommand(operationModel.getConnectorParameters(), parameter);
		}*/
		
		if(namespacesExist){
			executeSetValueCommand(CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE, CloudConnectorOperationParamEditorType.NAMESPACED_PROPERTY_EDITOR);
		}else{
			executeSetValueCommand(CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE, CloudConnectorOperationParamEditorType.INLINE);
		}
		
		return operationModel;
	}
}
