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
package org.eclipse.bpel.ui.commands;

import java.util.HashSet;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Condition;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;


/**
 * Replaces a child activity within its container with a new child actiivty.  Tries to keep any common information
 * between the old and the new child.
 */
public class ReplaceInContainerCommand extends AutoUndoCommand {

	//Parent container of the activity to be replaced
	IContainer container;

	// These two flags record the command's state from the caller's point of view.
	// TODO: do we still need these?  follow example provided by DeleteChildCommand 
	protected boolean isExecuted, isUndone;

	private Object parent;
	private Activity oldActivity, newActivity;

	// TODO: these should be typed for activities.
	public ReplaceInContainerCommand(Object parent, Object oldElement, Object newElement) {
		super(Messages.ReplaceInContainerCommand_Replace_1, (EObject)parent); 
		
		//The container of the objects
		this.parent = parent;
		container = BPELUtil.adapt(parent, IContainer.class);
		
		this.oldActivity = (Activity)oldElement;
		this.newActivity = (Activity)newElement;
	}

	// TODO: is there any special reason we catch and ignore these exceptions?
	// if so it should have comments explaining why 
	private void copyAttributes() {

		try {
			newActivity.setName(oldActivity.getName());		
		} catch (NullPointerException e) {
			BPELUIPlugin.log(e);
			// do nothing??
		}
		
		if (oldActivity.isSetSuppressJoinFailure()) {
			newActivity.setSuppressJoinFailure(oldActivity.getSuppressJoinFailure());
		}
		
		newActivity.setDocumentationElement(oldActivity.getDocumentationElement());
		newActivity.setEnclosingDefinition(oldActivity.getEnclosingDefinition());
		
		try {
			ModelHelper.setCreateInstance(newActivity, ModelHelper.getCreateInstance(oldActivity));
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	@Override
	public void doExecute() {
		if (!canExecute()) throw new IllegalStateException();
		isExecuted = true;

		// copy all common information from old element to the new
		copyAttributes();

		// Move any links from old to new
		Sources s = oldActivity.getSources();
		if (s != null) {
			Source[] sources = s.getChildren().toArray(new Source[0]);
			for (int i = 0; i < sources.length; i++) {
				sources[i].setActivity(newActivity);
			}
		}
		Targets t = oldActivity.getTargets();
		if (t != null) {
			Target[] targets = t.getChildren().toArray(new Target[0]);
			for (int i = 0; i < targets.length; i++) {
				targets[i].setActivity(newActivity);
			}
			Condition joinCondition = t.getJoinCondition();
			if (joinCondition != null) {
			    // There is already a targets in the destination,
			    // otherwise we wouldn't be in here.
			    newActivity.getTargets().setJoinCondition(joinCondition);
			}
		}

		//replace the old activity with the new activity
		container.replaceChild(parent, oldActivity, newActivity);
				
		//Copy relevant extension information to the new element
		if (ModelHelper.getExtension(oldActivity) != null) {
			ModelHelper.setLocation(newActivity, ModelHelper.getLocation(oldActivity));
			ModelHelper.setSize(newActivity, ModelHelper.getSize(oldActivity));
		}

		// Figure out which model objects are being deleted.
		HashSet deletingSet = new HashSet();
		ModelHelper.addSubtreeToCollection(oldActivity, deletingSet);
	}
}
