/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.updater.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;

public class UpdateNotificationPopUp extends AbstractNotificationPopup {
    
    protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

    private List<String> releaseNoteItems = new ArrayList<>();
    private Display display;

    /**
     * @param display
     */
    public UpdateNotificationPopUp(Display display, List<String> releaseItems) {
        super(display);
        this.display = display;
        this.releaseNoteItems = releaseItems;
    }

    @Override
    protected void createContentArea(Composite parent) {

        Composite container = new Composite(parent, SWT.NULL);
        container.setLayout(new GridLayout(1, false));
        GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        container.setLayoutData(data);

        Label descriptionMesg = new Label(container, SWT.NULL);
        descriptionMesg.setText("Updates are available for your Integration Studio.");

        new Label(container, SWT.NONE);
        Label newFeaturesLbl = new Label(container, SWT.NONE);
        newFeaturesLbl.setText("What's new in Integration Studio?");
        FontData fontData = newFeaturesLbl.getFont().getFontData()[0];
        Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
        newFeaturesLbl.setFont(font);

        // Configure scrolled composite
        final ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.V_SCROLL | SWT.H_SCROLL);
        scrolledComposite.setLayout(new GridLayout());
        GridData dData = new GridData(GridData.FILL_HORIZONTAL);
        dData.heightHint  = 105;
        scrolledComposite.setLayoutData(dData);
        scrolledComposite.setExpandVertical(true);
        scrolledComposite.setExpandHorizontal(true);
        
        // Add content to scrolled composite
        final Composite scrolledContent = new Composite(scrolledComposite, SWT.NONE);
        scrolledContent.setLayout(new GridLayout());
        GridData releaseSectionData = new GridData(GridData.FILL_HORIZONTAL);
        scrolledContent.setLayoutData(releaseSectionData);
        scrolledComposite.setContent(scrolledContent);
        
        for (String item : releaseNoteItems) {
            Label newItems = new Label(scrolledContent, SWT.NONE);
            newItems.setText("- " + item);
        }
        
        scrolledComposite.setMinHeight(scrolledContent.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
        
        scrolledComposite.addControlListener(new ControlAdapter(){
            public void controlResized( ControlEvent e ) {
                scrolledComposite.setMinHeight(scrolledContent.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
            }
        });
        
        new Label(container, SWT.NONE);
        final Link updateNowLbl = new Link(container, SWT.WRAP | SWT.LEFT);
        updateNowLbl.setText(createUrl("Review and install updates"));
        Cursor cursor = new Cursor(display, SWT.CURSOR_HAND);
        GridData linkData = new GridData();
        linkData.widthHint = 400;
        updateNowLbl.setLayoutData(linkData);
        updateNowLbl.setCursor(cursor);
        
        final StyledText elseMessage = new StyledText(container, SWT.NONE);
        elseMessage.setText("Go to Help > Check for Updates if you stop the automatic update");
        elseMessage.setLayoutData(linkData);
        elseMessage.setVisible(false);
        elseMessage.setEditable(false);
        elseMessage.setEnabled(false);
        FontData[] fD = elseMessage.getFont().getFontData();
        fD[0].setHeight(12);
        elseMessage.setFont( new Font(display,fD[0]));
        StyleRange style = new StyleRange();
        style.start = 6;
        style.length = 25;
        style.fontStyle = SWT.BOLD;
        elseMessage.setStyleRange(style);
        new Label(container, SWT.NONE);

        updateNowLbl.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench()
                        .getService(IHandlerService.class);
                try {
                    handlerService.executeCommand("org.wso2.developerstudio.eclipse.updater.CheckUpdatesCmd", null);
                } catch (Exception err) {
                    log.error("org.wso2.developerstudio.eclipse.updater.CheckUpdatesCmd not found", err);
                }
                
                updateNowLbl.setVisible(false);
                elseMessage.setVisible(true);
            }
        });
    }

    @Override
    protected String getPopupShellTitle() {
        return "Update(s) Available";
    }

    private String createUrl(String endpoint) {
        return "<a>" + endpoint + "</a>";
    }
}
