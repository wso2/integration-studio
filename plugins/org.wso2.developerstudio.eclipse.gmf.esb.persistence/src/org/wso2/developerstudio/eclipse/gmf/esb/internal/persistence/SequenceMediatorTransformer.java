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

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class SequenceMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof Sequence, "Invalid subject.");
		Sequence visualSequence = (Sequence) subject;
		org.apache.synapse.mediators.base.SequenceMediator sequence = new SequenceMediator();
		org.apache.synapse.mediators.base.SequenceMediator refferingSequence = new SequenceMediator();
		setCommonProperties(refferingSequence, visualSequence);
		sequence.setName(visualSequence.getName());
		try {
			Value value = null;
			if (visualSequence.getReferringSequenceType() == KeyType.DYNAMIC) {
				SynapseXPath synapseXPath = new SynapseXPath(visualSequence.getDynamicReferenceKey().getPropertyValue());
				for (int i = 0; i < visualSequence.getDynamicReferenceKey().getNamespaces().keySet().size(); ++i) {
					String prefix = (String) visualSequence.getDynamicReferenceKey().getNamespaces().keySet().toArray()[i];
					String namespaceUri = visualSequence.getDynamicReferenceKey().getNamespaces().get(prefix);
					synapseXPath.addNamespace(prefix, namespaceUri);
				}
				value = new Value(synapseXPath);
			} else {
				value = new Value(visualSequence.getStaticReferenceKey().getKeyValue());
			}
			refferingSequence.setKey(value);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}

		try {
			if (information.getSynapseConfiguration() != null) {
				if (information.getSynapseConfiguration().getSequence(visualSequence.getName()) == null) {
					information.getSynapseConfiguration().addSequence(visualSequence.getName(), sequence);
				}
			}
		} catch (org.apache.synapse.SynapseException e) {
			e.printStackTrace();
			// Should handle properly
			// Duplicate sequence definition for key
		}
		try {
			if ((information.getPreviouNode() instanceof org.wso2.developerstudio.eclipse.gmf.esb.EndPoint)
					&& ((visualSequence.getOutputConnector().get(0).getOutgoingLink() == null) || (visualSequence
							.getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint))) {
			} else {
				information.getParentSequence().addChild(refferingSequence);
			}
		} catch (ClassCastException e) {
			MessageDialog
					.openError(
							Display.getCurrent().getActiveShell(),
							"Diagram Incomplete ! ",
							"If there are two Sequences connected to an Endpoint's in and out terminals, the Sequence which is connected to the in terminal must have a Send mediator as the last mediator of the Sequence.");
		}
		doTransform(information, ((Sequence) subject).getOutputConnector().get(0));

	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof Sequence, "Invalid subject.");
		Sequence visualSequence = (Sequence) subject;
		org.apache.synapse.mediators.base.SequenceMediator refferingSequence = new SequenceMediator();
		setCommonProperties(refferingSequence, visualSequence);
		try {
			Value value = null;
			if (visualSequence.getReferringSequenceType() == KeyType.DYNAMIC) {
				SynapseXPath synapseXPath = new SynapseXPath(visualSequence.getDynamicReferenceKey().getPropertyValue());
				for (int i = 0; i < visualSequence.getDynamicReferenceKey().getNamespaces().keySet().size(); ++i) {
					String prefix = (String) visualSequence.getDynamicReferenceKey().getNamespaces().keySet().toArray()[i];
					String namespaceUri = visualSequence.getDynamicReferenceKey().getNamespaces().get(prefix);
					synapseXPath.addNamespace(prefix, namespaceUri);
				}
				value = new Value(synapseXPath);
			} else {
				value = new Value(visualSequence.getStaticReferenceKey().getKeyValue());
			}
			refferingSequence.setKey(value);

			sequence.addChild(refferingSequence);
			doTransformWithinSequence(information, visualSequence.getOutputConnector().get(0).getOutgoingLink(),
					sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}
}
