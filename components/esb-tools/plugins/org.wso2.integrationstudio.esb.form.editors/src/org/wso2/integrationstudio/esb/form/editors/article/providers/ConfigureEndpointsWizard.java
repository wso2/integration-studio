/*
 * Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.integrationstudio.esb.form.editors.article.providers;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.endpoints.TemplateEndpointFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

public class ConfigureEndpointsWizard extends Wizard implements IExportWizard {

    private ConfigureEndpointDialog endpointDialog;
    private EndpointTableEntry endpointTableEntry;
    private boolean initError = true;
    private boolean isFinish = false;
    private boolean isEdit = false;

    public ConfigureEndpointsWizard(Shell shell) {

    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        if (!isEdit) {
            endpointDialog = new ConfigureEndpointDialog("");
        } else {
            endpointDialog = new ConfigureEndpointDialog("", this.endpointTableEntry);
            isEdit = false;
        }
        initError = false;
    }

    @Override
    public boolean performFinish() {

        String endpointType = endpointDialog.getEndpointType();

        if (endpointType.equals("INLINE")) {
            String endpointConfig = endpointDialog.getInlineEndpoint();
            OMElement element = null;
            try {
                element = AXIOMUtil.stringToOM(endpointConfig);
                ComplexEndpointWizardUtils.removeIndentations(element);
                OMElement tempElement = element.cloneOMElement();
                ComplexEndpointWizardUtils.setNamespaceForChildren(tempElement);
                if (tempElement.getLocalName().equals("endpoint") 
                		&& tempElement.getAttribute(new QName("template")) != null) {
                	TemplateEndpointFactory.getEndpointFromElement(tempElement, false, null);
                } else {
                	EndpointFactory.getEndpointFromElement(tempElement, false, null);
                }

            } catch (Exception e) {
                ComplexEndpointWizardUtils.openMessageBox(getShell(), "Endpoint Error",
                        "An error occured while creating the endpoint configuration.\n", SWT.ICON_ERROR);
            }
            endpointTableEntry = new EndpointTableEntry(true, element.toString());
        } else {
            String endpointName = endpointDialog.getStaticEndpoint();
            endpointTableEntry = new EndpointTableEntry(false, endpointName);
        }
        isFinish = true;
        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(endpointDialog);
            super.addPages();
        }
    }

    public ConfigureEndpointDialog getEndpointDialog() {
        return endpointDialog;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public EndpointTableEntry getEndpointTableEntry() {
        return this.endpointTableEntry;
    }

    public void setEndpointTableEntry(EndpointTableEntry tableEntry) {
        this.endpointTableEntry = tableEntry;
    }

    public void setIsEdit() {
        this.isEdit = true;
    }

}
