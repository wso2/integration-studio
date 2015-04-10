package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import org.apache.synapse.inbound.InboundEndpoint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class InboundEndpointDeserializer extends AbstractEsbNodeDeserializer<InboundEndpoint,org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint>{

	@Override
    public org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint createNode(IGraphicalEditPart part, InboundEndpoint object) {
		org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint inboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) DeserializerUtils
				.createNode(part, EsbElementTypes.InboundEndpoint_3767);
		
		setElementToEdit(inboundEndpoint);
		refreshEditPartMap();
		
		executeSetValueCommand(INBOUND_ENDPOINT__NAME,object.getName());
	    return inboundEndpoint;
    }

}
