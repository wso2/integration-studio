package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;

public class EsbGroupBox extends RoundedRectangle{

	public EsbGroupBox() {
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 1;
		layoutThis.makeColumnsEqualWidth = true;
		this.setLayoutManager(layoutThis);

		this.setCornerDimensions(new Dimension(1, 1));
		this.setFill(false);
		this.setOutline(false);
		
		//this.setBackgroundColor(get);
		createContents();
	}
	
	
	private void createContents() {

		RoundedRectangle graphicalNodeContainer0 = new RoundedRectangle();
		graphicalNodeContainer0.setCornerDimensions(new Dimension(1, 1));
		graphicalNodeContainer0.setOutline(false);
		graphicalNodeContainer0.setBackgroundColor(this.getBackgroundColor());
		//graphicalNodeContainer0.setPreferredSize(new Dimension(100, 40));
		LineBorder border0 = new LineBorder(this.getBackgroundColor(), 1, SWT.BORDER_SOLID);
		graphicalNodeContainer0.setBorder(border0);

		GridData constraintGraphicalNodeContainer0 = new GridData();
		constraintGraphicalNodeContainer0.verticalAlignment = GridData.CENTER;
		constraintGraphicalNodeContainer0.horizontalAlignment = GridData.CENTER;
		constraintGraphicalNodeContainer0.horizontalIndent = 0;
		constraintGraphicalNodeContainer0.horizontalSpan = 1;
		constraintGraphicalNodeContainer0.verticalSpan = 1;
		constraintGraphicalNodeContainer0.grabExcessHorizontalSpace = true;
		constraintGraphicalNodeContainer0.grabExcessVerticalSpace = true;
		this.add(graphicalNodeContainer0, constraintGraphicalNodeContainer0);

		GridLayout layoutGraphicalNodeContainer0 = new GridLayout();
		layoutGraphicalNodeContainer0.numColumns = 2;
		layoutGraphicalNodeContainer0.makeColumnsEqualWidth = false;
		layoutGraphicalNodeContainer0.horizontalSpacing = 1;
		layoutGraphicalNodeContainer0.verticalSpacing = 0;
		layoutGraphicalNodeContainer0.marginHeight = -1;
		layoutGraphicalNodeContainer0.marginWidth = -1;
		graphicalNodeContainer0.setLayoutManager(layoutGraphicalNodeContainer0);

		ImageDescriptor imgDesc = EsbDiagramEditorPlugin
				.getBundledImageDescriptor(getIconPath());
		ImageFigure img = new ImageFigure(imgDesc.createImage());
		img.setSize(new Dimension(36, 40));

		RectangleFigure imageRectangle1 = new RectangleFigure();
		imageRectangle1.setOutline(false);
		imageRectangle1.setBackgroundColor(new Color(null, 255,255,255));
		imageRectangle1.setPreferredSize(new Dimension(36, 40));
		imageRectangle1.add(img);

		GridData constraintImageRectangle1 = new GridData();
		constraintImageRectangle1.verticalAlignment = GridData.FILL;
		constraintImageRectangle1.horizontalAlignment = GridData.FILL;
		constraintImageRectangle1.horizontalIndent = 0;
		constraintImageRectangle1.horizontalSpan = 1;
		constraintImageRectangle1.verticalSpan = 2;
		constraintImageRectangle1.grabExcessHorizontalSpace = true;
		constraintImageRectangle1.grabExcessVerticalSpace = true;
		graphicalNodeContainer0.add(imageRectangle1, constraintImageRectangle1);

		imageRectangle1.setLayoutManager(new StackLayout());

		// Rectangle to contain the type name label (eg: Log, Drop) on upper right
		//------------------------------------------------------------------------
		RectangleFigure esbNodeTypeNameRectangle1 = new RectangleFigure();
		esbNodeTypeNameRectangle1.setOutline(false);
		esbNodeTypeNameRectangle1
				.setBackgroundColor(new Color(null, 255, 255, 255));
		esbNodeTypeNameRectangle1.setPreferredSize(new Dimension(64, 20));

		GridData constraintEsbNodeTypeNameRectangle1 = new GridData();
		constraintEsbNodeTypeNameRectangle1.verticalAlignment = GridData.CENTER;
		constraintEsbNodeTypeNameRectangle1.horizontalAlignment = GridData.CENTER;
		constraintEsbNodeTypeNameRectangle1.horizontalIndent = 0;
		constraintEsbNodeTypeNameRectangle1.horizontalSpan = 1;
		constraintEsbNodeTypeNameRectangle1.verticalSpan = 1;
		constraintEsbNodeTypeNameRectangle1.grabExcessHorizontalSpace = true;
		constraintEsbNodeTypeNameRectangle1.grabExcessVerticalSpace = true;
		graphicalNodeContainer0.add(esbNodeTypeNameRectangle1,
				constraintEsbNodeTypeNameRectangle1);

		esbNodeTypeNameRectangle1.setLayoutManager(new StackLayout());
		
		//actual label to display which type this is
		WrappingLabel esbNodeTypeNameLabel2 = new WrappingLabel();
		esbNodeTypeNameLabel2.setText(getNodeName());
		esbNodeTypeNameLabel2
				.setForegroundColor(new Color(null, 0, 0, 0));
		esbNodeTypeNameLabel2
				.setFont(new Font(null, "Arial", 10, SWT.BOLD));
		esbNodeTypeNameLabel2.setAlignment(SWT.CENTER);
		esbNodeTypeNameLabel2.setPreferredSize(new Dimension(64, 20));

		esbNodeTypeNameRectangle1.add(esbNodeTypeNameLabel2);
		//------------------------------------------------------------------------

	}
	
	public String getIconPath() {
		return "override this in the child class with actual icon path";
	}

	public String getNodeName() {
		return "<default>";
	}
	
	public Color getLabelBackColor() {
		return this.getBackgroundColor();
	}
}

