package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class EsbLinkItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EsbLinkItemSemanticEditPolicy() {
		super(EsbElementTypes.EsbLink_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
