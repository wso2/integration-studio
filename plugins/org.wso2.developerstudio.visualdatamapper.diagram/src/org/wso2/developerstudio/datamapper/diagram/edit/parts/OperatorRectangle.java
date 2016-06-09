package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

public class OperatorRectangle extends RoundedRectangle{
 
	public OperatorRectangle (String title) {
		changeOperatorHeader(title);
	}
	
	public boolean changeOperatorHeader(String header){
		LineBorder border = new LineBorder(DataMapperColorConstants.connectorColor, 1, Graphics.LINE_SOLID);

		CustomTitleBarBorder titleBarBorder = new CustomTitleBarBorder(header);
		titleBarBorder.setTextColor(DataMapperColorConstants.color_black);
		titleBarBorder.setFont(new Font(null, "Arial", 10, SWT.BOLD));
		
		CompoundBorder compoundBorder = new CompoundBorder(titleBarBorder, border);
		CompoundBorder compoundBorderTop = new CompoundBorder(border, compoundBorder);
		this.setBorder(compoundBorderTop);
		return false;
	}
}

