package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class SpringMediatorTransformer extends AbstractEsbNodeTransformer  {

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {
		// TODO Auto-generated method stub
		information.getParentSequence().addChild(createSpringMediator(subject));
		// Transform the Spring mediator output data flow path.
		doTransform(information,
				((SpringMediator) subject).getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		// TODO Auto-generated method stub
		sequence.addChild(createSpringMediator(subject));
		doTransformWithinSequence(information,((SpringMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
		
	}

	private org.apache.synapse.mediators.spring.SpringMediator createSpringMediator(EsbNode subject) throws Exception{
		// Check subject.
		Assert.isTrue(subject instanceof SpringMediator, "Invalid subject.");
		SpringMediator visualSpring = (SpringMediator) subject;
		
		org.apache.synapse.mediators.spring.SpringMediator springMediator=new org.apache.synapse.mediators.spring.SpringMediator();
		setCommonProperties(springMediator, visualSpring);
		springMediator.setBeanName(visualSpring.getBeanName());
		springMediator.setConfigKey(visualSpring.getConfigurationKey().getKeyValue());
		return springMediator;
	}
}
