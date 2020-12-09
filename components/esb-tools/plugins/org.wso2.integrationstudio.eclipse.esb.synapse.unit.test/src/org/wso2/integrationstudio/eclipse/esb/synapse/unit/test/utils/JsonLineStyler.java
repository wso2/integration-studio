/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;
import org.wso2.integrationstudio.eclipse.platform.core.utils.ResourceManager;

/**
 * Class responsible for styling the JSON texts lines.
 */
public class JsonLineStyler implements LineStyleListener {

    private JsonScanner jsonScanner;
    private Map<JsonTokensType, Color> colorsMap;

    public JsonLineStyler(boolean isTextHighlighter) {
        initializeColors();
        jsonScanner = new JsonScanner(isTextHighlighter);
    }

    /*
     * Method for setting the color for the specified token type.
     */
    private void initializeColors() {
        colorsMap = new HashMap<JsonTokensType, Color>(JsonTokensType.getColoredTokensNum());
        colorsMap.put(JsonTokensType.TEXT, ResourceManager.getColor(0, 0, 0));
        colorsMap.put(JsonTokensType.KEYWORD, ResourceManager.getColor(196, 58, 34));
        colorsMap.put(JsonTokensType.QUOTED_LITERAL, ResourceManager.getColor(15, 128, 0));
        colorsMap.put(JsonTokensType.SYMBOL, ResourceManager.getColor(0, 0, 0));
        colorsMap.put(JsonTokensType.OTHER, ResourceManager.getColor(0, 0, 0));
        colorsMap.put(JsonTokensType.NUMBER, ResourceManager.getColor(45, 0, 255));
        colorsMap.put(JsonTokensType.JRPARAMETER, ResourceManager.getColor(178, 0, 0));
        colorsMap.put(JsonTokensType.JRFIELD, ResourceManager.getColor(32, 187, 34));
        colorsMap.put(JsonTokensType.JRVARIABLE, ResourceManager.getColor(17, 18, 254));
        colorsMap.put(JsonTokensType.STARTSYMBOL, ResourceManager.getColor(219, 26, 26));
        colorsMap.put(JsonTokensType.FREE_MARKUP_LOOP, ResourceManager.getColor(165, 152, 9));
        colorsMap.put(JsonTokensType.FREE_MARKUP_DOLLER_SYNTAX, ResourceManager.getColor(149, 62, 196));
    }

    /*
     * Method for getting the right color for the specified token type.
     * 
     * @param type type of the JSON token
     * 
     * @return Color for the token
     */
    private Color getColor(JsonTokensType type) {
        if (type != null) {
            return colorsMap.get(type);
        }
        return null;
    }

    @Override
    public void lineGetStyle(LineStyleEvent event) {
        Vector<StyleRange> styles = new Vector<StyleRange>();
        JsonTokensType token = null;
        StyleRange lastStyle = null;

        Color defaultFgColor = ((Control) event.widget).getForeground();
        jsonScanner.setRange(event.lineText);
        token = jsonScanner.nextToken();
        while (token != JsonTokensType.EOF) {
            if (token == JsonTokensType.OTHER) {
                // do nothing for non-colored tokens
            } else if (token != JsonTokensType.SPACE) {
                Color color = getColor(token);
                // Only create a style if the token color is different than the
                // widget's default foreground color and the token's style is not bold.
                // Keywords, symbols and operators are drawn bold.
                if (!color.equals(defaultFgColor) || (token == JsonTokensType.SYMBOL)) {
                    StyleRange style = new StyleRange(jsonScanner.getStartOffset() + event.lineOffset,
                            jsonScanner.getLength(), color, null);
                    if (token == JsonTokensType.SYMBOL) {
                        style.fontStyle = SWT.BOLD;
                    }
                    if (styles.isEmpty()) {
                        styles.addElement(style);
                    } else {
                        // Merge similar styles. Doing so will improve performance.
                        lastStyle = (StyleRange) styles.lastElement();
                        if (lastStyle.similarTo(style) && (lastStyle.start + lastStyle.length == style.start)) {
                            lastStyle.length += style.length;
                        } else {
                            styles.addElement(style);
                        }
                    }
                }
            } else if ((!styles.isEmpty()) && ((lastStyle = (StyleRange) styles.lastElement()).fontStyle == SWT.BOLD)) {
                int start = jsonScanner.getStartOffset() + event.lineOffset;
                lastStyle = (StyleRange) styles.lastElement();
                // A font style of SWT.BOLD implies that the last style
                // represents a java keyword.
                if (lastStyle.start + lastStyle.length == start) {
                    // Have the white space take on the style before it to
                    // minimize the number of style ranges created and the
                    // number of font style changes during rendering.
                    lastStyle.length += jsonScanner.getLength();
                }
            }
            token = jsonScanner.nextToken();
        }
        event.styles = new StyleRange[styles.size()];
        styles.copyInto(event.styles);
    }
}
