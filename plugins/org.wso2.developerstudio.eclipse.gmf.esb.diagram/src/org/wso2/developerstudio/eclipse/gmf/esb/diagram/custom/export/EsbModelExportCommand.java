/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.export;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbModelTransformer;

/**
 * Command responsible for exporting ESB visual model.
 */
public class EsbModelExportCommand extends Command {
	/**
	 * Current resource being edited.
	 */
	private Resource resource;	
	
	/**
	 * Constructs a new {@link EsbModelExportCommand}.
	 * 
	 * @param resource current {@link Resource} being edited.
	 */
	public EsbModelExportCommand(Resource resource) {
		super("export-esb-visual-model");
		this.resource = resource;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean canExecute() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canUndo() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void execute() {
		// TODO: Open file browser.
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setFilterExtensions(new String [] {"*.xml"});
		String filePath = fileDialog.open();
		
		// TODO: Use StringUtils.isBlank() instead.
		if (null != filePath) {			
			try {
				File exportFile = new File(filePath);
				EsbModelTransformer.instance.export(resource, exportFile);
			} catch (Exception ex) {
				// TODO: Log.
				ex.printStackTrace();
			}
		}		
	}
}
