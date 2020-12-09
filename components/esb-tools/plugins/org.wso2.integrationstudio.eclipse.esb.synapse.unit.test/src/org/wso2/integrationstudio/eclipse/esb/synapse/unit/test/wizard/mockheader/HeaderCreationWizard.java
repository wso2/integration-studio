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
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;

/**
 * Class responsible for creation of wizard for mock service resource headers.
 */
public class HeaderCreationWizard extends Wizard implements IExportWizard {

    private final String WINDOW_TITLE = "Add Header for the Resource";

    private HeaderDetailPage headerDetailPage;
    private boolean initError = false;
    private final String REQUEST = "REQUEST";
    private String requestHeaderType;

    private MockService serviceResourceHolder;

    /**
     * Class constructor.
     */
    public HeaderCreationWizard(MockService resourceHolder, String headerType) {
        this.serviceResourceHolder = resourceHolder;
        this.requestHeaderType = headerType;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);

        headerDetailPage = new HeaderDetailPage(workbench, selection, serviceResourceHolder, requestHeaderType);
    }

    @Override
    public boolean performFinish() {
        if (headerDetailPage.isPageDirty()) {
            return false;
        }

        String headerName = headerDetailPage.getHeaderName();
        String headerValue = headerDetailPage.getHeaderValue();

        if (requestHeaderType.equals(REQUEST)) {
            if (!serviceResourceHolder.isMockServiceRequestHeaderUpdate()) {
                serviceResourceHolder.addTemporalRequestHeaders(headerName, headerValue);
            } else if (!serviceResourceHolder.isMockServiceResourceUpdate()
                    && serviceResourceHolder.isMockServiceRequestHeaderUpdate()) {
                String oldHeaderName = serviceResourceHolder.getSelectedRequestHeaderKey();
                serviceResourceHolder.getTemporalRequestHeaders().remove(oldHeaderName);
                serviceResourceHolder.addTemporalRequestHeaders(headerName, headerValue);
            } else if (serviceResourceHolder.isMockServiceResourceUpdate()
                    && serviceResourceHolder.isMockServiceRequestHeaderUpdate()) {
                String oldHeaderName = serviceResourceHolder.getSelectedRequestHeaderKey();
                String resourceKey = serviceResourceHolder.getSelectedMockResourceKey();
                MockServiceResource resource = serviceResourceHolder.getMockResource(resourceKey);

                if (resource.getRequestHeaders().containsKey(oldHeaderName)) {
                    resource.removeRequestHeader(oldHeaderName);
                    resource.addRequestHeaders(headerName, headerValue);
                } else {
                    serviceResourceHolder.removeTemporalRequestHeaders(oldHeaderName);
                    serviceResourceHolder.addTemporalRequestHeaders(headerName, headerValue);
                }
            }
        } else {
            if (!serviceResourceHolder.isMockServiceResponseHeaderUpdate()) {
                serviceResourceHolder.addTemporalResponseHeaders(headerName, headerValue);
            } else if (!serviceResourceHolder.isMockServiceResourceUpdate()
                    && serviceResourceHolder.isMockServiceResponseHeaderUpdate()) {
                String oldHeaderName = serviceResourceHolder.getSelectedResponseHeaderKey();
                serviceResourceHolder.getTemporalResponseHeaders().remove(oldHeaderName);
                serviceResourceHolder.addTemporalResponseHeaders(headerName, headerValue);
            } else if (serviceResourceHolder.isMockServiceResourceUpdate()
                    && serviceResourceHolder.isMockServiceResponseHeaderUpdate()) {
                String oldHeaderName = serviceResourceHolder.getSelectedResponseHeaderKey();
                String resourceKey = serviceResourceHolder.getSelectedMockResourceKey();
                MockServiceResource resource = serviceResourceHolder.getMockResource(resourceKey);

                if (resource.getResponseHeaders().containsKey(oldHeaderName)) {
                    resource.removeResponseHeader(oldHeaderName);
                    resource.addResponseHeaders(headerName, headerValue);
                } else {
                    serviceResourceHolder.removeTemporalResponseHeaders(oldHeaderName);
                    serviceResourceHolder.addTemporalResponseHeaders(headerName, headerValue);
                }
            }
        }
        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(headerDetailPage);
            super.addPages();
        }
    }
}
