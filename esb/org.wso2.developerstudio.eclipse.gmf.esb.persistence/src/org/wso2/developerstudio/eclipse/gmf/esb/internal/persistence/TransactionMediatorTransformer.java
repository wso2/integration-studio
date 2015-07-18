package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class TransactionMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		information.getParentSequence().addChild(createTransactionMediator(subject));
		/*
		 *  Transform the property mediator output data flow path.
		 */
		doTransform(information,
				((TransactionMediator) subject).getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createTransactionMediator(subject));
		doTransformWithinSequence(information,((TransactionMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}
	
	private org.apache.synapse.mediators.transaction.TransactionMediator createTransactionMediator(EsbNode subject){
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof TransactionMediator, "Invalid subject.");
		TransactionMediator visualTransaction = (TransactionMediator) subject;

		/*
		 *  Configure property mediator.
		 */
		org.apache.synapse.mediators.transaction.TransactionMediator transactionMediator = new org.apache.synapse.mediators.transaction.TransactionMediator();
		setCommonProperties(transactionMediator, visualTransaction);
		{
			String action ="";
			if(visualTransaction.getAction().getValue()==0){
				action ="commit";
			}else if(visualTransaction.getAction().getValue()==1){
				action ="fault-if-no-tx";
			}else if(visualTransaction.getAction().getValue()==2){
				action="new";
			}else if(visualTransaction.getAction().getValue()==3){
				action="resume";
			}else if(visualTransaction.getAction().getValue()==4){
				action="suspend";
			}else if(visualTransaction.getAction().getValue()==5){
				action="rollback";
			}else if(visualTransaction.getAction().getValue()==6){
				action="use-existing-or-new";
			}
			transactionMediator.setAction(action);
		}
		return transactionMediator;
	}

}
