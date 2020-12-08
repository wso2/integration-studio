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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;
import org.wso2.developerstudio.eclipse.carbon.server.model.Activator;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public abstract class ConfigurationOtherCommonEditorSection extends ServerEditorSection {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private Button startWSASCheck;
	private Button hotupdateCheck;

	private Button osgiConsoleCheck;

	/**
	 * ConfigurationPortEditorSection constructor comment.
	 */
	public ConfigurationOtherCommonEditorSection() {
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
		section.setText("Other");
		section.setDescription("Other settings.");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

		// ports
		Composite composite = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 8;
		layout.marginWidth = 8;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		startWSASCheck =
		                 toolkit.createButton(composite,
		                                      "Bring up the carbon console in the browser once the server starts.",
		                                      SWT.CHECK);
		startWSASCheck.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				CarbonServerCommonUtils.setServerStartBrowserPopup(server.getOriginal(), startWSASCheck.getSelection());
			}
		});

		hotupdateCheck = toolkit.createButton(composite, "Enable hot update (may require server restart).", SWT.CHECK);
		hotupdateCheck.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				CarbonServerCommonUtils.setServerHotUpdate(server.getOriginal(), hotupdateCheck.getSelection());
			}

		});

		osgiConsoleCheck = toolkit.createButton(composite, "Enable OSGi console (requires server restart).", SWT.CHECK);
		osgiConsoleCheck.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				CarbonServerCommonUtils.setServerStartWithOSGiConsole(server.getOriginal(), osgiConsoleCheck.getSelection());
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
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				while (true) {
					Boolean serverConfigMapValue = CarbonServerCommonUtils.isServerStartBrowserPopup(server.getOriginal());
					if (serverConfigMapValue == null) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							log.error(e);
						}
						continue;
					}
					boolean startWSASBrowser = serverConfigMapValue;
					boolean enableAxis2Hotupdate = CarbonServerCommonUtils.isServerHotUpdate(server.getOriginal());
					boolean enableOSGIConsole = CarbonServerCommonUtils.isServerStartWithOSGiConsole(server.getOriginal());
					if (startWSASCheck != null) {
						startWSASCheck.setSelection(startWSASBrowser);
						startWSASCheck.setEnabled(!readOnly);
					}
					if (hotupdateCheck != null) {
						hotupdateCheck.setSelection(enableAxis2Hotupdate);
						hotupdateCheck.setEnabled(!readOnly);
					}
					if (osgiConsoleCheck != null) {
						osgiConsoleCheck.setSelection(enableOSGIConsole);
						osgiConsoleCheck.setEnabled(!readOnly);
					}
					break;
				}
			}
		});
	}
}
