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

package org.wso2.developerstudio.eclipse.carbon.server.model.configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;
import org.wso2.developerstudio.eclipse.carbon.server.model.Activator;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonUtils;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICredentials;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public abstract class ConfigurationCredentialsCommonEditorSection extends ServerEditorSection {
	Text usernameText;
	Text passwordText;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private boolean updatePassword = true;

	public ConfigurationCredentialsCommonEditorSection() {
		super();
	}

	/**
	 * Creates the SWT controls for this workbench part.
	 *
	 * @param parent
	 *            the parent control
	 */
	public void createSection(Composite parent) {
		super.createSection(parent);
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());

		Section section =
		                  toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED |
		                                                ExpandableComposite.TITLE_BAR | Section.DESCRIPTION |
		                                                ExpandableComposite.FOCUS_TITLE);
		section.setText("Credentials");
		section.setDescription("Credentials to authenticate with the ESB admin services");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

		// ports
		Composite composite = toolkit.createComposite(section);
		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = 8;
		layout.marginWidth = 8;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		toolkit.createLabel(composite, "Username");
		usernameText = toolkit.createText(composite, "");
		usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		toolkit.createLabel(composite, "Password");
		passwordText = toolkit.createText(composite, "");
		passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		passwordText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				setPasswordTextBoxOnFocus();
			}

			public void focusLost(FocusEvent arg0) {
				setPasswordTextBoxOnLostFocus();
			}
		});

		usernameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				CarbonServerCommonUtils.setServerUsername(server.getOriginal(), usernameText.getText());
			}

		});
		passwordText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (updatePassword)
					CarbonServerCommonUtils.setServerPassword(server.getOriginal(), passwordText.getText());
			}

		});
		initialize();
	}

	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * Initializes the editor part with a site and input.
	 */
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		initialize();
	}

	/**
	 * Initialize the fields in this editor.
	 */
	protected void initialize() {
		if (usernameText != null && passwordText != null) {
			try {
				ICredentials serverCredentials = CarbonServerManager.getServerCredentials(server.getOriginal());
				usernameText.setText(serverCredentials.getUsername());
				setPasswordTextBoxOnLostFocus();
			} catch (Exception e) {
				log.error(e);
			}

		}
	}

	private void setPasswordTextBoxOnFocus() {
		updatePassword = false;
		passwordText.setText("");
		passwordText.setEchoChar('*');
		passwordText.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_BLACK));
		updatePassword = true;
	}

	private void setPasswordTextBoxOnLostFocus() {
		updatePassword = false;
		passwordText.setEchoChar('\0');
		passwordText.setText("[Click to change the password]");
		passwordText.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		updatePassword = true;
	}

}
