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

import java.util.List;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.details.IDetailsColors;
import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;



public class TrayCategoryEntryFigure extends SelectionBorderFigure {

	public static final int BORDER = 3;
	
	/**
	 * Used to align the text of this entry with the text on the categories.
	 */
	protected class EntryLayout extends AbstractLayout {
		public void layout(IFigure container) {
			List elements = container.getChildren();
			Label text = (Label)elements.get(0);
			Rectangle containerBounds = container.getBounds();
			Rectangle constraint = getCategoryTitleLabelBounds();
			int width = containerBounds.width - constraint.x;
			text.setBounds(new Rectangle(constraint.x, containerBounds.y, width, containerBounds.height));
		}
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
			// use the minimum width and the preferred height plus some spacing
			Dimension result = new Dimension();
			result.width = nameLabel.getMinimumSize(wHint, hHint).width;
			result.height = nameLabel.getPreferredSize(wHint, hHint).height;
			result.height += (BORDER * 2);
			return result;
		}
	}

	protected Label nameLabel;
	protected IFigure labelPositionReference;
	protected TrayCategoryEntryEditPart part;
	
	public TrayCategoryEntryFigure(IFigure labelPositionReference, TrayCategoryEntryEditPart part) {
		super();
		this.labelPositionReference = labelPositionReference;
		this.part = part;
		setLayoutManager(new EntryLayout());
		setBorder(new MarginBorder(BORDER) {
			@Override
			public void paint(IFigure figure, Graphics graphics, Insets in) {
				Rectangle rect = figure.getBounds().getCopy();
				Color color = CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_LIGHT_BACKGROUND);
				graphics.setForegroundColor(color);
				graphics.drawLine(rect.x, rect.y + rect.height - 1, rect.x + rect.width, rect.y + rect.height - 1);
			}
		});
		nameLabel = new Label();
		nameLabel.setLabelAlignment(PositionConstants.LEFT);
		add(nameLabel);
	}

	public void setText(String text) {
		nameLabel.setText(text);
	}
	
	public String getText() {
		return nameLabel.getText();
	}
	
	protected Rectangle getCategoryTitleLabelBounds() {
		return labelPositionReference.getBounds();
	}

	public Label getLabel() {
		return nameLabel;
	}
	
	public TrayCategoryEntryEditPart getEditPart() {
		return part;
	}
}
