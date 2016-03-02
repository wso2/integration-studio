package org.wso2.developerstudio.datamapper.diagram.edit.parts.custom;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;

public class DataMapperDiagramFigure extends DataMapperDiagramBox{
	
	public DataMapperDiagramFigure(){
		ToolbarLayout layoutThis = new ToolbarLayout();
		layoutThis.setStretchMinorAxis(true);
		layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		layoutThis.setSpacing(0);
		layoutThis.setVertical(false);

		this.setLayoutManager(layoutThis);
		this.setPreferredSize(new Dimension(300, 400));
		this.setOutline(false);
		this.setBackgroundColor(new Color(null, 255, 255, 255));
		this.setForegroundColor(new Color(null, 0, 0, 0));
//		createContents();
	}

	private void createContents() {
		RoundedRectangle rr1 = new RoundedRectangle();
		RoundedRectangle rr2 = new RoundedRectangle();
		
		rr1.setLineStyle(Graphics.LINE_SOLID);
		rr2.setLineStyle(Graphics.LINE_DASHDOT);

		GridLayout layoutGraphicalNodeContainer = new GridLayout();
		layoutGraphicalNodeContainer.numColumns = 1;
		layoutGraphicalNodeContainer.horizontalSpacing = 5;
		layoutGraphicalNodeContainer.verticalSpacing = 5;
		layoutGraphicalNodeContainer.marginHeight = 5;
		layoutGraphicalNodeContainer.marginWidth = 5;
		rr1.setLayoutManager(layoutGraphicalNodeContainer);
		
		GridData constraintGraphicalNodeContainer0 = new GridData();
		constraintGraphicalNodeContainer0.verticalAlignment = GridData.CENTER;
		constraintGraphicalNodeContainer0.horizontalAlignment = GridData.CENTER;
		
		this.add(rr1,constraintGraphicalNodeContainer0);
//		this.add(rr2);
		
	}
	
/*	public void add(IFigure figure, Object constraint, int index) {
		if (figure instanceof InputEditPart) {
			GridData layoutData = new GridData();
			layoutData.grabExcessHorizontalSpace = true;
			layoutData.grabExcessVerticalSpace = true;
			layoutData.horizontalAlignment = GridData.FILL;
			layoutData.verticalAlignment = GridData.FILL;
			super.add(figure, layoutData, 1);
		} else if (figure instanceof OutputEditPart) {
			GridData layoutData = new GridData();
			layoutData.grabExcessHorizontalSpace = true;
			layoutData.grabExcessVerticalSpace = true;
			layoutData.horizontalAlignment = GridData.FILL;
			layoutData.verticalAlignment = GridData.FILL;
			super.add(figure, layoutData, 3);
		}

		else {
			super.add(figure, constraint, index);
		}
	}*/
}
