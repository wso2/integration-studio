/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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
import org.apache.synapse.config.xml.SwitchCase;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class SwitchMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
		try {
			info.getParentSequence().addChild(createSwitchMediator(info, subject));
			doTransform(info, ((SwitchMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		try {
			sequence.addChild(createSwitchMediator(information, subject));
			doTransformWithinSequence(information, ((SwitchMediator) subject).getOutputConnector().getOutgoingLink(),
					sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private org.apache.synapse.mediators.filters.SwitchMediator createSwitchMediator(TransformationInfo info,
			EsbNode subject) throws JaxenException, TransformerException {

		Assert.isTrue(subject instanceof SwitchMediator, "Invalid subject.");
		SwitchMediator visualSwitch = (SwitchMediator) subject;

		org.apache.synapse.mediators.filters.SwitchMediator switchMediator = new org.apache.synapse.mediators.filters.SwitchMediator();
		setCommonProperties(switchMediator, visualSwitch);

		if (visualSwitch.getSourceXpath() != null && !visualSwitch.getSourceXpath().getPropertyValue().equals("")) {
			SynapsePath XPath = CustomSynapsePathFactory.getSynapsePath(visualSwitch.getSourceXpath()
					.getPropertyValue());
			if (visualSwitch.getSourceXpath().getNamespaces() != null && !(XPath instanceof SynapseJsonPath)) {
				for (int i = 0; i < visualSwitch.getSourceXpath().getNamespaces().keySet().size(); ++i) {
					String prefix = (String) visualSwitch.getSourceXpath().getNamespaces().keySet().toArray()[i];
					String namespaceUri = visualSwitch.getSourceXpath().getNamespaces().get(prefix);
					XPath.addNamespace(prefix, namespaceUri);
				}
			}

			switchMediator.setSource(XPath);
		} else {
			switchMediator.setSource(new SynapseXPath("Default:"));
		}

		for (SwitchCaseBranchOutputConnector outputConnector : visualSwitch.getCaseBranches()) {
			SwitchCase switchCase = new SwitchCase();
			AnonymousListMediator caseMediator = new AnonymousListMediator();
			switchCase.setRegex(Pattern.compile(outputConnector.getCaseRegex()));
			switchCase.setCaseMediator(caseMediator);
			switchMediator.addCase(switchCase);
			TransformationInfo newInfo = new TransformationInfo();
			newInfo.setCurrentProxy(info.getCurrentProxy());
			newInfo.setTraversalDirection(info.getTraversalDirection());
			newInfo.setSynapseConfiguration(info.getSynapseConfiguration());
			newInfo.setOriginInSequence(info.getOriginInSequence());
			newInfo.setOriginOutSequence(info.getOriginOutSequence());
			newInfo.setParentSequence(caseMediator);
			doTransform(newInfo, outputConnector);
		}

		SwitchCase switchCase = new SwitchCase();
		AnonymousListMediator caseMediator = new AnonymousListMediator();
		switchCase.setCaseMediator(caseMediator);
		switchMediator.setDefaultCase(switchCase);
		TransformationInfo newInfo = new TransformationInfo();
		newInfo.setCurrentProxy(info.getCurrentProxy());
		newInfo.setTraversalDirection(info.getTraversalDirection());
		newInfo.setSynapseConfiguration(info.getSynapseConfiguration());
		newInfo.setOriginInSequence(info.getOriginInSequence());
		newInfo.setOriginOutSequence(info.getOriginOutSequence());
		newInfo.setParentSequence(caseMediator);
		doTransform(newInfo, visualSwitch.getDefaultBranch());

		return switchMediator;
	}
}
