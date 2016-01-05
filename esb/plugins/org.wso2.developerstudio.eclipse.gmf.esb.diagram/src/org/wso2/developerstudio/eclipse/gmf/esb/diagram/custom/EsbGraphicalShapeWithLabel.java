/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.DiagramCustomConstants.*;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Draws a Figure with a label
 */
public class EsbGraphicalShapeWithLabel extends RoundedRectangle {

	public GridData tempConstraintPropertyValueRectangle;
	public RoundedRectangle tempPropertyValueRectangle1;
	private WrappingLabel propertyNameLabel;
	private static int Image_PreferredWidth = 75;
	private static int Image_PreferredHeight = 52;
	protected RoundedRectangle mainImageRectangle;
	private LayeredPane pane;
	protected Layer figureLayer;
	private Layer breakpointLayer;
	private Layer skippointLayer;
	protected String toolTipMessage;

	public EsbGraphicalShapeWithLabel() {
		initializeShape();
	}

	/**
	 * This method set the tool tip message of the graphical shape
	 * 
	 * @param message
	 */
	public void setToolTipMessage(String message) {
		toolTipMessage = message;
	}

	private void initializeShape() {

		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 1;
		layoutThis.makeColumnsEqualWidth = true;
		layoutThis.horizontalSpacing = 0;
		layoutThis.verticalSpacing = -5;
		layoutThis.marginHeight = 3;
		layoutThis.marginWidth = 0;

		this.setLayoutManager(layoutThis);
		this.setCornerDimensions(new Dimension(8, 8));
		this.setOutline(false);

		RoundedRectangleBorder border = new RoundedRectangleBorder(8, 8);
		border.setColor(EditPartDrawingHelper.FigureNormalColor);
		this.setBorder(border);

		createContents();

		pane = new LayeredPane();
		pane.setLayoutManager(new StackLayout());
		pane.add(figureLayer);
		this.add(pane);
	}

	/**
	 * This method adds layer with breakpoint mark to the figure pane
	 */
	public void addBreakpointMark() {
		breakpointLayer = new Layer();
		breakpointLayer.setLayoutManager(new StackLayout());
		GridData constraintBreakpointImageRectangle = new GridData();
		constraintBreakpointImageRectangle.verticalAlignment = GridData.BEGINNING;
		constraintBreakpointImageRectangle.horizontalAlignment = GridData.BEGINNING;
		constraintBreakpointImageRectangle.verticalSpan = 1;
		ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(
				BREAKPOINT_IMAGE_LOCATION, 16, 16);
		RoundedRectangle breakpointImageRectangle = new RoundedRectangle();
		breakpointImageRectangle.setCornerDimensions(new Dimension(2, 2));
		breakpointImageRectangle.setOutline(false);
		breakpointImageRectangle.setPreferredSize(new Dimension(16, 16));
		breakpointImageRectangle.setAlpha(0);
		breakpointImageRectangle.add(iconImageFigure);
		iconImageFigure.translate((this.getSize().width / 2
				- mainImageRectangle.getSize().width / 2 + 3), 0);
		breakpointLayer.add(breakpointImageRectangle,
				constraintBreakpointImageRectangle);
		pane.add(breakpointLayer);
	}

	/**
	 * This method remove breakpoint layer
	 */
	public void removeBreakpointMark() {
		if (breakpointLayer != null) {
			pane.remove(breakpointLayer);
			breakpointLayer = null;
		}
	}

	/**
	 * This method adds layer with skip point mark to the figure pane
	 */
	public void addSkippointMark() {
		skippointLayer = new Layer();
		skippointLayer.setLayoutManager(new StackLayout());
		GridData constraintBreakpointImageRectangle = new GridData();
		constraintBreakpointImageRectangle.verticalAlignment = GridData.BEGINNING;
		constraintBreakpointImageRectangle.horizontalAlignment = GridData.BEGINNING;
		constraintBreakpointImageRectangle.verticalSpan = 1;
		ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(
				SKIP_POINT_IMAGE_LOCATION, this.getBounds().width,
				this.getBounds().height);
		RoundedRectangle skipPointImageRectangle = new RoundedRectangle();
		skipPointImageRectangle.setCornerDimensions(new Dimension(2, 2));
		skipPointImageRectangle.setOutline(false);
		skipPointImageRectangle.setPreferredSize(new Dimension(10, 10));
		skipPointImageRectangle.setAlpha(0);
		skipPointImageRectangle.add(iconImageFigure);

		skippointLayer.add(skipPointImageRectangle,
				constraintBreakpointImageRectangle);
		pane.add(skippointLayer);
	}

