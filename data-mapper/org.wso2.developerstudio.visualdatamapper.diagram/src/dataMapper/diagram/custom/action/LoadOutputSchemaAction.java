package dataMapper.diagram.custom.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import dataMapper.Output;
import dataMapper.diagram.edit.parts.OutputEditPart;

public class LoadOutputSchemaAction extends AbstractActionHandler{

	public LoadOutputSchemaAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
		
		setId("configure-output-schema-action-id");
		setText("Load output schema from file");
		setToolTipText("Load output schema from file.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof Output, "Invalid selection.");
		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);		
		FileDialog fid = new FileDialog(shell);
		fid.setFilterExtensions(new String [] {"*.avsc", "*.txt"});
		fid.setText("Output Schema File");
		String filePath = fid.open();
		
		if (!filePath.isEmpty()) {
			OutputEditPart iep = (OutputEditPart)selectedEP;
			iep.resetOutputTreeFromFile(filePath); 
		}
	}
	
	protected EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}
		return null;
	}

}
