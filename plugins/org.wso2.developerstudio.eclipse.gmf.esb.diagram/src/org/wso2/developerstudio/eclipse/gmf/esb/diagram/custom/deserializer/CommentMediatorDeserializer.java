/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
import org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;

public class CommentMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CommentMediator> {

	@Override
	public CommentMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.CommentMediator,
				"Unsupported mediator passed in for deserialization at " + this.getClass());

		org.apache.synapse.mediators.builtin.CommentMediator commentMediator = (org.apache.synapse.mediators.builtin.CommentMediator) mediator;
		CommentMediator visualCommentMediator = EsbFactory.eINSTANCE.createCommentMediator();
		visualCommentMediator.setCommentText(commentMediator.getCommentText());

		return visualCommentMediator;
	}

}
