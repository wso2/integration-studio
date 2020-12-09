/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils.DiagramCustomConstants;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils.ImageHolder;

import static org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils.DiagramCustomConstants.VALIDATION_MARK_IMAGE_LOCATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.SWITCH_MEDIATOR_ICON_PATH;

/**
 * This class is the view representation of the switch mediator.
 *
 */
public class SwitchMediatorGraphicalShape extends RoundedRectangle {
    RectangleFigure propertyValueRectangle1;
    RoundedRectangle leftRectangle;
    RoundedRectangle containerInsideLeftRectangle;
    private LayeredPane pane;
    private Layer figureLayer;
    private Layer breakpointLayer;
    private Layer skipPointLayer;
    private Layer validationMarkLayer;
    protected String toolTipMessage;

    public SwitchMediatorGraphicalShape() {
        GridLayout layoutThis = new GridLayout();
        layoutThis.numColumns = 2;
        layoutThis.makeColumnsEqualWidth = true;
        this.setLayoutManager(layoutThis);
        this.setCornerDimensions(new Dimension(1, 1));
        this.setOutline(false);
        this.setBorder(new LineBorder(new Color(null, 224, 224, 224), 2, SWT.BORDER_DASH));
        createContents();
    }

    public void setToolTipMessage(String message) {
        toolTipMessage = message;
    }

    public void addBreakpointMark() {
        if (breakpointLayer == null) {
            breakpointLayer = new Layer();
            breakpointLayer.setLayoutManager(new StackLayout());
            GridData constraintBreakpointImageRectangle = new GridData();
            constraintBreakpointImageRectangle.verticalAlignment = GridData.BEGINNING;
            constraintBreakpointImageRectangle.horizontalAlignment = GridData.BEGINNING;
            constraintBreakpointImageRectangle.verticalSpan = 1;
            ImageFigure iconImageFigure = EditPartDrawingHelper
                    .getIconImageFigure(DiagramCustomConstants.BREAKPOINT_IMAGE_LOCATION, 16, 16);

            RoundedRectangle breakpointImageRectangle = new RoundedRectangle();
            breakpointImageRectangle.setCornerDimensions(new Dimension(2, 2));
            breakpointImageRectangle.setOutline(false);
            breakpointImageRectangle.setPreferredSize(new Dimension(10, containerInsideLeftRectangle.getSize().height));
            breakpointImageRectangle.setAlpha(0);
            breakpointImageRectangle.add(iconImageFigure);
            iconImageFigure.translate(0, containerInsideLeftRectangle.getSize().height / 2
                    - DiagramCustomConstants.DEBUGPOINT_IMAGE_OFFSET_VALUE);
            breakpointLayer.add(breakpointImageRectangle, constraintBreakpointImageRectangle);
            containerInsideLeftRectangle.remove(pane);
            pane.add(breakpointLayer);
            containerInsideLeftRectangle.add(pane);
        }
    }

    public void addSkipPointMark() {
        if (skipPointLayer == null) {
            skipPointLayer = new Layer();
            skipPointLayer.setLayoutManager(new StackLayout());
            GridData constraintSkipPointImageRectangle = new GridData();
            constraintSkipPointImageRectangle.verticalAlignment = GridData.END;
            constraintSkipPointImageRectangle.horizontalAlignment = GridData.CENTER;
            constraintSkipPointImageRectangle.horizontalIndent = 0;
            constraintSkipPointImageRectangle.horizontalSpan = 1;
            constraintSkipPointImageRectangle.verticalSpan = 2;
            constraintSkipPointImageRectangle.grabExcessHorizontalSpace = true;
            constraintSkipPointImageRectangle.grabExcessVerticalSpace = true;
            ImageFigure iconImageFigure = EditPartDrawingHelper
                    .getIconImageFigure(DiagramCustomConstants.SKIP_POINT_IMAGE_LOCATION, 56, 56);

            RoundedRectangle skipPointImageRectangle = new RoundedRectangle();
            skipPointImageRectangle.setCornerDimensions(new Dimension(2, 2));
            skipPointImageRectangle.setOutline(false);
            skipPointImageRectangle.setPreferredSize(new Dimension(10, containerInsideLeftRectangle.getSize().height));
            skipPointImageRectangle.setAlpha(0);
            skipPointImageRectangle.add(iconImageFigure);
            iconImageFigure.translate(0, containerInsideLeftRectangle.getSize().height / 2
                    - DiagramCustomConstants.DEBUGPOINT_IMAGE_OFFSET_VALUE);
            skipPointLayer.add(skipPointImageRectangle, constraintSkipPointImageRectangle);
            skipPointLayer.setBackgroundColor(EditPartDrawingHelper.FigureNormalColor);
            containerInsideLeftRectangle.remove(pane);
            pane.add(skipPointLayer);
            containerInsideLeftRectangle.add(pane);
        }
    }

