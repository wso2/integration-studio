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

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.tools.SelectionTool;



public class BPELSelectionTool extends SelectionTool {

	public BPELSelectionTool() {
		super();
	}

	/**
	 * The following method is a workaround for a problem between 
	 * the GEF SelectionTool and how AbstractTextEditor is created. The
	 * problem can be reproduced (without this workaround) as follows:
	 * Select an edit part on the canvas that has a property tab with
	 * a Text editor in it (e.g. Receive - Documentation). Select the tab
	 * as well to make sure the editor is created. Now select an edit part
	 * that does not have the same tab (so, no text editor - e.g. a Variable).
	 * Select back the first edit part. Check your log or console for a NPE.
	 * 
	 * What happens underneath is: When you select the edit part (mouse down),
	 * the selection tool handles the MouseDown event activating its drag tracker
	 * and setting its current viewer. That selection causes a selection changed
	 * event to be triggered that ends up setting a new input for the properties view.
	 * The particular tab on the properties view needs a text editor and creates
	 * one. When creating the text editor, AbstractTextEditor (temporarily) sets the
	 * focus to the editor's parent composite. When that happens the edit part
	 * loses focus and the SelectionTool handles the FocusOut event by deactivating
	 * the drag tracker and setting its current viewer to null. When you release
	 * the mouse (mouse up) the selection tool tries to calculate the selection but
	 * it does not have a viewer anymore which causes the NPE.
	 * 
	 * The following workaround tests if we are notifying the properties view for
	 * a selection change and ignores the FocusOut event in that case.
	 */
	@Override
	protected boolean handleFocusLost() {
		if (isSelectionChangeBeingBroadcasted()) return true;
		return super.handleFocusLost();
	}
	protected boolean isSelectionChangeBeingBroadcasted() {
		BPELEditor editor = (BPELEditor) ((DefaultEditDomain)getDomain()).getEditorPart();
		return editor.getAdaptingSelectionProvider().isBroadcastingSelectionChange();
	}
	
	/**
	 * This workaround is similar to the one in handleFocusLost(). In this particular case
	 * there was also a timing issue related to when we received the button up event. 
	 */
	@Override
	protected boolean handleButtonUp(int button) {
		if (isSelectionChangeBeingBroadcasted()) return true;
		return super.handleButtonUp(button);
	}

	/**
	 * This workaround is similar to the one in handleFocusLost(). In this particular case
	 * there was also a timing issue related to when we received the button exit event. 
	 */
	@Override
	protected boolean handleViewerExited() {
		if (isSelectionChangeBeingBroadcasted()) return true;
		return super.handleViewerExited();
	}
}
