package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.actions.global;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

public class ESBEditorCopyCommand extends org.eclipse.gmf.runtime.common.core.command.AbstractCommand{


	public static List<EObject> toCopyElements ;
	public static List<IGraphicalEditPart> toCopyEditParts ;
	
	public ESBEditorCopyCommand(String label, List<EObject> toCopyElements,List<IGraphicalEditPart> toCopyEditParts) {
		super(label);
		this.toCopyElements = toCopyElements;
		this.toCopyEditParts = toCopyEditParts;		
	}

	@Override
	protected CommandResult doExecuteWithResult(
			IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {			
		ESBClipboard.setToCopyEditParts(toCopyEditParts);
		ESBClipboard.setCut(false);
		return CommandResult.newOKCommandResult();
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor,
			IAdaptable info) throws ExecutionException {
	
		return CommandResult.newOKCommandResult();
	}
	
	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor,
			IAdaptable info) throws ExecutionException {

		return null;
	}
}
