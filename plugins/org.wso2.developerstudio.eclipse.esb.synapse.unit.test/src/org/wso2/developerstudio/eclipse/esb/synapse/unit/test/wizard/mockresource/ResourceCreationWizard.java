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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockresource;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;

/**
 * Class responsible for creation of wizard for mock service resources.
 */
public class ResourceCreationWizard extends Wizard implements IExportWizard {

    private final String WINDOW_TITLE = "Add Resource for the Mock Service";

    private ResourcesRequestDetailPage resourceRequestDetailPage;
    private ResourcesResponseDetailPage resourceResponseDetailPage;
    private MockService serviceResourceHolder;

    private String EMPTY_STRING = "";
    private String SPACE_STRING = " ";
    private String serviceContext = EMPTY_STRING;
    private boolean initError = false;

    /**
     * Class constructor.
     */
    public ResourceCreationWizard(MockService mockService, String serviceContext) {
        serviceResourceHolder = mockService;
        serviceResourceHolder.clearAllTemporalDataHolders();
        this.serviceContext = serviceContext;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        resourceRequestDetailPage = new ResourcesRequestDetailPage(workbench, selection, serviceResourceHolder,
                serviceContext);
        resourceResponseDetailPage = new ResourcesResponseDetailPage(workbench, selection, serviceResourceHolder);
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == resourceResponseDetailPage
                && getContainer().getCurrentPage().isPageComplete()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean performFinish() {
        if (resourceResponseDetailPage.isPageDirty()) {
            return false;
        }

        String subContext = resourceRequestDetailPage.getServiceSubContext();
        String requestPayload = resourceRequestDetailPage.getServiceRequestPayload();
        if (requestPayload != null && !requestPayload.isEmpty()) {
            requestPayload = CommonUtil.addCDATATagToPayloads(requestPayload);
        }
        String method = resourceRequestDetailPage.getServiceMethod();
        String responsePayload = resourceResponseDetailPage.getServiceResponsePayload();
        if (responsePayload != null) {
            responsePayload = CommonUtil.addCDATATagToPayloads(responsePayload);
        } else {
            responsePayload = "";
            responsePayload = CommonUtil.addCDATATagToPayloads(responsePayload);
        }
        int statusCode = Integer.parseInt(resourceResponseDetailPage.getStatusCode().split(SPACE_STRING)[0]);
        LinkedHashMap<String, String> requestHeaders = serviceResourceHolder.getTemporalRequestHeaders();
        LinkedHashMap<String, String> responseHeaders = serviceResourceHolder.getTemporalResponseHeaders();

        if (!serviceResourceHolder.isMockServiceResourceUpdate()) {
            MockServiceResource resource = new MockServiceResource();
            resource.setSubContext(subContext);
            resource.setRequestPayload(requestPayload);
            resource.setMethod(method);
            resource.setResponsePayload(responsePayload);
            resource.setStatusCode(statusCode);

            for (Map.Entry<String, String> request : requestHeaders.entrySet()) {
                resource.addRequestHeaders(request.getKey(), request.getValue());
            }

            for (Map.Entry<String, String> response : responseHeaders.entrySet()) {
                resource.addResponseHeaders(response.getKey(), response.getValue());
            }

            serviceResourceHolder.addMockResources(subContext + method, resource);
        } else {
            String resourceKey = serviceResourceHolder.getSelectedMockResourceKey();
            MockServiceResource selectedResource = serviceResourceHolder.getMockResource(resourceKey);
            selectedResource.setSubContext(subContext);
            selectedResource.setRequestPayload(requestPayload);
            selectedResource.setMethod(method);
            selectedResource.setResponsePayload(responsePayload);
            selectedResource.setStatusCode(statusCode);

            for (Map.Entry<String, String> request : requestHeaders.entrySet()) {
                selectedResource.addRequestHeaders(request.getKey(), request.getValue());
            }

            for (Map.Entry<String, String> response : responseHeaders.entrySet()) {
                selectedResource.addResponseHeaders(response.getKey(), response.getValue());
            }

            serviceResourceHolder.removeMockResource(resourceKey);
            serviceResourceHolder.addMockResources(subContext + method, selectedResource);
        }

        return true;
    }

    @Override
    public IWizardPage getNextPage(IWizardPage currentPage) {
        if (currentPage == resourceRequestDetailPage && resourceRequestDetailPage.isPageComplete()) {
            return resourceResponseDetailPage;
        }
        return null;
    }

    public void addPages() {
        if (!initError) {
            addPage(resourceRequestDetailPage);
            addPage(resourceResponseDetailPage);
            super.addPages();
        }
    }
}
