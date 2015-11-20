package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class DBLookupMediatorDeserializer extends AbstractDBMediatorDeserializer{
	
	public DBLookupMediator createNode(IGraphicalEditPart part,
			AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.db.DBLookupMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.db.DBLookupMediator DBLookupMediator = (org.apache.synapse.mediators.db.DBLookupMediator)mediator;
		
		DBLookupMediator visualDBLookupMediator = (DBLookupMediator) DeserializerUtils.createNode(part, EsbElementTypes.DBLookupMediator_3512);
		setElementToEdit(visualDBLookupMediator);
		deserializeDBMediator(DBLookupMediator, visualDBLookupMediator);
		
		return visualDBLookupMediator;
	}

}
