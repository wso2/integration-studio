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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_COMMAND_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_EVENT_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_HOST_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_SERVER_LOCATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEBUG_PROFILE_INTERNAL_RUNNING_MODE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEBUG_PROFILE_REMOTE_RUNNING_MODE;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

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
public class DebuggerConfigTab extends AbstractLaunchConfigurationTab {
    private static final String EMPTY_STRING = "";
    private Text commandPort;
    private Text eventPort;
    private Text hostName;
    private Combo debugModeCombo;
    String hostNameString;
    String debugModeString;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Initializes the launch configuration with default values for the tab.
     * <p>
     * This method is called when a new launch configuration is created this method
     * may be called before this tab's control is created.
     */
    @Override
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

        try {
            hostNameString = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.error("Error while reading local host name", e);
            hostNameString = DEFAULT_HOST_NAME;
        }
        configuration.setAttribute(ESB_SERVER_LOCATION, EMPTY_STRING);
        configuration.setAttribute(Messages.DebuggerConfigTab_CommandPortLabel, DEFAULT_COMMAND_PORT);
        configuration.setAttribute(Messages.DebuggerConfigTab_EventPortLabel, DEFAULT_EVENT_PORT);
        configuration.setAttribute(Messages.DebuggerConfigTab_ServerHostName, hostNameString);
        configuration.setAttribute(Messages.DebuggerConfigTab_DebuggerMode, DEBUG_PROFILE_INTERNAL_RUNNING_MODE);
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
        try {
            hostNameString = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.error("Error while reading local host name", e);
            hostNameString = DEFAULT_HOST_NAME;
        }
        String tempConfigValue = getAttribute(launchConfig, Messages.DebuggerConfigTab_CommandPortLabel,
                DEFAULT_COMMAND_PORT);
        commandPort.setText(tempConfigValue);
        tempConfigValue = getAttribute(launchConfig, Messages.DebuggerConfigTab_EventPortLabel, DEFAULT_EVENT_PORT);
        eventPort.setText(tempConfigValue);
        tempConfigValue = getAttribute(launchConfig, Messages.DebuggerConfigTab_ServerHostName, hostNameString);
        hostName.setText(tempConfigValue);
        debugModeString = getAttribute(launchConfig, Messages.DebuggerConfigTab_DebuggerMode,
                DEBUG_PROFILE_INTERNAL_RUNNING_MODE);
        debugModeCombo.setText(debugModeString);

    }

    /**
     * Copies values from this tab into the given launch configuration.
     */
    @Override
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {

        configuration.setAttribute(Messages.DebuggerConfigTab_CommandPortLabel, commandPort.getText().toString());
        configuration.setAttribute(Messages.DebuggerConfigTab_EventPortLabel, eventPort.getText().toString());
        configuration.setAttribute(Messages.DebuggerConfigTab_ServerHostName, hostName.getText().toString());
        configuration.setAttribute(Messages.DebuggerConfigTab_DebuggerMode, debugModeCombo.getText().toString());

    }

    /**
     * Returns whether this tab is in a valid state in the context of the specified
     * launch configuration.
     * <p>
     * This information is typically used by the launch configuration dialog to
     * decide when it is okay to launch.
     * 
     * @return boolean Whether this tab is in a valid state
     */
    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {

        if (isValidHostName(hostName.getText())) {
            try {
                Integer.parseInt(commandPort.getText());
                Integer.parseInt(eventPort.getText());
                setErrorMessage(null);
                return true;
            } catch (NumberFormatException e) {
                setErrorMessage(Messages.DebuggerConfigTab_IntegerPortValueValidationErrorMessage);
                return false;
            }
        } else {
            setErrorMessage("Invalid host name address");
            return false;
        }
    }

    private boolean isValidHostName(String hostName) {
        return true;
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
     * @return the message for this tab which gives information to user.
     */
    @Override
    public String getMessage() {
        return Messages.DebuggerConfigTab_MainMessage;
    }

    /**
     * @return the name of this tab.
     */
    @Override
    public String getName() {
        return Messages.DebuggerConfigTab_MainTitle;
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
        Composite topControl = new Composite(parent, SWT.NONE);
        topControl.setLayout(new GridLayout(1, false));

        Group commandGroup = new Group(topControl, SWT.NONE);
        commandGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        commandGroup.setText(Messages.DebuggerConfigTab_CommandPortLabel);
        commandGroup.setLayout(new GridLayout(2, false));

        commandPort = new Text(commandGroup, SWT.BORDER);
        commandPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        commandPort.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent modifyEvent) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
        });

        Group eventGroup = new Group(topControl, SWT.NONE);
        eventGroup.setLayout(new GridLayout(2, false));
        eventGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        eventGroup.setText(Messages.DebuggerConfigTab_EventPortLabel);

        eventPort = new Text(eventGroup, SWT.BORDER);
        eventPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        eventPort.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent modifyEvent) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
        });

        Group hostGroup = new Group(topControl, SWT.NONE);
        hostGroup.setLayout(new GridLayout(2, false));
        hostGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        hostGroup.setText(Messages.DebuggerConfigTab_ServerHostName);

        hostName = new Text(hostGroup, SWT.BORDER);
        hostName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        hostName.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent modifyEvent) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
        });

        Group debugModeGroup = new Group(topControl, SWT.NONE);
        debugModeGroup.setLayout(new GridLayout(2, false));
        debugModeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        debugModeGroup.setText(Messages.DebuggerConfigTab_DebuggerMode);

        String[] availableDebugModes = new String[] { DEBUG_PROFILE_INTERNAL_RUNNING_MODE,
                DEBUG_PROFILE_REMOTE_RUNNING_MODE };
        // Create a drop-down Combo & Read only
        debugModeCombo = new Combo(debugModeGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
        debugModeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        debugModeCombo.setItems(availableDebugModes);
        debugModeCombo.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                if(debugModeCombo.getText().equals(DEBUG_PROFILE_INTERNAL_RUNNING_MODE)) {
                    eventPort.setText(DEFAULT_EVENT_PORT);
                    commandPort.setText(DEFAULT_COMMAND_PORT);
                    hostName.setEnabled(false);
                    eventPort.setEnabled(false);
                    commandPort.setEnabled(false);
                }else {
                    hostName.setEnabled(true);
                    eventPort.setEnabled(true);
                    commandPort.setEnabled(true);
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
        });

        // Disable all the setting for default internal mode
        hostName.setEnabled(false);
        eventPort.setEnabled(false);
        commandPort.setEnabled(false);
        
        setControl(topControl);
    }

    private String getAttribute(ILaunchConfiguration configuration, String name, String defaultValue) {
        try {
            return configuration.getAttribute(name, defaultValue);
        } catch (CoreException ex) {
            log.error("Error while reading the attribute " + name + " from launch configuration : " + ex.getMessage(),
                    ex);
        }
        return defaultValue;
    }
}
