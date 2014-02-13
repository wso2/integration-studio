package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionAction;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class TransactionMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, TransactionMediator>{

	public TransactionMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.transaction.TransactionMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.transaction.TransactionMediator transactionMediator = (org.apache.synapse.mediators.transaction.TransactionMediator)mediator;
		
		TransactionMediator visualTransactionMediator = (TransactionMediator) DeserializerUtils.createNode(part, EsbElementTypes.TransactionMediator_3521);
		setElementToEdit(visualTransactionMediator);
		setCommonProperties(transactionMediator, visualTransactionMediator);
		
		if("commit".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.COMMIT);
		}else if("fault-if-no-tx".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.FAULT_IF_NO_TRANSACTION);
		}else if("new".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.INITIATE_NEW);
		}else if("resume".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.RESUME);
		}else if("suspend".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.SUSPEND);
		}else if("rollback".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.ROLLBACK);
		}else if("use-existing-or-new".equals(transactionMediator.getAction())){
			executeSetValueCommand(TRANSACTION_MEDIATOR__ACTION, TransactionAction.USE_EXISTING_OR_NEW);
		}
		
		return visualTransactionMediator;
	}
}
