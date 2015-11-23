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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class StoreMediatorPropertyDescriptor extends DevSProjectArtifactsListPropertyDescriptor{
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String synapseNS = "http://ws.apache.org/ns/synapse";
	private Properties properties = new Properties();
	private final String TYPE_MESSAGE_STORE="synapse/message-store";
	
	private final String DEFAULT_VALUE="Select From Message Stores";
	
	public StoreMediatorPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
	
	public CellEditor createPropertyEditor(Composite parent) {		
		ArrayList<String> definedMessageStores = new ArrayList<String>();	
		definedMessageStores.add(DEFAULT_VALUE);
		File projectPath = null;
		final Object object_=this.object;
		final Shell shell=(Shell)parent.getShell();
		final IEditorPart editor=(IEditorPart) ((WorkbenchWindow)shell.getDisplay().getActiveShell().getData()).getActivePage().getActiveEditor();
		if (editor != null) {
			IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
			IFile file = input.getFile();
			IProject activeProject = file.getProject();
			//FIXME: scan whole workspace
			
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject workspaceProject : projects) {
			try {
				if (workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
					ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
					projectPath = workspaceProject.getLocation().toFile();
					try {
						esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
						List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
						for (ESBArtifact esbArtifact : allESBArtifacts) {
							if (TYPE_MESSAGE_STORE.equals(esbArtifact.getType())) {
								File artifact = new File(projectPath, esbArtifact.getFile());
								definedMessageStores.add(artifact.getName().replaceAll("[.]xml$", ""));
							}
							
						}
					} catch (Exception e) {
						log.error("Error occured while scanning the project for artifacts", e);
						ErrorDialog.openError(shell,"Error occured while scanning the project for artifacts", e.getMessage(), null);
					}
				}
			} catch (CoreException e) {
				log.error("Error occured while scanning the project", e);
				ErrorDialog.openError(shell,"Error occured while scanning the project", e.getMessage(), null);
			}
			}
		}
		final File projectPath_ =projectPath;
		
		/*
		 * A custom comboBox control which has available templates in its list will be returned.   
		 */
		return new ExtendedComboBoxCellEditor(parent,definedMessageStores,getLabelProvider()){	
			/*
			 * The purpose of overriding this 'focusLost' method is to fill the parameters dialog of the callTemplate mediator
			 * with parameters of the selected template.  
			 */
			protected void focusLost() {
				super.focusLost();
				TransactionalEditingDomain editingDomain=null;
				editingDomain =((EsbMultiPageEditor)editor).getGraphicalEditor().getEditingDomain();
				if(!DEFAULT_VALUE.equals(getValue().toString())){				
					SetCommand setCmd = new SetCommand(editingDomain, (EObject) object_,
							EsbPackage.Literals.STORE_MEDIATOR__MESSAGE_STORE, getValue().toString());
					if (setCmd.canExecute()) {
						editingDomain.getCommandStack().execute(setCmd);
					}		
			}			
			}
};
	}
}

