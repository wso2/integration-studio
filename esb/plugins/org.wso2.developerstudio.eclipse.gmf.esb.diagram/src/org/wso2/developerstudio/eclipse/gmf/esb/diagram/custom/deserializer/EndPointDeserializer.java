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


import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * Endpoint deserializer
 */
public class EndPointDeserializer extends AbstractEsbNodeDeserializer<EndpointWrapper, EndpointDiagram> {

	@SuppressWarnings("unchecked")
	@Override
	public EndpointDiagram createNode(IGraphicalEditPart part, EndpointWrapper endpointWrapper) {
		EndpointDiagram endpointDiagram = (EndpointDiagram) DeserializerUtils.createNode((IGraphicalEditPart)part.getParent(), EsbElementTypes.EndpointDiagram_3642);
		refreshEditPartMap();
		IGraphicalEditPart graphicalNode = (IGraphicalEditPart) getEditpart(endpointDiagram);
		if(graphicalNode!=null){
			Rectangle rect = new Rectangle(new Point(), graphicalNode.getFigure().getPreferredSize()).getCopy();
			rect.x = 0;
			rect.y = 0;
			SetBoundsCommand sbc = new SetBoundsCommand(graphicalNode.getEditingDomain(),
					"change location", new EObjectAdapter((View) graphicalNode.getModel()), rect);
			graphicalNode.getDiagramEditDomain().getDiagramCommandStack()
					.execute(new ICommandProxy(sbc));
			
			if(endpointWrapper!=null){
				Endpoint endpoint = endpointWrapper.getEndpoint();
				if(endpoint!=null){
					setElementToEdit(endpointDiagram);
					executeSetValueCommand(ENDPOINT_DIAGRAM__NAME, endpoint.getName());
					IGraphicalEditPart innerCompartment = (IGraphicalEditPart) graphicalNode.getChildren().get(0);
					@SuppressWarnings("rawtypes")
					IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endpoint);
					EsbNode node = deserializer.createNode(innerCompartment, endpoint);
					
					refreshEditPartMap();
					IGraphicalEditPart nodeEditPart = (IGraphicalEditPart) getEditpart(node);
					if(nodeEditPart!=null){
						rect = new Rectangle(new Point(), nodeEditPart.getFigure().getPreferredSize()).getCopy();
						rect.x = 0;
						rect.y = 0;
						sbc = new SetBoundsCommand(nodeEditPart.getEditingDomain(),
								"change location", new EObjectAdapter((View) nodeEditPart.getModel()), rect);
						nodeEditPart.getDiagramEditDomain().getDiagramCommandStack()
								.execute(new ICommandProxy(sbc));
					}
				}
			}
			
		}
		
		return endpointDiagram;
	}

}
