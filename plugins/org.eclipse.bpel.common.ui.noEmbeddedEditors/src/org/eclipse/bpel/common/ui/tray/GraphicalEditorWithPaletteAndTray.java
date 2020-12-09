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

import org.eclipse.bpel.common.ui.palette.GraphicalEditorWithPalette;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.ViewportLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * @author IBM Initial contribution
 * @date January, 2006
 *
 */

public abstract class GraphicalEditorWithPaletteAndTray extends GraphicalEditorWithPalette {

	protected TrayComposite trayComposite;
	protected GraphicalViewer trayViewer;

	/**
	 * @see org.eclipse.bpel.common.ui.palette.GraphicalEditorWithPalette#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		trayViewer = null;
	}

	/**
	 * Return the tray composite.
	 * @return the tray composite.
	 */
	public TrayComposite getTrayComposite() {
		return trayComposite;
	}

	/**
	 * Return the tray viewer.
	 * 
	 * @return the tray viewer
	 */
	
	public GraphicalViewer getTrayViewer() {
		return trayViewer;
	}
	
	/**
	 * Creates the palette and graphical viewers.
	 */
	@Override
	public void createPartControl(Composite parent) {
		trayComposite = new TrayComposite(parent, SWT.NONE);
		
		// create editor control
		Composite editorComposite = trayComposite.getEditorComposite();
		super.createPartControl(editorComposite);
		
		// create tray control
		createTrayViewer(trayComposite);
		trayComposite.setTrayControl(trayViewer.getControl());
	}
	
	protected void createTrayViewer(Composite parent) {
		trayViewer = new ScrollingGraphicalViewer();
		trayViewer.createControl(parent);
		final FigureCanvas canvas = (FigureCanvas) trayViewer.getControl();
		canvas.setScrollBarVisibility(FigureCanvas.NEVER);
		
		// We need to modify the viewport layout so that it adjusts the
		// size of the viewport contents according to the viewport size.
		// The contents cannot be bigger than the viewport otherwise it
		// will break the tray scrolling.
		canvas.getViewport().setLayoutManager(new ViewportLayout() {
			
			@Override
			public void layout(IFigure figure) {
				Viewport viewport = (Viewport)figure;
				IFigure contents = viewport.getContents();
				
				if (contents == null) return;
				Point p = viewport.getClientArea().getLocation();

				p.translate(viewport.getViewLocation().getNegated());
				
				Dimension newSize = viewport.getClientArea().getSize();
				
				contents.setBounds(new Rectangle(p, newSize));
			}
		});
		
		trayViewer.setKeyHandler(new TrayKeyHandler(trayViewer));
		initializeTrayViewer();
	}
	
    /**
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#setFocus()
     */
    @Override
	public void setFocus() {
    	getGraphicalViewer().getControl().setFocus();
    }
	
	protected abstract void initializeTrayViewer();
}
