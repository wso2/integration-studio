/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.details;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */
@SuppressWarnings("nls")
public class FocusContext implements IValue , Listener {
	
	/** The widget name */
	public static final String NAME = "name";

	Control [] fControls;
	
	Control fFocussed;
	
	/**
	 * @param args
	 */
	public FocusContext ( Control ... args ) {
		
		fControls = args;
		
		for(Control control : fControls) {
			control.addListener(SWT.FocusIn, this);
		}
	}
	
	
	
	/**
	 * @see org.eclipse.bpel.common.ui.details.IValue#get()
	 */
	@SuppressWarnings("boxing")
	public Object get () {
		if (fFocussed == null) {
			return null;
		}
		return fFocussed.getData(NAME);
	}
	
	/**
	 * @param obj
	 */
	
	public void set ( Object obj ) {
		for (Control c : fControls) {
			Object name = c.getData(NAME);
			if (name == null || name.equals(obj) == false) {
				continue;
			}
			c.setFocus();
			return ;
		}
	}



	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent (Event event) {
		if (event.widget instanceof Control) {
			fFocussed = (Control) event.widget;
		} else {
			fFocussed = null;
		}
	}
	
}
