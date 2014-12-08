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
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ESBKeyHandler extends AbstractHandler {
	protected final IDeveloperStudioLog log= Logger.getLog(Activator.PLUGIN_ID);
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
		if 	   (event.getCommand().getId().equals("esbproject.commands.new.msgStore")) {
			openWizard("org.wso2.developerstudio.eclipse.artifact.messagestore.wizard");
	   }else if(event.getCommand().getId().equals("esbproject.commands.new.lclEntry")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.newlocalentry");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.endPoint")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.newendpointartifact");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.mediatorPro")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.newmediatorartifact");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.msgProc")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.messageprocessor.wizard");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.proxService")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.newproxyservice");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.seQuence")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.newsequenceartifact");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.rstAPI")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.synapse.api.wizard");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.template")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.newtemplate");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.synapse")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.synapseartifact");
		}else if(event.getCommand().getId().equals("esbproject.commands.new.schedTask")){
			openWizard("org.wso2.developerstudio.eclipse.artifact.task.wizard");
		}else if(event.getCommand().getId().equals("esbproject.commands.sampleCommand")) {
		//EsbMultiPageEditor x;
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
			if (null != descriptor) {
				IWorkbenchWizard wizard = descriptor.createWizard();
				// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection()
				wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
				WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (CoreException e) {
			log.error("Cannot open wizard, core exception",e);
		}
	}
}
