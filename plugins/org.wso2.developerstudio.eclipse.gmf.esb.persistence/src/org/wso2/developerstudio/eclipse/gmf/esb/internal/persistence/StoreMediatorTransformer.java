/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class StoreMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		information.getParentSequence().addChild(createStoreMediator(subject));
		// Transform the property mediator output data flow path.
		doTransform(information,
				((StoreMediator) subject).getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createStoreMediator(subject));
		doTransformWithinSequence(information,((StoreMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}
	
	private org.apache.synapse.mediators.store.MessageStoreMediator createStoreMediator(EsbNode subject){
		Assert.isTrue(subject instanceof StoreMediator, "Invalid subject.");
		StoreMediator visualStore = (StoreMediator)subject;
		org.apache.synapse.mediators.store.MessageStoreMediator storeMediator=new org.apache.synapse.mediators.store.MessageStoreMediator();
		setCommonProperties(storeMediator, visualStore);
		storeMediator.setMessageStoreName(visualStore.getMessageStore());
		if (null != visualStore.getOnStoreSequence()
				&& StringUtils.isNotBlank(visualStore.getOnStoreSequence().getKeyValue())) {
			storeMediator.setOnStoreSequence(visualStore.getOnStoreSequence().getKeyValue());
		}
		return storeMediator;
	}

}
