package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

public class OperatorRectangle extends RoundedRectangle{
 
	public OperatorRectangle (String title) {
		Color blueColor = new Color(null,  0, 125, 133);
		LineBorder border = new LineBorder(DataMapperColorConstants.borderColor, 1, Graphics.LINE_SOLID);
		border.setColor(blueColor);
		this.setBorder(border);

		CustomTitleBarBorder titleBarBorder = new CustomTitleBarBorder(title);
		titleBarBorder.setBackgroundColor(blueColor);
		titleBarBorder.setTextColor(new Color(null, 0, 0, 0));
		titleBarBorder.setFont(new Font(null, "Arial", 10, SWT.BOLD));
		
		LineBorder lineBorder = new LineBorder(DataMapperColorConstants.borderColor, 1, Graphics.LINE_SOLID);
		CompoundBorder compoundBorder = new CompoundBorder(titleBarBorder, lineBorder);
		CompoundBorder compoundBorderTop = new CompoundBorder(border, compoundBorder);
		this.setBorder(compoundBorderTop);
	}
}

