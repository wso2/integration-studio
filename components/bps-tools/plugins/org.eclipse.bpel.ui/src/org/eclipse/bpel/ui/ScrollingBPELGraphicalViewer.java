/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.IModelVisitor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * We override ScrollingGraphicalViewer so we can install our own root edit part.
 * The root edit part is responsible for creating the layers, and the BPEL
 * editor wants many extra layers.
 * 
 * We extend GraphicalViewerImpl instead of ScrollingGraphicalViewer because this
 * is the only way that we can override and modify the reveal() behaviour.
 */
public class ScrollingBPELGraphicalViewer extends GraphicalViewerImpl {
	private HashMap<Object, Integer> orderMap = null;
	protected List selectionList = null;
	protected int indexVisit = 0;
	protected boolean hasFocus;
	protected boolean notifyingOfSelectionChange;

	@Override
	protected void createDefaultRoot() {
		setRootEditPart(new GraphicalBPELRootEditPart());
	}
	
	public class NumeratorVisitor implements IModelVisitor {
		public boolean visit(Object modelObject) {
			indexVisit++;
			orderMap.put(modelObject, Integer.valueOf( indexVisit ));
			return true;
		}
	}
	
	private class OrderedSelectionComparator implements Comparator<EditPart> {
		public int compare(EditPart ep1, EditPart ep2) {
			int val1 = 0, val2 = 0;
			Object m1 = ep1.getModel();
			Object m2 = ep2.getModel();
			if (orderMap.get(m1) != null)
				val1 = (orderMap.get(m1)).intValue();
			if (orderMap.get(m2) != null)
				val2 = (orderMap.get(m2)).intValue();
			if (val1 < val2)
				return -1;
			else
				if (val1 > val2)
					return 1; 
			return 0;
		}
	}
	
	/**
	 * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#appendSelection(org.eclipse.gef.EditPart)
	 */
	@Override
	public void appendSelection(EditPart editpart) {
		super.appendSelection(editpart);
		
		// We want to keep the selection in model order.
		selectionList = primGetSelectedEditParts();
		if (selectionList.size() > 1){
			indexVisit = 0;
			orderMap = new HashMap<Object, Integer>();
			BPELUtil.visitModelDepthFirst(BPELUtils.getProcess(editpart.getModel()), new NumeratorVisitor());
			Comparator cmp = new OrderedSelectionComparator();
			Collections.sort(selectionList, cmp);	
			StructuredSelection newSel = new StructuredSelection(selectionList);
			setSelection(newSel);
		}
		orderMap = null;
		selectionList = null;
	}

	/**
	 * @see org.eclipse.gef.EditPartViewer#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public final Control createControl(Composite parent) {
		final FigureCanvas canvas = new FigureCanvas(parent, getLightweightSystem());
		canvas.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				hasFocus = true;
				canvas.redraw();
			}

			public void focusLost(FocusEvent e) {
				hasFocus = false;
				canvas.redraw();
			}});
		
		super.setControl(canvas);
		installRootFigure();
		return canvas;
	}
	/**
	 * Convenience method which types the control as a <code>FigureCanvas</code>. This method
	 * returns <code>null</code> whenever the control is null.
	 * @return <code>null</code> or the Control as a FigureCanvas
	 */
	protected FigureCanvas getFigureCanvas() {
		return (FigureCanvas)getControl();
	}

	public boolean getFigureCanvasFocus() {
		return hasFocus;
	}

	/**
	 * If the figure is a viewport, set the canvas' viewport, otherwise, set its contents.
	 */
	private void installRootFigure() {
		if (getFigureCanvas() == null)
			return;
		IFigure rootFigure = getRootFigure();
		if (rootFigure instanceof Viewport)
			getFigureCanvas().setViewport((Viewport)rootFigure);
		else
			getFigureCanvas().setContents(rootFigure);
	}

