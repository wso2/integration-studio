/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;

public class CompoundCommand extends AutoUndoCommand {
	private List<Command> commandList = new ArrayList<Command>();
	
	public CompoundCommand() { 
		super(new ArrayList<Object>());
	}

	public CompoundCommand(String label) {
		super(label, new ArrayList<Object>());
	}
	
	public void add(Command command) {
		if (command != null) {			
			commandList.add(command);
		}
	}
	
	public boolean canExecute() {
		if (commandList.size() == 0)
			return false;
		for (Command cmd : commandList) {
			if (cmd == null)
				return false;
			if (!cmd.canExecute())
				return false;
		}
		return true;
	}
	
	public boolean canDoExecute() {
		if (commandList.size() == 0)
			return false;
		for (Command cmd : commandList) {
			if (cmd == null)
				return false;
			if ((cmd instanceof AutoUndoCommand) && !((AutoUndoCommand)cmd).canDoExecute())
				return false;
		}
		return true;
	}
	
	public void dispose() {
		for (Command cmd : commandList)
			cmd.dispose();
	}
	
	public void doExecute() {
		for (Command cmd : commandList) {
			if (cmd instanceof AutoUndoCommand) {
				((AutoUndoCommand)cmd).doExecute();
			} else {
				cmd.execute();
			}			
		}
	}
	
	public String getLabel() {
		String label = super.getLabel();
		if (label == null)
			if (commandList.isEmpty())
				return null;
		if (label != null)
			return label;
		return commandList.get(0).getLabel();
	}
	
	public boolean isEmpty() {
		return commandList.isEmpty();
	}
	
	public List<Command> getCommands() {
		return commandList;
	}
	
	@Override
	public Set<Object> getModelRoots() {
		HashSet<Object> result = new HashSet<Object>();
		for (Command command : commandList) {
			if (command instanceof AutoUndoCommand) {
				result.addAll(((AutoUndoCommand)command).getModelRoots());
			} else if (command instanceof AbstractEditModelCommand) {				
				for (Resource res : ((AbstractEditModelCommand)command).getResources()) {
					if (res instanceof BPELResource) {
						result.add(((BPELResource)res).getProcess());
					}
				}
			}
		}
		return result;
	}
}
