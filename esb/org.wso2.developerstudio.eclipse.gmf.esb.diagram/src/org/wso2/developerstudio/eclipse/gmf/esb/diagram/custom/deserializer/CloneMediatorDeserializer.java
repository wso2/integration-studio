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

import java.util.Collection;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.eip.Target;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CloneMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;


public class CloneMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CloneMediator> {

	public CloneMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.eip.splitter.CloneMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.eip.splitter.CloneMediator cloneMediator = (org.apache.synapse.mediators.eip.splitter.CloneMediator)mediator;
		
		CloneMediator visualClone = (CloneMediator) DeserializerUtils.createNode(part, EsbElementTypes.CloneMediator_3517);
		refreshEditPartMap();
		setElementToEdit(visualClone);
		setCommonProperties(cloneMediator, visualClone);
		
		executeSetValueCommand(CLONE_MEDIATOR__CLONE_ID, cloneMediator.getId());
		executeSetValueCommand(CLONE_MEDIATOR__SEQUENTIAL_MEDIATION, cloneMediator.isSequential());
		executeSetValueCommand(CLONE_MEDIATOR__CONTINUE_PARENT, cloneMediator.isContinueParent());
		
		//Configuring clone targets
		
		int count=0;
		for(Target target :cloneMediator.getTargets() ) {
			CloneTarget visualTarget = null;
			CloneTargetContainer cloneTargetContainer = null;
			CloneMediatorTargetOutputConnector targetOutputConnector = null;
			
			if (count++ == 0 && visualClone.getTargets().size() ==1){
				visualTarget = visualClone.getTargets().get(0);
				cloneTargetContainer = visualClone.getCloneContainer().getCloneTargetContainer().get(0);
				targetOutputConnector = visualClone.getTargetsOutputConnector().get(0);
			} else{
				visualTarget = EsbFactory.eINSTANCE.createCloneTarget();
				Collection<CloneTarget> targets = EcoreUtil.copyAll(visualClone.getTargets());
				targets.add(visualTarget);
				executeSetValueCommand(visualClone,CLONE_MEDIATOR__TARGETS, targets);
				cloneTargetContainer = (CloneTargetContainer) DeserializerUtils.createNode(
						(IGraphicalEditPart) getEditpart(visualClone.getCloneContainer()),
						EsbElementTypes.CloneTargetContainer_3604);
				targetOutputConnector = (CloneMediatorTargetOutputConnector) DeserializerUtils
						.createNode((IGraphicalEditPart) getEditpart(visualClone),
								EsbElementTypes.CloneMediatorTargetOutputConnector_3133);
			}
			
			if(!(target.getToAddress()==null || target.getToAddress().trim().isEmpty())){
				executeSetValueCommand(visualTarget,CLONE_TARGET__TO_ADDRESS, target.getToAddress());
			}
			if(!(target.getSoapAction()==null || target.getSoapAction().trim().isEmpty())){
				executeSetValueCommand(visualTarget,CLONE_TARGET__SOAP_ACTION, target.getSoapAction());
			}
			
			if(target.getSequence() != null){
				executeSetValueCommand(visualTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE, TargetSequenceType.ANONYMOUS);
				refreshEditPartMap();
				IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(cloneTargetContainer.getMediatorFlow()).getChildren().get(0);
				deserializeSequence(compartment, target.getSequence(), targetOutputConnector);
			}else if(target.getSequenceRef() != null && !target.getSequenceRef().equals("")){
				executeSetValueCommand(visualTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE, TargetSequenceType.REGISTRY_REFERENCE);
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regkey.setKeyValue(target.getSequenceRef());
				executeSetValueCommand(visualTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, regkey);
			}
			
			if(target.getEndpoint() != null){
				executeSetValueCommand(visualTarget,ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, TargetEndpointType.ANONYMOUS);
				//TODO how to proceed ?
				
			}else if (target.getEndpointRef() != null && target.getEndpointRef().equals("")) {
				executeSetValueCommand(visualTarget,ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, TargetEndpointType.REGISTRY_REFERENCE);
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regkey.setKeyValue(target.getEndpointRef());
				executeSetValueCommand(visualTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, regkey);
			}
		}
		EditPart editpart = getEditpart(visualClone);
		if (editpart instanceof CloneMediatorEditPart) {
			if (((CloneMediatorEditPart) editpart).reversed) {
				CloneMediatorUtils.reorderWhenRevered(editpart);
			} else {
				CloneMediatorUtils.reorderWhenForward(editpart);
			}
		}
		
		return visualClone;
	}

}