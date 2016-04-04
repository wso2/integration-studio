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
package org.eclipse.bpel.ui.editparts.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.decorator.DecorationLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;


public abstract class BPELDecorationLayout extends DecorationLayout {
	
	private List listeners = new ArrayList();

	class MouseMotionAdapter implements MouseMotionListener {
		int listenerAnchor;
		public MouseMotionAdapter(int anchor) {
			this.listenerAnchor = anchor;
		}
		public void mouseDragged(MouseEvent me) {
		}
		public void mouseEntered(MouseEvent me) {
			// fire listeners for the anchor point of the given mouse event
			fireMarkerMotionListeners(listenerAnchor);
		}
		public void mouseExited(MouseEvent me) {
		}
		public void mouseHover(MouseEvent me) {
		}
		public void mouseMoved(MouseEvent me) {
		}
	}
	
	public interface AnchorMotionListener {
		public void anchorEntered(int position);
	}
	public void addAnchorMotionListener(AnchorMotionListener listener) {
		listeners.add(listener);
	}
	public void removeAnchorMotionListener(AnchorMotionListener listener) {
		listeners.remove(listener);
	}
	private void fireMarkerMotionListeners(int anchor) {
		Iterator it = listeners.iterator();
		while (it.hasNext()) {
			AnchorMotionListener listener = (AnchorMotionListener)it.next();
			listener.anchorEntered(anchor);
		}
	}
	
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return new Dimension(0, 0);
	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		super.setConstraint(child, constraint);
		child.addMouseMotionListener(new MouseMotionAdapter(((Integer)constraint).intValue()));
	}
}
