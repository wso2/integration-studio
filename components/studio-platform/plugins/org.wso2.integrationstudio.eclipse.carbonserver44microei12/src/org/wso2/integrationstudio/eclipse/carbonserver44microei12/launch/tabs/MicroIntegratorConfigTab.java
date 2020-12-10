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

package org.wso2.integrationstudio.eclipse.carbonserver44microei12.launch.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.widgets.Composite;

/**
 * This class is extended from {@link AbstractLaunchConfigurationTab} and used
 * to edit/view attributes of ESB Mediation Debugger launch configuration.
 * 
 * <p>
 * This class implements the following life-cycle methods:
 * 
 * <p>
 * <u1>
 * <li>initializeFrom(ILaunchConfiguration)</li>
 * <li>performApply(ILaunchConfigurationWorkingCopy)</li>
 * <li>initializeFrom(ILaunchConfiguration)</li> </u1>
 * 
 */
public class MicroIntegratorConfigTab extends AbstractLaunchConfigurationTab {

    /**
     * Initializes the launch configuration with default values for the tab.
     * <p>
     * This method is called when a new launch configuration is created this method
     * may be called before this tab's control is created.
     */
    @Override
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

    }

    /**
     * Initializes this tab's controls with values from the given launch
     * configuration.
     * <p>
     * This method is called when a configuration is selected to view or edit, after
     * this tab's control has been created.
     */
    @Override
    public void initializeFrom(ILaunchConfiguration launchConfig) {
    }

    /**
     * Copies values from this tab into the given launch configuration.
     */
    @Override
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
    }

    /**
     * @return whether this tab is in a state that allows the launch configuration
     *         whose values this tab is showing to be saved.
     */
    @Override
    public boolean canSave() {
        return isDirty();
    }

    /**
     * Creates the top level control for the launch configuration tab under the
     * given parent composite.
     * 
     * <p>
     * This method is called once on tab creation, after
     * setLaunchConfigurationDialog is called.
     */
    @Override
    public void createControl(Composite parent) {
    }

    @Override
    public String getName() {
        return "Micro Integrator Run";
    }

}
