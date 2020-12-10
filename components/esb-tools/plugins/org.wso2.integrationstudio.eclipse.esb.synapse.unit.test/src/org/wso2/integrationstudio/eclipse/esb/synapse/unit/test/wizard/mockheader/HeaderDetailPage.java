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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.mockheader;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.ComboItems;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.ComboTypingSuggestUtil;

/**
 * Class responsible for creation of wizard page for mock service resource
 * headers.
 */
public class HeaderDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Mock Service Resource - Header Details";
    private static final String REQUEST_DIALOG_TITLE = "Mock Service Resource - Request Header Details";
    private static final String RESPONSE_DIALOG_TITLE = "Mock Service Resource - Response Header Details";
    private static final String REQUEST = "REQUEST";
    private static final String EMPTY_STRING = "";
    private static final String HEADER_NAME = "Header Name:";
    private static final String HEADER_VALUE = "Header Value:";

    private String headerName = EMPTY_STRING;
    private String headerValue = EMPTY_STRING;

    private boolean isPageDirty;

    /**
     * Class constructor.
     */
    protected HeaderDetailPage(IWorkbench wb, IStructuredSelection selection, MockService resourceHolder,
            String headerType) {
        super(DIALOG_TITLE);

        if (headerType.equals(REQUEST)) {
            setTitle(REQUEST_DIALOG_TITLE);
        } else {
            setTitle(RESPONSE_DIALOG_TITLE);
        }

        // check page loading for update status
        MockServiceResource selectedResource = null;
        if (resourceHolder.isMockServiceResourceUpdate()) {
            String key = resourceHolder.getSelectedMockResourceKey();
            selectedResource = resourceHolder.getMockResource(key);
        }

        String headerKey = EMPTY_STRING;
        String headerValue = EMPTY_STRING;
        if (resourceHolder.isMockServiceRequestHeaderUpdate()) {
            headerKey = resourceHolder.getSelectedRequestHeaderKey();

            if (selectedResource != null && selectedResource.getRequestHeaders().containsKey(headerKey)) {
                headerValue = selectedResource.getRequestHeaderValue(headerKey);
            } else {
                headerValue = resourceHolder.getTemporalRequestHeaderValue(headerKey);
            }

        } else if (resourceHolder.isMockServiceResponseHeaderUpdate()) {
            headerKey = resourceHolder.getSelectedResponseHeaderKey();

            if (selectedResource != null && selectedResource.getResponseHeaders().containsKey(headerKey)) {
                headerValue = selectedResource.getResponseHeaderValue(headerKey);
            } else {
                headerValue = resourceHolder.getTemporalResponseHeaderValue(headerKey);
            }
        }

        fillUpdatingHeaderData(headerKey, headerValue);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData fd;

        Label lblHeaderName = new Label(container, SWT.NONE);
        fd = new FormData();
        fd.top = new FormAttachment(10);
        fd.left = new FormAttachment(3);
        fd.width = 160;
        lblHeaderName.setLayoutData(fd);
        lblHeaderName.setText(HEADER_NAME);

        Combo comboHeaderTags = new Combo(container, SWT.BORDER);
        fd = new FormData();
        fd.top = new FormAttachment(10);
        fd.left = new FormAttachment(lblHeaderName, 0);
        fd.right = new FormAttachment(97);
        fd.width = 400;
        comboHeaderTags.setItems(ComboItems.getServiceHeaders());
        comboHeaderTags.setLayoutData(fd);
        ComboTypingSuggestUtil.addAutoCompleteFeature(comboHeaderTags);
        if (getHeaderName() != null && !getHeaderName().isEmpty()) {
            comboHeaderTags.setText(getHeaderName());
        }

        comboHeaderTags.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setHeaderName(comboHeaderTags.getText());
                validate();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        comboHeaderTags.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setHeaderName(comboHeaderTags.getText());
                validate();
            }
        });

        Label lblHeaderValue = new Label(container, SWT.NONE);
        fd = new FormData();
        fd.top = new FormAttachment(lblHeaderName, 20);
        fd.left = new FormAttachment(3);
        fd.width = 160;
        lblHeaderValue.setLayoutData(fd);
        lblHeaderValue.setText(HEADER_VALUE);

        Combo comboHeaderValue = new Combo(container, SWT.BORDER);
        fd = new FormData();
        fd.top = new FormAttachment(lblHeaderName, 20);
        fd.left = new FormAttachment(lblHeaderValue, 0);
        fd.right = new FormAttachment(97);
        fd.width = 400;
        comboHeaderValue.setLayoutData(fd);
        comboHeaderValue.setItems(ComboItems.getServiceHeaderValues());
        ComboTypingSuggestUtil.addAutoCompleteFeature(comboHeaderValue);
        if (getHeaderValue() != null && !getHeaderValue().isEmpty()) {
            comboHeaderValue.setText(getHeaderValue());
        }

        comboHeaderValue.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setHeaderValue(comboHeaderValue.getText());
                validate();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        comboHeaderValue.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setHeaderValue(comboHeaderValue.getText());
                validate();
            }
        });

        setPageComplete(false);
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getHeaderName() == null || getHeaderName().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a header name");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getHeaderValue() == null || getHeaderValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a header value");
            setPageComplete(false);
            setPageDirty(true);
            return;
        }

        setPageDirty(false);
        setErrorMessage(null);
        setPageComplete(true);
    }

    /**
     * Method for filling updating data to wizard page.
     *
     * @param name
     *            header name
     * @param value
     *            header value
     */
    private void fillUpdatingHeaderData(String name, String value) {
        setHeaderName(name);
        setHeaderValue(value);
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }

}
