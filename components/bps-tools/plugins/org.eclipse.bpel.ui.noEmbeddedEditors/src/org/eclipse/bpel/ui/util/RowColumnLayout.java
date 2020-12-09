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
package org.eclipse.bpel.ui.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

/**
 * class that implements a row/column layout used for BPEL Flows
 */
public class RowColumnLayout extends AbstractLayout {

	protected Map<IFigure, Object> constraints = new HashMap<IFigure, Object>();
	private static final int MIN_WIDTH_HEIGHT = 30;
	
	private int totalHeight, totalWidth;
	private Rectangle region;
	private int[] rowHeights;
	private int[] colWidths;
	boolean spanned = false;
	private int gridWidth, gridHeight;
	private int[] widthOffsets;
	private int[] heightOffsets;
	private int rows = 0, cols = 0;
	private boolean debugThis = false;
	
	public int getNumberOfColumns() {
		return cols;
	}

	public int getNumberOfRows() {
		return rows;
	}

	public boolean isSpanned() {
		return spanned;
	}

	public void setSpanned(boolean spanned) {
		//TODO:  setSpanned(true) not supported yet
		this.spanned = spanned;
	}

	private Rectangle getChildRegion(IFigure f, int availableX, int availableY) {
		if (spanned) {
			Dimension sz = f.getPreferredSize();
			int w = (int) Math.round((float) (sz.width) / this.gridWidth + 0.5);
			int h = (int) Math.round((float) (sz.height) / this.gridHeight + 0.5);
			return new Rectangle(availableX, availableY, w, h);
		}
		return new Rectangle(availableX, availableY, 1, 1);
	}

	public void characterizeGrid(IFigure f) {
		initVars();
		region = new Rectangle(0, 0, -1, -1);
		int unresolved = 0;
		ListIterator<IFigure> children = f.getChildren().listIterator();
		while (children.hasNext()) {
			IFigure child = children.next();
			Rectangle r = (Rectangle) constraints.get(child);
			if (r == null || r.width < 0 || r.height < 0) {
				unresolved++;
				if (debugThis) {
					if (r != null) System.out.println("unresolved figure " + r + " " + child); //$NON-NLS-1$ //$NON-NLS-2$
					else System.out.println("unresolved figure " + child); //$NON-NLS-1$
				}
				continue;
			}

			if (debugThis) System.out.println("resolved figure " + r + " " + child); //$NON-NLS-1$ //$NON-NLS-2$

			if (region.height < 0)
				region.setBounds(r);
			else
				region.union(r);
		}
		
		if (region.height >= 0) {
			rows = region.getBottomRight().y;
			cols = region.getBottomRight().x;
		}

		// we have to resolve the unresolved items by calculating a new row-column for it
		if (unresolved > 0) {
			children = f.getChildren().listIterator();
			while (children.hasNext()) {
				IFigure child = children.next();
				Rectangle r = (Rectangle) constraints.get(child);
				if (r == null || r.width < 0 || r.height < 0) {
					if (debugThis) System.out.println("trying to resolve figure at " + child); //$NON-NLS-1$
					r = getChildRegion(child, cols, 0);
					constraints.put(child, r);
					if (debugThis) System.out.println("new rect " + r); //$NON-NLS-1$
					if (region.height < 0)
						region.setBounds(r);
					else
						region.union(r);
					cols = region.getBottomRight().x;
				}
			}
		}

		// update again
		if (region.x >= 0) {
			rows = region.getBottomRight().y;
			cols = region.getBottomRight().x;
		}
		else {
			return;
		}
				
		if (rows < 0)
			return;

		if (debugThis)	{
			System.out.println("bounds  " + region);	 //$NON-NLS-1$
			System.out.println("rows " + rows); //$NON-NLS-1$
			System.out.println("cols " + cols); //$NON-NLS-1$
		}
		
		// allocate an array of row, col sizes;
		rowHeights = new int[rows];
		colWidths = new int[cols];

		for (int i = 0; i < cols; i++) {
			colWidths[i] = MIN_WIDTH_HEIGHT;
		}
		for (int i = 0; i < rows; i++) {
			rowHeights[i] = MIN_WIDTH_HEIGHT;
		}

		if (!isSpanned()) {
			children = f.getChildren().listIterator();
			while (children.hasNext()) {
				IFigure child = children.next();
				Rectangle rowcol = (Rectangle) constraints.get(child);
				
				if (debugThis)	{
					System.out.println("child " + child + " " + rowcol);	 //$NON-NLS-1$ //$NON-NLS-2$
				}
				
				Dimension sz = getChildSize(child, -1, -1);
				if (rowcol.x >= cols || rowcol.y >= rows)
					throw new IllegalArgumentException();
				if (rowcol.x < 0 || rowcol.y < 0)
					throw new IllegalArgumentException();
				rowHeights[rowcol.y] = Math.max(rowHeights[rowcol.y], sz.height+10);
				colWidths[rowcol.x] = Math.max(colWidths[rowcol.x], sz.width+10);
			}
		}
		
		for (int i = 0; i < rows; i++) 
			totalHeight += rowHeights[i];
		for (int i = 0; i < cols; i++)
			totalWidth += colWidths[i];
			
		// calculate the offsets of each cell in the coordinate space
		widthOffsets = new int[cols];
		heightOffsets = new int[rows];
		for (int i = 1; i < cols; i++)
			widthOffsets[i] = colWidths[i - 1] + widthOffsets[i - 1];
		for (int i = 1; i < rows; i++)
			heightOffsets[i] = rowHeights[i - 1] + heightOffsets[i - 1];
	}

