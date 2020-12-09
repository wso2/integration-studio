package org.wso2.integrationstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class CustomTitleBarBorder extends TitleBarBorder {
	public CustomTitleBarBorder(String string) {
		super.setLabel(string);
	}

	/**
	 * @see Border#paint(IFigure, Graphics, Insets)
	 */
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));
		Rectangle rec = tempRect;
		rec.height = Math.min(rec.height, getTextExtents(figure).height
				+ getPadding().getHeight());
		
		graphics.clipRect(rec);
	

		int x = rec.x + getPadding().left;
		int y = rec.y + getPadding().top;

		int textWidth = getTextExtents(figure).width;
		int freeSpace = rec.width - getPadding().getWidth() - textWidth;

		if (getTextAlignment() == PositionConstants.CENTER)
			freeSpace /= 2;
		if (getTextAlignment() != PositionConstants.LEFT)
			x += freeSpace;
		Color bgColor = graphics.getBackgroundColor();
		Color fgColor = graphics.getForegroundColor();
		// Set the graphics color
		graphics.setBackgroundColor(DataMapperColorConstants.titleBarColor);
		graphics.setForegroundColor(DataMapperColorConstants.titleBarColor);
		// Restore the original colors
		graphics.fillGradient(tempRect, true);
		graphics.setBackgroundColor(bgColor);
		graphics.setForegroundColor(fgColor);
		graphics.setFont(getFont(figure));
		graphics.setForegroundColor(getTextColor());
		graphics.drawString(getLabel(), x, y);
		
	
	}
}
