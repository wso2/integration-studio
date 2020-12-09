/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;


public class AutoArrangeFlowsAction extends SelectionAction {

	public final static String ACTION_ID = "AutoArrangeFlowsAction"; //$NON-NLS-1$

	public AutoArrangeFlowsAction(IWorkbenchPart part) {
		super(part);
		setId(ACTION_ID);
		setText(Messages.AutoArrangeFlowsAction_Arrange_Flow_Contents_2); 
		setToolTipText(Messages.AutoArrangeFlowsAction_Auto_arrange_flow_contents_3); 
	}

	protected boolean isFreeform(FlowEditPart flowEditPart) {
		return (flowEditPart.getContentPane().getLayoutManager() instanceof XYLayout);
	}

	boolean hasTargetFlows(List selectedObjects) {
		boolean foundFlow = false;
		for (Iterator it = selectedObjects.iterator(); it.hasNext(); ) {
			Object object = it.next();
			if (object instanceof FlowEditPart) {
				foundFlow = true;
				if (isFreeform((FlowEditPart)object))  return true;
			}
		}
		if (!foundFlow) {
			// There are no flows selected.  Instead, return any FlowEditParts which are
			// parents of a selected object and are freeform.
			for (Iterator it = selectedObjects.iterator(); it.hasNext(); ) {
				Object object = it.next();
				if (object instanceof EditPart) {
					object = ((EditPart)object).getParent();
					if (object instanceof FlowEditPart) {
						foundFlow = true;
						if (isFreeform((FlowEditPart)object))  return true;
					}
				}
			}
		}
		return false;
	}

	List getTargetFlows(List selectedObjects) {
		// Return all FlowEditParts which are selected and freeform.
		boolean foundFlow = false;
		List result = new ArrayList();
		for (Iterator it = selectedObjects.iterator(); it.hasNext(); ) {
			Object object = it.next();
			if (object instanceof FlowEditPart) {
				foundFlow = true;
				if (isFreeform((FlowEditPart)object))  result.add(object);
			}
		}
		if (!foundFlow) {
			// There are no flows selected.  Instead, return any FlowEditParts which are
			// parents of a selected object and are freeform.
			for (Iterator it = selectedObjects.iterator(); it.hasNext(); ) {
				Object object = it.next();
				if (object instanceof EditPart) {
					object = ((EditPart)object).getParent();
					if (object instanceof FlowEditPart) {
						foundFlow = true;
						if (isFreeform((FlowEditPart)object))  result.add(object);
					}
				}
			}
		}
		if (result.isEmpty())  return Collections.EMPTY_LIST;

		BPELUtil.sortFlowList(result);

		return result;
	}

	@Override
	public void run() {
		List flowsList = getTargetFlows(getSelectedObjects());
		for (Iterator it = flowsList.iterator(); it.hasNext(); ) {
			((FlowEditPart)it.next()).doAutoLayout();
		}
	}

	@Override
	protected boolean calculateEnabled() {
		List sel = getSelectedObjects();
		return sel.size() > 0 && 
				hasTargetFlows(sel) && 
				!ModelHelper.getBPELEditor(((EditPart)sel.get(0)).getModel()).getAutoFlowLayout();
	}

	@Override
	public boolean isChecked() {
		// TODO: make auto-arrange sticky in the future?  (would need other support)
		return false;
	}
}
