package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.CloudConnectorInitialConfigurationDialog;

public class CloudConnectorNewConfigPropertyDescriptor extends PropertyDescriptor{
	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				CloudConnectorInitialConfigurationDialog cloudConnectorConfigureDialog = new CloudConnectorInitialConfigurationDialog(shell,operation,cloudConnectorConfigurationParameters);
				
				cloudConnectorConfigureDialog.setDroppedCloudConnector(operation.getCloudConnectorName());
				cloudConnectorConfigureDialog.setDroppedCloudConnectorComponentName(getCloudConnectorDirectoryTraverser(operation.getCloudConnectorName()).getCloudConnectorName());
				cloudConnectorConfigureDialog.setBlockOnOpen(true);
				cloudConnectorConfigureDialog.open();
				
				
				return null;
			}
		};
	}
}
