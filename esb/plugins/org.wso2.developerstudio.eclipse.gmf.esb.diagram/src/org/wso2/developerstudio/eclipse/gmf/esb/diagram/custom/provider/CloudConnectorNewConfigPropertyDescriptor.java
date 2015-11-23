package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.CloudConnectorInitialConfigurationDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CloudConnectorNewConfigPropertyDescriptor extends PropertyDescriptor{
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID); 
	
	public CloudConnectorNewConfigPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
	
	private CloudConnectorDirectoryTraverser getCloudConnectorDirectoryTraverser(String droppedCloudConnector){
		IEditorPart editorpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		IFileEditorInput input = (IFileEditorInput) editorpart.getEditorInput();
		IFile file = input.getFile();
		IProject activeProject = file.getProject();
		//String connectorPath = activeProject.getLocation().toOSString() + File.separator
		//		+ "cloudConnectors" + File.separator + droppedCloudConnector+"-connector";
		String connectorPath = CloudConnectorDirectoryTraverser.getInstance()
				.getConnectorDirectoryPathFromConnectorName(
						activeProject.getWorkspace().getRoot().getLocation().toOSString(),
						droppedCloudConnector);
		return CloudConnectorDirectoryTraverser.getInstance(connectorPath);
	}
	
   
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			
			protected Object openDialogBox(Control cellEditorWindow) {
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				CloudConnectorOperation operation = null;
				if(object instanceof CloudConnectorOperation){
					operation = (CloudConnectorOperation)object;
				}
			
/*				CallTemplateParamDialog callTemplateParamDialog = new CallTemplateParamDialog(shell,
						mediator,TransactionUtil.getEditingDomain(mediator));
				callTemplateParamDialog.setBlockOnOpen(true);
				callTemplateParamDialog.open();*/
				
				
				Collection<String> cloudConnectorConfigurationParameters = null;
				try {
					cloudConnectorConfigurationParameters = getCloudConnectorDirectoryTraverser(operation.getCloudConnectorName()).getCloudConnectorConfigurationParameters();
				} catch (Exception e) {
					log.error("Error while reading parameters", e);
				}
				
				if (cloudConnectorConfigurationParameters != null && cloudConnectorConfigurationParameters.size() > 0) {
					CloudConnectorInitialConfigurationDialog cloudConnectorConfigureDialog = new CloudConnectorInitialConfigurationDialog(shell,operation,cloudConnectorConfigurationParameters);
					cloudConnectorConfigureDialog.setDroppedCloudConnector(operation.getCloudConnectorName());
					cloudConnectorConfigureDialog.setDroppedCloudConnectorComponentName(getCloudConnectorDirectoryTraverser(operation.getCloudConnectorName()).getCloudConnectorName());
					cloudConnectorConfigureDialog.setBlockOnOpen(true);
					cloudConnectorConfigureDialog.open();
				} else {
					String errorMsg = "Standard 'init' configuration not found for this connector. You may add it manually as a local entry and select it from available configs";
					showInformationMessage(errorMsg);
				}
				
				return null;
			}
		};
	}
	
	
	private void showInformationMessage(String errorMsg) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Information", errorMsg);
	}
}
