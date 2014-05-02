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
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.ui.IKeyBindingService;

/**
 * Responsible for contributing key bindings for embedded editors.
 * 
 * TODO: look at the implementation of KeyBindingService
 * We might need to copy and modify that class for our
 * own use.
 */
public class CompositeEditorKeyBindingService implements IKeyBindingService {

	protected IKeyBindingService parent;
	protected SortedMap commandIdToActionMap;

	public CompositeEditorKeyBindingService(IKeyBindingService parent) {
		this.parent = parent;
		commandIdToActionMap = new TreeMap();
	}

	public void activate() {
		for (Iterator iter = commandIdToActionMap.values().iterator(); iter.hasNext();) {
			IAction action = (IAction) iter.next();
			parent.registerAction(action);
		}
	}

	public void deactivate() {
		for (Iterator iter = commandIdToActionMap.values().iterator(); iter.hasNext();) {
			IAction action = (IAction) iter.next();
			parent.unregisterAction(action);
		}
	}

	public void enable(boolean enable) {
	}

	public String getActiveAcceleratorConfigurationId() {
		return null;
	}

	public String getActiveAcceleratorScopeId() {
		return null;
	}

	public boolean processKey(KeyEvent event) {
		return false;
	}

	/**
	 * Registered actions are stored and only enabled when the embedded editor
	 * associated with it becomes active.
	 */
	public void registerAction(IAction action) throws IllegalArgumentException {
		String command = action.getActionDefinitionId();
		if (command != null) {
			commandIdToActionMap.put(command, action);
		}
	}

	public void setActiveAcceleratorScopeId(String scopeId) throws IllegalArgumentException {
	}

	public void unregisterAction(IAction action) throws IllegalArgumentException {
		String command = action.getActionDefinitionId();
		if (command != null) {
			commandIdToActionMap.remove(command);
		}
	}

	public String[] getScopes() {
		return null;
	}

	public void setScopes(String[] scopes) throws IllegalArgumentException {
	}

}
