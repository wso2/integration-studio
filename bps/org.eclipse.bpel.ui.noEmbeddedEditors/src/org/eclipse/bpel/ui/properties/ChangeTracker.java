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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;


/**
 * Tracks changes on controls and execute commands to report them.
 */
public class ChangeTracker {
	
	protected IOngoingChange fChange;
	protected ICommandFramework fFramework;
	protected boolean fIsTracking;

	/**
	 * Brand new shiny change tracker.
	 * 
	 * @param target
	 * @param change
	 * @param framework
	 */
	public ChangeTracker(Control target, IOngoingChange change, ICommandFramework framework) {
		this(change, framework, target );
	}

	/**
	 * Brand new shiny change tracker.
	 * @param change
	 * @param framework
	 * @param targets
	 */
	
	public ChangeTracker(IOngoingChange change, ICommandFramework framework, Control ... targets ) {
		this.fChange = change;
		this.fFramework = framework;
		fIsTracking = true;
		for (Control c :  targets ) {		
			addListeners(c);
		}
	}

	/**
	 * Start tracking changes.
	 */
	public void startTracking() {
		fIsTracking = true;
	}
	
	/**
	 * Stop tracking changes.
	 */
	
	public void stopTracking() {
		fIsTracking = false;
	}
	
	protected void addListeners(Control target) {
		if (target instanceof Text) {
			trackModify(target);
			trackFocus(target);
			trackEnterKey(target);
		} else if (target instanceof Button) {
			trackSelection(target);
		} else if (target instanceof Composite) {
			trackFocus(target);
			trackSelection(target);
		} else if (target instanceof CCombo) {
			trackFocus(target);
			trackSelection(target);
			trackEnterKey(target);
		} else if (target instanceof Combo) {
			trackFocus(target);
			trackSelection(target);
			trackEnterKey(target);
		}
	}

	protected void trackSelection(Control target) {
		target.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (fIsTracking) {
					fFramework.notifyChangeInProgress(fChange);
					fFramework.notifyChangeDone(fChange);
				}
			}
		});
	}
	
	protected void trackFocus(Control target) {
		target.addListener(SWT.FocusOut, new Listener() {
			public void handleEvent(Event event) {
				if (fIsTracking) {
					fFramework.notifyChangeDone(fChange);
				}
			}
		});
	}
	
	protected void trackEnterKey(Control target) {
		target.addListener(SWT.KeyDown, new Listener() {
			public void handleEvent(Event event) {
				if (fIsTracking && event.keyCode == SWT.CR) {
					fFramework.notifyChangeDone(fChange);
				}
			}
		});
	}

	protected void trackModify(Control target) {
		target.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				if (fIsTracking) {
					fFramework.notifyChangeInProgress(fChange);
				}
			}
		});
	}
}
