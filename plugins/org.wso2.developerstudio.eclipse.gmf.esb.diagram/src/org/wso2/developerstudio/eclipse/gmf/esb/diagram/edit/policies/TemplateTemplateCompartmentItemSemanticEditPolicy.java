package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.EndpointDiagram2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.Sequences2CreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class TemplateTemplateCompartmentItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TemplateTemplateCompartmentItemSemanticEditPolicy() {
		super(EsbElementTypes.Template_3664);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EsbElementTypes.Sequences_3665 == req.getElementType()) {
			return getGEFWrapper(new Sequences2CreateCommand(req));
		}
		if (EsbElementTypes.EndpointDiagram_3666 == req.getElementType()) {
			return getGEFWrapper(new EndpointDiagram2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
