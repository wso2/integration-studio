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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.synapse.config.xml.endpoints.EndpointSerializer;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Transformer class to be used for serialize sequence templates and end-point
 * templates
 */
public class TemplateTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
		Assert.isTrue(subject instanceof Template, "Unsupported object passed in for serialization");
		Template template = (Template) subject;

		if (template.getChild() instanceof Sequences) {
			TemplateMediator templateMediator = new TemplateMediator();
			templateMediator.setName(template.getName());
			templateMediator.setParameters(new ArrayList<String>());
			saveParameters(template,templateMediator.getParameters());
			SequenceMediator sequence = new SequenceMediator();
			Sequences visualSequence = (Sequences) template.getChild();
			SequenceTransformer transformer = new SequenceTransformer();
			transformer.transformWithinSequence(info, visualSequence, sequence);
			templateMediator.addAll(sequence.getList());
			info.getSynapseConfiguration()
					.addSequenceTemplate(template.getName(), templateMediator);
		} else if (template.getChild() instanceof EndpointDiagram) {
			org.apache.synapse.endpoints.Template endpointTemplate = new org.apache.synapse.endpoints.Template();
			endpointTemplate.setName(template.getName());
			//endpointTemplate.setParameters(new ArrayList<String>());
			saveParameters(template,endpointTemplate.getParameters());
			org.apache.synapse.endpoints.Endpoint endpoint = null;
			EndpointDiagram endpointDiagram = (EndpointDiagram) template.getChild();
			EndPoint child = endpointDiagram.getChild();

			if (child instanceof WSDLEndPoint) {
				WSDLEndPointTransformer transformer = new WSDLEndPointTransformer();
				endpoint = transformer.create((WSDLEndPoint) child, child.getEndPointName());
			} else if (child instanceof DefaultEndPoint) {
				DefaultEndPointTransformer transformer = new DefaultEndPointTransformer();
				endpoint = transformer.create((DefaultEndPoint) child, child.getEndPointName());
			} else if (child instanceof AddressEndPoint) {
				AddressEndPointTransformer transformer = new AddressEndPointTransformer();
				endpoint = transformer.create((AddressEndPoint) child, child.getEndPointName());
			} else if (child instanceof HTTPEndpoint) {
				HTTPEndPointTransformer transformer = new HTTPEndPointTransformer();
				endpoint = transformer.create((HTTPEndpoint) child, child.getEndPointName());
			}
			endpointTemplate.setElement(EndpointSerializer.getElementFromEndpoint(endpoint));

			info.getSynapseConfiguration()
					.addEndpointTemplate(template.getName(), endpointTemplate);
		}

	}

	private void saveParameters(Template template, Collection<String> parameters) {
		for (TemplateParameter templateParameter :  template.getParameters()) {
			if (templateParameter != null && !(templateParameter.getName().equals("name") || templateParameter.getName().equals("uri"))) {
				parameters.add(templateParameter.getName());
			}
		}
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// nothing to do

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		// nothing to do

	}

}
