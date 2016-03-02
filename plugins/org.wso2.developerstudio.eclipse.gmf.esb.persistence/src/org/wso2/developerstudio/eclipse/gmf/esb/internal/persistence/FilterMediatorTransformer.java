/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
import java.util.regex.Pattern;

import org.apache.synapse.config.xml.AnonymousListMediator;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator} model objects
 * into
 * corresponding synapse artifact(s).
 */
public class FilterMediatorTransformer extends AbstractEsbNodeTransformer {
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof FilterMediator, "Invalid subject.");
		FilterMediator visualFilter = (FilterMediator) subject;

		// Build filter mediator.
		org.apache.synapse.mediators.filters.FilterMediator filterMediator =
		                                                                     new org.apache.synapse.mediators.filters.FilterMediator();
		setCommonProperties(filterMediator, visualFilter);
		try{
		if (visualFilter.getConditionType() == FilterMediatorConditionType.XPATH) {
			// TODO: validate xpaths before adding
			if (visualFilter.getXpath() != null &&
			    visualFilter.getXpath().getPropertyValue() != null &&
			    !visualFilter.getXpath().getPropertyValue().equals("")) {
				SynapsePath xPath;
				xPath = CustomSynapsePathFactory.getSynapsePath(visualFilter.getXpath()
					                                                    .getPropertyValue());
				if (visualFilter.getXpath().getNamespaces() != null &&
				    !(xPath instanceof SynapseJsonPath)) {
					for (int i = 0; i < visualFilter.getXpath().getNamespaces().keySet().size(); ++i) {
						String prefix =
						                (String) visualFilter.getXpath().getNamespaces().keySet()
						                                     .toArray()[i];
						String namespaceUri = visualFilter.getXpath().getNamespaces().get(prefix);
						try {
							xPath.addNamespace(prefix, namespaceUri);
						} catch (JaxenException e) {
							throw new TransformerException(e);
						}
					}
				}
				filterMediator.setXpath(xPath);
			}
		} else {
			if (visualFilter.getSource() != null &&
			    visualFilter.getSource().getPropertyValue() != null &&
			    !visualFilter.getSource().getPropertyValue().equals("")) {

				SynapsePath source;
				source = CustomSynapsePathFactory.getSynapsePath(visualFilter.getSource().getPropertyValue());

				if (visualFilter.getXpath().getNamespaces() != null &&
				    !(source instanceof SynapseJsonPath)) {
					for (int i = 0; i < visualFilter.getSource().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFilter.getSource().getNamespaces().keySet().toArray()[i];
						String namespaceUri = visualFilter.getSource().getNamespaces().get(prefix);
						try {
							source.addNamespace(prefix, namespaceUri);
						} catch (JaxenException e) {
							throw new TransformerException(e);
						}
					}
				}
				filterMediator.setSource(source);
			}

			filterMediator.setRegex(Pattern.compile(visualFilter.getRegex()));
		}
		info.getParentSequence().addChild(filterMediator);

		// Transform pass output data flow path.
		filterMediator.setThenElementPresent(true);
		TransformationInfo newThenInfo = new TransformationInfo();
		newThenInfo.setTraversalDirection(info.getTraversalDirection());
		newThenInfo.setSynapseConfiguration(info.getSynapseConfiguration());
		newThenInfo.setOriginInSequence(info.getOriginInSequence());
		newThenInfo.setOriginOutSequence(info.getOriginOutSequence());
		newThenInfo.setCurrentProxy(info.getCurrentProxy());
		newThenInfo.setParentSequence(filterMediator);
		doTransform(newThenInfo, visualFilter.getPassOutputConnector());

		// Transform fail output data flow path.
		AnonymousListMediator elseMediator = new AnonymousListMediator();
		filterMediator.setElseMediator(elseMediator);
		TransformationInfo newElseInfo = new TransformationInfo();
		newElseInfo.setTraversalDirection(info.getTraversalDirection());
		newElseInfo.setSynapseConfiguration(info.getSynapseConfiguration());
		newElseInfo.setOriginInSequence(info.getOriginInSequence());
		newElseInfo.setOriginOutSequence(info.getOriginOutSequence());
		newElseInfo.setCurrentProxy(info.getCurrentProxy());
		newElseInfo.setParentSequence(elseMediator);
		doTransform(newElseInfo, visualFilter.getFailOutputConnector());

		doTransform(info, ((FilterMediator) subject).getOutputConnector());
		}catch(JaxenException e){
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
	                                List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
	}

	public void transformWithinSequence(TransformationInfo info, EsbNode subject,
	                                    SequenceMediator sequence) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof FilterMediator, "Invalid subject.");
		FilterMediator visualFilter = (FilterMediator) subject;

		// Build filter mediator.
		org.apache.synapse.mediators.filters.FilterMediator filterMediator =
		                                              new org.apache.synapse.mediators.filters.FilterMediator();
		setCommonProperties(filterMediator, visualFilter);
		if (visualFilter.getConditionType() == FilterMediatorConditionType.XPATH) {
			// TODO: validate xpaths before adding
			if (visualFilter.getXpath() != null &&
			    visualFilter.getXpath().getPropertyValue() != null &&
			    !visualFilter.getXpath().getPropertyValue().equals("")) {

				SynapsePath xPath;
				try {
					xPath = CustomSynapsePathFactory.getSynapsePath(visualFilter.getXpath()
					                                                            .getPropertyValue());
				} catch (JaxenException e) {
					throw new TransformerException(e);
				}

				if (visualFilter.getXpath().getNamespaces() != null &&
				    !(xPath instanceof SynapseJsonPath)) {
					for (int i = 0; i < visualFilter.getXpath().getNamespaces().keySet().size(); ++i) {
						String prefix =
						                (String) visualFilter.getXpath().getNamespaces().keySet()
						                                     .toArray()[i];
						String namespaceUri = visualFilter.getXpath().getNamespaces().get(prefix);
						try {
							xPath.addNamespace(prefix, namespaceUri);
						} catch (JaxenException e) {
							throw new TransformerException(e);
						}
					}
				}
				filterMediator.setXpath(xPath);
			}
		} else {
			if (visualFilter.getSource() != null &&
			    visualFilter.getSource().getPropertyValue() != null &&
			    !visualFilter.getSource().getPropertyValue().equals("")) {

				SynapsePath source;
				try {
					source = CustomSynapsePathFactory.getSynapsePath(visualFilter.getSource()
					                                                     .getPropertyValue());
				} catch (JaxenException e) {
					throw new TransformerException(e);
				}

				if (visualFilter.getXpath().getNamespaces() != null &&
				    !(source instanceof SynapseJsonPath)) {
					for (int i = 0; i < visualFilter.getSource().getNamespaces().keySet().size(); ++i) {
						String prefix =
						                (String) visualFilter.getSource().getNamespaces().keySet()
						                                     .toArray()[i];
						String namespaceUri = visualFilter.getSource().getNamespaces().get(prefix);
						try {
							source.addNamespace(prefix, namespaceUri);
						} catch (JaxenException e) {
							throw new TransformerException(e);
						}
					}
				}
				filterMediator.setSource(source);
			}
			filterMediator.setRegex(Pattern.compile(visualFilter.getRegex()));
		}
		sequence.addChild(filterMediator);

		// Transform pass output data flow path.
		filterMediator.setThenElementPresent(true);
		TransformationInfo newThenInfo = new TransformationInfo();
		newThenInfo.setTraversalDirection(info.getTraversalDirection());
		newThenInfo.setSynapseConfiguration(info.getSynapseConfiguration());
		newThenInfo.setOriginInSequence(info.getOriginInSequence());
		newThenInfo.setOriginOutSequence(info.getOriginOutSequence());
		newThenInfo.setParentSequence(filterMediator);
		doTransform(newThenInfo, visualFilter.getPassOutputConnector());

		// Transform fail output data flow path.
		AnonymousListMediator elseMediator = new AnonymousListMediator();
		filterMediator.setElseMediator(elseMediator);
		TransformationInfo newElseInfo = new TransformationInfo();
		newElseInfo.setTraversalDirection(info.getTraversalDirection());
		newElseInfo.setSynapseConfiguration(info.getSynapseConfiguration());
		newElseInfo.setOriginInSequence(info.getOriginInSequence());
		newElseInfo.setOriginOutSequence(info.getOriginOutSequence());
		newElseInfo.setParentSequence(elseMediator);
		doTransform(newElseInfo, visualFilter.getFailOutputConnector());

		doTransformWithinSequence(info, ((FilterMediator) subject).getOutputConnector().getOutgoingLink(), sequence);
	}
}
