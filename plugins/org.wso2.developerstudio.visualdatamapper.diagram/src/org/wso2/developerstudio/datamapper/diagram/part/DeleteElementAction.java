package org.wso2.developerstudio.datamapper.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.tooling.runtime.actions.DefaultDeleteElementAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @generated
 */
public class DeleteElementAction extends DefaultDeleteElementAction {

	/**
	 * @generated
	 */
	public DeleteElementAction(IWorkbenchPart part) {
		super(part);
	}

	public void init() {
		super.init();
		setId(ActionIds.ACTION_DELETE_FROM_MODEL);
		setText(DiagramUIMessages.DiagramEditor_Delete_from_Model);
		setToolTipText(DiagramUIMessages.DiagramEditor_Delete_from_ModelToolTip);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	}

	/*
	 * We have overridden this method in this class because we need to add all the
	 * child editparts into the OperationSet once we select a root editpart. For
	 * an example when we select and remove one operation(Concat operation) from 
	 * the diagram all the child elements should be selected and removed. 
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createOperationSet()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List createOperationSet() {
		List list = super.createOperationSet();
		ArrayList tempList = new ArrayList(list);
		Iterator iterator = tempList.iterator();
		while (iterator.hasNext()) {
			EditPart parent = (EditPart) iterator.next();
			addChildren(list, parent);
		}
		return list;
	}

	/*
	 * Recursive method for adding children to the list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addChildren(List list, EditPart parent) {
		List children = parent.getChildren();
		Iterator iterator = children.iterator();
		while (iterator.hasNext()) {
			EditPart child = (EditPart) iterator.next();
			addChildren(list, child);
			list.add(child);
		}
	}
}
