/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Create a rectangle shape tool tip using {@link CustomLabelFigure}
 *
 */
public class CustomToolTip {

    private final int RATIO = 2;

    /**
     * Return tool tip shape that adjusted according to the tool tip message
     * 
     * @return rectangle shape {@link IFigure}
     */
    public IFigure getCustomToolTipShape(String toolTipMessage) {
        RectangleFigure toolTipBox = new RectangleFigure();
        toolTipBox.setBounds(new Rectangle());
        toolTipBox.setLayoutManager(new StackLayout());
        CustomLabelFigure figure = new CustomLabelFigure();
        figure.setRatio(RATIO);
        figure.setText(toolTipMessage);
        figure.setSize(figure.calculateSize());
        toolTipBox.add(figure);
        toolTipBox.setPreferredSize(figure.getSize().width, figure.getSize().height);
        return toolTipBox;
    }
}
