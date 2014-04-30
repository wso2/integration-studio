package org.wso2.developerstudio.datamapper.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperBaseItemSemanticEditPolicy;

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
		if (false == getElementToEdit() instanceof DataMapperLink) {
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
		if (!(oldEnd instanceof OutNode && newEnd instanceof OutNode)) {
			return false;
		}
		InNode target = getLink().getInNode();
		if (!(getLink().eContainer() instanceof OutNode)) {
			return false;
		}
		OutNode container = (OutNode) getLink().eContainer();
		return DataMapperBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistDataMapperLink_4001(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof InNode && newEnd instanceof InNode)) {
			return false;
		}
		OutNode source = getLink().getOutNode();
		if (!(getLink().eContainer() instanceof OutNode)) {
			return false;
		}
		OutNode container = (OutNode) getLink().eContainer();
		return DataMapperBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistDataMapperLink_4001(container, getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
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
	protected DataMapperLink getLink() {
		return (DataMapperLink) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected OutNode getOldSource() {
		return (OutNode) oldEnd;
	}

	/**
	 * @generated
	 */
	protected OutNode getNewSource() {
		return (OutNode) newEnd;
	}

	/**
	 * @generated
	 */
	protected InNode getOldTarget() {
		return (InNode) oldEnd;
	}

	/**
	 * @generated
	 */
	protected InNode getNewTarget() {
		return (InNode) newEnd;
	}
}
