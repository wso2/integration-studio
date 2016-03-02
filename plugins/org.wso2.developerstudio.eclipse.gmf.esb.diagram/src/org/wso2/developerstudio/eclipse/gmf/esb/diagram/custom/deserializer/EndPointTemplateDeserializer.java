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
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.endpoints.TemplateEndpointFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * Endpoint template deserializer
 */
public class EndPointTemplateDeserializer extends AbstractEsbNodeDeserializer<org.apache.synapse.endpoints.Template, Template> {

	@SuppressWarnings("unchecked")
	@Override
	public Template createNode(IGraphicalEditPart part, org.apache.synapse.endpoints.Template template) {
		Template templateModel = (Template) DeserializerUtils.createNode(part, EsbElementTypes.Template_3664);
		setElementToEdit(templateModel);
		executeSetValueCommand(TEMPLATE__NAME, template.getName());
		executeSetValueCommand(TEMPLATE__TEMPLATE_TYPE, TemplateType.ENDPOINT);

		for (String parameter : template.getParameters()) {
			if (parameter != null && !(parameter.equals("name") || parameter.equals("uri"))) {
				TemplateParameter templateParameter = EsbFactory.eINSTANCE.createTemplateParameter();
				templateParameter.setName(parameter);
				executeAddValueCommand(templateModel.getParameters(), templateParameter);
			}
		}
		
		refreshEditPartMap();
		IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(templateModel).getChildren().get(0);
		EndpointDiagram endpointDiagram = (EndpointDiagram) DeserializerUtils.createNode(compartment, EsbElementTypes.EndpointDiagram_3666);
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
			
			if(template.getElement()!=null){
				Endpoint endpoint = TemplateEndpointFactory.getEndpointFromElement(template.getElement(), false, new Properties());;
				if(endpoint!=null){
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
		
		return templateModel;
	}

}
