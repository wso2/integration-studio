package org.eclipse.bpel.ui.figures;

import java.util.List;

import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.bpel.ui.editparts.StartNodeEditPart;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.gef.EditPart;

public class ProcessHandlerLinker extends HandlerLinkerAdapter {
	
	private ProcessEditPart process;
	
	private StartNodeEditPart snep;
	
	public ProcessHandlerLinker(ProcessEditPart processEditPart) {
		super(processEditPart);
		this.process = processEditPart;
	}

	
	protected EventHandler getEventHandler() {
		return process.getEventHandler();
	}

	
	protected FaultHandler getFaultHandler() {
		return process.getFaultHandler();
	}

	
	protected int getEHTargetAnchorLoc() {
		return CenteredConnectionAnchor.LEFT;
	}

	
	protected boolean isShowEH() {
		return process.isShowEH();
	}

	
	protected boolean isShowFH() {
		return process.isShowFH();
	}
	
	private StartNodeEditPart getStartNodeEditPart(){
		if(snep == null){
			// Search for the StartNodeEditPart
			List<EditPart> children = process.getChildren();
			for (EditPart child : children) {
				if (child instanceof StartNodeEditPart) {
					snep = (StartNodeEditPart) child;
				}
			}
		}
		return snep;
	}

	/**
	 * Overridden to always return LEFT direction
	 */
	
	protected Ray getEHRoutingEndConstraint() {
		return ManhattanConnectionRouterEx.LEFT;
	}

	
	protected IFigure getEHFigure() {
		return getStartNodeEditPart().getEventImageFigure();
	}

	
	protected IFigure getFHFigure() {
		return getStartNodeEditPart().getFaultImageFigure();
	}
}