    /**
     * This method adds layer with validation mark to the figure pane to show
     * the incomplete mutator configuration
     */
    public void addValidationMark() {
        if (validationMarkLayer == null) {
            validationMarkLayer = new Layer();
            validationMarkLayer.setLayoutManager(new StackLayout());
            GridData constraintImageRectangle = new GridData();
            constraintImageRectangle.verticalAlignment = GridData.BEGINNING;
            constraintImageRectangle.horizontalAlignment = GridData.BEGINNING;
            constraintImageRectangle.verticalSpan = 1;
            ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(VALIDATION_MARK_IMAGE_LOCATION, 16,
                    16);
            RoundedRectangle validationMarkImageRectangle = new RoundedRectangle();
            validationMarkImageRectangle.setCornerDimensions(new Dimension(2, 2));
            validationMarkImageRectangle.setOutline(false);
            validationMarkImageRectangle
                    .setPreferredSize(new Dimension(10, containerInsideLeftRectangle.getSize().height));
            validationMarkImageRectangle.setAlpha(0);
            validationMarkImageRectangle.add(iconImageFigure);
            iconImageFigure.translate(containerInsideLeftRectangle.getSize().width - 30,
                    containerInsideLeftRectangle.getSize().height / 2
                            - DiagramCustomConstants.VALIDATIONPOINT_IMAGE_OFFSET_VALUE);
            validationMarkLayer.add(validationMarkImageRectangle, constraintImageRectangle);
            pane.add(validationMarkLayer);
        }
    }

    /**
     * This method remove validation point layer
     */
    public void removeValidationMark() {
        if (validationMarkLayer != null) {
            pane.remove(validationMarkLayer);
            validationMarkLayer = null;
        }
    }

    public void removeBreakpointMark() {
        if (breakpointLayer != null) {
            pane.remove(breakpointLayer);
            breakpointLayer = null;
        }
    }

    public void removeSkipPointMark() {
        if (skipPointLayer != null) {
            pane.remove(skipPointLayer);
            skipPointLayer = null;
        }
    }

    private void createContents() {

        pane = new LayeredPane();
        pane.setLayoutManager(new StackLayout());
        figureLayer = new Layer();
        figureLayer.setLayoutManager(new GridLayout());

        leftRectangle = new RoundedRectangle();
        leftRectangle.setCornerDimensions(new Dimension(1, 1));
        leftRectangle.setOutline(false);
        leftRectangle.setFill(false);
        leftRectangle.setPreferredSize(new Dimension(110, 30));
        leftRectangle.setMinimumSize(new Dimension(90, 95));

        GridData layoutGraphicalNodeContainer = new GridData();
        layoutGraphicalNodeContainer.verticalAlignment = GridData.CENTER;
        layoutGraphicalNodeContainer.horizontalAlignment = GridData.CENTER;
        this.add(leftRectangle, layoutGraphicalNodeContainer);

        GridLayout constraintGraphicalNodeContainer = new GridLayout();
        constraintGraphicalNodeContainer.numColumns = 1;
        leftRectangle.setLayoutManager(constraintGraphicalNodeContainer);

        // Create inner rectangle inside the left side rectangle.
        containerInsideLeftRectangle = createInnerRectangle(leftRectangle);

        Image image = ImageHolder.getInstance().getSwitchMediatorImage();
        Image scaled = new Image(Display.getDefault(), 23, 25);
        GC gc = new GC(scaled);
        gc.setAntialias(SWT.ON);
        gc.setInterpolation(SWT.HIGH);
        gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, 23, 25);
        gc.dispose();

