package dataMapper.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class DataMapperLinkItemSemanticEditPolicy extends
		dataMapper.diagram.edit.policies.DataMapperBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataMapperLinkItemSemanticEditPolicy() {
		super(
				dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
