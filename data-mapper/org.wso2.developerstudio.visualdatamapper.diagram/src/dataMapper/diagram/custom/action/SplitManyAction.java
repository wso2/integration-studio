package dataMapper.diagram.custom.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import dataMapper.Split;
import dataMapper.diagram.custom.util.ConfigureSplitOperatorDialog;

public class SplitManyAction extends AbstractActionHandler {

	CompoundCommand resultCommand;

	/**
	 * Creates a new {@link ConfigureSwitchMediatorAction} instance.
	 * 
	 * @param part a {@link IWorkbenchPart} instance.
	 */
	public SplitManyAction(IWorkbenchPart part) {
		super(part);
		setId(Messages.Configure_Split_Operator_Action_Id);
		setText(Messages.Add_Remove_Split_Branches);
		setToolTipText(Messages.Configure_Split_Operator);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}
	

	/**
	 * {@inheritDoc}
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		

		Display display = Display.getDefault();
		Shell shell = new Shell(display);		
		Dialog configureConcat = new ConfigureSplitOperatorDialog(shell, (Split) selectedObj, getEditingDomain(), selectedEP);
		configureConcat.setBlockOnOpen(true);
		configureConcat.open();
		
	}


	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	protected EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}

		return null; /* In case of selecting the wrong editpart */
	}
	
	/**
	 * Utility method for calculating the editing domain.
	 * 
	 * @return editing domain for this action.
	 */
	protected TransactionalEditingDomain getEditingDomain() {        
        // try adapting the workbench part
        IWorkbenchPart part = getWorkbenchPart();

        if (part != null) {
            IEditingDomainProvider edProvider = (IEditingDomainProvider) part
                .getAdapter(IEditingDomainProvider.class);

            if (edProvider != null) {
            	EditingDomain domain = edProvider.getEditingDomain();
            	
            	if (domain instanceof TransactionalEditingDomain) {
            		return (TransactionalEditingDomain) domain;
            	}
            }
        }
        
        return null;
    }


}
