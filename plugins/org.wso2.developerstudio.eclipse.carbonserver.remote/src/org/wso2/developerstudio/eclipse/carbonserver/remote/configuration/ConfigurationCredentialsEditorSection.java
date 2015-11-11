/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.remote.configuration;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;
import org.wso2.developerstudio.eclipse.carbonserver.remote.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonServer;
import org.wso2.developerstudio.eclipse.carbonserver.remote.ui.RemoteServerCredentialDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ConfigurationCredentialsEditorSection extends ServerEditorSection {
	Text usernameText;

	String username;
	private RemoteCarbonServer remoteCarbonServer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	protected boolean updating;

	/**
	 * ConfigurationPortEditorSection constructor comment.
	 */
	public ConfigurationCredentialsEditorSection() {
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
		remoteCarbonServer = (RemoteCarbonServer) server.loadAdapter(RemoteCarbonServer.class, null);
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());

		Section section =
		                  toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED |
		                                                ExpandableComposite.TITLE_BAR | Section.DESCRIPTION |
		                                                ExpandableComposite.FOCUS_TITLE);
		section.setText("Credentials");
		section.setDescription("Credentials to authenticate with the Carbon Admin Services");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

		// ports
		final Composite composite = toolkit.createComposite(section);
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
		String givenUName = remoteCarbonServer.getUsername();
		usernameText.setText(givenUName);
		usernameText.setEditable(false);

		usernameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setUsername(usernameText.getText().trim());
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
	}

}
