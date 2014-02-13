package org.eclipse.bpel.ui.figures;

import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.draw2d.IFigure;

/**
 * Convenience implementation of an handlerLinker. This is only an adapter
 * and should be used directly because it actually does nothing.
 * @author ascharf
 *
 */
public class HandlerLinkerAdapter extends AbstractHandlerLinker {
	
	public HandlerLinkerAdapter(BPELEditPart editPart){
		super(editPart);
	}

	
	protected IFigure getCHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected CompensationHandler getCompensationHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected IFigure getEHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected EventHandler getEventHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected IFigure getFHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected FaultHandler getFaultHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected IFigure getTHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected TerminationHandler getTerminationHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected boolean isShowCH() {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected boolean isShowEH() {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected boolean isShowFH() {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected boolean isShowTH() {
		// TODO Auto-generated method stub
		return false;
	}

}
