package dataMapper.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class DataMapperLinkReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public DataMapperLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof dataMapper.DataMapperLink) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof dataMapper.OutNode && newEnd instanceof dataMapper.OutNode)) {
			return false;
		}
		dataMapper.InNode target = getLink().getInNode();
		if (!(getLink().eContainer() instanceof dataMapper.OutNode)) {
			return false;
		}
		dataMapper.OutNode container = (dataMapper.OutNode) getLink()
				.eContainer();
		return dataMapper.diagram.edit.policies.DataMapperBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistDataMapperLink_4002(container,
						getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof dataMapper.InNode && newEnd instanceof dataMapper.InNode)) {
			return false;
		}
		dataMapper.OutNode source = getLink().getOutNode();
		if (!(getLink().eContainer() instanceof dataMapper.OutNode)) {
			return false;
		}
		dataMapper.OutNode container = (dataMapper.OutNode) getLink()
				.eContainer();
		return dataMapper.diagram.edit.policies.DataMapperBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistDataMapperLink_4002(container,
						getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setOutNode(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setInNode(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected dataMapper.DataMapperLink getLink() {
		return (dataMapper.DataMapperLink) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected dataMapper.OutNode getOldSource() {
		return (dataMapper.OutNode) oldEnd;
	}

	/**
	 * @generated
	 */
	protected dataMapper.OutNode getNewSource() {
		return (dataMapper.OutNode) newEnd;
	}

	/**
	 * @generated
	 */
	protected dataMapper.InNode getOldTarget() {
		return (dataMapper.InNode) oldEnd;
	}

	/**
	 * @generated
	 */
	protected dataMapper.InNode getNewTarget() {
		return (dataMapper.InNode) newEnd;
	}
}
