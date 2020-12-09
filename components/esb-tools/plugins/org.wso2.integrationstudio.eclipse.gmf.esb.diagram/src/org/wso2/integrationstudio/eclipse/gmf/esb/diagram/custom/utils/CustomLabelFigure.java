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

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

/**
 * Provide a custom label figure with a {@link TextFlow} that calculate and adjust content
 * according to the width to height ratio
 *
 */
public class CustomLabelFigure extends FlowPage {

    private final TextFlow textFlow;
    private double ratio;

    /**
     * Create a new label
     * 
     * @param ratio use when calculating the dimension
     */
    public CustomLabelFigure() {
        super();
        textFlow = new TextFlow();
        textFlow.setLayoutManager(new ParagraphTextLayout(textFlow, ParagraphTextLayout.WORD_WRAP_HARD));
        add(textFlow);
        setHorizontalAligment(PositionConstants.LEFT);
        setBorder(new MarginBorder(3));
    }

    public void setText(String text) {
        this.textFlow.setText(text);
    }

    public String getText() {
        return textFlow.getText();
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    /**
     * Calculate the best size using width to height ratio
     * 
     * @return calculated dimension
     */
    public Dimension calculateSize() {
        Dimension lineDimensions = TextUtilities.INSTANCE.getStringExtents(textFlow.getText(), getFont());
        double area = lineDimensions.width() * lineDimensions.height();
        double width = Math.sqrt(area / ratio) * ratio;
        invalidate();
        return getPreferredSize((int) width, -1).getCopy();
    }

}
