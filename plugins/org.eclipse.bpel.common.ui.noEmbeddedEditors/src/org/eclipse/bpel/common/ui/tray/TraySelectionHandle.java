/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.tray;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.AbstractHandle;

/**
 * This figure does not draw the selection handle. It is only used to
 * control when the selection border should be drawn or not.
 */
public class TraySelectionHandle extends AbstractHandle {

	protected static class TrayHandleLocator implements Locator {
		protected IFigure reference;
		public TrayHandleLocator(IFigure reference) {
			this.reference = reference;
		}
		public void relocate(IFigure target) {
			target.setBounds(reference.getClientArea());
		}
	}
	
	protected SelectionBorderFigure selectionBorderFigure;
	
	public TraySelectionHandle(GraphicalEditPart owner, SelectionBorderFigure figure) {
		super(owner, new TrayHandleLocator(figure));
		this.selectionBorderFigure = figure;
		
		// controls when the border should be painted based on the
		// parenting of this handle figure.
		addAncestorListener(new AncestorListener.Stub() {
			@Override
			public void ancestorAdded(IFigure ancestor) {
				selectionBorderFigure.setPaintSelectionBorder(true);
				selectionBorderFigure.repaint();
			}
			@Override
			public void ancestorRemoved(IFigure ancestor) {
				selectionBorderFigure.setPaintSelectionBorder(false);
				selectionBorderFigure.repaint();
			}
		});
	}

	/**
	 * The painting is done by the SelectionBorderFigure
	 * and not the selection handle.
	 */
	@Override
	public void paint(Graphics g) {
		// the painting is done by the SelectionBorderFigure
	}

	@Override
	protected DragTracker createDragTracker() {
		return null; // not needed
	}

	// make it non-clickable otherwise it will block tooltips and direct edit
	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		IFigure result = super.findFigureAt(x, y, search);
		if (result != this)
			return result;
		return null;
	}
	
	// get the buttons from the figure that the handle encloses, not from the handle itself
	@Override
	public IFigure findMouseEventTargetAt(int x, int y) {
		return selectionBorderFigure.findMouseEventTargetAt(x, y);
	}
	
}
