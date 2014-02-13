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
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * Draws a Figure with a label
 */
public class EsbGraphicalShapeWithLabel extends RoundedRectangle {

	public GridData tempConstraintPropertyValueRectangle;
	public RoundedRectangle tempPropertyValueRectangle1;
	private WrappingLabel propertyNameLabel;
	static int Figure_PreferredWidth = FixedSizedAbstractMediator.FigureWidth;
	static int Figure_PreferredHeight = FixedSizedAbstractMediator.FigureHeight + 20; //Additional 20 to show the editable label
	static int Image_PreferredWidth = 75;
	static int Image_PreferredHeight = 52;
	static int marginWidth = (Figure_PreferredWidth - Image_PreferredWidth) / 2; //equals to 10
	static int marginHeight = 10;

	public EsbGraphicalShapeWithLabel() {
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
	}

	private void createContents() {

		/* main image grid data */
		GridData constraintMainImageRectangle = new GridData();
		constraintMainImageRectangle.verticalAlignment = GridData.BEGINNING;
		constraintMainImageRectangle.horizontalAlignment = GridData.CENTER;
		constraintMainImageRectangle.verticalSpan = 1;

		ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(getIconPath(),
				Image_PreferredWidth, Image_PreferredHeight);

		RoundedRectangle mainImageRectangle = new RoundedRectangle();
		mainImageRectangle.setCornerDimensions(new Dimension(8, 8));
		mainImageRectangle.setOutline(false);
		mainImageRectangle.setPreferredSize(new Dimension(Image_PreferredWidth,
				Image_PreferredHeight));
		mainImageRectangle.add(iconImageFigure);
		this.add(mainImageRectangle, constraintMainImageRectangle);

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
		propertyNameLabel.setFont(new Font(null, new FontData("Courier", 8, SWT.NONE)));
		propertyNameLabel.setAlignment(SWT.CENTER);
		propertyNameLabel.setPreferredSize(new Dimension(FixedSizedAbstractMediator.maxFigureWidth, 20));
		
		propertyValueRectangle1.add(propertyNameLabel);
		this.add(propertyValueRectangle1, constraintPropertyValueRectangle);
		tempPropertyValueRectangle1=propertyValueRectangle1;
		tempConstraintPropertyValueRectangle=constraintPropertyValueRectangle;
	}

	protected WrappingLabel getPropertyNameLabel() {
		return propertyNameLabel;
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