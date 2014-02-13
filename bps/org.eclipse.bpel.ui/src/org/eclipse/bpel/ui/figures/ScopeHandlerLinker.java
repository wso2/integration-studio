package org.eclipse.bpel.ui.figures;

import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.editparts.borders.ScopeBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Ray;

public class ScopeHandlerLinker extends HandlerLinkerAdapter {

	private ScopeEditPart scope;

	public ScopeHandlerLinker(ScopeEditPart scopeEditPart) {
		super(scopeEditPart);
		this.scope = scopeEditPart;
	}

	
	protected CompensationHandler getCompensationHandler() {
		return scope.getCompensationHandler();
	}

	
	protected EventHandler getEventHandler() {
		return scope.getEventHandler();
	}

	
	protected FaultHandler getFaultHandler() {
		return scope.getFaultHandler();
	}

	/**
	 * Overridden to provide different connectionAnchors for an eventHandler
	 */
	
	protected int getEHTargetAnchorLoc() {
		if(!isHorizontalLayout()){
			if (getFaultHandler() != null && getCompensationHandler() != null
					&& getTerminationHandler() != null)
				return CenteredConnectionAnchor.LEFT;
			else
				return CenteredConnectionAnchor.TOP;
		}else
			return super.getEHTargetAnchorLoc();
	}

	
	protected boolean isShowCH() {
		return scope.getShowCompensationHandler();
	}

	
	protected boolean isShowEH() {
		return scope.getShowEventHandler();
	}

	
	protected boolean isShowFH() {
		return scope.getShowFaultHandler();
	}

	
	protected int getTHTargetAnchorLoc() {
		return isHorizontalLayout() ? CenteredConnectionAnchor.LEFT
				: CenteredConnectionAnchor.TOP;
	}

	
	protected TerminationHandler getTerminationHandler() {
		return scope.getTerminationHandler();
	}

	
	protected boolean isShowTH() {
		return scope.getShowTerminationHandler();
	}

	
	protected Ray getTHRoutingEndConstraint() {
		return isHorizontalLayout() ? ManhattanConnectionRouterEx.LEFT
				: ManhattanConnectionRouterEx.UP;
	}

	
	protected IFigure getCHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getCompensationImageFigure();
	}

	
	protected IFigure getEHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getEventImageFigure();
	}

	
	protected IFigure getFHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getFaultImageFigure();
	}

	
	protected IFigure getTHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getTerminationImageFigure();
	}
	
}
