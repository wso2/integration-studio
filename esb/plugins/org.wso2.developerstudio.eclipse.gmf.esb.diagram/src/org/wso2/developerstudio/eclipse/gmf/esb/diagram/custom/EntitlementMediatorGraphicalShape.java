/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;

public class EntitlementMediatorGraphicalShape extends RoundedRectangle{

	RectangleFigure propertyValueRectangle1;

	public EntitlementMediatorGraphicalShape() {
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 2;
		layoutThis.makeColumnsEqualWidth = true;
		this.setLayoutManager(layoutThis);

		this.setCornerDimensions(new Dimension(1, 1));
		//this.setFill(false); //dont uncoment this since we need this to be transparent we coment this
		this.setOutline(false);
		this.setBorder(new LineBorder(new Color(null, 224, 224, 224), 2, SWT.BORDER_DASH));
		createContents();
	}

	private void createContents() {		
		// Create left side rectangle.
		RoundedRectangle leftRectangle = new RoundedRectangle();
		leftRectangle.setCornerDimensions(new Dimension(1, 1));
		leftRectangle.setOutline(false);
		leftRectangle.setFill(false);
		leftRectangle.setPreferredSize(new Dimension(110, 30));
		leftRectangle.setMinimumSize(new Dimension(90, 95));

		GridData constraintGraphicalNodeContainer = new GridData();
		constraintGraphicalNodeContainer.verticalAlignment = GridData.CENTER;
		constraintGraphicalNodeContainer.horizontalAlignment = GridData.CENTER;
		this.add(leftRectangle, constraintGraphicalNodeContainer);

		GridLayout layoutGraphicalNodeContainer = new GridLayout();
		layoutGraphicalNodeContainer.numColumns = 1;
		leftRectangle.setLayoutManager(layoutGraphicalNodeContainer);
		
		// Create inner rectangle inside the left side rectangle.
		RoundedRectangle container = createInnerRectangle(leftRectangle);

		ImageDescriptor imgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(getIconPath());
			
		Image image =imgDesc.createImage();
		Image scaled = new Image(Display.getDefault(), 23, 25);
        GC gc = new GC(scaled);
        gc.setAntialias(SWT.ON);
        gc.setInterpolation(SWT.HIGH);
        gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, 23,
                     25);
        gc.dispose();		
		
		ImageFigure img = new ImageFigure(image);
		img.setSize(new Dimension(23, 25));

		RectangleFigure imageRectangle = new RectangleFigure();
		imageRectangle.setOutline(false);
		imageRectangle.setBackgroundColor(new Color(null, 233, 245, 215));
		imageRectangle.setPreferredSize(new Dimension(23, 25));
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

		// Rectangle to contain the type name label.
		RectangleFigure esbNodeTypeNameRectangle1 = new RectangleFigure();
		esbNodeTypeNameRectangle1.setOutline(false);
		esbNodeTypeNameRectangle1.setBackgroundColor(new Color(null, 233, 245, 215));
		esbNodeTypeNameRectangle1.setPreferredSize(new Dimension(45, 20));

		GridData constraintEsbNodeTypeNameRectangle = new GridData();
		constraintEsbNodeTypeNameRectangle.verticalAlignment = GridData.BEGINNING;
		constraintEsbNodeTypeNameRectangle.horizontalAlignment = GridData.CENTER;
		constraintEsbNodeTypeNameRectangle.horizontalIndent = 0;
		constraintEsbNodeTypeNameRectangle.horizontalSpan = 1;
		constraintEsbNodeTypeNameRectangle.verticalSpan = 1;
		constraintEsbNodeTypeNameRectangle.grabExcessHorizontalSpace = true;
		constraintEsbNodeTypeNameRectangle.grabExcessVerticalSpace = true;

		esbNodeTypeNameRectangle1.setLayoutManager(new StackLayout());

		// Actual label to display which type this is.
		WrappingLabel esbNodeTypeNameLabel = new WrappingLabel();
		esbNodeTypeNameLabel.setText(getNodeName());
		esbNodeTypeNameLabel.setForegroundColor(new Color(null, 0, 0, 0));
		esbNodeTypeNameLabel.setFont(new Font(null, "Arial", 10, SWT.BOLD));
		esbNodeTypeNameLabel.setAlignment(SWT.CENTER);
		esbNodeTypeNameLabel.setPreferredSize(new Dimension(45, 20));

		container.add(esbNodeTypeNameLabel, constraintEsbNodeTypeNameRectangle);

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
		innerRect.setBackgroundColor(new Color(null, 233, 245, 215));

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
	
	public RectangleFigure getPropertyValueRectangle1() {
		return propertyValueRectangle1;
	}

	public String getIconPath() {
		return "icons/ico20/entitlement-mediator.gif";
	}

	public String getNodeName() {
		return "Entitlement";
	}

	public Color getLabelBackColor() {
		return this.getBackgroundColor();
	}


	/**
	 * @generated
	 */
	static final Color LABEL2_FORE = new Color(null, 50, 50,
			50);

	/**
	 * @generated
	 */
	static final Color LOGMEDIATORPROPERTYVALUERECTANGLE1_BACK = new Color(
			null, 255, 255, 255);
}
