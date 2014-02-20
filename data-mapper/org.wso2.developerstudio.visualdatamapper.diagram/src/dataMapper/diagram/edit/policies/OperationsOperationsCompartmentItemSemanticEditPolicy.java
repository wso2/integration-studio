package dataMapper.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class OperationsOperationsCompartmentItemSemanticEditPolicy
		extends
			dataMapper.diagram.edit.policies.DataMapperBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public OperationsOperationsCompartmentItemSemanticEditPolicy() {
		super(
				dataMapper.diagram.providers.DataMapperElementTypes.Operations_3012);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (dataMapper.diagram.providers.DataMapperElementTypes.Concat_3013 == req
				.getElementType()) {
			return getGEFWrapper(new dataMapper.diagram.edit.commands.ConcatCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
