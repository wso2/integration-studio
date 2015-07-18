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

import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.EJBMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.apache.synapse.util.xpath.SynapseXPath;

/**
 * EJBMediatorTransformer responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator} model objects
 * into corresponding synapse artifact(s).
 */
public class EJBMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		try {
			information.getParentSequence().addChild(createEJBMediator(subject));
			// Transform the EJB mediator output data flow path.
			doTransform(information, ((EJBMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// nothing do to

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild(createEJBMediator(subject));
			// Transform the EJB mediator output data flow path.
			doTransformWithinSequence(information, ((EJBMediator) subject).getOutputConnector()
					.getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private Mediator createEJBMediator(EsbNode subject) throws JaxenException{
		Assert.isTrue(subject instanceof EJBMediator,
				"Unsupported mediator passed in for serialization");
		EJBMediator mediatorModel = (EJBMediator) subject;

		EJBMediatorExt mediator = new EJBMediatorExt();
		setCommonProperties(mediator, mediatorModel);
		mediator.setBeanstalkName(mediatorModel.getBeanstalk());
		mediator.setClassName(mediatorModel.getClass_());
		mediator.setJndiName(mediatorModel.getJNDIName());
		mediator.setMethodName(mediatorModel.getMethod());
		mediator.setRemove(mediatorModel.isRemove());
		mediator.setTargetValue(mediatorModel.getTarget());
		
		if(mediatorModel.getSessionIdType()==PropertyValueType.EXPRESSION){
			NamespacedProperty sessionExpression = mediatorModel.getSessionIdExpression();
			if (sessionExpression != null
					&& sessionExpression.getPropertyValue() != null) {
					SynapseXPath expression = new SynapseXPath(sessionExpression.getPropertyValue());
					for (Entry<String, String> entry : sessionExpression.getNamespaces().entrySet()) {
						expression.addNamespace(entry.getKey(), entry.getValue());
					}
					Value beanId = new Value(expression);
					mediator.setBeanId(beanId);
			}
		} else{
			if(mediatorModel.getSessionIdLiteral()!=null){
				Value beanId = new Value(mediatorModel.getSessionIdLiteral());
				mediator.setBeanId(beanId);
			}
		}
		
		// Method Arguments
		for (MethodArgument visualMethodArgument : mediatorModel.getMethodArguments()) {
			Value methodArgument = null;

			if (visualMethodArgument.getPropertyValueType().getLiteral().equals("LITERAL")) {
				methodArgument = new Value(visualMethodArgument.getPropertyValue());
			} else {
				NamespacedProperty namespacedExpression = visualMethodArgument
						.getPropertyExpression();
				if (namespacedExpression != null) {
					SynapseXPath argumentExpression = new SynapseXPath(
							namespacedExpression.getPropertyValue());
					for (Entry<String, String> entry : namespacedExpression.getNamespaces()
							.entrySet()) {
						argumentExpression.addNamespace(entry.getKey(), entry.getValue());
					}

					methodArgument = new Value(argumentExpression);
				}
			}

			mediator.addArgument(methodArgument);
		}
		
		return mediator;
	}

}
