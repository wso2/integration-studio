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
package org.eclipse.bpel.common.ui.details;

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * An abstract IOngoingChange that is also a Listener.  ChangeHelper notifies the
 * details area of IOngoingChange lifecycle events on behalf of the widget(s) it
 * listens to.
 */
public abstract class ChangeHelper implements IOngoingChange, Listener {

	protected ICommandFramework fCommandFramework;
	protected int fNonUserChange = 0;
	
	/**
	 * Marks the start of a programmatic change to the widget contents.  Clients must
	 * call startNonUserChange() before directly setting the widget contents to avoid
	 * unwanted IOngoingChange lifecycle events.  (Only some widgets/viewers will send the
	 * unwanted notifications, but all clients should use this pattern anyway).
	 * Currently, changes may not be nested.
	 * 
	 */
	
	public void startNonUserChange()  {
		fNonUserChange += 1;
	}
	
	/**
	 * Clients who call startNonUserChange() should call finishNonUserChange() as soon
	 * as possible after the change is done.
	 * 
	 * @throws IllegalArgumentException if no change is in progress.
	 */
	@SuppressWarnings("nls")
	public void finishNonUserChange()  {
		if (fNonUserChange == 0) {
			throw new IllegalStateException("Non-matching call to finishNonUserChange()") ;
		}
		fNonUserChange -= 1;		
	}

	/** 
	 * @return true if a programmatic change is in progress.
	 */
	public boolean isNonUserChange() {
		return fNonUserChange > 0;
	}
	
	/**
	 * 
	 * @param commandFramework
	 */
	public ChangeHelper (ICommandFramework commandFramework) {
		fCommandFramework = commandFramework;
	}
	
	
	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if (isNonUserChange()) {
			return ;
		}
		
		switch (event.type) {
		case SWT.KeyDown:
			if (event.character == SWT.CR) {
				finish();
			}
			break;
		case SWT.FocusOut:
			finish(); 
			break;
		case SWT.Modify:
		case SWT.Selection:
		case SWT.DefaultSelection:
			modify(); 
			break;
		case SWT.Dispose :
			abort();
			break;
		}
	}
	
	/**
	 * 
	 */
	void finish() {		
		fCommandFramework.notifyChangeDone(this);
	}
	
	/**
	 * 
	 */
	void modify() {		
		fCommandFramework.notifyChangeInProgress(this);
	}
	
	void abort () {
		fCommandFramework.abortCurrentChange();
	}
	
	protected boolean isModifyBasedControl(Control c) {
		if (c instanceof CCombo) {
			return (c.getStyle() & SWT.READ_ONLY) == 0; // if not read only
		}
		return (c instanceof Text);
	}

	protected boolean isSelectionBasedControl(Control c) {
		return !(c instanceof Text);
	}

	/**
	 * Registers this ChangeHelper with the given control to listen for events
	 * which indicate that a change is in progress (or done).
	 * 
	 * @param controls 
	 */
	
	public void startListeningTo (Control ... controls ) {
		
		for (Control control : controls) {
			
			control.addListener(SWT.FocusOut, this);
			control.addListener(SWT.Dispose, this);
			if (isModifyBasedControl(control)) {
				control.addListener(SWT.Modify, this);
			}
			if (isSelectionBasedControl(control)) {
				control.addListener(SWT.Selection, this);
				control.addListener(SWT.DefaultSelection, this);
			}
		}
	}
	
	/**
	 * Registers this ChangeHelper with the given control to listen for the
	 * Enter key.  When Enter is pressed, the change is considered done (this
	 * is appropriate for single-line Text widgets).
	 * @param controls 
	 */
	public void startListeningForEnter (Control ... controls) {
		// NOTE: KeyDown rather than KeyUp, because of similar usage in CCombo.
		for(Control control : controls) {
			control.addListener(SWT.KeyDown, this);
		}
	}
	
	/**
	 * Unregisters this ChangeHelper from a control previously passed to
	 * startListeningTo() and/or startListeningForEnter().
	 * @param controls 
	 */
	public void stopListeningTo (Control ...controls ) {
		for(Control control : controls) {
			
			control.removeListener(SWT.FocusOut, this);
			if (isModifyBasedControl(control)) {
				control.removeListener(SWT.Modify, this);
			}
			if (isSelectionBasedControl(control)) {
				control.removeListener(SWT.Selection, this);
				control.removeListener(SWT.DefaultSelection, this);
			}
			control.removeListener(SWT.KeyDown, this);
			
		}
		
	}
}