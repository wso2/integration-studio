/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CLASS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__NAME;

import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class InboundEndpointDeserializer extends
		AbstractEsbNodeDeserializer<InboundEndpoint, org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint> {

	@Override
	public org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint createNode(IGraphicalEditPart part,
			InboundEndpoint object) {
		/*
		 * Creating a new graphical InboundEndpoint object. 
		 */
		org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint inboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) DeserializerUtils
				.createNode(part, EsbElementTypes.InboundEndpoint_3767);

		setElementToEdit(inboundEndpoint);
		refreshEditPartMap();

		executeSetValueCommand(INBOUND_ENDPOINT__NAME, object.getName());
		executeSetValueCommand(INBOUND_ENDPOINT__CLASS, object.getClassImpl());

		/*
		 * Creating Sequence mediator graphically 
		 */
		addRootInputConnector(inboundEndpoint.getSequenceInputConnector());
		IGraphicalEditPart sequenceCompartment = (IGraphicalEditPart) getEditpart(
				inboundEndpoint.getContainer().getSequenceContainer().getMediatorFlow()).getChildren().get(0);
		setRootCompartment((GraphicalEditPart) sequenceCompartment);
		SequenceMediator sequenceContainer = new SequenceMediator();
		SequenceMediator sequenceMediator = new SequenceMediator();
		Value sequenceKey = new Value(object.getInjectingSeq());
		sequenceMediator.setKey(sequenceKey);
		sequenceContainer.addChild(sequenceMediator);
		deserializeSequence(sequenceCompartment, sequenceContainer, inboundEndpoint.getSequenceOutputConnector());
		
		/*
		 * Creating OnErrorSequence mediator graphically
		 */
		addRootInputConnector(inboundEndpoint.getOnErrorSequenceInputConnector());
		IGraphicalEditPart onErrorSequenceCompartment = (IGraphicalEditPart) getEditpart(
				inboundEndpoint.getContainer().getOnErrorSequenceContainer().getMediatorFlow()).getChildren().get(0);
		setRootCompartment((GraphicalEditPart) onErrorSequenceCompartment);
		SequenceMediator onErrorSequenceContainer = new SequenceMediator();
		SequenceMediator onErrorSequenceMediator = new SequenceMediator();
		Value onErrorSequenceKey = new Value(object.getOnErrorSeq());
		onErrorSequenceMediator.setKey(onErrorSequenceKey);
		onErrorSequenceContainer.addChild(onErrorSequenceMediator);
		deserializeSequence(onErrorSequenceCompartment, onErrorSequenceContainer,
				inboundEndpoint.getOnErrorSequenceOutputConnector());

		return inboundEndpoint;
	}

}
