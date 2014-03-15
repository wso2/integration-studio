package dataMapper.diagram.custom.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import dataMapper.diagram.edit.parts.InputEditPart;
import dataMapper.impl.InputImpl;


public class LoadInputSchemaAction extends AbstractActionHandler {

	/**
	 * Creates a new {@link LoadInputSchemaAction} instance.
	 * 
	 * @param part a {@link IWorkbenchPart} instance.
	 */
	public LoadInputSchemaAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
		
		setId("configure-input-schema-action-id");
		setText("Load input schema from file");
		setToolTipText("Load input schema from file.");
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
		Assert.isTrue(selectedObj instanceof InputImpl, "Invalid selection.");
		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);		
		FileDialog fid = new FileDialog(shell);
		fid.setFilterExtensions(new String [] {"*.avsc", "*.txt"});
		fid.setText("Input Schema File");
		String filePath = fid.open();
		
		if (!filePath.isEmpty()) {
			InputEditPart iep = (InputEditPart)selectedEP;
			iep.resetInputTreeFromFile(filePath); 
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
