package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class EnqueueMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		information.getParentSequence().addChild(createEnqueueMediator(subject));
		// Transform the property mediator output data flow path.
		doTransform(information,
				((EnqueueMediator) subject).getOutputConnector());		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createEnqueueMediator(subject));
		doTransformWithinSequence(information,((EnqueueMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}

	private org.apache.synapse.mediators.builtin.EnqueueMediator createEnqueueMediator(EsbNode subject){
	
		// Check subject.
		Assert.isTrue(subject instanceof EnqueueMediator, "Invalid subject.");
		EnqueueMediator visualEnqueue = (EnqueueMediator) subject;
		
		org.apache.synapse.mediators.builtin.EnqueueMediator enqueueMediator = new org.apache.synapse.mediators.builtin.EnqueueMediator();
		setCommonProperties(enqueueMediator, visualEnqueue);
		enqueueMediator.setExecutorName(visualEnqueue.getExecutor());
		enqueueMediator.setSequenceName(visualEnqueue.getSequenceKey().getKeyValue());
		enqueueMediator.setPriority(visualEnqueue.getPriority());
		return enqueueMediator;
	}	
	
}