	/**
	 * This method remove skip point layer
	 */
	public void removeSkippointMark() {
		if (skippointLayer != null) {
			pane.remove(skippointLayer);
			skippointLayer = null;
		}
	}

	private void createContents() {

		figureLayer = new Layer();
		GridLayout figureLayerLayout = new GridLayout();
		figureLayerLayout.marginHeight = 0;
		figureLayerLayout.marginWidth = 0;
		figureLayerLayout.verticalSpacing = 0;
		figureLayer.setLayoutManager(figureLayerLayout);
		GridData constraintMainImageRectangle = new GridData();
		constraintMainImageRectangle.verticalAlignment = GridData.BEGINNING;
		constraintMainImageRectangle.horizontalAlignment = GridData.CENTER;
		constraintMainImageRectangle.verticalSpan = 1;

		ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(
				getIconPath(), Image_PreferredWidth, Image_PreferredHeight);

		mainImageRectangle = new RoundedRectangle();
		mainImageRectangle.setCornerDimensions(new Dimension(8, 8));
		mainImageRectangle.setOutline(false);
		mainImageRectangle.setPreferredSize(new Dimension(Image_PreferredWidth,
				Image_PreferredHeight));
		mainImageRectangle.add(iconImageFigure);
		figureLayer.add(mainImageRectangle, constraintMainImageRectangle);

		RoundedRectangle propertyValueRectangle1 = new RoundedRectangle();
		propertyValueRectangle1.setCornerDimensions(new Dimension(0, 0));
		propertyValueRectangle1.setOutline(false);

		GridData constraintPropertyValueRectangle = new GridData();
		constraintPropertyValueRectangle.verticalAlignment = GridData.FILL;
		constraintPropertyValueRectangle.horizontalAlignment = GridData.FILL;
		constraintPropertyValueRectangle.horizontalIndent = 0;
		constraintPropertyValueRectangle.horizontalSpan = 1;
		constraintPropertyValueRectangle.verticalSpan = 1;
		constraintPropertyValueRectangle.grabExcessHorizontalSpace = true;
		constraintPropertyValueRectangle.grabExcessVerticalSpace = true;

		propertyValueRectangle1.setLayoutManager(new StackLayout());

		// Label to display description.
		propertyNameLabel = new WrappingLabel();
		propertyNameLabel.setText(getNodeName());
		propertyNameLabel.setForegroundColor(new Color(null, 46, 46, 46));
		propertyNameLabel.setFont(new Font(null, new FontData(
				PROPERTY_NAME_LABEL_FONT, 8, SWT.NONE)));
		propertyNameLabel.setAlignment(SWT.CENTER);
		propertyNameLabel.setPreferredSize(new Dimension(
				FixedSizedAbstractMediator.maxFigureWidth, 20));

		propertyValueRectangle1.add(propertyNameLabel);
		figureLayer.add(propertyValueRectangle1,
				constraintPropertyValueRectangle);
		tempPropertyValueRectangle1 = propertyValueRectangle1;
		tempConstraintPropertyValueRectangle = constraintPropertyValueRectangle;
	}

	protected WrappingLabel getPropertyNameLabel() {
		return propertyNameLabel;
	}

	public String getIconPath() {
		return "override this in the child class with actual icon path";
	}

	public String getNodeName() {
		return DEFAULT_NODE_NAME_VALUE;
	}

	public Color getLabelBackColor() {
		return this.getBackgroundColor();
	}
}