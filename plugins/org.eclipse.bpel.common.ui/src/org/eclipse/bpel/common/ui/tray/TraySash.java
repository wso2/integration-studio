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

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.ICommonUIConstants;
import org.eclipse.bpel.common.ui.details.IDetailsColors;
import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Button;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;



public class TraySash extends Composite {

	protected static final Image ARROW_LEFT = CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_KEY_TRAY_EXPAND_BUTTON);
	protected static final Image ARROW_RIGHT = CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_KEY_TRAY_COLLAPSE_BUTTON);

	protected static final Point TEXTURE_SIZE = new Point(15, 50);
	protected static final int TEXTURE_SPACING = 4;

	protected class TrayTextureCanvas extends Canvas {
		protected final int MAX_ROWS = (TEXTURE_SIZE.y / TEXTURE_SPACING);
		protected final int MAX_COLUMNS = 2;
		public TrayTextureCanvas(Composite parent, int style) {
			super(parent, SWT.NO_REDRAW_RESIZE | style);
			setBackground(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_LIGHT_BACKGROUND));

			addPaintListener(new PaintListener() {
				public void paintControl(PaintEvent e) {
					int y;
					int height = getBounds().height;
					int textureHeight = MAX_ROWS * TEXTURE_SPACING;
					int availableHeight = height - textureHeight;
					int imageHeight = 66;
					if (isTop()) {
						y = Math.min(0, (availableHeight - imageHeight));
					} else {
						y = Math.max(textureHeight, (height - imageHeight));
					}
					// paint texture background
					e.gc.setBackground(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_LIGHT_BACKGROUND));
					if (isTop()) {
						e.gc.fillRectangle(0, (y + imageHeight), getBounds().width, getBounds().height);
					} else {
						e.gc.fillRectangle(0, 0, getBounds().width, y);
					}
					// paint texture
					y = 0;
					if (isTop()) {
						y = getBounds().height;
					}
					for(int i = 0; i < MAX_ROWS; i++) {
						int x = (TEXTURE_SIZE.x - ((TEXTURE_SPACING-1) * MAX_COLUMNS)) / 2;
						for(int j = 0; j < MAX_COLUMNS; j++) {
							e.gc.setForeground(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_DARK_SHADOW));
							e.gc.drawLine(x, y, x, y+1);
							e.gc.setForeground(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_CANVAS));
							e.gc.drawLine(x+1, y, x+1, y+1);
							x += TEXTURE_SPACING;
						}
						if (isTop()) {
							y -= TEXTURE_SPACING;
						} else {
							y += TEXTURE_SPACING;
						}
					}
				}
				protected boolean isTop() {
					return (getStyle() & SWT.TOP) != 0;
				}
			});
		}
		@Override
		public Point computeSize(int wHint, int hHint, boolean changed) {
			return TEXTURE_SIZE;
		}
	}

	protected class TrayButtonCanvas extends Canvas {

		protected class TrayArrowButton extends Button {
			public TrayArrowButton() {
				super(getButtonImage());
				setBorder(null);
				setRolloverEnabled(true);
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						if (trayComposite.isInState(TrayComposite.STATE_COLLAPSED)) {
							trayComposite.setState(TrayComposite.STATE_EXPANDED);
						} else {
							trayComposite.setState(TrayComposite.STATE_COLLAPSED);
						}
					}
				});
				trayComposite.addListener(TrayComposite.EVENT_COLLAPSED_STATE_CHANGED, new Listener() {
					public void handleEvent(Event event) {
						setContents(new ImageFigure(getButtonImage()));
					}
				});
			}
			@Override
			protected void paintBorder(Graphics graphics) {
				if (hasFocus()) {
					graphics.setForegroundColor(ColorConstants.black);
					graphics.setBackgroundColor(ColorConstants.white);

					org.eclipse.draw2d.geometry.Rectangle area = getClientArea();
					graphics.drawFocus(area.x, area.y, area.width - 1, area.height - 1);
				}
			}
		}
		
		protected LightweightSystem lws;
		public TrayButtonCanvas(Composite parent) {
			super(parent, SWT.NO_REDRAW_RESIZE);
			setCursor(Cursors.ARROW);
			lws = new LightweightSystem();
			lws.setControl(this);
			lws.setContents(new TrayArrowButton());
		}
		@Override
		public Point computeSize(int wHint, int hHint, boolean changed) {
			Dimension size = lws.getRootFigure().getPreferredSize(wHint, hHint);
			size.union(new Dimension(wHint, hHint));
			return new Point(size.width, size.height * 2);
		}
		private Image getButtonImage() {
			return trayComposite.isInState(TrayComposite.STATE_COLLAPSED) ?  ARROW_LEFT : ARROW_RIGHT;
		}
	}
	
	protected TrayComposite trayComposite;
	
	public TraySash(TrayComposite composite, Composite parent, int style) {
		super(parent, SWT.NONE);
		this.trayComposite = composite;
		setBackground(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_TRAY_BACKGROUND));
		
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 3;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);

		Control topTexture = new TrayTextureCanvas(this, SWT.TOP);
		Control button = new TrayButtonCanvas(this);
		Control bottomTexture = new TrayTextureCanvas(this, SWT.BOTTOM);

		topTexture.setLayoutData(new GridData(GridData.BEGINNING | GridData.FILL_BOTH));
		button.setLayoutData(new GridData(GridData.CENTER | GridData.FILL_HORIZONTAL));
		bottomTexture.setLayoutData(new GridData(GridData.END | GridData.FILL_BOTH));

		// add listeners
		MouseTrackListener listener = new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				if (TraySash.this.trayComposite.isInState(TrayComposite.STATE_EXPANDED))
					setCursor(Cursors.SIZEWE);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				if (TraySash.this.trayComposite.isInState(TrayComposite.STATE_EXPANDED))
					setCursor(Cursors.ARROW);
			}
		};
		addMouseTrackListener(listener);
		topTexture.addMouseTrackListener(listener);
		bottomTexture.addMouseTrackListener(listener);
		
		TrayComposite.ResizeListener resizeListener = trayComposite.new ResizeListener();
		addMouseListener(resizeListener);
		addMouseMoveListener(resizeListener);
		topTexture.addMouseListener(resizeListener);
		topTexture.addMouseMoveListener(resizeListener);
		bottomTexture.addMouseListener(resizeListener);
		bottomTexture.addMouseMoveListener(resizeListener);
		
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.setForeground(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_DARK_SHADOW));
				e.gc.drawLine(0, 0, 0, getBounds().height);
			}
		});
	}
}