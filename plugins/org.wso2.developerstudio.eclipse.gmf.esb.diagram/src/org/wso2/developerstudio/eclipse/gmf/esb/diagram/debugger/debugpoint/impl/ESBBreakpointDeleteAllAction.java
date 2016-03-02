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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureEsbNodeAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This class extends the {@link ConfigureEsbNodeAction} to execute the
 * operation of enable/disable ESbBreakpoints
 * 
 */
public class ESBBreakpointDeleteAllAction extends ConfigureEsbNodeAction {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Creates a new {@link ESBBreakpointDeleteAllAction} instance.
     * 
     * @param part
     *            {@link IWorkbenchPart} instance.
     */
    public ESBBreakpointDeleteAllAction(IWorkbenchPart part) {
        super(part);
        super.init();
        setId(ESB_BREAKPOINT_DELETE_ALL_ACTION_ID);
        setText(ESB_BREAKPOINT_DELETE_ALL_COMMAND_LABEL);
        setToolTipText(ESB_BREAKPOINT_DELETE_ALL_COMMAND_TOOL_TIP);
        ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
        setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
        setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
        setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
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
     * This method performs the action when click the menu item Enable/Disable
     * ESB Breakpoints
     */
    @Override
    protected void doRun(IProgressMonitor progressMonitor) {
        try {
            ESBDebuggerUtil.removeAllESBDebugPointsFromDebugPointManager();
        } catch (ESBDebuggerException e) {
            log.error("Error while removing debugpoints from ESB Server", e);
        }
    }

}
