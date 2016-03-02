package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class StoreMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, StoreMediator>{
	
	public StoreMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.store.MessageStoreMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.store.MessageStoreMediator storeMediator = (org.apache.synapse.mediators.store.MessageStoreMediator)mediator;
		
		StoreMediator visualStoreMediator = (StoreMediator) DeserializerUtils.createNode(part, EsbElementTypes.StoreMediator_3588);
		setElementToEdit(visualStoreMediator);
		setCommonProperties(storeMediator, visualStoreMediator);
		
		executeSetValueCommand(STORE_MEDIATOR__MESSAGE_STORE,storeMediator.getMessageStoreName());
		if((storeMediator.getOnStoreSequence()!=null)&&!("".equals(storeMediator.getOnStoreSequence()))){
			executeSetValueCommand(visualStoreMediator.getOnStoreSequence(),REGISTRY_KEY_PROPERTY__KEY_VALUE, storeMediator.getOnStoreSequence());
		}
		
		return visualStoreMediator;
	}

}
