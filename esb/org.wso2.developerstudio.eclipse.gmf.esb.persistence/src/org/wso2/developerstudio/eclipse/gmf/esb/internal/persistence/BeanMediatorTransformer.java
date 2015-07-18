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

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.bean.BeanMediator.Action;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BeanMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class BeanMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		try {
			information.getParentSequence().addChild(
					createBeanMediator(subject, information));
			doTransform(information,
					((BeanMediator) subject).getOutputConnector());	
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild(createBeanMediator(subject, information));
			doTransformWithinSequence(information, ((BeanMediator) subject)
					.getOutputConnector().getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}
	
	private BeanMediatorExt createBeanMediator(
			EsbNode subject, TransformationInfo information) throws TransformerException, JaxenException {

		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof BeanMediator, "Invalid subject.");
		BeanMediator visualBeanMediator = (BeanMediator) subject;

		BeanMediatorExt beanMediator = new BeanMediatorExt();
		setCommonProperties(beanMediator, visualBeanMediator);
		
		beanMediator.setVarName(visualBeanMediator.getVar());

		switch (visualBeanMediator.getAction()) {
		case CREATE:
			beanMediator.setAction(Action.CREATE);
			beanMediator.setClassName(visualBeanMediator.getClass_());
			break;
		case GET_PROPERTY:
			beanMediator.setAction(Action.GET_PROPERTY);
			beanMediator.setPropertyName(visualBeanMediator.getProperty());
			if(visualBeanMediator.getTargetType()==PropertyValueType.EXPRESSION){
				NamespacedProperty sessionExpression = visualBeanMediator.getTargetExpression();
				if (sessionExpression != null
						&& sessionExpression.getPropertyValue() != null) {
						SynapseXPath expression = new SynapseXPath(sessionExpression.getPropertyValue());
						for (Entry<String, String> entry : sessionExpression.getNamespaces().entrySet()) {
							expression.addNamespace(entry.getKey(), entry.getValue());
						}
						Value targetValue = new Value(expression);
						beanMediator.setTargetValue(targetValue);
				}
			} else{
				if(visualBeanMediator.getTargetLiteral()!=null){
					Value targetValue = new Value(visualBeanMediator.getTargetLiteral());
					beanMediator.setTargetValue(targetValue);
				}
			}
			break;
		case REMOVE:
			beanMediator.setAction(Action.REMOVE);
			break;
		case SET_PROPERTY:
			beanMediator.setAction(Action.SET_PROPERTY);
			beanMediator.setPropertyName(visualBeanMediator.getProperty());
			
			if(visualBeanMediator.getValueType()==PropertyValueType.EXPRESSION){
				NamespacedProperty sessionExpression = visualBeanMediator.getValueExpression();
				if (sessionExpression != null
						&& sessionExpression.getPropertyValue() != null) {
						SynapseXPath expression = new SynapseXPath(sessionExpression.getPropertyValue());
						for (Entry<String, String> entry : sessionExpression.getNamespaces().entrySet()) {
							expression.addNamespace(entry.getKey(), entry.getValue());
						}
						Value targetValue = new Value(expression);
						beanMediator.setValue(targetValue);
				}
			} else{
				if(visualBeanMediator.getValueLiteral()!=null){
					Value targetValue = new Value(visualBeanMediator.getValueLiteral());
					beanMediator.setValue(targetValue);
				}
			}
			break;
		}
		
		return beanMediator;
	}

}
