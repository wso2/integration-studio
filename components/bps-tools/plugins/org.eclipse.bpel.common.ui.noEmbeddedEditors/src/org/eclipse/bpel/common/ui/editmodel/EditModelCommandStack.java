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
package org.eclipse.bpel.common.ui.editmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;



/**
 * Implements the CommandStack API, adds extra notifications,
 * supports validateEdit and update the resource's dirty state.
 * 
 * WDG: TODO: the GEF CommandStack has been extended with extra notifications.
 * However, how are we supposed to use it since everything is still private?
 */
public class EditModelCommandStack extends CommandStack {

	protected int saveLocation = 0;
	protected int fCurrentLocation = 0;
	
	protected Set<Resource> dirtyUntilSave = new HashSet<Resource>();
	
	protected List<Context> fContexts = new ArrayList<Context>(30);
	
	/**
	 * Brand new shiny EditModelCommandStack.
	 */
	public EditModelCommandStack() {
		super();
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#getUndoCommand()
	 */
	@Override
	public Command getUndoCommand() {
		if (fCurrentLocation < 1) {
			return null;
		}
		return fContexts.get(fCurrentLocation-1).fCommand;
	}
	
	/**
	 * @see org.eclipse.gef.commands.CommandStack#canUndo()
	 */
	@Override
	public boolean canUndo() {
		Command c = getUndoCommand();
		return (c != null) && c.canUndo();
	}

	
	/**
	 * @see org.eclipse.gef.commands.CommandStack#getRedoCommand()
	 */
	@Override
	public Command getRedoCommand() {
		if (fCurrentLocation >= fContexts.size()) return null;
		return fContexts.get(fCurrentLocation).fCommand;
	}
	
	/**
	 * @see org.eclipse.gef.commands.CommandStack#canRedo()
	 */
	@Override
	public boolean canRedo() {
		return (getRedoCommand() != null);
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#execute(org.eclipse.gef.commands.Command)
	 */	
	@Override
	public void execute (Command command) {
		SharedCommandStackChangedEvent event = notifyListeners(SharedCommandStackListener.EVENT_START_EXECUTE);
		if (!event.doit) return;

		if(getUndoCommand() instanceof PlaceHolderCommand) {
			// This should never happen because the EditModelCommandFramework should
			// remove the placeholder during the notifyListeners() call above.
			throw new IllegalStateException();
		}
		if (command == null) return;
		if (!validateEdit(command)) return;
		if (!command.canExecute()) return;
		drop(fCurrentLocation, fContexts.size());

		// Paranoia check
		if(getUndoCommand() instanceof PlaceHolderCommand) {
			// This should never happen because the EditModelCommandFramework should
			// remove the placeholder during the notifyListeners() call above.
			throw new IllegalStateException();
		}
		command.execute();
		if(getUndoCommand() instanceof PlaceHolderCommand) {
			// This should never happen because the EditModelCommandFramework should
			// remove the placeholder during the notifyListeners() call above.
			throw new IllegalStateException();
		}
		int limit = getUndoLimit();
		if (limit > 0) while (fCurrentLocation >= limit) {
			if (saveLocation == 0) saveLocation = -1;
			drop(0);
			notifyListeners(SharedCommandStackListener.EVENT_DROP_LAST_UNDO_STACK_ENTRY);
		}
		if(getUndoCommand() instanceof PlaceHolderCommand) {
			// This should never happen because the EditModelCommandFramework should
			// remove the placeholder during the notifyListeners() call above.
			throw new IllegalStateException();
		}
		Resource[] resources = getModifiedResources(command);
		if ((resources.length > 0) || (command instanceof PlaceHolderCommand)) {
			Context c = new Context(command, resources);
			fContexts.add(c); fCurrentLocation = fContexts.size();
			// mark resources as dirty/clean as appropriate.
			c.setModifiedFlags(true);
			//System.out.println("execute - markModified.  currentLocation="+currentLocation+", saveLocation="+saveLocation);
		}
		notifyListeners(SharedCommandStackListener.EVENT_FINISH_EXECUTE);
	}
	/*
	 * call VCM validateEdit;
	 * open the dialog to ask the user if he/she wants to procede
	 * 		in case the file is readonly;
	 * return true if the command should be executed otherwise returns false;
	 */
	protected boolean validateEdit(Command command) {
		Resource[] resources = getResources(command);
		if(resources.length == 0)
			return true;
		boolean disposeShell = false;
		Shell shell;
		IWorkbenchWindow win = CommonUIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow();
		if (win != null) {
			shell = win.getShell();
		} else {
			disposeShell = true;
			shell = new Shell();
		}
		try {
			IFile[] files = new IFile[resources.length];
			StringBuffer filesString = new StringBuffer();
			for (int i = 0; i < resources.length; i++) {
				Resource resource = resources[i];
				files[i] = EditModel.getIFileForURI(resource.getURI());
				filesString.append(files[i].getName());
				if(i < resources.length - 1)
					filesString.append(", "); //$NON-NLS-1$
			}
			IStatus stat = ResourcesPlugin.getWorkspace().validateEdit(files, shell);
			if (stat.getSeverity() == IStatus.CANCEL) {
				return false;
			} else if (!stat.isOK()) {
				String[] buttons = { IDialogConstants.OK_LABEL }; //
				String msg;
				if(files.length == 1)
					msg = NLS.bind(Messages.EditModelCommandStack_validateEdit_message0, (new String[]{filesString.toString(),stat.getMessage()})); 
				else
					msg = NLS.bind(Messages.EditModelCommandStack_validateEdit_message1, (new String[]{filesString.toString(),stat.getMessage()})); 
				MessageDialog dialog = new MessageDialog(
						shell,
						Messages.EditModelCommandStack_validateEdit_title, 
						null, // accept the default windowing system icon
						msg, 
						MessageDialog.WARNING,
						buttons,
						0);
				dialog.open();
				return false;
			}
		} finally {
			if(disposeShell)
				shell.dispose();
		}
		return true;
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#dispose()
	 */
	@Override
	public void dispose() {
		drop(0,fContexts.size());
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#flush()
	 */
	@Override
	public void flush() {
		SharedCommandStackChangedEvent event = notifyListeners(SharedCommandStackListener.EVENT_START_FLUSH);
		if (!event.doit) return;

		drop(0, fContexts.size());
		fContexts.clear();
		saveLocation = -1;
		fCurrentLocation = 0;
		// TODO: should we mark all resources as clean?
		notifyListeners(SharedCommandStackListener.EVENT_FINISH_FLUSH);
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#getCommands()
	 */
	@Override
	public Object[] getCommands() {		
		Object[] commands = new Object[fContexts.size()];
		for (int i = 0; i < fContexts.size(); i++) {
			commands[i] = fContexts.get(i).fCommand;
		}
		return commands;
	}


	/**
	 * @see org.eclipse.gef.commands.CommandStack#isDirty()
	 */
	@Override
	public boolean isDirty() {
		//System.out.println("isDirty: C="+currentLocation+"  S="+saveLocation+"  dus="+dirtyUntilSave.size());
		return (fCurrentLocation != saveLocation) || !dirtyUntilSave.isEmpty();
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#markSaveLocation()
	 */
	@Override
	public void markSaveLocation() {
//		// mark all the resources we know about as clean!
//		for (int i = 0; i<contexts.size(); i++) {
//			Context c = (Context)contexts.get(i);
//			c.setModifiedFlags(false);
//		}
//		// that includes ones that fell off the bottom of the undo stack. 
//		for (Iterator it = dirtyUntilSave.iterator(); it.hasNext(); ) {
//			setResourceModified((Resource)it.next(), false);
//		}
		dirtyUntilSave.clear();

		saveLocation = fCurrentLocation;
		notifyListeners(SharedCommandStackListener.EVENT_MARK_SAVED);
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStack#undo()
	 */
	@Override
	public void undo() {
		SharedCommandStackChangedEvent event = notifyListeners(SharedCommandStackListener.EVENT_START_UNDO);
		if (!event.doit) return;
		
		if (!canUndo()) return;
		Context c = fContexts.get(fCurrentLocation-1);
		c.fCommand.undo();
		fCurrentLocation--;
		// mark resources as dirty/clean as appropriate.
		if (fCurrentLocation < saveLocation) {
			// moving away from save location --> resources can only become dirty
			c.setModifiedFlags(true);
			// System.out.println("undo - markModified.  currentLocation="+currentLocation+", saveLocation="+saveLocation);
		} else {
			// moving towards save location --> resources can only become clean
			updateModifiedFlags();
		}
		
		notifyListeners();
		notifyListeners(SharedCommandStackListener.EVENT_FINISH_UNDO);
	}

	
	/**
	 * @see org.eclipse.gef.commands.CommandStack#redo()
	 */
	@Override
	public void redo() {
		SharedCommandStackChangedEvent event = notifyListeners(SharedCommandStackListener.EVENT_START_REDO);
		if (!event.doit) return;

		if (!canRedo()) return;
		Context c = fContexts.get(fCurrentLocation);
		c.fCommand.redo();
		fCurrentLocation++;
		// mark resources as dirty/clean as appropriate.
		if (fCurrentLocation > saveLocation) {
			// moving away from save location --> resources can only become dirty
			c.setModifiedFlags(true);
			//System.out.println("redo - markModified.  currentLocation="+currentLocation+", saveLocation="+saveLocation);
		} else {
			// moving towards save location --> resources can only become clean
			updateModifiedFlags();
		}

		if(getUndoCommand() instanceof PlaceHolderCommand) {
			// This should never happen
			throw new IllegalStateException();
		}
		notifyListeners();
		notifyListeners(SharedCommandStackListener.EVENT_FINISH_REDO);
	}

	/**
	 * Sends notification to all {@link CommandStackListener}s.
	 */
	protected SharedCommandStackChangedEvent notifyListeners(int property) {
		SharedCommandStackChangedEvent event = new SharedCommandStackChangedEvent(this);
		event.property = property;

		for (Object next : listeners) {
			CommandStackListener csl = (CommandStackListener) next;
			csl.commandStackChanged(event);
		}
		
		return event;
	}

	/*
	 * Helper to remove a command from any point in the stack.
	 */
	protected void drop (int pos) {
		//System.out.println("  (drop "+pos+") C="+currentLocation+" S="+saveLocation);
		if ((pos < 0) || pos >= fContexts.size()) {
			throw new IllegalArgumentException();
		}
		Context c = fContexts.get(pos);
		int a = Math.min(saveLocation, fCurrentLocation);
		int b = Math.max(saveLocation, fCurrentLocation);
		if ((a <= pos) && (pos < b)) {
			// we're dropping something between current and save point.
			dirtyUntilSave.addAll(Arrays.asList(c.fResources));
			//System.out.println("dus = "+dirtyUntilSave);
		}
		c.fCommand.dispose();
		fContexts.remove(pos);
		if (fCurrentLocation > pos) {
			fCurrentLocation--;
		}
		if (saveLocation > pos) {
			saveLocation--;
		}
	}

	/*
	 * Helper to remove a range of commands from anywhere in the stack.
	 */
	protected void drop(int from, int to) {
		if (to < from) { int a=to; to=from; from=a; }
		//System.out.println("drop: "+to+".."+from);
		while (to > from) { drop(from); to--; }
	}
	
	/*
	 * Helper to mark a resource as clean or dirty (mostly for ease of debugging)
	 */
	protected static void setResourceModified(Resource r, boolean modified) {
		if (r.isModified() != modified) {
			//System.out.println("> "+modified+" : "+r);
			r.setModified(modified);
		}
	}
	
	/*
	 * Helper to calculate which resources should be marked as dirty
	 */
	protected void updateModifiedFlags() {
		//System.out.println("calculateModifiedState()");
		
		Set<Resource> cleanResources = new HashSet<Resource>();
		// for starters, treat everything as clean
		for (Context c : fContexts) {
			cleanResources.addAll(Arrays.asList(c.fResources));
		}
		
		// mark things that fell off the bottom of the undo stack as dirty 
		for (Resource resource : dirtyUntilSave) {
			cleanResources.remove(resource);
			setResourceModified(resource, true);
		}
		// mark things modified between saveLocation and currentLocation as dirty
		int a = Math.min(fCurrentLocation, saveLocation);
		int b = Math.max(fCurrentLocation, saveLocation);
		
		for (int i = Math.max(a,0); i<b; i++) {
			Context c = fContexts.get(i);
			cleanResources.removeAll(Arrays.asList(c.fResources));
			c.setModifiedFlags(true);
		}
		// mark anything we still consider clean as clean
		for (Resource resource : cleanResources) {
			setResourceModified(resource, false);
		}
	}
	
	
	/**
	 * SharedCommandStackListener
	 * 
	 */
	public static interface SharedCommandStackListener extends CommandStackListener {
		
		public static final int EVENT_START_EXECUTE = 1;
		public static final int EVENT_FINISH_EXECUTE = 2;
		public static final int EVENT_START_UNDO = 3;
		public static final int EVENT_FINISH_UNDO = 4;
		public static final int EVENT_START_REDO = 5;
		public static final int EVENT_FINISH_REDO = 6;
		public static final int EVENT_START_FLUSH = 7;
		public static final int EVENT_FINISH_FLUSH = 8;
		public static final int EVENT_START_MARK_SAVED = 9;
		public static final int EVENT_FINISH_MARK_SAVED = 10;
		
		public static final int EVENT_DROP_LAST_UNDO_STACK_ENTRY = 11;
		public static final int EVENT_MARK_SAVED = 12;
		
	}

	public static class SharedCommandStackChangedEvent extends EventObject {
		int property;
		public boolean doit = true;
		SharedCommandStackChangedEvent(Object source) {	super(source); }
		public EditModelCommandStack getStack() {
			return (EditModelCommandStack)getSource();
		}
		public int getProperty() { return property; }
	}
	
	protected static Resource[] EMPTY_RESOURCE_ARRAY = new Resource[0];
	
	// TODO: should this be in a utility class?  Can it be made extensible?
	public static Resource[] getResources(Command command) {
		if (command instanceof IEditModelCommand) {
			return ((IEditModelCommand)command).getResources();
		}
		if (command instanceof CompoundCommand) {
			CompoundCommand ccmd = (CompoundCommand) command;
			
			Set<Resource> set = new HashSet<Resource>();			
			for (Object n : ccmd.getChildren() ) {
				for (Resource r : getResources((Command)n)) {
					set.add(r);
				}								
			}
			if (set.isEmpty()) {
				return EMPTY_RESOURCE_ARRAY;
			}
			return set.toArray( EMPTY_RESOURCE_ARRAY );		}
	
		throw new IllegalArgumentException();
	}
	
	// TODO: should this be in a utility class?  Can it be made extensible?
	public static Resource[] getModifiedResources(Command command) {
		
		if (command instanceof IEditModelCommand) {
			return ((IEditModelCommand)command).getModifiedResources();
		}
		if (command instanceof CompoundCommand) {
			CompoundCommand ccmd = (CompoundCommand) command;
			
			Set<Resource> set = new HashSet<Resource>();			
			for (Object n : ccmd.getChildren() ) {
				for (Resource r : getModifiedResources((Command)n)) {
					set.add(r);
				}								
			}
			if (set.isEmpty()) {
				return EMPTY_RESOURCE_ARRAY;
			}
			return set.toArray( EMPTY_RESOURCE_ARRAY );
		}
	
		throw new IllegalArgumentException();
	}

	
	protected static class Context {
		
		public Command fCommand;
		public Resource[] fResources;
		
		public Context(Command command, Resource[] resources) {
			this.fCommand = command; 
			this.fResources = resources;
		}
		public void setModifiedFlags (boolean value) {
			for (Resource r : fResources) {
				setResourceModified(r, value);
			}
		}
		
	}
	
}
