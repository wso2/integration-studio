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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;


/**
 * Retargets a link from one activity to another.
 */
public class MoveTargetCommand extends AutoUndoCommand {
	
	protected Activity fromActivity = null;
	protected Activity toActivity = null;
	protected Target target = null;

	public MoveTargetCommand(Activity fromActivity, Activity toActivity, Target target) {
		super(fromActivity);
		this.fromActivity = fromActivity;
		this.toActivity = toActivity;
		this.target = target;
	}

	@Override
	public boolean canDoExecute() {
		return super.canDoExecute() && (fromActivity != null) && (toActivity != null) && (target != null);
	}

	@Override
	public void doExecute() {
		super.execute();
		Targets targets = toActivity.getTargets();
		if (targets == null) {
			targets = BPELFactory.eINSTANCE.createTargets();
			toActivity.setTargets(targets);
		}
		targets.getChildren().add(target);
	}
}
