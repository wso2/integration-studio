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

import org.apache.commons.lang.StringUtils;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

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
	private Text commandPort;
	private Text eventPort;

	public DebuggerConfigTab() {
	}

	/**
	 * Initializes the launch configuration with default values for the tab.
	 * <p>
	 * This method is called when a new launch configuration is created this
	 * method may be called before this tab's control is created.
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ESB_SERVER_LOCATION, ""); //$NON-NLS-1$
		configuration.setAttribute(Messages.DebuggerConfigTab_CommandPortLabel,
				DEFAULT_COMMAND_PORT);
		configuration.setAttribute(Messages.DebuggerConfigTab_EventPortLabel,
				DEFAULT_EVENT_PORT);
	}

	/**
	 * Initializes this tab's controls with values from the given launch
	 * configuration.
	 * <p>
	 * This method is called when a configuration is selected to view or edit,
	 * after this tab's control has been created.
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration launchConfig) {
		if (StringUtils.isEmpty(commandPort.getText())) {
			commandPort.setText(DEFAULT_COMMAND_PORT);
		}
		if (StringUtils.isEmpty(eventPort.getText())) {
			eventPort.setText(DEFAULT_EVENT_PORT);
		}
	}

	/**
	 * Copies values from this tab into the given launch configuration.
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		configuration.setAttribute(Messages.DebuggerConfigTab_CommandPortLabel,
				commandPort.getText().toString());
		configuration.setAttribute(Messages.DebuggerConfigTab_EventPortLabel,
				eventPort.getText().toString());
	}

	/**
	 * Returns whether this tab is in a valid state in the context of the
	 * specified launch configuration.
	 * <p>
	 * This information is typically used by the launch configuration dialog to
	 * decide when it is okay to launch.
	 * 
	 * @return boolean Whether this tab is in a valid state
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {

		try {
			Integer.parseInt(commandPort.getText());
			Integer.parseInt(eventPort.getText());
			setErrorMessage(null);
			return true;
		} catch (NumberFormatException e) {
			setErrorMessage(Messages.DebuggerConfigTab_IntegerPortValueValidationErrorMessage);
			return false;
		}

	}

	/**
	 * @return whether this tab is in a state that allows the launch
	 *         configuration whose values this tab is showing to be saved.
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

		Group mainGroup = new Group(topControl, SWT.NONE);
		mainGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		mainGroup.setText(Messages.DebuggerConfigTab_CommandPortLabel); //$NON-NLS-1$
		mainGroup.setLayout(new GridLayout(2, false));

		commandPort = new Text(mainGroup, SWT.BORDER);
		commandPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group groupLaunch = new Group(topControl, SWT.NONE);
		groupLaunch.setLayout(new GridLayout(2, false));
		groupLaunch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		groupLaunch.setText(Messages.DebuggerConfigTab_EventPortLabel); //$NON-NLS-1$

		eventPort = new Text(groupLaunch, SWT.BORDER);
		eventPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		setControl(topControl);
	}
}
