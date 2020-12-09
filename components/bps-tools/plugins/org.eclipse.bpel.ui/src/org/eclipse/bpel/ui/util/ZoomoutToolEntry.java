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
package org.eclipse.bpel.ui.util;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.gef.SharedImages;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;


public class ZoomoutToolEntry extends ToolEntry {

	public ZoomoutToolEntry() {
		this(Messages.ZoomoutToolEntry_Zoom_out_1); 
	}

	public ZoomoutToolEntry(String label) {
		this(label, null);
	}

	public ZoomoutToolEntry(String label, String shortDesc) {
		super(
			label,
			shortDesc,
			SharedImages.DESC_SELECTION_TOOL_16, // these aren't the ones we want but leave them as placeholders
			SharedImages.DESC_SELECTION_TOOL_24);
		setUserModificationPermission(PERMISSION_NO_MODIFICATION);
	}

	@Override
	public Tool createTool() {
		return new ZoomoutTool();
	}
}
