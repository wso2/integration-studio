/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.composite;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.SubToolBarManager;
import org.eclipse.ui.internal.EditorActionBars;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.services.IServiceLocator;

/**
 * IActionBars implementation for the CompositeEditor. This class was
 * created to workaround problems we had when simply using instances of
 * SubActionBars.
 * 
 * 1) The main problem was that global actions contributed by
 * the workbench (copy, cut, paste, etc..) to the edit menu were never
 * enabled for the embedded editors. The summary is that the SubActionBars
 * for the embedded editor did not have any listeners associated to it.
 * The listeners were in the CompositeEditor action bars. These listeners
 * are responsible for updating the enablement of the menu items for global
 * action bars. The workaround is to set the global action handlers from
 * this instance to the CompositeEditor action bars (parent) upon activate
 * calls and remove them upon deactivate calls.
 * 
 * 2) The reason why we subclass EditorActionBars instead of SubActionBars
 * is that some workbench classes assume that if the part is an IEditorPart
 * than its IActionsBars is an EditorActionBars (e.g. EditorSite.getActionBarContributor()).
 */
public class CompositeEditorActionBars extends EditorActionBars {

	protected SubToolBarManager toolBarMgr;

	public CompositeEditorActionBars(WorkbenchPage page, IServiceLocator serviceLocator, String type) {
		super(page, serviceLocator, type);
	}

	/**
	 * We are implementing this method only to avoid a ClassCastException.
	 * This implementation is similar to the one in SubActionBars.
	 */
	@Override
	public IToolBarManager getToolBarManager() {
		if (toolBarMgr == null) {
			// TODO: The code below does not work anymore in Eclipse 3.2M5.
			// We cannot call this API anymore because we get an exception.
			// See WWinActionBars.getToolBarManager()
//			toolBarMgr = createSubToolBarManager(getParent().getToolBarManager());
			toolBarMgr = createSubToolBarManager(null);
			toolBarMgr.setVisible(getActive());
		}
		return toolBarMgr;
	}

	/**
	 * We have to add to the parent (CompositeEditor action bars)
	 * global action handlers contributed to this instance.
	 */
	@Override
	public void activate(boolean forceVisibility) {
		Map globalActionHandlers = getGlobalActionHandlers();
		if (globalActionHandlers != null) {
			for (Iterator iter = globalActionHandlers.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				String actionId = (String) entry.getKey();
				IAction actionHandler = (IAction) entry.getValue();
				getParent().setGlobalActionHandler(actionId, actionHandler);
			}
		}
		super.activate(forceVisibility);
		updateActionBars();
	}

	/**
	 * We have to remove from the parent (CompositeEditor action bars)
	 * global action handlers contributed to this instance.
	 */
	@Override
	public void deactivate(boolean forceVisibility) {
		Map globalActionHandlers = getGlobalActionHandlers();
		if (globalActionHandlers != null) {
			for (Iterator iter = globalActionHandlers.keySet().iterator(); iter.hasNext();) {
				String actionId = (String) iter.next();
				getParent().setGlobalActionHandler(actionId, null);
			}
		}
		super.deactivate(forceVisibility);
		updateActionBars();
	}

	/**
	 * Same implementation as in SubActionBars. The EditorActionBars
	 * implementation simply returns null.
	 */
	@Override
	protected SubToolBarManager createSubToolBarManager(IToolBarManager parent) {
		return new SubToolBarManager(parent);
	}

}