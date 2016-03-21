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
package org.eclipse.bpel.ui.palette;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.SelectionToolEntry;

/**
 * See comments in BPELSelectionTool.handleFocusLost().
 */
public class BPELSelectionToolEntry extends SelectionToolEntry {

	public BPELSelectionToolEntry() {
		super();
	}

	public BPELSelectionToolEntry(String label) {
		super(label);
	}

	public BPELSelectionToolEntry(String label, String shortDesc) {
		super(label, shortDesc);
	}

	@Override
	public Tool createTool() {
		return new BPELSelectionTool();
	}
}
