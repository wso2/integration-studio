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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch.tabs;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTabGroup;

/**
 * This class extends {@link ILaunchConfigurationTabGroup} and is used to
 * edit/view attributes of ESB Mediation Debugger launch configuration.
 * 
 * <p>
 * Launch configurations are presented in a Debug Configuration dialog with a tab folder. Each tab manipulates one or
 * more attributes of the launch configuration.
 * 
 * <p>
 * Launch configuration group extension is defined in plugin.xml of the plug-in.
 * 
 * <pre>
 * {@code   
 *     <extension
 *          point="org.eclipse.debug.ui.launchConfigurationTabGroups">
 *       <launchConfigurationTabGroup
 *             class="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch.tabs.LaunchConfigurationTabGroup"
 *             id="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch.tabgroup"
 *             type="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch">
 *          <launchMode
 *                mode="debug">
 *          </launchMode>
 *       </launchConfigurationTabGroup>
 *    </extension>
 * }
 * </pre>
 * 
 * <p>
 * <u1> The attributes are specified as follows:
 * <p>
 * <u1>
 * <li>id :A unique identifier for this launch configuration tab group.</li>
 * <li>type :Launch configuration type that this tab group is applicable to (corresponds to the id of a launch
 * configuration type extension).</li>
 * <li>class :specifies a fully qualified name of a Java class that implements ILaunchConfigurationTabGroup.</li> </u1>
 * </u1>
 */
public class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

    /**
     * This method creates the tabs contained in ESB Mediaton Debugger launch
     * mode. {@link DebuggerConfigTab} and {@link CommonTab} are created by this
     * method.
     * 
     * <p>
     * The tabs control's are not created. This is the fist method called in the life-cycle of a tab group.
     * 
     * @param dialog
     *            the launch configuration dialog this tab group is contained in
     * @param mode
     *            the mode the launch configuration dialog was opened in
     */
    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        setTabs(new ILaunchConfigurationTab[] { new DebuggerConfigTab(), new CommonTab() });
    }
}
