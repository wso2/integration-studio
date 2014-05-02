/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
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

	@Override
	protected IFigure getCHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CompensationHandler getCompensationHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IFigure getEHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EventHandler getEventHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IFigure getFHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected FaultHandler getFaultHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IFigure getTHFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TerminationHandler getTerminationHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isShowCH() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isShowEH() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isShowFH() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isShowTH() {
		// TODO Auto-generated method stub
		return false;
	}

}
