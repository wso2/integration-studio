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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class DropMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, DropMediator>{


	public DropMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.DropMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.wso2.developerstudio.eclipse.gmf.esb.DropMediator visualDropMediator = (org.wso2.developerstudio.eclipse.gmf.esb.DropMediator) DeserializerUtils.createNode(part, EsbElementTypes.DropMediator_3491); 
		setElementToEdit(visualDropMediator);
		setCommonProperties(mediator, visualDropMediator);
		//DropMediator vishualDrop = EsbFactory.eINSTANCE.createDropMediator();
		
		return visualDropMediator;
	}

}
