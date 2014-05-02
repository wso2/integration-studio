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

import org.eclipse.swt.widgets.Button;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */

@SuppressWarnings("nls")
public class RadioButtonIValue implements IValue {
	
	/**
	 * The value key used to lookup the assigned value of
	 * a radio button via getData() on the widget.
	 */
	static public final String VALUE = "value";
	
	/** Unset object value, equivalent to null */
	static public final Object UNSET_VALUE = new Object();
	
	Button[] fWidgets;

	/**
	 * @param args
	 */
	public RadioButtonIValue ( Button ... args ) {
		fWidgets = args;
	}

	/**
	 * @see org.eclipse.bpel.common.ui.details.IValue#get()
	 */
	@SuppressWarnings("boxing")
	public Object get() {
		for(Button n : fWidgets) {
			if (n.getSelection()) {
				Object value = n.getData(VALUE);
				return value == UNSET_VALUE ? null : value;				
			}
		}
		return null;
	}

	/** 
	 * @see org.eclipse.bpel.common.ui.details.IValue#set(java.lang.Object)
	 */
	@SuppressWarnings({ "nls", "boxing" })
	public void set ( Object object ) {
		for (Button n : fWidgets) {
			Object v = n.getData(VALUE);			
			n.setSelection( v.equals(object) || (v == UNSET_VALUE && object == null) );
		}		
	}
	
	
}
