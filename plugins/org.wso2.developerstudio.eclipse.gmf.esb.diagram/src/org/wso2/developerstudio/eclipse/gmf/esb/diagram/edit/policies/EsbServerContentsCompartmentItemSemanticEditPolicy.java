package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ComplexEndpointsCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.InboundEndpointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.LocalEntryCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.MergeNodeCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.MessageProcessorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.MessageStoreCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ProxyServiceCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SequencesCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SynapseAPICreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.TaskCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.TemplateCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class EsbServerContentsCompartmentItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EsbServerContentsCompartmentItemSemanticEditPolicy() {
		super(EsbElementTypes.EsbServer_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EsbElementTypes.ProxyService_3001 == req.getElementType()) {
			return getGEFWrapper(new ProxyServiceCreateCommand(req));
		}
		if (EsbElementTypes.MergeNode_3013 == req.getElementType()) {
			return getGEFWrapper(new MergeNodeCreateCommand(req));
		}
		if (EsbElementTypes.Sequences_3614 == req.getElementType()) {
			return getGEFWrapper(new SequencesCreateCommand(req));
		}
		if (EsbElementTypes.LocalEntry_3663 == req.getElementType()) {
			return getGEFWrapper(new LocalEntryCreateCommand(req));
		}
		if (EsbElementTypes.Template_3664 == req.getElementType()) {
			return getGEFWrapper(new TemplateCreateCommand(req));
		}
		if (EsbElementTypes.Task_3667 == req.getElementType()) {
			return getGEFWrapper(new TaskCreateCommand(req));
		}
		if (EsbElementTypes.SynapseAPI_3668 == req.getElementType()) {
			return getGEFWrapper(new SynapseAPICreateCommand(req));
		}
		if (EsbElementTypes.ComplexEndpoints_3677 == req.getElementType()) {
			return getGEFWrapper(new ComplexEndpointsCreateCommand(req));
		}
		if (EsbElementTypes.MessageStore_3715 == req.getElementType()) {
			return getGEFWrapper(new MessageStoreCreateCommand(req));
		}
		if (EsbElementTypes.MessageProcessor_3701 == req.getElementType()) {
			return getGEFWrapper(new MessageProcessorCreateCommand(req));
		}
		if (EsbElementTypes.InboundEndpoint_3767 == req.getElementType()) {
			return getGEFWrapper(new InboundEndpointCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
