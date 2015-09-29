package org.wso2.developerstudio.eclipse.general.project.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.ui.wizard.GeneralProjectWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class GeneralProjectUtils {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static IProject createGeneralProject(Shell shell,File location){
		IWizardDescriptor wizardDesc = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard("org.wso2.developerstudio.eclipse.general.project");
		if (wizardDesc!=null) {
			try {
				IProject newProject= null; 
				GeneralProjectWizard basicProjectWizard = (GeneralProjectWizard) wizardDesc.createWizard();
				IStructuredSelection selection = (IStructuredSelection) PlatformUI
						.getWorkbench().getActiveWorkbenchWindow()
						.getSelectionService().getSelection();				
				basicProjectWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, basicProjectWizard);
				ProjectDataModel regModel = basicProjectWizard.getModel();
				regModel.setLocation(location);
				dialog.create();
				if(dialog.open() ==Dialog.OK){
					String projectName = basicProjectWizard.getModel().getProjectName();					
					newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				}
				return newProject;
			} catch (CoreException e) {
				log.error("CoreException has occurred", e);
			}
		}
		return null;
	}
	
	public static String getFilenameWOExtension(String filename){
		String fileNameWOExt=null;
		if(FilenameUtils.indexOfExtension(filename)==-1){
			fileNameWOExt=filename;
		}else{
			fileNameWOExt=FilenameUtils.removeExtension(filename);
		}
		return fileNameWOExt;
	}
	
	public static String getFilenameExtension(String filename){
		String fileNameExt="";
		if(FilenameUtils.indexOfExtension(filename) != -1){
			fileNameExt=FilenameUtils.getExtension(filename);
		}
		return fileNameExt;
	}
}