	/**
	 * Provides the given child's preferred size
	 * @param child	The Figure whose preferred size needs to be calculated
	 * @param wHint	The width hint to be used when calculating the child's preferred size
	 * @param hHint	The height hint to be used when calculating the child's preferred size
	 * @return the child's preferred size
	 */
	protected Dimension getChildSize(IFigure child, int wHint, int hHint) {
		return child.getPreferredSize(wHint, hHint);
	}

	@Override
	public Object getConstraint(IFigure figure) {
		return constraints.get(figure);
	}
	
	public Point getOrigin(IFigure parent) {
		return parent.getClientArea().getLocation();
	}

	private void initVars() {
		totalHeight = 0;
		totalWidth = 0;
		rowHeights = null;
		colWidths = null;
		gridWidth = 40;
		gridHeight = 40;
		widthOffsets = null;
		heightOffsets = null;
		rows = 0;
		cols = 0;
	}

	@Override
	public void remove(IFigure figure) {
		super.remove(figure);
		constraints.remove(figure);
	}

	/**
	 * Sets the given bounds for the child figure input.
	 *
	 * @param parent  Parent Figure which holds the child.
	 * @param child   Child Figure whose bounds are to be set.
	 * @param bounds  The size of the child to be set.
	 * @since 2.0
	 */
	protected void setBoundsOfChild(IFigure parent, IFigure child, Rectangle bounds) {
		parent.getClientArea(Rectangle.SINGLETON);
		bounds.translate(Rectangle.SINGLETON.x, Rectangle.SINGLETON.y);
		child.setBounds(bounds);
	}

