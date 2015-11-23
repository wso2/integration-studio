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

import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator} model objects into
 * corresponding synapse artifact(s).
 */
public class ClassMediatorTransformer extends AbstractEsbNodeTransformer {
	
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject)
			throws TransformerException {		
		 info.getParentSequence().addChild(createClassMediator(subject));
		
		 // Transform the class mediator output data flow path.
		 doTransform(info, ((ClassMediator)subject).getOutputConnector());
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}


	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		// TODO Auto-generated method stub
		sequence.addChild(createClassMediator(subject));
		doTransformWithinSequence(information,((ClassMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		
		
	}
	
	private ClassMediatorExt createClassMediator(EsbNode subject) throws TransformerException {
		Assert.isTrue(subject instanceof ClassMediator, "Invalid subject.");
		ClassMediator visualClass = (ClassMediator) subject;

		ClassMediatorExt classMediator = new ClassMediatorExt(visualClass.getClassName());
		setCommonProperties(classMediator, visualClass);
		Mediator m = new DummyClassMediator();

		classMediator.setMediator((Mediator) m);

		// Class properties.
		for (ClassProperty visualProperty : visualClass.getProperties()) {
			classMediator.addProperty(visualProperty.getPropertyName(),
					visualProperty.getPropertyValue());
		}
		return classMediator;

	}

}