	/**
	 * Extends the superclass implementation to scroll the native Canvas control after the
	 * super's implementation has completed.
	 * @see org.eclipse.gef.EditPartViewer#reveal(org.eclipse.gef.EditPart)
	 */
	@Override
	public void reveal(EditPart part) {
		// New rule: Don't scroll *up* if it would cause any currently visible
		// part of the edit part to disappear off the bottom.
		// Likewise, don't scroll down if it would cause any currently visible
		// part of the edit part to disappear off the top, but this is
		// unlikely to happen anyway.
		super.reveal(part);
		if (part instanceof ProcessEditPart) {
			// We never want to even try to reveal the process edit part.
			return;
		}
		Viewport port = getFigureCanvas().getViewport();
		IFigure target = ((GraphicalEditPart)part).getFigure();
		Rectangle exposeRegion = target.getBounds().getExpanded(5, 5);
		target = target.getParent();
		while (target != null && target != port) {
			target.translateToParent(exposeRegion);
			target = target.getParent();
		}
		Dimension viewportSize = port.getClientArea().getSize();
		Point topLeft = exposeRegion.getTopLeft();
		Point bottomRight = exposeRegion.
		getBottomRight().
		translate(viewportSize.negate());
		Point finalLocation = Point.min(topLeft,
				Point.max(bottomRight, port.getViewLocation()));
		
		Dimension existingSize = port.getSize();
		int oldViewportY = port.getViewLocation().y;
		int newViewportY = finalLocation.y;
		int figureY = exposeRegion.y;
		int figureHeight = exposeRegion.height;
		int bottomVisibleBefore = Math.min(figureY + figureHeight, oldViewportY + existingSize.height);
		int bottomVisibleAfter = Math.min(figureY + figureHeight, newViewportY + existingSize.height);
		if (bottomVisibleAfter < bottomVisibleBefore) {
			// Truncate it so that we don't lose anything off the bottom of the screen.
			finalLocation.y = figureY + figureHeight - existingSize.height;
		}
		int topVisibleBefore = Math.max(figureY, oldViewportY);
		int topVisibleAfter = Math.max(figureY, finalLocation.y);
		if (topVisibleAfter > topVisibleBefore && bottomVisibleAfter < bottomVisibleBefore) {
			// Moving it would change both the top and bottom. Don't do anything.
			finalLocation.y = oldViewportY;
		}
		getFigureCanvas().scrollSmoothTo(finalLocation.x, finalLocation.y);
	}

	/**
	 * @see GraphicalViewerImpl#setRootFigure(IFigure)
	 */
	@Override
	protected void setRootFigure(IFigure figure) {
		// Warning: The super does more work than the old method did.
		super.setRootFigure(figure);
		installRootFigure();
	}
	
	/**
	 * Scroll vertical. If the argument is true, it scrolls up by 100 pixels,
	 * otherwise it scrolls down by 100 pixels.
	 * 
	 * @param up if true scroll up, if false scrolls down.
	 */
	public void scrollVertical(boolean up) {
		Viewport port = getFigureCanvas().getViewport();
		Point finalLocation = port.getViewLocation().getCopy();
		finalLocation.y += up ? -100: 100;
		getFigureCanvas().scrollSmoothTo(finalLocation.x, finalLocation.y);
	}
	
	/**
	 * Scroll horizontal. If left is true scrolls left, if false scrolls right.
	 * 
	 * @param left if true, it will scroll left.
	 */
	
	public void scrollHorizontal (boolean left) {
		Viewport port = getFigureCanvas().getViewport();
		Point finalLocation = port.getViewLocation().getCopy();
		finalLocation.x += left ? -100: 100;
		getFigureCanvas().scrollSmoothTo(finalLocation.x, finalLocation.y);
	}

	/**
	 * See comments in BPELSelectionTool.handleFocusLost().
	 */
	
	@Override
	protected void fireSelectionChanged() {		
		try {
			notifyingOfSelectionChange = true;
			super.fireSelectionChanged();
		} finally {
			notifyingOfSelectionChange = false;
		}
	}
	
	
	/**
	 * Returns true if it is sending an event that updates the
	 * properties view input.
	 * 
	 * See comments in BPELSelectionTool.handleFocusLost().
	 */
//	public boolean isUpdatingPropertiesViewInput() {
//		return updatingPropertiesViewInput;
//	}

	/** (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setSelection( ISelection arg0 ) {
		
		if (notifyingOfSelectionChange) { 
			return ;
		}
		super.setSelection(arg0);
	}

	/**
	 * 
	 */
	
	@Override
	public ISelection getSelection() {
		if (getSelectedEditParts().isEmpty()) {
			return StructuredSelection.EMPTY;
		}
		return new StructuredSelection(getSelectedEditParts());
	}
}