	/**
	 * Sets the layout constraint of the given figure.
	 *
	 * @param figure  Figure for which the constarint is being set.
	 * @param newConstraint  Constraint for the input figure.
	 * @see  #getConstraint(IFigure)
	 * @since 2.0
	 */
	@Override
	public void setConstraint(IFigure figure, Object newConstraint) {
		super.setConstraint(figure, newConstraint);
		if (newConstraint != null)
			constraints.put(figure, newConstraint);			
		if (debugThis) {
			if (newConstraint != null)
				System.out.println("setConstraint("+ figure + " " + newConstraint + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		// Subtract out the insets from the hints
		characterizeGrid(container);

		Dimension prefSize = new Dimension();
		prefSize.height += totalHeight;
		prefSize.width += totalWidth;
		prefSize.width += container.getInsets().getWidth();
		prefSize.height += container.getInsets().getHeight();
		prefSize.union(getBorderPreferredSize(container));
		return prefSize;
	}

	/**
	 * @see org.eclipse.draw2d.LayoutManager#layout(IFigure)
	 */
	public void layout(IFigure parent) {
		characterizeGrid(parent);
		if (rows == 0 || cols == 0)
			return;
		int row, col;
		Point offset = getOrigin(parent);
		Point centeringOffset = new Point();
		IFigure f;

		Iterator<IFigure> children;
		children = parent.getChildren().iterator();
		while (children.hasNext()) {
			f = children.next();
			Rectangle bounds = (Rectangle) getConstraint(f);
			if (bounds == null)
				continue;
			if (debugThis) System.out.println("bounds " + " " + f + " " + bounds); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
			Rectangle newChildArea = new Rectangle();
			row = bounds.y;
			col = bounds.x;

			newChildArea.x = widthOffsets[col];
			newChildArea.y = heightOffsets[row];
			if (isSpanned()) {
				newChildArea.height = gridHeight * bounds.height;
				newChildArea.width = gridWidth * bounds.width;
			} else {
				newChildArea.height = rowHeights[row];
				newChildArea.width = colWidths[col];
			}
			centeringOffset.x = (newChildArea.width - f.getPreferredSize().width) / 2;
			centeringOffset.y = (newChildArea.height - f.getPreferredSize().height) / 2;
			newChildArea = newChildArea.getTranslated(offset);
			newChildArea = newChildArea.getTranslated(centeringOffset);
			newChildArea.width = f.getPreferredSize().width;
			newChildArea.height = f.getPreferredSize().height;
			f.setBounds(newChildArea);
		}
	}

	/**
	 * @param pt - location to test
	 * @param gridInfo - returns the grid information from that point
	 * @param pixelRegionInfo - returns the pixel region of that grid 
	 * @return true if the point pass the hittest.
	 */
	public boolean getGridInfoFromLocation(Point pt, Rectangle gridInfo, Rectangle pixRegion) {
		Rectangle hitTest = new Rectangle();
		for (int i = 0; i < cols; i++)
			for (int k = 0; k < rows; k++) {
				hitTest.x = widthOffsets[i];
				hitTest.y = heightOffsets[k];
				hitTest.width = colWidths[i];
				hitTest.height = rowHeights[k];
				if (hitTest.contains(pt)) {
					gridInfo.x = i;
					gridInfo.y = k;
					gridInfo.setSize(1, 1);
					pixRegion.setBounds(hitTest);
					return true;
				}
			}				
		return false;
	}
	
	public boolean isDroppableAt(EditPart parentPart, EditPart test, Rectangle gridInfo) {
		IFigure f = ((GraphicalEditPart)parentPart).getContentPane();
		ListIterator<IFigure> children = f.getChildren().listIterator();
		while (children.hasNext()) {
			IFigure child = children.next();
			Rectangle r = (Rectangle) constraints.get(child);
			if (r.getLocation().equals(gridInfo.getLocation())) {
				return false;
			}
		}
		return true;
	}
	
	public Rectangle [] getDividers() {
		if (rows <= 1 && cols <= 1)
			return null;
		Rectangle [] rects = new Rectangle[(rows-1)+(cols-1)];
		int n = 0;
		for (int i = 0; i < (cols-1); i++) {
			rects[n++] = new Rectangle(new Point(widthOffsets[i+1], 0), new Dimension(0, totalHeight));
		}
		for (int i = 0; i < (rows-1); i++) {
			rects[n++] = new Rectangle(new Point(0, heightOffsets[i+1]), new Dimension(totalWidth, 0));
		}
		return rects;
	}
}
