/*package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.AddressEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DefaultEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.FailoverEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.LoadBalanceEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.WSDLEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

*//**
 * @generated
 *//*
public class EndpointFlowEndpointCompartment2ItemSemanticEditPolicy extends
		EsbBaseItemSemanticEditPolicy {

	*//**
	 * @generated
	 *//*
	public EndpointFlowEndpointCompartment2ItemSemanticEditPolicy() {
		super(EsbElementTypes.EndpointFlow_3580);
	}

	*//**
	 * @generated
	 *//*
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EsbElementTypes.DefaultEndPoint_3563 == req.getElementType()) {
			return getGEFWrapper(new DefaultEndPointCreateCommand(req));
		}
		if (EsbElementTypes.AddressEndPoint_3564 == req.getElementType()) {
			return getGEFWrapper(new AddressEndPointCreateCommand(req));
		}
		if (EsbElementTypes.FailoverEndPoint_3565 == req.getElementType()) {
			return getGEFWrapper(new FailoverEndPointCreateCommand(req));
		}
		if (EsbElementTypes.WSDLEndPoint_3566 == req.getElementType()) {
			return getGEFWrapper(new WSDLEndPointCreateCommand(req));
		}
		if (EsbElementTypes.LoadBalanceEndPoint_3567 == req.getElementType()) {
			return getGEFWrapper(new LoadBalanceEndPointCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
*/