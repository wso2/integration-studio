package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.Graphics;
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

public class InboundEndpointGroupBox extends RoundedRectangle {
	private WrappingLabel esbNodeTypeNameLabel2;

	public InboundEndpointGroupBox() {
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 2;
		layoutThis.makeColumnsEqualWidth = true;
		this.setLayoutManager(layoutThis);
		this.setCornerDimensions(new Dimension(1, 1));
		this.setFill(false);
		this.setOutline(false);
		this.setBorder(new LineBorder(new Color(null, 224, 224, 224), 2, SWT.BORDER_DASH));
		this.setLineDashOffset(2.0f);
		createContents();
	}

	private void createContents() {
		RoundedRectangle leftRectangle = new RoundedRectangle();
		leftRectangle.setCornerDimensions(new Dimension(1, 1));
		leftRectangle.setOutline(false);
		this.setFill(false);
		leftRectangle.setLineStyle(Graphics.LINE_SOLID);
		leftRectangle.setPreferredSize(new Dimension(100, 20));
		leftRectangle.setMinimumSize(new Dimension(90, 95));

		GridLayout layoutGraphicalNodeContainer = new GridLayout();
		layoutGraphicalNodeContainer.numColumns = 1;
		layoutGraphicalNodeContainer.horizontalSpacing = 5;
		layoutGraphicalNodeContainer.verticalSpacing = 5;
		layoutGraphicalNodeContainer.marginHeight = 5;
		layoutGraphicalNodeContainer.marginWidth = 5;
		leftRectangle.setLayoutManager(layoutGraphicalNodeContainer);

		GridData constraintGraphicalNodeContainer0 = new GridData();
		constraintGraphicalNodeContainer0.verticalAlignment = GridData.CENTER;
		constraintGraphicalNodeContainer0.horizontalAlignment = GridData.CENTER;

		this.add(leftRectangle, constraintGraphicalNodeContainer0);

		// Create inner rectangle inside the left side rectangle.
		RoundedRectangle container = createInnerRectangle(leftRectangle);

		ImageDescriptor imgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(getIconPath());
		ImageFigure img = new ImageFigure(imgDesc.createImage());
		img.setSize(new Dimension(36, 40));

		RectangleFigure imageRectangle = new RectangleFigure();
		imageRectangle.setOutline(false);
		imageRectangle.setBackgroundColor(new Color(null, 0, 125, 133));
		imageRectangle.setPreferredSize(new Dimension(36, 40));
		imageRectangle.add(img);

		GridData constraintImageRectangle = new GridData();
		constraintImageRectangle.verticalAlignment = GridData.END;
		constraintImageRectangle.horizontalAlignment = GridData.CENTER;
		constraintImageRectangle.horizontalIndent = 0;
		constraintImageRectangle.horizontalSpan = 1;
		constraintImageRectangle.verticalSpan = 2;
		constraintImageRectangle.grabExcessHorizontalSpace = true;
		constraintImageRectangle.grabExcessVerticalSpace = true;

		container.add(img, constraintImageRectangle);
		imageRectangle.setLayoutManager(new StackLayout());

		// Rectangle to contain the name label.
		RectangleFigure esbNodeTypeNameRectangle = new RectangleFigure();
		esbNodeTypeNameRectangle.setOutline(false);
		esbNodeTypeNameRectangle.setBackgroundColor(new Color(null, 0, 125, 133));
		esbNodeTypeNameRectangle.setPreferredSize(new Dimension(65, 20));
		esbNodeTypeNameRectangle.setMinimumSize(new Dimension(65, 20));
		esbNodeTypeNameRectangle.setMaximumSize(new Dimension(65, 20));

		GridData constraintEsbNodeTypeNameRectangle = new GridData();
		constraintEsbNodeTypeNameRectangle.verticalAlignment = GridData.BEGINNING;
		constraintEsbNodeTypeNameRectangle.horizontalAlignment = GridData.CENTER;
		constraintEsbNodeTypeNameRectangle.horizontalIndent = 0;
		constraintEsbNodeTypeNameRectangle.horizontalSpan = 1;
		constraintEsbNodeTypeNameRectangle.verticalSpan = 1;
		constraintEsbNodeTypeNameRectangle.grabExcessHorizontalSpace = false;
		constraintEsbNodeTypeNameRectangle.grabExcessVerticalSpace = true;

		esbNodeTypeNameRectangle.setLayoutManager(new StackLayout());

		// Actual label to display which type this is.
		esbNodeTypeNameLabel2 = new WrappingLabel();
		esbNodeTypeNameLabel2.setText(getNodeName());
		esbNodeTypeNameLabel2.setForegroundColor(new Color(null, 0, 0, 0));
		esbNodeTypeNameLabel2.setFont(new Font(null, "Arial", 8, SWT.BOLD));
		esbNodeTypeNameLabel2.setAlignment(SWT.CENTER);
		esbNodeTypeNameLabel2.setPreferredSize(new Dimension(37, 20));
		esbNodeTypeNameLabel2.setMinimumSize(new Dimension(37, 20));
		esbNodeTypeNameLabel2.setMaximumSize(new Dimension(37, 20));

		esbNodeTypeNameRectangle.add(esbNodeTypeNameLabel2);
		container.add(esbNodeTypeNameRectangle, constraintEsbNodeTypeNameRectangle);
	}

	private RoundedRectangle createInnerRectangle(RoundedRectangle leftRectangle) {
		RoundedRectangle innerRect = new RoundedRectangle();
		innerRect.setCornerDimensions(new Dimension(1, 1));
		innerRect.setOutline(false);
		innerRect.setBackgroundColor(this.getBackgroundColor());
		LineBorder innerRectBorder = new LineBorder(new Color(null, 90, 90, 90), 1,
				SWT.BORDER_SOLID);
		innerRect.setBorder(innerRectBorder);
		innerRect.setPreferredSize(new Dimension(95, 25));
		innerRect.setMinimumSize(new Dimension(80, 100));
		innerRect.setBackgroundColor(new Color(null, 0, 125, 133));

		GridLayout innerRectLayout = new GridLayout();
		innerRectLayout.numColumns = 1;
		innerRectLayout.makeColumnsEqualWidth = true;
		innerRect.setLayoutManager(innerRectLayout);

		GridData innerRectGridData = new GridData();
		innerRectGridData.verticalAlignment = GridData.FILL;
		innerRectGridData.horizontalAlignment = GridData.FILL;
		innerRectGridData.horizontalIndent = 5;
		innerRectGridData.horizontalSpan = 5;
		innerRectGridData.grabExcessHorizontalSpace = true;
		innerRectGridData.grabExcessVerticalSpace = true;
		leftRectangle.add(innerRect, innerRectGridData);

		return innerRect;
	}

	protected WrappingLabel getProxyNameLabel() {
		return esbNodeTypeNameLabel2;
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
