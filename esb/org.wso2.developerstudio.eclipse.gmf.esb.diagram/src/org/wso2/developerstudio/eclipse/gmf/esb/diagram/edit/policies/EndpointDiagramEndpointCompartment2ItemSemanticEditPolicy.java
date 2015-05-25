package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.AddressEndPoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DefaultEndPoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.FailoverEndPoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.HTTPEndpoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.LoadBalanceEndPoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.RecipientListEndPoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.TemplateEndpoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.WSDLEndPoint2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class EndpointDiagramEndpointCompartment2ItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EndpointDiagramEndpointCompartment2ItemSemanticEditPolicy() {
		super(EsbElementTypes.EndpointDiagram_3666);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EsbElementTypes.DefaultEndPoint_3643 == req.getElementType()) {
			return getGEFWrapper(new DefaultEndPoint2CreateCommand(req));
		}
		if (EsbElementTypes.AddressEndPoint_3646 == req.getElementType()) {
			return getGEFWrapper(new AddressEndPoint2CreateCommand(req));
		}
		if (EsbElementTypes.FailoverEndPoint_3649 == req.getElementType()) {
			return getGEFWrapper(new FailoverEndPoint2CreateCommand(req));
		}
		if (EsbElementTypes.RecipientListEndPoint_3696 == req.getElementType()) {
			return getGEFWrapper(new RecipientListEndPoint2CreateCommand(req));
		}
		if (EsbElementTypes.WSDLEndPoint_3653 == req.getElementType()) {
			return getGEFWrapper(new WSDLEndPoint2CreateCommand(req));
		}
		if (EsbElementTypes.LoadBalanceEndPoint_3656 == req.getElementType()) {
			return getGEFWrapper(new LoadBalanceEndPoint2CreateCommand(req));
		}
		if (EsbElementTypes.HTTPEndpoint_3712 == req.getElementType()) {
			return getGEFWrapper(new HTTPEndpoint2CreateCommand(req));
		}
		if (EsbElementTypes.TemplateEndpoint_3725 == req.getElementType()) {
			return getGEFWrapper(new TemplateEndpoint2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
