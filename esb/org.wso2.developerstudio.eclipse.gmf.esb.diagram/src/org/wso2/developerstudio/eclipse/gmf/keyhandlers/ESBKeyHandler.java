/*
 * Copyright 2014 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.keyhandlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ESBKeyHandler extends AbstractHandler {
	private static final String ESBPROJECT_COMMANDS_NEW_MSG_STORE = "esbproject.commands.new.msgStore";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_TASK_WIZARD = "org.wso2.developerstudio.eclipse.artifact.task.wizard";
	private static final String ESBPROJECT_COMMANDS_SAMPLE_COMMAND = "esbproject.commands.sampleCommand";
	private static final String ESBPROJECT_COMMANDS_NEW_SCHED_TASK = "esbproject.commands.new.schedTask";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_SYNAPSEARTIFACT = "org.wso2.developerstudio.eclipse.artifact.synapseartifact";
	private static final String ESBPROJECT_COMMANDS_NEW_SYNAPSE = "esbproject.commands.new.synapse";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWTEMPLATE = "org.wso2.developerstudio.eclipse.artifact.newtemplate";
	private static final String ESBPROJECT_COMMANDS_NEW_TEMPLATE = "esbproject.commands.new.template";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_SYNAPSE_API_WIZARD = "org.wso2.developerstudio.eclipse.artifact.synapse.api.wizard";
	private static final String ESBPROJECT_COMMANDS_NEW_RST_API = "esbproject.commands.new.rstAPI";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWSEQUENCEARTIFACT = "org.wso2.developerstudio.eclipse.artifact.newsequenceartifact";
	private static final String ESBPROJECT_COMMANDS_NEW_SE_QUENCE = "esbproject.commands.new.seQuence";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWPROXYSERVICE = "org.wso2.developerstudio.eclipse.artifact.newproxyservice";
	private static final String ESBPROJECT_COMMANDS_NEW_PROX_SERVICE = "esbproject.commands.new.proxService";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_MESSAGEPROCESSOR_WIZARD = "org.wso2.developerstudio.eclipse.artifact.messageprocessor.wizard";
	private static final String ESBPROJECT_COMMANDS_NEW_MSG_PROC = "esbproject.commands.new.msgProc";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWMEDIATORARTIFACT = "org.wso2.developerstudio.eclipse.artifact.newmediatorartifact";
	private static final String ESBPROJECT_COMMANDS_NEW_MEDIATOR_PRO = "esbproject.commands.new.mediatorPro";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWENDPOINTARTIFACT = "org.wso2.developerstudio.eclipse.artifact.newendpointartifact";
	private static final String ESBPROJECT_COMMANDS_NEW_END_POINT = "esbproject.commands.new.endPoint";
	private static final String ESBPROJECT_COMMANDS_NEW_LCL_ENTRY = "esbproject.commands.new.lclEntry";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWLOCALENTRY = "org.wso2.developerstudio.eclipse.artifact.newlocalentry";
	private static final String ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_MESSAGESTORE_WIZARD = "org.wso2.developerstudio.eclipse.artifact.messagestore.wizard";

	protected final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * The constructor.
	 */
	public ESBKeyHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (ESBPROJECT_COMMANDS_NEW_MSG_STORE.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_MESSAGESTORE_WIZARD);
		} else if (ESBPROJECT_COMMANDS_NEW_LCL_ENTRY.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWLOCALENTRY);
		} else if (ESBPROJECT_COMMANDS_NEW_END_POINT.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWENDPOINTARTIFACT);
		} else if (ESBPROJECT_COMMANDS_NEW_MEDIATOR_PRO.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWMEDIATORARTIFACT);
		} else if (ESBPROJECT_COMMANDS_NEW_MSG_PROC.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_MESSAGEPROCESSOR_WIZARD);
		} else if (ESBPROJECT_COMMANDS_NEW_PROX_SERVICE.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWPROXYSERVICE);
		} else if (ESBPROJECT_COMMANDS_NEW_SE_QUENCE.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWSEQUENCEARTIFACT);
		} else if (ESBPROJECT_COMMANDS_NEW_RST_API.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_SYNAPSE_API_WIZARD);
		} else if (ESBPROJECT_COMMANDS_NEW_TEMPLATE.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_NEWTEMPLATE);
		} else if (ESBPROJECT_COMMANDS_NEW_SYNAPSE.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_SYNAPSEARTIFACT);
		} else if (ESBPROJECT_COMMANDS_NEW_SCHED_TASK.equals(event.getCommand().getId())) {
			openWizard(ORG_WSO2_DEVELOPERSTUDIO_ECLIPSE_ARTIFACT_TASK_WIZARD);
		} else if (ESBPROJECT_COMMANDS_SAMPLE_COMMAND.equals(event.getCommand().getId())) {
			// EsbMultiPageEditor x;
			IEditorPart editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditors();
			for (int i = 0; i < editorReferences.length; i++) {
				IEditorPart editor = editorReferences[i];
				if (editor instanceof EsbMultiPageEditor) {
					((EsbMultiPageEditor) editor).focusToolbar();
				}
			}
		}
		return null;
	}

	private void openWizard(String id) {
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
		try {
			if (descriptor != null) {
				IWorkbenchWizard wizard = descriptor.createWizard();
				// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection()
				wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
				WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (CoreException e) {
			log.error("Cannot open wizard, core exception", e);
		}
	}
}
