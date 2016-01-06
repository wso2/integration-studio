package org.wso2.developerstudio.datamapper.diagram.edit.parts.custom;

import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class DataMapperDiagramBox extends RoundedRectangle {
	public DataMapperDiagramBox(){
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 3;
		layoutThis.makeColumnsEqualWidth = false;
		layoutThis.horizontalSpacing = 10;
		this.setLayoutManager(layoutThis);
		this.setCornerDimensions(new Dimension(1, 1));
		this.setFill(false);
		this.setOutline(false);
		this.setBorder(new LineBorder(new Color(null, 224, 224, 224), 2, SWT.BORDER_DASH));
		this.setLineDashOffset(2.0f);
//		layoutThis.marginHeight = 5;
//		layoutThis.marginWidth = 5;
//		layoutThis.horizontalSpacing = 5;
//		createContents();
	}

	private void createContents() {
		
	}
}
