package org.wso2.developerstudio.eclipse.ds.command;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;

public class DesignViewActionHandler extends AbstractHandler {

	private EObject referenceObject;
	private EditingDomain editingDomain;
	private ISelection currentSelection;

	public void delete(DsEditor editor) {

		EStructuralFeature feature = null;
		Object value = null;
		EObject parent = null;

		editingDomain = editor.getEditingDomain();

		if (editor.getActivePage() == DsEditor.getDesignViewIndex()) {

			currentSelection = editor.getMdPage().getOutLineBlock().getCurrentSelection();

			if (currentSelection instanceof IStructuredSelection &&
			    ((IStructuredSelection) currentSelection).size() == 1) {

				referenceObject =
				                  (EObject) ((IStructuredSelection) currentSelection).getFirstElement();

				if (referenceObject != null && referenceObject instanceof DataService) {

					DataService dataService = (DataService) referenceObject;
					MessageDialog.openError(Display.getCurrent().getActiveShell(),
					                        "Can not complete this action!", "You Can not delete " +
					                                                         dataService.getName() +
					                                                         " service!");
					return;
				}
				value = referenceObject;
				feature = referenceObject.eContainingFeature();
				parent = (EObject) editingDomain.getParent(referenceObject);

			} else {

				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Occuerd",
				                        "Can not delete this component");
				return;
			}

			if (editingDomain != null && parent != null && feature != null && value != null) {
				RemoveCommand removeCommand =
				                              new RemoveCommand(editingDomain, parent, feature,
				                                                value);
				if (removeCommand.canExecute()) {
					editingDomain.getCommandStack().execute(removeCommand);
				}

				else {
					Collection<EObject> collection = new ArrayList<EObject>();
					collection.add((EObject) value);
					DeleteCommand deleteCommand = new DeleteCommand(editingDomain, collection);
					if (deleteCommand.canExecute()) {
						editingDomain.getCommandStack().execute(deleteCommand);
					}
				}

			}

		}

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorpart =
		                         HandlerUtil.getActiveWorkbenchWindow(event).getActivePage()
		                                    .getActiveEditor();
		if (editorpart != null && editorpart instanceof DsEditor) {
			DsEditor dseditor =
			                    (DsEditor) HandlerUtil.getActiveWorkbenchWindow(event)
			                                          .getActivePage().getActiveEditor();
			delete(dseditor);
		}
		return null;
	}

}
