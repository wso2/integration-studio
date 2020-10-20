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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.JavaScriptLineStyler;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.JsonLineStyler;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.XmlRegion;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.XmlRegionAnalyzer;

/**
 * Class responsible for create syntax highlighting style box.
 */
public class SyntaxHighlightTextBox extends Layout {
    private StyledText styledTextInputPayload;
    private JsonLineStyler jsonStyler;
    private JsonLineStyler textStyler;
    private JavaScriptLineStyler javaScriptStyler;

    /**
     * Method of creating styled box.
     * 
     * @param parent
     *            Composite layout
     * @return StyledText widget
     */
    public StyledText getStyledTextBox(Composite parent) {
        SourceViewer sourceViewer = new SourceViewer(parent, null, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
        styledTextInputPayload = sourceViewer.getTextWidget();

        return styledTextInputPayload;
    }
    
    /**
     * Method of creating styled box.
     * 
     * @param parent
     *            Composite layout
     * @return StyledText widget
     */
    public StyledText getStyledTextBox(Composite parent, int styles) {
        SourceViewer sourceViewer = new SourceViewer(parent, null, styles);
        styledTextInputPayload = sourceViewer.getTextWidget();

        return styledTextInputPayload;
    }

    /**
     * Method of highlighting JSON texts.
     * 
     * @param inputPayload
     *            JSON text
     */
    public void highlightJson(String inputPayload, boolean isTextHighlighter) {
    	if (jsonStyler == null) {
    		jsonStyler = new JsonLineStyler(isTextHighlighter);
        }
    	
        styledTextInputPayload.addLineStyleListener(jsonStyler);
    }
    
    /**
     * Method of highlighting texts.
     * 
     * @param inputPayload
     *            JSON text
     */
    public void highlightText(String inputPayload, boolean isTextHighlighter) {
    	if (textStyler == null) {
    		textStyler = new JsonLineStyler(isTextHighlighter);
        }
    	
        styledTextInputPayload.addLineStyleListener(textStyler);
    }

    /**
     * Method of highlighting XML texts.
     * 
     * @param inputPayload
     *            XML text
     */
    public void highlightXml(String inputPayload) {
        List<XmlRegion> regions = new XmlRegionAnalyzer().analyzeXml(inputPayload);
        List<StyleRange> ranges = computeXmlStyleRanges(regions);

        StyleRange[] array = new StyleRange[ranges.size()];
        int x = 0;
        for (StyleRange range : ranges) {
            array[x] = range;
            x++;
        }

        styledTextInputPayload.setStyleRanges(array);
    }
    
    /**
     * Method of highlighting JavaScript texts.
     * 
     * @param inputPayload
     *            JavaScript text
     */
    public void highlightJavaScript(String inputPayload) {
        if (javaScriptStyler == null) {
        	javaScriptStyler = new JavaScriptLineStyler();
        }

        styledTextInputPayload.addLineStyleListener(javaScriptStyler);
    }

    /**
     * Method of defining XMLstyle ranges .
     * 
     * @param regions
     *            List of XML regions
     * @return List<StyleRange>
     */
    private List<StyleRange> computeXmlStyleRanges(List<XmlRegion> regions) {
        List<StyleRange> styleRanges = new ArrayList<StyleRange>();
        for (XmlRegion xRegion : regions) {

            // The style itself depends on the region type
            // In this example, we use colors from the system
            StyleRange styleRange = new StyleRange();
            int colorCode = -1;
            switch (xRegion.getXmlRegionType()) {
            case MARKUP:
                colorCode = SWT.COLOR_DARK_GREEN;
                break;
            case FREE_MARKUP_LOOP:
                colorCode = SWT.COLOR_DARK_YELLOW;
                break;    
            case FREE_MARKUP_DOLLER_SYNTAX:
                colorCode = SWT.COLOR_DARK_MAGENTA;
                break;
            case ATTRIBUTE:
                colorCode = SWT.COLOR_DARK_RED;
                break;
            case ATTRIBUTE_VALUE:
                colorCode = SWT.COLOR_DARK_MAGENTA;
                break;
            case MARKUP_VALUE:
                break;
            case COMMENT:
                colorCode = SWT.COLOR_GRAY;
                break;
            case INSTRUCTION:
                break;
            case CDATA:
                break;
            case WHITESPACE:
                break;
            default:
                break;
            }
            if (colorCode != -1) {
                styleRange.foreground = Display.getDefault().getSystemColor(colorCode);
            }

            // Define the position and limit
            styleRange.start = xRegion.getStart();
            styleRange.length = xRegion.getEnd() - xRegion.getStart();
            styleRanges.add(styleRange);
        }

        return styleRanges;
    }

    /**
     * Method of choosing relevant syntax method to highlight .
     * 
     * @param inputPayload
     *            raw text data
     */
    public void chooseSyntaxHighlighter(String inputPayload, boolean isJavaScriptHighlighter) {            
        if (inputPayload.trim().startsWith(Constants.JSON_PREFIX)) {
            highlightJson(inputPayload, false);
        } else if (inputPayload.trim().startsWith(Constants.XML_PREFIX)) {
        	if (jsonStyler != null) {
                styledTextInputPayload.removeLineStyleListener(jsonStyler);
            }
            if (javaScriptStyler != null) {
                styledTextInputPayload.removeLineStyleListener(javaScriptStyler);
            }
            if (textStyler != null) {
            	styledTextInputPayload.removeLineStyleListener(textStyler);
            }
            highlightXml(inputPayload);
        } else if (isJavaScriptHighlighter) {
            highlightJavaScript(inputPayload);
        } else {
        	highlightText(inputPayload, true);
        }
    }

    @Override
    protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
        return null;
    }

    @Override
    protected void layout(Composite composite, boolean flushCache) {
    }
}
