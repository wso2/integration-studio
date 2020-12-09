/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.model.ESBWirelog;

/**
 * This class is the wirelog viewpart class
 *
 */
public class WireLogView extends ViewPart implements ContentAcceptHandler {

    private StyledText requestWireLogText;
    private StyledText responseWireLogText;
    private Color tableEvenIndexColor;

    @Override
    public void createPartControl(Composite parent) {
        Display display = PlatformUI.createDisplay();
        tableEvenIndexColor = display.getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW);

        Composite wireLogArea = new Composite(parent, SWT.NONE);
        wireLogArea.setLayout(new GridLayout(2, true));
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.horizontalSpan = 2;
        wireLogArea.setLayoutData(data);

        // create a composite which holds request wire log label and request wirelogs
        Composite compositeRequet = new Composite(wireLogArea, SWT.BORDER);
        GridData gridDataReq = new GridData(SWT.FILL, SWT.FILL, true, true);
        compositeRequet.setLayoutData(gridDataReq);
        compositeRequet.setLayout(new GridLayout(1, false));

        // request wire log label
        Label requestLabel = new Label(compositeRequet, SWT.NONE);
        requestLabel.setText("Request Wire Log");

        // request wire log area
        requestWireLogText = new StyledText(compositeRequet,
                SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY);
        requestWireLogText.setLayoutData(gridDataReq);
        requestWireLogText.setBackground(tableEvenIndexColor);

        // composite which holds response wirelog label and response wire logs
        Composite compositeResponse = new Composite(wireLogArea, SWT.BORDER);
        GridData gridDataRes = new GridData(SWT.FILL, SWT.FILL, true, true);
        compositeResponse.setLayoutData(gridDataRes);
        compositeResponse.setLayout(new GridLayout(1, false));

        // response wire log label
        Label responseLabel = new Label(compositeResponse, SWT.NONE);
        responseLabel.setText("Response Wire Log");

        // response wire log area
        responseWireLogText = new StyledText(compositeResponse,
                SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY);
        responseWireLogText.setLayoutData(gridDataRes);
        responseWireLogText.setBackground(tableEvenIndexColor);
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void acceptContent(Object content, AcceptedContentAction action) {
        setRequestResponseWireLogs(content);
    }

    /**
     * Helper method to set request and response wire logs to the corresponding place
     * 
     * @param content
     */
    private void setRequestResponseWireLogs(Object content) {
        this.requestWireLogText.setText("");
        this.requestWireLogText.update();
        this.responseWireLogText.setText("");
        this.responseWireLogText.update();
        if (content == null) {
            return;
        }

        if (content instanceof ESBWirelog) {
            ESBWirelog esbWireLog = (ESBWirelog) content;
            this.requestWireLogText.setText(esbWireLog.getRequestWireLog());
            this.requestWireLogText.update();

            this.responseWireLogText.setText(esbWireLog.getResponseWireLog());
            this.responseWireLogText.update();
        }

    }
}
