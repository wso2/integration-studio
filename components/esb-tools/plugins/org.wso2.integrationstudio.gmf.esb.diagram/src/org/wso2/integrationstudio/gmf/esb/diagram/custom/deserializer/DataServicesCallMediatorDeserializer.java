/*
* Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.wso2.integrationstudio.gmf.esb.DSSSourceType;
import org.wso2.integrationstudio.gmf.esb.DSSTargetType;
import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.gmf.esb.PropertyValueType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation;
import org.wso2.integrationstudio.gmf.esb.DSSMediator;
import org.wso2.integrationstudio.gmf.esb.DSSOperationType;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator.Operation;
import org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator.Operations;
import org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator.Param;
import org.wso2.integrationstudio.gmf.esb.impl.AbstractDSSOperationImpl;

import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals;

import java.util.ArrayList;
import java.util.List;

public class DataServicesCallMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, DSSMediator> {

	@Override
	public DSSMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) throws DeserializerException {
		Assert.isTrue(mediator instanceof org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator,
				"Unsupported mediator passed in for deserialization at " + this.getClass());

		org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator dataServiceCallMediator = (org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator) mediator;
		DSSMediator visualDataServicesCall = (DSSMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.DSSMediator_3794);
		setElementToEdit(visualDataServicesCall);
		setCommonProperties(dataServiceCallMediator, visualDataServicesCall);

		String serviceName = dataServiceCallMediator.getDsName();
		if (serviceName != null) {
			executeSetValueCommand(Literals.DSS_MEDIATOR__SERVICE_NAME, serviceName);
			executeSetValueCommand(Literals.DSS_MEDIATOR__AVAILABLE_DATA_SERVICES, serviceName);

		}

		if (!dataServiceCallMediator.getSourceType().isEmpty()) {
			switch (dataServiceCallMediator.getSourceType()) {

			case "inline":
				executeSetValueCommand(Literals.DSS_MEDIATOR__SOURCE_TYPE, DSSSourceType.INLINE);
				break;

			case "body":
				executeSetValueCommand(Literals.DSS_MEDIATOR__SOURCE_TYPE, DSSSourceType.BODY);
				break;
			}
		}

		if (!dataServiceCallMediator.getTargetType().isEmpty()) {
			switch (dataServiceCallMediator.getTargetType()) {

			case "property":
				executeSetValueCommand(Literals.DSS_MEDIATOR__TARGET_TYPE, DSSTargetType.PROPERTY);
				executeSetValueCommand(Literals.DSS_MEDIATOR__TARGET_PROPERTY,
						dataServiceCallMediator.getTargetPropertyName());
				break;

			case "body":
				executeSetValueCommand(Literals.DSS_MEDIATOR__TARGET_TYPE, DSSTargetType.BODY);
				break;
			}
		}

		if (dataServiceCallMediator.getOperations() != null) {
			Operations synapseOperations = dataServiceCallMediator.getOperations();

			switch (synapseOperations.getType()) {
			case "single":
				executeSetValueCommand(Literals.DSS_MEDIATOR__OPERATION_TYPE, DSSOperationType.SINGLE);
				break;

			case "batch":
				executeSetValueCommand(Literals.DSS_MEDIATOR__OPERATION_TYPE, DSSOperationType.BATCH);
				break;

			case "request-box":
				executeSetValueCommand(Literals.DSS_MEDIATOR__OPERATION_TYPE, DSSOperationType.REQUESTBOX);
				break;
			}

			@SuppressWarnings("unchecked")
			List<Operation> synapseOperationList = synapseOperations.getOperations();

			for (Operation synapseOperation : synapseOperationList) {
				AbstractDSSOperation visualOperation = EsbFactory.eINSTANCE.createAbstractDSSOperation();
				visualOperation.setOperationName(synapseOperation.getOperationName());
				List<DSSoperationProperty> visualParamList = new ArrayList<DSSoperationProperty>();
				List<Param> synapseParams = synapseOperation.getParams();
				for (Param synapseParam : synapseParams) {
					DSSoperationProperty visualProperty = EsbFactory.eINSTANCE.createDSSoperationProperty();
					visualProperty.setPropertyName(synapseParam.getParamName());
					if (synapseParam.getEvaluator() != null) {
					    if (synapseParam.getEvaluator().contains("xml")) {
    						NamespacedProperty xpath1 = EsbFactory.eINSTANCE.createNamespacedProperty();
    						xpath1.setPropertyName(synapseParam.getParamName());
    						xpath1.setPropertyValue(synapseParam.getParamExpression().getExpression());
    						visualProperty.setPropertyExpression(xpath1);
    						visualProperty.setPropertyValueType(PropertyValueType.EXPRESSION);
					    } else if (synapseParam.getEvaluator().contains("json")) {
					        NamespacedProperty xpath1 = EsbFactory.eINSTANCE.createNamespacedProperty();
					        xpath1.setPropertyName(synapseParam.getParamName());
					        xpath1.setPropertyValue(synapseParam.getParamExpression().toString());
					        visualProperty.setPropertyExpression(xpath1);
					        visualProperty.setPropertyValueType(PropertyValueType.EXPRESSION);
					        visualProperty.setEvaluator("json");
					    }
					} else {
						visualProperty.setPropertyValueType(PropertyValueType.LITERAL);
						visualProperty.setPropertyValue(synapseParam.getParamValue());
					}
					visualParamList.add(visualProperty);
				}
				AbstractDSSOperationImpl visualAbstractDSSOperation = (AbstractDSSOperationImpl) visualOperation;
				visualAbstractDSSOperation.eSet(EsbPackage.ABSTRACT_DSS_OPERATION__DSS_PRPERTIES, visualParamList);
				executeSetValueCommand(Literals.DSS_MEDIATOR__OPERATIONS, visualAbstractDSSOperation);
			}

		}
		return visualDataServicesCall;
	}
}