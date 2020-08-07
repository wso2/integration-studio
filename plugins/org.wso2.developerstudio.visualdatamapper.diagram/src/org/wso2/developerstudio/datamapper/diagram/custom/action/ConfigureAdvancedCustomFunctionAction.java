package org.wso2.developerstudio.datamapper.diagram.custom.action;

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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.AdvancedCustomFunction;
import org.wso2.developerstudio.datamapper.diagram.custom.dialogs.ConfigureAdvancedCustomFunctionOperatorDialog;
//import org.wso2.developerstudio.datamapper.CustomFunction;
//import org.wso2.developerstudio.datamapper.diagram.custom.dialogs.ConfigureCustomFunctionOperatorDialog;

public class ConfigureAdvancedCustomFunctionAction extends AbstractActionHandler {

	CompoundCommand resultCommand;

	/**
	 * Creates a new {@link ConfigureSwitchMediatorAction} instance.
	 * 
	 * @param part
	 *            a {@link IWorkbenchPart} instance.
	 */
	public ConfigureAdvancedCustomFunctionAction(IWorkbenchPart part) {
		super(part);
		setId("configure-custom-function-action");
		setText("Configure Custom Function Properties");
		setToolTipText("Configure Custom Function Operator");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Dialog configureCustomFunction = new ConfigureAdvancedCustomFunctionOperatorDialog(Display.getDefault().getActiveShell(),
				(AdvancedCustomFunction) selectedObj, getEditingDomain(),selectedEP);
		configureCustomFunction.setBlockOnOpen(true);
		configureCustomFunction.open();
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
			IEditingDomainProvider edProvider = (IEditingDomainProvider) part.getAdapter(IEditingDomainProvider.class);

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
