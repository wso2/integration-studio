package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.APIResourceCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class SynapseAPIAPICompartmentItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SynapseAPIAPICompartmentItemSemanticEditPolicy() {
		super(EsbElementTypes.SynapseAPI_3668);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EsbElementTypes.APIResource_3669 == req.getElementType()) {
			return getGEFWrapper(new APIResourceCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
