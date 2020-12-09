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

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class TrayComposite extends SashForm {
	
	private static final int DEFAULT_TRAY_WIDTH = 92;

	public static final int EVENT_COLLAPSED_STATE_CHANGED = 9999999;
	public static final int STATE_EXPANDED = 1;
	public static final int STATE_COLLAPSED = 2;
	
	public int marginHeight = 0;
	public int marginWidth = 0;

	protected Composite editorControl;
	protected TraySash sashControl;
	protected Control trayControl;
	protected int trayState;
	protected int trayWidth;
	
	public class ResizeListener extends MouseAdapter implements MouseMoveListener {
		protected boolean dragging = false;
		protected boolean correctState = false;
		protected int origX;
		
		@Override
		public void mouseDown(MouseEvent me) {
			if (me.button != 1)
				return;
			dragging = true;
			correctState = isInState(STATE_EXPANDED);
			origX = me.x;
		}
		public void mouseMove(MouseEvent me) {
			if (dragging && correctState) {
				int shiftAmount = me.x - origX;
				int newWidth = trayWidth - shiftAmount;
				Point minSize = trayControl.computeSize(SWT.DEFAULT, SWT.DEFAULT);
				Point maxSize = TrayComposite.this.getSize();
				if (newWidth >= minSize.x && newWidth <= (maxSize.x / 2)) {
					setTrayWidth(newWidth);
				}
			}
		}
		@Override
		public void mouseUp(MouseEvent me) {
			dragging = false;
			correctState = false;
		}
	}
	
	/**
	 * @param parent
	 * @param style
	 */
	public TrayComposite(Composite parent, int style) {
		super(parent, style | SWT.HORIZONTAL);
		
		editorControl = new Composite(this, SWT.NONE);
		editorControl.setLayout(new FillLayout());

		sashControl = new TraySash(this, this, SWT.VERTICAL);
		
		setState(STATE_COLLAPSED);
		setTrayWidth(DEFAULT_TRAY_WIDTH);
		
		addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				layout();
			}
		});
	}
	
	public Composite getEditorComposite() {
		return editorControl;
	}
	
	/**
	 * set the tray composite
	 * @param trayControl
	 */
	public void setTrayControl(Control trayControl) {
		Assert.isTrue(trayControl.getParent() == this);
		this.trayControl = trayControl;
	}
		
	protected boolean isInState(int state) {
		return (trayState & state) != 0;
	}
	
	/**
	 * Sets the tray state to either STATE_EXPANDED or STATE_COLLAPSED.
	 */
	public void setState(int trayState) {
		if (this.trayState != trayState) {
			this.trayState = trayState;
			
			Event event = new Event();
			event.type = EVENT_COLLAPSED_STATE_CHANGED;
			notifyListeners(EVENT_COLLAPSED_STATE_CHANGED, event);

			layout();
		}
	}
	
	public void setTrayWidth(int width) {
		if (trayWidth != width) {
			trayWidth = width;
			layout();
		}
	}

	@Override
	public void layout(boolean changed) {
		if (editorControl == null || editorControl.isDisposed() || trayControl == null || trayControl.isDisposed())
			return;
	 	
		Rectangle area = getClientArea();
		if (area.width == 0 || area.height == 0)
			return;
		
		setRedraw(false);
		
		if (isInState(STATE_COLLAPSED)) {
			int titleWidth = sashControl.computeSize(-1, -1).x;			
			editorControl.setBounds(area.x, area.y, area.width - titleWidth, area.height);
			sashControl.setBounds(area.x + area.width - titleWidth, area.y, titleWidth, area.height);
			trayControl.setVisible(false);
			
		} else if (isInState(STATE_EXPANDED)) {
			int titleWidth = sashControl.computeSize(-1, -1).x;			
			if (changed) {
				int editorWeight = area.width - titleWidth - trayWidth;
				int sashWeight = titleWidth >= 0 ? titleWidth : 0;
				int trayWeight = trayWidth >= 0 ? trayWidth : 0;
				
				if (editorWeight < 0) {
					editorWeight = 0;
				}
				
				setWeights(new int[] {editorWeight, sashWeight, trayWeight});
			}
			editorControl.setBounds(area.x, area.y, area.width - titleWidth - trayWidth, area.height);
			sashControl.setBounds(area.x + area.width - titleWidth - trayWidth, area.y, titleWidth, area.height);
			trayControl.setBounds(area.x + area.width - trayWidth, area.y, trayWidth, area.height);
			trayControl.setVisible(true);
		}
		
		sashControl.layout(true);
		
		setRedraw(true);
		update();
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.swt.widgets.Scrollable#getClientArea()
     */
    @Override
	public Rectangle getClientArea() {
        Rectangle rect = super.getClientArea();
        rect.x += marginWidth;
        rect.y += marginHeight;
        rect.width -= marginWidth * 2;
        rect.height -= marginHeight * 2;
        return rect;
    }
}
