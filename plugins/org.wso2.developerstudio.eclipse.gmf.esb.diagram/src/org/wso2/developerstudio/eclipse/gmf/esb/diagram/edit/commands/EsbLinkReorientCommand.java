package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class EsbLinkReorientCommand extends EditElementCommand {

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
	public EsbLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof EsbLink) {
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
		if (!(oldEnd instanceof OutputConnector && newEnd instanceof OutputConnector)) {
			return false;
		}
		InputConnector target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof OutputConnector)) {
			return false;
		}
		OutputConnector container = (OutputConnector) getLink().eContainer();
		return EsbBaseItemSemanticEditPolicy.getLinkConstraints().canExistEsbLink_4001(container, getLink(),
				getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof InputConnector && newEnd instanceof InputConnector)) {
			return false;
		}
		OutputConnector source = getLink().getSource();
		if (!(getLink().eContainer() instanceof OutputConnector)) {
			return false;
		}
		OutputConnector container = (OutputConnector) getLink().eContainer();
		return EsbBaseItemSemanticEditPolicy.getLinkConstraints().canExistEsbLink_4001(container, getLink(), source,
				getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
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
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected EsbLink getLink() {
		return (EsbLink) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected OutputConnector getOldSource() {
		return (OutputConnector) oldEnd;
	}

	/**
	 * @generated
	 */
	protected OutputConnector getNewSource() {
		return (OutputConnector) newEnd;
	}

	/**
	 * @generated
	 */
	protected InputConnector getOldTarget() {
		return (InputConnector) oldEnd;
	}

	/**
	 * @generated
	 */
	protected InputConnector getNewTarget() {
		return (InputConnector) newEnd;
	}
}
