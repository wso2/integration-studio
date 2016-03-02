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
	private static final String NEW_MSG_STORE_COMMAND = "esbproject.commands.new.msgStore";
	private static final String ARTIFACT_TASK_WIZARD = "org.wso2.developerstudio.eclipse.artifact.task.wizard";
	private static final String SAMPLE_COMMAND = "esbproject.commands.sampleCommand";
	private static final String NEW_SCHED_TASK_COMMAND = "esbproject.commands.new.schedTask";
	private static final String ARTIFACT_SYNAPSEARTIFACT = "org.wso2.developerstudio.eclipse.artifact.synapseartifact";
	private static final String NEW_SYNAPSE_COMMAND = "esbproject.commands.new.synapse";
	private static final String ARTIFACT_NEWTEMPLATE = "org.wso2.developerstudio.eclipse.artifact.newtemplate";
	private static final String NEW_TEMPLATE_COMMAND = "esbproject.commands.new.template";
	private static final String SYNAPSE_API_WIZARD = "org.wso2.developerstudio.eclipse.artifact.synapse.api.wizard";
	private static final String NEW_RST_API_COMMAND = "esbproject.commands.new.rstAPI";
	private static final String NEW_SEQUENCE_ARTIFACT = "org.wso2.developerstudio.eclipse.artifact.newsequenceartifact";
	private static final String NEW_SE_QUENCE_COMMAND = "esbproject.commands.new.seQuence";
	private static final String NEW_PROXY_SERVICE = "org.wso2.developerstudio.eclipse.artifact.newproxyservice";
	private static final String NEW_PROX_SERVICE_COMMAND = "esbproject.commands.new.proxService";
	private static final String MESSAGE_PROCESSOR_WIZARD = "org.wso2.developerstudio.eclipse.artifact.messageprocessor.wizard";
	private static final String NEW_MSG_PROC_COMMAND = "esbproject.commands.new.msgProc";
	private static final String NEW_MEDIATOR_ARTIFACT = "org.wso2.developerstudio.eclipse.artifact.newmediatorartifact";
	private static final String NEW_MEDIATOR_PRO_COMMAND = "esbproject.commands.new.mediatorPro";
	private static final String NEW_ENDPOINT_ARTIFACT = "org.wso2.developerstudio.eclipse.artifact.newendpointartifact";
	private static final String NEW_END_POINT_COMMAND = "esbproject.commands.new.endPoint";
	private static final String NEW_LCL_ENTRY_COMMAND = "esbproject.commands.new.lclEntry";
	private static final String NEW_LOCAL_ENTRY = "org.wso2.developerstudio.eclipse.artifact.newlocalentry";
	private static final String MESSAGE_STORE_WIZARD = "org.wso2.developerstudio.eclipse.artifact.messagestore.wizard";

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
		if (NEW_MSG_STORE_COMMAND.equals(event.getCommand().getId())) {
			openWizard(MESSAGE_STORE_WIZARD);
		} else if (NEW_LCL_ENTRY_COMMAND.equals(event.getCommand().getId())) {
			openWizard(NEW_LOCAL_ENTRY);
		} else if (NEW_END_POINT_COMMAND.equals(event.getCommand().getId())) {
			openWizard(NEW_ENDPOINT_ARTIFACT);
		} else if (NEW_MEDIATOR_PRO_COMMAND.equals(event.getCommand().getId())) {
			openWizard(NEW_MEDIATOR_ARTIFACT);
		} else if (NEW_MSG_PROC_COMMAND.equals(event.getCommand().getId())) {
			openWizard(MESSAGE_PROCESSOR_WIZARD);
		} else if (NEW_PROX_SERVICE_COMMAND.equals(event.getCommand().getId())) {
			openWizard(NEW_PROXY_SERVICE);
		} else if (NEW_SE_QUENCE_COMMAND.equals(event.getCommand().getId())) {
			openWizard(NEW_SEQUENCE_ARTIFACT);
		} else if (NEW_RST_API_COMMAND.equals(event.getCommand().getId())) {
			openWizard(SYNAPSE_API_WIZARD);
		} else if (NEW_TEMPLATE_COMMAND.equals(event.getCommand().getId())) {
			openWizard(ARTIFACT_NEWTEMPLATE);
		} else if (NEW_SYNAPSE_COMMAND.equals(event.getCommand().getId())) {
			openWizard(ARTIFACT_SYNAPSEARTIFACT);
		} else if (NEW_SCHED_TASK_COMMAND.equals(event.getCommand().getId())) {
			openWizard(ARTIFACT_TASK_WIZARD);
		} else if (SAMPLE_COMMAND.equals(event.getCommand().getId())) {
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
