package org.wso2.developerstudio.datamapper.diagram.custom.action;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;

public class RenameFieldAction extends AbstractActionHandler{
	
	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String RENAME_ACTION_ID = "rename-field-action-id"; //$NON-NLS-1$
	private static final String NEW_NAME_ID = "NewName"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.RenameActions_renameField;

	public RenameFieldAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(RENAME_ACTION_ID);
		setText(RENAME_FIELD);
		setToolTipText(RENAME_FIELD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();

		if (null != selectedEP) {
			// Returns the TreeNodeImpl object respective to selectedEP
			EObject object = ((Node) selectedEP.getModel()).getElement();
			// Used to identify the selected resource of the model
			Element selectedElem = (Element) object;
			
			String newName = openRenameDialog();
			if (newName != null && newName != "") {
				selectedElem.setName(newName);
			}
			
			
		//	ChangeCommand changeCommand = new ChangeCommand();
			
			
			
			/*	AddCommand addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(),
					selectedNode, DataMapperPackage.Literals.TREE_NODE__ELEMENT, elementNew, 0);
			if (addCmd.canExecute()) {
				((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
						.execute(addCmd);
			}*/
			// FIXME force refresh root
			String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
			if (null != selectedInputOutputEditPart) {
				if(selectedEP.getParent().getParent().getParent() instanceof InputEditPart){
					InputEditPart iep = (InputEditPart)selectedEP.getParent().getParent().getParent();
					DataMapperRootEditPart rep = (DataMapperRootEditPart)iep.getParent();
					DataMapperRoot rootDiagram = (DataMapperRoot)((DiagramImpl)rep.getModel()).getElement();
					if (INPUT_EDITPART.equals(selectedInputOutputEditPart)) {
						EList<TreeNode> inputTreeNodesList = rootDiagram.getInput().getTreeNode();
						if (null != inputTreeNodesList && !inputTreeNodesList.isEmpty()) {
							// keep a temp reference
							TreeNodeImpl inputTreeNode = (TreeNodeImpl) inputTreeNodesList.get(0);
							// remove and add to rectify placing
							RemoveCommand rootRemCmd = new RemoveCommand(
									((GraphicalEditPart) selectedEP).getEditingDomain(),
									rootDiagram.getInput(),
									DataMapperPackage.Literals.INPUT__TREE_NODE, inputTreeNode);
							if (rootRemCmd.canExecute()) {
								((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
										.execute(rootRemCmd);
							}

							AddCommand rootAddCmd = new AddCommand(
									((GraphicalEditPart) selectedEP).getEditingDomain(),
									rootDiagram.getInput(),
									DataMapperPackage.Literals.INPUT__TREE_NODE, inputTreeNode, 0);
							if (rootAddCmd.canExecute()) {
								((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
										.execute(rootAddCmd);
							}
						}
					} else {
						EList<TreeNode> outputTreeNodesList = rootDiagram.getOutput().getTreeNode();
						if (null != outputTreeNodesList && !outputTreeNodesList.isEmpty()) {
							// keep a temp reference
							TreeNodeImpl outputTreeNode = (TreeNodeImpl) outputTreeNodesList.get(0);
							// remove and add to rectify placing
							RemoveCommand rootRemCmd = new RemoveCommand(
									((GraphicalEditPart) selectedEP).getEditingDomain(),
									rootDiagram.getOutput(),
									DataMapperPackage.Literals.OUTPUT__TREE_NODE, outputTreeNode);
							if (rootRemCmd.canExecute()) {
								((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
										.execute(rootRemCmd);
							}

							AddCommand rootAddCmd = new AddCommand(
									((GraphicalEditPart) selectedEP).getEditingDomain(),
									rootDiagram.getOutput(),
									DataMapperPackage.Literals.OUTPUT__TREE_NODE, outputTreeNode, 0);
							if (rootAddCmd.canExecute()) {
								((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
										.execute(rootAddCmd);
							}

						}
					}

				}
				
			}
		}
		
	}
	

	private String openRenameDialog() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		RenamingDialog renamingDialog = new RenamingDialog(shell);
		renamingDialog.create();
		renamingDialog.open();
		return renamingDialog.getnewName();
		
	}

	private String getSelectedInputOutputEditPart() {
		EditPart tempEP = selectedEP;
		while (!(tempEP instanceof InputEditPart) && !(tempEP instanceof OutputEditPart)) {
			tempEP = tempEP.getParent();
		}

		if (tempEP instanceof InputEditPart) {
			return INPUT_EDITPART;
		} else if (tempEP instanceof OutputEditPart) {
			return OUTPUT_EDITPART;
		} else {
			// When the selected editpart is not InputEditPart or OutputEditPart
			return null;
		}
	}

	private EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}
		// In case of selecting the wrong editpart
		return null;
	}

	@Override
	public void refresh() {
		// refresh action. Does not do anything
	}

}
