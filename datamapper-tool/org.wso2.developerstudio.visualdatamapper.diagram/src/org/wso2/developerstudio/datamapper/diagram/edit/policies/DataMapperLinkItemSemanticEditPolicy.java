package org.wso2.developerstudio.datamapper.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes;

/**
 * @generated
 */
public class DataMapperLinkItemSemanticEditPolicy extends DataMapperBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataMapperLinkItemSemanticEditPolicy() {
		super(DataMapperElementTypes.DataMapperLink_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
