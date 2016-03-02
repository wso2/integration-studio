package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class DBReportMediatorDeserializer extends AbstractDBMediatorDeserializer{

	public DBReportMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.db.DBReportMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.db.DBReportMediator DBReportMediator = (org.apache.synapse.mediators.db.DBReportMediator)mediator;
		
		DBReportMediator visualDBReportMediator = (DBReportMediator) DeserializerUtils.createNode(part, EsbElementTypes.DBReportMediator_3513);
		setElementToEdit(visualDBReportMediator);
		deserializeDBMediator(DBReportMediator, visualDBReportMediator);
		executeSetValueCommand(DB_REPORT_MEDIATOR__CONNECTION_USE_TRANSACTION, DBReportMediator.isUseTransaction());
		
		return visualDBReportMediator;
	}

}
