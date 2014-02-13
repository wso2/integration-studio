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

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.eip.Target;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class IterateMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, IterateMediator> {

	@Override
	public IterateMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof org.apache.synapse.mediators.eip.splitter.IterateMediator,
		"Unsupported mediator passed in for deserialization");

		org.apache.synapse.mediators.eip.splitter.IterateMediator mediator = (org.apache.synapse.mediators.eip.splitter.IterateMediator) object;
		IterateMediator mediatorModel = (IterateMediator) DeserializerUtils.createNode(part,
		EsbElementTypes.IterateMediator_3519);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);
		
		executeSetValueCommand(ITERATE_MEDIATOR__ITERATE_EXPRESSION, createNamespacedProperty(mediator.getExpression()));
		executeSetValueCommand(ITERATE_MEDIATOR__ATTACH_PATH, createNamespacedProperty(mediator.getAttachPath()));
		executeSetValueCommand(ITERATE_MEDIATOR__PRESERVE_PAYLOAD, mediator.isPreservePayload());
		executeSetValueCommand(ITERATE_MEDIATOR__CONTINUE_PARENT, mediator.isContinueParent());
		executeSetValueCommand(ITERATE_MEDIATOR__ITERATE_ID, mediator.getId());
		executeSetValueCommand(ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION, !mediator.getTarget().isAsynchronous());
		
		Target target = mediator.getTarget();
		IterateTarget targetModel = mediatorModel.getTarget();
		
		if(!(target.getToAddress()==null || target.getToAddress().trim().isEmpty())){
			executeSetValueCommand(targetModel,ITERATE_TARGET__TO_ADDRESS, target.getToAddress());
		}
		if(!(target.getSoapAction()==null || target.getSoapAction().trim().isEmpty())){
			executeSetValueCommand(targetModel,ITERATE_TARGET__SOAP_ACTION, target.getSoapAction());
		}
		
		if(target.getSequence() != null){
			executeSetValueCommand(ITERATE_MEDIATOR__SEQUENCE_TYPE, SequenceType.ANONYMOUS);
			refreshEditPartMap();
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(mediatorModel.getMediatorFlow()).getChildren().get(0);
			deserializeSequence(compartment, target.getSequence(), mediatorModel.getTargetOutputConnector());
		}else if(target.getSequenceRef() != null && !target.getSequenceRef().equals("")){
			executeSetValueCommand(ITERATE_MEDIATOR__SEQUENCE_TYPE, SequenceType.REGISTRY_REFERENCE);
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(target.getSequenceRef());
			executeSetValueCommand(ITERATE_MEDIATOR__SEQUENCE_KEY, regkey);
		}
		
		if(target.getEndpoint() != null){
			//FIXME : this feature does not support in current implementation 
			executeSetValueCommand(targetModel,ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, TargetEndpointType.ANONYMOUS);
			
		}else if (target.getEndpointRef() != null && target.getEndpointRef().equals("")) {
			//FIXME :this feature does not support in current implementation 
			executeSetValueCommand(targetModel,ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, TargetEndpointType.REGISTRY_REFERENCE);
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(target.getEndpointRef());
			executeSetValueCommand(targetModel,ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, regkey);
		}
		
		
		return mediatorModel;
	}

}
