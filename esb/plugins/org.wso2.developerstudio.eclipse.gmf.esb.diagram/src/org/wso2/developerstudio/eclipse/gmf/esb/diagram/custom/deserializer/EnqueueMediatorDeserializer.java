/*
 * Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class EnqueueMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, EnqueueMediator> {

	public EnqueueMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.EnqueueMediator,
				"Unsupported mediator passed in for deserialization at " + this.getClass());
		org.apache.synapse.mediators.builtin.EnqueueMediator enqueueMediator 
										= (org.apache.synapse.mediators.builtin.EnqueueMediator) mediator;
		org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator visualEnqueueMediator 
										= (org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator) DeserializerUtils
																.createNode(part, EsbElementTypes.EnqueueMediator_3600);
		setElementToEdit(visualEnqueueMediator);
		setCommonProperties(enqueueMediator, visualEnqueueMediator);
		// Setting executer name
		if (enqueueMediator.getExecutorName() != null && !enqueueMediator.getExecutorName().equals("")) {
			executeSetValueCommand(ENQUEUE_MEDIATOR__EXECUTOR, enqueueMediator.getExecutorName());
		}

		// Setting priority.
		executeSetValueCommand(ENQUEUE_MEDIATOR__PRIORITY, enqueueMediator.getPriority());

		// Setting sequence
		if (!"".equals(enqueueMediator.getSequenceName())) {
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(enqueueMediator.getSequenceName());
			executeSetValueCommand(ENQUEUE_MEDIATOR__SEQUENCE_KEY, regkey);
		}
		return visualEnqueueMediator;
	}
}
