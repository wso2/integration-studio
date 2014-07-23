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

import java.util.ArrayList;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;


/**
 * command used to set the size and location of a bpel activity for activities
 * that can be placed at a specific xy location
 */
public class SetConstraintCommand extends AutoUndoCommand {

	private Point newPos;
	private Dimension newSize, oldSize;
	private Activity activity;

	/**
	 * Either the location or the size may be optionally be null.
	 */
	public SetConstraintCommand(Activity activity, Point location, Dimension size) {
		super(new ArrayList());
		this.activity = activity;
		this.newPos = location;
		this.newSize = size;
		addModelRoot(activity);
	}

	@Override
	public void doExecute() {
		// TODO: HACK!
		addModelRoot(ModelHelper.getExtension(activity));
		
		if (newSize != null)  oldSize = ModelHelper.getSize(activity);
		if (newPos != null)  ModelHelper.setLocation(activity, newPos);
		if (newSize != null)  ModelHelper.setSize(activity, newSize);
	}

	@Override
	public String getLabel() {
		// bug 327644
		if (newSize == null || newSize.equals(oldSize))
			return IBPELUIConstants.CMD_REPOSITION_NODE;
		return IBPELUIConstants.CMD_RESIZE_NODE;
	}
}
