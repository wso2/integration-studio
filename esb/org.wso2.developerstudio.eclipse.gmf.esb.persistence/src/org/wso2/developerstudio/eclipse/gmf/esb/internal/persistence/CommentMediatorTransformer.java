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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CommentMediatorTransformer {

	public void transform(TransformationInfo information, EsbNode subject){
		information.getParentSequence().addChild(createCommentMediator(information, subject));
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
			throws Exception {

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		sequence.addChild(createCommentMediator(information, subject));

	}

	private org.apache.synapse.mediators.builtin.CommentMediator createCommentMediator(TransformationInfo information,
			EsbNode subject) {
		Assert.isTrue(subject instanceof CommentMediator, "Unsupported mediator passed in for serialization.");
		CommentMediator visualComment = (CommentMediator) subject;
		org.apache.synapse.mediators.builtin.CommentMediator commentMediator = new org.apache.synapse.mediators.builtin.CommentMediator();
		commentMediator.setCommentText(visualComment.getCommentText());
		return commentMediator;
	}

}
