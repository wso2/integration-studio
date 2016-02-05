/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;

/**
 * This class define view to show the ESB Mediation Debugger envelope properties while debugging
 *
 */
public class EnvelopeView extends ViewPart implements ContentAcceptHandler {

    private Text messageEnvelope;
    ListViewer viewer;

    @Override
    public void createPartControl(Composite parent) {
        messageEnvelope = new Text(parent, SWT.MULTI | SWT.READ_ONLY);
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
    }

    private void setMessageEnvelope(String messageEnvelope) {
        this.messageEnvelope.setText(OpenEditorUtil.formatMessageEnvelope(messageEnvelope));
        this.messageEnvelope.update();
    }

    @Override
    public void acceptContent(Object content) {
        if (content instanceof String) {
            setMessageEnvelope((String) content);
        }
    }

}
