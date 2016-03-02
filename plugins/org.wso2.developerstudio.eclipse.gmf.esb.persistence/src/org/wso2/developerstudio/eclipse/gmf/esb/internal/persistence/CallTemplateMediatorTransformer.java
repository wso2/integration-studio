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

import java.util.List;
import java.util.Map.Entry;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CallTemplateMediatorTransformer extends AbstractEsbNodeTransformer{
	
	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		Assert.isTrue(subject instanceof CallTemplateMediator, "Invalid subject.");
		CallTemplateMediator visuaCallTemplate = (CallTemplateMediator) subject;
		try {
			information.getParentSequence().addChild(
					createInvokeMediator(information, visuaCallTemplate));
			// Transform the callTemplate mediator output data flow path.
			doTransform(information, visuaCallTemplate.getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		Assert.isTrue(subject instanceof CallTemplateMediator, "Invalid subject.");
		CallTemplateMediator visuaCallTemplate = (CallTemplateMediator) subject;
		try {
			sequence.addChild(createInvokeMediator(information, visuaCallTemplate));
			doTransformWithinSequence(information, visuaCallTemplate.getOutputConnector()
					.getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}
	
	private InvokeMediator createInvokeMediator(TransformationInfo information,
			CallTemplateMediator obj) throws JaxenException {
		
		InvokeMediator invokeMediator = new InvokeMediator();
		setCommonProperties(invokeMediator, obj);
		invokeMediator.setTargetTemplate(obj.getTargetTemplate());
		
		for (CallTemplateParameter param : obj.getTemplateParameters()) {
			if (param.getParameterName() != null && !param.getParameterName().isEmpty()) {
				if (param.getTemplateParameterType().equals(RuleOptionType.EXPRESSION)) {
					
					NamespacedProperty namespacedExpression = param.getParameterExpression();
					String xpathValue = namespacedExpression.getPropertyValue();
					Boolean dynamic = namespacedExpression.isDynamic();
					
					if (dynamic){
						
						xpathValue = "{" + xpathValue + "}";
						Value value = new Value(xpathValue);
						
						if (namespacedExpression.getNamespaces().size() > 0)
						{
							OMFactory factory = OMAbstractFactory.getOMFactory();
							OMElement root = null;
							int i = 0;
							for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {
								if (i == 0) {
									OMNamespace firstNameSpace = factory.createOMNamespace(entry.getValue(), entry.getKey());
									root = factory.createOMElement("root",firstNameSpace);
								}
								else {
									root.declareNamespace(entry.getValue(), entry.getKey());
								}
								i++;
							}
							value.setNamespaces(root);
						}
						invokeMediator.getpName2ExpressionMap().put(param.getParameterName(), value);
					} else {
						SynapseXPath paramExpression = new SynapseXPath(xpathValue);
						for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {;
							paramExpression.addNamespace(entry.getKey(), entry.getValue());
						}
						invokeMediator.getpName2ExpressionMap().put(param.getParameterName(), new Value(paramExpression));
					}
				} else {
					invokeMediator.getpName2ExpressionMap().put(param.getParameterName(), new Value(param.getParameterValue()));
				}
			}
		}
		return invokeMediator;
	}

}
