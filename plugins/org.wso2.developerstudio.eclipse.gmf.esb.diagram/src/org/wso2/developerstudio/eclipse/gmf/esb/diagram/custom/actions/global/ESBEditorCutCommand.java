package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.actions.global;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

public class ESBEditorCutCommand extends org.eclipse.gmf.runtime.common.core.command.AbstractCommand{

	public static List<EObject> toCutElements ;
	public static List<IGraphicalEditPart> toCutEditParts ;
	
	public ESBEditorCutCommand(String label, List<EObject> toCutElements,List<IGraphicalEditPart> toCutEditParts) {
		super(label);
		this.toCutElements = toCutElements;
		this.toCutEditParts = toCutEditParts;		
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		ESBClipboard.setToCopyEditParts(toCutEditParts);
		ESBClipboard.setCut(true);
		return CommandResult.newOKCommandResult();
	}

	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return null;
	}

	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return null;
	}

}
