/*
 * Copyright 2009-2015 WSO2, Inc. (http://wso2.com)
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

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator} model objects into
 * corresponding synapse artifact(s).
 */
public class LogMediatorTransformer extends AbstractEsbNodeTransformer {
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof LogMediator, "Invalid subject.");
		LogMediator visualLog = (LogMediator) subject;
		
		try {
			info.getParentSequence().addChild(createLogMediator(visualLog));			
			// Transform the log mediator output data flow path.
			doTransform(info, visualLog.getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	/**
	 * @param visualLog
	 * @return org.apache.synapse.mediators.builtin.LogMediator
	 * @throws JaxenException
	 */
	private org.apache.synapse.mediators.builtin.LogMediator createLogMediator(LogMediator visualLog)
			throws JaxenException {
		org.apache.synapse.mediators.builtin.LogMediator logMediator = new org.apache.synapse.mediators.builtin.LogMediator();
		setCommonProperties(logMediator, visualLog);
		{
			// Log category.
			switch (visualLog.getLogCategory()) {
				case DEBUG:
					logMediator.setCategory(org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_DEBUG);
					break;
				case ERROR:
					logMediator.setCategory(org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_ERROR);
					break;
				case FATAL:
					logMediator.setCategory(org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_FATAL);
					break;
				case INFO:
					logMediator.setCategory(org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_INFO);
					break;
				case TRACE:
					logMediator.setCategory(org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_TRACE);
					break;
				case WARN:
					logMediator.setCategory(org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_WARN);
					break;
			}
			
			// Log level.
			switch (visualLog.getLogLevel()) {
				case CUSTOM:
					logMediator.setLogLevel(org.apache.synapse.mediators.builtin.LogMediator.CUSTOM);
					break;
				case FULL:
					logMediator.setLogLevel(org.apache.synapse.mediators.builtin.LogMediator.FULL);
					break;
				case HEADERS:
					logMediator.setLogLevel(org.apache.synapse.mediators.builtin.LogMediator.HEADERS);
					break;
				case SIMPLE:
					logMediator.setLogLevel(org.apache.synapse.mediators.builtin.LogMediator.SIMPLE);
					break;
			}
			
			// Log separator.
			if (!StringUtils.isBlank(visualLog.getLogSeparator())) {
				logMediator.setSeparator(visualLog.getLogSeparator());
			}
			
			// Log properties.
			for (LogProperty visualProperty : visualLog.getProperties()) {
				MediatorProperty mediatorProperty = new MediatorProperty();
				mediatorProperty.setName(visualProperty.getPropertyName());
				
				if(visualProperty.getPropertyValueType().getLiteral().equals("LITERAL")){
					mediatorProperty.setValue(visualProperty.getPropertyValue());
				}
				if (visualProperty.getPropertyValueType().getLiteral().equals("EXPRESSION")) {
					NamespacedProperty namespacedExpression = visualProperty
							.getPropertyExpression();
					if (namespacedExpression != null) {
						SynapsePath propertyExpression = CustomSynapsePathFactory
								.getSynapsePath(namespacedExpression.getPropertyValue());
						if (namespacedExpression.getNamespaces() != null
								&& !(propertyExpression instanceof SynapseJsonPath)) {
							for (Entry<String, String> entry : namespacedExpression.getNamespaces()
									.entrySet()) {
								propertyExpression.addNamespace(entry.getKey(), entry.getValue());
							}
						}

						mediatorProperty.setExpression(propertyExpression);
					}
				}			
				logMediator.addProperty(mediatorProperty);
			}
		}
		return logMediator;
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}
	
	public void transformWithinSequence(TransformationInfo info, EsbNode subject,SequenceMediator sequence) throws TransformerException{
		
		// Check subject.
		Assert.isTrue(subject instanceof LogMediator, "Invalid subject.");
		LogMediator visualLog = (LogMediator) subject;
		
		try {
			sequence.addChild(createLogMediator(visualLog));
			doTransformWithinSequence(info,visualLog.getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
}