        ImageFigure img = new ImageFigure(image);
        img.setSize(new Dimension(36, 40));

        GridData constraintImageRectangle = new GridData();
        constraintImageRectangle.verticalAlignment = GridData.END;
        constraintImageRectangle.horizontalAlignment = GridData.CENTER;
        constraintImageRectangle.horizontalIndent = 0;
        constraintImageRectangle.horizontalSpan = 1;
        constraintImageRectangle.verticalSpan = 2;
        constraintImageRectangle.grabExcessHorizontalSpace = true;
        constraintImageRectangle.grabExcessVerticalSpace = true;
        figureLayer.add(img, constraintImageRectangle);

        // Rectangle to hold item name.
        RectangleFigure esbNodeTypeNameRectangle = new RectangleFigure();
        esbNodeTypeNameRectangle.setOutline(false);
        esbNodeTypeNameRectangle.setBackgroundColor(new Color(null, 233, 245, 215));
        esbNodeTypeNameRectangle.setPreferredSize(new Dimension(55, 20));

        GridData constraintEsbNodeTypeNameRectangle = new GridData();
        constraintEsbNodeTypeNameRectangle.verticalAlignment = GridData.BEGINNING;
        constraintEsbNodeTypeNameRectangle.horizontalAlignment = GridData.CENTER;
        constraintEsbNodeTypeNameRectangle.horizontalIndent = 0;
        constraintEsbNodeTypeNameRectangle.horizontalSpan = 1;
        constraintEsbNodeTypeNameRectangle.verticalSpan = 1;
        constraintEsbNodeTypeNameRectangle.grabExcessHorizontalSpace = true;
        constraintEsbNodeTypeNameRectangle.grabExcessVerticalSpace = true;

        esbNodeTypeNameRectangle.setLayoutManager(new StackLayout());

        // Actual label to display which type this is.
        WrappingLabel esbNodeTypeNameLabel = new WrappingLabel();
        esbNodeTypeNameLabel.setText(getNodeName());
        esbNodeTypeNameLabel.setForegroundColor(new Color(null, 255, 255, 255));
        esbNodeTypeNameLabel.setFont(new Font(null, "Arial", 10, SWT.BOLD));
        esbNodeTypeNameLabel.setAlignment(SWT.CENTER);
        esbNodeTypeNameLabel.setPreferredSize(new Dimension(55, 20));
        figureLayer.add(esbNodeTypeNameLabel, constraintEsbNodeTypeNameRectangle);
        pane.add(figureLayer);
        GridData constraintPaneRectangle = new GridData();
        constraintPaneRectangle.verticalAlignment = GridData.FILL;
        constraintPaneRectangle.horizontalAlignment = GridData.FILL;
        constraintPaneRectangle.horizontalIndent = 0;
        constraintPaneRectangle.horizontalSpan = 1;
        constraintPaneRectangle.verticalSpan = 1;
        constraintPaneRectangle.grabExcessHorizontalSpace = true;
        constraintPaneRectangle.grabExcessVerticalSpace = true;
        containerInsideLeftRectangle.add(pane, constraintPaneRectangle);
    }

    private RoundedRectangle createInnerRectangle(RoundedRectangle leftRectangle) {
        RoundedRectangle innerRect = new RoundedRectangle();
        innerRect.setCornerDimensions(new Dimension(1, 1));
        innerRect.setOutline(false);
        innerRect.setBackgroundColor(this.getBackgroundColor());
        LineBorder innerRectBorder = new LineBorder(new Color(null, 255, 255, 255), 1, SWT.BORDER_SOLID);
        innerRect.setBorder(innerRectBorder);
        innerRect.setPreferredSize(new Dimension(95, 25));
        innerRect.setMinimumSize(new Dimension(80, 100));
        innerRect.setBackgroundColor(new Color(null, 37, 185, 154));

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

    public String getNodeName() {
        return "Switch";
    }

    public String getIconPath() {
        return SWITCH_MEDIATOR_ICON_PATH;
    }

    public Color getLabelBackColor() {
        return this.getBackgroundColor();
    }

}
