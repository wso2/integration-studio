/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver31.configuration;

import java.beans.PropertyChangeListener;

import org.eclipse.jface.viewers.TableViewer;
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
import org.wso2.developerstudio.eclipse.carbonserver31.Activator;
import org.wso2.developerstudio.eclipse.carbonserver31.util.CarbonServer31Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ConfigurationOtherEditorSection extends ServerEditorSection{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private Button startWSASCheck;
	private Button hotupdateCheck;
//	FileMonitor axis2FileMonitor;
//	private boolean axis2FileChanged=false;
//	private int axis2FileChangeCheckDelay=5000;
	
	private Button osgiConsoleCheck;

	/**
	 * ConfigurationPortEditorSection constructor comment.
	 */
	public ConfigurationOtherEditorSection() {
		super();
	}

	
	/**
	 * Creates the SWT controls for this workbench part.
	 *
	 * @param parent the parent control
	 */
	public void createSection(Composite parent) {
		super.createSection(parent);
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());
		
		Section section = toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED
			| ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | ExpandableComposite.FOCUS_TITLE);
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
		startWSASCheck = toolkit.createButton(composite,"Bring up the carbon console in the browser once the server starts.", SWT.CHECK );
		startWSASCheck.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent arg0) {
				CarbonServer31Utils.setServerStartBrowserPopup(server.getOriginal(),startWSASCheck.getSelection());
			}
		});

		hotupdateCheck = toolkit.createButton(composite,"Enable hot update (may require server restart).", SWT.CHECK );
		hotupdateCheck.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent arg0) {
				CarbonServer31Utils.setServerHotUpdate(server.getOriginal(), hotupdateCheck.getSelection());
			}
			
		});
		
		osgiConsoleCheck = toolkit.createButton(composite,"Enable OSGi console (requires server restart).", SWT.CHECK );
		osgiConsoleCheck.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent arg0) {
				CarbonServer31Utils.setServerStartWithOSGiConsole(server.getOriginal(),osgiConsoleCheck.getSelection());
			}
		});
		
//		axis2FileMonitor = new FileMonitor(CarbonServer31Utils.getAxis2FilePath(server.getOriginal()));
//		axis2FileMonitor.addFileStatusListener(new IFileStatusListener(){
//			public void fileChanged(File file, long lastModified,
//					long newModified) {
//				axis2FileChanged=true;
////				hotupdateAxis2Check.setSelection(WSASServer31Utils.isHotUpdateEnabled(server.getOriginal()));
//			}
//
//			public void fileCreated(File file, long createTime) {
//			}
//
//			public void fileDeleted(File file, long deleteTime) {
//			}
//		});
//		Timer timer = new Timer();
//		TimerTask task = new TimerTask(){
//			
//			public void run() {
//				if (axis2FileChanged){
//					axis2FileChanged=false;
//					if (hotupdateAxis2Check!=null) hotupdateAxis2Check.setSelection(WSASServer31Utils.isHotUpdateEnabled(server.getOriginal()));
//				}
//			}
//			
//		};
//		timer.schedule(task, 5000,5000);
//		getShell().getDisplay().timerExec(axis2FileChangeCheckDelay, this);
		initialize();
	}

//	public void run() {
//		if (axis2FileChanged){
//			axis2FileChanged=false;
//			if (hotupdateCheck!=null) hotupdateCheck.setSelection(CarbonServer31Utils.isHotUpdateEnabled(server.getOriginal()));
//		}
//		getShell().getDisplay().timerExec(axis2FileChangeCheckDelay, this);
//	} 
	
	public void dispose() {
//		axis2FileMonitor.stopMonitoring();
	}
	
	/* (non-Javadoc)
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
		Display.getDefault().asyncExec(new Runnable(){
            public void run() {
            	while(true){
            		Boolean serverConfigMapValue = CarbonServer31Utils.isServerStartBrowserPopup(server.getOriginal());
            		if (serverConfigMapValue==null){
            			try {
	                        Thread.sleep(2000);
                        } catch (InterruptedException e) {
	                        log.error(e);
                        }
            			continue;
            		}
            		boolean startWSASBrowser=serverConfigMapValue;
            		boolean enableAxis2Hotupdate=CarbonServer31Utils.isServerHotUpdate(server.getOriginal());
            		boolean enableOSGIConsole=CarbonServer31Utils.isServerStartWithOSGiConsole(server.getOriginal());
            		if (startWSASCheck!=null) {
            			startWSASCheck.setSelection(startWSASBrowser);
            			startWSASCheck.setEnabled(!readOnly);
            		}
            		if (hotupdateCheck!=null) {
            			hotupdateCheck.setSelection(enableAxis2Hotupdate);
            			hotupdateCheck.setEnabled(!readOnly);
            		}
            		if (osgiConsoleCheck!=null) {
            			osgiConsoleCheck.setSelection(enableOSGIConsole);
            			osgiConsoleCheck.setEnabled(!readOnly);
            		}
//            		if (axis2FileMonitor!=null) axis2FileMonitor.startMonitoring();
            		break;
            	}
            }
		});
	}
}
