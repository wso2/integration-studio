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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_SHOW_WIRE_LOGS_ACTION_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_SHOW_WIRE_LOGS_COMMAND_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_SHOW_WIRE_LOGS_COMMAND_TOOL_TIP;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_STACK_FRAME_WIRE_LOGS_RECEIVED_EVENT;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureEsbNodeAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonObject;

/**
 * A {@link AbstractActionHandler} used to hook-up action for set and clear
 * breakpoints in esb design view editor.
 */
public class ESBShowWireLogsAction extends ConfigureEsbNodeAction {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private IEventBroker wirelLogsReceiveEB;

    /**
     * Creates a new {@link ESBBreakpointAction} instance.
     * 
     * @param part
     *            {@link IWorkbenchPart} instance.
     */
    public ESBShowWireLogsAction(IWorkbenchPart part) {
        super(part);
        super.init();
        setId(ESB_SHOW_WIRE_LOGS_ACTION_ID);
        setText(ESB_SHOW_WIRE_LOGS_COMMAND_LABEL);
        setToolTipText(ESB_SHOW_WIRE_LOGS_COMMAND_TOOL_TIP);
        ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
        setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
        setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
        setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
        wirelLogsReceiveEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
    }

    /**
     * Utility method for retrieving the currently selected {@link EditPart}.
     * 
     * @return current selected {@link EditPart} or null if multiple edit parts
     *         or no edit parts are selected.
     */
    @Override
    protected EditPart getSelectedEditPart() {
        IStructuredSelection selection = getStructuredSelection();
        if (selection.size() == 1) {
            Object selectedEP = selection.getFirstElement();
            if (selectedEP instanceof EditPart) {
                return (EditPart) selectedEP;
            }
        }
        return null;
    }

    /**
     * Utility method for calculating the editing domain.
     * 
     * @return editing domain for this action.
     */
    @Override
    protected TransactionalEditingDomain getEditingDomain() {
        IWorkbenchPart part = getWorkbenchPart();

        if (part != null) {
            IEditingDomainProvider edProvider = (IEditingDomainProvider) part.getAdapter(IEditingDomainProvider.class);

            if (edProvider != null) {
                EditingDomain domain = edProvider.getEditingDomain();

                if (domain instanceof TransactionalEditingDomain) {
                    return (TransactionalEditingDomain) domain;
                }
            }
        }
        return null;
    }

    /**
     * This method performs the action when click the menu item Toggle
     * Breakpoint
     */
    @Override
    protected void doRun(IProgressMonitor progressMonitor) {
        invokeEvent();
    }

    /**
     * Helper method which will check what is selected and act accordingly
     */
    private void invokeEvent() {
        EditPart selectedEP = getSelectedEditPart();
        if (selectedEP instanceof ProxyServiceEditPart) {
            // whole proxy service selected
            String proxyKey = ((ProxyService) ((Node) selectedEP.getModel()).getElement()).getName();
            JsonObject proxyJson = new JsonObject();
            proxyJson.addProperty("mediation-component", "requestResponse");
            proxyJson.addProperty("type", "proxy");
            proxyJson.addProperty("proxy-key", proxyKey);
            wirelLogsReceiveEB.send(ESB_STACK_FRAME_WIRE_LOGS_RECEIVED_EVENT, proxyJson);
        } else if (selectedEP instanceof APIResourceEditPart) {
            // whole API selected
            JsonObject apiJson = new JsonObject();
            apiJson.addProperty("mediation-component", "requestResponse");
            apiJson.addProperty("type", "api");
            String apiKey = ((SynapseAPI) ((APIResource) ((Node) selectedEP.getModel()).getElement()).eContainer())
                    .getApiName();
            apiJson.addProperty("api-key", apiKey);
            String urlString = null;
            if (((APIResource) ((Node) selectedEP.getModel()).getElement()).getUriTemplate() != null
                    && !((APIResource) ((Node) selectedEP.getModel()).getElement()).getUriTemplate().isEmpty()) {
                urlString = ((APIResource) ((Node) selectedEP.getModel()).getElement()).getUriTemplate();
                apiJson.addProperty("restResourceUrlString", urlString);

            } else if (((APIResource) ((Node) selectedEP.getModel()).getElement()).getUrlMapping() != null
                    && !((APIResource) ((Node) selectedEP.getModel()).getElement()).getUrlMapping().isEmpty()) {
                urlString = ((APIResource) ((Node) selectedEP.getModel()).getElement()).getUrlMapping();
                apiJson.addProperty("restResourceUrlString", urlString);
            }
            wirelLogsReceiveEB.send(ESB_STACK_FRAME_WIRE_LOGS_RECEIVED_EVENT, apiJson);
        } else if (selectedEP instanceof AbstractMediator
                && ESBDebugPointTarget.canToggleDiagramDebugpoints(selectedEP)) {
            try {
                ESBDebugPointTarget.triggerWirelogRetrieveEventWithMediatorId((AbstractMediator) selectedEP,
                        wirelLogsReceiveEB);
            } catch (CoreException | ESBDebuggerException e) {
                log.error("Error while registering the breakpoint : " + e.getMessage(), e);
            }
        }
    }
}
